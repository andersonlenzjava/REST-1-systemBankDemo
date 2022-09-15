package com.byteBank.system.model;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TIPO")
public abstract class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	private Integer idade;
	
	public Pessoa(String nome, String cpf, LocalDate dataNascimento) {
		System.out.println("MARCADOR " + dataNascimento);
		this.idade = calculaIdade(dataNascimento);
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		System.out.println("MARCADOR");
	}

	public Pessoa() {
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Integer getIdade() {
		return calculaIdade(this.dataNascimento);
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Integer calculaIdade(LocalDate dataNascimento) {
		Period idade = Period.between(dataNascimento, LocalDate.now());
		return Integer.valueOf(idade.getYears());
	}
}
