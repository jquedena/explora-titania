<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<html:html>
<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet" href='${pageContext.request.contextPath}/theme/IIRGEspacio2.css' type="text/css">
<title>Carpetas Comerciales</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/js/contexto.js"></script>
<script type="text/javascript">
	var contexto = obtenerContexto();

	function eliminar(){
		alert("Esta opción eliminará permanentemente la información del Histórico de Seguimiento .La siguiente ventana le permitirá aceptar o cancelar la acción");
		if (confirm("Se eliminarán todos los registros del histórico de seguimiento Carpetas Comerciales. ¿Desea continuar?")){
			document.forms[0].action = contexto+"eliminarHistorico.do";       
			document.forms[0].submit(); 
			return true;
		}
		
	}  
</script>
</head>
<body>
<form>
<table width="100%" border="1" cellpadding="0" cellspacing="0">
		
		<tr class="FondoGris1"><td style="font-weight: bold;color: #2d4492;" >
		<br/>
		&nbsp;&nbsp;&nbsp;CARGAS :
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="2" class="datTable">
 
			<tr>
				<td width="2%"></td>
				<td width="98%"><A href="<c:out value="${pageContext.request.contextPath}"/>/pages/AdmArchVincula.jsp"  >CARGA DE ARCHIVOS DE VINCULACI&Oacute;N</A></td>
			</tr> 

			<tr>
				<td width="2%"></td>
				<td width="98%"><A href="<c:out value="${pageContext.request.contextPath}"/>/pages/administracionCargaArchivos/iilc_adm_carga_variofer.jsp"  >CARGA DE ARCHIVOS DE OTRAS OFERTAS</A></td>
			</tr> 
						<tr>
				<td width="2%"></td>
				<td width="98%"><A href="<c:out value="${pageContext.request.contextPath}"/>/pages/administracionCargaArchivos/iilc_adm_carga_oferta_cli.jsp"  >CARGA DE ARCHIVOS DE OFERTAS</A></td>
			</tr>
			<tr><td colspan="2">&nbsp;</td></tr> 
		</TABLE>
		 
		&nbsp;&nbsp;&nbsp;CABECERAS :
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="2" class="datTable">
 			<tr>
				<td width="2%"></td>
				<td width="98%"><A href="<c:out value="${pageContext.request.contextPath}"/>/pages/iilc_listado_vinculacion.jsp" > CABECERA VINCULACI&Oacute;N</A></td>
			</tr> 
			
			<tr>
				<td width="2%"></td >
				<td width="98%"><A href="<c:out value="${pageContext.request.contextPath}"/>/listadoDescripcionCarpetas.do" > DESCRIPCI&Oacute;N DE PESTAÑAS CARPETAS COMERCIALES</A></td>
			</tr>
			
			<tr>
				<td width="2%"></td >
				<td width="98%"><A href="<c:out value="${pageContext.request.contextPath}"/>/administrarCabecera.do?method=administrar" >  ADMINISTRAR CABECERA CARPETAS COMERCIALES  </A></td>
			</tr>
			 <tr><td colspan="2">&nbsp;</td></tr> 

		</TABLE>
		
		
		
		&nbsp;&nbsp;&nbsp;OTROS :
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="2" class="datTable">
			 <tr>
				<td width="2%"></td>
				<td width="98%"><A href="<c:out value="${pageContext.request.contextPath}"/>/permisoUsuario.do?method=listar"  >ACCESO USUARIO CONSULTA</A></td>
			</tr>
			<tr>
				<td width="2%"></td>
				<td width="98%"><A href="javascript:eliminar();" > BORRADO DE SEGUIMIENTO DE INGRESO A LA APLICACI&Oacute;N </A></td>
			</tr>
			<tr><td colspan="2">&nbsp;</td></tr> 
		</TABLE>
		</td></tr>
	</table>
</form>
</BODY>
</html:html>
