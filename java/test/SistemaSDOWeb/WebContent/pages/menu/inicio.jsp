<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0060)http://nettuts.s3.amazonaws.com/001_Tabbed/site/jQuery.html# -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>

<HTML lang=en xml:lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Menu</title>
<META http-equiv=Content-Type content="text/html; charset=windows-1252">
<link media=screen href="<%=request.getContextPath()%>/css/styleTab.css"
	type=text/css rel=stylesheet>
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/base/basico.css" />


<script type="text/javascript">	
	  
function chequear_todos(chkbox)	{                                                                                             
	for (var i=0;i < document.forms[0].elements.length;i++)	{
		var elemento = document.forms[0].elements[i];                                                                                                                                                                                      
		if (elemento.type == "checkbox"){                                                                                                                                                                                                                                                                                                                                                                                            
			elemento.checked = chkbox.checked                                                                                                                                                                                                                                                                                                                                                                                    
		}                                                                                                                                                                                                                                                                                                                                                                                                                            
	}                                                                                                                                                                                                                                                                                                                                                                                                                                    
}

	function metodo(padre,metodo) {
		var opciones="toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, width=450px, height=200px, top=85, left=140";
		window.open('menuAction.do?method='+metodo+'&padre='+padre,"opm",opciones);		
	}
	
	function eliminar(padre){                                                                                                                                                                                                                                                            
		if(confirm("\u00BFEstá seguro de eliminar el registro seleccionado?"))    
		{   
		    obj="menuAction.do?method=delete&padre="+padre;
			getUrlInicio(obj);
		}	                                                                                                                                                                                                                                                                                                                                                                                     
}  
	function eliminarVarios(){	
	var cadCheckValues =obtenerCheckValues("seleccion","-");
		if(cadCheckValues=="")
	    {
	        alert("Debe seleccionar uno o mas registros.");
	        return false;
	    }	                                                                                                                                                                                                                                                                                                                                        
		if(confirm("\u00BFEstá seguro de eliminar el registro seleccionado?"))    
		{   
		    obj="menuAction.do?method=delete&padre="+cadCheckValues;
			getUrlInicio(obj);
		}	                                                                                                                                                                                                                                                                                                                                                                                     
} 



  </script>
</head>
<body>
<DIV class=tabbed_box id=tabbed_box_1>
<DIV class=tabbed_area>
<UL class=tabs>
	<LI><A class="tab active">Menu</A>
</UL>
<DIV class=content id=content_1>
<UL>
	<html:form action="/menuAction.do?method=delete">
		<input type="hidden" name="method">
		<html:hidden property="codPerfil" />
		<table width="80%" cellspacing="0" cellpadding="0">
			<tr>
				<td colspan="2">
				<table width="100%" cellpadding="0" cellspacing="0" border="0">
					<tr align="center">
						<td><display:table id="menu" 
							name="sessionScope.listaMenu"
							class="tabla_borde busqueda_letra" style="margin: auto;"
							cellpadding="2" cellspacing="0" requestURI="" pagesize="50">
							<display:column title="Padre" property="padre"
								class="bordeIzquierdo" />
							<display:column title="Hijo" property="hijo"
								class="bordeIzquierdo" />
							<display:column title="Link" property="link"
								class="bordeIzquierdo"  />
							<display:column title="Descripción" property="descripcion"
								class="bordeIzquierdo" />
								<display:column title="Descripción" property="codPerfil"
								class="bordeIzquierdo" />
							<display:column title="Editar" class="bordeIzquierdo">
								<img alt="Modificar" border="0"
									src="<c:out value="${pageContext.request.contextPath}"/>/images/editar.png"
									width="16" height="16"
									onclick="javascript:metodo('<c:out value="${menu.padre}"/>','mostrarEditar');" />
							</display:column>
							<display:column title="Eliminar" class="bordeIzquierdo">
								<img alt="Eliminar" border="0"
									src="<c:out value="${pageContext.request.contextPath}"/>/images/eliminar.png"
									width="16" height="16"
									onclick="javascript:eliminar('<c:out value="${menu.padre}"/>');" />
							</display:column>
							<display:column class="bordeIzquierdo" 
								title="<input type='checkbox' safari=1 name='selectall' onClick='chequear_todos(this);'">
								<input type="checkbox" id="${menu.padre}"
									name="seleccion"
									value="${menu.padre}">
							</display:column>
						</display:table></td>
					</tr>
					<tr>
						<td align="center">&nbsp;</td>
					</tr>
					<tr>
						<td align="center"><html:button property="new" styleClass="boton"
							onclick="metodo('','mostrarNuevo');">Nuevo</html:button> &nbsp; <html:button
							property="elimi" styleClass="boton" onclick="eliminarVarios();">Eliminar</html:button>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		
	</html:form>
</UL>
</DIV>
</DIV>
</DIV>
</body>
</html>
