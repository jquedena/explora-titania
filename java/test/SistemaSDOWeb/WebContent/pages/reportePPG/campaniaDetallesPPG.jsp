<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@page import="java.util.Vector"%>
<%@page import="com.grupobbva.bc.per.tele.sdo.serializable.CampaniasGeneral"%>
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
Vector lista = (Vector)request.getAttribute("listaCampaniasDetalles");
String codOficinaCompleto = (String)request.getAttribute("codOficinaCompleto");
String codOficina = (String)request.getAttribute("codOficina");
String codGestor = (String)request.getAttribute("codGestor");
String codAnho = (String)request.getAttribute("codAnho");
String codMes = (String)request.getAttribute("codMes");
String descCampania = (String)request.getAttribute("descCampania");
String codCamp = (String)request.getAttribute("codCamp");
String prioridad = (String)request.getParameter("prioridad");
String epigrafe = (String)request.getParameter("nomEpigrafe");
String codEpigrafe = (String)request.getParameter("codEpigrafe");

String tam = "0";
if(lista != null){
	tam = String.valueOf(lista.size());
}

CampaniasGeneral bean = null;
 %>
<script language="javascript">
	function crear(codOficinaCompleto, codOficina, codGestor, codAnho, codMes, descCampania, codCamp, tam) {
		if(tam < 15){	
			document.forms.codOficinaCompleto.value = codOficinaCompleto;
			document.forms.codOficina.value = codOficina;
			document.forms.codGestor.value = codGestor;
			document.forms.codAnho.value = codAnho;
			document.forms.codMes.value = codMes;
			document.forms.codCamp.value = codCamp;		
		
			document.forms.action="reportePPGAction.do?method=mostrarNuevoCampaniaDetalle&descCampania=" + descCampania;
			document.forms.submit();
		} else {
			alert('Solo puede ingresar 15 registros');
		}
	}

function eliminar(codOficinaCompleto, codOficina, codGestor, codAnho, codMes, descCampania, codCamp) {
	var cadena = "";
	var arreglo;
	var cod;
	var nombre;	
	var elim;	
	var noEliminados = "";	
	
	m = 1;			
		if(document.forms.caja)	{
			if(document.forms.caja.length)	{
				for (i=0; i<document.forms.caja.length; i++) {
					if(document.forms.caja[i].checked){	
						arreglo = document.forms.caja[i].value.split("-");
						cod = arreglo[0];
						nombre = arreglo[1];	
						elim = arreglo[2];
						
						if(elim == "1") {
							if(m == 1) {
								cadena = cadena + cod;
							}
							else {		
								cadena = cadena + ";" + cod;						
							}
						} else {							
							noEliminados += nombre + "," ;
						}
						m++;
					}				
				}
			}
			else	{
				if(document.forms.caja.checked)	{
					arreglo = document.forms.caja.value.split("-");
					cod = arreglo[0];
					nombre = arreglo[1];	
					elim = arreglo[2];
					
					if(elim == "1") {
						cadena = cod;
					} else {
						noEliminados += nombre;
					}
					m++;
				}
			}			
			if(m == 1)	{
				alert("Debe de Seleccionar por lo menos un Esfuerzo Adicional");
				return false;
			}		
			if (confirm("Desea eliminar la o las Esfuerzos Adicionales seleccionadas") == false) {	 
				return false;
			}
	
			document.forms.codigos.value = cadena;
	
			document.forms.codOficinaCompleto.value = codOficinaCompleto;
			document.forms.codOficina.value = codOficina;
			document.forms.codGestor.value = codGestor;
			document.forms.codAnho.value = codAnho;
			document.forms.codMes.value = codMes;
			document.forms.codCamp.value = codCamp;	
			document.forms.descCampania.value = descCampania;		
	
			document.forms.action="reportePPGAction.do?method=eliminarCampaniaDetalle";		
			document.forms.submit();
			
			
			if(noEliminados != "") {
				alert("Los siguientes esfuerzos no pueden ser eliminados, debido a que se han registrado datos de seguimiento: " + noEliminados);
			}			
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

	function volver(codOficinaCompleto, codOficina, codGestor, codAnho, codMes) {
		document.forms.codAnho.value = codAnho;
		document.forms.codMes.value = codMes;
		document.forms.codOficinaCompleto.value = codOficinaCompleto;
		document.forms.codOficina.value = codOficina;
		document.forms.codGestor.value = codGestor;
		
		document.forms.action="reportePPGAction.do?method=inicioReportePGGAcciones2";		
		document.forms.submit();
	}
	
	function editar(codCampaniaDetalle, codOficinaCompleto, codOficina, codGestor, codAnho, codMes, descCampania, codCamp){	
		document.forms.codOficinaCompleto.value = codOficinaCompleto;
		document.forms.codOficina.value = codOficina;
		document.forms.codGestor.value = codGestor;
		document.forms.codAnho.value = codAnho;
		document.forms.codMes.value = codMes;
		document.forms.codCamp.value = codCamp;			
		document.forms.descCampania.value = descCampania;		
	
		document.forms.action="reportePPGAction.do?method=mostrarEditCampaniaDetalle&codCampaniaDetalle=" + codCampaniaDetalle;
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
<input type="hidden" name="restoOficina" >
<input type="hidden" name="metaGestor" >
<input type="hidden" name="codOficinaCompleto" >
<input type="hidden" name="codEpigrafe" value="<%=codEpigrafe%>" >
<input type="hidden" name="nomEpigrafe" value="<%=epigrafe%>" >
<input type="hidden" name="prioridad" value="<%=prioridad%>" >
<input type="hidden" name="codCamp" >
<input type="hidden" name="descCampania" >

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

<div align="center"><strong>ESFUERZOS ADICIONALES</strong></div><br />
<TABLE><TR><TD align="center">	
	<TABLE>
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
<c:if test="${sessionScope.gestor.codigoPerfil != 'CON'}">
<input type="button" name="Crear" onClick="crear('<%=codOficinaCompleto %>','<%=codOficina %>','<%=codGestor %>','<%=codAnho %>','<%=codMes %>','<%=descCampania %>','<%=codCamp %>','<%=tam %>');" value="A&Ntilde;ADIR">
</c:if>
&nbsp;
<input type="button" name="Volver" onClick="volver('<%=codOficinaCompleto %>','<%=codOficina %>','<%=codGestor %>','<%=codAnho %>','<%=codMes %>');" value="VOLVER">
<%if(lista != null){ %>&nbsp;
<c:if test="${sessionScope.gestor.codigoPerfil != 'CON'}">
<input type="button" name="Eliminar" onClick="eliminar('<%=codOficinaCompleto %>','<%=codOficina %>','<%=codGestor %>','<%=codAnho %>','<%=codMes %>','<%=descCampania %>','<%=codCamp %>');" value="ELIMINAR">
</c:if>
&nbsp;
<BR><BR>
<CENTER>
<table cellspacing="0" cellpadding="0" class="DataGrid">
  <tr>
  	<th colspan="1">&nbsp;</th>
    <th colspan="3">ESFUERZOS ADICIONALES</th>
    <th colspan="3">PRIMERA QUINCENA</th>
    <th colspan="3">SEGUNDA QUINCENA</th>
    <th colspan="3">TOTALES</th>
  </tr>
  <tr height="20">
   <th align="center">
		<INPUT TYPE="checkbox" name="todos" onClick="seleccionar_todos();">
	</th>
    <th align="center">Descripci&oacute;n</th>
    <th align="center">N&deg; de Clientes</th>
    <th align="center">Compromiso del Gestor</th>
    <th align="center">N&deg; Gestiones</th>
    <th align="center">N&deg; Concretados</th>
    <th align="center">Monto</th>
    <th align="center">N&deg; Gestiones</th>
    <th align="center">N&deg; Concretados</th>
    <th align="center">Monto</th>
    <th align="center">T.Gest</th>
    <th align="center">T.Concr</th>
    <th align="center">T.Montos</th>
  </tr>
<% 	
			if(lista != null)
			{	String colorfila = "";
				for(int i=0; i < lista.size() - 1; i++){
				bean = (CampaniasGeneral)lista.elementAt(i);    

				if (i%2 != 0)
					colorfila = "colorfila1";
				else
					colorfila = "colorfila2";
					
				String elim = "1";
				
				if( bean.getNroGestorSeguimiento1().doubleValue() != 0 ||
					bean.getNroConcSeguimiento1().doubleValue() != 0 ||
					bean.getMontoSeguimiento1().doubleValue() != 0 ||
					bean.getNroGestorSeguimiento2().doubleValue() != 0 ||
					bean.getNroConcSeguimiento2().doubleValue() != 0 ||
					bean.getMontoSeguimiento2().doubleValue() != 0) {					
					elim = "0";
				}
				%>
	  <tr height="20">
		<td align="center" width="80"  class="<%=colorfila %>">
				<input type="checkbox" name="caja" value="<%=bean.getCodigoCampaniaDetalle() %>-<%=bean.getNombreCampania() %>-<%=elim %>">
	    
	    <td class="<%=colorfila %>">
	    	<a href="javascript:editar('<%=bean.getCodigoCampaniaDetalle() %>','<%=codOficinaCompleto %>','<%=codOficina %>','<%=codGestor %>','<%=codAnho %>','<%=codMes %>','<%=descCampania %>','<%=codCamp %>');"><%=bean.getNombreCampania() %></a>
	    </td>
	    
	    <td align="center" class="<%=colorfila %>"><%=bean.getNroClientes() %></td>
	    <td align="center" class="<%=colorfila %>"><%=bean.getCompromisoGestor() %></td>
	    <td align="right" class="<%=colorfila %>"><%=bean.getNroGestorSeguimiento1() %></td>
	    <td align="right" class="<%=colorfila %>"><%=bean.getNroConcSeguimiento1() %></td>
	    <td align="right" class="<%=colorfila %>"><%=bean.getMontoSeguimiento1() %></td>
	    <td align="right" class="<%=colorfila %>"><%=bean.getNroGestorSeguimiento2() %></td>
	    <td align="right" class="<%=colorfila %>"><%=bean.getNroConcSeguimiento2() %></td>
	    <td align="right" class="<%=colorfila %>"><%=bean.getMontoSeguimiento2() %></td>
	    <td align="right" class="<%=colorfila %>"><%=bean.getTotalNroGestor() %></td>
	    <td align="right" class="<%=colorfila %>"><%=bean.getTotalNroConc() %></td>
	    <td align="right" class="<%=colorfila %>"><%=bean.getTotalMonto() %></td>    
	  </tr>
		<% 
		}
		bean = (CampaniasGeneral)lista.elementAt(lista.size() - 1);   
		colorfila = "colorfila1";
		%>
		<tr height="20">
		<td align="center" width="80"  class="<%=colorfila %>">&nbsp;</td>
	    <td class="<%=colorfila %>"><a><%=bean.getNombreCampania() %></a></td>
	    <td align="center" class="<%=colorfila %>"><%=bean.getNroClientes() %></td>
	    <td align="center" class="<%=colorfila %>"><%=bean.getCompromisoGestor() %></td>
	    <td align="right" class="<%=colorfila %>"><%=bean.getNroGestorSeguimiento1() %></td>
	    <td align="right" class="<%=colorfila %>"><%=bean.getNroConcSeguimiento1() %></td>
	    <td align="right" class="<%=colorfila %>"><%=bean.getMontoSeguimiento1() %></td>
	    <td align="right" class="<%=colorfila %>"><%=bean.getNroGestorSeguimiento2() %></td>
	    <td align="right" class="<%=colorfila %>"><%=bean.getNroConcSeguimiento2() %></td>
	    <td align="right" class="<%=colorfila %>"><%=bean.getMontoSeguimiento2() %></td>
	    <td align="right" class="<%=colorfila %>"><%=bean.getTotalNroGestor() %></td>
	    <td align="right" class="<%=colorfila %>"><%=bean.getTotalNroConc() %></td>
	    <td align="right" class="<%=colorfila %>"><%=bean.getTotalMonto() %></td>    
	  </tr>	
		<% 
}%>
  <tr height="20">

  </tr>
</table>
</CENTER>
<%} %>
<!-- **** FIN RESTO DE CÓDIGO DE LA PÁGINA-->


		</td>
	</tr>
</table>
</td>
</tr>
</table>
</form>
</BODY>
</html:html>
