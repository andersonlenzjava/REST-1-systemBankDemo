package com.byteBank.system.service;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.byteBank.system.dto.AgenciaDto;
import com.byteBank.system.dto.GerenteDto;
import com.byteBank.system.form.GerenteForm;
import com.byteBank.system.model.Agencia;
import com.byteBank.system.model.Gerente;
import com.byteBank.system.repository.AgenciaRepository;
import com.byteBank.system.repository.GerenteRepository;

@Service
public class GerenteService {

	@Autowired
	private GerenteRepository gerenteRepository;

	@Autowired
	private AgenciaRepository agenciaRepository;

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

	// get
	public Page<GerenteDto> listar(String nomeGerente, Pageable paginacao) {
		if (nomeGerente == null) {
			Page<Gerente> gerentes = gerenteRepository.findAll(paginacao);
			return GerenteDto.converter(gerentes);
		} else {
			Page<Gerente> gerentes = gerenteRepository.findByNome(nomeGerente, paginacao);
			return GerenteDto.converter(gerentes);
		}
	}

	// get id
	public ResponseEntity<GerenteDto> detalharPorId(Long id) {
		Optional<Gerente> gerente = gerenteRepository.findById(id);
		if (gerente.isPresent()) {
			return ResponseEntity.ok(GerenteDto.converterUmaAgencia(gerente.get()));
		}
		return ResponseEntity.notFound().build();
	}

	// cadastrar
	public ResponseEntity<GerenteDto> cadastrarGerente(@Valid GerenteForm gerenteForm, UriComponentsBuilder uriBuilder)
			throws Exception {
		Gerente gerente = gerenteForm.converter(agenciaRepository);
		Optional<Gerente> gerenteOptional = gerenteRepository.findByNomeAndCpfAndDataNascimento(gerente.getNome(),
				gerente.getCpf(), gerente.getDataNascimento());
		if (gerenteOptional.isEmpty()) {
			gerenteRepository.save(gerente);
			URI uri = uriBuilder.path("/gerentes/{id}").buildAndExpand(gerente.getId()).toUri();
			return ResponseEntity.created(uri).body(new GerenteDto(gerente));
		} else {
			throw new Exception("Gerente já existe");
		}
	}

	// atualizar
	public ResponseEntity<GerenteDto> atualizar(Long id, GerenteForm gerenteForm) {
		Optional<Gerente> optionalgerente = gerenteRepository.findById(id);
		if (optionalgerente.isPresent()) {
			Gerente gerente = gerenteForm.atualizar(id, gerenteRepository, agenciaRepository);
			return ResponseEntity.ok(new GerenteDto(gerente));
		}
		return ResponseEntity.notFound().build();
	}

	// delete
	public ResponseEntity<?> removerGerente(Long id) {
		Optional<Gerente> optinalGerente = gerenteRepository.findById(id);
		if (optinalGerente.isPresent()) {
			gerenteRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}
