package br.mfs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.mfs.model.Produto;
import br.mfs.service.ProdutoService;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping("/novoProduto")
	public String novoProduto(Model model) {
		
		Produto produto = new Produto();
		
		model.addAttribute("produto", produto);
		
		return "";
	}
	
	@PostMapping("/saveProduto")
	public String saveProduto(@ModelAttribute("produto") Produto produto) {
		
		produtoService.create(produto);
		
		return "";
	}
	
	@GetMapping("/deleteProduto/{id}")
	public String deleteProduto(@PathVariable (value = "id") int id) {
		
		this.produtoService.remove(id);
		
		return "";
	}
	
	@GetMapping("/updateProduto/{id}")
	public String updateProduto(@PathVariable (value = "id") int id, Model model) {
		
		return "";
	}
}
