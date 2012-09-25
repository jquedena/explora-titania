optionPredio = {
    height: 290,
    width: 1000,
    colNames: ["C\u00F3digo", "Administrado", "Direcci\u00F3n Fiscal", "C\u00F3digo Predio"],
    colModel: [
        {name:'cidpers', index:'cidpers', width:80, align: 'center'},
        {name:'crazsoc', index:'crazsoc', width:420},
        {name:'direccf', index:'direccf', width:420},
        {name:'cidpred', index:'cidpred', width:420},],
    caption: "&nbsp;&nbsp;&nbsp;Resultados de la busqueda"
}

buscarContribuyente = function() { 
    parameters = {
        "name": "tblListaPredio",
        "procedure": "public.buscar_persona",
        "parameters": '{' +
        '"p_nvar1":"0000000020",' +
        '"p_nvar2":"",' +
        '"p_nvar3":"",' +
        '"p_nvar4":"",' +
        '"p_nvar5":""' +
        '}'
    };


    procesarConsulta("panelListaPredio", "tblListaPredio", optionPredio, parameters);
};

$(function(){
    inicializarGrid("tblListaPredio", optionPredio);
    buscarContribuyente();
});