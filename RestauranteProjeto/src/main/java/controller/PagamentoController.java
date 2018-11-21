package controller;

import java.util.List;

import controller.util.FacesUtil;
import model.PagamentoModel;
import model.Entidades.Pagamento;
import model.Exception.DateException;
import model.Exception.JaExisteException;
import model.Exception.NullException;
import model.dao.PagamentoDaoImpl;

public class PagamentoController {
	private Pagamento pagamento;
	private List<Pagamento> listaPagamento;
	private List<Pagamento> listaPagamentoFiltrado;
	private PagamentoDaoImpl pagamentoDaoImpl = new PagamentoDaoImpl();
	PagamentoModel pm = new PagamentoModel();
	
	public Pagamento getPagamento() {
		return pagamento;
	}
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	public List<Pagamento> getListaPagamento() {
		listaPagamento = pagamentoDaoImpl.listando();
		return listaPagamento;
	}
	public void setListaPagamento(List<Pagamento> listaPagamento) {
		this.listaPagamento = listaPagamento;
	}
	public List<Pagamento> getListaPagamentoFiltrado() {
		listaPagamentoFiltrado = pagamentoDaoImpl.listando();
		return listaPagamentoFiltrado;
	}
	public void setListaPagamentoFiltrado(List<Pagamento> listaPagamentoFiltrado) {
		this.listaPagamentoFiltrado = listaPagamentoFiltrado;
	}
	
	public void carregarPesquisa(Pagamento p) {
		try {
			listaPagamento = pagamentoDaoImpl.listando();
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao listar pagamentos" + ex.getMessage());
		}
	}

	public void salvar(Pagamento p) {
		try {
			pm.registraPagamento(p);
			FacesUtil.adicionarMsgInfo("Pagamento Salvo com Sucesso.");
		} catch (JaExisteException ee) {
			FacesUtil.adicionarMsgErro(ee.getMessage());
		} catch (NullException ne) {
			FacesUtil.adicionarMsgErro(ne.getMessage());
		} catch (DateException de) {
			FacesUtil.adicionarMsgErro(de.getMessage());
		} 
		
	}

	public void excluir(Pagamento p) {
		pm.deletaPagamento(p);
		FacesUtil.adicionarMsgInfo("Pagamento excluido.");
	}

	public String editar(Pagamento p) {
		try {
			pm.atualizaPagamento(p);
			FacesUtil.adicionarMsgInfo("Pagamento alterado.");
		} catch (NullException ne) {
			FacesUtil.adicionarMsgErro(ne.getMessage());
		}
		return "";
	}	
}
