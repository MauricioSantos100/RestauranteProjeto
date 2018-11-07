package controller;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.servlet.http.HttpSessionEvent;

import model.Entidades.Pessoa;
import model.dao.util.JPAManager;

@ManagedBean(name = "loginController")
@SessionScoped
public class LoginController {

	private String snome;
	private String ssenha;

	public String getSnome() {
		return snome;
	}

	public void setSnome(String snome) {
		this.snome = snome;
	}

	public String getSsenha() {
		return ssenha;
	}

	public void setSsenha(String ssenha) {
		this.ssenha = ssenha;
	}

	public Pessoa auth(String snome, String ssenha) {
		EntityManager em = JPAManager.getInstance().getEntityManager();
		try {

			Query query = em.createQuery("FROM Pessoa p where p.usuario = :usuario and p.senha = :senha");
			query.setParameter("usuario", snome);
			query.setParameter("senha", ssenha);

			return (Pessoa) query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("Não encontrado");
			return null;
		}
	}

	//////////
	private String nome;
	private String senha;

	public void logar() {
		FacesContext con = FacesContext.getCurrentInstance();

		if (this.nome.equals("admin") && this.senha.equals("admin")) {
			con.getExternalContext().getSessionMap().put("user", nome);
			try {
				con.getExternalContext().redirect("Inicio.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			con.addMessage(null, new FacesMessage("falha ao entrar."));
		}
	}
	
	public boolean sessao(HttpSessionEvent se) {
		if(se.getSession().getId() != null) {
			return true;
		}
		return false;
	}
	
	public void deslogar() {
		FacesContext con = FacesContext.getCurrentInstance();
		con.getExternalContext().invalidateSession();
		try {
			con.getExternalContext().redirect("Login.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
