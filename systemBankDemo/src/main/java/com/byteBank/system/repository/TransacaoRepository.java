package com.byteBank.system.repository;
import java.math.BigDecimal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.byteBank.system.model.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

	@Query("SELECT u FROM Transacao u WHERE u.contaOperadora.numero = :numero "
			+ "OR u.contaDestino.numero = :numero")
	Page<Transacao> findByContaNumero(@Param("numero") Long numero, Pageable paginacao);
	
	@Query("SELECT u FROM Transacao u WHERE u.valor >= :valorTransacao")
	Page<Transacao> findMaiorQue(BigDecimal valorTransacao, Pageable paginacao);

}
