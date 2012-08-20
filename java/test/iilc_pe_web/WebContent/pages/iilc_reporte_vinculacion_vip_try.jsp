
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
 
	
<TITLE>Carpetas Comerciales</TITLE>

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

<script type="text/javascript">


var hayResultados = false;
var numPag=0;
var totalPag=0;
var tipo_detalle = '0';

function consulta(){
	hayResultados = false;
	tipo_detalle = '0';
	
	AjaxRequest.get(
	  {
	    'url':'reporteVinculacionVIP.do'
	    ,'parameters':{ 
	    	'method':'buscar'
	     }
	    ,'timeout':600000
	    ,'onSuccess':function(req){
	    				alert('procesa');
	    				procesarResultado(req);
		 			}
	    ,'onTimeout':function(req){
	 					alert("Error de comunicaci\u00F3n.  Intente nuevamente.");
						mostrarProceso(0);
						desbloquear();
		 			}
        ,'onError':function(req){
	 					alert("Error de comunicaci\u00F3n.");
						mostrarProceso(0);
						desbloquear();
		 			}
	  }
	);
	
	limpiarResultados();
	bloquear();
	mostrarProceso(1);
}


function procesarResultado(req){
	var paso = 10;
	var rspText = limpiarDatosAjax(req.responseText);
	if (rspText == "exp"){
		if(confirm("La sesi\u00F3n ha expirado. ¿Desea volver a cargar la p\u00E1gina?")){
			window.location.reload();
		}
	}
	else if (rspText == ""){
		alert("No se encontraron resultados.1");
	}
	else {
		if(validarRespuesta(rspText)){
			try{
				var partes = eval(rspText)[0];
				if(partes["datos"].length==0){
					pintarDetalles(partes["datosDetalleFiltros"]);
					alert("No se encontraron resultados.2");
				}
				else{
					paso++;//11
					var cabeceras = partes["cabeceras"];
					
					//alert(partes["datos"][partes["datos"].length-1][0]);
					
					
					
					var res = partes["datos"];
					numPag = partes["pagActual"];
					totalPag = partes["numPags"];
					paso++;//12
					pintarDetalles(partes["datosDetalleFiltros"]);
					paso++;//13
					pintarPaginacion(numPag,totalPag);
					paso++;//14
					mostrarResultados();
					paso++;//15
					generarModelo(res,cabeceras);
					paso++;//16
					hayResultados = true;
				}
			}
			catch(e){
			alert("El servidor ha retornado una respuesta no válida (" + paso + ")");
				limpiarResultados();
			}
		}
	}
	mostrarProceso(0);
	paso++;//17
	desbloquear(hayResultados);
}

function pageInit(){
	
	limpiarResultados();
	pintarDetalles('');
}


function pintarDetalles(datos){
	var i;
	var j = 0;
	var html = "";
	var objDiv = document.getElementById("divDetalleFiltros");
	html+="<table border='0' cellspacing='0' cellpadding='0' width='97%'>";
	if(datos.length>0){
		for(i=0; i<datos.length; i++){
			if(datos[i][0]!=null){
				j++;
				html+="<tr class='detalle'>";
				html+="<td class='detalle1' width='150'>" + datos[i][0] + "</td>";
				html+="<td class='detalle2'>" + datos[i][1] + "</td>";
				html+="</tr>";
			}
		}
	}
	if(datos.length==0 || j==0){
		html+="<tr>";
		html+="<td class='detalle1' width='150'>&nbsp;</td>";
		html+="<td class='detalle2'>SIN FILTROS</td>";
		html+="</tr>";
	}
	
	html+="</table>";
	objDiv.innerHTML = html;
	objDiv.style.visibility = "visible";
}
   
</script>
</HEAD>
<BODY  onload="pageInit();consulta();"  >
<html:form action="/reporteVinculacionVIP" >
<input type="hidden" name="tipo_detalle" value="1" />
<input type="hidden" name="territorio" value="" />
<input type="hidden" name="oficina" value="" />
<input type="hidden" name="gestor" value="" />
<input type="hidden" name="nivelVinculacion" value="" />
<input type="hidden" name="clasificacion" value="" />
<input type="hidden" name="margenOrdinario" value="" />
<input type="hidden" name="etiqueta" value="" />
<input type="hidden" name="edad" value="" />
<input type="hidden" name="cuotaRiesgoTotal" value="" />
<input type="hidden" name="codEmpresa" value="" />
	<div id="divDetalleFiltros" class="detalle" style="visibility:hidden;">
	</div>
	<table width="100%" border="1" cellpadding="0" cellspacing="0">
		
		<tr class="FondoGris1"><td>
			
			<table border="0" cellspacing="0" cellpadding="0" style="height:100%;table-layout:fixed;width:100%;">
			<tr><td>
			<div id="divProceso" style="height:240px;width:100%;background:url('images/ajaxConsulta.gif') center no-repeat; visibility:hidden; position:absolute;"></div>
			<div id="divPaginacion" style="text-align:center;">
				<span id="spanPagPri" style="width:16px;vertical-align:middle;visibility:hidden;"><IMG alt="Ver primera página" border="0" style="CURSOR: hand" src="<c:out value="${pageContext.request.contextPath}"/>/images/btn_primero.png" width="16" height="16" onclick="consultaPagina('pri')"></span>
				<span id="spanPagAnt" style="width:16px;vertical-align:middle;visibility:hidden;"><IMG alt="Ver página anterior" border="0" style="CURSOR: hand" src="<c:out value="${pageContext.request.contextPath}"/>/images/btn_anterior.png" width="16" height="16" onclick="consultaPagina('ant')"></span>
				<span id="spanPagText" style="width:200px;vertical-align:middle;text-align:center;"></span>
				<span id="spanPagSig" style="width:16px;vertical-align:middle;visibility:hidden;"><IMG alt="Ver página siguiente" border="0" style="CURSOR: hand" src="<c:out value="${pageContext.request.contextPath}"/>/images/btn_siguiente.png" width="16" height="16" onclick="consultaPagina('sig')"></span>
				<span id="spanPagUlt" style="width:16px;vertical-align:middle;visibility:hidden;"><IMG alt="Ver última página" border="0" style="CURSOR: hand" src="<c:out value="${pageContext.request.contextPath}"/>/images/btn_ultimo.png" width="16" height="16" onclick="consultaPagina('ult')"></span>
			</div>
			<div id="divResultados" style="overflow:hidden; width:100%;">
				<input type="hidden" ID="RowNo" NAME="RowNo" value="-1">
				<input type="hidden" ID="ColumnNo" NAME="ColumnNo">
				<span id="myGrid"></span>
			</div>
			</td></tr></table>
			
			
			
		</td></tr>
	</table>
</html:form>
</BODY>
</html:html>
