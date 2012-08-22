ejecutarMetodoAdicional_Territorio = true;
ejecutarMetodoAdicional_Oficina = true;
ejecutarMetodoAdicional_Anio = true;
ejecutarMetodoAdicional_Mes = true;

function fn_OnlyZero(control) {
	control.value = $.trim(control.value)=='' ? '0' : $.trim(control.value);
}

function cargarConfBasicaMeta() {
	var jqxhr = $.post("cargarConfBasicaMeta.do", 
	   		   {
				'basicaMeta.id': $('#id').val(),
				'basicaMeta.cod_terr': $('#idTerritorioFiltro').val(),
				'basicaMeta.cod_ofi': $('#idOficinaFiltro').val(),
				'basicaMeta.anio': $('#idAnio').val(),
				'basicaMeta.mes': $('#idMes').val()
	   		   });
	
	jqxhr.success(function(data) 
		{ 
		
			if(data.resultado != undefined && data.resultado == "ERROR")
			{
				openDialogError(data.mensaje);
			}		    		
			else if(data.id != undefined)
			{
				$('#id').val(data.id);
				$('#idTerritorioFiltro').val(data.cod_terr);
				$('#idOficinaFiltro').val(data.cod_ofi);
				$('#idAnio').val(data.anio);
				$('#idMes').val(data.mes);
				$('#semana1').val(data.semana1);
				$('#semana2').val(data.semana2);
				$('#semana3').val(data.semana3);
				$('#semana4').val(data.semana4);
				$('#semana5').val(data.semana5);
				$('#min_con_dia_perso').val(data.min_con_dia_perso);
				$('#min_con_dia_no_perso').val(data.min_con_dia_no_perso);
				$('#min_vis_dia_perso').val(data.min_vis_dia_perso);
				$('#min_vis_dia_no_perso').val(data.min_vis_dia_no_perso);
				
				fn_CalcularDistribMes();
				fn_ActivarQuintaSemana();
			}
			else
			{
				document.getElementById('currentForm').action = 'logout.do';
				document.getElementById('currentForm').submit();
			}
		}
	);
}


function onChangeTerritorio() {
	cargarConfBasicaMeta();
}

function onChangeOficina() {
	cargarConfBasicaMeta();
}

function onChangeAnio() {
	cargarConfBasicaMeta();
}

function onChangeMes() {
	cargarConfBasicaMeta();
}

function fn_ValidatePercent(pControl) {
    if (pControl.value>100) {
    	alert("El valor no debe exceder al 100%");
    	pControl.value=0;
    }
}

function fn_CalcularDistribMes(pControl) {
	fn_ValidatePercent(this);
	var controlsArray = new Array('semana1','semana2','semana3','semana4','semana5');
	var total = fn_calcTotal(controlsArray);
	
	if (total>100) 
	{
		openDialogError("El porcentaje Distribuido del Mes debe sumar el 100%");
		pControl.value=0;
		total = fn_calcTotal(controlsArray);
	}
	
	$('#distribuidoMes').val(total);
}

function executeActionForm_guardarConfigBasicaMeta()
{
	var esValido = true;
	
	esValido = $("#currentForm").validationEngine('validate');
	
	if(esValido)
	{
		if ($('#distribuidoMes').val()==100)
			openDialogConfirm('&#191;Desea guardar los datos ingresados?');
		else
			openDialogError("El porcentaje Distribuido del Mes debe sumar el 100%");			
	}
}

function executeActionForm_eliminarConfigBasicaMeta()
{
	var esValido = true;
	
	esValido = $("#currentForm").validationEngine('validate');
	
	if(esValido)
	{
		openDialogConfirm2('&#191;Desea eliminar los datos?');		
	}
}

function okButton()
{
		closeDialogConfirm();
	
		var jqxhr = $.post("guardarConfBasicaMeta.do", 
			   		   {
						'basicaMeta.id': $('#id').val(),
						'basicaMeta.cod_terr': $('#idTerritorioFiltro').val(),
						'basicaMeta.cod_ofi': $('#idOficinaFiltro').val(),
						'basicaMeta.anio': $('#idAnio').val(),
						'basicaMeta.mes': $('#idMes').val(),
			   		   	'basicaMeta.semana1': $('#semana1').val(),
			   		   	'basicaMeta.semana2': $('#semana2').val(),
			   		   	'basicaMeta.semana3': $('#semana3').val(),
			   		   	'basicaMeta.semana4': $('#semana4').val(),
			   		   	'basicaMeta.semana5': $('#semana5').val(),
			   		   	'basicaMeta.min_con_dia_perso': $('#min_con_dia_perso').val(),
			   		   	'basicaMeta.min_con_dia_no_perso': $('#min_con_dia_no_perso').val(),
			   		   	'basicaMeta.min_vis_dia_perso': $('#min_vis_dia_perso').val(),
			   		   	'basicaMeta.min_vis_dia_no_perso': $('#min_vis_dia_no_perso').val()
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

function okButton2()
{
		closeDialogConfirm2();
	
		var jqxhr = $.post("eliminarConfBasicaMeta.do", 
			   		   {
						'basicaMeta.id': $('#id').val()
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
	    			cargarConfBasicaMeta();
	    		}
	    		else
	    		{
	    			document.getElementById('currentForm').action = 'logout.do';
					document.getElementById('currentForm').submit();
	    		}
	    	}
	    );
	        
}

function exportarExcelConfigBasicaMeta()
{
	
	if($('#idTerritorioFiltro').is('select'))	
		$('#des_terr').val($('#idTerritorioFiltro').children('option:selected').text());	
	else	
		$('#des_terr').val($('#descTerritorioFiltro').val());
	
	if($('#idOficinaFiltro').is('select'))	
		$('#des_ofi').val($('#idOficinaFiltro').children('option:selected').text());	
	else	
		$('#des_ofi').val($('#descOficinaFiltro').val());
	
	$('#des_anio').val(obtenerValorVistaControl('#idAnio'));
	$('#des_mes').val(obtenerValorVistaControl('#idMes'));
	$('#des_sem1').val($('#semana1').val());
	$('#des_sem2').val($('#semana2').val());
	$('#des_sem3').val($('#semana3').val());
	$('#des_sem4').val($('#semana4').val());
	$('#des_sem5').val($('#semana5').val());
	$('#des_min_con_per').val($('#min_con_dia_perso').val());
	$('#des_min_con_no_per').val($('#min_con_dia_no_perso').val());
	$('#des_min_vis_per').val($('#min_vis_dia_perso').val());
	$('#des_min_vis_no_per').val($('#min_vis_dia_no_perso').val());
	
	document.getElementById('currentForm').action = 'exportarExcelConfigBasicaMeta.do';
	document.getElementById('currentForm').submit();
}