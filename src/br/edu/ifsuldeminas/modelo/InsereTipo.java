package br.edu.ifsuldeminas.modelo;

import br.edu.ifsuldeminas.dao.Dao;

public class InsereTipo {
	
	public static void main(String[] args) {
		
		Tipo t1 = new Tipo();
		t1.setNome("bebida");
		
		Tipo t2 = new Tipo();
		t2.setNome("nome");
		
		Dao<Tipo> dao = new Dao<Tipo>(Tipo.class);
		dao.adiciona(t1);
		dao.adiciona(t2);
	}
}
