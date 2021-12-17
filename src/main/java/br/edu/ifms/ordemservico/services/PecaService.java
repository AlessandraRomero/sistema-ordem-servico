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

import br.edu.ifms.ordemservico.dto.PecaDTO;
import br.edu.ifms.ordemservico.entities.Peca;
import br.edu.ifms.ordemservico.repositories.PecaRepository;
import br.edu.ifms.ordemservico.services.exceptions.DataBaseException;
import br.edu.ifms.ordemservico.services.exceptions.ResourceNotFoundException;

@Service
public class PecaService {


	@Autowired
	private PecaRepository repository;
	
	@Transactional(readOnly = true)
	public List<PecaDTO> findAll() {
		List<Peca> list = repository.findAll();
		return list.stream().map(peca -> new PecaDTO(peca)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public PecaDTO findByID(Long id) {
		Optional<Peca> obj = repository.findById(id);
		Peca peca = obj
				.orElseThrow(() -> new ResourceNotFoundException("A peca solicitado não foi localizado"));
		return new PecaDTO(peca);
	}

	@Transactional
	public PecaDTO insert(PecaDTO dto) {
		Peca peca = new Peca();
		copyDtoToEntity(dto, peca);
		peca = repository.save(peca);
		return new PecaDTO(peca);
	}
	
	@Transactional
	public PecaDTO update(Long id, PecaDTO dto) {
		try {
			Peca peca = repository.getById(id);
			copyDtoToEntity(dto, peca);
			peca = repository.save(peca);
			return new PecaDTO(peca);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("A peça não foi localizado");
		}

	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Não foi possivel excluir, id do servidor não foi localizado");
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Não foi possível excluir o servidor pois o mesmo está em uso");
		}
	}
	
	private void copyDtoToEntity(PecaDTO dto, Peca peca) {
		peca.setDescricao(dto.getDescricao());

	}
}
