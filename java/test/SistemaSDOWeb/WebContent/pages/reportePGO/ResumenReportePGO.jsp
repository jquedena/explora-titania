
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@page import="java.util.Vector"%>
<%@page import="com.grupobbva.bc.per.tele.sdo.serializable.Gestor"%>
<%@page import="com.grupobbva.bc.per.tele.sdo.serializable.ReportePPG"%>
<%@page import="com.grupobbva.bc.per.tele.sdo.serializable.Multitabla"%>
<%@page import="com.grupobbva.bc.per.tele.sdo.serializable.ListabusAllTerritorio"%>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META HTTP-EQUIV='PRAGMA' CONTENT='NO-CACHE'>
<META HTTP-EQUIV='EXPIRES' CONTENT='0'>
<META http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
<TITLE></TITLE>
<%
Vector a = (Vector)request.getAttribute("listaAnhos");
Vector d = (Vector)request.getAttribute("listaReportePGOResumen");
String codAnhoReturn=(String)request.getAttribute("codAnhoReturn");
String codMesReturn=(String)request.getAttribute("codMesReturn");
String codTerritorioReturn=(String)request.getAttribute("codTerritorioReturn");
String nomTerritorio=(String)request.getAttribute("nomTerritorio");
Vector listaTerritorio = (Vector)request.getAttribute("listaTerritorio");
ListabusAllTerritorio dtoTerritorio = null;

Gestor bean = null;
ReportePPG bean1=null;
Multitabla newAnio=null;
int i=0;

 %>
<script language="javascript">

function cargar(){
	var codAnho = document.forms.anho.value;
	var codMes = document.forms.mes.value;
	

	document.forms.codAnho.value = codAnho;
	document.forms.codMes.value = codMes;
	
	var codTerritorio;
	if(document.forms.cmbTerritorio != null) {
		codTerritorio = document.forms.cmbTerritorio.value;
		document.forms.cmbTerritorio.value = codTerritorio;
	}

	document.forms.action="reportePGOAction.do?method=inicioReportePGOResumen";
	document.forms.submit();
}

function enviar(codOficina){

var codAnho=document.forms.anho.value;
var codMes=document.forms.mes.value;
var codOficina=codOficina;

document.forms.codAnho.value=codAnho;
document.forms.codMes.value=codMes;
document.forms.oficinaCompleto.value=codOficina;

document.forms.action="reportePGOAction.do?method=reportePGO";
document.forms.submit();
}
</script>

</HEAD>
<BODY>
<form  method="post" name="forms">
<input type="hidden" name="codAnho" >
<input type="hidden" name="codMes" >
<input type="hidden" name="oficinaCompleto" >

<table align="center" width="100%" height="%" cellspacing="0" cellpadding="0">
	<tr>
		<td width="100%" align="left"  valign="top">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td><img src="<%=request.getContextPath()%>/images/esq_izq.jpg"></td>	
					<td width="200" class="textocentradoblanco">PGO / RESUMEN</td>	
					<td><img src="<%=request.getContextPath()%>/images/esq_der.jpg"></td>	
				</tr>						
			</table>
		</td>	
	</tr>
	<tr>
		<td style="border: 2px solid #264971;padding:10px;" valign="top" height="%" align="center">


			<!-- **** INICIO RESTO DE CÓDIGO DE LA PÁGINA-->

	<CENTER>


	<TABLE>
		<TR>		
			<td>MES / A&Ntilde;O: </td>
			    <td>

<select name="mes" class="combo" onchange="cargar();">

				<OPTION value="01" <%if("01".equals(codMesReturn)){%>selected<%}%>>Enero</OPTION>
				<OPTION value="02" <%if("02".equals(codMesReturn)){%>selected<%}%>>Febrero</OPTION>
				<OPTION value="03" <%if("03".equals(codMesReturn)){%>selected<%}%>>Marzo</OPTION>
				<OPTION value="04" <%if("04".equals(codMesReturn)){%>selected<%}%>>Abril</OPTION>
				<OPTION value="05" <%if("05".equals(codMesReturn)){%>selected<%}%>>Mayo</OPTION>
				<OPTION value="06" <%if("06".equals(codMesReturn)){%>selected<%}%> >Junio</OPTION>
				<OPTION value="07" <%if("07".equals(codMesReturn)){%>selected<%}%>>Julio</OPTION>
				<OPTION value="08" <%if("08".equals(codMesReturn)){%>selected<%}%>>Agosto</OPTION>
				<OPTION value="09" <%if("09".equals(codMesReturn)){%>selected<%}%>>Setiembre</OPTION>
				<OPTION value="10" <%if("10".equals(codMesReturn)){%>selected<%}%>>Octubre</OPTION>
				<OPTION value="11" <%if("11".equals(codMesReturn)){%>selected<%}%>>Noviembre</OPTION>
				<OPTION value="12" <%if("12".equals(codMesReturn)){%>selected<%}%>>Diciembre</OPTION>
			</select>

			<select name="anho" class="combo" onchange="cargar();">

<% 	
			if(a!=null)
			{	String colorfila = "";
				for( i=0;i<a.size();i++){
				newAnio = (Multitabla)a.elementAt(i);    
				%>

				  <option value="<%=newAnio.getValor1() %>"  <%if(newAnio.getValor1().equals(codAnhoReturn)){%>selected<%}%>><%=newAnio.getValor1() %></option>

				<% 
			 } 
			}%>
			</select>

</td>
		</TR>

		<TR>
			<TD width="100" >TERRITORIO: </TD>
			<TD ALIGN="left">
			<%
				if(listaTerritorio != null) {
			%>
					<select name="cmbTerritorio" class="combo" onchange="cargar();">
					<%	
						for(int k = 0; k < listaTerritorio.size(); k++){					
							dtoTerritorio = (ListabusAllTerritorio)listaTerritorio.elementAt(k);   							
					%>
							<option value="<%=dtoTerritorio.getCodTerritorio()%>" <%if(dtoTerritorio.getCodTerritorio().equals(codTerritorioReturn)){%>selected<%}%> >
								<%=dtoTerritorio.getNomTerritorio()%>
							</option>
					<%
						}
					%>							
					</select>
			<%
				} else {
			%>
					<%=nomTerritorio %>
			<%
				}
			%>	
			</TD>
			
		</TR>
	</TABLE>
	</CENTER>
<br>
<%if (d==null){ %>NO EXISTEN DATOS
<%}else{ %>
<center>
<table class="DataGrid" cellspacing="0" cellpadding="0" border="0">

  <tr>
    <th align="center" width="80" class="celda1cabecera">CODIGO</th>
    <th align="center" width="80" class="celda1cabecera">OFICINA</th>
    <th align="center" width="80" class="celda1cabecera">TOTAL<BR>GESTORES</th>
    <th align="center" width="80" class="celda1cabecera">INGRESOS</th>
    <th align="center" width="80" class="celda1cabecera">PENDIENTES</th>
  </tr>
			<% 	
		if(d!=null)
		{	String colorfila = "";

		for(i=0;i<d.size()-1;i++){
			bean = (Gestor)d.elementAt(i);    
			if (i%2 != 0)
				colorfila = "colorfila1";
			else
				colorfila = "colorfila2";
			%>
  <tr height="20">
    <td><div align="center"><%=bean.getCodigoOficina() %></div></td>
    <td><a href="#" onclick="enviar('<%=bean.getCodigoOficina() %>');" class="enlace"><%=bean.getNombreOficina() %></a></td>
    <td><div align="center"><%=bean.getTotalGestores() %></div></td>
    <td><div align="center"><%=bean.getTotalIngresos() %></div></td>
    <td><div align="center"><%=bean.getTotalpendientes() %></div></td>
  </tr>
			<% 
		 } 
		bean=(Gestor)d.elementAt(i);
		}%>
  <tr>
    <th colspan="2">TOTAL GENERAL</th>
    <th><div align="center"><%=bean.getSumtotalGestores() %></div></th>
    <th align="right"><%=bean.getSumtotalIngresos() %></th>
    <th align="right"><%=bean.getSumtotalPendientes() %></th>
  </tr>
</table>
<table>
  <tr height="20">
    <td colspan="5" height="20" align="center"><input type="submit" name="imprimir" value="imprimir" onclick="window.print();"/></td>
  </tr>
</table>
</center>
<%} %>
<!-- **** FIN RESTO DE CÓDIGO DE LA PÁGINA-->


		</td>
	</tr>
</table>
</form>
</BODY>
</html:html>
