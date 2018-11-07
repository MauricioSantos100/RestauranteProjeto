package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Entidades.ItemCardapio;
import model.dao.util.JPAManager;

public class ItemCardapioDaoImpl extends DAOImpl implements ItemCardapioDao{

	public ItemCardapio buscaNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<ItemCardapio> listando(){
		List<ItemCardapio> itemCardapio = null;
		EntityManager mng = JPAManager.getInstance().getEntityManager();
		try {
			mng.getTransaction().begin();
			Query query = mng.createQuery("FROM ItemCardapio");
			itemCardapio = query.getResultList();
		}catch (Exception e) {
			mng.getTransaction().rollback();
		} finally {
			mng.close();
		}
		return itemCardapio;
	}
}
