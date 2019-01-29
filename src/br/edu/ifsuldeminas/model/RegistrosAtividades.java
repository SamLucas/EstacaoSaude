package br.edu.ifsuldeminas.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class RegistrosAtividades {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private Integer serie;
	private Integer rep;
	private Integer intervalo;
	private String observacao;
	
	public Integer  hora_inicial;
	
	public Integer hora_final;
	
	@Temporal(TemporalType.DATE)
	private Calendar data = Calendar.getInstance();
	
	@ManyToOne
	private Aluno aluno;
	
	@ManyToOne
	private Professor professor;
	
	@ManyToOne
	private Atividade atividade;
	
	public Integer getHora_inicial() {
		return hora_inicial;
	}
	
	public void setHora_inicial(Integer hora_inicial) {
		this.hora_inicial = hora_inicial;
	}
	
	public Integer getHora_final() {
		return hora_final;
	}
	
	public void setHora_final(Integer hora_final) {
		this.hora_final = hora_final;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getSerie() {
		return serie;
	}

	public void setSerie(Integer serie) {
		this.serie = serie;
	}

	public Integer getRep() {
		return rep;
	}

	public void setRep(Integer rep) {
		this.rep = rep;
	}

	public Integer getIntervalo() {
		return intervalo;
	}

	public void setIntervalo(Integer intervalo) {
		this.intervalo = intervalo;
	}
	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}	
}