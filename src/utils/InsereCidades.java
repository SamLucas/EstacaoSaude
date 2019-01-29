package utils;

import br.edu.ifsuldeminas.dao.Dao;
import br.edu.ifsuldeminas.model.Cidade;
import br.edu.ifsuldeminas.model.Estado;

public class InsereCidades {
	
	public static void main(String[] args) {
		
		Cidade cidade = new Cidade();
		Cidade cidade2 = new Cidade();
		cidade.setNome("Guaxupe");
		cidade2.setNome("Varginha");
		
		Estado estado = new Estado();
		estado.setNome("Minas gerais");
	
		cidade2.setEstado(estado);
		cidade.setEstado(estado);
	
		Dao<Estado> dao = new Dao<Estado>(Estado.class);
		dao.adiciona(estado);
	
		Dao<Cidade> dao2 = new Dao<Cidade>(Cidade.class);
		dao2.adiciona(cidade2);
		dao2.adiciona(cidade);
		
		
		
	}
}
