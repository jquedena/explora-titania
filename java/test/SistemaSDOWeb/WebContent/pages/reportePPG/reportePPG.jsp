<!DOCTYPE HTML PUBLIC "-//W3C//Dtd HTML 4.01 transitional//EN">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="java.util.Vector" %>
<%@ page import="com.grupobbva.bc.per.tele.sdo.serializable.PlanesAcciones" %> 
<%@ page import="com.grupobbva.bc.per.tele.sdo.serializable.CampaniasGeneral" %>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html.tld"%>
<%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@ taglib prefix="fn" uri="/WEB-INF/fn.tld"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>

<fmt:setLocale value="en_US"/>
<html:html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta http-equiv='PRAGMA' content='NO-CACHE'>
	<meta http-equiv='EXPIRES' content='0'>	
	<link rel="stylesheet"	href="<%=request.getContextPath()%>/css/style.css"	type="text/css" />
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.2.6.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/js-preparaJSONExcel.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/pages/reportePPG/reportePPG.js"></script>
	<script type="text/javascript">
	$(function(){
		$("input[name=exporta]").click(function(){
			prepareJSONTable();
			document.forms["fExportarExel"].submit();
		});
		
		var textVerde='#D6FED9';
		var textRojo='#FFB1B1';
		var textAmbar='#FEFECC';
		
		$(".textRojo").each(function(){$(this).css({'backgroundColor': textRojo});});
		$(".textAmbar").each(function(){$(this).css({'backgroundColor': textAmbar});});
		$(".textVerde").each(function(){$(this).css({'backgroundColor': textVerde});});
	});
	</script>
</head>
<body> 
<html:form action="/reportePPGAction">
<input type="hidden" name="method" />

<table align="center" width="100%" cellspacing="0" cellpadding="0">
<tr>
	<td align="left"  valign="top">
		<table cellspacing="0" cellpadding="0">
		<tr>
		<td class="bls">&nbsp;</td>
		<td width="200" class="textocentradoblanco">REPORTE P.P.G.</td>
		<td class="brs">&nbsp;</td>
		</tr>
		</table>
	</td>
</tr>
<tr>
	<td style="border: 2px solid #264971; padding:5px;" valign="top" align="center">
		<table width="780" align="center">
		<tr>
			<td width="15%">MES/A&Ntilde;O</td>
			<td width="30%">
				<html:select property="mes" value="${requestScope.mes}" onchange="recargar();">
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
				<c:if test="${requestScope.listaAnio != null}">
					<html:select property="anho" value="${requestScope.anio}" onchange="recargar();">
					<c:forEach items="${requestScope.listaAnio}" var ="anio" >
						<html:option value="${anio.codelem}">${oficina.valor1}</html:option>
					</c:forEach>
					</html:select>
				</c:if>
			</td>
			<td width="15%">PERFIL</td>
			<td width="40%"><div id="textoPerfil"><c:out value="${requestScope.codPerfilGestor}" /></div></td>
		</tr>
		<tr>
			<td>OFICINA</td> 
			<td>
				<c:if test="${requestScope.listaOficina != null}">
				<html:select property="codOficina" value="${requestScope.codOficina}" onchange="recargar();">
				<c:forEach items="${requestScope.listaOficina}" var ="oficina" >
					<html:option value="${oficina.codOfic}">${oficina.codNomOficina}</html:option>
				</c:forEach>
				</html:select>
				</c:if>
			</td>
			<td>GESTOR </td>
			<td>
				<c:if test="${requestScope.listaGestor != null}">
				<html:select property="codGestor" value="${requestScope.codGestor}" onchange="recargar();">
				<c:forEach items="${requestScope.listaGestor}" var ="codGestor" >
					<html:option value="${codGestor.codigoGestor}">${codGestor.nombreGestor}</html:option>
				</c:forEach>
				</html:select>
				</c:if>
			</td>
		</tr>
		<tr>
			<td colspan="4" align="center"><input type="button" id="botonImprimir" value="Imprimir" onClick="imprimir();">&nbsp;&nbsp;<input type="button" name="exporta" value="Excel"></td>
		</tr>
		</table>
	</td>
</tr>
</table>
<div style="padding-top:6px;">
<table class="DataGrid" cellpadding="0" cellspacing="0" style="width:1300px;">
<tr class="Header">
	<th colspan=5 class="ReportePPG">&nbsp;</th>
	<th colspan=3>&nbsp;</th>
	<th colspan=10>** SEGUIMIENTO</th>
</tr>
<tr class="Header">
	<th colspan=5 class="ReportePPG">PRIORIDAD Y OBJETIVOS DEL GESTOR</th>
	<th colspan=3>ACCIONES CONCRETAS</th>
	<th colspan=3>PRIMERA QUINCENA</th>
	<th colspan=3>SEGUNDA QUINCENA</th>	
	<th colspan=4>TOTAL</th>
</tr>
<tr class="Header">
	<th class="ReportePPG" style="width:50px;font-size:75%;">PRIOR</th>
	<th class="ReportePPG" style="font-size:75%;">EPIGRAFE</th>
	<th class="ReportePPG" style="width:64px;font-size:75%;">OBJ. FACT. GESTOR</th>
	<th class="ReportePPG" style="width:64px;font-size:75%;">M_I_S</th>
	<th class="ReportePPG" style="width:64px;font-size:75%;">DESV. %</th>
	<th style="font-size:75%;">DESCRIPCION</th>
	<th style="width:64px;font-size:75%;">NRO. CLI</th>
	<th style="width:64px;font-size:75%;">COMPR GT</th>
	<th style="width:64px;font-size:75%;">NRO.GEST</th>
	<th style="width:64px;font-size:75%;">NRO. CONCR</th>
	<th style="width:64px;font-size:75%;">MONTO</th>
	<th style="width:64px;font-size:75%;">NRO.GEST</th>
	<th style="width:64px;font-size:75%;">NRO. CONCR</th>
	<th style="width:64px;font-size:75%;">MONTO</th>
	<th style="width:64px;font-size:75%;">NRO.GEST</th>
	<th style="width:64px;font-size:75%;">NRO. CONCR</th>
	<th style="width:64px;font-size:75%;">MONTO</th>
	<th style="width:64px;font-size:75%;">%CONS</th>
</tr>
<c:if test="${requestScope.listaSeguimiento != null}">
	<c:set var="temp" value="SEG"/>
	<c:set var="subtotal" value="SUBTOTAL"/>
	<c:set var="total" value="TOTAL"/>
	<c:set var="orden" value="1"/>
	<c:set var="tipo1" value="SEG"/>
	<c:set var="tipo2" value="ESF"/>
	<c:set var="epigrafe" value="${requestScope.codEpigrafe}"/>
	<c:forEach items="${requestScope.listaSeguimiento}" var ="seguimiento" >
	
	<c:set var="style" value=""/>
	<c:set var="colspan" value="1"/>
	<c:if test="${seguimiento.nomAcci==total}">
		<c:set var="style" value="Subtotal"/>
		<c:set var="colspan" value="6"/>
	</c:if>
	<c:if test="${seguimiento.nomAcci==subtotal}">
		<c:set var="style" value="Subtotal"/>
		<c:set var="colspan" value="1"/>
	</c:if>
	
	<c:if test="${epigrafe!=seguimiento.codEpigrafe}">
		<c:set var="epigrafe" value="${seguimiento.codEpigrafe}"/>
		<c:if test="${temp==seguimiento.tipo}">
			<tr class="Row" style="height:10px;"><td align="center" colspan="18" style="border-right: 1px solid #fff;font-size:10%;">&nbsp;</td></tr>
		</c:if>
	</c:if>
	
	<c:if test="${temp!=seguimiento.tipo}">
		<c:set var="temp" value="${seguimiento.tipo}"/>
		<tr class="Row"><td align="center" colspan="18" style="border: 1px solid #fff;">&nbsp;</td></tr>
		<tr class="Row"><td align="center" colspan="18" style="border: 1px solid #fff;"><b>ESFUERZOS ADICIONALES</b></td></tr>
		<tr class="Row"><td align="center" colspan="18" style="border-right: 1px solid #fff;"><b>(En miles de Soles)</b></td></tr>
		<tr class="Row">
			<th class="ReportePPG" style="font-size:75%;">PRIOR</th>
			<th class="ReportePPG" style="font-size:75%;">EPIGRAFE</th>
			<th class="ReportePPG" style="font-size:75%;">OBJ. FACT. GESTOR</th>
			<th class="ReportePPG" style="font-size:75%;">M_I_S</th>
			<th class="ReportePPG" style="font-size:75%;">DESV. %</th>
			<th style="font-size:75%;">DESCRIPCION</th>
			<th style="font-size:75%;">NRO. CLI</th>
			<th style="font-size:75%;">COMPR GT</th>
			<th style="font-size:75%;">NRO.GEST</th>
			<th style="font-size:75%;">NRO. CONCR</th>
			<th style="font-size:75%;">MONTO</th>
			<th style="font-size:75%;">NRO.GEST</th>
			<th style="font-size:75%;">NRO. CONCR</th>
			<th style="font-size:75%;">MONTO</th>
			<th style="font-size:75%;">NRO.GEST</th>
			<th style="font-size:75%;">NRO. CONCR</th>
			<th style="font-size:75%;">MONTO</th>
			<th style="font-size:75%;">%CONS</th>
		</tr>
	</c:if>
	
	<tr class='Row <c:out value="${style}"/>'>
		
		<c:if test="${seguimiento.nomAcci!=subtotal && seguimiento.nomAcci!=total}">
			<c:if test="${seguimiento.orden==orden}">
				<td class="Title" align="right"><c:out value='${seguimiento.prioridad}'/>&nbsp;</td>
				<td class="Title" style="font-size:80%;"><c:out value='${seguimiento.nomEpigrafe}'/></td>
				<td class="Title <c:out value='${seguimiento.semaforoDesviacionMIS}'/>" pattern="#,###.00" type="NUMBER" align="right"><fmt:formatNumber value='${seguimiento.metGerOfi}' maxFractionDigits="0" minFractionDigits="0"/></td>
				<td class="Title <c:out value='${seguimiento.semaforoDesviacionMIS}'/>" pattern="#,###.00" type="NUMBER" align="right"><fmt:formatNumber value='${seguimiento.totalMIS}' maxFractionDigits="0" minFractionDigits="0"/><c:if test="${seguimiento.totalMIS==null}">&nbsp;</c:if></td>
				<td class="Title <c:out value='${seguimiento.semaforoDesviacionMIS}'/>" pattern="#,###.00" type="NUMBER" align="right"><fmt:formatNumber value="${seguimiento.desviacionMIS}" maxFractionDigits="2" minFractionDigits="2"/>%</td>
			</c:if>
			<c:if test="${seguimiento.orden!=orden}">
				<td colspan='5' style="	border: 1px solid #fff; border-right: 1px solid #9dbee7;">&nbsp;</td>
			</c:if>
		</c:if>
		<c:if test="${seguimiento.nomAcci==subtotal}">
			<td colspan='5' style="	border: 1px solid #fff; border-right: 1px solid #9dbee7; border-bottom: 1px solid #9dbee7;background-color:#fff;">&nbsp;</td>
		</c:if>
		<td colspan='<c:out value="${colspan}"/>' style="font-size:80%;">
			<c:if test="${seguimiento.nomAcci!=total}">
				<c:out value='${seguimiento.nomAcci}'/>
			</c:if>
			<c:if test="${seguimiento.tipo==tipo1 && seguimiento.nomAcci==total}">
				TOTAL DE ACCIONES DEL GESTOR
			</c:if>
			<c:if test="${seguimiento.tipo==tipo2 && seguimiento.nomAcci==total}">
				TOTAL DE ESFUERZOS ADICIONALES DEL GESTOR
			</c:if>
		</td>
		<td pattern="#,###.00" type="NUMBER" align="right"><c:out value='${seguimiento.nroClie}'/><c:if test="${seguimiento.nroClie==null}">&nbsp;</c:if></td>
		<td pattern="#,###.00" type="NUMBER" align="right"><fmt:formatNumber value='${seguimiento.compGest}' pattern="#,###" maxFractionDigits="0" minFractionDigits="0"/><c:if test="${seguimiento.compGest==null}">&nbsp;</c:if></td>
		<td pattern="#,###.00" type="NUMBER" align="right"><c:out value='${seguimiento.nroGestSegu1}'/><c:if test="${seguimiento.nroGestSegu1==null}">&nbsp;</c:if></td>
		<td pattern="#,###.00" type="NUMBER" align="right"><c:out value='${seguimiento.nroConcSegu1}'/><c:if test="${seguimiento.nroConcSegu1==null}">&nbsp;</c:if></td>
		<td pattern="#,###.00" type="NUMBER" align="right">
			<c:if test="${seguimiento.nomAcci!=total}"><fmt:formatNumber value='${seguimiento.monSegu1}' maxFractionDigits="0" minFractionDigits="0"/></c:if>
			<c:if test="${seguimiento.monSegu1==null || seguimiento.nomAcci==total}">&nbsp;</c:if>
		</td>
		<td pattern="#,###.00" type="NUMBER" align="right"><c:out value='${seguimiento.nroGestSegu2}'/><c:if test="${seguimiento.nroGestSegu2==null}">&nbsp;</c:if></td>
		<td pattern="#,###.00" type="NUMBER" align="right"><c:out value='${seguimiento.nroConcSegu2}'/><c:if test="${seguimiento.nroConcSegu2==null}">&nbsp;</c:if></td>
		<td pattern="#,###.00" type="NUMBER" align="right">
			<c:if test="${seguimiento.nomAcci!=total}"><fmt:formatNumber value='${seguimiento.monSegu2}' maxFractionDigits="0" minFractionDigits="0"/></c:if>
			<c:if test="${seguimiento.monSegu2==null || seguimiento.nomAcci==total}">&nbsp;</c:if>
		</td>
		<td pattern="#,###.00" type="NUMBER" align="right"><c:out value='${seguimiento.nroGestTotal}'/><c:if test="${seguimiento.nroGestTotal==null}">&nbsp;</c:if></td>
		<td pattern="#,###.00" type="NUMBER" align="right"><c:out value='${seguimiento.nroConcTotal}'/><c:if test="${seguimiento.nroConcTotal==null}">&nbsp;</c:if></td>
		<td pattern="#,###.00" type="NUMBER" align="right" class="<c:if test="${seguimiento.nomAcci==subtotal}"><c:out value='${seguimiento.semaforoPorcConsecucion}'/></c:if>">
			<c:if test="${seguimiento.nomAcci!=total}"><fmt:formatNumber value='${seguimiento.monTotal}' pattern="#,###" maxFractionDigits="0" minFractionDigits="0"/></c:if>
			<c:if test="${seguimiento.monTotal==null || seguimiento.nomAcci==total}">&nbsp;</c:if>
		</td>	
		<td pattern="#,###.00" type="NUMBER" align="right" class="<c:if test="${seguimiento.nomAcci==subtotal}"><c:out value='${seguimiento.semaforoPorcConsecucion}'/></c:if>">
			<c:if test="${seguimiento.nomAcci!=total}"><fmt:formatNumber value="${seguimiento.porcConsecucion}" maxFractionDigits="2" minFractionDigits="2"/>%</c:if>
			<c:if test="${seguimiento.porcConsecucion==null || seguimiento.nomAcci==total}">&nbsp;</c:if>
		</td>
	</tr>
	</c:forEach>
	
	<tr class="Footer">
		<td colspan="18" style="border: 1px solid #fff;">&nbsp;</td>
	</tr>
	<tr class="Footer">
		<td align="right" style="border: 1px solid #fff;">*</td>
		<td colspan="17" style="border: 1px solid #fff;">El sem&aacute;foro ubicado en la secci&oacute;n "Prioridad y Objetivos del Gestor" muestra el MIS con respecto al Objetivo Fact. Gestor</td>
	</tr>
	<tr class="Footer">
		<td align="right" style="border: 1px solid #fff;">**</td>
		<td colspan="17" style="border: 1px solid #fff;">El sem&aacute;foro ubicado en la secci&oacute;n "Seguimiento" muestra el "Monto Total por Ep&iacute;grafe" con respecto a las Acciones Concretas del Gestor "COMPR. GESTOR"</td>
	</tr>
	<tr class="Footer">
		<td align="right" style="border: 1px solid #fff;">&nbsp;</td>
		<td colspan="17" style="border: 1px solid #fff;">La información de MIS corresponde a las altas de contratos efectuadas hasta el d&iacute;a anterior.</td>
	</tr>
</c:if>
</table>
</div>
</html:form>
<form method="post" name="fExportarExel" action="ExportGenericExcelServlet">
	<input type="hidden" id="header" name="header" />
	<input type="hidden" id="rows" name="rows" />
	<input type="hidden" id="footer" name="footer" />
	<input type="hidden" id="file" name="file" value="Reporte_PPG" />
	<input type="hidden" id="title" name="title" value="Reporte PPG" />
</form>
</body>
</html:html>