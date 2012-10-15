<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>iilc_permiso_usuario_buscar</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/theme/Master.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/theme/IIRGEspacio2.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/includes/js/bbva/jquery-ui.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/jquery-1.2.6.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/js/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript">
var verificar = '${requestScope.verificar}';
var result = ${requestScope.listaPermisoUsuario};
var cargo = '${requestScope.codCargo}';
var oficina = '${requestScope.oficina}';
var nombre = '${requestScope.nombre}';
var perfil = parseInt('${requestScope.perfil}');
var registro = $("input[name=registro]").val().toUpperCase();
if(registro.length == 0) {
	registro = $("input[name=registroDisabled]").val().toUpperCase();
}

$('#usuario').html(nombre);

if(verificar.toLowerCase()=='si') {
	if(result.length==0){
		if(confirm("Esta seguro que desea grabar")){
			$("form[name=registrarPermiso]").submit();
		}
	}else{
		if(confirm("El registro ya existe. \u00BFDesea reemplazarlo?")){
			$("form[name=registrarPermiso]").submit();
		}
	}	
} else {
	var sw = 'inline';
	var sx = 'none';
	
	if(perfil==1){
		alert('El registro '
			+ registro 
			+ ', ya tiene un perfil asociado por Registro: ['
			+ cargo 
			+ '], [' + oficina + '].');
		sw = 'none';
		sx = 'inline';
	}
	if(perfil==2){
		alert('El registro '
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
	
	if(sw!='none'){
		if(result.length==0){
			if(nombre.length==0){
				alert("Usuario no registrado en BBVA PERU.");
			}else{
				alert("El n\u00FAmero de registro ingresado no tiene territorios asociados.");
			}
		}
	
		apply = '';
		$.each(result, function(idx, val){
			if(apply.indexOf(val.codTerritorio)==-1){
				$("#terr_" + val.codTerritorio).attr('checked', true);
				$("." + val.codTerritorio).css({"display":"inline"});
				apply += val.codTerritorio + ',';
			}
			$("#ofic_" + val.codTerritorio + "_" + val.codOficina).attr('checked', true);
		});
		
		cta = 0;
		$(".territorio").each(function(){
			chk = $(this).attr('checked') ? true : false;
			if(chk != true) {
				cta++;
			}
		});
		$("input[name=allTerritorio]").attr('checked', (cta > 0) ? false : true);
		
		cta = 0;
		$(".oficina").each(function(){
			chk = $(this).attr('checked') ? true : false;
			if(chk != true) {
				cta++;
			}
		});
		$("input[name=allOficina]").attr('checked', (cta > 0) ? false : true);
	}
}
</script>
</head>
</html>