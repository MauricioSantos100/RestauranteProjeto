package model;

import java.util.List;

import model.Entidades.Produto;
import model.Exception.JaExisteException;
import model.Exception.NullException;
import model.Exception.StringException;
import model.Exception.ValorException;
import model.dao.ProdutoDao;
import model.dao.ProdutoDaoImpl;
import model.util.Validacoes;

public class ProdutoModel {

	private ProdutoDaoImpl dao = new ProdutoDaoImpl();

	public void registrarProduto(Produto p) throws JaExisteException, StringException, ValorException, NullException {
		if (p != null) {
			if (!this.existe(p)) {
				if (Validacoes.verificaString(p.getNome()) && Validacoes.verificaString(p.getCategoria())) {
					if (Validacoes.verificaValor(p.getPrecoCusto())) {
						dao.insert(p);
					} else {
						throw new ValorException("Preço inválido");
					}
				} else {
					throw new StringException("Nome ou Categoria inválidos");
				}
			} else {
				throw new JaExisteException("Este produto já existe");
			}
		} else {
			throw new NullException("Nenhum item pode estar vazio");
		}
	}

	public void atualizaProduto(Produto p) throws ValorException, StringException, NullException {
		if (((ProdutoDao) dao).buscaNome(p.getNome()) != null) {
			if (Validacoes.verificaString(p.getNome()) && Validacoes.verificaString(p.getCategoria())) {
				if (Validacoes.verificaValor(p.getPrecoCusto())) {
					dao.update(p);
				} else {
					throw new ValorException("Preço inválido");
				}
			} else {
				throw new StringException("Não digite números ou símbolos");
			}
		} else {
			throw new NullException("Nenhum item pode estar vazio");
		}
	}

	public void removeProduto(Produto p) {
		dao.remove(p);
	}

	private boolean existe(Produto p) {
		boolean valida = false;
		if (((ProdutoDao) dao).buscaNome(p.getNome()) != null) {
			valida = true;
		}
		return valida;
	}
	
	public List<Produto> listarProdutos() {
		return dao.listando();
	}

	public List<Produto> filtrarProdutos() {
		return dao.listando();
	}

}