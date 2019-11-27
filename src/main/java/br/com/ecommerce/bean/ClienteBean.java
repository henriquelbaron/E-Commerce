package br.com.ecommerce.bean;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.ecommerce.bean.util.MessageUtil;
import br.com.ecommerce.dao.ClienteDao;
import br.com.ecommerce.domain.Cliente;
import br.com.ecommerce.domain.Endereco;
import br.com.ecommerce.domain.Usuario;

@Named
@ViewScoped
public class ClienteBean extends CrudBean<Cliente, ClienteDao> {
	private static final long serialVersionUID = 1L;

	@Inject
	private ClienteDao clienteDao;
	private String confirmarSenha;
	private Usuario usuario;

	@Override
	public ClienteDao getDao() {
		return clienteDao;
	}

	@Override
	public void salvar() {
		try {
			usuario.setLogin(entidade.getEmail());
			entidade.setUsuario(usuario);
			usuario.setCliente(entidade);
			clienteDao.saveOrUpdate(entidade);
			MessageUtil.info("Salvo com Sucesso!");
		} catch (Exception e) {
			System.out.println(e);
			MessageUtil.error("Erro " + e);
		} finally {
			refresh();
		}
	}

	@Override
	public Cliente newEntidade() {
		Cliente cliente = new Cliente();
		usuario = new Usuario();
		cliente.setEndereco(new Endereco());
		return cliente;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
