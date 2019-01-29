package br.edu.ifsuldeminas.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.edu.ifsuldeminas.model.Aluno;
import br.edu.ifsuldeminas.model.Professor;
import utils.utils;

public class UsuarioDao {
	
	public Aluno buscarPorUsuarioESenhaaluno(String usuario, String senha) {
		Aluno Usuario;
		
		String jpql = "SELECT DISTINCT u FROM Aluno u  WHERE u.email = :pUsuario AND u.Senha = :pSenha";
				
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Aluno> query = em.createQuery(jpql, Aluno.class);
		query.setParameter("pUsuario", usuario);
		query.setParameter("pSenha",senha);
		
		try {
			Usuario = query.getSingleResult();
	    } catch (NoResultException ex) {
	    	Usuario = null;
	    }
		
		em.close();
		
		return Usuario;
	}
	
	public Professor buscarPorUsuarioESenhaprofessor(String usuario, String senha) {
		Professor Usuario;
		
		String jpql = "SELECT DISTINCT u FROM Professor u  WHERE u.email = :pUsuario AND u.Senha = :pSenha";
				
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Professor> query = em.createQuery(jpql,Professor.class);
		query.setParameter("pUsuario", usuario);
		query.setParameter("pSenha",senha);
		
		try {
			Usuario = query.getSingleResult();
	    } catch (NoResultException ex) {
	    	Usuario = null;
	    }
		
		em.close();
		
		return Usuario;
	}
	
}
