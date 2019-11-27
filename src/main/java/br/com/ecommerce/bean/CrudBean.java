package br.com.ecommerce.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import br.com.ecommerce.bean.util.MessageUtil;
import br.com.ecommerce.dao.BaseDao;
import br.com.ecommerce.domain.IBaseModel;

@SuppressWarnings("rawtypes")
public abstract class CrudBean<T extends IBaseModel, D extends BaseDao> implements Serializable {
	private static final long serialVersionUID = 1L;

	protected T entidade;
	private List<T> entidades;

	public void novo() {
		entidade = newEntidade();
	}

	@PostConstruct
	public void init() {
		refresh();
	}

	@SuppressWarnings("unchecked")
	public void salvar() {
		try {
			getDao().saveOrUpdate(entidade);
			MessageUtil.info("Salvo com Sucesso!");
		} catch (Exception e) {
			System.out.println(e);
			MessageUtil.error("Erro " + e);
		} finally {
			refresh();
		}
	}

	@SuppressWarnings("unchecked")
	public void delete() {
		try {
			getDao().excluir(entidade);
			MessageUtil.info("Excluido com Sucesso!");
		} catch (Exception e) {
			System.out.println(e);
			MessageUtil.error("Erro " + e);
		} finally {
			refresh();
		}
	}

	@SuppressWarnings("unchecked")
	protected void refresh() {
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
