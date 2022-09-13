package com.byteBank.system.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.byteBank.system.model.Agencia;

@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Long>{

	Page<Agencia> findByNome(String nomeAgencia, Pageable paginacao);

	Optional<Agencia> findByNomeAndNumeroAndNumeroPredio(String nome, String numero, Long numeroPredio);

	Optional<Agencia> findByNumero(String agenciaNumero);

	Optional<Agencia> findByNumeroOrNome(String agenciaNome, String agenciaNumero);


}
