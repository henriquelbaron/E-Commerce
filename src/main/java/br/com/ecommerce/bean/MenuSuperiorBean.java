package br.com.ecommerce.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.ecommerce.dao.ProdutoDao;
import br.com.ecommerce.domain.Produto;

@Named
@ViewScoped
public class MenuSuperiorBean extends CrudBean<Produto, ProdutoDao> {
	private static final long serialVersionUID = 1L;

	@Inject
	private ProdutoDao produtoDao;
	private List<Produto> produtos;
	private Produto produto;
	private Produto produtoLinhaEditavel;

	@PostConstruct
	public void init() {
		produtos = produtoDao.buscarTodos();
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

	public List<String> nameSuggestions(String enteredValue) {
		List<String> matches = new ArrayList<>();
		// using data factory for getting suggestions
		for (Produto s : produtos) {
			if (s.getNome().toLowerCase().startsWith(enteredValue.toLowerCase())) {
				matches.add(s.getNome());
			}
		}
		return matches;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Produto getProdutoLinhaEditavel() {
		return produtoLinhaEditavel;
	}

	public void setProdutoLinhaEditavel(Produto produtoLinhaEditavel) {
		this.produtoLinhaEditavel = produtoLinhaEditavel;
	}

}
