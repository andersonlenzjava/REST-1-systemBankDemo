package com.byteBank.system.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.byteBank.system.dto.SacarDepositarDto;
import com.byteBank.system.dto.TransferirDto;
import com.byteBank.system.form.SacarDepositarForm;
import com.byteBank.system.form.TransferirForm;
import com.byteBank.system.service.TransacaoService;

@RestController
@RequestMapping("/acaoConta")
public class TransacaoController {

	@Autowired
	private TransacaoService transacaoService;
	
	@PostMapping ("/depositar")
	@Transactional
	public ResponseEntity<SacarDepositarDto> depositar(@RequestBody @Valid SacarDepositarForm sacarDepositarForm, 
			UriComponentsBuilder uriBuilder) throws Exception {
		return transacaoService.depositar(sacarDepositarForm, uriBuilder);
	}
	
	@PostMapping ("/sacar")
	@Transactional
	public ResponseEntity<SacarDepositarDto> sacar(@RequestBody @Valid SacarDepositarForm sacarDepositarForm, 
			UriComponentsBuilder uriBuilder) throws Exception {
		return transacaoService.sacar(sacarDepositarForm, uriBuilder);
	}
	
	@PostMapping ("/transferir")
	@Transactional
	public ResponseEntity<TransferirDto> transferir(@RequestBody @Valid TransferirForm transferirForm, 
			UriComponentsBuilder uriBuilder) throws Exception {
		return transacaoService.transferir(transferirForm, uriBuilder);
	}
}
