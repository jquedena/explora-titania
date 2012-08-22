<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
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
<TITLE>Mantenimiento Oficinas Hijas</TITLE>

<script language="javascript">		
	function editar(codigoOficinaHija) {
		var form = document.forms[0];
		
		form.method.value = "mostrarNuevoEditarOficinaHija";		
		form.codigoOficinaHija.value = codigoOficinaHija;	
		form.mostrarEditar.value = "2";
		
		form.submit();		
	}
	
	function eliminar(codigoOficinaHija) {
		var form = document.forms[0];
		
		form.method.value = "eliminarOficinaHija";		
		form.codigoOficinaHija.value = codigoOficinaHija;		
		
		form.submit();		
	}
	
	function nuevo() {
		var form = document.forms[0];
		
		form.method.value = "mostrarNuevoEditarOficinaHija";		
		form.mostrarEditar.value = "1";
		
		form.submit();		
	}

var mensaje_error = '<%=request.getAttribute("mensajeExito")%>';

window.onload=function(){
	if (mensaje_error != 'null') {
		alert(mensaje_error);
	}
}
</script>

</HEAD>
<BODY>
<html:form action = "/oficinaHijaAction">
<html:hidden property="method"/>
<html:hidden property="codigoOficinaHija"/>
<html:hidden property="mostrarEditar"/>

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
			<div align="center"><strong>OFICINAS HIJAS</strong></div><br />
				<table cellspacing="0" cellpadding="0" align="center">  
				  <tr>
				    <td width="140">&nbsp;</td>
				    <td width="75">&nbsp;</td>
				    <td width="140">&nbsp;</td>
				    <td width="75">&nbsp;</td>
				    <td width="25">&nbsp;</td>
				    <td width="25">&nbsp;</td>
				  </tr>
				  <tr>
				   <td colspan = "6" align = "center">
			    		<div align = "center">
					    	<c:if test="${not empty requestScope.mensajeError}">
								<span class = "mensaje_error">
									<c:out value="${requestScope.mensajeError}" escapeXml="false" />
								</span>
							</c:if> 
							<c:if test="${empty requestScope.mensajeError && not empty requestScope.mensajeExito}">
								<span class = "mensaje_exito">			
									<c:out value="${requestScope.mensajeExito}" escapeXml="false" />
								</span>					
							</c:if> 
						</div>	
				    </td>
				  </tr>
				  <tr>
				    <td align="center" class="celda1cabecera">C&oacute;digo Oficina Hija</td>
				    <td align="center" class="celda1cabecera">Oficina Hija</td>
				    <td align="center" class="celda1cabecera">C&oacute;digo Oficina Padre</td>
				    <td align="center" class="celda1cabecera">Oficina Padre</td>
				    <td align="center" class="celda1cabecera">Editar</td>
				    <td align="center" class="celda1cabecera">Eliminar</td>
				  </tr>
				  <c:if test="${not empty requestScope.listaOficinaHija}">				  		
				  	 <c:forEach items="${requestScope.listaOficinaHija}" var="row"> 	
						 <tr>
							<td class="colorfila2">
								<div align="center">
									${row.codigoOficinaHija}								
						    	</div>  										
							</td>
						    <td class="colorfila2">
								<div align="center">
						    		${row.nombreOficinaHija}
						    	</div>  	
						    </td>
						    <td class="colorfila2">
								<div align="center">
							    	${row.codigoOficinaPadre}
						    	</div>  		
						    </td>
						     <td class="colorfila2">
								<div align="center">
							    	${row.nombreOficinaPadre}
						    	</div>  		
						    </td>	
						    <td class="colorfila2">
								<div align="center">
									<a href='javascript:editar("${row.codigoOficinaHija}")'   >
										<img src="${pageContext.request.contextPath}/images/editar.png" width="18" height="18"  border="0" id="editar" />
									</a>																
								</div>  
							</td>						  
							 <td class="colorfila2">
								<div align="center">
									<a href='javascript:eliminar("${row.codigoOficinaHija}")'   >
										<img src="${pageContext.request.contextPath}/images/delete.gif" width="18" height="18"  border="0" id="eliminar" />
									</a>																
								</div>  
							</td>	    
						</tr>  
					 </c:forEach>	
				 </c:if>   
				  
				  <c:if test="${empty requestScope.listaOficinaHija}">
					  <tr>
						<td class="colorfila2">&nbsp;</td>
					    <td class="colorfila2">&nbsp;</td>
					    <td class="colorfila2">&nbsp;</td>
					    <td class="colorfila2">&nbsp;</td>		    
					    <td class="colorfila2">&nbsp;</td>		    				    
					    <td class="colorfila2">&nbsp;</td>		    				    
					   </tr>  
				 </c:if>   
				 
				  <tr>
				  	<td colspan = "6" align = "center">&nbsp;</td>
				  </tr> 
				  <tr>
				   <td colspan = "6" align = "center">
			    		<div align = "center">
					    	<input type="button" name="btnNuevo" value="Nuevo" onClick="nuevo();" class="botonnew" tabindex="1">
						</div>	
				    </td>
				  </tr>
				 
				</table>				
		</td>
	</tr>
</table>
</html:form>
</BODY>
</html:html>