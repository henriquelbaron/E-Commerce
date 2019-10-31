function mascara(o, f) {
	v_obj = o;
	v_fun = f;
	setTimeout("execmascara()", 1);
}
function execmascara() {
	v_obj.value = v_fun(v_obj.value);
}
function valor(v) {
	v = v.replace(/\D/g, "");
	v = v.replace(/[0-9]{15}/, "Inválido");
	v = v.replace(/(\d{1})(\d{11})$/, "$1.$2"); // coloca ponto antes dos
	// Ãºltimos 11 digitos
	v = v.replace(/(\d{1})(\d{8})$/, "$1.$2"); // coloca ponto antes dos
	// Ãºltimos 8 digitos
	v = v.replace(/(\d{1})(\d{5})$/, "$1.$2"); // coloca ponto antes dos
	// Ãºltimos 5 digitos
	v = v.replace(/(\d{1})(\d{1,2})$/, "$1,$2"); // coloca virgula antes dos
	// Ãºltimos 2 digitos
	return v;
}

function cpfCnpj(v) {

	// Remove tudo o que não é dígito
	v = v.replace(/\D/g, "");
	v = v.replace(/[0-9]{15}/, "Inválido");
	if (v.length <= 11) { // CPF

		// Coloca um ponto entre o terceiro e o quarto dígitos
		v = v.replace(/(\d{3})(\d)/, "$1.$2");

		// Coloca um ponto entre o terceiro e o quarto dígitos
		// de novo (para o segundo bloco de números)
		v = v.replace(/(\d{3})(\d)/, "$1.$2");

		// Coloca um hífen entre o terceiro e o quarto dígitos
		v = v.replace(/(\d{3})(\d{1,2})$/, "$1-$2");

	} else { // CNPJ

		// Coloca ponto entre o segundo e o terceiro dígitos
		v = v.replace(/^(\d{2})(\d)/, "$1.$2");

		// Coloca ponto entre o quinto e o sexto dígitos
		v = v.replace(/^(\d{2})\.(\d{3})(\d)/, "$1.$2.$3");

		// Coloca uma barra entre o oitavo e o nono dígitos
		v = v.replace(/\.(\d{3})(\d)/, ".$1/$2");

		// Coloca um hífen depois do bloco de quatro dígitos
		v = v.replace(/(\d{4})(\d)/, "$1-$2");

	}
	return v
}