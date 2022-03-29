package br.mfs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Compra")
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "compra_data")
	private String data;
	
	@Column(name = "compra_valor")
	private Double valor;
	
	@Column(name = "compra_formapg")
	private String formaPg;
	
	@ManyToOne
	@JoinColumn
	private Usuario usuario;
}
