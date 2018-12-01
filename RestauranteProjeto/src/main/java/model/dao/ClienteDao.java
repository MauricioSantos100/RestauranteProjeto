package model.dao;

import java.util.List;

import model.Entidades.Cliente;

public interface ClienteDao {
	public List<Cliente> ListarTodos();
	public Cliente buscarPorNome(String nome);
	public Cliente buscarPorCpf(String cpf);

}
