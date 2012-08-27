<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@ taglib prefix="fn" uri="/WEB-INF/fn.tld"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld" %>


<fmt:setLocale value="en_US"/>
<html:html>
<head>
	<meta http-equiv='PRAGMA' content='NO-CACHE'>
	<meta http-equiv='EXPIRES' content='0'>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css"	type="text/css">
	<style type="text/css">
		input.Text {padding-right: 5px;}
	</style>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.2.6.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/js-preparaJSONExcel.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/pages/objetivos/objetivosDistribucion.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/script.js"></script>
	<script type="text/javascript">
	var session_error="<c:out value="${requestScope.ERROR_SDO}"/>";
	<c:set var="requestScope.ERROR_SDO" value=""/>
	$(function() {
		// La meta debe ser mayor o igual a lo asignado por el Gerente Territorial o JPN
		$(".GOF").blur(function() {
			var disabled = false;
			
			if(Math.abs(parseFloat($(this).val())) < Math.abs(parseFloat($(this).attr('valueOld')))) {
				disabled = true;
				alert('La meta debe ser mayor o igual a lo asignado por el Gerente Territorial o JPN');
				$(this).val($(this).attr('valueOld'));
				$(this).change();
				$(this).focus();
			}
		});
	
		test = new Boolean(session_error);
		if(test) {
			if(session_error.toLowerCase() == "") {
			} else if(session_error.toLowerCase() != "ok"){
				alert(session_error);
			} else {
				alert("Actualizaci\u00F3n correcta");
			}
		}
		
		var testEpigrafe = "";
		
		$("select[name=codEpigrafe]").find('option').each(function(){
			text = $(this).html();
			
			if(parseInt(text) == 99 || parseInt(text) == NaN || parseInt(text) == undefined) {
				testEpigrafe = "Al menos un epigrafe debe tener un nivel de prioridad";
			}
			
			text = text.replace("99 - ", "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			$(this).html(text);
		});
		
		if($("#codEpigrafe option").length==0){
			$("#btnBar").css({"visibility":"hidden"});
		} else {
			$("#btnBar").css({"visibility":"visible"});
		}
		
		$(".DataGrid .Row").each(function(){
			if($(this).find('td').eq(0).text().indexOf("*")>-1) {
				$(this).addClass("GestorNode");
			}
		});
		
		if( $('input[name=grabacion]').val() == undefined) {
			$('input:text').attr('readonly', true);
		}
		
		$(".Text").blur(function(){
			var disabled = false;
			var cellContent = $("#epigrafe").val();
			if(cellContent.toUpperCase().indexOf('CARTERA ATRASADA')>=0) {
				if(parseFloat($(this).val())>0) {
					disabled = true;
					alert('La cartera atrasada debe ser negativa');
					$(this).focus();
				}	
			} else {
				if(parseFloat($(this).val())<0) {
					disabled = true;
					alert('El monto no puede ser negativo');
					$(this).focus();
				}
			}
		});
		
		$(".Text").change(function(){
			var s = 0;
			$(".Text").each(function(){
				s+=parseFloat($(this).val().length == 0 ? '0' : $(this).val());
			});
			
			if(s <= $("input[name=restoOficina]").val()){
				$("#trMensaje").css({"display":"none"});
			} else {
				$("#trMensaje").css({"display":"block"});
			}
			
			$("input[name=montoTotal]").val(s);
		});
		
		$("input[name=prioridad]").each(function(){
			if($(this).val()=="99") {
				$(this).val("");
			}		
		});
		
		$("input[name=exporta]").click(function(){
			prepareJSONTable();
			document.forms["fExportarExel"].submit();
		});
	});
		
	function grabar(gestor){
		
		var codPorcentaje = '';
		var codGestor = '';
		var nomGestor = '';
		var codPerfil = '';
		var i = 0;
		$("#grpText .Text").each(function(){
			if(codPorcentaje.length > 0) codPorcentaje +=',';
			codPorcentaje += $(this).val();
			
			if(codGestor.length > 0) codGestor +=',';
			codGestor += $(this).attr('codigo');
			
			if(nomGestor.length > 0) nomGestor +=',';
			nomGestor += $(this).attr('nombre');
			
			if(codPerfil.length > 0) codPerfil +=',';
			codPerfil += $(this).attr('codperfil');
			i++;
		});
		
		var valorInicialGOF = 0;
		
		<c:if test="${not empty requestScope.planes}">
			<c:if test="${not empty requestScope.planes.factAjusGereOfic}">
				valorInicialGOF = ${requestScope.planes.factAjusGereOfic};
			</c:if>
		</c:if>
		
		// var finalGOF =  document.forms[0].elements["${codigoGestorGOF}"];
		var finalGOF =  parseFloat(document.forms[0].elements["montoTotal"]);
		var valorFinalGOF = 0;
		
		if(finalGOF != null) {
			valorFinalGOF = finalGOF.value;
		}
		
		if(Math.abs(parseFloat(valorInicialGOF)) > Math.abs(valorFinalGOF)) {
			alert("No se puede disminuir el valor de la meta asignada");
			finalGOF.focus();
			finalGOF.select();
			return;	
		}
		
		if(verificarMonto()){
			var form = document.forms[0];
			form.gestor.value = gestor;
			form.codPorcentaje.value = codPorcentaje;
			form.codGestor.value = codGestor;
			form.nomGestor.value = nomGestor;
			form.codPerfil.value = codPerfil;
			
			if(form.restoOficina.value == '') {
				form.restoOficina.value = '0';
			}		
			
			form.action = "objetivosAction.do?method=actualizarObjetivo";
			form.method="post";
			var resp = confirm("¿Desea guardar los cambios?");
	    	if(resp) {
	    		form.submit();
	    	}    
		}
	}
	</script>
	<title></title>
</head>
<% 
	String colorfila = "";
	int i = 0;
	String mensaje = "";
	mensaje = request.getSession(false).getAttribute("mensaje").toString();
	String tipo = "";
	tipo = request.getSession(false).getAttribute("tipo").toString();
%>
<body onload="mostrarFelicitacion();">
<html:form action="/objetivosAction" styleId="objetivosForm">
	
<input type="hidden" name="gestor" >
<input type="hidden" name="codPorcentaje" >
<input type="hidden" name="codGestor" >
<input type="hidden" name="nomGestor" >
<input type="hidden" name="codPerfil"/>
<c:set var = "codigoGestorGOF" value = "AA"/>
    		
<table border=0 align="center" width="100%" height="%" cellspacing="0" cellpadding="0">
	<tr>
		<td width="100%" align="left"  valign="top">
			<table border=0 cellspacing="0" cellpadding="0">
				<tr>
					<td class="bls">&nbsp;</td>
					<td width="200" class="textocentradoblanco">OBJETIVOS</td>
					<td class="brs">&nbsp;</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td style="border: 2px solid #264971;padding: 10px;" valign="top" height="%" align="center">
			<table border=0 width="608" align=center cellpadding="0" cellspacing="0">
				<tr>
					<td>
						<table border=0 width="100%" cellpadding="0" cellspacing="0">
							<tr>
								<td>Mes: </td>
								<td>
									<html:select property="mes" styleClass="combo" onchange="javascript:buscarObjetivos();" value="${requestScope.mes}">
										<html:option value="01">Enero</html:option>
										<html:option value="02">Febrero</html:option>
										<html:option value="03">Marzo</html:option>
										<html:option value="04">Abril</html:option>
										<html:option value="05">Mayo</html:option>
										<html:option value="06">Junio</html:option>
										<html:option value="07">Julio</html:option>
										<html:option value="08">Agosto</html:option>
										<html:option value="09">Setiembre</html:option>
										<html:option value="10">Octubre</html:option>
										<html:option value="11">Noviembre</html:option>
										<html:option value="12">Diciembre</html:option>
									</html:select>
								</td>
								<td>Año: </td>
								<td>
									<html:select property="anho" styleClass="combo" onchange="javascript:buscarObjetivos();" value="${requestScope.anho}">
										<c:if test="${requestScope.listaAnhos != null}">
												<c:forEach var="lista" items="${requestScope.listaAnhos}">
													<html:option value="${lista.codelem}"><c:out value="${lista.valor1}" /></html:option>
												</c:forEach>
										</c:if>
									</html:select>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td align="100%" style="padding-top:20px;">
						<table border=0 width=100% cellspacing="0" cellpadding="0">
						    <tr>
						    	<td align="center">Oficinas:</td>
						    	<td align="center">Epigrafes:</td>
						    </tr>
						    <tr>
								<td align=center>
									<html:select property="codOficina" styleClass="combo" onchange="javascript:buscarObjetivos();" value="${requestScope.codOficina}"> 
										<c:if test="${requestScope.listaOficina != null}">
											<c:forEach var="lista" items="${requestScope.listaOficina}">
												<html:option value="${lista.codOfic}"><c:out value="${lista.codNomOficina}" /></html:option>
											</c:forEach>
										</c:if>
									</html:select>
								</td>
						    	<td align="center">
									<html:select styleId="codEpigrafe" property="codEpigrafe" styleClass="combo" onchange="javascript:buscarObjetivos();">
										<c:if test="${requestScope.listaEpigrafes != null}">
											<c:forEach var="lista" items="${requestScope.listaEpigrafes}">
												<html:option value="${lista.codEpigrafe}"><c:out value="${lista.nomEpigrafe}" /></html:option>
											</c:forEach>
										</c:if>
									</html:select>
						    	</td>
							</tr>
						</table>
					</td>
				</tr>
				<c:if test="${requestScope.indMostrarEpigrafe =='0' || requestScope.indMostrarGerente =='0'}">
					<logic:notPresent name ="listaGestores" scope="request">
							<tr>
								<td align="100%" style="padding-top:20px;" class="mensaje" align="center">
									<div align="center">No existen planes</div>
								</td> 
							</tr>
					</logic:notPresent>
				</c:if>
				<tr>
					<td style="padding-top:20px;">
						<c:if test="${requestScope.indMostrarEpigrafe!='0'}">
						<table border=0 width=100% class="DataGrid" cellspacing="0" cellpadding="0">
							<tr>
								<th>Prioridad</th>
								<th>Ep&iacute;grafe</th>
								<th>Ajuste Territorial</th>
							</tr>
							<tr>
								<td align="center"><html:text property="prioridad" styleId="prioridad" readonly="true" size="10"/></td>
								<td align="center"><html:text property="epigrafe" styleId="epigrafe" readonly="true" size="30"/></td>
								<td align="center"><html:text property="restoOficina" styleId="restoOficina" readonly="true" size="10"  onkeypress="return validKey(INT_PATTERN_NEGATIVO);" /></td>
							</tr>
						</table>
						</c:if>
					</td>
				</tr>
				</table>
				<table border=0 width="608" align=center cellpadding="0" cellspacing="0">
				<tr>
					<td style="padding-top:20px;">
<c:if test="${requestScope.indMostrarGerente!='0'}">
<table border=0 width=100% cellspacing="0" cellpadding="0" class="DataGrid" id="grpText">
<tr class="Header">
	<th>Gestor</th>
	<th>Cargo</th>
	<th>Consecusi&oacute;n Media<br/>(Ultimos 6 Meses)</th>
	<th>Meta Asig.</th>
</tr>
<logic:present name ="listaGestores">
<c:forEach items="${requestScope.listaGestores}" var="objBean">
<tr class="Row">
	<td><c:out value="${objBean.codigoGestor}"/> - <c:out value="${objBean.nombreGestor}"/></td>
	<td><c:out value="${objBean.perfilMostrar}"/><input type="hidden" name = "codPerfilInterno" value = "${objBean.perfilMostrar}"/></td>
	<td pattern="#,###.00" type="NUMBER" align="right"><fmt:formatNumber value="${objBean.promedio6m}" pattern="#,###.00"  maxFractionDigits="0" minFractionDigits="0"/></td>
	<td pattern="#,###.00" type="NUMBER" align="center">
		<c:if test="${objBean.codigoPerfil == 'GOF'}">
			<c:set var = "porc" value = "0"/>
			<c:if test="${objBean.porcAsignado != 0 && objBean.porcAsignado != '' && objBean.porcAsignado != null }"><c:set var = "porc" value = "1"/></c:if>
			
			<c:set var = "codigoGestorGOF" value = "${objBean.codigoGestor}"/>
			<c:if test="${porc == '0'}">
				<c:set var = "fact" value = "0"/>
  				<c:if test="${requestScope.planes.factAjusGereOfic != 0 && requestScope.planes.factAjusGereOfic != '' && requestScope.planes.factAjusGereOfic != null }">
	  				<c:set var = "fact" value = "1"/>
	  			</c:if>

				<c:if test="${fact == '0'}">
					<input type="text" class="Text <c:out value="${objBean.codigoPerfil}"/> textCeleste" name=<c:out value="${objBean.codigoGestor}"/> size="10"  size="10" 
						codigo ="<c:out value='${objBean.codigoGestor}'/>"
						nombre="<c:out value='${objBean.nombreGestor}'/>"
						codperfil="<c:out value='${objBean.perfilMostrar}'/>"
						valueOld="${requestScope.planes.factAjusGereOfic}"
						value="0" onblur="setearCero();" onkeypress="return validKey(INT_PATTERN_NEGATIVO);"/>
				</c:if>
				
				<c:if test="${fact == '1'}">
					<input type="text" class="Text <c:out value="${objBean.codigoPerfil}"/> textCeleste" name=<c:out value="${objBean.codigoGestor}"/> size="10"  size="10"
						codigo ="<c:out value='${objBean.codigoGestor}'/>"
						nombre="<c:out value='${objBean.nombreGestor}'/>"
						codperfil="<c:out value='${objBean.perfilMostrar}'/>"
						valueOld="${requestScope.planes.factAjusGereOfic}"
						value="${requestScope.planes.factAjusGereOfic}" onblur="setearCero();" onkeypress="return validKey(INT_PATTERN_NEGATIVO);"/>
				</c:if>
			</c:if>

			<c:if test="${porc == '1'}">
					<input type="text" class="Text <c:out value="${objBean.codigoPerfil}"/> textAzul" name=<c:out value="${objBean.codigoGestor}"/> size="10"  size="10"
						codigo ="<c:out value='${objBean.codigoGestor}'/>"
						nombre="<c:out value='${objBean.nombreGestor}'/>"
						codperfil="<c:out value='${objBean.perfilMostrar}'/>"
						valueOld="${objBean.porcAsignado}"
						value="${objBean.porcAsignado}" onblur="setearCero();" onkeypress="return validKey(INT_PATTERN_NEGATIVO);"/>
			</c:if>
		</c:if>
		
		<c:if test="${objBean.codigoPerfil != 'GOF'}">
			<c:if test="${objBean.porcAsignado != 0 }">
				<input type="text" class="Text <c:out value="${objBean.codigoPerfil}"/> textAzul" name=<c:out value="${objBean.codigoGestor}"/> size="10"
					codigo ="<c:out value='${objBean.codigoGestor}'/>"
					nombre="<c:out value='${objBean.nombreGestor}'/>"
					codperfil="<c:out value='${objBean.perfilMostrar}'/>"
					valueOld="${objBean.porcAsignado}"
					value=<c:out value="${objBean.metaGestor.porcAsignado}"/> onblur="setearCero();" onkeypress="return validKey(IINT_PATTERN_NEGATIVO);"/>
			</c:if>
			<c:if test="${objBean.porcAsignado == 0 }">
				<input type="text" class="Text <c:out value="${objBean.codigoPerfil}"/> textCeleste" name=<c:out value="${objBean.codigoGestor}"/> size="10"
					codigo ="<c:out value='${objBean.codigoGestor}'/>"
					nombre="<c:out value='${objBean.nombreGestor}'/>"
					codperfil="<c:out value='${objBean.perfilMostrar}'/>"
					valueOld="${objBean.porcAsignado}"
					value=0 onblur="setearCero();" onkeypress="return validKey(INT_PATTERN_NEGATIVO);"/>
			</c:if>	
		</c:if>
	</td><!-- mostrarFelicitacion() -->
</tr>
</c:forEach>
</logic:present>
<!--
<tr class="Footer"><td colspan='4'>"Nota el monto ingresado representa miles de soles"</td></tr>
-->

<tr id="trMensaje" style="display:none;">
	<td align="right" colspan="4"><img src="<%=request.getContextPath()%>/images/encima_meta.png" width="126" height="53"></td>
</tr>
<tr class="Footer">
	<%if(tipo.equals("C  ")){%>
	<td colspan="3" class="mensaje"><IMG src="<%=request.getContextPath()%>/images/error.png" /><%=mensaje %></td>
	<%}else if(tipo.equals("A  ") || tipo.equals("B  ")){ %>
	<td colspan="3" class="mensaje"><IMG src="<%=request.getContextPath()%>/images/exito.png" /><%=mensaje %></td>
	<%}else {%> 
	<td colspan="3" align="right">Total:</td>
	<%}%>
	<td align="center"> 
		<html:text property="montoTotal" styleClass="textCeleste"  styleId="montoTotal"
			size="10" 
			value="0"
			onkeypress="return validKey(INT_PATTERN_NEGATIVO);"
			readonly="true"/>
	</td>
</tr>
</table>
</c:if>
					</td>
				</tr>
			</table>
			<table id="btnBar" border=0 width=100%>
				<tr>
					<td align=center style="padding-top:20px;">
						<c:if test="${sessionScope.gestor.codigoPerfil !='CON' && sessionScope.gestor.codigoPerfil !='ADM' && sessionScope.gestor.codigoPerfil !='SUP' && sessionScope.gestor.codigoPerfil !='GPT' && sessionScope.gestor.codigoPerfil !='GCO' && sessionScope.gestor.codigoPerfil !='GPE' }">
							<input type="button" id="grabacion" name="grabacion" value="Grabar" onClick="Javascript:grabar('${gestor}');">
						</c:if>
						<input type="button" name="imprime" value="Imprimir" onClick="Javascript:imprimir();">
						<input type="button" name="exporta" value="Excel">
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</html:form>
<form method="post" name="fExportarExel" action="ExportGenericExcelServlet">
	<input type="hidden" id="header" name="header" />
	<input type="hidden" id="rows" name="rows" />
	<input type="hidden" id="footer" name="footer" />
	<input type="hidden" id="file" name="file" value="Objetivos" />
	<input type="hidden" id="title" name="title" value="Objetivos" />
</form>
</body>
</html:html>