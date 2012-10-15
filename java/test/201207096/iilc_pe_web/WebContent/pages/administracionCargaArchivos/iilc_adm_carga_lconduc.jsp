
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%> 
<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<LINK rel="stylesheet" href='<c:out value="${pageContext.request.contextPath}"/>/theme/IIRGEspacio2.css' type="text/css">
<LINK rel="stylesheet" href='theme/IIRGEspacio2.css' type="text/css">
<TITLE>Carpetas Comerciales</TITLE>
<script type="text/javascript" src="<c:out value="${pageContext.request.contextPath}"/>/includes/datetimepicker.js"></script>
<script type="text/javascript" src="<c:out value="${pageContext.request.contextPath}"/>/includes/jquery-1.2.6.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/js/contexto.js"></script>
<script type="text/javascript">
	var contexto = obtenerContexto();

	function reloj(){
		$.post(contexto+"horaServidorAjax.do",   function(data) { 
		    $("#reloj").html(data);
		});
	}

	function fecha_programada(tipoVinculacion){
		document.forms[0].action = contexto+'admCargaConduccionAction.do?method=listarFechasProgramadas';       
	    document.forms[0].submit();  
	}

	function grabar(){
		document.forms[0].action = contexto+'admCargaConduccionAction.do?method=crearProgramacionCarga';       
	    document.forms[0].submit();  
	}

	function mensajero(){
		if(document.forms[0].mensaje.value=='NULL' ||
		   document.forms[0].mensaje.value=='null' ||
		   document.forms[0].mensaje.value==''){
		  }else{
		  	alert(document.forms[0].mensaje.value);
		  }
		  
		  if(document.forms[0].mensajeInformacion.value=='NULL' ||
		   document.forms[0].mensajeInformacion.value=='null' ||
		   document.forms[0].mensajeInformacion.value==''){
		    if(document.getElementById( "fecha")!=null){
		    	document.getElementById( "fecha").value='';
		    }
		   
		  }else{
		  	
				if(confirm(document.forms[0].mensajeInformacion.value)){
						document.forms[0].action = contexto+'admCargaConduccionAction.do?method=crearProgramacionCarga&sobreescritura=true';       
	    				document.forms[0].submit();  
				}
		  }
	}

	function salir(){
	 	window.close(); 
	}
</script>
 
</HEAD>
<BODY onload="mensajero();reloj();setInterval('reloj()',5000);" >
<html:form action="/admArchVincula" >
<input type="hidden" id="sobreescritura" value="" />
<input type="hidden" id="mensaje" name="mensaje" value="<%=request.getAttribute("mensaje")%>" />
<input type="hidden" id="tipo" name="tipo" value="<%=request.getAttribute("tipo")%>" />
<input type="hidden" id="mensajeInformacion" name="mensajeInformacion" value="<%=request.getAttribute("mensajeInformacion")%>" />
<table width="100%" border="0" cellspacing="0" cellpadding="0">
 
<tr>
	<td style="vertical-align:middle;" colspan="2" >
		<TABLE width="100%" align="center">
			<TR>
				<TD class="FondoAzul" width="25%">CARGA LISTADO CONDUCCI&Oacute;N</TD>
			
			
		</TR>
	</TABLE>
	</td>
</tr>

	</table>
		<div align="right" style="width: 100%">
	  <div id="reloj"></div>
</div>
	<table width="100%" border="1" cellpadding="0" cellspacing="0">
		
		<tr class="FondoGris1"> <td>
	
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="datTable">
			<tr><td colspan="3" align="right" >
			<html:button property="cancelar2" styleClass="boton" onclick="salir();">Salir</html:button></td></tr>
			 
			<tr>
				<td width="80%">
						
						<table width="100%" >
							<tr>
								<td align="left" colspan="2"  >
 									Fecha / Hora
									 <input type="text" id="fecha" name="fecha" 
									 readonly="readonly"
									 value="<%=(request.getAttribute("fecha")!=null)?request.getAttribute("fecha"):"" %>"  
									   />
									   <a href="javascript:NewCal('fecha','ddmmyyyy',true,24)">
									   <img src="<c:out value="${pageContext.request.contextPath}"/>/images/cal.gif" width="16" height="16" border="0" >
									   </a>
									   &nbsp&nbsp									
									<html:button property="Fechas1"   onclick="fecha_programada('V');">
										Fechas programadas
									</html:button>
									<html:button property="Grabar1"  onclick="grabar('V');">
										Grabar
									</html:button>
								</td>
							</tr> 
							<tr>
								<td align="left" colspan="2"  >

								</td>
							</tr>
						 <tr>
								<td align="left" colspan="2"  >
								<br/>
								<br/> 
 									<b style="font-size: 90%;color:green;">Se recomienda realizar la carga de 7 pm a 9 am</b>
								</td>
							</tr>
							
						</table>
				</td> 
				<td width="20%">
				
				</td>
			</tr>
			<tr height="3" style="background-color: black;" >
				<td  colspan="3" >
				
				</td>
			</tr>
			
		</TABLE>
		</td></tr>
	</table>
</html:form>
</BODY>
</html:html>
