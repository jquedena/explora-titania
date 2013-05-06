<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html:html>
<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<META HTTP-EQUIV='PRAGMA' CONTENT='NO-CACHE'>
<META HTTP-EQUIV='EXPIRES' CONTENT='0'>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
<TITLE></TITLE>
<%
String codOficinaCompleto= (String)request.getAttribute("codOficinaCompleto");
String codOficina= (String)request.getAttribute("codOficina");
String codGestor= (String)request.getAttribute("codGestor");
String codAnho= (String)request.getAttribute("codAnho");
String codMes= (String)request.getAttribute("codMes");
String codCamp= (String)request.getAttribute("codCamp");
String descCampania= (String)request.getAttribute("descCampania");
String prioridad = (String)request.getParameter("prioridad");
String epigrafe = (String)request.getParameter("nomEpigrafe");
String codEpigrafe = (String)request.getParameter("codEpigrafe");

String descAccion= "";
int numeroCliente= 0;
int compromisoGestor= 0;
%>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/validaTecla.js"></script>
<script language="javascript">

	function grabar(codOficinaCompleto, codOficina, codGestor, codAnho, codMes, codCamp, descCampania){
		var descAccion = document.forms.nombreAccion.value;
		var numeroCliente = document.forms.numeroClientes.value;
		var compromisoGestor = document.forms.compGestor.value;
		
		document.forms.codOficinaCompleto.value = codOficinaCompleto;
		document.forms.codOficina.value = codOficina;
		document.forms.codGestor.value = codGestor;
		document.forms.codAnho.value = codAnho;
		document.forms.codMes.value = codMes;
		document.forms.codCamp.value = codCamp;
		document.forms.descAccion.value = descAccion;
		document.forms.numeroCliente.value = numeroCliente;
		document.forms.compromisoGestor.value = compromisoGestor;
		
		if(descAccion == "") {
			alert("Ingrese descripción");
			return false;
		}

		if(numeroCliente == "") {
			alert("Ingrese Nro. de Clientes");
			return false;
		}
		
		if(compromisoGestor == "") {
			alert("Ingrese Compromiso Gestor");
			return false;
		}
		
		document.forms.action="reportePPGAction.do?method=grabarCampaniaDetalle&descCampania=" + descCampania;
		var resp = confirm("\u00BFDesea guardar los cambios?");
		if(resp) {
    		document.forms.submit();
    	}
	}
	
function volver(codOficinaCompleto, codOficina, codGestor, codAnho, codMes, codCamp, descCampania) {
	document.forms.codOficinaCompleto.value = codOficinaCompleto;
	document.forms.codOficina.value = codOficina;
	document.forms.codGestor.value = codGestor;
	document.forms.codAnho.value = codAnho;
	document.forms.codMes.value = codMes;
	document.forms.codCamp.value = codCamp;
	document.forms.descCampania.value = descCampania;
				
	document.forms.action="reportePPGAction.do?method=mostrarEdicionCampaniaDetalle";
	document.forms.submit();
}
</script>
</HEAD>

<BODY>
<form  method="post" name="forms">
<input type="hidden" name="codAnho" >
<input type="hidden" name="codMes" >
<input type="hidden" name="codOficina" >
<input type="hidden" name="codGestor" >
<input type="hidden" name="codigos" >
<input type="hidden" name="restoOficina" >
<input type="hidden" name="metaGestor" >
<input type="hidden" name="codOficinaCompleto" >
<input type="hidden" name="codCamp" >
<input type="hidden" name="descCampania" >
<input type="hidden" name="descAccion" >
<input type="hidden" name="numeroCliente" >
<input type="hidden" name="compromisoGestor" >
<input type="hidden" name="codEpigrafe" value="<%=codEpigrafe%>" >
<input type="hidden" name="nomEpigrafe" value="<%=epigrafe%>" >
<input type="hidden" name="prioridad" value="<%=prioridad%>" >
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
<TABLE align="center" >
		<TR>
			<TD colspan=2>
				<div align="center"><strong>ESFUERZOS ADICIONALES</strong></div><br />
			</TD>
		</TR>
		<TR>
			<TD width="40%">OFICINA</TD>
			<TD ALIGN="left"><%=codOficinaCompleto %></TD>
		</TR>
		<TR>
			<TD width="40%">A&Ntilde;O</TD>
			<TD ALIGN="left"><%=codAnho %></TD>
		</TR>
		<TR>
			<TD width="40%">MES</TD>
			<TD ALIGN="left">
<%if(codMes.equals("01")){ %>ENERO<%}else if(codMes.equals("02")){%>FEBRERO<%}else if(codMes.equals("03")){ %>
MARZO<%}else if(codMes.equals("04")){ %>ABRIL<%}else if(codMes.equals("05")){ %>MAYO<%}else if(codMes.equals("06")){ %>JUNIO<%}
else if(codMes.equals("07")){ %>JULIO<%}else if(codMes.equals("08")){ %>AGOSTO<%}else if(codMes.equals("09")){ %>SETIEMBRE<%}
else if(codMes.equals("10")){ %>OCTUBRE<%}else if(codMes.equals("11")){ %>NOVIEMBRE<%}else {%>DICIEMBRE<%}%>
</TD>
		</TR>
		<TR>
			<TD width="40%">PRIORIDAD</TD>
			<TD ALIGN="left"><%=prioridad%></TD>
		</TR>
		<TR>
			<TD width="40%">EPIGRAFE</TD>
			<TD ALIGN="left"><%=epigrafe%></TD>
		</TR>		
		<TR>
			<TD width="40%">ESFUERZO</TD>
			<TD ALIGN="left"><%=descCampania %></TD>
		</TR>
		<TR>
			<TD width="40%">GESTOR</TD>
			<TD ALIGN="left">${nombreGestorAccion}</TD>
		</TR>		
	</TABLE>
	
	<BR>

	<TABLE align="center">
		<TR>
			<TD class="FondoAzul8" width="150" height=30>DESCRIPCION</TD>			
			<TD colspan=5>
<input name="nombreAccion" type="text" value="<%=descAccion %>"  size=70 maxlength="80" class="cajatexto" onKeyPress="return SoloLetras()"/> </TD>
		</TR>
		<TR>
			<TD class="FondoAzul8">N&deg; de Clientes</TD>
			<TD><input type="text" name="numeroClientes" size=10 maxlength="4" value="<%=numeroCliente %>" onKeyPress="return validKey(this, event, INT_PATTERN);" class="cajatexto"></TD>

			<TD class="FondoAzul8" width="200">Compromiso Gestor<br>&nbsp;(Monto en Miles) &nbsp;/&nbsp;Número</TD>
			<TD colspan=2><input type="text" name="compGestor" size=10 maxlength="10" value="<%=compromisoGestor %>" onKeyPress="return validKey(this, event, INT_PATTERN_NEGATIVO);" class="cajatexto"></TD>
		</TR>
	</TABLE>
	<TABLE align="center">
<tr><td align="center">
<c:if test="${sessionScope.gestor.codigoPerfil != 'CON'}">
<input type="button" name="Grabar" onClick="grabar('<%=codOficinaCompleto %>', '<%=codOficina %>', '<%=codGestor %>', '<%=codAnho %>', '<%=codMes %>', '<%=codCamp %>', '<%=descCampania %>');" value="Grabar">
</c:if>
&nbsp;
<input type="button" name="Volver" onClick="volver('<%=codOficinaCompleto %>', '<%=codOficina %>', '<%=codGestor %>', '<%=codAnho %>', '<%=codMes %>', '<%=codCamp %>', '<%=descCampania %>');" value="Volver">
</td></tr>


	</TABLE>

<!-- **** FIN RESTO DE CÓDIGO DE LA PÁGINA-->


		</td>
	</tr>
</table>
</form>
</BODY>
</html:html>
