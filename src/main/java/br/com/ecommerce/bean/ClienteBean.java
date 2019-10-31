package br.com.ecommerce.bean;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.ecommerce.dao.ClienteDao;
import br.com.ecommerce.domain.Cliente;
import br.com.ecommerce.domain.Endereco;

@Named
@ViewScoped
public class ClienteBean extends CrudBean<Cliente, ClienteDao> {
	private static final long serialVersionUID = 1L;

	@Inject
	private ClienteDao clienteDao;
	private String confirmarSenha;

	@Override
	public ClienteDao getDao() {
		return clienteDao;
	}

	@Override
	public Cliente newEntidade() {
		Endereco endereco = new Endereco();
		Cliente cliente = new Cliente();
		cliente.setEndereco(endereco);
		return cliente;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

}
