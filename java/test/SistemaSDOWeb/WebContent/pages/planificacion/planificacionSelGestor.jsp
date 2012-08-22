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

<script>

var isNN = (navigator.appName.indexOf("Netscape")!=-1);

document.onkeypress = onlynumber;

function onlynumber(DnEvents) {
	// window.event.srcElement.value = 12345
	// alert(window.event.srcElement.name);
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
    form.action = "planificacionAction.do?method=elegirGestor";
    form.method="post";
    form.submit();
}
</script>


<BODY>
<div id="pagina" style="overflow:auto;"><html:form
	action="/planificacionAction" styleId="planeacionForm">	
	<!-- Border Table Build for @Autor: Tasayco Yataco Jose ----------------------------->
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
											<td style="font-size: 9pt;">Gestores: </td>
											<td><html:select property="codGestor" onchange="javascript:buscar();">
												<c:if test="${listaGestor != null}">
													<c:forEach var="lista" items="${listaGestor}">
														<html:option value="${lista.codGestor}"><c:out value="${lista.desGestor}" /></html:option>
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
				<input type="button" name="Entrar" value="Entrar" onclick="Javascript:elegirGestor()"  class="Boton">
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