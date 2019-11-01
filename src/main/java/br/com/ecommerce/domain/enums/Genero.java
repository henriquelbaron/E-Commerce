package br.com.ecommerce.domain.enums;

public enum Genero {
	MASCULINO(1, "Masculino"), 
	FEMININO(2, "Feminino"); 

	private int id;
	private String descricao;

	private Genero(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private Genero(String label) {
		this.descricao = label;
	}

	public String getDescricao() {
		return descricao;
	}
}
