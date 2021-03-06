package br.mfs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Produto")
public class Produto {

	public Produto(String nome, Double preco, String marca) {
		
		this.nome = nome;
		this.preco = preco;
		this.marca = marca;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "produto_nome")
	private String nome;
	
	@Column(name = "produto_preco")
	private Double preco;
	
	@Column(name = "produto_marca")
	private String marca;
}
