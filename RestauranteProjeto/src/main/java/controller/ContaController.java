package controller;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import controler.util.FacesUtil;
import model.ContaModel;
import model.Entidades.Conta;
import model.Exception.JaExisteException;
import model.Exception.NullException;
import model.Exception.StringException;
import model.Exception.ValorException;
import model.dao.ContaDaoImpl;

@ApplicationScoped
@ManagedBean(name = "contaController")
public class ContaController {
	private Conta conta;
	private List<Conta> listaConta;
	private List<Conta> listaContaFiltrado;
	private ContaDaoImpl contaDaoImpl = new ContaDaoImpl();
	ContaModel cm = new ContaModel();

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public List<Conta> getListaConta() {
		listaConta = contaDaoImpl.listando();
		return listaConta;
	}

	public void setListaConta(List<Conta> listaConta) {
		this.listaConta = listaConta;
	}

	public List<Conta> getListaContaFiltrado() {
		listaContaFiltrado = contaDaoImpl.listando();
		return listaContaFiltrado;
	}

	public void setListaContaFiltrado(List<Conta> listaContaFiltrado) {
		this.listaContaFiltrado = listaContaFiltrado;
	}

	public void carregarPesquisa(Conta c) {
		try {
			ContaDaoImpl contadaoimpl = new ContaDaoImpl();
			listaConta = contadaoimpl.listando();
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao listar contas" + ex.getMessage());
		}
	}

	public void salvar(Conta c) {
		try {
			cm.registraConta(c);
			FacesUtil.adicionarMsgInfo("Cliente Salvo com Sucesso.");
		} catch (JaExisteException ee) {
			FacesUtil.adicionarMsgErro(ee.getMessage());
		} catch (NullException ne) {
			FacesUtil.adicionarMsgErro(ne.getMessage());
		} catch (StringException se) {
			FacesUtil.adicionarMsgErro(se.getMessage());
		} catch (ValorException ve) {
			FacesUtil.adicionarMsgErro(ve.getMessage());
		}
	}

	public void excluir(Conta c) {
		cm.removeConta(c);
		FacesUtil.adicionarMsgInfo("Conta excluida.");
	}

	public String editar(Conta c) throws SQLException {
		try {
			cm.atualizaConta(c);
			FacesUtil.adicionarMsgInfo("Conta alterada.");
		} catch (StringException se) {
			FacesUtil.adicionarMsgErro(se.getMessage());
		} catch (ValorException ve) {
			FacesUtil.adicionarMsgErro(ve.getMessage());
		} catch (NullException ne) {
			FacesUtil.adicionarMsgErro(ne.getMessage());
		}

		return "";
	}
}
