

ejecutarMetodoAdicional_Territorio = true;
ejecutarMetodoAdicional_Oficina = true;
ejecutarMetodoAdicional_Anio = true;
ejecutarMetodoAdicional_Mes = true;
ejecutarMetodoAdicional_Semana = true;

function onChangeTerritorio()
{
	procesarConsultaLogros();
}

function onChangeOficina()
{
	procesarConsultaLogros();
}

function onChangeAnio()
{
	inicializarEstadoAnioMesSemana();
	cargarSemanas();
	procesarConsultaLogros();
}

function onChangeMes()
{
	inicializarEstadoAnioMesSemana();
	cargarSemanas();
	procesarConsultaLogros();
}

function onChangeSemana()
{
	procesarConsultaLogros();
}

function procesarConsultaLogros()
{
	
	var jqxhr = $.post("procesarConsultaLogros.do",
			{
   				'rubroLogroFiltro.codigoTerritorio': $('#idTerritorioFiltro').val(),
   				'rubroLogroFiltro.codigoOficina': $('#idOficinaFiltro').val(),
   				'rubroLogroFiltro.anio': $('#idAnio').val(),
   				'rubroLogroFiltro.mes': $('#idMes').val(),
   				'rubroLogroFiltro.semana': $('#idSemana').val()
			});
	
	jqxhr.success(function(data) 
	{ 
		if(data.resultado != undefined && data.resultado == "ERROR")
		{
			$("#tbConsultaLogros > tbody").empty(); 			
			$("#tbConsultaLogros").removeAttr("style");
		}	
		else if(data.resultado != undefined && data.resultado == "EXITO")
		{
			regargarConsultaLogros(data.listaObjetos1, data.listaObjetos2, data.listaObjetos3); 
		}
		else
		{
			document.getElementById('currentForm').action = 'logout.do';
			document.getElementById('currentForm').submit();
		}
	});	
}

function regargarConsultaLogros(listaRubros, listaOficinaGestores, listaLogrosMetas)
{	
	$("#tbConsultaLogros > tbody").empty(); 
	
	var newRow1 = "";
	var newRow2 = "";
	
	newRow1 = "<tr><td>&nbsp;</td>";
	newRow2 = "<tr><td>&nbsp;</td>";
	
	$.each(listaRubros, function(i,objeto)
	{  						
		newRow1 = newRow1 + "<th colspan='2' width='120px'>" + objeto.descrubro + "</th>";			
		newRow2 = newRow2 + "<th>Meta</th><th>Logro</th>";
	});
	
	newRow1 = newRow1 + "</tr>";
	newRow2 = newRow2 + "</tr>";
	
	$("#tbConsultaLogros").append(newRow1);
	$("#tbConsultaLogros").append(newRow2);
	
	var newRowCuerpo1 = "";
	var newRowCuerpo2 = "";
	
	$.each(listaOficinaGestores, function(indexOficinaGestor,objetoOficinaGestor)
	{  		
		newRowCuerpo1 = "<tr class='even'><th rowspan='2' width='250px'>" + objetoOficinaGestor.descripcion + "</th>";	
		newRowCuerpo2= "<tr>";
		
		$.each(listaRubros, function(indexRubro,objetoRubro)
		{  	
			$.each(listaLogrosMetas, function(indexLogroMeta, objetoLogroMeta)
			{  	
				if(objetoLogroMeta.codigo == objetoOficinaGestor.codigo && objetoLogroMeta.idRubro == objetoRubro.id)
				{
					newRowCuerpo1 = newRowCuerpo1 + "<td align='right'>" + objetoLogroMeta.meta + "</td><td align='right'>" + objetoLogroMeta.logro + "</td>";
					newRowCuerpo2 = newRowCuerpo2 + "<td colspan='2' align='center' bgcolor='" + objetoLogroMeta.color + "'>"+ objetoLogroMeta.porcentaje +"</td>";
					return true;
				}
			});						
		});	
		newRowCuerpo1 = newRowCuerpo1 + "</tr>";
		newRowCuerpo2 = newRowCuerpo2 + "</tr>";
		
		$("#tbConsultaLogros").append(newRowCuerpo1);
		$("#tbConsultaLogros").append(newRowCuerpo2);
		
	});
	
	gridSingleSelect('tbConsultaLogros');
	
	$("#tbConsultaLogros").removeAttr("style");
	
	if(listaRubros.length > 4)
	{		
		$("#divConsultaLogros").css("overflow-x","scroll");
		$("#divConsultaLogros").css("overflow-y","hidden");
		$("#tbConsultaLogros").css("width",(250 + 120*listaRubros.length) + 'px');
	}
		
}

function exportarExcelConsultaLogro()
{
	
	if($('#idTerritorioFiltro').is('select')) {
		descTerritorio = $('#idTerritorioFiltro option:selected').text();
	} else {
		descTerritorio = $('#descTerritorioFiltro').val();
	}
	
	if($('#idOficinaFiltro').is('select')) {
		descOficina = $('#idOficinaFiltro option:selected').text();
	} else {
		descOficina = $('#descOficinaFiltro').val();
	}	
	
	 var result = ""; 
	 result += descTerritorio + "|";
	 result += descOficina + "|";
	 result += $('#idAnio option:selected' ).text() + "|";
	 result += $('#idMes option:selected').text() + "|";
	 result += $('#idSemana option:selected').text() + "|";
 
	$("#exportarConsultaLogro").val(result);
	$("#codigoTerritorio").val($('#idTerritorioFiltro').val());
	$("#codigoOficina").val($('#idOficinaFiltro').val());
	$("#anio").val($('#idAnio').val());
	$("#mes").val($('#idMes').val());
	$("#semana").val($('#idSemana').val());
	
	document.getElementById('currentForm').action = 'exportarExcelConsultaLogro.do';

	document.getElementById('currentForm').submit();
}