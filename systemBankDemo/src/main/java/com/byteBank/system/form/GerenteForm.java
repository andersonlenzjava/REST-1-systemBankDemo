package com.byteBank.system.form;

import java.time.LocalDate;
import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.byteBank.system.model.Agencia;
import com.byteBank.system.model.Gerente;
import com.byteBank.system.repository.AgenciaRepository;
import com.byteBank.system.repository.GerenteRepository;
import com.fasterxml.jackson.annotation.JsonFormat;

public class GerenteForm {

	@NotNull
	@NotEmpty
	@Length(min = 5, max = 80)
	private String nome;

	@NotNull
	@NotEmpty
	@Length(min = 9, max = 9)
	private String cpf;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;

	@NotNull
	@NotEmpty
	private String agenciaNumero;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setAgenciaNumero(String agenciaNumero) {
		this.agenciaNumero = agenciaNumero;
	}

	public Gerente converter(AgenciaRepository agenciaRepository) {
		Optional<Agencia> agenciaOptional = agenciaRepository.findByNumero(this.agenciaNumero);
		Agencia agencia = null;
		Gerente gerente = null;
		if (agenciaOptional.isPresent()) {
			agencia = agenciaOptional.get();
			gerente = new Gerente(agencia, nome, cpf, dataNascimento);
			return gerente;
		} else {
			return gerente;
		}
	}

	public Gerente atualizar(Long id, GerenteRepository gerenteRepository, AgenciaRepository agenciaRepository) {
		Gerente gerente = gerenteRepository.getReferenceById(id);

		gerente.setNome(nome);
		gerente.setCpf(cpf);
		gerente.setDataNascimento(dataNascimento);

		Optional<Agencia> optionalAgencia = agenciaRepository.findByNumero(agenciaNumero);
		if (optionalAgencia.isPresent()) {
			Agencia agencia = optionalAgencia.get();
			gerente.setAgencia(agencia);
		} else {
			gerente = null;
		}
		return gerente;
	}
}
