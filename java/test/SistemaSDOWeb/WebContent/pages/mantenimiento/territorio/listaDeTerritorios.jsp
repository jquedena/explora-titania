<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@page import="java.util.Vector"%>
<%@page import="com.grupobbva.bc.per.tele.sdo.serializable.ListabusAllTerritorio"%>
<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
<TITLE></TITLE>
<%
Vector d = (Vector) request.getAttribute("listaTerritorio");
String perfil = (String) request.getAttribute("perfil");
ListabusAllTerritorio bean = null;
%>
<script language="javascript">

function nuevo(){

document.forms.action="mantenimientoTerritorioAction.do?method=nuevo";
document.forms.submit();
}

function editar(cod){
var valorSeleccionado=cod;

document.forms.codTerritorio.value=valorSeleccionado;
document.forms.action="mantenimientoTerritorioAction.do?method=mostrarEditar";
document.forms.submit();

}

function eliminar()	{
cadena="";
m = 1;
	if(document.forms.caja){
		if(document.forms.caja.length){
			for (i=0; i<document.forms.caja.length; i++) {
				if(document.forms.caja[i].checked){
					if(m==1)	cadena = cadena + document.forms.caja[i].value;
					else		cadena = cadena + ";" + document.forms.caja[i].value;
					m++;
				}
			}
		}
		else{
			if(document.forms.caja.checked)	{
				cadena = document.forms.caja.value;
				m++;
			}
		}
		if(m==1){
			alert("Debe de Seleccionar por lo menos un Territorio");
			return false;
		}
		if (confirm("Desea eliminar el o los Territorios seleccionados")==false)
		return false;
		
		document.forms.codigos.value=cadena;
		document.forms.action="mantenimientoTerritorioAction.do?method=eliminarTerritorio";
		
		document.forms.submit();
	}
}
function seleccionar_todos(){
		if(document.forms.caja){
		  if(document.forms.caja.length){
			  for (i=0; i<document.forms.caja.length; i++) {
			  	if (document.forms.todos.checked==false) document.forms.caja[i].checked=false;
			  	else document.forms.caja[i].checked=true;
			  }
		  }
		  else  {
		  	if(document.forms.todos.checked==false) document.forms.caja.checked=false
		  	else document.forms.caja.checked=true
		  }
	  	}
}


var mensaje_error = '<%=session.getAttribute("error_Territorio")%>';
<% session.setAttribute("error_Territorio", null); %>
window.onload=function(){
	if (mensaje_error != 'null') {
		alert(mensaje_error);
	}
}
</script>
</HEAD>

<BODY>

<table align="center" width="100%" height="%" cellspacing="0" cellpadding="0">
	<tr>
		<td width="100%" align="left"  valign="top">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td><img src="<%=request.getContextPath()%>/images/esq_izq.jpg"></td>
					<td width="200" class="textocentradoblanco">MANTENIMIENTO</td>
					<td><img src="<%=request.getContextPath()%>/images/esq_der.jpg"></td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td style="border: 2px solid #264971;padding:20px;" valign="top" height="%" align="center">


			<!-- **** INICIO RESTO DE CÓDIGO DE LA PÁGINA-->
			<form  method="post" name="forms">
			<input type="hidden" name="codTerritorio" >
			<input type="hidden" name="codigos" >
			<p class="titulo" >MANTENIMIENTO DE TERRITORIOS</p>
			
			<table cellspacing="0" cellpadding="0" align="center">
			  <tr>
			    <td align="center" width="100" class="celda1cabecera">CODIGO</td>
			    <td align="center" class="celda1cabecera">NOMBRE</td>
			    <td align="center" width="70" class="celda1cabecera">Editar</td>
			    <td align="center" class="celda1cabecera">
			<INPUT TYPE="checkbox" name="todos" onClick="seleccionar_todos();"></td>
			    <td align="center" width="80" class="celda1cabecera">ESTADO</td>
			
			<% if(d!=null){
				String colorfila = "";
				for(int i=0;i<d.size();i++){
					bean = (ListabusAllTerritorio) d.elementAt(i);    

					if (i%2 != 0)
						colorfila = "colorfila1";
					else
						colorfila = "colorfila2";
						
					if(bean!=null){
			%>
			<tr>
				<td align="center"  class="<%=colorfila %>"><%=bean.getCodTerritorio() %></td>
				<td class="<%=colorfila %>"><%=bean.getNomTerritorio() %></td>
				<td align="center"  class="<%=colorfila %>">
				<% if(i<d.size()) {%>
					<a href="javascript:editar('<%=bean.getCodTerritorio() %>')"><IMG border="0" src="<%=request.getContextPath()%>/images/editar.png" width="18" height="18"></a>
				<%} %>
				</td>
				<td align="center" width="80"  class="<%=colorfila %>">
				<input type="checkbox" name="caja" value="<%=bean.getCodTerritorio() %>">
				</td>
				<td align="center" width="80"  class="<%=colorfila %>"><%=bean.getEstado() %></td>
			  </tr>
			<% 
					}
				} 
			} %>

			  <tr>
			    <td colspan="5" >&nbsp;</td>
			  </tr>
<%if(perfil.equals("ADM")){ %>
			  <tr>
			    <td colspan="5" align="center" >
					<table><tr>
					<td><input type="button" name="Nuevo" onClick="nuevo();" value="Nuevo" class="botonnew"></td>
					<td><input type="button" name="Eliminar" onClick="eliminar();" value="Eliminar" class="botonnew"></td>
					</tr></table>
				</td>
			  </tr>
<%} %>
			</table>
			</form>


<!-- **** FIN RESTO DE CÓDIGO DE LA PÁGINA-->


		</td>
	</tr>
</table>
</BODY>
</html:html>
