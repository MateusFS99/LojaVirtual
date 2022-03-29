package br.mfs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ItemCompra")
public class ItemCompra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "itemcompra_qtde")
	private int qtde;
	
	@OneToMany
	@JoinColumn
	private Produto produto;
	
	@OneToMany
	@JoinColumn
	private Compra compra;
}
