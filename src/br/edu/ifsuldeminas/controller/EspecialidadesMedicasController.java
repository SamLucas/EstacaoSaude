package br.edu.ifsuldeminas.controller;



import java.util.LinkedList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifsuldeminas.dao.AlunoDao;
import br.edu.ifsuldeminas.dao.Dao;
import br.edu.ifsuldeminas.model.Aluno;
import br.edu.ifsuldeminas.model.EspecialidadesMedicas;
import br.edu.ifsuldeminas.model.TipodeEspecialidade;

@ManagedBean
@ViewScoped
public class EspecialidadesMedicasController {
	
	private EspecialidadesMedicas especialidadesmedicas = new EspecialidadesMedicas();
	private Integer tipoId;
	
	private String nome_aluno;
	List<EspecialidadesMedicas> listEspecialidadesMedicas = new LinkedList<EspecialidadesMedicas>();


	public void gravar(){
		Dao<EspecialidadesMedicas> dao = new Dao<EspecialidadesMedicas>(EspecialidadesMedicas.class);
		TipodeEspecialidade t = new Dao<TipodeEspecialidade>(TipodeEspecialidade.class).listaPorId(tipoId);
		
		this.especialidadesmedicas.setTipo(t);
		
		if(this.especialidadesmedicas.getId() == null) 
			dao.adiciona(especialidadesmedicas);
		else 
			dao.atualiza(this.especialidadesmedicas);
		
		especialidadesmedicas = new EspecialidadesMedicas();
		tipoId = null;
	}
	
	public void getTodosAlunoPorEpecialidade(){
		List<Aluno> allll = new AlunoDao().listaTodosPorNome(nome_aluno);
		listEspecialidadesMedicas = new Dao<EspecialidadesMedicas>(EspecialidadesMedicas.class).listaTodos();
		List<EspecialidadesMedicas> listEspecialidadesMedicas2 = new LinkedList<EspecialidadesMedicas>();
		for(Aluno f : allll) {
			for(EspecialidadesMedicas a : listEspecialidadesMedicas) {
				if(a.getAlu().getId() == f.getId()) {
					listEspecialidadesMedicas2.add(a);
				}
			}
		}
		listEspecialidadesMedicas = listEspecialidadesMedicas2;
	}
	
	public List<TipodeEspecialidade> getTodosTipodeEspecialidade(){
		return new Dao<TipodeEspecialidade>(TipodeEspecialidade.class).listaTodos();
	}

	
	public List<EspecialidadesMedicas> getTodosEspecialidadesMedicas(){
		return new Dao<EspecialidadesMedicas>(EspecialidadesMedicas.class).listaTodos();
	}

	public void remover(EspecialidadesMedicas esp){
		new Dao<EspecialidadesMedicas>(EspecialidadesMedicas.class).remove(esp.getId());
	}
	
	public void carregar(EspecialidadesMedicas esp){
		this.especialidadesmedicas = esp;
		this.tipoId = especialidadesmedicas.getTipo().getId();
	}


	public EspecialidadesMedicas getEspecialidadesMedicas() {
		return especialidadesmedicas;
	}


	public Integer getTipoId() {
		return tipoId;
	}


	public void setTipoId(Integer tipoId) {
		this.tipoId = tipoId;
	}


	public void setEspecialidadesMedicas(EspecialidadesMedicas especialidadesmedicas) {
		this.especialidadesmedicas = especialidadesmedicas;
	}

	public EspecialidadesMedicas getEspecialidadesmedicas() {
		return especialidadesmedicas;
	}

	public void setEspecialidadesmedicas(EspecialidadesMedicas especialidadesmedicas) {
		this.especialidadesmedicas = especialidadesmedicas;
	}

	public String getNome_aluno() {
		return nome_aluno;
	}

	public void setNome_aluno(String nome_aluno) {
		this.nome_aluno = nome_aluno;
	}

	public List<EspecialidadesMedicas> getListEspecialidadesMedicas() {
		return listEspecialidadesMedicas;
	}

	public void setListEspecialidadesMedicas(List<EspecialidadesMedicas> listEspecialidadesMedicas) {
		this.listEspecialidadesMedicas = listEspecialidadesMedicas;
	}
	
	

}
