package model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.dao.util.JPAManager;

public class DAOImpl implements DAO<Object>{

	EntityManager manager = JPAManager.getInstance().getEntityManager();
	
	public void insert(Object obj) {
		try  {
			manager.getTransaction().begin();		
			manager.persist(obj);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
	}

	public void update(Object obj) {		
		try  {
			manager.getTransaction().begin();		
			manager.merge(obj);
			manager.getTransaction().commit();
			
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
	}

	public void remove(Object obj) {
		try  {
			manager.getTransaction().begin();		
			manager.remove(manager.merge(obj));
			manager.getTransaction().commit();
			
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
	}

	public Object findbyID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Object> findporid(Integer id) {
		List<Object> obj = null;
		try {
			manager.getTransaction().begin();
			Query query = (Query) manager.find(getClass(), id);
			obj = query.getResultList();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		return obj;
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> findALL() {
		List<Object> obj = null;
		try {
			manager.getTransaction().begin();
			Query query = manager.createQuery("FROM " + getClass());
			obj = query.getResultList();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		return obj;
	}
	
	public List<Object> findALsL() {
		List<Object> lista = new ArrayList<Object>();
		try {
			manager.getTransaction().begin();
			lista = manager.createQuery("SELECT FROM Object", Object.class).getResultList();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		return lista;
	}
}
