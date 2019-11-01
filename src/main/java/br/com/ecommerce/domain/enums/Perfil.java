package br.com.ecommerce.domain.enums;

public enum Perfil {
	ADMIN(1, "ROLE_ADMIN"), CLIENTE(2, "ROLE_CLIENTE");

	private int id;
	private String descricao;

	private Perfil(int cod, String descricao) {
		this.id = cod;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Perfil toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (Perfil x : Perfil.values()) {
			if (cod.equals(x.getId())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id Inválido  " + cod);
	}
}
