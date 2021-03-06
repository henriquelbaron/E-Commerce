package br.com.ecommerce.service;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.ecommerce.bean.util.MessageUtil;
import br.com.ecommerce.dao.UsuarioDao;
import br.com.ecommerce.domain.Usuario;
import br.com.ecommerce.exception.UsuarioDesativadoExeption;
import br.com.ecommerce.exception.UsuarioInvalidoException;
import br.com.ecommerce.util.HashUtils;

@Named
public class LoginService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioDao usuarioDao;
	private Usuario usuarioLogado;

	public void verificaLogin(String email, String senha) throws UsuarioInvalidoException, UsuarioDesativadoExeption {
		String senhaCriptografada = HashUtils.generatedHash(senha);
		usuarioLogado = usuarioDao.verificaLogin(email, senhaCriptografada);

		if (usuarioLogado == null) {
			throw new UsuarioInvalidoException();
		} else if (!usuarioLogado.isAtivo()) {
			throw new UsuarioDesativadoExeption();
		}
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

		session.setAttribute("usuarioLogado", usuarioLogado);

	}

	public String realizaLogin(String email, String senha) {
		try {
			verificaLogin(email, senha);
			return "/dashboard.xhtml?faces-redirect=true";
		} catch (UsuarioInvalidoException e) {
			MessageUtil.error("Email ou Usuário incorreto!");
			return "/login.xhtml";
		} catch (UsuarioDesativadoExeption e) {
			MessageUtil.error("Usuário desativado!");
			return "/login.xhtml";
		}
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

}
