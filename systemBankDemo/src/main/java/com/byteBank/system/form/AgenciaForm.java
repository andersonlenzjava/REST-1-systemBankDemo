package com.byteBank.system.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

import com.byteBank.system.model.Agencia;

public class AgenciaForm {
	
	@NotNull @NotEmpty @Length(min = 5, max = 5)
	public String numero;
	
	@NotNull @NotEmpty
	public String nome;
	
	@NotNull @NotEmpty
	public String rua;
	
	@NotNull @NotEmpty @Length(min = 5, max = 8)
	public String cep;
	
	@Positive 
	@NotNull
	public Long numeroPredio;
	
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
	public String getNumero() {
		return numero;
	}
	public String getNome() {
		return nome;
	}
	public String getRua() {
		return rua;
	}
	public String getCep() {
		return cep;
	}
	public Long getNumeroPredio() {
		return numeroPredio;
	}
	public Agencia converter() {
		Agencia agencia = new Agencia(numero, nome, rua, cep, numeroPredio);			
		return agencia;
	}
	
	
	
}
