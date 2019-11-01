package br.com.ecommerce.bean.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.primefaces.component.picklist.PickList;
import org.primefaces.model.DualListModel;

import br.com.ecommerce.domain.Categoria;

@FacesConverter(value = "catConverter")
public class PickListCategoria implements Converter {
	@Override
	public Object getAsObject(FacesContext fc, UIComponent comp, String value) {
		DualListModel<Categoria> model = (DualListModel<Categoria>) ((PickList) comp).getValue();
		for (Categoria employee : model.getSource()) {
			if (employee.getId().equals(value)) {
				return employee;
			}
		}
		for (Categoria employee : model.getTarget()) {
			if (employee.getId().equals(value)) {
				return employee;
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((Categoria) value).getId().toString();
		}
		return "";
	}

}
