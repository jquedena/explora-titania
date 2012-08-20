
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
 
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>  
<%@ taglib uri="/WEB-INF/displaytag-11.tld" prefix="display"%>
<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<META name="GENERATOR" content="IBM Software Development Platform">
<LINK rel="stylesheet" href='<c:out value="${pageContext.request.contextPath}"/>/theme/IIRGEspacio2.css' type="text/css">
<LINK rel="stylesheet" href='theme/IIRGEspacio2.css' type="text/css">
	
<TITLE>Carpetas Comerciales</TITLE>
<style type="text/css">
 
#contenido {
    position:absolute;
    left:35%;
    top:38%;
    width:35%;
    height:15%px;
    z-index:2;
}


</style>

<script language="javascript" type="text/javascript" src="<c:out value="${pageContext.request.contextPath}"/>/includes/datetimepicker.js"></script>
<script type="text/javascript" src="<c:out value="${pageContext.request.contextPath}"/>/includes/jquery-1.2.6.js"></script>
<script type="text/javascript">


$(function() {
    $("#contenido").hide();  
    if(document.forms[0].modificacion.value=='mostrarDIV'){
    		$("#Bbody input").css("visibility", "hidden");
	  		if ($("#contenido").is(":hidden")) {
				$("#contenido").show();
			}
	 }
	  	
	  	
	$('#boton').click(function(){
		$("#Bbody input").css("visibility", "visible");  
		$('#contenido').hide(); 
	});
 });

function eliminar(){

	if(document.getElementById('arregloEliminar')!=null){
	if(confirm("\u00BFDesea eliminar las fechas programadas?")){
		document.forms[0].action ='admCargaOtrasOfertasAction.do?method=eliminarFechasProgramadas&eliminar=true';       
    	document.forms[0].submit();  
    }
	}
}

function mensajero(){

	if(document.forms[0].mensaje.value=='NULL' ||
	   document.forms[0].mensaje.value=='null' ||
	   document.forms[0].mensaje.value==''){
	  }else{
	   
	  		alert(document.forms[0].mensaje.value);
 
	  }
}

function salir(){
	window.location = "pages/administracionCargaArchivos/iilc_adm_carga_variofer.jsp";
}

function grabarModificacion(){
	document.forms[0].action ='admCargaOtrasOfertasAction.do?method=actualizarProgramacion';       
    document.forms[0].submit();
}
   
</script>
</HEAD>

<BODY onload="mensajero();" >
<html:form action="/admCargaOtrasOfertasAction" >

<div id="Bbody" >
<table width="100%" border="0" cellspacing="0" cellpadding="0">
 
<tr>
	<td style="vertical-align:middle;" colspan="2" >
		<TABLE width="100%" align="center">
			<TR>
				<TD class="FondoAzul" width="25%">PROGRAMACIONES DE CARGA VARIOFER</TD>
			 
		</TR>
	</TABLE>
	</td>
</tr>
	</table>
	<br>
	<table width="100%" border="1" cellpadding="0" cellspacing="0">
		
		<tr class="FondoGris1"><td>
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="datTable">
			<tr>
				<td colspan="2" align="right" >
				
				</td>
			</tr>
			
			<tr>
				<td width="100%" align="left" >
						
						<display:table name="listaCargas"  id="lista" pagesize="20" summary="false" scope="session"  class="grilla"  >
							<display:column  class="cabecera"  >
							<input type="checkbox"  name="arregloEliminar" id="arregloEliminar"  value="${lista.id_registro}" >
							</display:column>
						
							<display:column class="cabecera" > 
								<html:link action="/admCargaOtrasOfertasAction.do?method=validarEstadoProceso&fecha=${lista.fecha_formateada}&id=${lista.id_registro}"   >
									${lista.fecha_formateada}
								</html:link>
							</display:column>
						</display:table>
						
 
								</td> 
							</tr>
 
							<tr>
								 <td  colspan="4" align="center"" >
								  	<html:button property="Fechas1"   onclick="eliminar();">
										Eliminar
									</html:button>
									<html:button property="Grabar1"  onclick="salir();">
										Salir
									</html:button>
								</td>
 
							</tr>
						</table>
						
						
				</td>
			</tr>
		</TABLE> 
		
</div>
			<table id="contenido" class="FondoGris1" border="1" >
			<tr>
			<td>
			 <table width="100%" border="0" cellpadding="0" cellspacing="0" >
			 <tr>
			 <td width="100%" class="FondoAzul" >
			 	Modificando programaci&oacute;n de carga <%=request.getAttribute("fecha_original") %>
			  </td>
			  <td  class="FondoAzul" >
			  	<div id="boton"  style="cursor:pointer;width:14%;">
			  		<img width="20" height="20" src="<c:out value="${pageContext.request.contextPath}"/>/images/icos/cerrar.png"  />
			  	</div>
			  </td>
			  </tr>
			  <tr>
			  <td colspan="2" align="center" >
			 <br>
			 <br>
			 <input type="hidden" id="id" name="id" value="<%=request.getAttribute("id")%>" />
			 <input type="hidden" id="mensaje" name="mensaje" value="<%=request.getAttribute("mensaje")%>" />
			<input type="hidden" id="modificacion" name="modificacion" value="<%=request.getAttribute("modificacion")%>" />
			<input type="hidden" id="fecha_original" name="fecha_original" value="<%=request.getAttribute("fecha_original")%>" />  
			 
			 Fecha / Hora
									 <input type="text" id="fecha" name="fecha" 
									 readonly="readonly"
									 value="<%=(request.getAttribute("fecha")!=null)?request.getAttribute("fecha"):"" %>"  
									   />
									   <a href="javascript:NewCal('fecha','ddmmyyyy',true,24)">
									   <img src="<c:out value="${pageContext.request.contextPath}"/>/images/cal.gif" width="16" height="16" border="0" >
									   </a>
			 <br/>
			 <br/>
			 </td>
			 </tr>
			 </table>
			 <center>
			<html:button property="grabar"   onclick="grabarModificacion();" >
					Grabar
			</html:button>
			<html:button property="cancelar"  onclick="document.getElementById('boton').click();">
					Cancelar
			</html:button>
			</center>
			</td></tr>
			</table> 
</html:form>
</BODY>
</html:html>