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
					throw new EnderecoException("Não digite simbolos");
				}
			} else {
				throw new JaExisteException("Esta entrega já existe");
			}
		} else {
			throw new NullException("Nenhum item pode estar vazio");
		}
	}

	public void atualizaEntrega(Entrega e) throws EnderecoException, NullException {
		if (((EntregaDao) dao).buscaCodEntrega(e.getCodEntrega()) != null) {
			if (verificaEndereco(e.getBairro()) && verificaEndereco(e.getRua()) && verificaEndereco(e.getComplemento())
					&& verificaEndereco(e.getReferencia()) && verificaEndereco(e.getStatus())) {
				dao.update(e);
			} else {
				throw new EnderecoException("Não digite simbolos");
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
		if (((EntregaDao) dao).buscaCodEntrega(e.getCodEntrega()) != null) {
			existe = true;
		}
		return existe;
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
	
	public List<Entrega> listarEntregas() {
		return dao.listando();
	}

	public List<Entrega> filtrarEntregas() {
		return dao.listando();
	}
}