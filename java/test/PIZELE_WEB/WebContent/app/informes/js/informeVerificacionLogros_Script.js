
ejecutarMetodoAdicional_Territorio = true;
ejecutarMetodoAdicional_Oficina = true;
ejecutarMetodoAdicional_Gestor = true;

ejecutarMetodoFiltroGestores = true;

var valorDefectoFiltroOficina = '----- Seleccione ------';

function procesatBusquedaVerificacionLogro()
{
	var esValido = true;
	
	esValido = $("#currentForm").validationEngine('validate');
	
	if(esValido)
	{
		var jqxhr = $.post("buscarVerificacionLogro.do", 
		   		   {
						'verificacionLogroParametroFiltro.codigoTerritorio': $('#idTerritorioFiltro').val(),
						'verificacionLogroParametroFiltro.codigoOficina': $('#idOficinaFiltro').val(),
						'verificacionLogroParametroFiltro.codigoGestor': $('#idGestor').val(),
						'verificacionLogroParametroFiltro.fechaDesde': $('#idFechaDesde').val(),
			            'verificacionLogroParametroFiltro.fechaHasta': $('#idFechaHasta').val()
		   		   });

		jqxhr.success(function(data) 
			{ 
				if(data.resultado != undefined && data.resultado == "ERROR")
	    		{
	    			openDialogError(data.mensaje);
	    		}
	    		
	    		else
	    		{
	    			if(data.objeto == undefined)
	    			{
	    				document.getElementById('currentForm').action = 'logout.do';
	    				document.getElementById('currentForm').submit();
	    			}
	    			else
	    			{
	    				if(data.objeto.path != "")
	    				{	    					
	    					$('#imgReporte').css('display','inline');
	    					
	    					$('#imgReporte').attr("src", obtenerContexto() + data.objeto.path);
	    					
	    					$('#imgReporte').css('width', data.objeto.width + 'px');
	    					$('#imgReporte').css('height', data.objeto.height + 'px');
	    					
	  
	    					if(data.objeto.width > 700)
	    					{	    						
	    						$('#divImgReporte').css('overflow-x','scroll');
	    					}
	    					else
	    					{
	    						$('#divImgReporte').css('overflow-x','hidden');
	    					}
	    				
	    				}
	    				else
	    				{
	    					$('#divImgReporte').css('overflow-x','hidden');
	    					$('#imgReporte').css('display','none');
	    				}
	    				
	    			}
	    		}
				
			});		
	}
	
}

function exportarVerificacionLogro()
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
	$('#idFechaDesdeExcel').val($('#idFechaDesde').val());
	$('#idFechaHastaExcel').val($('#idFechaHasta').val());
	
	document.getElementById('currentForm').action = 'exportarExcelVerificacionLogro.do';
	document.getElementById('currentForm').submit();
	
}

function onChangeTerritorio()
{
	$("#currentForm").validationEngine("validateField","#idTerritorioFiltro"); 
}

function onChangeOficina()
{
	$("#currentForm").validationEngine("validateField","#idOficinaFiltro"); 
}

function onChangeGestor()
{
	$("#currentForm").validationEngine("validateField","#idGestor"); 
}
