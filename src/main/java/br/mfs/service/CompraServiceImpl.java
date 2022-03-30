package br.mfs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mfs.model.Compra;
import br.mfs.repository.CompraRepository;

@Service
public class CompraServiceImpl implements CompraService{

	@Autowired
	private CompraRepository compraRepository;
	
	@Override
	public void create(Compra compra) {
		this.compraRepository.save(compra);
	}

	@Override
	public void remove(int id) {
		this.compraRepository.deleteById(id);
	}

	@Override
	public Compra getById(int id) {

		Optional<Compra> optional = compraRepository.findById(id);
		Compra compra = null;
		
		if(optional.isPresent())
			compra = optional.get();
		else
			throw new RuntimeException("Compra não encontrada!");
		
		return compra;
	}

	@Override
	public List<Compra> getAll() {
		return this.compraRepository.findAll();
	}

}
