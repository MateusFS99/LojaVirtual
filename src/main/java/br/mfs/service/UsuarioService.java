package br.mfs.service;

import java.util.List;

import br.mfs.model.Usuario;

public interface UsuarioService {

	void create(Usuario usuario);
	void remove(int id);
	Usuario getById(int id);
	List<Usuario> getAll();
}
