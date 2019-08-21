package com.andreyalves.projetofullstack.domian;

import javax.persistence.Entity;

import com.andreyalves.projetofullstack.domian.enums.EstadoPagamento;


@Entity
public class PagamentoComCartao extends Pagamento {
	private static final long serialVersionUID = 1L; 


	private Integer numeroDeParcelas;
	
	public PagamentoComCartao() {
		
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcela) {
		super(id, estado, pedido);
		this.numeroDeParcelas = numeroDeParcela;
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	
	
	
}
