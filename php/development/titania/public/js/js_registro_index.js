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
    /*onSelectRow: function(id) {
        row = $(this).getRowData(id);
        console.log(row);
    },*/
    ondblClickRow: function(rowid, iRow, iCol,e) {
        row = $(this).getRowData(rowid);
        console.log(row);
    }
}

optionPredio = {
    height: 290,
    width: 1000,
    colNames: ["C\u00F3digo", "Administrado", "Direcci\u00F3n Fiscal"],
    colModel: [
        {name:'cidpers', index:'cidpers', width:80, align: 'center'},
        {name:'crazsoc', index:'crazsoc', width:420},
        {name:'direccf', index:'direccf', width:420} ],
    caption: "&nbsp;&nbsp;&nbsp;Resultados de la busqueda",
    /*onSelectRow: function(id) {
        row = $(this).getRowData(id);
        console.log(row);
    },*/
    ondblClickRow: function(rowid, iRow, iCol,e) {
        row = $(this).getRowData(rowid);
        console.log(row);
    }
}

bindkeysContribuyente = {"onEnter": function( rowid ) { listarPredio(rowid) }};

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
                _post = $.post(path + "jqgrid/paginar", {"name": "tblResult"}, function(request){
                    $("#c_nombrecontrib").val(request.rows[0].cell[1]);
                }, "json");

                // $("#c_apepatcontrib").val();
                // $("#c_apematcontrib").val();
            }
        };
        
        procesarConsultaSubProceso('registrar', parameters, proceso);        
        // procesarProcedimiento("panelResult", "tblResult", optionContribuyente, parameters);
        
    } else {
        openDialogWarning("Ingrese un valor en los campos de busqueda.", 380, 150);
    }
};

listarPredio = function(id) {
    
}

buscarPredio = function() {
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