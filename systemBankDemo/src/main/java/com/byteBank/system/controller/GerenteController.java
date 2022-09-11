package com.byteBank.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.byteBank.system.dto.GerenteDto;
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
	
}
