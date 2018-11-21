package controller;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import controller.util.FacesUtil;
import model.CardapioModel;
import model.ItemCardapioModel;
import model.Entidades.Cardapio;
import model.Entidades.ItemCardapio;
import model.Exception.JaExisteException;
import model.Exception.NullException;
import model.Exception.StringException;
import model.Exception.ValorException;

@ManagedBean(name = "itemCardapioController")
@ApplicationScoped
public class ItemCardapioController {
	private ItemCardapio itemCardapio;
	private List<ItemCardapio> listaItemCardapio;
	private List<ItemCardapio> listaItemCardapioFiltrado;
	ItemCardapioModel icm = new ItemCardapioModel();
	
	public ItemCardapio getItemCardapio() {
		return this.itemCardapio;
	}
	public void setItemCardapio(ItemCardapio itemCardapio) {
		this.itemCardapio = itemCardapio;
	}
	public ItemCardapioController() {
		this.itemCardapio = new ItemCardapio();
	}
	public List<ItemCardapio> getListaItemCardapio() {
		listaItemCardapio = icm.listarItemCardapios();
		return listaItemCardapio;
	}
	public void setListaItemCardapio(List<ItemCardapio> listaItemCardapio) {
		this.listaItemCardapio = listaItemCardapio;
	}
	public List<ItemCardapio> getListaItemCardapioFiltrado() {
		listaItemCardapioFiltrado = icm.filtrarItemCardapios();
		return listaItemCardapioFiltrado;
	}
	public void setListaItemCardapioFiltrado(List<ItemCardapio> listaItemCardapioFiltrado) {
		this.listaItemCardapioFiltrado = listaItemCardapioFiltrado;
	}

	public void salvar() {
		try {
			icm.registraItemCardapio(this.itemCardapio);
			FacesUtil.adicionarMsgInfo("Item cardápio Salvo com Sucesso.");
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

	public void excluir(ItemCardapio ic) {
		icm.removeItemCardapio(ic);
		FacesUtil.adicionarMsgInfo("Item cardápio excluido.");
	}

	public String editar() {
		try {
			icm.atualizaItemCardapio(this.itemCardapio);
			FacesUtil.adicionarMsgInfo("Item cardápio alterado.");
		} catch (NullException ne) {
			FacesUtil.adicionarMsgErro(ne.getMessage());
		} catch (StringException se) {
			FacesUtil.adicionarMsgErro(se.getMessage());
		} catch (ValorException ve) {
			FacesUtil.adicionarMsgErro(ve.getMessage());
		}

		return "";
	}		
}
