
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@page import="java.util.Vector"%>
<%@page import="com.grupobbva.bc.per.tele.sdo.serializable.Epigrafe"%>
<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<META HTTP-EQUIV='PRAGMA' CONTENT='NO-CACHE'>
<META HTTP-EQUIV='EXPIRES' CONTENT='0'>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
<TITLE></TITLE>
<%
String codOficinaCompleto = (String)request.getAttribute("codOficinaCompleto");
String codOficina = (String)request.getAttribute("codOficina");
String codGestor = (String)request.getAttribute("codGestor");
String codAnho = (String)request.getAttribute("codAnho");
String codMes = (String)request.getAttribute("codMes");
String nomCampania = (String)request.getAttribute("nomCampania");
String prioridad = (String)request.getAttribute("prioridad");
String codEpigrafe = (String)request.getAttribute("codEpigrafe");
Vector listaEpigrafe = (Vector) request.getAttribute("listaEpigrafes");
%>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.2.6.js"></script>
<script language="javascript">
$(function(){
	$("select[name=codEpigrafe]").find('option').each(function(){
		text = $(this).html();
		text = text.replace("99 - ", "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		$(this).html(text);
	});
});

function SoloNumeros()
{
/*
Descripcion	:	Permite el ingreso unicamente de Numeros.
*/

if(window.event.keyCode!=13)
	{
	var Tecla;
	Tecla = String.fromCharCode(window.event.keyCode);
	if ( !(Tecla>="0"&&Tecla<="9") )
		{
		window.event.keyCode = 0;
		}
	}
}
function SoloLetras()
{   if(window.event.keyCode!=13)
   {
      var Tecla;
      Tecla = String.fromCharCode(window.event.keyCode);
      if ( !( (Tecla>="A" && Tecla<="Z")||(Tecla>="a" && Tecla<="z") || (Tecla>="0" && Tecla<="9") ||
              (Tecla=="?") || (Tecla=="?") || (Tecla=="?") || (Tecla=="?") || (Tecla=="?") ||
              (Tecla=="?") || (Tecla=="?") || (Tecla=="?") || (Tecla=="?") || (Tecla=="?") ||
              (Tecla==" ") || (Tecla=="?") || (Tecla=="?") ) )
     {
         window.event.keyCode = 0;
      }
   }	
   
}
function grabar(mes, anho, codOficina, codGestor, codOficinaCompleto){
	var codMes=mes;
	var codAnho=anho;
	var codOficina=codOficina;
	var codGestor=codGestor;
	var codOficinaCompleto=codOficinaCompleto;
	var nomCampania = document.forms.nombreCampania.value;
	var indexEpigrafe = document.forms.codEpigrafe.selectedIndex;
	var codEpigrafe = document.forms.codEpigrafe.options[indexEpigrafe].value;
	
	if(indexEpigrafe==-1 || codEpigrafe=="***"){
		alert('Seleccione un epigrafe');
		return false;
	}
	
	if(nomCampania==""){
		alert('Ingrese Nombre Esfuerzo');
		return false;
	}
	
	var prioridad = document.forms.codigoPrioridad.value;
	
	if(prioridad==""){
		alert('Ingrese Prioridad');
		return false;
	}
	
	document.forms.codAnho.value=codAnho;
	document.forms.codMes.value=codMes;
	document.forms.codOficina.value=codOficina;
	document.forms.codGestor.value=codGestor;
	document.forms.codOficinaCompleto.value=codOficinaCompleto;
	document.forms.nomCampania.value=nomCampania;
	document.forms.prioridad.value=prioridad;
	
	document.forms.action="reportePPGAction.do?method=nuevaCampania";
	var resp = confirm("\u00BFDesea guardar los cambios?");    		
	if(resp) {
    	document.forms.submit();
    }
}

function volver(mes, anho, codOficina, codGestor, codOficinaCompleto){

var codMes=mes;
var codAnho=anho;
var codOficina=codOficina;
var codGestor=codGestor;
var codOficinaCompleto=codOficinaCompleto;

document.forms.codAnho.value=codAnho;
document.forms.codMes.value=codMes;
document.forms.codOficina.value=codOficina;
document.forms.codGestor.value=codGestor;
document.forms.codOficinaCompleto.value=codOficinaCompleto;
document.forms.action="reportePPGAction.do?method=inicioReportePGGAcciones2";
document.forms.submit();

return null;
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
<input type="hidden" name="codAnho" >
<input type="hidden" name="codMes" >
<input type="hidden" name="codOficina">
<input type="hidden" name="codGestor" >
<input type="hidden" name="nomCampania" >
<input type="hidden" name="prioridad" >
<input type="hidden" name="codOficinaCompleto" >
<!-- input type="hidden" name="codEpigrafe" -->

<CENTER>
	<TABLE width="50%" cellpadding=1 cellspacing=1>
		<TR><TD colspan=2 align="center" class="titulo">NUEVO ESFUERZO ADICIONAL</TD></TR>
		<TR>
			<TD width=150 height=6px>A&Ntilde;O</TD>
			<TD><%=codAnho %> </TD>
		</TR>
		<TR>
			<TD width=150 height=6px>MES</TD>
			<TD>
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
			<TD width=150 height=6px>GESTOR</TD>			
		    <td>${nombreGestorAccion}</td>
		</TR>
		<TR>
			<TD width=150 height=6px>NOMBRE ESFUERZO</TD>			
		    <td><input name="nombreCampania" type="text" value="<%=nomCampania %>" maxlength="80" size=70 onKeyPress="return SoloLetras()" /></td>

		</TR>
		<tr>
			<TD width=150 height=6px>EPIGRAFE</TD>			
			<td>
			<select name="codEpigrafe">
			<%
			if(listaEpigrafe != null) {
				out.write("<!-- " + listaEpigrafe.size() + " -->");

				Epigrafe o;
				for(int i = 0; i < listaEpigrafe.size(); i++) {
					o = (Epigrafe) listaEpigrafe.get(i);
					out.write("<option value=" + o.getCodEpigrafe() + ">" + o.getNomEpigrafe() + "</option>");
				}
			}
			%>
			</select>
			</td>
		</tr>
		<TR>
			<TD width=150 height=6px>PRIORIDAD</TD>			
			<TD><input name="codigoPrioridad" type="text" value="<%=prioridad%>" maxlength="2" size=10 onKeyPress="return SoloNumeros()"/></td>
		</TR>		
	</TABLE>
	
	<TABLE width="50%">
		<TR><TD align="center">
			<c:if test="${sessionScope.gestor.codigoPerfil != 'CON'}">
			<INPUT TYPE="button" name="guardar" onClick="grabar('<%=codMes %>', '<%=codAnho %>', '<%=codOficina %>', '<%=codGestor %>','<%=codOficinaCompleto %>');" value="Grabar">
			</c:if>
			<INPUT TYPE="button" name="atras" value ="Volver" onClick="volver('<%=codMes %>', '<%=codAnho %>', '<%=codOficina %>', '<%=codGestor %>','<%=codOficinaCompleto %>');">
		</TD></TR>
	</TABLE>
</CENTER>
</form>

<!-- **** FIN RESTO DE CÓDIGO DE LA PÁGINA-->


		</td>
	</tr>
</table>
</BODY>
</html:html>
