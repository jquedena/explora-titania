xviewuit = function(){
	
}

bindkeysuit = {"onEnter": xviewuit};
buscaruit = function(_periodo) {
	if(_periodo == undefined || _periodo == null) {
		_periodo = $("#cboPeriodo").val();
    }
  
    parameters = {
        "name": "tblResultuit",
        "procedure": "public.buscar_cvaluit",
        "parameters": '{' +
        '"p_nvar1":"",' +
        '"p_nvar2":"' + _periodo + '"' +
        '}'
    };
    
    proceso = function(requestData){
        $("#panelResultuit").html(requestData);
        records = $("#ctblResultuit").val();
        //if(records > 1) {
            actualizarGrid("tblResultuit", optionreguit, bindkeysuit);
            jQuery("#tblResultuit").jqGrid('navGrid','#ptblResultuit',{edit:true,add:true,del:true,search:false});
            /*
            jQuery("#tblResultuit").jqGrid('navButtonAdd','#ptblResultuit',{caption:"Modificar",
            	onClickButton:function(){
            		var gsr = jQuery("#tblResultuit").jqGrid('getGridParam','selrow');
            		if(gsr){
            			jQuery("#tblResultuit").jqGrid('GridToForm',gsr,"#order");
            		} else {
            			alert("Please select Row")
            		}							
            	} 
            });
            
            jQuery("#tblResultuit").jqGrid('navButtonAdd','#ptblResultuit',{caption:"Registrar",
            	onClickButton:function(){
            		var gsr = jQuery("#tblResultuit").jqGrid('getGridParam','selrow');
            		if(gsr){
            			jQuery("#tblResultuit").jqGrid('GridToForm',gsr,"#order");
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

//buscar_cvaluit
//p_nvar1 idsigma
//p_nvar2 periodo
optionreguit = {
    height: 290,
    width: 1000,
    colNames: ["C\u00F3digo", "Periodo","ctiptri", "Valor UIT", "Imp Min", "Imp Max", "Costo Emision", "Costos Adicionales", "Estado"],
    colModel: [
        {name:'idsigma', index:'idsigma', width:100,editable: true, align: 'center', frozen: true},
        {name:'cperiod', index:'cperiod', width:90,editable: true, align: 'center', frozen: true},
        {name:'ctiptri', index:'ctiptri', width:90,editable: true},//,hidden:true},
        {name:'mvaluit', index:'mvaluit', width:90,editable: true},
        {name:'nimpmin', index:'nimpmin', width:90,editable: true},
        {name:'nimpmax', index:'nimpmax', width:90,editable: true},
        {name:'ncosemi', index:'ncosemi', width:90,editable: true},
        {name:'ncosadi', index:'ncosadi', width:90,editable: true},
        {name:'nestado', index:'nestado', width:90,editable: true}
        ],
    caption: "&nbsp;&nbsp;&nbsp;Resultados de la busqueda"
    /* onSelectRow: function(id) {
        row = $(this).getRowData(id);
        console.log(row);
    },*/
    //ondblClickRow: xviewuit
};
$(function(){

    //inicializarGrid("tblResultpersons", optionPerson);
	//$("#cboPeriodo").combobox();
    $("#txtPeriodo").attr("maxlength", 4);
    $("#txtPeriodo").bind("autocompleteselect", function(event, ui) {
        buscaruit(ui.item.value);
    });
    $("#txtPeriodo").bind("autocompletechange", function(event, ui) {
        if(ui.item) {
        	//buscaruit(ui.item.value);
        	buscaruit(ui.item.value);
        } else {
            openDialogWarning("El valor ingresado no esta en la lista de elementos.", 380, 150);
        }
    });
    inicializarGrid("tblResultuit", optionreguit);
    buscaruit();
//---
    
});
