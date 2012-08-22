<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@ taglib prefix="fn" uri="/WEB-INF/fn.tld"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html:html>
<HEAD>
	<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<META name="GENERATOR" content="IBM Software Development Platform">
	<META HTTP-EQUIV='PRAGMA' CONTENT='NO-CACHE'>
	<META HTTP-EQUIV='EXPIRES' CONTENT='0'>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="stylesheet"	href="<%=request.getContextPath()%>/css/style.css"	type="text/css">
	<TITLE></TITLE>
</HEAD>

<script>
<% String colorfila = "";
	int i = 0;
 %>

function nuevo(){
	var form = document.forms[0];
	
	form.action="permisoPerfilAction.do?method=nuevoPermisoPerfil";
	form.submit();
}

function editar(codPerfil, tipoAcceso, valorRCP){
	var form = document.forms[0];
	
	form.action="permisoPerfilAction.do?method=mostrarPermisoPerfil&codPerfil="+codPerfil+"&tipoAcceso="+tipoAcceso+"&valorRCP="+valorRCP;	
	form.submit();
}

function eliminar()	{
	var cadenaCodPerfil="";
	var cadenaTipoAcceso="";
	var cadenaValorRCP="";	
	var valorCaja; 
	var m = 1;
	
	if(document.forms[0].caja)	{
		if(document.forms[0].caja.length)	{
			for (i=0; i<document.forms[0].caja.length; i++) {
				if(document.forms[0].caja[i].checked){	
					if(m==1) {						
						valorCaja = document.forms[0].caja[i].value.split(",");
						
						cadenaCodPerfil = cadenaCodPerfil + "|" + valorCaja[0];
						cadenaTipoAcceso = cadenaTipoAcceso + "|" + valorCaja[1];
						cadenaValorRCP = cadenaValorRCP + "|" + valorCaja[2];
					}
					else {	
						valorCaja = document.forms[0].caja[i].value.split(",");
								
						cadenaCodPerfil = cadenaCodPerfil + "|" + valorCaja[0];
						cadenaTipoAcceso = cadenaTipoAcceso + "|" + valorCaja[1];
						cadenaValorRCP = cadenaValorRCP + "|" + valorCaja[2];
					}
					m++;
				}
			}
		}
		else {
			if(document.forms[0].caja.checked) {				
				valorCaja = document.forms[0].caja[i].value.split(",");
								
				cadenaCodPerfil = cadenaCodPerfil + "|" + valorCaja[0];
				cadenaTipoAcceso = cadenaTipoAcceso + "|" + valorCaja[1];
				cadenaValorRCP = cadenaValorRCP + "|" + valorCaja[2];
				
				m++;
			}
		}
		
		if(m==1) {
			alert("Debe de Seleccionar por lo menos un Permiso Perfil");
			return false;
		}
		
		if (confirm("\u00BFDesea eliminar el Permiso Perfil seleccionado?")==false)
			return false;

		document.forms[0].listaCodPerfil.value = cadenaCodPerfil;
		document.forms[0].listaTipoAcceso.value = cadenaTipoAcceso;
		document.forms[0].listaValorRCP.value = cadenaValorRCP;
		document.forms[0].action="permisoPerfilAction.do?method=eliminarPermisoPerfil";
		document.forms[0].submit();
	}
}

function seleccionar_todos() {
	var form = document.forms[0];

	if(form.caja) {
		if(form.caja.length) {
			for (i=0; i<form.caja.length; i++) {
				if (form.todos.checked==false) {
					form.caja[i].checked=false;
				}
				else { 
					form.caja[i].checked=true;
				}
			}
		}
		else {
			if(form.todos.checked==false) { 
				form.caja.checked=false;
			}
		  	else { 
		  		form.caja.checked=true;
		  	}
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
<html:form action="/permisoPerfilAction">
<html:hidden property="listaCodPerfil" value="" />
<html:hidden property="listaTipoAcceso" value="" />
<html:hidden property="listaValorRCP" value="" />

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
				<p class="titulo" >MANTENIMIENTO DE PERMISO PERFIL </p>
				
				<!-- Border Table Build  ----------------------------->
				<table border="0" cellpadding="0" cellspacing="0" width="938">
					<tr>
						<td></td>
					</tr>
					<tr>
						<td></td>
					</tr>		
				</table>						
				<table width="640" height="80" border="1" cellspacing="0" >	
				  <tr>
				    <td width="150" align="center" class="celda1cabecera"><span class="Estilo2">Perfil</span></td>
				    <td width="80" align="center" class="celda1cabecera"><span class="Estilo2">Tipo de Acceso</span></td>
				    <td width="80" align="center" class="celda1cabecera"><span class="Estilo2">Valor RCP</span></td>
				    <td width="210" align="center" class="celda1cabecera"><span class="Estilo2">Usuario</span></td>
				    <td width="60" align="center" class="celda1cabecera"><span class="Estilo2">Editar</span></td>
				    <td width="60" align="center" class="celda1cabecera"><span class="Estilo2">
				      <input type="checkbox" name="todos" onClick="seleccionar_todos();"></span>				
				    </td>
			      </tr>			
				  <c:if test="${not empty requestScope.listaPermisoPerfiles}">					
					<c:forEach items="${requestScope.listaPermisoPerfiles}" var="objBean">
					<%  
						if (i%2 != 0) colorfila = "colorfila1";
						else colorfila = "colorfila2";
						i++;
					%>
					<tr class="cuerpoTabla">
					<td class="<%=colorfila %>" align="center" ><c:out value="${objBean.nombrePerfil}"/></td>
					<td class="<%=colorfila %>" align="center" ><c:out value="${objBean.nombreTipoAcceso}"/></td>
					<td class="<%=colorfila %>" align="center" ><c:out value="${objBean.valorRCP}"/></td>
					<td class="<%=colorfila %>" align="left" >&nbsp;<c:out value="${objBean.usuario}"/></td>					
					<td align="center" class="<%=colorfila %>">
						<a href="javascript:editar('<c:out value="${objBean.codPerfil}"/>','<c:out value="${objBean.tipoAcceso}"/>','<c:out value="${objBean.valorRCP}"/>')">
							<img border="0" src="<%=request.getContextPath()%>/images/editar.png" width="18" height="18">
						</a>
					</td>
					<td align="center" class="<%=colorfila %>">
						<input type="checkbox" name="caja" value="<c:out value="${objBean.codPerfil}"/>,<c:out value="${objBean.tipoAcceso}"/>,<c:out value="${objBean.valorRCP}"/>"/>
					</td>
					</tr>
					</c:forEach>
				  </c:if>	
				  <c:if test="${empty requestScope.listaPermisoPerfiles}">	
				  	<tr class="cuerpoTabla">
				  		<td class="colorfila1">&nbsp;</td>
				  		<td class="colorfila1">&nbsp;</td>
				  		<td class="colorfila1">&nbsp;</td>
				  		<td class="colorfila1">&nbsp;</td>
				  		<td class="colorfila1">&nbsp;</td>
				  		<td class="colorfila1">&nbsp;</td>
				  	</tr>
				  </c:if>					  
				</table>
	
				<c:if test="${sessionScope.newPerfilUsuario ==  'ADM'}">     
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
      	   </c:if>   
				<!--FIN  Border Table Build ----------------------------->
		   </div>
		
		<!-- **** FIN EL RESTO DE CÓDIGO DE LA PÁGINA-->
	
	
		</td>
	</tr>
</table>
</html:form> 
</BODY>
</html:html>