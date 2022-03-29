package br.mfs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.mfs.model.ItemCompra;


@Repository
public interface ItemCompraRepository extends JpaRepository<ItemCompra, Integer> {

}
