
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/displaytag-11.tld" prefix="display"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">

<TITLE>Carpetas Comerciales</TITLE>
<style type="text/css">



</style>
<LINK rel="stylesheet" href='<c:out value="${pageContext.request.contextPath}"/>/theme/IIRGEspacio2.css' type="text/css">
<script language="javascript" src="includes/index_combos.js"></script>

<!-- js y css para grilla -->
<script src="aw_runtime/lib/aw.js" type="text/javascript"></script>
<script src="includes/grilla.js" type="text/javascript"></script>
<link href="aw_runtime/styles/oso/aw.css" rel="stylesheet">
<script src="includes/index_grilla.js" type="text/javascript"></script>
<script src="includes/common.js" type="text/javascript"></script>
<script src="includes/AjaxRequest.js" type="text/javascript"></script>
<script src="includes/AjaxCommon.js" type="text/javascript"></script>
<!-- NO BORRAR LOS ATRIBUTOS TITLE DE ESTOS CSS -->
<link href="aw_runtime/styles/oso/extras_grilla.css" rel="stylesheet" title="cssEstiloGrilla">
<link rel="stylesheet" href="theme/bloqueCeldas.css" title="cssEstilosCeldas">
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/js/contexto.js"></script>
<script type="text/javascript">
var contexto = obtenerContexto();

function datoFiltro(){
	var codigos;
}

hayResultados=<%=request.getAttribute("hayResultados")%>;

function openFile(tipo){
	if(hayResultados){
		var opciones="toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, width=300px, height=200px, top=85, left=140";
		ventana = window.open("consultaListadoConduccionAction.do?method=espera&tipo="+tipo+"&origenVinculacion=5" ,"",opciones);
	}
	else{
		alert("No hay resultados para exportar.");
	}
}

function abrirFiltro(tipo){ 

	if(tipo==1)
		datoFiltro.codigos = document.forms[0].segmento.value;
 
	
	var url = "consulta2.do?method=filtro&tipo=6";
	
	if(window.showModalDialog(url,datoFiltro,"dialogWidth:240px;dialogHeight:360px;")){
		 
		if(tipo==1)
			document.forms[0].segmento.value = datoFiltro.codigos;
		 
		updateBotonesFiltro();
	}
	else{
		return;
	}
}

function updateBotonesFiltro(){
	if(document.forms[0].segmento.value=="-1"){
		document.getElementById("btnSegmento").value = "Todos";
		document.getElementById("btnSegmento").className = "botonFiltro";
	}
	else{
		document.getElementById("btnSegmento").value = "Filtrado";
		document.getElementById("btnSegmento").className = "botonFiltroLleno";
	}
}

function limpiar(){
	document.forms[0].segmento.value="-1";
	updateBotonesFiltro();
}
 
 function salir(){
	window.location = contexto+"reporteVinculacion.do?tipoReporte=1&method=buscar";
	
}
 
function buscar(){
	window.location = contexto+"reporteVinculacionVIPSegmentado.do?segmento="+document.forms[0].segmento.value;

}

 function lanzaMensaje(){
 
 	if(document.forms[0].mensaje.value==null || document.forms[0].mensaje.value=='null' || document.forms[0].mensaje.value==''){
 	}else{
 		alert(document.forms[0].mensaje.value);
 	}
 
 } 
  
</script>
</HEAD>
<BODY      onload="updateBotonesFiltro();lanzaMensaje();"  >
<html:form action="/reporteVinculacionVIPSegmentado.do" >
<input type="hidden" value="<%=request.getParameter("tipoReporte") %>" name="tipoReporte" id="tipoReporte" />
<input type="hidden" value="buscar" name="method" id="method" />
<input type="hidden" value="<%=request.getAttribute("mensaje") %>" name="mensaje" id="mensaje" />
<input type="hidden" value="<%=request.getParameter("segmento") %>" name="segmento" id="segmento" />
 <table width="100%" >
	 <tr> 
		 <td  width="40%" align="left" >
		 		<table width="100%" >
		 			<tr>
		 			<td class="FondoAzulPeq" >
		 				SEGMENTO
		 			</td>
		 			<td>
		 				<input type="button" class="botonFiltro" id="btnSegmento" value="Todos" onclick="abrirFiltro(1);" />
		 			</td>
		 			</tr>
		 		</table>
		 </td>
		 <td  width="50%" align="right"  >
		 		<html:button property="cancelar" styleClass="boton" onclick="limpiar();">Limpiar</html:button>
				<html:button property="cancelar2" styleClass="boton" onclick="buscar();">Buscar</html:button>
				<html:button property="cancelar2" styleClass="boton" onclick="salir();">Salir</html:button>
		</td>
		<td width="10%" style="text-align:center;padding-left:5px;padding-right:5px;font-size:10px;" align="right" >
				<img id="btnExcel" src="<c:out value="${pageContext.request.contextPath}"/>/images/btnExcel1.gif" width="28" height="23" border="0"
					style="CURSOR: hand" onclick="openFile('exportacion');"  >
		 <br/>Exportar
		 </td>
	 </tr>
 </table>
 
 
 <div align="left"	style="width: 100%" >	
 		<display:table name="reporteSegmentado" requestURI="/reporteVinculacionVIPSegmentado.do"  id="lista" pagesize="30"  scope="request" summary="false"  width="60%" class="grilla"  >
 
 			<display:column    title="Codigo Gestor" property="cod_gestor"   class="cabecera"   />
 			<display:column    title="Nombre Gestor" property="nom_gestor"   class="cabecera"   />
 			<display:column    title="Segmento" property="segmento"   class="cabecera"   />
 			<display:column    title="Total" property="total_puntos"   class="cabecera"   />
 			 
 		</display:table>
  </div>
 
 
			
		 
</html:form>
</BODY>
</html:html>
