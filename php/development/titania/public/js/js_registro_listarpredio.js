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
        {name: 'tnumero', index:'tnumero', width: 450},
        {name: 'cusogen', index:'cusogen', width: 250},
        {name: 'nvalpre', index:'nvalpre', width: 100, formatter:'currency', align: 'right'},
        {name: 'nvalafe', index:'nvalafe', width: 100, formatter:'currency', align: 'right'},
        {name: 'dfecadq', index:'dfecadq', width: 80, formatter:'date', formatoptions: {srcformat:"Y-m-d", newformat:"d-M-Y"}, align: 'center'},
        {name: 'vnrodoc', index:'vnrodoc', width: 80, align: 'center'},
        {name: 'nporcen', index:'nporcen', width: 60, align: 'right'}],
    caption: "&nbsp;&nbsp;&nbsp;Predios Registrados",
    shrinkToFit: false
}

buscarPredio = function() { 
    parameters = {
        "name": "tblListaPredio",
        "procedure": "pl_function.listar_predios",
        "parameters": '{' +
        '"p_cperiod":"2012",' +
        '"p_cidpers":"0000000020"' +
        '}'
    };


    procesarProcedimiento("panelListaPredio", "tblListaPredio", optionPredio, parameters);
    $("#tblListaPredio").jqGrid('hideCol',["dfecadq","nporcen"]);
    $("#tblListaPredio").jqGrid("remapColumns", [0, 7, 8, 9, 3, 5, 1, 2, 4], false, false);
};

$(function(){
    inicializarGrid("tblListaPredio", optionPredio);
    buscarPredio();
});