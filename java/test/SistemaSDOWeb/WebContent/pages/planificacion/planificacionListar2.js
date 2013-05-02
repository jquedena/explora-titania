var isNN = (navigator.appName.indexOf("Netscape") != -1);
var indicadorFuncion = true;
var indicadorCalculo = 0;
var calculosRealizados = 0;

document.onkeypress = onlynumber;

// NUEVO CODIGO PARA DAR FORMATO.
function oNumero(numero) {
	//Propiedades
	this.valor = numero || 0
	this.dec = -1;
	// Metodos
	this.formato = numFormat;
	this.ponValor = ponValor;
	// Definicion de los metodos
	function ponValor(cad) {
		if (cad == '-' || cad == '+')
			return

		if (cad.length == 0)
			return

		if (cad.indexOf('.') >= 0)
			this.valor = parseFloat(cad);
		else
			this.valor = parseInt(cad);
	}
	function numFormat(dec, miles) {
		var num = this.valor, signo = 3, expr;
		var cad = "" + this.valor;
		var ceros = "", pos, pdec, i;
		for (i = 0; i < dec; i++)
			ceros += '0';
		pos = cad.indexOf('.');
		if (pos < 0) {
			if (ceros != "") {
				cad = cad + "." + ceros;
			}
		} else {
			pdec = cad.length - pos - 1;
			if (pdec <= dec) {
				for (i = 0; i < (dec - pdec); i++)
					cad += '0';
			} else {
				num = num * Math.pow(10, dec);
				num = Math.round(num);
				num = num / Math.pow(10, dec);
				cad = new String(num);
			}
		}
		pos = cad.indexOf('.');
		if (pos < 0)
			pos = cad.lentgh;

		if (cad.substr(0, 1) == '-' || cad.substr(0, 1) == '+')
			signo = 4;

		if (miles && pos > signo)
			do {
				expr = /([+-]?\d)(\d{3}[\.\,]\d*)/;
				cad.match(expr);
				cad = cad.replace(expr, RegExp.$1 + '' + RegExp.$2);
			} while (cad.indexOf(',') > signo);

		if (dec < 0)
			cad = cad.replace(/\./, '');

		return cad;
	}
}

function onlynumber(DnEvents) {
	k = (isNN) ? DnEvents.which : window.event.keyCode;
	a = (isNN) ? DnEvents.target.name : window.event.srcElement.name;
	if (a != null) {
		if (k == 8 || k == 0)
			return true;

		if (((k < 48) || (k > 57)) && (k != 45)) {
			if (isNN)
				return false;
			else
				event.returnValue = false;
		}
	}
}

function elegirGestor() {
	var form = document.forms[0];
	form.action = "reportePPGAction.do?method=inicioReportePGGAcciones";
	form.method = "post";
	form.submit();
}

function decide(valor) {
	if (valor == 0) {
		calcularDesvPptoAjustado(true);
	} else {
		if (valor == 1) {
			calculaProyeccion(true);
		} else {
			if (valor == 2) {
				calcularAjuste(true);
			} else {
				calcular(true);
			}
		}
	}
}

function calcularTodo() {
	var form = document.forms[0];
	var resp1 = calcularDesvPptoAjustado(true);
	var resp2 = calculaProyeccion(true);
	var resp3 = calcularAjuste(true);
	var resp4 = calcular(true);

	if (resp1 && resp2 && resp3 && resp4) {
		for ( var t = 0; t < form.metaMesSaldPuntVista.length; t++) {
			form.metaMesSaldPuntVista[t].value = form.metaMesSaldPunt[t].value;
			form.desvPptoVista[t].value = form.desvPpto[t].value;
			form.desvAjusPptoVista[t].value = form.desvAjusPpto[t].value;
		}

		alert("Se calculo Objetivos de la Oficina, de no modificar el campo Ajuste Territorial, pulse grabar");
		calculosRealizados = 1;
	}
}

function calcularDesvPptoAjustado(mensaje) {
	var form = document.forms[0];
	var tempSaldMediJunioDici = new Array();
	var mesPresupuesto = "";

	indicadorFuncion = true;
	mesPresupuesto = form.preReferencia.options[form.preReferencia.selectedIndex].value;

	for ( var t = 0, r = 0; t < form.saldMediJunio.length; t = t + 2, r++) {
		tempSaldMediJunioDici[r] = form.saldMediJunio[t].value;
	}

	for ( var i = 0; i < form.monto.length; i++) {
		if ((form.indAfecta[i].value == "S")
				&& ((eval(form.ajusPpto[i].value) == 0) || (eval(form.ajusPpto[i].value) == "null"))) {
			eval(form.ajusPpto[i].value = 100);
		}

		if (form.indAfecta[i].value == "S") {
			var numero = new oNumero(eval(form.desvPpto[i].value));

			eval(tempSaldMediJunioDici[i]);
			eval(form.monto[i].value);
			eval(form.ajusPpto[i].value);

			eval(form.desvAjusPpto[i].value = (parseFloat(tempSaldMediJunioDici[i])
					* parseFloat(form.ajusPpto[i].value) / 100)
					- parseFloat(form.monto[i].value));
			eval(form.desvAjusPpto[i].value = parseInt(form.desvAjusPpto[i].value));

			eval(form.desvPpto[i].value);
			eval(tempSaldMediJunioDici[i]);
			eval(form.monto[i]);
		}
	}

	if (indicadorFuncion) {

		sumaDesvPptoAjustadoSubClase = 0;

		indicadorHayHijos = false;

		for ( var k = form.monto.length - 1; k >= 0; k--) {

			if ((eval(form.indHijo[k].value) == 0)
					&& (eval(form.indSubClase[k].value) == 0)) {
			} else {
				if ((eval(form.indHijo[k].value) != 0)
						&& (eval(form.indSubClase[k].value) != 0)) {
					sumaDesvPptoAjustadoSubClase = sumaDesvPptoAjustadoSubClase
							+ parseFloat(eval(form.desvAjusPpto[k].value));
					indicadorHayHijos = true;
				} else {
					if (indicadorHayHijos) {
						eval(form.desvAjusPpto[k].value = sumaDesvPptoAjustadoSubClase);
						sumaDesvPptoAjustadoSubClase = 0;
						indicadorHayHijos = false;
					}
				}
			}
		}

		for ( var i = 0; i < form.monto.length; i++) {

			/* Sumamos todas las subclases (indicadorSubClase!=0 e indicadorHijo==0) */
			if ((eval(form.indHijo[i].value) == 0)
					&& (eval(form.indSubClase[i].value) == 0)) {
				sumaDesvPptoAjustadoClase = 0;
				indicadorHayHijos = false;

				for ( var j = 0; j < form.monto.length; j++) {
					if ((eval(form.indHijo[j].value) == "0")
							&& (eval(form.indSubClase[j].value) != "0")
							&& (eval(form.indClase[j].value) == eval(form.indClase[i].value))) {
						sumaDesvPptoAjustadoClase = sumaDesvPptoAjustadoClase
								+ parseFloat(eval(form.desvAjusPpto[j].value));
						indicadorHayHijos = true;
					}
				}
				if (indicadorHayHijos) {
					eval(form.desvAjusPpto[i].value = sumaDesvPptoAjustadoClase);
				}
			}
			eval(form.desvAjusPpto[i]);

		}

		indicadorCalculo = 1;
		if (mensaje) {
			/* alert("Se ha modificado el presupuesto") */
			return true;
		}
	} else {
		return false;
	}

}

function calculaProyeccion(mensaje) {
	var form = document.forms[0];
	var tempSaldMediJunioDici = new Array();
	var mesPresupuesto = "";

	calcularDesvPptoAjustado(false);

	mesPresupuesto = form.preReferencia.options[form.preReferencia.selectedIndex].value;

	for ( var t = 0, r = 0; t < form.saldMediJunio.length; t = t + 2, r++) {
		tempSaldMediJunioDici[r] = form.saldMediJunio[t].value;
	}

	for ( var i = 0; i < form.monto.length; i++) {

		if (form.indAfecta[i].value == "S"
				&& ((form.nroMesesFalt[i].value == 0) || (form.nroMesesFalt[i].value == "null"))) {
			eval(form.nroMesesFalt[i].value = (parseFloat(form.preReferencia.value)
					- parseFloat(form.mes[i].value) + 1));
		}

		/* calculamos los valores de los hijos */
		if (form.indAfecta[i].value == "S") {

			eval(form.desvPpto[i].value);
			eval(form.saldMediDici[i].value);
			eval(form.monto[i].value);

			eval(form.desvAjusPpto[i].value = (parseFloat(tempSaldMediJunioDici[i])
					* parseFloat(form.ajusPpto[i].value) / 100)
					- parseFloat(form.monto[i].value));
			eval(form.desvAjusPpto[i].value = parseInt(form.desvAjusPpto[i].value));
			eval(form.proyCrecMens[i].value = (parseFloat(form.desvAjusPpto[i].value) / parseFloat(form.nroMesesFalt[i].value)));
			eval(form.desvPpto[i].value);

			eval(tempSaldMediJunioDici[i]);
			eval(form.monto[i].value);
		}
	}

	if (indicadorFuncion) {
		sumaCrecimientoMensualSubClase = 0;

		indicadorHayHijos = false;
		for ( var k = form.monto.length - 1; k >= 0; k--) {
			/* sumamos los resultados de los hijos de una subclase
			   trabajamos en base a los indicadores clase + subclase + hijo - concatenados - que estan en orden. */

			if ((eval(form.indHijo[k].value) == 0)
					&& (eval(form.indSubClase[k].value) == 0)) {
			} else {
				if ((eval(form.indHijo[k].value) != 0)
						&& (eval(form.indSubClase[k].value) != 0)) {
					sumaCrecimientoMensualSubClase = sumaCrecimientoMensualSubClase
							+ parseFloat(eval(form.proyCrecMens[k].value));
					indicadorHayHijos = true;
				} else {
					if (indicadorHayHijos) {
						eval(form.proyCrecMens[k].value = sumaCrecimientoMensualSubClase);
						sumaCrecimientoMensualSubClase = 0;
						indicadorHayHijos = false;
					}
				}
			}
		}

		for ( var i = 0; i < form.monto.length; i++) {
			/* Sumamos todas las subclases (indicadorSubClase!=0 e indicadorHijo==0) */
			if ((eval(form.indHijo[i].value) == 0)
					&& (eval(form.indSubClase[i].value) == 0)) {
				sumaCrecimientoMensualClase = 0;
				indicadorHayHijos = false;

				for ( var j = 0; j < form.monto.length; j++) {
					if ((eval(form.indHijo[j].value) == "0")
							&& (eval(form.indSubClase[j].value) != "0")
							&& (eval(form.indClase[j].value) == eval(form.indClase[i].value))) {
						sumaCrecimientoMensualClase = sumaCrecimientoMensualClase
								+ parseFloat(eval(form.proyCrecMens[j].value));
						indicadorHayHijos = true;
					}
				}
				if (indicadorHayHijos) {
					eval(form.proyCrecMens[i].value = sumaCrecimientoMensualClase);
				}
			}
			eval(form.proyCrecMens[i].value);
			eval(form.desvAjusPpto[i].value);
		}//for
	} else {
		return false;
	}

	/*Calculos de Factor Ajuste Saldo Puntual Historico Bajas Objetivo Oficina */

	if (indicadorFuncion) {

		for ( var i = 0; i < form.monto.length; i++) {

			//le damos el formato necesario para calcular
			eval(form.desvPpto[i].value);
			// eval(form.porAlcanzado[i].value);
			eval(form.proyCrecMens[i].value);

			if (form.indAfecta[i].value == "S") {
				eval(form.histBajas[i].value);
			}

			// calculamos los valores de los hijos
			if (form.indAfecta[i].value == "S") {
				eval(form.proyAjusMens[i].value = (parseFloat(form.proyCrecMens[i].value) * parseFloat(form.factAjusSaldPunt[i].value)));
				valorObj = (parseFloat(form.proyAjusMens[i].value) + parseFloat(form.histBajas[i].value))
				eval(form.metaMesSaldPunt[i].value = Math.round(valorObj * 1) / 1);

				var newnum = new oNumero(eval(form.metaMesSaldPunt[i].value));
				// form.metaMesSaldPunt[i].value = newnum.formato(2, true);
				form.metaMesSaldPunt[i].value = newnum.formato(0, true);
			}

			//damos el formato necesario para mostrar
			eval(form.desvPpto[i].value);

			if (form.indAfecta[i].value == "S") {
				eval(form.histBajas[i].value);
			}

		}
	}

	if (indicadorFuncion) {
		sumaAjusteMensualSubClase = 0;
		sumaMetaMesSaldoPuntualSubClase = 0;

		indicadorHayHijos = false;

		for ( var k = form.monto.length - 1; k >= 0; k--) {

			if ((eval(form.indHijo[k].value) == 0)
					&& (eval(form.indSubClase[k].value) == 0)) {
			} else {
				if ((eval(form.indHijo[k].value) != 0)
						&& (eval(form.indSubClase[k].value) != 0)) {
					sumaAjusteMensualSubClase = sumaAjusteMensualSubClase
							+ parseFloat(eval(form.proyAjusMens[k].value));
					sumaMetaMesSaldoPuntualSubClase = sumaMetaMesSaldoPuntualSubClase
							+ parseFloat(eval(form.metaMesSaldPunt[k].value));
					indicadorHayHijos = true;
				} else {
					if (indicadorHayHijos) {
						eval(form.proyAjusMens[k].value = sumaAjusteMensualSubClase);
						eval(form.metaMesSaldPunt[k].value = Math
								.round(sumaMetaMesSaldoPuntualSubClase * 1) / 1);

						var newnum = new oNumero(
								eval(form.metaMesSaldPunt[k].value));
						// form.metaMesSaldPunt[k].value = newnum.formato(2,
						// true);
						form.metaMesSaldPunt[k].value = newnum.formato(0, true);

						sumaAjusteMensualSubClase = 0;
						sumaMetaMesSaldoPuntualSubClase = 0;
						indicadorHayHijos = false;
					}
				}
			}
		}

		for ( var i = 0; i < form.monto.length; i++) {
			// Sumamos todas las subclases (indicadorSubClase!=0 e indicadorHijo==0)
			if ((eval(form.indHijo[i].value) == 0)
					&& (eval(form.indSubClase[i].value) == 0)) {
				sumaAjusteMensualClase = 0;
				sumaMetaMesSaldoPuntualClase = 0;
				indicadorHayHijos = false;

				for ( var j = 0; j < form.monto.length; j++) {
					if ((eval(form.indHijo[j].value) == "0")
							&& (eval(form.indSubClase[j].value) != "0")
							&& (eval(form.indClase[j].value) == eval(form.indClase[i].value))) {
						sumaAjusteMensualClase = sumaAjusteMensualClase
								+ parseFloat(eval(form.proyAjusMens[j].value));
						sumaMetaMesSaldoPuntualClase = sumaMetaMesSaldoPuntualClase
								+ parseFloat(eval(form.metaMesSaldPunt[j].value));
						indicadorHayHijos = true;
					}
				}

				if (indicadorHayHijos) {
					eval(form.proyAjusMens[i].value = sumaAjusteMensualClase);
					eval(form.metaMesSaldPunt[i].value = sumaMetaMesSaldoPuntualClase);

					var newnum = new oNumero(
							eval(form.metaMesSaldPunt[i].value));
					form.metaMesSaldPunt[i].value = newnum.formato(0, true);
					// form.metaMesSaldPunt[i].value = newnum.formato(2, true);
				}
			}

			eval(form.proyCrecMens[i].value);
			eval(form.proyAjusMens[i].value);
			eval(form.metaMesSaldPunt[i].value);
		}

		indicadorCalculo = 2;
		if (mensaje) {
			//alert("Los calculos de la proyeccion se han llevado a cabo.")
			return true;
		}
	} else {
		return false;
	}

	// Se copia a la vista
	for ( var i = 0; i < form.monto.length; i++) {
		var newnum = eval(form.proyCrecMens[i].value);
		eval(form.proyCrecMensVista[i].value = Math.round(newnum));
	}

} //function

function calcularAjuste(mensaje) {
	var form = document.forms[0];
	calculaProyeccion(false);

	if (indicadorFuncion) {
		for ( var i = 0; i < form.monto.length; i++) {
			if ((form.indAfecta[i].value == "S")
					&& ((eval(form.factAjusTerri[i].value) == 0) || (form.factAjusTerri[i].value == "null"))) {
				eval(form.factAjusTerri[i].value = form.metaMesSaldPunt[i].value);
			}
		}
		indicadorCalculo = 3;
		if (mensaje) {
			//alert("Ajuste territorial ha sido ingresado");
			return true;
		}
	} else {
		return false;
	}
}

function calcular(mensaje) {
	var form = document.forms[0];

	calcularAjuste(false);

	if (indicadorFuncion) {
		for ( var i = 0; i < form.monto.length; i++) {

			if ((form.indAfecta[i].value == "S")
					&& ((eval(form.factAjusTerri[i].value) == 0) || (form.factAjusTerri[i].value == "null"))) {
				eval(form.factAjusTerri[i].value = form.metaMesSaldPunt[i].value);
			}

			if ((form.indAfecta[i].value == "S")
					&& ((eval(form.nroMesesFalt[i].value) == 0) || (form.nroMesesFalt[i].value == "null"))) {
				alert("No se puede realizar calculos con valores 0 o nulos.");
				indicadorFuncion = false;
				return false;
			} else {
				//le damos el formato necesario para calcular
				// eval(form.porAlcanzado[i].value);
				eval(form.desvPpto[i].value);
				eval(form.proyCrecMens[i].value);
				eval(form.factAjusTerri[i].value);

				// damos el formato necesario para mostrar
				eval(form.factAjusTerri[i].value);
				// eval(form.porAlcanzado[i].value);
				eval(form.desvPpto[i].value);

			}
		}
	}

	if (indicadorFuncion) {
		sumaMetaGerenteOficinaSubClase = 0;

		indicadorHayHijos = false;

		for ( var k = form.monto.length - 1; k >= 0; k--) {
			// sumamos los resultados de los hijos de una subclase
			// trabajamos en base a los indicadores clase + subclase + hijo -
			// concatenados - que
			// estan en orden.

			if ((eval(form.indHijo[k].value) == 0)
					&& (eval(form.indSubClase[k].value) == 0)) {
			} else {
				if ((eval(form.indHijo[k].value) != 0)
						&& (eval(form.indSubClase[k].value) != 0)) {
					sumaMetaGerenteOficinaSubClase = sumaMetaGerenteOficinaSubClase
							+ parseFloat(form.factAjusGereOfic[k].value);
					indicadorHayHijos = true;
				} else {
					if (indicadorHayHijos) {

						eval(form.factAjusGereOfic[k].value = sumaMetaGerenteOficinaSubClase);
						sumaMetaGerenteOficinaSubClase = 0;
						indicadorHayHijos = false;
					}
				}
			}
		}

		for ( var i = 0; i < form.monto.length; i++) {
			// Sumamos todas las subclases (indicadorSubClase!=0 e indicadorHijo==0)
			if ((eval(form.indHijo[i].value) == 0)
					&& (eval(form.indSubClase[i].value) == 0)) {
				sumaMetaGerenteOficinaClase = 0;
				indicadorHayHijos = false;

				for ( var j = 0; j < form.monto.length; j++) {
					if ((eval(form.indHijo[j].value) == "0")
							&& (eval(form.indSubClase[j].value) != "0")
							&& (eval(form.indClase[j].value) == eval(form.indClase[i].value))) {
						sumaMetaGerenteOficinaClase = sumaMetaGerenteOficinaClase
								+ parseFloat(eval(form.factAjusGereOfic[j].value));
						indicadorHayHijos = true;
					}
				}

				if (indicadorHayHijos) {
					eval(form.factAjusGereOfic[i].value = sumaMetaGerenteOficinaClase);
				}
			}

			eval(form.proyCrecMens[i].value);
			eval(form.proyAjusMens[i].value);
			eval(form.metaMesSaldPunt[i].value);
		}

		if (mensaje) {
			/* alert("Calculos concluidos") */
			return true;
		}
	} else {
		return false;
	}

	/* Se copia a la vista */
	for ( var i = 0; i < form.monto.length; i++) {
		var newnum = eval(form.proyCrecMens[i].value);
		eval(form.proyCrecMensVista[i].value = Math.round(newnum));
	}

}