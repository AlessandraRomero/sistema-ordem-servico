package br.edu.ifms.ordemservico.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import br.edu.ifms.ordemservico.entities.Cliente;
import br.edu.ifms.ordemservico.entities.Equipamento;


public class EquipamentoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotBlank(message = "O campo tipo de equipamento é obrigatório")
	private String tipo_equipamento;
	@NotBlank(message = "O campo descrição é obrigatório")
	private String descricao_equipamento;
	@NotBlank(message = "O campo servidor é obrigatório")
	private Cliente cliente;
	
	public EquipamentoDTO(Equipamento equipamento) {
		
	}

	public EquipamentoDTO(Long id, String tipo_equipamento, String descricao_equipamento, Cliente cliente) {
		this.id = id;
		this.tipo_equipamento = tipo_equipamento;
		this.descricao_equipamento = descricao_equipamento;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo_equipamento() {
		return tipo_equipamento;
	}

	public void setTipo_equipamento(String tipo_equipamento) {
		this.tipo_equipamento = tipo_equipamento;
	}

	public String getDescricao_equipamento() {
		return descricao_equipamento;
	}

	public void setDescricao_equipamento(String descricao_equipamento) {
		this.descricao_equipamento = descricao_equipamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EquipamentoDTO other = (EquipamentoDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}

