package br.unisul.pweb.quarta.atleta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unisul.pweb.quarta.atleta.domain.Atleta;

public interface AtletaRepository extends JpaRepository<Atleta, Integer>{

}
