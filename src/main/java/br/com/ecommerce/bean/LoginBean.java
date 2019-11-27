package br.com.ecommerce.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.ecommerce.bean.util.MessageUtil;
import br.com.ecommerce.dao.UsuarioDao;
import br.com.ecommerce.domain.Usuario;

@Named
@SessionScoped
public class LoginBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioDao dao;
	private Usuario usuarioLogado;
	private String email;
	private String senha;

	public String login() {
		usuarioLogado = dao.verificaLogin(email, senha);
		if (usuarioLogado == null) {
			MessageUtil.error("Email ou Usuário incorreto!");
			return "/login.xhtml";
		}
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

		session.setAttribute("usuarioLogado", usuarioLogado);

		return "/dashboard.xhtml?faces-redirect=true";
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

}
