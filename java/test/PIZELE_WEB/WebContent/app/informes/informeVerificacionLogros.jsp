 <%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<script language="JavaScript">

	$(document).ready(function()
	{
    	seleccioneChangeTextTerritorio();
    	seleccioneChangeTextOficina();			  		  		 	    		
   	});
			
</script>

<script type="text/javascript" src="<%=request.getContextPath()%>/app/comun/js/comun_Script.js">
</script>

<script type="text/javascript" src="<%=request.getContextPath()%>/app/informes/js/informeVerificacionLogros_Script.js">
</script>


<s:form id="currentForm" theme="simple">
  	
<s:hidden id="idCodTerrExcel" name="verificacionLogroParametroFiltro.codigoTerritorio"></s:hidden>
<s:hidden id="idNombreTerritorioExcel" name="verificacionLogroParametroFiltro.descTerritorio"></s:hidden>
<s:hidden id="idCodigoOficinaExcel" name="verificacionLogroParametroFiltro.codigoOficina"></s:hidden>
<s:hidden id="idNombreOficinaExcel" name="verificacionLogroParametroFiltro.descOficina"></s:hidden>
<s:hidden id="idGestorExcel" name="verificacionLogroParametroFiltro.codigoGestor"></s:hidden>
<s:hidden id="idNombreGestorExcel" name="verificacionLogroParametroFiltro.nombreGestor"></s:hidden>
<s:hidden id="idFechaDesdeExcel" name="verificacionLogroParametroFiltro.fechaDesde"></s:hidden>
<s:hidden id="idFechaHastaExcel" name="verificacionLogroParametroFiltro.fechaHasta"></s:hidden>
  					
<div class="ui-widget ui-widget-content ui-corner-all" style="width: 99%;margin: 3px 3px 3px 3px;">   
<div class="fondo_div_principal">
	<label>Informe de Verificación de Logros</label>
</div> 
<div align="left" style="margin: 5px 5px 5px 5px; ">
	<table width="100%">
		<s:include value="../comun/filtroTerritorioOficina.jsp"></s:include>	
		<tr>
			<s:include value="../comun/comboGestor.jsp"></s:include>
			<td colspan="2">			
			</td>
		</tr>
		<tr>
			<td>
				<label>Fecha Desde :</label>
			</td>
			<td>
				<sj:datepicker id="idFechaDesde" displayFormat="dd/mm/yy" buttonImageOnly="true" readonly="true"
						disabled="true">
						</sj:datepicker> 
			</td>
			<td>
				<label>Fecha hasta :</label>
			</td>
			<td>
				<sj:datepicker id="idFechaHasta" displayFormat="dd/mm/yy" buttonImageOnly="true" readonly="true"
						disabled="true">
						</sj:datepicker> 
			</td>
		</tr>
	</table>
</div>	
</div> 
<div class="ui-widget ui-widget-content ui-corner-all" align="center" style="width: 99%;margin: 3px 3px 3px 3px;">
	<div style="margin: 3px 3px 3px 3px;">				
		<sj:a button="true" onclick="procesatBusquedaVerificacionLogro()" buttonIcon="ui-icon-circle-zoomin">
			Buscar
		</sj:a>
		<sj:a button="true" onclick="exportarVerificacionLogro()" buttonIcon="ui-icon-disk">
			Exportar a Excel
		</sj:a>
	</div>													
</div>
<div class="ui-widget ui-widget-content ui-corner-all" style="width: 99%;margin: 3px 3px 3px 3px;">   
<div class="fondo_div_principal">
	<label>Resultado de Búsqueda</label>
</div> 
<div align="center"  style="margin: 5px 5px 5px 5px; width:775px;overflow-y:hidden;overflow-x:hidden;" id="divImgReporte"> 
	<img id="imgReporte" style="display: none;"/>
</div>	
</div> 
</s:form>

