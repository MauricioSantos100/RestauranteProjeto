package controller;

import java.util.List;

import controler.util.FacesUtil;
import model.ItemPedidoModel;
import model.Entidades.ItemPedido;
import model.Exception.JaExisteException;
import model.Exception.NullException;
import model.dao.ItemPedidoDaoImpl;

public class ItemPedidoController {
	private ItemPedido itemPedido;
	private List<ItemPedido> listaItemPedido;
	private List<ItemPedido> listaItemPedidoFiltrado;
	private ItemPedidoDaoImpl itemPedidoDaoImpl = new ItemPedidoDaoImpl();
	ItemPedidoModel ipm = new ItemPedidoModel();
	
	public ItemPedido getItemPedido() {
		return itemPedido;
	}
	public void setItemPedido(ItemPedido itemPedido) {
		this.itemPedido = itemPedido;
	}
	public List<ItemPedido> getListaItemPedido() {
		listaItemPedido = itemPedidoDaoImpl.listando();
		return listaItemPedido;
	}
	public void setListaItemPedido(List<ItemPedido> listaItemPedido) {
		this.listaItemPedido = listaItemPedido;
	}
	public List<ItemPedido> getListaItemPedidoFiltrado() {
		listaItemPedidoFiltrado = itemPedidoDaoImpl.listando();
		return listaItemPedidoFiltrado;
	}
	public void setListaItemPedidoFiltrado(List<ItemPedido> listaItemPedidoFiltrado) {
		this.listaItemPedidoFiltrado = listaItemPedidoFiltrado;
	}
	

	public void carregarPesquisa(ItemPedido ip) {
		try {
			listaItemPedido = itemPedidoDaoImpl.listando();
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao listar Item pedidos" + ex.getMessage());
		}
	}

	public void salvar(ItemPedido ip) {
		try {
			ipm.registraItemPedido(ip);
			FacesUtil.adicionarMsgInfo("Item pedido Salvo com Sucesso.");
		} catch (JaExisteException ee) {
			FacesUtil.adicionarMsgErro(ee.getMessage());
		} catch (NullException ne) {
			FacesUtil.adicionarMsgErro(ne.getMessage());
		}
	}

	public void excluir(ItemPedido ip) {
		ipm.removeItemPedido(ip);
		FacesUtil.adicionarMsgInfo("Item pedido excluido.");
	}

	public String editar(ItemPedido ip) {
		try {
			ipm.atualizaItemPedido(ip);
			FacesUtil.adicionarMsgInfo("Item pedido alterado.");
		} catch (NullException ne) {
			FacesUtil.adicionarMsgErro(ne.getMessage());
		}
		return "";
	}		
}
