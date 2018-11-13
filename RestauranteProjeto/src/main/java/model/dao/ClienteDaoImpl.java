package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Entidades.Cliente;
import model.dao.util.JPAManager;

public class ClienteDaoImpl extends DAOImpl implements ClienteDao{

	public Cliente buscaCpfCliente(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> listando(){
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

	@SuppressWarnings("unchecked")
	public List<Cliente> listarNome(){
		List<Cliente> cliente = null;
		EntityManager mng = JPAManager.getInstance().getEntityManager();
		try {
			mng.getTransaction().begin();
			Query query = mng.createQuery("SELECT nome FROM Cliente");
			cliente = query.getResultList();
		}catch (Exception e) {
			mng.getTransaction().rollback();
		} finally {
			mng.close();
		}
		return cliente;
	}

	public Cliente buscaCpfCliente(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}
