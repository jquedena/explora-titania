
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="java.util.Vector"%>
<%@page import="com.grupobbva.bc.per.tele.sdo.serializable.ListabusAllTerritorio"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@page import="com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil"%><html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
<TITLE></TITLE>
<%
Vector d = (Vector)request.getAttribute("listaTerritorios");
String codOficina=(String)request.getAttribute("codOficina");
String nomOficina=(String)request.getAttribute("nomOficina");
String codTerritorio=(String)request.getAttribute("codTerritorio");
String codTerritorioACT=(String)request.getAttribute("codTerritorio");

ListabusAllTerritorio bean = null;
%>
<script language="javascript">
function SoloLetras()
{   if(window.event.keyCode!=13)
   {
      var Tecla;
      Tecla = String.fromCharCode(window.event.keyCode);
      if ( !( (Tecla>="A" && Tecla<="Z")||(Tecla>="a" && Tecla<="z") || (Tecla>="0" && Tecla<="9") ||
              (Tecla=="?") || (Tecla=="?") || (Tecla=="?") || (Tecla=="?") || (Tecla=="?") ||
              (Tecla=="?") || (Tecla=="?") || (Tecla=="?") || (Tecla=="?") || (Tecla=="?") ||
              (Tecla==" ") || (Tecla=="?") || (Tecla=="?") ) )
     {
         window.event.keyCode = 0;
      }
   }	
   
}
function enviar(codTerritorioActual){
var ValorCod = document.oficinaForm.txtCodOficina.value;
var ValorNom = document.oficinaForm.txtNomOficina.value;
var codTerritorio = document.oficinaForm.codterritorio.value;
var codTerritorioACT = codTerritorioActual;
document.oficinaForm.codOficina.value=ValorCod;
document.oficinaForm.nomOficina.value=ValorNom;
document.oficinaForm.codTerritorioNUE.value=codTerritorio;
document.oficinaForm.codTerritorioACT.value=codTerritorioACT;
document.oficinaForm.action="mantenimientoOficinaAction.do?method=editar";
document.oficinaForm.submit();
}

function desHabilitar() {
	document.oficinaForm.codterritorio.disabled = true;
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
<html:form action="mantenimientoOficinaAction.do?method=editar" >
<input type="hidden" name="codOficina" >
<input type="hidden" name="nomOficina" >
<input type="hidden" name="codTerritorioNUE" >
<input type="hidden" name="codTerritorioACT" >

<div align="center"><strong>EDITAR OFICINA</strong></div><br />

<table cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td class="colorfila1" width="60">Codigo:</td>
    <td class="colorfila1"><input name="txtCodOficina" type="text" value="<%=codOficina %>" maxlength="4"  disabled="disabled" class="cajatexto"/>  </td>
  </tr>
  <tr>
    <td class="colorfila2">Nombre:</td>
    <td class="colorfila2"><input name="txtNomOficina" type="text" value="<%=nomOficina %>" maxlength="99" class="cajatexto" /></td>
  </tr>
  <tr>
    <td colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td class="colorfila1">Territorio:</td>
    <td>
	<select name="codterritorio">
			<% 	
			if(d!=null)
			{	String colorfila = "";
				for(int i=0;i<d.size();i++){
				bean = (ListabusAllTerritorio)d.elementAt(i);    

				if (i%2 != 0)
					colorfila = "colorfila1";
				else
					colorfila = "colorfila2";
				%>
    <option value="<%=bean.getCodTerritorio() %>"<%if(bean.getCodTerritorio().equals(codTerritorio)){%>selected="selected"<%} %>><%=bean.getNomTerritorio() %></option>
		<% 
		  } 
			}%>
    </select>
	</td>
  </tr>
  <tr>
    <td class="colorfila2">Estado:</td>
    <td class="colorfila2">	
	<html:select property="estado">
		<html:option value="<%=ConstantesUtil.OFICINA_ESTADO_ACTIVO %>">Activo</html:option>
		<html:option value="<%=ConstantesUtil.OFICINA_ESTADO_INACTIVO %>">Inactivo</html:option>
	</html:select>	
	</td>
  </tr>
  <tr>
    <td colspan="2">&nbsp;</td>
  </tr>
<tr>
    <td colspan="2">
    <table align="center"><tr>
    <td><input type="button" name="Aceptar" value="Aceptar" onclick="enviar('<%=codTerritorioACT %>');" class="botonnew"></td>
    <td><input type="button" name="Cancelar" value="Cancelar" onclick="history.back()" class="botonnew"></td>
    </tr></table>
    </td>
</tr>
</table>
</html:form>
		</td>
	</tr>
</table>
</BODY>
</html:html>