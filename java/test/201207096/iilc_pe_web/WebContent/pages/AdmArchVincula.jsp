<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>

<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<LINK rel="stylesheet" href='<c:out value="${pageContext.request.contextPath}"/>/theme/IIRGEspacio2.css' type="text/css">
<LINK rel="stylesheet" href='theme/IIRGEspacio2.css' type="text/css">
	
<TITLE>Carpetas Comerciales</TITLE>

<script language="javascript" type="text/javascript" src="<c:out value="${pageContext.request.contextPath}"/>/includes/datetimepicker.js">
//Date Time Picker script- by TengYong Ng of http://www.rainforestnet.com
//Script featured on JavaScript Kit (http://www.javascriptkit.com)
//For this script, visit http://www.javascriptkit.com 
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/js/contexto.js"></script>
<script type="text/javascript">
var contexto = obtenerContexto();

function fecha_programada(tipoVinculacion){
	document.forms[0].action = contexto+'admElimArchVincula.do?tipo='+tipoVinculacion;       
	document.forms[0].submit();    
}

function grabar(tipoVinculacion){
	document.forms[0].action = contexto+'admArchVincula.do?tipo='+tipoVinculacion;       
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
			if(document.getElementById( "fecha_"+document.forms[0].tipo.value)!=null){
				document.getElementById( "fecha_"+document.forms[0].tipo.value).value='';
			}
	}else{  	
		if(confirm(document.forms[0].mensajeInformacion.value)){
			document.forms[0].action = contexto+'admArchVincula.do?sobreescritura=true&tipo='+document.forms[0].tipo.value;       
			document.forms[0].submit();  
		}
	}
}

function salir(){
	window.location = contexto+"pages/iilc_listado_administrador.jsp";
}   
</script>
 
</HEAD>
<BODY onload="mensajero();" >
<html:form action="/admArchVincula" >
<input type="hidden" id="sobreescritura" value="" />
<input type="hidden" id="mensaje" name="mensaje" value="<%=request.getAttribute("mensaje")%>" />
<input type="hidden" id="tipo" name="tipo" value="<%=request.getAttribute("tipo")%>" />
<input type="hidden" id="mensajeInformacion" name="mensajeInformacion" value="<%=request.getAttribute("mensajeInformacion")%>" />
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr>
<td style="vertical-align:middle;" colspan="2" >
	<TABLE width="100%" align="center">
	<TR><TD class="FondoAzul" width="25%">ADMINISTRADOR CARGA VINCULACI&Oacute;N</TD></TR>
	</TABLE>
</td>
</tr>
</table>
<br>

	<table width="100%" border="1" cellpadding="0" cellspacing="0">
		
		<tr class="FondoGris1"><td>
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="datTable">
			<tr><td colspan="3" align="right" >
			<html:button property="cancelar2" styleClass="boton" onclick="salir();">Salir</html:button></td></tr>
			
			<tr>
				<td width="20%">
						
						<table width="100%" >
							<tr>
								<td colspan="2" >
									Vinculaci&oacute;n VIP
									
								</td>
							</tr>
							<tr>
								<td align="left" colspan="2"  >
 									Fecha / Hora
									 <input type="text" id="fecha_V" name="fecha_V" 
									 readonly="readonly"
									 value="<%=(request.getAttribute("fecha_V")!=null)?request.getAttribute("fecha_V"):"" %>"  
									   />
									   <a href="javascript:NewCal('fecha_V','ddmmyyyy',true,24)">
									   <img src="<c:out value="${pageContext.request.contextPath}"/>/images/cal.gif" width="16" height="16" border="0" >
									   </a>
									
								</td>
							</tr> 
							<tr>
								<td align="left" colspan="2"  >
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
								<br/>
								<br/> 
 									<b style="font-size: 90%;color:green;">Se recomienda realizar la carga de 7 pm a 9 am</b>
								</td>
							</tr>
							
						</table>
				</td>
				<td width="5%">
				</td>
				<td width="60%">
					<iframe width="100%"  src="/iilc_pe_web/visualizarEstadoCargaVincula.do?method=carga&tipo=V"  frameborder="0"  style="height:150px;background: transparent;"  ></iframe>
				</td>
			</tr>
			<tr height="3" style="background-color: black;" >
				<td  colspan="3" >
				
				</td>
			</tr>
			
				<tr>
				<td width="20%">
						
						<table width="100%" >
							<tr>
								<td colspan="2" >
									Vinculaci&oacute;n GCO
									
								</td>
							</tr>
							<tr>
								<td align="left" colspan="2"  >
								Fecha / Hora
									 <input type="text" id="fecha_G" name="fecha_G"  readonly="readonly"
									  value="<%=(request.getAttribute("fecha_G")!=null)?request.getAttribute("fecha_G"):"" %>"   />
									  <a href="javascript:NewCal('fecha_G','ddmmyyyy',true,24)">
									   <img src="<c:out value="${pageContext.request.contextPath}"/>/images/cal.gif" width="16" height="16" border="0" >
									   </a>
									
								</td>
							</tr>

							<tr>
								<td align="left" colspan="2"  >
									<html:button property="Fechas1"   onclick="fecha_programada('G');">
										Fechas programadas
									</html:button>
									<html:button property="Grabar1"  onclick="grabar('G');">
										Grabar
									</html:button>
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
				<td width="5%">
				</td>
				<td width="60%">
				<iframe width="100%"  src="/iilc_pe_web/visualizarEstadoCargaVincula.do?method=carga&tipo=G"  frameborder="0"  style="height:150px;background: transparent;"  ></iframe>
				</td>
			</tr>
			
			
			<tr height="3" style="background-color: black;" >
				<td  colspan="3" >
				
				</td>
			</tr>
			
				<tr>
				<td width="20%">
						
						<table width="100%" >
							<tr>
								<td colspan="2" >
									Vinculaci&oacute;n PH
									
								</td>
							</tr>
							<tr>
								<td align="left" colspan="2"  >
								Fecha / Hora
									 <input type="text" id="fecha_P" name="fecha_P"  readonly="readonly"
									 value="<%=(request.getAttribute("fecha_P")!=null)?request.getAttribute("fecha_P"):"" %>"
									  />
										<a href="javascript:NewCal('fecha_P','ddmmyyyy',true,24)">
									   <img src="<c:out value="${pageContext.request.contextPath}"/>/images/cal.gif" width="16" height="16" border="0" >
									   </a>
								</td> 
							</tr>
							<tr>
								<td align="left" colspan="3"  >
									<html:button property="Fechas1"   onclick="fecha_programada('P');">
										Fechas programadas
									</html:button>
									<html:button property="Grabar1"  onclick="grabar('P');">
										Grabar
									</html:button>
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
				<td width="5%">
				</td>
				<td width="60%">
				<iframe width="100%"  src="/iilc_pe_web/visualizarEstadoCargaVincula.do?method=carga&tipo=P"  frameborder="0"  style="height:150px;background: transparent;"  ></iframe>
				</td>
			</tr>
			
		</TABLE>
		</td></tr>
	</table>
</html:form>
</BODY>
</html:html>
