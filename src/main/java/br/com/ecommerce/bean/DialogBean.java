package br.com.ecommerce.bean;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Named;

import org.primefaces.PrimeFaces;

@Named
public class DialogBean {
	public void showViewImagem() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("resizable", false);
		PrimeFaces.current().dialog().openDynamic("viewImagem", options, null);
	}
}
