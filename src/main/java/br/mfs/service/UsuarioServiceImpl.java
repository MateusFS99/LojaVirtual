package br.mfs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mfs.model.Usuario;
import br.mfs.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public void create(Usuario usuario) {
		this.usuarioRepository.save(usuario);
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
		return this.usuarioRepository.findAll();
	}

}
