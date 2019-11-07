package br.com.ecommerce.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DualListModel;

import br.com.ecommerce.bean.util.MessageUtil;
import br.com.ecommerce.bean.util.UploadArquivo;
import br.com.ecommerce.dao.CategoriaDao;
import br.com.ecommerce.dao.ProdutoDao;
import br.com.ecommerce.domain.Categoria;
import br.com.ecommerce.domain.Produto;
import br.com.ecommerce.domain.ProdutoCategoria;
import br.com.ecommerce.domain.enums.Genero;

@Named
@ViewScoped
public class ProdutoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private CategoriaDao categoriaDao;
	@Inject
	private ProdutoDao produtoDao;
	private List<Produto> produtos;
	private Produto produto;
	private DualListModel<Categoria> categorias;
	private UploadArquivo fileUtil = new UploadArquivo();
	private List<Categoria> source;
	private List<Categoria> target;

	@PostConstruct
	public void init() {
		source = categoriaDao.buscarTodos();
		target = new ArrayList<Categoria>();
		categorias = new DualListModel<Categoria>(source, target);
		refresh();
	}

	public void salvar() {
		try {
			List<ProdutoCategoria> produtoCategorias = new ArrayList<ProdutoCategoria>();
			for (Categoria categoria : categorias.getTarget()) {
				ProdutoCategoria pc = new ProdutoCategoria();
				pc.setCategoria(categoria);
				pc.setProduto(produto);
				produtoCategorias.add(pc);
			}
			produto.setCategorias(produtoCategorias);
			produtoDao.saveOrUpdate(produto);
			fileUtil.gravar();
			refresh();
			MessageUtil.info("Salvo com Sucesso!");
		} catch (Exception e) {
			MessageUtil.error("Erro Inesperado " + e);
		}
	}

	public void delete() {
		try {
			produtoDao.excluir(produto);
			MessageUtil.info("Excluido com Sucesso!");
			refresh();
		} catch (Exception e) {
			MessageUtil.error("Erro Inesperado" + e);
		}
	}

	public void refresh() {
		produto = new Produto();
		produtos = produtoDao.buscarTodos();
	}

	public void uploadAction(FileUploadEvent event) {
		fileUtil.fileUpload(event, ".jpg", "/images/");
		produto.setImagem(this.fileUtil.getNome());
	}

	public Genero[] getGeneros() {
		return Genero.values();
	}

	public Produto getProduto() {
		return produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void setCategorias(DualListModel<Categoria> categorias) {
		this.categorias = categorias;
	}

	public DualListModel<Categoria> getCategorias() {
		return categorias;
	}

}
