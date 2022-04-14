package com.mv.breakfest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.mv.breakfest.entity.OpcaoCafeManha;

@Repository
public class OpcaoCafeManhaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void save(OpcaoCafeManha opcaoCafeManha) {
		entityManager.createNativeQuery("INSERT INTO opcao_cafe_manha (item) VALUES (?)", OpcaoCafeManha.class)
				.setParameter(1, opcaoCafeManha.getItem()).executeUpdate();
	}

	@Transactional
	public void saveAtribuindoColaborador(OpcaoCafeManha opcaoCafeManha, int id) {
		entityManager
				.createNativeQuery("INSERT INTO opcao_cafe_manha(item, colaborador_id) VALUES( ?, ?)",
						OpcaoCafeManha.class)
				.setParameter(1, opcaoCafeManha.getItem()).setParameter(2, id).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<OpcaoCafeManha> getOpcoesCafeManha() {
		List<OpcaoCafeManha> resultado = (List<OpcaoCafeManha>) entityManager
				.createNativeQuery("SELECT * FROM opcao_cafe_manha", OpcaoCafeManha.class).getResultList();
		return resultado;

	}

	public OpcaoCafeManha getById(int id) {
		OpcaoCafeManha resultado = (OpcaoCafeManha) entityManager
				.createNativeQuery("SELECT * FROM opcao_cafe_manha WHERE id = ?", OpcaoCafeManha.class)
				.setParameter(1, id).getSingleResult();
		return resultado;

	}

	@Transactional
	public void update(OpcaoCafeManha opcaoCafeManha, int id) {
		entityManager.createNativeQuery("UPDATE opcao_cafe_manha SET item= ? WHERE id= ?", OpcaoCafeManha.class)
				.setParameter(1, opcaoCafeManha.getItem()).setParameter(2, id).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<OpcaoCafeManha> getAllCafeManhaByColaboradorId(int id) {
		List<OpcaoCafeManha> resultado = (List<OpcaoCafeManha>) entityManager
				.createNativeQuery("SELECT * FROM opcao_cafe_manha WHERE colaborador_id = ?", OpcaoCafeManha.class)
				.setParameter(1, id).getResultList();
		return resultado;

	}

	@Transactional
	public void delete(int id) {
		entityManager.createNativeQuery("DELETE FROM public.opcao_cafe_manha WHERE id= ?", OpcaoCafeManha.class)
				.setParameter(1, id).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<OpcaoCafeManha> getAllItemCafeManha(String itemCafeManha) {
		List<OpcaoCafeManha> resultado = (List<OpcaoCafeManha>) entityManager
				.createNativeQuery("SELECT * FROM opcao_cafe_manha WHERE item = :item", OpcaoCafeManha.class)
				.setParameter("item", itemCafeManha).getResultList();
		return resultado;
	}

}
