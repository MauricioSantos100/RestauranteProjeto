package controller;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import controller.util.FacesUtil;
import model.EstoqueModel;
import model.Entidades.Estoque;
import model.Exception.JaExisteException;
import model.Exception.NullException;
import model.Exception.StringException;


@ManagedBean(name = "estoqueController")
@ApplicationScoped
public class EstoqueController {
	
	private Estoque estoque;
	private List<Estoque> listaEstoque;
	private List<Estoque> listaEstoqueFiltrado;
	private EstoqueModel em = new EstoqueModel();
	
	public Estoque getEstoque() {
		return this.estoque;
	}
	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
	
	public EstoqueController() {
		this.estoque = new Estoque();
	}
	
	public List<Estoque> getListaEstoque() {
		listaEstoque = em.listarEstoques();
		return listaEstoque;
	}
	public void setListaEstoque(List<Estoque> listaEstoque) {
		this.listaEstoque = listaEstoque;
	}
	public List<Estoque> getListaEstoqueFiltrado() {
		listaEstoqueFiltrado = em.filtrarEstoques();
		return listaEstoqueFiltrado;
	}
	public void setListaEstoqueFiltrado(List<Estoque> listaEstoqueFiltrado) {
		this.listaEstoqueFiltrado = listaEstoqueFiltrado;
	}

	public void salvar() {
		try {
			em.registraEstoque(this.estoque);
			FacesUtil.adicionarMsgInfo("Estoque Salvo com Sucesso.");
		} catch (JaExisteException ee) {
			FacesUtil.adicionarMsgErro(ee.getMessage());
		} catch (NullException ne) {
			FacesUtil.adicionarMsgErro(ne.getMessage());
		} catch (StringException se) {
			FacesUtil.adicionarMsgErro(se.getMessage());
		}
	}

	public void excluir(Estoque e) {
		em.removeEstoque(e);
		FacesUtil.adicionarMsgInfo("Estoque excluido.");
	}

	public String editar() {
		try {
			em.atualizaEstoque(this.estoque);
			FacesUtil.adicionarMsgInfo("Entrega alterada.");
		} catch (NullException ne) {
			FacesUtil.adicionarMsgErro(ne.getMessage());
		} catch (StringException se) {
			FacesUtil.adicionarMsgErro(se.getMessage());
		}

		return "";
	}
	
}
