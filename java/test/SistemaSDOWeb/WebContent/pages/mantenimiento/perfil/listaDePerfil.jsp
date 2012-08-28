<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@ taglib prefix="fn" uri="/WEB-INF/fn.tld"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld" %>

<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet"	href="<%=request.getContextPath()%>/css/style.css"	type="text/css">
<TITLE></TITLE>
<%
String perfil=(String)request.getAttribute("perfil");
 %>
</HEAD>

<script>


<% String colorfila = "";
	int i = 0;
 %>

function nuevo(){
	var form = document.forms[0];
	
	form.action="perfilAction.do?method=nuevoPerfil";
	form.submit();
}

function editar(cod,nom,perfil){
	var form = document.forms[0];
	var valorCodSel=cod;
	var valorNomSel=nom;
	var valorPerfil=perfil;
	form.codPerfil.value=valorCodSel+'|'+valorNomSel+'|'+valorPerfil;
	form.action="perfilAction.do?method=mostrarPerfil";
	form.submit();
}

function eliminar() {
	cadena="";
	m = 1;
	
	if(document.forms[0].caja) {
		if(document.forms[0].caja.length) {
			for (i=0; i<document.forms[0].caja.length; i++) {
				if(document.forms[0].caja[i].checked){
					if(m==1) cadena = cadena + document.forms[0].caja[i].value;
					else	 cadena = cadena + "|" + document.forms[0].caja[i].value;
					m++;
				}
			}
		}
		else {
			if(document.forms[0].caja.checked) {
				cadena = document.forms[0].caja.value;
				m++;
			}
		}
		if(m==1) {
			alert("Debe de seleccionar por lo menos un perfil");
			return false;
		}
		if (confirm("\u00BFDesea eliminar los perfiles seleccionados?")==false)
			return false;

		document.forms[0].codigos.value=cadena;
		document.forms[0].action="perfilAction.do?method=eliminarPerfil";
		document.forms[0].submit();
	}
}

function seleccionar_todos() {
	var form = document.forms[0];

	if(form.caja) {
		if(form.caja.length) {
			for (i=0; i<form.caja.length; i++) {
				if (form.todos.checked==false) form.caja[i].checked=false;
				else form.caja[i].checked=true;
			}
		}
		else {
			if(form.todos.checked==false) form.caja.checked=false
		  	else form.caja.checked=true
		}
	}	
}

var mensaje_error = '<%=session.getAttribute("error_Territorio")%>';
<% session.setAttribute("error_Territorio", null); %>
window.onload=function(){
	if (mensaje_error != 'null') {
		alert(mensaje_error);
	}
}
</script>

<BODY>
<table align="center" width="100%" height="%" cellspacing="0" cellpadding="0">
	<tr>
		<td width="100%" align="left"  valign="top">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td><img src="<%=request.getContextPath()%>/images/esq_izq.jpg"></td>
					<td width="200" class="textocentradoblanco">MANTEMIMIENTO</td>
					<td><img src="<%=request.getContextPath()%>/images/esq_der.jpg"></td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td style="border: 2px solid #264971;padding:20px;" valign="top" height="%" align="center">

		<!-- **** AQUI EL RESTO DE CÓDIGO DE LA PÁGINA-->
		
		<div id="pagina" style="overflow:auto;">
			<html:form action="/perfilAction" styleId="perfilForm">
				<input type="hidden" name="codPerfil" >
				<input type="hidden" name="nomPerfil" >
				<input type="hidden" name="codigos" >
				<p class="titulo" >MANTENIMIENTO DE PERFILES </p>
				
				<!-- Border Table Build  ----------------------------->
				<table border="0" cellpadding="0" cellspacing="0" width="938">
					<tr>
						<td></td>
					</tr>
					<tr>
						<td></td>
					</tr>		
				</table>
			<table width="546" height="80" border="1" cellspacing="0" >

			  <tr>
			    <td width="57" align="center" class="celda1cabecera"><span class="Estilo2">C&oacute;digo</span></td>
				<td width="57" align="center" class="celda1cabecera"><span class="Estilo2">Perfil</span></td>
			    <td width="219" align="center" class="celda1cabecera"><span class="Estilo2">Nombre</span></td>
			    <td width="173" align="center" class="celda1cabecera"><span class="Estilo2">Editar</span></td>
			    <td width="79" align="center" class="celda1cabecera"><span class="Estilo2">
			      <input type="checkbox" name="todos" onClick="seleccionar_todos();"></span>
				</td>
		      </tr>
			
			  <logic:present name ="listaAllPerfil">
				<bean:define id="listaDatos" name="listaAllPerfil" scope="session" />
				<c:forEach items="${listaDatos}" var="objBean">
				<%  
					if (i%2 != 0) colorfila = "colorfila1";
					else colorfila = "colorfila2";
					i++;
				%>
				<tr class="cuerpoTabla">
				<td class="<%=colorfila %>">
					<c:out value="${objBean.codPerfil}"/>
				</td>
				<td class="<%=colorfila %>">
					<c:out value="${objBean.perfil}"/>
				</td>
				
				<td class="<%=colorfila %>"><c:out value="${objBean.nomPerfil}"/></td>
				<td align="center" class="<%=colorfila %>">
					<a href="javascript:editar('<c:out value="${objBean.codPerfil}"/>', '<c:out value="${objBean.nomPerfil}"/>', '<c:out value="${objBean.perfil}"/>')">
						<IMG border="0" src="<%=request.getContextPath()%>/images/editar.png" width="18" height="18">
					</a>
				</td>
				<td align="center" class="<%=colorfila %>">
					<input type="checkbox" name="caja" value='<c:out value="${objBean.codPerfil}"/>'>
				</td>
				</tr>
				</c:forEach>
			  </logic:present>
			</table>
<%if(perfil.equals("ADM")){ %>
			<table width="938">
				<tr>
				<td width="300"></td>
				<td width="338"></td>
				<td width="300"></td>
				</tr>
				<tr>
				<td>
				</td>
				<td align="center">
					<input type="button" name="grabo" value="Nuevo" onClick="javascript:nuevo()" class="botonnew">
					<input type="button" name="borrar" value="Eliminar" onClick="javascript:eliminar()" class="botonnew">
				</td>
				<td>
				</td>
				</tr>

			  </table>
	<%} %>		
				<!--FIN  Border Table Build ----------------------------->
			</html:form></div>
		
		<!-- **** FIN EL RESTO DE CÓDIGO DE LA PÁGINA-->
	
	
		</td>
	</tr>
</table>
</BODY>
</html:html>