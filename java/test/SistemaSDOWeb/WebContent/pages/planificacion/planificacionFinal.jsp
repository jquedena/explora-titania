<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@ taglib prefix="fn" uri="/WEB-INF/fn.tld"%>

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
	<!-- Border Table Build for @Autor: Godofredo Ureta ----------------------------->
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
											<td style="font-size: 9pt;">Oficina: </td>
											<td><html:select property="codOficina" onchange="javascript:buscar();">												
												<c:if test="${listaOficina != null}">
													<c:forEach var="lista" items="${listaOficina}">
														<html:option value="${lista.codOfic}"><c:out value="${lista.codNomOficina}" /></html:option>
													</c:forEach>
												</c:if>
											</html:select></td>
											<TD></TD>
											<td style="font-size: 9pt;">Presupuesto de Referencia: </td>
											<td><html:select property="preReferencia" onchange="javascript:buscar();">												
												<c:if test="${listaPresup != null}">
													<c:forEach var="lista" items="${listaPresup}">
														<html:option value="${lista.codelem}"><c:out value="${lista.valor1}" /></html:option>
													</c:forEach>
												</c:if>
											</html:select></td>																					
										</tr>
										<tr>
											<td width="12%" style="font-size: 9pt;">Mes de Planificación</td>
											<td width="24%"><html:select property="mesPlanificacion" onchange="javascript:buscar();">												
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
											<td width="13%" style="font-size: 9pt;">Año: </td>
											<td width="19%"><html:select property="anho" onchange="javascript:buscar();">												
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
		
		<logic:iterate id="planes" name="listaPlanes">
		
		<tr>
			<td width="37" align="center">
				<input type="text" class="textBlanco" name="listarNombre" value=<bean:write name="planes" property="nomEpigrafe"/> size="10"/>
			</td>
			
		</tr>
		
		</logic:iterate>
		

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
					<c:if test="${sessionScope.gestor.codigoPerfil=='GTE' || sessionScope.gestor.codigoPerfil=='ADM' || sessionScope.gestor.codigoPerfil=='SUP'}">
						<input type="button" value="Esfuerzos Adicionales" onclick="mostrarAcciones();"  class="Boton">
						<input type="button" name="calculo" value="Calcular" onclick="javascript:decide(indicadorCalculo);"  class="Boton">
						<input type="button" name="grabo" value="Grabar" onclick="javascript:envioDatos('${gestor}')"  class="Boton">
					</c:if>
					<input type="button" name="imprime" value="Imprimir" onclick="Javascript:imprimir('${gestor}')"  class="Boton">
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
	
	<!--FIN  Border Table Build for @Autor: Godofredo Ureta ----------------------------->
</html:form></div>
</BODY>
</html:html>