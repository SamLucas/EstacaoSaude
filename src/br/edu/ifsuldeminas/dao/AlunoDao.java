package br.edu.ifsuldeminas.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.ifsuldeminas.model.Aluno;

public class AlunoDao {
	
	public List<Aluno> listaTodosPorNome(String nome) {
		EntityManager em = JPAUtil.getEntityManager();
		
		String jpql = "SELECT t FROM Aluno t WHERE t.nome LIKE %:pnomeee%";
		TypedQuery<Aluno> query = em.createQuery(jpql, Aluno.class);
		query.setParameter("pnomeee", nome);
		List<Aluno> lista = query.getResultList();
		em.close();
		
		return lista;
	}	
}