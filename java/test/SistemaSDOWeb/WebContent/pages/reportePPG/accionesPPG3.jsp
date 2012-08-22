<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@page import="java.util.Vector"%>
<%@page import="com.grupobbva.bc.per.tele.sdo.serializable.Accion"%>
<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="generator" content="Bluefish 2.0.3" >
<META HTTP-EQUIV='PRAGMA' CONTENT='NO-CACHE'>
<META HTTP-EQUIV='EXPIRES' CONTENT='0'>
<META http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
<TITLE></TITLE>
<%Vector a= (Vector)request.getAttribute("listaAcciones");
String codOficinaCompleto= (String)request.getAttribute("codOficinaCompleto");
String codOficina= (String)request.getAttribute("codOficina");
String codGestor= (String)request.getAttribute("codGestor");
String codAnho= (String)request.getAttribute("codAnho");
String codMes= (String)request.getAttribute("codMes");
String nomEpigrafe= (String)request.getAttribute("nomEpigrafe");
String prioridad= (String)request.getAttribute("prioridad");
String restoOficina= (String)request.getAttribute("restoOficina");
String metaGestor= (String)request.getAttribute("metaGestor");
String codEpigrafe= (String)request.getAttribute("codEpigrafe");
String tam="0";
if(a!=null){
tam=String.valueOf(a.size());}

Accion bean=null;
 %>
<script language="javascript">

function crear(codOficinaCompleto, codOficina, codGestor, codAnho, codMes, nomEpigrafe, prioridad, restoOficina, metaGestor, tam, codEpigrafe){
if(tam<15){

var codOficinaCompleto=codOficinaCompleto;
var codOficina=codOficina;
var codGestor=codGestor;
var codAnho=codAnho;
var codMes=codMes;
var nomEpigrafe=nomEpigrafe;
var prioridad=prioridad;
var restoOficina=restoOficina;
var metaGestor=metaGestor;
var codEpigrafe=codEpigrafe;

document.forms.codOficinaCompleto.value=codOficinaCompleto;
document.forms.codOficina.value=codOficina;
document.forms.codGestor.value=codGestor;
document.forms.codAnho.value=codAnho;
document.forms.codMes.value=codMes;
document.forms.nomEpigrafe.value=nomEpigrafe;
document.forms.prioridad.value=prioridad;
document.forms.restoOficina.value=restoOficina;
document.forms.metaGestor.value=metaGestor;
document.forms.codEpigrafe.value=codEpigrafe;

	if(nomEpigrafe==""){
		alert('Ingrese Nombre Esfuerzo');
		return false;
	}
	
	if(prioridad==""){
		alert('Ingrese Prioridad');
		return false;
	}

document.forms.action="reportePPGAction.do?method=mostarNuevaAccion";
document.forms.submit();
}
else{
alert('Solo puede ingresar 15 registros')
}

}

function eliminar(codOficinaCompleto, codOficina, codGestor, codAnho, codMes, nomEpigrafe, prioridad, restoOficina, metaGestor, codEpigrafe){
var codOficinaCompleto=codOficinaCompleto;
var codOficina=codOficina;
var codGestor=codGestor;
var codAnho=codAnho;
var codMes=codMes;
var nomEpigrafe=nomEpigrafe;
var prioridad=prioridad;
var restoOficina=restoOficina;
var metaGestor=metaGestor;
var codEpigrafe=codEpigrafe;

cadena="";
m = 1;			
	if(document.forms.caja)	{
		if(document.forms.caja.length)	{
			for (i=0; i<document.forms.caja.length; i++) {
				if(document.forms.caja[i].checked){	
					if(m==1)	cadena = cadena + document.forms.caja[i].value;
					else		cadena = cadena + ";" + document.forms.caja[i].value;						
					m++;
				}				
			}
		}
		else	{
			if(document.forms.caja.checked)	{
				cadena = document.forms.caja.value;
				m++;
			}
		}			
		if(m==1)	{
			alert("Debe de seleccionar por lo menos una acci\u00F3n");
			return false;
		}		
		if (confirm("\u00BF Desea eliminar las acciones seleccionadas ?")==false)	
		return false;

		document.forms.codigos.value=cadena;

		document.forms.codOficinaCompleto.value=codOficinaCompleto;
		document.forms.codOficina.value=codOficina;
		document.forms.codGestor.value=codGestor;
		document.forms.codAnho.value=codAnho;
		document.forms.codMes.value=codMes;
		document.forms.nomEpigrafe.value=nomEpigrafe;
		document.forms.prioridad.value=prioridad;
		document.forms.restoOficina.value=restoOficina;
		document.forms.metaGestor.value=metaGestor;
		document.forms.codEpigrafe.value=codEpigrafe;

		document.forms.action="reportePPGAction.do?method=eliminarAccion";		
		document.forms.submit();
	}	
}
function seleccionar_todos()	{

		if(document.forms.caja)	{
		  if(document.forms.caja.length)	{
			  for (i=0; i<document.forms.caja.length; i++) {
			  	if (document.forms.todos.checked==false)	document.forms.caja[i].checked=false;
			  	else	document.forms.caja[i].checked=true;
			  }
		  }
		  else  {
		  	if(document.forms.todos.checked==false)	document.forms.caja.checked=false
		  	else	document.forms.caja.checked=true
		  }
	  	}	
}
function volver(codOficinaCompleto, codGestor, codAnho, codMes){

var codOficinaCompleto=codOficinaCompleto;
var codGestor=codGestor;
var codAnho=codAnho;
var codMes=codMes;

document.forms.codAnho.value=codAnho;
document.forms.codMes.value=codMes;
document.forms.codOficinaCompleto.value=codOficinaCompleto;
document.forms.codGestor.value=codGestor;

document.forms.action="reportePPGAction.do?method=inicioReportePGGAcciones2";		
document.forms.submit();
}

function editar(codAccion, codOficinaCompleto, codGestor, codAnho, codMes, nomEpigrafe, prioridad, restoOficina, metaGestor, codEpigrafe){	
	document.forms.codOficinaCompleto.value = codOficinaCompleto;
	document.forms.codGestor.value = codGestor;
	document.forms.codAnho.value = codAnho;
	document.forms.codMes.value = codMes;
	document.forms.nomEpigrafe.value = nomEpigrafe;
	document.forms.prioridad.value = prioridad;
	document.forms.restoOficina.value = restoOficina;
	document.forms.metaGestor.value = metaGestor;
	document.forms.codEpigrafe.value = codEpigrafe;				

	document.forms.action="reportePPGAction.do?method=mostrarEditarAccion&codAccion=" + codAccion;
	document.forms.submit();
}
</Script>
</HEAD>


<BODY>
<form  method="post" name="forms">
<input type="hidden" name="codAnho" >
<input type="hidden" name="codMes" >
<input type="hidden" name="codOficina" >
<input type="hidden" name="codGestor" >
<input type="hidden" name="codigos" >
<input type="hidden" name="nomEpigrafe" >
<input type="hidden" name="prioridad" >
<input type="hidden" name="restoOficina" >
<input type="hidden" name="metaGestor" >
<input type="hidden" name="codOficinaCompleto" >
<input type="hidden" name="codEpigrafe" >

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


			<!-- **** INICIO RESTO DE CÓDIGO DE LA PÁGINA -->

<div align="center"><strong>ACCIONES - INGRESO A ACTIVIDADES</strong></div><br />
<table width="350px"><TR><TD align="center">	
	<table width="100%">
		<TR>
			<TD width="40%">OFICINA</TD>
			<TD ALIGN="left"><%=codOficinaCompleto %></TD>
		</TR>
		<TR>
			<TD width="40%">AÑO</TD>
			<TD ALIGN="left"><%=codAnho %></TD>
		</TR>
		<TR>
			<TD width="40%">MES</TD>
			<TD ALIGN="left">
				<%if(codMes.equals("01")){ %>ENERO
				<%}else if(codMes.equals("02")){%>FEBRERO
				<%}else if(codMes.equals("03")){%>MARZO
				<%}else if(codMes.equals("04")){%>ABRIL
				<%}else if(codMes.equals("05")){%>MAYO
				<%}else if(codMes.equals("06")){%>JUNIO
				<%}else if(codMes.equals("07")){%>JULIO
				<%}else if(codMes.equals("08")){%>AGOSTO
				<%}else if(codMes.equals("09")){%>SETIEMBRE
				<%}else if(codMes.equals("10")){%>OCTUBRE
				<%}else if(codMes.equals("11")){%>NOVIEMBRE
				<%}else {%>DICIEMBRE<%}%>				
			</TD>
		</TR>
		<TR>
			<TD width="40%">PRIORIDAD</TD>
			<TD ALIGN="left"><%=prioridad %></TD>
		</TR>		
		<TR>
			<TD width="40%">EPIGRAFE</TD>
			<TD ALIGN="left"><%=nomEpigrafe %></TD>
		</TR>
		<TR>
			<TD width="40%">GESTOR</TD>
			<TD ALIGN="left">${nombreGestorAccion}</TD>
		</TR>					
		<TR>
			<TD width="40%">META RESTO OFI.</TD>
			<TD ALIGN="left"><%=restoOficina %></TD>
		</TR>				
		<TR>
			<TD width="40%">META GESTOR</TD>
			<TD ALIGN="left"><%=metaGestor %></TD>
		</TR>				
	</TABLE>
</td>
</tr>
</table>
<BR><BR>
<c:if test="${perfil != 'ADM' && perfil != 'SUP' && perfil != 'CON'}">
	<input type="button" name="Crear" onClick="crear('<%=codOficinaCompleto %>','<%=codOficina %>','<%=codGestor %>','<%=codAnho %>','<%=codMes %>','<%=nomEpigrafe %>','<%=prioridad %>','<%=restoOficina %>','<%=metaGestor %>','<%=tam %>','<%=codEpigrafe %>');" value="AÑADIR">
</c:if>		
&nbsp;
<input type="button" name="Volver" onClick="volver('<%=codOficinaCompleto %>','<%=codGestor %>','<%=codAnho %>','<%=codMes %>');" value="VOLVER">
<%if(a!=null){ %>&nbsp;
<c:if test="${sessionScope.gestor.codigoPerfil != 'CON'}">
<input type="button" name="Eliminar" onClick="eliminar('<%=codOficinaCompleto %>','<%=codOficina %>','<%=codGestor %>','<%=codAnho %>','<%=codMes %>','<%=nomEpigrafe %>','<%=prioridad %>','<%=restoOficina %>','<%=metaGestor %>','<%=codEpigrafe %>');" value="ELIMINAR">
</c:if>
&nbsp;
<BR><BR>
<CENTER>
<table cellspacing="0" cellpadding="0" class="DataGrid" width="90%">
  <tr>
  	<th>&nbsp;</th>
    <th colspan="3">ACCIONES CONCRETAS</th>
    <th colspan="3">PRIMERA QUINCENA</th>
    <th colspan="3">SEGUNDA QUINCENA</th>
    <th colspan="3">TOTALES</th>
  </tr>
  <tr>  	
    <th align="center" style="width:40px;"><INPUT TYPE="checkbox" name="todos" onClick="seleccionar_todos();"></th>
    <th>Descripci&oacuten</th>
    <th style="width:70px;font-size:85%;">N&deg; de Clientes</th>
    <th style="width:70px;font-size:80%;">Compromiso del Gestor</th>
    <th style="width:70px;font-size:85%;">N&deg; Gestiones</th>
    <th style="width:70px;font-size:80%;">N&deg; Concretados</th>
    <th style="width:70px;font-size:85%;">Monto</th>
    <th style="width:70px;font-size:85%;">N&deg; Gestiones</th>
    <th style="width:70px;font-size:80%;">N&deg; Concretados</th>
    <th style="width:70px;font-size:85%;">Monto</th>
    <th style="width:70px;font-size:85%;">T.Gest</th>
    <th style="width:70px;font-size:85%;">T.Concr</th>
    <th style="width:70px;font-size:85%;">T.Montos</th>
  </tr>
<% 	
			if(a!=null)
			{	String colorfila = "";
				for(int i=0;i<a.size();i++){
				bean = (Accion)a.elementAt(i);    

				%>
  <tr>
	<td align="center">
		<input type="checkbox" name="caja" value="<%=bean.getCodAccion() %>">
	</td>
    <td>
    	<a href="javascript:editar('<%=bean.getCodAccion() %>','<%=codOficinaCompleto %>','<%=codGestor %>','<%=codAnho %>','<%=codMes %>','<%=nomEpigrafe %>','<%=prioridad %>','<%=restoOficina %>','<%=metaGestor %>','<%=codEpigrafe %>');"><%=bean.getNomAccion() %></a>
    </td>
    <td align="center"><%=bean.getNumeroCliente() %></td>
    <td align="center"><%=bean.getCompGestor() %></td>
    <td align="right"><%=bean.getNumeroGestiones1() %></td>
    <td align="right"><%=bean.getNumeroConcretados1() %></td>
    <td align="right"><%=bean.getMonto1() %></td>
    <td align="right"><%=bean.getNumeroGestiones2() %></td>
    <td align="right"><%=bean.getNumeroConcretados2() %></td>
    <td align="right"><%=bean.getMonto2() %></td>
    <td align="right"><%=bean.getTotalNumeroGestiones() %></td>
    <td align="right"><%=bean.getTotalNumeroConcretados() %></td>
    <td align="right"><%=bean.getTotalMonto() %></td>
  </tr>
		<% 
	 } 
}%>
</table>
</CENTER>
<%} %>
<!-- **** FIN RESTO DE CÓDIGO DE LA PÁGINA-->
		</td>
	</tr>
</table>
</form>
</BODY>
</html:html>
