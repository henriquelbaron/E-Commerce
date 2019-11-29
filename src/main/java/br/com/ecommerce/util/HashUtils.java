package br.com.ecommerce.util;

import org.apache.commons.codec.digest.Crypt;

public class HashUtils {

	private static final String SALT = "hashhhhhdohenriqueEEE";

	public static String generatedHash(String string) {
		return Crypt.crypt(string, SALT);
	}

	public static void main(String[] args) {
		System.out.println(generatedHash("admin"));
	}
}
