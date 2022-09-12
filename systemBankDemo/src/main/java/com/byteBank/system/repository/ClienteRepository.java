package com.byteBank.system.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.byteBank.system.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	Page<Cliente> findByNome(String nomeCliente, Pageable paginacao);

	Optional<Cliente> findByNomeAndCpfAndDataNascimento(String nome, String cpf, LocalDate dataNascimento);

}
