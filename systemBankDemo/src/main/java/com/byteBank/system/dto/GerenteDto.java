package com.byteBank.system.dto;

import java.time.LocalDate;

import org.springframework.data.domain.Page;

import com.byteBank.system.model.Agencia;
import com.byteBank.system.model.Gerente;
import com.byteBank.system.model.StatusTrabalho;

public class GerenteDto {

	private Long id;
	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	StatusTrabalho status;
	private Integer idade;
	Agencia agencia;
	
	public GerenteDto(Gerente gerente) {
		this.id = gerente.getId();
		this.nome = gerente.getNome();
		this.cpf = gerente.getCpf();
		this.dataNascimento = gerente.getDataNascimento();
		this.status = gerente.getStatus();
		this.agencia = gerente.getAgencia();
		this.idade = gerente.getIdade();
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
	public StatusTrabalho getStatus() {
		return status;
	}
	public Integer getIdade() {
		return idade;
	}
	public Long getAgencia() {
		return agencia.getId();
	}

	public static Page<GerenteDto> converter(Page<Gerente> gerentes) {
		return gerentes.map(GerenteDto::new);
	}

	public static GerenteDto converterUmaAgencia(Gerente gerente) {
		return new GerenteDto(gerente);
	}

}
