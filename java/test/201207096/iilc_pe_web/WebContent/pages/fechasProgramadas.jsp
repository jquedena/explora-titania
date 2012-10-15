
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
 
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@page import="java.util.List" session="true" %>
<%@page import="java.util.ArrayList" session="true" %>
<%@page import="com.grupobbva.bc.per.tel.iilc.serializable.AdministracionCargaVinculacion" session="true" %>
<%@ taglib uri="/WEB-INF/displaytag-11.tld" prefix="display"%>
<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<LINK rel="stylesheet" href='<c:out value="${pageContext.request.contextPath}"/>/theme/IIRGEspacio2.css' type="text/css">

<TITLE>Carpetas Comerciales</TITLE>

<style type="text/css">
 
#contenido {
    position:absolute;
    left:35%;
    top:38%;
    width:35%;
    height:15%px;
    z-index:2;
}

</style>

<script language="javascript" type="text/javascript" src="<c:out value="${pageContext.request.contextPath}"/>/includes/datetimepicker.js"></script>
<script type="text/javascript" src="<c:out value="${pageContext.request.contextPath}"/>/includes/jquery-1.2.6.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/js/contexto.js"></script>
<script type="text/javascript">
	var contexto = obtenerContexto();

	function eliminar(){
		if(document.getElementById('arregloEliminar')!=null){
			if(confirm("\u00BFDesea eliminar las fechas programadas?")){
				document.forms[0].action = contexto+'admElimArchVincula.do?eliminar=true';       
		    	document.forms[0].submit();  
		    }
		}
	}

/*	
	function mensajero(){
		if(document.forms[0].mensaje.value=='NULL' ||
			document.forms[0].mensaje.value=='null' ||
			document.forms[0].mensaje.value=='' ||
			document.forms[0].mensaje.value=='undefined' ||
			document.forms[0].mensaje.value==undefined ){
		}else{
			alert(document.forms[0].mensaje.value);
		}
	}
*/

function mensajero(){
	if(document.forms[0].mensaje.value=='NULL' ||
		document.forms[0].mensaje.value=='null' ||
		document.forms[0].mensaje.value=='' ||
		document.forms[0].mensaje.value=='undefined' ||
		document.forms[0].mensaje.value==undefined ){
	}else{
		alert(document.forms[0].mensaje.value);
	}
	
	if(document.forms[0].mensajeInformacion.value=='NULL' ||
		document.forms[0].mensajeInformacion.value=='null' ||
		document.forms[0].mensajeInformacion.value=='' ||
		document.forms[0].mensaje.value=='undefined' ||
		document.forms[0].mensaje.value==undefined ){
			if(document.getElementById( "fecha_"+document.forms[0].tipo.value)!=null){
				document.getElementById( "fecha_"+document.forms[0].tipo.value).value='';
			}
	}else{  	
		if(confirm(document.forms[0].mensajeInformacion.value)){
			document.forms[0].action = contexto+'admArchVincula.do?sobreescritura=true&tipo='+document.forms[0].tipo.value;       
			document.forms[0].submit();  
		}
	}
}

   function salir(){
     	window.location = contexto+"pages/AdmArchVincula.jsp";
   }

function cargarVentana(){
	$("#contenido").hide();
	if(document.forms[0].modificacion.value=='mostrarDIV'){
			$("#Bbody input.qwe").css("visibility", "hidden");
			if ($("#contenido").is(":hidden")) {
				$("#contenido").show();
			}
	}
		
	$('#boton').click(function(){
		$("#Bbody input.qwe").css("visibility", "visible");  
		$('#contenido').hide(); 
	});
}
   
window.onload=function(){
	cargarVentana();
	mensajero();
};

function asignaFecha(fecha, id){
	$("#fecha").val(fecha);
	$("#fecha_original").val(fecha);
	document.forms[0].modificacion.value='mostrarDIV';
	cargarVentana();
}

function grabarModificacion(tipoVinculacion){
	document.forms[0].action = contexto+'admArchVincula.do?sobreescritura=true&org=1&tipo='+tipoVinculacion;       
    document.forms[0].submit();  
}

function carga_modificar (action){
	document.forms[0].action =contexto+action;       
	document.forms[0].submit();
}
   
</script>
</HEAD>

<BODY>
<html:form action="/admElimArchVincula" >

<div id="Bbody" >
	<input type="hidden" id="mensaje" name="mensaje" value="<%=request.getAttribute("mensaje")%>" />
	<input type="hidden" id="tipo" name="tipo" value="<%=request.getParameter("tipo")%>" />
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<!-- FILTROS -->
<tr>
	<td style="vertical-align:middle;" colspan="2" >
		<TABLE width="100%" align="center">
		<TR>
			<TD class="FondoAzul" width="25%">ADMINISTRADOR CARGA VINCULACI&Oacute;N</TD>
		</TR>
		</TABLE>
	</td>
</tr>
</table>
<br>
<table width="100%" border="1" cellpadding="0" cellspacing="0">
	<tr class="FondoGris1"><td>
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="datTable">
			<tr>
				<td colspan="2" align="right" ></td>
			</tr>
			<tr>
				<td width="100%" align="left" >
					<display:table name="listaCargas"  id="lista" pagesize="20" summary="false" scope="session" class="grilla" >
					<display:column class="cabecera">
					<input class="qwe" type="checkbox"  name="arregloEliminar" id="arregloEliminar"  value="${lista.fecha}" >
					</display:column>
					<display:column class="cabecera">
					<a href="javascript: void(0)" onclick="asignaFecha('${lista.fecha}', '${lista.id_registro}');" >
					${lista.fecha}
					</a>
					</display:column>
					</display:table>
				</td> 
			</tr>
			<tr>
				<td colspan="4" align="center">
					<html:button styleClass="qwe" property="Fechas1" onclick="eliminar();">Eliminar</html:button>
					<html:button styleClass="qwe" property="Grabar1"  onclick="salir();">Salir</html:button>
				</td>
			</tr>
		</table>
	</td></tr>
</table>
</div>
	
	
	<table id="contenido" class="FondoGris1" border="1" >
			<tr>
			<td>
			 <table width="100%" border="0" cellpadding="0" cellspacing="0" >
			 <tr>
			 <td width="100%" class="FondoAzul" >
			 	Modificando programaci&oacute;n de carga
			  </td>
			  <td  class="FondoAzul" >
			  	<div id="boton"  style="cursor:pointer;width:14%;">
			  		<img width="20" height="20" src="<c:out value="${pageContext.request.contextPath}"/>/images/icos/cerrar.png"  />
			  	</div>
			  </td>
			  </tr>
			  <tr>
			  <td colspan="2" align="center" >
			 <br>
			 <br>
			<input type="hidden" id="id" name="id" value="<%=request.getAttribute("id")%>" />
			<input type="hidden" id="modificacion" name="modificacion" value="<%=request.getAttribute("modificacion")%>" />
			<input type="hidden" id="fecha_original" name="fecha_original" value="${requestScope.fecha}" />
				Fecha / Hora
				<input type="text" id="fecha" name="fecha_<%=request.getParameter("tipo")%>" readonly value="${requestScope.fecha}" />
				<a href="javascript:NewCal('fecha','ddmmyyyy',true,24)">
				<img src="<c:out value="${pageContext.request.contextPath}"/>/images/cal.gif" width="16" height="16" border="0" >
				</a>
			 <br/>
			 <br/>
			 </td>
			 </tr>
			 </table>
			 <center>
			<html:button property="grabar"   onclick="grabarModificacion('${requestScope.tipo}');" >
					Grabar
			</html:button>
			<html:button property="cancelar"  onclick="document.getElementById('boton').click();">
					Cancelar
			</html:button>
			</center>
			</td></tr>
			</table>
</html:form>
</BODY>
</html:html>
