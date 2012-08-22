<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<%@page import="indra.bbva.pizele.domain.extend.*"%>

<script language="JavaScript">

	$(document).ready(function()
	{
    	gridMultiSelect('tbRubroFijo');	
		gridMultiSelect('tbRubroAdicional');  
		inicializarEstadoAnioMes();  				  		  		 	    		
   	});
			
</script>

<script type="text/javascript" src="<%=request.getContextPath()%>/app/comun/js/comun_Script.js">
</script>

<script type="text/javascript" src="<%=request.getContextPath()%>/app/configuracion/js/configRubro_Script.js">
</script>


<s:form id="currentForm" theme="simple">

<s:hidden id="exportarRubroFijo" name="exportarRubroFijo"></s:hidden>


  					
<div class="ui-widget ui-widget-content ui-corner-all" style="width: 99%;margin: 3px 3px 3px 3px;">   
<div class="fondo_div_principal">
	<label>Configuración de Rubros</label>
</div> 
<div align="left" style="margin: 5px 5px 5px 5px; ">
	<table width="100%">
		<s:include value="../comun/filtroTerritorioOficina.jsp"></s:include>
		<tr>
			<s:include value="../comun/comboAnio.jsp"></s:include>
			<s:include value="../comun/comboMes.jsp"></s:include>
		</tr>	
		<tr>
			<td colspan="4" align="center">
				<sj:a button="true" onclick="mostrarFormRubros()" buttonIcon="ui-icon-circle-plus">
					Agregar Nuevo Rubro
				</sj:a>
			</td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<table width="500px" cellpadding="2" cellspacing="0">
				<tr>
					<td valign="top" align="left" width="130px">
						<label>Rubros Fijos :</label>
						<br>
						<label>ADMINISTRADOR</label>
					</td>
					<td valign="top">
					<div style="margin: 3px 3px 3px 3px;" align="left">	
						<display:table id="listaRubroFijo" name="listaRubroFijo" uid="tbRubroFijo"
        						class="dataTable" style="width:100%;">          						
	        				<display:column style="text-align:center;width:5px;">
								<input type="checkbox" name="chkRubroFijo"
										value="<%= ((AsignacionRubroDetalle)pageContext.getAttribute("tbRubroFijo")).getCodigos()%>"
										style="display: none;"/>
								<img src='/PIZELE_WEB/images/arrow_white.gif'/>
							</display:column>
				        	<display:column title="Descripción" property="nombreRubro"/>  
				        	<display:setProperty name="basic.empty.showtable" value="true" />   
							<display:setProperty name="paging.banner.group_size" value="10" />   
							<display:setProperty name="paging.banner.item_name" value="registro" />   
							<display:setProperty name="paging.banner.item_names" value="registros" />   
							<display:setProperty name="paging.banner.onepage" value=" " />		
							<display:setProperty name="paging.banner.placement" value="both" />	
							<display:setProperty name="paging.banner.some_items_found" value="{0} {1} encontrados, mostrando del {2} al {3}. " />
							<display:setProperty name="paging.banner.no_items_found" value="" />			
							<display:setProperty name="basic.msg.empty_list_row" value="Ningún elemento encontrado." />      	        	
						</display:table>
					</div>
					</td>
					<td valign="top" width="60px" align="left" style="padding-top: 5px;">
					<s:if test="%{#session.__current_user__.codigoPerfil == 'ADM'}">
						<sj:a button="true" onclick="aprobarEliminacionFijo()" buttonIcon="ui-icon-circle-close">
									Suprimir
						</sj:a>
					</s:if>	
					</td>
				</tr>
				<tr>
					<td colspan="3">
						<br>
					</td>
				</tr>
				<s:set name="style" value="" />
				<s:if test="%{#session.__current_user__.codigoPerfil == 'ADM'}">
					<s:set name="style" value="style='display: none'" />
				</s:if>
				
				<tr id="idRowRubroAdicional" <s:property value="#style"/> >
					<td valign="top" align="left">
						<label>Rubros Adicionales :</label>
						<br>
						<label>GERENTE DE TERRITORIO</label>
						<br>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label>ó</label>
						<br>
						<label>GERENTE DE OFICINA</label>
					</td>
					<td valign="top">
					<div style="margin: 3px 3px 3px 3px;" align="left">	
						<display:table id="listaRubroAdicional" name="listaRubroAdicional" uid="tbRubroAdicional"
        						class="dataTable" style="width:100%;">          						
	        				<display:column style="text-align:center;width:5px;">
								<input type="checkbox" name="chkRubroAdicional"
										value="<%= ((AsignacionRubroDetalle)pageContext.getAttribute("tbRubroAdicional")).getCodigos()%>"
										style="display: none;"/>
								<img src='/PIZELE_WEB/images/arrow_white.gif'/>
							</display:column>
				        	<display:column title="Descripción" property="nombreRubro"/>
				        	<display:setProperty name="basic.empty.showtable" value="true" />   
							<display:setProperty name="paging.banner.group_size" value="10" />   
							<display:setProperty name="paging.banner.item_name" value="registro" />   
							<display:setProperty name="paging.banner.item_names" value="registros" />   
							<display:setProperty name="paging.banner.onepage" value=" " />		
							<display:setProperty name="paging.banner.placement" value="both" />	
							<display:setProperty name="paging.banner.some_items_found" value="{0} {1} encontrados, mostrando del {2} al {3}. " />
							<display:setProperty name="paging.banner.no_items_found" value="" />			
							<display:setProperty name="basic.msg.empty_list_row" value="" />        	        	
						</display:table>
					</div>
					</td>
					<td valign="top" align="left" style="padding-top: 5px;">					
						<sj:a button="true" onclick="aprobarEliminacionAdicional()" buttonIcon="ui-icon-circle-close">
									Suprimir
						</sj:a>
					</td>
				</tr>
				</table>
			</td>
		</tr>	
	</table>
</div>	

</div> 

<div class="ui-widget ui-widget-content ui-corner-all" align="center" style="width: 99%;margin: 3px 3px 3px 3px;">
	<div style="margin: 3px 3px 3px 3px;">				
		<sj:a button="true" onclick="executeActionForm_guardarConfRubro()" buttonIcon="ui-icon-circle-check">
			Grabar
		</sj:a>
		<sj:a button="true" onclick="exportarExcelRubro()" buttonIcon="ui-icon-disk">
            Exportar a Excel
        </sj:a>
		<sj:a button="true" onclick="print()" buttonIcon="ui-icon-print">
			Imprimir
		</sj:a>
	</div>													
</div>

</s:form>

<sj:dialog 
	id="jqDialogRubro" autoOpen="false" modal="true" resizable="false" closeOnEscape="false"	
	height="400" cssStyle="display:none;" width="500" title="Administración de Rubros" 
	showEffect="slide"
    hideEffect="blind"
	openTopics="openEffectDialog"
    closeTopics="closeEffectDialog">
	
	<div class="ui-widget ui-widget-content ui-corner-all" align="left" style="width: 480px;">
		<div class="fondo_div">
			<label>Filtros de Búsqueda</label>
		</div> 		
		<table width="100%">
			<tr>
				<td>
					<label>Tipo :</label>
				</td>
				<td width="100px">
					<select id="idTipoRubroFiltro" disabled="disabled">
						<option value="F">Fijo</option>
						<option value="A">Adicional</option>
					</select>									 										
				</td>				
				<td>
					<label>Descripción :</label>
				</td>
				<td>
					<input type="text" size="49" id="idDescRubroFiltro" maxlength="200">
				</td>									
			</tr>							
			<tr>
				<td colspan="4" align="right">
					<sj:a button="true" onclick="asignarRubro()" buttonIcon="ui-icon-note">
						Asignar
					</sj:a>	
					<sj:a button="true" onclick="nuevoRubro()" buttonIcon="ui-icon-circle-plus">
						Nuevo
					</sj:a>
					<sj:a button="true" onclick="editarRubro()" buttonIcon="ui-icon-pencil">
						Modificar
					</sj:a>							
					<sj:a button="true" onclick="buscarRubros()" buttonIcon="ui-icon-circle-zoomin">
						Buscar
					</sj:a>	
				</td>
			</tr>	
		</table>	
	</div>

	<div class="ui-widget ui-widget-content ui-corner-all" align="left" style="margin-top: 5px;padding: 2px 2px 2px 2px;width: 476px;">
		<div class="fondo_div">
			<label>Resultados de Búsqueda </label>
		</div> 	
		<div style="width:475px;max-height:240px; overflow-y: scroll;margin-top: 5px;"> 
		<table class="dataTable" style="width:455px;" id="tbRubros">
		<thead>
		<tr>
			<th width="10px"></th>
			<th>Descripción</th>
			<th width="80px" align="center">Comp. Negativo</th>			
		</tr>
		</thead>
		<tbody>
		</tbody>
		</table>
		</div>						   
	</div>
		
</sj:dialog>

<sj:dialog 
	id="jqDialogEdicionRubro" autoOpen="false" modal="true" resizable="false" closeOnEscape="false"	
	height="180" cssStyle="display:none;" width="350" title="Rubro" 
	showEffect="clip"
    hideEffect="blind"
	openTopics="openEffectDialog"
    closeTopics="closeEffectDialog">
    
    <s:form id="frmEdicionRubro">
	<div class="ui-widget ui-widget-content ui-corner-all" align="center" style="width: 99%;margin: 3px 3px 3px 3px;">
		<div class="fondo_div">
			<label>Edición</label>
		</div> 	
		<table width="100%">
			<tr>
				<td align="left">
					<label>Tipo</label>
				</td>
				<td align="left">
					<select id="idTipoRubroEdicion" disabled="disabled">
						<option value="F">Fijo</option>
						<option value="A">Adicional</option>
					</select>	
				</td>
			</tr>
			<tr>
				<td align="left">
					<label>Descripción</label>
				</td>
				<td align="left">
					<input type="text" size="35" id="idDescRubroEdicion" maxlength="200"
							class="validate[required,custom[onlyTextoValido]]">	
				</td>
			</tr>
			<tr>
				<td align="left">
					<label>Comp. Negativo</label>
				</td>
				<td align="left">
					<input type="checkbox" id="chkComNegativoEdicion">	
				</td>
			</tr>
		</table>
		<input type="hidden" id="idRubroEdicion">
	</div>
	</s:form>
	
	<div class="ui-widget ui-widget-content ui-corner-all" align="center" style="width: 99%;margin: 3px 3px 3px 3px;">
		<div style="margin: 3px 3px 3px 3px;">				
			<sj:a button="true" onclick="executeActionForm_guardarRubro()" buttonIcon="ui-icon-circle-check">
				Grabar
			</sj:a>
		</div>													
	</div>
		
</sj:dialog>