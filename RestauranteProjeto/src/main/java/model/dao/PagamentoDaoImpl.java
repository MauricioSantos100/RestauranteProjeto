package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Entidades.Pagamento;
import model.dao.util.JPAManager;

public class PagamentoDaoImpl extends DAOImpl implements PagamentoDao {

	public Pagamento buscaCodPagamento(int codPagamento) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Pagamento> listando(){
		List<Pagamento> pagamento = null;
		EntityManager mng = JPAManager.getInstance().getEntityManager();
		try {
			mng.getTransaction().begin();
			Query query = mng.createQuery("FROM Pagamento");
			pagamento = query.getResultList();
		}catch (Exception e) {
			mng.getTransaction().rollback();
		} finally {
			mng.close();
		}
		return pagamento;
	}
}
