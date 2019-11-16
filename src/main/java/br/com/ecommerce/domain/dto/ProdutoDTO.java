package br.com.ecommerce.domain.dto;

public class ProdutoDTO {

	private String categoria;
	private Long quantidadeProdutos;

	public ProdutoDTO(String categoria, Long quantidadeProdutos) {
		this.categoria = categoria;
		this.quantidadeProdutos = quantidadeProdutos;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Long getQuantidadeProdutos() {
		return quantidadeProdutos;
	}

	public void setQuantidadeProdutos(Long quantidadeProdutos) {
		this.quantidadeProdutos = quantidadeProdutos;
	}

}
