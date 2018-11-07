package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Entidades.Pedido;
import model.dao.util.JPAManager;

public class PedidoDaoImpl extends DAOImpl implements PedidoDao{

	public Pedido buscaCodPedido(int codPedido) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Pedido> listando(){
		List<Pedido> pedido = null;
		EntityManager mng = JPAManager.getInstance().getEntityManager();
		try {
			mng.getTransaction().begin();
			Query query = mng.createQuery("FROM Pedido");
			pedido = query.getResultList();
		}catch (Exception e) {
			mng.getTransaction().rollback();
		} finally {
			mng.close();
		}
		return pedido;
	}

}
