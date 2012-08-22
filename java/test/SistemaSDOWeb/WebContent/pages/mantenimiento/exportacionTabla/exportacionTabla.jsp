<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>


<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META HTTP-EQUIV='PRAGMA' CONTENT='NO-CACHE'>
<META HTTP-EQUIV='EXPIRES' CONTENT='0'>
<META http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
<TITLE>Mantenimiento Exportación Tabla</TITLE>

<script language="javascript">
	function inicio() {
		var form = document.forms[0];
		
		form.codigoTabla.focus();
	}

	function limpiar(){
		var form = document.forms[0];
		
		form.codigoTabla.selectedIndex = 0;
		form.mes.selectedIndex = 0;
		form.anio.selectedIndex = 0;
	}
	
	function exportar() {
		var form = document.forms[0];
		
		form.method.value = "exportarTabla";		
		
		if(validar()) {
			form.target = '_blank';
			form.submit();		
		}		
	}
	
	function validar() {
		var form = document.forms[0];
		
		if(form.codigoTabla.value == "") {
			alert("Seleccione tabla");
			form.codigoTabla.focus();
			
			return false;
		}
		
		if(form.mes.value == "") {
			alert("Seleccione mes");
			form.mes.focus();
			
			return false;
		}
		
		if(form.anio.value == "") {
			alert("Seleccione año");
			form.anio.focus();
			
			return false;
		}
		
		return true;
	}
</script>
</HEAD>

<BODY onload="inicio();">
<html:form action = "/exportacionTablaAction">
<html:hidden property="method"/>
<table align="center" width="100%" height="%" cellspacing="0" cellpadding="0">
	<tr>
		<td width="100%" align="left"  valign="top">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td><img src="${pageContext.request.contextPath}/images/esq_izq.jpg"></td>	
					<td width="200" class="textocentradoblanco">MANTENIMIENTO</td>	
					<td><img src="${pageContext.request.contextPath}/images/esq_der.jpg"></td>	
				</tr>						
			</table>
		</td>	
	</tr>
	<tr>
		<td style="border: 2px solid #264971;padding:20px;" valign="top" height="%" align="center">
			<div align="center"><strong>EXPORTACIÓN TABLA</strong></div><br />
			<table cellspacing="1" cellpadding="1" align="center">
				<tr>
			    	<td width="60">&nbsp;</td>
			    	<td width="60">&nbsp;</td>
			    	<td width="60">&nbsp;</td>				    
			    	<td width="60">&nbsp;</td>
				    <td width="60">&nbsp;</td>
				    <td width="60">&nbsp;</td>
				</tr>
				<tr>
			    	<td colspan = "6" align = "center">
			    		<div align = "center">
					    	<c:if test="${not empty requestScope.mensajeError}">
								<span class = "mensaje_error">
									${requestScope.mensajeError}
								</span>
							</c:if> 
							<c:if test="${empty requestScope.mensajeError && not empty requestScope.mensajeExito}">
								<span class = "mensaje_exito">			
									${requestScope.mensajeExito}
								</span>					
							</c:if> 
						</div>	
				    </td>
				</tr>				
				<tr>
			    	<td width="60" style="font-size: 12px">Tabla:</td>			    	
				    <td colspan = "5">
				    	<html:select property="codigoTabla" styleClass="combo2" tabindex="1">
							<html:option value="" >[------SELECCIONE------]</html:option>
							<html:options collection="listaExportacion" property="id" labelProperty="descripcion"/>
						</html:select>
				    </td>
				</tr>				
			  	<tr>
			    	<td style="font-size: 12px">Mes:</td>
				    <td >				    
				    	<html:select property="mes" styleClass="combo2" tabindex="2">
							<html:option value="" >[Seleccione Mes]</html:option>
							<html:option value="01" >Enero</html:option>
							<html:option value="02" >Febrero</html:option>
							<html:option value="03" >Marzo</html:option>
							<html:option value="04" >Abril</html:option>
							<html:option value="05" >Mayo</html:option>
							<html:option value="06" >Junio</html:option>
							<html:option value="07" >Julio</html:option>
							<html:option value="08" >Agosto</html:option>
							<html:option value="09" >Setiembre</html:option>
							<html:option value="10" >Octubre</html:option>							
							<html:option value="11" >Noviembre</html:option>							
							<html:option value="12" >Diciembre</html:option>														
						</html:select>			    	
					</td>
					<td>&nbsp;</td>
					<td align="right" style="font-size: 12px">Año:</td>
				    <td >
				    	<html:select property="anio" styleClass="combo2" tabindex="3">
							<html:option value="">[Seleccione Año]</html:option>
							<html:options collection="listaAnio" property="codelem" labelProperty="valor1"/>
						</html:select>	   	
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
			    	<td>&nbsp;</td>
			    	<td>&nbsp;</td>
			    	<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>				
				</tr>
			   	<tr>
	    			<td colspan="6">
					    <table align="center">
					    	<tr>
	    						<td colspan = "3" align = "center">
	    							<input type="button" name="btnExportar" value="Exportar" onClick="exportar();" class="botonnew" tabindex="4">
	    							&nbsp;	
							    	<input type="button" name="btnLimpiar" value="Limpiar" onClick="limpiar();" class="botonnew" tabindex="5" onblur = "inicio();">
							    	&nbsp;								    	
							    </td>
						    </tr>
						</table>
				    </td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</html:form>
</BODY>
</html:html>