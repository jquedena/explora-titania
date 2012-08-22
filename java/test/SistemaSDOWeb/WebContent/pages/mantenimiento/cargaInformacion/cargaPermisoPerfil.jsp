<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@ taglib prefix="fn" uri="/WEB-INF/fn.tld"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld" %>

<%@ taglib uri="http://stefanini.com.pe/tags/util" prefix="util"%>
<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META HTTP-EQUIV='PRAGMA' CONTENT='NO-CACHE'>
<META HTTP-EQUIV='EXPIRES' CONTENT='0'>
<META name="GENERATOR" content="IBM Software Development Platform">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet"	href="<%=request.getContextPath()%>/css/style.css"	type="text/css">
<TITLE></TITLE>
</HEAD>

<script>

function envioDatos(){
	var form = document.forms[0];
	form.txtRuta.value = form.fileInput.value;
	if(form.txtRuta.value == "") {
		alert("Seleccione un archivo");
		return false;
	}
	form.action = "cargaPermisosAction.do?method=cargarData";
	form.method="post";	
	form.submit();
}

</script>
<BODY>
<table align="center" width="100%" height="%" cellspacing="0" cellpadding="0">
	<tr>
		<td width="100%" align="left"  valign="top">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td><img src="<%=request.getContextPath()%>/images/esq_izq.jpg"></td>
					<td width="200" class="textocentradoblanco">CARGA DE INFORMACI&Oacute;N </td>
					<td><img src="<%=request.getContextPath()%>/images/esq_der.jpg"></td>
				</tr>						
			</table>
		</td>	
	</tr>
	<tr>
		<td style="border: 2px solid #264971;padding:20px;" valign="top" height="%" align="center">				
		<div id="pagina" style="overflow:auto;">
			<form action="/cargaPermisosAction" styleId="simpleLoadForm" enctype="multipart/form-data">
				<input type="hidden" name="txtRuta" >
				<input type="hidden" name="txtArchivo">
				<p class="titulo" >Cargar Data de Permisos </p>							
				<table width="518" height="80" border="1" cellspacing="0" >
			  <tr class="cuerpoTabla">
			    <td width="57" align="center"><span class="Estilo2">Ruta:</span></td>
			    <td width="60"><span class="Estilo2">
					<input type="file" class="multi" maxlength="1" accept="txt" name="fileInput" id="fileInput" />
					</span>
				</td>
		      </tr>
			</table>
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
				  <input type="button" name="grabo" value="Enviar" onClick="javascript:envioDatos()"  class="botonnew"></td>
				<td>
				</td>
				</tr>
				<tr>
				<td>
				</td>
				<td align="center">
				<td>
				</td>
				</tr>
				<tr>
				<td>
				</td>
				<td>
				</td>
				<td>
				</td>
				</tr>
			  </table>				
				<util:errorMessage key="error_message" styleClass="mensaje_error"/>			  		  						  
			</form></div>

		</td>
	</tr>
</table>
<table border="0" cellpadding="0" cellspacing="0" width="938">
  <tr>
    <td></td>
  </tr>
  <tr>
    <td></td>
  </tr>
</table>
</BODY>
</html:html>