package br.com.ecommerce.dao;

import java.util.List;

import br.com.ecommerce.domain.IBaseModel;

public interface IBaseDao<T extends IBaseModel> {

	void saveOrUpdate(T model);

	void salvar(T model);

	void alterar(T model);

	void excluir(T model);

	T buscarPorID(Long id);

	List<T> buscarTodos();

}
