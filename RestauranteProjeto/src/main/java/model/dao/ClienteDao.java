package model.dao;

import model.Entidades.Cliente;

public interface ClienteDao {
	public Cliente buscaCpfCliente(String cpf);

}
