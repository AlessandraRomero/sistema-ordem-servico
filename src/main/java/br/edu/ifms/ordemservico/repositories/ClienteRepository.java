package br.edu.ifms.ordemservico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import br.edu.ifms.ordemservico.entities.Cliente;

@Repository
@Component
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
