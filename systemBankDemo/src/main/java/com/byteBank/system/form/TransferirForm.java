package com.byteBank.system.form;

import java.math.BigDecimal;

public class TransferirForm {

	private Long numeroContaTransferir;
	
	private Long numeroContaReceber;
	
	private BigDecimal valorTransferir;

	public void setNumeroContaTransferir(Long numeroContaTransferir) {
		this.numeroContaTransferir = numeroContaTransferir;
	}
	public void setNumeroContaReceber(Long numeroContaReceber) {
		this.numeroContaReceber = numeroContaReceber;
	}
	public void setValorTransferir(BigDecimal valorTransferir) {
		this.valorTransferir = valorTransferir;
	}
	public Long getNumeroContaTransferir() {
		return numeroContaTransferir;
	}
	public Long getNumeroContaReceber() {
		return numeroContaReceber;
	}
	public BigDecimal getValorTransferir() {
		return valorTransferir;
	}
	
}
