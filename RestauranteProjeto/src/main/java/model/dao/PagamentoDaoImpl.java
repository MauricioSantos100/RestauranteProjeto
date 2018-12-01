package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Entidades.Pagamento;
import model.dao.util.JPAManager;

public class PagamentoDaoImpl extends DAOImpl implements PagamentoDao {

	@SuppressWarnings("unchecked")
	public List<Pagamento> listarTodos(){
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

	public Pagamento buscarPorCodPagamento(int codPagamento) {
		Pagamento pagamento = null;
		EntityManager mng = JPAManager.getInstance().getEntityManager();
		try {
			mng.getTransaction().begin();
			Query query = mng.createQuery("FROM Pagamento where cod_pagamento = :codPagamento");
			pagamento = (Pagamento) query.getSingleResult();
		}catch (Exception e) {
			mng.getTransaction().rollback();
		} finally {
			mng.close();
		}
		return pagamento;
	}
}
