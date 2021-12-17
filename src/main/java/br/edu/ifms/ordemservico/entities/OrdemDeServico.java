package br.edu.ifms.ordemservico.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.edu.ifms.ordemservico.entities.enums.Prioridade;
import br.edu.ifms.ordemservico.entities.enums.Status;

@Entity
@Table(name = "tb_ordem_de_servico")
public class OrdemDeServico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "equipamento_id")
	private Equipamento equipamento;
	private String patrimonio;
	private String setor;
	@Column(columnDefinition = "TEXT")
	private String descricaoProblema;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Date dataCadastro;
	@Enumerated(value = EnumType.STRING)
	private Status status;
	@Enumerated(value = EnumType.STRING)
	private Prioridade prioridade;
	@Column(columnDefinition = "TEXT")
	private String descricaoSolucao;
	@ManyToOne
	@JoinColumn(name = "servidor_id")
	private Servidor servidor;

	public OrdemDeServico() {
	}

	public OrdemDeServico(Long id, Equipamento equipamento, String patrimonio, String setor, String descricaoProblema,
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
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
		OrdemDeServico other = (OrdemDeServico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}