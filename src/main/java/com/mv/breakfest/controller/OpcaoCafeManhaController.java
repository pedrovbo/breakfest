package com.mv.breakfest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mv.breakfest.entity.OpcaoCafeManha;
import com.mv.breakfest.service.OpcaoCafeManhaService;

@RestController
@RequestMapping(value = "/opcaoCafeManha")
public class OpcaoCafeManhaController {
// TODO:  Replicar lógicas de validação da ColaboradorController aqui, também tentar adequar tudo a try catch

	@Autowired
	private OpcaoCafeManhaService opcaoCafeManhaService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> save(@RequestBody OpcaoCafeManha opcaoCafeManha) {
		if (opcaoCafeManhaService.isExisteItemCafeManha(opcaoCafeManha.getItem())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Opção de café da manhã já existe!");
		} else {
			opcaoCafeManhaService.save(opcaoCafeManha);
			return ResponseEntity.status(HttpStatus.CREATED).body("Opção de café da manhã adicionada com sucesso!");
		}

	}

	@RequestMapping(value = "/opcoesCafeManha", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<OpcaoCafeManha>> getOpcoesCafeManha() {
		List<OpcaoCafeManha> resultado = opcaoCafeManhaService.getOpcoesCafeManha();
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
			OpcaoCafeManha resultado = opcaoCafeManhaService.getById(id);
			return ResponseEntity.status(HttpStatus.OK).body(resultado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Opcão de café da manhã não foi encontrada!");
		}
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Object> update(@RequestBody OpcaoCafeManha opcaoCafeManha,
			@PathVariable(value = "id") int id) {
		
		if(opcaoCafeManhaService.isExisteItemCafeManha(opcaoCafeManha.getItem())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Opção de café da manhã já existe!");
		} else if(!(opcaoCafeManhaService.isExisteId(id))) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id inexistente!");
		} else {
			opcaoCafeManhaService.update(opcaoCafeManha, id);
			return ResponseEntity.status(HttpStatus.OK).body("Opção de café da manhã atualizada com sucesso!");
		}
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Object> delete(@PathVariable(value = "id") int id) {
		if(!(opcaoCafeManhaService.isExisteId(id))) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id inexistente!");
		} else {
			opcaoCafeManhaService.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body("Opção de café da manhã removida com sucesso!");
		}
	}

}
