package com.byteBank.system.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.byteBank.system.model.Conta;
import com.byteBank.system.model.TipoOperacao;

public class SacarDepositarDto {

	private long id; 
	private Conta contaOperacao; 
	private TipoOperacao tipoOperacao;
	private BigDecimal valor;
	private LocalDate dataHoraTransacao;
	
	public SacarDepositarDto(Conta contaOperacao, TipoOperacao tipoOperacao, BigDecimal valor,
			LocalDate dataHoraTransacao) {
		this.contaOperacao = contaOperacao;
		this.tipoOperacao = tipoOperacao;
		this.valor = valor;
		this.dataHoraTransacao = dataHoraTransacao;
	}

	public long getId() {
		return id;
	}
	public Conta getContaOperacao() {
		return contaOperacao;
	}
	public TipoOperacao getTipoOperacao() {
		return tipoOperacao;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public LocalDate getDataHoraTransacao() {
		return dataHoraTransacao;
	}
}
