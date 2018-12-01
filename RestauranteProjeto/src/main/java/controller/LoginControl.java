package controller;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.UsuarioModel;
import model.Entidades.Pessoa;
import model.Entidades.Usuario;

@ManagedBean(name = "loginControl")
@SessionScoped
public class LoginControl {
	private String usuario;
	private String senha;
	private Pessoa pessoa;
	@SuppressWarnings("unused")
	private Usuario usuariologin = null;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public LoginControl() {
		usuariologin = new Usuario();
	}

	public void logar(){
		FacesContext con = FacesContext.getCurrentInstance();
		
		if (this.usuario.equals(usuario) && this.senha.equals(senha)
				|| this.usuario.equals("admin") && this.senha.equals("admin")) {
			UsuarioModel cm = new UsuarioModel();
			usuariologin = cm.autenticar(usuario, senha);
			con.getExternalContext().getSessionMap().put("user", usuario);
			try {
				con.getExternalContext().redirect("Inicio.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			//con.addMessage(null, new FacesMessage("falha ao entrar."));
		}
	}
	private String tipo;
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean temPermissao(String tipos) {
			UsuarioModel cm = new UsuarioModel();
			usuariologin = cm.tipo(tipos, pessoa);
			if(this.tipo.equals(tipos)){
				return true;
			}
		return false;
	}

	public void deslogar() {
		FacesContext con = FacesContext.getCurrentInstance();
		con.getExternalContext().invalidateSession();
		try {
			con.getExternalContext().redirect("Inicio.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
 
}
