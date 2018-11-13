package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Entidades.Funcionario;
import model.dao.util.JPAManager;

public class FuncionarioDaoImpl extends DAOImpl implements FuncionarioDao{

	public Funcionario buscaCpfFuncionario(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> listando(){
		List<Funcionario> funcionario = null;
		EntityManager mng = JPAManager.getInstance().getEntityManager();
		try {
			mng.getTransaction().begin();
			Query query = mng.createQuery("FROM Funcionario");
			funcionario = query.getResultList();
		}catch (Exception e) {
			mng.getTransaction().rollback();
		} finally {
			mng.close();
		}
		return funcionario;
	}
}
