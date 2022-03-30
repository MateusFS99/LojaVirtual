package br.mfs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mfs.model.ItemCompra;
import br.mfs.repository.ItemCompraRepository;

@Service
public class ItemCompraServiceImpl implements ItemCompraService {

	@Autowired
	private ItemCompraRepository itemCompraRepository;
	
	@Override
	public void create(ItemCompra item) {
		this.itemCompraRepository.save(item);
	}

	@Override
	public void remove(int id) {
		this.itemCompraRepository.deleteById(id);
	}

	@Override
	public ItemCompra getById(int id) {
		
		Optional<ItemCompra> optional = itemCompraRepository.findById(id);
		ItemCompra item = null;
		
		if(optional.isPresent())
			item = optional.get();
		else
			throw new RuntimeException("Item não encontrado!");
		
		return item;
	}

	@Override
	public List<ItemCompra> getAll() {
		return this.itemCompraRepository.findAll();
	}
}
