package br.edu.ifsuldeminas.controller;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifsuldeminas.dao.Dao;
import br.edu.ifsuldeminas.dao.RegistroDao;
import br.edu.ifsuldeminas.model.Aluno;
import br.edu.ifsuldeminas.model.Atividade;
import br.edu.ifsuldeminas.model.Professor;
import br.edu.ifsuldeminas.model.RegistrosAtividades;

@ManagedBean
@ViewScoped
public class RegistrosAtividadesController {
	
	private RegistrosAtividades reg = new RegistrosAtividades();
	private Integer id_aluno;
	private Integer id_professor;
	private Integer id_atividade;
	
	
	
	public RegistrosAtividadesController() {
		
		
		/*reg = new Dao<RegistrosAtividades>(RegistrosAtividades.class).listaPorId(Integer.parseInt("1"));
		id_aluno = reg.getAluno().getId();
		id_professor = reg.getProfessor().getId();
		id_atividade = reg.getAtividade().getId();*/
	}
		
	// Functionssss
	public void gravar(){
		
		Dao<RegistrosAtividades> dao = new Dao<RegistrosAtividades>(RegistrosAtividades.class);
		Aluno aln = new Dao<Aluno>(Aluno.class).listaPorId(id_aluno);
		Professor pro = new Dao<Professor>(Professor.class).listaPorId(id_professor);
		Atividade atv = new Dao<Atividade>(Atividade.class).listaPorId(id_atividade);
		
		reg.setAluno(aln);
		reg.setProfessor(pro);
		reg.setAtividade(atv);
		
		if(this.reg.getId() == null) dao.adiciona(reg);
		else dao.atualiza(this.reg);
		reg = new RegistrosAtividades();
	}
	
	public void remover(RegistrosAtividades reg){
		new Dao<RegistrosAtividades>(RegistrosAtividades.class).remove(reg.getId());
	}
	
	public void carregar(RegistrosAtividades registro){
		this.reg = registro;
	}
	
	public List<Aluno> getTodosAluno(){
		return new Dao<Aluno>(Aluno.class).listaTodos();
	}
	
	public List<Professor> getTodosProfessor(){
		return new Dao<Professor>(Professor.class).listaTodos();
	}
	
	public List<Atividade> getTodosAtividade(){
		return new Dao<Atividade>(Atividade.class).listaTodos();
	}
	
	// Get and Seters.....
	public RegistrosAtividades getReg() {
		return reg;
	}

	public void setReg(RegistrosAtividades reg) {
		this.reg = reg;
	}

	public Integer getId_aluno() {
		return id_aluno;
	}

	public void setId_aluno(Integer id_aluno) {
		this.id_aluno = id_aluno;
	}

	public Integer getId_professor() {
		return id_professor;
	}

	public void setId_professor(Integer id_professor) {
		this.id_professor = id_professor;
	}

	public Integer getId_atividade() {
		return id_atividade;
	}

	public void setId_atividade(Integer id_atividade) {
		this.id_atividade = id_atividade;
	}
}