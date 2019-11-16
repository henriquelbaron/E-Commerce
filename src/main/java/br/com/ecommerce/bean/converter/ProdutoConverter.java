package br.com.ecommerce.bean.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.ecommerce.dao.ProdutoDao;
import br.com.ecommerce.domain.Produto;

@Named
public class ProdutoConverter implements Converter {

	@Inject
	private ProdutoDao dao;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Produto retorno = null;
		if (value != null) {
			List<Produto> produtos = dao.getProdutoPorNome(value);
			for (Produto Produto : produtos) {
				if (Produto.getNome().equals(value.trim()))
					return Produto;
			}
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((Produto) value).getId().toString();
		}
		return "";
	}
}
