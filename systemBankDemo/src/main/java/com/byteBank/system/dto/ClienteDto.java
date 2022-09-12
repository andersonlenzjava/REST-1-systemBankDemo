package com.byteBank.system.dto;

import java.time.LocalDate;

import org.springframework.data.domain.Page;

import com.byteBank.system.model.Cliente;
import com.byteBank.system.model.Gerente;
import com.byteBank.system.model.StatusTrabalho;

public class ClienteDto {

	private Long id;
	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	private Integer idade;
	
	public ClienteDto(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.cpf = cliente.getCpf();
		this.dataNascimento = cliente.getDataNascimento();
		this.idade = cliente.getIdade();
	}
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public Integer getIdade() {
		return idade;
	}
	

	public static Page<ClienteDto> converter(Page<Cliente> clientes) {
		return clientes.map(ClienteDto::new);
	}

	public static ClienteDto converterUmCliente(Cliente cliente) {
		return new ClienteDto(cliente);
	}

}
