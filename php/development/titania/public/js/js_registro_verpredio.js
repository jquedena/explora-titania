habilitarComponenteDetalle = function(disabled){
    $(".ui-text, .ui-combobox-input").attr("disabled", disabled);
    $(".ui-text, .ui-combobox-input").toggleClass("ui-state-disabled-text");
    $(".ui-combobox a").button("option", "disabled", disabled);
    $("#dtpFechaAdquisicion, #dtpFechaTransferencia, #dptFechaResolucionInafecto").datepicker("option", "disabled", disabled);
    $("#btnGrabarPredio").button("option", "disabled", disabled);
    
    if($("#cboCondicion").val() == "1000000145"){
        $("#btnVerCondominante").button("option", "disabled", disabled);
        $("#nporcen").attr("disabled", disabled);
        $("#nporcen").toggleClass("ui-state-disabled-text");
    } else {
        if(!disabled) {
            $("#nporcen").attr("disabled", true);
            $("#nporcen").toggleClass("ui-state-disabled-text"); 
        }
    }
    
    $("#btnEditarPredio").button("option", "disabled", !disabled);
    $("#txtPeriodo").toggleClass("ui-state-disabled-text");

    if(disabled) {
        $("#linkPeriodo").button("option", "disabled", false);
        $("#txtPeriodo").attr("disabled", false);
        
        var hEd = CKEDITOR.instances['txtObservacionInafectacion'];
        if (hEd) {
            CKEDITOR.remove(hEd);
        }
    } else {
        CKEDITOR.replace('txtObservacionInafectacion', config);
    }
};

cambioTipoPredio = function(event, ui) {
    if(ui.item) {
        bVisible = (ui.item.option.value == "1000000091");
        visibility = (bVisible? "hidden": "visible");
        display = (bVisible? "inline": "none");
        $("#panelTerreno").css({"visibility" : visibility});
        $("#tabPredioRustico").css({"display" : display});
        
        contenidocomboContenedor("#cboTipoPredioUrbano", (bVisible ? "1000000209": "1000000202"));
    } else {
        openDialogWarning("El valor ingresado no esta en la lista de elementos.", 380, 150);
    }
};

cambioTipoUso = function(event, ui) {
    if(ui.item) {
    } else {
        openDialogWarning("El valor ingresado no esta en la lista de elementos.", 380, 150);
    }
};

cambioCondicion = function(event, ui) {
    if(ui.item) {
        disable = !(ui.item.option.value == "1000000145");
        $("#btnVerCondominante").button("option", "disabled", disable);
        $("#nporcen").attr("disabled", disable);
        $("#nporcen").toggleClass("ui-state-disabled-text");
    } else {
        openDialogWarning("El valor ingresado no esta en la lista de elementos.", 380, 150);
    }
};

var periodoSel = ''; 

cambioPeriodo = function(event, ui) {
	if(ui.item) {
		if(periodoSel != ui.item.option.value) {
	        parameters = {
	            "mperson": $("#lblCodigo").text(),
	            "vnombre": $("#lblNombre").text(),
	            "vdirecf": $("#lblDireccion").text(),
	            "mpredio": $("#_mpredio").val(),
	            "mhresum": $("#_mhresum").val(),
	            "cperiod": ui.item.option.value
	        };
	        _post = $.post(path + "registro/verpredio", parameters);
	        _post.error(postError);
	        _post.success(function(request){
	            $("#panelRegistro").html(request);
	        });
		}
        periodoSel = ui.item.option.value;
	} else {
		openDialogWarning("El valor ingresado no esta en la lista de elementos.", 380, 150);
	}
};

loadVerDetalle = function(){
    tabs = $("#tabsDetallePredio").tabs();

    $(".ui-text-numeric").numeric({
        decimal: '.',
        negative: false
    }, function() {
        openDialogWarning("Solo Numeros Positivos.", 150, 90);
        this.value = "";
        this.focus();
    });

    $("#nnrohab").numeric({
        decimal: false,
        negative: false
    }, function() {
        openDialogWarning("Solo Numeros Enteros Positivos.", 150, 90);
        this.value = "";
        this.focus();
    });

    themeTextBox("#panelRegistro .ui-text");
    themeComboBox("#panelRegistro select");
    habilitarComponenteDetalle(true);
    
    $("#txtTipoPredio").bind("autocompleteselect", cambioTipoPredio);
    $("#txtTipoPredio").bind("autocompletechange", cambioTipoPredio);

    $("#txtUso").bind("autocompleteselect", cambioTipoUso);
    $("#txtUso").bind("autocompletechange", cambioTipoUso);

    $("#txtCondicion").bind("autocompleteselect", cambioCondicion);
    $("#txtCondicion").bind("autocompletechange", cambioCondicion);

    $("#txtPeriodo").attr("maxlength", 4);
    $("#txtPeriodo").bind("autocompleteselect", cambioPeriodo);
    $("#txtPeriodo").bind("autocompletechange", cambioPeriodo);
    periodoSel = $("#txtPeriodo").val();
    
    $("#dtpFechaAdquisicion, #dtpFechaTransferencia, #dptFechaResolucionInafecto").datepicker({
        dateFormat: "dd/mm/yy",
        showOn: "button",
        buttonImage: pathImage + "calendar.gif",
        buttonImageOnly: true
    });

    $("#btnVerCondominante").button({
        text: false,
        icons: {primary:'ui-icon-search'},
        disabled: true
    }).bind("click", function(){
        openDialogData1("registro/condominio", {}, "725", "405", "Registro de Condomimantes");
    });

    $("#btnBuscarDireccion").button({
        text: false,
        icons: {primary:'ui-icon-search'}
    }).bind("click", function(){
        openDialogData1("registro/direccion", {}, "710", "180", "Ubicaci&oacute;n del Predio");
    });

    $("#btnEditarPredio").button({
        icons: {primary:'ui-icon-pencil'}
    }).bind('click', function(){
        habilitarComponenteDetalle(false);
    });

    $("#btnGrabarPredio").button({
        icons: {primary:'ui-icon-disk'},
        disabled: true
    }).bind('click', function(){
        openDialogData1("registro/declaracion", {}, "700", "490", "Declaraci&oacute;n Jurada");
    });

    $("#btnCancelarPredio").button({
        icons: {primary:'ui-icon-arrowreturnthick-1-w'}
    }).bind('click', function(){
        location.href = path + "registro";
    });

    $("#btnValorPredio").button({
        icons: {primary:'ui-icon-calculator'}
    }).bind('click', function(){
        // location.href = path + "registro";
        alert('ver valores del predio');
    });
    
    actualizarGrid("tblPiso", optionPiso, null, function(){
        $("#tblPiso").jqGrid('navGrid', '#ptblPiso', {edit:false, add:false, del:false, search:false, refresh:false});
        $("#tblPiso").jqGrid('navButtonAdd', '#ptblPiso', btnInsertarPiso);
        $("#tblPiso").jqGrid('navSeparatorAdd','#ptblPiso');
        $("#tblPiso").jqGrid('navButtonAdd','#ptblPiso', btnEditarPiso);
        $("#tblPiso").jqGrid('navSeparatorAdd','#ptblPiso');
        $("#tblPiso").jqGrid('navButtonAdd','#ptblPiso', btnEliminarPiso);
    });

    actualizarGrid("tblInstalacion", optionInstalacion, null, function(){
        $("#tblInstalacion").jqGrid('navGrid', '#ptblInstalacion', {edit:true, add:true, del:true, search:false, refresh:false});
        // $("#tblInstalacion").jqGrid('navButtonAdd','#ptblInstalacion', btnInsertarPiso);
        // $("#tblInstalacion").jqGrid('navSeparatorAdd','#ptblInstalacion');
        // $("#tblInstalacion").jqGrid('navButtonAdd','#ptblInstalacion', btnEditarPiso);
        // $("#tblInstalacion").jqGrid('navSeparatorAdd','#ptblInstalacion');
        // $("#tblInstalacion").jqGrid('navButtonAdd','#ptblInstalacion', btnEliminarPiso);
    });
};

config = {
    skin:'v2'
    , toolbar: [
        ['Bold','Italic','Underline','-','NumberedList','BulletedList','-','Outdent','Indent','-','Undo','Redo','-','HorizontalRule','-','Blockquote','CreateDiv'],
        ['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock','-','TextColor','BGColor'],
        ['UIColor']
    ]
};