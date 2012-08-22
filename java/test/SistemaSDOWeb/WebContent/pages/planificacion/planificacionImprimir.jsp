<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@ taglib prefix="fn" uri="/WEB-INF/fn.tld"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld" %>

<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<%=request.getContextPath()%>/pages/planificacion/planificacionListar.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/theme/IIRGEspacio2.css"
	type="text/css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/basico.css"
	type="text/css">	
<style type="text/css">
<!--
.Estilo4 {
	color: #000000;
	font-weight: bold;
}

.Estilo2 {
	color: #000000;	
}

-->
</style>
<TITLE></TITLE>
</HEAD>

<BODY>
<div id="pagina" style="overflow:auto;"><html:form
	action="/planificacionAction" styleId="planeacionForm">	
	<!-- Border Table Build for @Autor: Tasayco Yataco Jose ----------------------------->
	<table border="0" cellpadding="0" cellspacing="0" width="99%">
		<tr>
			<td width="97%"><!-- Tabs editar Nombres @Autor: Tasayco Yataco Jose ------->
			<table width="202" border="0" align="left" cellpadding="0"
				cellspacing="0">
				<tr>
					<td width="5">Imprimir Planificacion</td>
				</tr>
			</table>
			<!-- FIN Tabs editar Nombres @Autor: Tasayco Yataco Jose ------></td>
		</tr>
		<tr>
			<td>
			<table border="0" cellpadding="0" cellspacing="0" width="100%">
				
				<tr>
					<td class="BordeTabla"></td>
					<td class="BordeTabla"></td>
					<td colspan="2" valign="top" class="BordeTabla"></td>
					<td width="100%">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="0%" class="busqueda"></td>
							<td width="100%" class="busqueda"></td>
							<td width="0%" class="busqueda"></td>
						</tr>
						<tr>
							<td height="67" class="busqueda"></td>
							<!-- Contenido -->
							<td>
							<table width="100%" border="0">
								<tr>
									<td>
									<table width="100%" cellpadding="0" cellspacing="0" bgcolor="DBE7F3">
										<tr>
											<td style="font-size: 9pt;">Oficina: </td>
											<td><c:out value="${codOficina}"/></td>
											<TD></TD>
											<td style="font-size: 9pt;">Presupuesto de Referencia: </td>
											<td><c:out value="${presuReferencia}"/></td>																					
										</tr>
										<tr>
											<td width="12%" style="font-size: 9pt;">Mes de Planificación</td>
											<td width="24%"><c:out value="${mes}"/></td>
											<TD width="1%"></TD>
											<td width="13%" style="font-size: 9pt;">Año: </td>
											<td width="19%"><c:out value="${anho}"/></td>											
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
							<td class="busqueda" height="2"></td>
							<td class="busqueda"></td>
							<td class="busqueda"></td>
						</tr>
					</table>
					<!-- --------------------------- --></td>
					<td class="BordeTabla"></td>
					<td colspan="2" class="BordeTabla"></td>
					<td class="BordeTabla"></td>
				</tr>
			</table>
		</tr>		
	</table>
		<table width="938" height="80" border="1" cellspacing="0" >
  <tr class="cabeceraTabla">
    <td colspan="11" align="center" ><span class="Estilo4">Saldo Medio Expresado en Miles de Soles </span></td>
    <td width="55" rowspan="2" align="center"><span class="Estilo2">Factor de Ajuste Saldo Puntual </span></td>
    <td width="55" rowspan="2" align="center"><span class="Estilo2">Hist&oacute;rico Bajas </span></td>
    <td colspan="3" align="center"><span class="Estilo4">Facturaci&oacute;n Expresada en Miles de Soles </span></td>
  </tr>
  <tr class="cabeceraTabla">
    <td width="37" align="center"><span class="Estilo2">Prioridad</span></td>
    <td width="250" align="center"><span class="Estilo2">Epigrafe</span></td>
    <td width="48" align="center"><span class="Estilo2">Presup </span> <span class="Estilo4"><c:out value="${mesEvalMostrar}"/>.</span></td>
    <td width="48" align="center"><span class="Estilo2"><c:out value="${mesEvalMostrarAnte}"/>.</span></td>
    <td width="48" align="center"><span class="Estilo2">Var % mes</span></td>
    <td width="48" align="center"><span class="Estilo2">% Avance </span></td>
    <td width="48" align="center"><span class="Estilo2">Desv. Ppto. </span></td>
    <td width="48" align="center"><span class="Estilo2">Ajust % Presup </span></td>
    <td width="48" align="center"><span class="Estilo2">Desv. Presup. Ajust </span></td>
    <td width="48" align="center"><span class="Estilo2">N. Meses Faltant </span></td>
    <td width="48" align="center"><span class="Estilo2">Crec. Prom. Mens. </span></td>
    <td width="64" align="center"><span class="Estilo2">Objetivo Oficina</span></td>
    <td width="64" align="center"><span class="Estilo2">Ajuste Territorial </span></td>
    <td width="63" align="center"><span class="Estilo2">Asignaci&oacute;n a Gte Oficina </span></td>
  </tr>
  <c:if test="${indMostrar=='1'}">
  
  <logic:present name ="listaPlanes">
	<bean:define id="listaDatos" name="listaPlanes" scope="session" />
	<c:forEach items="${listaDatos}" var="objBean">
	<tr class="cuerpoTabla">
	<td><c:out value="${objBean.prioridad}"/></td>
	<td><c:out value="${objBean.nomEpigrafe}"/></td>
	<td><c:out value="${objBean.monto}"/></td>
	<td><c:out value="${objBean.montoMesSig}"/></td>
	<td><c:out value="${objBean.varMes}"/></td>
	<td><c:out value="${objBean.porAlcanzado}"/></td>
	<td><c:out value="${objBean.desvPpto}"/></td>
	<td><c:out value="${objBean.ajusPpto}"/></td>
	<td><c:out value="${objBean.desvAjusPpto}"/></td>
	<td><c:out value="${objBean.nroMesesFalt}"/></td>
	<td><c:out value="${objBean.proyCrecMens}"/></td>
	<td><c:out value="${objBean.factAjusSaldPunt}"/></td>
	<td><c:out value="${objBean.histBajas}"/></td>
	<td><c:out value="${objBean.metaMesSaldPunt}"/></td>
	<td><c:out value="${objBean.factAjusTerri}"/></td>
	<td><c:out value="${objBean.factAjusGereOfic}"/></td>
	</tr>
	</c:forEach>
	</logic:present>	
	</c:if>
	<c:if test="${indMostrar=='0'}">									  
		<label style="font-style: italic;">
		
		</label>
	</c:if>
	
</table>
	<table width="938">
	<tr>
	<td width="300"></td>
	<td width="338"></td>
	<td width="300"></td>
	</tr>
	<tr>
	<td>
	</td>
	<td align="center">
	<c:if test="${indMostrar=='1'}">		
		<input type="button" name="imprime" value="Imprimir" onclick="Javascript:imprimirFinal()"  class="Boton">
	</c:if>
	</td>
	<td>
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
	
	<!--FIN  Border Table Build for @Autor: Tasayco Yataco Jose ----------------------------->
</html:form></div>
</BODY>
</html:html>