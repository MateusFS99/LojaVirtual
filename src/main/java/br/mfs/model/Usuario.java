package br.mfs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "usuario_nome")
	private String nome;
	
	@Column(name = "usuario_cpf")
	private String cpf;
	
	@Column(name = "usuario_login")
	private String login;
	
	@Column(name = "usuario_senha")
	private String senha;
	
	@Column(name = "usuario_telefone")
	private String telefone;
	
	@Column(name = "usuario_endereco")
	private String endereco;
}
