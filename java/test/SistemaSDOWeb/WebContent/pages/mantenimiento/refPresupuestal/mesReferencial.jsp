<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<html:html>
<head>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META HTTP-EQUIV='PRAGMA' CONTENT='NO-CACHE'>
<META HTTP-EQUIV='EXPIRES' CONTENT='0'>
<META http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
<title></title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.2.6.js"></script>
<script language="javascript">
	function guardar(){
	
		mesTemp = 0;
		for(i=1; i <13; i++){
			mesSel = parseInt($("select[name=idMes" + i + "]").val());
			if(i == 1) mesTemp = mesSel;
			
			if(mesSel < mesTemp){
				alert('El mes seleccionado es invalido. Debe seleccionar un mes igual superior al anteriormente configurado.');
				$("select[name=idMes" + i + "]").val('0');
				return false;
			}
		}
	
		var resp =confirm("\u00BFDesea guardar los cambios?");
		if(resp){
			var form =document.forms[0];
			form.action="refPresupuestalAction.do?method=referencia";
			form.method="post";
			form.submit();
		}
	}
	
	function getListaMeses()
	{
		var form =document.forms[0];
		form.action="refPresupuestalAction.do?method=buscarListaMeses";
		form.method="post";
		form.submit();
	}
	
	function validarMes(nroMes)
	{
		var mesSel = parseInt($("select[name=idMes" + nroMes + "]").val());
		
		if(mesSel < nroMes)
		{
			alert('El mes seleccionado es invalido');
			$("select[name=idMes" + nroMes + "]").val('0');
		}
	}
	var mensaje_error = '<%=request.getAttribute("mensajeExito")%>';

	window.onload=function(){
		if (mensaje_error != 'null') {
			alert(mensaje_error);
		}
	}
</script>
</head>
<body>
<table align="center" width="100%" cellspacing="0" cellpadding="0" border="0">
	<tr>
		<td width="100%" align="left" valign="top">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td><img src="<%=request.getContextPath()%>/images/esq_izq.jpg"></td>
					<td width="225" class="textocentradoblanco" align="center">REFERENCIA PRESUPUESTAL</td>
					<td><img src="<%=request.getContextPath()%>/images/esq_der.jpg"></td>
				</tr>
			</table>
		</td>
	</tr>		
	<tr>
		<td style="border: 2px solid #264971;padding:10px;" valign="top" align="center">
			<html:form action="/refPresupuestalAction" styleId="refPresupuestalForm">
				<html:hidden property="valor1" value=""/>
				<p class="titulo">REFERENCIA PRESUPUESTAL</p>
				<table>
					<tr>
						<td >Año</td>
						<td>
							<html:select
								property="anho"
								onchange="javascript:getListaMeses();"
								value="${requestScope.anio}">
								<c:if test="${listaAnhos != null}">
									<c:forEach var="lista" items="${listaAnhos}">
										<html:option value="${lista.codelem}">
											<c:out value="${lista.valor1}" />
										</html:option>
									</c:forEach>
								</c:if>
							</html:select>
						</td>
					</tr>
				</table>
				<bean:define id="listaMeses" name="listaMeses" scope="session" />
				<table cellspacing="0" cellpadding="0" align="center" border="0">
					<tr>
						<td>Mes</td>
						<td>Mes Referencia</td>
					</tr>
					<tr>
						<td>Enero</td>
						<td>
							<html:select property="idMes1" disabled="${disabledMes1}" onchange="javascript:validarMes(1);">
								<c:forEach items="${listaMeses}" var="objMes">
									<html:option value="${objMes.id}">${objMes.nombre}</html:option>
								</c:forEach>
							</html:select>
						</td>
					</tr>
					<tr>
						<td>Febrero</td>
						<td>
							<html:select property="idMes2"  disabled="${disabledMes2}" onchange="javascript:validarMes(2);">
								<c:forEach items="${listaMeses}" var="objMes">
									<html:option value="${objMes.id}">${objMes.nombre}</html:option>
								</c:forEach>
							</html:select>
						</td>
					</tr>
					<tr>
						<td>Marzo</td>
						<td>
							<html:select property="idMes3"  disabled="${disabledMes3}" onchange="javascript:validarMes(3);">
								<c:forEach items="${listaMeses}" var="objMes">
									<html:option value="${objMes.id}">${objMes.nombre}</html:option>
								</c:forEach>
							</html:select>
						</td>
					</tr>
					<tr>
						<td>Abril</td>
						<td>
							<html:select property="idMes4"  disabled="${disabledMes4}" onchange="javascript:validarMes(4);">
								<c:forEach items="${listaMeses}" var="objMes">
									<html:option value="${objMes.id}">${objMes.nombre}</html:option>
								</c:forEach>
							</html:select>
						</td>
					</tr>
					<tr>
						<td>Mayo</td>
						<td>
							<html:select property="idMes5"  disabled="${disabledMes5}" onchange="javascript:validarMes(5);">
								<c:forEach items="${listaMeses}" var="objMes">
									<html:option value="${objMes.id}">${objMes.nombre}</html:option>
								</c:forEach>
							</html:select>
						</td>
					</tr>
					<tr>
						<td>Junio</td>
						<td>
							<html:select property="idMes6"  disabled="${disabledMes6}" onchange="javascript:validarMes(6);">
								<c:forEach items="${listaMeses}" var="objMes">
									<html:option value="${objMes.id}">${objMes.nombre}</html:option>
								</c:forEach>
							</html:select>
						</td>
					</tr>
					<tr>
						<td>Julio</td>
						<td>
							<html:select property="idMes7"  disabled="${disabledMes7}" onchange="javascript:validarMes(7);">
								<c:forEach items="${listaMeses}" var="objMes">
									<html:option value="${objMes.id}">${objMes.nombre}</html:option>
								</c:forEach>
							</html:select>
						</td>
					</tr>
					<tr>
						<td>Agosto</td>
						<td>
							<html:select property="idMes8"  disabled="${disabledMes8}" onchange="javascript:validarMes(8);">
								<c:forEach items="${listaMeses}" var="objMes">
									<html:option value="${objMes.id}">${objMes.nombre}</html:option>
								</c:forEach>
							</html:select>
						</td>
					</tr>
					<tr>
						<td>Setiembre</td>
						<td>
							<html:select property="idMes9"  disabled="${disabledMes9}" onchange="javascript:validarMes(9);">
								<c:forEach items="${listaMeses}" var="objMes">
									<html:option value="${objMes.id}">${objMes.nombre}</html:option>
								</c:forEach>
							</html:select>
						</td>
					</tr>
					<tr>
						<td>Octubre</td>
						<td>
							<html:select property="idMes10"  disabled="${disabledMes10}" onchange="javascript:validarMes(10);">
								<c:forEach items="${listaMeses}" var="objMes">
									<html:option value="${objMes.id}">${objMes.nombre}</html:option>
								</c:forEach>
							</html:select>
						</td>
					</tr>
					<tr>
						<td>Noviembre</td>
						<td>
							<html:select property="idMes11"  disabled="${disabledMes11}" onchange="javascript:validarMes(11);">
								<c:forEach items="${listaMeses}" var="objMes">
									<html:option value="${objMes.id}">${objMes.nombre}</html:option>
								</c:forEach>
							</html:select>
						</td>
					</tr>
					<tr>
						<td>Diciembre</td>
						<td>
							<html:select property="idMes12"  disabled="${disabledMes12}" onchange="javascript:validarMes(12);">
								<c:forEach items="${listaMeses}" var="objMes">
									<html:option value="${objMes.id}">${objMes.nombre}</html:option>
								</c:forEach>
							</html:select>
						</td>
					</tr>
				</table>
				<div style="padding-top:6px;">
				<table align="center" cellpadding="0" cellspacing="0" border="0">
					<tr>
						<td colspan="5" align="center">
							<table cellpadding="0" cellspacing="0" border="0">
								<tr>
									<td>
										<c:if test="${grabarListaMeses}">
											<input type="button" name="Guardar" onClick="javascript:guardar();" value="Guardar" disabled>
										</c:if>
										
										<c:if test="${!grabarListaMeses}">
											<input type="button" name="Guardar" onClick="javascript:guardar();" value="Guardar">
										</c:if>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				</div>
			</html:form>
		</td>
	</tr>
</table>
</body>
</html:html>