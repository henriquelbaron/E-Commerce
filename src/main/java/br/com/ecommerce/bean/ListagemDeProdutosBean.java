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
public class ListagemDeProdutosBean extends CrudBean<Produto, ProdutoDao> {
	private static final long serialVersionUID = 1L;

	@Inject
	private ProdutoDao produtoDao;
	private List<Produto> produtos;
	private Produto produto;
	public static String nomeDeBusca;

	@PostConstruct
	public void init() {
		produtos = nomeDeBusca == null ? produtoDao.buscarTodos() : produtoDao.getProdutoPorNome(nomeDeBusca);
		nomeDeBusca = null;
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
		ListagemDeProdutosBean.nomeDeBusca = enteredValue;
		List<String> matches = new ArrayList<>();
		produtos = produtoDao.getProdutoPorNome(enteredValue);
		produtos.forEach(p -> matches.add(p.getNome()));
//		produtos.stream().filter(p -> p.getNome().toLowerCase().contains(enteredValue.toLowerCase()))
//				.forEach(p -> matches.add(p.getNome()));
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

}
