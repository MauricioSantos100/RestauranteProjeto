package controller;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import controller.util.FacesUtil;
import model.ClienteModel;
import model.Entidades.Cliente;
import model.Entidades.Usuario;
import model.Exception.CpfException;
import model.Exception.EmailException;
import model.Exception.JaExisteException;
import model.Exception.NullException;
import model.Exception.StringException;
import model.Exception.TelefoneException;

@ManagedBean(name = "clienteController")
@RequestScoped
public class ClienteController {
	private Cliente cliente;
	private Usuario usuario;
	private List<Cliente> listaCliente;
	private ClienteModel cm = new ClienteModel();
	UsuarioController uc = new UsuarioController();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getListaCliente() {
		listaCliente = cm.ListarTodos();
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}
	
	public ClienteController() {
		this.usuario = new Usuario();
		this.cliente = new Cliente();
	}

	public String salvar() {
		try {
			cliente.setTipo("C");
			uc.salvar(this.usuario);
			cm.registraCliente(this.cliente);
			FacesUtil.adicionarMsgInfo("Cliente Salvo com Sucesso.");
		} catch (JaExisteException ee) {
			FacesUtil.adicionarMsgErro(ee.getMessage());
		} catch (NullException ne) {
			FacesUtil.adicionarMsgErro(ne.getMessage());
		} catch (StringException se) {
			FacesUtil.adicionarMsgErro(se.getMessage());
		} catch (EmailException eex) {
			FacesUtil.adicionarMsgErro(eex.getMessage());
		} catch (CpfException ce) {
			FacesUtil.adicionarMsgErro(ce.getMessage());
		} catch (TelefoneException te) {
			FacesUtil.adicionarMsgErro(te.getMessage());
		}
		return "Inicio.xhtml?faces-redirect=true";
	}

	public String salvar2() {
		try {
			cliente.setTipo("C");
			uc.salvar2(this.usuario);
			cm.registraCliente(this.cliente);
			FacesUtil.adicionarMsgInfo("Cliente Salvo com Sucesso.");
		} catch (JaExisteException ee) {
			FacesUtil.adicionarMsgErro(ee.getMessage());
		} catch (NullException ne) {
			FacesUtil.adicionarMsgErro(ne.getMessage());
		} catch (StringException se) {
			FacesUtil.adicionarMsgErro(se.getMessage());
		} catch (EmailException eex) {
			FacesUtil.adicionarMsgErro(eex.getMessage());
		} catch (CpfException ce) {
			FacesUtil.adicionarMsgErro(ce.getMessage());
		} catch (TelefoneException te) {
			FacesUtil.adicionarMsgErro(te.getMessage());
		}
		return "PesquisaCliente.xhtml?faces-redirect=true";
	}

	public String excluir(Cliente c) {
		uc.excluir(this.usuario);
		cm.removeCliente(c);
		FacesUtil.adicionarMsgInfo("Cliente excluido.");
		return "PesquisaCliente.xhtml?faces-redirect=true";
	}

	public String editar() throws SQLException {
		try {
			uc.editar(this.usuario);
			cliente.setTipo("C");
			cm.atualizaCliente(this.cliente);
			FacesUtil.adicionarMsgInfo("Cliente alterado.");
		} catch (StringException se) {
			FacesUtil.adicionarMsgErro(se.getMessage());
		} catch (EmailException eex) {
			FacesUtil.adicionarMsgErro(eex.getMessage());
		} catch (CpfException ce) {
			FacesUtil.adicionarMsgErro(ce.getMessage());
		} catch (TelefoneException te) {
			FacesUtil.adicionarMsgErro(te.getMessage());
		} catch (NullException ne) {
			FacesUtil.adicionarMsgErro(ne.getMessage());
		}
		return "PesquisaCliente.xhtml?faces-redirect=true";
	}
}
