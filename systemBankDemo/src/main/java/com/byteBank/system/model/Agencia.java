package com.byteBank.system.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Agencia {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	public String numero;
	public String nome;
	public String rua;
	public String cep;
	public Long numeroPredio;
	
	public Agencia(String numero, String nome, String rua, String cep, Long numeroPredio) {
		this.numero = numero;
		this.rua = rua;
		this.nome = nome;
		this.cep = cep;
		this.numeroPredio = numeroPredio;
	}
	
	public Agencia() {
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Long getNumeroPredio() {
		return numeroPredio;
	}
	public void setNumeroPredio(Long numeroPredio) {
		this.numeroPredio = numeroPredio;
	}
}
