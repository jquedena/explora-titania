
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@page import="java.util.Vector"%>
<%@page import="com.grupobbva.bc.per.tele.sdo.serializable.Campanias"%>
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
Vector a = (Vector) request.getAttribute("listaEditar");
String codCamp = (String) request.getAttribute("codCamp");
String codOficinaCompleto = (String) request.getAttribute("codOficinaCompleto");
String codGestor = (String) request.getAttribute("codGestor");
String codAnho = (String) request.getAttribute("codAnho");
String codMes = (String) request.getAttribute("codMes");
String codEpigrafe = (String) request.getAttribute("codEpigrafe");
Vector listaEpigrafe = (Vector) request.getAttribute("listaEpigrafes");
Campanias bean = null;
%>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.2.6.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/validaTecla.js"></script>
<script language="javascript">
$(function(){
	$("select[name=codEpigrafe]").find('option').each(function(){
		text = $(this).html();
		text = text.replace("99 - ", "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		$(this).html(text);
	});
});

function enviar(anho, mes, codCamp, codGestor, codOficinaCompleto){

var ValorCodCamp=codCamp;
var ValorAnho = anho;
var ValorMes = mes;
var codGestor = codGestor;
var codOficinaCompleto = codOficinaCompleto;

var ValorOrden = document.forms.codOrden.value;
var ValorNomCamp = document.forms.nombreCampania.value;
var indexEpigrafe = document.forms.codEpigrafe.selectedIndex;
var codEpigrafe = document.forms.codEpigrafe.options[indexEpigrafe].value;

if(indexEpigrafe==-1 || codEpigrafe=="***"){
	alert('Seleccione un epigrafe');
	return false;
}
	
document.forms.codAnho.value=ValorAnho;
document.forms.codMes.value=ValorMes;
document.forms.nomCampania.value=ValorNomCamp;
document.forms.codOrden.value=ValorOrden;
document.forms.CodigoCamp.value=ValorCodCamp;
document.forms.codGestor.value=codGestor;
document.forms.codOficinaCompleto.value=codOficinaCompleto;

document.forms.action="reportePPGAction.do?method=editarCampania";
var resp = confirm("\u00BFDesea guardar los cambios?");    		
	if(resp) {
		document.forms.submit();
	}
}
function volver(anho, mes, codGestor, codOficinaCompleto){

var ValorAnho = anho;
var ValorMes = mes;
var codGestor = codGestor;
var codOficinaCompleto = codOficinaCompleto;

document.forms.codAnho.value=ValorAnho;
document.forms.codMes.value=ValorMes;
document.forms.codGestor.value=codGestor;
document.forms.codOficinaCompleto.value=codOficinaCompleto;

document.forms.action="reportePPGAction.do?method=inicioReportePGGAcciones2";
document.forms.submit();
}

</script>
</HEAD>

<BODY>
<form  method="post" name="forms">
<input type="hidden" name="codAnho" >
<input type="hidden" name="codMes" >
<input type="hidden" name="nomCampania" >
<input type="hidden" name="CodigoCamp" >
<input type="hidden" name="codigoOrden" >
<input type="hidden" name="codGestor" >
<input type="hidden" name="codOficinaCompleto" >
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

<CENTER>
<%bean = (Campanias)a.elementAt(0); %>
	<TABLE width="50%" cellpadding=1 cellspacing=1>
		<TR><TD colspan=2 align="center" class="titulo">EDITAR ESFUERZO ADICIONAL</TD></TR>
		<TR>
			<TD width=150 height=6px>A&Ntilde;O</TD>
			<TD ><%=codAnho %> </TD>
		</TR>
		<TR>
			<TD width=150 height=6px>MES</TD>
			<TD >
<%if(codMes.equals("01")){ %>ENERO<%}else if(codMes.equals("02")){%>FEBRERO<%}else if(codMes.equals("03")){ %>
MARZO<%}else if(codMes.equals("04")){ %>ABRIL<%}else if(codMes.equals("05")){ %>MAYO<%}else if(codMes.equals("06")){ %>JUNIO<%}
else if(codMes.equals("07")){ %>JULIO<%}else if(codMes.equals("08")){ %>AGOSTO<%}else if(codMes.equals("09")){ %>SETIEMBRE<%}
else if(codMes.equals("10")){ %>OCTUBRE<%}else if(codMes.equals("11")){ %>NOVIEMBRE<%}else {%>DICIEMBRE<%}%></TD>
		</TR>
		<TR>
			<TD width=150 height=6px>GESTOR</TD>			
		    <td>${nombreGestorAccion}</td>
		</TR>
		<TR>
			<TD width=150 height=6px>NOMBRE ESFUERZO</TD>			
		    <td><input name="nombreCampania" type="text" value="<%=bean.getNomCamp() %>" maxlength="80" size=70  onKeyPress="return SoloLetras()"/></td>
		</TR>
		<tr>
			<TD width=150 height=6px>EPIGRAFE</TD>			
			<td>
			<select name="codEpigrafe">
			<%
			out.write("<!-- " + listaEpigrafe.size() + " -->");
			if(listaEpigrafe != null) {				

				Epigrafe o;
				for(int i = 0; i < listaEpigrafe.size(); i++) {
					o = (Epigrafe) listaEpigrafe.get(i);
					out.write("<option value=" + o.getCodEpigrafe() + " ");
					if(bean != null) {
						out.write( bean.getCodEpigrafe().equalsIgnoreCase(o.getCodEpigrafe()) ? "selected" : "" );
					}
					out.write(">" + o.getNomEpigrafe() + "</option>");
				}
			}
			%>
			</select>
			</td>
		</tr>
		<TR >
			<TD width=150 height=6px>PRIORIDAD</TD>			
			<TD ><input name="codOrden" type="text" value="<%=bean.getOrden() %>" maxlength="2" size=10 onKeyPress="return validKey(this, event, INT_PATTERN);" /></td>
		</TR>		
	</TABLE>
	
	<TABLE width="50%">
		<TR><TD align="center">
			<c:if test="${sessionScope.gestor.codigoPerfil != 'CON'}">
			<INPUT TYPE="button" name="guardar" onClick="enviar('<%=codAnho%>','<%=codMes %>','<%=codCamp %>','<%=codGestor %>','<%=codOficinaCompleto %>');" value="Grabar">
			</c:if>
			<INPUT TYPE="button" name="atras" value ="Volver" onClick="volver('<%=bean.getAnho() %>','<%=bean.getMes() %>','<%=codGestor %>','<%=codOficinaCompleto %>');">
		</TD></TR>
	</TABLE>
</CENTER>
<!-- **** FIN RESTO DE CÓDIGO DE LA PÁGINA-->


		</td>
	</tr>
</table>
</form>
</BODY>
</html:html>
