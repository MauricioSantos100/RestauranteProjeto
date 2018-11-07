package model;

import java.util.List;

import model.Entidades.Pedido;
import model.Exception.JaExisteException;
import model.Exception.NullException;
import model.Exception.StringException;
import model.dao.PedidoDao;
import model.dao.PedidoDaoImpl;
import model.util.Validacoes;

public class PedidoModel {

	private PedidoDaoImpl dao = new PedidoDaoImpl();

	public void registraPedido(Pedido p) throws JaExisteException, StringException, NullException {
		if (p != null) {
			if (!this.existe(p)) {
				if (Validacoes.verificaString(p.getStatus())) {
					dao.insert(p);
				} else {
					throw new StringException("Status inválido");
				}
			} else {
				throw new JaExisteException("Este Pedido já existe");
			}
		} else {
			throw new NullException("Nenhum item pode estar vazio");
		}
	}

	public void atualizaPedido(Pedido p) throws NullException, StringException {
		if (((PedidoDao) dao).buscaCodPedido(p.getCodPedido()) != null) {
			if (Validacoes.verificaString(p.getStatus())) {
				dao.update(p);
			} else {
				throw new StringException("Status inválido");
			}
		} else {
			throw new NullException("Nenhum item pode estar vazio");
		}
	}

	public void removePedido(Pedido p) {
		dao.remove(p);
	}

	private boolean existe(Pedido p) {
		boolean valida = false;
		if (((PedidoDao) dao).buscaCodPedido(p.getCodPedido()) != null) {
			valida = true;
		}
		return valida;
	}
	
	public List<Pedido> listarPedidos() {
		return dao.listando();
	}

	public List<Pedido> filtrarPedidos() {
		return dao.listando();
	}
}
