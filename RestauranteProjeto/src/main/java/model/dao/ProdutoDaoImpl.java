package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Entidades.Produto;
import model.dao.util.JPAManager;

public class ProdutoDaoImpl extends DAOImpl implements ProdutoDao{

	public Produto buscarPorNome(String nome) {
		Produto produto = null;
		EntityManager mng = JPAManager.getInstance().getEntityManager();
		try {
			Query query = mng.createQuery("FROM Produto where nome = :nome");
			produto = (Produto) query.getSingleResult();
		} finally {
			mng.close();
		}
		return produto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> listarTodos(){
		List<Produto> produto = null;
		EntityManager mng = JPAManager.getInstance().getEntityManager();
		try {
			Query query = mng.createQuery("FROM Produto");
			produto = query.getResultList();
		} finally {
			mng.close();
		}
		return produto;
	}

}
