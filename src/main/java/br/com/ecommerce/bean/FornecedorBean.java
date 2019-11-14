package br.com.ecommerce.bean;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.ecommerce.dao.FornecedorDao;
import br.com.ecommerce.domain.Endereco;
import br.com.ecommerce.domain.Fornecedor;

@Named
@ViewScoped
public class FornecedorBean extends CrudBean<Fornecedor, FornecedorDao> {
	private static final long serialVersionUID = 1L;

	@Inject
	private FornecedorDao fornecedorDao;

	@Override
	public FornecedorDao getDao() {
		return fornecedorDao;
	}

	@Override
	public Fornecedor newEntidade() {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setEndereco(new Endereco());
		return fornecedor;
	}


}
