package br.com.ecommerce.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import br.com.ecommerce.bean.util.MessageUtil;
import br.com.ecommerce.dao.BaseDao;
import br.com.ecommerce.domain.IBaseModel;

public abstract class CrudBean<T extends IBaseModel, D extends BaseDao> implements Serializable {
	private static final long serialVersionUID = 1L;

	private T entidade;
	private List<T> entidades;

	public void novo() {
		entidade = newEntidade();
	}

	@PostConstruct
	public void init() {
		refresh();
	}

	public void salvar() {
		try {
			getDao().saveOrUpdate(entidade);
			MessageUtil.info("Salvo com Sucesso!");
			refresh();
		} catch (Exception e) {
			MessageUtil.error("Erro Inesperado " + e);
		}
	}

	public void delete() {
		try {
			getDao().excluir(entidade);
			MessageUtil.info("Excluido com Sucesso!");
			refresh();
		} catch (Exception e) {
			MessageUtil.error("Erro Inesperado" + e);
		}
	}

	private void refresh() {
		entidade = newEntidade();
		entidades = getDao().buscarTodos();
	}

	public T getEntidade() {
		return entidade;
	}

	public void setEntidade(T entidade) {
		this.entidade = entidade;
	}

	public List<T> getEntidades() {
		return entidades;
	}

	public void setEntidades(List<T> entidades) {
		this.entidades = entidades;
	}

	public abstract D getDao();

	public abstract T newEntidade();
}
