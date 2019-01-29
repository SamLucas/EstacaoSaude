package br.edu.ifsuldeminas.controller;

import java.util.Arrays;
import java.util.List;
import javax.faces.application.ProjectStage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.ifsuldeminas.dao.Dao;
import br.edu.ifsuldeminas.model.Atividade;
import br.edu.ifsuldeminas.model.Cidade;
import br.edu.ifsuldeminas.model.Professor;
import br.edu.ifsuldeminas.model.Sexo;

@RequestScoped
@ManagedBean
@ViewScoped
public class ProfessorController {
	
	private Professor professor = new Professor();
	private Integer id_cidade;
	
	public ProfessorController() {
		String url = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if(url != null) {
			professor = new Dao<Professor>(Professor.class).listaPorId(Integer.parseInt(url));
			id_cidade = professor.getCiadade().getId();
			/*professor.setSexo(professor.getSexo()
			 * );*/
		}
	 	
	}

	public String gravar(){
		Dao<Professor> dao = new Dao<Professor>(Professor.class);
		
		Cidade ct = new Dao<Cidade>(Cidade.class).listaPorId(id_cidade);
		professor.setCiadade(ct);
		
		if(this.professor.getId() == null) 
			dao.adiciona(professor);
		else 
			dao.atualiza(this.professor);
		
		professor = new Professor();
		return "Index.xhtml?faces-redirect=true";
	}
	
	public List<Sexo> getTodosSexos() {
		return Arrays.asList(Sexo.values());
	}
	
	public List<Professor> getTodosProfessor(){
		return new Dao<Professor>(Professor.class).listaTodos();
	}
	
	public List<Cidade> getTodasCidades() {
		return new Dao<Cidade>(Cidade.class).listaTodos();
	}
	
	public void remover(Professor professor){
		new Dao<Professor>(Professor.class).remove(professor.getId());
	}
	
	public String carregar(Professor professor){
		this.professor = professor;
		return "professor?id="+professor.getId()+"faces-redirect=true";
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
		
	}

	public Integer getId_cidade() {
		return id_cidade;
	}

	public void setId_cidade(Integer id_cidade) {
		this.id_cidade = id_cidade;
	}
}