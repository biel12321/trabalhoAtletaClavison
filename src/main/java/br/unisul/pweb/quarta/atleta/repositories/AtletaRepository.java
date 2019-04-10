package br.unisul.pweb.quarta.atleta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unisul.pweb.quarta.atleta.domain.Atleta;

@Repository
public interface AtletaRepository extends JpaRepository<Atleta, Integer>{

}
