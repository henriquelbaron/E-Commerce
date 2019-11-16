package br.com.ecommerce.util;

import java.text.DecimalFormat;

import br.com.ecommerce.bean.util.MessageUtil;

public class NumberUtils {

	public static String doubleToString(Double numero) {
		DecimalFormat df = new DecimalFormat("#,###.00");
		return df.format(numero);
	}

	public static Double stringToDouble(String numero) {
		Double retorno = null;
		try {
			retorno = Double.parseDouble(numero);
		} catch (NumberFormatException e) {
			MessageUtil.error("Erro ao corverter para Double");
		}
		return retorno;
	}

	public static Long stringToLong(String numero) {
		Long retorno = null;
		try {
			retorno = Long.parseLong(numero);
		} catch (NumberFormatException e) {
			MessageUtil.error("Erro ao corverter para Long");
		}
		return retorno;
	}

}
