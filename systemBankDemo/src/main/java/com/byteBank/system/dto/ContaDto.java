package com.byteBank.system.dto;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;

import com.byteBank.system.model.Agencia;
import com.byteBank.system.model.Conta;
import com.byteBank.system.model.TipoConta;

public class ContaDto {

	private Long id;
	private Long numero;
	private BigDecimal saldo;
	private TipoConta tipoConta;
	private String numeroAgencia;
	private String nomeGerente;
	private String nomeCliente;

	public ContaDto(Conta conta) {
		this.id = conta.getId();
		this.numero = conta.getNumero();
		this.saldo = conta.getSaldo();
		this.tipoConta = conta.getTipoConta();
		this.numeroAgencia = conta.getAgencia().getNumero();
		this.nomeGerente = conta.getGerente().getNome();
		this.numeroAgencia = conta.getCliente().getNome();
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
	public String getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(String numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}
	public String getNomeGerente() {
		return nomeGerente;
	}
	public void setNomeGerente(String nomeGerente) {
		this.nomeGerente = nomeGerente;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public static Page<ContaDto> converter(Page<Conta> contas) {
		return contas.map(ContaDto::new);
	}
	public static ContaDto converterUmaConta(Conta conta) {
		return new ContaDto(conta);
	}
}
