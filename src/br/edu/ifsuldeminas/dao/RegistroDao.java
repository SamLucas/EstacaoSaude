package br.edu.ifsuldeminas.dao;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.ifsuldeminas.model.RegistrosAtividades;

public class RegistroDao {
	
	public List<RegistrosAtividades> listaTodosPorData(Calendar data) {
		EntityManager em = JPAUtil.getEntityManager();
		
		String jpql = "SELECT t FROM RegistrosAtividades t WHERE t.data = :pnomeee";
		TypedQuery<RegistrosAtividades> query = em.createQuery(jpql, RegistrosAtividades.class);
		query.setParameter("pnomeee", data);
		List<RegistrosAtividades> lista = query.getResultList();
		em.close();
		
		return lista;
	}	
}