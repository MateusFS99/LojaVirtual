package br.mfs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mfs.model.Produto;
import br.mfs.repository.ProdutoRepository;
import lombok.Getter;
import lombok.Setter;

@Named(value = "produtoMB")
@ViewScoped
@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Getter
    @Setter
    private List<Produto> produtos = new ArrayList<>();

    @Getter
    @Setter
    private Produto produto;
    
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Override
	public void create(Produto produto) {
		
		this.produto = produto;
		this.produtoRepository.save(this.produto);
	}

	@Override
	public void remove(int id) {
		this.produtoRepository.deleteById(id);
	}

	@Override
	public Produto getById(int id) {

		Optional<Produto> optional = produtoRepository.findById(id);
		Produto produto = null;
		
		if(optional.isPresent())
			produto = optional.get();
		else
			throw new RuntimeException("Produto não encontrado!");
		
		return produto;
	}

	@PostConstruct
	@Override
	public List<Produto> getAll() {
		
		produtos = this.produtoRepository.findAll();
    	
        return produtos;
	}
}
