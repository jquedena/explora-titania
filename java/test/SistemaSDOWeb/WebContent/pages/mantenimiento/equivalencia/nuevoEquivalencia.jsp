<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@ taglib prefix="fn" uri="/WEB-INF/fn.tld"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld" %>

<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet"	href="<%=request.getContextPath()%>/css/style.css"	type="text/css">
<TITLE></TITLE>
</HEAD>

<script>

<% String colorfila = "";
	int i = 0;
 %>

function envioDatos(){
	var form = document.forms[0];

	form.action="equivalAction.do?method=ingresarEquivalencia";
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
					<td width="200" class="textocentradoblanco">MANTENIMIENTO</td>
					<td><img src="<%=request.getContextPath()%>/images/esq_der.jpg"></td>
				</tr>						
			</table>
		</td>	
	</tr>
	<tr>
		<td style="border: 2px solid #264971;padding:20px;" valign="top" height="%" align="center">

		<!-- **** AQUI EL RESTO DE CÓDIGO DE LA PÁGINA-->
		
		<div id="pagina" style="overflow:auto;">
			<html:form action="/equivalAction" styleId="equivalForm">
				<input type="hidden" name="codCargoSel" >
				<input type="hidden" name="codPerfilSel" >
				<p class="titulo" >NUEVA EQUIVALENCIA</p>
				
				<!-- Border Table Build  ----------------------------->
				<table border="0" cellpadding="0" cellspacing="0" width="938">
					<tr>
						<td></td>
					</tr>
					<tr>
						<td></td>
					</tr>		
				</table>
			<table width="286" height="80" border="1" cellspacing="0" >

			  <tr class="cuerpoTabla">
			    <td width="57" align="center"><span class="Estilo2">Cargo</span></td>
			    <td width="60"><span class="Estilo2">
					<input type="text" name="txtcodCargo" value="<c:out value="${codigoCargo}"/>"/></span>
					</td>
		      </tr>
 			  <tr class="cuerpoTabla">
				<td width="57" align="center"><span class="Estilo2">Perfil</span></td>
				<td class="colorfila1">
					<html:select property="codPerfil" styleClass="combo">
					<c:if test="${listaAllPerfil != null}">
						<c:forEach var="lista" items="${listaAllPerfil}">
							<html:option value="${lista.codPerfil}"><c:out value="${lista.nomPerfil}" /></html:option>
						</c:forEach>
					</c:if>
					</html:select>
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
					<input type="button" name="grabo" value="Enviar" onClick="javascript:envioDatos()"  class="botonnew">
					<input type="button" name="imprime" value="Cancelar" onClick="Javascript:imprimir()"  class="botonnew">
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
				
				<!--FIN  Border Table Build ----------------------------->
			</html:form></div>
		
		<!-- **** FIN EL RESTO DE CÓDIGO DE LA PÁGINA-->
	
	
		</td>
	</tr>
</table>
</BODY>
</html:html>