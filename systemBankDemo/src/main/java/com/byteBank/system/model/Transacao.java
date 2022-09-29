package com.byteBank.system.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Transacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Conta contaOperadora;
	
	@ManyToOne
	private Conta contaDestino;
	
	@Enumerated(EnumType.STRING)
	private TipoOperacao tipoOperacao;
	private BigDecimal valor;
	private LocalDate dataTransacao;
	
	public Transacao(Conta contaOperadora, Conta contaDestino, TipoOperacao tipoOperacao, BigDecimal valor, LocalDate dataHoraTransacao) {
		this.contaOperadora = contaOperadora;
		this.contaDestino = contaDestino;
		this.tipoOperacao = tipoOperacao;
		this.valor = valor;
		this.dataTransacao = dataHoraTransacao;
	}
	
	public Transacao() {
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Conta getContaOperadora() {
		return contaOperadora;
	}
	public void setContaOperadora(Conta contaOperadora) {
		this.contaOperadora = contaOperadora;
	}
	public Conta getContaDestino() {
		return contaDestino;
	}
	public void setContaDestino(Conta contaDestino) {
		this.contaDestino = contaDestino;
	}
	public TipoOperacao getTipoOperacao() {
		return tipoOperacao;
	}
	public void setTipoOperacao(TipoOperacao tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public LocalDate getDataHoraTransacao() {
		return dataTransacao;
	}
	public void setDataHoraTransacao(LocalDate dataHoraTransacao) {
		this.dataTransacao = dataHoraTransacao;
	}
}
