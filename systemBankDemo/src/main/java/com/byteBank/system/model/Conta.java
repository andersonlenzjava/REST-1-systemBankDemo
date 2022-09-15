package com.byteBank.system.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long numero;
	private BigDecimal saldo = BigDecimal.ZERO;
	private TipoConta tipoConta = TipoConta.CORRENTE;
	
	@ManyToOne
	private Agencia agencia;
	
	@ManyToOne
	private Gerente gerente;
	
	@ManyToOne
	private Cliente cliente;
	
	public Conta(Long numero, BigDecimal saldo, TipoConta tipoConta, Agencia agencia, 
			Gerente gerente, Cliente cliente) {	
		this.numero = numero;
		this.saldo = saldo;
		this.tipoConta = tipoConta;
		this.agencia = agencia;
		this.gerente = gerente;
		this.cliente = cliente;
	}
	
	public Conta() {
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
	public TipoConta getTipoConta() {
		return tipoConta;
	}
	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}
	public Agencia getAgencia() {
		return agencia;
	}
	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
	public Gerente getGerente() {
		return gerente;
	}
	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
