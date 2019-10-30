package br.com.ecommerce.dao;

import java.io.Serializable;

import br.com.ecommerce.domain.Pedido;

public class PedidoDao extends BaseDao<Pedido> implements Serializable {
	private static final long serialVersionUID = 1L;

	public PedidoDao() {
		super(Pedido.class);
	}
}
