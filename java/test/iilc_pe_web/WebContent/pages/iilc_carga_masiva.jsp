
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript" src='<c:out value="${pageContext.request.contextPath}"/>/includes/InnerDiv.js'></script>
<script type="text/javascript" src='<c:out value="${pageContext.request.contextPath}"/>/includes/funciones.js'></script>
<LINK rel="stylesheet" type="text/css" href='<c:out value="${pageContext.request.contextPath}"/>/theme/IIRGEspacio2.css'/>
<LINK rel="stylesheet" type="text/css" href='<c:out value="${pageContext.request.contextPath}"/>/theme/stylish.css'/>
<LINK rel="stylesheet" type="text/css" href='<c:out value="${pageContext.request.contextPath}"/>/theme/displaytag.css'/>
	
<TITLE>Carpetas Comerciales</TITLE>

</HEAD>
<script type="text/javascript">
function metodo(){
	if (document.forms[0].archivo.value != null){
		document.forms[0].method.value = 'carga';
		confirmarCargaBatch('iilc_espera.jsp')
	}
}
</script>
<table width="100%" cellpadding="0" cellspacing="0" >
	<tr class="FondoGris2">
		<td>
			<img src="<c:out value="${pageContext.request.contextPath}"/>/images/dibujo.png" border="0" alt="">
		</td>
		<td align="right" style="vertical-align:middle; font-size: 16px; color: #2d4492; font-weight: bold; text-transform: uppercase">
			RECURSOS HUMANOS 
		</td>
	</tr>
	<tr class="FondoAzul" >
		<td colspan="2" height="10px"></td>
	</tr>
</table>
<BODY>
<html:form action="/cargaMasiva" enctype="multipart/form-data" method="post">
<input type="hidden" name="method"/>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td class="TituloPagServGen">Carpetas Comerciales</td>
		</tr>
	</table>
	<br>
	<table width="100%" border="2" align="center">
		<tr><td>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr><td colspan="2">&nbsp;</td></tr>
				<tr>
					<td>Tipo:</td>
					<td>
						<html:select property="tipo">
							<html:option value="C">Clientes</html:option>
							<html:option value="A">Areas</html:option>
							<html:option value="T">Territorio/Oficina</html:option>
							<html:option value="G">Gestor</html:option>	
							<html:option value="E">Empresa</html:option>							
						</html:select>
					</td>
				</tr>
				<tr>
					<td>Archivo:</td>
					<td><html:file property="archivo"  /></td>
				</tr>
				<tr>
					<td colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2" >
						<div align="right">
							<html:button styleClass="boton" property="aceptar" onclick="metodo();">Aceptar</html:button>
							<html:button styleClass="boton" property="cancelar" onclick="window.close();">Salir</html:button>
						</div>	
					</td>
				</tr>
				<tr>
					<td colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2" class="Titulo2AzulClaro">Mensaje de la operaci&oacute;n:
					</td>
				</tr>
				<tr>
					<td colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2">
					<html:textarea property="mensaje" readonly="true" rows="6"></html:textarea>
					</td>
				</tr>
			</table>
		</td></tr>
	</table>
</html:form>

</BODY>
</html:html>
