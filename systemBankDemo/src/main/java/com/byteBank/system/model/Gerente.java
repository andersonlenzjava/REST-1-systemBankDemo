package com.byteBank.system.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("Gert")
public class Gerente extends Pessoa {

	@Enumerated(EnumType.STRING)
	StatusTrabalho status = StatusTrabalho.TRABALHANDO;
	@ManyToOne
	Agencia agencia;
	
	@OneToMany
	List<Conta> contas = new ArrayList<>();
	
	public Gerente(Agencia agencia, String nome, String cpf, LocalDate dataNascimento) {
		super (nome, cpf, dataNascimento);
		this.agencia = agencia;
	}
	
	public Gerente() {
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
	public List<Conta> getContas() {
		return contas;
	}
	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}
}
