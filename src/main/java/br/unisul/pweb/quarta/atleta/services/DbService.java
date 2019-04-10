package br.unisul.pweb.quarta.atleta.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.pweb.quarta.atleta.domain.Atleta;
import br.unisul.pweb.quarta.atleta.domain.Competicao;
import br.unisul.pweb.quarta.atleta.repositories.AtletaRepository;
import br.unisul.pweb.quarta.atleta.repositories.CompeticaoRepository;

@Service
public class DbService {

	@Autowired
	private AtletaRepository atletaResp;
	
	@Autowired
	private CompeticaoRepository compResp;
	
	public void inicializaBancoDeDados() throws ParseException {

		Competicao comp1 = new Competicao(null, "Surf Street", "25/02/2018");
		Competicao comp2 = new Competicao(null, "Corrida são silvestre", "22/02/2018");
		Competicao comp3 = new Competicao(null, "Festival de natação", "28/02/2018");
		Competicao comp4 = new Competicao(null, "Surf mirim", "07/03/2018");
		Competicao comp5 = new Competicao(null, "Corrida dos aloprados", "05/03/2018");
		Competicao comp6 = new Competicao(null, "Festival de natação 2", "02/03/2018");
		
		Atleta p1 = new Atleta(null, "Gabriel Lopes Weber");
		Atleta p2 = new Atleta(null, "Jose claudio");
		Atleta p3 = new Atleta(null, "Rafael Fagundes");
		Atleta p4 = new Atleta(null, "Marcos");
		Atleta p5 = new Atleta(null, "Aluizio");
		Atleta p6 = new Atleta(null, "Luiza");
		
		p1.getCompeticao().addAll(Arrays.asList(comp2, comp5));
		p2.getCompeticao().addAll(Arrays.asList(comp3, comp6));
		p3.getCompeticao().addAll(Arrays.asList(comp1, comp4));
		p4.getCompeticao().addAll(Arrays.asList(comp2, comp5));
		p5.getCompeticao().addAll(Arrays.asList(comp3, comp6));
		p6.getCompeticao().addAll(Arrays.asList(comp1, comp4));
		comp1.getAtleta().addAll(Arrays.asList(p3, p6)); // surf
		comp2.getAtleta().addAll(Arrays.asList(p1, p5)); // corrida
		comp3.getAtleta().addAll(Arrays.asList(p2, p4)); // natação
		comp4.getAtleta().addAll(Arrays.asList(p6, p3));
		comp5.getAtleta().addAll(Arrays.asList(p1, p5));
		comp6.getAtleta().addAll(Arrays.asList(p4, p2));
		
		compResp.saveAll(Arrays.asList(comp1, comp2, comp3, comp4, comp5, comp6));
		atletaResp.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6));
	}
}
