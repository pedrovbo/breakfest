package com.mv.breakfest.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mv.breakfest.entity.OpcaoCafeManha;

@Component
public interface OpcaoCafeManhaService {

	void save(OpcaoCafeManha opcaoCafeManha);

	List<OpcaoCafeManha> getOpcoesCafeManha();

	OpcaoCafeManha getById(int id);

	void update(OpcaoCafeManha opcaoCafeManha, int id);

	void saveAtribuindoColaborador(OpcaoCafeManha opcaoCafeManha, int id);

	void delete(int id);

	List<OpcaoCafeManha> getAllCafeManhaByColaboradorId(int id);

	public boolean isExisteItemCafeManha(String itemCafeManha);

	public boolean isExisteId(int id);

}
