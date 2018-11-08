package controller;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSessionEvent;

import controler.util.FacesUtil;
import model.ClienteModel;
import model.FuncionarioModel;
import model.Entidades.Cliente;
import model.Entidades.Funcionario;

@ManagedBean(name = "loginControl")
@SessionScoped
public class LoginControl2 {
	
	 	private String usuario;
	    private String senha;
	    private Cliente clienteLogin = null;
	    private Funcionario funcionarioLogin = null;
	    
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
		public LoginControl2(){
		    clienteLogin = new Cliente();
		    funcionarioLogin = new Funcionario();
		}
		
		public void logar() {
			FacesContext con = FacesContext.getCurrentInstance();
			ClienteModel cm = new ClienteModel();
			clienteLogin = cm.autenticar(usuario, senha);
			 
			if (this.usuario.equals(usuario) && this.senha.equals(senha)) {
				con.getExternalContext().getSessionMap().put("user", usuario);
				try {
					con.getExternalContext().redirect("Inicio.xhtml");
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				FuncionarioModel fm = new FuncionarioModel();
				funcionarioLogin = fm.autenticarfunc(usuario, senha);
				if (this.usuario.equals(usuario) && this.senha.equals(senha)) {
					con.getExternalContext().getSessionMap().put("user", usuario);
					try {
						con.getExternalContext().redirect("Inicio.xhtml");
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					FacesUtil.adicionarMsgErro("Erro ao fazer login!");
				}
				
				//con.addMessage(null, new FacesMessage("falha ao entrar."));
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
}
