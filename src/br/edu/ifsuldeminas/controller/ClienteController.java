package br.edu.ifsuldeminas.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifsuldeminas.dao.Dao;
import br.edu.ifsuldeminas.modelo.Cliente;

@ManagedBean
@ViewScoped
public class ClienteController extends PessoaController {
	
	private Cliente cliente = new Cliente();

	public Cliente getCliente() {
		return cliente;
	}
	
	public void gravar(){
		super.gravar(cliente);
		cliente = new Cliente();
	}
	
	public List<Cliente> getTodosClientes() {
		return new Dao<Cliente>(Cliente.class).listaTodos();
	}
	
	public void carregar(Cliente cli) {
		cliente = cli;
	}
}