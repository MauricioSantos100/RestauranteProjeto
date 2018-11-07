package model;

import java.util.List;

import model.Entidades.ItemCardapio;
import model.Exception.JaExisteException;
import model.Exception.NullException;
import model.Exception.StringException;
import model.Exception.ValorException;
import model.dao.ItemCardapioDao;
import model.dao.ItemCardapioDaoImpl;
import model.util.Validacoes;

public class ItemCardapioModel {

	private ItemCardapioDaoImpl dao = new ItemCardapioDaoImpl();

	public void registraItemCardapio(ItemCardapio ic)
			throws StringException, JaExisteException, ValorException, NullException {
		if (ic != null) {
			if (!this.existe(ic)) {
				if (Validacoes.verificaString(ic.getNome())) {
					if (Validacoes.verificaValor(ic.getPreco())) {
						dao.insert(ic);
					} else {
						throw new ValorException("Valor inválido");
					}
				} else {
					throw new StringException("Nome inválido");
				}
			} else {
				throw new JaExisteException("Este item do cardapio já existe");
			}
		} else {
			throw new NullException("Nenhum item pode estar vazio");
		}
	}

	public void atualizaItemCardapio(ItemCardapio ic) throws ValorException, StringException, NullException {
		
			if (Validacoes.verificaString(ic.getNome())) {
				if (Validacoes.verificaValor(ic.getPreco())) {
					dao.update(ic);
				} else {
					throw new ValorException("Valor inválido");
				}
			} else {
				throw new StringException("Não digite números ou símbolos");
			}
		
	}

	public void removeItemCardapio(ItemCardapio ic) {
		dao.remove(ic);
	}

	private boolean existe(ItemCardapio ic) {
		boolean valida = false;
		if (((ItemCardapioDao) dao).buscaNome(ic.getNome()) != null) {
			valida = true;
		}
		return valida;
	}
	
	public List<ItemCardapio> listarItemCardapios() {
		return dao.listando();
	}

	public List<ItemCardapio> filtrarItemCardapios() {
		return dao.listando();
	}
}
