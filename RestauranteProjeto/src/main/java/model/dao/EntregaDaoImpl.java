package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Entidades.Entrega;
import model.dao.util.JPAManager;

public class EntregaDaoImpl extends DAOImpl implements EntregaDao{

	public Entrega buscarPorCodEntrega(int codEntrega) {
		Entrega entrega = null;
		EntityManager mng = JPAManager.getInstance().getEntityManager();
		try {
			Query query = mng.createQuery("FROM Entrega where cod_entrega = :codentrega");
			entrega = (Entrega) query.getSingleResult();
		} finally {
			mng.close();
		}
		return entrega;
	}
	
	@SuppressWarnings("unchecked")
	public List<Entrega> listarTodos(){
		List<Entrega> entrega = null;
		EntityManager mng = JPAManager.getInstance().getEntityManager();
		try {
			Query query = mng.createQuery("FROM Entrega");
			entrega = query.getResultList();
		} finally {
			mng.close();
		}
		return entrega;
	}
}
