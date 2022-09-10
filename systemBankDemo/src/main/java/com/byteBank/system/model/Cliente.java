package com.byteBank.system.model;

public class Cliente {

	private Long id;
	Pessoa pessoa;
	Conta conta;
	
	public Cliente(Pessoa pessoa, Conta conta) {
		this.pessoa = pessoa;
		this.conta = conta;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
