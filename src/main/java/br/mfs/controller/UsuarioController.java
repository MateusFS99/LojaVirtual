package br.mfs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.mfs.model.Usuario;
import br.mfs.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/novoUsuario")
	public String novoUsuario(Model model) {
		
		Usuario usuario = new Usuario();
		
		model.addAttribute("usuario", usuario);
		
		return "";
	}
	
	@PostMapping("/saveUsuario")
	public String saveUsuario(@ModelAttribute("usuario") Usuario usuario) {
		
		usuarioService.create(usuario);
		
		return "";
	}
	
	@GetMapping("/deleteUsuario/{id}")
	public String deleteUsuario(@PathVariable (value = "id") int id) {
		
		this.usuarioService.remove(id);
		
		return "";
	}
	
	@GetMapping("/updateUsuario/{id}")
	public String updateUsuario(@PathVariable (value = "id") int id, Model model) {
		
		return "";
	}
}
