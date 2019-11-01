package br.com.ecommerce.bean;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.ecommerce.dao.ProdutoDao;
import br.com.ecommerce.domain.Produto;

@Named
@ViewScoped
public class RoupaBean extends CrudBean<Produto, ProdutoDao> {
	private static final long serialVersionUID = 1L;

	@Inject
	private ProdutoDao produtoDao;

	@Override
	public ProdutoDao getDao() {
		return produtoDao;
	}

	@Override
	public Produto newEntidade() {
		return new Produto();
	}

}
