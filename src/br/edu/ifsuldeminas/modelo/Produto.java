package br.edu.ifsuldeminas.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto incremente
	private Integer id;
	private String nome;
	private Integer qtde;
	private Integer qtdeMin;
	@ManyToOne
	private Tipo Tipo = new Tipo();
	public Tipo getTipo() {
		return Tipo;
	}
	public void setTipo(Tipo tipo) {
		Tipo = tipo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getQtde() {
		return qtde;
	}
	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}
	public Integer getQtdeMin() {
		return qtdeMin;
	}
	public void setQtdeMin(Integer qtdeMin) {
		this.qtdeMin = qtdeMin;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	private Double valor;
	// tipo
}
