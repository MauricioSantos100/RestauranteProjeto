package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Entidades.ItemPedido;
import model.dao.util.JPAManager;

public class ItemPedidoDaoImpl extends DAOImpl implements ItemPedidoDao {

	public ItemPedido buscaCodItemPedido(Integer integer) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<ItemPedido> listando(){
		List<ItemPedido> itemPedido = null;
		EntityManager mng = JPAManager.getInstance().getEntityManager();
		try {
			mng.getTransaction().begin();
			Query query = mng.createQuery("FROM ItemPedido");
			itemPedido = query.getResultList();
		}catch (Exception e) {
			mng.getTransaction().rollback();
		} finally {
			mng.close();
		}
		return itemPedido;
	}
}
