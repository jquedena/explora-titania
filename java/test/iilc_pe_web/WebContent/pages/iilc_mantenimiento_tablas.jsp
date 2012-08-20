
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
<script type="text/javascript" src='${pageContext.request.contextPath}/includes/InnerDiv.js'></script>
<script type="text/javascript" src='${pageContext.request.contextPath}/includes/funciones.js'></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/jquery-1.2.6.js"></script>
<link rel="stylesheet" href='${pageContext.request.contextPath}/theme/IIRGEspacio2.css' type="text/css">
<link rel="stylesheet" href='${pageContext.request.contextPath}/theme/stylish.css' type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/theme/displaytag.css" type="text/css">
<TITLE>Carpetas Comerciales</TITLE>
<style>
	img {
		border: 0px;
	}
</style>
</HEAD>
<%
	String tipo = request.getParameter("tipoSel") == null ? "M" : request.getParameter("tipoSel");
%>

<script type="text/javascript">
function chequear_todos(chkbox)	{
	for (var i=0;i < document.forms[0].elements.length;i++)	{
		var elemento = document.forms[0].elements[i];
		if (elemento.type == "checkbox"){
			elemento.checked = chkbox.checked;
		}
	}
}
function metodoIMG1(param1,param2){
	document.forms[0].method.value='forward';
	document.forms[0].forward.value=param1;
	document.forms[0].cod_perfil.value= param2;
	if(param1=='eliminar') {
		if(confirm("¿Está seguro de eliminar el registro seleccionado?"))
			document.forms[0].submit();
	}else document.forms[0].submit();
}
function metodoIMG2(param1,param2,param3){
	document.forms[0].method.value='forward';
	document.forms[0].forward.value=param1;
	document.forms[0].cod_mult.value= param2;
	document.forms[0].cod_ele.value= param3;
	if(param1=='eliminar') {
		if(confirm("¿Está seguro de eliminar el registro seleccionado?"))
			document.forms[0].submit();
	}else document.forms[0].submit();
}
function metodoIMG3(param1,param2,param3,param4){
	document.forms[0].method.value='forward';
	document.forms[0].forward.value=param1;
	document.forms[0].cod_perfil.value= param2;
	document.forms[0].tipo_acceso.value= param3;
	document.forms[0].valor_rcp.value= param4;
	if(param1=='eliminar') {
		if(confirm("¿Está seguro de eliminar el registro seleccionado?"))
			document.forms[0].submit();
	}else document.forms[0].submit();			
}
function metodo(param){
	document.forms[0].method.value='forward';
	document.forms[0].forward.value=param;
	if(param=='eliminar') {
		if(confirm("¿Está seguro de eliminar los registros seleccionados?")){
			document.forms[0].method.value=param;
			document.forms[0].submit();
		}
	} else document.forms[0].submit();
}
function habilitarTable(_onload){
}

function habilitarTable1(_onload){
	if(_onload) {
	
		$("#multitabla a").each(function(){
			temp = $(this).attr("href");
			temp += "&tipoSel=M";
			$(this).attr("href", temp);
		});
		$("#perfil a").each(function(){
			temp = $(this).attr("href");
			temp += "&tipoSel=P";
			$(this).attr("href", temp);
		});
		$("#permisoperfil a").each(function(){
			temp = $(this).attr("href");
			temp += "&tipoSel=S";
			$(this).attr("href", temp);
		});

		tipoSeleccionado = "<%=tipo%>";		
		$("select[name=tipo]").val(tipoSeleccionado);
	}
	
	if (document.forms[0].tipo.value == 'P'){
		window.document.getElementById('multitabla').style.display='none';
		window.document.getElementById('perfil').style.display='block';
		window.document.getElementById('permisoperfil').style.display='none';
	}
	if (document.forms[0].tipo.value == 'M'){
		window.document.getElementById('multitabla').style.display='block';
		window.document.getElementById('perfil').style.display='none';
		window.document.getElementById('permisoperfil').style.display='none';
	}
	if (document.forms[0].tipo.value == 'S'){
		window.document.getElementById('multitabla').style.display='none';
		window.document.getElementById('perfil').style.display='none';
		window.document.getElementById('permisoperfil').style.display='block';
	}
}
</script>
<BODY onload='habilitarTable(true)'>
<html:form action="/mantenimientoTablas" >
<html:hidden property= "forward"/>
<html:hidden property= "cod_mult"/>
<html:hidden property= "cod_ele"/>
<html:hidden property= "cod_perfil"/>
<html:hidden property= "tipo_acceso"/>
<html:hidden property= "valor_rcp"/>
<input type="hidden" name="method"/>
<input type="hidden" name="tipoCombo" value="P"/>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td class="TituloPagServGen">Carpetas Comerciales</td>
		</tr>
	</table>
	<br>
	<table width="100%" border="2" align="center">
		<tr><td style="padding: 10px;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td witdh="40px;">Tipo:</td>
					<td witdh="80px;">
						<html:select property="tipo" onchange="habilitarTable(false)">
							<html:option value="M">Multitabla</html:option>
							<html:option value="P">Perfil</html:option>
							<html:option value="S">PermisoPerfil</html:option>
						</html:select>
					</td>
					<td align="right">
						<html:button property="cancelar" styleClass="boton" onclick="metodo('agregar');">Agregar</html:button>
						<html:button property="cancelar" styleClass="boton" onclick="metodo('eliminar');">Eliminar</html:button>
						<html:button property="cancelar" styleClass="boton" onclick="window.close();">Salir</html:button>
					</td>
				</tr>
			</table>
			</td>
		</tr>
		<tr>
			<td>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td colspan="2">
						<table width="100%" cellpadding="0" cellspacing="0" border="0">
							<tr>
								<td>
									<div id="multitabla">
									<table width="100%" cellpadding="0" cellspacing="0" border="1" >
										<display:table id="multitabla" pagesize="10" name="sessionScope.listaMultitabla" class="displayTable" width="100%" >
											<display:column width="100px" title="COD MULT" property="cod_mult"/>
											<display:column width="100px" title="COD ELE" property="cod_ele"/>
											<display:column title="VALOR 1" property="valor1"/>
											<display:column title="VALOR 2" property="valor2"/>
											<display:column title="VALOR 3" property="valor3"/>
											<display:column title="VALOR 4" property="valor4"/>		
											<display:column width="100px" title="Seleccionar">
												<IMG alt="Ver" border="1" src="<c:out value="${pageContext.request.contextPath}"/>/images/search_16.gif" width="16" height="16" onclick="javascript:metodoIMG2('ver','<c:out value="${multitabla.cod_mult}"/>','<c:out value="${multitabla.cod_ele}"/>');" />
												<IMG alt="Modificar" border="1"	src="<c:out value="${pageContext.request.contextPath}"/>/images/icon_edit_16.gif" width="16" height="16" onclick="javascript:metodoIMG2('modificar','<c:out value="${multitabla.cod_mult}"/>','<c:out value="${multitabla.cod_ele}"/>');"/>
												<IMG alt="Eliminar" border="1" src="<c:out value="${pageContext.request.contextPath}"/>/images/icon_cancel_16.gif" width="16" height="16" onclick="javascript:metodoIMG2('eliminar','<c:out value="${multitabla.cod_mult}"/>','<c:out value="${multitabla.cod_ele}"/>')"/> 
											</display:column>			
											<display:column width="20px" title="<input style='display:none;' type='checkbox' name='selectall' onClick='chequear_todos(this);'">
												<input type="checkbox" id="${multitabla.cod_mult}-${multitabla.cod_ele}" name="seleccion" value="${multitabla.cod_mult}-${multitabla.cod_ele}">
											</display:column>
										</display:table>
									</table>
									</div>
									<br/>
									<div id="perfil" style="display: block;">
									<table width="100%" cellpadding="0" cellspacing="0" border="1" >
										<display:table id="perfil" pagesize="10" name="sessionScope.listaPerfil" class="displayTable" width="100%">
											<display:column width="200px" title="COD PERFIL" property="cod_perfil"/>
											<display:column title="DES PERFIL" property="des_perfil"/>
											<display:column title="COMPONENTE" property="componente"/>
											<display:column width="100px" title="Seleccionar">
												<IMG alt="Ver" border="1" src="<c:out value="${pageContext.request.contextPath}"/>/images/search_16.gif" width="16" height="16" onclick="javascript:metodoIMG1('ver','<c:out value="${perfil.cod_perfil}"/>');" />
												<IMG alt="Modificar" border="1"	src="<c:out value="${pageContext.request.contextPath}"/>/images/icon_edit_16.gif" width="16" height="16" onclick="javascript:metodoIMG1('modificar','<c:out value="${perfil.cod_perfil}"/>');"/>
												<IMG alt="Eliminar" border="1" src="<c:out value="${pageContext.request.contextPath}"/>/images/icon_cancel_16.gif" width="16" height="16" onclick="javascript:metodoIMG1('eliminar','<c:out value="${perfil.cod_perfil}"/>')"/> 
											</display:column>			
											<display:column width="20px" title="<input style='display:none;' type='checkbox' name='selectall' onClick='chequear_todos(this);'">
												<input type="checkbox" id="${perfil.cod_perfil}" name="seleccion" value="${perfil.cod_perfil}">
											</display:column>
										</display:table>
									</table>
									</div>
									<br/>
									<div id="permisoperfil" style="display: block;">
									<table width="100%" cellpadding="0" cellspacing="0" border="1" >
										<display:table id="permisoPerfil" pagesize="10" name="sessionScope.listaPermisoPerfil" class="displayTable" width="100%">
											<display:column width="200px" title="COD PERFIL" property="cod_perfil"/>
											<display:column title="TIPO ACCESO" property="tipo_acceso"/>
											<display:column title="VALOR RCP" property="valor_rcp"/>
											<display:column width="100px" title="Seleccionar">
												<IMG alt="Ver" border="1" src="<c:out value="${pageContext.request.contextPath}"/>/images/search_16.gif" width="16" height="16" onclick="javascript:metodoIMG3('ver','<c:out value="${permisoPerfil.cod_perfil}"/>','<c:out value="${permisoPerfil.tipo_acceso}"/>','<c:out value="${permisoPerfil.valor_rcp}"/>');" />
												<IMG alt="Eliminar" border="1" src="<c:out value="${pageContext.request.contextPath}"/>/images/icon_cancel_16.gif" width="16" height="16" onclick="javascript:metodoIMG3('eliminar','<c:out value="${permisoPerfil.cod_perfil}"/>','<c:out value="${permisoPerfil.tipo_acceso}"/>','<c:out value="${permisoPerfil.valor_rcp}"/>')"/> 
											</display:column>			
											<display:column width="20px" title="<input style='display:none;' type='checkbox' name='selectall' onClick='chequear_todos(this);'">
												<input type="checkbox" id="${permisoPerfil.cod_perfil}-${permisoPerfil.tipo_acceso}-${permisoPerfil.valor_rcp}" name="seleccion" value="${permisoPerfil.cod_perfil}-${permisoPerfil.tipo_acceso}-${permisoPerfil.valor_rcp}">
											</display:column>
										</display:table>
									</table>
									</div>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td></tr>
	</table>
</html:form>

</BODY>
</html:html>
