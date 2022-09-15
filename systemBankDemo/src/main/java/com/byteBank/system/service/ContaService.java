package com.byteBank.system.service;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.byteBank.system.dto.ContaDto;
import com.byteBank.system.form.ContaForm;
import com.byteBank.system.model.Conta;
import com.byteBank.system.repository.AgenciaRepository;
import com.byteBank.system.repository.ClienteRepository;
import com.byteBank.system.repository.ContaRepository;
import com.byteBank.system.repository.GerenteRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private AgenciaRepository agenciaRepository;
	
	@Autowired
	private GerenteRepository gerenteRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
		
	// get
	public Page<ContaDto> listar(Long numeroConta, Pageable paginacao) {
		if (numeroConta == null) {
			Page<Conta> contas = contaRepository.findAll(paginacao);
			return ContaDto.converter(contas);
		} else {
			Page<Conta> contas = contaRepository.findByNumero(numeroConta, paginacao);
			return ContaDto.converter(contas);
		}
	}

	// get id
	public ResponseEntity<ContaDto> detalharPorId(Long id) {
		Optional<Conta> contaOptional = contaRepository.findById(id);
		if (contaOptional.isPresent()) {
			return ResponseEntity.ok(ContaDto.converterUmaConta(contaOptional.get()));
		}
		return ResponseEntity.notFound().build();
	}

	// cadastrar
	public ResponseEntity<ContaDto> cadastrarConta(ContaForm contaForm, UriComponentsBuilder uriBuilder)
			throws Exception {
		Optional<Conta> contaOptional = contaRepository.findByNumero(contaForm.getNumero());
		if (contaOptional.isEmpty()) {
			Conta conta = contaForm.converter(agenciaRepository, gerenteRepository, clienteRepository);
			contaRepository.save(conta);
			URI uri = uriBuilder.path("/conta/{id}").buildAndExpand(conta.getId()).toUri();
			return ResponseEntity.created(uri).body(new ContaDto(conta));
		} else {
			throw new Exception("Conta já existe");
		}
	}

	// atualizar
	public ResponseEntity<ContaDto> atualizar(Long id, ContaForm contaForm) throws Exception {
		Optional<Conta> contaOptional = contaRepository.findById(id);
		if (contaOptional.isPresent()) {
			Conta conta = contaForm.atualizar(contaOptional.get(), agenciaRepository);
			return ResponseEntity.ok(new ContaDto(conta));
		}
		return ResponseEntity.notFound().build();
	}

	// delete
	public ResponseEntity<?> removerCliente(Long id) {
		Optional<Conta> optinalCliente = contaRepository.findById(id);
		if (optinalCliente.isPresent()) {
			contaRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}
