package br.com.ecommerce.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class DateUtils {
	
	public static DateFormat getFormatadorDataBrasil() {
		return new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("pt", "BR"));
	}
}
