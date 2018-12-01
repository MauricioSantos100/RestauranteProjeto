package model.dao;

import java.util.List;

import model.Entidades.ItemPedido;

public interface ItemPedidoDao {
	public List<ItemPedido> listarTodos();
	public ItemPedido buscarPorCodItemPedido(Integer codItem);
	public ItemPedido buscarPorNome(String nome);
}
