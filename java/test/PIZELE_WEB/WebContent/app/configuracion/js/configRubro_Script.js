
ejecutarMetodoAdicional_Territorio = true;
ejecutarMetodoAdicional_Oficina = true;
ejecutarMetodoAdicional_Anio = true;
ejecutarMetodoAdicional_Mes = true;

function onChangeTerritorio()
{
	if($('#idTerritorioFiltro').val() == '-1')
	{
		$('#idRowRubroAdicional').css('display','none');		
	}
	else
	{
		$('#idRowRubroAdicional').css('display','inline');	
	}		
	filtrarRubros();
	$("#tbRubros > tbody").empty();
}

function onChangeOficina()
{
	filtrarRubros();
	$("#tbRubros > tbody").empty();
}

function onChangeAnio()
{
	filtrarRubros();
	$("#tbRubros > tbody").empty();
}

function onChangeMes()
{
	filtrarRubros();
	$("#tbRubros > tbody").empty();
}

function filtrarRubros()
{

	var jqxhr = $.post("filtrarRubros.do",
				{
	   				'asignacionRubro_Filtro.codterr': $('#idTerritorioFiltro').val(),
	   				'asignacionRubro_Filtro.codofic': $('#idOficinaFiltro').val(),
	   				'asignacionRubro_Filtro.anio': $('#idAnio').val(),
	   				'asignacionRubro_Filtro.mes': $('#idMes').val()
				});
 	
    jqxhr.success(function(data) 
    { 
    	if(data.resultado != undefined && data.resultado == "ERROR")
    	{
    		openDialogError(data.mensaje);
    	}	
    	else if(data.resultado != undefined && data.resultado == "EXITO")
		{
    		regargarListaRubrosFijos(data.listaObjetos1);
    		regargarListaRubrosAdicionales(data.listaObjetos2);  
		}
    	else
    	{
    		document.getElementById('currentForm').action = 'logout.do';
			document.getElementById('currentForm').submit();
    	}
    });	
}

function regargarListaRubrosFijos(listaObjetos)
{
	
	$("#tbRubroFijo > tbody").empty(); 
	
	if(listaObjetos == undefined)
		return;
	
	$.each(listaObjetos, function(i,objeto)
	{  
		var newRow = '';	
		var cssClase = (i%2 == 0 ? 'odd' : 'even');
		
		newRow = "<tr class='" + cssClase + "'>";
		newRow = newRow + "<td style='text-align:center;width:10px;'><input type='checkbox' name='chkRubroFijo' style='display:none;' value='" + objeto.codigos + "'/>";
		newRow = newRow + "<img src='/PIZELE_WEB/images/arrow_white.gif'/></td>";
		newRow = newRow + "<td>" + objeto.nombreRubro + "</td>";		
		newRow = newRow + "</tr>";
									    
		$("#tbRubroFijo").append(newRow);		
		
	});
	
	gridMultiSelect('tbRubroFijo');	
	
}

function regargarListaRubrosAdicionales(listaObjetos)
{
	
	$("#tbRubroAdicional > tbody").empty(); 
	
	if(listaObjetos == undefined)
		return;
	
	$.each(listaObjetos, function(i,objeto)
	{  
		var newRow = '';	
		var cssClase = (i%2 == 0 ? 'odd' : 'even');
		
		newRow = "<tr class='" + cssClase + "'>";
		newRow = newRow + "<td style='text-align:center;width:10px;'><input type='checkbox' name='chkRubroAdicional' style='display:none;' value='" + objeto.codigos + "'/>";
		newRow = newRow + "<img src='/PIZELE_WEB/images/arrow_white.gif'/></td>";
		newRow = newRow + "<td>" + objeto.nombreRubro + "</td>";		
		newRow = newRow + "</tr>";
									    
		$("#tbRubroAdicional").append(newRow);		
		
	});
	
	gridMultiSelect('tbRubroAdicional');	
	
}


function mostrarFormRubros()
{
	if($('#idTerritorioFiltro').val() == '-1')
	{
		if($('#idAnio').val() == '-1')
		{
			openDialogError('La asignaci&#243;n de rubros fijos es anual, debe seleccionar un a&#241;o.');
			return;
		}
		else
		{
			if($('#idMes').val() != '-1')
			{
				openDialogError('La asignaci&#243;n de rubros fijos es anual, debe seleccionar todos los meses.');
				return;
			}
		}
		
		$("#idTipoRubroFiltro").val('F');
		$("#idDescRubroFiltro").val('');
		$('#jqDialogRubro').dialog('open');
		$('#idDescRubroFiltro').focus();
		
	}
	else
	{
		
		$("#idTipoRubroFiltro").val('A');
		$("#idDescRubroFiltro").val('');
		$('#jqDialogRubro').dialog('open');
		$('#idDescRubroFiltro').focus(); 
	}
}

function buscarRubros()
{

	var jqxhr = $.post("buscarRubros.do",
			{
   				'rubro_Filtro.descFiltro': $('#idDescRubroFiltro').val(),
   				'rubro_Filtro.tiprubro': $('#idTipoRubroFiltro').val()
			});
	
	jqxhr.success(function(data) 
	{ 
		if(data.resultado != undefined && data.resultado == "ERROR")
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
				regargarListaRubros(data.listaObjetos)
			}
		}				
	});	
}

function regargarListaRubros(listaObjetos)
{
	
	$("#tbRubros > tbody").empty(); 
	
	if(listaObjetos == undefined)
		return;
	
	$.each(listaObjetos, function(i,objeto)
	{  
		var newRow = '';	
		var cssClase = (i%2 == 0 ? 'odd' : 'even');
		
		newRow = "<tr class='" + cssClase + "'>";
		newRow = newRow + "<td style='text-align:center;width:10px;'><input type='radio' name='rdbRubro' style='display:none;' value='" + objeto.datos + "'/>";
		newRow = newRow + "<img src='/PIZELE_WEB/images/arrow_white.gif'/></td>";
		newRow = newRow + "<td>" + objeto.descrubro + "</td>";	
		if(objeto.comp_nega == 'S')
		{
			newRow = newRow + "<td align='center'><input type='checkbox' disabled='disabled' checked='true'/></td>";
		}	
		else
		{
			newRow = newRow + "<td align='center'><input type='checkbox' disabled='disabled'/></td>";
		}
		newRow = newRow + "</tr>";
									    
		$("#tbRubros").append(newRow);		
		
	});
	
	gridSingleSelect('tbRubros');

}

function nuevoRubro()
{
	$('#idTipoRubroEdicion').val($('#idTipoRubroFiltro').val());
	$('#idDescRubroEdicion').val('');	
	$('#chkComNegativoEdicion').attr('checked',false);	
	$('#idRubroEdicion').val('');
	$('#jqDialogEdicionRubro').dialog('open');
	$('#idDescRubroEdicion').focus();
}

function editarRubro()
{
	var objRubro = $("input[name='rdbRubro']:checked");
	
	if(objRubro.val() != null)
	{
		$('#idRubroEdicion').val(objRubro.val().split('|')[0]);
		$('#idDescRubroEdicion').val(objRubro.val().split('|')[1]);
		$('#idTipoRubroEdicion').val(objRubro.val().split('|')[2]);
		
		if(objRubro.val().split('|')[3] == 'S')
		{
			$('#chkComNegativoEdicion').attr('checked',true);
		}
		else
		{
			$('#chkComNegativoEdicion').attr('checked',false);
		}
		
		$('#jqDialogEdicionRubro').dialog('open');
		$('#idDescRubroEdicion').focus();
	}
	else
	{
		openDialogError('Debe seleccionar el rubro que desea modificar.');
	}

}

function executeActionForm_guardarRubro()
{
	var esValido = true;
	
	esValido = $("#frmEdicionRubro").validationEngine('validate');
	
	if(esValido)
	{
		openDialogConfirm('&#191;Desea guardar los datos ingresados?');		
	}
}

function okButton()
{
		closeDialogConfirm();
	
		var jqxhr = $.post("guardarRubro.do", 
				   		   {
							'rubro_Filtro.descFiltro': $('#idDescRubroFiltro').val(),
							'rubro_Filtro.tiprubro': $('#idTipoRubroFiltro').val(),
							'rubro_Edicion.id': $('#idRubroEdicion').val(),
							'rubro_Edicion.descrubro': $('#idDescRubroEdicion').val(),
							'rubro_Edicion.tiprubro': $('#idTipoRubroEdicion').val(),
							'rubro_Edicion.comp_nega': $('#chkComNegativoEdicion').is(':checked') ? 'S' : 'N'
				   		   });
    	
	    jqxhr.success(function(data) 
	    	{ 
	    		if(data.resultado != undefined && data.resultado == "ERROR")
	    		{
	    			openDialogError(data.mensaje);
	    		}		    		
	    		else if(data.resultado != undefined && data.resultado == "EXITO")
	    		{
	    			regargarListaRubros(data.listaObjetos);
	    			$('#jqDialogEdicionRubro').dialog('close');
	    		}
	    		else
	    		{
	    			document.getElementById('currentForm').action = 'logout.do';
					document.getElementById('currentForm').submit();
	    		}
	    	}
	    );
	        
}

function asignarRubro()
{
	var objRubro = $("input[name='rdbRubro']:checked");
	var ya_asignado = false;
	var chkName = '';
	var gridID = '';

	if(objRubro.val() != null)
	{
		
		if($('#idTipoRubroFiltro').val() == 'F')
		{
			chkName = 'chkRubroFijo';
			gridID = 'tbRubroFijo';
		}
		else if($('#idTipoRubroFiltro').val() == 'A')
		{
			chkName = 'chkRubroAdicional';
			gridID = 'tbRubroAdicional';
		}
		
		var checkBoxes = $("input[name="+chkName+"]");
		
		if(checkBoxes != null)
		{
			$.each(checkBoxes, function() 
			{
				if(objRubro.val().split('|')[0] == $(this).val().split('|')[1])
				{
					ya_asignado = true;
				}		            	
	        });					
		}
				
		if(ya_asignado)
		{
			openDialogError('El rubro seleccionado ya fue asignado.');
		}
		else
		{
			var newRow = '';
			var valor = '';
			var i = $("#" + gridID + " tr").length;	
			var cssClase = ((i-1)%2 == 0 ? 'odd' : 'even');

			valor = '|' + objRubro.val().split('|')[0];
			newRow = "<tr class='" + cssClase + "'>";
			newRow = newRow + "<td style='text-align:center;width:10px;'><input type='checkbox' name='" + chkName + "' style='display:none;' value='" + valor + "'/>";
			newRow = newRow + "<img src='/PIZELE_WEB/images/arrow_white.gif'/></td>";
			newRow = newRow + "<td>" + objRubro.val().split('|')[1] + "</td>";		
			newRow = newRow + "</tr>";
										    			
			$("#" + gridID).append(newRow);	
			gridMultiSelect_Last(gridID);
			$('#jqDialogRubro').dialog('close');
		}
		
	}
	else
	{
		openDialogError('Debe seleccionar o hacer doble click al rubro que desee asignar.');
	}

}

function aprobarEliminacionFijo()
{
		
	var hay_seleccionados = false;
	
	$('[name=chkRubroFijo]:checked').each(function() 
	{
		hay_seleccionados = true;	
	});
	
	if(!hay_seleccionados)
	{
		openDialogError('Debe seleccionar uno o varios rubros fijos.');
		return;
	}
	
	var fijo_no_eliminable = false;
	
	$('[name=chkRubroFijo]:checked').each(function() 
	{
		if($(this).val().split('|')[1] == '1' || $(this).val().split('|')[1] == '2')
		{
			fijo_no_eliminable = true;			
		}
	});
	
	if(fijo_no_eliminable)
	{
		openDialogError('La asignaci&#243;n de los rubros fijos Contactos y Visitas no pueden ser eliminadas');
		return;
	}	
	
	var ids = '';
	
	$('[name=chkRubroFijo]:checked').each(function() 
	{		
		if($(this).val().split('|')[0] != '')
		{
			ids = ids + "|" + $(this).val().split('|')[0];
		} 
	});
	
	if(ids != '')
	{
		var jqxhr = $.post("validarSuprimirRubroFijo.do", 
		   		    {
					 'codigosEliminar': ids
		   		    });

		jqxhr.success(function(data) 
			{ 
				if(data.resultado != undefined && data.resultado == "ERROR")
				{
					openDialogError(data.mensaje);
				}		    		
				else if(data.resultado != undefined && data.resultado == "EXITO")
				{
					$('[name=chkRubroFijo]:checked').each(function() 
					{
						$(this).parent().parent().remove();
					});

					reprocesarEstilos('tbRubroFijo');    			
				}
				else
				{
					document.getElementById('currentForm').action = 'logout.do';
					document.getElementById('currentForm').submit();
				}
			}
		);
	}
	else
	{
		$('[name=chkRubroFijo]:checked').each(function() 
		{
			$(this).parent().parent().remove();
		});

		reprocesarEstilos('tbRubroFijo');  
	}
	
}

function aprobarEliminacionAdicional()
{
		
	var hay_seleccionados = false;
	
	$('[name=chkRubroAdicional]:checked').each(function() 
	{
		hay_seleccionados = true;	
	});
	
	if(!hay_seleccionados)
	{
		openDialogError('Debe seleccionar uno o varios rubros adicionales.');
		return;
	}
	
	var ids = '';
	
	$('[name=chkRubroAdicional]:checked').each(function() 
	{		
		if($(this).val().split('|')[0] != '')
		{
			ids = ids + "|" + $(this).val().split('|')[0];
		} 
	});
	
	if(ids != '')
	{
		var jqxhr = $.post("validarSuprimirRubroAdicional.do", 
		   		    {
					 'codigosEliminar': ids
		   		    });

		jqxhr.success(function(data) 
			{ 
				if(data.resultado != undefined && data.resultado == "ERROR")
				{
					openDialogError(data.mensaje);
				}		    		
				else if(data.resultado != undefined && data.resultado == "EXITO")
				{
					$('[name=chkRubroAdicional]:checked').each(function() 
					{
						$(this).parent().parent().remove();
					});

					reprocesarEstilos('tbRubroAdicional');    			
				}
				else
				{
					document.getElementById('currentForm').action = 'logout.do';
					document.getElementById('currentForm').submit();
				}
			}
		);
	}
	else
	{
		$('[name=chkRubroAdicional]:checked').each(function() 
		{
			$(this).parent().parent().remove();
		});

		reprocesarEstilos('tbRubroAdicional');  
	}
		
}

function executeActionForm_guardarConfRubro()
{

	if($('#idTerritorioFiltro').val() == '-1')
	{

		if($('#idAnio').val() == '-1')
		{
			openDialogError('La asignaci&#243;n de rubros fijos es anual, debe seleccionar un a&#241;o.');
			return;
		}
		else
		{
			if($('#idMes').val() != '-1')
			{
				openDialogError('La asignaci&#243;n de rubros fijos es anual, debe seleccionar todos los meses.');
				return;
			}
		}
		
		var numero = $("input[name=chkRubroFijo]").length;
		
		if(numero == 0)
		{
			openDialogError('Debe asignar uno o varios rubros fijos.');
			return;
		}
		
		openDialogConfirm2('&#191;Desea guardar la asignaci&#243;n de rubros fijos?');
		
	}
	else
	{

		openDialogConfirm2('&#191;Desea guardar la asignaci&#243;n de rubros adicionales?');
		
	}
		
			
	
}

function okButton2()
{
	
		closeDialogConfirm2();

		var codigos;
		var i = 0;
		
		if($('#idTerritorioFiltro').val() == '-1')
		{
		
			$('[name=chkRubroFijo]').each(function() 
			{
				if(i == 0)
				{
					codigos = $(this).val().split('|')[1];
				}
				else
				{
					codigos = codigos + '|' + $(this).val().split('|')[1];
				}
				i++;
			});
			
		}
		else
		{
			$('[name=chkRubroAdicional]').each(function() 
			{
				if(i == 0)
				{
					codigos = $(this).val().split('|')[1];
				}
				else
				{
					codigos = codigos + '|' + $(this).val().split('|')[1];
				}
					i++;
				});			
		}
				
		var jqxhr = $.post("guardarConfiguracionRubro.do", 
				   		   {
							'asignacionRubro_Filtro.codterr': $('#idTerritorioFiltro').val(),
							'asignacionRubro_Filtro.codofic': $('#idOficinaFiltro').val(),
							'asignacionRubro_Filtro.anio': $('#idAnio').val(),
							'asignacionRubro_Filtro.mes': $('#idMes').val(),
							'codigosGuardar' : codigos
				   		   });
    	
	    jqxhr.success(function(data) 
	    	{ 
	    		if(data.resultado != undefined && data.resultado == "ERROR")
	    		{
	    			openDialogError(data.mensaje);
	    		}		    		
	    		else if(data.resultado != undefined && data.resultado == "EXITO")
	    		{
	        		openDialogInfo(data.mensaje);	    			
	    		}
	    		else
	    		{
	    			document.getElementById('currentForm').action = 'logout.do';
					document.getElementById('currentForm').submit();
	    		}
	    	}
	    );
	        
}

function exportarExcelRubro(){
    var result = "";
    var temp = "";
    
    result += $('#idTerritorioFiltro option:selected').text() + "|";
    result += $('#idOficinaFiltro option:selected').text() + "|";
    result += $('#idAnio option:selected').text() + "|";
    result += $('#idMes option:selected').text() + "|";
    
    $("#tbRubroFijo > tbody > tr").each(function(){
            temp = $(this).find('td').eq(1).text();
            
            if(result.length>0) result += '|'; 
            result += temp;
    });
    
    result += '|~' 
    
    $("#tbRubroAdicional > tbody > tr").each(function(){
            temp = $(this).find('td').eq(1).text();
            
            if(result.length>0) result += '|'; 
            result += temp;
    });
            
    $("#exportarRubroFijo").val(result);

    document.getElementById('currentForm').action = 'exportarExcelRubro.do';
    document.getElementById('currentForm').submit();
}



