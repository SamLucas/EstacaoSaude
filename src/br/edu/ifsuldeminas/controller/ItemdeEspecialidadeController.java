package br.edu.ifsuldeminas.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifsuldeminas.dao.Dao;
import br.edu.ifsuldeminas.model.ItemdeEspecialidade;


@ManagedBean
@ViewScoped
public class ItemdeEspecialidadeController {
	private ItemdeEspecialidade itemdeEspecialidade = new ItemdeEspecialidade();


	public void gravar(){
		Dao<ItemdeEspecialidade> dao = new Dao<ItemdeEspecialidade>(ItemdeEspecialidade.class);
		
		if(this.itemdeEspecialidade.getId() == null) 
			dao.adiciona(itemdeEspecialidade);
		else 
			dao.atualiza(this.itemdeEspecialidade);
		
		itemdeEspecialidade = new ItemdeEspecialidade();
	}

	
	public List<ItemdeEspecialidade> getTodosItemdeEspecialidade(){
		return new Dao<ItemdeEspecialidade>(ItemdeEspecialidade.class).listaTodos();
	}

	public void remover(ItemdeEspecialidade it){
		new Dao<ItemdeEspecialidade>(ItemdeEspecialidade.class).remove(it.getId());
	}
	
	public void carregar(ItemdeEspecialidade it){
		this.itemdeEspecialidade = it;
	}


	public ItemdeEspecialidade getItemdeEspecialidade() {
		return itemdeEspecialidade;
	}


	public void setItemdeEspecialidade(ItemdeEspecialidade itemdeEspecialidade) {
		this.itemdeEspecialidade = itemdeEspecialidade;
	}	

}
