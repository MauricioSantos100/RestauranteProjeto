package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Entidades.Conta;
import model.dao.util.JPAManager;

public class ContaDaoImpl extends DAOImpl implements ContaDao{

	public Conta buscaCodConta(int codConta) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Conta> listando(){
		List<Conta> conta = null;
		EntityManager mng = JPAManager.getInstance().getEntityManager();
		try {
			mng.getTransaction().begin();
			Query query = mng.createQuery("FROM Conta");
			conta = query.getResultList();
		}catch (Exception e) {
			mng.getTransaction().rollback();
		} finally {
			mng.close();
		}
		return conta;
	}

}
