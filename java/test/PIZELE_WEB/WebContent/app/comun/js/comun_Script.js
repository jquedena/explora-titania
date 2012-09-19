

var ejecutarMetodoAdicional_Territorio = false;
var ejecutarMetodoAdicional_Oficina = false;
var ejecutarMetodoAdicional_Anio = false;
var ejecutarMetodoAdicional_Mes = false;
var ejecutarMetodoAdicional_Semana = false;
var ejecutarMetodoAdicional_Gestor = false;

var ejecutarMetodoFiltroGestores = false;

var valorDefectoFiltroGestor = '----- Seleccione ------';
var valorDefectoFiltroOficina = '----- Todas ------';

function filtrarOficinas()
{
	$("printTerritorioFiltro")
	
		var jqxhr = $.post("filtrarOficinas.do", 
				   		   {
				   		   		'codigoTerritorioFiltro': $('#idTerritorioFiltro').val()
				   		   });
		
		    jqxhr.success(function(data) 
		    	{
		    		if(data.resultado != undefined && data.resultado == 'error')
		    		{
		    			openDialogError(data.mensaje);
		    		}
		    		else
		    		{
		    			if(data.listaObjetos == undefined)
		    			{
		    				document.getElementById('currentForm').action = 'logout.do';
							document.getElementById('currentForm').submit();
		    			}
		    			else
		    			{
		    				$('#idOficinaFiltro').empty();
			    			$('#idOficinaFiltro').append($('<option>', { value : '-1' }).text(valorDefectoFiltroOficina));

			    			$.each(data.listaObjetos, function(i,objeto)
			    			{  			
			    				$('#idOficinaFiltro').append($('<option>', { value : objeto.codigo }).text(objeto.descripcion));  
			    			});  	
			    			
			    			if(ejecutarMetodoAdicional_Territorio)
			    				onChangeTerritorio();
			    			
			    			if(ejecutarMetodoFiltroGestores)
			    			{
			    				$('#idGestor').empty();
				    			$('#idGestor').append($('<option>', { value : '-1' }).text(valorDefectoFiltroGestor));			    				
			    			}			    							    		
		    			}								    		
		    		}	    		    		
		    	}
		    );
		    		    
}

function seleccionaOficinas()
{
	if(ejecutarMetodoFiltroGestores)
	{
		var jqxhr = $.post("filtrarGestores.do", 
		   		   {
		   		   		'codigoOficinaFiltro': $('#idOficinaFiltro').val()
		   		   });

				 jqxhr.success(function(data) 
				 	{
				 		if(data.resultado != undefined && data.resultado == 'error')
				 		{
				 			openDialogError(data.mensaje);
				 		}
				 		else
				 		{
				 			if(data.listaObjetos == undefined)
				 			{
				 				document.getElementById('currentForm').action = 'logout.do';
								document.getElementById('currentForm').submit();
				 			}
				 			else
				 			{
				 					$('#idGestor').empty();
					    			$('#idGestor').append($('<option>', { value : '-1' }).text(valorDefectoFiltroGestor));
				
					    			$.each(data.listaObjetos, function(i,objeto)
					    			{  			
					    				$('#idGestor').append($('<option>', { value : objeto.codigoRegistro }).text(objeto.nombreCompleto));  
					    			});  	
					    						    							    		
				 			}								    		
				 		}	    		    		
				 	}
				 );			    				
	}
	
	if(ejecutarMetodoAdicional_Oficina)
		onChangeOficina();
}

function seleccionaAnio()
{
	inicializarEstadoAnioMes();
	
	if(ejecutarMetodoAdicional_Anio)
		onChangeAnio();
}

function seleccionaMes()
{
	if(ejecutarMetodoAdicional_Mes)
		onChangeMes();
}

function seleccionaSemana()
{
	if(ejecutarMetodoAdicional_Semana)
		onChangeSemana();
}

function seleccionaGestor()
{
	if(ejecutarMetodoAdicional_Gestor)
		onChangeGestor();
}



function inicializarEstadoAnioMes()
{
	if($('#idAnio').val() == '-1')
	{
		$('#idMes').val('-1');
		$('#idMes').attr('disabled','disabled');
	}	
	else
	{
		$('#idMes').removeAttr('disabled');
	}
}

function inicializarEstadoAnioMesSemana()
{
	if($('#idAnio').val() == '-1' || $('#idMes').val() == '-1')
	{
		$('#idSemana').val('-1');
		$('#idSemana').attr('disabled','disabled');
	}	
	else
	{
		$('#idSemana').removeAttr('disabled');
	}
}

function seleccioneChangeTextTerritorio()
{
	if($("#idTerritorioFiltro").is('select'))
	{
		$("#idTerritorioFiltro").find('option').eq(0).html('---- Seleccione ----');
	}
}

function seleccioneChangeTextOficina()
{
	if($("#idOficinaFiltro").is('select'))
	{
		$("#idOficinaFiltro").find('option').eq(0).html('---- Seleccione ----');
	}	
}

function seleccioneChangeTextAnio()
{
	if($("#idAnio").is('select'))
	{
		$("#idAnio").find('option').eq(0).html('---- Seleccione ----');
	}	
}

function seleccioneChangeTextMes()
{
	$("#idMes").find('option').eq(0).html('---- Seleccione ----');
}

function todosChangeTextGestor()
{
	$("#idGestor").find('option').eq(0).html('---- Todos ----');
}

function cargarSemanas()
{
	
	if($('#idAnio').val() == '-1' || $('#idMes').val() == '-1')
		return;
	
	$('#idSemana').empty();
	$('#idSemana').append($('<option>', { value : '-1' }).text('----- Todas ------'));
	$('#idSemana').append($('<option>', { value : '1' }).text('Semana 1'));
	$('#idSemana').append($('<option>', { value : '2' }).text('Semana 2'));
	$('#idSemana').append($('<option>', { value : '3' }).text('Semana 3'));
	$('#idSemana').append($('<option>', { value : '4' }).text('Semana 4'));
	
	if(fn_tieneQuintaSemana())
	{		
		$('#idSemana').append($('<option>', { value : '5' }).text('Semana 5'));
	}
	
}

function establacerSemana()
{
	$('#idSemana').val($('#semana').val());
}
