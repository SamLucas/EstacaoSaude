package br.edu.ifsuldeminas.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifsuldeminas.dao.Dao;
import br.edu.ifsuldeminas.model.Cidade;
import br.edu.ifsuldeminas.model.DadosdaEmpresa;

@ManagedBean
@ViewScoped
public class DadosdaEmpresaController {

	private DadosdaEmpresa dadosdaempresa = new DadosdaEmpresa();
	private Integer id_cidade;
	
	public DadosdaEmpresaController() {
		DadosdaEmpresa aux =  new Dao<DadosdaEmpresa>(DadosdaEmpresa.class).listaPorId(Integer.parseInt("1"));
		if(aux != null) {
			dadosdaempresa = aux;
			id_cidade = dadosdaempresa.getCid().getId();
		}
	}

	public String gravar() {
		Dao<DadosdaEmpresa> dao = new Dao<DadosdaEmpresa>(DadosdaEmpresa.class);
		
		Cidade cit = new Dao<Cidade>(Cidade.class).listaPorId(id_cidade);
		dadosdaempresa.setCid(cit);
		
		if (this.dadosdaempresa.getId() == null)
			dao.adiciona(dadosdaempresa);
		else
			dao.atualiza(this.dadosdaempresa);

		dadosdaempresa = new DadosdaEmpresa();
		return "Index?faces-redirect=true";
	}
	
	public List<Cidade> getTodasCidades() {
		return new Dao<Cidade>(Cidade.class).listaTodos();
	}

	public List<DadosdaEmpresa> getTodosDadosdaEmpresa() {
		return new Dao<DadosdaEmpresa>(DadosdaEmpresa.class).listaTodos();
	}

	public void remover(DadosdaEmpresa dad) {
		new Dao<DadosdaEmpresa>(DadosdaEmpresa.class).remove(dad.getId());
	}

	public void carregar(DadosdaEmpresa dad) {
		this.dadosdaempresa = dad;
	}

	public DadosdaEmpresa getDadosdaEmpresa() {
		return dadosdaempresa;
	}

	public void setDadosdaEmpresa(DadosdaEmpresa dadosdaempresa) {
		this.dadosdaempresa = dadosdaempresa;
	}

	public DadosdaEmpresa getDadosdaempresa() {
		return dadosdaempresa;
	}

	public void setDadosdaempresa(DadosdaEmpresa dadosdaempresa) {
		this.dadosdaempresa = dadosdaempresa;
	}

	public Integer getId_cidade() {
		return id_cidade;
	}

	public void setId_cidade(Integer id_cidade) {
		this.id_cidade = id_cidade;
	}
}
