package br.mfs.beans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import br.mfs.model.Produto;
import br.mfs.service.ProdutoService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named(value = "produtoMB")
@ViewScoped
public class ProdutoMB {

    @Getter
    @Setter
    private List<Produto> produtos = new ArrayList<>();

    @Getter
    @Setter
    private Produto produto;

    @Autowired
    private ProdutoService produtoService;

    @PostConstruct
    public List<Produto> listarTodos() {
    	
    	produtos = produtoService.getAll();
        return produtos;
    }

    public Integer getTamanhoDaLista() {
    	
        return produtos.size();
    }

    public void setTamanhoDaLista(Integer size) {
    	
        // Método criado para ser utilizado pelo primefaces
    }
}
