package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Entidades.Estoque;
import model.dao.util.JPAManager;

public class EstoqueDaoImpl extends DAOImpl implements EstoqueDao{

	public Estoque buscarPorNome(String nome) {
		Estoque estoque = null;
		EntityManager mng = JPAManager.getInstance().getEntityManager();
		try {
			Query query = mng.createQuery("FROM Estoque where nome = :nome");
			estoque = (Estoque) query.getSingleResult();
		} finally {
			mng.close();
		}
		return estoque;
	}
	
	@SuppressWarnings("unchecked")
	public List<Estoque> listarTodos(){
		List<Estoque> estoque = null;
		EntityManager mng = JPAManager.getInstance().getEntityManager();
		try {
			Query query = mng.createQuery("FROM Estoque");
			estoque = query.getResultList();
		} finally {
			mng.close();
		}
		return estoque;
	}


}
