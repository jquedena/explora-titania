<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@ taglib prefix="fn" uri="/WEB-INF/fn.tld"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html:html>
<head>
	<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="generator" content="Bluefish 2.0.3" >
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv='PRAGMA' content='NO-CACHE'>
	<meta http-equiv='EXPIRES' content='0'>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.2.6.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/js-preparaJSONExcel.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/pages/planificacion/planificacionListar.js"></script>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css" />
	<title></title>
	<script type="text/javascript" >
		$(function() {
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
			$(".Col1").each(function() {
				$(this).addClass("Node");
			});
		});
	</script>
</head>
<body>
<html:form action="/planificacionAction" styleId="planeacionForm">
<table border='0' align="center" width="100%" height="%" cellspacing="0" cellpadding="0">
<tr>
	<td width="100%" align="left"  valign="top">
	<table cellspacing="0" cellpadding="0">
	<tr>
		<td class="bls">&nbsp;</td>	
		<td width="200" class="textocentradoblanco">HISTORIAL DEL A&Ntilde;O </td>	
		<td class="brs">&nbsp;</td>	
	</tr>		
	</table>
	</td>	
</tr>
<tr>
	<td style="border: 2px solid #264971; padding:5px;">
	<!-- Cabecera de Busqueda -->
	<table cellpadding="0" cellspacing="0" class="Busqueda">
	<tr><th colspan="5">Busqueda de Planificación</th></tr>
	<tr>
		<td>Oficina:</td>
		<td>
			<html:select property="codOficina" onchange="javascript:historial()" style="width: 300px;">
				<c:if test="${listaOficina != null}">
					<c:forEach var="lista" items="${listaOficina}">
						<html:option value="${lista.codOfic}"><c:out value="${lista.codNomOficina}" /></html:option>
					</c:forEach>
				</c:if>
			</html:select>
		</td>
		<td style="width: 10px;"></td>
		<td>Presupuesto de Referencia: </td>
		<td>
			<html:select property="preReferencia" onchange="javascript:historial()" style="width: 90px;">
				<c:if test="${listaPresup != null}">
					<c:forEach var="lista" items="${listaPresup}">
						<html:option value="${lista.codelem}"><c:out value="${lista.valor1}" /></html:option>
					</c:forEach>
				</c:if>
			</html:select>
		</td>
	</tr>
	<tr>
		<td></td>
		<td></td>
		<td></td>
		<td>Año:</td>
		<td>
			<html:select property="anho" onchange="javascript:historial()" style="width: 60px;">
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
<br>
<div id="tablaExportar">
<c:if test="${indMostrar=='0'}"><label>No se encontraron Datos</label></c:if>
<c:if test="${indMostrar=='1'}">

	<table class="DataGrid" cellspacing="0" cellpadding="0" style="width: 1455px;">
	<tr class="Header"><th colspan="27">Presupuesto - Año Historial</th></tr>
	<tr class="Header"><th colspan="27">Expresado en miles de soles</th></tr>
	<tr class="Header">
		<th style="width: 200px;">Epigrafe</th>
		<th style="width: 60px;">Ene</th>
		<th style="width: 35px;">%<br/>Avan</th>
		<th style="width: 60px;">Feb</th>
		<th style="width: 35px;">%<br/>Avan</th>
		<th style="width: 60px;">Mar</th>
		<th style="width: 35px;">%<br/>Avan</th>
		<th style="width: 60px;">Abr</th>
		<th style="width: 35px;">%<br/>Avan</th>
		<th style="width: 60px;">May</th>
		<th style="width: 35px;">%<br/>Avan</th>
		<th style="width: 60px;">Jun</th>
		<th style="width: 35px;">%<br/>Avan</th>
		<th style="width: 60px;">Jul</th>
		<th style="width: 35px;">%<br/>Avan</th>
		<th style="width: 60px;">Ago</th>
		<th style="width: 35px;">%<br/>Avan</th>
		<th style="width: 60px;">Set</th>
		<th style="width: 35px;">%<br/>Avan</th>
		<th style="width: 60px;">Oct</th>
		<th style="width: 35px;">%<br/>Avan</th>
		<th style="width: 60px;">Nov</th>
		<th style="width: 35px;">%<br/>Avan</th>
		<th style="width: 60px;">Dic</th>
		<th style="width: 35px;">%<br/>Avan</th>
		<th style="width: 60px;">Total S/.</th>
		<th style="width: 35px;">Total<br/>%</th>
	</tr>

	<logic:present name ="listaPlanes">
	<bean:define id="listaDatos" name="listaPlanes" scope="session" />
	<c:forEach items="${listaDatos}" var="objBean">

	<c:set var="classEpigrafe" value=" SubEpigrafe"/>
	<c:set var="classPrioridad" value=""/>
	<c:if test="${objBean.indHijo == 0}"><c:set var="classEpigrafe" value=" Epigrafe"/></c:if>
	<c:if test="${objBean.prioridad < 99}"><c:set var="classPrioridad" value=" Resaltar"/></c:if>	
	
	<tr class="Row<c:out value='${classEpigrafe}'/><c:out value='${classPrioridad}'/>">
		<td class="Col1"><c:out value="${objBean.nomEpigrafe}"/></td>
		<td pattern="" type="NUMBER" style="text-align:right;"><c:out value="${objBean.ener}"/></td>           
		<td pattern="" type="NUMBER" style="text-align:right;"><c:out value="${objBean.enerP}"/></td>
		<td pattern="" type="NUMBER" style="text-align:right;"><c:out value="${objBean.febr}"/></td>  
		<td pattern="" type="NUMBER" style="text-align:right;"><c:out value="${objBean.febrP}"/></td>    
		<td pattern="" type="NUMBER" style="text-align:right;"><c:out value="${objBean.marz}"/></td>   
		<td pattern="" type="NUMBER" style="text-align:right;"><c:out value="${objBean.marzP}"/></td>                            
		<td pattern="" type="NUMBER" style="text-align:right;"><c:out value="${objBean.abri}"/></td>                                                                      
		<td pattern="" type="NUMBER" style="text-align:right;"><c:out value="${objBean.abriP}"/></td>                   
		<td pattern="" type="NUMBER" style="text-align:right;"><c:out value="${objBean.mayo}"/></td>   
		<td pattern="" type="NUMBER" style="text-align:right;"><c:out value="${objBean.mayoP}"/></td>
		<td pattern="" type="NUMBER" style="text-align:right;"><c:out value="${objBean.juni}"/></td>
		<td pattern="" type="NUMBER" style="text-align:right;"><c:out value="${objBean.juniP}"/></td> 
		<td pattern="" type="NUMBER" style="text-align:right;"><c:out value="${objBean.juli}"/></td>    
		<td pattern="" type="NUMBER" style="text-align:right;"><c:out value="${objBean.juliP}"/></td>
		<td pattern="" type="NUMBER" style="text-align:right;"><c:out value="${objBean.agos}"/></td>    
		<td pattern="" type="NUMBER" style="text-align:right;"><c:out value="${objBean.agosP}"/></td>                            
		<td pattern="" type="NUMBER" style="text-align:right;"><c:out value="${objBean.seti}"/></td>
		<td pattern="" type="NUMBER" style="text-align:right;"><c:out value="${objBean.setiP}"/></td>
		<td pattern="" type="NUMBER" style="text-align:right;"><c:out value="${objBean.octu}"/></td>   
		<td pattern="" type="NUMBER" style="text-align:right;"><c:out value="${objBean.octuP}"/></td>                                          
		<td pattern="" type="NUMBER" style="text-align:right;"><c:out value="${objBean.novi}"/></td>   
		<td pattern="" type="NUMBER" style="text-align:right;"><c:out value="${objBean.noviP}"/></td>                            
		<td pattern="" type="NUMBER" style="text-align:right;"><c:out value="${objBean.dici}"/></td>
		<td pattern="" type="NUMBER" style="text-align:right;"><c:out value="${objBean.diciP}"/></td>             
		<td pattern="" type="NUMBER" style="text-align:right;"><fmt:formatNumber value="${objBean.totalM}" maxFractionDigits="0" minFractionDigits="0" pattern="############"/></td>
		<td pattern="" type="NUMBER" style="text-align:right;font-weight: bold;">
			<c:if test="${objBean.porcentajeMax == null && objBean.porcentajeMin == null }"><span class="textNegro"><c:out value= ""/></span></c:if>
			<c:if test="${objBean.porcentajeMax != null || objBean.porcentajeMin != null }">
				<c:if test="${objBean.porcentajeMin == objBean.porcentajeMax}"><span class="textAmbar"><c:out value="${objBean.totalP}"/></span></c:if>
			</c:if>						

			<c:if test="${objBean.porcentajeMin <= objBean.porcentajeMax}">	
				<c:if test="${objBean.porcentajeMin != objBean.porcentajeMax}">
					<c:if test="${objBean.totalP >= objBean.porcentajeMax}"><span class="textVerde"><c:out value="${objBean.totalP}"/></span></c:if>
					<c:if test="${objBean.totalP <= objBean.porcentajeMin}"><span class="textRojo"><c:out value="${objBean.totalP}"/></span></c:if>
				</c:if>
				<c:if test="${objBean.totalP > objBean.porcentajeMin && objBean.totalP < objBean.porcentajeMax}">
					<span class="textAmbar"><c:out value="${objBean.totalP}"/></span>
				</c:if>
			</c:if>

			<c:if test="${objBean.porcentajeMin > objBean.porcentajeMax}">	
				<c:if test="${objBean.porcentajeMin != objBean.porcentajeMax}">
					<c:if test="${objBean.porcentajeMax >= objBean.totalP}"><span class="textVerde"><c:out value="${objBean.totalP}"/></span></c:if>
					<c:if test="${objBean.porcentajeMin  <= objBean.totalP}"><span class="textRojo"><c:out value="${objBean.totalP}"/></span></c:if>
				</c:if>
				<c:if test="${objBean.totalP > objBean.porcentajeMax && objBean.totalP < objBean.porcentajeMin}">
					<span class="textAmbar"><c:out value="${objBean.totalP}"/></span>
				</c:if>
			</c:if>
		</td>
	</tr>
	</c:forEach>
	</logic:present>

	</table>
	
	<table width="100%" height="50px">
	<tr>
		<td align="center">
		<input type="button" name="exporta" value="Excel">
		</td>
	</tr>
	</table>
	
</c:if>
</div>

</html:form>
<form method="post" name="fExportarExel" action="ExportGenericExcelServlet">
	<input type="hidden" id="header" name="header" />
	<input type="hidden" id="rows" name="rows" />
	<input type="hidden" id="footer" name="footer" />
	<input type="hidden" id="file" name="file" value="Historial_Planificacion" />
	<input type="hidden" id="title" name="title" value="Historial Planificacion" />
</form>

	
</body>
</html:html>
