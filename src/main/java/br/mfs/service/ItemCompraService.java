package br.mfs.service;

import java.util.List;

import br.mfs.model.ItemCompra;

public interface ItemCompraService {

	void create(ItemCompra item);
	void remove(int id);
	ItemCompra getById(int id);
	List<ItemCompra> getAll();
}
