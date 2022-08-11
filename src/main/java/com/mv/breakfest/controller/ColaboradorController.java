package com.mv.breakfest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
import com.mv.breakfest.service.ColaboradorService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/colaborador")
public class ColaboradorController {

	@Autowired
	private ColaboradorService colaboradorService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> save(@RequestBody Colaborador colaborador) {

		if (colaboradorService.isExisteCpf(colaborador.getCpf())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("CPF já está cadastrado!");
		} else {
			colaboradorService.save(colaborador);
			return ResponseEntity.status(HttpStatus.CREATED).body("Colaborador adicionado com sucesso!");
		}

	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Colaborador>> getAll() {
		List<Colaborador> resultado = colaboradorService.getColaboradores();
		if (resultado.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resultado);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(resultado);
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> getById(@PathVariable(value = "id") int id) {

		try {
			Colaborador colaborador = colaboradorService.getById(id);
			return ResponseEntity.status(HttpStatus.OK).body(colaborador);

		} catch (EmptyResultDataAccessException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Colaborador não foi encontrado!");
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Object> update(@RequestBody Colaborador colaborador, @PathVariable(value = "id") int id) {

		// TODO: é necessária validação de cpf neste PUT?
		if (colaboradorService.isExisteCpf(colaborador.getCpf())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("CPF já está cadastrado!");
		} else if (!(colaboradorService.isExisteId(id))) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id inexistente!");
		} else {
			colaboradorService.update(colaborador, id);
			return ResponseEntity.status(HttpStatus.OK).body("Colaborador atualizado com sucesso");
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Object> delete(@PathVariable(value = "id") int id) {
		if (!(colaboradorService.isExisteId(id))) {			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id inexistente!");
		} else {
			colaboradorService.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body("Colaborador removido com sucesso!");
		}

	}

}
