package br.mfs.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.mfs.model.Produto;
import br.mfs.model.Usuario;
import br.mfs.service.ProdutoService;
import br.mfs.service.UsuarioService;

import javax.annotation.PostConstruct;

@Component
public class CarregaData {

    private boolean podeCarregarDados;

    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private UsuarioService usuarioService;

    @PostConstruct
    public void loadData() {

    	produtoService.create(new Produto("Bolacha", 5.99, "Bauduco"));
    	produtoService.create(new Produto("Panetone", 19.90, "Bauduco"));
    	produtoService.create(new Produto("Pasta de Dente", 3.50, "Colgate"));
    	produtoService.create(new Produto("Pasta de Dente", 3.40, "Oral-G"));
    	produtoService.create(new Produto("Filé de Frango", 22.90, "Seara"));
    	
    	usuarioService.create(new Usuario("Mateus Fonseca Santos", "452.759.456-58", "mfs", "1234", "(18)99654-7456", "Rua Dois"));
    	usuarioService.create(new Usuario("Victor Costa", "447.587.258-69", "vic", "1234", "(18)99785-2569", "Rua da Esquina"));
    }
}
