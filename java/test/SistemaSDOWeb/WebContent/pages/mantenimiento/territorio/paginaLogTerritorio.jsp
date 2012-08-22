<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es-ES" lang="es-ES">
 
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Registro de Solicitud</title>
		<link href='<%=request.getContextPath()%>/css/basico.css'	rel="stylesheet" type="text/css">   
		<link href='<%=request.getContextPath()%>/css/calendar.css'	rel="stylesheet" type="text/css">
		<script type="text/javascript"	src="<%=request.getContextPath()%>/js/script.js"></script>
		<script type="text/javascript"	src="<%=request.getContextPath()%>/pages/mantenimiento/usuario/usuario.js"></script>
		<script type="text/javascript"  src="<%=request.getContextPath()%>/js/calendar/mootools.v1.2.js" ></script>
		<script type="text/javascript"  src="<%=request.getContextPath()%>/js/calendar/calendar.js"></script>
	</head>


<script type="text/javascript">
	function redimension(){
		f = document.getElementById('pagina').offsetHeight
		if (f < 400) f=400;
		parent.document.getElementById('MAIN').style.height = f + 10;
	}
	function metodo(param){	
		var f=document.forms[0];
		f.method.value = param;		
		f.submit();
	}	
</script>
<script language="javascript">
 var req;
 var tipoS;
 var ventana;
 /*
  * Get the second options by calling a Struts action
  */
	//Callback function
	function populateBox() {  
		var f = document.forms[0];
		var element;
		if (tipoS == 'T') {	
			element = f.codOficina;		
			}
		f.codOficina.options.length = 0;
		f.codOficina.options[0] = new Option('Seleccione', '-1');

		if (req.readyState == 4) { // Complete
			if (req.status == 200) { // OK response
				textToSplit = req.responseText;
				if (textToSplit == '803') {
				}
				//Split the document
				returnElements = textToSplit.split("||");
				if (returnElements == "")
					return;

				//Process each of the elements 					
				for ( var i = 0; i < returnElements.length; i++) {
					valueLabelPair = returnElements[i].split("|");
					element.options[i + 1] = new Option(valueLabelPair[1],
							valueLabelPair[0]);
				}
			}
		}
	}
</script>
<body onLoad="redimension();">
<div id="pagina" style="overflow:auto;">
<html:form method ="post" action="/territorioAction.do">
<input type="hidden" name="method" />
 <table width="99%" height="100%" border="0" cellpadding="0" cellspacing="0" id="marco">
  <tr>
     <td height="28" colspan="3"  background="<c:out value="${pageContext.request.contextPath}"/>/images/tabs.png"="titulos">
		<table width="100%"><tr><td width="211" class="titulos">Solicitud</td>
	<td width="725"></td>
	</tr></table>
	</td>
    <!-- marco horizontal arriba -->
  </tr>
  <tr>
    <td width="0.5%" height="100%" bgcolor="#000e4b"></td>
    <!-- marco vertical izq -->
    <td width="99%" valign="top"><!-- Celda principal - @Orlando Pihue Montoya -->
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="1%" height="10"></td>
            <td width="98%"></td>
            <td width="0%"></td>
          </tr>
          <tr>
            <td height="102">&nbsp;</td>
            <td valign="top">
            <table width="100%" border="0">
              <tbody>               
           <tr class="Titulo2">
           	<td height="34">
			<div class="pihue">
             <table width="100%">
                <tr>
                  <td width="14%" colspan="6">El Territorio <c:out value="${territorio.desTerritorio}"/>  se <c:out value="${tipo}"/> Satisfactoriamente</td>                  
				</tr>
				<tr>
                  <td></td>
                  <td></td>
                  <td>&nbsp;</td>
                  <td></td>
                  <td></td>
                  <td></td>
				</tr>
            </table></div>   
				  </td>
                  </tr>
                <tr>
                  <td></td>
                </tr>
              </tbody>
            </table></td>
            <td>&nbsp;</td>
          </tr>
		   <tr>
            <td height="2"></td>
            <!-- init botones -->
            <td colspan="1" align="center">&nbsp;</td>
            <!-- end  botones -->
            <td width="0%">&nbsp;</td>
            <td width="1%">&nbsp;</td>
          </tr>
        </table>
      <!-- fin de la celda principal -->    </td>
    <td width="0.5%" bgcolor="000e4b"></td>
    <!-- marco vertical der -->
  </tr>
  <tr>
    <td colspan="3" height="4" bgcolor="000e4b"></td>
    <!-- marco horizontal abajo -->
  </tr>
</table>
</html:form>
</div>
</body>
</html>