package br.edu.ifsuldeminas.model;

public enum Sexo {
	FEMININO("Feminino"), MASCULINO("Masculino");
	
	private String descricao;

	private Sexo(String desc) {
		this.descricao = desc;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
