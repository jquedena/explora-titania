loadVerDetalle = function(){
    $("#tabsDetallePredio").tabs();

    themeTextBox("#panelRegistro .ui-text");
    themeComboBox("#panelRegistro select");
    
    $("#dtpFechaAdquisicion, #dtpFechaDescargo").datepicker({
        dateFormat: "dd/mm/yy",
        showOn: "button",
        buttonImage: pathImage + "calendar.gif",
        buttonImageOnly: true
    });

    $("#btnBuscarDireccion").button({
        text: false,
        icons: {primary:'ui-icon-search'}
    });
    
    $("#btnEditarPredio").button({
        icons: {primary:'ui-icon-pencil'}
    });

    $("#btnGrabarPredio").button({
        icons: {primary:'ui-icon-disk'}
    });

    $("#btnCancelarPredio").button({
        icons: {primary:'ui-icon-arrowreturnthick-1-w'}
    });
    
    inicializarGrid("tblPiso", optionPiso);
    // $("#tblPiso").jqGrid('hideCol',['idsigma','dpredio','cnitems','cperiod','ctipdat','vnrodoc','dfecdoc','cmotivo','ctipdoc','cmescon','canocon','narecom','dafecta']);
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
        'Area Const.',
        'Val. Unit. m2',
        'Inc. 5%',
        '% Depr',
        'Depr.',
        'Val. Unit. Depr.',
        'narecom',
        '% Area Com\u00FAn',
        'Val. Area Com\u00FAn',
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
        {name: 'cnumpis', index: 'cnumpis', width: 30}, // Nro de piso
        {name: 'nantigu', index: 'nantigu', width: 30}, // Antiguedad
        {name: 'cmescon', index: 'cmescon', width: 30, hidden: true}, // Mes de la construccion
        {name: 'canocon', index: 'canocon', width: 30, hidden: true}, // Periodo de Construccion
        {name: 'cmateri', index: 'cmateri', width: 30, align: 'center'}, // Material
        {name: 'cconser', index: 'cconser', width: 30, align: 'center'}, // Estado de conservacion
        {name: 'cmurcol', index: 'cmurcol', width: 20, align: 'center'}, // Muros y columnas
        {name: 'ctechos', index: 'ctechos', width: 20, align: 'center'}, // Techos
        {name: 'cmpisos', index: 'cmpisos', width: 20, align: 'center'}, // Pisos
        {name: 'cpueven', index: 'cpueven', width: 20, align: 'center'}, // Puertas y ventanas
        {name: 'crevest', index: 'crevest', width: 20, align: 'center'}, // Revestimientos
        {name: 'cbanios', index: 'cbanios', width: 20, align: 'center'}, // Sanitarios
        {name: 'celectr', index: 'celectr', width: 20, align: 'center'}, // Instalaciones electricas
        {name: 'narecon', index: 'narecon', width: 30, align: 'right'}, // Area construida
        {name: 'nvaluni', index: 'nvaluni', width: 30}, // Valor unitario
        {name: 'nincrem', index: 'nincrem', width: 30}, // Incremento
        {name: 'npordep', index: 'npordep', width: 30}, // Porcentaje de depreciacion
        {name: 'ndepred', index: 'ndepred', width: 30}, // Depreciacion
        {name: 'nvalare', index: 'nvalare', width: 30}, // Valor unitario depreciado del area construida
        {name: 'narecom', index: 'narecom', width: 30, hidden: true}, // Area comun
        {name: 'nporcom', index: 'nporcom', width: 30}, // Porcentaje de area comun
        {name: 'nvalcom', index: 'nvalcom', width: 30}, // Valor del area comun
        {name: 'nvalpis', index: 'nvalpis', width: 30}, // Valor total del piso
        {name: 'dafecta', index: 'dafecta', width: 30, hidden: true}  // Fecha desde donde se comienzan a generar los tributos
    ],
    caption: "&nbsp;&nbsp;&nbsp;Pisos",
    ondblClickRow: function(rowid, iRow, iCol, e) {
        row = $(this).getRowData(rowid);
        console.log(row)
    }
};

optionInstalacion = {
    
};

bindkeysContribuyente = {"onEnter": verContribuyentePredio};

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

    // console.log(parameters);
    procesarProcedimiento("panelListaPredio", "tblListaPredio", optionPredio, parameters);
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
            if(records > 1) {
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
});