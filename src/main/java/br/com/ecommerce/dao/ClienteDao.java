package br.com.ecommerce.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.TypedQuery;

import br.com.ecommerce.dao.filter.ClienteFilter;
import br.com.ecommerce.domain.Cliente;

public class ClienteDao extends BaseDao<Cliente> implements Serializable {
	private static final long serialVersionUID = 1L;

	public ClienteDao() {
		super(Cliente.class);
	}

	public List<Cliente> buscar(ClienteFilter filter) {

		StringBuilder jpqlBuilder = new StringBuilder();
		jpqlBuilder.append("Select c from Cliente c ");
		jpqlBuilder.append("where 1=1 ");

		filter.getFilters().forEach((k, v) -> jpqlBuilder.append(" and p.").append(k).append(" like :").append(k));

		if (filter.getSortField() != null) {
			jpqlBuilder.append("order by ").append(filter.getSortField());
			if (!filter.isSortOrder()) {
				jpqlBuilder.append(" desc");
			}
		}
		TypedQuery<Cliente> query = manager.createQuery(jpqlBuilder.toString(), Cliente.class);

		filter.getFilters().forEach((k, v) -> query.setParameter("%" + k + "%", v));
		query.setFirstResult(filter.getFirst());
		query.setMaxResults(filter.getPageSize());

		return query.getResultList();
	}



	public int count() {
		String jpql = "select count(p) from Pessoa p";
		TypedQuery<Long> query = manager.createQuery(jpql, Long.class);
		return query.getSingleResult().intValue();
	}

}
