package br.com.ecommerce.dao;

import java.io.Serializable;

import br.com.ecommerce.domain.Endereco;

public class EnderecoDao extends BaseDao<Endereco> implements Serializable {
	private static final long serialVersionUID = 1L;

	public EnderecoDao() {
		super(Endereco.class);
	}
}
