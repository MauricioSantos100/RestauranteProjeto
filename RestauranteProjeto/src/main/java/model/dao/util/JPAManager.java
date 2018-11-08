package model.dao.util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class JPAManager {

	private static JPAManager manager;
	private SessionFactory sessionFactory;
	private JPAManager() {
		sessionFactory = (SessionFactory) Persistence.createEntityManagerFactory( "ProjetoRestaurante" );
	}
	
	public static JPAManager getInstance() {
		if (manager == null) {
			manager = new JPAManager();
		}
		
		return manager;
	}
	
	public EntityManager getEntityManager() {
		return sessionFactory.createEntityManager();
	}
	
	public Object autenticar(String usuario, String senha) {
        Session session = this.sessionFactory.openSession();
        Object obj = null;
        
        try {
            Query consulta = session.createQuery (" SELECT a FROM Cliente a WHERE a.usuario = :usuario AND a.senha = :senha");
            consulta.setParameter("usuario", usuario);
            consulta.setParameter("senha", senha);
            obj = consulta.getSingleResult();
        } catch(RuntimeException ex) {
            throw ex;
        } finally {
                session.close();
        }
        
        return obj;
    }
	public Object autenticarfunc(String usuario, String senha) {
        Session session = this.sessionFactory.openSession();
        Object obj = null;
        
        try {
            Query consulta = session.createQuery (" SELECT f FROM Funcionario f WHERE f.usuario = :usuario AND f.senha = :senha");
            consulta.setParameter("usuario", usuario);
            consulta.setParameter("senha", senha);
            obj = consulta.getSingleResult();
        } catch(RuntimeException ex) {
            throw ex;
        } finally {
                session.close();
        }
        
        return obj;
        
    }
}
