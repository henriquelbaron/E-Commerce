package br.com.ecommerce.bean;

import java.io.Serializable;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;

import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class IdiomaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String idiomaSelecionado;
	private Locale locale;

	@PostConstruct
	public void init() {
		locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
	}

	public String getIdiomaSelecionado() {
		return idiomaSelecionado;
	}

	public void setIdiomaSelecionado(String idiomaSelecionado) {
		locale = new Locale(idiomaSelecionado);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

}
