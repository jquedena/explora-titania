
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@page import="java.util.Vector"%>
<%@page import="com.grupobbva.bc.per.tele.sdo.serializable.ReportePPG"%>
<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="generator" content="Bluefish 2.0.3" >
<META http-equiv="Content-Style-Type" content="text/css">
<META HTTP-EQUIV='PRAGMA' CONTENT='NO-CACHE'>
<META HTTP-EQUIV='EXPIRES' CONTENT='0'>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
<TITLE></TITLE>
<%
Vector a= (Vector)request.getAttribute("listaEpigrafe");
Vector b= (Vector)request.getAttribute("listaAnhos");
Vector c= (Vector)request.getAttribute("listaEsfuerzos");

String codOficinaCompleto= (String)request.getAttribute("codOficinaCompleto");
String codOficina= (String)request.getAttribute("codOficina");
String codGestor= (String)request.getAttribute("codGestor");
String codAnho= (String)request.getAttribute("codAnho");
String codMes= (String)request.getAttribute("codMes");

ReportePPG bean = null;
%>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.2.6.js"></script>
<script language="javascript">
$(function(){
	$(".EpigrafeN").each(function(){
		cod = $(this).attr("codEpigrafe");
		pri = $(this).attr("prioridad");
		epi = $(this).text();
		$('a[codEpigrafe='+cod+']').each(function(){
			$(this).html(epi);
			$(this).attr('nomEpigrafe', epi);
			$(this).attr('prioridad', pri);
		});
	});
});
function crear(codGestor, codOficina, anho, mes, codOficinaCompleto)	{	
var codMes=mes;
var codAnho=anho;
var codOf=codOficina;
var codGest=codGestor;
var codOficinaCompleto=codOficinaCompleto;

document.forms.codMes.value=codMes;
document.forms.codAnho.value=codAnho;
document.forms.codOficina.value=codOf;
document.forms.codGestor.value=codGest;
document.forms.codOficinaCompleto.value=codOficinaCompleto;
document.forms.action="reportePPGAction.do?method=mostrarNuevaCampania";
document.forms.submit();
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

function eliminar(codGestor, codOficina, anho, mes, codOficinaCompleto)	{

var codMes=mes;
var codAnho=anho;
var codOf=codOficina;
var codGest=codGestor;
var codOficinaCompleto=codOficinaCompleto;

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
			alert("Debe de Seleccionar por lo menos un Esfuerzo");
			return false;
		}		
		if (confirm("Desea eliminar el o los Esfuerzos seleccionados")==false)	
		return false;

		document.forms.codMes.value=codMes;
		document.forms.codAnho.value=codAnho;
		document.forms.codOficina.value=codOf;
		document.forms.codGestor.value=codGest;
		document.forms.codOficinaCompleto.value=codOficinaCompleto;

		document.forms.codigos.value=cadena;
		document.forms.action="reportePPGAction.do?method=eliminarCampania";
		document.forms.submit();
	}	
}
function editar(anho, mes, codCamp, codGestor, codOficinaCompleto, codEpigrafe){

nomEpigrafe=$('a[codEpigrafe='+cod+']').eq(0).attr('nomEpigrafe');
prioridad=$('a[codEpigrafe='+cod+']').eq(0).attr('prioridad');

var valorSeleccionado=codCamp;
var codGest=codGestor;
var codOficinaCompleto=codOficinaCompleto;
var codAnho=anho;
var codMes=mes;

document.forms.codCamp.value=valorSeleccionado;
document.forms.codGestor.value=codGest;
document.forms.codOficinaCompleto.value=codOficinaCompleto;
document.forms.codAnho.value=codAnho;
document.forms.codMes.value=codMes;

document.forms.codEpigrafe.value=codEpigrafe;
document.forms.nomEpigrafe.value=nomEpigrafe;
document.forms.prioridad.value=prioridad;

document.forms.action="reportePPGAction.do?method=mostrarEditarCampania";
document.forms.submit();
}

function adicionarCampaniaDetalle(anho, mes, codCamp, codGestor, codOficinaCompleto, descCampania, codEpigrafe){
	nomEpigrafe=$('a[codEpigrafe='+cod+']').eq(0).attr('nomEpigrafe');
	prioridad=$('a[codEpigrafe='+cod+']').eq(0).attr('prioridad');
	
	document.forms.codCamp.value = codCamp;
	document.forms.codGestor.value = codGestor;
	document.forms.codOficinaCompleto.value = codOficinaCompleto;
	document.forms.codAnho.value = anho;
	document.forms.codMes.value = mes;
	document.forms.codEpigrafe.value=codEpigrafe;
	document.forms.nomEpigrafe.value=nomEpigrafe;
	document.forms.prioridad.value=prioridad;
	
	// alert(codEpigrafe + '/' + nomEpigrafe + '/' + prioridad);
	
	document.forms.action="reportePPGAction.do?method=mostrarEdicionCampaniaDetalle&descCampania=" + descCampania;
	
	document.forms.submit();
}


function enviar(codGestor, codOficina, anho, mes, codOficinaCompleto, nomEpigrafe, prioridad, codEpigrafe){

var codMes=mes;
var codAnho=anho;
var codOf=codOficina;
var codGest=codGestor;
var codOficinaCompleto=codOficinaCompleto;
var nomEpigrafe=nomEpigrafe;
var prioridad=prioridad;
var codEpigrafe=codEpigrafe;

document.forms.codMes.value=codMes;
document.forms.codAnho.value=codAnho;
document.forms.codOficina.value=codOf;
document.forms.codGestor.value=codGest;
document.forms.codOficinaCompleto.value=codOficinaCompleto;
document.forms.codEpigrafe.value=codEpigrafe;
document.forms.nomEpigrafe.value=nomEpigrafe;
document.forms.prioridad.value=prioridad;

document.forms.action="reportePPGAction.do?method=inicioReportePGGAcciones3";
document.forms.submit();

}

function volver(anho, mes, codOficinaCompleto){

var codMes=mes;
var codAnho=anho;
var codOficinaCompleto=codOficinaCompleto;


document.forms.codMes.value=codMes;
document.forms.codAnho.value=codAnho;
document.forms.codOficina.value=codOficinaCompleto;


document.forms.action="reportePPGAction.do?method=inicioReportePGGAcciones";
document.forms.submit();

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
<input type="hidden" name="codMes" >
<input type="hidden" name="codAnho" >
<input type="hidden" name="codOficina" >
<input type="hidden" name="codGestor" >
<input type="hidden" name="codigos" >
<input type="hidden" name="codCamp" >
<input type="hidden" name="nomEpigrafe" >
<input type="hidden" name="prioridad" >
<input type="hidden" name="codOficinaCompleto" >
<input type="hidden" name="codEpigrafe">


<CENTER>
<p class="titulo" >ACCIONES - INGRESO A ACTIVIDADES</p>
</CENTER>

<CENTER>
<table cellspacing="0" cellpadding="0">

  <tr height="20">
    <td>OFICINA:  </td>
    <td><%=codOficinaCompleto %></td>
  </tr>
  <tr height="20">
		<td>MES / A&Ntilde;O:  </td>
	    <td>

<%if(codMes.equals("01")){ %>ENERO<%}else if(codMes.equals("02")){%>FEBRERO<%}else if(codMes.equals("03")){ %>
MARZO<%}else if(codMes.equals("04")){ %>ABRIL<%}else if(codMes.equals("05")){ %>MAYO<%}else if(codMes.equals("06")){ %>JUNIO<%}
else if(codMes.equals("07")){ %>JULIO<%}else if(codMes.equals("08")){ %>AGOSTO<%}else if(codMes.equals("09")){ %>SETIEMBRE<%}
else if(codMes.equals("10")){ %>OCTUBRE<%}else if(codMes.equals("11")){ %>NOVIEMBRE<%}else {%>DICIEMBRE<%}%>

 / <%=codAnho %>


</td>
  </tr>
	<tr height="20">
	    <td>GESTOR:  </td>
    	<td>${nombreGestorAccion}</td>
	</tr>  
</table>
</CENTER>
<br><br>
<%if(a!=null){ %>
<CENTER>
<table class="DataGrid" cellspacing=0 cellpadding=0>
<tr>
<th width="55">Prioridad</th>
<th width="250">Descripcion</th>
</tr>
<% 	
			if(a!=null)
			{	String colorfila = "";
				for(int i=0;i<a.size();i++){
				bean = (ReportePPG)a.elementAt(i);    
				%>
<tr>
 
<td><div align="center">
	<%if(bean.getPrioridad()==null || bean.getPrioridad().trim().equalsIgnoreCase("99") ){%>&nbsp;<%}else{%><%=bean.getPrioridad() %><%} %></div>
</td>
<td>
	<a class="EpigrafeN" prioridad="<%=bean.getPrioridad() %>" codEpigrafe="<%=bean.getCodEpigrafe()%>" href="#" onclick="enviar('<%=codGestor %>','<%=codOficina %>','<%=codAnho %>','<%=codMes %>','<%=codOficinaCompleto %>','<%=bean.getNomEpigrafe() %>','<%=bean.getPrioridad() %>','<%=bean.getCodEpigrafe()%>');" class="enlace">
		<%=bean.getNomEpigrafe() %>
	</a>
</td>

</tr>
		<% 
	 } 
}%>
</table>
</CENTER>
<%}
else{ %>
<%} %>
<br>
<CENTER><b>ESFUERZOS ADICIONALES<b><BR><BR>
<c:if test="${sessionScope.gestor.codigoPerfil != 'ADM' && sessionScope.gestor.codigoPerfil != 'SUP' && sessionScope.gestor.codigoPerfil != 'CON'}">
	<input type="button" name="Crear" onClick="crear('<%=codGestor %>','<%=codOficina %>','<%=codAnho %>','<%=codMes %>','<%=codOficinaCompleto %>');" value="A&Ntilde;ADIR">
</c:if>		
<%if(c!=null){ %>&nbsp;	&nbsp;	&nbsp;
<c:if test="${sessionScope.gestor.codigoPerfil != 'CON'}">
<input type="button" name="Eliminar" onClick="eliminar('<%=codGestor %>','<%=codOficina %>','<%=codAnho %>','<%=codMes %>','<%=codOficinaCompleto %>');" value="ELIMINAR">
</c:if>
<%}
else{} %>&nbsp;	&nbsp;	&nbsp;
<input type="button" name="Volver" onClick="volver('<%=codAnho %>','<%=codMes %>','<%=codOficinaCompleto %>');" value="VOLVER">
</CENTER>
<br>
<%if(c!=null){ %>
<CENTER>
<table class="DataGrid" cellspacing="0" cellpadding="0">
  <tr>
    <th style="width:20;"><INPUT TYPE="checkbox" name="todos" onClick="seleccionar_todos();"></th>
    <th style="width:230;">Ep&iacute;grafe</th>
	<th style="width:230;">Descripci&oacute;n</th>
	<th style="width:40;">Editar</th>
  </tr>
<% 	
			if(c!=null)
			{	String colorfila = "";
				for(int i=0;i<c.size();i++){
				bean = (ReportePPG)c.elementAt(i);
				%>
  <tr>
    <td>
		<input type="checkbox" name="caja" value="<%=bean.getCodCamp() %>">
	</td>
	<td>
    	<% if(i<c.size()) {%>
    		<a codEpigrafe="<%=bean.getCodEpigrafe()%>" nomEpigrafe="" prioridad="" href="javascript:adicionarCampaniaDetalle('<%=codAnho %>','<%=codMes %>','<%=bean.getCodCamp() %>','<%=codGestor %>','<%=codOficinaCompleto %>','<%=bean.getEsfuerzo() %>', '<%=bean.getCodEpigrafe()%>');">
				<%=bean.getCodEpigrafe()%>
			</a>
	    <%} %>
    </td>
    <td>
    	<% if(i<c.size()) {%>
    		<a href="javascript:adicionarCampaniaDetalle('<%=codAnho %>','<%=codMes %>','<%=bean.getCodCamp() %>','<%=codGestor %>','<%=codOficinaCompleto %>','<%=bean.getEsfuerzo() %>', '<%=bean.getCodEpigrafe()%>');"><%=bean.getEsfuerzo()%></a>
	    <%} %>
    </td>
	<td align="center">
		<% if(i<c.size()) {%>
		<a href="javascript:editar('<%=codAnho %>','<%=codMes %>','<%=bean.getCodCamp() %>','<%=codGestor %>','<%=codOficinaCompleto %>', '<%=bean.getCodEpigrafe()%>');">
			<IMG border="0" src="<%=request.getContextPath()%>/images/editar.png" width="18" height="18">
		</a>
		<%} %>
	</td>
  </tr>
		<% 
	 } 
}%>
</table>
</CENTER>
<%}
else{ %>

<%} %>
<br>
</form>
<!-- **** FIN RESTO DE CÓDIGO DE LA PÁGINA-->


		</td>
	</tr>
</table>
</BODY>
</html:html>
