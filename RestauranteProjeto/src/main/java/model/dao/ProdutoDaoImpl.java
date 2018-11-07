package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Entidades.Produto;
import model.dao.util.JPAManager;

public class ProdutoDaoImpl extends DAOImpl implements ProdutoDao{

	public Produto buscaNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> listando(){
		List<Produto> produto = null;
		EntityManager mng = JPAManager.getInstance().getEntityManager();
		try {
			mng.getTransaction().begin();
			Query query = mng.createQuery("FROM Produto");
			produto = query.getResultList();
		}catch (Exception e) {
			mng.getTransaction().rollback();
		} finally {
			mng.close();
		}
		return produto;
	}



}
