function descargaArchivo() {
	alert('testing');
	var a = $existe;
	alert(a);	
}
function imprimir(obj) {	
	var ventana = window.open();
	var contenido = "<html>";
	contenido = contenido + "<head>";
	contenido = contenido + '<link href="/REAUNIWeb/recursos/css/default.css" rel="stylesheet" type="text/css">';
	contenido = contenido + '<link href="/REAUNIWeb/recursos/css/theme.css" rel="stylesheet" type="text/css">';
	contenido = contenido + '<link href="/REAUNIWeb/faces/javax.faces.resource/theme.css?ln=primefaces-redmond" rel="stylesheet" type="text/css">';
	contenido = contenido + '<link href="/REAUNIWeb/faces/javax.faces.resource/jquery/ui/jquery-ui.css?ln=primefaces&v=3.0.M3" type="text/css" media="screen" rel="stylesheet">';
	contenido = contenido + '<link href="/REAUNIWeb/faces/javax.faces.resource/wijmo/wijmo.css?ln=primefaces&v=3.0.M3" type="text/css" media="screen" rel="stylesheet">';
	contenido = contenido + '<link href="/REAUNIWeb/faces/javax.faces.resource/messages/messages.css?ln=primefaces&v=3.0.M3" type="text/css" media="screen" rel="stylesheet">';
	contenido = contenido + '<link href="/REAUNIWeb/faces/javax.faces.resource/dialog/dialog.css?ln=primefaces&v=3.0.M3" type="text/css" media="screen" rel="stylesheet">';
	contenido = contenido + '<link href="/REAUNIWeb/faces/javax.faces.resource/forms/forms.css?ln=primefaces&v=3.0.M3" type="text/css" media="screen" rel="stylesheet">';
	contenido = contenido + '<link href="/REAUNIWeb/faces/javax.faces.resource/paginator/paginator.css?ln=primefaces&v=3.0.M3" type="text/css" media="screen" rel="stylesheet">';
	contenido = contenido + '<link href="/REAUNIWeb/faces/javax.faces.resource/datatable/datatable.css?ln=primefaces&v=3.0.M3" type="text/css" media="screen" rel="stylesheet">';
	contenido = contenido + '<link href="/REAUNIWeb/faces/javax.faces.resource/datagrid/datagrid.css?ln=primefaces&v=3.0.M3" type="text/css" media="screen" rel="stylesheet">';
	contenido = contenido + "</head>";
	contenido = contenido + "<body onload='window.print();window.close();'>";
	contenido = contenido + document.getElementById(obj).innerHTML + "</body></html>";
	ventana.document.open();
	ventana.document.write(contenido);
	ventana.document.close();
}

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

	var horaFecha = dia + "-" + mes + "-" + (d.getYear()) + " " + hora + ":" + minuto + ":" + segundo;
	try {
		document.getElementById("inReloj").value = horaFecha;
	} catch (e) {
		alert(e);
	}
	setTimeout("getFechaHora()", 1000);
}

/* Valida entrada de teclado */
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
		var bol=false;
		if (numeros.indexOf(key) != -1) {
			bol=true;
		}
		// 46
		if (tecla == 46) {
			var cadena = textbox.value;
			var iIndex = cadena.indexOf('.');
			if (iIndex == -1) {
				bol=true;
			}
		}

		return bol;
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

// Deshabilita copia y pega
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

function obtenerContexto(){
	url = document.URL;
	tmp = url.split("REAUNIWeb");
	return tmp[0] + "REAUNIWeb/";
}


function exportarContrato(tipo) {
	var 
		x = parseInt(screen.width / 2) ,
		y = parseInt(screen.height / 2); 

	window.open(obtenerContexto() + "ExportarContrato.do?tipo=" + tipo, "_blank", "width=10,height=10,left=" + (x - 10)  + ",top=" + (y - 10) + ",scrollbars=0,directories=0,location=0,status=0");
}

function cerrar() {
	window.close();
}

function cerrarVentana() {
	$.ajax({
		url: obtenerContexto() + 'CerrarSesion.do',
		success: function(data) {
		},
		error: function(data) {
			alert("No se pudo cerrar la sesi\u00F3n.");
		}
	});
}

window.onload = function(){
    $('#itCodigoCliente').live("cut copy paste",function(e) {
        e.preventDefault();
    });
};