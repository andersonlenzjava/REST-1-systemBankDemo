package com.byteBank.system.form;

import java.math.BigDecimal;
import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.byteBank.system.model.Agencia;
import com.byteBank.system.model.Conta;
import com.byteBank.system.model.TipoConta;
import com.byteBank.system.repository.AgenciaRepository;

public class ContaForm {

	private Long numero;

	private BigDecimal saldo;

	private TipoConta tipoConta;

	@NotNull
	@NotEmpty
	private String agenciaNome;

	private String agenciaNumero;

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

	public void setAgenciaNome(String agenciaNome) {
		this.agenciaNome = agenciaNome;
	}

	public void setAgenciaNumero(String agenciaNumero) {
		this.agenciaNumero = agenciaNumero;
	}

	public Conta converter(AgenciaRepository agenciaRepository) throws Exception {
		Optional<Agencia> optionalAgencia = agenciaRepository.findByNumeroOrNome(agenciaNome, agenciaNumero);
		Conta conta;
		if (optionalAgencia.isPresent()) {
			Agencia agencia = optionalAgencia.get();
			conta = new Conta(numero, tipoConta, saldo, agencia);
			return conta;
		} else {
			throw new Exception("Agencia não encontrado");
		}
	}

	public Conta atualizar(Conta conta, AgenciaRepository agenciaRepository) throws Exception {
		Optional<Agencia> optionalAgencia = agenciaRepository.findByNumeroOrNome(agenciaNome, agenciaNumero);
		if (optionalAgencia.isPresent()) {
			Agencia agencia = optionalAgencia.get();
			conta.setNumero(numero);
			conta.setSaldo(saldo);
			conta.setTipoConta(tipoConta);
			conta.setAgencia(agencia);
			return conta;
		} else {
			throw new Exception("Agencia inesistente!");
		}
	}
}
