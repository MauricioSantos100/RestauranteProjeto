package model.dao;

import java.util.List;

import model.Entidades.Cardapio;

public interface CardapioDao {
	public List<Cardapio> listarTodos();
	public Cardapio buscarPorCategoria(String categoria);

}
