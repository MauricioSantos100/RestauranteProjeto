package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Entidades.Cliente;
import model.dao.util.JPAManager;

public class ClienteDaoImpl extends DAOImpl implements ClienteDao{

	public Cliente buscarPorCpf(String cpf) {
		Cliente cliente = null;
		EntityManager mng = JPAManager.getInstance().getEntityManager();
		try {
			mng.getTransaction().begin();
			Query query = mng.createQuery("FROM Cliente where cpf = :cpf");
			cliente = (Cliente) query.getSingleResult();
		}catch (Exception e) {
			mng.getTransaction().rollback();
		} finally {
			mng.close();
		}
		return cliente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> ListarTodos(){
		List<Cliente> cliente = null;
		EntityManager mng = JPAManager.getInstance().getEntityManager();
		try {
			mng.getTransaction().begin();
			Query query = mng.createQuery("FROM Cliente");
			cliente = query.getResultList();
		}catch (Exception e) {
			mng.getTransaction().rollback();
		} finally {
			mng.close();
		}
		return cliente;
	}

	public Cliente buscarPorNome(String nome){
		Cliente cliente = null;
		EntityManager mng = JPAManager.getInstance().getEntityManager();
		try {
			mng.getTransaction().begin();
			Query query = mng.createQuery("FROM Cliente where nome = :nome");
			cliente = (Cliente) query.getSingleResult();
		}catch (Exception e) {
			mng.getTransaction().rollback();
		} finally {
			mng.close();
		}
		return cliente;
	}
}
