package br.edu.ifsuldeminas.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.ifsuldeminas.dao.Dao;
import br.edu.ifsuldeminas.model.Atividade;
import br.edu.ifsuldeminas.model.TipoAtividade;

@RequestScoped
@ManagedBean
@ViewScoped
public class TipoAtividadeController {
	private TipoAtividade tipoatividade = new TipoAtividade();

	public TipoAtividadeController() {
		String url = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if(url != null) {
			tipoatividade = new Dao<TipoAtividade>(TipoAtividade.class).listaPorId(Integer.parseInt(url));
			tipoatividade.setId(Integer.parseInt(url));
		}
	 	
	}
	
	public String gravar(){
		Dao<TipoAtividade> dao = new Dao<TipoAtividade>(TipoAtividade.class);
		
		if(this.tipoatividade.getId() == null) 
			dao.adiciona(tipoatividade);
		else 
			dao.atualiza(this.tipoatividade);
		
		tipoatividade = new TipoAtividade();
		return "Index.xhtml?faces-redirect=true";
	}

	
	public List<TipoAtividade> getTodosTipoAtividade(){
		return new Dao<TipoAtividade>(TipoAtividade.class).listaTodos();
	}

	public void remover(TipoAtividade tip){
		new Dao<TipoAtividade>(TipoAtividade.class).remove(tip.getId());
	}
	
	public String carregar(TipoAtividade tip){
		this.tipoatividade = tip;
		return "tipoatividade?id="+tip.getId()+"faces-redirect=true";
	}


	public TipoAtividade getTipoatividade() {
		return tipoatividade;
	}


	public void setTipoatividade(TipoAtividade tipoatividade) {
		this.tipoatividade = tipoatividade;
	}	

}
