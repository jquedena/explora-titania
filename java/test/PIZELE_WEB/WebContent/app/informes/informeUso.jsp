 <%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@page import="indra.bbva.pizele.domain.extend.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script language="JavaScript">

	$(document).ready(function() {
    	gridMultiSelect('tbInformeUso');						  		  		 	    		
   	});
			
</script>

<script type="text/javascript" src="<%=request.getContextPath()%>/app/comun/js/comun_Script.js">
</script>

<script type="text/javascript" src="<%=request.getContextPath()%>/app/informes/js/informeUso_Script.js">
</script>

<s:form id="currentForm" theme="simple">

<s:hidden id="idCodTerrExcel" name="informeUsoExcel.codterr"></s:hidden>
<s:hidden id="idNombreTerritorioExcel" name="informeUsoExcel.nombreTerritorio"></s:hidden>
<s:hidden id="idCodigoOficinaExcel" name="informeUsoExcel.codigoOficina"></s:hidden>
<s:hidden id="idNombreOficinaExcel" name="informeUsoExcel.nombreOficina"></s:hidden>
<s:hidden id="idFechaDesdeExcel" name="informeUsoExcel.fechaDesde"></s:hidden>
<s:hidden id="idFechaHastaExcel" name="informeUsoExcel.fechaHasta"></s:hidden>

<div class="ui-widget ui-widget-content ui-corner-all" style="width: 99%;margin: 3px 3px 3px 3px;">   
<div class="fondo_div_principal">
	<label>Informe de Uso</label>
</div> 
<div align="left" style="margin: 5px 5px 5px 5px; ">
	<table width="100%">
		<s:include value="../comun/filtroTerritorioOficina.jsp"></s:include>
		<tr>
			<td>
				<label>Fecha Desde :</label>
			</td>
			<td>
				<sj:datepicker id="idFechaDesde" displayFormat="dd/mm/yy" 
					buttonImageOnly="true"
					readonly="true"
					onCompleteTopics="onDpClose"
					disabled="true">
				</sj:datepicker> 
			</td>
			<td>
				<label>Fecha hasta :</label>
			</td>
			<td>
				<sj:datepicker id="idFechaHasta" displayFormat="dd/mm/yy"
					buttonImageOnly="true" 
					readonly="true"
					disabled="true">
				</sj:datepicker> 
			</td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<table  align="center" class="dataTable" width="130px">
			      <tbody>
					<tr class="even">
						<td bgcolor="#00FF00" width="50%">&nbsp;</td>
						<td>SI</td>
					</tr>
					<tr class="even">
						<td bgcolor="red" width="50%">&nbsp;</td>
						<td>NO</td>
					</tr>					
			       </tbody>
				</table>
			</td>
		</tr>
	</table>
	

</div>

</div>
<div class="ui-widget ui-widget-content ui-corner-all" align="center" style="width: 99%;margin: 3px 3px 3px 3px;">
	<div style="margin: 3px 3px 3px 3px;">				
		<sj:a button="true" onclick="procesatBusquedaInforme()"  buttonIcon="ui-icon-circle-zoomin">
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
	<div align="left"  style="margin: 5px 5px 5px 5px; width:775px;overflow-x: scroll;" >  
	  <table class="dataTable" id="tbInformeUso" width="1205px">
			<thead>
			<tr>
				<th width="10px"></th>
				<th width="300px">Territorio</th>
				<th width="100px">Código de Oficina</th>
				<th width="250px">Oficina</th>
				<th width="300px">Gerente</th>
				<th width="50px">Establecio Metas</th>
				<th width="50px">% Metas</th>
				<th width="50px">Registró Logros</th>
				<th width="50px">% Logros</th>
				<th width="45px">Consecución</th>			
			</tr>
			</thead>
			<tbody>
			</tbody>
			<tfoot>
			</tfoot>
	 </table>
	</div>
</div> 
</s:form>

