var valor_disabled_territorio;
var valor_disabled_oficina;
var valor_disabled_gestor;

function generarModelo(matriz,cabeceras){
	var filaInicioPie = 0;
	var f = 0;
	
	var arrCabeceras = new Array(cabeceras.length);
	
	for(var i=0; i<cabeceras.length; i++){
		arrCabeceras[i] = cabeceras[i]["valor1"];
	}
	
	// myColumns = cabeceras;
	myColumns = arrCabeceras;
	estilos(cabeceras);
	
	//identificar pies de tabla
	/*if(matriz.length>=3 && matriz[matriz.length-3][0].substring(0,3)=='TOT')
		f = 3;
	else if(matriz.length>=2 && matriz[matriz.length-2][0].substring(0,3)=='TOT')
		f = 2;
	else if(matriz.length>=1 && matriz[matriz.length-1][0].substring(0,3)=='TOT')
		f = 1;*/
	
	filaInicioPie = matriz.length-f;
	
	//copiar datos
	myData = new Array();
	/*myFooters1 = new Array();
	myFooters2 = new Array();*/
	for(i=0;i<matriz.length;i++){
		// if (i<filaInicioPie)
			myData[i] = matriz[i];
		/*else if(i==filaInicioPie)
			myFooters1 = matriz[i];
		else if(i==filaInicioPie+1){
			myFooters2 = matriz[i];
		}
		else if(i==filaInicioPie+2)
			myFooters3 = matriz[i];*/
	}
	document.getElementById("myGrid").innerHTML='';
	
	creaGrilla(myData.length,matriz[0].length,f,estiloGrilla());
}

function pintarPaginacion(pagActual,numPags){
	var pagPri = document.getElementById("spanPagPri");
	var pagAnt = document.getElementById("spanPagAnt");
	var pagSig = document.getElementById("spanPagSig");
	var pagUlt = document.getElementById("spanPagUlt");
	var pagText = document.getElementById("spanPagText");
	if(numPags<=1){
		pagPri.style.visibility = 'hidden';
		pagAnt.style.visibility = 'hidden';
		pagSig.style.visibility = 'hidden';
		pagUlt.style.visibility = 'hidden';
	}
	else{
		if(pagActual>1){
			pagPri.style.visibility = 'visible';
			pagAnt.style.visibility = 'visible';
		}
		else{
			pagPri.style.visibility = 'hidden';
			pagAnt.style.visibility = 'hidden';
		}
		
		if(numPags - pagActual > 0){
			pagSig.style.visibility = 'visible';
			pagUlt.style.visibility = 'visible';
		}
		else{
			pagSig.style.visibility = 'hidden';
			pagUlt.style.visibility = 'hidden';
		}
	}
	
	var cajaPaginacion = '<input type="text" name="numPag" value="' + pagActual + '" onkeyup="consultaPaginaNum(event)" onfocus="this.select();" class="cajaPagina" maxlength="7" />';
	pagText.innerHTML = 'Pag. ' + cajaPaginacion + ' de ' + (numPags);
	document.getElementById("divPaginacion").style.visibility = "visible";
}

function bloquear(){
	valor_disabled_territorio = document.forms[0].territorio.disabled;
	valor_disabled_oficina = document.forms[0].oficina.disabled;
	valor_disabled_gestor = document.forms[0].gestor.disabled;
	
	document.forms[0].territorio.disabled = true;
	document.forms[0].oficina.disabled = true;
	document.forms[0].gestor.disabled = true;
	
	document.getElementById("btnNivelVinculacion").disabled = true;
	document.getElementById("btnClasificacion").disabled = true;
	document.getElementById("btnMargenOrdinario").disabled = true;
	document.getElementById("btnEtiqueta").disabled = true;
	document.getElementById("btnEdad").disabled = true;
	document.getElementById("btnCuotaRiesgoTotal").disabled = true;
	document.getElementById("btnTipoCliente").disabled = true;
	document.getElementById("btnCodEmpresa").disabled = true;
	
	document.forms[0].btnBuscar.disabled = true;
	document.forms[0].btnLimpiar.disabled = true;

	// $("#radio input").button("option", "disabled", true);
	page = "";
   	for (i_ = 0; i_ < document.forms[0].tipo_detalle.length; i_++){ 
      	 if (document.forms[0].tipo_detalle[i_].checked) {
      		 page = $("#radio_txt" + (i_ + 1)).html();
         	 break;
   		}
   	}
   	$("#radio_txt").html("Consultando la opci&oacute;n: <b>" + page + "</b>");
   	$("#radio_txt").css({"display": "inline"});
   	$("#radio").css({"display": "none"});
	
	// document.getElementById("buscarPagoHaberes").style.visibility = 'hidden';
	document.getElementById("btnExcel").src = 'images/btnExcel0.gif';
}

function desbloquear(hayResultados){
	var i;
	
	document.forms[0].territorio.disabled = valor_disabled_territorio;
	document.forms[0].oficina.disabled = valor_disabled_oficina;
	document.forms[0].gestor.disabled = valor_disabled_gestor;
	
	document.getElementById("btnNivelVinculacion").disabled = false;
	document.getElementById("btnClasificacion").disabled = false;
	document.getElementById("btnMargenOrdinario").disabled = false;
	document.getElementById("btnEtiqueta").disabled = false;
	document.getElementById("btnEdad").disabled = false;
	document.getElementById("btnCuotaRiesgoTotal").disabled = false;
	document.getElementById("btnTipoCliente").disabled = false;
	document.getElementById("btnCodEmpresa").disabled = false;
	
	document.forms[0].btnBuscar.disabled = false;
	document.forms[0].btnLimpiar.disabled = false;
	
	// $("#radio input").button("option", "disabled", false);
   	
   	$("#radio_txt").css({"display": "none"});
   	$("#radio").css({"display": "inline"});
   	
	if(hayResultados){
		document.getElementById("btnExcel").src = 'images/btnExcel1.gif';
	}
	
	// document.getElementById("buscarPagoHaberes").style.visibility = 'visible';
}

function mostrarResultados(){
	document.getElementById("divResultados").style.visibility='visible';
	document.getElementById("divResultados").style.position='relative';
}

function limpiarResultados(){
	document.getElementById("divResultados").style.visibility='hidden';
	document.getElementById("divResultados").style.position='absolute';
	
	document.getElementById("spanPagPri").style.visibility = 'hidden';
	document.getElementById("spanPagAnt").style.visibility = 'hidden';
	document.getElementById("spanPagSig").style.visibility = 'hidden';
	document.getElementById("spanPagUlt").style.visibility = 'hidden';
	document.getElementById("spanPagText").innerHTML = '';
	document.getElementById("divPaginacion").style.visibility = "hidden";
	
	/*var obj_tipo_detalle = document.forms[0].tipo_detalle;
	var i;
	for(i=0; i<obj_tipo_detalle.length; i++){
		obj_tipo_detalle[i].disabled = true;
	}*/
	
	hayResultados = false;
}

function mostrarProceso(estado){
	if(estado==1)
		document.getElementById("divProceso").style.visibility='visible';
	else
		document.getElementById("divProceso").style.visibility='hidden';
}

function estilos(cabeceras){
	var theRules;
	
	//obtener objeto de reglas css
	for(var i=0;i<document.styleSheets.length;i++){
		if(document.styleSheets[i].title=='cssEstilosCeldas'){
			if (document.styleSheets[i].cssRules) {
				theRules = document.styleSheets[i].cssRules;
			} else if (document.styleSheets[i].rules) {
				theRules = document.styleSheets[i].rules;
			}
			break;
		}
	}
	
	// modificar segun lista
	for(i=0; i<cabeceras.length; i++){
		theRules[i].style.width = cabeceras[i]["valor2"];
		theRules[i].style.textAlign = cabeceras[i]["valor3"];
		if(cabeceras[i]["valor4"]=='0')
			theRules[i].style.borderRight = '0px #ccc solid';
		else if(cabeceras[i]["valor4"]=='1')
			theRules[i].style.borderRight = '1px #ccc solid';
		else if(cabeceras[i]["valor4"]=='2')
			theRules[i].style.borderRight = '1px #000 solid';
	}
}

function estiloGrilla(){
	var theRules = new Array();
	for(var i=0;i<document.styleSheets.length;i++){
		if(document.styleSheets[i].title=='cssEstiloGrilla'){
			if (document.styleSheets[i].cssRules) {
				theRules = document.styleSheets[i].cssRules;
			} else if (document.styleSheets[i].rules) {
				theRules = document.styleSheets[i].rules;
			}
		}
	}
	return theRules[1].style;
}