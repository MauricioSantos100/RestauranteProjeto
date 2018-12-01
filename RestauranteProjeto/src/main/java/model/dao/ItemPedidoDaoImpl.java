package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Entidades.ItemPedido;
import model.dao.util.JPAManager;

public class ItemPedidoDaoImpl extends DAOImpl implements ItemPedidoDao {

	public ItemPedido buscarPorCodItemPedido(Integer codItem) {
		ItemPedido itemPedido = null;
		EntityManager mng = JPAManager.getInstance().getEntityManager();
		try {
			mng.getTransaction().begin();
			Query query = mng.createQuery("FROM ItemPedido where cod_item = :codItem");
			itemPedido = (ItemPedido) query.getSingleResult();
		}catch (Exception e) {
			mng.getTransaction().rollback();
		} finally {
			mng.close();
		}
		return itemPedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<ItemPedido> listarTodos(){
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

	public ItemPedido buscarPorNome(String nome) {
		ItemPedido itemPedido = null;
		EntityManager mng = JPAManager.getInstance().getEntityManager();
		try {
			mng.getTransaction().begin();
			Query query = mng.createQuery("FROM ItemPedido where nome = :nome");
			itemPedido = (ItemPedido) query.getSingleResult();
		}catch (Exception e) {
			mng.getTransaction().rollback();
		} finally {
			mng.close();
		}
		return itemPedido;
	}
}
