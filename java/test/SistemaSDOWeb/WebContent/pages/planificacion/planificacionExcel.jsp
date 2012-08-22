<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@ taglib prefix="fn" uri="/WEB-INF/fn.tld"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld" %>
<HEAD>
<%@ page language="java" contentType="application/vnd.ms-excel; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<%=request.getContextPath()%>/pages/planificacion/planificacionListar.js"></script>
<link rel="stylesheet"	href="<%=request.getContextPath()%>/css/style.css"	type="text/css">
<TITLE></TITLE>

</HEAD>


<html:html>
<style type="text/css">
.text1 {	
	font-family: Arial, Helvetica, sans-serif; 
	font-size: 10px; 
	background-color: #F0F3F4; 
	color:"#264971"; 
	padding:2px;
	border: 1px solid #F0F3F4;
}
.text2 {	
	font-family: Arial, Helvetica, sans-serif; 
	font-size: 10px; 
	background-color: #FBFBFB; 
	color:"#264971"; 
	padding:2px;
	border: 1px solid #FBFBFB;
}
</style>


<script>

var isNN = (navigator.appName.indexOf("Netscape")!=-1);

indicadorFuncion = true;
indicadorCalculo = 0;

document.onkeypress = onlynumber;
<% String colorfila = "";
	String textofila = "";
	int i = 0;
 %>
 
 
 // NUEVO CODIGO PARA DAR FORMATO.
 
function oNumero(numero)
{
	//Propiedades 
	this.valor = numero || 0
	this.dec = -1;
	//Métodos 
	this.formato = numFormat;
	this.ponValor = ponValor;
	//Definición de los métodos 
	function ponValor(cad)
	{
		if (cad =='-' || cad=='+') return
		if (cad.length ==0) return
		if (cad.indexOf('.') >=0)
			this.valor = parseFloat(cad);
		else 
			this.valor = parseInt(cad);
	} 
	function numFormat(dec, miles)
	{
	var num = this.valor, signo=3, expr;
	var cad = ""+this.valor;
	var ceros = "", pos, pdec, i;
	for (i=0; i < dec; i++)
	ceros += '0';
	pos = cad.indexOf('.')
	if (pos < 0)
		cad = cad+"."+ceros;
	else
	{
		pdec = cad.length - pos -1;
		if (pdec <= dec) {
			for (i=0; i< (dec-pdec); i++)
				cad += '0';
		}
		else {
			num = num*Math.pow(10, dec);
			num = Math.round(num);
			num = num/Math.pow(10, dec);
			cad = new String(num);
		}
	}
	pos = cad.indexOf('.')
	if (pos < 0) pos = cad.lentgh
	if (cad.substr(0,1)=='-' || cad.substr(0,1) == '+') 
		   signo = 4;
	if (miles && pos > signo)
		do{
			expr = /([+-]?\d)(\d{3}[\.\,]\d*)/
			cad.match(expr)
			cad=cad.replace(expr, RegExp.$1+','+RegExp.$2)
			}
	while (cad.indexOf(',') > signo)
		if (dec<0) cad = cad.replace(/\./,'')
			return cad;
	}
}//Fin del objeto oNumero:


 // FIN DE CODIGO PARA FORMATOS
function onlynumber(DnEvents) {
	//window.event.srcElement.value = 12345
	//alert(window.event.srcElement.name);
	k = (isNN) ? DnEvents.which : window.event.keyCode;
	a = (isNN) ? DnEvents.target.name : window.event.srcElement.name;
	if (a!=null){
	
		if(k==8 || k==0)
			return true;

		if ((k < 48) || (k > 57)) {
			if(isNN)
			return false;
			else
			event.returnValue = false;
		}
	}
}

function elegirGestor() {
	var form = document.forms[0];         
    form.action = "reportePPGAction.do?method=inicioReportePGGAcciones";
    form.method="post";
    form.submit();
}

//function decide(){
//	var form = document.forms[0];
//	//var valorSel="";
	
//	alert("Ingreso 1");
//	//calcularDesvPptoAjustado(true);
//	//calculaProyeccion(true)
//	//calcularAjuste(true)
//	calcular(true)
//	if(form.porAlcanzado) {
//		alert("Ingreso 2");
//		if(form.porAlcanzado.length) {
//			alert("Ingreso 3");
//			for (i=0; i<form.porAlcanzado.length; i++) {
//				eval(form.ajusPpto[i].value = 100);
//			}
//		}
//	}
//}

function decide(valor){
	if (valor==0) {
		calcularDesvPptoAjustado(true);		
	}
	else {
		if (valor==1){
			calculaProyeccion(true);
		} else {
			if (valor==2) {
				calcularAjuste(true);
			}
			else {							
				calcular(true);
			}
		}
	}
}

function calcularDesvPptoAjustado(mensaje)  {
	var form = document.forms[0];
	
	indicadorFuncion = true;
	
	for(var i=0; i<form.monto.length; i++) {
		if ((form.indAfecta[i].value=="S") && ((eval(form.ajusPpto[i].value)==0) || (eval(form.ajusPpto[i].value)=="null")))
		{
			eval(form.ajusPpto[i].value = 100);
		}


		
		if (form.indAfecta[i].value=="S")
		{
		 var numero = new oNumero(eval(form.desvPpto[i].value));
		 form.desvPpto[i].value = numero.formato(2, true); 
		 eval(form.saldMediDici[i].value);
		 eval(form.monto[i].value);
		 eval(form.ajusPpto[i].value);
		
		 eval(form.desvAjusPpto[i].value= (parseFloat(form.saldMediDici[i].value) * parseFloat(form.ajusPpto[i].value)/100) - parseFloat(form.monto[i].value));

		 eval(form.desvPpto[i]); 
		 eval(form.saldMediDici[i]);
		 eval(form.monto[i]);
		}
	} // for

	if (indicadorFuncion) 	{

		sumaDesvPptoAjustadoSubClase = 0;

		indicadorHayHijos = false;
		
		for(var k=form.monto.length-1; k>=0; k--) {
	
			if ((eval(form.indHijo[k].value) == 0) &&	(eval(form.indSubClase[k].value) == 0))
			{
			} 
			else 
			{
				if ((eval(form.indHijo[k].value) != 0) && (eval(form.indSubClase[k].value) != 0))
				{
					sumaDesvPptoAjustadoSubClase = sumaDesvPptoAjustadoSubClase + parseFloat(eval(form.desvAjusPpto[k].value));
					indicadorHayHijos = true;
				}
				else 
				{
					if (indicadorHayHijos) 
					{
						eval(form.desvAjusPpto[k].value= sumaDesvPptoAjustadoSubClase);
						sumaDesvPptoAjustadoSubClase = 0;
						indicadorHayHijos = false;
					}
				}
			}
		} //for
		
		for(var i=0; i<form.monto.length; i++) {
		
		// Sumamos todas las subclases (indicadorSubClase!=0 e indicadorHijo==0)
			if ((eval(form.indHijo[i].value) == 0) && (eval(form.indSubClase[i].value) == 0)) 
			{
				sumaDesvPptoAjustadoClase = 0;
				indicadorHayHijos = false;

				for(var j=0; j<form.monto.length; j++) 
				{
					if ((eval(form.indHijo[j].value) == "0") &&
						(eval(form.indSubClase[j].value) != "0") &&
						(eval(form.indClase[j].value) == eval(form.indClase[i].value))) 
					{
						sumaDesvPptoAjustadoClase = sumaDesvPptoAjustadoClase + parseFloat(eval(form.desvAjusPpto[j].value));
						indicadorHayHijos = true;
					}
				}
				if (indicadorHayHijos) 
				{
					eval(form.desvAjusPpto[i].value = sumaDesvPptoAjustadoClase);
				}
			}			
			eval(form.desvAjusPpto[i]);
		}
		indicadorCalculo=1;
		if (mensaje) 
		{
			alert("Se ha modificado el presupuesto")
		}
	} 
	else 
	{
		return false;
	}

} // function

function calculaProyeccion(mensaje) {
	var form = document.forms[0];
	
	calcularDesvPptoAjustado(false);
	
	for(var i=0; i<form.monto.length; i++) 
	{
		
		if ((form.indAfecta[i].value=="S") &&	((form.nroMesesFalt[i].value==0) || (form.nroMesesFalt[i].value=="null")))
		{
			eval(form.nroMesesFalt[i].value = (parseFloat(form.preReferencia.value) - parseFloat(form.mes[i].value) + 1));
		}

		// calculamos los valores de los hijos
		if (form.indAfecta[i].value=="S") 
		{

			eval(form.desvPpto[i].value); 
		 	eval(form.saldMediDici[i].value);
		 	eval(form.monto[i].value);

			eval(form.desvAjusPpto[i].value= ((parseFloat(form.saldMediDici[i].value) * parseFloat(form.ajusPpto[i].value))/100) - parseFloat(form.monto[i].value));
			eval(form.proyCrecMens[i].value= (parseFloat(form.desvAjusPpto[i].value) / parseFloat(form.nroMesesFalt[i].value)));

			eval(form.desvPpto[i].value); 
		 	eval(form.saldMediDici[i].value);
		 	eval(form.monto[i].value);
		}
	} //for
	
	if (indicadorFuncion) 
	{
		sumaCrecimientoMensualSubClase = 0;

		indicadorHayHijos = false;
		for(var k=form.monto.length-1; k>=0; k--) 
		{
			// sumamos los resultados de los hijos de una subclase
			// trabajamos en base a los indicadores clase + subclase + hijo - concatenados - que estan en orden.
			
			if ((eval(form.indHijo[k].value) == 0) &&	(eval(form.indSubClase[k].value) == 0))
			{
			} 
			else 
			{
				if ((eval(form.indHijo[k].value) != 0) && (eval(form.indSubClase[k].value) != 0))
				{
					sumaCrecimientoMensualSubClase = sumaCrecimientoMensualSubClase + parseFloat(eval(form.proyCrecMens[k].value));
					indicadorHayHijos = true;
				}
				else 
				{
					if (indicadorHayHijos) 
					{
						eval(form.proyCrecMens[k].value = sumaCrecimientoMensualSubClase);
						sumaCrecimientoMensualSubClase = 0;
						indicadorHayHijos = false;
					}
				}
			}
		}//for
		
		for(var i=0; i<form.monto.length; i++)
		{
		// Sumamos todas las subclases (indicadorSubClase!=0 e indicadorHijo==0)
			if ((eval(form.indHijo[i].value) == 0) && (eval(form.indSubClase[i].value) == 0)) 
			{
				sumaCrecimientoMensualClase = 0;
				indicadorHayHijos = false;

				for(var j=0; j<form.monto.length; j++) 
				{
					if ((eval(form.indHijo[j].value) == "0") &&
						(eval(form.indSubClase[j].value) != "0") &&
						(eval(form.indClase[j].value) == eval(form.indClase[i].value)))
					{
						sumaCrecimientoMensualClase = sumaCrecimientoMensualClase + parseFloat(eval(form.proyCrecMens[j].value));
						indicadorHayHijos = true;
					}
				}
				if (indicadorHayHijos)
				{
					eval(form.proyCrecMens[i].value = sumaCrecimientoMensualClase);
				}
			}
			eval(form.proyCrecMens[i].value);
			eval(form.desvAjusPpto[i].value);
		}//for
		
	} 
	else 
	{
		return false;
	}
	
	/*Calculos de Factor Ajuste Saldo Puntual Histórico Bajas Objetivo Oficina */

	if (indicadorFuncion) 
	{	
	
		for(var i=0; i<form.monto.length; i++) 
		{
						
				//le damos el formato necesario para calcular
				eval(form.desvPpto[i].value);
				//eval(form.porAlcanzado[i].value);
				eval(form.proyCrecMens[i].value);
				
				if (form.indAfecta[i].value=="S")
				{
					eval(form.histBajas[i].value);
				}
				
				// calculamos los valores de los hijos
				if (form.indAfecta[i].value=="S")
				{
					eval(form.proyAjusMens[i].value = (parseFloat(form.proyCrecMens[i].value) * parseFloat(form.factAjusSaldPunt[i].value)));
					eval(form.metaMesSaldPunt[i].value = (parseFloat(form.proyAjusMens[i].value) + parseFloat(form.histBajas[i].value)));
				}
				
				//damos el formato necesario para mostrar
				eval(form.desvPpto[i].value);
				
				if (form.indAfecta[i].value=="S")
				{
					eval(form.histBajas[i].value);
				}
	
		} // for
	} // if
	
	if (indicadorFuncion) 
	{
		sumaAjusteMensualSubClase = 0;
		sumaMetaMesSaldoPuntualSubClase = 0;		

		indicadorHayHijos = false;

		for(var k=form.monto.length-1; k>=0; k--)
		{
		
			if ((eval(form.indHijo[k].value) == 0) &&	(eval(form.indSubClase[k].value) == 0))
			{
			} 
			else 
			{
				if ((eval(form.indHijo[k].value) != 0) && (eval(form.indSubClase[k].value) != 0))
				{
					sumaAjusteMensualSubClase = sumaAjusteMensualSubClase + parseFloat(eval(form.proyAjusMens[k].value));
					sumaMetaMesSaldoPuntualSubClase = sumaMetaMesSaldoPuntualSubClase + parseFloat(eval(form.metaMesSaldPunt[k].value));
					indicadorHayHijos = true;
				} 
			else 
				{
					if (indicadorHayHijos)
					{
						eval(form.proyAjusMens[k].value = sumaAjusteMensualSubClase);
						eval(form.metaMesSaldPunt[k].value = sumaMetaMesSaldoPuntualSubClase);
						sumaAjusteMensualSubClase = 0;
						sumaMetaMesSaldoPuntualSubClase = 0;						
						indicadorHayHijos = false;
					}
				}
			}
		}
		
		for(var i=0; i<form.monto.length; i++)
		{
		// Sumamos todas las subclases (indicadorSubClase!=0 e indicadorHijo==0)
			if ((eval(form.indHijo[i].value) == 0) && (eval(form.indSubClase[i].value) == 0))
			{
				sumaAjusteMensualClase = 0;
				sumaMetaMesSaldoPuntualClase = 0;
				indicadorHayHijos = false;

				for(var j=0; j<form.monto.length; j++) 
				{
					if ((eval(form.indHijo[j].value) == "0") &&
						(eval(form.indSubClase[j].value) != "0") &&
						(eval(form.indClase[j].value) == eval(form.indClase[i].value)))
					{
						sumaAjusteMensualClase = sumaAjusteMensualClase + parseFloat(eval(form.proyAjusMens[j].value));
						sumaMetaMesSaldoPuntualClase = sumaMetaMesSaldoPuntualClase + parseFloat(eval(form.metaMesSaldPunt[j].value));
						indicadorHayHijos = true;
					}
				}
				
				if (indicadorHayHijos) 
				{
					eval(form.proyAjusMens[i].value = sumaAjusteMensualClase);
					eval(form.metaMesSaldPunt[i].value = sumaMetaMesSaldoPuntualClase);
				}
			}
			
			eval(form.proyCrecMens[i].value);
			eval(form.proyAjusMens[i].value);
			eval(form.metaMesSaldPunt[i].value);
		}
		
		indicadorCalculo=2;
		if (mensaje) 
		{
			alert("Los cálculos de la proyección se han llevado a cabo.")
		}
	} 
	else 
	{
		return false;
	}
	
} //function


function calcularAjuste(mensaje) {
	var form = document.forms[0];
	calculaProyeccion(false);

	if (indicadorFuncion)
	{
		for(var i=0; i<form.monto.length; i++)
		{
			if ((form.indAfecta[i].value=="S") && ((eval(form.factAjusTerri[i].value)==0) || (form.factAjusTerri[i].value=="null"))) {
				 eval(form.factAjusTerri[i].value = form.metaMesSaldPunt[i].value);
				}
		}
		indicadorCalculo=3;
		if (mensaje) 
		{
			alert("Ajuste territorial ha sido ingresado");
		}
	}
	else 
	{
		return false;
	}
}


function calcular(mensaje){
	var form = document.forms[0];
	
	calcularAjuste(false);

	if (indicadorFuncion)
	{
		for(var i=0; i<form.monto.length; i++)
		{

			if ((form.indAfecta[i].value=="S") && ((eval(form.factAjusTerri[i].value)==0) || (form.factAjusTerri[i].value=="null"))) {
				eval(form.factAjusTerri[i].value = form.metaMesSaldPunt[i].value);
			}
		
			if ((form.indAfecta[i].value=="S") && ((eval(form.nroMesesFalt[i].value)==0) || (form.nroMesesFalt[i].value=="null"))) 
			{
				 alert("No se puede realizar calculos con valores 0 o nulos.");
				 indicadorFuncion = false;
				 return false;
			} 
			else 
			{
				//le damos el formato necesario para calcular
				//eval(form.porAlcanzado[i].value);
				eval(form.desvPpto[i].value); 
				eval(form.proyCrecMens[i].value); 
				eval(form.factAjusTerri[i].value);
	
				//damos el formato necesario para mostrar
				eval(form.factAjusTerri[i].value);
				//eval(form.porAlcanzado[i].value);
				eval(form.desvPpto[i].value);
				
			}
		}
	}
	
	if (indicadorFuncion) 
	{
		sumaMetaGerenteOficinaSubClase = 0;

		indicadorHayHijos = false;

		for(var k=form.monto.length-1; k>=0; k--) 
		{
			// sumamos los resultados de los hijos de una subclase
			// trabajamos en base a los indicadores clase + subclase + hijo - concatenados - que 
			// estan en orden.
			
			if ((eval(form.indHijo[k].value) == 0) && (eval(form.indSubClase[k].value) == 0))
			{
			} 
			else 
			{
				if ((eval(form.indHijo[k].value) != 0) && (eval(form.indSubClase[k].value) != 0)) {
					sumaMetaGerenteOficinaSubClase = sumaMetaGerenteOficinaSubClase + parseFloat(form.factAjusGereOfic[k].value);
					indicadorHayHijos = true;
				} 
				else 
				{
					if (indicadorHayHijos) 
					{
											
						eval(form.factAjusGereOfic[k].value = sumaMetaGerenteOficinaSubClase);
						sumaMetaGerenteOficinaSubClase = 0;
						indicadorHayHijos = false;
					}
				}
			}
		}
		
		for(var i=0; i<form.monto.length; i++) 
		{
		// Sumamos todas las subclases (indicadorSubClase!=0 e indicadorHijo==0)
			if ((eval(form.indHijo[i].value) == 0) && (eval(form.indSubClase[i].value) == 0)) {
				sumaMetaGerenteOficinaClase = 0;
				indicadorHayHijos = false;

				for(var j=0; j<form.monto.length; j++) 
				{
					if ((eval(form.indHijo[j].value) == "0") &&
						(eval(form.indSubClase[j].value) != "0") &&
						(eval(form.indClase[j].value) == eval(form.indClase[i].value)))
					{
						sumaMetaGerenteOficinaClase = sumaMetaGerenteOficinaClase + parseFloat(eval(form.factAjusGereOfic[j].value));
						indicadorHayHijos = true;
					}
				}
				
				if (indicadorHayHijos) 
				{
					eval(form.factAjusGereOfic[i].value = sumaMetaGerenteOficinaClase);
				}
			}
			
			eval(form.proyCrecMens[i].value);
			eval(form.proyAjusMens[i].value);
			eval(form.metaMesSaldPunt[i].value);
		}
		if (mensaje) 
		{
			alert("Cálculos concluidos")
		}
	} 
	else 
	{
		return false;
	}
	
} //function

</script>

<BODY>
<table align="center" width="100%" height="%" cellspacing="0" cellpadding="0">
	<tr>
		<td width="100%" align="left"  valign="top">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td><img src="<%=request.getContextPath()%>/images/esq_izq.jpg"></td>	
					<td width="200" class="textocentradoblanco">PLANIFICACI&Oacute;N</td>	
					<td><img src="<%=request.getContextPath()%>/images/esq_der.jpg"></td>	
				</tr>						
			</table>
		</td>	
	</tr>
	<tr>
		<td style="border: 2px solid #264971;padding:20px;" valign="top" height="%" align="center">


		<!-- **** AQUI EL RESTO DE CÓIGO DE LA PÁINA-->
		
		<div id="pagina" style="overflow:auto;">
			<html:form
				action="/planificacionAction" styleId="planeacionForm">	
				<!-- Border Table Build  ----------------------------->
				<table border="0" cellpadding="0" cellspacing="0" width="938">
					<tr>
						
					</tr>
					<tr>
						<td>
						<table border="0" cellpadding="0" cellspacing="0" width="100%">
							
							<tr>
								<td class="BordeTabla"></td>
								<td class="BordeTabla"></td>
								<td colspan="2" valign="top" ></td>
								<td width="100%">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="0%" ></td>
										<td width="80" ></td>
										<td width="0%" ></td>
									</tr>
									<tr>
										<td height="67" ></td>
										<!-- Contenido -->
										<td>
										<table width="100%" border="0">
											<tr>
												<td>
												<table width="100%" cellpadding="0" cellspacing="0" bgcolor="DBE7F3">
													<tr>
														<td style="font-size: 9pt;"  class="celda1cabecera">Oficina: </td>
														<td class="colorfila1"><html:select property="codOficina" styleClass="combo" onchange="javascript:buscar();">												
															<c:if test="${listaOficina != null}">
																<c:forEach var="lista" items="${listaOficina}">
																	<html:option value="${lista.codOfic}"><c:out value="${lista.codNomOficina}" /></html:option>
																</c:forEach>
															</c:if>
														</html:select></td>
														<TD></TD>
														<td style="font-size: 9pt;"  class="celda1cabecera">Presupuesto de Referencia: </td>
														<td class="colorfila1"><html:select property="preReferencia" styleClass="combo" onchange="javascript:buscar();">												
															<c:if test="${listaPresup != null}">
																<c:forEach var="lista" items="${listaPresup}">
																	<html:option value="${lista.codelem}"><c:out value="${lista.valor1}" /></html:option>
																</c:forEach>
															</c:if>
														</html:select></td>																					
													</tr>
													<tr>
														<td width="12%" style="font-size: 9pt;"  class="celda1cabecera">Mes de Planificación</td>
														<td width="24%" class="colorfila1"><html:select property="mesPlanificacion" styleClass="combo" onchange="javascript:buscar();">												
																	<html:option value="01">Enero</html:option>
																	<html:option value="02">Febrero</html:option>
																	<html:option value="03">Marzo</html:option>
																	<html:option value="04">Abril</html:option>
																	<html:option value="05">Mayo</html:option>
																	<html:option value="06">Junio</html:option>
																	<html:option value="07">Julio</html:option>
																	<html:option value="08">Agosto</html:option>
																	<html:option value="09">Setiembre</html:option>
																	<html:option value="10">Octubre</html:option>
																	<html:option value="11">Noviembre</html:option>
																	<html:option value="12">Diciembre</html:option>
														</html:select></td>
														<TD width="1%"></TD>
														<td width="13%" style="font-size: 9pt;" class="celda1cabecera">Año</td>
														<td width="19%" class="colorfila1"><html:select property="anho" styleClass="combo" onchange="javascript:buscar();">												
															<c:if test="${listaAnhos != null}">
																<c:forEach var="lista" items="${listaAnhos}">
																	<html:option value="${lista.codelem}"><c:out value="${lista.valor1}" /></html:option>
																</c:forEach>
															</c:if>
														</html:select></td>											
													</tr>										
												</table>
												</td>
											</tr>
										</table>
										</td>
										<!-- Fin Contenido -->
										<td class="busqueda"></td>
									</tr>
									<tr>
										<td height="2"></td>
										<td></td>
										<td></td>
									</tr>
								</table>
								<!-- --------------------------- --></td>
								<td class="BordeTabla"></td>					
							</tr>
						</table>
					</tr>		
				</table>
					<table width="938" height="80" border="1" cellspacing="0" >
			  <tr>
			    <td colspan="11" align="center" class="celda1cabecera" ><span class="Estilo4">Saldo Medio Expresado en Miles de Soles </span></td>
			    <td width="55" rowspan="2" align="center" class="celda1cabecera"><span class="Estilo2">Factor de Ajuste Saldo Puntual </span></td>
			    <td width="55" rowspan="2" align="center" class="celda1cabecera"><span class="Estilo2">Hist&oacute;rico Bajas </span></td>
			    <td colspan="3" align="center" class="celda1cabecera"><span class="Estilo4">Facturaci&oacute;n Expresada en Miles de Soles </span></td>
			  </tr>
			  <tr>

			    <td width="37" align="center" class="celda1cabecera"><span class="Estilo2">Prioridad</span></td>
			    <td width="250" align="center" class="celda1cabecera"><span class="Estilo2">Epigrafe</span></td>
			    <td width="48" align="center" class="celda1cabecera"><span class="Estilo2">Presup </span> <span class="Estilo4"><c:out value="${mesEvalMostrar}"/></span></td>
			    <td width="48" align="center" class="celda1cabecera"><span class="Estilo2"><c:out value="${mesEvalMostrarAnte}"/></span></td>
			    <td width="48" align="center" class="celda1cabecera"><span class="Estilo2">Var % mes</span></td>
			    <td width="48" align="center" class="celda1cabecera"><span class="Estilo2">% Avance</span></td>
			    <td width="48" align="center" class="celda1cabecera"><span class="Estilo2">Desv. Ppto. </span></td>
			    <td width="48" align="center" class="celda1cabecera"><span class="Estilo2">Ajust % Presup </span></td>
			    <td width="48" align="center" class="celda1cabecera"><span class="Estilo2">Desv. Presup. Ajust </span></td>
			    <td width="48" align="center" class="celda1cabecera"><span class="Estilo2">N. Meses Faltant </span></td>
			    <td width="48" align="center" class="celda1cabecera"><span class="Estilo2">Crec. Prom. Mens. </span></td>
			    <td width="64" align="center" class="celda1cabecera"><span class="Estilo2">Objetivo Oficina</span></td>
			    <td width="64" align="center" class="celda1cabecera"><span class="Estilo2">Ajuste Territorial </span></td>
			    <td width="63" align="center" class="celda1cabecera"><span class="Estilo2">Asignaci&oacute;n a Gte Oficina </span></td>
			  </tr>
			  <c:if test="${indMostrar=='1'}">
			
			  <logic:present name ="listaPlanes">
				<bean:define id="listaDatos" name="listaPlanes" scope="session" />
				<c:forEach items="${listaDatos}" var="objBean">
				<%  
					if (i%2 != 0) {
					colorfila = "colorfila1";
					textofila = "text1";
					} else {
					colorfila = "colorfila2";
					textofila = "text2";
					}
					i++;
				%>
				<tr class="cuerpoTabla">
				<INPUT type="hidden" name="indAfecta" value=<c:out value="${objBean.indAfecta}"/>>
				<INPUT type="hidden" name="saldMediDici" value=<c:out value="${objBean.saldMediDici}"/>>
				<INPUT type="hidden" name="saldMediJunio" value=<c:out value="${objBean.saldMediJunio}"/>>
				<INPUT type="hidden" name="indHijo" value=<c:out value="${objBean.indHijo}"/>>
				<INPUT type="hidden" name="indSubClase" value=<c:out value="${objBean.indSubClase}"/>>
				<INPUT type="hidden" name="indClase" value=<c:out value="${objBean.indClase}"/>>
				<INPUT type="hidden" name="proyAjusMens" value=<c:out value="${objBean.proyAjusMens}"/>>
				<INPUT type="hidden" name="mes" value=<c:out value="${objBean.mes}"/>>
				<INPUT type="hidden" name="mesEval" value=<c:out value="${objBean.mesEval}"/>>
				<INPUT type="hidden" name="montoMesSig" value=<c:out value="${objBean.montoMesSig}"/>>


				<td class="<%=colorfila %>">
					<c:if test="${objBean.prioridad !=99}">
						<input type="text" class="textBlanco" name="prioridad" value=<c:out value="${objBean.prioridad}"/> size="2"/>
					</c:if>
					<c:if test="${objBean.prioridad == 99}">
						<input type="text" class="textBlanco" name="prioridad" value="" size="2"/>
					</c:if>
				</td>
				<td class="<%=colorfila %>"><c:out value="${objBean.nomEpigrafe}"/></td>
				<c:if test="${mesPresupuesto=='07'}">
				<td class="<%=colorfila %>"><input type="text" class="<%=textofila %>" name="saldMediJunio" value=<c:out value="${objBean.saldMediJunio}"/> readonly="readonly" size="8"/></td>
				</c:if>
				<c:if test="${mesPresupuesto=='12'}">
				<td class="<%=colorfila %>"><input type="text" class="<%=textofila %>" name="saldMediDici" value=<c:out value="${objBean.saldMediDici}"/> readonly="readonly" size="8"/></td>
				</c:if>
				<td width="10%" class="<%=colorfila %>"><input type="text" class="<%=textofila %>" name="monto" value=<c:out value="${objBean.monto}"/> readonly="readonly" size="8"/></td>
				<td class="<%=colorfila %>"><c:out value="${objBean.varMes}"/></td>
				<td class="<%=colorfila %>"><c:if test="${objBean.codEpigrafe=='0000900' || objBean.codEpigrafe=='0001000'}">
						<c:if test="${objBean.porAlcanzado > 110}">
							<input type="text" class="textRojo" name="porAlcanzado"
								value=<c:out value="${objBean.porAlcanzado}"/> readonly="readonly" size="3"/>
						</c:if>
						<c:if test="${objBean.porAlcanzado < 80}">
							<input type="text" class="textVerde" name="porAlcanzado"  
								value=<c:out value="${objBean.porAlcanzado}"/> readonly="readonly" size="3"/>
						</c:if>
						<c:if test="${objBean.porAlcanzado > 80 && objBean.porAlcanzado < 110}">
							<input type="text" class="textAmbar" name="porAlcanzado"  
								value=<c:out value="${objBean.porAlcanzado}"/> readonly="readonly" size="3"/>
						</c:if>
					</c:if>
					<c:if test="${objBean.codEpigrafe!='0000900' && objBean.codEpigrafe!='0001000'}">
						<c:if test="${objBean.porAlcanzado > 110}">
							<input type="text" class="textVerde" name="porAlcanzado" 
								value=<c:out value="${objBean.porAlcanzado}"/> readonly="readonly" size="3"/>
						</c:if>
						<c:if test="${objBean.porAlcanzado < 80}">
							<input type="text" class="textRojo" name="porAlcanzado" 
								value=<c:out value="${objBean.porAlcanzado}"/> readonly="readonly" size="3"/>
								
						</c:if>
						<c:if test="${objBean.porAlcanzado > 80 && objBean.porAlcanzado < 110}">
							<input type="text" class="textAmbar" name="porAlcanzado"  
								value=<c:out value="${objBean.porAlcanzado}"/> readonly="readonly" size="3"/>
						</c:if>
					</c:if>
				</td>
				<td class="<%=colorfila %>"><input type="text" class="<%=textofila %>" name="desvPpto" value=<c:out value="${objBean.desvPpto}"/> readonly="readonly" size="10"/></td>
				<td class="<%=colorfila %>">
					<c:if test="${objBean.ajusPpto == 0 && objBean.indAfecta == 'S'}">
						<input type="text" class="textBlanco" name="ajusPpto" 
							value=<c:out value="${objBean.ajusPpto}"/> size="10"/>
					</c:if>
					<c:if test="${objBean.ajusPpto == 0 && objBean.indAfecta == 'N'}">
						<input type="text" class="textNegro" name="ajusPpto"  
							value=<c:out value="${objBean.ajusPpto}"/> readonly="readonly" size="10"/>
					</c:if>
					<c:if test="${objBean.ajusPpto != 0}">
						<input type="text" class="textBlanco" name="ajusPpto"  
							value=<c:out value="${objBean.ajusPpto}"/> size="10"/>
					</c:if>
				</td>
				<td class="<%=colorfila %>"><input type="text" class="<%=textofila %>" name="desvAjusPpto" value=<c:out value="${objBean.desvAjusPpto}"/> readonly="readonly" size="3"/></td>
				<td class="<%=colorfila %>">
					<c:if test="${objBean.nroMesesFalt == 0 && objBean.indAfecta == 'S'}">
						<input type="text" class="textBlanco" name="nroMesesFalt"  
							value=<c:out value="${objBean.nroMesesFalt}"/> size="10"/>
					</c:if>
					<c:if test="${objBean.nroMesesFalt == 0 && objBean.indAfecta == 'N'}">
						<input type="text" class="textNegro" name="nroMesesFalt"  
							value=<c:out value="${objBean.nroMesesFalt}"/> readonly="readonly" size="10"/>
					</c:if>
					<c:if test="${objBean.nroMesesFalt != 0}">
						<input type="text" class="textBlanco" name="nroMesesFalt"  
							value=<c:out value="${objBean.nroMesesFalt}"/> size="10"/>
					</c:if>
				</td>
				<td class="<%=colorfila %>"><input type="text" class="<%=textofila %>" name="proyCrecMens" value=<c:out value="${objBean.proyCrecMens}"/> readonly="readonly" size="10"/></td>
				<td class="<%=colorfila %>">
					<c:if test="${objBean.indAfecta == 'S'}">
						<input type="text" class="<%=textofila %>" name="factAjusSaldPunt" size="10"  
							value=<c:out value="${objBean.factAjusSaldPunt}"/> readonly="readonly" />
					</c:if>
					<c:if test="${objBean.indAfecta == 'N'}">
						<input type="text" class="textNegro" name="factAjusSaldPunt" 
							value=<c:out value="${objBean.factAjusSaldPunt}"/> readonly="readonly" size="10"/>
					</c:if>
				</td>
				<td class="<%=colorfila %>">
					<c:if test="${objBean.indAfecta == 'S'}">
						<input type="text" class="<%=textofila %>" name="histBajas" size="10" 
							value=<c:out value="${objBean.histBajas}"/> readonly="readonly" />	
					</c:if>
					<c:if test="${objBean.indAfecta == 'N'}">
						<input type="text" class="textNegro" name="histBajas"  
							value=<c:out value="${objBean.histBajas}"/> readonly="readonly" size="10"/>
					</c:if>
				</td>
				<td class="<%=colorfila %>"><input type="text" class="<%=textofila %>" name="metaMesSaldPunt" value=<c:out value="${objBean.metaMesSaldPunt}"/> readonly="readonly" size="3"/></td>
				<td class="<%=colorfila %>">
					<c:if test="${objBean.indAfecta == 'S'}">
						<input type="text" class="textBlanco" name="factAjusTerri" size="10" 
							value=<c:out value="${objBean.factAjusTerri}"/> />
					</c:if>
					<c:if test="${objBean.indAfecta == 'N'}">
						<input type="text" class="textNegro" name="factAjusTerri"  
							value=<c:out value="${objBean.factAjusTerri}"/> readonly="readonly" size="10"/>
					</c:if>
				</td>
				<td class="<%=colorfila %>">
					<c:if test="${objBean.indAfecta == 'S'}">
						<input type="text" class="textBlanco" name="factAjusGereOfic" size="10"
							value=<c:out value="${objBean.factAjusGereOfic}"/> />
					</c:if>
					<c:if test="${objBean.indAfecta == 'N'}">
						<input type="text" class="textNegro" name="factAjusGereOfic"  
							value=<c:out value="${objBean.factAjusGereOfic}"/> readonly="readonly" size="10"/>
					</c:if>
				</td>
				</tr>
				</c:forEach>
				</logic:present>	
				</c:if>
				<c:if test="${indMostrar=='0'}">									  
					<label style="font-style: italic;">
					No se encontraron Datos
					</label>
				</c:if>
				
			</table>
				<table width="938">
				<tr>
				<td width="110"></td>
				<td width="516"></td>
				<td width="296"></td>
				</tr>
				<tr>
				<td>
				</td>
				<td align="center">
				<c:if test="${indMostrar=='1'}">
					<c:if test="${sessionScope.gestor.codigoPerfil=='GTE'}">
					<input type="button" value="Esfuerzos Adicionales" onClick="javascript:elegirGestor()"  class="botonnew">
					<input type="button" name="calculo" value="Calcular" onClick="javascript:decide(indicadorCalculo);"  class="botonnew">
					<input type="button" name="grabo" value="Grabar" onClick="javascript:envioDatos()"  class="botonnew">
					<input type="button" name="imprime2" value="Historial del A&ntilde;o" onClick="Javascript:historial()"  class="botonnew">
					</c:if>
				</c:if>
				</td>
				<td>
				<c:if test="${indMostrar=='1'}">
					<input type="button" name="imprime" value="Imprimir" onClick="Javascript:imprimir()"  class="botonnew">
					<input type="button" name="exporta" value="Excel" onClick="Javascript:excel()"  class="botonnew">
					<a href="<%=request.getContextPath()%>/pages/planificacion/planExcel.jsp">Excel</a>
				</c:if>
				</td>
				</tr>
				<tr>
				<td>
				</td>
				<td>
				</td>
				<td>
				</td>
				</tr>
				</table>
				
				<!--FIN  Border Table Build ----------------------------->
			</html:form></div>
		
		<!-- **** FIN EL RESTO DE CÓIGO DE LA PÁINA-->
	
	
		</td>
	</tr>
</table>
</BODY>
</html:html>