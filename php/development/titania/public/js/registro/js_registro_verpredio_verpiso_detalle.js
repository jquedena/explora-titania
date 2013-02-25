selectAutocomplete = function( event, ui ) {
	name = "#d" + $(this).attr("id");
	$(name).html(ui.item.desc);
	$(this).val(ui.item.label);
	return false;
};

blur_lpad2 = function() {
	$(this).val(LPad($(this).val(), 2, '0'));
};

blur_lpad4 = function() {
	$(this).val(LPad($(this).val(), 4, '0'));
};

click_closeDialog = function() {
	closeDialog('jqDialog1');
};

click_guardar = function(){
	/*isValid = true;
		
		$("#formPiso").find("input").each(function() {
			if($(this).val().length ==0) {
				isValid = false;
	       		return;
	   		}
		});
		
		if(!isValid) {
				openDialogWarning("Los campos deben estar llenos.", 380, 150);	
		} else {
			GuardarPiso();
			//openDialogWarning("Los datos han sido guardados.", 380, 150);
			closeDialog('jqDialog1');
		}*/
	
	// navPanelPiso()
};


$(function() {
	themeTextBox();
	
	_post = $.post(path + "registro/verpisocaracteristicas", {}, function(data){
		autocompletar("#txt_pisomaterial", data.material, selectAutocomplete);
		autocompletar("#txt_pisoestado", data.estado, selectAutocomplete);
		autocompletar("#txt_pisomuro", data.muro, selectAutocomplete);
		autocompletar("#txt_pisotecho", data.techo, selectAutocomplete);
		autocompletar("#txt_pisopisos", data.piso, selectAutocomplete);
		autocompletar("#txt_pisopuertaventana", data.puerta, selectAutocomplete);
		autocompletar("#txt_pisorevestimiento", data.revestimiento, selectAutocomplete);
		autocompletar("#txt_pisobanio", data.banio, selectAutocomplete);
		autocompletar("#txt_pisoinstalaciones", data.instalacion, selectAutocomplete);
	}, 'json');
    _post.error(postError);
	
    themeTextBox();
    
    $("#txt_pisonivel").bind('blur', blur_lpad2);
    $("#txt_pisoanocon").bind('blur', blur_lpad4);
    $("#txt_pisomescon").bind('blur', blur_lpad2);
    
	$("#btnguardar").button(ICON_SAVE).bind('click', click_guardar);
	$("#btncancelar").button(ICON_CANCEL).bind('click', click_closeDialog);
	
	$(".panel-valor-construccion .ui-text-numeric").autoNumeric();
	$(".panel-detalle-construccion .ui-text-numeric").autoNumeric({mDec: 0, aPad: false});
	$("input:submit, input:button, input:reset, button").button();
});	