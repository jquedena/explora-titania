<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@ taglib prefix="fn" uri="/WEB-INF/fn.tld"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>

<fmt:setLocale value="en_US"/>
<html:html>
<head>
	<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	<meta http-equiv="content-type" content="text/html; charset=ISO-8859-1" >
	<meta http-equiv='PRAGMA' content='NO-CACHE'>
	<meta http-equiv='EXPIRES' content='0'>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
	<style>
		table.DataGrid td input {
			width:50px;
			padding-left: 3px;
			padding-right: 3px;
		}
	</style>
	<title></title>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.2.6.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/js-preparaJSONExcel.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/pages/planificacion/planificacionListar.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/pages/planificacion/planificacionListar2.js"></script>
	<script type="text/javascript">
		var codPerfil="<c:out value="${sessionScope.gestor.codigoPerfil}"/>";
		var session_error="<c:out value="${sessionScope.ERROR_SDO}"/>";
		$(function() {
			test = new Boolean(session_error);
			if(test) {
				if(session_error.toLowerCase() == "") {
				} else if(session_error.toLowerCase() != "ok"){
					alert(session_error);
				} else {
					alert("Actualizaci\u00F3n correcta");
				}
			}
		
			$(".DataGrid .Epigrafe").find("td").each(function() {
				if( $(this).hasClass('textVerde') || $(this).hasClass('textAmbar') || $(this).hasClass('textRojo') ) {
					$(this).css({"fontWeight": "bold"});
				} else {
					$(this).addClass("Node");
				}
			});
			
			$(".DataGrid .Resaltar").find("td").each(function() {
				if( $(this).hasClass('textVerde') || $(this).hasClass('textAmbar') || $(this).hasClass('textRojo') ) {
					$(this).css({"fontWeight": "bold"});
				} else {
					$(this).css({"color": "#4c84b8", "fontWeight": "bold"});
					$(this).find('input').each(function() {
						$(this).css({"color": "#4c84b8", "fontWeight": "bold"});
					});
				}			
			});
			
			$(".Col1, .Col17").each(function() {
				$(this).addClass("Node");
			});		
			
			/*$('input:text').change(function() {
				if(parseFloat($(this).val()) != parseFloat($(this).attr('valueOld'))) {
					$("input[name=exporta]").attr('disabled', true);
					$("input[name=imprime2]").attr('disabled', true);
				} else {
					$("input[name=exporta]").attr('disabled', false);
					$("input[name=imprime2]").attr('disabled', false);
				}
			});*/
			
			if( $('input[name=grabo]').val() == undefined) {
				$('input:text').attr('readonly', true);
			}
		});
	</script>
</head>
<body>
<html:form action="/planificacionAction" styleId="planeacionForm">
<table align="center" width="100%" cellspacing="0" cellpadding="0">
<tr>
	<td width="100%" valign="top">
	<table cellspacing="0" cellpadding="0">
	<tr>
		<td class="bls">&nbsp;</td>
		<td width="200" class="textocentradoblanco">PLANIFICACI&Oacute;N</td>
		<td class="brs">&nbsp;</td>
	</tr>
	</table>
	</td>
</tr>
<tr>
	<td style="border: 2px solid #264971; padding: 5px;" valign="top">
	<table cellpadding="0" cellspacing="0" class="Busqueda">
	<tr>
		<td>Oficina:</td>
		<td>
			<html:select property="codOficina" styleClass="combo" onchange="javascript:buscar();" style="width: 300px;">
			<c:if test="${listaOficina != null}">
				<c:forEach var="lista" items="${listaOficina}">
					<html:option value="${lista.codOfic}"><c:out value="${lista.codNomOficina}" /></html:option>
				</c:forEach>
			</c:if>
			</html:select>
		</td><td style="width: 10px;"></td>
		<td>Presupuesto de Referencia:</td>
		<td>
			<html:select property="preReferencia" styleClass="combo" onchange="javascript:buscar();" disabled="false" style="width: 90px;">
			<c:if test="${listaPresup != null}">
				<c:forEach var="lista" items="${listaPresup}">
					<html:option value="${lista.codelem}"><c:out value="${lista.valor1}" /></html:option>
				</c:forEach>
			</c:if>
			</html:select>
		</td>
	</tr>
	<tr>
		<td>Mes de Planificación</td>
		<td>
			<html:select property="mesPlanificacion" styleClass="combo" onchange="javascript:buscar();" style="width: 90px;">
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
			</html:select>
		</td>
		<td></td>
		<td>Año</td>
		<td>
			<html:select property="anho" styleClass="combo" onchange="javascript:buscar();" style="width: 60px;">
			<c:if test="${listaAnhos != null}">
				<c:forEach var="lista" items="${listaAnhos}">
					<html:option value="${lista.codelem}"><c:out value="${lista.valor1}" /></html:option>
				</c:forEach>
			</c:if>
			</html:select>
		</td>
	</tr>
	</table>
	</td>
</tr>
</table>
<div id="tablaExportar" style="padding-top:6px;">
<c:if test="${indMostrar=='0'}">
<label> No se encontraron Datos </label><br>
<center><input type="button" name="imprime2" value="Historial del A&ntilde;o" onClick="Javascript:historial()" /></center>
</c:if>
<c:if test="${indMostrar=='1'}">
<table cellspacing="0" cellpadding="0" class="DataGrid" style="width:1370;">
<tr class="Header">
	<th rowspan="2" style="width:180px;">Ep&iacute;grafe</th>
	<th colspan="9">Saldo Medio Expresado en Miles de Soles</th>
	<th rowspan="2" style="width:70px;">Factor de Ajuste Saldo Puntual</th>
	<th rowspan="2" style="width:75px;">Hist&oacute;rico <br/>Bajas</th>
	<th colspan="3" >Facturaci&oacute;n Expresada en Miles de Soles</th>
	<th rowspan="2" style="width:55px;padding-left:3px;padding-right:3px;">Prioridad</th>
	<th rowspan="2" style="width:180px;">Ep&iacute;grafe</th>
</tr>
<tr class="Header">
	<th style="width:75px;">Presup.<br/><c:out value="${mesEvalMostrar}" /></th>
	<th style="width:75px;"><c:out value="${mesEvalMostrarAnte}" /></th>
	<th style="width:65px;">Var %<br/>Mes</th>
	<th style="width:46px;">% <br/>Avance</th>
	<th style="width:60px;">Desv. <br/>Ppto.</th>
	<th style="width:45px;">Ajust % <br/>Presup</th>
	<th style="width:60px;">Desv. Presup. Ajust</th>
	<th style="width:45px;">Meses <br/>Falt.</th>
	<th style="width:60px;">Crec. Prom. Mens.</th>
	<th style="width:72px;">Objetivo <br/>Oficina</th>
	<th style="width:92px;">Ajuste <br/>Territorial </th>
	<th style="width:92px;">Asignaci&oacute;n a <br/>Gte Oficina</th>
</tr>

<logic:present name="listaPlanes">
<bean:define id="listaDatos" name="listaPlanes" scope="session" />
<c:forEach items="${listaDatos}" var="objBean">

<c:set var="classEpigrafe" value=" SubEpigrafe"/>
<c:set var="classPrioridad" value=""/>
<c:if test="${objBean.indHijo == 0}"><c:set var="classEpigrafe" value=" Epigrafe"/></c:if>
<c:if test="${objBean.prioridad < 99}"><c:set var="classPrioridad" value=" Resaltar"/></c:if>

<tr class="Row<c:out value='${classEpigrafe}'/><c:out value='${classPrioridad}'/>">
	<input type="hidden" name="indAfecta" value='<c:out value="${objBean.indAfecta}"/>' />
	<input type="hidden" name="saldMediDici" value='<c:out value="${objBean.saldMediDici}"/>' />
	<input type="hidden" name="saldMediJunio" value='<c:out value="${objBean.saldMediJunio}"/>' />
	<input type="hidden" name="indHijo" value='<c:out value="${objBean.indHijo}"/>' />
	<input type="hidden" name="indSubClase" value='<c:out value="${objBean.indSubClase}"/>' />
	<input type="hidden" name="indClase" value='<c:out value="${objBean.indClase}"/>' />
	<input type="hidden" name="proyAjusMens" value='<c:out value="${objBean.proyAjusMens}"/>' />
	<input type="hidden" name="mes" value='<c:out value="${objBean.mes}"/>' />
	<input type="hidden" name="mesEval" value='<c:out value="${objBean.mesEval}"/>' />
	<input type="hidden" name="montoMesSig" value='<c:out value="${objBean.montoMesSig}"/>' />

	<td pattern="" type="STRING" class="Col1"><c:out value="${objBean.nomEpigrafe}" /></td>
	
	<td pattern="#,###.00" type="NUMBER" style="text-align: right;">
		<input type="text" style="width:60px;" value='<fmt:formatNumber value="${objBean.saldMediJunio}" maxFractionDigits="0" minFractionDigits="0"/>' readonly="readonly" size="8"/>
		<input type="hidden" name="saldMediJunio" value='<c:out value="${objBean.saldMediJunio}"/>' />
	</td>
	
	<td pattern="#,###.00" type="NUMBER" style="text-align: right;">
		<input type="text" style="width:60px;" value='<fmt:formatNumber value="${objBean.monto}" maxFractionDigits="0" minFractionDigits="0"/>' readonly="readonly" size="8" />
		<input type="hidden" name="monto" value='<c:out value="${objBean.monto}" />' />
	</td>
	
	<td pattern="#,###.00" type="NUMBER" style="text-align: right;"><c:out value="${objBean.varMes}" /></td>
	<td pattern="" type="NUMBER" style="text-align: right;">
		<c:if test="${objBean.porcentajeMax == null && objBean.porcentajeMin == null }"><c:out value= ""/></c:if>
		<c:if test="${objBean.porcentajeMax != null || objBean.porcentajeMin != null }">
			<c:if test="${objBean.porcentajeMin == objBean.porcentajeMax}"><span class="textAmbar"><fmt:formatNumber value="${objBean.porAlcanzado}" maxFractionDigits="0" minFractionDigits="0"/></span></c:if>
		</c:if>
		<c:if test="${objBean.porcentajeMin <= objBean.porcentajeMax}">
			<c:if test="${objBean.porcentajeMin != objBean.porcentajeMax}">
				<c:if test="${objBean.porAlcanzado >= objBean.porcentajeMax}">
					<span class="textVerde"><fmt:formatNumber value="${objBean.porAlcanzado}" maxFractionDigits="0" minFractionDigits="0"/></span>
				</c:if>
				<c:if test="${objBean.porAlcanzado <= objBean.porcentajeMin}"><span class="textRojo"><fmt:formatNumber value="${objBean.porAlcanzado}" maxFractionDigits="0" minFractionDigits="0"/></span></c:if>
			</c:if>
			<c:if test="${objBean.porAlcanzado > objBean.porcentajeMin && objBean.porAlcanzado < objBean.porcentajeMax}">
				<span class="textAmbar"><fmt:formatNumber value="${objBean.porAlcanzado}" maxFractionDigits="0" minFractionDigits="0"/></span>
			</c:if>
		</c:if>
		<c:if test="${objBean.porcentajeMin > objBean.porcentajeMax}">
			<c:if test="${objBean.porcentajeMin != objBean.porcentajeMax}">
				<c:if test="${objBean.porcentajeMax >= objBean.porAlcanzado}">
					<span class="textVerde"><fmt:formatNumber value="${objBean.porAlcanzado}" maxFractionDigits="0" minFractionDigits="0"/></span>
				</c:if>
				<c:if test="${objBean.porcentajeMin  <= objBean.porAlcanzado}">
					<span class="textRojo"><fmt:formatNumber value="${objBean.porAlcanzado}" maxFractionDigits="0" minFractionDigits="0"/></span>
				</c:if>
			</c:if>
			<c:if test="${objBean.porAlcanzado > objBean.porcentajeMax && objBean.porAlcanzado < objBean.porcentajeMin}">
				<span class="textAmbar"><fmt:formatNumber value="${objBean.porAlcanzado}" maxFractionDigits="0" minFractionDigits="0"/></span>
			</c:if>
		</c:if>
	</td>
	
	<td pattern="" type="NUMBER" style="text-align: right;">
		<input type="hidden" name="desvPpto" value='<c:out value="${objBean.desvPpto}"/>' />
		<input type="text" name="desvPptoVista" value='<fmt:formatNumber value="${objBean.desvPpto}" maxFractionDigits="0" minFractionDigits="0"/>' readonly="readonly" size="10" />
	</td>
	
	<td pattern="" type="NUMBER" style="text-align: right;">
		<c:if test="${objBean.ajusPpto == 0 && objBean.indAfecta == 'S'}">
			<input type="text" style="width: 35px;" class="Text" name="ajusPpto" value='<c:out value="${objBean.ajusPpto}"/>' size="10" maxlength="6"/>
		</c:if>
		<c:if test="${objBean.ajusPpto == 0 && objBean.indAfecta == 'N'}">
			<input type="text" style="width: 35px;" name="ajusPpto" value='<c:out value="${objBean.ajusPpto}"/>' readonly="readonly" size="10" maxlength="6"/>
		</c:if>
		<c:if test="${objBean.ajusPpto == 0 && objBean.indAfecta == null}">
			<input type="text" style="width: 35px;" name="ajusPpto" value='<c:out value="${objBean.ajusPpto}"/>' readonly="readonly" size="10" maxlength="6" />
		</c:if>
		<c:if test="${objBean.ajusPpto != 0}">
			<input type="text" style="width: 35px;" class="Text" name="ajusPpto" value='<c:out value="${objBean.ajusPpto}"/>' size="10"   maxlength="6" />
		</c:if>
	</td>
	
	<td pattern="" type="NUMBER" style="text-align: right;">
		<input type="text" name="desvAjusPptoVista" value='<fmt:formatNumber value="${objBean.desvAjusPpto}" maxFractionDigits="0" minFractionDigits="0"/>' readonly="readonly" size="10" />
		<input type="hidden" name="desvAjusPpto" value='<c:out value="${objBean.desvAjusPpto}"/>' readonly="readonly" size="10" />
	</td>
	
	<td pattern="" type="NUMBER" style="text-align: right;">
		<c:if test="${objBean.nroMesesFalt == 0 && objBean.indAfecta == 'S'}">
			<input type="text" name="nroMesesFalt" class="Text" onkeypress="return validKey(INT_PATTERN);" value='<c:out value="${objBean.nroMesesFalt}"/>' size="3" maxlength="2" />
		</c:if>
		<c:if test="${objBean.nroMesesFalt == 0 && objBean.indAfecta == 'N'}">
			<input type="text" name="nroMesesFalt" style="width:20px;" onkeypress="return validKey(INT_PATTERN);" value='<c:out value="${objBean.nroMesesFalt}"/>' readonly="readonly" size="3" maxlength="2" />
		</c:if>
		<c:if test="${objBean.nroMesesFalt == 0 && objBean.indAfecta == null}">
			<input type="text" name="nroMesesFalt" style="width:20px;" onkeypress="return validKey(INT_PATTERN);" value='<c:out value="${objBean.nroMesesFalt}"/>' readonly="readonly" size="3" maxlength="2" />
		</c:if>
		<c:if test="${objBean.nroMesesFalt != 0}">
			<input type="text" name="nroMesesFalt" class="Text" style="width:35px;" onkeypress="return validKey(INT_PATTERN);" value='<c:out value="${objBean.nroMesesFalt}"/>' size="3" maxlength="2" />
		</c:if>
	</td>
	
	<td pattern="" type="NUMBER" style="text-align: right;">
		<input type="text" name="proyCrecMensVista" value='<fmt:formatNumber value="${objBean.proyCrecMensVista}" maxFractionDigits="0" minFractionDigits="0"/>' readonly="readonly" size="10" />
		<input type="hidden" name="proyCrecMens" value='<c:out value="${objBean.proyCrecMens}"/>' />
	</td>
	<td pattern="" type="NUMBER" style="text-align: right;">
		<c:if test="${objBean.indAfecta == 'S'}">
			<input type="text" name="factAjusSaldPunt" value='<c:out value="${objBean.factAjusSaldPunt}"/>' readonly="readonly" size="10" />
		</c:if>
		<c:if test="${objBean.indAfecta == 'N'}">
			<input type="text" name="factAjusSaldPunt" value='<c:out value="${objBean.factAjusSaldPunt}"/>' readonly="readonly" size="10" />
		</c:if>
		<c:if test="${objBean.indAfecta == null}">
			<input type="text" name="factAjusSaldPunt" value='<c:out value="${objBean.factAjusSaldPunt}"/>' readonly="readonly" size="10" />
		</c:if>
	</td>
	<td pattern="" type="NUMBER" style="text-align: right;">
		<c:if test="${objBean.indAfecta == 'S'}">
			<input type="text" name="histBajas" style="width:68px;" size="12" value='<c:out value="${objBean.histBajas}"/>' readonly="readonly" />
		</c:if>
		<c:if test="${objBean.indAfecta == 'N'}">
			<input type="text" name="histBajas" style="width:68px;" size="12" value='<c:out value="${objBean.histBajas}"/>' readonly="readonly" />
		</c:if>
		<c:if test="${objBean.indAfecta == null}">
			<input type="text" name="histBajas" style="width:68px;" size="12" value='<c:out value="${objBean.histBajas}"/>' readonly="readonly" />
		</c:if>
	</td>
	<td pattern="" type="NUMBER" style="text-align: right;">
		<input type="text" name="metaMesSaldPuntVista" value='<fmt:formatNumber value="${objBean.metaMesSaldPunt}" maxFractionDigits="0" minFractionDigits="0"/>' readonly="readonly" size="7" />
		<input type="hidden" name="metaMesSaldPunt" value='<c:out value="${objBean.metaMesSaldPunt}"/>' readonly="readonly" size="7" />
	</td>
	<td pattern="" type="NUMBER" style="text-align: right;">
		<c:if test="${objBean.indAfecta == 'S'}">
			<input type="text" style="width: 75px;" class="Text" name="factAjusTerri" size="10" maxlength="10" value='<c:out value="${objBean.factAjusTerri}"/>' valueOld='<c:out value="${objBean.factAjusTerri}"/>' />
		</c:if>
		<c:if test="${objBean.indAfecta == 'N'}">
			<input type="text" style="width: 75px;" name="factAjusTerri" value='<c:out value="${objBean.factAjusTerri}"/>' readonly="readonly" size="10" maxlength="10" />
		</c:if>
		<c:if test="${objBean.indAfecta == null}">
			<input type="text" style="width: 75px;" name="factAjusTerri" value='<c:out value="${objBean.factAjusTerri}"/>' readonly="readonly" size="10" maxlength="10" />
		</c:if>
	</td>
	<!-- <c:out value="${objBean.indClase}"/> -->
	<td pattern="" type="NUMBER" style="text-align: right;">
		<c:if test="${objBean.indAfecta == 'S'}">
			<input type="text" style="width: 75px;" class="Text" name="factAjusGereOfic" size="10" maxlength="10" value='<c:out value="${objBean.factAjusGereOfic}"/>' valueOld='<c:out value="${objBean.factAjusGereOfic}"/>' />
		</c:if>
		<c:if test="${objBean.indAfecta == 'N'}">
			<input type="text" style="width: 75px;" name="factAjusGereOfic" value='<c:out value="${objBean.factAjusGereOfic}"/>' readonly="readonly" size="10"  maxlength="10" />
		</c:if>
		<c:if test="${objBean.indAfecta == null}">
			<input type="text" style="width: 75px;" name="factAjusGereOfic" value='<c:out value="${objBean.factAjusGereOfic}"/>' readonly="readonly" size="10"  maxlength="10" />
		</c:if>
	</td>
	<td pattern="" type="NUMBER" style="text-align: right;">
		<c:if test="${objBean.indAfecta == 'N'}">
			<input type="text" style="width: 40px;visibility:hidden;" name="prioridad" onkeypress="return validKey(INT_PATTERN);" value="" size="2" maxlength="2" />
		</c:if>
		<c:if test="${objBean.indAfecta != 'N'}">
			<c:if test="${objBean.prioridad !=99}">
				<input type="text" class="Text" style="width: 40px;" name="prioridad" onkeypress="return validKey(INT_PATTERN);" value='<c:out value="${objBean.prioridad}"/>' size="2" maxlength="2" />
			</c:if>
			<c:if test="${objBean.prioridad == 99}">
				<input type="text" class="Text" style="width: 40px;" name="prioridad" onkeypress="return validKey(INT_PATTERN);" value="" size="2" maxlength="2" />
			</c:if>
		</c:if>
	</td>
	<td pattern="" type="STRING" class="Col17"><c:out value="${objBean.nomEpigrafe}" /></td>
</tr>
</c:forEach>
</logic:present>
</table>

<table width="100%" height="50px;">
<tr>
<td align="center" nowrap>
	<c:if test="${indMostrar=='1'}">
		<c:if test="${sessionScope.gestor.codigoPerfil == 'ADM' || sessionScope.gestor.codigoPerfil == 'SUP'}">
			<input type="button" name="imprime2" value="Historial del A&ntilde;o" onClick="javascript:historial()" />
			<input type="button" name="exporta" value="Excel" />
		</c:if>

		<c:if test="${sessionScope.gestor.codigoPerfil == 'GTE'
			|| sessionScope.gestor.codigoPerfil == 'GCO'
			|| sessionScope.gestor.codigoPerfil == 'GPE'
			|| sessionScope.gestor.codigoPerfil == 'GPT'
			|| sessionScope.gestor.codigoPerfil == 'JPN'
			|| sessionScope.gestor.codigoPerfil == 'JPR'}">
			<input type="button" value="Esfuerzos Adicionales" onClick="javascript:elegirGestor()" />
		</c:if>

		<c:if test="${sessionScope.gestor.codigoPerfil == 'GTE' || sessionScope.gestor.codigoPerfil == 'JPN' || sessionScope.gestor.codigoPerfil == 'JPR' || sessionScope.gestor.codigoPerfil == 'GOF'}">
			<input type="button" name="calculo" value="Calcular" onClick="javascript:calcularTodo();" />
		</c:if>

		<c:if test="${sessionScope.gestor.codigoPerfil == 'GTE' || sessionScope.gestor.codigoPerfil == 'JPN' || sessionScope.gestor.codigoPerfil == 'JPR' || sessionScope.gestor.codigoPerfil == 'GOF'}">
			<input type="button" name="grabo" value="Grabar" onClick="javascript:envioDatos()" />
		</c:if>

		<c:if test="${sessionScope.gestor.codigoPerfil == 'GTE' 
			|| sessionScope.gestor.codigoPerfil == 'GCO' 
			|| sessionScope.gestor.codigoPerfil == 'GPE' 
			|| sessionScope.gestor.codigoPerfil == 'GPT' 
			|| sessionScope.gestor.codigoPerfil == 'JPN' 
			|| sessionScope.gestor.codigoPerfil == 'JPR'}">
			<input type="button" name="imprime2" value="Historial del A&ntilde;o" onClick="Javascript:historial()" />
			<input type="button" name="exporta" value="Excel" />
		</c:if>

		<c:if test="${sessionScope.gestor.codigoPerfil == 'GOF'
			|| sessionScope.gestor.codigoPerfil == 'CON'}">
			<input type="button" value="Esfuerzos Adicionales" onClick="javascript:elegirGestor()" />
			<input type="button" name="imprime2" value="Historial del A&ntilde;o" onClick="Javascript:historial()" />
			<input type="button" name="exporta" value="Excel" />
		</c:if>
	</c:if>
</td>
</tr>
</table>

</c:if>
</div>
</html:form>

<!-- ExportarExcelServlet -->
<form method="post" name="fExportarExel" action="ExportGenericExcelServlet">
	<input type="hidden" id="header" name="header" />
	<input type="hidden" id="rows" name="rows" />
	<input type="hidden" id="footer" name="footer" />
	<input type="hidden" id="file" name="file" value="Planificacion" />
	<input type="hidden" id="title" name="title" value="Planificacion" />
</form>

</body>
</html:html>
