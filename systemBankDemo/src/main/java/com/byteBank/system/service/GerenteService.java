package com.byteBank.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.byteBank.system.dto.AgenciaDto;
import com.byteBank.system.dto.GerenteDto;
import com.byteBank.system.model.Agencia;
import com.byteBank.system.model.Gerente;
import com.byteBank.system.repository.GerenteRepository;

@Service
public class GerenteService {

	@Autowired
	private GerenteRepository gerenteRepository;
	
	public void criarConta() {
		
	}
	
	public void apagarTransacao() {
		
	}
	
	public void editarTransacao() {
		
	}
	
	public void relatorioConta() {
		
	}
	
	public void RelatorioDinamico() {
		
	}

	public Page<GerenteDto> listar(String nomeGerente, Pageable paginacao) {
		if (nomeGerente == null) {
			Page<Gerente> agencias = gerenteRepository.findAll(paginacao);
			return GerenteDto.converter(agencias);
		} else {
			Page<Gerente> agencias = gerenteRepository.findByNome(nomeGerente, paginacao);
			return GerenteDto.converter(agencias);
		}
	}
}
