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

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/theme/IIRGEspacio2.css" type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/basico.css" type="text/css">
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

<style type="text/css" media="print">
div.page { 
writing-mode: tb-rl;
height: 100%;
margin: 10% 0%;
}
</style>


<TITLE></TITLE>
</HEAD>

<script>
<% String colorfila = "";
	int i = 0;
 %>
</script>

<BODY>
<table align="center" width="100%" height="%" cellspacing="0" cellpadding="0">
	<tr>
		<td width="100%" align="left"  valign="top">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td><img src="<%=request.getContextPath()%>/images/esq_izq.jpg"></td>	
					<td width="200" class="textocentradoblanco">RESUMEN</td>	
					<td><img src="<%=request.getContextPath()%>/images/esq_der.jpg"></td>	
				</tr>						
			</table>
		</td>	
	</tr>
	<tr>
		<td style="border: 2px solid #264971;padding:20px;" valign="top" height="%" align="center">


		<!-- **** AQUI EL RESTO DE CÓDIGO DE LA PÁGINA-->

	<div id="pagina" style="overflow:auto;">
	<html:form action="/planificacionAction" styleId="planeacionForm">

	<table border="0" cellpadding="0" cellspacing="0" width="99%">
		<tr>
			<td width="97%"><!-- Tabs editar Nombres @Autor: Tasayco Yataco Jose ------->
				<table width="267" border="0" align="left" cellpadding="0"
					cellspacing="0">
					<tr>
						<td width="267">Busqueda de Planificación</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
			<table border="0" cellpadding="0" cellspacing="0" width="938">
				
				<tr>
					<td class="BordeTabla"></td>
					<td class="BordeTabla"></td>
					<td colspan="2" valign="top" class="BordeTabla"></td>
					<td width="100%">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="0%"></td>
							<td width="0%"></td>
							<td width="0%"></td>
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
											<td style="font-size: 9pt;" class="celda1cabecera">Oficina: </td>
											<td class="colorfila1"><html:select property="codOficina" onchange="javascript:buscarResumen();">												
												<c:if test="${listaOficina != null}">
													<c:forEach var="lista" items="${listaOficina}">
														<html:option value="${lista.codOfic}"><c:out value="${lista.codNomOficina}" /></html:option>
													</c:forEach>
												</c:if>
											</html:select></td>
											<TD></TD>
											<td style="font-size: 9pt;" class="celda1cabecera">Presupuesto de Referencia: </td>
											<td class="colorfila1"><html:select property="preReferencia" onchange="javascript:buscarResumen();">												
												<c:if test="${listaPresup != null}">
													<c:forEach var="lista" items="${listaPresup}">
														<html:option value="${lista.codelem}"><c:out value="${lista.valor1}" /></html:option>
													</c:forEach>
												</c:if>
											</html:select></td>																					
										</tr>
										<tr>
											<td width="12%" style="font-size: 9pt;" class="celda1cabecera">Mes de Planificación</td>
											<td width="24%" class="colorfila1"><html:select property="mesPlanificacion" onchange="javascript:buscarResumen();">												
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
											<td width="13%" style="font-size: 9pt;" class="celda1cabecera">Año: </td>
											<td width="19%" class="colorfila1"><html:select property="anho" onchange="javascript:buscarResumen();">												
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
	<table width="950" height="80" border="1" cellspacing="0" >  
		<tr class="cabeceraTabla">
			<td width="37" align="center" class="celda1cabecera"><span class="Estilo2">Prioridad</span></td>
			<td width="150" align="center" class="celda1cabecera"><span class="Estilo2">Epigrafe</span></td>
			<td width="70" align="center" class="celda1cabecera"><span class="Estilo2">Crec Prom Mens (SM)</span></td>
			<td width="70" align="center" class="celda1cabecera"><span class="Estilo2">Factor Ajuste GT</span></td>
			<td width="70" align="center" class="celda1cabecera"><span class="Estilo2">Asignación a GOF</span></td>
			<td width="70" align="center" class="celda1cabecera"><span class="Estilo2">% Meta Gerente</span></td>
			<td width="70" align="center" class="celda1cabecera"><span class="Estilo2">GCO</span></td>
			<td width="70" align="center" class="celda1cabecera"><span class="Estilo2">% GCO</span></td>    
			<td width="70" align="center" class="celda1cabecera"><span class="Estilo2">GPE</span></td>    
			<td width="70" align="center" class="celda1cabecera"><span class="Estilo2">% GPE</span></td>    
			<td width="70" align="center" class="celda1cabecera"><span class="Estilo2">GPT</span></td>    
			<td width="70" align="center" class="celda1cabecera"><span class="Estilo2">% GPT</span></td>    
		</tr>
		<c:if test="${indMostrar=='1'}">
		<logic:present name ="listaPlanes">
			<bean:define id="listaDatos" name="listaPlanes" scope="session" />
				<c:forEach items="${listaDatos}" var="objBean">
					<%  
						if (i%2 != 0) colorfila = "colorfila1";
						else colorfila = "colorfila2";
						i++;
					%>
					<tr class="cuerpoTabla">
						<td class="<%=colorfila %>"><c:if test="${objBean.prioridad !=99}">
								<c:out value="${objBean.prioridad}"/>
							</c:if>
						</td>
						<td class="<%=colorfila %>"><c:out value="${objBean.nomEpigrafe}"/></td>
						<td class="<%=colorfila %>"><c:out value="${objBean.proyCrecMens}"/></td>
						<td class="<%=colorfila %>"><c:out value="${objBean.metaMesSaldPunt}"/></td>
						<td class="<%=colorfila %>"><c:if test="${objBean.indAfecta=='S'}">
								<c:if test="${objBean.metaGereOficina != 0}"><c:out value="${objBean.metaGereOficina}"/></c:if>
								<c:if test="${objBean.metaGereOficina == 0}">0</c:if>
							</c:if>
						</td>
						<td class="<%=colorfila %>"><c:if test="${objBean.indAfecta=='S'}">
								<c:if test="${objBean.porMetaGerente != 0}"><c:out value="${objBean.porMetaGerente}"/></c:if>
								<c:if test="${objBean.porMetaGerente == 0}">?</c:if>
							</c:if>
						</td>
						<td class="<%=colorfila %>">
							<c:if test="${objBean.desvPpto != 0}"><c:out value="${objBean.desvPpto}"/></c:if>
							<c:if test="${objBean.desvPpto == 0}">0</c:if>
						</td>
						<td class="<%=colorfila %>">
							<c:if test="${objBean.desvAjusPpto != 0}"><c:out value="${objBean.desvAjusPpto}"/></c:if>
							<c:if test="${objBean.desvAjusPpto == 0}">?</c:if>
						</td>
						<td class="<%=colorfila %>">
							<c:if test="${objBean.monto != 0}"><c:out value="${objBean.monto}"/></c:if>
							<c:if test="${objBean.monto == 0}">?</c:if>
						</td>
						<td class="<%=colorfila %>">
							<c:if test="${objBean.montoMesSig != 0}"><c:out value="${objBean.montoMesSig}"/></c:if>
							<c:if test="${objBean.montoMesSig == 0}">?</c:if>
						</td>
						<td class="<%=colorfila %>">
							<c:if test="${objBean.proyAjusMens != 0}"><c:out value="${objBean.proyAjusMens}"/></c:if>
							<c:if test="${objBean.proyAjusMens == 0}">?</c:if>
						</td>
						<td class="<%=colorfila %>">
							<c:if test="${objBean.proyCrecMens != 0}"><c:out value="${objBean.proyCrecMens}"/></c:if>
							<c:if test="${objBean.proyCrecMens == 0}">?</c:if>
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
			<td width="300"></td>
			<td width="338"></td>
			<td width="300"></td>
		</tr>
		<tr>
			<td>
			</td>
			<td align="center">
				<c:if test="${indMostrar=='1'}">		
					<input type="button" name="imprime" value="Imprimir" onClick="Javascript:imprimirResumen()" class="Boton">
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
</html:form>
</div>
		
		<!-- **** FIN EL RESTO DE CÓDIGO DE LA PÁGINA-->
		</td>
	</tr>
</table>
</BODY>
</html:html>