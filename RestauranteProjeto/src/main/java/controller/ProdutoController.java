package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import controller.util.FacesUtil;
import model.ProdutoModel;
import model.Entidades.Produto;
import model.Exception.JaExisteException;
import model.Exception.NullException;
import model.Exception.StringException;
import model.Exception.ValorException;

@ManagedBean(name = "produtoController")
@RequestScoped
public class ProdutoController {
	private Produto produto;
	private List<Produto> listaProduto;
	private ProdutoModel pm = new ProdutoModel();
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public ProdutoController() {
		this.produto = new Produto();
	}
	public List<Produto> getListaProduto() {
		listaProduto = pm.listarTodos();
		return listaProduto;
	}
	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}
	
	
	public void salvar() {
		try {
			pm.registrarProduto(this.produto);
			FacesUtil.adicionarMsgInfo("Produto Salvo com Sucesso.");
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

	public void excluir(Produto p) {
		pm.removeProduto(p);
		FacesUtil.adicionarMsgInfo("Produto excluido.");
	}

	public void editar() {
		try {
			pm.atualizaProduto(this.produto);
			FacesUtil.adicionarMsgInfo("Produto alterado.");
		} catch (NullException ne) {
			FacesUtil.adicionarMsgErro(ne.getMessage());
		} catch (StringException se) {
			FacesUtil.adicionarMsgErro(se.getMessage());
		} catch (ValorException ve) {
			FacesUtil.adicionarMsgErro(ve.getMessage());
		}		
	}		
	
	
}
