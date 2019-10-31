package br.com.ecommerce.bean;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.ecommerce.dao.CategoriaDao;
import br.com.ecommerce.domain.Categoria;

@Named
@ViewScoped
public class CategoriaBean extends CrudBean<Categoria, CategoriaDao> {
	private static final long serialVersionUID = 1L;

	@Inject
	private CategoriaDao categoriaDao;

	@Override
	public CategoriaDao getDao() {
		return categoriaDao;
	}

	@Override
	public Categoria newEntidade() {
		return new Categoria();
	}

}
