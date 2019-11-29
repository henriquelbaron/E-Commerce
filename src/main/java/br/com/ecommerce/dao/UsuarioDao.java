package br.com.ecommerce.dao;

import java.io.Serializable;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.ecommerce.domain.Usuario;

public class UsuarioDao extends BaseDao<Usuario> implements Serializable {
	private static final long serialVersionUID = 1L;

	public UsuarioDao() {
		super(Usuario.class);
	}

	public Usuario verificaLogin(String email, String senha) {
		String jpql = "select u from Usuario u where login = :login and senha  = :senha";

		TypedQuery<Usuario> query = manager.createQuery(jpql, Usuario.class);

		query.setParameter("login", email);
		query.setParameter("senha", senha);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public boolean isUniqueLogin(String email) {
		String jpql = "Select u from Usuario where login = :login";
		TypedQuery<Usuario> query = manager.createQuery(jpql, Usuario.class);
		query.setParameter("login", email);
		try {
			query.getFirstResult();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
