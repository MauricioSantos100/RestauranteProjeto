package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import controller.util.FacesUtil;
import model.CardapioModel;
import model.Entidades.Cardapio;
import model.Exception.JaExisteException;
import model.Exception.NullException;
import model.Exception.StringException;

@ManagedBean(name = "cardapioController")
@SessionScoped
public class CardapioController {
	
	private Cardapio cardapio;
	private List<Cardapio> listaCardapio;
	private List<Cardapio> listaCardapioFiltrado;
	private CardapioModel cm = new CardapioModel();

	public Cardapio getCardapio() {
		return this.cardapio;
	}

	public void setCardapio(Cardapio cardapio) {
		this.cardapio = cardapio;
	}

	public CardapioController() {
		this.cardapio = new Cardapio();
	}
	
	public List<Cardapio> getListaCardapio() {		
		listaCardapio = cm.listarCardapios();
		return listaCardapio;
	}

	public void setListaCardapio(List<Cardapio> listaCardapio) {
		this.listaCardapio = listaCardapio;
	}

	public List<Cardapio> getListaCardapioFiltrado() {
		listaCardapioFiltrado = cm.filtrarCardapios();
		return listaCardapioFiltrado;
	}
	
	public void setListaCardapioFiltrado(List<Cardapio> listaCardapioFiltrado) {
		this.listaCardapioFiltrado = listaCardapioFiltrado;
	}

	public void salvar() {
		try {
			cm.registraCategoria(this.cardapio);
			FacesUtil.adicionarMsgInfo("Cardapio salvo com Sucesso.");
		} catch (JaExisteException ex) {
			FacesUtil.adicionarMsgErro(ex.getMessage());
		} catch (NullException ne) {
			FacesUtil.adicionarMsgErro(ne.getMessage());
		} catch (StringException se) {
			FacesUtil.adicionarMsgErro(se.getMessage());
		} finally {
			this.cardapio = new Cardapio();
		}
	}
	
	public void excluir(Cardapio c) {
		cm.removeCategoria(c);
		FacesUtil.adicionarMsgInfo("Cardapio excluido.");
	}

	public String editar() throws NullException, StringException, JaExisteException{
		try {
			cm.atualizarCategoria(this.cardapio);
			FacesUtil.adicionarMsgInfo("Cardapio atualizado com Sucesso.");
		} catch (StringException se) {
			FacesUtil.adicionarMsgErro(se.getMessage());
		} catch (NullException ne) {
			FacesUtil.adicionarMsgErro(ne.getMessage());
		} catch (JaExisteException je) {
			FacesUtil.adicionarMsgErro(je.getMessage());
		}
		
		return "";
	}
}
