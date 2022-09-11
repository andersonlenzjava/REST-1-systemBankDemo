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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.byteBank.system.dto.AgenciaDto;
import com.byteBank.system.form.AgenciaForm;
import com.byteBank.system.service.AgenciaService;

@RestController
@RequestMapping("/agencias")
public class AgenciaController {
	
	@Autowired
	private AgenciaService agenciaService;

	@GetMapping
	public Page<AgenciaDto> listar(@RequestParam(required = false) String nomeAgencia,
			@PageableDefault(sort = "id", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {
		return agenciaService.listar(nomeAgencia, paginacao);
	}

	@GetMapping("/{id}")
	public ResponseEntity<AgenciaDto> detalhar(@PathVariable Long id) {
		return agenciaService.detalharPorId(id);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<AgenciaDto> cadastrar(@RequestBody @Valid AgenciaForm agenciaForm,
			UriComponentsBuilder uriBuilder) throws Exception {
		return agenciaService.cadastrarAgencia(agenciaForm, uriBuilder);
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		return agenciaService.removerAgencia(id);
	}
}
