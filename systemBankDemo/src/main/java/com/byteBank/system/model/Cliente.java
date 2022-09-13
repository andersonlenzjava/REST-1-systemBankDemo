package com.byteBank.system.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("Client")
public class Cliente extends Pessoa {

	@OneToMany
	private List<Conta> contas = new ArrayList<>();
	
	public Cliente(String nome, String cpf, LocalDate dataNascimento) {
		super (nome, cpf, dataNascimento);
	}
	
	public Cliente() {
	}
	
	public List<Conta> getConta() {
		return contas;
	}
	public void setConta(List<Conta> contas) {
		this.contas = contas;
	}
}
