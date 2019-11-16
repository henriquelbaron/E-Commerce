package br.com.ecommerce.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.TypedQuery;

import br.com.ecommerce.domain.Produto;
import br.com.ecommerce.domain.dto.ProdutoDTO;

public class ProdutoDao extends BaseDao<Produto> implements Serializable {
	private static final long serialVersionUID = 1L;

	public ProdutoDao() {
		super(Produto.class);
	}

	public List<Produto> porNome(String nome) {
		return manager.createQuery("from Produto where uper(nome) like :nome", Produto.class)
				.setParameter("nome", nome.toUpperCase() + "%").getResultList();
	}

	public List<ProdutoDTO> buscaProdutosPorCategoria() {
		StringBuilder jpqlBuilder = new StringBuilder();
		jpqlBuilder.append("select new br.com.ecommerce.domain.dto.ProdutoDTO(");
		jpqlBuilder.append("cat.categoria.nome, count(pro)) ");
		jpqlBuilder.append("from Produto pro ");
		jpqlBuilder.append("join pro.categorias cat ");
		jpqlBuilder.append("group by cat.categoria.nome ");

		TypedQuery<ProdutoDTO> query = manager.createQuery(jpqlBuilder.toString(), ProdutoDTO.class);

		List<ProdutoDTO> resultado = query.getResultList();

		return resultado;
	}

	public List<Produto> getProdutoPorNome(String value) {
		TypedQuery<Produto> query = manager.createQuery("from Produto where nome = :nome", Produto.class);
		query.setParameter("nome", value);
		List<Produto> resultado = query.getResultList();

		return resultado;
	}
}
