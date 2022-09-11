package com.byteBank.system.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Client")
public class Cliente {

	Pessoa pessoa;
	Conta conta;
	
	public Cliente(Pessoa pessoa, Conta conta) {
		this.pessoa = pessoa;
		this.conta = conta;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}

}
