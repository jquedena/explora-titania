validar = function() {
	return true;
};

guardar = function() {
	
};

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

click_guardar = function() {
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

		indexRow = $("#ctblPiso").val();
		row = {};
		ids = $("#tblPiso").jqGrid('getDataIDs');
		gsr = $("#tblPiso").jqGrid('getGridParam', 'selrow');
		
		if(gsr){
			row = $("#tblPiso").jqGrid('getRowData', gsr);
		}
		nro=jQuery("#tblPiso").getDataIDs().length;
		console.log(nro);
		indexRow = $("#ctblPiso").val();
		var actual= new Date();
	    var anyo= actual.getUTCFullYear();
	    
		row = $.extend(row, {
				idsigma: $("#txt_idsigma").val(),
				cnitems: '05',
				cnitems: $("#txt_idsigma").val(),
				dpredio: $("#_dpredio").val(),
				cnumpis: $("#txt_pisonivel").val(),
				canocon: $("#txt_pisoanocon").val(),
				nantigu: anyo - $("#txt_pisoanocon").val(),
				cmescon: $("#txt_pisomescon").val(),
				cmateri: $("#txt_pisodmaterial").val(),       
				cconser: $("#txt_pisodestado").val(),
				cmurcol: $("#txt_pisodmuro").val(),     
				ctechos: $("#txt_pisodtecho").val(),
				cmpisos: $("#txt_pisodpisos").val(),    
				cpueven: $("#txt_pisodpuertaventana").val(),
				crevest: $("#txt_pisorevestimiento").val(),      
				cbanios: $("#txt_pisodbanio").val(),
				celectr: $("#txt_pisodinstalaciones").val(),       
				narecon: $("#txt_pisoarecon").val(),
				nvaluni: $("#txt_pisovaluni").val(),
				nincrem: $("#txt_pisoincrem").val(),
				npordep: $("#txt_pisopordep").val(),      
				ndepred: $("#txt_pisodepred").val(),
				nvalare: $("#txt_pisovalare").val(),      
				narecom: $("#txt_pisoarecom").val(),
				nporcom: $("#txt_pisoporcom").val(),
				nvalcom: $("#txt_pisovalcom").val(),
				nvalpis: $("#txt_valpre").val(),
				nestado: '1'
		});
		console.log(row);
	
		_post = $.post(path + "registro/guardarpiso", row);
	    _post.success(function(data){
	    	optionPiso = $.extend(optionPiso, {data: data.data});
	    	procesarJSON("panelPiso", "tblPiso", optionPiso, null, function(){
	         $("#tblPiso").jqGrid('navGrid', '#ptblPiso', {edit:false, add:false, del:false, search:false, refresh:false});
	            $("#tblPiso").jqGrid('navButtonAdd', '#ptblPiso', btnInsertarPiso);
	            $("#tblPiso").jqGrid('navSeparatorAdd','#ptblPiso');
	            $("#tblPiso").jqGrid('navButtonAdd','#ptblPiso', btnEditarPiso);
	            $("#tblPiso").jqGrid('navSeparatorAdd','#ptblPiso');
	            $("#tblPiso").jqGrid('navButtonAdd','#ptblPiso', btnEliminarPiso);
	        });
		});
	    _post.error(postError);
	};
*/