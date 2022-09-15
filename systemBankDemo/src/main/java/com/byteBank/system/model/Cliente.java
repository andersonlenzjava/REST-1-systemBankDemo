package com.byteBank.system.model;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Client")
public class Cliente extends Pessoa {

	public Cliente(String nome, String cpf, LocalDate dataNascimento) {
		super (nome, cpf, dataNascimento);
	}
	
	public Cliente() {
	}
	
}
