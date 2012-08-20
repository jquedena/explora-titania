<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>iilc_permiso_usuario</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/theme/Master.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/theme/IIRGEspacio2.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/includes/js/bbva/jquery-ui.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/js/contexto.js"></script>
<script type="text/javascript">
	var contexto = obtenerContexto();
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/jquery-1.2.6.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/js/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/js/iilc_permiso_usuario.js"></script>
<script type="text/javascript">
var cargo = '${requestScope.codCargo}';
var oficina = '${requestScope.oficina}';
var nombre = '${requestScope.nombre}';
var perfil = parseInt('${requestScope.perfil}');
var registro = '${requestScope.registro}';

window.onload = function(){

	var sw = 'inline';
	var sx = 'none';
	
	if(perfil==1){
		alert('No se puede grabar la informaci\u00F3n, del registro '
			+ registro 
			+ ', ya tiene un perfil asociado por Registro: ['
			+ cargo 
			+ '], [' + oficina + '].');
		sw = 'none';
		sx = 'inline';
	}
	if(perfil==2){
		alert('No se puede grabar la informaci\u00F3n, del registro '
			+ registro 
			+ ', ya tiene un perfil asociado por Cargo: ['
			+ cargo 
			+ '], [' + oficina + '].');
		sw = 'none';
		sx = 'inline';
	}
	
	// $("input[name=cmdGrabar]").css('display', sw);
	// $("input[name=cmdGrabar1]").css('display', sx);
	// $("input[name=cmdEliminar]").css('display', sw);
	// $("input[name=cmdEliminar1]").css('display', sx);
	$("input[name=cmdLimpiar]").click();

	if(perfil==-1){
		<c:if test="${requestScope.registro!=null}">
			alert('Configuraci\u00F3n registrada correctamente para el registro ${requestScope.registro}.');
			$("input[name=registro]").val("${requestScope.registro}");
			$("input[name=cmdBuscar]").click();
		</c:if>
	}
};
</script>
</head>
<body>
<div id="result" style="display: none"></div>
<form action="${pageContext.request.contextPath}/permisoUsuario.do" method="post" name="registrarPermiso">
<input type="hidden" name="method" value="registrar"/>
<input type="hidden" name="ver" value=""/>
<table width="99%" align="center">
<tr>
	<td colspan="2" style="vertical-align:middle;font-weight: bold;" class="FondoAzul">
		ADMINISTRADOR DE USUARIOS
	</td>
</tr>
<tr>
	<td colspan="2">&nbsp;</td>
</tr>
<tr>
	<td style="vertical-align: middle;"><b>Registro: </b><input maxlength="7" type="text" name="registro" value="" style="font-weight: bold; width: 100px;"><input maxlength="7" type="text" name="registroDisabled" readonly class="readonly" value="" style="font-weight: bold; width: 100px; display: none;"></td>
	<td><input type="button" name="cmdLimpiar" class="boton" value="Limpiar" />
		<input type="button" name="cmdBuscar" class="boton" value="Buscar" />&nbsp;&nbsp;<b id="usuario"></b></td>
</tr>
<tr>
	<td colspan="2">&nbsp;</td>
</tr>
<tr>
	<td style="width:40%">
		<table style="width:630;background-color: #fff;" cellpadding="0" cellspacing="0">
		<tr>
			<td class="FondoAzul" style="width:50px;" align="center"><b>Todos</b></td>
			<td class="FondoAzul" style="vertical-align: middle;" rowspan="2"><b>Territorio</b></td>
		</tr>
		<tr>
			<td class="FondoAzul" style="width:50px;" align="center"><input type="checkbox" name="allTerritorio"/></td>
		</tr>
		</table>
		
		<div style="width: 650px; height: 400px; overflow: auto;">
			<table style="width: 630px;background-color: #fff;">
			<c:forEach items="${listaTerritorio}" var="territorio">
			<tr>
				<td align="center"><input class="territorio" type="checkbox" id='terr_<c:out value="${territorio.cod_territorio}"/>' name='terr_<c:out value="${territorio.cod_territorio}" />' /></td>
				<td><c:out value="${territorio.des_territorio}" /></td>
			</tr>
			</c:forEach>
			</table>
		</div>
	</td>
	<td style="width:60%">
		<table style="width:630;background-color: #fff;" cellpadding="0" cellspacing="0">
		<tr>
			<td class="FondoAzul" style="width:50px;" align="center"><b>Todos</b></td>
			<td class="FondoAzul" style="vertical-align: middle;" rowspan="2"><b>Oficina</b></td>
		</tr>
		<tr>
			<td class="FondoAzul" style="width:50px;" align="center"><input type="checkbox" name="allOficina"/></td>
		</tr>
		</table>
		<div style="width: 650px; height: 400px; overflow: auto;">
			
			<c:forEach items="${listaOficina}" var="oficina">
			<div class="${oficina.codTerritorio} oficinaDiv" style="display:none;">
			<table style="width: 630px;background-color: #fff;">
			<tr>
				<td style="width:50px;" align="center"><input class="oficina" type="checkbox" id='ofic_<c:out value="${oficina.codTerritorio}"/>_<c:out value="${oficina.codOficina}"/>' name='ofic_<c:out value="${oficina.codTerritorio}"/>_<c:out value="${oficina.codOficina}" />' /></td>
				<td><c:out value="${oficina.desTerritorio}" /> / <c:out value="${oficina.desOficina}" /></td>
			</tr>
			</table>
			</div>
			</c:forEach>
			
		</div>
	</td>
</tr>
<tr>
	<td style="vertical-align: middle;" colspan="2">
		<input type="button" name="cmdEliminar" class="boton" value="Eliminar"/>
		<input type="button" name="cmdEliminar1" class="boton" value="Eliminar" disabled style="display:none;"/>
		<input type="button" name="cmdGrabar" class="boton" value="Grabar"/>
		<input type="button" name="cmdGrabar1" class="boton" value="Grabar" disabled style="display:none;"/>
		<input type="button" name="cmdSalir" class="boton" value="Salir" />
	</td>
</tr>
</table>
</form>
</body>
</html>