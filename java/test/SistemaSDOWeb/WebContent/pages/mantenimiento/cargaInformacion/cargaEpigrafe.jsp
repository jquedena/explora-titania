<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@ taglib prefix="fn" uri="/WEB-INF/fn.tld"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld" %>
<%@ taglib uri="http://stefanini.com.pe/tags/util" prefix="util"%>
<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META HTTP-EQUIV='PRAGMA' CONTENT='NO-CACHE'>
<META HTTP-EQUIV='EXPIRES' CONTENT='0'>
<meta name="generator" content="Bluefish 2.0.3" >
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet"	href="<%=request.getContextPath()%>/css/style.css"	type="text/css">
<TITLE></TITLE>
</HEAD>
<script>
<% String colorfila = "";
	int i = 0;
%>

function cargarPage(){
	var form = document.forms[0];
	var mydate=new Date()
	var year=mydate.getYear()
	if (year <1000)
		year+=1900
	var month=mydate.getMonth()
	var mes = parseFloat(month)+1;
	
	if (mes<10)
		month="0"+mes
	
	form.fileInput.value="D:\\de\\iido\\online\\pe\\web\\uti\\carga\\epig"+year+""+month+".txt";
}

function envioDatos(){
	var form = document.forms[0];
	form.txtRuta.value = form.fileInput.value;

	if(form.txtRuta.value == "") {
		alert("Seleccione un archivo");
		return false;
	}	
	form.action = "planificacionAction.do?method=cargaDataEpigrafe";
	form.method="post";	
	form.submit();
}

function borrarEpigrafe() {
	alert("Ingreso Borrar Data...");
	var form = document.forms[0];
	form.txtRuta.value = "";	
	form.action = "planificacionAction.do?method=borrarEpigrafe";
	form.method="post";
	form.submit();
}

function regresar(){
	var form = document.forms[0];	
	form.action="planificacionAction.do?method=inicioCarga";
	form.submit();
}

</script>
<BODY>
<table align="center" width="100%" height="%" cellspacing="0" cellpadding="0">
	<tr>
		<td width="100%" align="left"  valign="top">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td><img src="<%=request.getContextPath()%>/images/esq_izq.jpg"></td>
					<td width="200" class="textocentradoblanco">CARGA DE INFORMACI&Oacute;N </td>
					<td><img src="<%=request.getContextPath()%>/images/esq_der.jpg"></td>
				</tr>						
			</table>
		</td>	
	</tr>
	<tr>
		<td style="border: 2px solid #264971;padding:10px;" valign="top" height="%" align="center">				
		<div id="pagina" style="overflow:auto;">
			<form action="/planificacionAction" styleId="planeacionForm" enctype="multipart/form-data">
				<input type="hidden" name="txtRuta" >
				<input type="hidden" name="txtArchivo">
				<p class="titulo">Cargar Data de Epigrafes</p>							
			<table height="50" cellspacing="0" >
			<tr>
			    <td width="57" align="center"><span class="Estilo2">Ruta:</span></td>
			    <td><input type="file" class="multi" maxlength="1" accept="txt" name="fileInput" id="fileInput" /></td>
				<td><input type="button" name="grabo" value="Enviar" onClick="javascript:envioDatos()"></td>
		    </tr>
			</table>
			<util:errorMessage key="error_message" styleClass="mensaje_error"/>		  		  			
			<c:if test="${mostrarResumen}">
			<p><a target="_blank" href="<%=request.getContextPath()%>/LogDownload?file=/mnt/compartido/iido/uti/jsp/CargaEpigrafe.log"><b>Ver log</b></a></p>
			  <table class="DataGrid" width="700" cellspacing="0">
			  	<tr>
			  		<th>Informe de carga</th>
			  		<th>Registros OK</th>
					<th>Registros con Error</th>
					<th>Total</th> 
			  	</tr>
				<tr>
					<td  width="520"> - N&deg; registros del archivo</td>
					<td  width="60" align="center">${registrosOkEpig}</td>
					<td  width="60" align="center">${registrosErrEpig}</td>
					<td  width="60" align="center">${registrosTotalEpig}</td>
				</tr>
				<tr>
					<td  width="520"> - N&deg; registros cargados OK</td>
					<td  width="60" align="center">${cargadosOkEpig}</td>
					<td  width="60" align="center">0</td>
					<td  width="60" align="center">${cargadosOkEpig}</td>
				</tr>
				<tr>
					<td  width="520"> - N&deg; registros NO cargados, falla al guardar en repositorio de datos</td>
					<td  width="60" align="center">0</td>
					<td  width="60" align="center">${cargadosErrEpig}</td>
					<td  width="60" align="center">${cargadosErrEpig}</td>
				</tr>
				<tr>
					<td  width="520"> - N&deg; registros NO cargados, campos nulos</td>
					<td  width="60" align="center">0</td>
					<td  width="60" align="center">${nulosErrEpig}</td>
					<td  width="60" align="center">${nulosErrEpig}</td>
				</tr>
				<tr>
					<th  width="520" align="left">TOTAL</th>
					<th  width="60" align="center">${totalOkEpig}</th>
					<th  width="60" align="center">${totalErrEpig}</th>
					<th  width="60" align="center">${totalEpig}</th>
				</tr>
			  </table>
			  </c:if>
			</form></div>

		</td>
	</tr>
</table>
<table border="0" cellpadding="0" cellspacing="0" width="938">
  <tr>
    <td></td>
  </tr>
  <tr>
    <td></td>
  </tr>
</table>
</BODY>
</html:html>
