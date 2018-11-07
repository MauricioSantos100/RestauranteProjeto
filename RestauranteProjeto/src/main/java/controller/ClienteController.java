package controller;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import controler.util.FacesUtil;
import model.ClienteModel;
import model.Entidades.Cliente;
import model.Exception.CpfException;
import model.Exception.EmailException;
import model.Exception.JaExisteException;
import model.Exception.NullException;
import model.Exception.StringException;
import model.Exception.TelefoneException;

@ManagedBean(name = "clienteController")
@ApplicationScoped
public class ClienteController {

	private Cliente cliente;
	private List<Cliente> listaCliente;
	private List<Cliente> listaClienteFiltrado;
	private ClienteModel cm = new ClienteModel();

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ClienteController() {
		this.cliente = new Cliente();
	}

	public List<Cliente> getListaCliente() {
		listaCliente = cm.listarClientes();
		return listaCliente;
	}
	private List<Cliente> clientes;
	public List<Cliente> getClientes() {
		clientes = cm.listarNomeCliente();
		return clientes;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}

	public List<Cliente> getListaClienteFiltrado() {
		listaClienteFiltrado = cm.filtrarClientes();
		return listaClienteFiltrado;
	}

	public void setListaClienteFiltrado(List<Cliente> listaClienteFiltrado) {
		this.listaClienteFiltrado = listaClienteFiltrado;
	}

	public void salvar() {

		try {
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
	}

	public void excluir(Cliente c) {
		cm.removeCliente(c);
		FacesUtil.adicionarMsgInfo("Cliente excluido.");
	}

	public String editar() throws SQLException {
		try {
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

		return "";
	}
}
