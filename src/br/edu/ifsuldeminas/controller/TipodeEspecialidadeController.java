package br.edu.ifsuldeminas.controller;



import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifsuldeminas.dao.Dao;
import br.edu.ifsuldeminas.model.TipodeEspecialidade;


@ManagedBean
@ViewScoped
public class TipodeEspecialidadeController {
	private TipodeEspecialidade tipoEspecialidade = new TipodeEspecialidade();


	public String gravar(){
		Dao<TipodeEspecialidade> dao = new Dao<TipodeEspecialidade>(TipodeEspecialidade.class);
		
		
		if(this.tipoEspecialidade.getId() == null) 
			dao.adiciona(tipoEspecialidade);
		else 
			dao.atualiza(this.tipoEspecialidade);
		
		tipoEspecialidade = new TipodeEspecialidade();
		return "Index.xhtml?faces-redirect=true";
	}

	
	public List<TipodeEspecialidade> getTodosTipodeEspecialidade(){
		return new Dao<TipodeEspecialidade>(TipodeEspecialidade.class).listaTodos();
	}

	public void remover(TipodeEspecialidade tipo){
		new Dao<TipodeEspecialidade>(TipodeEspecialidade.class).remove(tipo.getId());
	}
	
	public void carregar(TipodeEspecialidade tipo){
		this.tipoEspecialidade = tipo;
	}


	public TipodeEspecialidade getTipodeEspecialidade() {
		return tipoEspecialidade;
	}


	public void setTipodeEspecialidade(TipodeEspecialidade tipo) {
		this.tipoEspecialidade = tipo;
	}	

}
