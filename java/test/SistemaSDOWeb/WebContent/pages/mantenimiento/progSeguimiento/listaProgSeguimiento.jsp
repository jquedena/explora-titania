<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>


<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META HTTP-EQUIV='PRAGMA' CONTENT='NO-CACHE'>
<META HTTP-EQUIV='EXPIRES' CONTENT='0'>
<META http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
<TITLE>Mantenimiento Programación Seguimiento</TITLE>

<script language="javascript">
	function ver(codTerritorio, mes, anio) {
		var form = document.forms[0];
		
		form.method.value = "verProgSeguimiento";
		form.codTerritorio.value = codTerritorio;
		form.mes.value = mes;
		form.anio.value = anio;
		
		form.submit();
	}
	
	function editar(codTerritorio, mes, anio) {
		var form = document.forms[0];
		
		form.method.value = "mostrarNuevoEditarProgSeguimiento";
		form.codTerritorio.value = codTerritorio;
		form.mes.value = mes;
		form.anio.value = anio;
		
		form.submit();
	}
	
	function eliminar(codTerritorio, mes, anio) {
		var form = document.forms[0];
		
		form.method.value = "eliminarProgSeguimiento";
		form.codTerritorio.value = codTerritorio;
		form.mes.value = mes;
		form.anio.value = anio;
		
		form.submit();
	}
	
	function crear(codTerritorio, mes, anio) {
		var form = document.forms[0];
		
		form.method.value = "mostrarNuevoEditarProgSeguimiento";
		form.codTerritorio.value = codTerritorio;
		form.mes.value = mes;
		form.anio.value = anio;
		
		form.submit();
	}
	
	function volver() {
		var form = document.forms[0];
		
		form.method.value = "mostrarNuevoEditarProgSeguimiento";
		
		form.submit();
	}
	
var mensaje_error = '<%=request.getAttribute("mensajeExito")%>';

window.onload=function(){
	if (mensaje_error != 'null') {
		alert(mensaje_error);
	}
}
	
</script>

</HEAD>
<BODY>
<html:form action = "/progSeguimientoAction">
<html:hidden property="method"/>
<html:hidden property="codTerritorio"/>
<html:hidden property="mes"/>
<html:hidden property="anio"/>

<table align="center" width="100%" height="%" cellspacing="0" cellpadding="0">
	<tr>
		<td width="100%" align="left"  valign="top">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td><img src="${pageContext.request.contextPath}/images/esq_izq.jpg"></td>
					<td width="200" class="textocentradoblanco">MANTENIMIENTO</td>
					<td><img src="${pageContext.request.contextPath}/images/esq_der.jpg"></td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td style="border: 2px solid #264971;padding:20px;" valign="top" height="%" align="center">
			<div align="center"><strong>PROGRAMACI&Oacute;N SEGUIMIENTO</strong></div><br />
				<table cellspacing="0" cellpadding="0" align="center">  
				  <tr>
				    <td width="180">&nbsp;</td>
				    <td width="70">&nbsp;</td>
				    <td width="40">&nbsp;</td>
				    <td width="25">&nbsp;</td>
				    <td width="25">&nbsp;</td>
				    <td width="25">&nbsp;</td>
				  </tr>
				  <tr>
				   <td colspan = "6" align = "center">
						&nbsp;
				    </td>
				  </tr>
				  <tr>
				    <td width="180" align="center" class="celda1cabecera">Territorio</td>
				    <td width="70" align="center" class="celda1cabecera">Mes</td>
				    <td width="40" align="center" class="celda1cabecera">A&ntilde;o</td>
				    <td width="25" align="center" class="celda1cabecera">Ver</td>
				    <td width="25" align="center" class="celda1cabecera">Eliminar</td>
				  </tr>
				  <c:if test="${not empty requestScope.listaProgSeguimiento}">
				  	 <c:forEach items="${requestScope.listaProgSeguimiento}" var="row">
						 <tr>
							<td class="colorfila2">
									${row.nomTerritorio}
							</td>
						    <td class="colorfila2">
								<div align="center">
						    		${row.nomMes}
						    	</div>  	
						    </td>
						    <td class="colorfila2">
								<div align="center">
							    	${row.anio}
						    	</div>  		
						    </td>
						    <td class="colorfila2">
						    	<div align="center">
										<a href='javascript:ver(${row.codTerritorio},${row.mes},${row.anio})'   >
											<img src="${pageContext.request.contextPath}/images/ver.gif" width="18" height="18"  border="0" id="ver" />
										</a>
								</div>  
						    </td>
							 <td class="colorfila2">
								<div align="center">
									<a href='javascript:eliminar(${row.codTerritorio},${row.mes},${row.anio})'   >
										<img src="${pageContext.request.contextPath}/images/delete.gif" width="18" height="18"  border="0" id="eliminar" />
									</a>
								</div>
							</td>
						</tr>
					 </c:forEach>
				 </c:if>
				  
				  <c:if test="${empty requestScope.listaProgSeguimiento}">
					  <tr>
						<td class="colorfila2">&nbsp;</td>
					    <td class="colorfila2">&nbsp;</td>
					    <td class="colorfila2">&nbsp;</td>
					    <td class="colorfila2">&nbsp;</td>
					    <td class="colorfila2">&nbsp;</td>
					   </tr>
				 </c:if>
				</table>
				<br>
				<table cellspacing="0" cellpadding="0" align="center">  
					<tr>
						<td>
							<input type="button" name="btnVolver" onClick="javascript:volver();" value="Volver" class="botonnew">
						</td>
					</tr>
				</table>
		</td>
	</tr>
</table>
</html:form>
</BODY>
</html:html>