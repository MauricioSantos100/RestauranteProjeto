package model.Entidades;


import java.io.Serializable;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo", discriminatorType= DiscriminatorType.STRING, length = 1)
public abstract class Pessoa implements Serializable{
	
	private static final long serialVersionUID = 5795870903752855103L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "cod_pessoa")
	protected Integer codPessoa;
	@Column(name = "nome", length = 100, nullable = false)
	private String nome;
	@Column(name = "cpf", length = 11, nullable = false)
	private String cpf;
	@Column(name = "telefone", length = 20, nullable = false)
	private String telefone;
	@Column(name = "email", length = 100, nullable = false)
	private String email;
	
	@AttributeOverride(name="tipo", column=@Column(name="tipo", nullable = false, insertable = false, updatable= false ))
	private Pessoa pessoat;
	
	@Formula("tipo")
	public Pessoa getTheApType() {
	    return pessoat;
	}
	
	

	public Pessoa getPessoat() {
		return pessoat;
	}



	public void setPessoat(Pessoa pessoat) {
		this.pessoat = pessoat;
	}



	@Transient
	public String getDecriminatorValue() {
	    return this.getClass().getAnnotation(DiscriminatorColumn.class).name();
	}

	
	@ManyToMany
	private List<Usuario> usuario;
	
	protected Pessoa() {}
	
	
	public Integer getCodPessoa() {
		return codPessoa;
	}
	public void setCodPessoa(Integer codPessoa) {
		this.codPessoa = codPessoa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codPessoa == null) ? 0 : codPessoa.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((pessoat == null) ? 0 : pessoat.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (codPessoa == null) {
			if (other.codPessoa != null)
				return false;
		} else if (!codPessoa.equals(other.codPessoa))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (pessoat == null) {
			if (other.pessoat != null)
				return false;
		} else if (!pessoat.equals(other.pessoat))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}


}
