package br.mfs.service;

import java.util.List;

import br.mfs.model.Produto;

public interface ProdutoService {

	void create(Produto produto);
	void remove(int id);
	Produto getById(int id);
	List<Produto> getAll();
}
