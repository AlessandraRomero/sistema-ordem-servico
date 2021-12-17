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

import br.edu.ifms.ordemservico.dto.EquipamentoDTO;
import br.edu.ifms.ordemservico.entities.Equipamento;
import br.edu.ifms.ordemservico.repositories.EquipamentoRepository;
import br.edu.ifms.ordemservico.services.exceptions.DataBaseException;
import br.edu.ifms.ordemservico.services.exceptions.ResourceNotFoundException;

@Service
public class EquipamentoService {

	@Autowired
	private EquipamentoRepository repository;

	@Transactional(readOnly = true)
	public List<EquipamentoDTO> findAll() {
		List<Equipamento> list = repository.findAll();
		return list.stream().map(equipamento -> new EquipamentoDTO(equipamento)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public EquipamentoDTO findByID(Long id) {
		Optional<Equipamento> obj = repository.findById(id);
		Equipamento equipamento = obj
				.orElseThrow(() -> new ResourceAccessException("O equipamento solicitado não foi localizada"));
		return new EquipamentoDTO(equipamento);
	}

	@Transactional
	public EquipamentoDTO insert(EquipamentoDTO dto) {
		Equipamento equipamento = new Equipamento();
		copyDtoToEntity(dto, equipamento);
		return new EquipamentoDTO(equipamento);
	}
	
	@Transactional
	public EquipamentoDTO update(Long id, EquipamentoDTO dto) {
		try {
			Equipamento equipamento = repository.getById(id);
			copyDtoToEntity(dto, equipamento);
			equipamento = repository.save(equipamento);
			return new EquipamentoDTO(equipamento);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("O equipamento não foi localizado");
		}

	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Não foi possivel excluir, id do equipamento não foi localizado");
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Não foi possível excluir equipamento pois o mesmo está em uso");
		}
	}

	private void copyDtoToEntity(EquipamentoDTO dto, Equipamento equipamento) {
		equipamento.setTipo_equipamento(dto.getTipo_equipamento());
		equipamento.setDescricao_equipamento(dto.getDescricao_equipamento());
		equipamento.setCliente(dto.getCliente());
		

	}


}
