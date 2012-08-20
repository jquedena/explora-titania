
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/displaytag-11.tld" prefix="display"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@ page import="java.util.List" session="true"    %>
<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="generator" content="Bluefish 2.0.3" >
 
<script language="javascript" type="text/javascript" src="<c:out value="${pageContext.request.contextPath}"/>/includes/datetimepicker.js">
//Date Time Picker script- by TengYong Ng of http://www.rainforestnet.com
//Script featured on JavaScript Kit (http://www.javascriptkit.com)
//For this script, visit http://www.javascriptkit.com 
</script>
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

<script type="text/javascript" src="${pageContext.request.contextPath}/includes/js/contexto.js"></script>
<script type="text/javascript">
var contexto = obtenerContexto();

hayResultados=<%=request.getAttribute("hayResultados")%>;

function consultarPorPagina(e){
	var totalPag=<%=Integer.parseInt(request.getAttribute("cantidadDetalle").toString())%>;
	var objPag = document.forms[0].paginaActual;
	var tecla =  e.keyCode ;
	
	if(tecla==13){
		objPag.value = objPag.value.trimAll();
		if(!esSoloNumero(objPag.value)){
			alert("No es un número de página válido");
			objPag.value=<%=request.getAttribute("paginaActual")%>;
				objPag.focus();
				objPag.select();
		}
		else{
			if(objPag.value<1 || objPag.value>totalPag){
				alert("El número de página debe estar entre 1 y " + totalPag);
				objPag.value=<%=request.getAttribute("paginaActual")%>;
				objPag.focus();
				objPag.select();
			}
			else{
					document.forms[0].action = contexto+"reporteHistoricoSeguimiento.do?method=buscar";       
					document.forms[0].submit();
			}
		} 
	}
}

function openFile(tipo){
	if(hayResultados){
		var opciones="toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, width=300px, height=200px, top=85, left=140";
		ventana = window.open("reporteHistoricoSeguimiento.do?method=espera&tipo="+tipo+"&origenVinculacion="+document.forms[0].tipoReporte.value+
																"&tipoReporte="+document.forms[0].tipoReporte.value
																+"&territorio="+document.forms[0].territorio.value
																+"&oficina="+document.forms[0].oficina.value
																+"&perfil="+document.forms[0].perfil.value
																+"&gestor="+document.forms[0].gestor.value
																+"&fechaInicio="+document.forms[0].fechaInicio.value
																+"&fechaFin="+document.forms[0].fechaFin.value,"",opciones);
	}
	else{
		alert("No hay resultados para exportar.");
	}
}

function limpiar(){
	document.forms[0].territorio.value="-1";
	document.forms[0].oficina.value="-1";
	document.forms[0].perfil.value="-1";
	document.forms[0].gestor.value="-1";
	
	document.forms[0].fechaInicio.value=document.forms[0].fechaOriginal.value;
	document.forms[0].fechaFin.value=document.forms[0].fechaOriginal.value;
	
	updateBotonesFiltro();
}
 
function datoFiltro(){
	var codigos;
}
 
 
 function abrirFiltro(tipo){
 	var parametros='';
 
	if(tipo==0)
		datoFiltro.codigos = document.forms[0].territorio.value;

	if(tipo==1){
		parametros="&territorio="+document.forms[0].territorio.value;
		datoFiltro.codigos = document.forms[0].oficina.value;
	}
	if(tipo==2){
		parametros="&territorio="+document.forms[0].territorio.value+"&oficina="+document.forms[0].oficina.value;
		datoFiltro.codigos = document.forms[0].gestor.value;
		}
	if(tipo==3)
		datoFiltro.codigos = document.forms[0].perfil.value;
		
	var url = "consulta2.do?method=filtroHistorico&tipo=" + tipo+parametros;
	
	if(window.showModalDialog(url,datoFiltro,"dialogWidth:240px;dialogHeight:360px;")){
		if(tipo==0)
			document.forms[0].territorio.value = datoFiltro.codigos;
		if(tipo==1)
			document.forms[0].oficina.value = datoFiltro.codigos;
		if(tipo==2)
			document.forms[0].gestor.value = datoFiltro.codigos;
		if(tipo==3)
			document.forms[0].perfil.value = datoFiltro.codigos;

		updateBotonesFiltro();
	}
	else{
		return;
	}
	
}
 
 
 
 function updateBotonesFiltro(){
	if(document.forms[0].territorio.value=='null' || document.forms[0].territorio.value==null || document.forms[0].territorio.value=="-1"){
		if(document.getElementById("btnTerritorio")!=null){
			document.getElementById("btnTerritorio").value = "Todos";
			document.getElementById("btnTerritorio").className = "botonFiltro";
		}
	}
	else{
		if(document.getElementById("btnTerritorio")!=null){
			document.getElementById("btnTerritorio").value = "Filtrado";
			document.getElementById("btnTerritorio").className = "botonFiltroLleno";
		}
	}
	if(document.forms[0].oficina.value=='null' || document.forms[0].oficina.value==null || document.forms[0].oficina.value=="-1"){
		if(document.getElementById("btnOficina")!=null){
			document.getElementById("btnOficina").value = "Todos";
			document.getElementById("btnOficina").className = "botonFiltro";
		}
	}
	else{
		if(document.getElementById("btnOficina")!=null){
			document.getElementById("btnOficina").value = "Filtrado";
			document.getElementById("btnOficina").className = "botonFiltroLleno";
		}
	}
	if(document.forms[0].gestor.value=='null' || document.forms[0].gestor.value==null || document.forms[0].gestor.value=="-1"){
		if(document.getElementById("btnGestor")!=null){
			document.getElementById("btnGestor").value = "Todos";
			document.getElementById("btnGestor").className = "botonFiltro";
		}
	}
	else{
		if(document.getElementById("btnGestor")!=null){
			document.getElementById("btnGestor").value = "Filtrado";
			document.getElementById("btnGestor").className = "botonFiltroLleno";
		}
	}
	if(document.forms[0].perfil.value=='null' || document.forms[0].perfil.value==null || document.forms[0].perfil.value=="-1"){
		if(document.getElementById("btnPerfil")!=null){
			document.getElementById("btnPerfil").value = "Todos";
			document.getElementById("btnPerfil").className = "botonFiltro";
		}
	}
	else{
		if(document.getElementById("btnPerfil")!=null){
			document.getElementById("btnPerfil").value = "Filtrado";
			document.getElementById("btnPerfil").className = "botonFiltroLleno";
		}
	}
}
 
 
 function cargaFiltro(tipoConsolidado){

	window.location = contexto+"reporteHistoricoSeguimiento.do?method=buscar&tipoReporte="+tipoConsolidado
																+"&territorio="+document.forms[0].territorio.value
																+"&oficina="+document.forms[0].oficina.value
																+"&perfil="+document.forms[0].perfil.value
																+"&gestor="+document.forms[0].gestor.value
																+"&fechaInicio="+document.forms[0].fechaInicio.value
																+"&fechaFin="+document.forms[0].fechaFin.value;
 }
 
 
function buscar(){

	window.location = contexto+"reporteHistoricoSeguimiento.do?method=buscar&tipoReporte="+document.forms[0].tipoReporte.value
																+"&territorio="+document.forms[0].territorio.value
																+"&oficina="+document.forms[0].oficina.value
																+"&perfil="+document.forms[0].perfil.value
																+"&gestor="+document.forms[0].gestor.value
																+"&fechaInicio="+document.forms[0].fechaInicio.value
																+"&fechaFin="+document.forms[0].fechaFin.value;
																
																
}
 
 
 
function paginar(pagina){
	window.location = contexto+"reporteHistoricoSeguimiento.do?method=buscar&tipoReporte="+document.forms[0].tipoReporte.value
																+"&territorio="+document.forms[0].territorio.value
																+"&oficina="+document.forms[0].oficina.value
																+"&perfil="+document.forms[0].perfil.value
																+"&gestor="+document.forms[0].gestor.value
																+"&fechaInicio="+document.forms[0].fechaInicio.value
																+"&fechaFin="+document.forms[0].fechaFin.value
																+"&paginaActual="+pagina
																;
																
																
}
  
function validacionMensaje(){
 
	 if(document.forms[0].mensaje.value!=''){
	 	alert(document.forms[0].mensaje.value);
	 }
 
}
  
function pintarDetalles(datos){
	var html = "";
	var objDiv = document.getElementById("divDetalleFiltros");
	
	html+="<table border='0' cellspacing='0' cellpadding='0' width='97%'>"
	if(datos.length > 0){
		html+="<tr class='detalle'>";
		html+="<td class='detalle2'>" + datos + "</td>";
		html+="</tr>";
	}
	
	html+="</table>";
	objDiv.innerHTML = html;
	objDiv.style.visibility = "visible";
}
</script>
</HEAD>
<BODY    onload="updateBotonesFiltro();validacionMensaje();pintarDetalles('<%=request.getAttribute("desc_filtro")%>')"  >
<html:form action="/reporteHistoricoSeguimiento.do" >
 <input type="hidden" value="<%=request.getParameter("tipoReporte") %>" name="tipoReporte" id="tipoReporte" />
 <input type="hidden" value="<%=request.getAttribute("mensaje") %>" name="mensaje" id="mensaje" />
 <input type="hidden" value="buscar" name="method" id="method" />

<input type="hidden" name="fechaOriginal" id="fechaOriginal" value='<%=request.getAttribute("fechaOriginal") %>'  />
<input type="hidden" value="<%=(request.getAttribute("hid_territorio")==null || request.getAttribute("hid_territorio").equals("") )?request.getParameter("territorio"):request.getSession().getAttribute("cod_territorio").toString()%>" name="territorio" id="territorio" />
<input type="hidden" value="<%=(request.getAttribute("hid_oficina")==null || request.getAttribute("hid_oficina").equals("") )?request.getParameter("oficina"):request.getSession().getAttribute("cod_oficina").toString() %>" name="oficina" id="oficina" />
<input type="hidden" value="<%=(request.getAttribute("hid_gestor")==null || request.getAttribute("hid_gestor").equals("") )?request.getParameter("gestor"):request.getSession().getAttribute("gestor").toString() %>" name="gestor" id="gestor" />
<input type="hidden" value="<%=request.getParameter("perfil") %>" name="perfil" id="perfil" />
  	<table width="100%" border="0" cellpadding="1" cellspacing="1" >
	 <tr> 
		 <td  width="33%" align="left" >
		 
		 		<table width="90%" border="0" cellpadding="0" cellspacing="0"  >
		 			<tr>
		 			<td class="FondoAzulPeq" width="50%" >
		 				TERRITORIO
		 			</td>
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
		 <td  width="33%" align="left" >
		 
		 		<table width="90%" border="0" cellpadding="0" cellspacing="0"  >
		 			<tr>
		 			<td class="FondoAzulPeq"  width="50%">
		 				OFICINA
		 			</td>
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
		 <td  width="33%" align="left" >
		 
		 		<table width="90%" border="0" cellpadding="0" cellspacing="0"  >
		 			<tr>
		 			<td class="FondoAzulPeq" width="50%" >
		 				GESTOR
		 			</td>
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
	</tr>
	
	 <tr> 
		 <td  width="33%" align="left" >
		 
		 		 <table width="90%" border="0" cellpadding="0" cellspacing="0"  >
		 			<tr>
		 			<td class="FondoAzulPeq"  width="50%">
		 				CARGO O PERFIL
		 			</td>
		 			<td width="50%">
		 				<input type="button" class="botonFiltro" id="btnPerfil" value="Todos" onclick="abrirFiltro(3);" />
		 			</td>
		 			</tr>
		 		</table>
		 
		 </td>
		 <td  width="33%" align="left" >
		 
		 		<table width="90%" border="0" cellpadding="0" cellspacing="0"  >
		 			<tr>
		 			<td class="FondoAzulPeq" width="50%" >
		 				FECHA INICIO
		 			</td>
		 			<td width="50%">
		 				<input type="text" id="fechaInicio" name="fechaInicio" 
									 readonly="readonly"
									 style="width: 90px;"
									 value="<%=(request.getAttribute("fechaInicio")!=null)?request.getAttribute("fechaInicio"):"" %>"  
						/>
						<a href="javascript:NewCal('fechaInicio','ddMMyyyy')">
							<img src="<c:out value="${pageContext.request.contextPath}"/>/images/cal.gif" width="16" height="16" border="0" >
						</a>
		 			</td>
		 			</tr>
		 		</table>
		 
		 </td>
		 <td  width="33%" align="left" >
		 
		 		 <table width="90%" border="0" cellpadding="0" cellspacing="0"  >
		 			<tr>
		 			<td class="FondoAzulPeq" width="50%" >
		 				FECHA FIN
		 			</td>
		 			<td width="50%">
		 				<input type="text" id="fechaFin" name="fechaFin" 
									 readonly="readonly"
									 style="width: 90px;"
									 value="<%=(request.getAttribute("fechaFin")!=null)?request.getAttribute("fechaFin"):"" %>"  
						/>
						<a href="javascript:NewCal('fechaFin','ddMMyyyy')">
							<img src="<c:out value="${pageContext.request.contextPath}"/>/images/cal.gif" width="16" height="16" border="0" >
						</a>
		 			</td>
		 			</tr>
		 		</table>
		 
		 </td>
	</tr>
	 <tr> 
		 <td  width="66%" colspan="2" align="left" >
 			 	<input type="radio" <%=request.getParameter("tipoReporte").equals("D")?"checked='checked'":"" %> name="filtroConsolidado"     onclick="cargaFiltro('D');" >Reporte consolidado por d&iacute;a
			 	<input type="radio" <%=request.getParameter("tipoReporte").equals("T")?"checked='checked'":""  %> name="filtroConsolidado"     onclick="cargaFiltro('T');" >Reporte consolidado resumen
		 </td>
		 <td  width="33%" align="left" >
		 
		 		 <table width="90%" border="0" cellpadding="0" cellspacing="0"  >
		 			<tr>
		 			<td width="90%" align="right" >
		 			<html:button property="cancelar" styleClass="boton" onclick="limpiar();">Limpiar</html:button>
								<html:button property="cancelar2" styleClass="boton" onclick="buscar();">Buscar</html:button>
								
		 			</td>
		 			<td width="10%"  style="text-align:center;padding-left:5px;padding-right:5px;font-size:10px;" >
		 			<img id="btnExcel" src="<c:out value="${pageContext.request.contextPath}"/>/images/btnExcel1.gif" width="28" height="23" border="0"
									style="CURSOR: hand" onclick="openFile('exportacion');"  >
									<br/>Exportar
		 			</td>
		 			</tr>
		 		</table>
		 
		 </td>
	</tr>
	
	</table>
	<div id="divDetalleFiltros" class="detalle" style="visibility:hidden;"></div> 
	<center>
 	<%if(((List)request.getAttribute("listadoDetalle")).size()>0){
		int cantidadDetalle=Integer.parseInt(request.getAttribute("cantidadDetalle").toString());
		if(cantidadDetalle>1){
		%>
			<%if(Integer.parseInt(request.getAttribute("paginaActual").toString())>1){ %>
			<a href="#" onclick="paginar(1);" ><img border="0" alt="Primera" src="<c:out value="${pageContext.request.contextPath}"/>/images/btn_primero.png"></a>
			<a href="#" onclick='paginar(<%=Integer.parseInt(request.getAttribute("paginaActual").toString())-1 %>);'  ><img  border="0" alt="Anterior" src="<c:out value="${pageContext.request.contextPath}"/>/images/btn_anterior.png"></a>
			<%} %>
			Pagina : 
			<input type="text"  value="<%=request.getAttribute("paginaActual").toString()%>"  name="paginaActual" id="paginaActual" size="3" maxlength="6" 
							onkeypress="consultarPorPagina(event);"	/>
							 de <%=(cantidadDetalle) %>
			&nbsp;
			<%if(cantidadDetalle!=Integer.parseInt(request.getAttribute("paginaActual").toString())){ %>
			<a href="#" onclick='paginar(<%=Integer.parseInt(request.getAttribute("paginaActual").toString())+1 %>);' ><img  border="0" alt="Siguiente" src="<c:out value="${pageContext.request.contextPath}"/>/images/btn_siguiente.png"></a>
			<a href="#" onclick="paginar(<%=(cantidadDetalle) %>);"  ><img  border="0" alt="Ultima" src="<c:out value="${pageContext.request.contextPath}"/>/images/btn_ultimo.png"></a>
			<%} %>
		<%}else{ %>
 			Pagina :   <%=request.getAttribute("paginaActual").toString()%>
 		<%}
 		}%>
 	</center>
 		<div id="caja_scroll" style="width: 100%" >
 		
 		<display:table name="listadoDetalle"  id="lista"  summary="false"   width="100%" class="grilla"  >
 			<%if(request.getParameter("tipoReporte").equals("D")){ %>
 			<display:column   title="Fecha ingreso" property="fecha_ingreso"   class="cabecera"  media="html"  />
 			<%} %>
 			
 			<display:column title="C&oacute;digo territorio" property="cod_territorio"   class="cabecera" nowrap="true"  media="html"  />
 			<display:column   title="Descripci&oacute;n territorio" property="des_territorio"   class="cabecera" nowrap="true"  media="html"  />
 			<display:column   title="C&oacute;digo oficina" property="cod_oficina"   class="cabecera" nowrap="true"  media="html"  />
 			<display:column   title="Descripci&oacute;n oficina" property="des_oficina"   class="cabecera" nowrap="true"  media="html"  />
 			<display:column   title="Registro" property="usuario"   class="cabecera" nowrap="true"  media="html"  />
 			<display:column   title="Nombre" property="nombre_usuario"   class="cabecera" nowrap="true"  media="html"  />
 			<display:column   title="Cargo" property="des_cargo"   class="cabecera" nowrap="true"  media="html"  />
 			
 			<display:column   title="Ingresos a la aplicaci&oacute;n" property="total"   class="cabecera" nowrap="true"  media="html"  /> 
 
			<display:column   headerStyleClass="cabecera_celeste"  title="Nivel de vinculaci&oacute;n" property="nivel_vinculacion" class="cabecera" nowrap="true"  media="html"  />
 
			<display:column    headerStyleClass="cabecera_celeste"  title="Clasificaci&oacute;n" property="clasificacion"   class="cabecera" nowrap="true"  media="html"  />
			<display:column    headerStyleClass="cabecera_celeste"  title="Margen ordinario" property="margen_ordinario"   class="cabecera" nowrap="true"  media="html"  />
			<display:column    headerStyleClass="cabecera_celeste"  title="Etiqueta" property="etiqueta"   class="cabecera" nowrap="true"  media="html"  />
			<display:column    headerStyleClass="cabecera_celeste"  title="Edad" property="edad"   class="cabecera" nowrap="true"  media="html"  />
			<display:column    headerStyleClass="cabecera_celeste"   title="Cuota riesgo total" property="cuota"   class="cabecera" nowrap="true"  media="html"  />
			<display:column    headerStyleClass="cabecera_celeste"  title="Pago haberes" property="pago"   class="cabecera" nowrap="true"  media="html"  />
			<display:column   headerStyleClass="cabecera_verde" title="Todos " property="todos"   class="cabecera" nowrap="true"  media="html"  />
			<display:column   headerStyleClass="cabecera_verde" title="Activo" property="activo"   class="cabecera" nowrap="true"  media="html"  />
			<display:column   headerStyleClass="cabecera_verde" title="Tarjetas " property="tarjetas"   class="cabecera" nowrap="true"  media="html"  />
			<display:column   headerStyleClass="cabecera_verde" title="Pasivo" property="pasivo"   class="cabecera" nowrap="true"  media="html"  />
			<display:column   headerStyleClass="cabecera_verde" title="Servicios" property="servicios"   class="cabecera" nowrap="true"  media="html"  />
			<display:column   headerStyleClass="cabecera_verde" title="Ofertas" property="ofertas"   class="cabecera" nowrap="true"  media="html"  />
			<display:column   headerStyleClass="cabecera_verde" title="Otras ofertas" property="canales"   class="cabecera" nowrap="true"  media="html"  />
			<display:column   headerStyleClass="cabecera_naranja" title="exportaciones" property="exportar"   class="cabecera" nowrap="true"  media="html"  />

 		</display:table>

		</div>
		 
</html:form>
</BODY>
</html:html>
