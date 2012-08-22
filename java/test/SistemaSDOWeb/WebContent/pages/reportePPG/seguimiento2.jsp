<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@page import="java.util.Vector"%>
<%@page import="com.grupobbva.bc.per.tele.sdo.serializable.Accion"%>
<%@page import="com.grupobbva.bc.per.tele.sdo.serializable.Gestor"%>
<%@page import="com.grupobbva.bc.per.tele.sdo.serializable.Oficina"%>
<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META HTTP-EQUIV='PRAGMA' CONTENT='NO-CACHE'>
<META HTTP-EQUIV='EXPIRES' CONTENT='0'>
<META http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css" type="text/css">
<style>
.ingreso1 { width:50px; text-align:right; }
.ingreso2 { width:70px; text-align:right; }
</style>
<TITLE></TITLE>
<%
	Vector a = (Vector) request.getAttribute("listaDatos");
	Vector b = (Vector) request.getAttribute("listaOficina");
	Vector newListaOficina = (Vector) request.getAttribute("newListaOficina");
	Vector c = (Vector) request.getAttribute("listaEsfuerzo");
	Vector d = (Vector) request.getAttribute("listaGestores");
	String nomGestor = (String) request.getAttribute("nomGestor");
	String perfil = (String) request.getAttribute("perfil");
	String nomTerritorio = (String) request.getAttribute("nomTerritorio");
	String codAnhoReturn = (String) request.getAttribute("codAnhoReturn");
	String codMesReturn = (String) request.getAttribute("codMesReturn");
	String codOficinaReturn = (String) request.getAttribute("codOficinaReturn");
	String codGestorReturn = (String) request.getAttribute("codGestorReturn");
	int j = 0;

	Gestor gestor = (Gestor) session.getAttribute("gestor");
	String perfilUsuario = ""; 
	if(gestor != null) {
		perfilUsuario = gestor.getCodigoPerfil();
	}
	boolean sw_perfil = !(!perfilUsuario.equalsIgnoreCase("adm") && !perfilUsuario.equalsIgnoreCase("sup")  && !perfilUsuario.equalsIgnoreCase("con"));
	Accion bean = null;
	Gestor bean1 = null;
	//ReportePPG bean1=null;
	Oficina oficinaBean = null;
%>
<script language="JavaScript" src="js/common.js"></script>
<script language="javascript">

function cargar(){

		var codAnho=document.forms.anho.value;
		var codMes=document.forms.mes.value;
		var oficinaCompleto=document.forms.oficina.value;
		var codGestor=document.forms.gestor.value;
	
		document.forms.codAnho.value=codAnho;
		document.forms.codMes.value=codMes;
		document.forms.oficinaCompleto.value=oficinaCompleto;
		document.forms.codigoGestor.value=codGestor;
		
		document.forms.action="seguimientoAction.do?method=reporteSeguimiento2";
		document.forms.submit();
}

function cargarNoCambioGestor(){

		var codAnho=document.forms.anho.value;
		var codMes=document.forms.mes.value;
		var oficinaCompleto=document.forms.oficina.value;
		var codGestor=document.forms.gestor.value;
	
		document.forms.codAnho.value=codAnho;
		document.forms.codMes.value=codMes;
		document.forms.oficinaCompleto.value=oficinaCompleto;
		document.forms.codigoGestor.value="";
		
		document.forms.action="seguimientoAction.do?method=reporteSeguimiento2";
		document.forms.submit();
}

function grabar(){
	if(valida()){
		var s = "";
		var t = "";
		var tbs = document.getElementsByTagName("input");
		
		for(i=0; i<tbs.length; i++){
			if(tbs[i].type == "text" && tbs[i].name.substring(0,3)=="txt"){
				if(tbs[i].value == "") {
					tbs[i].value == "0";
				}
				
				t = tbs[i].name + '_' + tbs[i].value;
				if(s.indexOf(t)==-1){
					if(s!="")
						t = '\n' + t;
					s = s + t;
				}
			}
	  	}
		
		document.forms.bloqueDatos.value = s;
		
		var codAnho=document.forms.anho.value;
		var codMes=document.forms.mes.value;
		var oficinaCompleto=document.forms.oficina.value;
		var codGestor=document.forms.gestor.value;
	
		document.forms.codAnho.value=codAnho;
		document.forms.codMes.value=codMes;
		document.forms.oficinaCompleto.value=oficinaCompleto;
		document.forms.codigoGestor.value=codGestor;
		
		document.forms.action="seguimientoAction.do?method=reporteSeguimiento2Grabar";
		var resp = confirm("\u00BFDesea guardar los cambios?");
    	if(resp) {
    		document.forms.submit();
    	}
	}
}

function valida(){
	var valid = 0;

	// Acciones
	var table = document.getElementById("accionesConcretadas");
	var rows = table.getElementsByTagName("TR");
	var it = 2;
	
	for(i = 2; i < (rows.length - 1); i++){
		cells = rows[i].getElementsByTagName("TD");
		cell3 = cells[3].innerHTML.replace("&nbsp;", "");
		
		if(i == it){
			cell1 = cells[1].innerHTML.replace("&nbsp;", "");
		}
		
		if(cell3.toLowerCase().indexOf("subtotal")==-1){
			monto=parseFloat(cells[8].getElementsByTagName("INPUT")[0].value);
			if(cell1.toUpperCase().indexOf('CARTERA ATRASADA')>=0) {
				if(monto>0) {
					alert('La cartera atrasada debe ser negativa');
					cells[8].getElementsByTagName("INPUT")[0].focus();
					valid = 1;
					break;
				}
			} else {
				if(monto<0) {
					alert('El monto no puede ser negativo');
					cells[8].getElementsByTagName("INPUT")[0].focus();
					valid = 1;
					break;
				}
			}
			
			gestionado=parseFloat(cells[6].getElementsByTagName("INPUT")[0].value);
			concretado=parseFloat(cells[7].getElementsByTagName("INPUT")[0].value);
			
			if(concretado > gestionado){
				alert("El nro. de concretados debe ser menor o igual al nro. de gestiones realizadas para el epigrafe "+cell1);
				cells[7].getElementsByTagName("INPUT")[0].focus();
				valid = 1;
				break;
			}
		}else{
			it=i+1;
		}
	}
	
	if(valid == 1){
		return false;
	}
	
	// esfuerzosConcretados
	table = document.getElementById("esfuerzosConcretados");
	rows = table.getElementsByTagName("TR");
	it = 2;
	
	for(i = 2; i < (rows.length - 1); i++){
		cells = rows[i].getElementsByTagName("TD");
		cell3 = cells[3].innerHTML.replace("&nbsp;", "");
		
		if(i == it){
			cell1 = cells[1].getElementsByTagName("DIV")[0].innerHTML.replace("&nbsp;", "");
			cell1_1 = cells[1].getElementsByTagName("INPUT")[0].value;
		}
		
		if(cell3.toLowerCase().indexOf("subtotal")==-1){
			monto=parseFloat(cells[8].getElementsByTagName("INPUT")[0].value);
			if(cell1_1.toUpperCase().indexOf('0001001')>=0) {
				if(monto>0) {
					alert('La cartera atrasada debe ser negativa');
					cells[8].getElementsByTagName("INPUT")[0].focus();
					valid = 1;
					break;
				}
			} else {
				if(monto<0) {
					alert('El monto no puede ser negativo');
					cells[8].getElementsByTagName("INPUT")[0].focus();
					valid = 1;
					break;
				}
			}
			
			gestionado=parseFloat(cells[6].getElementsByTagName("INPUT")[0].value);
			concretado=parseFloat(cells[7].getElementsByTagName("INPUT")[0].value);
			
			if(concretado > gestionado){
				alert("El nro. de concretados debe ser menor o igual al nro. de gestiones realizadas para el esfuerzo adicional "+cell1);
				cells[7].getElementsByTagName("INPUT")[0].focus();
				valid = 1;
				break;
			}
		}else{
			it=i+1;
		}
	}
	
	if(valid == 1){
		return false;
	}
	
	return true;
}

window.onload = function() {
	if($(".Text")!=undefined) {
		if($(".Text").length == 0) {
			$("#btnGrabar").css({'display': 'none'});
		}
	} else {
		var rows = document.getElementsByTagName("INPUT");
		// alert(rows.length);
		// alert(document.forms.btnGrabar);
		var sw = false;
		for(i = 0; i < rows.length; i++) {
			if(rows[i].className.toLowerCase().indexOf("text")>-1){
				var sw = true;
				break;
			}
			// alert(rows[i].className);
		}
		
		if(!sw) {
			if(document.forms.btnGrabar != undefined || document.forms.btnGrabar != null) {
				document.forms.btnGrabar.style.display='none';
			}
		}
	}
};

/*
if($(".Text").length == 0) {
	$("#btnGrabar").css({'display': 'none'});
}*/
</script>
</HEAD>

<BODY>
<form method="post" name="forms"><input type="hidden" name="codAnho"> <input
	type="hidden" name="codMes"> <input type="hidden"
	name="oficinaCompleto"> <input type="hidden" name="codigoGestor"> <input
	type="hidden" name="bloqueDatos">
<table align="center" width="100%" height="%" cellspacing="0"
	cellpadding="0">
	<tr>
		<td width="100%" align="left" valign="top">
		<table cellspacing="0" cellpadding="0">
			<tr>
				<td class="bls">&nbsp;</td>
				<td width="200" class="textocentradoblanco">PPG / CIERRE</td>
				<td class="brs">&nbsp;</td>
			</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td style="border: 2px solid #264971;padding:15px;" valign="top"
			height="%" align="center"><!-- **** INICIO RESTO DE CÓDIGO DE LA PÁGINA-->
		<table cellspacing="0" cellpadding="0" align="center">
			<tr height="20">
				<td height="20">MES / A&Ntilde;O:</td>
				<td><select name="mes" class="combo"
					onchange="cargarNoCambioGestor();">

					<OPTION value="01" <%if("01".equals(codMesReturn)){%> selected
						<%}%>>Enero</OPTION>
					<OPTION value="02" <%if("02".equals(codMesReturn)){%> selected
						<%}%>>Febrero</OPTION>
					<OPTION value="03" <%if("03".equals(codMesReturn)){%> selected
						<%}%>>Marzo</OPTION>
					<OPTION value="04" <%if("04".equals(codMesReturn)){%> selected
						<%}%>>Abril</OPTION>
					<OPTION value="05" <%if("05".equals(codMesReturn)){%> selected
						<%}%>>Mayo</OPTION>
					<OPTION value="06" <%if("06".equals(codMesReturn)){%> selected
						<%}%>>Junio</OPTION>
					<OPTION value="07" <%if("07".equals(codMesReturn)){%> selected
						<%}%>>Julio</OPTION>
					<OPTION value="08" <%if("08".equals(codMesReturn)){%> selected
						<%}%>>Agosto</OPTION>
					<OPTION value="09" <%if("09".equals(codMesReturn)){%> selected
						<%}%>>Setiembre</OPTION>
					<OPTION value="10" <%if("10".equals(codMesReturn)){%> selected
						<%}%>>Octubre</OPTION>
					<OPTION value="11" <%if("11".equals(codMesReturn)){%> selected
						<%}%>>Noviembre</OPTION>
					<OPTION value="12" <%if("12".equals(codMesReturn)){%> selected
						<%}%>>Diciembre</OPTION>
				</select>
				<c:if test="${requestScope.listaAnio != null}">
					<html:select styleClass="combo" property="anho" value="${requestScope.anio}" onchange="cargarNoCambioGestor();">
					<c:forEach items="${requestScope.listaAnio}" var ="anio" >
						<html:option value="${anio.codelem}">${oficina.valor1}</html:option>
					</c:forEach>
					</html:select>
				</c:if></td>
				<td width="80"></td>
				<td>PERFIL:</td>
				<td align="center"><%=perfil%></td>
			</tr>
			<tr height="20">
				<td height="20">OFICINA:</td>
				<td><%if (newListaOficina == null) {

			%> <select
					name="oficina" class="combo"">
					<option value="NO EXISTEN OFICINAS">NO EXISTEN OFICINAS</option>
				</select> <%} else {

				%> <select name="oficina" class="combo"
					onchange="cargarNoCambioGestor();">
					<%if (newListaOficina != null) {
					String colorfila = "";
					for (int i = 0; i < newListaOficina.size(); i++) {
						oficinaBean = (Oficina) newListaOficina.elementAt(i);

						if (i % 2 != 0)
							colorfila = "colorfila1";
						else
							colorfila = "colorfila2";

						%>

					<option value="<%=oficinaBean.getCodOfic() %>"
						<%if(oficinaBean.getCodOfic().equals(codOficinaReturn)){%>
						selected <%}%>><%=oficinaBean.getCodNomOficina()%></option>

					<%}
				}%>

				</select> <%}

			%></td>
				<td></td>
				<td>GESTOR:</td>
				<td><%if (d != null) {

				%> <select name="gestor" class="combo" onchange="cargar();">
					<%if (d != null) {
					String colorfila = "";
					for (int i = 0; i < d.size(); i++) {
						bean1 = (Gestor) d.elementAt(i);

						%>
					<OPTION value="<%=bean1.getCodigoGestor()%>"
						<%if(bean1.getCodigoGestor().equals(codGestorReturn)){%> selected
						<%}%>><%=bean1.getNombreGestor()%></OPTION>
					<%}
				}%>
				</select> <%} else {

			%> <select name="gestor" class="combo" onchange="cargar();">
					<OPTION value="null">NO EXISTEN GESTORES</OPTION>
				</select> <%}

			%></td>
			</tr>
			<tr height="20">
				<td height="20">TERRITORIO:</td>
				<td><%=nomTerritorio%></td>
			</tr>
		</table>
		<br>
		<br>

		<table id="accionesConcretadas" cellspacing="0" cellpadding="0" align="center" class="DataGrid" width="1000px">
			<tr>
				<th colspan="3">PRIORIDAD Y OBJETIVOS DE LA OFICINA</th>
				<th colspan="3">ACCIONES CONCRETAS</th>
				<th colspan="3">TOTAL</th>
			</tr>
			<tr>
				<th style="width:40px;font-size:80%;">PRIOR</th>
				<th style="width:230px;font-size:80%;">EPIGRAFE</th>
				<th style="width:75px;font-size:80%;">OBJ. FACT. MES</th>
				<th>DESCRIPCION</th>
				<th style="width:75px;font-size:80%;">N&deg; DE CLIENTES</th>
				<th style="width:75px;font-size:80%;">COMPR GT</th>
				<th style="width:75px;font-size:80%;">N&deg; GESTIONES</th>
				<th style="width:75px;font-size:80%;">N&deg; CONCRETADOS</th>
				<th style="width:75px;font-size:80%;">MONTO</th>
			</tr>
			<%
			//String editable = (String) request.getAttribute("editable");
			//boolean soloLectura = editable.equals("0") ? true : false;

			if (a != null) {
				String colorfila = "";
				for (int i = 0; i < a.size(); i++) {
					bean = (Accion) a.elementAt(i);

					if (bean.getOrden() == null || bean.getOrden().equals("")) {
						colorfila = "colorfila2";
					} else {
						colorfila = "colorfila1";
					}
					%>
			<%if (i < a.size() - 1) {%>
			<tr>
				<td align="right"><%=bean.getOrden()%>&nbsp;</td>
				<td><%=bean.getNomEpigrafe()%>&nbsp;</td>
				<td align="right">&nbsp;<%=bean.getPorc_asig()%></td>
				<td><%=bean.getNomAccion()%>&nbsp;</td>
				<td align="right"><%=bean.getNumeroCliente()%>&nbsp;</td>
				<td align="right"><%=bean.getCompGestor()%>&nbsp;</td>
				<td align="right"><%if ((bean.getNomAccion() != null && bean.getNomAccion().equals("Subtotal")) || sw_perfil) {
							%>
				<%=bean.getNumeroGestiones2()%> <%} else {
							%> <%if (bean.getEstado()==0) {%>
				<%=bean.getNumeroGestiones2()%> <%} else {
								%> <input
					style="text-align: right; width:50px;" align="right" type="text"
					class="textBlanco Text" maxlength="5" 
					name="txtNumGestiones_1_<%=bean.getCodAccion() %>_<%=bean.getCodEpigrafe() %>"
					value="<%=bean.getNumeroGestiones2() %>"
					onKeyPress="ingresoEnteros(event);"> <%}
						%> <%}%></td>
				<td align="right"><%if ((bean.getNomAccion() != null && bean.getNomAccion().equals("Subtotal")) || sw_perfil) {
							%>
				<%=bean.getNumeroConcretados2()%> <%} else {
							%> <%if (bean.getEstado()==0) {%>
				<%=bean.getNumeroConcretados2()%> <%} else {
								%> <input
					style="text-align: right; width:50px;" type="text" class="textBlanco Text"
					maxlength="4"
					name="txtNumConcretados_1_<%=bean.getCodAccion() %>_<%=bean.getCodEpigrafe() %>"
					value="<%=bean.getNumeroConcretados2() %>"
					onkeypress="ingresoEnteros(event);"> <%}
						%> <%}%></td>
				<td align="right"><%if ((bean.getNomAccion() != null && bean.getNomAccion().equals("Subtotal")) || sw_perfil) {
							%>
				<%=bean.getMonto2()%> <%} else {

							%> <%if (bean.getEstado()==0) {%> <%=bean.getMonto2()%>
				<%} else {
								%> <input style="text-align: right; width:50px;" type="text"
					class="textBlanco Text" maxlength="9"
					name="txtMonto_1_<%=bean.getCodAccion() %>_<%=bean.getCodEpigrafe() %>"
					value="<%=bean.getMonto2() %>"
					onkeypress="ingresoEnterosN(event);"> <%}
						%> <%}%></td>
			</tr>
			<%}
					%>
			<%if (i == a.size() - 1) {%>
			<tr>
				<td colspan="3">&nbsp;</td>
				<td>TOTAL GENERAL</td>
				<td align="right"><%=bean.getTotalClientes()%></td>
				<td align="right">&nbsp;</td>
				<td align="right">&nbsp;</td>
				<td align="right">&nbsp;</td>
				<td align="right">&nbsp;</td>
			</tr>
			<%}

				%>

			<%}
			} else {%>
			<tr>
				<td colspan="3">&nbsp;</td>
				<td>TOTAL GENERAL</td>
				<td align="right">0</td>
				<td align="right">&nbsp;</td>
				<td align="right">&nbsp;</td>
				<td align="right">&nbsp;</td>
				<td align="right">&nbsp;</td>
			</tr>
			<%}

			%>

		</table>
		<br>
		<br>
		<div style="text-align: center; font-size: 11px;"><b>ESFUERZOS ADICIONALES</b></div>
		<br>
		<table id="esfuerzosConcretados" cellspacing="0" cellpadding="0" align="center" class="DataGrid" width="1000px">
			<tr>
				<th colspan="3">PRIORIDAD Y OBJETIVOS DE LA OFICINA</th>
				<th colspan="3">ACCIONES CONCRETAS</th>
				<th colspan="3">TOTAL</th>
			</tr>
			<tr>
				<th style="width:40px;font-size:80%;">PRIOR</th>
				<th style="width:230px;font-size:80%;">TAREAS</th>
				<th style="width:75px;font-size:80%;">OBJ. FACT. MES</th>
				<th>DESCRIPCION</th>
				<th style="width:75px;font-size:80%;">N&deg; DE CLIENTES</th>
				<th style="width:75px;font-size:80%;">COMPR GT</th>
				<th style="width:75px;font-size:80%;">N&deg; GESTIONES</th>
				<th style="width:75px;font-size:80%;">N&deg; CONCRETADOS</th>
				<th style="width:75px;font-size:80%;">MONTO</th>
			</tr>
			<%if (c != null) {
				String colorfila = "";
				for (int i = 0; i < c.size(); i++) {
					bean = (Accion) c.elementAt(i);

					if (i < c.size() - 1) {
						if (bean.getOrden() == null
								|| bean.getOrden().equals("")) {
							colorfila = "colorfila2";
						} else {
							colorfila = "colorfila1";
						}

						%>
			<tr>
				<td align="right"><%=bean.getOrden()%>&nbsp;</td>
				<td><div><%=bean.getNomCampania()%></div><input type="hidden" value="<%=bean.getCodEpigrafe()%>">&nbsp;</td>
				<td align="right"><%=bean.getPorc_asig()%>&nbsp;</td>
				<td><%=bean.getNomAccion()%>&nbsp;</td>
				<td align="right"><%=bean.getNumeroCliente()%>&nbsp;</td>
				<td align="right"><%=bean.getCompGestor()%></td>
				<td align="right">&nbsp;
					<%
						if ((bean.getNomAccion() != null && bean.getNomAccion().equals("Subtotal")) || sw_perfil) {
					%>
						<%=bean.getNumeroGestiones2()%>
					<%	}
						else {
							if (bean.getEstado()==0) {
					%>
						<%=bean.getNumeroGestiones2()%>
					<%		} else {
					%>
						<input
						style="text-align: right; width:50px;" align="right" type="text"
						class="textBlanco Text" maxlength="5"
						name="txtNumGestiones_2_<%=bean.getCodAccion() %>_0"
						value="<%=bean.getNumeroGestiones2() %>"
						onKeyPress="ingresoEnteros(event);">
					<%		}
						}
					%>
				</td>
				<td align="right">&nbsp; <%if ((bean.getNomAccion() != null && bean.getNomAccion().equals("Subtotal")) || sw_perfil) {

							%>
				<%=bean.getNumeroConcretados2()%> <%} else {

							%> <%if (bean.getEstado()==0) {%>
				<%=bean.getNumeroConcretados2()%> <%} else {

								%> <input
					style="text-align: right; width:50px;" type="text" class="textBlanco Text"
					maxlength="4"
					name="txtNumConcretados_2_<%=bean.getCodAccion() %>_0"
					value="<%=bean.getNumeroConcretados2() %>"
					onkeypress="ingresoEnteros(event);"> <%}

						%> <%}%></td>
				<td align="right">&nbsp; <%if ((bean.getNomAccion() != null && bean.getNomAccion().equals("Subtotal")) || sw_perfil) {

							%>
				<%=bean.getMonto2()%> <%} else {

							%> <%if (bean.getEstado()==0) {%> <%=bean.getMonto2()%>
				<%} else {

								%> <input style="text-align: right; width:50px;" type="text"
					class="textBlanco Text" maxlength="9"
					name="txtMonto_2_<%=bean.getCodAccion() %>_0"
					value="<%=bean.getMonto2() %>"
					onkeypress="ingresoEnterosN(event);"> <%}

						%> <%}%></td>
			</tr>
			<%}

					%>
			<%if (i == c.size() - 1) {%>
			<tr>
				<td colspan="3">&nbsp;</td>
				<td>TOTAL GENERAL</td>
				<td align="right">&nbsp;<%=bean.getTotalClientes()%></td>
				<td align="right">&nbsp;</td>
				<td align="right">&nbsp;</td>
				<td align="right">&nbsp;</td>
				<td align="right">&nbsp;</td>
			</tr>
			<%}
				%>
			<%}
			}
			%>
		</table>
		<BR>
		<%if (c != null || a != null) {%>
		<center><c:if test="${sessionScope.gestor.codigoPerfil!='ADM' && sessionScope.gestor.codigoPerfil!='SUP' && sessionScope.gestor.codigoPerfil!='CON'}">
			<input type="button" value="Grabar" onClick="grabar()" <% if (bean.getEstado()!=0) {%> disabled <%}%>>
		</c:if> <input type="button" value="Imprimir" onClick="window.print()"></center>
		<%} else {

			%> <%}

		%> <!-- **** FIN RESTO DE CÓDIGO DE LA PÁGINA--></td>
	</tr>
</table>
</form>
</BODY>
</html:html>
