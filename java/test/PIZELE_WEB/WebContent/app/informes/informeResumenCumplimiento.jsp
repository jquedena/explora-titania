 <%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<script type="text/javascript" src="<%=request.getContextPath()%>/app/comun/js/comun_Script.js">
</script>

<script type="text/javascript" src="<%=request.getContextPath()%>/app/informes/js/informeResumenCumplimiento_Script.js">
</script>

<script language="JavaScript">

	$(document).ready(function()
	{
		seleccioneChangeTextAnio();
		seleccioneChangeTextMes();
    	inicializarEstadoAnioMes();
    	inicializarEstadoAnioMesSemana(); 	
    	cargarSemanas();
    	establacerSemana();		  		  		 	    		
   	});
			
</script>

<s:form id="currentForm" theme="simple">

<s:hidden id="exportarResumenCumplimiento" name="exportarResumenCumplimiento"></s:hidden>
  
<s:hidden id="codigoTerritorioExcel" name="rubroLogroFiltro.codigoTerritorio"></s:hidden>
<s:hidden id="codigoOficinaExcel" name="rubroLogroFiltro.codigoOficina"></s:hidden>
<s:hidden id="anioExcel" name="rubroLogroFiltro.anio"></s:hidden>  	
<s:hidden id="mesExcel" name="rubroLogroFiltro.mes"></s:hidden>  	
<s:hidden id="semanaExcel" name="rubroLogroFiltro.semana"></s:hidden>  	  
  					
<div class="ui-widget ui-widget-content ui-corner-all" style="width: 99%;margin: 3px 3px 3px 3px;">   
<div class="fondo_div_principal">
	<label>Informe de Resumen de Cumplimiento</label>
</div> 
<div align="left" style="margin: 5px 5px 5px 5px; ">
	<table width="100%">
		<s:include value="../comun/filtroTerritorioOficina.jsp"></s:include>
		<tr>
			<s:include value="../comun/comboAnio.jsp"></s:include>
			<s:include value="../comun/comboMes.jsp"></s:include>
		</tr>
		<tr>
			<s:include value="../comun/comboSemana.jsp"></s:include>
			<td colspan="2">&nbsp;</td>
		</tr>
		<tr>
			<s:include value="../comun/semaforo.jsp"></s:include>
		</tr>	
	</table>
</div>	
</div> 
<div class="ui-widget ui-widget-content ui-corner-all" align="center" style="width: 99%;margin: 3px 3px 3px 3px;">
	<div style="margin: 3px 3px 3px 3px;">				
		<sj:a button="true" onclick="buscarResumenCumplimiento()" buttonIcon="ui-icon-circle-zoomin">
			Buscar
		</sj:a>
		<sj:a button="true" onclick="exportarExcelResumenCumplimiento()" buttonIcon="ui-icon-disk">
			Exportar a Excel
		</sj:a>
	</div>													
</div>
<div class="ui-widget ui-widget-content ui-corner-all" style="width: 99%;margin: 3px 3px 3px 3px;">   
<div class="fondo_div_principal">
	<label>Resultado de Búsqueda</label>
</div> 
<div align="left"  style="margin: 5px 5px 5px 5px; width:775px;" > 
	  <table class="dataTable" id="tbResumenCumplimiento" width="775px" style="display: none;">
	  	<tbody>
	  		<tr>
	  			<th colspan="2">Ranking Mensual de Rubros</th>
	  		</tr>
	  		<tr>
	  			<td valign="middle">
	  				<table class="dataTable" id="tbRankMensualRubro">
	  					<thead>
	  					<tr>
	  						<th width="10px">&nbsp;</th>
	  						<th width="200px">Rubro</th>
	  						<th width="20px">%</th>
	  						<th width="25px">&nbsp;</th>
	  					</tr>
	  					</thead>
	  					<tbody>
	  					</tbody>
	  				</table>
	  			</td>
	  			<td valign="middle">
	  				<div style="width: 520px;overflow-x: auto;" id="divReporRankMensualRubro">
	  					<img id="imgReporRankMensualRubro"/>
	  				</div>	  				 											
	  			</td>
	  		</tr>
	  		<tr id="rowTituloRankSemRubro">
	  			<th colspan="2">Ranking Semanal de Rubros</th>	  			
	  		</tr>
	  		<tr id="rowContenidoRankSemRubro" valign="middle">
	  			<td>
	  				<table class="dataTable" id="tbRankSemanalRubro">
	  					<thead>
	  					<tr>
	  						<th width="10px">&nbsp;</th>
	  						<th width="200px">Rubro</th>
	  						<th width="20px">%</th>
	  						<th width="25px">&nbsp;</th>
	  					</tr>
	  					</thead>
	  					<tbody>
	  					</tbody>
	  				</table>
	  			</td>
	  			<td valign="middle">	
	  				<div style="width: 520px;overflow-x: auto;" id="divReporRankSemanalRubro">
	  					<img id="imgReporRankSemanalRubro"/>
	  				</div>					
	  			</td>
	  		</tr>
	  		<tr>
	  			<th colspan="2">Ranking Mensual de Gestores</th>
	  		</tr>
	  		<tr>
	  			<td valign="middle">
	  				<table class="dataTable" id="tbRankMensualGestor">
	  					<thead>
	  					<tr>
	  						<th width="10px">&nbsp;</th>
	  						<th width="200px">Gestor</th>
	  						<th width="20px">%</th>
	  						<th width="25px">&nbsp;</th>
	  					</tr>
	  					</thead>
	  					<tbody>
	  					</tbody>
	  				</table>
	  			</td>
	  			<td valign="middle">	 
	  			 	<div style="width: 520px;overflow-x: auto;" id="divReporRankMensualGestor">
	  					<img id="imgReporRankMensualGestor"/>
	  				</div>						
	  			</td>
	  		</tr>
	  		<tr id="rowTituloRankSemGestor">
	  			<th colspan="2">Ranking Semanal de Gestores</th>
	  		</tr>
	  		<tr id="rowContenidoRankSemGestor" valign="middle">
	  			<td>
	  				<table class="dataTable" id="tbRankSemanalGestor">
	  					<thead>
	  					<tr>
	  						<th width="10px">&nbsp;</th>
	  						<th width="200px">Gestor</th>
	  						<th width="20px">%</th>
	  						<th width="25px">&nbsp;</th>
	  					</tr>
	  					</thead>
	  					<tbody>
	  					</tbody>
	  				</table>
	  			</td>
	  			<td valign="middle">	  
	  				<div style="width: 520px;overflow-x: auto;" id="divReporRankSemanalGestor">
	  					<img id="imgReporRankSemanalGestor"/>
	  				</div>					
				
	  			</td>
	  		</tr>
	  	</tbody>
	  </table>
</div>
</div> 
</s:form>

