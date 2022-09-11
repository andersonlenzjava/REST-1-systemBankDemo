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
import com.byteBank.system.form.AgenciaForm;
import com.byteBank.system.model.Agencia;
import com.byteBank.system.repository.AgenciaRepository;

@Service
public class AgenciaService {

	@Autowired
	private AgenciaRepository agenciaRepository;
	
	//get
	public Page<AgenciaDto> listar(String nomeAgencia, Pageable paginacao) {
		
		if (nomeAgencia == null) {
			Page<Agencia> agencias = agenciaRepository.findAll(paginacao);
			return AgenciaDto.converter(agencias);
		} else {
			Page<Agencia> agencias = agenciaRepository.findByNome(nomeAgencia, paginacao);
			return AgenciaDto.converter(agencias);
		}
	}
	
	//get id
	public ResponseEntity<AgenciaDto> detalharPorId(Long id) {
		Optional<Agencia> agencia = agenciaRepository.findById(id);
		if (agencia.isPresent()) {
			return ResponseEntity.ok(AgenciaDto.converterUmaAgencia(agencia.get()));
		}
		return ResponseEntity.notFound().build();
	}

	//cadastrar
	public ResponseEntity<AgenciaDto> cadastrarAgencia(@Valid AgenciaForm agenciaForm,
			UriComponentsBuilder uriBuilder) throws Exception {
		Agencia agencia = agenciaForm.converter();
		Optional<Agencia> agenciaOptional = agenciaRepository.findByNomeAndNumeroAndNumeroPredio(agencia.getNome(),
				agencia.getNumero(), agencia.getNumeroPredio());
		if (agenciaOptional.isEmpty()) {
			agenciaRepository.save(agencia);
			URI uri = uriBuilder.path("/agencias/{id}").buildAndExpand(agencia.getId()).toUri();
			return ResponseEntity.created(uri).body(new AgenciaDto(agencia));
		} else {
			throw new Exception("Agencia já existe");
		}
	}

	//deletar 
	public ResponseEntity<?> removerAgencia(Long id) {
		Optional<Agencia> optinalAgencia = agenciaRepository.findById(id);
		if (optinalAgencia.isPresent()) {
			agenciaRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
