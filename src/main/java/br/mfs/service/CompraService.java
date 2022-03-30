package br.mfs.service;

import java.util.List;

import br.mfs.model.Compra;

public interface CompraService {

	void create(Compra compra);
	void remove(int id);
	Compra getById(int id);
	List<Compra> getAll();
}
