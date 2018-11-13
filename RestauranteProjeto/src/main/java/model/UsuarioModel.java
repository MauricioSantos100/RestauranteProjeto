package model;

import model.Entidades.Pessoa;
import model.Entidades.Usuario;
import model.dao.UsuarioDao;
import model.dao.UsuarioDaoImpl;

public class UsuarioModel {
	private UsuarioDaoImpl dao = new UsuarioDaoImpl();

	public void registraUsuario(Usuario u) {
		dao.insert(u);
	}
	public void atualizaUsuario(Usuario u) {
		dao.update(u);
	}

	public void removeCliente(Usuario u) {
		dao.remove(u);
	}

	private boolean existe(Usuario u) {
		boolean existe = false;
		if (((UsuarioDao) dao).buscaIdUsuario(u.getId()) != null) {
			existe = true;
		}
		return existe;
	}
	/*
	 * public List<Cliente> listarClientes() { return dao.listando(); }
	 * 
	 * public List<Cliente> filtrarClientes() { return dao.listando(); } public
	 * List<Cliente> listarNomeCliente() { return dao.listarNome(); }
	 */

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
}
