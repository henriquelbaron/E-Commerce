package br.com.ecommerce.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.ecommerce.bean.util.MessageUtil;
import br.com.ecommerce.dao.ClienteDao;
import br.com.ecommerce.domain.Cliente;

@Named
public class ClienteService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private ClienteDao clienteDao;

	public ClienteDao getClienteDao() {
		return clienteDao;
	}

	public void saveOrUpdate(Cliente cliente) {
		try {
			clienteDao.saveOrUpdate(cliente);
			MessageUtil.info("Salvo com Sucesso!");
		} catch (javax.persistence.PersistenceException e) {
			System.out.println(e);
			MessageUtil.error("Este e-mail ja possui cadastro em nosso sistema!");
		}
	}

	public void excluir(Cliente cliente) {
		try {
			clienteDao.excluir(cliente);
			MessageUtil.info("Excluido com Sucesso!");
		} catch (Exception e) {
			System.out.println(e);
			MessageUtil.error("Erro ao Deletar " + e);
		}
	}

	public List<Cliente> buscarTodos() {
		return clienteDao.buscarTodos();
	}

	public void setClienteDao(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}

}
