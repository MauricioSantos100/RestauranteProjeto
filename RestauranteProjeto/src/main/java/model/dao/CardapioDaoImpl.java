package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Entidades.Cardapio;
import model.dao.util.JPAManager;

public class CardapioDaoImpl extends DAOImpl implements CardapioDao {

	public Cardapio buscarPorCategoria(String categoria) {
		Cardapio cardapio = null;
		EntityManager mng = JPAManager.getInstance().getEntityManager();
		try {
			Query query = mng.createQuery("FROM Cardapio where categoria = :categoria");
			cardapio = (Cardapio) query.getSingleResult();
		} finally {
			mng.close();
		}
		return cardapio;
	}

	@SuppressWarnings("unchecked")
	public List<Cardapio> listarTodos() {
		List<Cardapio> cardapio = null;
		EntityManager mng = JPAManager.getInstance().getEntityManager();
		try {
			Query query = mng.createQuery("FROM Cardapio");
			cardapio = query.getResultList();
		} finally {
			mng.close();
		}
		return cardapio;
	}

}
