package com.byteBank.system.form;

import java.math.BigDecimal;
import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.byteBank.system.model.Agencia;
import com.byteBank.system.model.Cliente;
import com.byteBank.system.model.Conta;
import com.byteBank.system.model.Gerente;
import com.byteBank.system.model.TipoConta;
import com.byteBank.system.repository.AgenciaRepository;
import com.byteBank.system.repository.ClienteRepository;
import com.byteBank.system.repository.GerenteRepository;

public class ContaForm {

	private Long numero;
	
	@NotNull
	private BigDecimal saldo;

	private TipoConta tipoConta;

	@NotEmpty
	@NotNull
	@Length(min = 5, max = 5)
	private String agenciaNumero;
	
	@NotEmpty
	@NotNull
	private String cpfGerente;

	@NotEmpty
	@NotNull
	private String cpfCliente;
	
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
	public String getCpfCliente() {
		return cpfCliente;
	}
	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
	public String getCpfGerente() {
		return cpfGerente;
	}
	public void setCpfGerente(String cpfGerente) {
		this.cpfGerente = cpfGerente;
	}
	
	public Conta converter(AgenciaRepository agenciaRepository, 
			GerenteRepository gerenteRepository, ClienteRepository clienteRepository) throws Exception {
		Optional<Agencia> optionalAgencia = agenciaRepository.findByNumero(agenciaNumero);
		Optional<Gerente> optionalGerente = gerenteRepository.findByCpf(cpfGerente);
		Optional<Cliente> optionalCliente = clienteRepository.findByCpf(cpfCliente);
		
		if (optionalAgencia.isPresent() && optionalGerente.isPresent() && optionalCliente.isPresent()) {
			Agencia agencia = optionalAgencia.get();
			Gerente gerente = optionalGerente.get();
			Cliente cliente = optionalCliente.get();
			return new Conta(numero, saldo, tipoConta, agencia, gerente, cliente);
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
