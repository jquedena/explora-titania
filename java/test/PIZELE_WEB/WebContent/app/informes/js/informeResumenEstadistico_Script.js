

ejecutarMetodoFiltroGestores = true;

valorDefectoFiltroGestor = '----- Todos ------';

function buscarResumenEstadistico()
{
	if($("#currentForm").validationEngine("validateField","#idAnio") || $("#currentForm").validationEngine("validateField","#idMes"))
		return;
	
	
	var jqxhr = $.post("buscarResumenEstadistico.do",
			{
				'informeParametro.codigoTerritorio': $('#idTerritorioFiltro').val(),
				'informeParametro.codigoOficina': $('#idOficinaFiltro').val(),
				'informeParametro.codigoGestor': $('#idGestor').val(),
				'informeParametro.idAnio': $('#idAnio').val(),
				'informeParametro.idMes': $('#idMes').val()
			});
	
	jqxhr.success(function(data) 
	{ 
		if(data.resultado != undefined && data.resultado == "ERROR")
		{
			openDialogError(data.mensaje);			
		}
		else if(data.resultado != undefined && data.resultado == "NO_DATA")
		{
			$("#tbResumenEstatistico > tbody").empty();
		}
		else if(data.resultado != undefined && data.resultado == "EXITO")
		{
			recargarResumenEstadistico(data.listaObjetos);
		}
		else
		{
			document.getElementById('currentForm').action = 'logout.do';
			document.getElementById('currentForm').submit();
		}
	});	
}

function recargarResumenEstadistico(listaEstadistica)
{
	
	if($("#currentForm").validationEngine("validateField","#idAnio") || $("#currentForm").validationEngine("validateField","#idMes"))
		return;
	
	$("#tbResumenEstatistico > tbody").empty();
	
	var newRowHeader = "";
	var newRowGraphic = "";
	var column = 0;
	
	newRowHeader = "<tr>";
	newRowGraphic = "<tr>";
	
	$.each(listaEstadistica, function(i,objeto)
	{  			
		if(column == 2)
		{
			$("#tbResumenEstatistico").append(newRowHeader);
			$("#tbResumenEstatistico").append(newRowGraphic);
			
			newRowHeader = "<tr>";
			newRowGraphic = "<tr>";
			
			column = 0;
		}
		
		newRowHeader = newRowHeader + "<th align='center' width='40%'>" + objeto.descRubro + "</th>";
		newRowHeader = newRowHeader + "<td align='center' width='10%' bgcolor='" + objeto.color + "'>" + objeto.porcentajeCumplimiento + "%</td>";
		
		newRowGraphic = newRowGraphic + "<td align='center' colspan='2'><img src='" + obtenerContexto() + objeto.pathReporte + "'/></td>";

		column++;
	});
	
	if(column == 1)
	{
		newRowHeader = newRowHeader + "<td align='center' width='40%'></td>";
		newRowHeader = newRowHeader + "<td align='center' width='10%'></td>";
		
		newRowGraphic = newRowGraphic + "<td align='center' colspan='2'></td>";
			
	}
	
	$("#tbResumenEstatistico").append(newRowHeader);
	$("#tbResumenEstatistico").append(newRowGraphic);
						
}

function exportarExcelInformeUso()
{
	if($('#idTerritorioFiltro').is('select')) {
		idTerritorio = $('#idTerritorioFiltro option:selected').val();
		descTerritorio = $('#idTerritorioFiltro option:selected').text();
	} else {
		idTerritorio = $('#idTerritorioFiltro').val();
		descTerritorio = $('#descTerritorioFiltro').val();
	}
	
	if($('#idOficinaFiltro').is('select')) {
		idOficina = $('#idOficinaFiltro option:selected').val();
		descOficina = $('#idOficinaFiltro option:selected').text();
	} else {
		idOficina = $('#idOficinaFiltro').val();
		descOficina = $('#descOficinaFiltro').val();
	}
	
	$('#idCodTerrExcel').val(idTerritorio);
	$('#idNombreTerritorioExcel').val(descTerritorio);
	$('#idCodigoOficinaExcel').val(idOficina);
	$('#idNombreOficinaExcel').val(descOficina);
	$('#idGestorExcel').val($('#idGestor option:selected').val());
	$('#idNombreGestorExcel').val($('#idGestor option:selected').text());
	$('#idAnioExcel').val($('#idAnio option:selected').val());	
	$('#idMesExcel').val($('#idMes option:selected').val());
	$('#idNombreMesExcel').val($('#idMes option:selected').text());
	
	document.getElementById('currentForm').action = 'exportarExcelResumenEstadistico.do';
	document.getElementById('currentForm').submit();
	
}
