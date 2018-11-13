package model.dao;

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

	public Usuario buscaIdUsuario(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
