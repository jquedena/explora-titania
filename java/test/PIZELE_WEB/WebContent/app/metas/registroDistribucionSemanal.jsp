<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<%@page import="indra.bbva.pizele.domain.base.MetaMensual"%>
<%@page import="indra.bbva.pizele.common.Constantes.TipoRubro"%>
<%@page import="indra.bbva.pizele.common.Constantes"%>

<script type="text/javascript" src="<%=request.getContextPath()%>/app/comun/js/comun_Script.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/app/metas/js/registroDistribucionSemanal_Script.js"></script>
<script type="text/javascript">
	var permiso = '<s:property value="permiso"/>';
	$(document).ready(function(){
		gridSingleSelect('tbMetasMensuales');
		inicializarEstadoAnioMes();
		seleccioneChangeTextAnio();
		seleccioneChangeTextMes();
		seleccioneChangeTextTerritorio();
		seleccioneChangeTextOficina();
		
		if(permiso=='0'){
			$("#cmdCalcular").css({"display":"none"});
			$("#cmdGrabar").css({"display":"none"});
			$("#cmdCopiar").css({"display":"none"});
		}
		
		$("#idAnio").removeClass('validate[required3]');
		$("#idMes").removeClass('validate[required3]');
		$("#idTerritorioFiltro").removeClass('validate[required3]');
		$("#idOficinaFiltro").removeClass('validate[required3]'); 	
		
   });
</script>

<s:form id="currentFormXLS" theme="simple">
	<s:hidden id="xlsHead" name="xlsHead" value="" />
	<s:hidden id="xlsBody" name="xlsBody" value="" />
</s:form>
<s:form id="currentForm" theme="simple">

<div class="ui-widget ui-widget-content ui-corner-all" style="width: 99%;margin: 3px 3px 3px 3px;">   
<div class="fondo_div_principal">
	<label>Registro de Metas Mensuales / Distribución Semanal</label>
</div>
<div align="left" style="margin: 5px 5px 5px 5px; ">
	<table width="100%">
		<s:include value="../comun/filtroTerritorioOficina.jsp"></s:include>
		<tr>
			<s:include value="../comun/comboAnio.jsp"></s:include>
			<s:include value="../comun/comboMes.jsp"></s:include>
		</tr>
		<tr>
			<td>
				Rubro :
			</td>
			<td>
				<s:select 
					 headerKey="0"
					 headerValue="----- Seleccione ------"
					 list="listaRubro"
					 listKey="id"
					 listValue="descrubro"
					 cssStyle="width: 300px;"
					 id="idAsigRubro"
					 onchange="cargarListaCompletaListasMensuales()"
					 cssClass="validate[required2]">
				</s:select> 
			</td>
			<td colspan="2" align="right">
				<sj:a button="true" onclick="iniciarCopia()" buttonIcon="ui-icon-clipboard" id="cmdCopiar" >
					Copiar Configuraci&oacute;n
				</sj:a>
			</td>
		</tr>
	</table>
</div>
</div>

<div id="divMetas">
	<table width="100%">
		<tr>
			<td valign="top" colspan="2">
			<div class="ui-widget ui-widget-content ui-corner-all" align="left" style="margin: 3px 3px 3px 0px;">
			<div style="margin: 3px 3px 3px 3px;">	
				<display:table id="listaMetasMensuales" name="listaMetasMensuales" uid="tbMetasMensuales" class="dataTable" style="width:100%;" >  
				<display:column style="text-align:center;width:5px;" >
						<input type="radio" name="rdoMetasMensuales" style="display: none;" value="<%= ((MetaMensual)pageContext.getAttribute("tbMetasMensuales")).getId()%>"/>
						<img src='/PIZELE_WEB/images/arrow_white.gif'/>
					</display:column>
					<display:column title="Nombre Gestor" style="width:275px;" maxLength="25">
						<%= ((MetaMensual)pageContext.getAttribute("tbMetasMensuales")).getNom_gestor() + " " + 
							((MetaMensual)pageContext.getAttribute("tbMetasMensuales")).getApell_pat_gestor() + " " + 
							((MetaMensual)pageContext.getAttribute("tbMetasMensuales")).getApell_mat_gestor()%>
					</display:column>
					
					<display:column title="Meta Referencia SDO" property="meta_sdo" style="width:35px;"/>
					
					<display:column title="Meta Mensual" style="width:35px;">
						<input type="text" size="5" maxlength="6" 
							name="metaMensual" 
							value="<%= ((MetaMensual)pageContext.getAttribute("tbMetasMensuales")).getMeta_mensual()%>" />
					</display:column>
					<display:column title="Semana 1" style="width:85px;">
						<input type="text" size="3" maxlength="3" name="txtMetaSemana1" disabled="disabled" 
						value="<%= ((MetaMensual)pageContext.getAttribute("tbMetasMensuales")).getSemana1()%>" 
						onkeypress="return fn_validaTecla('entero', this);"/>
						<input type="checkbox" style="display: none;" name="chkAusenteMetaSemana1"
						value="<%= ((MetaMensual)pageContext.getAttribute("tbMetasMensuales")).getAusente1()%>"/>
					</display:column>
					<display:column title="Semana 2" style="width:85px;">
						<input type="text" size="3" maxlength="3" name="txtMetaSemana2" disabled="disabled" 
						value="<%= ((MetaMensual)pageContext.getAttribute("tbMetasMensuales")).getSemana2()%>" 
						onkeypress="return fn_validaTecla('entero', this);"/>
						<input type="checkbox" style="display: none;" name="chkAusenteMetaSemana2" 
						value="<%= ((MetaMensual)pageContext.getAttribute("tbMetasMensuales")).getAusente2()%>"/>
					</display:column>
					<display:column title="Semana 3" style="width:85px;">
						<input type="text" size="3" maxlength="3" name="txtMetaSemana3" disabled="disabled"
						value="<%= ((MetaMensual)pageContext.getAttribute("tbMetasMensuales")).getSemana3()%>" 
						onkeypress="return fn_validaTecla('entero', this);"/>
						<input type="checkbox" style="display: none;" name="chkAusenteMetaSemana3" 
						value="<%= ((MetaMensual)pageContext.getAttribute("tbMetasMensuales")).getAusente3()%>"/>
					</display:column>
					<display:column title="Semana 4" style="width:85px;">
						<input type="text" size="3" maxlength="3" name="txtMetaSemana4" disabled="disabled"
						value="<%= ((MetaMensual)pageContext.getAttribute("tbMetasMensuales")).getSemana4()%>" 
						onkeypress="return fn_validaTecla('entero', this);"/>
						<input type="checkbox" style="display: none;" name="chkAusenteMetaSemana4" 
						value="<%= ((MetaMensual)pageContext.getAttribute("tbMetasMensuales")).getAusente4()%>"/>
					</display:column>
					<display:column title="Semana 5" style="width:85px;">
						<input type="text" size="3" maxlength="3" name="txtMetaSemana5" disabled="disabled"
						value="<%= ((MetaMensual)pageContext.getAttribute("tbMetasMensuales")).getSemana5()%>" 
						onkeypress="return fn_validaTecla('entero', this);"/>
						<input type="checkbox" style="display: none;" name="chkAusenteMetaSemana5" 
						value="<%= ((MetaMensual)pageContext.getAttribute("tbMetasMensuales")).getAusente5()%>"/>
					</display:column>
					<display:setProperty name="basic.empty.showtable" value="true" />
					<display:setProperty name="paging.banner.group_size" value="10" />
					<display:setProperty name="paging.banner.item_name" value="registro" />
					<display:setProperty name="paging.banner.item_names" value="registros" />
					<display:setProperty name="paging.banner.onepage" value=" " />
					<display:setProperty name="paging.banner.placement" value="both" />
					<display:setProperty name="paging.banner.some_items_found" value="{0} {1} encontrados, mostrando del {2} al {3}. " />
					<display:setProperty name="paging.banner.no_items_found" value="" />
					<!-- display:setProperty name="basic.msg.empty_list_row" value="Ningún elemento encontrado." / -->
				</display:table>
			</div>
			</div>
			</td>
		</tr>
	</table>
</div>
<div class="ui-widget ui-widget-content ui-corner-all" align="center" style="width: 99%;margin: 3px 3px 3px 3px;">
	<div style="margin: 3px 3px 3px 3px;">
		<sj:a button="true" onclick="calcularMetasSemanales()" buttonIcon="ui-icon-play" id="cmdCalcular" >
			Calcular
		</sj:a>
		<sj:a button="true" onclick="executeActionForm_guardarRegistroMeta()" buttonIcon="ui-icon-circle-check" id="cmdGrabar" >
			Grabar
		</sj:a>
		<sj:a button="true" onclick="exportarExcelRegistroMeta()" buttonIcon="ui-icon-disk">
			Exportar a Excel
		</sj:a>
		<sj:a button="true" onclick="print()" buttonIcon="ui-icon-print">
			Imprimir
		</sj:a>
	</div>
</div>


<sj:dialog id="jqDialogCopiarConfiguracion" 
	autoOpen="false" 
	modal="true" 
	resizable="false" 
	closeOnEscape="false"
	height="80" 
	cssStyle="display:none;" 
	width="540" 
	title="Copiar Configuración" 
	showEffect="slide"
	hideEffect="blind"
	openTopics="openEffectDialog"
	closeTopics="closeEffectDialog">
	
		<table width="100%" style="height:100%;vertical-align:middle;">
			<tr>
				<td>
					<label>Año :</label>
				</td>
				<td>
				 	<s:select 
							 headerKey="-1"
							 headerValue="--- Seleccione ---"
							 list="listaAnios"
							 listKey="codigo"
							 listValue="descripcion"
							 cssStyle="width: 120px;"
							 id="idAnioDestino"
							 onchange="seleccionaAnioDestino()">
					</s:select>
				</td>
				<td>
					<label>Mes :</label>
				</td>
				<td>	
					<s:select 
								 headerKey="-1"
								 headerValue="--- Seleccione ---"
								 list="listaMeses"
								 listKey="id"
								 listValue="nombre"
								 cssStyle="width: 120px;"
								 id="idMesDestino"
								 onchange="seleccionaMesDestino()"
								 disabled="true">
						</s:select>
				</td>
				<td align="right">
					<sj:a id="copiarConf" button="true" onclick="copiarConfiguracion()" buttonIcon="ui-icon-note">
						Aceptar
					</sj:a>
					<sj:a button="true" onclick="$('#jqDialogCopiarConfiguracion').dialog('close');" buttonIcon="ui-icon-circle-zoomin">
						Cancelar
					</sj:a>
				</td>
			</tr>
		</table>
	<!-- /div -->
</sj:dialog>
</s:form>