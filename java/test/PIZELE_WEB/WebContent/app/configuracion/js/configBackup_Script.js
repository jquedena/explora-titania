

function validarFecha()
{
	$("#currentForm").validationEngine("validateField","#idVigencia"); 
}

function validarGestor()
{
	$("#currentForm").validationEngine("validateField","#idNuevoGestorBackup"); 
}

function executeActionForm_guardarBackup()
{
	var esValido = true;
	
	esValido = $("#currentForm").validationEngine('validate');
	
	if(esValido)
	{
		openDialogConfirm('&#191;Desea guardar los datos ingresados?');		
	}
}

function executeActionForm_eliminarBackups()
{
	var esValido = false;
	
	$('[name=chkBackupsVigentes]:checked').each(function() 
	{
		esValido = true;		
	});
	
	if(esValido)
	{
		openDialogConfirm2('&#191;Desea eliminar los Backups seleccionados?');		
	}
	else
	{
		openDialogError('Debe seleccionar almenos un Backup.');
	}
}

function okButton2()
{
	
	closeDialogConfirm2();
	
	var ids = '';
	var index = 0;
	$('[name=chkBackupsVigentes]:checked').each(function() 
    {
		if(index == 0)
		{
			ids = $(this).val();
		}
		else
		{
			ids = ids + '|' + $(this).val();
		}	
		index++;
    });
	
	var jqxhr = $.post("eliminarBackupSuplente.do", 
		   		   {
		   		   	'codigosBackup': ids
		   		   });
	
    jqxhr.success(function(data) 
    	{ 
    		if(data.resultado != undefined && data.resultado == "ERROR")
    		{
    			openDialogError(data.mensaje);
    		}		    		
    		else if(data.resultado != undefined && data.resultado == "EXITO")
    		{
    			regargarListaBackupVigente(data);
    		}
    		else
    		{
    			document.getElementById('currentForm').action = 'logout.do';
				document.getElementById('currentForm').submit();
    		}
    	}
    );
    
}

function okButton()
{
		closeDialogConfirm();
	
		var jqxhr = $.post("guardarBackupSuplenteValidacion.do", 
			   		   {
			   		   	'backupEdicion.fechaVigente': $('#idVigencia').val(),
			   		   	'backupEdicion.codigoGestorSuplente': $('#idNuevoGestorBackup').val()
			   		   });
    	
	    jqxhr.success(function(data) 
	    	{ 
	    		if(data.resultado != undefined && data.resultado == "ERROR")
	    		{
	    			openDialogError(data.mensaje);
	    		}		    		
	    		else if(data.resultado != undefined && data.resultado == "PREGUNTA")
	    		{
	    			openDialogPregunta(data.mensaje);	
	    		}
	    		else if(data.resultado != undefined && data.resultado == "EXITO")
	    		{
	    			regargarListaBackupVigente(data);
	    		}
	    		else
	    		{
	    			document.getElementById('currentForm').action = 'logout.do';
					document.getElementById('currentForm').submit();
	    		}
	    	}
	    );
	        
}

function okEjecutar()
{
	closeDialogPregunta();
	
	var jqxhr = $.post("actualizarBackupSuplente.do", 
		   		   {
		   		   	'backupEdicion.fechaVigente': $('#idVigencia').val(),
		   		   	'backupEdicion.codigoGestorSuplente': $('#idNuevoGestorBackup').val()
		   		   });
	
    jqxhr.success(function(data) 
    	{ 
    		if(data.resultado != undefined && data.resultado == "ERROR")
    		{
    			openDialogError(data.mensaje);
    		}		    		
    		else if(data.resultado != undefined && data.resultado == "EXITO")
    		{
    			regargarListaBackupVigente(data);    			
    		}
    		else
    		{
    			document.getElementById('currentForm').action = 'logout.do';
				document.getElementById('currentForm').submit();
    		}
    	}
    );
}

function regargarListaBackupVigente(data)
{
	
	openDialogInfo(data.mensaje);
	
	$('#idVigencia').val('');
	$('#idNuevoGestorBackup').val('0');
	
	$("#tbBackupVigente > tbody").empty(); 
	
	$.each(data.listaObjetos, function(i,objeto)
	{  
		var newRow = '';	
		var cssClase = (i%2 == 0 ? 'odd' : 'even');
		
		newRow = "<tr class='" + cssClase + "'>";
		newRow = newRow + "<td style='text-align:center;'><input type='checkbox' name='chkBackupsVigentes' style='display:none;' value='" + objeto.id + "'/>";
		newRow = newRow + "<img src='/PIZELE_WEB/images/arrow_white.gif'/></td>";
		newRow = newRow + "<td style='width:90px;'>" + objeto.codigoGestorSuplente + "</td>";
		newRow = newRow + "<td>" + objeto.nombreCompleto + "</td>";
		newRow = newRow + "<td style='width:50px;'>" + objeto.fechaVigente + "</td>";
		newRow = newRow + "</tr>";
									    
		$("#tbBackupVigente").append(newRow);		
		
	});
	
	gridMultiSelect('tbBackupVigente');	
	
}

function exportarExcelBackupSuplente()
{
	$('#nombreNuevoBackup_Excel').val($('#idNuevoGestorBackup').children('option:selected').text());
	$('#fechaVigencia_Excel').val($('#idVigencia').val());
	document.getElementById('currentForm').action = 'exportarExcelBackupSuplente.do';
	document.getElementById('currentForm').submit();
}