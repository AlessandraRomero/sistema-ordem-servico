package br.edu.ifms.ordemservico.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.ResourceAccessException;

import br.edu.ifms.ordemservico.dto.ClienteDTO;
import br.edu.ifms.ordemservico.entities.Cliente;
import br.edu.ifms.ordemservico.repositories.ClienteRepository;
import br.edu.ifms.ordemservico.services.exceptions.DataBaseException;
import br.edu.ifms.ordemservico.services.exceptions.ResourceNotFoundException;


@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Transactional(readOnly = true)
	public List<ClienteDTO> findAll() {
		List<Cliente> list = repository.findAll();
		return list.stream().map(cli -> new ClienteDTO(cli)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public ClienteDTO findByID(Long id) {
		Optional<Cliente> obj = repository.findById(id);
		Cliente cli = obj
				.orElseThrow(() -> new ResourceAccessException("O Cliente não foi localizada"));
		return new ClienteDTO(cli);
	}

	@Transactional
	public ClienteDTO insert(ClienteDTO dto) {
		Cliente cli = new Cliente();
		copyDtoToEntity(dto, cli);
		return new ClienteDTO(cli);
	}

	@Transactional
	public ClienteDTO update(Long id, ClienteDTO dto) {
		try {
			Cliente cli = repository.getById(id);
			copyDtoToEntity(dto, cli);
			cli = repository.save(cli);
			return new ClienteDTO(cli);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Cliente não foi localizado");
		}

	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Não foi possivel excluir, id do cliente não foi localizado");
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Não foi possível excluir cliente pois o mesmo está em uso");
		}
	}

	private void copyDtoToEntity(ClienteDTO dto, Cliente cli) {
		cli.setNome(dto.getNome());
		cli.setTelefone(dto.getTelefone());
		cli.setEmail(dto.getEmail());
		cli.setEndereco(dto.getEndereco());
		

	}
	
	
}
