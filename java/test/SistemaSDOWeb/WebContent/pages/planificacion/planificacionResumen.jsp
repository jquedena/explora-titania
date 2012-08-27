<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@ taglib prefix="fn" uri="/WEB-INF/fn.tld"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>

<html:html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="generator" content="Bluefish 2.0.3" >
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.2.6.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/js-preparaJSONExcel.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/pages/planificacion/planificacionListar.js"></script>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
	<title></title>
	<script type="text/javascript" >
		$(function() {
			$(".DataGrid .Epigrafe").find("td").each(function() {
				$(this).addClass("Node");
			});
			$(".DataGrid .Epigrafe").find("td.Planificacion").each(function() {
				$(this).css({"backgroundColor": "#d8d8d8"});
			});
			$(".DataGrid .Resaltar").find("td").each(function() {
				$(this).css({"color": "#4c84b8", "fontWeight": "bold"});
			});
			$(".Col2").each(function() {
				$(this).addClass("Node");
			});
		});
	</script>
</head>
<body>
<html:form action="/planificacionAction" styleId="planeacionForm">
<table align="center" width="100%" height="%" cellspacing="0" cellpadding="0">
<tr>
	<td width="100%" align="left" valign="top">
	<table cellspacing="0" cellpadding="0">
		<tr>
			<td class="bls">&nbsp;</td>
			<td width="200" class="textocentradoblanco">RESUMEN</td>
			<td class="brs">&nbsp;</td>
		</tr>
	</table>
	</td>
</tr>
<tr>
	<td style="border: 2px solid #264971;padding:5px;" valign="top" height="%" align="center">
		<table border="0" cellpadding="0" cellspacing="0" width="99%">
		<tr align="center">
			<td>
			<table border="0" cellpadding="0" cellspacing="0" width="938">
			<tr>
				<td></td>
				<td></td>
				<td colspan="2" valign="top"></td>
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
					<tr align="center">
						<td>
						<table width="100%" cellpadding="0" cellspacing="0">
						<tr>
							<c:if test = "${requestScope.listaTerritorio != null}">
								<td>Territorio:</td>
								<td>
									<html:select property="codTerritorio" styleClass="combo" onchange="javascript:buscarResumen();">
									<c:forEach items="${requestScope.listaTerritorio}" var="lista" >
										<html:option value="${lista.codTerr}">
											<c:out value="${lista.nomTerr}"></c:out>
										</html:option>
									</c:forEach>
									</html:select>
								</td>
							</c:if>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td>Oficina:</td>
							<td>
								<html:select property="codOficina" styleClass="combo" onchange="javascript:buscarResumen();">
									<c:if test="${listaOficina != null}">
										<c:forEach items="${requestScope.listaOficina}" var="lista">
											<html:option value="${lista.codOfic}">
												<c:out value="${lista.codNomOficina}" />
											</html:option>
										</c:forEach>
									</c:if>
								</html:select>
							</td>
							<td></td>
							<td>Presupuesto de Referencia:</td>
							<td>
								<html:select property="preReferencia" styleClass="combo" onchange="javascript:buscarResumen();" disabled="true">
									<c:if test="${listaPresup != null}">
										<c:forEach items="${requestScope.listaPresup}" var="lista" >
											<html:option value="${lista.codelem}">
												<c:out value="${lista.valor1}" />
											</html:option>
										</c:forEach>
									</c:if>
								</html:select>
							</td>
						</tr>
						<tr>
							<td width="12%">Mes de Planificación</td>
							<td width="24%">
								<html:select property="mesPlanificacion" styleClass="combo" onchange="javascript:buscarResumen();">
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
							<td width="1%"></td>
							<td width="13%">Año:</td>
							<td width="19%">
								<html:select property="anho" styleClass="combo" onchange="javascript:buscarResumen();">
									<c:if test="${requestScope.listaAnhos != null}">
										<c:forEach items="${requestScope.listaAnhos}" var="lista">
											<html:option value="${lista.codelem}">
												<c:out value="${lista.valor1}" />
											</html:option>
										</c:forEach>
									</c:if>
								</html:select>
							</td>
						</tr>
						</table>
						</td>
					</tr>
					</table>
					</td>
					<td></td>
				</tr>
				<tr>
					<td height="2"></td>
					<td></td>
					<td></td>
				</tr>
				</table>
				</td>
				<td></td>
			</tr>
			</table>
		</tr>
		</table>
</tr>
</table>
<br>
<!-- Begin: Modificado por Juan Quedena -->
<c:if test="${not empty requestScope.listaPlanesResumen}">
<table class="DataGrid" cellpadding=0 cellspacing=0>
<tr class="Header">
	<th colspan=2>&nbsp;</th>
	<th colspan=2 style="background-color: #a5a5a5;">PLANIFICACI&Oacute;N</th>
	<th colspan=9>OBJETIVOS</th>
</tr>
<tr class="Header">
	<th style="width: 60px;" rowspan='3'>Prioridad</th>
	<th style="width: 250px;" rowspan='3'>Ep&iacute;grafe</th>
	<th style="width: 85px; background-color: #a5a5a5;" rowspan='3'>Facturaci&oacute;n</th>
	<th style="width: 85px; background-color: #a5a5a5;" rowspan='3'>Ajuste Territorial a la Facturaci&oacute;n</th>
	<th colspan=2>GOF</th>
	<th colspan=2>GCO</th>
	<th colspan=2>GPE</th>
	<th colspan=2>EBP</th>
	<th style="width: 75px;" rowspan=3>Total<br/>Asignado</th>
</tr>
<tr class="Header">
	<th colspan=2><c:out value="${requestScope.GOF}"/></th>
	<th colspan=2><c:out value="${requestScope.GCO}"/></th>
	<th colspan=2><c:out value="${requestScope.GPE}"/></th>
	<th colspan=2><c:out value="${requestScope.GPT}"/></th>
</tr>
<tr class="Header">
	<th style="width: 70px;">Sub Total</th>
	<th style="width: 70px;">%</th>
	<th style="width: 70px;">Sub Total</th>
	<th style="width: 70px;">%</th>
	<th style="width: 70px;">Sub Total</th>
	<th style="width: 70px;">%</th>
	<th style="width: 70px;">Sub Total</th>
	<th style="width: 70px;">%</th>
</tr>

<c:forEach items="${requestScope.listaPlanesResumen}" var="objBean" varStatus="fila">

<c:set var="classEpigrafe" value=" SubEpigrafe"/>
<c:set var="classPrioridad" value=""/>
<c:if test="${objBean.indHijo == 0}"><c:set var="classEpigrafe" value=" Epigrafe"/></c:if>
<c:if test="${objBean.prioridad < 99}"><c:set var="classPrioridad" value=" Resaltar"/></c:if>

<tr class="Row<c:out value="${classEpigrafe}"/><c:out value="${classPrioridad}"/>">
<td align="center">
	<c:if test="${objBean.prioridad != 99}"><c:out value="${objBean.prioridad}" /></c:if>&nbsp;
</td>
<td class="Col2"><c:out value="${objBean.nomEpigrafe}" /></td>
<!-- Facturacion -->
<td class="Planificacion" pattern="" type="NUMBER" align="right">
	<c:if test="${objBean.codEpigrafe=='0000900' || objBean.codEpigrafe=='0001000'}">
		<c:if test="${objBean.porcentajeMax == null && objBean.porcentajeMin == null }">&nbsp;</c:if>
		<c:if test="${objBean.porcentajeMin == objBean.porcentajeMax}">
			<c:if test="${objBean.porAlcanzado >= objBean.porcentajeMax}">${objBean.factPlanificacion}</c:if>
		</c:if>
		<c:if test="${objBean.porcentajeMin != objBean.porcentajeMax}">
			<c:if test="${objBean.porAlcanzado >= objBean.porcentajeMax}">${objBean.factPlanificacion}</c:if>
			<c:if test="${objBean.porAlcanzado <= objBean.porcentajeMin}">${objBean.factPlanificacion}</c:if>
		</c:if>
		<c:if test="${objBean.porAlcanzado > objBean.porcentajeMin && objBean.porAlcanzado < objBean.porcentajeMax}">${objBean.factPlanificacion}</c:if>
	</c:if>
	<c:if test="${objBean.codEpigrafe!='0000900' && objBean.codEpigrafe!='0001000'}">
		<c:if test="${objBean.porcentajeMax == null && objBean.porcentajeMin == null }">&nbsp;</c:if>
		<c:if test="${objBean.porcentajeMin == objBean.porcentajeMax}">
			<c:if test="${objBean.porAlcanzado >= objBean.porcentajeMax}">${objBean.factPlanificacion}</c:if>
		</c:if>
		<c:if test="${objBean.porcentajeMin < objBean.porcentajeMax}">
			<c:if test="${objBean.porcentajeMin != objBean.porcentajeMax}">
				<c:if test="${objBean.porAlcanzado >= objBean.porcentajeMax}">${objBean.factPlanificacion}</c:if>
				<c:if test="${objBean.porAlcanzado <= objBean.porcentajeMin}">${objBean.factPlanificacion}</c:if>
			</c:if>
			<c:if test="${objBean.porAlcanzado > objBean.porcentajeMin && objBean.porAlcanzado < objBean.porcentajeMax}">${objBean.factPlanificacion}</c:if>
		</c:if>
		<c:if test="${objBean.porcentajeMin > objBean.porcentajeMax}">
			<c:if test="${objBean.porcentajeMin != objBean.porcentajeMax}">
				<c:if test="${objBean.porcentajeMax >= objBean.porAlcanzado}">${objBean.factPlanificacion}</c:if>
				<c:if test="${objBean.porcentajeMin <= objBean.porAlcanzado}">${objBean.factPlanificacion}</c:if>
			</c:if>
			<c:if test="${objBean.porAlcanzado > objBean.porcentajeMax && objBean.porAlcanzado < objBean.porcentajeMin}">${objBean.factPlanificacion}</c:if>
		</c:if>
	</c:if>
</td>
<!-- Ajuste Territorial de la Facturacion -->
<td class="Planificacion" pattern="" type="NUMBER" align="right">
	<c:if test="${objBean.ajusteTerrPlanificacion != null}"><c:out value="${objBean.ajusteTerrPlanificacion}" /></c:if> 
	<c:if test="${objBean.ajusteTerrPlanificacion == null }">&nbsp;</c:if>
</td>
<!-- Facturacion Asignada al GOF -->
<!--
<td align="right">
	<c:if test="${objBean.factAsigGOFPlanificacion != null}"><c:out value="${objBean.factAsigGOFPlanificacion }" /></c:if>
	<c:if test="${objBean.factAsigGOFPlanificacion  == null}">0</c:if>
</td>
-->
<!-- GOF Subtotal-->
<td pattern="" type="NUMBER" align="right">
	<c:if test="${objBean.GOFObjetivos != null}"><c:out value="${objBean.GOFObjetivos}" /></c:if> 
	<c:if test="${objBean.GOFObjetivos == null}">0</c:if>
</td>
<!-- GOF %-->
<td pattern="" type="STRING" align="right">
	<c:if test="${objBean.porcGOFObjetivos != null}"><c:out value="${objBean.porcGOFObjetivos}"/>%</c:if>
	<c:if test="${objBean.porcGOFObjetivos == null}">0.00%</c:if>
</td>
<!-- GCO Subtotal-->
<td pattern="" type="NUMBER" align="right">
	<c:if test="${objBean.GCOObjetivos != null}"><c:out value="${objBean.GCOObjetivos}" /></c:if> 
	<c:if test="${objBean.GCOObjetivos == null}">0</c:if>
</td>
<!-- GCO %-->
<td pattern="" type="STRING" align="right">
	<c:if test="${objBean.porcGCOObjetivos != null}"><c:out value="${objBean.porcGCOObjetivos}" />%</c:if> 
	<c:if test="${objBean.porcGCOObjetivos == null}">0.00%</c:if>
</td>
<!-- GPE Subtotal-->
<td pattern="" type="NUMBER" align="right">
	<c:if test="${objBean.GPEObjetivos != null}"><c:out value="${objBean.GPEObjetivos}" /></c:if> 
	<c:if test="${objBean.GPEObjetivos == null}">0</c:if>
</td>
<!-- GPE %-->
<td pattern="" type="STRING" align="right">
	<c:if test="${objBean.porcGPEObjetivos != null}"><c:out value="${objBean.porcGPEObjetivos}" />%</c:if>
	<c:if test="${objBean.porcGPEObjetivos == null}">0.00%</c:if>
</td>
<!-- GPT Subtotal-->
<td pattern="" type="NUMBER" align="right">
	<c:if test="${objBean.GPTObjetivos != null}"><c:out value="${objBean.GPTObjetivos}" /></c:if>
	<c:if test="${objBean.GPTObjetivos == null}">0</c:if>
</td>
<!-- GPT %-->
<td pattern="" type="STRING" align="right">
	<c:if test="${objBean.porcGPTObjetivos != null}"><c:out value="${objBean.porcGPTObjetivos}" />%</c:if>
	<c:if test="${objBean.porcGPTObjetivos == null}">0.00%</c:if>
</td>
<!-- Total Asignado -->
<td pattern="" type="NUMBER" align="right">
	<c:if test="${objBean.totalAsignadoObjetivos != null}"><c:out value="${objBean.totalAsignadoObjetivos}" /></c:if>
	<c:if test="${objBean.totalAsignadoObjetivos == null}">0</c:if>
</td>
</tr>
</c:forEach>
</table>
</c:if>

<c:if test="${empty requestScope.listaPlanesResumen}">
	<label style="font-style: italic;"> No se encontraron Datos</label>
</c:if>
<!-- End: Modificado por Juan Quedena -->


<table width="100%" height="50px" border=0>
<tr>
<td align="center">
	<c:if test="${not empty requestScope.listaPlanesResumen}"><input style="width: 75px;" type="button" name="imprime" value="Imprimir" onClick="javascript:imprimirFinal()"></c:if>
	<c:if test="${not empty requestScope.listaPlanesResumen}"><input style="width: 75px;" type="button" id="exporta" name="exporta" value="Excel"></c:if>
</td>
</tr>
</table>
</html:form>

<form method="post" name="fExportarExel" action="ExportGenericExcelServlet">
	<input type="hidden" id="header" name="header" />
	<input type="hidden" id="rows" name="rows" />
	<input type="hidden" id="footer" name="footer" />
	<input type="hidden" id="file" name="file" value="Resumen_Planificacion" />
	<input type="hidden" id="title" name="title" value="Resumen Planificacion" />
</form>

</body>
</html:html>
