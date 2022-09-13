package com.byteBank.system.model;

import java.time.LocalDate;

public class Transacao {

	private Long id;
	private Conta contaOperadora;
	private Conta contaDestino;
	private Long numero;
	private LocalDate dataHoraTransacao;
	
	public Transacao(Conta contaOperadora, Conta contaDestino, Long numero, LocalDate dataHoraTransacao) {
		this.contaOperadora = contaOperadora;
		this.contaDestino = contaDestino;
		this.numero = numero;
		this.dataHoraTransacao = dataHoraTransacao;
	}
	public Transacao() {
	}
	
	public Long getId() {
		return id;
	}
	public Conta getContaOperadora() {
		return contaOperadora;
	}
	public Conta getContaDestino() {
		return contaDestino;
	}
	public Long getNumero() {
		return numero;
	}
	public LocalDate getDataHoraTransacao() {
		return dataHoraTransacao;
	}
}
