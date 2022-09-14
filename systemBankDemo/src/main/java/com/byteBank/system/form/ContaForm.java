package com.byteBank.system.form;

import java.math.BigDecimal;
import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.byteBank.system.model.Agencia;
import com.byteBank.system.model.Conta;
import com.byteBank.system.model.TipoConta;
import com.byteBank.system.repository.AgenciaRepository;
import com.byteBank.system.service.GerenteService;

public class ContaForm {

	private Long numero;
	
	@NotNull
	private BigDecimal saldo;

	private TipoConta tipoConta;

	@NotEmpty
	@NotNull
	@Length(min = 5, max = 5)
	private String agenciaNumero;
	
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
	public String getAgenciaNumero() {
		return agenciaNumero;
	}
	public void setAgenciaNumero(String agenciaNumero) {
		this.agenciaNumero = agenciaNumero;
	}
	
	public Conta converter(AgenciaRepository agenciaRepository) throws Exception {
		Conta conta;
		Optional<Agencia> optionalAgencia = agenciaRepository.findByNumero(agenciaNumero);
		if (optionalAgencia.isPresent()) {
			Agencia agencia = optionalAgencia.get();
			System.out.println(agencia.getNumero());
			conta = new Conta(numero, saldo, tipoConta, agencia);
			return conta;
		} else {
			throw new Exception("Agencia não encontrada");
		}
	}

	public Conta atualizar(Conta conta, AgenciaRepository agenciaRepository) throws Exception {
		Optional<Agencia> optionalAgencia = agenciaRepository.findByNumero(agenciaNumero);
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
