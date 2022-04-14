package com.mv.breakfest.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mv.breakfest.entity.Colaborador;

@Component
public interface ColaboradorService {

	void save(Colaborador colaborador);

	List<Colaborador> getColaboradores();

	Colaborador getById(int id);

	void update(Colaborador colaborador, int id);

	void delete(int id);

	public boolean isExisteCpf(String cpf);

	public boolean isExisteId(int id);

}
