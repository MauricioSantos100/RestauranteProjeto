package model.dao.util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.SessionFactory;

import model.Entidades.Pessoa;


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
       
        EntityManager session = getEntityManager();
        Object obj = null;
        try {
            Query consulta = session.createQuery (" SELECT a FROM Usuario a WHERE a.login = :usuario AND a.senha = :senha");
            consulta.setParameter("usuario", usuario);
            consulta.setParameter("senha", senha);
            obj = consulta.getSingleResult();
        } finally {
            session.close();
        }
        
        return obj;
    }
	
	public Object tipo(String tipo, Pessoa pessoa) {
		EntityManager session = getEntityManager();
        Object obj = null;
        try {
            Query consulta = session.createQuery (" SELECT p FROM Pessoa p WHERE p.tipo = :tipo");
            consulta.setParameter("tipo", tipo);
            obj = consulta.getSingleResult();
        } finally {
            session.close();
        }
        
        return obj;
    }

	
}
