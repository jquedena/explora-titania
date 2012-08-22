
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@page import="java.util.Vector"%>
<%@page import="com.grupobbva.bc.per.tele.sdo.serializable.ListabusAllTerritorio"%>
<%@page import="com.grupobbva.bc.per.tele.sdo.serializable.Oficina"%>

<%@page import="com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil"%><html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
<TITLE></TITLE>
<%Vector d = (Vector)request.getAttribute("listaTerritorios");
Vector e = (Vector)request.getAttribute("listaOficinas");
String codTerritorio=(String)request.getAttribute("codTerritorio");
String perfil=(String)request.getAttribute("perfil");
ListabusAllTerritorio bean = null;
Oficina bean1 = null;
%>
<script language="javascript">

function editarOficina(codOficina, nomOficina, codTerritorio,estado){
var codOficina=codOficina;
var nomOficina=nomOficina;
var codTerritorio=codTerritorio;
document.forms.codOficina.value=codOficina;
document.forms.nomOficina.value=nomOficina;
document.forms.codTerritorio.value=codTerritorio;
document.forms.estado.value=estado;
document.forms.action="mantenimientoOficinaAction.do?method=mostrarEditar";
document.forms.submit();
}

function eliminar()	{	
cadena="";
m = 1;			
	if(document.forms.caja)	{
		if(document.forms.caja.length)	{
			for (i=0; i<document.forms.caja.length; i++) {
				if(document.forms.caja[i].checked){	
					if(m==1)	cadena = cadena + document.forms.caja[i].value;
					else		cadena = cadena + ";" + document.forms.caja[i].value;						
					m++;
				}				
			}
		}
		else	{
			if(document.forms.caja.checked)	{
				cadena = document.forms.caja.value;
				m++;
			}
		}			
		if(m==1)	{
			alert("Debe de Seleccionar por lo menos una Oficina");
			return false;
		}		
		if (confirm("\u00BFDesea eliminar las Oficinas seleccionadas?")==false)
		return false;

		document.forms.codigos.value=cadena;
		document.forms.action="mantenimientoOficinaAction.do?method=eliminar";
		
		document.forms.submit();
	}	
}

function cargaOficinas(){
var codTerritorio=document.forms.codterritorio.value;

document.forms.codTerritorio.value=codTerritorio;
document.forms.action="mantenimientoOficinaAction.do?method=mostrar";
document.forms.submit();

}

function nuevo(){

document.forms.action="mantenimientoOficinaAction.do?method=nuevo";
document.forms.submit();
}

function seleccionar_todos()	{
		if(document.forms.caja)	{
		  if(document.forms.caja.length)	{
			  for (i=0; i<document.forms.caja.length; i++) {
			  	if (document.forms.todos.checked==false)	document.forms.caja[i].checked=false;
			  	else	document.forms.caja[i].checked=true;
			  }
		  }
		  else  {
		  	if(document.forms.todos.checked==false)	document.forms.caja.checked=false
		  	else	document.forms.caja.checked=true
		  }
	  	}	
}

var mensaje_error = '<%=session.getAttribute("error_Territorio")%>';
<% session.setAttribute("error_Territorio", null); %>

window.onload=function(){
	if (mensaje_error != 'null') {
		alert(mensaje_error);
	}
}
</script>

</HEAD>

<BODY>
<table align="center" width="100%" cellspacing="0" cellpadding="0">
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
<input type="hidden" name="estado" >
<input type="hidden" name="codigos" >
<p class="titulo" >MANTENIMIENTO DE OFICINAS</p>
<% if(request.getAttribute("msg")!=null){ %>
<div class="msgError"><%=(String)request.getAttribute("msg") %></div>
<br />
<% } %>

<table cellspacing="0" cellpadding="0" align="center">

  <tr height="20">
    <td height="20">Territorio:&nbsp;</td>
    <td>
	<select name="codterritorio" onChange="cargaOficinas();">
    <option <%if(codTerritorio==null){%>selected="selected"<%}%>>Seleccione</option>
		<%if(d!=null)
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
</table>

<p>&nbsp;</p>
<%if(e!=null){ %>

<table cellspacing="0" cellpadding="0" align="center">  
  <tr>
    <td width="100" align="center" class="celda1cabecera">Codigo</td>
    <td align="center" class="celda1cabecera">Nombre</td>
    <td width="70" align="center" class="celda1cabecera">Estado</td>
    <td width="70" align="center" class="celda1cabecera">Editar</td>    
    <td width="80" align="center" class="celda1cabecera"><INPUT TYPE="checkbox" name="todos" onClick="seleccionar_todos();"></td>
  </tr>
			<% 	
			if(e!=null)
			{	String colorfila = "";
				for(int i=0;i<e.size();i++){
				bean1 = (Oficina)e.elementAt(i);    
				if (i%2 != 0)
					colorfila = "colorfila1";
				else
					colorfila = "colorfila2";
				%>
  <tr height="20">
    <td height="20" align="center" class="<%=colorfila %>"><%=bean1.getCodOfic() %></td>
    <td class="<%=colorfila %>"><%=bean1.getCodNomOficina() %></td>
    <td class="<%=colorfila %>"><%=ConstantesUtil.OFICINA_ESTADO_ACTIVO.equals(bean1.getEstado())?"ACTIVO":"INACTIVO" %></td>
    <td align="center" class="<%=colorfila %>">
<a href="javascript:editarOficina('<%=bean1.getCodOfic()%>','<%=bean1.getCodNomOficina() %>','<%=codTerritorio %>','<%=bean1.getEstado() %>')"><IMG border="0" src="<%=request.getContextPath()%>/images/editar.png" width="18"
						height="18"></a>

	</td>
    <td align="center" class="<%=colorfila %>"><input type="checkbox" name="caja" value="<%=bean1.getCodOfic() %>"></td>
  </tr>
		<% 
		  } 
			}%>
</table>
<%} %>
<%if(perfil.equals("ADM")){ %>
<table align="center">
		  <tr>
		    <td colspan="5" align="center" >
				<table><tr>
				<td><input type="button" name="Nuevo" onClick="nuevo();" value="Nuevo" class="botonnew"></td>
				<td><input type="button" name="Eliminar" onClick="eliminar();" value="Eliminar" class="botonnew"></td>
		  </tr>
</table>
</td></tr></table>
<%} %>
</form>
		</td>
	</tr>
</table>
</BODY>
</html:html>