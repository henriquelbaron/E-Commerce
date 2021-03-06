package br.com.ecommerce.bean.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class MessageUtil {

	public static void info(String message) {
		factory(message, FacesMessage.SEVERITY_INFO);
	}

	public static void error(String message) {
		factory(message, FacesMessage.SEVERITY_ERROR);
	}

	public static void warn(String message) {
		factory(message, FacesMessage.SEVERITY_WARN);
	}

	public static void fatal(String message) {
		factory(message, FacesMessage.SEVERITY_FATAL);
	}

	private static void factory(String message, Severity fm) {
		FacesMessage mensagem = new FacesMessage();
		mensagem.setSeverity(fm);
		mensagem.setSummary(message);
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
	}

}
