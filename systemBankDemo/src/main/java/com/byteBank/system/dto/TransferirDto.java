package com.byteBank.system.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.byteBank.system.model.Conta;
import com.byteBank.system.model.TipoOperacao;

public class TransferirDto {

	private long id; 
	private Conta contaTransferir; 
	private Conta contaReceber;
	private TipoOperacao tipoOperacao;
	private BigDecimal valor;
	private LocalDate dataHoraTransacao;
	
	public TransferirDto(Conta contaTransferir, Conta contaReceber, TipoOperacao tipoOperacao, BigDecimal valor,
			LocalDate dataHoraTransacao) {
		this.contaTransferir = contaTransferir;
		this.contaReceber = contaReceber;
		this.tipoOperacao = tipoOperacao;
		this.valor = valor;
		this.dataHoraTransacao = dataHoraTransacao;
	}

	public long getId() {
		return id;
	}
	public Conta getContaTransferir() {
		return contaTransferir;
	}
	public Conta getContaReceber() {
		return contaReceber;
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
