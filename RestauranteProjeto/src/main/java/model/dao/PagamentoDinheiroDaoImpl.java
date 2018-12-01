package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Entidades.PagamentoDinheiro;
import model.dao.util.JPAManager;

public class PagamentoDinheiroDaoImpl extends DAOImpl implements PagamentoDinheiroDao{

	public PagamentoDinheiro buscarPorCodPagamento(int codPagamento) {
		PagamentoDinheiro pagamentoDinheiro = null;
		EntityManager mng = JPAManager.getInstance().getEntityManager();
		try {
			mng.getTransaction().begin();
			Query query = mng.createQuery("FROM pagamentoDinheiro where cod_pagamento = :codPagamento");
			pagamentoDinheiro = (PagamentoDinheiro) query.getSingleResult();
		}catch (Exception e) {
			mng.getTransaction().rollback();
		} finally {
			mng.close();
		}
		return pagamentoDinheiro;
	}

}
