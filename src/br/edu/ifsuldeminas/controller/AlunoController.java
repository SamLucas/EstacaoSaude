package br.edu.ifsuldeminas.controller;

import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifsuldeminas.dao.Dao;
import br.edu.ifsuldeminas.model.Aluno;
import br.edu.ifsuldeminas.model.Cidade;
import br.edu.ifsuldeminas.model.Sexo;

@ManagedBean
@ViewScoped
public class AlunoController {
	
	private Aluno aluno = new Aluno();
	private Cidade cidade;
	
	
	private Integer id_cidade;

	public String gravar(){
		Dao<Aluno> dao = new Dao<Aluno>(Aluno.class);
		
		Cidade citt = new Dao<Cidade>(Cidade.class).listaPorId(id_cidade);
		aluno.setCit(citt);
		
		if(this.aluno.getId() == null) 
			dao.adiciona(aluno);
		else 
			dao.atualiza(this.aluno);
		
		aluno = new Aluno();
		return "index.html?faces-redirect=true";
	}

	public List<Sexo> getTodosSexos(){	
		return Arrays.asList(Sexo.values()); // retorna um vetor
	}
	
	public List<Aluno> getTodosAluno(){
		return new Dao<Aluno>(Aluno.class).listaTodos();
	}
	
	public List<Cidade> getTodosCidade(){
		return new Dao<Cidade>(Cidade.class).listaTodos();
	}

	public void remover(Aluno aluno){
		new Dao<Aluno>(Aluno.class).remove(aluno.getId());
	}
	
	public void carregar(Aluno aluno){
		this.aluno = aluno;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Integer getId_cidade() {
		return id_cidade;
	}

	public void setId_cidade(Integer id_cidade) {
		this.id_cidade = id_cidade;
	}
}
