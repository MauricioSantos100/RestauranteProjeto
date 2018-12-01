package model.dao;

import java.util.List;

import model.Entidades.Usuario;

public interface UsuarioDao {
	public List<Usuario> listarTodos();
	public Usuario buscarPorIdUsuario(Integer id);
}
