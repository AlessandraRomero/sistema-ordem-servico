package br.edu.ifms.ordemservico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.ordemservico.entities.Peca;

@Repository
public interface PecaRepository extends JpaRepository<Peca, Long>{
	
}
