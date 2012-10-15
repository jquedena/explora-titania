<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@ taglib prefix="fn" uri="/WEB-INF/fn.tld"%>
<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK rel="stylesheet" href='<c:out value="${pageContext.request.contextPath}"/>/theme/IIRGEspacio2.css' type="text/css">
<LINK rel="stylesheet" href='<c:out value="${pageContext.request.contextPath}"/>/theme/displaytag.css' type="text/css">
<TITLE></TITLE>
</HEAD>
<script language="javascript">
	function redimension(){
		f = document.getElementById('pagina').offsetHeight
		if (f<200) f=200;
		parent.document.getElementById('contenido').style.height = f + 60;
	}
	
	function onKeyPressNumbers(e,elem,num_pag){
		var key = window.event ? e.keyCode : e.which;
		var valor = elem.value;
		if (((key>47) && (key<=58) )  || (key==8)|| (key==183)|| (key==184)|| (key==9)) { 
			valor = valor + String.fromCharCode(key)
			if (valor <= num_pag){
				return true; 
			}
		}else
			if (key == 13) { 
				metodo1('paginacion',valor)
				return true;
			}
		return false;
	}
	
	function metodo1(param1,param2){
		document.forms[0].pagina.value=param2;
		document.forms[0].method.value=param1;
		document.forms[0].submit();
	}
	
	function metodo2(param1,param2){
		document.forms[0].pagina.value= param2+(document.forms[0].pagina.value/1);
		document.forms[0].method.value=param1;
		document.forms[0].submit();
	}
	
	alert('Test me voy a volver loko');
</script>

<BODY onload="redimension();">
<div id="pagina" style="overflow:auto;">
<html:form action="/consultaListadoConduccionAction" >
	<!-- TABLA DE COMBOS PARA CONSULTA -->
	<input type="hidden" name="method"/>
	<c:if test="${listaConduccion != null}">
	<TABLE width="100%" align="center" border="0">
	<tr>
		<%if(Integer.parseInt((String)request.getSession().getAttribute("pag_actual")) > 1 ) {%>
		<td width="16px" style="padding-top: 4px;">
			<IMG alt="Ver primera página" border="0" style="CURSOR: hand" src="<c:out value="${pageContext.request.contextPath}"/>/images/btn_primero.png" width="16" height="16" onclick="metodo1('paginacion',1)">
		</td>
		<td width="16px" style="padding-top: 4px;">
			<IMG alt="Ver página anterior" border="0" style="CURSOR: hand" src="<c:out value="${pageContext.request.contextPath}"/>/images/btn_anterior.png" width="16" height="16" onclick="metodo2('paginacion',-1)">
		</td>
		<%}%>
		<td width="18px" style="padding-top: 4px;">Pag.</td>
		<td width="30px"><html:text property="pagina" size="2" maxlength="4"  onkeypress="return onKeyPressNumbers(event,this, ${num_paginas});"></html:text>
		</td>
		<td width="55px" style="padding-top: 4px;">de ${num_paginas}</td>
		
		<%if(Integer.parseInt((String)request.getSession().getAttribute("pag_actual")) < Integer.parseInt((String)request.getSession().getAttribute("num_paginas"))) {%>
		<td width="16px" style="padding-top: 4px;">
			<IMG alt="Ver siguiente página" border="0" style="CURSOR: hand" src="<c:out value="${pageContext.request.contextPath}"/>/images/btn_siguiente.png" width="16" height="16" onclick="metodo2('paginacion',1)">
		</td>
		<td width="16px"style="padding-top: 4px;">
			<IMG alt="Ver ultima página" border="0" style="CURSOR: hand" src="<c:out value="${pageContext.request.contextPath}"/>/images/btn_ultimo.png" width="16" height="16" onclick="metodo1('paginacion',${num_paginas})">
		</td>
		<%}%>
		<td>&nbsp;</td>
	</tr>
	</TABLE>
	<TABLE width="${table_width}" align="left" border="2">
		<tr><td>
		<table width="100%" border="0" align="center">
			<!-- Inicio Cabecera, definir aqui los anchos de cada celda-->
			<tr class="FondoAzul">
				<td class="LCtd" width="100px">COD---.CENTRALrev</td>
				<td class="LCtd" width="300px">NOMBRE</td>
			<c:choose>
			<c:when test="${fn:containsIgnoreCase(detalle, 'dt_general')}">
<!-- LISTA GENERAL -->
			<!-- PARTE 1 -->	
								
				<td class="LCtd" width="110px">PERSONA</td>
				<!--<td class="LCtd" width="80px">DOC/NRO.</td>-->
				<td class="LCtd" width="110px">PERFIL</td>
				<td class="LCtd" width="110px">E.CIVIL</td>
				<!--<td class="LCtd" width="350px">DIRECCIÓN</td>-->
				<td class="LCtd" width="110px">TELÉFONO</td>
				<!-- td class="LCtd" width="300px">EMPRESA</td -->

			<!-- PARTE 2 -->				
				<!--<td class="LCtd" width="150px">DEPTO.</td>-->
				<!--<td class="LCtd" width="150px">PROVINCIA</td>-->
				<!--<td class="LCtd" width="150px">DISTRITO</td>-->
				<td class="LCtd" width="110px">SEGMENTO</td>
				<td class="LCtd" width="110px">VINCULACION</td>
				<td class="LCtd" width="110px">T.ACTIVO</td>
				<td class="LCtd" width="110px">T.PASIVO</td>
				<td class="LCtd" width="110px">T.TARJETAS</td>
				<td class="LCtd" width="110px">T.SERVICIOS</td>
				
				<td class="LCtd" width="110px">MG.ORD.ACUM.</td>
		
			<!-- PARTE 3 -->
				<td class="LCtd" width="110px">BC.DEU.DIR</td>
				<td class="LCtd" width="110px">BC.DEU.IND</td>
				<td class="LCtd" width="110px">BC.DEU.TOT</td>
				<td class="LCtd" width="110px">BC.PASIVO</td>
				<td class="LCtd" width="110px">BC.VOLUMEN</td>
				<td class="LCtd" width="110px">SF.DEU.DIR</td>
				<td class="LCtd" width="110px">SF.DEU.IND</td>
				<td class="LCtd" width="110px">SF.DEU.TOT</td>
				<td class="LCtd" width="110px">SF.DEU.JUD</td>
				<td class="LCtd" width="110px">%CUO.DIR</td>
				<td class="LCtd" width="110px">%CUO.IND</td>
				<td class="LCtd" width="110px">%CUO.BCO</td>
			</c:when>

					
			<c:when test="${fn:containsIgnoreCase(detalle, 'dt_activo')}">
<!-- DETALLE ACTIVO -->

				<td class="LCtd" width="110px">PPER</td>   
				<td class="LCtd" width="110px">PAUT</td>      
				<td class="LCtd" width="110px">PHIP</td>      
				<td class="LCtd" width="110px">PMIV</td>      
				<td class="LCtd" width="110px">CPTE</td>     
				<td class="LCtd" width="110px">PMAS</td>      
				<td class="LCtd" width="110px">PCOM</td>      
				<td class="LCtd" width="110px">DSCT</td>      
				<td class="LCtd" width="110px">LEAST</td>   
				<td class="LCtd" width="110px">CLOC</td>   
				<td class="LCtd" width="110px">PREF</td>   
				<td class="LCtd" width="110px">LCTA</td>   
				<td class="LCtd" width="110px">PROM</td>   
				<td class="LCtd" width="110px">FCEX</td>   
				<td class="LCtd" width="110px">AVAL</td>
				<td class="LCtd" width="110px">T. ACTIVO</td>   
			</c:when>
					
			<c:when test="${fn:containsIgnoreCase(detalle, 'dt_tarjetas')}">
<!-- DETALLE TARJETAS -->
				<td class="LCtd" width="110px">VNAC</td>
				<td class="LCtd" width="110px">VARC</td>
				<td class="LCtd" width="110px">VCLA</td>
				<td class="LCtd" width="110px">VREP</td>
				<td class="LCtd" width="110px">VORO</td>
				<td class="LCtd" width="110px">VPLA</td>
				<td class="LCtd" width="110px">VEMP</td>
				<td class="LCtd" width="110px">VSIG</td>
				<td class="LCtd" width="110px">MCLA</td>
				<td class="LCtd" width="110px">MORO</td>
				<td class="LCtd" width="110px">T. TARJETAS</td>
			</c:when>                      


			<c:when test="${fn:containsIgnoreCase(detalle, 'dt_pasivo')}">
<!-- DETALLE PASIVO -->	
				<td class="LCtd" width="110px">CCTE</td>    
				<td class="LCtd" width="110px">CEMP</td>    
				<td class="LCtd" width="110px">CVIP</td>    
				<td class="LCtd" width="110px">CGAN</td>    
				<td class="LCtd" width="110px">AHOR</td>    
				<td class="LCtd" width="110px">PLZO</td>    
				<td class="LCtd" width="110px">SDEP</td>    
				<td class="LCtd" width="110px">FMUT</td>    
				<td class="LCtd" width="110px">CTS</td>    
				<td class="LCtd" width="110px">CTSD</td>    
				<td class="LCtd" width="110px">T. PASIVO</td> 
			</c:when>


			<c:when test="${fn:containsIgnoreCase(detalle, 'dt_servicios')}">
<!-- DETALLE SERVICIOS -->	
				<td class="LCtd" width="110px">COLB</td>      
				<td class="LCtd" width="110px">CEXT</td>       
				<td class="LCtd" width="110px">SVID</td>      
				<td class="LCtd" width="110px">SONC</td>       
				<td class="LCtd" width="110px">SPRO</td>      
				<td class="LCtd" width="110px">PSERV</td>     
				<td class="LCtd" width="110px">PH</td>   
				<td class="LCtd" width="110px">EMPH</td>     
				<td class="LCtd" width="110px">TDEB</td>
				<td class="LCtd" width="110px">TVIP</td>
				<td class="LCtd" width="110px">T. SERVICIOS</td>
			</c:when>
			
			
			<c:when test="${fn:containsIgnoreCase(detalle, 'dt_canales')}">	
<!-- DETALLE CANALES -->	
				<td class="LCtd" width="110px">CNET</td>    
				<td class="LCtd" width="110px">CEMP</td>    
				<td class="LCtd" width="110px">LINCO</td>     
				<td class="LCtd" width="110px">B24</td>   
				<td class="LCtd" width="110px">POS</td>  
				<td class="LCtd" width="110px">T. CANALES</td>
			</c:when>					
			</c:choose>			
			</tr>
			
			<!-- Fin Cabecera, definir aqui los anchos de cada celda, cada TR es una fila de Datos-->
			<%int i = 0; %>
			<c:forEach var="row" items="${listaConduccion}">
			
			<tr <c:if test="${row.ph != '0'}">
				<%if (i%2 == 0) { %>
				 class="FondoAmarillo"
				<%} else { %>
				 class="FondoGris2"
				<% } %>
			</c:if>
			
			<c:if test="${row.ph == '0'}">
				class="FondoAmarillo"
			</c:if> >
			<c:choose>		
			<c:when test="${fn:containsIgnoreCase(detalle, 'dt_general')}">
<!-- LISTA GENERAL -->
			<!-- PARTE 1 -->
				<td class="LCtd" align="center">${row.codigo}</td>
				<td class="LCtd">${row.nombre}</td>	
				<td class="LCtd">${row.tipo_persona}</td>
				<!--<td class="LCtd">${row.nro_documento}</td>-->
				<td class="LCtd">${row.perfil}</td>
				<td class="LCtd">${row.estcivil}</td>
				<!--<td class="LCtd">${row.direc1} ${row.nro} ${row.calle}</td>-->
				<td class="LCtd">${row.telefono}</td>
				<!-- td class="LCtd">${row.des_empresa}</td -->
				
				<!-- PARTE 2 -->				
				<!--  <td class="LCtd">${row.departamento}</td>-->
				<!--<td class="LCtd">${row.provincia}</td>-->
				<!--<td class="LCtd">${row.distrito}</td>-->
				<td class="LCtd">${row.segment1}</td>
				<td class="LCtd">${row.vinculacion}</td>
				<td class="LCtd">${row.t_act_ct2}</td>
				<td class="LCtd">${row.t_act_ct4}</td>
				<td class="LCtd">${row.t_act_ct3}</td>
				<td class="LCtd">${row.t_act_ct5}</td>
				
				<td class="LCtd">${row.margeno}</td>						
			
				<!-- PARTE 3 -->
				<td class="LCtd">${row.bcorid}</td>
				<td class="LCtd">${row.bcorii}</td>
				<td class="LCtd">${row.bcorie}</td>
				<td class="LCtd">${row.bcopas}</td>
				<td class="LCtd">${row.bcovol}</td>
				<td class="LCtd">${row.sbsrid}</td>
				<td class="LCtd">${row.sbsrii}</td>
				<td class="LCtd">${row.sbsrie}</td>
				<td class="LCtd">${row.sbsjud}</td>
				<td class="LCtd">${row.porcrid}</td>
				<td class="LCtd">${row.porcrii}</td>
				<td class="LCtd">${row.porcrie}</td>		
			</c:when>


			<c:when test="${fn:containsIgnoreCase(detalle, 'dt_activo')}">
<!-- DETALLE ACTIVO -->
				<td class="LCtd" align="center">${row.codigo}</td>
				<td class="LCtd">${row.nombre}</td>
				
				
						
				<td class="LCtd">${row.pper}</td>
				<td class="LCtd">${row.pper}</td>
				<td class="LCtd">${row.paut}</td>    
				<td class="LCtd">${row.phip}</td>    
				<td class="LCtd">${row.pmiv}</td>    
				<td class="LCtd">${row.cpte}</td>
				<td class="LCtd">${row.pmas}</td>
				<td class="LCtd">${row.pcom}</td>
				<td class="LCtd">${row.dsct}</td>
				<td class="LCtd">${row.leas}</td>
				<td class="LCtd">${row.cloc}</td>
				<td class="LCtd">${row.pref}</td>
				<td class="LCtd">${row.lcta}</td>   
				<td class="LCtd">${row.prom}</td>   
				<td class="LCtd">${row.fcex}</td>   
				<td class="LCtd">${row.aval}</td>   
				<td class="LCtd">${row.t_act_ct2}</td>
			</c:when>


			<c:when test="${fn:containsIgnoreCase(detalle, 'dt_tarjetas')}">				
<!-- DETALLE TARJETAS -->
				<td class="LCtd" align="center">${row.codigo}</td>
				<td class="LCtd">${row.nombre}</td>	
				<td class="LCtd">${row.prefijo}</td>
				<td class="LCtd">${row.telefono}</td>
				<td class="LCtd">${row.vnac}</td>      
				<td class="LCtd">${row.varc}</td>      
				<td class="LCtd">${row.vcla}</td>      
				<td class="LCtd">${row.vrep}</td>      
				<td class="LCtd">${row.voro}</td>      
				<td class="LCtd">${row.vpla}</td>      
				<td class="LCtd">${row.vemp}</td>      
				<td class="LCtd">${row.vctr}</td>      
				<td class="LCtd">${row.mcla}</td>      
				<td class="LCtd">${row.moro}</td>      
				<td class="LCtd">${row.t_act_ct3}</td> 
			</c:when>


			<c:when test="${fn:containsIgnoreCase(detalle, 'dt_pasivo')}">					
<!-- DETALLE PASIVO -->	
				<td class="LCtd" align="center">${row.codigo}</td>
				<td class="LCtd">${row.nombre}</td>	
				<td class="LCtd">${row.prefijo}</td>
				<td class="LCtd">${row.telefono}</td>
				<td class="LCtd">${row.ccte}</td>    
				<td class="LCtd">${row.cemp}</td>    
				<td class="LCtd">${row.cvip}</td>    
				<td class="LCtd">${row.ahsd}</td>    
				<td class="LCtd">${row.ahor}</td>    
				<td class="LCtd">${row.plzo}</td>    
				<td class="LCtd">${row.sdep}</td>    
				<td class="LCtd">${row.fmut}</td>    
				<td class="LCtd">${row.cts}</td>     
				<td class="LCtd">${row.ctsd}</td>    
				<td class="LCtd">${row.t_act_ct4}</td> 
			</c:when>


			<c:when test="${fn:containsIgnoreCase(detalle, 'dt_servicios')}">	
<!-- DETALLE SERVICIOS -->	
				<td class="LCtd" align="center">${row.codigo}</td>
				<td class="LCtd">${row.nombre}</td>	
				<td class="LCtd">${row.prefijo}</td>
				<td class="LCtd">${row.telefono}</td>
				<td class="LCtd">${row.colb}</td>       
				<td class="LCtd">${row.cext}</td>       
				<td class="LCtd">${row.svid}</td>       
				<td class="LCtd">${row.sonc}</td>       
				<td class="LCtd">${row.spro}</td>       
				<td class="LCtd">${row.pserv}</td>      
				<td class="LCtd">${row.ph}</td>       
				<td class="LCtd">${row.emph}</td>       
				<td class="LCtd">${row.tdeb}</td>        
				<td class="LCtd">${row.tvip}</td>      
				<td class="LCtd">${row.t_act_ct5}</td> 
			</c:when>

			
			<c:when test="${fn:containsIgnoreCase(detalle, 'dt_canales')}">	
<!-- DETALLE CANALES -->
				<td class="LCtd" align="center">${row.codigo}</td>
				<td class="LCtd">${row.nombre}</td>	
				<td class="LCtd">${row.prefijo}</td>
				<td class="LCtd">${row.telefono}</td>
				<td class="LCtd">${row.cnet}</td>
				<td class="LCtd">${row.cemp}</td>
				<td class="LCtd">${row.linco}</td>
				<td class="LCtd">${row.b24}</td>
				<td class="LCtd">${row.pos}</td>
				<td class="LCtd">${row.t_act_ct6}</td>
			</c:when>
						
			</c:choose>
			</tr>
			<%i++; %>
			</c:forEach>
		</table>
		</td></tr>
	</TABLE>
	</c:if>
	<c:if test="${mensaje != null}">
	<script type="text/javascript">
		alert("<c:out value="${mensaje}"/>");
		<%request.setAttribute("mensaje",null);%>
	</script>
</c:if>
</html:form>
</div>
</BODY>
</html:html>