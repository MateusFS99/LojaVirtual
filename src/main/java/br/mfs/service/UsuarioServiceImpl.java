package br.mfs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mfs.model.Usuario;
import br.mfs.repository.UsuarioRepository;
import lombok.Getter;
import lombok.Setter;

@Named(value = "usuarioMB")
@ViewScoped
@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Getter
    @Setter
    private List<Usuario> usuarios = new ArrayList<>();

    @Getter
    @Setter
    private Usuario usuario;
    
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public void create(Usuario usuario) {
		
		this.usuario = usuario;
		this.usuarioRepository.save(this.usuario);
	}

	@Override
	public void remove(int id) {
		this.usuarioRepository.deleteById(id);
	}

	@Override
	public Usuario getById(int id) {
		
		Optional<Usuario> optional = usuarioRepository.findById(id);
		Usuario usuario = null;
		
		if(optional.isPresent())
			usuario = optional.get();
		else
			throw new RuntimeException("Usuario não encontrado!");
		
		return usuario;
	}

	@Override
	public List<Usuario> getAll() {
		
		usuarios = this.usuarioRepository.findAll();
    	
        return usuarios;
	}
	
	public String login(String login, String senha) {
		
		Optional<Usuario> optional = usuarioRepository.findByLogin(login);
		
		usuario = null;
		if(optional.isPresent()) {

			usuario = optional.get();
			System.out.println(usuario.getNome());
		}
		else
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
					"Usuário não Encontrado!", "Erro no Login!"));
		if(usuario != null) {
			
			if(usuario.getSenha().equals(senha))
				return "/produtos.js";
			else
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
						"Senha Incorreta!", "Erro no Login!"));
		}
		return "";
	} 

}
