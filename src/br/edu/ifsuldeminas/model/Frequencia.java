package br.edu.ifsuldeminas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Frequencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String presensa;
	
	@ManyToOne
	private RegistrosAtividades Reg;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getPresensa() {
		return presensa;
	}

	public void setPresensa(String string) {
		this.presensa = string;
	}

	public RegistrosAtividades getReg() {
		return Reg;
	}

	public void setReg(RegistrosAtividades reg) {
		Reg = reg;
	}
}