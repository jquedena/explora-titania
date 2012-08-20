
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%> 

<%@page import="com.grupobbva.bc.per.tel.iilc.common.Constantes"%><html:html>
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

function fecha_programada(tipo){
	document.forms[0].action = contexto+'admCargaOfertasClientesAction.do?method=listarFechasProgramadas&tipo='+tipo;       
    document.forms[0].submit();  
    
}

function intervalos(){
	idEstado = 0;
	$.post(contexto+"admCargaOfertasClientesAction.do?method=estadoCarga&tipo=<%=Constantes.CODIGO_ALMACCC%>", function(data) { 
		idEstado = data;
		// console.log(idEstado);
		if(idEstado != 2) {
			document.forms[0].action = contexto+'admCargaOfertasClientesAction.do?method=listarIntervalos';       
			document.forms[0].submit();
		} else {
			alert("Carga en proceso.");
		}
	});
}

function grabar(tipo){
	document.forms[0].action = contexto+'admCargaOfertasClientesAction.do?method=crearProgramacionCarga&tipo='+tipo;       
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
					document.forms[0].action = contexto+'admCargaOfertasClientesAction.do?method=crearProgramacionCarga&sobreescritura=true';       
    				document.forms[0].submit();  
			}
	  }
}

function salir(){
  	window.location = contexto+"pages/iilc_listado_administrador.jsp";
}
   
</script>
 
</HEAD>
<BODY onload="mensajero();reloj();setInterval('reloj()',5000);" >
<html:form action="/admCargaOfertasClientesAction" >
<input type="hidden" id="sobreescritura" value="" />
<input type="hidden" id="mensaje" name="mensaje" value="<%=request.getAttribute("mensaje")%>" />
<input type="hidden" id="tipo" name="tipo" value="<%=request.getAttribute("tipo")%>" />
<input type="hidden" id="mensajeInformacion" name="mensajeInformacion" value="<%=request.getAttribute("mensajeInformacion")%>" />
<table width="100%" border="0" cellspacing="0" cellpadding="0">
 
 
<tr>
	<td style="vertical-align:middle;" colspan="2" >
		<TABLE width="100%" align="center">
			<TR>
				<TD class="FondoAzul" width="25%">ADMINISTRACI&Oacute;N DE CARGA DE LOS ARCHIVOS OFERTAS CLIENTES</TD>
			
			
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
				<td width="30%">
						ALMCCC
						<table width="100%" >
							<tr>
								<td align="left" colspan="2"  >
 									Fecha / Hora
									 <input type="text" id="fecha_12" name="fecha_12" 
									 readonly="readonly"
									 value="<%=(request.getAttribute("fecha_12")!=null)?request.getAttribute("fecha_12"):"" %>"  
									   />
									   <a href="javascript:NewCal('fecha_12','ddmmyyyy',true,24)">
									   <img src="<c:out value="${pageContext.request.contextPath}"/>/images/cal.gif" width="16" height="16" border="0" >
									   </a>
									
								</td>
							</tr> 
							<tr>
								<td align="left" colspan="2"  >
									<html:button property="Fechas1"   onclick="fecha_programada('12');">
										Fechas programadas
									</html:button>
									<html:button property="Grabar1"  onclick="grabar('12');">
										Grabar
									</html:button>
								</td>
							</tr>
						 <tr>
								<td align="left" colspan="2"  >
								<br/>
								<br/>
									<b style="font-size: 90%;color:red;">"Se recomienda realizar la programaci&oacute;n de las cargas de ofertas con 60 minutos de diferencia"</b>
								<br/>
 									<b style="font-size: 90%;color:green;">Se recomienda realizar la carga de 7 pm a 9 am</b>
								</td>
							</tr>
							
						</table>
				</td> 
				<td width="70%">
					<iframe width="100%"  src="/iilc_pe_web/admCargaOfertasClientesAction.do?method=visualizarEstadoCarga&tipo=12"  frameborder="0"  style="height:150px;background: transparent;"  ></iframe>
				</td>
			</tr>
			<tr height="3" style="background-color: black;" >
				<td  colspan="3" >
				
				</td>
			</tr>
			 <tr>
				<td width="30%">
						ESTM
						<table width="100%" >
							<tr>
								<td align="left" colspan="2"  >
 									Fecha / Hora
									 <input type="text" id="fecha_13" name="fecha_13" 
									 readonly="readonly"
									 value="<%=(request.getAttribute("fecha_13")!=null)?request.getAttribute("fecha_13"):"" %>"  
									   />
									   <a href="javascript:NewCal('fecha_13','ddmmyyyy',true,24)">
									   <img src="<c:out value="${pageContext.request.contextPath}"/>/images/cal.gif" width="16" height="16" border="0" >
									   </a>
									
								</td>
							</tr> 
							<tr>
								<td align="left" colspan="2"  >
									<html:button property="Fechas13"   onclick="fecha_programada('13');">
										Fechas programadas
									</html:button>
									<html:button property="Grabar13"  onclick="grabar('13');">
										Grabar
									</html:button>
								</td>
							</tr>
						 <tr>
								<td align="left" colspan="2"  >
								<br/>
								<br/>
									<b style="font-size: 90%;color:red;">"Se recomienda realizar la programaci&oacute;n de las cargas de ofertas con 60 minutos de diferencia"</b>
								<br/>
 									<b style="font-size: 90%;color:green;">Se recomienda realizar la carga de 7 pm a 9 am</b>
								</td>
							</tr>
							
						</table>
				</td> 
				<td width="70%" align="right" >
					<iframe width="100%" src="/iilc_pe_web/admCargaOfertasClientesAction.do?method=visualizarEstadoCarga&tipo=13"  frameborder="0"  style="height:150px;background: transparent;"  ></iframe>
					<html:button styleId="intervalos14" property="intervalos14" styleClass="boton" onclick="intervalos()">
						Intervalos
					</html:button>
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
