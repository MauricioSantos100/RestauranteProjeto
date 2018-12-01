package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Entidades.Pessoa;
import model.Entidades.Usuario;
import model.dao.util.JPAManager;

public class UsuarioDaoImpl extends DAOImpl implements UsuarioDao {


    public static Usuario autenticar(String usuario, String senha) {
        return (Usuario) JPAManager.getInstance().autenticar(usuario, senha);
    }
    public static Usuario tipo(String tipo, Pessoa pessoa) {
        return (Usuario) JPAManager.getInstance().tipo(tipo, pessoa);
    }

	public Usuario buscarPorIdUsuario(Integer id) {
		Usuario usuario = null;
		EntityManager mng = JPAManager.getInstance().getEntityManager();
		try {
			mng.getTransaction().begin();
			Query query = mng.createQuery("FROM Usuario where id = :id");
			usuario = (Usuario) query.getSingleResult();
		}catch (Exception e) {
			mng.getTransaction().rollback();
		} finally {
			mng.close();
		}
		return usuario;
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listarTodos() {
		List<Usuario> usuario = null;
		EntityManager mng = JPAManager.getInstance().getEntityManager();
		try {
			mng.getTransaction().begin();
			Query query = mng.createQuery("FROM Usuario");
			usuario = query.getResultList();
		}catch (Exception e) {
			mng.getTransaction().rollback();
		} finally {
			mng.close();
		}
		return usuario;
	}
	
}
