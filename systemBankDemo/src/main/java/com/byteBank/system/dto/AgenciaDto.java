package com.byteBank.system.dto;

import org.springframework.data.domain.Page;

import com.byteBank.system.model.Agencia;

public class AgenciaDto {

	public Long id;
	public String numero;
	public String nome;
	public String rua;
	public String cep;
	public Long numeroPredio;
	
	
	public AgenciaDto(Agencia agencia) {
		this.id = agencia.getId();
		this.numero = agencia.getNumero();
		this.nome = agencia.getNome();
		this.rua = agencia.getRua();
		this.cep = agencia.getCep();
		this.numeroPredio = agencia.getNumeroPredio();
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public void setNumeroPredio(Long numeroPredio) {
		this.numeroPredio = numeroPredio;
	}

	public static Page<AgenciaDto> converter(Page<Agencia> agencias) {
		return agencias.map(AgenciaDto::new);
	}

	public static AgenciaDto converterUmaAgencia(Agencia agencia) {
		return new AgenciaDto(agencia);
	}
}
