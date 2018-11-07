package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Entidades.Estoque;
import model.dao.util.JPAManager;

public class EstoqueDaoImpl extends DAOImpl implements EstoqueDao{

	public Estoque buscaNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Estoque> listarNome(){
		List<Estoque> estoque = null;
		EntityManager mng = JPAManager.getInstance().getEntityManager();
		try {
			mng.getTransaction().begin();
			Query query = mng.createQuery("SELECT nome FROM Estoque");
			estoque = query.getResultList();
		}catch (Exception e) {
			mng.getTransaction().rollback();
		} finally {
			mng.close();
		}
		return estoque;
	}
	@SuppressWarnings("unchecked")
	public List<Estoque> listando(){
		List<Estoque> estoque = null;
		EntityManager mng = JPAManager.getInstance().getEntityManager();
		try {
			mng.getTransaction().begin();
			Query query = mng.createQuery("FROM Estoque");
			estoque = query.getResultList();
		}catch (Exception e) {
			mng.getTransaction().rollback();
		} finally {
			mng.close();
		}
		return estoque;
	}


}
