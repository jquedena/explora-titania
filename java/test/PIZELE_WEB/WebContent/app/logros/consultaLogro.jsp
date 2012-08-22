 <%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>



<script type="text/javascript" src="<%=request.getContextPath()%>/app/comun/js/comun_Script.js">
</script>

<script type="text/javascript" src="<%=request.getContextPath()%>/app/logros/js/consultaLogro_Script.js">
</script>

<script language="JavaScript">

	$(document).ready(function()
	{
    	inicializarEstadoAnioMes();
    	inicializarEstadoAnioMesSemana(); 	
    	cargarSemanas();
    	establacerSemana();	
    	procesarConsultaLogros();		  		  		 	    		
   	});
			
</script>

<s:form id="currentForm" theme="simple">
  	
<s:hidden id="exportarConsultaLogro" name="exportarConsultaLogro"></s:hidden>
<s:hidden id="codterr" name="rubroLogroFiltro.codigoTerritorio"></s:hidden>
<s:hidden id="codofi" name="rubroLogroFiltro.codigoOficina"></s:hidden>  	
				
<div class="ui-widget ui-widget-content ui-corner-all" style="width: 99%;margin: 3px 3px 3px 3px;">   
<div class="fondo_div_principal">
	<label>Consulta de Logros</label>
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
		<sj:a button="true" onclick="exportarExcelConsultaLogro()" buttonIcon="ui-icon-disk">
			Exportar a Excel
		</sj:a>
		<sj:a button="true" onclick="print()" buttonIcon="ui-icon-print">
			Imprimir
		</sj:a>
	</div>													
</div>
<div class="ui-widget ui-widget-content ui-corner-all" style="width: 99%;margin: 3px 3px 3px 3px;">   
	<div class="fondo_div_principal">
		<label>Resultado de Búsqueda</label>		
	</div> 
	<div style="margin: 4px 4px 4px 4px;width: 775px;" align="center" id="divConsultaLogros">
	<table class="dataTable" id="tbConsultaLogros">
	<tbody>		
	</tbody>
	</table>
	</div>
</div> 
</s:form>

