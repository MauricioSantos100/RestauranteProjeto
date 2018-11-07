package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Entidades.Cardapio;
import model.dao.util.JPAManager;


public class CardapioDaoImpl extends DAOImpl implements CardapioDao {

	public Cardapio buscaCategoria(String categoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Cardapio> listando(){
		List<Cardapio> cardapio = null;
		EntityManager mng = JPAManager.getInstance().getEntityManager();
		try {
			mng.getTransaction().begin();
			Query query = mng.createQuery("FROM Cardapio");
			cardapio = query.getResultList();
		}catch (Exception e) {
			mng.getTransaction().rollback();
		} finally {
			mng.close();
		}
		return cardapio;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cardapio> listarNome(){
		List<Cardapio> cardapio = null;
		EntityManager mng = JPAManager.getInstance().getEntityManager();
		try {
			mng.getTransaction().begin();
			Query query = mng.createQuery("SELECT categoria FROM Cardapio");
			cardapio = query.getResultList();
		}catch (Exception e) {
			mng.getTransaction().rollback();
		} finally {
			mng.close();
		}
		return cardapio;
	}
	
}
