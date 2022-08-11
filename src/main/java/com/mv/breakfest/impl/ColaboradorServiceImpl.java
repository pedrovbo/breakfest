package com.mv.breakfest.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mv.breakfest.entity.Colaborador;
import com.mv.breakfest.repository.ColaboradorRepository;
import com.mv.breakfest.service.ColaboradorService;

@Service("colaboradorServiceImpl")
public class ColaboradorServiceImpl implements ColaboradorService {

	@Autowired
	private ColaboradorRepository colaboradorRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void save(Colaborador colaborador) {

		try {
			boolean cpfExistente = this.isExisteCpf(colaborador.getCpf());
			if (!cpfExistente) {
				colaboradorRepository.save(colaborador);
			}
		} catch (Exception e) {
			// TODO: melhorar captação da exceção
			System.out.println("CPF já está cadastrado!");
		}
	}

	public List<Colaborador> getColaboradores() {
		return colaboradorRepository.getAll();
	}

	public Colaborador getById(int id) {
		return colaboradorRepository.getById(id);
	}

	@Transactional
	public void update(Colaborador colaborador, int id) {

		try {
			boolean cpfExistente = this.isExisteCpf(colaborador.getCpf());
			if (!cpfExistente) {
				colaboradorRepository.update(colaborador, id);
			}
		} catch (Exception e) {
			// TODO: melhorar captação da exceção
			System.out.println("CPF já está cadastrado!");
		}
		// colaboradorRepository.update(colaborador, id);

	}

	@Transactional
	public void delete(int id) {
		colaboradorRepository.delete(id);

	}

	public boolean isExisteCpf(String cpf) {
		boolean existe = true;
		List<Colaborador> consulta = colaboradorRepository.getAllCpf(cpf);
		if (consulta.isEmpty()) {
			existe = false;
		}

		return existe;
	}

	
	public boolean isExisteId(int id) {
		boolean existe = true;
		
		try {
			colaboradorRepository.getById(id);
		} catch (Exception e) {
			System.out.println(e);
			existe = false;
		}
		
		return existe;
	}

}
