

function obtenerContexto()
{
	var url = document.URL;
	var tmp = url.split("/PIZELE_WEB");
	return tmp[0];
}


function print()     
{
	// console.log($("#divPrincipal").html());
	$("#divPrincipal").jqprint();    
}      

function obtenerValorVistaControl(ctrl)
{
	if($(ctrl).is('select'))	
		return $(ctrl).children('option:selected').text();	
	else	
		return $(ctrl).val();
}

function executeActionForm(validar, form, accion, parametros)
{
	var esValido = true;
	
	if(validar == 'S')
	{
		esValido = $("#" + form).validationEngine('validate');
	}
	
	if(esValido)
	{
		document.getElementById(form).action = accion + '.do' + parametros;
		document.getElementById(form).submit();
	}
}

function executeActionForm_Confirm(validar, form, accion, parametros, msg)
{
	var esValido = true;
	
	if(validar == 'S')
	{
		esValido = $("#" + form).validationEngine('validate');
	}
	
	if(esValido)
	{
		if(confirm(msg))
		{
			document.getElementById(form).action = accion + '.do' + parametros;
			document.getElementById(form).submit();
		}
		
	}
}

function executeActionForm_Confirm2(validar, form, msg)
{
	var esValido = true;
	
	if(validar == 'S')
	{
		esValido = $("#" + form).validationEngine('validate');
	}
		
	if(esValido)
	{
		openDialogConfirm(msg);
	}
}

function cancelButton()
{
    $('#jqDialogCofirmacion').dialog('close');
};

function cancelButton2()
{
    $('#jqDialogCofirmacion2').dialog('close');
};

function cancelEjecutar()
{
    $('#jqDialogPregunta').dialog('close');
};

function executeActionFormRedirect(form, accion, idCodigo, valor)
{
		document.getElementById(idCodigo).value = valor;
		document.getElementById(form).action = accion + '.do';
		document.getElementById(form).submit();

}

function openDialogConfirm(msg)
{
	var contenido = '<p><span class=\"ui-icon ui-icon-circle-check\" style=\"float:left; margin:0 7px 7px 0;\"></span>';
	contenido = contenido + msg;
	contenido = contenido + '</p>';
	$('#jqDialogCofirmacion').html(contenido);
	$('#jqDialogCofirmacion').dialog('open');
}

function openDialogConfirm2(msg)
{
	var contenido = '<p><span class=\"ui-icon ui-icon-circle-check\" style=\"float:left; margin:0 7px 7px 0;\"></span>';
	contenido = contenido + msg;
	contenido = contenido + '</p>';
	$('#jqDialogCofirmacion2').html(contenido);
	$('#jqDialogCofirmacion2').dialog('open');
}

function openDialogPregunta(msg)
{
	var contenido = '<p><span class=\"ui-icon ui-icon-circle-check\" style=\"float:left; margin:0 7px 7px 0;\"></span>';
	contenido = contenido + msg;
	contenido = contenido + '</p>';
	$('#jqDialogPregunta').html(contenido);
	$('#jqDialogPregunta').dialog('open');
}

function openDialogError(msg)
{
	var contenido = '<p><span class=\"ui-icon ui-icon-alert\" style=\"float:left; margin:0 7px 7px 0;\"></span>';
	contenido = contenido + msg;
	contenido = contenido + '</p>';
	$('#jqDialogError').html(contenido);
	$('#jqDialogError').dialog('open');
}

function openDialogWarning(msg)
{
	var contenido = '<p><span class=\"ui-icon ui-icon-info\" style=\"float:left; margin:0 7px 7px 0;\"></span>';
	contenido = contenido + msg;
	contenido = contenido + '</p>';
	$('#jqDialogWarning').html(contenido);
	$('#jqDialogWarning').dialog('open');
}

function openDialogInfo(msg)
{
	var contenido = '<p><span class=\"ui-icon ui-icon-comment\" style=\"float:left; margin:0 7px 7px 0;\"></span>';
	contenido = contenido + msg;
	contenido = contenido + '</p>';
	$('#jqDialogInfo').html(contenido);
	$('#jqDialogInfo').dialog('open');
}

function closeDialogError()
{
	$('#jqDialogError').dialog('close');
}

function closeDialogWarning()
{
	$('#jqDialogWarning').dialog('close');
}

function closeDialogInfo()
{
	$('#jqDialogInfo').dialog('close');
}

function closeDialogConfirm()
{
	$('#jqDialogCofirmacion').dialog('close');
}

function closeDialogConfirm2()
{
	$('#jqDialogCofirmacion2').dialog('close');
}

function closeDialogPregunta()
{
	$('#jqDialogPregunta').dialog('close');
}


