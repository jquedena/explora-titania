ejecutarMetodoAdicional_Territorio = true;
ejecutarMetodoAdicional_Oficina = true;

function onChangeTerritorio(){
	seleccioneChangeTextOficina();
}

function onChangeOficina(){
	if($('#idTerritorioFiltro').val() != "-1"){
		if($('#idOficinaFiltro').val() != "-1"){
			recargarGOF();
		}
	}
}
function recargarGOF() {
	var jqxhr = $.post("recargarGOF.do", {'codOficina': $('#idOficinaFiltro').val(), 'codigoGOF': $("#txtCodigoRegistro").val()});

	jqxhr.success(function(data) {
		if(data.resultado != undefined && data.resultado == "ERROR") {
			openDialogError(data.mensaje);
		}		    		
		else if(data.resultado != undefined && data.resultado == "EXITO") {
			_html = "";
			_html = "<option value='-1'>---Seleccione---</option>";
			$.each(data.listaObjetos[0].gestores, function(i, item){
				_html += "<option value='" + item.codigoRegistro + "'>" + item.nombreCompleto + "</option>";
			});
			$("#idNuevoGestorBackup").html(_html);
			$("#idNuevoGestorBackup").val('-1');
			
			$("#txtCodigoRegistro").val(data.listaObjetos[0].GOF.codusu);
			$("#txtNombreRegistro").val(data.listaObjetos[0].GOF.nombreCompleto);
			
			recargaLista(data.listaObjetos[0].backup);
		}
		else {
			document.getElementById('currentForm').action = 'logout.do';
			document.getElementById('currentForm').submit();
		}
	});
}

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
		   		   	'codigosBackup': ids, 'codOficina': $('#idOficinaFiltro').val(), 'codigoGOF': $("#txtCodigoRegistro").val()
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
			   		   	'backupEdicion.codigoGestorSuplente': $('#idNuevoGestorBackup').val(),
			   		   	'backupEdicion.codigoGOF': $('#txtCodigoRegistro').val(),
			   		   	'codOficina': $('#idOficinaFiltro').val(),
			   		   	'codigoGOF': $("#txtCodigoRegistro").val()
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
		   		   	'backupEdicion.codigoGestorSuplente': $('#idNuevoGestorBackup').val(),
		   		   	'codOficina': $('#idOficinaFiltro').val(),
		   		   	'codigoGOF': $("#txtCodigoRegistro").val()
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
	
	recargaLista(data.listaObjetos);
}

function recargaLista(listaBackup) {
	$("#tbBackupVigente > tbody").empty(); 
	
	$.each(listaBackup, function(i,objeto)
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
	$('#codOficina_Excel').val($('#idOficinaFiltro').val());
	$('#codigoGOF_Excel').val($("#txtCodigoRegistro").val());
	
	$('#nombreGOF_Excel').val($("#txtNombreRegistro").val());
	$('#oficinaGOF_Excel').val($('#idOficinaFiltro option:selected').text() == '' ? $('#descOficinaFiltro').val() : $('#idOficinaFiltro option:selected').text());
	$('#territorioGOF_Excel').val($('#idTerritorioFiltro option:selected').text() == '' ? $('#descTerritorioFiltro').val() : $('#idTerritorioFiltro option:selected').text());
	
	document.getElementById('currentForm').action = 'exportarExcelBackupSuplente.do';
	document.getElementById('currentForm').submit();
}