package br.com.ecommerce.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.TypedQuery;

import br.com.ecommerce.domain.Fornecedor;

public class FornecedorDao extends BaseDao<Fornecedor> implements Serializable {
	private static final long serialVersionUID = 1L;

	public FornecedorDao() {
		super(Fornecedor.class);
	}

	public List<Fornecedor> getFornecedorPorNome(String value) {
		TypedQuery<Fornecedor> query = manager.createQuery("from Fornecedor where nome = :nome", Fornecedor.class);
		query.setParameter("nome", value);
		List<Fornecedor> resultado = query.getResultList();

		return resultado;
	}

	
}
