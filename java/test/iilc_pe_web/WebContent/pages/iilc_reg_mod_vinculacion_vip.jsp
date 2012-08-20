
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>


<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>

<%@page import="com.grupobbva.bc.per.tel.iilc.common.Constantes"%><html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<LINK rel="stylesheet"
	href='<c:out value="${pageContext.request.contextPath}"/>/theme/IIRGEspacio2.css'
	type="text/css">
	<LINK rel="stylesheet" href='theme/IIRGEspacio2.css' type="text/css">
	
<TITLE>Carpetas Comerciales</TITLE>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/js/contexto.js"></script>
<script type="text/javascript">
	var contexto = obtenerContexto();
	
	function salir(){
		window.location = contexto+"pages/iilc_listado_vinculacion.jsp";
	}
   
	function grabar(){
		document.forms[0].action = contexto+'crearListadoVinculacionVIP.do';       
		document.forms[0].submit();  
	}
 
	function validaCaractaer(e){
		var tecla= String.fromCharCode((document.all) ? e.keyCode : e.which);
		var digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz _";
		if(digits.indexOf(tecla)==-1) return false;
	}
</script>
</HEAD>
<BODY onunload="cargar_al_cerrar();">
<html:form action="/listadoVinculacionesVIP" >
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
<!-- FILTROS -->
<tr>
	<td style="vertical-align:middle;" colspan="2" >
		<TABLE width="100%" align="center">
			<TR>
				<TD class="FondoAzul" >ADMINISTRADOR CABECERA VINCULACION VIP</TD>
			
			
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
						<td align="left" class="mensajeInformacion" >
							<logic:notEmpty  name="mensaje"   >	
								<bean:write name="mensaje"  />
							</logic:notEmpty>
						</td>
								<td align="right">
									<html:button property="cancelar" styleClass="boton" onclick="grabar();">Grabar</html:button>
									<html:button property="cancelar2" styleClass="boton" onclick="salir();">Salir</html:button>
								</td>
							</tr>
			<tr><td>
		<table width="100%" border="0" align="center">
			<!-- Inicio Cabecera, definir aqui los anchos de cada celda-->
			<tr class="FondoAzul" >
				<td class="LCtd" width="200px">CAMPO</td>
				<td class="LCtd" width="300px">DESCRIPCI&Oacute;N CORTA</td>
				<td class="LCtd" width="400px">DESCRIPCI&Oacute;N LARGA</td>
			</tr>
			     <logic:notEmpty name = "listadoVin">
                                  <logic:iterate name="listadoVin" id="vinc"  >
                                 <tr>
                             <TD>
                             <input disabled="disabled" type = "text" id = "campo_<bean:write name="vinc" property="orden"/>"  name="campo_<bean:write name="vinc" property="orden"/>" size="25"  value = "<bean:write name="vinc" property="campo"/>" >
                               
                             
                             </TD>
                                <TD>
                                 <logic:notEmpty name="vinc" property="descorta" >
                                
                                <input  type = "text" maxlength="<%=Constantes.LONGITUD_CAMPO_VINCULACION_CORTA%>"  id = "corta_<bean:write name="vinc" property="orden"/>"  onkeypress="return validaCaractaer(event);" name="corta_<bean:write name="vinc" property="orden"/>" size="30"  value = "<bean:write name="vinc" property="descorta"/>"  >
                                 </logic:notEmpty>
                                        <logic:empty name="vinc" property="descorta" >
                                
                                <input  type = "text" maxlength="<%=Constantes.LONGITUD_CAMPO_VINCULACION_CORTA%>" id = "corta_<bean:write name="vinc" property="orden"/>"  onkeypress="return validaCaractaer(event);" name="corta_<bean:write name="vinc" property="orden"/>" size="30"  value = "<bean:write name="vinc" property="descorta"/>"  >
                                 </logic:empty>
                                </TD>
                                   <TD>
                                   <logic:notEmpty name="vinc" property="deslarga" >
                                
                                   <input  type = "text" maxlength="<%=Constantes.LONGITUD_CAMPO_VINCULACION_LARGA%>"  id = "larga_<bean:write name="vinc" property="orden"/>"  onkeypress="return validaCaractaer(event);" name="larga_<bean:write name="vinc" property="orden"/>" size="50" value = "<bean:write name="vinc" property="deslarga"/>"  >
                              </logic:notEmpty>
                                   <logic:empty name="vinc" property="deslarga" >
                                
                                <input  type = "text" maxlength="<%=Constantes.LONGITUD_CAMPO_VINCULACION_LARGA%>" id = "larga_<bean:write name="vinc" property="orden"/>"   onkeypress="return validaCaractaer(event);" name="larga_<bean:write name="vinc" property="orden"/>" size="50"    >
                                 </logic:empty>
                                   </TD>
                              </tr>
                                </logic:iterate>
                </logic:notEmpty>  
			
			
		</table>
		</td>
		</tr>
			
			
		</TABLE>
		
		
		</td></tr>
	</table>
</html:form>
</BODY>
</html:html>
