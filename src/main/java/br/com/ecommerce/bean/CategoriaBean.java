package br.com.ecommerce.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.ecommerce.dao.CategoriaDao;
import br.com.ecommerce.domain.Categoria;

@Named
@ViewScoped
public class CategoriaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private CategoriaDao categoriaDao;
	private List<Categoria> categorias;
	private Categoria categoria;

	@PostConstruct
	public void init() {
		categorias = categoriaDao.buscarTodos();
		categoria = new Categoria();
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
