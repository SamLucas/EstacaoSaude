package br.edu.ifsuldeminas.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.edu.ifsuldeminas.dao.Dao;
import br.edu.ifsuldeminas.modelo.Produto;

@ManagedBean
public class ProdutoController {
	private Produto produto = new Produto();
	
	public void gravar(){
		Dao<Produto> dao = new Dao<Produto>(Produto.class);
		dao.adiciona(produto);
		//System.out.println("Gravandoo....");
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public List<Produto> getTodosProdutos(){
		return new Dao<Produto>(Produto.class).listaTodos();
	}
	
	public void remover(Produto p) {
		new Dao<Produto>(Produto.class).remove(p.getId());
	}
	
	
}

