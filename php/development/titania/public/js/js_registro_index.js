verContribuyentePredio = function(rowid) {   
    if(rowid == undefined || rowid == null) {
        parameters = {"name": "tblResult"};
    } else {
        parameters = $(this).getRowData(rowid);
    }
    
    _post = $.post(path + "registro/listarpredio", parameters);
    
    _post.success(function(request){
        $("#panelRegistro").html(request);
        $("#cboPeriodo").on("change", function(){
            buscarPredio();
        });
        buscarPredio();
    });
	
    _post.error(postError);
};

verPredio = function(rowid, iRow, iCol, e) {
    row = $(this).getRowData(rowid);
    console.log(row);
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
    hidegrid: true,
    /* onSelectRow: function(id) {
        row = $(this).getRowData(id);
        console.log(row);
    },*/
    ondblClickRow: verContribuyentePredio
}

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
    colModel: [{name: 'ccodpre', index:'ccodpre', width: 80}, // , frozen: true
        {name: 'tnumero', index:'tnumero', width: 450}, // , frozen: true
        {name: 'cusogen', index:'cusogen', width: 250},
        {name: 'nvalpre', index:'nvalpre', width: 100, formatter:'currency', align: 'right'},
        {name: 'nvalafe', index:'nvalafe', width: 100, formatter:'currency', align: 'right'},
        {name: 'dfecadq', index:'dfecadq', width: 80, formatter:'date', formatoptions: {srcformat:"Y-m-d", newformat:"d-M-Y"}, align: 'center'},
        {name: 'vnrodoc', index:'vnrodoc', width: 80, align: 'center'},
        {name: 'nporcen', index:'nporcen', width: 60, align: 'right'}],
    caption: "&nbsp;&nbsp;&nbsp;Predios Registrados",
    ondblClickRow: verPredio
}

bindkeysContribuyente = {"onEnter": verContribuyentePredio};

buscarPredio = function() { 
    parameters = {
        "name": "tblListaPredio",
        "procedure": "pl_function.listar_predios",
        "parameters": '{' +
        '"p_cperiod":"' + $("#cboPeriodo").val() + '",' +
        '"p_cidpers":"' + $("#lblCodigo").html() + '"' +
        '}'
    };

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