package br.com.ecommerce.dao;

import java.io.Serializable;

import br.com.ecommerce.domain.Cliente;

public class ClienteDao extends BaseDao<Cliente> implements Serializable {
	private static final long serialVersionUID = 1L;

	public ClienteDao() {
		super(Cliente.class);
	}
}
