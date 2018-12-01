package model.dao;

import java.util.List;

import model.Entidades.Funcionario;

public interface FuncionarioDao {
	public List<Funcionario> listarTodos();
	public Funcionario buscarPorCpf(String cpf);
	public Funcionario buscarPorNome(String nome);
}
