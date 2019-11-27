package br.com.ecommerce.bean;

import java.io.Serializable;
import java.util.Locale;
import javax.enterprise.context.SessionScoped;

import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class IdiomaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String idiomaSelecionado;

	public String getIdiomaSelecionado() {
		return idiomaSelecionado;
	}

	public void setIdiomaSelecionado(String idiomaSelecionado) {
		FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(idiomaSelecionado));
	}

}
