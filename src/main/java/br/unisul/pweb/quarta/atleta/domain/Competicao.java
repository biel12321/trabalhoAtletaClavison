package br.unisul.pweb.quarta.atleta.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Competicao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id // coloca o id como chave primaria.
	@GeneratedValue(strategy=GenerationType.IDENTITY) // coloca id como autoIncremento
	private Integer id;
	
	private String descricao;
	
	private String data;
	

	@ManyToMany(mappedBy="competicao")
	private List<Atleta> atleta = new ArrayList<>();
	
	public Competicao() {
		
	}
	
	public Competicao(Integer id, String descricao, String data) {
		this();
		this.id = id;
		this.descricao = descricao;
		this.data = data;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public List<Atleta> getAtleta() {
		return atleta;
	}

	public void setAtleta(List<Atleta> atleta) {
		this.atleta = atleta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Competicao other = (Competicao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
