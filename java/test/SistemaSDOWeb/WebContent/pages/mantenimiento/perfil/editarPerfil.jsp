<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@ taglib prefix="fn" uri="/WEB-INF/fn.tld"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld" %>

<html:html>
<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet"	href="<%=request.getContextPath()%>/css/style.css"	type="text/css">
</head>
<script>
<%
	String colorfila = "";
	int i = 0;
%>

function envioDatos(cod,nom){
	var form = document.forms[0];
	form.action="perfilAction.do?method=modificarPerfil";
	form.submit();
}

function regresar(){
	var form = document.forms[0];

	form.action="perfilAction.do?method=inicioPerfil";
	form.submit();
}
</script>
<body>
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
		<td style="border: 2px solid #264971; padding:20px;" valign="top" height="%" align="center">
			<html:form action="/perfilAction" styleId="perfilForm">
				<p class="titulo">EDITAR PERFIL</p>
				<table width="286" border="0" cellspacing="0" cellpadding="0">
				<tr class="cuerpoTabla">
					<td width="40%" align="center"><span class="Estilo2">C&oacute;digo</span></td>
					<td width="60&">
						<input type="text" name="txtcodPerfil" maxlength="3" value="<c:out value="${codigoPerfil}"/>" readonly />
					</td>
				</tr>
				<tr class="cuerpoTabla">
					<td align="center"><span class="Estilo2">C&oacute;digo a mostrar</span></td>
					<td>
						<input type="text" name="txtperfil" maxlength="3" value="<c:out value="${perfil}"/>"/>
					</td>
				</tr>
				<tr class="cuerpoTabla">
					<td align="center"><span class="Estilo2">Nombre</span></td>
					<td>
						<input type="text" name="txtnomPerfil" value="<c:out value="${nombrePerfil}"/>"/>
					</td>
				</tr>
				</table>
				<table align="center">
				<tr>
					<td>
						<input type="button" name="grabo" value="Enviar" onClick="javascript:envioDatos()" />
						<input type="button" name="cancelar" value="Cancelar" onClick="javascript:regresar()" />
					</td>
				</tr>
				</table>
			</html:form>
		</td>
	</tr>
</table>
</body>
</html:html>