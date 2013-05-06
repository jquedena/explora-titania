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
<TITLE>Mantenimiento Programación Seguimiento</TITLE>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/js/calendar2/calendar-system.css"/>
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/js/calendar2/calendar.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/calendar2/calendar-es.js" charset="UTF-8"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/validaTecla.js"></script>

<script language="javascript">
	var FEC_PATTERN=/\d{0,2}\/?\d{0,2}\/?\d{0,4}/;
	
	function ultimoDia(mes, anno) {
		if (mes.charAt(0) == '0')
			mes = mes.charAt(1);
		
		mes = parseInt(mes);
		anno = parseInt(anno);
		
		switch (mes) {
			case 1 :
			case 3 :
			case 5 :
			case 7 :
			case 8 :
			case 10 :
			case 12 :
				return 31;
			case 2 :
				return (anno % 4 == 0) ? 29 : 28;
		}
		return 30;
	}
	
	function inicio() {
		var form = document.forms[0];
		var codTerritorio = form.codTerritorio;
		
		form.seg1Ini.readOnly = true;
		form.seg2Ini.readOnly = true;
		focoTerritorio();
	}
	
	function focoTerritorio(){
		var form = document.forms[0];
		var codTerritorio = form.codTerritorio;
		
		if(codTerritorio.type != 'hidden') {
			codTerritorio.focus();
		} else {
			form.mes.focus();
		}
	}
	
	function limpiar(){
		var form = document.forms[0];
		var codTerritorio = form.codTerritorio;
		
		if(codTerritorio.type != 'hidden') {
			codTerritorio.selectedIndex = 0;
			codTerritorio.focus();
		}
		
		form.mes.value = "";
		form.anio.value = "";
		form.seg1Ini.value = "";
		
		form.seg1Fin.value = "";
		form.seg2Ini.value = "";
		form.seg2Fin.value = "";
	}
	
	
	function setearSeg1Fin() {
		var form = document.forms[0];
		
		try {
			var fecha;
			var strFecha;
			var seg1Fin = form.seg1Fin.value;
			var dia = form.seg1Ini.value.substring(0, 2);
			var mes = form.seg1Ini.value.substring(3, 5);
			var anio = form.seg1Ini.value.substring(6, 10);
			var diaSalida;
			var mesSalida;
			var anioSalida;
			
			switch(Number(mes)) {
				case 1: mesSalida = "Jan"; break;
				case 2: mesSalida = "Feb"; break;
				case 3: mesSalida = "Mar"; break;
				case 4: mesSalida = "Apr"; break;
				case 5: mesSalida = "May"; break;
				case 6: mesSalida = "Jun"; break;
				case 7: mesSalida = "Jul"; break;
				case 8: mesSalida = "Aug"; break;
				case 9: mesSalida = "Sep"; break;
				case 10: mesSalida = "Oct"; break;
				case 11: mesSalida = "Nov"; break;
				case 12: mesSalida = "Dec"; break;
			}
			
			strFecha = mesSalida + " " + Number(dia) + ", " + anio + " 00:00:00";
			fecha = new Date(strFecha);
			
			fecha.setDate(fecha.getDate() + 39);
			
			diaSalida = fecha.getDate();
			mesSalida = Number(fecha.getMonth()) + 1;
			anioSalida = fecha.getYear();
					
			if(diaSalida < 10) {
				diaSalida = "0" + diaSalida;
	 		}
			
			if(mesSalida < 10) {
				mesSalida = "0" + mesSalida;
	 		}
			
			form.seg1Fin.value = diaSalida + "/" + mesSalida + "/" + anioSalida;
		} catch(e) {
			form.seg1Fin.value = "";
		}
	}
	
	function setearSeg2Fin() {
		var form = document.forms[0];
		
		try {
			var fecha;
			var strFecha;
			var seg2Fin = form.seg2Fin.value;
			var dia = form.seg2Ini.value.substring(0, 2);
			var mes = form.seg2Ini.value.substring(3, 5);
			var anio = form.seg2Ini.value.substring(6, 10);
			var diaSalida;
			var mesSalida;
			var anioSalida;
						
			switch(Number(mes)) {
				case 1: mesSalida = "Jan"; break;
				case 2: mesSalida = "Feb"; break;
				case 3: mesSalida = "Mar"; break;
				case 4: mesSalida = "Apr"; break;
				case 5: mesSalida = "May"; break;
				case 6: mesSalida = "Jun"; break;
				case 7: mesSalida = "Jul"; break;
				case 8: mesSalida = "Aug"; break;
				case 9: mesSalida = "Sep"; break;
				case 10: mesSalida = "Oct"; break;
				case 11: mesSalida = "Nov"; break;
				case 12: mesSalida = "Dec"; break;
			}
			
			strFecha = mesSalida + " " + Number(dia) + ", " + anio + " 00:00:00";
			fecha = new Date(strFecha);
			
			fecha.setDate(fecha.getDate() + 39);
			
			diaSalida = fecha.getDate();
			mesSalida = Number(fecha.getMonth()) + 1;
			anioSalida = fecha.getYear();
					
			if(diaSalida < 10) {
				diaSalida = "0" + diaSalida;
	 		}
			
			if(mesSalida < 10) {
				mesSalida = "0" + mesSalida;
	 		}
			
			form.seg2Fin.value = diaSalida + "/" + mesSalida + "/" + anioSalida;
		} catch(e) {
			form.seg2Fin.value = "";
		}		
	}
	
	function grabar() {
		var form = document.forms[0];
		
		form.method.value = "grabarProgSeguimiento";
		
		if(validar()) {
			form.submit();
		}		
	}
	
	function consultar() {
		var form = document.forms[0];
		
		form.method.value = "listarProgSeguimiento";
		
		form.submit();
	}
	
	function validar() {
		var form = document.forms[0];
		
		if(form.codTerritorio.type != "hidden") {
			if(form.codTerritorio.value == "") {
				alert("Seleccione territorio");
				form.codTerritorio.focus();
				
				return false;
			}
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
		
		if(form.seg1Fin.value == "") {
			alert("Ingrese fecha fin de seguimiento 1");
			form.seg1Fin.focus();
			form.seg1Fin.select();
			return false;
		} else {
			if(!isDate(form.seg1Fin.value)) {
				alert("Fecha fin de seguimiento 1 no es una fecha válida");
				return false;
			}
			if(compararFecha(form.seg1Fin.value, form.anio.value + "/" + form.mes.value + "/" + ultimoDia(form.mes.value, form.mes.value))>0){
				if(isModificoFechaSeguimiento(form.seg1Fin.value,'<c:out value="${requestScope.progSeguimiento.seg1Fin}"/>')){
					alert("Fecha fin de seguimiento 1 debe ser menor o igual al ultimo día del mes.");
					return false;
				}
			}
			/* if(compararFechaConFechaActualDelServidor(form.seg1Fin.value)<0){
				if(isModificoFechaSeguimiento(form.seg1Fin.value,'<c:out value="${requestScope.progSeguimiento.seg1Fin}"/>')){
					alert("Fecha fin de seguimiento 1 debe ser mayor o igual a la fecha actual");
					return false;
				}
			} */
		}
		
		if(form.seg2Fin.value == "") {
			alert("Ingrese fecha fin de cierre de mes");
			form.seg2Fin.focus();
			form.seg2Fin.select();
				
			return false;
		} else {
			if(!isDate(form.seg2Fin.value)) {
				alert("Fecha fin de cierre de mes no es una fecha válida");
				return false;
			}
			/* if(compararFechaConFechaActualDelServidor(form.seg2Fin.value)<0){
				if(isModificoFechaSeguimiento(form.seg2Fin.value,'<c:out value="${requestScope.progSeguimiento.seg2Fin}"/>')){
					alert("Fecha fin de cierre de mes debe ser mayor o igual a la fecha actual");
					return false;
				}
			} */
		}
		return true;
	}
	
	function isModificoFechaSeguimiento(fechaActualDelCampo,fechaInicial){
		return fechaActualDelCampo!=fechaInicial;
	}
	
	function compararFechaConFechaActualDelServidor(fechaAComparar){
		var strFechaActual = '<%=new java.text.SimpleDateFormat("yyyy/MM/dd").format(java.util.Calendar.getInstance().getTime())%>';
		var dtFechaActual = new Date(strFechaActual.split('/')[0],strFechaActual.split('/')[1],strFechaActual.split('/')[2]);
		var dtFecha=new Date(fechaAComparar.split('/')[2],fechaAComparar.split('/')[1],fechaAComparar.split('/')[0]);
		if (dtFecha.getTime()==dtFechaActual.getTime()) {
			return 0;
		}
		if (dtFecha.getTime()<dtFechaActual.getTime()) {
			return -1;
		}
		if (dtFecha.getTime()>dtFechaActual.getTime()) {
			return 1;
		}
	}
	
	function compararFecha(fechaAComparar, strFecha){
		var dtFechaActual = new Date(strFecha.split('/')[0],strFecha.split('/')[1],strFecha.split('/')[2]);
		var dtFecha=new Date(fechaAComparar.split('/')[2],fechaAComparar.split('/')[1],fechaAComparar.split('/')[0]);
		if (dtFecha.getTime()==dtFechaActual.getTime()) {
			return 0;
		}
		if (dtFecha.getTime()<dtFechaActual.getTime()) {
			return -1;
		}
		if (dtFecha.getTime()>dtFechaActual.getTime()) {
			return 1;
		}
	}
	
	function isDate(text){
		var arDate = text.split("/");
		var blnRet;
	
		if(arDate.length==3){
			var aDate = new Date(arDate[2],arDate[1]-1,arDate[0]);
			blnRet = (aDate.getFullYear()==arDate[2]&&aDate.getMonth()==arDate[1]-1&&aDate.getDate()==arDate[0]);
		}
		
		return (arDate.length==3 && blnRet);
	}
	
	function cargarProgramacion() {
		var form = document.forms[0];
		var codTerritorio = form.codTerritorio;
		var valorCodTerritorio;
		var mes = form.mes;
		var anio = form.anio;
		
		if(codTerritorio.type != 'hidden') {
			valorCodTerritorio = codTerritorio.value;
		} else {
			valorCodTerritorio = codTerritorio.value;
		}
		
		if(	valorCodTerritorio != "" &&
			mes.value != "" && anio.value != "") {
			
			form.method.value = "mostrarNuevoEditarProgSeguimiento";
			
			form.submit();
		}
	}
	
</script>
</HEAD>

<BODY onload="inicio();">
<html:form action = "/progSeguimientoAction">
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
			<div align="center"><strong>PROGRAMACI&Oacute;N SEGUIMIENTO</strong></div><br />
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
			    	<td width="60">Territorio:</td>
			    	<td width="60">&nbsp;</td>
				    <td colspan = "4">
				    	<c:if test = "${sessionScope.gestor.codigoPerfil == 'ADM'}">		
					    	<html:select property="codTerritorio" styleClass="combo2" tabindex="1" value="${requestScope.progSeguimiento.codTerritorio}" onchange="cargarProgramacion();">
								<html:option value="" >[Seleccione Territorio]</html:option>
								<html:options collection="listaTerritorio" property="codTerritorio" labelProperty="nomTerritorio"/>
							</html:select>
						</c:if> 
				    	<c:if test = "${sessionScope.gestor.codigoPerfil == 'GTE' || sessionScope.gestor.codigoPerfil == 'JPN' || sessionScope.gestor.codigoPerfil == 'JPR'}">				    	
				    		<html:hidden property="codTerritorio" value ="${sessionScope.codTerrProgSeguimiento}"/>
					    	${sessionScope.nomTerrProgSeguimiento}
						</c:if> 						
				    </td>
				</tr>				
			  	<tr>
			    	<td >Mes:</td>
			    	<td >&nbsp;</td>
				    <td >				    
				    	<html:select property="mes" styleClass="combo2" onchange="cargarProgramacion();" tabindex="2" value="${requestScope.progSeguimiento.mes}">
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
					<td align="right">Año:</td>
				    <td >
				    	<html:select property="anio" styleClass="combo2" onchange="cargarProgramacion();" tabindex="3" value="${requestScope.progSeguimiento.anio}">
							<html:option value="">[Seleccione A&ntilde;o]</html:option>
							<html:options collection="listaAnio" property="codelem" labelProperty="valor1"/>
						</html:select>	   	
					</td>
				</tr>
				<tr>
			    	<td >Fecha Seguimiento 1:</td>
			    	<td align="right">Inicio:</td>
				    <td >
				    	<html:text property="seg1Ini" size="10" maxlength="10" styleClass="cajatexto" onkeypress="return validKey(this, event, FEC_PATTERN);" value="${requestScope.progSeguimiento.seg1Ini}"> </html:text> 							     
						<img align="top" style="cursor:hand" src="${pageContext.request.contextPath}/js/calendar2/calendar.gif"
											id="fechaSeg1Ini"  alt="Calendar" title="Calendar"/>

			                  <script type="text/javascript">								
			                  Calendar.setup({ 								
			                   inputField :  'seg1Ini',								
			                   ifFormat :    '%d/%m/%Y', 								
			                   button :      'fechaSeg1Ini', 								
			                   align :       'cr', 								
			                   singleClick : true, 								
			                   firstDay :    1								
			                  });
			                  </script>	
			        	(dd/mm/aaaa)
					</td>
					<td>&nbsp;</td>
					<td align="right">Fin:</td>
					<td >
						<html:text property="seg1Fin" size="10" maxlength="10" styleClass="cajatexto" onkeypress="return validKey(this, event, FEC_PATTERN);" tabindex="4" value="${requestScope.progSeguimiento.seg1Fin}"> </html:text>

 							 <img align="top" style="cursor:hand" src="${pageContext.request.contextPath}/js/calendar2/calendar.gif"
											id="fechaSeg1Fin"  alt="Calendar" title="Calendar"/>

			                  <script type="text/javascript">								
			                  Calendar.setup({ 								
			                   inputField :  'seg1Fin',								
			                   ifFormat :    '%d/%m/%Y', 								
			                   button :      'fechaSeg1Fin', 								
			                   align :       'cr', 								
			                   singleClick : true, 								
			                   firstDay :    1								
			                  });
			                  </script>	
			        	(dd/mm/aaaa)
					</td>
				    <td>&nbsp;</td>
				</tr>
				<tr>
			    	<td>Fecha cierre de mes:</td>
			    	<td align="right">Inicio:</td>
				    <td>
						<html:text property="seg2Ini" size="10" maxlength="10" styleClass="cajatexto" onkeypress="return validKey(this, event, FEC_PATTERN);"value="${requestScope.progSeguimiento.seg2Ini}"> </html:text> 							 
						 <img align="top" style="cursor:hand" src="${pageContext.request.contextPath}/js/calendar2/calendar.gif"
											id="fechaSeg2Ini"  alt="Calendar" title="Calendar"/>

			                  <script type="text/javascript">								
			                  Calendar.setup({ 								
			                   inputField :  'seg2Ini',								
			                   ifFormat :    '%d/%m/%Y', 								
			                   button :      'fechaSeg2Ini', 								
			                   align :       'cr', 								
			                   singleClick : true, 								
			                   firstDay :    1								
			                  });
			                  </script>	
			        	(dd/mm/aaaa)
					</td>
					<td>&nbsp;</td>
					<td align="right">Fin:</td>
					<td>
						<html:text property="seg2Fin" size="10" maxlength="10" styleClass="cajatexto" onkeypress="return validKey(this, event, FEC_PATTERN);" tabindex="5" value="${requestScope.progSeguimiento.seg2Fin}"> </html:text>

 							 <img align="top" style="cursor:hand" src="${pageContext.request.contextPath}/js/calendar2/calendar.gif"
											id="fechaSeg2Fin"  alt="Calendar" title="Calendar"/>

			                  <script type="text/javascript">								
			                  Calendar.setup({ 								
			                   inputField :  'seg2Fin',								
			                   ifFormat :    '%d/%m/%Y', 								
			                   button :      'fechaSeg2Fin', 								
			                   align :       'cr', 								
			                   singleClick : true, 								
			                   firstDay :    1								
			                  });
			
			                  </script>									
			            (dd/mm/aaaa)    			                  
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
	    							<input type="button" name="btnGrabar" value="Grabar" onClick="grabar();" tabindex="6">
	    							&nbsp;	
							    	<input type="button" name="btnLimpiar" value="Limpiar" onClick="limpiar();" tabindex="7" 							    	
								    	<c:if test = "${sessionScope.gestor.codigoPerfil == 'GTE' || sessionScope.gestor.codigoPerfil == 'JPN' || sessionScope.gestor.codigoPerfil == 'JPR' }">	
									    	onblur="focoTerritorio();"
								    	</c:if> 
							    	>
							    	&nbsp;	
							    	<c:if test = "${sessionScope.gestor.codigoPerfil == 'ADM'}">	
								    	<input type="button" name="btnConsultar" value="Consulta" onClick="consultar();" tabindex="8" onblur="focoTerritorio();">
								    </c:if> 
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