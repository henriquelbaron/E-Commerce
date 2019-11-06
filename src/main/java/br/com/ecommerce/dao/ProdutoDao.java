package br.com.ecommerce.dao;

import java.io.Serializable;
import java.util.List;

import br.com.ecommerce.domain.Produto;

public class ProdutoDao extends BaseDao<Produto> implements Serializable {
	private static final long serialVersionUID = 1L;

	public ProdutoDao() {
		super(Produto.class);
	}

	public List<Produto> porNome(String nome) {
		return manager.createQuery("from Produto where uper(nome) like :nome", Produto.class)
				.setParameter("nome", nome.toUpperCase() + "%").getResultList();
	}
}
