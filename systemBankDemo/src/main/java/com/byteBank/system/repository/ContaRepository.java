package com.byteBank.system.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.byteBank.system.model.Cliente;
import com.byteBank.system.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

	Page<Conta> findByNumero(Long numeroConta, Pageable paginacao);

	Optional<Conta> findByNumero(Long numero);

	List<Conta> findByCliente(Cliente cliente);

}
