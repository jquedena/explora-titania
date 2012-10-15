
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
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
<TITLE>Carpetas Comerciales</TITLE>
<script type="text/javascript">
function metodo(){
	document.forms[0].method.value=document.forms[0].forward.value;
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
			RECURSOS HUMANOS 
		</td>
	</tr>
	<tr class="FondoAzul" >
		<td colspan="2" height="10px"></td>
	</tr>
</table>
<BODY>

<html:form action="/mantenimientoTablas" >
<html:hidden property="forward"/>
<input type="hidden" name="method"/>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td class="TituloPagServGen">Carpetas Comerciales</td>
		</tr>
	</table>
	<br>
	<table width="100%" border="1" cellpadding="0" cellspacing="0">
		<tr><td>
			<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="2%" class="FondoAzulSubTitulo"></td>
				<td width="98%" class="FondoAzulSubTitulo">DATOS DE PERMISO PERFIL</td>
			</tr>
			</TABLE>
		</td></tr>
		<tr class="FondoGris1"><td>
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="datTable">
			<tr>
				<td colspan="3">&nbsp;</td>
			</tr>
			<tr>
				<td width="2%"></td>
				<td width="12%">COD_PERFIL</td>
				<td width="86%"><html:text property="cod_perfil"/></td>
			</tr>
			<tr>
				<td></td>
				<td>TIPO_ACCESO</td>
				<td><html:text property="tipo_acceso"/></td>
			</tr>
			<tr>
				<td></td>
				<td>VALOR_RCP</td>
				<td><html:text property="valor_rcp"/></td>
			</tr>
			
			<tr><td colspan="3">&nbsp;</td></tr>
			<tr><td colspan="3" align="right"><html:button property="guard" styleClass="boton" onclick="metodo()" value="aceptar"/><html:button property="guard" styleClass="boton" onclick="javascript:history.go(-1);" value="cancelar"/></td></tr>
			<tr><td colspan="3">&nbsp;</td></tr>			
		</TABLE>
		</td></tr>
	</table>
</html:form>
</BODY>
</html:html>
