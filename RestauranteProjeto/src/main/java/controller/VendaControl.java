package controller;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import model.ClienteModel;
import model.FuncionarioModel;
import model.ItemCardapioModel;
import model.ItemPedidoModel;
import model.PedidoModel;
import model.Entidades.Cliente;
import model.Entidades.Funcionario;
import model.Entidades.ItemCardapio;
import model.Entidades.ItemPedido;
import model.Entidades.Pedido;

@ManagedBean(name = "vendaControl")
@RequestScoped
public class VendaControl implements Serializable{
	
	private static final long serialVersionUID = 5982537053071441373L;

	private Pedido pedido;
	
	private List<ItemCardapio> itensCardapio;
	private List<ItemPedido> itensPedido;
	private List<Cliente> clientes;
	private List<Funcionario> funcionarios;
	
	private List<Pedido> pedidos;
	private ClienteModel cm = new ClienteModel();
	private FuncionarioModel fm = new FuncionarioModel();
	private ItemCardapioModel ic = new ItemCardapioModel();
	private ItemPedidoModel ip = new ItemPedidoModel();
	private PedidoModel pem = new PedidoModel();
	
	private List<ItemCardapio> itemCardapio = new ArrayList<ItemCardapio>();
	private Double total = 0.;
	private Integer quantidade = 0;

	
	public void adicionarProduto(ItemCardapio prod) {
		this.itemCardapio.add(prod);
		this.total += prod.getPreco();
		quantidade++;
	}
	
	public List<ItemCardapio> getItemCardapio() {
		return itemCardapio;
	}
	
	public void setItemCardapio(List<ItemCardapio> itemCardapio) {
		this.itemCardapio = itemCardapio;
	}
	
	public Double getTotal() {
		return total;
	}
	
	public void setTotal(Double total) {
		this.total = total;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	


	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public List<ItemCardapio> getItensCardapio() {
		itensCardapio = ic.listarTodos();
		return itensCardapio;
	}

	public void setItensCardapio(List<ItemCardapio> itensCardapio) {
		this.itensCardapio = itensCardapio;
	}

	public List<ItemPedido> getItensPedido() {
		itensPedido = ip.listarTodos();
		return itensPedido;
	}

	public void setItensPedido(List<ItemPedido> itensPedido) {
		this.itensPedido = itensPedido;
	}

	public List<Cliente> getClientes() {
		clientes = cm.ListarTodos();
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Funcionario> getFuncionarios() {
		funcionarios = fm.listarTodos();
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public List<Pedido> getPedidos() {
		pedidos = pem.listarTodos();
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	
	public void adicionar(ActionEvent evento) {
		ItemCardapio itemcardapio = (ItemCardapio) evento.getComponent().getAttributes().get("produtoSelecionado");
		
		ItemPedido itempedido = new ItemPedido();
		itempedido.setQuantidade(1);
		itempedido.setItemCardapio(itemcardapio);
		

		itensPedido.add(itempedido);
		System.out.println(itempedido);
		
		/*
		int achou = -1;
		for (int posicao = 0; posicao < itensPedido.size(); posicao++) {
			if (itensPedido.get(posicao).getItemdardapio().equals(itemcardapio)) {
				achou = posicao;
			}
		}

		if (achou < 0) {
			ItemPedido itempedido = new ItemPedido();
			itempedido.setQuantidade(1);
			itempedido.setItemdardapio(itemcardapio);

			itensPedido.add(itempedido);
		} else {
			ItemPedido itempedido = itensPedido.get(achou);
			itempedido.setQuantidade(itempedido.getQuantidade() + 1);
		}*/
		//calcular();
	}
	public void remover(ActionEvent evento) {
		ItemPedido itempedido = (ItemPedido) evento.getComponent().getAttributes().get("itemSelecionado");

		int achou = -1;
		for (int posicao = 0; posicao < itensPedido.size(); posicao++) {
			if (itensPedido.get(posicao).getItemCardapio().equals(itempedido.getItemCardapio())) {
				achou = posicao;
			}
		}

		if (achou > -1) {
			itensPedido.remove(achou);
		}

		//calcular();
	}
}
