<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<META HTTP-EQUIV='PRAGMA' CONTENT='NO-CACHE'>
<META HTTP-EQUIV='EXPIRES' CONTENT='0'>
<title></title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css" type="text/css" />

<%
  String alerta = (String) request.getAttribute("alerta");
  String texto  = (String) request.getAttribute("msg");
  if (texto == null) texto = "";
%>

<!-- TinyMCE -->
<script type="text/javascript"
	src="<%=request.getContextPath()%>/tinymce/js/tiny_mce/tiny_mce.js"></script>
<script type="text/javascript">

function preview(){
	if(validar()){
		document.bienvenida.accion.value = "P";
		document.bienvenida.texto.value = tinyMCE.get('elm1').getContent();
		document.bienvenida.submit();
	}
}

function guardar(){
	if(validar()){
		document.bienvenida.txtRuta.value = document.bienvenida.fileInput.value;
		if(document.bienvenida.txtRuta=="") alert('Ud. No ha seleccionado ning\u00FAn archivo');
		document.bienvenida.accion.value = "G";
		document.bienvenida.texto.value = tinyMCE.get('elm1').getContent();
		document.bienvenida.submit();
	}
}

function validar(){
	var res = true;
	var o = limpiarTextoHTML(tinyMCE.get('elm1').getContent());
	var lineas = o.split("\n");
	
	if(lineas.length - 1 == 0){
		alert("No hay ning\u00FAn texto");
		res = false;
	}
	else if(lineas.length - 1>30){
		alert("S\u00F3lo se permite un m\u00E1ximo de 30 l\u00EDneas");
		res = false;
	}
	else{
		for(i=0;i<lineas.length - 1;i++){
			if(lineas[i].length>130){
				alert("Cada l\u00EDnea no debe superar los 130 caracteres de longitud.");
				res = false;
				break;
			}
		}
	}
	
	//if()
	
	return res;
}

function limpiarTextoHTML(texto){
	var j = 0;
	while(true){
		j = texto.length;
		texto = texto.replace("&aacute;","a");
		texto = texto.replace("&eacute;","e");
		texto = texto.replace("&iacute;","i");
		texto = texto.replace("&oacute;","o");
		texto = texto.replace("&uacute;","u");
		texto = texto.replace("&Aacute;","A");
		texto = texto.replace("&Eacute;","E");
		texto = texto.replace("&Iacute;","I");
		texto = texto.replace("&Oacute;","O");
		texto = texto.replace("&Uacute;","U");
		texto = texto.replace("&ntilde;","n");
		texto = texto.replace("&Ntilde;","N");
		texto = texto.replace("</p>","\n");
		texto = texto.replace("</P>","\n");
		texto = texto.replace("<br />","\n");
		texto = texto.replace("<BR />","\n");
		if(texto.length==j)
			break;
	}
	
	var salida = "";
	j=1;
	for(i=0;i<texto.length;i++){
		if(texto.substr(i,1)=="<") j=0;
		if(j==1) salida=salida+""+texto.substr(i,1);
		if(texto.substr(i,1)==">") j=1;
	}
	return salida;
}
	tinyMCE.init({
		// General options
		mode : "textareas",
		theme : "advanced",
		plugins : "safari,pagebreak,style,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,paste,directionality,noneditable,visualchars,nonbreaking,template",

		// Theme options
		theme_advanced_buttons1 : "fontselect,fontsizeselect,|,bold,italic,underline,|,forecolor,|,numlist,bullist,outdent,indent,|,justifyleft,justifycenter,justifyright",
		theme_advanced_buttons2 : "",
		theme_advanced_buttons3 : "",
		theme_advanced_buttons4 : "",
		theme_advanced_toolbar_location : "top",
		theme_advanced_toolbar_align : "left",
		theme_advanced_statusbar_location : "bottom",
		theme_advanced_resizing : true,
		paste_remove_styles: true,
		paste_remove_spans: true,
		paste_strip_class_attributes: "all",
		theme_advanced_resizing : false,
		theme_advanced_path : false,
		force_br_newlines : true,
		content_css : "<%=request.getContextPath()%>/css/style.css",
		theme_advanced_fonts:"Arial=arial,helvetica,sans-serif;Arial Black=arial black,avant garde;Comic Sans MS=comic sans ms,sans-serif;Courier New=courier new,courier;Times New Roman=times new roman,times;Verdana=verdana,geneva",
		setup: function(ed) {
			ed.onPaste.add( function(ed, e, o) {
	            ed.execCommand('mcePasteText', true);
	            return tinymce.dom.Event.cancel(e);
	        });
		}
	});
	
var mensaje_error = '<%=alerta%>';
window.onload=function(){

	if (mensaje_error != 'null') {
		document.getElementById("xxx_error").innerHTML =  mensaje_error;
	}
}
</script>
<!-- /TinyMCE -->
</head>
<body>
<div id='body' style="text-align: center">
	<form method="post" name="bienvenida" action="actionBienvenida.do" styleId="bienvenidaForm" enctype="multipart/form-data">
	<input type="hidden" name="accion" value="" />
	<input type="hidden" name="texto" value="" />
	<input type="hidden" name="txtRuta" value="" />
	<table width="640" height="480">
		<tr>
			<td>
				<h2 style="text-align:center;margin-top: 20px;">Modificar Texto</h2>
				<div id="xxx_error" style="font-weight: bold;font-size: 120%;"></div>
			</td>
		</tr>
		<tr>
			<td>
				<div style="text-align:center; width:100%;">
					<textarea class="textocelda" id="elm1" name="elm1" rows="15" cols="80" style="width: 80%">
						<c:out value="${msg}" escapeXml="false" />
					</textarea>
				</div>
				<div style="text-align:center; width: 100%; border-style:solid; border-width:0px;">
					<table width="80%" height="50" border="0" cellspacing="0" >
					<tr>
						<td align="center" width="20%"><span>Imagen a Importar:</span></td>
						<td><span> <input type="file" style="width: 100%; padding-left: 10px" maxlength="1" accept="gif/jpg" name="fileInput" id="fileInput" /> </span></td>
					</tr>
					</table>
				</div>
				<div id='bot' style="padding-top: 30px;"><input type="button"
					value="Vista Previa" onclick="preview();" /> <input type="button"
					value="Guardar" onclick="guardar();" /></div>
			</td>
		</tr>
	</table>
	</form>
</div>
</body>
</html>
