function getFechaHora() {

	// var dias = new Array("Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado");
	// var meses = new Array("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre");

	d = new Date();
	hora = d.getHours();
	minuto = d.getMinutes();
	segundo = d.getSeconds();
	dia = d.getDate();
	mes = d.getMonth() + 1;
	if (hora < 10)
		hora = "0" + hora;
	if (minuto < 10)
		minuto = "0" + minuto;
	if (segundo < 10)
		segundo = "0" + segundo;
	if (dia < 10)
		dia = "0" + dia;
	if (mes < 10)
		mes = "0" + mes;

	var horaFecha = dia + "-" + mes + "-" + (d.getYear()) + " " + hora
			+ ":" + minuto + ":" + segundo;
	try {
		frmReloj.inReloj.value = horaFecha;
	} catch (e) {
		alert(e);
	}
	setTimeout("getFechaHora()", 1000);
}

/Valida entrada de teclado/
function fn_validaTecla(tipo, textbox) {
	var tecla;

	if (navigator.appName.indexOf("Netscape") != -1)
		tecla = event.which;
	else
		tecla = event.keyCode;

	var key = String.fromCharCode(tecla);
	var numeros = "0123456789";
	var sololetras = "_*-AaBbCcDdEeFfGgHhIiJjKkLlMmNn??OoPpQqRrSsTtUuVvWwXxYyZz??????????";
	var letras = "_*-AaBbCcDdEeFfGgHhIiJjKkLlMmNn??OoPpQqRrSsTtUuVvWwXxYyZz??????????,";
	var hexa = "0123456789AaBbCcDdEeFf";
	var fechas = "0123456789/";
	var email = "@.;";

	if (tipo == 'archivo') {
		if (tecla == 34)
			return false;
		if (tecla == 39)
			return false;
		if (tecla == 96)
			return false;
		return true;
	}

	if (tipo == 'email') {
		if (tecla == 34)
			return false;
		if (tecla == 39)
			return false;
		if (tecla == 32)
			return false;

		if ((numeros.indexOf(key) != -1) || (sololetras.indexOf(key) != -1)
				|| (email.indexOf(key) != -1))
			return true;
		else
			return false;
	}

	if (tipo == 'nocomillas') {
		if (tecla == 39 || tecla == 34)
			return false;
		else
			return true;
	}

	if (tipo == 'letras') {
		if (tecla == 32)
			return true;

		if (letras.indexOf(key) != -1)
			return true;

		return false;
	}

	if (tipo == 'entero') {
		if (numeros.indexOf(key) != -1)
			return true;
		else
			return false;
	}

	if (tipo == 'decimal') {

		if (numeros.indexOf(key) != -1) {
			return true;
		}
		// 46
		if (tecla == 44) {
			var cadena = textbox.value;
			var iIndex = cadena.indexOf(',');

			if (iIndex == -1) {
				return true;
			}
		}

		return false;
	}

	if (tipo == "NoNumeros") {
		if (tecla == 32)
			return true;

		if (numeros.indexOf(key) != -1)
			return false;

		return true;

	}

	if (tipo == "hexadecimal") {
		if (tecla == 32)
			return true;
		if (tecla == 39)
			return false;
		if (hexa.indexOf(key) != -1)
			return true;
		return false;
	}

	if (tipo == "alfanumerico") {
		if (tecla == 34)
			return false;
		if (tecla == 39)
			return false;

		if ((numeros.indexOf(key) != -1) || (sololetras.indexOf(key) != -1))
			return true;
		else
			return false;
	}
	if (tipo == "fecha") {
		if ((fechas.indexOf(key) != -1))
			return true;
		else
			return false;
	}
	if (tipo == "horas") {

		if ((numeros.indexOf(key) != -1))
			return true;

		if (tecla == 58) {
			var cadena = textbox.value;
			var iIndex = cadena.indexOf(':');

			if (iIndex == -1) {
				return true;
			}
		}

		return false;

	}
	if (tipo == "alfanumericoypunto") {
		if ((numeros.indexOf(key) != -1) || (sololetras.indexOf(key) != -1)
				|| key == '.')
			return true;
		else
			return false;
	}
	if (tipo == "alfanumericoydivision") {
		if ((numeros.indexOf(key) != -1) || (sololetras.indexOf(key) != -1)
				|| key == '/')
			return true;
		else
			return false;
	}
	if (tipo == "alfanumericoypuntoyblanco") {
		if ((numeros.indexOf(key) != -1) || (sololetras.indexOf(key) != -1)
				|| key == '.' || key == ' ')
			return true;
		else
			return false;
	}

}

/Deshabilita copia y pega/
function fn_DisableCopyPaste() {
	try {
		if (window.event
				&& ((window.event.ctrlKey && window.event.keyCode == 86) || (window.event.shiftKey && window.event.keyCode == 45))) {
			return false;
		}
		return true;
	} catch (e) {
	}
}

function cerrar() {
	opener = null;
	window.close()
}
