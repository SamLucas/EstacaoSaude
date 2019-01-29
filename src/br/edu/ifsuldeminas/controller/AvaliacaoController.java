package br.edu.ifsuldeminas.controller;

import java.util.LinkedList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifsuldeminas.dao.AlunoDao;
import br.edu.ifsuldeminas.dao.Dao;
import br.edu.ifsuldeminas.model.Aluno;
import br.edu.ifsuldeminas.model.Avaliacao;
import br.edu.ifsuldeminas.model.Professor;

@ManagedBean
@ViewScoped
public class AvaliacaoController {
	
	private Avaliacao avaliacao = new Avaliacao();
	private Integer alunoId;
	private Integer professorid;
	
	private String nome_aluno;
	List<Avaliacao> listAvaliacoes = new LinkedList<Avaliacao>();
	
	public AvaliacaoController() {
		listAvaliacoes = new Dao<Avaliacao>(Avaliacao.class).listaTodos();
	}
	
	// Functionssss..........
	public void gravar(){
		Dao<Avaliacao> dao = new Dao<Avaliacao>(Avaliacao.class);
		Aluno a = new Dao<Aluno>(Aluno.class).listaPorId(alunoId);
		Professor prof = new Dao<Professor>(Professor.class).listaPorId(professorid); 
		
		this.avaliacao.setAluno(a);
		avaliacao.setProfessor(prof);
		
		if(this.avaliacao.getId() == null) 
			dao.adiciona(avaliacao);
		else 
			dao.atualiza(this.avaliacao);
		
		avaliacao = new Avaliacao();
		alunoId = null;
	}
	
	public List<Avaliacao> getTodasAvaliacao(){
		return new Dao<Avaliacao>(Avaliacao.class).listaTodos();
	}
	
	public List<Aluno> getTodosAlunos(){
		return new Dao<Aluno>(Aluno.class).listaTodos();
	}
	
	public void remover(Avaliacao av){
		new Dao<Avaliacao>(Avaliacao.class).remove(av.getId());
	}
	
	public void getTodosAlunoPorAtividade(){
		List<Aluno> allll = new AlunoDao().listaTodosPorNome(nome_aluno);
		listAvaliacoes = new Dao<Avaliacao>(Avaliacao.class).listaTodos();
		List<Avaliacao> listAvaliacoes2 = new LinkedList<Avaliacao>();
		for(Aluno f : allll) {
			for(Avaliacao a : listAvaliacoes) {
				if(a.getAluno().getId() == f.getId()) {
					listAvaliacoes2.add(a);
				}
			}
		}
		listAvaliacoes = listAvaliacoes2;
	}
	
	public void carregar(Avaliacao av){
		this.avaliacao = av;
		this.alunoId = avaliacao.getAluno().getId();
		professorid = avaliacao.getProfessor().getId();
	}	
	
	// Gets and Seters...........
	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Integer getAlunoId() {
		return alunoId;
	}

	public void setAlunoId(Integer alunoId) {
		this.alunoId = alunoId;
	}

	public Integer getProfessorid() {
		return professorid;
	}

	public void setProfessorid(Integer professorid) {
		this.professorid = professorid;
	}

	public String getNome_aluno() {
		return nome_aluno;
	}

	public void setNome_aluno(String nome_aluno) {
		this.nome_aluno = nome_aluno;
	}

	public List<Avaliacao> getListAvaliacoes() {
		return listAvaliacoes;
	}

	public void setListAvaliacoes(List<Avaliacao> listAvaliacoes) {
		this.listAvaliacoes = listAvaliacoes;
	}
	
}