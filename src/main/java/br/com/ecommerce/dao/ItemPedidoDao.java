package br.com.ecommerce.dao;

import java.io.Serializable;

import br.com.ecommerce.domain.ItemPedido;

public class ItemPedidoDao extends BaseDao<ItemPedido> implements Serializable {
	private static final long serialVersionUID = 1L;

	public ItemPedidoDao() {
		super(ItemPedido.class);
	}

}
