package com.byteBank.system.form;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.byteBank.system.model.Cliente;
import com.byteBank.system.repository.ClienteRepository;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ClienteForm {

	@NotNull
	@NotEmpty
	@Length(min = 5, max = 80)
	private String nome;

	@NotNull
	@NotEmpty
	@Length(min = 9, max = 9)
	private String cpf;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Cliente converter() {
		return new Cliente(nome, cpf, dataNascimento);
	}

	public Cliente atualizar(Cliente cliente, ClienteRepository clienteRepository) {
		cliente.setNome(nome);
		cliente.setCpf(cpf);
		cliente.setDataNascimento(dataNascimento);
		clienteRepository.save(cliente);
		return cliente;
	}
}
