<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>

<script type="text/javascript" src="<%=request.getContextPath()%>/app/comun/js/comun_Script.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/app/configuracion/js/configRelacionEpigrafeRubro_Script.js"></script>

<script type="text/javascript" language="JavaScript">
	$(document).ready(function(){
		inicializarEstadoAnioMes(); 
		seleccioneChangeTextAnio();
		seleccioneChangeTextMes();
	});
</script>

<s:form id="currentForm" theme="simple">
<s:hidden id="exportar" name="exportar" value="" />
<div class="ui-widget ui-widget-content ui-corner-all" style="width: 99%;margin: 3px;">   
<div class="fondo_div_principal">
	<label>Configuración de Relación Epígrafes por Rubro</label>
</div> 
<div align="left" style="margin: 5px;">
	<table width="100%">
		<tr>
			<s:include value="../comun/comboAnio.jsp"></s:include>
			<s:include value="../comun/comboMes.jsp"></s:include>
			<td>
				Rubros :
			</td>
			<td>
				<s:select 
				headerKey="-1"
				headerValue="---- Seleccione ----"
				list="listaRubroFijo"
				listKey="id"
				listValue="descrubro"
				cssStyle="width: 120px;"
				id="idRubro"
				onchange="cargarEpigrafeRubro()"
				name="rubro"
				disabled="true">
				</s:select>
			</td>
			<td style="width: 200px;">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="7" align="right" style="padding-right: 10px;">
				<sj:a button="true" onclick="iniciarCopia()" buttonIcon="ui-icon-clipboard">
					Copiar Configuraci&oacute;n
				</sj:a>
			</td>
		</tr>
	</table>
	<table width="100%" cellpadding="5" cellspacing="5">
		<tr>
			<td valign="top" width="180px;">	
					<div class="ui-widget ui-widget-content ui-corner-all" align="left" style="margin: 3px 3px 3px 0px;">
					<div style="margin: 3px 3px 3px 3px;">	
						<table width="100%" class="dataTable">
						<tr>
							<th>
								Epigrafes MIS Disponibles
							</th>
						</tr>
						</table>		
					</div>
					<div style="margin: 5px 5px 5px 5px;" align="center">	
						<sj:a button="true" onclick="listarEpigrafeMIS();" buttonIcon="ui-icon-search">
							Buscar
						</sj:a>			
					</div>					
				</div>
		
													
			</td>
			<td valign="top" width="250px;">				
					<div style="margin: 3px 3px 3px 3px;">											
						<table width="100%" class="dataTable" id="tbEpigrafeSDO">
						<thead>						
						<tr>
							<th></th>
							<th>
								Epigrafes SDO Disponibles
							</th>
						</tr>
						</thead>
						<tbody>
						</tbody>
						</table>		
					</div>				
			</td>
			<td valign="middle" align="center">
				<table cellpadding="2" cellspacing="2">
					<tr>
						<td>
							<sj:a style="height:28px;width:28px;" button="true" onclick="moverEpigrafeSDO('tbEpigrafeSDO','tbEpigrafeAsociado',true);" buttonIcon="ui-icon-arrowthickstop-1-e"></sj:a>
						</td>
					</tr>
					<tr>
						<td>
							<sj:a style="height:28px;width:28px;" button="true" onclick="moverEpigrafeSDO('tbEpigrafeSDO','tbEpigrafeAsociado',false);" buttonIcon="ui-icon-arrowthick-1-e"></sj:a>
						</td>
					</tr>
					<tr>
						<td>
							<sj:a style="height:28px;width:28px;" button="true" onclick="moverEpigrafeSDO('tbEpigrafeAsociado','tbEpigrafeSDO',false);" buttonIcon="ui-icon-arrowthick-1-w"></sj:a>
						</td>
					</tr>
					<tr>
						<td>
							<sj:a style="height:28px;width:28px;" button="true" onclick="moverEpigrafeSDO('tbEpigrafeAsociado','tbEpigrafeSDO',true);" buttonIcon="ui-icon-arrowthickstop-1-w"></sj:a>
						</td>
					</tr>
				</table>					
			</td>
			<td valign="top" width="250px;">				
					<div style="margin: 3px 3px 3px 3px;">											
						<table width="100%" class="dataTable" id="tbEpigrafeAsociado">
						<thead>
						
						<tr>
							<th></th>
							<th>
								Epigrafes asociados SDO y MIS
							</th>
						</tr>
						</thead>
						<tbody>
						</tbody>
						</table>		
					</div>				
			</td>
		</tr>
	</table>
</div>	
</div> 
<div class="ui-widget ui-widget-content ui-corner-all" align="center" style="width: 99%;margin: 3px;">
	<div style="margin: 3px;">
		<sj:a button="true" onclick="executeActionForm_guardarConfRubroEpigrafe()" buttonIcon="ui-icon-circle-check">
			Grabar
		</sj:a>
		<sj:a button="true" onclick="exportarExcelRubroEpigrafe()" buttonIcon="ui-icon-disk">
			Exportar a Excel
		</sj:a>
		<sj:a button="true" onclick="print()" buttonIcon="ui-icon-print">
			Imprimir
		</sj:a>
	</div>
</div>
</s:form>

<sj:dialog id="jqDialogRubro" 
	autoOpen="false" 
	modal="true" 
	resizable="false" 
	closeOnEscape="false"
	height="400" 
	cssStyle="display:none;" 
	width="540" 
	title="Asociación Rubro Epígrafe" 
	showEffect="slide"
	hideEffect="blind"
	openTopics="openEffectDialog"
	closeTopics="closeEffectDialog">
	
	<div class="ui-widget ui-widget-content ui-corner-all" align="left" style="width: 520px;">
		<div class="fondo_div">
			<label>Filtros de B&uacute;squeda</label>
		</div>
		<table width="100%">
			<tr>
				<td width="50px">
					<label>Tipo :</label>
				</td>
				<td width="120px">
					<select id="idTipoFiltro" style="width:100px;">
						<option value="C">C&oacute;digo</option>
						<option value="N" selected>Nombre</option>
					</select>
				</td>
				<td>
					<label>Descripci&oacute;n :</label>
				</td>
				<td>
					<input type="text" size="49" id="idFiltro" maxlength="200">
				</td>
			</tr>
			<tr>
				<td colspan="4" align="right">
					<sj:a button="true" onclick="asignarRubroEpigrafe()" buttonIcon="ui-icon-note">
						Aceptar
					</sj:a>	
					<sj:a button="true" onclick="buscarRubroEpigrafe()" buttonIcon="ui-icon-circle-zoomin">
						Buscar
					</sj:a>	
				</td>
			</tr>
		</table>
	</div>

	<div class="ui-widget ui-widget-content ui-corner-all" align="left" style="margin-top: 5px;width: 516px;padding: 2px 2px 2px 2px;">
		<div class="fondo_div">
			<label>Resultados de Búsqueda </label>
		</div> 	
		<div style="width:515px;max-height:240px; overflow-y: scroll;margin-top: 5px;"> 
		<table class="dataTable" style="width:495px;" id="tbEpigrafe_MIS">
		<thead>
		<tr>
			<th width="10px"></th>
			<th width="80px">C&oacute;digo</th>
			<th>Descripci&oacute;n</th>
		</tr>
		</thead>
		<tbody>
		</tbody>
		</table>
		</div>
	</div>
</sj:dialog>

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