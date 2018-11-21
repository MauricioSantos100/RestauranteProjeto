package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import controller.util.FacesUtil;
import model.UsuarioModel;
import model.Entidades.Usuario;

@ManagedBean(name = "usuarioController")
@SessionScoped
public class UsuarioController {
	private Usuario usuario;
	private UsuarioModel um = new UsuarioModel();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioController() {
		this.usuario = new Usuario();
	}

	public void salvar(Usuario usuario22) {
		um.registraUsuario(usuario22);
		FacesUtil.adicionarMsgInfo("usuario salvo com Sucesso.");

	}

	public void excluir(Usuario u) {
		um.removeCliente(u);
		FacesUtil.adicionarMsgInfo("usuario excluido.");
	}
	/*
	 * public String editar() throws NullException, StringException,
	 * JaExisteException{ try { cm.atualizarCategoria(this.cardapio);
	 * FacesUtil.adicionarMsgInfo("Cardapio atualizado com Sucesso."); } catch
	 * (StringException se) { FacesUtil.adicionarMsgErro(se.getMessage()); } catch
	 * (NullException ne) { FacesUtil.adicionarMsgErro(ne.getMessage()); } catch
	 * (JaExisteException je) { FacesUtil.adicionarMsgErro(je.getMessage()); }
	 * 
	 * return ""; }
	 */
}
