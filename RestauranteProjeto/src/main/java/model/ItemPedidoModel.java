package model;

import java.util.List;

import model.Entidades.ItemPedido;
import model.Exception.JaExisteException;
import model.Exception.NullException;
import model.dao.ItemPedidoDao;
import model.dao.ItemPedidoDaoImpl;

public class ItemPedidoModel {

	private ItemPedidoDaoImpl dao = new ItemPedidoDaoImpl();

	public void registraItemPedido(ItemPedido ip) throws JaExisteException, NullException {
		if (ip != null) {
			if (!this.existe(ip)) {
				dao.insert(ip);
			} else {
				throw new JaExisteException("Este item pedido já existe");
			}
		} else {
			throw new NullException("Nenhum item pode estar vazio");
		}
	}

	public void atualizaItemPedido(ItemPedido ip) throws NullException {
		if (((ItemPedidoDao) dao).buscarPorCodItemPedido(ip.getCodItemPedido()) != null) {
			dao.update(ip);
		} else {
			throw new NullException("Nenhum item pode estar vazio");
		}
	}

	public void removeItemPedido(ItemPedido ip) {
		dao.remove(ip);
	}

	private boolean existe(ItemPedido ip) {
		boolean valida = false;
		if (((ItemPedidoDao) dao).buscarPorCodItemPedido(ip.getCodItemPedido()) != null) {
			valida = true;
		}
		return valida;
	}
	
	public List<ItemPedido> listarTodos() {
		return dao.listarTodos();
	}

	public ItemPedido buscarPorNome(String nome) {
		return dao.buscarPorNome(nome);
	}
}
