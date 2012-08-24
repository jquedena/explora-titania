<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@page import="indra.bbva.pizele.domain.extend.*"%>

<script type="text/javascript" src="<%=request.getContextPath()%>/app/comun/js/comun_Script.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/app/configuracion/js/configBackup_Script.js"></script>
<script type="text/javascript">

	$(document).ready(function() {
		seleccioneChangeTextTerritorio();
		seleccioneChangeTextOficina();
    	gridMultiSelect('tbBackupVigente');		    			  		 	    	
   	});
			
</script>

<s:form id="currentForm" theme="simple">
  	
<s:hidden name="nombreNuevoBackup_Excel" id="nombreNuevoBackup_Excel"></s:hidden>
<s:hidden name="fechaVigencia_Excel" id="fechaVigencia_Excel"></s:hidden>
<s:hidden name="codOficina_Excel" id="codOficina_Excel"></s:hidden>
<s:hidden name="codigoGOF_Excel" id="codigoGOF_Excel"></s:hidden>
<s:hidden name="nombreGOF_Excel" id="nombreGOF_Excel"></s:hidden>
<s:hidden name="oficinaGOF_Excel" id="oficinaGOF_Excel"></s:hidden>
<s:hidden name="territorioGOF_Excel" id="territorioGOF_Excel"></s:hidden>
  					
<div class="ui-widget ui-widget-content ui-corner-all" style="width: 99%;margin: 3px 3px 3px 3px;">   
<div class="fondo_div_principal">
	<label>Asignación de Suplente Temporal</label>
</div> 
<div align="left" style="margin: 5px 5px 5px 5px; ">
	<table width="100%">
		<s:include value="../comun/filtroTerritorioOficina.jsp"></s:include>
		<tr>
			<td colspan="4">
				<table width="100%" style="position: relative; left: -3px;">
				<tr>
					<td>
						<label>Actuar como Backup del GOF :</label>
					</td>
					<td>
						<s:if test="%{#session.__current_user__.oficina!=null}">
							<s:textfield name="#session.__current_user__.codigoRegistro" id="txtCodigoRegistro" cssStyle="width:107px;" disabled="true" />
							&nbsp;<B>-</B>&nbsp;
							<s:textfield name="#session.__current_user__.nombreCompleto" id="txtNombreRegistro" cssStyle="width:304px;" disabled="true" />
						</s:if>
						<s:else>
							<s:textfield name="#session.__current_user__.codigoRegistro" id="txtCodigoRegistro" cssStyle="width:107px;" disabled="true" value="" />
							&nbsp;<B>-</B>&nbsp;
							<s:textfield name="#session.__current_user__.nombreCompleto" id="txtNombreRegistro" cssStyle="width:304px;" disabled="true" value="" />
						</s:else>
					</td>
					<td width="170px;">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td valign="top">
						<label>Lista de Backups Vigentes :</label>
					</td>
					<td valign="top">
					<div style="margin: 3px 3px 3px 3px;">	
						<display:table id="listaBackupVigente" name="listaBackupVigente" uid="tbBackupVigente"
        						class="dataTable" style="width:100%;">  
        				<display:column style="text-align:center;">
							<input type="checkbox" name="chkBackupsVigentes"
									value="<%= ((BackupDetalle)pageContext.getAttribute("tbBackupVigente")).getId()%>"
									style="display: none;"/>
							<img src='/PIZELE_WEB/images/arrow_white.gif'/>
						</display:column>
			        	<display:column title="Código Registro" property="codigoGestorSuplente" style="width:90px;"/>        	        	
			        	<display:column title="Nombre Completo" property="nombreCompleto"/>
			        	<display:column title="Vigencia" property="fechaVigente" style="width:50px;"/>
			        	
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
					<td valign="top" align="left" style="padding-top: 4px;">			
							<sj:a button="true" onclick="executeActionForm_eliminarBackups()" buttonIcon="ui-icon-circle-close">
									Suprimir Backup
							</sj:a>
					</td>
				</tr>
				<tr>
					<td>
						<label>Nuevo Gestor Backup :</label>
					</td>
					<td>
						<s:select 
							 headerKey="0"
							 headerValue="----- Seleccione ------"
							 list="listaGestorBackup"
							 listKey="codigoRegistro"
							 listValue="nombreCompleto"
							 cssStyle="width: 300px;"
							 id="idNuevoGestorBackup"
							 cssClass="validate[required2]"
							 onchange="validarGestor()">
						</s:select> 
					</td>
					<td></td>
				</tr>
				<tr>
					<td>
						<label>Será Backup hasta el día :</label>
					</td>
					<td>
						<sj:datepicker id="idVigencia" displayFormat="dd/mm/yy" buttonImageOnly="true"
							readonly="true" cssClass="validate[required]" onchange="validarFecha()"
							disabled="true" value="today">
						</sj:datepicker> 
					</td>
					<td></td>
				</tr>
				</table>
			</td>
		</tr>		
	</table>
</div>	
</div> 
<div class="ui-widget ui-widget-content ui-corner-all" align="center" style="width: 99%;margin: 3px 3px 3px 3px;">
	<div style="margin: 3px 3px 3px 3px;">				
		<sj:a button="true" onclick="executeActionForm_guardarBackup()" buttonIcon="ui-icon-circle-check">
			Grabar
		</sj:a>
		<sj:a button="true" onclick="exportarExcelBackupSuplente()" buttonIcon="ui-icon-disk">
			Exportar a Excel
		</sj:a>
		<sj:a button="true" onclick="print()" buttonIcon="ui-icon-print">
			Imprimir
		</sj:a>
	
	</div>													
</div>
</s:form>

