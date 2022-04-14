package com.mv.breakfest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.mv.breakfest.entity.Colaborador;

@Repository
public class ColaboradorRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void save(Colaborador colaborador) {
		entityManager.createNativeQuery("INSERT INTO colaborador (cpf, nome) VALUES (?,?)", Colaborador.class)
				.setParameter(1, colaborador.getCpf()).setParameter(2, colaborador.getNome()).executeUpdate();

	}

	@SuppressWarnings("unchecked")
	public List<Colaborador> getAll() {
		List<Colaborador> resultado = (List<Colaborador>) entityManager
				.createNativeQuery("SELECT * FROM colaborador", Colaborador.class).getResultList();
		return resultado;
	}

	@SuppressWarnings("unchecked")
	public List<Colaborador> getAllCpf(String cpf) {
		List<Colaborador> resultado = (List<Colaborador>) entityManager
				.createNativeQuery("SELECT * FROM colaborador WHERE cpf = :cpf", Colaborador.class).setParameter("cpf", cpf)
				.getResultList();
		return resultado;
	}

	
	public Colaborador getById(int id) {
		Colaborador resultado = (Colaborador) entityManager
				.createNativeQuery("SELECT id, cpf, nome FROM colaborador WHERE id = ?", Colaborador.class)
				.setParameter(1, id).getSingleResult();
		return resultado;
	}

	@Transactional
	public void update(Colaborador colaborador, int id) {
		entityManager.createNativeQuery("UPDATE colaborador SET cpf= ?, nome= ? WHERE id= ?", Colaborador.class)
				.setParameter(1, colaborador.getCpf()).setParameter(2, colaborador.getNome()).setParameter(3, id)
				.executeUpdate();
	}

	@Transactional
	public void delete(int id) {
		entityManager.createNativeQuery("DELETE FROM public.colaborador WHERE id= ?", Colaborador.class)
				.setParameter(1, id).executeUpdate();
	}

}