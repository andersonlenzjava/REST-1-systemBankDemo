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
	private Agencia agencia;

	public ContaDto(Conta conta) {
		this.id = conta.getId();
		this.numero = conta.getNumero();
		this.saldo = conta.getSaldo();
		this.tipoConta = conta.getTipoConta();
		this.agencia = conta.getAgencia();
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
	
	public String getAgencia() {
		return agencia.getNumero();
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public static Page<ContaDto> converter(Page<Conta> contas) {
		return contas.map(ContaDto::new);
	}

	public static ContaDto converterUmaConta(Conta conta) {
		return new ContaDto(conta);
	}
}
