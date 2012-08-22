<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@ taglib prefix="fn" uri="/WEB-INF/fn.tld"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="java.util.*"%>
<%@page import="java.lang.*"%>
<%@page import="com.grupobbva.bc.per.tele.sdo.serializable.ListaReportePGO"%>
<%@page import="com.grupobbva.bc.per.tele.sdo.serializable.ReportePPG"%>
<%@page import="com.grupobbva.bc.per.tele.sdo.serializable.Oficina"%>
<%@page import="com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil"%>
<%@page import="org.apache.commons.lang.*"%>
<%@page import="org.apache.commons.lang.builder.ReflectionToStringBuilder"%>

<fmt:setLocale value="en_US"/>

<html:html>
<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1">
<meta http-equiv='pragma' content='no-cache'>
<meta http-equiv='expires' content='0'>
<meta name="generator" content="ibm software development platform">
<meta http-equiv="content-style-type" content="text/css">
<link rel="stylesheet"	href="<%=request.getContextPath()%>/css/style.css"	type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.2.6.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/js-preparaJSONExcel.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/pages/reportePPG/reportePPG.js"></script>
<script type="text/javascript">
$(function(){
	$("input[name=exporta]").click(function(){
		prepareJSONTable();
		$('form[name=fExportarExel]').submit();
	});
	
	$("._Total").each(function(){
		_name = $(this).attr('name');
		_val = $(this).val();
		
		if(_name.indexOf('C_')>-1){
			textVerde='#D6FED9';
			textRojo='#FFB1B1';
			textAmbar='#FEFECC';
			
			if(_val=='textVerde') {backgroundColor = textVerde;}
			if(_val=='textRojo') {backgroundColor = textRojo;}
			if(_val=='textAmbar') {backgroundColor = textAmbar;}
			
			$("."+_name).css({'backgroundColor': backgroundColor});
			$("."+_name.replace('C_', 'T_')).css({'backgroundColor': backgroundColor});
			$("."+_name.replace('C_', 'D_')).css({'backgroundColor': backgroundColor});
			
		} else {
			$("."+_name).html(_val);
		}
		
		$(_name).val("");
	});
});

function cargar(){
	var codAnho=document.forms.anho.value;
	var codMes=document.forms.mes.value;
	var oficinaCompleto=document.forms.oficina.value;

	document.forms.codAnho.value=codAnho;
	document.forms.codMes.value=codMes;
	document.forms.oficinaCompleto.value=oficinaCompleto;

	document.forms.action="reportePGOAction.do?method=reportePGO";
	document.forms.submit();
}
</script>
<title></title>
<%
Vector b = (Vector) request.getAttribute("listaOficina");
Vector newListaOficina = (Vector)request.getAttribute("newListaOficina");
// Vector c = (Vector) request.getAttribute("listaReportePGO");
// Vector listaEsfuerzo = (Vector)request.getAttribute("listaReportePGOEsfuerzo");

String nomGestor = (String) request.getAttribute("codGestor");
String perfil = (String) request.getAttribute("perfil");
String nomTerritorio = (String) request.getAttribute("nomTerritorio");
String codAnhoReturn = (String) request.getAttribute("codAnhoReturn");
String codMesReturn = (String) request.getAttribute("codMesReturn");
String codOficinaReturn = (String) request.getAttribute("codOficinaReturn");
int i = 0;
int j = 0;

ListaReportePGO bean = null;
ReportePPG bean1 = null;
Oficina oficinaBean = null;
%>
</head>
<body>
<form  method="post" name="forms">
<input type="hidden" name="codAnho">
<input type="hidden" name="codMes">
<input type="hidden" name="oficinaCompleto">
<table align="center" width="100%" cellspacing="0" cellpadding="0">
<tr>
	<td width="100%" align="left"  valign="top">
		<table cellspacing="0" cellpadding="0">
			<tr>
				<td class="bls">&nbsp;</td>
				<td width="200" class="textocentradoblanco">PGO / REPORTE</td>
				<td class="brs">&nbsp;</td>
			</tr>						
		</table>
	</td>	
</tr>
<tr>
	<td style="border: 2px solid #264971;padding:10px;" valign="top" align="center">
	<table cellspacing="0" cellpadding="2" align="center">
	<tr>
		<td>MES / A&Ntilde;O: </td>
		<td>
			<select name="mes" class="combo" onchange="cargar();">
				<option value="01" <%if("01".equals(codMesReturn)){%>selected<%}%>>Enero</option>
				<option value="02" <%if("02".equals(codMesReturn)){%>selected<%}%>>Febrero</option>
				<option value="03" <%if("03".equals(codMesReturn)){%>selected<%}%>>Marzo</option>
				<option value="04" <%if("04".equals(codMesReturn)){%>selected<%}%>>Abril</option>
				<option value="05" <%if("05".equals(codMesReturn)){%>selected<%}%>>Mayo</option>
				<option value="06" <%if("06".equals(codMesReturn)){%>selected<%}%> >Junio</option>
				<option value="07" <%if("07".equals(codMesReturn)){%>selected<%}%>>Julio</option>
				<option value="08" <%if("08".equals(codMesReturn)){%>selected<%}%>>Agosto</option>
				<option value="09" <%if("09".equals(codMesReturn)){%>selected<%}%>>Setiembre</option>
				<option value="10" <%if("10".equals(codMesReturn)){%>selected<%}%>>Octubre</option>
				<option value="11" <%if("11".equals(codMesReturn)){%>selected<%}%>>Noviembre</option>
				<option value="12" <%if("12".equals(codMesReturn)){%>selected<%}%>>Diciembre</option>
			</select>
			<!--  <select name="anho" class="combo" onchange="cargar();">|
			</select>-->
			<c:if test="${requestScope.listaAnhos != null}">
				<select class="combo" 
					onchange="cargar();"
					name="anho">
					<c:forEach items="${requestScope.listaAnhos}" var="anio">
						<option value="${anio.codelem}" <c:if test="${anio.codelem==requestScope.codAnhoReturn}">selected</c:if>> ${anio.valor1}</option>
					</c:forEach>
				</select>
			</c:if>
		</td>
		<td width="15"></td>
		<td>PERFIL: </td>
		<td><%=perfil %></td>
	</tr>
	<tr>
		<td>OFICINA: </td>
		<td>
			<% if (newListaOficina==null){ %>
			<select name="oficina" class="combo"">
				<option value="NO EXISTEN OFICINAS">NO EXISTEN OFICINAS</option>
			</select>
			<% } else{ %>
			<select name="oficina" class="combo" onchange="cargar();">
			<% if(newListaOficina!=null){
				for(i=0; i<newListaOficina.size(); i++){
					oficinaBean = (Oficina)newListaOficina.elementAt(i);    
			%>
				<option value="<%=oficinaBean.getCodOfic()%>" <%if(oficinaBean.getCodOfic().equals(codOficinaReturn)){%>selected<%}%> ><%=oficinaBean.getCodNomOficina()%></option>
			<% 	}
			} %>
			</select>
			<% } %>
		</td>
		<td></td>
		<td>GESTOR: </td>
		<td><%=nomGestor %></td>
	</tr>
	<tr>
		<td>TERRITORIO: </td>
		<td><%=nomTerritorio %></td>
		<td></td>
		<td><input type="button" name="exporta" value="Excel"></td>
	</tr>
	</table>
	</td>
</tr>
</table>
</form>
<div style="padding-top:6px;">
<table class="DataGrid" cellpadding="0" cellspacing="0" style="width:1300px;">
<tr class="Header">
	<th colspan=5 class="ReportePPG">PRIORIDAD Y OBJETIVOS DE LA OFICINA</th>
	<th colspan=4>ACCIONES CONCRETAS</th>
	<th colspan=4>SEGUIMIENTO**<br/> (Primera y Segunda Quincena)</th>
</tr>
<tr class="Header">
	<th class="ReportePPG" style="width:50px;font-size:75%;">PRIOR</th>
	<th class="ReportePPG" style="font-size:75%;">EPIGRAFE</th>
	<th class="ReportePPG" style="width:64px;font-size:75%;">OBJ. MES</th>
	<th class="ReportePPG" style="width:64px;font-size:75%;">M_I_S</th>
	<th class="ReportePPG" style="width:64px;font-size:75%;">DESV. %</th>
	<th style="font-size:75%;">PERFIL - GESTOR</th>
	<th style="font-size:75%;">ACCIONES</th>
	<th style="width:64px;font-size:75%;">NRO.CLI.</th>
	<th style="width:64px;font-size:75%;">COMPR. GES.</th>
	<th style="width:64px;font-size:75%;">NRO.GEST</th>
	<th style="width:64px;font-size:75%;">NRO. CONCR.</th>
	<th style="width:64px;font-size:75%;">MONTO NRO.</th>
	<th style="width:64px;font-size:75%;">DESV.</th>
</tr>
<c:if test="${requestScope.listaSeguimiento != null}">
	<c:set var="temp" value="SEG"/>
	<c:set var="subtotal" value="SUBTOTAL"/>
	<c:set var="total" value="TOTAL"/>
	<c:set var="orden" value="1"/>
	<c:set var="suborden" value="2"/>
	<c:set var="epigrafe" value="${requestScope.codEpigrafe}"/>
	<c:set var="tipo1" value="SEG"/>
	<c:set var="tipo2" value="ESF"/>
	<c:forEach items="${requestScope.listaSeguimiento}" var ="seguimiento" >
	
	<c:set var="style" value=""/>
	<c:set var="colspan" value="1"/>
	<c:if test="${seguimiento.nomAcci==total}">
		<c:set var="style" value="Subtotal"/>
		<c:set var="colspan" value="7"/>
	</c:if>
	<c:if test="${seguimiento.nomAcci==subtotal}">
		<c:set var="style" value="Subtotal"/>
		<c:set var="colspan" value="2"/>
	</c:if>
	
	<c:if test="${epigrafe!=seguimiento.codEpigrafe}">
		<c:set var="epigrafe" value="${seguimiento.codEpigrafe}"/>
		<c:if test="${temp==seguimiento.tipo}">
			<tr class="Row" style="height:10px;"><td align="center" colspan="13" style="border-right: 1px solid #fff;font-size:10%;">&nbsp;</td></tr>
		</c:if>
	</c:if>
	
	<c:if test="${temp!=seguimiento.tipo}">
		<c:set var="temp" value="${seguimiento.tipo}"/>
		<tr class="Row"><td align="center" colspan="13" style="border: 1px solid #fff;">&nbsp;</td></tr>
		<tr class="Row"><td align="center" colspan="13" style="border: 1px solid #fff;"><b>ESFUERZOS ADICIONALES</b></td></tr>
		<tr class="Row"><td align="center" colspan="13" style="border-right: 1px solid #fff;"><b>(En miles de Soles)</b></td></tr>
		<tr class="Row">
			<th class="ReportePPG" style="width:50px;font-size:75%;">PRIOR</th>
			<th class="ReportePPG" style="font-size:75%;">EPIGRAFE</th>
			<th class="ReportePPG" style="width:64px;font-size:75%;">OBJ. MES</th>
			<th class="ReportePPG" style="width:64px;font-size:75%;">M_I_S</th>
			<th class="ReportePPG" style="width:64px;font-size:75%;">DESV. %</th>
			<th style="font-size:75%;">PERFIL - GESTOR</th>
			<th style="font-size:75%;">ACCIONES</th>
			<th style="width:64px;font-size:75%;">NRO.CLI.</th>
			<th style="width:64px;font-size:75%;">COMPR. GES.</th>
			<th style="width:64px;font-size:75%;">NRO.GEST</th>
			<th style="width:64px;font-size:75%;">NRO. CONCR.</th>
			<th style="width:64px;font-size:75%;">MONTO NRO.</th>
			<th style="width:64px;font-size:75%;">DESV.</th>
		</tr>
	</c:if>
	
	<tr class='Row <c:out value="${style}"/>'>
		
		<c:if test="${seguimiento.nomAcci!=subtotal && seguimiento.nomAcci!=total}">
			<c:if test="${seguimiento.orden==orden}">
				<td class="Title" align="right"><c:out value='${seguimiento.prioridad}'/>&nbsp;</td>
				<td class="Title" style="font-size:80%;"><c:out value='${seguimiento.nomEpigrafe}'/></td>
				<td class="Title C_<c:out value="${seguimiento.codEpigrafe}"/><c:out value="${seguimiento.tipo}"/>" pattern="#,###.00" type="NUMBER" align="right"><fmt:formatNumber value='${seguimiento.metGerOfi}' maxFractionDigits="0" minFractionDigits="0"/></td>
				<td class="Title T_<c:out value="${seguimiento.codEpigrafe}"/><c:out value="${seguimiento.tipo}"/>" pattern="#,###.00" type="NUMBER" align="right"><fmt:formatNumber value='${seguimiento.totalMIS}' maxFractionDigits="0" minFractionDigits="0"/><c:if test="${seguimiento.totalMIS==null}">&nbsp;</c:if></td>
				<td class="Title D_<c:out value="${seguimiento.codEpigrafe}"/><c:out value="${seguimiento.tipo}"/>" pattern="#,###.00" type="NUMBER" align="right"><fmt:formatNumber value="${seguimiento.desviacionMIS}" maxFractionDigits="2" minFractionDigits="2"/>%</td>
			</c:if>
			<c:if test="${seguimiento.orden!=orden}">
				<td colspan='5' style="	border: 1px solid #fff; border-right: 1px solid #9dbee7;">&nbsp;</td>
			</c:if>
		</c:if>
		<c:if test="${seguimiento.nomAcci==subtotal}">
			<td colspan='5' style="	border: 1px solid #fff; border-right: 1px solid #9dbee7; border-bottom: 1px solid #9dbee7;background-color:#fff;">&nbsp;
			<!-- <c:out value='${seguimiento.metGerOfi}'/> -->
			<input type="hidden" value="" />
			<input class="_Total" name='C_<c:out value="${seguimiento.codEpigrafe}"/><c:out value="${seguimiento.tipo}"/>' type="hidden" value="<c:out value='${seguimiento.semaforoDesviacionMIS}'/>" />
			<input class="_Total" name='T_<c:out value="${seguimiento.codEpigrafe}"/><c:out value="${seguimiento.tipo}"/>' type="hidden" value="<c:out value='${seguimiento.totalMIS}'/><c:if test="${seguimiento.totalMIS==null}">0</c:if>" />
			<input class="_Total" name='D_<c:out value="${seguimiento.codEpigrafe}"/><c:out value="${seguimiento.tipo}"/>' type="hidden" value="<fmt:formatNumber value="${seguimiento.desviacionMIS}" maxFractionDigits="2" minFractionDigits="2"/>%
			" />
			</td>
		</c:if>
		<c:if test="${seguimiento.nomAcci!=subtotal && seguimiento.nomAcci!=total}">
			<td style="font-size:80%;" class="<c:out value='${seguimiento.codGest}'/>"><c:out value='${seguimiento.nomGest}'/></td>
		</c:if>
		<td colspan='<c:out value="${colspan}"/>' style="font-size:80%;">
			<c:if test="${seguimiento.nomAcci!=total}">
				<c:out value='${seguimiento.nomAcci}'/>
			</c:if>
			<c:if test="${seguimiento.tipo==tipo1 && seguimiento.nomAcci==total}">
				TOTAL DE ACCIONES DE LA OFICINA
			</c:if>
			<c:if test="${seguimiento.tipo==tipo2 && seguimiento.nomAcci==total}">
				TOTAL DE ESFUERZOS ADICIONALES DE LA OFICINA
			</c:if>
		</td>
		<td pattern="#,###.00" type="NUMBER" align="right"><c:out value='${seguimiento.nroClie}'/><c:if test="${seguimiento.nroClie==null}">&nbsp;</c:if></td>
		<td pattern="#,###.00" type="NUMBER" align="right"><fmt:formatNumber value='${seguimiento.compGest}' maxFractionDigits="0" minFractionDigits="0" pattern="#,###"/><c:if test="${seguimiento.compGest==null}">&nbsp;</c:if></td>
		<td pattern="#,###.00" type="NUMBER" align="right"><c:out value='${seguimiento.nroGestTotal}'/><c:if test="${seguimiento.nroGestTotal==null}">&nbsp;</c:if></td>
		<td pattern="#,###.00" type="NUMBER" align="right"><c:out value='${seguimiento.nroConcTotal}'/><c:if test="${seguimiento.nroConcTotal==null}">&nbsp;</c:if></td>
		<td pattern="#,###.00" type="NUMBER" align="right" class="<c:if test="${seguimiento.nomAcci==subtotal}"><c:out value='${seguimiento.semaforoPorcConsecucion}'/></c:if>">
			<c:if test="${seguimiento.nomAcci!=total}"><fmt:formatNumber value='${seguimiento.monTotal}' maxFractionDigits="0" minFractionDigits="0" pattern="#,###"/></c:if>
			<c:if test="${seguimiento.monTotal==null || seguimiento.nomAcci==total}">&nbsp;</c:if>
		</td>	
		<td pattern="#,###.00" type="NUMBER" align="right" class="<c:if test="${seguimiento.nomAcci==subtotal}"><c:out value='${seguimiento.semaforoPorcConsecucion}'/></c:if>">
			<c:if test="${seguimiento.nomAcci!=total}"><fmt:formatNumber value="${seguimiento.desviacion}" maxFractionDigits="0" minFractionDigits="0"/></c:if>
			<c:if test="${seguimiento.desviacion==null || seguimiento.nomAcci==total}">&nbsp;</c:if> 
		</td>
	</tr>
	</c:forEach>
	
	<tr class="Footer">
		<td colspan="13" style="border: 1px solid #fff;">&nbsp;</td>
	</tr>
	<tr class="Footer">
		<td align="right" style="border: 1px solid #fff;">*</td>
		<td colspan="12" style="border: 1px solid #fff;">El sem&aacute;foro ubicado en la secci&oacute;n "Datos de la Oficina" muestra el MIS con respecto al Objetivo del Mes por Ep&iacute;grafe.</td>
	</tr>
	<tr class="Footer">
		<td align="right" style="border: 1px solid #fff;">**</td>
		<td colspan="12" style="border: 1px solid #fff;">El sem&aacute;foro ubicado en la secci&oacute;n "Seguimiento" muestra el "Monto Total por Ep&iacute;grafe" con respecto a las Acciones Concretas del Gestor "COMPR. GESTOR"</td>
	</tr>
	<tr class="Footer">
		<td align="right" style="border: 1px solid #fff;">&nbsp;</td>
		<td colspan="12" style="border: 1px solid #fff;">La información de MIS corresponde a las altas de contratos efectuadas hasta el d&iacute;a anterior.</td>
	</tr>
</c:if>
</table>
</div>
<form method="post" name="fExportarExel" action="ExportGenericExcelServlet">
	<input type="hidden" id="header" name="header" />
	<input type="hidden" id="rows" name="rows" />
	<input type="hidden" id="footer" name="footer" />
	<input type="hidden" id="file" name="file" value="Reporte_PGO" />
	<input type="hidden" id="title" name="title" value="Reporte PGO" />
</form>
</body>
</html:html>