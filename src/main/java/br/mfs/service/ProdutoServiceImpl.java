package br.mfs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mfs.model.Produto;
import br.mfs.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Override
	public void create(Produto produto) {
		this.produtoRepository.save(produto);
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

	@Override
	public List<Produto> getAll() {
		return this.produtoRepository.findAll();
	}

}
