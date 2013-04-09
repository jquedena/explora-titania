validar = function() {
	isValid = true;
	
	/*$("#formPiso").find("input").each(function() {
		if($(this).val().length ==0) {
			isValid = false;
       		return;
   		}
	});*/
	
	if ($("#txt_pisonivel").val()=='9999999999'){
		alert("Ingrese el Nivel del Piso");
		isValid = false;
		return false;
	}
	
	if ($("#txt_pisoanocon").val()==''){
		alert("Ingrese el A\xf1o del Piso");
		isValid = false;
		$("#txt_pisoanocon").focus();
		return false;
	}
	
	if ($("#txt_pisomescon").val()==''){
		alert("Ingrese el Mes de la Construccion");
		isValid = false;
		$("#txt_pisomescon").focus();
		return false;
	}
	
	if ($("#ctxt_cmateri").val()==''){
		alert("Ingrese la materia Construccion");
		isValid = false;
		$("#txt_cmateri").focus();
		return false;
	}
	
	if ($("#ctxt_cconser").val()==''){
		alert("Ingrese el estado de la Conservacion");
		isValid = false;
		$("#txt_cconser").focus();
		return false;
	}
	
	if ($("#ctxt_cmurcol").val()==''){
		alert("Ingrese el estado de Muros y Columnas");
		isValid = false;
		$("#txt_cmurcol").focus();
		return false;
	}
	
	if ($("#ctxt_ctechos").val()==''){
		alert("Ingrese el estado de Techo");
		isValid = false;
		$("#txt_ctechos").focus();
		return false;
	}
	
	if ($("#ctxt_cmpisos").val()==''){
		alert("Ingrese el estado de Piso");
		isValid = false;
		$("#txt_cmpisos").focus();
		return false;
	}
	
	if ($("#ctxt_crevest").val()==''){
		alert("Ingrese el Revestimiento");
		isValid = false;
		$("#txt_crevest").focus();
		return false;
	}
	
	if ($("#ctxt_cpueven").val()==''){
		alert("Ingrese el Revestimiento del Puertas y Ventanas");
		isValid = false;
		$("#txt_cpueven").focus();
		return false;
	}
	
	
	if ($("#ctxt_cbanios").val()==''){
		alert("Ingrese el Ba\xf1os");
		isValid = false;
		$("#txt_cbanios").focus();
		return false;
	}
	
	if ($("#ctxt_celectr").val()==''){
		alert("Ingrese Instalaciones Electricas");
		isValid = false;
		$("#txt_celectr").focus();
		return false;
	}
	
	if ($("#txt_pisoarecon").val()==''){
		alert("Ingrese Area Construccion");
		isValid = false;
		$("#txt_pisoarecon").focus();
		return false;
	}
	
	
	if(!isValid) {
			openDialogWarning("Los campos deben estar llenos.", 380, 150);	
			return false;
	} else {
		/*GuardarPiso();
		openDialogWarning("Los datos han sido guardados.", 380, 150);
		closeDialog('jqDialog1');*/
		return true;
	}

// navPanelPiso()	
	//return true;
};

guardar = function() {
	//debugger;
	
	
	
	
	row = {
			idsigma: $("#txt_idsigma").val(),
			cnitems: 0,
			dpredio: $("#_dpredio").val(),
			cnumpis: $("#txt_pisonivel").val(),
			canocon: $("#txt_pisoanocon").val(),
			cmescon: $("#txt_pisomescon").val(),
			cmateri: $("#ctxt_cmateri").val(),       
			cconser: $("#ctxt_cconser").val(),
			cmurcol: $("#ctxt_cmurcol").val(),     
			ctechos: $("#ctxt_ctechos").val(),
			cmpisos: $("#ctxt_cmpisos").val(),    
			cpueven: $("#ctxt_cpueven").val(),
			crevest: $("#ctxt_crevest").val(),      
			cbanios: $("#ctxt_cbanios").val(),
			celectr: $("#ctxt_celectr").val(),		
			narecon: $("#txt_pisoarecon").val(),      
			narecom: $("#txt_pisoarecom").val(),
			nporcom: $("#txt_pisoporcom").val(),
			nestado: 1,
			cperiod: $("#txtPeriodo").val(),
			cclasif: $("#cboClasificacion option:selected").val() + $("#txt_cmateri").val() + $("#txt_cconser").val(),
			caracte: $("#txt_cmurcol").val()+        
				     $("#txt_ctechos").val()+        
				     $("#txt_cmpisos").val()+        
				     $("#txt_cpueven").val()+        
				     $("#txt_crevest").val()+        
				     $("#txt_cbanios").val()+        
				     $("#txt_celectr").val(),
			//Detalle Piso
			nvaluni:$("#txt_pisovaluni").val(),
			nincrem:$("#txt_pisoincrem").val(),
			npordep:$("#txt_pisopordep").val(),
			ndepred:$("#txt_pisodepred").val(),
			nvalare:$("#txt_pisovalcom").val(),
			nvalcom:$("#txt_pisoarecom").val(),
			nvalpis:$("#txt_valpre").val()
			
	};

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
	if(validar()) {
		guardar();
		click_closeDialog();
	}
	
};


$(function() {
	themeTextBox();
	
	_post = $.post(path + "registro/verpisocaracteristicas", {}, function(data){
		autocompletar("#txt_cmateri", data.material, selectAutocomplete);
		autocompletar("#txt_cconser", data.estado, selectAutocomplete);
		autocompletar("#txt_cmurcol", data.muro, selectAutocomplete);
		autocompletar("#txt_ctechos", data.techo, selectAutocomplete);
		autocompletar("#txt_cmpisos", data.piso, selectAutocomplete);
		autocompletar("#txt_cpueven", data.puerta, selectAutocomplete);
		autocompletar("#txt_crevest", data.revestimiento, selectAutocomplete);
		autocompletar("#txt_cbanios", data.banio, selectAutocomplete);
		autocompletar("#txt_celectr", data.instalacion, selectAutocomplete);
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