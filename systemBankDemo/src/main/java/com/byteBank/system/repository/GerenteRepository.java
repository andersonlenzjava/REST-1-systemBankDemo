package com.byteBank.system.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.byteBank.system.model.Gerente;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente, Long>{

	Page<Gerente> findByNome(String nomeGerente, Pageable paginacao);

	Optional<Gerente> findByNomeAndCpfAndDataNascimento(String nome, String cpf, LocalDate dataNascimento);

}
