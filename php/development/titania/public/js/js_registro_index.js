verContribuyentePredio = function(rowid) {  
    if(typeof rowid == 'object') {
        parameters = rowid[0];
    } else {
        parameters = $(this).getRowData(rowid);
    }
    
    parameters = $.extend(parameters, {
    	mhresum: $("#mhresum").val(),
    	vnrodoc: $("#vnrodoc").val()
    });

    _post = $.post(path + "registro/listarpredio", parameters);
    _post.error(postError);
    _post.success(function(request){
        $("#panelRegistro").html(request);
    });
};

verDetalle = function(rowid) {
	row = $("#tblResult").jqGrid('getRowData', rowid);
	ajaxDialog = false;
	panelPersona(row);
};

gridCompleteTblResult = function(){
	var ids = $("#tblResult").jqGrid('getDataIDs');
	for(var i=0; i < ids.length; i++){ 
		id = ids[i]; 
		bt = "<a style='height:20px;width:20px;' class='btnGrid' href='javascript: void(0);' onclick=\"verDetalle('"+id+"');\"><img src='" + pathImage + "find.png'/></a>";
		$("#tblResult").jqGrid('setRowData', ids[i], {modedit: bt});
	}
}

optionContribuyente = {
    // height: 290,
	// gridComplete: gridCompleteTblResult,
	// hoverrows: 0,
    width: 1000,
    colNames: [/*"", */"C\u00F3digo", "Administrado", "Direcci\u00F3n Fiscal"],
    colModel: [
        // {name:'modedit', index:'modedit', width:22, align: 'center'},
        {name:'cidpers', index:'cidpers', width:80, align: 'center'},
        {name:'crazsoc', index:'crazsoc', width:420},
        {name:'direccf', index:'direccf', width:420} ],
    caption: "&nbsp;&nbsp;&nbsp;Resultados de la busqueda",
    onSelectRow: verDetalle,
    ondblClickRow: verContribuyentePredio
};
bindkeysContribuyente = {"onEnter": verContribuyentePredio};

verViaPredio = function(rowid){
    row = $("#tblResult").jqGrid('getRowData', rowid);
    parameters = {
        "mperson": row.mperson,
        "vnombre": row.vnombre,
        "vdirecf": row.vdirecf,
        "mpredio": row.mpredio
    };
    _post = $.post(path + "registro/verpredio", parameters);
    _post.error(postError);
    _post.success(function(request){
        $("#panelRegistro").html(request);
    });
};

optionViaPredio = {
    height: 290,
    width: 1000,
    colNames: ['C\u00F3digo',
        'Administrado',
        'Predio',
        'Direcci\u00F3n',
        'Uso',
        'Valor del Predio',
        'Valor Afecto',
        'Adquirido',
        'Nro. de Doc.',
        '% Prop.',
        'mpredio',
        'tnompob',
        'tnomvia',
        'dnumero',
        'ddepart',
        'dmanzan',
        'dnlotes',
        'Direcci\u00F3n Fiscal'],
    colModel: [
        {name: 'mperson', index:'mperson', width: 70, align: 'center', frozen: true},
        {name: 'vnombre', index:'vnombre', width: 250, frozen: true},
        {name: 'ccodpre', index:'ccodpre', width: 70, align: 'center', frozen: true},
        {name: 'tnumero', index:'tnumero', width: 450}, // , frozen: true
        {name: 'cusogen', index:'cusogen', width: 250},
        {name: 'nvalpre', index:'nvalpre', width: 100, formatter:'currency', align: 'right'},
        {name: 'nvalafe', index:'nvalafe', width: 100, formatter:'currency', align: 'right'},
        {name: 'dfecadq', index:'dfecadq', width: 80, formatter:'date', formatoptions: {srcformat:"Y-m-d", newformat:"d-M-Y"}, align: 'center'},
        {name: 'vnrodoc', index:'vnrodoc', width: 80, align: 'center'},
        {name: 'nporcen', index:'nporcen', width: 60, align: 'right'},
        {name: 'mpredio', index:'mpredio', width: 1, hidden: true},
        {name: 'tnompob', index:'tnompob', width: 1, hidden: true},
        {name: 'tnomvia', index:'tnomvia', width: 1, hidden: true},
        {name: 'dnumero', index:'dnumero', width: 1, hidden: true},
        {name: 'ddepart', index:'ddepart', width: 1, hidden: true},
        {name: 'dmanzan', index:'dmanzan', width: 1, hidden: true},
        {name: 'dnlotes', index:'dnlotes', width: 1, hidden: true},
        {name: 'vdirecf', index:'vdirecf', width: 250, frozen: true}],
    caption: "&nbsp;&nbsp;&nbsp;Predios Registrados",
    /*onSelectRow: function(id) {
        row = $(this).getRowData(id);
        console.log(row);
    },*/
    ondblClickRow: verViaPredio
};
bindkeysViaPredio = {"onEnter": verViaPredio};

buscarPredio = function() {
    parameters = {
        "name": "tblResult",
        "procedure": "pl_function.buscar_predio",
        "parameters": '{' +
        '"p_ccodpre":"' + $("#c_predial").val().toUpperCase() + '",' +
        '"p_ccodvia":"' + ccodvia.toUpperCase() + '",' +
        '"p_cnrovia":"' + $("#c_nroviacontrib").val().toUpperCase() + '",' +
        '"p_cmanzan":"' + $("#c_mzacontrib").val().toUpperCase() + '",' +
        '"p_cnrlote":"' + $("#c_lotecontrib").val().toUpperCase() + '"' +
        '}'
    };

    proceso = function(requestData){
        $("#panelResult").html(requestData);
        records = $("#ctblResult").val();
        if(records == 0) {
            inicializarGrid("tblResult", optionViaPredio);
            buttons = {
                "Aceptar": function(){
                    closeDialog("jqDialogInfo");
                    $('#c_codigocontrib').focus();
                }
            }
            openDialogInfo("No existen predios con los criterios de busqueda ingresados.", 380, 150, buttons);
        } else if(records > 1) {
            actualizarGrid("tblResult", optionViaPredio, bindkeysViaPredio);
        } else {
            // verContribuyentePredio();
            alert('Un predio');
        }
    };

    procesarConsultaSubProceso('registrar', parameters, proceso);
};

buscarContribuyente = function() {    
    parameters = {
        "name": "tblResult",
        "procedure": "public.buscar_persona",
        "print": "true",
        "parameters": '{' +
        '"p_nvar1":"' + $("#c_codigocontrib").val().toUpperCase() + '",' +
        '"p_nvar2":"' + $("#c_nombrecontrib").val().toUpperCase() + '",' +
        '"p_nvar3":"' + $("#c_apepatcontrib").val().toUpperCase() + '",' +
        '"p_nvar4":"' + $("#c_apematcontrib").val().toUpperCase() + '",' +
        '"p_nvar5":""' +
        '}'
    };

    proceso = function(requestData){
    	$("#panelResult").html('<table id="tblResult"></table><div id="ptblResult"></div><input type="hidden" id="ctblResult" name="ctblResult" value="" />');
    	records = requestData.length;
    	options = $.extend(optionContribuyente, {
			data: requestData,
	        datatype: "local"
    	});
        if(records == 0) {
            inicializarGrid("tblResult", options);
            buttons = {
                "Aceptar": function(){
                    closeDialog("jqDialogInfo");
                    $('#c_codigocontrib').focus();
                }
            }
            openDialogInfo("No existen contribuyentes con los criterios de busqueda ingresados.", 380, 150, buttons);
        } else if(records > 1) {
        	inicializarGrid("tblResult", options, bindkeysContribuyente);
        } else {
            verContribuyentePredio(requestData);
        }
    };

    procesarConsultaSubProceso('registrar', parameters, proceso, 'json');
};

$(function(){
    $("#c_codigocontrib").numeric({
        decimal: false, 
        negative: false
    }, function() {
        openDialogWarning("Solo Numeros Enteros Positivos.", 150, 90);
        this.value = "";
        this.focus();
    });
    
    $("#btnbuscar").button("option", "icons", {
        primary:'ui-icon-search'
    });
   
    inicializarGrid("tblResult", optionContribuyente);
    
    $("#panelContribuyente").on("keyup", "input", function(e) {
        if(e.keyCode == 13){
            $("#btnbuscar").click();
        }
    });
    
    $("#panelPredio").on("keyup", "input", function(e) {
        if(e.keyCode == 13){
            $("#btnbuscar").click();
        }
    });
    
    $("#c_codigocontrib, #c_predial").on("focus", function() {
        $("#panelContribuyente input.ui-text").val("");
        $("#panelPredio input.ui-text").val("");
    });
    
    $(".pnl").on("focus", function() {
        $("#c_codigocontrib").val("");
        $("#c_predial").val("");
    });
    
    $("#btnbuscar").click(function(){
        valid = [false, false];
    
        if(trim($('#c_codigocontrib').val()).length > 0){
            $('#c_codigocontrib').val(LPad($('#c_codigocontrib').val(), 10, '0'));
        }

        valid[0] = valid[0] || (trim($("#c_nombrecontrib").val()).length > 0);
        valid[0] = valid[0] || (trim($("#c_apepatcontrib").val()).length > 0);
        valid[0] = valid[0] || (trim($("#c_apematcontrib").val()).length > 0);
        valid[0] = valid[0] || (trim($("#c_codigocontrib").val()).length > 0);

        if(trim($('#c_predial').val()).length > 0){
            $('#c_predial').val(LPad($('#c_predial').val(), 10, '0'));
        }

        valid[1] = valid[1] || (trim($("#c_predial").val()).length > 0);
        valid[1] = valid[1] || (trim($("#c_viacontrib").val()).length > 0);
        valid[1] = valid[1] || (trim($("#c_nroviacontrib").val()).length > 0);
        valid[1] = valid[1] || (trim($("#c_mzacontrib").val()).length > 0);
        valid[1] = valid[1] || (trim($("#c_lotecontrib").val()).length > 0);
    
        if(valid[0]) {
            buscarContribuyente();
        } else if(valid[1]) {
            buscarPredio();
        } else {
            openDialogWarning("Ingrese un valor en los campos de busqueda.", 380, 150);
        }
    });
    $("#c_codigocontrib").focus();
});