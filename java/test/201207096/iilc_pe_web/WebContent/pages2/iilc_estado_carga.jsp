<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@page import="com.grupobbva.bc.per.tel.iilc.serializable.EstadoCarga"%>
<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META HTTP-EQUIV="REFRESH" CONTENT='5'>
<LINK rel="stylesheet" type="text/css" href='<c:out value="${pageContext.request.contextPath}"/>/theme/IIRGEspacio2.css'/>
<TITLE>Carpetas Comerciales</TITLE>

<%
EstadoCarga bean = (EstadoCarga)request.getAttribute("bean");
 %>
<script type="text/javascript">
 

function cargaEsperaDescarga(){
			var opciones="toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, width=300px, height=200px, top=85, left=140";
			ventana = window.open('cargaMasiva.do?method=descargaLog',"",opciones);
}
</script>
</HEAD>
<BODY>
<table width="100%" cellpadding="0" cellspacing="0" >
	<tr class="FondoGris2">
		<td>
			<img src="<c:out value="${pageContext.request.contextPath}"/>/images/dibujo.png" border="0" alt="">
		</td>
		<td align="right" style="vertical-align:middle; font-size: 16px; color: #2d4492; font-weight: bold; text-transform: uppercase">
			RECURSOS HUMANOS
		</td>
	</tr>
	<tr class="FondoAzul" >
		<td colspan="2" height="10px"></td>
	</tr>
</table>


	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td class="TituloPagServGen">Carpetas Comerciales</td>
		</tr>
	</table>
	<br>
	<table width="100%" border="1" cellpadding="0" cellspacing="0">
		<tr><td>
			<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="2%" class="FondoAzulSubTitulo"></td>
				<td width="98%" class="FondoAzulSubTitulo">ÚLTIMO ESTADO DE CARGA</td>
			</tr>
			</TABLE>
		</td></tr>
		<tr class="FondoGris1"><td>
		
		<% if(bean==null){ %>No hay datos en el historial de carga
		<% } else { %>
		<table border="0" width="100%" cellpadding="10"><tr><td width="50%" valign="top">
		
		<DIV style="border-bottom:1px solid gray; font-weight:bold;">ESTADO GENERAL</DIV><br />
		<table border="0" cellpadding="7" align="center">
		<tr>
			<td class="FondoAzulPeq">Estado de Carga</td>
			<td class="FondoClaro" style="border-bottom:1px solid gray;"><% if(bean.getEstado()==0) { %>Concluida<% } else { %>En proceso<% } %></td>
		</tr>
		<tr>
			<td class="FondoAzulPeq">Fecha de Inicio</td>
			<td class="FondoClaro" style="border-bottom:1px solid gray;"><%=bean.getFechaIni() %></td>
		</tr>
		<% if(bean.getEstado()==0) { %>
			<tr>
				<td class="FondoAzulPeq">Fecha de Fin</td>
				<td class="FondoClaro" style="border-bottom:1px solid gray;"><%=bean.getFechaFin() %></td>
			</tr>
		<% } %>
		<tr>
			<td class="FondoAzulPeq">Archivo de carga</td>
			<td class="FondoClaro" style="border-bottom:1px solid gray;">
				<% if(bean.getArchivoEncontrado()==0) { %>
					<% if(bean.getEstado()==0){ %>
						<div style="color:red;">No encontrado</div>
					<% } else { %>
						...
					<% } %>
				<% } else { %>
				Encontrado
				<% } %>
			</td>
		</tr>
		<tr>
			<td class="FondoAzulPeq">Data previa truncada</td>
			<td class="FondoClaro" style="border-bottom:1px solid gray;">
				<% if(bean.getTablasTruncadas()==0) { %>
					<div style="color:red;">No</div>
				<% } else { %>
					Si
				<% } %>
			</td>
		</tr>
		<tr>
			<td class="FondoAzulPeq">Filas procesadas</td>
			<td align="right" class="FondoClaro" style="border-bottom:1px solid gray;"><%=bean.getFilasProcesadas() %></td>
		</tr>

		<% if(bean.getEstado()==0) { %>
		<tr>
			<td  colspan="2" >
				<a  href='#' onclick="cargaEsperaDescarga();">Exportar log de errores carga archivo LCONDUC</a>
			</td>
		</tr>
		<% } %>
		
		</table>
		
		</td><td width="50%" valign="top">
		
		<DIV style="border-bottom:1px solid gray; font-weight:bold;">DETALLE DE FILAS</DIV><br />
		<table border="0" align="center" cellpadding="7">
		<tr>
			<td class="FondoAzulPeq" width="120">Tipo Fila</td>
			<td class="FondoAzulPeq" width="80">Leidas</td>
			<td class="FondoAzulPeq" width="80">Escritas</td>
		</tr>
		<tr>
			<td class="FondoClaro" style="border-bottom:1px solid gray;">Cliente (1)</td>
			<td align="right" class="FondoClaro" style="border-bottom:1px solid gray;"><%=bean.getFilasCLeidas() %></td>
			<td align="right" class="FondoClaro" style="border-bottom:1px solid gray;">
				<% if(bean.getFilasCEscritas()<bean.getFilasCLeidas()){ %>
					<div style="color:red;"><%=bean.getFilasCEscritas() %></div>
				<% } else { %>
					<%=bean.getFilasCEscritas() %>
				<% } %>
			</td>
		</tr>
		<tr>
			<td class="FondoClaro" style="border-bottom:1px solid gray;">Total Gestor (2+3)</td>
			<td align="right" class="FondoClaro" style="border-bottom:1px solid gray;"><%=bean.getFilasGLeidas() %></td>
			<td align="right" class="FondoClaro" style="border-bottom:1px solid gray;">
				<% if(bean.getFilasGEscritas()<bean.getFilasGLeidas()){ %>
					<div style="color:red;"><%=bean.getFilasGEscritas() %></div>
				<% } else { %>
					<%=bean.getFilasGEscritas() %>
				<% } %>
			</td>
		</tr>
		<tr>
			<td class="FondoClaro" style="border-bottom:1px solid gray;">Total Oficina (4+5)</td>
			<td align="right" class="FondoClaro" style="border-bottom:1px solid gray;"><%=bean.getFilasOLeidas() %></td>
			<td align="right" class="FondoClaro" style="border-bottom:1px solid gray;">
				<% if(bean.getFilasOEscritas()<bean.getFilasOLeidas()){ %>
					<div style="color:red;"><%=bean.getFilasOEscritas() %></div>
				<% } else { %>
					<%=bean.getFilasOEscritas() %>
				<% } %>
			</td>
		</tr>
		<tr>
			<td class="FondoClaro" style="border-bottom:1px solid gray;">Total Territorio (6+7)</td>
			<td align="right" class="FondoClaro" style="border-bottom:1px solid gray;"><%=bean.getFilasTLeidas() %></td>
			<td align="right" class="FondoClaro" style="border-bottom:1px solid gray;">
				<% if(bean.getFilasTEscritas()<bean.getFilasTLeidas()){ %>
					<div style="color:red;"><%=bean.getFilasTEscritas() %></div>
				<% } else { %>
					<%=bean.getFilasTEscritas() %>
				<% } %>
			</td>
		</tr>
		</table>
		
		</td></tr></table>
		
		<% } %>
		
		</td></tr>
	</table>

<!--<font size="2"><%=request.getAttribute("descCarga") %></font>-->
</BODY>
</html:html>