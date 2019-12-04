package br.com.ecommerce.domain.dto;

public class FornecedorDTO {

	private String fornecedor;
	private Long quantidadeProdutos;

	public FornecedorDTO(String fornecedor, Long quantidadeProdutos) {
		this.fornecedor = fornecedor;
		this.quantidadeProdutos = quantidadeProdutos;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Long getQuantidadeProdutos() {
		return quantidadeProdutos;
	}

	public void setQuantidadeProdutos(Long quantidadeProdutos) {
		this.quantidadeProdutos = quantidadeProdutos;
	}

}
