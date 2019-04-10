package br.unisul.pweb.quarta.atleta.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.pweb.quarta.atleta.domain.Atleta;
import br.unisul.pweb.quarta.atleta.domain.Competicao;
import br.unisul.pweb.quarta.atleta.dtos.AtletaNewDTO;
import br.unisul.pweb.quarta.atleta.repositories.AtletaRepository;

@Service
public class AtletaService {
	
	@Autowired //Injetor de variavel para quando for usado.
	private AtletaRepository rep;
	
	//BUSCAR POR ID
	public Atleta find (Integer id) {
		Optional<Atleta> obj = rep.findById(id);
		return obj.orElse(null);
	}
	
	//INSERIR
	public Atleta insert (Atleta obj) {
		obj.setId(null);
		return rep.save(obj);
	}

	//ATUALIZAR
	public Atleta update (Atleta obj) {
		find(obj.getId());
		return rep.save(obj);
	}

	//DELETAR
	public void delete (Integer id) {
		find(id);
		rep.deleteById(id);
	}
	
	//LISTAR TODAS
	public List<Atleta> findAll(){
		return rep.findAll();
	}
	
	public Atleta fromDTO(AtletaNewDTO objDto) {
		Atleta atl = new Atleta(null, objDto.getNome());
		Competicao comp = new Competicao(objDto.getId(), null, null);
		atl.getCompeticao().add(comp);
		atl.getModalidade().add(objDto.getModalidade());
		return atl;
	}
}
