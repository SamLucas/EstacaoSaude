package br.edu.ifsuldeminas.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.ifsuldeminas.dao.Dao;
import br.edu.ifsuldeminas.model.Atividade;
import br.edu.ifsuldeminas.model.TipoAtividade;
@RequestScoped
@ManagedBean
@ViewScoped
public class AtividadeController {
	private Atividade atividade  = new Atividade();
	private Integer id_tipo;
	
	public AtividadeController() {
		String url = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if(url != null) {
			atividade = new Dao<Atividade>(Atividade.class).listaPorId(Integer.parseInt(url));
			id_tipo = atividade.getTipo_atividade().getId();
			atividade.setId(Integer.parseInt(url));
		}
	 	
	}
	
	@ManagedProperty("#{request.requestURI}")
	private String uri;
	
	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public void gravar(){
		Dao<Atividade> dao = new Dao<Atividade>(Atividade.class);
		
		TipoAtividade tp = new Dao<TipoAtividade>(TipoAtividade.class).listaPorId(id_tipo);
		atividade.setTipo_atividade(tp);
		
		if(this.atividade.getId() == null) 
			dao.adiciona(atividade);
		else 
			dao.atualiza(atividade);
		
		atividade = new Atividade();
	}

	public Integer getId_tipo() {
		return id_tipo;
	}
	
	public void setId_tipo(Integer id_tipo) {
		this.id_tipo = id_tipo;
	}


	public List<TipoAtividade> getTodosTipos(){
		return new Dao<TipoAtividade>(TipoAtividade.class).listaTodos();
	}
	
	public List<Atividade> getTodasAtividades(){
		return new Dao<Atividade>(Atividade.class).listaTodos();
	}

	public void remover(Atividade tip){
		new Dao<Atividade>(Atividade.class).remove(tip.getId());
	}
	
	public String carregar(Atividade tip){
		this.atividade = tip;
		id_tipo = atividade.getTipo_atividade().getId();
		return "atividade?id="+tip.getId()+"faces-redirect=true";
	}
	

	public Atividade getAtividade() {
		return atividade;
	}


	public void setAtividade(Atividade Atividade) {
		this.atividade = Atividade;
	}	

}
