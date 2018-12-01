package model;

import java.util.List;

import model.Entidades.Entrega;
import model.Exception.EnderecoException;
import model.Exception.JaExisteException;
import model.Exception.NullException;
import model.dao.EntregaDao;
import model.dao.EntregaDaoImpl;

public class EntregaModel {

	private EntregaDaoImpl dao = new EntregaDaoImpl();

	public void registraEndereco(Entrega e) throws EnderecoException, NullException, JaExisteException {
		if (e != null) {
			if (!this.existe(e)) {
				if (verificaEndereco(e.getBairro()) && verificaEndereco(e.getRua())
						&& verificaEndereco(e.getComplemento()) && verificaEndereco(e.getReferencia())
						&& verificaEndereco(e.getStatus())) {
					dao.insert(e);
				} else {
					throw new EnderecoException("N�o digite simbolos");
				}
			} else {
				throw new JaExisteException("Esta entrega j� existe");
			}
		} else {
			throw new NullException("Nenhum item pode estar vazio");
		}
	}

	public void atualizaEntrega(Entrega e) throws EnderecoException, NullException {
		if (!this.existe(e)) {
			if (verificaEndereco(e.getBairro()) && verificaEndereco(e.getRua()) && verificaEndereco(e.getComplemento())
					&& verificaEndereco(e.getReferencia()) && verificaEndereco(e.getStatus())) {
				dao.update(e);
			} else {
				throw new EnderecoException("N�o digite simbolos");
			}
		} else {
			throw new NullException("Nenhum item pode estar vazio");
		}

	}

	public void removeEntrega(Entrega e) {
		dao.remove(e);
	}

	private boolean existe(Entrega e) {
		boolean existe = false;
		if (((EntregaDao) dao).buscarPorCodEntrega(e.getCodEntrega()) != null) {
			existe = true;
		}
		return existe;
	}

	public List<Entrega> listarTodos() {
		return dao.listarTodos();
	}

	private boolean verificaEndereco(String s) {
		boolean verifica = true;
		String palavra = s.replaceAll(" ", "");
		for (int i = 0; i < palavra.length(); i++) {
			if (Character.isLetterOrDigit(palavra.charAt(i)) == false) {
				verifica = false;
				break;
			}
		}
		return verifica;
	}

}