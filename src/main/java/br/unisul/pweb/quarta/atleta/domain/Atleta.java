package br.unisul.pweb.quarta.atleta.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Atleta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id // coloca o id como chave primaria.
	@GeneratedValue(strategy=GenerationType.IDENTITY) // coloca id como autoIncremento
	private Integer id;
	
	private String nome;

	@ManyToMany
	@JoinTable(name = "ATLETA_COMPETICAO",
		joinColumns = @JoinColumn(name = "atleta_id"),
		inverseJoinColumns = @JoinColumn(name = "competicao_id")
	)
	
	private List<Competicao> competicao = new ArrayList<>();

	@ElementCollection
	@CollectionTable(name="MODALIDADE")
	private Set<String> modalidade = new HashSet<>();

	
	public Atleta() {
		
	}
	
	public Atleta(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Competicao> getCompeticao() {
		return competicao;
	}

	public void setCompeticao(List<Competicao> competicao) {
		this.competicao = competicao;
	}

	public Set<String> getModalidade() {
		return modalidade;
	}

	public void setModalidade(Set<String> modalidade) {
		this.modalidade = modalidade;
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
		Atleta other = (Atleta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
