package br.edu.ifsuldeminas.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class AlunoEspecialidade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String Observacoes;

	@Temporal(TemporalType.DATE)
	private Calendar Data = Calendar.getInstance();
	
	@ManyToOne
	private Aluno aln;
	
	@ManyToOne
	private EspecialidadesMedicas ESPM;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getObservacoes() {
		return Observacoes;
	}

	public void setObservacoes(String observacoes) {
		Observacoes = observacoes;
	}

	public Calendar getData() {
		return Data;
	}

	public void setData(Calendar data) {
		Data = data;
	}

	public Aluno getAln() {
		return aln;
	}

	public void setAln(Aluno aln) {
		this.aln = aln;
	}

	public EspecialidadesMedicas getESPM() {
		return ESPM;
	}

	public void setESPM(EspecialidadesMedicas eSPM) {
		ESPM = eSPM;
	}
}
