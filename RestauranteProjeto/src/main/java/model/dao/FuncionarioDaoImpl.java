package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Entidades.Funcionario;
import model.dao.util.JPAManager;

public class FuncionarioDaoImpl extends DAOImpl implements FuncionarioDao{

	public Funcionario buscarPorCpf(String cpf) {
		Funcionario funcionario = null;
		EntityManager mng = JPAManager.getInstance().getEntityManager();
		try {
			mng.getTransaction().begin();
			Query query = mng.createQuery("FROM Funcionario where cpf = :cpf");
			funcionario = (Funcionario) query.getSingleResult();
		}catch (Exception e) {
			mng.getTransaction().rollback();
		} finally {
			mng.close();
		}
		return funcionario;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> listarTodos(){
		List<Funcionario> funcionario = null;
		EntityManager mng = JPAManager.getInstance().getEntityManager();
		try {
			mng.getTransaction().begin();
			Query query = mng.createQuery("FROM Funcionario");
			funcionario = query.getResultList();
		}catch (Exception e) {
			mng.getTransaction().rollback();
		} finally {
			mng.close();
		}
		return funcionario;
	}


	public Funcionario buscarPorNome(String nome) {
		Funcionario funcionario = null;
		EntityManager mng = JPAManager.getInstance().getEntityManager();
		try {
			mng.getTransaction().begin();
			Query query = mng.createQuery("FROM Funcionario where nome = :nome");
			funcionario = (Funcionario) query.getSingleResult();
		}catch (Exception e) {
			mng.getTransaction().rollback();
		} finally {
			mng.close();
		}
		return funcionario;
	}
	
}
