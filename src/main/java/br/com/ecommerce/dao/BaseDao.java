package br.com.ecommerce.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.ecommerce.domain.IBaseModel;

public abstract class BaseDao<T extends IBaseModel> implements IBaseDao<T> {

	@Inject
	protected EntityManager manager;

	private Class<T> persistenceClass;

	public BaseDao(Class<T> persistenceClass) {
		this.persistenceClass = persistenceClass;
	}

	@Override
	public void saveOrUpdate(T model) {
		if (model.getId() == null) {
			salvar(model);
		} else {
			alterar(model);
		}
	}

	@Override
	public void salvar(T model) {
		manager.getTransaction().begin();
		manager.persist(model);
		manager.getTransaction().commit();
	}

	@Override
	public void alterar(T model) {
		manager.getTransaction().begin();
		manager.merge(model);
		manager.getTransaction().commit();
	}

	@Override
	public void excluir(T model) {
		manager.getTransaction().begin();
		manager.remove(manager.find(model.getClass(), model.getId()));
		manager.getTransaction().commit();
	}

	@Override
	public T buscarPorID(Long id) {
		T resultado = manager.find(persistenceClass, id);
		return resultado;
	}

	@Override
	public List<T> buscarTodos() {
		TypedQuery<T> query = manager.createQuery("from " + persistenceClass.getName(), persistenceClass);

		List<T> resultado = query.getResultList();

		return resultado;
	}

}
