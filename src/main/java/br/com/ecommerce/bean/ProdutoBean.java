package br.com.ecommerce.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DualListModel;

import br.com.ecommerce.dao.CategoriaDao;
import br.com.ecommerce.dao.ProdutoDao;
import br.com.ecommerce.domain.Categoria;
import br.com.ecommerce.domain.Produto;

@Named
@ViewScoped
public class ProdutoBean extends CrudBean<Produto, ProdutoDao> {
	private static final long serialVersionUID = 1L;

	@Inject
	private CategoriaDao categoriaDao;
	@Inject
	private ProdutoDao produtoDao;

	private DualListModel<Categoria> categorias;
	private List<Categoria> source;
	private List<Categoria> target;

	@Override
	@PostConstruct
	public void init() {
		source = categoriaDao.buscarTodos();
		target = new ArrayList<Categoria>();
		categorias = new DualListModel<Categoria>(source, target);
		refresh();
	}

	@Override
	public ProdutoDao getDao() {
		return produtoDao;
	}

	@Override
	public Produto newEntidade() {
		return new Produto();
	}

	public void setCategorias(DualListModel<Categoria> categorias) {
		this.categorias = categorias;
	}

	public DualListModel<Categoria> getCategorias() {
		return categorias;
	}

}
