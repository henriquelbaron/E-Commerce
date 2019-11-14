package br.com.ecommerce.dao;

import java.io.Serializable;

import br.com.ecommerce.domain.Fornecedor;

public class FornecedorDao extends BaseDao<Fornecedor> implements Serializable {
	private static final long serialVersionUID = 1L;

	public FornecedorDao() {
		super(Fornecedor.class);
	}
}
