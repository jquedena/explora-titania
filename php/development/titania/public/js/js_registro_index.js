habilitarComponenteDetalle = function(disabled){
    $(".ui-text, .ui-combobox-input").attr("disabled", disabled);
    $(".ui-text, .ui-combobox-input").toggleClass("ui-state-disabled-text");
    $(".ui-combobox a").button("option", "disabled", disabled);
    $("#btnGrabarPredio").button("option", "disabled", disabled);
    $("#btnVerCondominante").button("option", "disabled", disabled);
    $("#btnEditarPredio").button("option", "disabled", !disabled);
    $("#txtPeriodo").toggleClass("ui-state-disabled-text");
    
    if(disabled){
        $("#linkPeriodo").button("option", "disabled", false);
        $("#txtPeriodo").attr("disabled", false);
    }
};

loadVerDetalle = function(){
    $("#tabsDetallePredio").tabs();

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
    $("#txtPeriodo").attr("maxlength", 4);

    $("#dtpFechaAdquisicion, #dtpFechaDescargo").datepicker({
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
        // openDialogData1("registro/direccion", {}, "700", "185", "Ubicaci&oacute;n del Predio");
    });

    $("#btnBuscarDireccion").button({
        text: false,
        icons: {primary:'ui-icon-search'}
    }).bind("click", function(){
        openDialogData1("registro/direccion", {}, "700", "185", "Ubicaci&oacute;n del Predio");
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
    
    parametersPiso = {
        "name": "tblPiso",
        "procedure": "pl_function.listar_construccion",
        "parameters": '{"p_dpredio":"' + '---' + '"}'
    };
    procesarProcedimiento("panelPiso", "tblPiso", optionPiso, parametersPiso);
    $("#tblPiso").jqGrid('navGrid','#ptblPiso',{edit:true, add:true,del:true});
    
    parametersInstalacion = {
        "name": "tblInstalacion",
        "procedure": "pl_function.listar_instalacion",
        "parameters": '{"p_dpredio":"' + '---' + '"}'
    };
    procesarProcedimiento("panelInstalacion", "tblInstalacion", optionInstalacion, parametersInstalacion)
};

verContribuyentePredio = function(rowid) {   
    if(rowid == undefined || rowid == null) {
        parameters = {"name": "tblResult"};
    } else {
        parameters = $(this).getRowData(rowid);
    }
    
    _post = $.post(path + "registro/listarpredio", parameters);
    _post.error(postError);
    _post.success(function(request){
        $("#panelRegistro").html(request);
        themeComboBox();
        $("#btnRegistrarPredio").button({
            icons: {primary:'ui-icon-document'}
        });
        $("#btnCancelarPredio").button({
            icons: {primary:'ui-icon-arrowreturnthick-1-w'}
        }).bind('click', function(){
            location.href = path + "registro";
        });
        $("#txtPeriodo").attr("maxlength", 4);
        $("#txtPeriodo").bind("autocompleteselect", function(event, ui) {
            buscarPredio(ui.item.value);
        });
        $("#txtPeriodo").bind("autocompletechange", function(event, ui) {
            if(ui.item) {
                buscarPredio(ui.item.value);
            } else {
                openDialogWarning("El valor ingresado no esta en la lista de elementos.", 380, 150);
            }
        });
        buscarPredio();
    });
};

verPredio = function(rowid, iRow, iCol, e) {
    row = $(this).getRowData(rowid);
    _post = $.post(path + "registro/verpredio", parameters);
    _post.error(postError);
    _post.success(function(request){
        $("#panelRegistro").html(request);
        loadVerDetalle();
    });
};

optionContribuyente = {
    height: 290,
    width: 1000,
    colNames: ["C\u00F3digo", "Administrado", "Direcci\u00F3n Fiscal"],
    colModel: [
        {name:'cidpers', index:'cidpers', width:80, align: 'center'},
        {name:'crazsoc', index:'crazsoc', width:420},
        {name:'direccf', index:'direccf', width:420} ],
    caption: "&nbsp;&nbsp;&nbsp;Resultados de la busqueda",
    /* onSelectRow: function(id) {
        row = $(this).getRowData(id);
        console.log(row);
    },*/
    ondblClickRow: verContribuyentePredio
};

optionPredio = {
    height: 290,
    width: 1000,
    colNames: ['C\u00F3digo',
        'Direcci\u00F3n',
        'Uso',
        'Valor del Predio',
        'Valor Afecto',
        'Adquirido',
        'Nro. de Doc.',
        '% Prop.'],
    colModel: [{name: 'ccodpre', index:'ccodpre', width: 80, frozen: true},
        {name: 'tnumero', index:'tnumero', width: 450}, // , frozen: true
        {name: 'cusogen', index:'cusogen', width: 250},
        {name: 'nvalpre', index:'nvalpre', width: 100, formatter:'currency', align: 'right'},
        {name: 'nvalafe', index:'nvalafe', width: 100, formatter:'currency', align: 'right'},
        {name: 'dfecadq', index:'dfecadq', width: 80, formatter:'date', formatoptions: {srcformat:"Y-m-d", newformat:"d-M-Y"}, align: 'center'},
        {name: 'vnrodoc', index:'vnrodoc', width: 80, align: 'center'},
        {name: 'nporcen', index:'nporcen', width: 60, align: 'right'}],
    caption: "&nbsp;&nbsp;&nbsp;Predios Registrados",
    ondblClickRow: verPredio
};

optionPiso = {
    height: 200,
    width: 990,
    rowNum: 10,
    colNames: [
        'idsigma',
        'dpredio',
        'cnitems',
        'cperiod',
        'ctipdat',
        'vnrodoc',
        'dfecdoc',
        'cmotivo',
        'ctipdoc',
        'Nivel',
        'Antig.',
        'cmescon',
        'canocon',
        'Mat.',
        'Est.',
        'Mu',
        'Te',
        'Pi',
        'Pv',
        'Rv',
        'Ba',
        'In',
        'Area Con.',
        'V. Unit. m2',
        'Inc. 5%',
        '% Depr',
        'Depr.',
        'V. Unit. Depr.',
        'Area Com.',
        '% Area Com.',
        'Val. Area Com.',
        'Val. del Piso',
        'dafecta'
    ],
    colModel: [
        {name: 'idsigma', index: 'idsigma', width: 30, hidden: true}, // Identificador de la construccion del predio
        {name: 'dpredio', index: 'dpredio', width: 30, hidden: true}, // Identificador del predio
        {name: 'cnitems', index: 'cnitems', width: 30, hidden: true}, // Nro de orden de la construccion
        {name: 'cperiod', index: 'cperiod', width: 30, hidden: true}, // Ejercicio de la declaracion jurada
        {name: 'ctipdat', index: 'ctipdat', width: 30, hidden: true}, // Tipo de ficha (1 = declaracion jurada // 2 = acta de inspeccion)
        {name: 'vnrodoc', index: 'vnrodoc', width: 30, hidden: true}, // Nro de declaracion jurada
        {name: 'dfecdoc', index: 'dfecdoc', width: 30, hidden: true}, // Fecha de la declaracion jurada
        {name: 'cmotivo', index: 'cmotivo', width: 30, hidden: true}, // Motivo de la declaracion jurada
        {name: 'ctipdoc', index: 'ctipdoc', width: 30, hidden: true}, // Tipo de documento con el que se realiza la declaracion jurada
        {name: 'cnumpis', index: 'cnumpis', width: 65, align: 'center'}, // Nro de piso
        {name: 'nantigu', index: 'nantigu', width: 65, align: 'center'}, // Antiguedad
        {name: 'cmescon', index: 'cmescon', width: 30, hidden: true}, // Mes de la construccion
        {name: 'canocon', index: 'canocon', width: 30, hidden: true}, // Periodo de Construccion
        {name: 'cmateri', index: 'cmateri', width: 40, align: 'center'}, // Material
        {name: 'cconser', index: 'cconser', width: 40, align: 'center'}, // Estado de conservacion
        {name: 'cmurcol', index: 'cmurcol', width: 40, align: 'center'}, // Muros y columnas
        {name: 'ctechos', index: 'ctechos', width: 40, align: 'center'}, // Techos
        {name: 'cmpisos', index: 'cmpisos', width: 40, align: 'center'}, // Pisos
        {name: 'cpueven', index: 'cpueven', width: 40, align: 'center'}, // Puertas y ventanas
        {name: 'crevest', index: 'crevest', width: 40, align: 'center'}, // Revestimientos
        {name: 'cbanios', index: 'cbanios', width: 40, align: 'center'}, // Sanitarios
        {name: 'celectr', index: 'celectr', width: 40, align: 'center'}, // Instalaciones electricas
        {name: 'narecon', index: 'narecon', width: 150, align: 'right'}, // Area construida
        {name: 'nvaluni', index: 'nvaluni', width: 150, align: 'right'}, // Valor unitario
        {name: 'nincrem', index: 'nincrem', width: 150, align: 'right'}, // Incremento
        {name: 'npordep', index: 'npordep', width: 150, align: 'right'}, // Porcentaje de depreciacion
        {name: 'ndepred', index: 'ndepred', width: 150, align: 'right'}, // Depreciacion
        {name: 'nvalare', index: 'nvalare', width: 150, align: 'right'}, // Valor unitario depreciado del area construida
        {name: 'narecom', index: 'narecom', width: 150, align: 'right'}, // Area comun
        {name: 'nporcom', index: 'nporcom', width: 150, align: 'right'}, // Porcentaje de area comun
        {name: 'nvalcom', index: 'nvalcom', width: 150, align: 'right'}, // Valor del area comun
        {name: 'nvalpis', index: 'nvalpis', width: 150, align: 'right'}, // Valor total del piso
        {name: 'dafecta', index: 'dafecta', width: 30, hidden: true}  // Fecha desde donde se comienzan a generar los tributos
    ],
    caption: "&nbsp;&nbsp;&nbsp;Pisos",
    ondblClickRow: function(rowid, iRow, iCol, e) {
        row = $(this).getRowData(rowid);
        console.log(row)
    }
};

optionInstalacion = {height: 200,
    width: 990,
    rowNum: 10,
    colNames: [
        'idsigma',
        'dpredio',
        'cnitems',
        'cperiod',
        'ctipdat',
        'vnrodoc',
        'dfecdoc',
        'cmotivo',
        'ctipdoc',
        'Nivel',
        'Antig.',
        'canocon',
        'Altura',
        'Ancho',
        'Largo',
        'ctipint',
        'Descripci\u00F3n',
        'Val. Inst.',
        'dafecta'
    ],
    colModel: [
        {name: "idsigma", index: "idsigma", width: 30, hidden: true}, // Identificador de la instalacion del predio
        {name: "dpredio", index: "dpredio", width: 30, hidden: true}, // Identificador del predio
        {name: "cnitems", index: "cnitems", width: 30, hidden: true}, // Nro de orden de la construccion
        {name: "cperiod", index: "cperiod", width: 30, hidden: true}, // Ejercicio de la declaracion jurada
        {name: "ctipdat", index: "ctipdat", width: 30, hidden: true}, // Tipo de ficha (1 = declaracion jurada // 2 = acta de inspeccion)
        {name: "vnrodoc", index: "vnrodoc", width: 30, hidden: true}, // Nro de declaracion jurada
        {name: "dfecdoc", index: "dfecdoc", width: 30, hidden: true}, // Fecha de la declaracion jurada
        {name: "cmotivo", index: "cmotivo", width: 30, hidden: true}, // Motivo de la declaracion jurada
        {name: "ctipdoc", index: "ctipdoc", width: 30, hidden: true}, // Tipo de documento con el que se realiza la declaracion jurada
        {name: "cnumpis", index: "cnumpis", width: 65, align: "center"}, // Nro de piso
        {name: "nantigu", index: "nantigu", width: 65, align: "center"}, // Antiguedad
        {name: "canocon", index: "canocon", width: 30, hidden: true}, // Periodo de Construccion
        {name: "nvalanc", index: "nvalanc", width: 30, hidden: true}, // Ancho de la instalacion
        {name: "nvalalt", index: "nvalalt", width: 30, hidden: true}, // Altura de la instalacion
        {name: "nvallar", index: "nvallar", width: 30, hidden: true}, // Largo de la instalacion
        {name: "ctipint", index: "ctipint", width: 30, hidden: true}, // Tipo de instalacion
        {name: "vdesint", index: "vdesint", width: 250}, // Descripcion de la instalacion
        {name: "nvalins", index: "nvalins", width: 150, align: "right"}, // Valor de la instalacion
        {name: "dafecta", index: "dafecta", width: 30, hidden: true}  // Fecha desde donde se comienzan a generar los tributos
    ],
    caption: "&nbsp;&nbsp;&nbsp;Instalaci\u00F3n",
    ondblClickRow: function(rowid, iRow, iCol, e) {
        row = $(this).getRowData(rowid);
        console.log(row)
    }
};

bindkeysContribuyente = {"onEnter": verContribuyentePredio};
bindkeysPredio = {"onEnter": verPredio};

buscarPredio = function(cperiod) { 
    if(cperiod == undefined || cperiod == null) {
        cperiod = $("#cboPeriodo").val();
    }
    parameters = {
        "name": "tblListaPredio",
        "procedure": "pl_function.listar_predios",
        "parameters": '{' +
        '"p_cperiod":"' + cperiod + '",' +
        '"p_cidpers":"' + $("#lblCodigo").html() + '"' +
        '}'
    };

    procesarProcedimiento("panelListaPredio", "tblListaPredio", optionPredio, parameters, bindkeysPredio);
};

buscarContribuyente = function() {
    valid = false;
    
    if(trim($('#c_codigocontrib').val()).length > 0){
        $('#c_codigocontrib').val(LPad($('#c_codigocontrib').val(), 10, '0'));
    }

    valid = valid || (trim($("#c_nombrecontrib").val()).length > 0);
    valid = valid || (trim($("#c_apepatcontrib").val()).length > 0);
    valid = valid || (trim($("#c_apematcontrib").val()).length > 0);
    valid = valid || (trim($("#c_codigocontrib").val()).length > 0);

    if(valid) {    
        parameters = {
            "name": "tblResult",
            "procedure": "public.buscar_persona",
            "parameters": '{' +
            '"p_nvar1":"' + $("#c_codigocontrib").val().toUpperCase() + '",' +
            '"p_nvar2":"' + $("#c_nombrecontrib").val().toUpperCase() + '",' +
            '"p_nvar3":"' + $("#c_apepatcontrib").val().toUpperCase() + '",' +
            '"p_nvar4":"' + $("#c_apematcontrib").val().toUpperCase() + '",' +
            '"p_nvar5":""' +
            '}'
        };
        
        proceso = function(requestData){
            $("#panelResult").html(requestData);
            records = $("#ctblResult").val();
            if(records == 0) {
                inicializarGrid("tblResult", optionContribuyente);
                buttons = {
                    "Aceptar": function(){
                        closeDialog("jqDialogInfo");
                        $('#c_codigocontrib').focus();
                    }
                }
                openDialogInfo("No existen contribuyentes con los criterios de busqueda ingresados.", 380, 150, buttons);
            } else if(records > 1) {
                actualizarGrid("tblResult", optionContribuyente, bindkeysContribuyente);
            } else {
                verContribuyentePredio();
            }
        };
        
        procesarConsultaSubProceso('registrar', parameters, proceso);        
    } else {
        openDialogWarning("Ingrese un valor en los campos de busqueda.", 380, 150);
    }
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
            buscarContribuyente();
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
    
    $("#btnbuscar").click(buscarContribuyente);
    $("#c_codigocontrib").focus();
});