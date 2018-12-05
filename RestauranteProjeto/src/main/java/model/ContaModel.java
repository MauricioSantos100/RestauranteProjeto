package model;

import java.util.List;

import model.Entidades.Conta;
import model.Exception.JaExisteException;
import model.Exception.NullException;
import model.Exception.StringException;
import model.Exception.ValorException;
import model.dao.ContaDao;
import model.dao.ContaDaoImpl;
import model.util.Validacoes;

public class ContaModel {

	private ContaDaoImpl dao = new ContaDaoImpl();
	private static ContaModel conta;

	private ContaModel() {
		
	}
	
	public static final ContaModel getInstance() {
		if (conta == null) {
			conta = new ContaModel();
		}
		return conta;
	}
	
	public void registraConta(Conta c) throws JaExisteException, NullException, StringException, ValorException {
		if (ContaModel.getInstance() != null) {
			if (c != null) {
				if (!this.existe(c)) {
					if (Validacoes.verificaString(c.getStatus())) {
						if (Validacoes.verificaValor(c.getValorTotal())) {
							dao.insert(c);
						} else {
							throw new ValorException("Não são permitidos valores negativos ou igual a zero");
						}
					} else {
						throw new StringException("Status inválido");
					}
				} else {
					throw new JaExisteException("Esta conta já existe");
				}
			} else {
				throw new NullException("Nenhum item pode estar vazio");
			}
		}
	}

	public void atualizaConta(Conta c) throws ValorException, StringException, NullException {
		if  (!this.existe(c)) {
			if (Validacoes.verificaString(c.getStatus())) {
				if (Validacoes.verificaValor(c.getValorTotal())) {
					dao.update(c);
				} else {
					throw new ValorException("Não são permitidos valores negativos ou igual a zero");
				}
			} else {
				throw new StringException("Não digite números ou símbolos");
			}
		} else {
			throw new NullException("Nenhum item pode estar vazio");
		}
	}

	public void removeConta(Conta c) {
		dao.remove(c);
	}

	private boolean existe(Conta c) {
		boolean valida = false;
		if (((ContaDao) dao).buscarPorCodConta(c.getCodConta()) != null) {
			valida = true;
		}
		return valida;
	}

	public List<Conta> listarTodos() {
		return dao.listarTodos();
	}
	
}
