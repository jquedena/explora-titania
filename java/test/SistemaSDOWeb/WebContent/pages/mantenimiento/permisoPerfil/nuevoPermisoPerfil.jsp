<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@ taglib prefix="fn" uri="/WEB-INF/fn.tld"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html:html>
<HEAD>
	<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<META name="GENERATOR" content="IBM Software Development Platform">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<META HTTP-EQUIV='PRAGMA' CONTENT='NO-CACHE'>
	<META HTTP-EQUIV='EXPIRES' CONTENT='0'>
	<link rel="stylesheet"	href="<%=request.getContextPath()%>/css/style.css"	type="text/css">
	<TITLE></TITLE>
</HEAD>

<script type="text/javascript" language="javascript">

function grabar(){
	var form = document.forms[0];
	
	if(validar()) {		
		form.action="permisoPerfilAction.do?method=ingresarPermisoPerfil";
		form.submit();
	}
}

function validar() {
	var form = document.forms[0];
	var mensaje = "";
	var valido = true;
	var tipoAcceso = form.elements["tipoAcceso"].value;
	
	if(form.elements["codPerfil"].value==""){
		mensaje += "- Seleccione Perfil\n";
		valido = false;
	}
	
	if(tipoAcceso==""){
		mensaje += "- Seleccione Tipo de Acceso \n";
		valido = false;
	}
	
	if(form.elements["valorRCP"].value==""){
		mensaje += "- Ingrese valor RCP \n";
		valido = false;
	}	
		
	if(valido) {
		return true;			
	} else {
		alert(mensaje);
		
		return false;	
	}
}

function cambiarTipoAcceso() {
	var form = document.forms[0];
	var tipoAcceso = form.elements["tipoAcceso"].value;
	
	if(tipoAcceso == "" || tipoAcceso == "1") {
		form.elements["usuario"].disabled = true;
		form.elements["usuario"].value = "";
	} else {
		form.elements["usuario"].disabled = false;
	}
}

function cambiarTipoAccesoInicio() {
	var form = document.forms[0];
	var tipoAcceso = form.elements["tipoAcceso"].value;
	
	if(tipoAcceso == "" || tipoAcceso == "1") {
		form.elements["usuario"].disabled = true;
	} else {
		form.elements["usuario"].disabled = false;
	}
}

function cancelar(){
	var form = document.forms[0];

	form.action="permisoPerfilAction.do?method=inicioPermisoPerfil";
	form.submit();
}

function SoloLetras()
{   if(window.event.keyCode!=13)
   {
      var Tecla;
      Tecla = String.fromCharCode(window.event.keyCode);
      if ( !( (Tecla>="A" && Tecla<="Z")||(Tecla>="a" && Tecla<="z") || (Tecla>="0" && Tecla<="9") ||
              (Tecla=="-") || (Tecla=="_") || (Tecla=="?") || (Tecla=="?") || (Tecla=="?") ||
              (Tecla=="?") || (Tecla=="?") || (Tecla=="?") || (Tecla=="?") || (Tecla=="?") ||
              (Tecla==" ") || (Tecla=="?") || (Tecla=="?") ) )
     {
         window.event.keyCode = 0;
      }
   }	   
}

</script>

<BODY onload="javascript:cambiarTipoAccesoInicio();">
<html:form action="/permisoPerfilAction">
<table align="center" width="100%" height="%" cellspacing="0" cellpadding="0">
	<tr>
		<td width="100%" align="left"  valign="top">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td><img src="<%=request.getContextPath()%>/images/esq_izq.jpg"></td>
					<td width="200" class="textocentradoblanco">MANTENIMIENTO</td>
					<td><img src="<%=request.getContextPath()%>/images/esq_der.jpg"></td>
				</tr>						
			</table>
		</td>	
	</tr>
	<tr>
		<td style="border: 2px solid #264971;padding:20px;" valign="top" height="%" align="center">
		
		<div id="pagina" style="overflow:auto;">
			
				<p class="titulo" >INGRESAR PERMISO PERFIL</p>
				
				<!-- Border Table Build  ----------------------------->
				<table border="0" cellpadding="0" cellspacing="0" width="938">
					<tr>
						<td align="center"><span class="mensaje_error"><c:out value="${mensajeError}"/></span></td>
					</tr>
					<tr>
						<td></td>
					</tr>		
				</table>
			<table width="286" height="80" border="1" cellspacing="0" >

			  <tr class="cuerpoTabla">
			    <td width="120" align="left" nowrap><span class="Estilo2">Perfil</td>
			    <td width="166"><span class="Estilo2">
			    	<html:select property="codPerfil" styleClass="input_text_2" value = "${requestScope.permisoPerfil.codPerfil}">
						<html:option value="" >-----------SELECCIONE-----------</html:option>
						<html:options collection="listaPerfiles" property="codPerfil" labelProperty="nomPerfil"/>
					</html:select>
				</td>
		      </tr>
 			  <tr class="cuerpoTabla">
				<td width="120"  align="left"><span class="Estilo2">Tipo de Acceso</span></td>
				<td width="166">
					<span class="Estilo2">
						<html:select property="tipoAcceso" styleClass="input_text_2" value = "${requestScope.permisoPerfil.tipoAcceso}" onchange="javascript:cambiarTipoAcceso();">
							<html:option value="" >-----------SELECCIONE-----------</html:option>
							<html:option value="1" >Registro</html:option>
							<html:option value="2" >Cargo</html:option>
							<html:option value="3" >Oficina</html:option>							
						</html:select>
					</span>
				</td>				
			  </tr>
			  <tr class="cuerpoTabla">
				<td width="120"  align="left"><span class="Estilo2">Valor RCP</span></td>
				<td width="166"><span class="Estilo2">
					<html:text property = "valorRCP" styleClass="input_text_2" size="10" maxlength="10" 
							value = "${requestScope.permisoPerfil.valorRCP}" onkeypress="return SoloLetras()"/>
				</span>
				</td>				
			  </tr>
			  <tr class="cuerpoTabla">
				<td width="120"  align="left"><span class="Estilo2">Usuario</span></td>
				<td width="166">
					<span class="Estilo2">
						<html:text property = "usuario" styleClass="input_text_2" size="40" maxlength="100" 
							value = "${requestScope.permisoPerfil.usuario}" onkeypress="return SoloLetras()" disabled="true"/>
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
					<input type="button" name="btnGrabar" value="Enviar" onClick="javascript:grabar();"  class="botonnew">
					<input type="button" name="btnCancelar" value="Cancelar" onClick="javascript:cancelar();"  class="botonnew">
				</td>
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
			</div>		
		</td>
	</tr>
</table>
</html:form>
</BODY>
</html:html>