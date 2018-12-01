package model.dao;

import java.util.List;

import model.Entidades.Produto;

public interface ProdutoDao {
	public List<Produto> listarTodos();
	public Produto buscarPorNome(String nome);
}
