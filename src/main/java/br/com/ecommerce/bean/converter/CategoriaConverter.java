package br.com.ecommerce.bean.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.ecommerce.dao.CategoriaDao;
import br.com.ecommerce.domain.Categoria;
import br.com.ecommerce.util.NumberUtils;

@Named
public class CategoriaConverter implements Converter {

	@Inject
	private CategoriaDao dao;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Categoria retorno = null;
		if (value != null) {
			retorno = dao.buscarPorID(NumberUtils.stringToLong(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((Categoria) value).getId().toString();
		}
		return "";
	}
}
