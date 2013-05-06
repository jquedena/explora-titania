<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@page import="java.util.Vector"%>
<%@page import="com.grupobbva.bc.per.tele.sdo.serializable.ListabusAllTerritorio"%>
<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
<TITLE></TITLE>
<%Vector d = (Vector)request.getAttribute("listaTerritorios");
String codOficina = (String)request.getAttribute("codOficina");
String nomOficina = (String)request.getAttribute("nomOficina");
ListabusAllTerritorio bean=null;
%>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/validaTecla.js"></script>
<script language="javascript">

function enviar(){

var ValorCod = document.forms.cod.value;
var ValorNom = document.forms.nom.value;
var ValorCodTer = document.forms.codterritorio.value;

if(!validar()){
	return;
}

document.forms.codTerritorio.value=ValorCodTer;
document.forms.codOficina.value=ValorCod;
document.forms.nomOficina.value=ValorNom;
document.forms.action="mantenimientoOficinaAction.do?method=grabarOficina";
document.forms.submit();

}

function validar(){
	var validosNum = "0123456789";
	var validosTxt = "abcdefghijklmnñopqrstuvwxyz ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
	var valorCod = document.forms.cod.value;
	var valorNom = document.forms.nom.value;
	var valorCodTer = document.forms.codterritorio.value;
	
	if(isNaN(valorCod) || valorCod.length!=4){
		alert("El código debe ser numérico de 4 dígitos");
		document.forms.cod.focus();
		return false;
	}
	if(valorNom.length<1){
		alert("Ingrese un nombre de oficina");
		document.forms.nom.focus();
		return false;
	}
	
	return true;
}

</script>
</HEAD>

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
<form  method="post" name="forms">
<input type="hidden" name="codTerritorio" >
<input type="hidden" name="codOficina" >
<input type="hidden" name="nomOficina" >
<div align="center"><strong>NUEVA OFICINA</strong></div><br />
<table cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td class="colorfila1" width="60">Codigo:</td>
    <td class="colorfila1"><input name="cod" type="text" value="<%=codOficina %>" maxlength="4" class="cajatexto" onKeyPress="return validKey(this, event, INT_PATTERN);"/> </td>
  </tr>
  <tr>
    <td class="colorfila2">Nombre:</td>
    <td class="colorfila2"><input name="nom" type="text" value="<%=nomOficina %>" maxlength="99" class="cajatexto" />
</td>
  </tr>
  <tr>
<td class="colorfila1">Territorio:</td>
    <td class="colorfila1">
	<select name="codterritorio">
		<%if(d!=null)
			{	String colorfila = "";
				for(int i=0;i<d.size();i++){
				bean = (ListabusAllTerritorio)d.elementAt(i);    

				if (i%2 != 0)
					colorfila = "colorfila1";
				else
					colorfila = "colorfila2";
				%>
    <option value="<%=bean.getCodTerritorio() %>"><%=bean.getNomTerritorio() %></option>
		<% 
		  } 
			}%>
    </select>
	</td>
  </tr>
  <tr >
    <td colspan="2">
    <table align="center"><tr>
    <td><input type="button" name="Aceptar" value="Aceptar" onClick="enviar();" class="botonnew"></td>
    <td width="20">&nbsp;</td>
    <td><input type="button" name="Cancelar" value="Cancelar" onClick="history.back()" class="botonnew"></td>
    </tr></table>
    </td>
  </tr>
</table>
</form>
		</td>
	</tr>
</table>
</BODY>
</html:html>
