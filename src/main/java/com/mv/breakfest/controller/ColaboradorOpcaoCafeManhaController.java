package com.mv.breakfest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mv.breakfest.entity.Colaborador;
import com.mv.breakfest.entity.OpcaoCafeManha;
import com.mv.breakfest.service.ColaboradorService;
import com.mv.breakfest.service.OpcaoCafeManhaService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/colaborador_opcao_cafe_manha")
public class ColaboradorOpcaoCafeManhaController {
// TODO:  Replicar lógicas de validação da ColaboradorController aqui, também tentar adequar tudo a try catch
	@Autowired
	private ColaboradorService colaboradorService;

	@Autowired
	private OpcaoCafeManhaService opcaoCafeManhaService;

	@RequestMapping(value = "/escolherCafeManha/{id}", method = RequestMethod.POST)

	@ResponseBody
	public ResponseEntity<Object> escolherCafeManha(@RequestBody List<OpcaoCafeManha> opcaoCafeManha,

			@PathVariable int id) {
		if (colaboradorService.isExisteId(id)) {
			Colaborador colaborador = colaboradorService.getById(id);
			opcaoCafeManha.forEach(i -> opcaoCafeManhaService.saveAtribuindoColaborador(i, colaborador.getId()));
			colaborador.getOpcaoCafeManha().addAll(opcaoCafeManha);
			System.out.println(colaborador.getOpcaoCafeManha());
			return ResponseEntity.status(HttpStatus.CREATED)
					.body("Opção(ões) de café da manhã associado(s) com sucesso ao colaborador!");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id inexistente");
		}

	}

	@RequestMapping(value = "/colaborador/opcao_cafe_manha/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> getAllCafeManhaByColaboradorId(int id) {
		if (colaboradorService.isExisteId(id)) {
			List<OpcaoCafeManha> resultado = opcaoCafeManhaService.getAllCafeManhaByColaboradorId(id);
			return ResponseEntity.status(HttpStatus.OK).body(resultado);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id inexistente");
		}

	}
}
