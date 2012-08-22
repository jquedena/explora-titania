<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<html:html>
<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../../theme/Master.css" rel="stylesheet"
	type="text/css">
<title>Registro de Rotativo</title>
<link href='<%=request.getContextPath()%>/css/basico.css'	rel="stylesheet" type="text/css">   
<link href='<%=request.getContextPath()%>/css/calendar.css'	rel="stylesheet" type="text/css">   

<script type="text/javascript"	src="<%=request.getContextPath()%>/js/script.js"></script>
<script type="text/javascript"  src="<%=request.getContextPath()%>/js/calendar/mootools.v1.2.js" ></script>
<script type="text/javascript"  src="<%=request.getContextPath()%>/js/calendar/calendar.js"></script>
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
</head>
<body onLoad="redimension();">
<div id="pagina" style="overflow:auto;">
<html:form method ="post" action="/territorioAction.do">
<input type="hidden" name="method" />
<table width="98%" height="100%" border="0" cellpadding="0" cellspacing="0" id="marco">
  <tr>
    <td height="28" colspan="3" bgcolor="#000e4b" class="titulos">Registro de Territorio </td>
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
            <TABLE width="100%" border="0">
              <tr>
                <td><TABLE width="100%" border="0" >
                    <TBODY>                      
                      <tr>
                        <td colspan="2">DATOS DE TERRITORIO </td>
                      </tr>
                      <tr>
                        <td colspan="2"><table width="100%" class="pihue"  align="center" cellpadding="3" cellspacing="0" >
                          <tr>
                            <td><div class="pihue">
                              <table width="100%">
                                <tr>
                                  <td><table width="100%">
                                      <tr>
                                        <td> Codigo Territorio: </td>
                                        <td width="75%"><html:text property="codTerritorio" styleId="codTerritorio" size="30" maxlength="4" /></td>
                                        </tr>
                                      <tr>
                                        <td width="25%"> Nombre Territorio: </td>
                                        <td><html:text property="nomTerritorio" styleId="nomTerritorio" size="60"  /></td>
                                        </tr>
									  <tr>
                                        <td width="25%">Estado: </td>
                                        <td>
	                                      <html:select property="estado" size="1">
	                                    	<html:option value="-1" selected>[--Seleccione--]</html:option>
	                                      	<c:if test="${listaEstado != null}">
												<c:forEach var="lista" items="${listaEstado}">
													<html:option value="${lista.codElem}">
															<c:out value="${lista.valor1}" />
													</html:option>
												</c:forEach>
											</c:if>
	                                      </html:select>
                                        </td>
                                        </tr>									 
                                  </table></td>
                                </tr>
                              </table>
                            </div></td>
                          </tr>
                        </table></td>
                      </tr>
                      <tr>
						<td colspan="2" height="34">
						<div align="center"><input type="button" value="Enviar"
						onclick="metodo('crear')" class="boton"> &nbsp;<input type="button"
						value="Cancelar" onClick="window.close();" class="boton"></div></td>
						</tr>
                    </TBODY>
                </TABLE></td>
              </tr>
            </TABLE></td>
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
</html:html>
