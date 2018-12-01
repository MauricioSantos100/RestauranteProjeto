package model;

import java.util.List;

import model.Entidades.Pessoa;
import model.Entidades.Usuario;
import model.dao.UsuarioDao;
import model.dao.UsuarioDaoImpl;

public class UsuarioModel {
	private UsuarioDaoImpl dao = new UsuarioDaoImpl();

	public void registraUsuario(Usuario u) {
		if (u != null) {
			if (!this.existe(u)) {
				dao.insert(u);
			}
		}
	}

	public void atualizaUsuario(Usuario u) {
		dao.update(u);
	}

	public void removeCliente(Usuario u) {
		dao.remove(u);
	}

	private boolean existe(Usuario u) {
		boolean existe = false;
		if (((UsuarioDao) dao).buscarPorIdUsuario(u.getId()) != null) {
			existe = true;
		}
		return existe;
	}

	public Usuario autenticar(String login, String senha) {
		if (login == null || senha == null) {
			return null;
		}
		return UsuarioDaoImpl.autenticar(login, senha);
	}

	public Usuario tipo(String tipo, Pessoa pessoa) {
		if (tipo == null) {
			return null;
		}
		return UsuarioDaoImpl.tipo(tipo, pessoa);
	}
	
	public List<Usuario> listarTodos() {
		return dao.listarTodos();	}
}
