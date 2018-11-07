package model;

import java.util.List;

import model.Entidades.Pagamento;
import model.Exception.DateException;
import model.Exception.JaExisteException;
import model.Exception.NullException;
import model.dao.PagamentoDao;
import model.dao.PagamentoDaoImpl;
import model.util.Validacoes;

public class PagamentoModel {

	private PagamentoDaoImpl dao = new PagamentoDaoImpl();

	public void registraPagamento(Pagamento p) throws JaExisteException, NullException, DateException {
		if (p != null) {
			if (!this.existe(p)) {
				if(Validacoes.validaData(p.getData())) {
					dao.insert(p); 
				} else {
					throw new DateException ("Data invalida");
				}
			} else {
				throw new JaExisteException("Este pagamento já existe");
			}
		} else {
			throw new NullException("Nenhum item pode estar vazio");
		}
	}

	public void atualizaPagamento(Pagamento p) throws NullException {
		if (((PagamentoDao) dao).buscaCodPagamento(p.getCodPagamento()) != null) {
			dao.update(p);
		} else {
			throw new NullException("Nenhum item pode estar vazio");
		}
	}

	public void deletaPagamento(Pagamento p) {
		dao.remove(p);
	}

	private boolean existe(Pagamento p) {
		boolean valida = false;
		if (((PagamentoDao) dao).buscaCodPagamento(p.getCodPagamento()) != null) {
			valida = true;
		}
		return valida;
	}
	
	public List<Pagamento> listarPagamentos() {
		return dao.listando();
	}

	public List<Pagamento> filtrarPagamentos() {
		return dao.listando();
	}
}