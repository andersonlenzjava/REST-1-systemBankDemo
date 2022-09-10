package com.byteBank.system.model;

import java.math.BigDecimal;

public class Conta {

	private Long id;
	private Long numero;
	private BigDecimal saldo = BigDecimal.ZERO;
	Cliente cliente;
	Gerente gerente;
	private TipoConta tipoConta = TipoConta.CORRENTE;
	
	public Conta(Long numero, BigDecimal saldo, Cliente cliente, Gerente gerente) {
		this.numero = numero;
		this.saldo = saldo;
		this.cliente = cliente;
		this.gerente = gerente;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Gerente getGerente() {
		return gerente;
	}
	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}
	public TipoConta getTipoConta() {
		return tipoConta;
	}
	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}
	
}
