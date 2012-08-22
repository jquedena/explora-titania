<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@page import="java.util.Vector"%>
<!--@page import="com.grupobbva.bc.per.tele.sdo.serializable.ReportePPG"-->
<%@page import="com.grupobbva.bc.per.tele.sdo.serializable.Gestor"%>
<%@page import="com.grupobbva.bc.per.tele.sdo.serializable.Oficina"%>
<%@page import="com.grupobbva.bc.per.tele.sdo.serializable.Multitabla"%>
<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META HTTP-EQUIV='PRAGMA' CONTENT='NO-CACHE'>
<META HTTP-EQUIV='EXPIRES' CONTENT='0'>
<META http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
<TITLE></TITLE>
<%
Vector a= (Vector)request.getAttribute("listaAnhos");
Vector b= (Vector)request.getAttribute("listaOficina");
Vector newListaOficina=(Vector)request.getAttribute("newListaOficina");
Vector c= (Vector)request.getAttribute("listaGestor");
String codOficinaReturn= (String)request.getAttribute("codOficinaReturn");
String codAnhoReturn= (String)request.getAttribute("codAnhoReturn");
String codMesReturn= (String)request.getAttribute("codMesReturn");
Gestor bean =null;
//ReportePPG bean = null;
Oficina oficinaBean=null;
Multitabla newAnio=null;
%>
<script language="javascript">

function cargaGestor(){

var codOficina=document.forms.codoficina.value;
var codAnho=document.forms.anho.value;
var codMes=document.forms.mes.value;

document.forms.codOficina.value=codOficina;
document.forms.codAnho.value=codAnho;
document.forms.codMes.value=codMes;

document.forms.action="reportePPGAction.do?method=inicioReportePGGAcciones";
document.forms.submit();
}

function entrar(){
	var codAnho=document.forms.anho.value;
	var codMes=document.forms.mes.value;
	var codOficina=document.forms.codoficina.value;
	var codGestor=document.forms.gestores.value;
	var ind = document.forms.gestores.selectedIndex;

	if(codGestor == "" || codGestor == "-1" ) {		
		alert("Seleccione un gestor");			
		document.forms.gestores.focus();
	} else {
		document.forms.codAnho.value=codAnho;
		document.forms.codMes.value=codMes;
		document.forms.codOficinaCompleto.value=codOficina;
		document.forms.codGestor.value=codGestor;
		document.forms.nombreGestorAccion.value = document.forms.gestores.options[ind].text;
		document.forms.action="reportePPGAction.do?method=inicioReportePGGAcciones2";
		document.forms.submit();
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
					<td width="200" class="textocentradoblanco">PPG / ACCIONES</td>	
					<td><img src="<%=request.getContextPath()%>/images/esq_der.jpg"></td>	
				</tr>						
			</table>
		</td>	
	</tr>
	<tr>
		<td style="border: 2px solid #264971;padding:20px;" valign="top" height="%" align="center">


			<!-- **** INICIO RESTO DE CÓDIGO DE LA PÁGINA-->
<form  method="post" name="forms">
<input type="hidden" name="codOficina" >
<input type="hidden" name="codGestor" >
<input type="hidden" name="codMes" >
<input type="hidden" name="codAnho" >
<input type="hidden" name="codOficinaCompleto" >
<input type="hidden" name="nombreGestorAccion" >
<%if(newListaOficina!=null){ %>
<CENTER><p class="titulo" >SELECCIONAR OFICINA Y GESTOR</p></CENTER>
<p>
<CENTER>
<table cellspacing="0" cellpadding="0">
<tr height="30">
	<td height="20">MES / A&Ntilde;O: &nbsp;&nbsp;</td>
	<td>
		<select name="mes" class="combo">
			<OPTION value="01" <%if("01".equals(codMesReturn)){%>selected<%}%>>Enero</OPTION>
			<OPTION value="02" <%if("02".equals(codMesReturn)){%>selected<%}%>>Febrero</OPTION>
			<OPTION value="03" <%if("03".equals(codMesReturn)){%>selected<%}%>>Marzo</OPTION>
			<OPTION value="04" <%if("04".equals(codMesReturn)){%>selected<%}%>>Abril</OPTION>
			<OPTION value="05" <%if("05".equals(codMesReturn)){%>selected<%}%>>Mayo</OPTION>
			<OPTION value="06" <%if("06".equals(codMesReturn)){%>selected<%}%>>Junio</OPTION>
			<OPTION value="07" <%if("07".equals(codMesReturn)){%>selected<%}%>>Julio</OPTION>
			<OPTION value="08" <%if("08".equals(codMesReturn)){%>selected<%}%>>Agosto</OPTION>
			<OPTION value="09" <%if("09".equals(codMesReturn)){%>selected<%}%>>Setiembre</OPTION>
			<OPTION value="10" <%if("10".equals(codMesReturn)){%>selected<%}%>>Octubre</OPTION>
			<OPTION value="11" <%if("11".equals(codMesReturn)){%>selected<%}%>>Noviembre</OPTION>
			<OPTION value="12" <%if("12".equals(codMesReturn)){%>selected<%}%>>Diciembre</OPTION>
		</select>
		<select name="anho" class="combo">
		<% 	
		if(a!=null){
			String colorfila = "";
			for(int i=0;i<a.size();i++){
				newAnio = (Multitabla)a.elementAt(i);    
		%>
			<option value="<%=newAnio.getValor1()%>"<% if(newAnio.getValor1().equals(codAnhoReturn)){ %>selected<%}%>><%=newAnio.getValor1()%></option>

		<% 
			} 
		}
		%>
		</select>
	</td>
</tr>
<tr height="30">
	<td height="20">OFICINA: &nbsp;&nbsp;</td>
	<td>
		<select name="codoficina" onChange="cargaGestor();" class="combo">
		<% 	
		if(newListaOficina!=null){
			String colorfila = "";
			for(int i=0;i<newListaOficina.size();i++){
				oficinaBean = (Oficina)newListaOficina.elementAt(i); 
		%>
			<option value="<%=oficinaBean.getCodOfic()%>" <%if(oficinaBean.getCodOfic().equals(codOficinaReturn)){%>selected<%}%> ><%=oficinaBean.getCodNomOficina()%></option>
		<% 
			} 
		}
		%>
		</select>
	</td>
</tr>
<tr height="30">
	<td height="20">GESTORES</td>
	<td>
		<select name="gestores" class="combo">
			<OPTION value="-1" >Seleccione</option>
			<%
			if(c!=null){
				String colorfila = "";
				for(int i=0;i<c.size();i++){
					bean = (Gestor)c.elementAt(i);
			%>
				<OPTION value="<%=bean.getCodigoGestor()%>-<%=bean.getCodigoPerfil()%>"><%=bean.getNombreGestor() %></option>
			<% 
				} 
			} else {
			%>
				<OPTION value="">NO EXISTEN GESTORES</option>
			<%
			}
			%>
		</select>
	</td>
</tr>
</table>
<br>
<%
if(a!=null & newListaOficina!=null){
%>
	<div align="center"><input type="button" name="Entrar" onClick="entrar();" value="ENTRAR"></div>
<%
}
%>
</CENTER>
<%}else{ %>NO EXISTEN DATOS
<%} %>
</form>
<!-- **** FIN RESTO DE CÓDIGO DE LA PÁGINA-->
</td>
</tr>
</table>
</BODY>
</html:html>
