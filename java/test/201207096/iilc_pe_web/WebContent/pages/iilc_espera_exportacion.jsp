<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@page import="com.grupobbva.bc.per.tel.iilc.common.Constantes"%>
<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<LINK type="text/css" rel="stylesheet" href='${pageContext.request.contextPath}/theme/IIRGEspacio2.css'>
<TITLE>Procesando... </TITLE>
<script src="${pageContext.request.contextPath}/includes/AjaxRequest.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/includes/AjaxCommon.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/js/contexto.js"></script>
<script type="text/javascript">
var contexto = obtenerContexto();

function avisaExportacion(){


	AjaxRequest.get(
	  {
	    'url':'exportacion.do'
	    ,'parameters':{ 
	    	'method':'exportacion',
	    	'origenVinculacion': document.forms[0].origenVinculacion.value
	     }
	    ,'timeout':600000
	    ,'onSuccess':function(req){
	    				var resp = limpiarResponse(req.responseText);
						if(resp!='too_much'){
	   		        		window.opener.self.location.href=contexto+"/pages/iilc_descarga_excel.jsp";
							window.close();
			        	}
			        	else{
				            alert("La cantidad de registros excede a la permitida por excel: <%=Constantes.TOT_REGEXCEL%>.\nAplique m\u00E1s filtros a la consulta e intente nuevamente");
							window.close();
			        	}			        
		 			}
	    ,'onTimeout':function(req){
	 					alert("Error de comunicaci\u00F3n.  Intente nuevamente.");
						window.close();
		 			}
        ,'onError':function(req){
	 					alert("Error de comunicaci\u00F3n.");
						window.close();
		 			}
	  }
	);
}


 var req;
 /*
  * Get the second options by calling a Struts action
  */
 	function carga(){
	    
	    url="exportacion.do?method=exportacion";
	    if (window.XMLHttpRequest){ // Non-IE browsers
	    	req = new XMLHttpRequest();
			req.onreadystatechange = exportacion;
      		req.open("GET", url, true); 
			req.send(null);
	    } else {
	    	if (window.ActiveXObject) { // IE     
		      	req = new ActiveXObject("Microsoft.XMLHTTP");
	    	  	if (req) {
	        		req.onreadystatechange = exportacion;
	        		req.open("GET", url, true);
		        	req.send();
	    	  	}
	    	}
	  	}
	}
  
  //Callback function
	function exportacion(){
		if (req.readyState == 4) { // Complete
    		if (req.status == 200) { // OK response
    			//textToSplit = req.responseText;
    			//limpiar script agregado en produccion
    			var script2 = "</" + "SCRIPT>" + "\n";
				if (req.responseText.indexOf(script2) != -1){
					textToSplit = req.responseText.substring(req.responseText.indexOf(script2) + script2.length);
				}
				else{
					textToSplit = req.responseText;
				}
	        	alert(req.responseText);
        		if(textToSplit == '803'){
				}
	        	//Split the document
		        returnElements=textToSplit.split("||");
		        if(returnElements.length == 2){
	   		        file = returnElements[0];
			        rootpath = returnElements[1];
			        if (file!='too_much'){
				        window.opener.self.location.href="pages/iilc_descarga.jsp?file=" + file+ "&rootpath=" + rootpath;
						window.close();
			        } else {
				        alert("La cantidad de registros excede a la permitida por excel: <%=Constantes.TOT_REGEXCEL%>.\nAplique m\u00E1s filtros a la consulta e intente nuevamente");
						window.close();
			        }			        
			        
				}else{
					alert("No hay informaci\u00F3n de b\u00FAsqueda para crear el archivo");
					window.close();
				}
    	    }
      	}    
	}
</script>

</HEAD>

<body onload="avisaExportacion();">
<html:form action="/exportacion">
<input type="hidden"" name="origenVinculacion" id="origenVinculacion" value='<%=request.getAttribute("origenVinculacion") %>'   />
<table width="100%" align="center" height="180px">
<tr><td colspan="3">&nbsp;</td></tr>
<tr><td colspan="3" align="center" style="font:bold">Operaci&oacute;n en proceso</td></tr>

<tr>
<td width="95px">&nbsp;</td>
<td>
<IMG name="exportar" border="0" src="images/btn_espera.gif" width="90" height="20" >
</td>
<td width="72px">&nbsp;</td>
</tr>
<tr><td colspan="3">&nbsp;</td></tr>
</table>
</html:form>
</body>
</html:html>
