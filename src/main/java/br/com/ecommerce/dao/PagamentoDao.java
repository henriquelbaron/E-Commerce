package br.com.ecommerce.dao;

import java.io.Serializable;

import br.com.ecommerce.domain.Pagamento;

public class PagamentoDao extends BaseDao<Pagamento> implements Serializable {
	private static final long serialVersionUID = 1L;

	public PagamentoDao() {
		super(Pagamento.class);
	}
}
