package com.byteBank.system.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.domain.Page;

import com.byteBank.system.model.Conta;
import com.byteBank.system.model.TipoOperacao;
import com.byteBank.system.model.Transacao;

public class TransferirDto {

	private long id; 
	private Long numeroContaTransferir; 
	private Long numeroContaReceber;
	private TipoOperacao tipoOperacao;
	private BigDecimal valor;
	private LocalDate dataHoraTransacao;
	
	public TransferirDto(Conta contaTransferir, Conta contaReceber, TipoOperacao tipoOperacao, BigDecimal valor,
			LocalDate dataHoraTransacao) {
		this.numeroContaTransferir = contaTransferir.getNumero();
		this.numeroContaReceber = contaReceber.getNumero();
		this.tipoOperacao = tipoOperacao;
		this.valor = valor;
		this.dataHoraTransacao = dataHoraTransacao;
	}
	
	public TransferirDto(Transacao transacao) {
		this.id = transacao.getId();
		this.numeroContaTransferir = transacao.getContaOperadora().getNumero();
		this.numeroContaReceber = transacao.getContaDestino().getNumero();
		this.tipoOperacao = transacao.getTipoOperacao();
		this.valor = transacao.getValor();
		this.dataHoraTransacao = transacao.getDataHoraTransacao();
	}
	public long getId() {
		return id;
	}
	public Long getNumeroContaTransferir() {
		return numeroContaTransferir;
	}
	public Long getNumeroContaReceber() {
		return numeroContaReceber;
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
	
	public static Page<TransferirDto> converterTrasacoes(Page<Transacao> transacoes) {
		return transacoes.map(TransferirDto::new);
	}
	
	public static TransferirDto converterUmaTransacao(Transacao transacao) {
		return new TransferirDto(transacao);
	}
}
