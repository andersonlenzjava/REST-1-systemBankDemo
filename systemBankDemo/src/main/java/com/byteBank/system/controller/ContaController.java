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

import com.byteBank.system.dto.ContaDto;
import com.byteBank.system.form.ContaForm;
import com.byteBank.system.service.ContaService;

@RestController
@RequestMapping("/conta")
public class ContaController {
	
	@Autowired
	private ContaService contaService;

	@GetMapping
	public Page<ContaDto> listar(@RequestParam(required = false) Long numeroConta,
			@PageableDefault(sort = "id", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {
		return contaService.listar(numeroConta, paginacao);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ContaDto> detalhar(@PathVariable Long id) {
		return contaService.detalharPorId(id);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<ContaDto> cadastrar(@RequestBody @Valid ContaForm contaForm,
			UriComponentsBuilder uriBuilder) throws Exception {
		return contaService.cadastrarConta(contaForm, uriBuilder);
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ContaDto> atualizar(@PathVariable Long id, @RequestBody @Valid ContaForm contaForm) throws Exception {
		return contaService.atualizar(id, contaForm);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		return contaService.removerCliente(id);
	}
	
	
}
