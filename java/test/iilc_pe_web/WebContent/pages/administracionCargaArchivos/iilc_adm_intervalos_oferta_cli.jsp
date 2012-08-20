
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
 
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>  
<%@ taglib uri="/WEB-INF/displaytag-11.tld" prefix="display"%>
<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<META name="GENERATOR" content="IBM Software Development Platform">
<LINK rel="stylesheet" href='<c:out value="${pageContext.request.contextPath}"/>/theme/IIRGEspacio2.css' type="text/css">
<LINK rel="stylesheet" href='theme/IIRGEspacio2.css' type="text/css">
	
<TITLE>Carpetas Comerciales</TITLE>
<style type="text/css">
 
#contenido {
    position:absolute;
    left:35%;
    border:1;
    top:38%;
    width:30%;
    height:15%px;
    z-index:2;
    background-color:white;
    color: black;
}


</style>

<script language="javascript" type="text/javascript" src="<c:out value="${pageContext.request.contextPath}"/>/includes/datetimepicker.js"></script>
<script type="text/javascript" src="<c:out value="${pageContext.request.contextPath}"/>/includes/jquery-1.2.6.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/js/contexto.js"></script>
<script type="text/javascript">
var contexto = obtenerContexto();
	
function validaCaractaer(e)
		{
		var tecla= String.fromCharCode((document.all) ? e.keyCode : e.which);
		var digits = "0123456789";
		if(digits.indexOf(tecla)==-1) return false;
		
		
		}
            
            
function mensajero(){

	if(document.forms[0].mensaje.value=='NULL' ||
	   document.forms[0].mensaje.value=='null' ||
	   document.forms[0].mensaje.value==''){
	  }else{
	   
	  		alert(document.forms[0].mensaje.value);
 
	  }
}

function salir(){
    	 window.location = contexto+"pages/administracionCargaArchivos/iilc_adm_carga_oferta_cli.jsp";
}

function grabar(){
	/*
	error=false;
	for(i=0;i<1;i++){ // document.forms[0].valor1.length
		// alert(document.forms[0].valor1[i].value.length);
		// alert(document.forms[0].valor2[i].value.length);
		if(document.forms[0].valor1[i].value.length > 0 || document.forms[0].valor2[i].value.length > 0) {
			if(error){
				break;
			} else {
				$.post(contexto+"admCargaOfertasClientesAction.do?method=validarIntervalos&cod_ele="+i+"&valor1="+document.forms[0].valor1[i].value+"&valor2="+document.forms[0].valor2[i].value, function(data) {
					console.log(data);
					if(data!=''){
						data = data + i;
						error=true;
					}
				});
			}
		}
	}
	*/
	// if(error==false){
		document.forms[0].action =contexto+'admCargaOfertasClientesAction.do?method=actualizarIntervalos';       
		document.forms[0].submit();
	// } else {
	//	alert(data);
	// }
}

window.onload=function(){
	var mensaje='${requestScope.mensaje}';
	if(mensaje!=null || mensaje != '' || mensaje!=undefined) {
		alert(mensaje);
	}
}


</script>
</HEAD>

<BODY onload="mensajero();" >
<html:form action="/admCargaOfertasClientesAction" >
<img style="visibility: hidden"  src="<c:out value="${pageContext.request.contextPath}"/>/images/icos/cerrar.png"  />
<input type="hidden" id="mensaje" name="mensaje" value="<%=request.getAttribute("mensaje")%>" />
<input type="hidden" id="id" name="id" value="<%=request.getAttribute("id")%>" />  
<table width="100%" border="0" cellspacing="0" cellpadding="0">
 
<tr>
	<td style="vertical-align:middle;" colspan="2" >
		<TABLE width="100%" align="center">
			<TR>
				<TD class="FondoAzul" width="25%">INTERVALOS</TD>
			 
		</TR>
	</TABLE>
	</td>
</tr>
	</table>
	<br>
	<table width="100%" border="1" cellpadding="0" cellspacing="0">
		
		<tr class="FondoGris1"><td>
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="datTable">
			<tr>
				<td colspan="2" align="right" >
				
				</td>
			</tr>
			
			<tr>
				<td width="100%" align="left" >
						
						<display:table name="listaIntervalos"  id="lista" pagesize="20"   summary="false" scope="request"  class="grilla"  >
							<display:column  class="cabecera" property="cod_ele"  /> 
							<display:column class="cabecera" title="INTER.INI" > 
								<input type="text" id="valor1" name="valor1" maxlength="7"   value="${lista.valor1}"  />
							</display:column>
							<display:column class="cabecera" title="INTER.FIN" > 
								<input type="text" id="valor2" name="valor2" maxlength="7"     value="${lista.valor2}"  />
							</display:column>
						</display:table><input type="button" value="Grabar"
						onclick="grabar();">
						
 
								</td> 
							</tr>
 
							<tr>
								 <td  colspan="4" align="center" >
										 
									<html:button property="salir1"  onclick="salir();">
										Salir
									</html:button>
								</td>
 
							</tr>
						</table>
						
						
				</td>
			</tr>
		</TABLE> 

</html:form>
</BODY>
</html:html>
