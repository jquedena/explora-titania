<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@page import="java.util.Vector"%>
<%@page import="com.grupobbva.bc.per.tel.iilc.serializable.Multitabla"%>
<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK rel="stylesheet"
	href='<c:out value="${pageContext.request.contextPath}"/>/theme/IIRGEspacio2.css'
	type="text/css">
	
	<style type="text/css">
<!--
.Estilo1 {color: #FF8000}
.Estilo2 {color: #33CC66}
-->
</style>

<TITLE></TITLE>
<%
Vector listaEtiSeg = (Vector)request.getSession().getAttribute("listaEtiSeg");
Vector listaFamilias = (Vector)request.getSession().getAttribute("listaFamilias");
Vector listaNivelVin = (Vector)request.getSession().getAttribute("listaNivelVin");

String tituloNV=(String)request.getSession().getAttribute("tituloNV");
String tituloETySEG=(String)request.getSession().getAttribute("tituloETySEG");

Multitabla bean = null;

 %>
</HEAD>
<script language="javascript">
 var req;
 var tipoS;
 var ventana;
 /*
  * Get the second options by calling a Struts action
  */
  /*
  P060049
  */
  	function abrir(pagina) {
		var opciones="toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, width=360px, height=420px, top=85, left=140";
		window.open(pagina,"",opciones);
	}
 	function retrieveOptions(tipo){
	    tipoS = tipo;
	    territorio = document.forms[0].territorio;
	    oficina = document.forms[0].oficina;
	    gestor = document.forms[0].gestor;
	    
	    if (tipoS == 'T' && territorio.value == "-1"){
			oficina.options.length = 0;
			oficina.options[0] = new Option('TODOS', '-1');
			gestor.options.length = 0;
			gestor.options[0] = new Option('TODOS', '-1');
			return null;
		}
		else {
			if (tipoS == 'O' && oficina.value == "-1"){	
				gestor.options.length = 0;
				gestor.options[0] = new Option('TODOS', '-1');
				return null;
			}
		}
	
			
	    
	    url='<c:out value="${pageContext.request.contextPath}"/>/cargaDatos.do?method=cargaSelect&tipo='+tipo+'&territorio='+territorio.value+'&oficina='+oficina.value;
	    if (window.XMLHttpRequest){ // Non-IE browsers
	    	req = new XMLHttpRequest();
			req.onreadystatechange = populateBox;
      		req.open("GET", url, true); 
			req.send(null);
	    } else {
	    	if (window.ActiveXObject) { // IE     
		      	req = new ActiveXObject("Microsoft.XMLHTTP");
	    	  	if (req) {
	        		req.onreadystatechange = populateBox;
	        		req.open("GET", url, true);
		        	req.send();
	    	  	}
	    	}else {metodo2('carga');}
	  	}
	}
  
  //Callback function
	function populateBox(){
		var element;
		if (tipoS == 'T'){
			element = document.forms[0].oficina;
			
			document.forms[0].oficina.options.length = 0;
			document.forms[0].oficina.options[0] = new Option('TODOS', '-1');
		}
		else {
			if (tipoS == 'O')	
				element = document.forms[0].gestor;
		}

		document.forms[0].gestor.options.length = 0;
		document.forms[0].gestor.options[0] = new Option('TODOS', '-1');
		
		
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
        		if(textToSplit == '803'){
				}
	        //Split the document
		        returnElements=textToSplit.split("||");
		        if (returnElements == "")
	          		return;
	          	
	          	//Process each of the elements 	
		        for ( var i=0; i<returnElements.length; i++ ){
	    	       	valueLabelPair = returnElements[i].split("|");
	    	       	element.options[i+1] = new Option(valueLabelPair[1], valueLabelPair[0]);
		        }
    	    }
      	}    
	}
</script>

<script language="javascript">
	function metodo1(param1){
	
	    gestor = document.getElementById("gestor").value;
  	    document.forms[0].gestorCombo.value=gestor;
		document.forms[0].method.value = param1;
		document.forms[0].target="contenido";
		document.forms[0].action='<c:out value="${pageContext.request.contextPath}"/>/consultaListadoConduccionAction.do';
		document.forms[0].submit();
	}
	
	function metodo2(param1){
		document.forms[0].method.value = param1;
		document.forms[0].target="_self";
		document.forms[0].action='<c:out value="${pageContext.request.contextPath}"/>/consultaListadoConduccionAction.do';
		document.forms[0].submit();
	}
	
	function carga(){
		if (document.forms[0].territorio.value != "-1"){
	     	if (document.forms[0].oficina.value == "-1"){
	    		//document.forms[0].oficina.focus();
	     	}else{
		     	if (document.forms[0].gestor.value == "-1"){
		    		//document.forms[0].gestor.focus();
		     	}
		    }
		}    
	}
	
	function openFile(tipo){ 
		var opciones="toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, width=300px, height=200px, top=85, left=140";
		ventana = window.open('<c:out value="${pageContext.request.contextPath}"/>/consultaListadoConduccionAction.do?method=espera&tipo='+tipo,"",opciones);
	} 
	function popup(){
	window.open("cargaDatos.do?method=cargaEtiquetaSegmento","popup" , "width=800,height=400,scrollbars=YES,left=220,top=200,screenX=0,screenY=100'")
	}
	function popup2(){
	window.open("iilc_nivel_vinculacion.jsp","popup" , "width=600,height=400,scrollbars=YES,left=220,top=200,screenX=0,screenY=100'")
	}
	
	function mostrarTabla(param,codigo){
	    territorio = document.getElementById("territorio").value;
	    oficina = document.getElementById("oficina").value;
	    gestor = document.getElementById("gestor").value;
	
		document.forms[0].target="_self";
		document.forms[0].action="cargaDatos.do?method=cargaNVyET&parametro="+param+"&codigo="+codigo+"&codTerritorio="+territorio+"&codOficina="+oficina+"&codGestor="+gestor;
		document.forms[0].submit();		
	}
</script>
<BODY onload="carga();">
<html:form action="/consultaListadoConduccionAction">
	<input type="hidden" name="method" />
	<input type="hidden" name="gestorCombo" >
	<html:hidden property="cod_empresa" value="-1"/>
	<!-- TABLA DE COMBOS PARA CONSULTA -->
	<TABLE width="100%" align="center">
		<TR>
			<TD colspan="9" align="right">
			<TABLE>
				<TR>
					<TD class="Boton" align="center"><IMG name="exportar" border="0"
						style="CURSOR: hand"
						src="<c:out value="${pageContext.request.contextPath}"/>/images/JPEG_excel_28.gif"
						width="28" height="28" onclick="javascript: openFile('exportacion');"><br>
					<bean:message key="exportar" /></TD>
				</TR>
			</TABLE>
			</TD>

		</TR>
	</TABLE>

	<!-- TABLA DE COMBOS PARA CONSULTA -->
	<TABLE width="100%" align="center">
		<TR>
			<TD class="FondoAzulPeq" width="140"><bean:message key="territorio" /></TD>
			<TD><html:select property="territorio" styleId="territorio" disabled='${terr}' styleClass="filtro"
				onchange="retrieveOptions('T')">
				<html:option value="-1" selected>TODOS</html:option>
				<c:if test="${listaTerritorio != null}">
					<c:forEach var="territorio" items="${listaTerritorio}">
						<html:option value="${territorio.cod_territorio}">
							<c:out value="${territorio.des_territorio}" />
						</html:option>
					</c:forEach>
				</c:if>
			</html:select></TD>
			<TD></TD>
			<TD class="FondoAzulPeq" width="140"><bean:message key="oficina" /></TD>
			<TD><html:select property="oficina" styleId="oficina" disabled='${ofic}' styleClass="filtro"
				onchange="retrieveOptions('O')">
				<html:option value="-1" selected>TODOS</html:option>
				<c:if test="${listaOficina != null}">
					<c:forEach var="oficina" items="${listaOficina}">
						<html:option value="${oficina.cod_oficina}">
							<c:out value="${oficina.des_oficina}" />
						</html:option>
					</c:forEach>
				</c:if>
			</html:select></TD>
			<TD></TD>
			<TD class="FondoAzulPeq" width="140"><bean:message key="gestor" /></TD>
			<TD><html:select property="gestor" styleId="gestor" disabled='${gest}' styleClass="filtro2">
				<html:option value="-1" selected>TODOS</html:option>
				<c:if test="${listaGestor != null}">
					<c:forEach var="gestor" items="${listaGestor}">
						<html:option value="${gestor.cod_gestor}">
							<c:out value="${gestor.nom_gestor}" /> - <c:out value="${gestor.perfil_gestor}" />
						</html:option>
					</c:forEach>
				</c:if>
			</html:select></TD>
			<TD></TD>
		</TR>
		<TR>
			<TD bgcolor="#2D4492" width="140"><div class="enlace2" align="center"><a href="javascript:popup2();"><bean:message
				key="nivel_vinculacion" /></a></div></TD>
			<TD><html:select property="nivel_vinculacion" styleClass="filtro" onchange="mostrarTabla('NV',this.value)">
				<html:option value="-1" selected>TODOS</html:option>
				<c:if test="${listaNivelVinculacion != null}">
					<c:forEach var="nivelVinculacion" items="${listaNivelVinculacion}">
						<html:option
							value="${nivelVinculacion.cod_mult}${nivelVinculacion.cod_ele}">
							<c:out value="${nivelVinculacion.valor1}" />
					  	</html:option>
					</c:forEach>
				</c:if>
			</html:select></TD>
			<TD></TD>
			<TD class="FondoAzulPeq" width="140"><bean:message
				key="clasificacion" /></TD>
			<TD><html:select property="clasificacion" styleClass="filtro">
				<html:option value="-1" selected>TODOS</html:option>
				<c:if test="${listaClasificacion != null}">
					<c:forEach var="clasificacion" items="${listaClasificacion}">
						<html:option
							value="${clasificacion.cod_mult}${clasificacion.cod_ele}">
							<c:out value="${clasificacion.valor1}" />
						</html:option>
					</c:forEach>
				</c:if>
				<html:option value="9001" selected>NO CLASIFICADO</html:option>
			</html:select></TD>
			<TD></TD>
			<TD class="FondoAzulPeq" width="140"><bean:message
				key="margen_ordinario" /></TD>
			<TD><html:select property="margen_ordinario" styleClass="filtro">
				<html:option value="-1" selected>TODOS</html:option>
				<c:if test="${listaMargenOrdinario != null}">
					<c:forEach var="margenOrdinario" items="${listaMargenOrdinario}">
						<html:option
							value="${margenOrdinario.cod_mult}${margenOrdinario.cod_ele}">
							<c:out value="${margenOrdinario.valor1}" />
						</html:option>
					</c:forEach>
				</c:if>
			</html:select></TD>
			<TD></TD>
		</TR>
		<TR>
			<TD bgcolor="#2D4492" width="140"><div class="enlace2" align="center"><a href="javascript:popup();"><bean:message
				key="etiqueta" /></a></div></TD>
			<TD><html:select property="etiqueta" styleClass="filtro" onchange="mostrarTabla('ET',this.value)">
				<html:option value="-1" selected>TODOS</html:option>
				<c:if test="${listaEtiqueta != null}">
					<c:forEach var="etiqueta" items="${listaEtiqueta}">
						<html:option value="${etiqueta.cod_mult}${etiqueta.cod_ele}">
							<c:out value="${etiqueta.valor1}" />
						</html:option>
					</c:forEach>
				</c:if>
				<!-- <html:option value="9001" selected>OTROS</html:option> -->
			</html:select></TD>
			<TD></TD>
			<TD class="FondoAzulPeq" width="140"><bean:message key="edad" /></TD>
			<TD><html:select property="edad" styleClass="filtro">
				<html:option value="-1" selected>TODOS</html:option>
				<c:if test="${listaEdad != null}">
					<c:forEach var="edad" items="${listaEdad}">
						<html:option value="${edad.cod_mult}${edad.cod_ele}">
							<c:out value="${edad.valor1}" />
						</html:option>
					</c:forEach>
				</c:if>
			</html:select></TD>
			<TD></TD>
			<TD class="FondoAzulPeq" width="140"><bean:message
				key="cuota_riesgo_total" /></TD>
			<TD><html:select property="cuota_riesgo_total" styleClass="filtro">
				<html:option value="-1" selected>TODOS</html:option>
				<c:if test="${listaCuotaRiesgoTotal != null}">
					<c:forEach var="cuotaRiesgoTotal" items="${listaCuotaRiesgoTotal}">
						<html:option
							value="${cuotaRiesgoTotal.cod_mult}${cuotaRiesgoTotal.cod_ele}">
							<c:out value="${cuotaRiesgoTotal.valor1}" />
						</html:option>
					</c:forEach>
				</c:if>
			</html:select></TD>
			<TD></TD>
		</TR>
		<!-- MEJORA : PAGO DE HABERES : P060049 EDGAR ZAVALETA SIERRALTA -->
		<TR>
			<TD class="FondoAzulPeq" width="140"><bean:message key="pago_haberes" /></TD>
			<TD>
			
				<html:text property="des_empresa" styleClass="empresa" value="TODOS" readonly="true"></html:text>
				<IMG alt="Agregar" border="0"  src="<c:out value="${pageContext.request.contextPath}"/>/images/search_16.gif" width="16" height="16" style="CURSOR: hand" onclick="javascript:abrir('<c:out value="${pageContext.request.contextPath}"/>/consultaListadoConduccionAction.do?method=cargaEmpresa');"/>
			</TD>
			<TD colspan="7" ></TD>
		</TR>
	</TABLE>

	    	<!-- TABLA DE DESCRIPCION PARA NIVEL DE VINCULACION Y SEGMENTOS -->
	<%if(listaEtiSeg!=null || listaNivelVin!=null){%>
	<TABLE width="100%" align="left">            
			<%if(listaNivelVin!=null){%> 
				<tr>
					<TD  align="left">			
						<table cellspacing="0" cellpadding="0" border="1">
						<%  String colorfila = "";
							for(int i=0;i<listaNivelVin.size();i++){
							bean = (Multitabla)listaNivelVin.elementAt(i);    
			
							if (i%2 != 0)
								colorfila = "FondoGris1";
							else
								colorfila = "FondoGris2";
							%>				
						<tr>			
						<td align="center"  class="FondoAzulPeq" width="200"><span class="Estilo1"><strong><%=bean.getValor1() %></strong></span>&nbsp;&nbsp;</td>
						<td align="center"  class="<%=colorfila %>">&nbsp;<%=bean.getValor2() %></td>
						</tr>
						<%}%>
						</table>
			            </TD>
		            	<%if(listaEtiSeg!=null && listaNivelVin!=null){%>
           					<TD align="right"><html:button property="buscar" styleClass="boton" onclick="metodo1('buscar');">BUSCAR</html:button></TD>
		            	<%} %>
				<%if(listaEtiSeg==null){%>
				<TD align="right"><html:button property="buscar" styleClass="boton" onclick="metodo1('buscar');">BUSCAR</html:button></TD>
				<%} %>
            
				</tr>
			<%}%>
			<%if(listaEtiSeg!=null){%>
				<TR>
					<TD align="left">            
						<table cellspacing="0" cellpadding="0" border="1">
						<tr>
						<td align="center" class="FondoAzulPeq" width="200"><span class="Estilo2"><STRONG> ETIQUETA: <%=tituloETySEG %>&nbsp;&nbsp;</STRONG></span></td>			
						<%  String colorfila = "";
							for(int i=0;i<listaEtiSeg.size();i++){
							bean = (Multitabla)listaEtiSeg.elementAt(i);
							if (i%2 != 0)
								colorfila = "FondoGris1";
							else
								colorfila = "FondoGris2";
							%>			  			
						<td align="center" class="<%=colorfila %>">&nbsp;<%=bean.getValor2() %>&nbsp;</td>			  
						<%}%>
						</tr>
						</table>                
					</TD>
				<%if(listaNivelVin==null){%>
				<TD align="right"><html:button property="buscar" styleClass="boton" onclick="metodo1('buscar');">BUSCAR</html:button></TD>
				<%} %>
				</TR>
			<%} %> 
	</TABLE>
		<%if(listaNivelVin==null){ %>
		<br><br>
		<%} %>
		<%if(listaEtiSeg==null){ %>
		<br><br><%} %>
		<%if(listaEtiSeg!=null && listaNivelVin!=null){ %>
		<br><br><br><br>
		<%} %>	
	<%} %>
	<!-- TABLA DE RADIOBUTTONS PARA CONSULTAS -->
	<TABLE width="100%">
	<%if(listaNivelVin==null && listaEtiSeg==null){%>			
			<TR><TD colspan="10"></TD>
			<TD align="right"><html:button property="buscar" styleClass="boton" onclick="metodo1('buscar');">BUSCAR</html:button></TD>			
			</TR>
			<%} %>
		<TR>
			<TD colspan="12">&nbsp;</TD>
		</TR>
		<TR>
			<TD class="FondoGris38" width="12%"><bean:message
				key="detalle_general" /></TD>
			<TD width="5%"><html:radio property="tipo_detalle" value="dt_general"
				onclick="metodo1('detalle');"></html:radio></TD>

			<TD class="FondoGris38" width="12%"><bean:message
				key="detalle_activo" /></TD>
			<TD width="5%"><html:radio property="tipo_detalle" value="dt_activo"
				onclick="metodo1('detalle');"></html:radio></TD>

			<TD class="FondoGris38" width="12%"><bean:message
				key="detalle_tarjetas" /></TD>
			<TD width="5%"><html:radio property="tipo_detalle"
				value="dt_tarjetas" onclick="metodo1('detalle');"></html:radio></TD>

			<TD class="FondoGris38" width="12%"><bean:message
				key="detalle_pasivo" /></TD>
			<TD width="5%"><html:radio property="tipo_detalle" value="dt_pasivo"
				onclick="metodo1('detalle');"></html:radio></TD>

			<TD class="FondoGris38" width="12%"><bean:message
				key="detalle_servicios" /></TD>
			<TD width="5%"><html:radio property="tipo_detalle"
				value="dt_servicios" onclick="metodo1('detalle');"></html:radio></TD>

			<TD class="FondoGris38" width="12%"><bean:message
				key="detalle_canales" /></TD>
			<TD width="3%"><html:radio property="tipo_detalle" value="dt_canales"
				onclick="metodo1('detalle');"></html:radio></TD>
		</TR>
	</TABLE>
</html:form>
</BODY>
</html:html>



