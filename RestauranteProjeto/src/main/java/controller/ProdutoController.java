package controller;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import controler.util.FacesUtil;
import model.EstoqueModel;
import model.ProdutoModel;
import model.Entidades.Estoque;
import model.Entidades.Produto;
import model.Exception.JaExisteException;
import model.Exception.NullException;
import model.Exception.StringException;
import model.Exception.ValorException;

@ManagedBean(name = "produtoController")
@ApplicationScoped
public class ProdutoController {
	private Produto produto;
	private List<Produto> listaProduto;
	private List<Produto> listaProdutoFiltrado;
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
		listaProduto = pm.listarProdutos();
		return listaProduto;
	}
	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}
	public List<Produto> getListaProdutoFiltrado() {
		listaProdutoFiltrado = pm.filtrarProdutos();
		return listaProdutoFiltrado;
	}
	public void setListaProdutoFiltrado(List<Produto> listaProdutoFiltrado) {
		this.listaProdutoFiltrado = listaProdutoFiltrado;
	}
	
	//Importar lista de Estoques
	private String estoque;
	private List<Estoque> estoques;
	private EstoqueModel em = new EstoqueModel();
	
	
	public String getEstoque() {
		return estoque;
	}
	public void setEstoque(String estoque) {
		this.estoque = estoque;
	}
	public List<Estoque> getEstoques() {
		estoques = em.listarNomeEstoque();
		return estoques;
	}
	public void setEstoques(List<Estoque> estoques) {
		this.estoques = estoques;
	}
	
	//fim lista de Estoques
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

	public String editar(Produto p) {
		try {
			pm.atualizaProduto(p);
			FacesUtil.adicionarMsgInfo("Produto alterado.");
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
