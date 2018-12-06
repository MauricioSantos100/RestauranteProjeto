package model;

import java.util.List;

import model.Entidades.Estoque;
import model.Exception.JaExisteException;
import model.Exception.NullException;
import model.Exception.StringException;
import model.Exception.ValorException;
import model.dao.EstoqueDao;
import model.dao.EstoqueDaoImpl;
import model.util.Validacoes;

public class EstoqueModel {

	private EstoqueDaoImpl dao = new EstoqueDaoImpl();

	public void registraEstoque(Estoque e) throws StringException, JaExisteException, NullException, ValorException {
		if (e != null) {
			if (!this.existe(e)) {
				if (Validacoes.verificaString(e.getNome()) && Validacoes.verificaString(e.getUniMedida())) {
					if (Validacoes.verificaValor(e.getPrecoCusto())) {
						dao.insert(e);
					} else {
						throw new ValorException("Valor ínvalido");
					}
				} else {
					throw new StringException("Não digite números ou símbolos");
				}
			} else {
				throw new JaExisteException("Este estoque já existe");
			}
		} else {
			throw new NullException("Nenhum item pode estar vazio");
		}
	}

	public void removeEstoque(Estoque e) {
		dao.remove(e);
	}

	public void atualizaEstoque(Estoque e) throws StringException, NullException, ValorException {
		if (Validacoes.verificaString(e.getNome()) && Validacoes.verificaString(e.getUniMedida())) {
			if (Validacoes.verificaValor(e.getCodEstoque())) {
				dao.update(e);
			} else {
				throw new ValorException("Valor ínvalido");
			}
		} else {
			throw new StringException("Não digite números ou símbolos");
		}
	}

	private boolean existe(Estoque e) {
		boolean valida = false;
		if (((EstoqueDao) dao).buscarPorNome(e.getNome()) != null) {
			valida = true;
		}
		return valida;
	}

	public List<Estoque> listarTodos() {
		return dao.listarTodos();
	}

	public Estoque buscarPorNome(String nome) {
		return dao.buscarPorNome(nome);
	}

	public static boolean verificaUniMedida(String uniMedida) {
		boolean verifica = true;
		String palavra = uniMedida.replaceAll(" ", "");
		for (int i = 0; i < palavra.length(); i++) {
			if (Character.isLetterOrDigit(palavra.charAt(i)) == false) {
				verifica = false;
				break;
			}
		}
		return verifica;
	}

}
