optionContribuyente = {
    height: 290,
    width: 1000,
    colNames: ["C\u00F3digo", "Administrado", "Direcci\u00F3n Fiscal"],
    colModel: [
        {name:'cidpers', index:'cidpers', width:80, align: 'center'},
        {name:'crazsoc', index:'crazsoc', width:420},
        {name:'direccf', index:'direccf', width:420} ],
    caption: "&nbsp;&nbsp;&nbsp;Resultados de la busqueda"
}

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
                actualizarGrid("tblResult", optionContribuyente);
            } else {
                
            }
        };
        
        procesarConsultaSubProceso(parameters, proceso);
        // procesarConsulta("panelResult", "tblResult", optionContribuyente, parameters);
        
    } else {
        openDialogWarning("Ingrese un valor en los campos de busqueda.", 380, 150);
    }
};

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
    /*
    $("#btnestcta").button("option", "icons", {
        primary:'ui-icon-document'
    });
    $("#btncontri").button("option", "icons", {
        primary:'ui-icon-person'
    });
    */
   
    inicializarGrid("tblResult", optionContribuyente);
    
    $("#panelContribuyente").on("keyup", "input", function(e) {
        if(e.keyCode == 13){
            buscarContribuyente();
        }
    });
    
    $("#btnbuscar").click(buscarContribuyente);
});