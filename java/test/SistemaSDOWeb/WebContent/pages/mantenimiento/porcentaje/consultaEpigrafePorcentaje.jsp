
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META HTTP-EQUIV='PRAGMA' CONTENT='NO-CACHE'>
<META HTTP-EQUIV='EXPIRES' CONTENT='0'>
<META http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
<script type="text/javascript"	src="<%=request.getContextPath()%>/js/script.js"></script>
<TITLE></TITLE>
</HEAD>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/validaTecla.js"></script>
<script type="text/javascript">


function validar(){
	var max = document.getElementById("intPorcMax").value;
	var min = document.getElementById("intPorcMin").value;
	
	if (isNaN(max)){
		alert("El porcentaje ingresado debe ser numérico");
		document.getElementById("intPorcMax").value = "";
		document.getElementById("intPorcMax").focus();
		return false;
	}
	if (isNaN(min)){
		alert("El porcentaje ingresado debe ser numérico");
		document.getElementById("intPorcMin").value = "";
		document.getElementById("intPorcMin").focus();
		return false;
	}
	if (max == "" ){
		alert("Debe ingresar el porcentaje Máximo");
		document.getElementById("intPorcMax").focus();
		return false;
	}
	
	if (min == "" ){
		alert("Debe ingresar el porcentaje Mínimo");
		document.getElementById("intPorcMin").focus();
		return false;
	}
	
	/*if (eval(max) > 100 ){
		alert("El porcentaje Máximo debe ser menor ó igual que 100");
		document.getElementById("intPorcMax").focus();
		return false;
	}
	if (eval(min) > 100 ){
		alert("El porcentaje Mínimo debe ser menor ó igual que 100");
		document.getElementById("intPorcMin").focus();
		return false;
	}*/
	
	
}

// porcentajeEpigrafeAction.do?method=inicio

</script>

<BODY>
<html:form action="porcentajeEpigrafeAction" onsubmit="return validar();" >
<html:hidden property="method" value="actualizarPorcertaje" />
<html:hidden property="strCodEpigrafe" />
<html:hidden property="strAnio" />

<table width="100%" align="center" cellspacing="0" cellpadding="0">
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
			<p class="titulo" >MANTENIMIENTO DE PORCENTAJES</p>
			<table border="0" >
				<tr align="center" >
					<td class="colorfila1"  >Año:</td>
					<td class="colorfila1" >${porcentajeEpigrafeForm.strAnio}</td>
				</tr>
				<tr align="center" >
					<td class="colorfila2"  >Nombre:</td>
					<td class="colorfila2" >${porcentajeEpigrafeForm.strNombreEpigrafe}</td>
				</tr>
				<tr align="center" >
					<td class="colorfila1"  >Porcentaje Máximo:</td>
					<td class="colorfila1" ><html:text property="intPorcMax" maxlength="3" onkeypress="return validKey(event, INT_PATTERN);"></html:text>%</td>
				</tr>
				<tr align="center" >
					<td class="colorfila2"  >Porcentaje Mínimo:</td>
					<td class="colorfila2" ><html:text property="intPorcMin" maxlength="3" onkeypress="return validKey(event, INT_PATTERN);"></html:text>%</td>
				</tr>
				<tr><td colspan="2" ><hr></td> </tr>
				<tr><td colspan="2" align="center"  ><html:submit value="Grabar" styleClass="botonnew" ></html:submit>&nbsp;&nbsp;<html:button property="" value="Cancelar" styleId="id_cancelar"  styleClass="botonnew" onclick="javascript:window.history.back();" ></html:button> </td> </tr>				
			</table>
		</td>
	</tr>
	
	
</table>

</html:form>
</BODY>
</html:html>
