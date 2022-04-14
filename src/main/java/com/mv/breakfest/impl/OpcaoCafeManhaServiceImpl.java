package com.mv.breakfest.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mv.breakfest.entity.OpcaoCafeManha;
import com.mv.breakfest.repository.OpcaoCafeManhaRepository;
import com.mv.breakfest.service.OpcaoCafeManhaService;

@Service("opcaoCafeManhaServiceImpl")
public class OpcaoCafeManhaServiceImpl implements OpcaoCafeManhaService {

	@Autowired
	private OpcaoCafeManhaRepository opcaoCafeManhaRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void save(OpcaoCafeManha opcaoCafeManha) {

		try {
			boolean existe = this.isExisteItemCafeManha(opcaoCafeManha.getItem());
			if (!existe) {
				opcaoCafeManhaRepository.save(opcaoCafeManha);
			}
		} catch (Exception e) {
			// TODO: melhorar captação da exceção
			System.out.println("Item de café da manhã já está cadastrado!");
		}
	}

	public List<OpcaoCafeManha> getOpcoesCafeManha() {
		return opcaoCafeManhaRepository.getOpcoesCafeManha();
	}

	public OpcaoCafeManha getById(int id) {
		return opcaoCafeManhaRepository.getById(id);
	}

	@Transactional
	public void update(OpcaoCafeManha opcaoCafeManha, int id) {

		try {
			boolean existe = this.isExisteItemCafeManha(opcaoCafeManha.getItem());
			if (!existe) {
				opcaoCafeManhaRepository.update(opcaoCafeManha, id);
			}
		} catch (Exception e) {
			// TODO: melhorar captação da exceção
			System.out.println("Item de café da manhã já está cadastrado!");
		}

	}

	@Transactional
	public void saveAtribuindoColaborador(OpcaoCafeManha opcaoCafeManha, int id) {

		try {
			boolean existe = this.isExisteItemCafeManha(opcaoCafeManha.getItem());
			if (!existe) {
				opcaoCafeManhaRepository.saveAtribuindoColaborador(opcaoCafeManha, id);
			}
		} catch (Exception e) {
			// TODO: melhorar captação da exceção
			System.out.println("Item de café da manhã já está cadastrado!");
		}

	}

	public List<OpcaoCafeManha> getAllCafeManhaByColaboradorId(int id) {
		return opcaoCafeManhaRepository.getAllCafeManhaByColaboradorId(id);

	}

	@Transactional
	public void delete(int id) {
		opcaoCafeManhaRepository.delete(id);

	}

	@Override
	public boolean isExisteItemCafeManha(String itemCafeManha) {
		boolean existe = true;
		List<OpcaoCafeManha> consulta = opcaoCafeManhaRepository.getAllItemCafeManha(itemCafeManha);
		if (consulta.isEmpty()) {
			existe = false;
		}

		return existe;
	}

	public boolean isExisteId(int id) {
		boolean existe = true;

		try {
			opcaoCafeManhaRepository.getById(id);
		} catch (Exception e) {
			System.out.println(e);
			existe = false;
		}

		return existe;
	}

}
