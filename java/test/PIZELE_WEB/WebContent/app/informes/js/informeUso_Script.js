function validar() {
	var _mensaje = "";
	if($('#idFechaDesde').val() == '' && $('#idFechaHasta').val() == '') {
		_mensaje = "Debe ingresar la fecha de inicio y termino del periodo a verificar.";
	} else if($('#idFechaDesde').val() == '') {
		_mensaje = "Debe ingresar la fecha de inicio del periodo a verificar.";
	} else if($('#idFechaHasta').val() == '') {
		_mensaje = "Debe ingresar la fecha de termino del periodo a verificar.";
	}
	return _mensaje;
}
function procesatBusquedaInforme()
{    
	var mensaje = validar();
	
	if(mensaje == "") {
		var jqxhr = $.post("buscarInformeUso.do", 
			   		   {
						'informeUso.codterr': $('#idTerritorioFiltro').val(),
						'informeUso.codigoOficina': $('#idOficinaFiltro').val(),
						'informeUso.fechaDesde': $('#idFechaDesde').val(),
                        'informeUso.fechaHasta': $('#idFechaHasta').val()
			   		   });
		
	    jqxhr.success(function(data) 
	    	{ 
	    		if(data.resultado != undefined && data.resultado == "ERROR")
	    		{
	    			openDialogError(data.mensaje);
	    		}
	    		
	    		else
	    		{
	    			if(data.listaObjetos1 == undefined || data.listaObjetos2 == undefined )
	    			{
	    				document.getElementById('currentForm').action = 'logout.do';
	    				document.getElementById('currentForm').submit();
	    			}
	    			else
	    			{
	    				regargarListaInforme(data.listaObjetos1, data.listaObjetos2);
	    			}
	    		}				
	    	});
	} else {
		openDialogError(mensaje);
	}
}



function regargarListaInforme(listaObjetosCuerpo, listaObjetosPromedio)
{

	$("#tbInformeUso > tbody").empty();
	$("#tbInformeUso > tfoot").empty(); 
	
	if(listaObjetosCuerpo.length == 0 || listaObjetosPromedio.length == 0)
		return;
	
	$.each(listaObjetosCuerpo, function(i,objeto)
	{  
		var newRow = '';	
		var cssClase = (i%2 == 0 ? 'odd' : 'even');
		
		newRow = "<tr class='" + cssClase + "'>";
		newRow = newRow + "<td style='text-align:center;width:10px;'><img src='/PIZELE_WEB/images/arrow_white.gif'/></td>";		
		newRow = newRow + "<td>" + objeto.nombreTerr + "</td>";
		newRow = newRow + "<td>" + objeto.codigoOficina + "</td>";	
		newRow = newRow + "<td>" + objeto.nombreOficina + "</td>";	
		newRow = newRow + "<td>" + objeto.nombreGestorGerente + "</td>";	
		
		if(objeto.porcentajeMeta == 0)
		{
			newRow = newRow + "<td align='center' bgcolor= '#FF0000'>NO</td>";
		}	
		else
		{
			newRow = newRow + "<td align='center' bgcolor= '#00FF00'>SI</td>";
		}
		newRow = newRow + "<td align='center'>" + objeto.porcentajeMeta + "%</td>";	
		
		
		if(objeto.porcentajeLogro == 0)
		{
			newRow = newRow + "<td align='center' bgcolor= '#FF0000'>NO</td>";
		}	
		else
		{
			newRow = newRow + "<td align='center' bgcolor= '#00FF00'>SI</td>";
		}
		newRow = newRow + "<td align='center'>" + objeto.porcentajeLogro + "%</td>";	
		
		newRow = newRow + "<td align='center'>" + objeto.consecucion + "%</td>";	
		newRow = newRow + "</tr>";
									    
		$("#tbInformeUso").append(newRow);		
		
	});
	
	$.each(listaObjetosPromedio, function(i,objeto) {  
		var newRow = '';	
		var cssClase = 'avarage';
		
		newRow = "<tr class='" + cssClase + "'>";
		newRow = newRow + "<td style='text-align:center;width:10px;'>&nbsp;</td>";		
		newRow = newRow + "<td colspan='4' align='right'><label>Promedios : </label>&nbsp;&nbsp;</td>";
		newRow = newRow + "<td></td>";
		newRow = newRow + "<td align='center'>" + objeto.porcentajeMeta + "%</td>";
		newRow = newRow + "<td></td>";
		newRow = newRow + "<td align='center'>" + objeto.porcentajeLogro + "%</td>";
		newRow = newRow + "<td align='center'>" + objeto.consecucion + "%</td>";
		newRow = newRow + "</tr>";
									    
		$("#tbInformeUso > tfoot").append(newRow);		
		
	});
	
	gridSingleSelect('tbInformeUso');
}

function exportarExcelInformeUso() {
	var mensaje = validar();
	
	if(mensaje == "") {
		
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
		$('#idFechaDesdeExcel').val($('#idFechaDesde').val());
		$('#idFechaHastaExcel').val($('#idFechaHasta').val());
		
		document.getElementById('currentForm').action = 'exportarExcelInfomeUso.do';
		document.getElementById('currentForm').submit();
	} else {
		openDialogError(mensaje);
	}
}

function nroDiasMes(mes, anio) {
  var fmFebrero = ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))) ? 29 : 28;
  var DAYS_IN_MONTH = [31, fmFebrero, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
  return DAYS_IN_MONTH[mes];
}

$.subscribe('onDpClose', function(event, data) {
	var selectDate = $("#idFechaDesde").val();
	var anio = parseInt(selectDate.substring(6));
	var mes = parseInt(selectDate.substring(3, 5)) - 1;
	var dia = nroDiasMes(mes, anio);

	$("#idFechaHasta").datepicker("option", "minDate", new Date(anio, mes, 1));
	$("#idFechaHasta").datepicker("option", "maxDate", new Date(anio, mes, dia));
});