validar = function() {
	return true;
};

guardar = function() {
	indexRow = $("#ctblPiso").val();
	gsr = $("#tblPiso").jqGrid('getGridParam', 'selrow');
	row = {};
	
	if(gsr){
		row = $("#tblPiso").jqGrid('getRowData', gsr);
	}
	    
	row = {
			idsigma: $("#txt_idsigma").val(),
			cnitems: $("#txt_idsigma").val(),
			dpredio: $("#_dpredio").val(),
			cnumpis: $("#txt_pisonivel").val(),
			canocon: $("#txt_pisoanocon").val(),
			cmescon: $("#txt_pisomescon").val(),
			cmateri: $("#txt_cdmaterial").val(),       
			cconser: $("#txt_cdestado").val(),
			cmurcol: $("#txt_cdmuro").val(),     
			ctechos: $("#txt_cdtecho").val(),
			cmpisos: $("#txt_cdpisos").val(),    
			cpueven: $("#txt_cdpuertaventana").val(),
			crevest: $("#txt_cdrevestimiento").val(),      
			cbanios: $("#txt_cdbanio").val(),
			celectr: $("#txt_cdinstalaciones").val(),		
			narecon: $("#txt_pisoarecon").val(),      
			narecom: $("#txt_pisoarecom").val(),
			nporcom: $("#txt_pisoporcom").val(),
			nestado: '1'
	};

	console.log(row);
	
	_post = $.post(path + "registro/guardarpiso", row);
    _post.success(function(data){
    	optionPiso = $.extend(optionPiso, {data: data.data});
    	procesarJSON("panelPiso", "tblPiso", optionPiso, null, navPanelPiso);
	});
    _post.error(postError);	
};

selectAutocomplete = function( event, ui ) {
	desc = "#d" + $(this).attr("id");
	idsm = "#c" + $(this).attr("id");
	
	$(idsm).val(ui.item.idsigma);
	$(desc).html(ui.item.desc);
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

click_guardar = function() {
	guardar();
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

/*
$("#btnguardar").button({
        icons: {primary:'ui-icon-disk'}
    }).bind('click', function(){
    	isValid = true;
    	
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
		}
    });
	
	$("#btncancelar").button({
		icons: {primary:'ui-icon-pencil'}
	}).bind('click', function(){
		closeDialog('jqDialog1');
	});

	GuardarPiso = function() {

		
	};
*/