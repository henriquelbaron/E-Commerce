package br.com.ecommerce.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.LazyDataModel;

import br.com.ecommerce.bean.lazytable.ClienteLazyModel;
import br.com.ecommerce.domain.Cliente;
import br.com.ecommerce.domain.Endereco;
import br.com.ecommerce.domain.Usuario;
import br.com.ecommerce.service.ClienteService;

@Named
@ViewScoped
public class ClienteBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private ClienteService clienteService;
	private String confirmarSenha;
	private List<Cliente> clientes;
	private Cliente cliente;

	private LazyDataModel<Cliente> lazyClientes;

	@PostConstruct
	public void init() {
		lazyClientes = new ClienteLazyModel(clienteService.getClienteDao());
		refresh();
	}

	public void salvar() {
		cliente.getUsuario().setLogin(cliente.getEmail());
		clienteService.saveOrUpdate(cliente);
		refresh();
	}

	public Cliente refresh() {
		clientes = clienteService.buscarTodos();
		cliente = new Cliente();
		cliente.setUsuario(new Usuario());
		cliente.setEndereco(new Endereco());
		return cliente;
	}

	public void delete() {
		clienteService.excluir(cliente);
		refresh();
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public LazyDataModel<Cliente> getLazyClientes() {
		return lazyClientes;
	}

	public void setLazyClientes(LazyDataModel<Cliente> lazyClientes) {
		this.lazyClientes = lazyClientes;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
