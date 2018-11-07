package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Entidades.Entrega;
import model.dao.util.JPAManager;

public class EntregaDaoImpl extends DAOImpl implements EntregaDao{

	public Entrega buscaCodEntrega(int codEntrega) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Entrega> listando(){
		List<Entrega> entrega = null;
		EntityManager mng = JPAManager.getInstance().getEntityManager();
		try {
			mng.getTransaction().begin();
			Query query = mng.createQuery("FROM Entrega");
			entrega = query.getResultList();
		}catch (Exception e) {
			mng.getTransaction().rollback();
		} finally {
			mng.close();
		}
		return entrega;
	}
}
