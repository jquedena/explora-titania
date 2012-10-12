xviewreajust = function(){
	
}

bindkeysreajust = {"onEnter": xviewreajust};
buscarreajust = function(_periodo) {
	if(_periodo == undefined || _periodo == null) {
		_periodo = $("#cboPeriodo").val();
    }
  
    parameters = {
        "name": "tblResultreajust",
        "procedure": "public.buscar_mreajus",
        "parameters": '{' +
        '"p_nvar1":"",' +
        '"p_nvar2":"' + _periodo + '"' +
        '}'
    };
    
    proceso = function(requestData){
        $("#panelResultreajust").html(requestData);
        records = $("#ctblResultreajust").val();
        //if(records > 1) {
            actualizarGrid("tblResultreajust", optionregreajust, bindkeysreajust);
            jQuery("#tblResultreajust").jqGrid('navGrid','#ptblResultreajust',{edit:true,add:true,del:true,search:false});
            /*
            jQuery("#tblResultreajust").jqGrid('navButtonAdd','#ptblResultreajust',{caption:"Modificar",
            	onClickButton:function(){
            		var gsr = jQuery("#tblResultreajust").jqGrid('getGridParam','selrow');
            		if(gsr){
            			jQuery("#tblResultreajust").jqGrid('GridToForm',gsr,"#order");
            		} else {
            			alert("Please select Row")
            		}							
            	} 
            });
            
            jQuery("#tblResultreajust").jqGrid('navButtonAdd','#ptblResultreajust',{caption:"Registrar",
            	onClickButton:function(){
            		var gsr = jQuery("#tblResultreajust").jqGrid('getGridParam','selrow');
            		if(gsr){
            			jQuery("#tblResultreajust").jqGrid('GridToForm',gsr,"#order");
            		} else {
            			alert("Please select Row")
            		}							
            	} 
            });*/
        //} else {
        //	xmantepersonupdate();
        //}
    };
    
    procesarConsultaSubProceso('registrar', parameters, proceso);        
 
};

//buscar_mreajus
//p_nvar1 idsigma
//p_nvar2 periodo
optionregreajust = {
    height: 290,
    width: 1000,
    colNames: ["C\u00F3digo", "Periodo","Tipo", "Mes", "Taza interes Mora.", "Factor Reajus.", "Fecha Vencimiento", "IPM", "ntipcuo","Aplica IPM","Aplica Mora","nestado"],
    colModel: [
        {name:'idsigma', index:'idsigma', width:100,editable: true, align: 'center', frozen: true},
        {name:'cperiod', index:'cperiod', width:90,editable: true, align: 'center', frozen: true},// periodo
        {name:'ctiping', index:'ctiping', width:90,editable: true},//hidden:true},// tipo de ingreso 273=ip 0278=AM
        {name:'cnromes', index:'cnromes', width:90,editable: true},//Mes
        {name:'nmontim', index:'nmontim', width:90,editable: true},//taza de interes moratorio
        {name:'nfacrea', index:'nfacrea', width:90,editable: true},// factor Reajuste
        {name:'dfecven', index:'dfecven', width:90,editable: true},//fecha de vencimiento del tributo
        {name:'nmonipm', index:'nmonipm', width:90,editable: true},//IPM  
        {name:'ntipcuo', index:'ntipcuo', width:90,editable: true,hidden:true},//condicional para el fracc :S
        {name:'nipmapl', index:'nipmapl', width:90,editable: true},//si aplika ipm o no
        {name:'nmorapl', index:'nmorapl', width:90,editable: true},//si aplika mora 1 si no 0
        {name:'nestado', index:'nestado', width:90,editable: true}
        ],
    caption: "&nbsp;&nbsp;&nbsp;Resultados de la busqueda"
    /* onSelectRow: function(id) {
        row = $(this).getRowData(id);
        console.log(row);
    },*/
    //ondblClickRow: xviewreajust
};
$(function(){

    //inicializarGrid("tblResultpersons", optionPerson);
	//$("#cboPeriodo").combobox();
    $("#txtPeriodo").attr("maxlength", 4);
    $("#txtPeriodo").bind("autocompleteselect", function(event, ui) {
        buscarreajust(ui.item.value);
    });
    $("#txtPeriodo").bind("autocompletechange", function(event, ui) {
        if(ui.item) {
        	//buscarreajust(ui.item.value);
        	buscarreajust(ui.item.value);
        } else {
            openDialogWarning("El valor ingresado no esta en la lista de elementos.", 380, 150);
        }
    });
    inicializarGrid("tblResultreajust", optionregreajust);
    buscarreajust();
//---
    
});
