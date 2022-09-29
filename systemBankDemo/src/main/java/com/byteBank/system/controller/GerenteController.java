package com.byteBank.system.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.byteBank.system.dto.GerenteDto;
import com.byteBank.system.form.GerenteForm;
import com.byteBank.system.service.GerenteService;

@RestController
@RequestMapping("/gerentes")
public class GerenteController {
	
	@Autowired
	private GerenteService gerenteService;

	@GetMapping
	public Page<GerenteDto> listar(@RequestParam(required = false) String nomeGerente,
			@PageableDefault(sort = "id", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {
		return gerenteService.listar(nomeGerente, paginacao);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<GerenteDto> detalhar(@PathVariable Long id) {
		return gerenteService.detalharPorId(id);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<GerenteDto> cadastrar(@RequestBody @Valid GerenteForm gerenteForm,
			UriComponentsBuilder uriBuilder) throws Exception {
		return gerenteService.cadastrarGerente(gerenteForm, uriBuilder);
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<GerenteDto> atualizar(@PathVariable Long id, @RequestBody @Valid GerenteForm gerenteForm) throws Exception {
		return gerenteService.atualizar(id, gerenteForm);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		return gerenteService.removerGerente(id);
	}
	
	
}
