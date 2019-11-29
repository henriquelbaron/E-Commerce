package br.com.ecommerce.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.ecommerce.bean.util.MessageUtil;
import br.com.ecommerce.exception.UsuarioDesativadoExeption;
import br.com.ecommerce.exception.UsuarioInvalidoException;
import br.com.ecommerce.service.LoguinService;

@Named
@SessionScoped
public class LoginBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private LoguinService loguinService;
	private String email;
	private String senha;

	public String login() {
		try {
			loguinService.verificaLogin(email, senha);
			return "/dashboard.xhtml?faces-redirect=true";
		} catch (UsuarioInvalidoException e) {
			MessageUtil.error("Email ou Usuário incorreto!");
			return "/login.xhtml";
		} catch (UsuarioDesativadoExeption e) {
			MessageUtil.error("Usuário desativado!");
			return "/login.xhtml";
		}
	}

	public String logout() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

		session.invalidate();

		return "/login.xhtml?faces-redirect=true";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public LoguinService getLoguinService() {
		return loguinService;
	}

}
