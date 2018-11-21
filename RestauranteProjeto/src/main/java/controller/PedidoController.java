package controller;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import controller.util.FacesUtil;
import model.PedidoModel;
import model.Entidades.Pedido;
import model.Exception.JaExisteException;
import model.Exception.NullException;
import model.Exception.StringException;
import model.dao.PedidoDaoImpl;

@ManagedBean(name = "pedidoController")
@ApplicationScoped
public class PedidoController {
	private Pedido pedido;
	private List<Pedido> listaPedido;
	private List<Pedido> listaPedidoFiltrado;
	private PedidoDaoImpl pedidoDaoImpl = new PedidoDaoImpl();
	PedidoModel pm = new PedidoModel();
	
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public PedidoController() {
		this.pedido = new Pedido();
	}
	public List<Pedido> getListaPedido() {
		listaPedido = pedidoDaoImpl.listando();
		return listaPedido;
	}
	public void setListaPedido(List<Pedido> listaPedido) {
		this.listaPedido = listaPedido;
	}
	public List<Pedido> getListaPedidoFiltrado() {
		listaPedidoFiltrado = pedidoDaoImpl.listando();
		return listaPedidoFiltrado;
	}
	public void setListaPedidoFiltrado(List<Pedido> listaPedidoFiltrado) {
		this.listaPedidoFiltrado = listaPedidoFiltrado;
	}
	

	public void carregarPesquisa(Pedido p) {
		try {
			listaPedido = pedidoDaoImpl.listando();
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao listar pedidos" + ex.getMessage());
		}
	}

	public void salvar(Pedido p) {
		try {
			pm.registraPedido(p);
			FacesUtil.adicionarMsgInfo("Pedido Salvo com Sucesso.");
		} catch (JaExisteException ee) {
			FacesUtil.adicionarMsgErro(ee.getMessage());
		} catch (NullException ne) {
			FacesUtil.adicionarMsgErro(ne.getMessage());
		} catch (StringException se) {
			FacesUtil.adicionarMsgErro(se.getMessage());
		}
		
	}

	public void excluir(Pedido p) {
		pm.removePedido(p);
		FacesUtil.adicionarMsgInfo("Pedido excluido.");
	}

	public String editar(Pedido p) {
		try {
			pm.atualizaPedido(p);
			FacesUtil.adicionarMsgInfo("Pedido alterado.");
		} catch (NullException ne) {
			FacesUtil.adicionarMsgErro(ne.getMessage());
		} catch (StringException se) {
			FacesUtil.adicionarMsgErro(se.getMessage());
		}
		return "";
	}
	
	public String Pedido()
	  {
	    return "Pedido";
	  }
}
