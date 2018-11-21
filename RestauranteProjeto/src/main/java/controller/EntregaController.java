package controller;

import java.util.List;

import controller.util.FacesUtil;
import model.EntregaModel;
import model.Entidades.Entrega;
import model.Exception.EnderecoException;
import model.Exception.JaExisteException;
import model.Exception.NullException;
import model.dao.EntregaDaoImpl;

public class EntregaController {
	private Entrega conta;
	private List<Entrega> listaEntrega;
	private List<Entrega> listaEntregaFiltrado;
	private EntregaDaoImpl entregaDaoImpl = new EntregaDaoImpl();
	EntregaModel em = new EntregaModel();
	
	public Entrega getConta() {
		return conta;
	}
	public void setConta(Entrega conta) {
		this.conta = conta;
	}
	public List<Entrega> getListaEntrega() {
		listaEntrega = entregaDaoImpl.listando();
		return listaEntrega;
	}
	public void setListaEntrega(List<Entrega> listaEntrega) {
		this.listaEntrega = listaEntrega;
	}
	public List<Entrega> getListaEntregaFiltrado() {
		listaEntregaFiltrado = entregaDaoImpl.listando();
		return listaEntregaFiltrado;
	}
	public void setListaEntregaFiltrado(List<Entrega> listaEntregaFiltrado) {
		this.listaEntregaFiltrado = listaEntregaFiltrado;
	}
	

	public void carregarPesquisa(Entrega e) {
		try {
			EntregaDaoImpl entregadaoimpl = new EntregaDaoImpl();
			listaEntrega = entregadaoimpl.listando();
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao listar entregas" + ex.getMessage());
		}
	}

	public void salvar(Entrega e) {
		try {
			em.registraEndereco(e);
			FacesUtil.adicionarMsgInfo("Entrega Salva com Sucesso.");
		} catch (JaExisteException ee) {
			FacesUtil.adicionarMsgErro(ee.getMessage());
		} catch (NullException ne) {
			FacesUtil.adicionarMsgErro(ne.getMessage());
		} catch (EnderecoException ene) {
			FacesUtil.adicionarMsgErro(ene.getMessage());
		}
	}

	public void excluir(Entrega e) {
		em.removeEntrega(e);
		FacesUtil.adicionarMsgInfo("Entrega excluida.");
	}

	public String editar(Entrega e) {
		try {
			em.atualizaEntrega(e);
			FacesUtil.adicionarMsgInfo("Entrega alterada.");
		} catch (EnderecoException ene) {
			FacesUtil.adicionarMsgErro(ene.getMessage());
		} catch (NullException ne) {
			FacesUtil.adicionarMsgErro(ne.getMessage());
		}

		return "";
	}	
}
