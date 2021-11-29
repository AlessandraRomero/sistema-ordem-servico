package br.edu.ifms.ordemservico.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;

import br.edu.ifms.ordemservico.entities.OrdemDeServico;
import br.edu.ifms.ordemservico.entities.Servidor;
import br.edu.ifms.ordemservico.entities.enums.Prioridade;
import br.edu.ifms.ordemservico.entities.enums.Status;

public class OrdemDeServicoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotBlank(message = "O campo equipamento é obrigatório")
	private String equipamento;
	@NotBlank(message = "O campo patrimonio é obrigatório")
	private String patrimonio;
	@NotBlank(message = "O campo setor é obrigatório")
	private String setor;
	@NotBlank(message = "O campo descrição do problema é obrigatório")
	private String descricaoProblema;
	@FutureOrPresent(message = "A data não pode ser no passado")
	private Date dataCadastro;
	private Status status;
	private Prioridade prioridade;
	@NotBlank(message = "O campo descrição  da solução é obrigatório")
	private String descricaoSolucao;
	@NotBlank(message = "O campo servidor é obrigatório")
	private Servidor servidor;
	
	public OrdemDeServicoDTO() {
	}

	public OrdemDeServicoDTO(Long id, String equipamento, String patrimonio, String setor, String descricaoProblema,
			Date dataCadastro, Status status, Prioridade prioridade, String descricaoSolucao, Servidor servidor) {
		this.id = id;
		this.equipamento = equipamento;
		this.patrimonio = patrimonio;
		this.setor = setor;
		this.descricaoProblema = descricaoProblema;
		this.dataCadastro = dataCadastro;
		this.status = status;
		this.prioridade = prioridade;
		this.descricaoSolucao = descricaoSolucao;
		this.servidor = servidor;
	}
	
	public OrdemDeServicoDTO(OrdemDeServico ordem) {
		this.id = ordem.getId();
		this.equipamento = ordem.getEquipamento();
		this.patrimonio = ordem.getPatrimonio();
		this.setor = ordem.getSetor();
		this.descricaoProblema = ordem.getDescricaoProblema();
		this.dataCadastro = ordem.getDataCadastro();
		this.status = ordem.getStatus();
		this.prioridade = ordem.getPrioridade();
		this.descricaoSolucao = ordem.getDescricaoSolucao();
		this.servidor = ordem.getServidor();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(String equipamento) {
		this.equipamento = equipamento;
	}

	public String getPatrimonio() {
		return patrimonio;
	}

	public void setPatrimonio(String patrimonio) {
		this.patrimonio = patrimonio;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getDescricaoProblema() {
		return descricaoProblema;
	}

	public void setDescricaoProblema(String descricaoProblema) {
		this.descricaoProblema = descricaoProblema;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}

	public String getDescricaoSolucao() {
		return descricaoSolucao;
	}

	public void setDescricaoSolucao(String descricaoSolucao) {
		this.descricaoSolucao = descricaoSolucao;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}
	
}
