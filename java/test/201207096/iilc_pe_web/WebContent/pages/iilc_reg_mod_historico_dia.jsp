
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<html:html>
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
		window.location = contexto+"pages/iilc_listado_historico.jsp";
	}

	function grabar(){
	   	document.forms[0].action = contexto+'crearHistoricoDia.do';       
	    document.forms[0].submit();  
   }
</script>
</HEAD>
<table width="100%" cellpadding="0" cellspacing="0" >
	<tr class="FondoGris2">
		<td>
			<img src="<c:out value="${pageContext.request.contextPath}"/>/images/dibujo.png" border="0" alt="">
		</td>
		<td align="right" style="vertical-align:middle; font-size: 16px; color: #2d4492; font-weight: bold; text-transform: uppercase">
			ADMINISTRADOR
		</td>
	</tr>

</table>
<BODY onunload="cargar_al_cerrar();" >
<html:form action="/listadoHistoricoDia" >
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
<!-- FILTROS -->
<tr>
	<td style="vertical-align:middle;" colspan="2" >
		<TABLE width="100%" align="center">
			<TR>
				<TD class="FondoAzul" >ADMINISTRADOR CABECERA REPORTE HISTORICO DE SEGUIMIENTO DIA</TD>
			
			
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
								<bean:write name="mensaje"   />
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
				<td class="LCtd" width="300px">DESCRIPCION CORTA</td>
				<td class="LCtd" width="400px">DESCRIPCION LARGA</td>
			</tr>
			     <logic:notEmpty name = "listadoVin4">
                                  <logic:iterate name="listadoVin4" id="vinc"  >
                                 <tr>
                             <TD>
                             <input disabled="disabled" type = "text" id = "campo_<bean:write name="vinc" property="orden"/>"  name="campo_<bean:write name="vinc" property="orden"/>" size="25"  value = "<bean:write name="vinc" property="campo"/>" >
                               
                             
                             </TD>
                                <TD>
                                 <logic:notEmpty name="vinc" property="descorta" >
                                
                                <input  type = "text" maxlength="30"  id = "corta_<bean:write name="vinc" property="orden"/>"  name="corta_<bean:write name="vinc" property="orden"/>" size="30"  value = "<bean:write name="vinc" property="descorta"/>"  >
                                 </logic:notEmpty>
                                        <logic:empty name="vinc" property="descorta" >
                                
                                <input  type = "text" maxlength="30" id = "corta_<bean:write name="vinc" property="orden"/>"  name="corta_<bean:write name="vinc" property="orden"/>" size="30"  value = "<bean:write name="vinc" property="descorta"/>"  >
                                 </logic:empty>
                                </TD>
                                   <TD>
                                   <logic:notEmpty name="vinc" property="deslarga" >
                                
                                   <input  type = "text" maxlength="100"  id = "larga_<bean:write name="vinc" property="orden"/>" name="larga_<bean:write name="vinc" property="orden"/>" size="50" value = "<bean:write name="vinc" property="deslarga"/>"  >
                              </logic:notEmpty>
                                   <logic:empty name="vinc" property="deslarga" >
                                
                                <input  type = "text" maxlength="100" id = "larga_<bean:write name="vinc" property="orden"/>"  name="larga_<bean:write name="vinc" property="orden"/>" size="50"    >
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
