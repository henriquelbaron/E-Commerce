package br.com.ecommerce.dao;

import java.io.Serializable;

import br.com.ecommerce.domain.Produto;

public class ProdutoDao extends BaseDao<Produto> implements Serializable {
	private static final long serialVersionUID = 1L;

	public ProdutoDao() {
		super(Produto.class);
	}

}
