package model.Entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "estoque")
public class Estoque implements Serializable {

	private static final long serialVersionUID = 3516141863055834903L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_estoque")
	private Integer codEstoque;
	@Column(name = "nome", length = 20, nullable = false)
	private String nome;
	@Column(name = "preco_custo", precision = 6, scale = 2, nullable = false)
	private double precoCusto;
	@Column(name = "quantidade", nullable = false)
	private Integer quantidade;
	@Column(name = "uni_medida", length = 2, nullable = false)
	private String uniMedida;

	@OneToOne(mappedBy = "estoque", cascade = CascadeType.ALL)
	private ItemCardapio itemCadapio;

	public Estoque() {
	}

	public Integer getCodEstoque() {
		return codEstoque;
	}

	public void setCodEstoque(Integer codEstoque) {
		this.codEstoque = codEstoque;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getUniMedida() {
		return uniMedida;
	}

	public void setUniMedida(String uniMedida) {
		this.uniMedida = uniMedida;
	}

	public ItemCardapio getItemCadapio() {
		return itemCadapio;
	}

	public void setItemCadapio(ItemCardapio itemCadapio) {
		this.itemCadapio = itemCadapio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codEstoque == null) ? 0 : codEstoque.hashCode());
		result = prime * result + ((itemCadapio == null) ? 0 : itemCadapio.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(precoCusto);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((quantidade == null) ? 0 : quantidade.hashCode());
		result = prime * result + ((uniMedida == null) ? 0 : uniMedida.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estoque other = (Estoque) obj;
		if (codEstoque == null) {
			if (other.codEstoque != null)
				return false;
		} else if (!codEstoque.equals(other.codEstoque))
			return false;
		if (itemCadapio == null) {
			if (other.itemCadapio != null)
				return false;
		} else if (!itemCadapio.equals(other.itemCadapio))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(precoCusto) != Double.doubleToLongBits(other.precoCusto))
			return false;
		if (quantidade == null) {
			if (other.quantidade != null)
				return false;
		} else if (!quantidade.equals(other.quantidade))
			return false;
		if (uniMedida == null) {
			if (other.uniMedida != null)
				return false;
		} else if (!uniMedida.equals(other.uniMedida))
			return false;
		return true;
	}

}
