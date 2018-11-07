package model.dao;

import model.Entidades.Funcionario;

public interface FuncionarioDao {
	
	public Funcionario buscaCpfFuncionario(String cpf);
}
