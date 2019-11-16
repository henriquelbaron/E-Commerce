package br.com.ecommerce.bean.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.ecommerce.dao.FornecedorDao;
import br.com.ecommerce.domain.Fornecedor;

@Named
public class FornecedorConverter implements Converter {

	@Inject
	private FornecedorDao dao;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Fornecedor retorno = null;
		if (value != null) {
			List<Fornecedor> fornecedores = dao.getFornecedorPorNome(value);
			for (Fornecedor fornecedor : fornecedores) {
				if (fornecedor.getNome().equals(value.trim()))
					return fornecedor;
			}
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((Fornecedor) value).getId().toString();
		}
		return "";
	}
}
