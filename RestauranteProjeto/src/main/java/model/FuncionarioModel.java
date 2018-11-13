package model;

import java.util.List;

import model.Entidades.Funcionario;
import model.Exception.CpfException;
import model.Exception.EmailException;
import model.Exception.JaExisteException;
import model.Exception.NullException;
import model.Exception.StringException;
import model.Exception.TelefoneException;
import model.Exception.ValorException;
import model.dao.FuncionarioDao;
import model.dao.FuncionarioDaoImpl;
import model.util.Validacoes;

public class FuncionarioModel {
	private FuncionarioDaoImpl dao = new FuncionarioDaoImpl();

	public void registraFuncionario(Funcionario f) throws EmailException, TelefoneException, CpfException,
			StringException, NullException, JaExisteException, ValorException {
		if (f != null) {
			if (!this.existe(f)) {
				if (Validacoes.verificaString(f.getNome())
						&& Validacoes.verificaString(f.getFuncao())) {
					if (Validacoes.verificaCpf(f.getCpf())) {
						if (Validacoes.verificaTelefone(f.getTelefone())) {
							if (Validacoes.verificaEmail(f.getEmail())) {
								if (Validacoes.verificaValor(f.getSalario())) {
									dao.insert(f);
								} else {
									throw new ValorException("Sal�rio inv�lido");
								}
							} else {
								throw new EmailException("Email inv�lido");
							}
						} else {
							throw new TelefoneException("Telefone inv�lido");
						}
					} else {
						throw new CpfException("Cpf inv�lido");
					}
				} else {
					throw new StringException("Nome, Usuario ou Fun��o inv�lidos");
				}
			} else {
				throw new JaExisteException("Este funcion�rio j� existe");
			}
		} else {
			throw new NullException("Nenhum item pode estar vazio");
		}
	}

	public void removeFuncionario(Funcionario f) {
		dao.remove(f);
	}

	public void atualizaFuncionario(Funcionario f)
			throws StringException, ValorException, EmailException, TelefoneException, CpfException, NullException {
		if (((FuncionarioDao) dao).buscaCpfFuncionario(f.getCpf()) != null) {
			if (Validacoes.verificaString(f.getNome())
					&& Validacoes.verificaString(f.getFuncao())) {
				if (Validacoes.verificaCpf(f.getCpf())) {
					if (Validacoes.verificaTelefone(f.getTelefone())) {
						if (Validacoes.verificaEmail(f.getEmail())) {
							if (Validacoes.verificaValor(f.getSalario())) {
								dao.update(f);
							} else {
								throw new ValorException("Sal�rio inv�lido");
							}
						} else {
							throw new EmailException("Email inv�lido");
						}
					} else {
						throw new TelefoneException("Telefone inv�lido");
					}
				} else {
					throw new CpfException("Cpf inv�lido");
				}
			} else {
				throw new StringException("Nome, Usuario ou Fun��o inv�lidos");
			}
		} else {
			throw new NullException("Nenhum item pode estar vazio");
		}
	}

	private boolean existe(Funcionario f) {
		boolean existe = false;
		if (((FuncionarioDao) dao).buscaCpfFuncionario(f.getCpf()) != null) {
			existe = true;
		}
		return existe;
	}
	
	public List<Funcionario> listarFuncionarios() {
		return dao.listando();
	}

	public List<Funcionario> filtrarFuncionarios() {
		return dao.listando();
	}
	
}