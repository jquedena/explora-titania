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

function regresar(){
	var form = document.forms[0];
	
	form.action="permisoPerfilAction.do?method=inicioPermisoPerfil";
	form.submit();
}

</script>
<BODY>
<html:form action="/permisoPerfilAction">

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
				<table width="670" height="160" border="0" cellspacing="0" >	
				  <tr>
				    <td width="670" align="center">
				    	<span class="Estilo2">La operación se realizo en forma satisfactoria.</span>
				    <BR>
				    <BR>
					<BR>
					<INPUT type="button" name="btnRegresar" value="Regresar"  onclick="javascript:regresar();" class="botonnew">
					</td>				   
			      </tr>							  			  
				</table>
				
				<!--FIN  Border Table Build -----------------------------></div>
		
		<!-- **** FIN EL RESTO DE CÓDIGO DE LA PÁGINA-->
	
	
		</td>
	</tr>
</table>
</html:form> 
</BODY>
</html:html>