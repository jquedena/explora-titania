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
	<script type="text/javascript">
	$(function(){
		$("input[name=exporta]").click(function(){
			prepareJSONTable();
			$("form[name=fExportarExel]").submit();
		});
		
		$("select").change(function(){
			// $("form[name=fExportarExel]").action = "reportePPGAction.do?method=reporteAvance";
			$("#action").method = "post";
			$("#action").submit();
		});
	});
	</script>
</head>
<body> 
<html:form styleId="action" action="/reportePPGAction.do?method=reporteAvance">
<table align="center" width="100%" cellspacing="0" cellpadding="0">
<tr>
	<td align="left"  valign="top">
		<table cellspacing="0" cellpadding="0">
		<tr>
		<td class="bls">&nbsp;</td>	
		<td width="200" class="textocentradoblanco">REPORTE AVANCE</td>	
		<td class="brs">&nbsp;</td>	
		</tr>						
		</table>
	</td>	
</tr>
<tr>
	<td style="border: 2px solid #264971; padding:5px;" valign="top" align="center">
		<table width="780" align="center">
		<tr>		
			<td width="15%">A&Ntilde;O</td>
			<td width="30%">
				<c:if test="${requestScope.listaAnio != null}">
					<html:select property="anho" value="${requestScope.anio}">
					<c:forEach items="${requestScope.listaAnio}" var ="anio" >
						<html:option value="${anio.codelem}">${oficina.valor1}</html:option>
					</c:forEach>
					</html:select>
				</c:if>
			</td>
			<td width="15%">MES</td>
			<td width="40%">
				<html:select property="mes" value="${requestScope.mes}">
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
		</tr>
		<tr>
			<td>TERRITORIO</td> 
			<td>
				<c:if test="${requestScope.listaTerritorio != null}">
				<html:select property="codTerr" value="${requestScope.codTerr}">
				<c:forEach items="${requestScope.listaTerritorio}" var ="lista" >
					<html:option value="${lista.codTerr}">${lista.nomTerr}</html:option>
				</c:forEach>
				</html:select>
				</c:if>
			</td>
			<td>OFICINA</td>
			<td>
				<c:if test="${requestScope.listaOficina != null}">
				<html:select property="codOficina" value="${requestScope.codOficina}">
				<c:forEach items="${requestScope.listaOficina}" var ="oficina" >
					<html:option value="${oficina.codOfic}">${oficina.codNomOficina}</html:option>
				</c:forEach>
				</html:select>
				</c:if>
			</td>
		</tr>
		<tr>
			<td>GESTOR </td>
			<td>
				<c:if test="${requestScope.listaGestor != null}">
				<html:select property="codGestor" value="${requestScope.codGestor}">
				<c:forEach items="${requestScope.listaGestor}" var ="codGestor" >
					<html:option value="${codGestor.codigoGestor}">${codGestor.nombreGestor}</html:option>
				</c:forEach>
				</html:select>
				</c:if>
			</td>
		</tr>
		<tr>
			<td colspan="4" align="center"><input type="button" name="exporta" value="Excel"></td>
		</tr>
		</table>
	</td>
</tr>
</table>

<div style="padding-top:6px;">
<table class="DataGrid" cellpadding="0" cellspacing="0">
<tr class="Header">
	<th rowspan=2 style="width:64px;font-size:75%;">PRIORIDAD</th>
	<th rowspan=2 style="width:400px;">EPIGRAFE</th>
	<th rowspan=2 style="width:64px;">OBJ<br/> MES</th>
	<th colspan=3>M I S</th>	
	<th colspan=3>SEGUIMIENTO</th>
</tr>
<tr class="Header">
	<th style="width:64px;font-size:75%;">AVANCE</th>
	<th style="width:64px;font-size:75%;">DESV. MONTO</th>
	<th style="width:64px;font-size:75%;">DESV. %</th>
	<th style="width:64px;font-size:75%;">MONTO</th>
	<th style="width:64px;font-size:75%;">DESV. MONTO</th>	
	<th style="width:64px;font-size:75%;">DESV. %</th>	
</tr>
<c:if test="${requestScope.listaSeguimiento != null}">
	<c:set var="codTerr" value="***"/>
	<c:set var="codOfic" value="***"/>
	<c:set var="codGest" value="***"/>
	<c:set var="epigrafe" value="${requestScope.codEpigrafe}"/>
	<c:forEach items="${requestScope.listaSeguimiento}" var ="seguimiento" >
	
	<c:if test="${codTerr!=seguimiento.nomTerr}">
	<tr class='Row <c:out value="${style}"/>'>
		<td colspan='9' style="font-size:120%; font-weight: bold; background-color: #DBE5F1;">
			<c:out value="${seguimiento.nomTerr}"/>
			<c:set var="codTerr" value="${seguimiento.nomTerr}"/>
		</td>
	</tr>
	</c:if>
	
	<c:if test="${codOfic!=seguimiento.nomOfic}">
	<tr class='Row <c:out value="${style}"/>'>
		<td colspan='9' style="font-size:100%;padding-left:30px; font-weight: bold; background-color: #DBE5F1;">
			<c:out value="${seguimiento.nomOfic}"/>
			<c:set var="codOfic" value="${seguimiento.nomOfic}"/>
		</td>
	</tr>
	</c:if>
	
	<c:if test="${codGest!=seguimiento.nomGestor}">
	<tr class='Row <c:out value="${style}"/>'>
		<td colspan='9' style="font-size:80%;padding-left:60px; font-weight: bold;">
			<c:out value="${seguimiento.nomGestor}"/>
			<c:set var="codGest" value="${seguimiento.nomGestor}"/>
		</td>
	</tr>
	</c:if>
	
	<tr class='Row <c:out value="${style}"/>'>

		<td><c:out value="${seguimiento.prioridad}"/>&nbsp;</td>
		<td><c:out value="${seguimiento.nomEpigrafe}"/>&nbsp;</td>
		<td pattern="#,###.00" type="NUMBER" align="right">
			<c:out value='${seguimiento.metGerOfi}'/>
			<c:if test="${seguimiento.metGerOfi==null}">0</c:if>
		</td>
		<td pattern="#,###.00" type="NUMBER" align="right">
			<c:out value='${seguimiento.totalMIS}'/>
			<c:if test="${seguimiento.totalMIS==null}">&nbsp;</c:if>
		</td>
		<td pattern="#,###.00" type="NUMBER" align="right">
			<c:out value='${seguimiento.desvMontoMIS}'/>
			<c:if test="${seguimiento.desvMontoMIS==null}">&nbsp;</c:if>
		</td>
		<td pattern="#,###.00" type="NUMBER" align="right" class="<c:out value='${seguimiento.semaforoDesvPercentMIS}'/>">
			<c:if test="${seguimiento.desvPercentMIS==null}">0.00</c:if>
			<fmt:formatNumber value="${seguimiento.desvPercentMIS}" maxFractionDigits="2" minFractionDigits="2"/>%
		</td>
		<td pattern="#,###.00" type="NUMBER" align="right">
			<c:out value='${seguimiento.monTotal}'/>
			<c:if test="${seguimiento.monTotal==null}">&nbsp;</c:if>
		</td>
		<td pattern="#,###.00" type="NUMBER" align="right">
			<c:out value='${seguimiento.desvMontoSeg}'/>
			<c:if test="${seguimiento.desvMontoSeg==null}">&nbsp;</c:if>
		</td>
		<td pattern="#,###.00" type="NUMBER" align="right" class="<c:out value='${seguimiento.semaforoDesvPercentSeg}'/>">
			<c:if test="${seguimiento.desvPercentSeg==null}">0.00</c:if>
			<fmt:formatNumber value="${seguimiento.desvPercentSeg}" maxFractionDigits="2" minFractionDigits="2"/>%
		</td>
	</tr>
	</c:forEach>
	
	<tr class="Footer">
		<td colspan="9" style="border: 1px solid #fff;">&nbsp;</td>
	</tr>
	<tr class="Footer">
		<td align="right" style="border: 1px solid #fff;">*</td>
		<td colspan="8" style="border: 1px solid #fff;">El semáforo muestra la desviación % con respecto al Objetivo del Mes.</td>
	</tr>
</c:if>
</table>
</div>
</html:form>
<form method="post" name="fExportarExel" action="ExportGenericExcelServlet">
	<input type="hidden" id="header" name="header" />
	<input type="hidden" id="rows" name="rows" />
	<input type="hidden" id="footer" name="footer" />
	<input type="hidden" id="file" name="file" value="Reporte_Avance" />
	<input type="hidden" id="title" name="title" value="Reporte de Avance" />
</form>
</body>
</html:html>