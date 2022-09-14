package com.byteBank.system.form;

import java.math.BigDecimal;

public class SacarDepositarForm {

	private Long numeroContaTransferir;
	
	private BigDecimal valorTransferir;

	public void setNumeroContaTransferir(Long numeroContaTransferir) {
		this.numeroContaTransferir = numeroContaTransferir;
	}
	public void setValorTransferir(BigDecimal valorTransferir) {
		this.valorTransferir = valorTransferir;
	}
	public Long getNumeroContaTransferir() {
		return numeroContaTransferir;
	}
	public BigDecimal getValorTransferir() {
		return valorTransferir;
	}
	
}
