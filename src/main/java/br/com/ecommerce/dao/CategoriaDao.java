package br.com.ecommerce.dao;

import java.io.Serializable;

import br.com.ecommerce.domain.Categoria;


public class CategoriaDao extends BaseDao<Categoria> implements Serializable {
	private static final long serialVersionUID = 1L;

	public CategoriaDao() {
		super(Categoria.class);
	}
}
