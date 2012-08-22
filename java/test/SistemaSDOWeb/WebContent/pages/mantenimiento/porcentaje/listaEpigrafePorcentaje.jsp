
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
<TITLE></TITLE>

<script type="text/javascript">
function editar(codEpigrafe,anio){
	location.href="porcentajeEpigrafeAction.do?method=consultarPorcentaje&codEpigrafe="+codEpigrafe+"&anio="+anio;
}
function buscaXAnio(valor){
	document.forms[0].submit();
	//location.href="porcentajeEpigrafeAction.do?method=buscaXAnio&anio="+valor;
	
}

</script>

</HEAD>

<BODY>
<html:form action="porcentajeEpigrafeAction" >
<html:hidden property="method" value="buscaXAnio" />
<table width="100%" align="center" >
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
			<p class="titulo" >MANTENIMIENTO DE PORCENTAJES</p>
			<table border="0" >
				<tr align="center" >
					<td>
						<table cellpadding="0" cellspacing="0" width="40%" align="center" >
							<tr>
								<td class="colorfila1">Año:</td>
								<td>
									<html:select property="strAnio" onchange="buscaXAnio(this.value);" >
										<logic:present name="porcentajeEpigrafeForm" property="lstAnios"></logic:present>
											<html:optionsCollection property="lstAnios" label="valor1" value="codelem" />
						 				</html:select>
						 		</td>
						 	</tr>
						 </table>
					</td>
				</tr>
				<tr>
					<td colspan="2" >
						<table>
						<logic:present  name="lstEpigrafes"  >
							<tr>
								<td class="celda1cabecera" >Código Epigrafe</td>
								<td class="celda1cabecera" >Nombre Epigrafe</td>
								<td class="celda1cabecera" >Porcentaje Máximo</td>
								<td class="celda1cabecera" >Porcentaje Mínimo</td>
								<td class="celda1cabecera" >Año</td>
								<td align="center" width="70" class="celda1cabecera">Editar</td>
							</tr>
							<logic:iterate name="lstEpigrafes" id="epigrafes" indexId="indice" >
								<tr>
									<td class="colorfila${indice%2+1}" >${epigrafes.codEpigrafe} </td>
									<td class="colorfila${indice%2+1}" >${epigrafes.nomEpigrafe} </td>
									<td class="colorfila${indice%2+1}" align="center" >
										<logic:present name="epigrafes" property="porcentajeMax" >
										${epigrafes.porcentajeMax} %
										</logic:present>
									</td>
									<td class="colorfila${indice%2+1}" align="center" >
										<logic:present name="epigrafes" property="porcentajeMin" >
										${epigrafes.porcentajeMin} %
										</logic:present>
									</td>
									<td class="colorfila${indice%2+1}" >${epigrafes.anho}</td>
									<td class="colorfila${indice%2+1}" align="center" >
										<a href="javascript:editar('<bean:write name="epigrafes" property="codEpigrafe" />','<bean:write name="epigrafes" property="anho" />')"><IMG border="0" src="<%=request.getContextPath()%>/images/editar.png" width="18"
											height="18"></a>
									</td>
									
								</tr>
							</logic:iterate>
						</logic:present>
						</table>

					</td>
				</tr>
			</table>
		</td>
	</tr>
	
	
</table>

</html:form>
</BODY>
</html:html>
<logic:present name="msj" >
<script type="text/javascript">
	alert("${msj}");
</script>
</logic:present>
