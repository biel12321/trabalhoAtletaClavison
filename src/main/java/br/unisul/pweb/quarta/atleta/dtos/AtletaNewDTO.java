package br.unisul.pweb.quarta.atleta.dtos;

import java.io.Serializable;

public class AtletaNewDTO implements Serializable {
	
	private Integer id;
	private String nome;
	private String modalidade;
	
	private static final long serialVersionUID = 1L;
	
	public AtletaNewDTO() {
		
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

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}
	
}
