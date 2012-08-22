<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@ taglib prefix="fn" uri="/WEB-INF/fn.tld"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld" %>
<%@page import="com.grupobbva.bc.per.tele.sdo.serializable.PlanesAcciones"%>
<%@page import="com.grupobbva.bc.per.tele.sdo.serializable.CampaniasGeneral"%>
<%@page import="java.util.Vector"%>
<%@page import="java.math.BigDecimal"%>

<link rel="stylesheet"	href="<%=request.getContextPath()%>/css/style.css"	type="text/css">
<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<%=request.getContextPath()%>/pages/reportePPG/reportePPG.js"></script>
<TITLE>Reporte PPG</TITLE>
<script language="JavaScript">
<% String colorfila = "";
 %>
function doIt(){
	datosFijos();
	print();
	window.close();
}

function datosFijos(){
	var o1 = document.forms[0].mes;
	var o2 = document.forms[0].anho;
	document.getElementById("datoMesAnio").innerHTML= o1.options[o1.selectedIndex].text + " " + o2.options[o2.selectedIndex].text;
	
	o1 = document.forms[0].codOficina;
	document.getElementById("datoOficina").innerHTML= o1.options[o1.selectedIndex].text;

	o1 = document.forms[0].codGestor;
	document.getElementById("datoGestor").innerHTML= o1.options[o1.selectedIndex].text;
}
</script>
<style>
body { font-family:Arial, Verdana; font-size:10px; }
td { font-family:Arial, Verdana; font-size:10px; }
</style>


<%
Vector lista1 = (Vector)request.getAttribute("listaPlanesAcciones");
Vector lista2 = (Vector)request.getAttribute("listaCampanias");
String epigrafe = "";

BigDecimal total1;
BigDecimal total2;
BigDecimal total3;
BigDecimal total4;

BigDecimal subtotal01;	BigDecimal subtotal02;	BigDecimal subtotal03;
BigDecimal subtotal04;	BigDecimal subtotal05;	BigDecimal subtotal06;
BigDecimal subtotal07;	BigDecimal subtotal08;	BigDecimal subtotal09;
BigDecimal subtotal10;	BigDecimal subtotal11;	BigDecimal subtotal12;
int c_epigrafes = 0;
int i=0;

BigDecimal totalgral01;	BigDecimal totalgral02;	BigDecimal totalgral03;
BigDecimal totalgral04;	BigDecimal totalgral05;	BigDecimal totalgral06;
BigDecimal totalgral07;	BigDecimal totalgral08;	BigDecimal totalgral09;
BigDecimal totalgral10;	BigDecimal totalgral11;	BigDecimal totalgral12;


 %>



</HEAD>

<BODY onLoad="doIt();">
<h2>PLAN PERSONAL DE GESTION (P.P.G.)</h2>
<html:form action="/reportePPGAction" styleId="reportePPGForm">	
<TABLE border="1" cellspacing="0" cellpadding="2">
<tr>
	<TD class="celda1cabecera">PERFIL</TD>
	<TD class="colorfila1"><c:out value="${sessionScope.gestor.codigoPerfil}"/></TD>
</tr>
<tr>
	<TD class="celda1cabecera">MES/AÑO</TD>
	<TD class="colorfila1">
		<div id="datoMesAnio">
		<html:select property="mes" disabled="true">
			<html:option value="01">Enero</html:option>
			<html:option value="02">Febrero</html:option>
			<html:option value="03">Marzo</html:option>
			<html:option value="04">Abril</html:option>
			<html:option value="05">Mayo</html:option>
			<html:option value="06">Junio</html:option>
			<html:option value="07">Julio</html:option>
			<html:option value="08">Agosto</html:option>
			<html:option value="09">Setiembre</html:option>
			<html:option value="10">Octubre</html:option>
			<html:option value="11">Noviembre</html:option>
			<html:option value="12">Diciembre</html:option>
		</html:select>
		<html:select property="anho" disabled="true">
			<c:if test="${listaAnhos != null}">
				<c:forEach var="lista" items="${listaAnhos}">
					<html:option value="${lista.codelem}"><c:out value="${lista.valor1}" /></html:option>
				</c:forEach>
			</c:if>
		</html:select>
		</div>
	</TD>
</TR>
<TR>
	<TD class="celda1cabecera">OFICINA</TD> 
	<TD class="colorfila1">
		<div id="datoOficina">
		<html:select property="codOficina" disabled="true">
			<c:if test="${listaOficina != null}">
				<c:forEach var="lista" items="${listaOficina}">
					<html:option value="${lista.codOfic}"><c:out value="${lista.codNomOficina}" /></html:option>
				</c:forEach>
			</c:if>
		</html:select>
		</div>
	</TD>
</tr>
<tr>
	<TD class="celda1cabecera">GESTOR</TD>
	<TD class="colorfila1">
		<div id="datoGestor">
		<html:select property="codGestor" disabled="true">
			<c:if test="${listaGestores != null}">
				<c:forEach var="lista" items="${listaGestores}">
					<html:option value="${lista.codigoPerfil}"> - <c:out value="${lista.nombreGestor}" /></html:option>
				</c:forEach>
			</c:if>
		</html:select>
		</div>
	</TD>
</TR>
</TABLE>

<br><br>
<TABLE border="1" cellspacing="0" cellpadding="2">
<TR>
	<TD colspan=3 align="center" class="celda1cabecera">PRIORIDAD Y OBJETIVOS DE LA OFICINA</TD>
	<TD colspan=3 align="center" class="celda1cabecera">ACCIONES CONCRETAS</TD>
	<TD colspan=3 align="center" class="celda1cabecera">PRIMERA QUINCENA</TD>
	<TD colspan=3 align="center" class="celda1cabecera">SEGUNDA QUINCENA</TD>	
	<TD colspan=4 align="center" class="celda1cabecera">TOTAL</TD>
</TR>

<TR>
	<TD align="center" class="celda1cabecera"> PRIOR</TD>
	<TD align="center" class="celda1cabecera"> EPIGRAFE</TD>
	<TD align="center" class="celda1cabecera"> OBJ. FACT. MES</TD>
	<TD align="center" class="celda1cabecera"> DESCRIPCION</TD>
	<TD align="center" class="celda1cabecera"> NRO. CLI</TD>
	<TD align="center" class="celda1cabecera"> COMPR GT</TD>
	<TD align="center" class="celda1cabecera"> NRO.GEST</TD>
	<TD align="center" class="celda1cabecera"> NRO. CONCR</TD>
	<TD align="center" class="celda1cabecera"> MONTO</TD>
	<TD align="center" class="celda1cabecera"> NRO.GEST</TD>
	<TD align="center" class="celda1cabecera"> NRO. CONCR</TD>
	<TD align="center" class="celda1cabecera"> MONTO</TD>
	<TD align="center" class="celda1cabecera"> NRO.GEST</TD>
	<TD align="center" class="celda1cabecera"> NRO. CONCR</TD>
	<TD align="center" class="celda1cabecera"> MONTO</TD>	
	<TD align="center" class="celda1cabecera"> %CONS</TD>	
</TR>
	<% 
		subtotal01 = new BigDecimal(0);subtotal02 = new BigDecimal(0);subtotal03 = new BigDecimal(0);
		subtotal04 = new BigDecimal(0);subtotal05 = new BigDecimal(0);subtotal06 = new BigDecimal(0);
		subtotal07 = new BigDecimal(0);subtotal08 = new BigDecimal(0);subtotal09 = new BigDecimal(0);
		subtotal10 = new BigDecimal(0);subtotal11 = new BigDecimal(0);subtotal12 = new BigDecimal(0);
		totalgral01 = new BigDecimal(0);totalgral02 = new BigDecimal(0);totalgral03 = new BigDecimal(0);
		totalgral04 = new BigDecimal(0);totalgral05 = new BigDecimal(0);totalgral06 = new BigDecimal(0);
		totalgral07 = new BigDecimal(0);totalgral08 = new BigDecimal(0);totalgral09 = new BigDecimal(0);
		totalgral10 = new BigDecimal(0);totalgral11 = new BigDecimal(0);totalgral12 = new BigDecimal(0);
		c_epigrafes = 0;
		if(lista1!=null){
		for(i=0;i<lista1.size();i++) {
	PlanesAcciones bean = (PlanesAcciones)lista1.elementAt(i);
		if (i%2 != 0) colorfila = "colorfila1";
		else colorfila = "colorfila2";
			i++;
	if(i>0 && !bean.getNombreEpigrafe().equals(epigrafe)){
		%>
		<TR>
		<TD colspan="3">&nbsp;</TD>
		<TD align="center" class="celda1cabecera">Subtotal:</TD>
		<TD align="center" class="<%=colorfila %>"><%=subtotal01 %></TD><TD align="center"><%=subtotal02 %></TD><TD align="center"><%=subtotal03 %></TD>
		<TD align="center" class="<%=colorfila %>"><%=subtotal04 %></TD><TD align="center"><%=subtotal05 %></TD><TD align="center"><%=subtotal06 %></TD>
		<TD align="center" class="<%=colorfila %>"><%=subtotal07 %></TD><TD align="center"><%=subtotal08 %></TD><TD align="center"><%=subtotal09 %></TD>
		<TD align="center" class="<%=colorfila %>"><%=subtotal10 %></TD><TD align="center"><%=subtotal11 %></TD><TD align="center">
		<% if(c_epigrafes>0){ %>
			<%=subtotal12.divide(new BigDecimal(c_epigrafes),1) %>%
		<% } else { %>
			0%
		<% } %>
		</TD>
		</TR>
		<%
		subtotal01 = new BigDecimal(0);subtotal02 = new BigDecimal(0);subtotal03 = new BigDecimal(0);
		subtotal04 = new BigDecimal(0);subtotal05 = new BigDecimal(0);subtotal06 = new BigDecimal(0);
		subtotal07 = new BigDecimal(0);subtotal08 = new BigDecimal(0);subtotal09 = new BigDecimal(0);
		subtotal10 = new BigDecimal(0);subtotal11 = new BigDecimal(0);subtotal12 = new BigDecimal(0);
		c_epigrafes=0;
	}
	epigrafe=bean.getNombreEpigrafe();
	
	
	
	total1 = bean.getNroGestorSeguimiento1().add(bean.getNroGestorSeguimiento2());
	total2 = bean.getNroConcSeguimiento1().add(bean.getNroConcSeguimiento2());
	total3 = bean.getMontoSeguimiento1().add(bean.getMontoSeguimiento2());
	if(total3.doubleValue()>0)
		total4 = bean.getMetaMesSaldoPuntual().multiply(new BigDecimal(100)).divide(total3,1);
	else
		total4 = new BigDecimal("0");
	
	subtotal01 = subtotal01.add(bean.getNroClientes());
	subtotal02 = subtotal02.add(bean.getCompromisoGestor());
	subtotal03 = subtotal03.add(bean.getNroGestorSeguimiento1());
	subtotal04 = subtotal04.add(bean.getNroConcSeguimiento1());
	subtotal05 = subtotal05.add(bean.getMontoSeguimiento1());
	subtotal06 = subtotal06.add(bean.getNroGestorSeguimiento2());
	subtotal07 = subtotal07.add(bean.getNroConcSeguimiento2());
	subtotal08 = subtotal08.add(bean.getMontoSeguimiento2());
	subtotal09 = subtotal09.add(total1);
	subtotal10 = subtotal10.add(total2);
	subtotal11 = subtotal11.add(total3);
	subtotal12 = subtotal12.add(total4);
	
	totalgral01 = subtotal01.add(bean.getNroClientes());
	totalgral02 = subtotal02.add(bean.getCompromisoGestor());
	totalgral03 = subtotal03.add(bean.getNroGestorSeguimiento1());
	totalgral04 = subtotal04.add(bean.getNroConcSeguimiento1());
	totalgral05 = subtotal05.add(bean.getMontoSeguimiento1());
	totalgral06 = subtotal06.add(bean.getNroGestorSeguimiento2());
	totalgral07 = subtotal07.add(bean.getNroConcSeguimiento2());
	totalgral08 = subtotal08.add(bean.getMontoSeguimiento2());
	totalgral09 = subtotal09.add(total1);
	totalgral10 = subtotal10.add(total2);
	totalgral11 = subtotal11.add(total3);
	totalgral12 = subtotal12.add(total4);
	c_epigrafes++;
	
	%>
	<TR>
	<TD align="center" class="<%=colorfila %>"><%=bean.getPrioridad() %></TD>
	<TD align="center" class="<%=colorfila %>"><%=bean.getNombreEpigrafe() %></TD>
	<TD align="center" class="<%=colorfila %>"><%=bean.getMetaMesSaldoPuntual() %></TD>
	<TD align="center" class="<%=colorfila %>"><%=bean.getNombreAccion() %></TD>
	<TD align="center" class="<%=colorfila %>"><%=bean.getNroClientes() %></TD>
	<TD align="center" class="<%=colorfila %>"><%=bean.getCompromisoGestor() %></TD>
	<TD align="center" class="<%=colorfila %>"><%=bean.getNroGestorSeguimiento1() %></TD>
	<TD align="center" class="<%=colorfila %>"><%=bean.getNroConcSeguimiento1() %></TD>
	<TD align="center" class="<%=colorfila %>"><%=bean.getMontoSeguimiento1() %></TD>
	<TD align="center" class="<%=colorfila %>"><%=bean.getNroGestorSeguimiento2() %></TD>
	<TD align="center" class="<%=colorfila %>"><%=bean.getNroConcSeguimiento2() %></TD>
	<TD align="center" class="<%=colorfila %>"><%=bean.getMontoSeguimiento2() %></TD>
	<TD align="center" class="<%=colorfila %>"><%=total1 %></TD>
	<TD align="center" class="<%=colorfila %>"><%=total2 %></TD>
	<TD align="center" class="<%=colorfila %>"><%=total3 %></TD>	
	<TD align="center" class="<%=colorfila %>"><%=total4 %>%</TD>	
	</TR>
<%
	
	if(i+1==lista1.size()){
		%>
		
		<TR>
		<TD colspan="3">&nbsp;</TD>
		<TD align="center" class="celda1cabecera">Subtotal:</TD>
		<TD align="center" class="<%=colorfila %>"><%=subtotal01 %></TD><TD align="center"><%=subtotal02 %></TD><TD align="center"><%=subtotal03 %></TD>
		<TD align="center" class="<%=colorfila %>"><%=subtotal04 %></TD><TD align="center"><%=subtotal05 %></TD><TD align="center"><%=subtotal06 %></TD>
		<TD align="center" class="<%=colorfila %>"><%=subtotal07 %></TD><TD align="center"><%=subtotal08 %></TD><TD align="center"><%=subtotal09 %></TD>
		<TD align="center" class="<%=colorfila %>"><%=subtotal10 %></TD><TD align="center"><%=subtotal11 %></TD><TD align="center">
		<% if(c_epigrafes>0){ %>
			<%=subtotal12.divide(new BigDecimal(c_epigrafes),1) %>%
		<% } else { %>
			0%
		<% } %>
		</TD>
		</TR>
		
		<%
			}
		}
	}
 %>
<tr>
<TD colspan="3">&nbsp;</TD>
<TD align="center" class="celda1cabecera">TOTAL GENERAL</TD>
<TD align="center" class="<%=colorfila %>"><%=totalgral01 %></TD><TD align="center"><%=totalgral02 %></TD><TD align="center"><%=totalgral03 %></TD>
<TD align="center" class="<%=colorfila %>"><%=totalgral04 %></TD><TD align="center"><%=totalgral05 %></TD><TD align="center"><%=totalgral06 %></TD>
<TD align="center" class="<%=colorfila %>"><%=totalgral07 %></TD><TD align="center"><%=totalgral08 %></TD><TD align="center"><%=totalgral09 %></TD>
<TD align="center" class="<%=colorfila %>"><%=totalgral10 %></TD><TD align="center"><%=totalgral11 %></TD><TD align="center">
<% if((i-1)>0){ %>
	<%=totalgral12.divide(new BigDecimal(i-1),1) %>%</TD>
<% } else { %>
	0%
<% } %>
</tr>
</table>

<br><br>
<TABLE border="1" cellspacing="0" cellpadding="2">
<TR>
	<TD colspan=3 align="center" class="celda1cabecera">PRIORIDAD Y OBJETIVOS DE LA OFICINA</TD>
	<TD colspan=3 align="center" class="celda1cabecera">ACCIONES CONCRETAS</TD>
	<TD colspan=3 align="center" class="celda1cabecera">PRIMERA QUINCENA</TD>
	<TD colspan=3 align="center" class="celda1cabecera">SEGUNDA QUINCENA</TD>	
	<TD colspan=4 align="center" class="celda1cabecera">TOTAL</TD>
</TR>

<TR>
	<TD align="center" class="celda1cabecera"> PRIOR</TD>
	<TD align="center" class="celda1cabecera"> EPIGRAFE</TD>
	<TD align="center" class="celda1cabecera"> OBJ. FACT. MES</TD>
	<TD align="center" class="celda1cabecera"> DESCRIPCION</TD>
	<TD align="center" class="celda1cabecera"> NRO. CLI</TD>
	<TD align="center" class="celda1cabecera"> COMPR GT</TD>
	<TD align="center" class="celda1cabecera"> NRO.GEST</TD>
	<TD align="center" class="celda1cabecera"> NRO. CONCR</TD>
	<TD align="center" class="celda1cabecera"> MONTO</TD>
	<TD align="center" class="celda1cabecera"> NRO.GEST</TD>
	<TD align="center" class="celda1cabecera"> NRO. CONCR</TD>
	<TD align="center" class="celda1cabecera"> MONTO</TD>
	<TD align="center" class="celda1cabecera"> NRO.GEST</TD>
	<TD align="center" class="celda1cabecera"> NRO. CONCR</TD>
	<TD align="center" class="celda1cabecera"> MONTO</TD>	
	<TD align="center" class="celda1cabecera"> %CONS</TD>	
</TR>
	<% 
		subtotal01 = new BigDecimal(0);subtotal02 = new BigDecimal(0);subtotal03 = new BigDecimal(0);
		subtotal04 = new BigDecimal(0);subtotal05 = new BigDecimal(0);subtotal06 = new BigDecimal(0);
		subtotal07 = new BigDecimal(0);subtotal08 = new BigDecimal(0);subtotal09 = new BigDecimal(0);
		subtotal10 = new BigDecimal(0);subtotal11 = new BigDecimal(0);subtotal12 = new BigDecimal(0);
		totalgral01 = new BigDecimal(0);totalgral02 = new BigDecimal(0);totalgral03 = new BigDecimal(0);
		totalgral04 = new BigDecimal(0);totalgral05 = new BigDecimal(0);totalgral06 = new BigDecimal(0);
		totalgral07 = new BigDecimal(0);totalgral08 = new BigDecimal(0);totalgral09 = new BigDecimal(0);
		totalgral10 = new BigDecimal(0);totalgral11 = new BigDecimal(0);totalgral12 = new BigDecimal(0);
		c_epigrafes = 0;
		if(lista1!=null){ 
		for(i=0;i<lista2.size();i++) {
	CampaniasGeneral bean2 = (CampaniasGeneral)lista2.elementAt(i);
	
	if(i>0 && !bean2.getNombreCampania().equals(epigrafe)){
		%>
		<TR>
		<TD colspan="3">&nbsp;</TD>
		<TD align="center">Subtotal:</TD>
		<TD align="center"><%=subtotal01 %></TD><TD align="center"><%=subtotal02 %></TD><TD align="center"><%=subtotal03 %></TD>
		<TD align="center"><%=subtotal04 %></TD><TD align="center"><%=subtotal05 %></TD><TD align="center"><%=subtotal06 %></TD>
		<TD align="center"><%=subtotal07 %></TD><TD align="center"><%=subtotal08 %></TD><TD align="center"><%=subtotal09 %></TD>
		<TD align="center"><%=subtotal10 %></TD><TD align="center"><%=subtotal11 %></TD><TD align="center">
		<% if(c_epigrafes>0){ %>
			<%=subtotal12.divide(new BigDecimal(c_epigrafes),1) %>%</TD>
		<% } else { %>
			0%
		<% } %>
		</TR>
		<%
		subtotal01 = new BigDecimal(0);subtotal02 = new BigDecimal(0);subtotal03 = new BigDecimal(0);
		subtotal04 = new BigDecimal(0);subtotal05 = new BigDecimal(0);subtotal06 = new BigDecimal(0);
		subtotal07 = new BigDecimal(0);subtotal08 = new BigDecimal(0);subtotal09 = new BigDecimal(0);
		subtotal10 = new BigDecimal(0);subtotal11 = new BigDecimal(0);subtotal12 = new BigDecimal(0);
		c_epigrafes=0;
	}
	epigrafe=bean2.getNombreCampania();
	
	
	
	total1 = bean2.getNroGestorSeguimiento1().add(bean2.getNroGestorSeguimiento2());
	total2 = bean2.getNroConcSeguimiento1().add(bean2.getNroConcSeguimiento2());
	total3 = bean2.getMontoSeguimiento1().add(bean2.getMontoSeguimiento2());
	if(total3.doubleValue()>0)
		total4 = bean2.getCompromisoGestor().multiply(new BigDecimal(100)).divide(total3,1);
	else
		total4 = new BigDecimal("0");
	
	subtotal01 = subtotal01.add(bean2.getNroClientes());
	subtotal02 = subtotal02.add(bean2.getCompromisoGestor());
	subtotal03 = subtotal03.add(bean2.getNroGestorSeguimiento1());
	subtotal04 = subtotal04.add(bean2.getNroConcSeguimiento1());
	subtotal05 = subtotal05.add(bean2.getMontoSeguimiento1());
	subtotal06 = subtotal06.add(bean2.getNroGestorSeguimiento2());
	subtotal07 = subtotal07.add(bean2.getNroConcSeguimiento2());
	subtotal08 = subtotal08.add(bean2.getMontoSeguimiento2());
	subtotal09 = subtotal09.add(total1);
	subtotal10 = subtotal10.add(total2);
	subtotal11 = subtotal11.add(total3);
	subtotal12 = subtotal12.add(total4);
	
	totalgral01 = subtotal01.add(bean2.getNroClientes());
	totalgral02 = subtotal02.add(bean2.getCompromisoGestor());
	totalgral03 = subtotal03.add(bean2.getNroGestorSeguimiento1());
	totalgral04 = subtotal04.add(bean2.getNroConcSeguimiento1());
	totalgral05 = subtotal05.add(bean2.getMontoSeguimiento1());
	totalgral06 = subtotal06.add(bean2.getNroGestorSeguimiento2());
	totalgral07 = subtotal07.add(bean2.getNroConcSeguimiento2());
	totalgral08 = subtotal08.add(bean2.getMontoSeguimiento2());
	totalgral09 = subtotal09.add(total1);
	totalgral10 = subtotal10.add(total2);
	totalgral11 = subtotal11.add(total3);
	totalgral12 = subtotal12.add(total4);
	c_epigrafes++;
	
	%>
	<TR>
	<TD align="center" class="<%=colorfila %>"><%=bean2.getOrden() %></TD>
	<TD align="center" class="<%=colorfila %>"><%=bean2.getNombreCampania() %></TD>
	<TD align="center" class="<%=colorfila %>"><%=bean2.getCompromisoGestor() %></TD>
	<TD align="center" class="<%=colorfila %>"><%=bean2.getNombreCampaniaDetalle() %></TD>
	<TD align="center" class="<%=colorfila %>"><%=bean2.getNroClientes() %></TD>
	<TD align="center" class="<%=colorfila %>"><%=bean2.getCompromisoGestor() %></TD>
	<TD align="center" class="<%=colorfila %>"><%=bean2.getNroGestorSeguimiento1() %></TD>
	<TD align="center" class="<%=colorfila %>"><%=bean2.getNroConcSeguimiento1() %></TD>
	<TD align="center" class="<%=colorfila %>"><%=bean2.getMontoSeguimiento1() %></TD>
	<TD align="center" class="<%=colorfila %>"><%=bean2.getNroGestorSeguimiento2() %></TD>
	<TD align="center" class="<%=colorfila %>"><%=bean2.getNroConcSeguimiento2() %></TD>
	<TD align="center" class="<%=colorfila %>"><%=bean2.getMontoSeguimiento2() %></TD>
	<TD align="center" class="<%=colorfila %>"><%=total1 %></TD>
	<TD align="center" class="<%=colorfila %>"><%=total2 %></TD>
	<TD align="center" class="<%=colorfila %>"><%=total3 %></TD>	
	<TD align="center" class="<%=colorfila %>"><%=total4 %>%</TD>	
	</TR>
<%
	
	if(i+1==lista1.size()){
		%>
		
		<TR>
		<TD colspan="3">&nbsp;</TD>
		<TD align="center">Subtotal:</TD>
		<TD align="center"><%=subtotal01 %></TD><TD align="center"><%=subtotal02 %></TD><TD align="center"><%=subtotal03 %></TD>
		<TD align="center"><%=subtotal04 %></TD><TD align="center"><%=subtotal05 %></TD><TD align="center"><%=subtotal06 %></TD>
		<TD align="center"><%=subtotal07 %></TD><TD align="center"><%=subtotal08 %></TD><TD align="center"><%=subtotal09 %></TD>
		<TD align="center"><%=subtotal10 %></TD><TD align="center"><%=subtotal11 %></TD><TD align="center">
		<% if(c_epigrafes>0){ %>
			<%=subtotal12.divide(new BigDecimal(c_epigrafes),1) %>%
		<% } else { %>
			0%
		<% } %>
		</TD>
		</TR>
		
		<%
			}
		}
	}
 %>
 <tr>
<TD colspan="3">&nbsp;</TD>
<TD align="center">TOTAL GENERAL</TD>
<TD align="center"><%=totalgral01 %></TD><TD align="center"><%=totalgral02 %></TD><TD align="center"><%=totalgral03 %></TD>
<TD align="center"><%=totalgral04 %></TD><TD align="center"><%=totalgral05 %></TD><TD align="center"><%=totalgral06 %></TD>
<TD align="center"><%=totalgral07 %></TD><TD align="center"><%=totalgral08 %></TD><TD align="center"><%=totalgral09 %></TD>
<TD align="center"><%=totalgral10 %></TD><TD align="center"><%=totalgral11 %></TD><TD align="center">
<% if(i-1>0){ %>
	<%=totalgral12.divide(new BigDecimal(i-1),1) %>%
<% } else { %>
	0%
<% } %>
</TD>
</tr>
</table>
</html:form>
</BODY>
</html:html>