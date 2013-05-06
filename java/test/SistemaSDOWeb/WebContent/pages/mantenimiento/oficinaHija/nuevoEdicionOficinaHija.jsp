<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>


<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META HTTP-EQUIV='PRAGMA' CONTENT='NO-CACHE'>
<META HTTP-EQUIV='EXPIRES' CONTENT='0'>
<META http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
<TITLE>Mantenimiento Oficinas Hijas</TITLE>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/validaTecla.js"></script>
<script type="text/javascript">
	function limpiar(){
		var form = document.forms[0];
		
		form.method.value = "mostrarNuevoEditarOficinaHija";		
		
		<c:if test="${requestScope.mostrarEditar == '1'}">
			form.mostrarEditar.value = "1";
		</c:if> 				
		
		<c:if test="${requestScope.mostrarEditar == '2'}">
			form.codigoOficinaHija.value = "${requestScope.oficinaHija.codigoOficinaHija}";
			form.mostrarEditar.value = "2";
		</c:if> 						
		
		form.submit();																			
	}
	
	function grabar() {
		var form = document.forms[0];

		form.mostrarEditar.value = "${requestScope.mostrarEditar}";				
		form.method.value = "grabarOficinaHija";		
		
		if(validar()) {			
			form.submit();		
		}		
	}

	function validar() {
		var form = document.forms[0];
		
		if(form.codigoOficinaHija.value == "") {
			alert("Ingrese código de oficina hija");
			form.codigoOficinaHija.focus();
			
			return false;
		}
		
		if(form.descripcion.value == "") {
			alert("Ingrese nombre de oficina hija");
			form.descripcion.focus();
			
			return false;
		}
		
		if(form.codigoOficinaPadre.options[form.codigoOficinaPadre.selectedIndex].value == "") {
			alert("Seleccione oficina padre");
			form.codigoOficinaPadre.focus();
			
			return false;
		}
		
		if(form.codigoOficinaPadre.options[form.codigoOficinaPadre.selectedIndex].value == form.codigoOficinaHija.value) {
			alert("La oficina hija no puede ser la misma oficina padre");		
			
			return false;
		}
		
		return true;
	}	
	
	function volver(){
		var form = document.forms[0];
		
		form.method.value = "listarOficinaHija";
		form.submit();									
	}
	
	function inicio() {
		focoCodOficinaHija();
		
		<c:if test="${requestScope.mostrarEditar == '2'}">
			soloLecturaCodigoOficinaHija();
			focoNombreOficinaHija();
		</c:if> 	
	}
	
	function soloLecturaCodigoOficinaHija() {
		var form = document.forms[0];
		
		form.codigoOficinaHija.readOnly = true;
	}
	
	function focoCodOficinaHija() {
		var form = document.forms[0];
		
		form.codigoOficinaHija.focus();
	}
	
	function focoNombreOficinaHija() {
		var form = document.forms[0];
		
		form.descripcion.focus();
	}
	
	var mensaje_error = '<%=request.getAttribute("mensajeExito")%>';

</script>
</HEAD>

<BODY onload="inicio();">
<html:form action = "/oficinaHijaAction">
<html:hidden property="method"/>
<html:hidden property="mostrarEditar"/>
<table align="center" width="100%" height="%" cellspacing="0" cellpadding="0">
	<tr>
		<td width="100%" align="left"  valign="top">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td><img src="${pageContext.request.contextPath}/images/esq_izq.jpg"></td>	
					<td width="200" class="textocentradoblanco">MANTENIMIENTO</td>	
					<td><img src="${pageContext.request.contextPath}/images/esq_der.jpg"></td>	
				</tr>						
			</table>
		</td>	
	</tr>
	<tr>
		<td style="border: 2px solid #264971;padding:20px;" valign="top" height="%" align="center">
			<div align="center"><strong>OFICINAS HIJAS</strong></div><br />
			<table cellspacing="1" cellpadding="1" align="center">
				<tr>
			    	<td width="60">&nbsp;</td>
			    	<td width="60">&nbsp;</td>
			    	<td width="60">&nbsp;</td>				    
			    	<td width="60">&nbsp;</td>
				    <td width="60">&nbsp;</td>
				    <td width="60">&nbsp;</td>
				</tr>
				<tr>
					<td colspan = "6" align = "center">
			    		<div align = "center" id="text_error" style="font-weight: bold;font-size: 120%;">
					    	<c:if test="${not empty requestScope.mensajeError}">
								<span class = "mensaje_error">
									${requestScope.mensajeError}
								</span>
							</c:if> 
							<c:if test="${not empty requestScope.mensajeExito}">
								<span class = "mensaje_exito">			
									${requestScope.mensajeExito}
								</span>					
							</c:if> 
						</div>	
				    </td>
				</tr>							  	
				<tr>
			    	<td></td>
			    	<td align="right">
			    		<SPAN style="font-size: 12">C&oacute;digo Oficina Hija:</SPAN>
			    	</td>
				    <td >
				    	<html:text property="codigoOficinaHija" size="3" tabindex="1" maxlength="4" styleClass="cajatexto" readonly="readonly" value="${requestScope.oficinaHija.codigoOficinaHija}" onkeypress="return validKey(this, event, ALFA_PATTERN);"> </html:text> 							     
					</td>
					<td colspan = "3">&nbsp;</td>					
				</tr>	
				<tr>
			    	<td></td>
			    	<td align="right"><SPAN style="font-size: 12">Nombre Oficina Hija:</SPAN></td>
				    <td >
				    	<html:text property="descripcion" size="20" maxlength="80" tabindex="2" styleClass="cajatexto" readonly="readonly" value="${requestScope.oficinaHija.nombreOficinaHija}" onkeypress="return validKey(this, event, ALFA_PATTERN);"> </html:text> 							     
					</td>
					<td colspan = "3">&nbsp;</td>					
				</tr>	
				<tr>
					<td></td>
			    	<td align="right">
			    		<SPAN style="font-size: 12">Oficina Padre:</SPAN>			    		
			    	</td>
				    <td colspan = "4">				    	
				    	<html:select property="codigoOficinaPadre" styleClass="combo2" tabindex="3" value="${requestScope.oficinaHija.codigoOficinaPadre}">
							<html:option value="" >[Seleccione Oficina Padre]</html:option>
							<html:options collection="listaOficinaPadre" property="codOfic" labelProperty="codNomOficina"/>
						</html:select>										    	
				    </td>
				</tr>					
				<tr>
			    	<td>&nbsp;</td>
			    	<td>&nbsp;</td>
			    	<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>				
				</tr>
			   	<tr>
	    			<td colspan="6">
					    <table align="center">
					    	<tr>
	    						<td colspan = "3" align = "center">
	    							<input type="button" name="btnGrabar" value="Grabar" onClick="grabar();" class="botonnew" tabindex="4">
	    							&nbsp;	
							    	<input type="button" name="btnLimpiar" value="Limpiar" onClick="limpiar();" class="botonnew" tabindex="5">
							    	&nbsp;								    	
								    <input type="button" name="btnVolver" value="Volver" onClick="volver();" class="botonnew" tabindex="6" onblur="javascript:focoCodOficinaHija();">
							    </td>
						    </tr>
						</table>
				    </td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</html:form>
</BODY>
</html:html>
