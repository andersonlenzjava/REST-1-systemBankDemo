package com.byteBank.system.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.byteBank.system.dto.SacarDepositarDto;
import com.byteBank.system.dto.TransferirDto;
import com.byteBank.system.form.SacarDepositarForm;
import com.byteBank.system.form.TransferirForm;
import com.byteBank.system.model.Conta;
import com.byteBank.system.model.TipoOperacao;
import com.byteBank.system.model.Transacao;
import com.byteBank.system.repository.ContaRepository;
import com.byteBank.system.repository.TransacaoRepository;

@Service
public class TransacaoService {

	@Autowired
	private ContaRepository contaRepository;

	@Autowired
	private TransacaoRepository transacaoRepository;

	public ResponseEntity<SacarDepositarDto> depositar(SacarDepositarForm sacarDepositarForm,
			UriComponentsBuilder uriBuilder) throws Exception {
		Optional<Conta> contaOperacao = contaRepository.findByNumero(sacarDepositarForm.getNumeroContaTransferir());
		if (contaOperacao.isPresent()) {
			Conta conta = contaOperacao.get();
			conta.setSaldo(conta.getSaldo().add(sacarDepositarForm.getValorTransferir()));
			contaRepository.save(conta);
			salvarTransferencia(conta, conta, TipoOperacao.DEPOSITAR, sacarDepositarForm.getValorTransferir());
			return ResponseEntity.ok(new SacarDepositarDto(conta, TipoOperacao.DEPOSITAR,
					sacarDepositarForm.getValorTransferir(), LocalDate.now()));
		} else {
			throw new Exception("Conta inestitente!");
		}
	}

	public ResponseEntity<SacarDepositarDto> sacar(SacarDepositarForm sacarDepositarForm,
			UriComponentsBuilder uriBuilder) throws Exception {
		Optional<Conta> contaOperacao = contaRepository.findByNumero(sacarDepositarForm.getNumeroContaTransferir());
		if (contaOperacao.isPresent()) {
			Conta conta = contaOperacao.get();
			System.out.println(sacarDepositarForm.getValorTransferir().compareTo(conta.getSaldo()));
			if (((sacarDepositarForm.getValorTransferir().compareTo(conta.getSaldo())) < 0)) {
				conta.setSaldo(conta.getSaldo().subtract(sacarDepositarForm.getValorTransferir()));
				contaRepository.save(conta);
				salvarTransferencia(conta, conta, TipoOperacao.SACAR, sacarDepositarForm.getValorTransferir());
				return ResponseEntity.ok(new SacarDepositarDto(conta, TipoOperacao.SACAR,
						sacarDepositarForm.getValorTransferir(), LocalDate.now()));
			} else {
				throw new Exception("Saldo insuficiente!");
			}
		} else {
			throw new Exception("Conta inestitente!");
		}
	}

	public ResponseEntity<TransferirDto> transferir(TransferirForm transferirForm,
			UriComponentsBuilder uriBuilder) throws Exception {
		Optional<Conta> contaOptionalTransferir = contaRepository.findByNumero(transferirForm.getNumeroContaTransferir());
		Optional<Conta> contaOptionalReceber = contaRepository.findByNumero(transferirForm.getNumeroContaReceber());
		if (contaOptionalTransferir.isPresent()) {
			if (contaOptionalReceber.isPresent()) {
				Conta contaTransferir = contaOptionalTransferir.get();
				Conta contaReceber = contaOptionalReceber.get();
				if (((transferirForm.getValorTransferir().compareTo(contaTransferir.getSaldo())) < 0)) {
					contaTransferir.setSaldo(contaTransferir.getSaldo().subtract(transferirForm.getValorTransferir()));
					contaReceber.setSaldo(contaReceber.getSaldo().add(transferirForm.getValorTransferir()));
					contaRepository.save(contaTransferir);
					contaRepository.save(contaReceber);
					salvarTransferencia(contaTransferir, contaReceber, TipoOperacao.TRANSFERIR,
							transferirForm.getValorTransferir());
					return ResponseEntity.ok(new TransferirDto(contaTransferir, contaReceber, TipoOperacao.TRANSFERIR,
							transferirForm.getValorTransferir(), LocalDate.now()));
				} else {
					throw new Exception("Saldo insuficiente!");
				}
			} else {
				throw new Exception("Conta a receber inestitente!");
			}
		} else {
			throw new Exception("Conta a transferir inestitente!");
		}
	}

	public void salvarTransferencia(Conta contaOperadora, Conta contaDestino, TipoOperacao tipoOperacao,
			BigDecimal valor) {
		Transacao transacao = new Transacao(contaOperadora, contaDestino, tipoOperacao, valor, LocalDate.now());
		transacaoRepository.save(transacao);
	}

}
