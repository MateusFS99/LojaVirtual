package br.mfs.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.mfs.model.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer> {

}
