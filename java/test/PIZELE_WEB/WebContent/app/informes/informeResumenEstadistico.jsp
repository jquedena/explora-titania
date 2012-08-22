 <%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<script language="JavaScript">

	$(document).ready(function()
	{
    	seleccioneChangeTextAnio();
		seleccioneChangeTextMes();
    	inicializarEstadoAnioMes();	
    	todosChangeTextGestor();		  		  		 	    		
   	});
			
</script>

<script type="text/javascript" src="<%=request.getContextPath()%>/app/comun/js/comun_Script.js">
</script>

<script type="text/javascript" src="<%=request.getContextPath()%>/app/informes/js/informeResumenEstadistico_Script.js">
</script>


<s:form id="currentForm" theme="simple">
 
<s:hidden id="idCodTerrExcel" name="informeParametro.codigoTerritorio"></s:hidden>
<s:hidden id="idNombreTerritorioExcel" name="informeParametro.descTerritorio"></s:hidden>
<s:hidden id="idCodigoOficinaExcel" name="informeParametro.codigoOficina"></s:hidden>
<s:hidden id="idNombreOficinaExcel" name="informeParametro.descOficina"></s:hidden>
<s:hidden id="idGestorExcel" name="informeParametro.codigoGestor"></s:hidden>
<s:hidden id="idNombreGestorExcel" name="informeParametro.nombreGestor"></s:hidden>
<s:hidden id="idAnioExcel" name="informeParametro.idAnio"></s:hidden>
<s:hidden id="idMesExcel" name="informeParametro.idMes"></s:hidden>
<s:hidden id="idNombreMesExcel" name="informeParametro.descMes"></s:hidden>
  					
<div class="ui-widget ui-widget-content ui-corner-all" style="width: 99%;margin: 3px 3px 3px 3px;">   
<div class="fondo_div_principal">
	<label>Informe de Resumen Estadístico</label>
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
			<s:include value="../comun/comboAnio.jsp"></s:include>
			<s:include value="../comun/comboMes.jsp"></s:include>
		</tr>
		<tr>
			<s:include value="../comun/semaforo.jsp"></s:include>
		</tr>		
	</table>
</div>	
</div> 
<div class="ui-widget ui-widget-content ui-corner-all" align="center" style="width: 99%;margin: 3px 3px 3px 3px;">
	<div style="margin: 3px 3px 3px 3px;">				
		<sj:a button="true" onclick="buscarResumenEstadistico()" buttonIcon="ui-icon-circle-zoomin">
			Buscar
		</sj:a>
		<sj:a button="true" onclick="exportarExcelInformeUso()" buttonIcon="ui-icon-disk">
			Exportar a Excel
		</sj:a>
	</div>													
</div>
<div class="ui-widget ui-widget-content ui-corner-all" style="width: 99%;margin: 3px 3px 3px 3px;">   
<div class="fondo_div_principal">
	<label>Resultado de Búsqueda</label>
</div> 
<div align="left"  style="margin: 5px 5px 5px 5px; width:775px;" > 
	  <table class="dataTable" id="tbResumenEstatistico" width="775px">
	  	<tbody>	  	
	  	</tbody>
	  </table>
</div>	
</div> 
</s:form>

