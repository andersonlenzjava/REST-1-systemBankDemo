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

import com.byteBank.system.dto.ClienteDto;
import com.byteBank.system.dto.GerenteDto;
import com.byteBank.system.form.ClienteForm;
import com.byteBank.system.form.GerenteForm;
import com.byteBank.system.model.Cliente;
import com.byteBank.system.model.Gerente;
import com.byteBank.system.repository.AgenciaRepository;
import com.byteBank.system.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	// get
	public Page<ClienteDto> listar(String nomeCliente, Pageable paginacao) {
		if (nomeCliente == null) {
			Page<Cliente> clientes = clienteRepository.findAll(paginacao);
			return ClienteDto.converter(clientes);
		} else {
			Page<Cliente> clientes = clienteRepository.findByNome(nomeCliente, paginacao);
			return ClienteDto.converter(clientes);
		}
	}

	// get id
	public ResponseEntity<ClienteDto> detalharPorId(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if (cliente.isPresent()) {
			return ResponseEntity.ok(ClienteDto.converterUmCliente(cliente.get()));
		}
		return ResponseEntity.notFound().build();
	}

	// cadastrar
	public ResponseEntity<ClienteDto> cadastrarCliente(@Valid ClienteForm clienteForm, UriComponentsBuilder uriBuilder)
			throws Exception {
		Cliente cliente = clienteForm.converter();
		Optional<Cliente> clienteOptional = clienteRepository.findByNomeAndCpfAndDataNascimento(cliente.getNome(),
				cliente.getCpf(), cliente.getDataNascimento());
		if (clienteOptional.isEmpty()) {
			clienteRepository.save(cliente);
			URI uri = uriBuilder.path("/gerentes/{id}").buildAndExpand(cliente.getId()).toUri();
			return ResponseEntity.created(uri).body(new ClienteDto(cliente));
		} else {
			throw new Exception("Cliente já existe");
		}
	}

	// atualizar
	public ResponseEntity<ClienteDto> atualizar(Long id, ClienteForm clienteForm) {
		Optional<Cliente> clienteOptional = clienteRepository.findById(id);
		if (clienteOptional.isPresent()) {
			Cliente cliente = clienteForm.atualizar(id, clienteRepository);
			return ResponseEntity.ok(new ClienteDto(cliente));
		}
		return ResponseEntity.notFound().build();
	}

	// delete
	public ResponseEntity<?> removerCliente(Long id) {
		Optional<Cliente> optinalCliente = clienteRepository.findById(id);
		if (optinalCliente.isPresent()) {
			clienteRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}
