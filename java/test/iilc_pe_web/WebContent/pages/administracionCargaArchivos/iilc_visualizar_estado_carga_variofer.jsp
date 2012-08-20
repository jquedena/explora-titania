<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
 
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@page import="java.util.List" session="true" %>
<%@page import="java.util.ArrayList" session="true" %>
<%@page import="com.grupobbva.bc.per.tel.iilc.beans.Tiilc_adm_carga_archivo" session="true" %>

<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<LINK rel="stylesheet"
	href='<c:out value="${pageContext.request.contextPath}"/>/theme/IIRGEspacio2.css'
	type="text/css">
	<LINK rel="stylesheet" href='theme/IIRGEspacio2.css' type="text/css">
	
<TITLE>Carpetas Comerciales</TITLE>
<META HTTP-EQUIV="REFRESH" CONTENT='5;<c:out value="${pageContext.request.contextPath}"/>/admCargaOtrasOfertasAction.do?method=visualizarEstadoCarga'> 
<script type="text/javascript">


function cargaEsperaDescarga(){
			var opciones="toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, width=300px, height=200px, top=85, left=140";
			ventana = window.open('admCargaOtrasOfertasAction.do?method=descargarLogError&tipo=<%=request.getAttribute("tipo")%>',"",opciones);
}

function mensajero(){
	if(document.forms[0].mensaje.value=='NULL' ||
	   document.forms[0].mensaje.value=='null' ||
	   document.forms[0].mensaje.value==''){
	  }else{
	  	alert(document.forms[0].mensaje.value);
	  }
}

 
   
</script>
</HEAD>
<BODY onload="mensajero();" class="FondoGris1"  >

<html:form action="/admCargaOtrasOfertasAction" >

<input type="hidden" id="method" name="method" value="visualizarEstadoCarga" />
<input type="hidden" id="mensaje" name="mensaje" value="<%=request.getAttribute("mensaje")%>" />
<input type="hidden" id="tipo" name="tipo" value="<%=request.getAttribute("tipo")%>" />
<% 

 Tiilc_adm_carga_archivo objBean=(Tiilc_adm_carga_archivo)request.getAttribute("beanCarga"); %>

	<table width="100%" border="0" cellpadding="0" class="FondoGris1" cellspacing="0">
		<tr class="FondoGris1"><td>
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="datTable">
			<tr>
				<td align="left" width="25%" >
 					Estado de la carga
				</td>
				<td align="left"  width="25%"  style="font-weight:bold; " >
					<%if(request.getAttribute("beanCarga")!=null) {%>
 					 <%=objBean.getEstado_descripcion() %>
 					 <%} %>
				</td>
				<td align="left"  width="25%"  >
 					Cantidad de filas le&iacute;das
				</td>
				<td align="left"  width="25%" style="font-weight:bold; " >
				<%if(request.getAttribute("beanCarga")!=null) {%>
 					 <%=objBean.getFilas_leidas() %>
 				 <%} %>
				</td>
			</tr>
			<tr height="10" >
				<td align="right" colspan="4" >
 					 
				</td> 
			</tr>
			<tr>
				<td align="left" >
 					Fecha de inicio programada
				</td>
				<td align="left" style="font-weight:bold; " >
				<%if(request.getAttribute("beanCarga")!=null) {%>
 					 <%=objBean.getFecha_inicio_str()  %>
 				 <%} %>
				</td>
				<td align="left" >
 					Cantidad de filas procesadas OK
				</td>
				<td align="left" style="font-weight:bold; " >
				<%if(request.getAttribute("beanCarga")!=null) {%>
 					 <%=objBean.getFilas_procesadas() %>
 				 <%} %>
				</td>
			</tr>
			<tr height="10" >
				<td align="right" colspan="4" >
 					 
				</td> 
			</tr>
			 <tr>
				<td align="left" >
 					Fecha de inicio real
				</td>
				<td align="left" style="font-weight:bold; " >
				<%if(request.getAttribute("beanCarga")!=null) {%>
 					 <%=objBean.getFecha_inicio_real_str()!=null?objBean.getFecha_inicio_real_str()+"":"" %>
 				 <%} %>
				</td>
				<td align="left" >
 					Cantidad de filas no procesadas
				</td>
				<td align="left" style="font-weight:bold; " >
				<%if(request.getAttribute("beanCarga")!=null) {%>
 					 <%=objBean.getFilas_no_procesadas() %>
 				 <%} %>
				</td>
			</tr>
			<tr height="10" >
				<td align="right" colspan="4" >
 					 
				</td> 
			</tr>
			 <tr>
				<td align="left" >
 					Fecha de fin
				</td>
				<td align="left" style="font-weight:bold; " >
				<%if(request.getAttribute("beanCarga")!=null) {%>
 					 <%=objBean.getFecha_fin_str()!=null?objBean.getFecha_fin_str()+"":"" %>
 				 <%} %>
				</td>
				<td align="left" >
				</td>
			</tr>
			<tr height="10" >
				<td align="right" colspan="4" >
 					 
				</td> 
			</tr>
			<tr>
				<td align="left" >
 					Se encontr&oacute; archivo
				</td>
				<td align="left" style="font-weight:bold; " >
				<%if(request.getAttribute("beanCarga")!=null) {%>
 					 <%=objBean.getArchivo_carga()==1?"Si":"No" %>
 				 <%} %>
				</td>
				<td align="left" >
 					 
				</td>
			</tr> 
			 <tr height="10" >
				<td align="right" colspan="4" >
				<%if(request.getAttribute("beanCarga")!=null) {%> 
				<% if(objBean.getId_estado()==4){ %>
					<a   href='#' onclick="cargaEsperaDescarga()"    >
	 					 Descargar log de errores  
	 				</a>
	 			<%}
	 			}%>
				</td> 
			</tr>
		</TABLE>
		</td></tr>
	</table>
</html:form>
</BODY>
</html:html>
