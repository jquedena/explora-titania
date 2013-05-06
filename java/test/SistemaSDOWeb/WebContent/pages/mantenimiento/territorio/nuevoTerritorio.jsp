<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<META HTTP-EQUIV='PRAGMA' CONTENT='NO-CACHE'>
<META HTTP-EQUIV='EXPIRES' CONTENT='0'>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath()%>/tinymce/js/tiny_mce/tiny_mce.js"></script>

<script src="<%=request.getContextPath()%>/js/colorpicker/mootools.v1.11.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/colorpicker/nogray_core_vs1_min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/colorpicker/nogray_color_picker_vs2.js" type="text/javascript"></script>
<TITLE></TITLE>

<script language="javascript">
	window.addEvent('domready', function(){
		var color = new ColorPicker('colorFondo', 'colorFondo_div', {color:'#FFFFFF'}, 'mantenimientoTerritorioAction.do?method=popupSelectorColor');		
	});	
</script>

<%
String codTerritorio = (String)request.getAttribute("codTerritorio");
String nomTerritorio = (String)request.getAttribute("nomTerritorio");
String mensaje = (String)request.getAttribute("mensaje");
%>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/validaTecla.js"></script>
<script language="javascript">

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

function enviar(){
	var ValorCod = document.forms.cod.value;
	var ValorNom = document.forms.nom.value;
	
	if(ValorCod == "") {
		alert("Ingrese código del territorio.");
		return false;
	}
	
	if(ValorNom == "") {
		alert("Ingrese nombre del territorio.");
		return false;
	}
	
	// Validar mensaje
	var mensaje = limpiarTextoHTML(tinyMCE.get('mensaje').getContent());
	var lineas = mensaje.split("\n");
	
	/*if(lineas.length - 1 == 0){
		alert("No hay ningún texto");
		return false;
	}
	else */
	if(lineas.length - 1> 18){
		alert("Sólo se permite un máximo de 18 líneas");
		return false;
	}
	else{
		for(i=0; i<lineas.length - 1; i++){
			if(lineas[i].length > 36){
				alert("Cada línea no debe superar los 36 caracteres de longitud.");
				return false;
				break;
			}
		}
	}
	
	document.forms.codTerritorio.value=ValorCod;
	document.forms.nomTerritorio.value=ValorNom;
	document.forms.action="mantenimientoTerritorioAction.do?method=grabarTerritorio";
	document.forms.submit();	
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
</script>
</HEAD>

<BODY>
<table align="center" width="100%" height="%" cellspacing="0" cellpadding="0">
	<tr>
		<td width="100%" align="left"  valign="top">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td><img src="<%=request.getContextPath()%>/images/esq_izq.jpg"></td>	
					<td width="200" class="textocentradoblanco">MANTENIMIENTO</td>	
					<td><img src="<%=request.getContextPath()%>/images/esq_der.jpg"></td>	
				</tr>						
			</table>
		</td>	
	</tr>
	<tr>
		<td style="border: 2px solid #264971;padding:20px;" valign="top" height="%" align="center">


			<!-- **** INICIO RESTO DE CÓDIGO DE LA PÁGINA-->
<form  method="post" name="forms">
<input type="hidden" name="codTerritorio" >
<input type="hidden" name="nomTerritorio" >
<div align="center"><strong>NUEVO TERRITORIO</strong></div><br />
<table cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td class="colorfila1" width="60">Codigo:</td>
    <td class="colorfila1" align="left"><input name="cod" type="text" value="<%=codTerritorio %>" maxlength="4" class="cajatexto" onkeypress="return validKey(this, event, INT_PATTERN);"/> </td>
  </tr>
  <tr>
    <td class="colorfila2">Nombre:</td>
    <td class="colorfila2" align="left"><input name="nom" type="text" value="<%=nomTerritorio %>" size = "35" maxlength="99" class="cajatexto" onkeypress="return SoloLetras()"/>
</td>
  </tr>
   <tr>
    <td class="colorfila2">Mensaje:</td>
    <td class="colorfila2" align="left">
    	<textarea class="textocelda" id="mensaje" name="mensaje" rows="15" cols="80" style="width: 80%"></textarea>
	</td>
  </tr>
  <tr>
	    <td class="colorfila2">Color de Fondo</td>
	    <td align="left" class="colorfila2">	    	
			<div id="colorFondo_div" class="sample_swatch" style="width: 30px; border: 1px; border-style: solid ;border-color: #000000">&nbsp;</div>
			<input type="hidden" size="6" id="colorFondo" name="colorFondo" readonly="readonly"/>			
		</td>
  </tr>
  <tr>
    <td colspan="2">&nbsp;</td>
  </tr>
  <tr >
    <td colspan="2">
    <table align="center"><tr>
    <td><input type="button" name="Aceptar" value="Aceptar" onclick="enviar();" class="botonnew"></td>
    <td width="20">&nbsp;</td>
    <td><input type="button" name="Cancelar" value="Cancelar" onclick="history.back()" class="botonnew"></td>
    </tr></table>
    </td>
  </tr>
</table>
</form>
<!-- **** FIN RESTO DE CÓDIGO DE LA PÁGINA-->


		</td>
	</tr>
</table>
</BODY>
</html:html>
