<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0060)http://nettuts.s3.amazonaws.com/001_Tabbed/site/jQuery.html# -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>

<HTML lang=en xml:lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Menu - <c:out value="${method}"/></title>
<META http-equiv=Content-Type content="text/html; charset=windows-1252">
<SCRIPT src="<%=request.getContextPath()%>/js/jquery.js" type=text/javascript></SCRIPT>
<SCRIPT src="<%=request.getContextPath()%>/js/customselect.js" type=text/javascript></SCRIPT>


<STYLE type=text/css>CODE {
	BORDER-RIGHT: #ccc 1px solid; PADDING-RIGHT: 10px; BORDER-TOP: #ccc 1px solid; DISPLAY: block; PADDING-LEFT: 21px; BACKGROUND: url(http://finalevillee.googlepages.com/Code_BG.gif) #f0f0f0 repeat-y left top; PADDING-BOTTOM: 10px; FONT: 96%/1.2em Trebuchet, Trebuchet MS, Arial, sans-serif; OVERFLOW: auto; BORDER-LEFT: #ccc 1px solid; WIDTH: 500px; COLOR: #000033; MAX-HEIGHT: 200px; PADDING-TOP: 10px; BORDER-BOTTOM: #ccc 1px solid
}
.selectborder {
	BORDER-BOTTOM: #ddd 1px dashed
}
.selectitem {
	MARGIN: 2px; CURSOR: default
}
.selecttext {
	WIDTH: 100%; TEXT-ALIGN: left
}
</STYLE>
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/base/basico.css" />
<script type="text/javascript">
function nuevo(){
        metodo='<c:out value="${method}"/>';
		var f=window.opener.document.forms[0];	
		var ft=document.forms[0],
		padre=ft.padre.value,	padre=padre.replace(/^(\s|\&nbsp;)*|(\s|\&nbsp;)*$/g,"");
		hijo=ft.hijo.value,	hijo=hijo.replace(/^(\s|\&nbsp;)*|(\s|\&nbsp;)*$/g,"");		
		link=ft.link.value; link=link.replace(/^(\s|\&nbsp;)*|(\s|\&nbsp;)*$/g,"");
		descripcion=ft.descripcion.value; descripcion=descripcion.replace(/^(\s|\&nbsp;)*|(\s|\&nbsp;)*$/g,"");
		codPerfil=ft.codPerfil.value; codPerfil=codPerfil .replace(/^(\s|\&nbsp;)*|(\s|\&nbsp;)*$/g,"");
			if(padre=='')
			{
			alert('Ingrese Padre  !!!')
			ft.padre.focus()
			return false;
			}				
			else
			{			
		//obj="permisoPerfilAction.do?method=nuevo&codPerfil="+codPerfil+"&tipoAcceso="+tipoAcceso+"&valorRCP="+valorRCP;			
		obj="menuAction.do?method="+metodo+"&padre="+padre+"&hijo="+hijo+"&link="+link+"&descripcion="+descripcion+"&codPerfil="+codPerfil;

		window.opener.getUrlInicio(obj);
		window.close();	
		}	
	}	
	function cargar()
	{
	var ft=document.forms[0].padre.focus()
	}
</script>

</HEAD>
<style type="text/css">td{font-size:9pt;}</style>
<body onload="cargar();">


<html:form action="/menuAction.do?method=mostrarNuevo">
	<input type="hidden" name="method" />		
		<table width="99%" height="80%" cellpadding="2" class="tabla_borde busqueda_letra" style="margin: auto;" cellspacing="0" id="permisoPerfil">
		<thead>
		<tr>
		<th colspan="5" align="left"></th>
		</tr>
		<tr>
		<th colspan="3" align="left">PERMISO PERFIL - <c:out value="${method}"/></th>
		</tr>
		<tr>
		<th colspan="5" align="left"></th>
		</tr>
		</thead>
		<tr class=pihue>
			<td width="1%" height="26"></td>
			<td width="26%">Padre: </td>
			<td width="37%">
			<c:if test="${menu==true}"> <c:out value="${menuForm.padre}" />  <html:hidden property="padre" /></c:if>
			<c:if test="${menu==false}"> <html:text property="padre" styleClass="TEXTINPUT" size="2"/> </c:if>
			</td> 
            
		</tr>
		<tr class=pihue>
			<td width="1%" height="26"></td>
			<td width="26%">Hijo:</td>
			<td width="37%"><html:text property="hijo"  styleClass="TEXTINPUT" size="2"/> </td>
		</tr>		
		<tr class=pihue>
			<td height="23">&nbsp;</td>
		    <td>Link:</td>
		    <td><html:text property="link"  styleClass="TEXTINPUT" size="60"/>            </td>
		</tr>
        <tr class=pihue>
			<td height="23">&nbsp;</td>
		    <td>Descripci&oacute;n:</td>
		    <td><html:text property="descripcion"  styleClass="TEXTINPUT"/>            </td>
		</tr>
        <tr class=pihue>
			<td height="23">&nbsp;</td>
		    <td>C&oacute;digo Perfil:</td>
		    <td><html:text property="codPerfil"  styleClass="TEXTINPUT" size="10"/>            </td>
		</tr>
		<tr class=pihue>
			<td>&nbsp;</td>
			<td colspan="2" align="center"> 
            <html:button property="guard"
				styleClass="boton" onclick="nuevo('')" value="Aceptar" /> <html:button
				property="guard" styleClass="boton"
				onclick="javascript: window.close();" value="Cancelar" /></td>
        </tr>
        <tr class=pihue>
			<td>&nbsp;</td>
			<td colspan="2" align="center"> 
           </td>
        </tr>
	</table>
</html:form>
</BODY>
</html>
