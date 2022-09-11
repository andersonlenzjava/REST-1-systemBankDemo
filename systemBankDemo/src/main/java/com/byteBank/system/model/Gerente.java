package com.byteBank.system.model;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Gert")
public class Gerente {

	Pessoa pessoa;
	StatusTrabalho status;
	Agencia agencia;
	
	public Gerente(StatusTrabalho status, Agencia agencia, String nome, String cpf, LocalDate dataNascimento, Integer idade) {
		this.status = status;
		this.agencia = agencia;
		Pessoa pessoa = new Pessoa();
		pessoa.setCpf(cpf);
		pessoa.setDataNascimento(dataNascimento);
		pessoa.setIdade(idade);
		pessoa.setNome(nome);
		this.pessoa = pessoa;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public StatusTrabalho getStatus() {
		return status;
	}
	public void setStatus(StatusTrabalho status) {
		this.status = status;
	}
	public Agencia getAgencia() {
		return agencia;
	}
	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
}
