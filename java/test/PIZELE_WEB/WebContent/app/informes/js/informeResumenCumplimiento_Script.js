
ejecutarMetodoAdicional_Anio = true;
ejecutarMetodoAdicional_Mes = true;

function onChangeAnio()
{
	inicializarEstadoAnioMesSemana();
	cargarSemanas();
	$("#currentForm").validationEngine("validateField","#idAnio");
}

function onChangeMes()
{
	inicializarEstadoAnioMesSemana();
	cargarSemanas();
	$("#currentForm").validationEngine("validateField","#idMes");
}

function buscarResumenCumplimiento()
{
	if($("#currentForm").validationEngine("validateField","#idAnio") || $("#currentForm").validationEngine("validateField","#idMes"))
		return;
	
	
	var jqxhr = $.post("buscarResumenCumplimiento.do",
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
			openDialogError(data.mensaje);			
		}
		else if(data.resultado != undefined && data.resultado == "NO_DATA")
		{
			$("#tbResumenCumplimiento").css('display','none'); 
			$("#tbRankMensualRubro > tbody").empty();
			$("#tbRankSemanalRubro > tbody").empty();
			$("#tbRankMensualGestor > tbody").empty();
			$("#tbRankSemanalGestor > tbody").empty();
		}
		else if(data.resultado != undefined && data.resultado == "EXITO")
		{
			recargarResumenCumplimiento(data.listaObjetos1, 
										data.listaObjetos2,
										data.listaObjetos3,
										data.listaObjetos4,
										data.listaObjetos5);
		}
		else
		{
			document.getElementById('currentForm').action = 'logout.do';
			document.getElementById('currentForm').submit();
		}
	});	
}

function recargarResumenCumplimiento(listaRankRubroMensual, 
									 listaRankRubroSemanal, 
									 listaRankGestorMensual, 
									 listaRankGestorSemanal,
									 listaImagenesReporte)
{

	$("#tbResumenCumplimiento").css('display','inline'); 
	$("#tbRankMensualRubro > tbody").empty();
	$("#tbRankSemanalRubro > tbody").empty();
	$("#tbRankMensualGestor > tbody").empty();
	$("#tbRankSemanalGestor > tbody").empty();
	
	var newRow = "";
	
	$.each(listaRankRubroMensual, function(i,objeto)
	{  			
		var cssClase = (i%2 == 0 ? 'odd' : 'even');
		
		newRow = "<tr class='" + cssClase + "'>";
		newRow = newRow + "<td><img src='/PIZELE_WEB/images/arrow_white.gif'/></td>";
		newRow = newRow + "<td>" + objeto.descRubro + "</td>";
		newRow = newRow + "<td align='center'>" + objeto.porcentajeCumplimiento + "</td>";
		newRow = newRow + "<td bgcolor='" + objeto.color + "'>&nbsp;</td></tr>";
		$("#tbRankMensualRubro").append(newRow);
	});
	
	gridSingleSelect('tbRankMensualRubro');	
	
	
	newRow = "";
	
	$.each(listaRankGestorMensual, function(i,objeto)
			{  			
				var cssClase = (i%2 == 0 ? 'odd' : 'even');
				
				newRow = "<tr class='" + cssClase + "'>";
				newRow = newRow + "<td><img src='/PIZELE_WEB/images/arrow_white.gif'/></td>";
				newRow = newRow + "<td>" + objeto.nomGestor + " " + objeto.apellPatGestor + "</td>";
				newRow = newRow + "<td align='center'>" + objeto.porcentajeCumplimiento + "</td>";
				newRow = newRow + "<td bgcolor='" + objeto.color + "'>&nbsp;</td></tr>";
				$("#tbRankMensualGestor").append(newRow);
			});
			
	gridSingleSelect('tbRankMensualGestor');	
			
	if(listaRankRubroSemanal.length > 0)
	{
		$("#rowTituloRankSemRubro").css('display','inline');
		$("#rowContenidoRankSemRubro").css('display','inline');
		
		newRow = "";
		
		$.each(listaRankRubroSemanal, function(i,objeto)
		{  			
			var cssClase = (i%2 == 0 ? 'odd' : 'even');
			
			newRow = "<tr class='" + cssClase + "'>";
			newRow = newRow + "<td><img src='/PIZELE_WEB/images/arrow_white.gif'/></td>";
			newRow = newRow + "<td>" + objeto.descRubro + "</td>";
			newRow = newRow + "<td align='center'>" + objeto.porcentajeCumplimiento + "</td>";
			newRow = newRow + "<td bgcolor='" + objeto.color + "'>&nbsp;</td></tr>";
			$("#tbRankSemanalRubro").append(newRow);
		});
		
		gridSingleSelect('tbRankSemanalRubro');	
		
	}
	else
	{
		$("#rowTituloRankSemRubro").css('display','none');
		$("#rowContenidoRankSemRubro").css('display','none');
	}
	
	if(listaRankGestorSemanal.length > 0)
	{
		$("#rowTituloRankSemGestor").css('display','inline');
		$("#rowContenidoRankSemGestor").css('display','inline');
		
		newRow = "";
		
		$.each(listaRankGestorSemanal, function(i,objeto)
				{  			
					var cssClase = (i%2 == 0 ? 'odd' : 'even');
					
					newRow = "<tr class='" + cssClase + "'>";
					newRow = newRow + "<td><img src='/PIZELE_WEB/images/arrow_white.gif'/></td>";
					newRow = newRow + "<td>" + objeto.nomGestor + " " + objeto.apellPatGestor + "</td>";
					newRow = newRow + "<td align='center'>" + objeto.porcentajeCumplimiento + "</td>";
					newRow = newRow + "<td bgcolor='" + objeto.color + "'>&nbsp;</td></tr>";
					$("#tbRankSemanalGestor").append(newRow);
				});
				
		gridSingleSelect('tbRankSemanalGestor');
	}
	else
	{
		$("#rowTituloRankSemGestor").css('display','none');
		$("#rowContenidoRankSemGestor").css('display','none');
	}
	
	$.each(listaImagenesReporte, function(i,objeto)
	{  	
		if(i == 0)
		{
			$('#imgReporRankMensualRubro').attr("src", obtenerContexto() + objeto.path);									
			$('#divReporRankMensualRubro').css('height', objeto.height + 'px');
		}
		else if(i == 1)
		{
			$('#imgReporRankMensualGestor').attr("src", obtenerContexto() + objeto.path);						
			$('#divReporRankMensualGestor').css('height', objeto.height + 'px');
		}
		else if(i == 2)
		{
			$('#imgReporRankSemanalRubro').attr("src", obtenerContexto() + objeto.path);									
			$('#divReporRankSemanalRubro').css('height', objeto.height + 'px');
		}
		else if(i == 3)
		{
			$('#imgReporRankSemanalGestor').attr("src", obtenerContexto() + objeto.path);					
			$('#divReporRankSemanalGestor').css('height', objeto.height + 'px');
		}
	});
	
}

function exportarExcelResumenCumplimiento()
{
	 var result = ""; 
	 result += ($('#idTerritorioFiltro option:selected').text() == '' ? $('#descTerritorioFiltro').val() : $('#idTerritorioFiltro option:selected').text()) + "|";
	 result += ($('#idOficinaFiltro option:selected').text() == '' ? $('#descOficinaFiltro').val() : $('#idOficinaFiltro option:selected').text()) + "|";
	 result += $('#idAnio option:selected' ).text() + "|";
	 result += $('#idMes option:selected').text() + "|";
	 result += $('#idSemana option:selected').text() + "|";
	 
	$("#exportarResumenCumplimiento").val(result);
	$("#codigoTerritorioExcel").val($('#idTerritorioFiltro').val());
	$("#codigoOficinaExcel").val($('#idOficinaFiltro').val());
	$("#anioExcel").val($('#idAnio').val());
	$("#mesExcel").val($('#idMes').val());
	$("#semanaExcel").val($('#idSemana').val());
	
	 
	document.getElementById('currentForm').action = 'exportarExcelResumenCumplimiento.do';
	document.getElementById('currentForm').submit();
	
}
