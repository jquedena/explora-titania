
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/displaytag-11.tld" prefix="display"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@ page import="com.grupobbva.bc.per.tel.iilc.beans.Tiilc_conf_cabeceras_rep" session="true"    %>
<%@ page import="java.util.List" session="true"    %>

<%@page import="com.grupobbva.bc.per.tel.iilc.common.Constantes"%>
<html:html>
<head>
<title>Carpetas Comerciales</title>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="generator" content="Bluefish 2.0.3" >
<link rel="stylesheet" href='${pageContext.request.contextPath}/theme/IIRGEspacio2.css' type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/aw_runtime/styles/oso/aw.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/aw_runtime/styles/oso/extras_grilla.css" title="cssEstiloGrilla" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/theme/bloqueCeldas.css" title="cssEstilosCeldas" />

<script type="text/javascript" src="${pageContext.request.contextPath}/includes/index_combos.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/aw_runtime/lib/aw.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/grilla.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/index_grilla.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/AjaxRequest.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/AjaxCommon.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/jquery-1.2.6.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/js/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/js/iilc_reporte_all.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/js/contexto.js"></script>
<script type="text/javascript">
var contexto = obtenerContexto();
var totalPag = <%=Integer.parseInt(request.getAttribute("cantidadDetalle").toString())%>;
var page_Act = <%=request.getAttribute("paginaActual")%>;
var hayResultados = <%=request.getAttribute("hayResultados")%>;
var perfilTerritorio = "${requestScope.pTerritorio}";
var perfilOficina = "${requestScope.pOficina}";

function openFile(tipo){
	if(hayResultados){
		if(<%=Integer.parseInt(request.getAttribute("cantidadDetalle").toString())%>*30><%=Constantes.MAXIMO_REGISTROS_REPORTE_EXCEL%>){
			alert('S\u00F3lo se permite descargar '+ parseInt(<%=Constantes.MAXIMO_REGISTROS_REPORTE_EXCEL%>/30) +' p\u00E1ginas');
			return;
		}
		var opciones="toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, width=300px, height=200px, top=85, left=140";
			ventana = window.open(contexto+'reporteVinculacion.do?method=espera&tipo='
									+tipo+'&origenVinculacion=1&tipoReporte=<%=request.getParameter("tipoReporte")%>&territorio='
									+document.forms[0].territorio.value+'&oficina='+document.forms[0].oficina.value+'&gestor='+document.forms[0].gestor.value,"",opciones);
	
	}
	else{
		alert("No hay resultados para exportar.");
	}
}
 
function cargaFiltroVIP(tipoFiltro){	
	if(tipoFiltro=='V'){
     	window.location = contexto+"reporteVinculacionVIPVinculado.do?perfil=-1";
	}else if(tipoFiltro=='S'){
		window.location = contexto+"reporteVinculacionVIPSegmentado.do?segmento=-1";
	}
}

function lanzaMensaje(){
	var mensaje='<%=request.getAttribute("mensaje") %>';
	if( mensaje=='null' || mensaje==''){
	}else{
		alert(mensaje);
	}
}
</script>
</head>
<body onload="updateBotonesFiltro();lanzaMensaje();pintarDetalles('<%=request.getAttribute("desc_filtro")%>')">
<form  method="post">
<input type="hidden" value="<%=request.getSession().getAttribute("codperfil").toString()%>" name="perfil" id="perfil" />

<input type="hidden" value="<%=(request.getAttribute("hid_territorio")==null || request.getAttribute("hid_territorio").equals("") )?request.getParameter("territorio"): request.getSession().getAttribute("cod_territorio").toString() %>" name="territorio" id="territorio" />
<input type="hidden" value="<%=(request.getAttribute("hid_oficina")==null || request.getAttribute("hid_oficina").equals("") )?request.getParameter("oficina"): request.getSession().getAttribute("cod_oficina").toString() %>" name="oficina" id="oficina" />
<input type="hidden" value="<%=(request.getAttribute("hid_gestor")==null || request.getAttribute("hid_gestor").equals("") )?request.getParameter("gestor"): request.getSession().getAttribute("gestor").toString() %>" name="gestor" id="gestor" />
<input type="hidden" value="<%=request.getParameter("tipoReporte") %>" name="tipoReporte" id="tipoReporte" />
<input type="hidden" value="buscar" name="method" id="method" /> 
 
<table width="100%" border="0" cellpadding="1" cellspacing="1" >
<tr> 
	<td  width="25%" align="left" style="vertical-align:middle;">
		<table width="90%" border="0" cellpadding="0" cellspacing="0"  >
		<tr>
			<td class="FondoAzulPeq" width="50%" >TERRITORIO</td>
			<td  width="50%">
				<%if(request.getAttribute("hid_territorio")==null || request.getAttribute("hid_territorio").equals("")){ %>
					<input type="button" class="botonFiltro" id="btnTerritorio" value="Todos" onclick="abrirFiltro(0);" />
				<%}else{ %>
					<%=request.getAttribute("hid_territorio")%>		 				
				<%} %>
			</td>
		</tr>
		</table>
	</td>
	<td  width="25%" align="left" style="vertical-align:middle;">
		<table width="90%" border="0" cellpadding="0" cellspacing="0"  >
		<tr>
			<td class="FondoAzulPeq"  width="50%">OFICINA</td>
 			<td width="50%">
				<%if(request.getAttribute("hid_oficina")==null || request.getAttribute("hid_oficina").equals("") ){ %>
					<input type="button" class="botonFiltro" id="btnOficina" value="Todos" onclick="abrirFiltro(1);" />
 				<%}else{ %>
 					<%=request.getAttribute("hid_oficina")%>		 				
 				<%} %>
 			</td>
 		</tr>
 		</table>
	</td>
	<td  width="25%" align="left" style="vertical-align:middle;"> 
		<table width="90%" border="0" cellpadding="0" cellspacing="0"  >
		<tr>
			<td class="FondoAzulPeq" width="50%">GESTOR</td>
			<td width="50%">
				<%if(request.getAttribute("hid_gestor")==null || request.getAttribute("hid_gestor").equals("") ){ %>
					<input type="button" class="botonFiltro" id="btnGestor" value="Todos" onclick="abrirFiltro(2);" />
				<%}else{ %>
					<%=request.getAttribute("hid_gestor")%>		 				
				<%} %>
			</td>
		</tr>
		</table>
	</td>
	<td width="15%" align="right" style="vertical-align:middle;">
		<html:button property="cancelar" styleClass="boton" onclick="limpiar();">Limpiar</html:button>
		<html:button property="cancelar2" styleClass="boton" onclick="buscar();">Buscar</html:button>		
	</td>
	<td align="right" width="5%"  style="text-align:center;padding-left:5px;padding-right:5px;font-size:10px;" >
		<img id="btnExcel" src="<c:out value="${pageContext.request.contextPath}"/>/images/btnExcel1.gif" width="28" height="23" border="0" style="CURSOR: hand" onclick="openFile('exportacion');"/>
		<br>Exportar
	</td>
</tr>
<tr>
	<td colspan="5">
		<div id="divDetalleFiltros" class="detalle" style="visibility:hidden;"></div>
	</td>
</tr>
</table>
<table width="100%">
 		<tr>
 			<td align="left" width="25%">
			 	<input type="radio" value="V" onclick="cargaFiltroVIP('V');" >Vinculado por gestor
			 	<input type="radio" value="S" onclick="cargaFiltroVIP('S');" >Segmento por gestor
 			</td>
 			
 			<td align="center" valign="bottom" >
 		<%if(((List)request.getAttribute("listadoDetalle")).size()>0){
		int cantidadDetalle=Integer.parseInt(request.getAttribute("cantidadDetalle").toString());
		if(cantidadDetalle>1){
		%>
			<%if(Integer.parseInt(request.getAttribute("paginaActual").toString())>1){ %>
			<a href="#" onclick="setearPagina(1);" ><img border="0" alt="Primera" src="<c:out value="${pageContext.request.contextPath}"/>/images/btn_primero.png"></a>
			<a href="#" onclick='setearPagina(<%=Integer.parseInt(request.getAttribute("paginaActual").toString())-1 %>);' ><img  border="0" alt="Anterior" src="<c:out value="${pageContext.request.contextPath}"/>/images/btn_anterior.png"></a>
			<%} %>
			P&aacute;gina : 
			<input type="text"  value="<%=request.getAttribute("paginaActual").toString()%>"  name="paginaActual" id="paginaActual" size="3" maxlength="6" 
							 onkeypress="consultarPorPagina(event);"	/>
							 de <%=(cantidadDetalle)%>
			&nbsp;
			<%if(cantidadDetalle!=Integer.parseInt(request.getAttribute("paginaActual").toString())){ %>
			<a href="#" onclick='setearPagina(<%=Integer.parseInt(request.getAttribute("paginaActual").toString())+1 %>);' ><img  border="0" alt="Siguiente" src="<c:out value="${pageContext.request.contextPath}"/>/images/btn_siguiente.png"></a>
			<a href="#" onclick="setearPagina(<%=(cantidadDetalle) %>);" ><img  border="0" alt="Ultima" src="<c:out value="${pageContext.request.contextPath}"/>/images/btn_ultimo.png"></a>
			<%} %>
		<%}else{ %>
 			P&aacute;gina :   <%=request.getAttribute("paginaActual").toString()%>
 		<%}
 		}%>
 		
 		</td>

 		</tr>
 	</table>	
 		<div id="caja_scroll" style="width: 100%" >
 		<display:table name="listadoDetalle" id="lista" summary="false" width="100%" class="grilla">
 		<%    
 		List cabeceras=(List)request.getSession().getAttribute("cabecera");
		int i=0;
		if(cabeceras!=null && cabeceras.size()>0){
		%>
		<display:column title="<%=((Tiilc_conf_cabeceras_rep)cabeceras.get(i++)).getDescorta() %>" property="cod_oficina"    	class="cabecera" nowrap="true"  media="html"  />
		<display:column title="<%=((Tiilc_conf_cabeceras_rep)cabeceras.get(i++)).getDescorta() %>" property="codigo_cliente"   	class="cabecera" nowrap="true"  media="html"  />
		<display:column title="<%=((Tiilc_conf_cabeceras_rep)cabeceras.get(i++)).getDescorta() %>" property="nombre_cliente"    class="cabecera" nowrap="true"  media="html" width="200" />
		<display:column title="<%=((Tiilc_conf_cabeceras_rep)cabeceras.get(i++)).getDescorta() %>" property="cod_gestor"   		class="cabecera" nowrap="true"  media="html"  />
		<display:column title="<%=((Tiilc_conf_cabeceras_rep)cabeceras.get(i++)).getDescorta() %>" property="nom_gestor"   		class="cabecera" nowrap="true"  media="html"  />
		<display:column title="<%=((Tiilc_conf_cabeceras_rep)cabeceras.get(i++)).getDescorta() %>" property="segmento"   			class="cabecera" nowrap="true"  media="html"  />
		<display:column title="<%=((Tiilc_conf_cabeceras_rep)cabeceras.get(i++)).getDescorta() %>" property="ahorro_cta_cero"   class="cabecera" nowrap="true"  media="html"  />
		<display:column title="<%=((Tiilc_conf_cabeceras_rep)cabeceras.get(i++)).getDescorta() %>" property="cuenta_cte_vip"   	class="cabecera" nowrap="true"  media="html"  />
		<display:column title="<%=((Tiilc_conf_cabeceras_rep)cabeceras.get(i++)).getDescorta() %>" property="ahorro_cta_gan"   	class="cabecera" nowrap="true"  media="html"  />
		<display:column title="<%=((Tiilc_conf_cabeceras_rep)cabeceras.get(i++)).getDescorta() %>" property="otras_ctas_ahorro" class="cabecera" nowrap="true"  media="html"  />
		<display:column title="<%=((Tiilc_conf_cabeceras_rep)cabeceras.get(i++)).getDescorta() %>" property="familia1"   			class="cabecera" nowrap="true"  media="html"  />
		<display:column title="<%=((Tiilc_conf_cabeceras_rep)cabeceras.get(i++)).getDescorta() %>" property="plazo"   				class="cabecera" nowrap="true"  media="html"  />
		<display:column title="<%=((Tiilc_conf_cabeceras_rep)cabeceras.get(i++)).getDescorta() %>" property="fondos_mutuos"   	class="cabecera" nowrap="true"  media="html"  />
		<display:column title="<%=((Tiilc_conf_cabeceras_rep)cabeceras.get(i++)).getDescorta() %>" property="bolsa"   				class="cabecera" nowrap="true"  media="html"  />
		<display:column title="<%=((Tiilc_conf_cabeceras_rep)cabeceras.get(i++)).getDescorta() %>" property="cts"   				class="cabecera" nowrap="true"  media="html"  />
		<display:column title="<%=((Tiilc_conf_cabeceras_rep)cabeceras.get(i++)).getDescorta() %>" property="familia2"   			class="cabecera" nowrap="true"  media="html"  />
		<display:column title="<%=((Tiilc_conf_cabeceras_rep)cabeceras.get(i++)).getDescorta() %>" property="pres_libre_dis"   	class="cabecera" nowrap="true"  media="html"  />
		<display:column title="<%=((Tiilc_conf_cabeceras_rep)cabeceras.get(i++)).getDescorta() %>" property="pres_auto"   		class="cabecera" nowrap="true"  media="html"  />
		<display:column title="<%=((Tiilc_conf_cabeceras_rep)cabeceras.get(i++)).getDescorta() %>" property="pres_hipotecario"  class="cabecera" nowrap="true"  media="html"  />
		<display:column title="<%=((Tiilc_conf_cabeceras_rep)cabeceras.get(i++)).getDescorta() %>" property="tc_activas"   		class="cabecera" nowrap="true"  media="html"  />
		<display:column title="<%=((Tiilc_conf_cabeceras_rep)cabeceras.get(i++)).getDescorta() %>" property="familia3"   			class="cabecera" nowrap="true"  media="html"  />
		<display:column title="<%=((Tiilc_conf_cabeceras_rep)cabeceras.get(i++)).getDescorta() %>" property="infomail"   			class="cabecera" nowrap="true"  media="html"  />
		<display:column title="<%=((Tiilc_conf_cabeceras_rep)cabeceras.get(i++)).getDescorta() %>" property="haberes"   			class="cabecera" nowrap="true"  media="html"  />
		<display:column title="<%=((Tiilc_conf_cabeceras_rep)cabeceras.get(i++)).getDescorta() %>" property="bca_internet"   	class="cabecera" nowrap="true"  media="html"  />
		<display:column title="<%=((Tiilc_conf_cabeceras_rep)cabeceras.get(i++)).getDescorta() %>" property="domiciliado"   		class="cabecera" nowrap="true"  media="html"  />
		<display:column title="<%=((Tiilc_conf_cabeceras_rep)cabeceras.get(i++)).getDescorta() %>" property="familia4"   			class="cabecera" nowrap="true"  media="html"  />
		<display:column title="<%=((Tiilc_conf_cabeceras_rep)cabeceras.get(i++)).getDescorta() %>" property="vida"   				class="cabecera" nowrap="true"  media="html"  />
		<display:column title="<%=((Tiilc_conf_cabeceras_rep)cabeceras.get(i++)).getDescorta() %>" property="onc_dent"   			class="cabecera" nowrap="true"  media="html"  />
		<display:column title="<%=((Tiilc_conf_cabeceras_rep)cabeceras.get(i++)).getDescorta() %>" property="proteccion_tc"   	class="cabecera" nowrap="true"  media="html"  />
		<display:column title="<%=((Tiilc_conf_cabeceras_rep)cabeceras.get(i++)).getDescorta() %>" property="otros_seguros"   	class="cabecera" nowrap="true"  media="html"  />
		<display:column title="<%=((Tiilc_conf_cabeceras_rep)cabeceras.get(i++)).getDescorta() %>" property="familia5"   			class="cabecera" nowrap="true"  media="html"  />
		<display:column title="<%=((Tiilc_conf_cabeceras_rep)cabeceras.get(i++)).getDescorta() %>" property="total_puntos"   	class="cabecera" nowrap="true"  media="html"  />
		<display:column title="<%=((Tiilc_conf_cabeceras_rep)cabeceras.get(i++)).getDescorta() %>" property="perfil"   			class="cabecera" nowrap="true"  media="html"  />
		<display:column title="<%=((Tiilc_conf_cabeceras_rep)cabeceras.get(i++)).getDescorta() %>" property="libre1"   			class="cabecera" nowrap="true"  media="html"  />
		<display:column title="<%=((Tiilc_conf_cabeceras_rep)cabeceras.get(i++)).getDescorta() %>" property="libre2"   			class="cabecera" nowrap="true"  media="html"  />
		<display:column title="<%=((Tiilc_conf_cabeceras_rep)cabeceras.get(i++)).getDescorta() %>" property="libre3"   			class="cabecera" nowrap="true"  media="html"  />
 		<%} %>
 		</display:table>
 		
 		</div>
</form>
</body>
</html:html>