xviewreajust = function(){
	
}

bindkeysreajust = {"onEnter": xviewreajust};
buscarreajust = function(_periodo) {
	if(_periodo == undefined || _periodo == null) {
		//_periodo = $("#cboPeriodo").val();
		 $("#txtPeriodo").val('');
		 _periodo ='%'
    }else{
    	
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
            jQuery("#tblResultreajust").jqGrid('navGrid','#ptblResultreajust',
            		{edit:true,add:true,del:false,search:false,view:false}, //options
            		{jqModal:true,checkOnUpdate:false,savekey: [true,13], navkeys: [true,38,40], checkOnSubmit : true, reloadAfterSubmit:false, closeOnEscape:true, bottominfo:""}, // edit options
            		{jqModal:true,checkOnUpdate:false,savekey: [true,13], navkeys: [true,38,40], checkOnSubmit : true, reloadAfterSubmit:false, closeOnEscape:true,bottominfo:""}, // add options
            		{reloadAfterSubmit:false,jqModal:false, closeOnEscape:true}, // del options
            		{closeOnEscape:true}, // search options
            		{navkeys: [true,38,40], height:250,jqModal:false,closeOnEscape:true} // view options
            		);

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
var anios ={value:"9999999999:Seleccionar" +
					";1991:1991" +
					";1992:1992" +
					";1993:1993" +
					";1994:1994" +
					";1995:1995" +
					";1996:1996" +
					";1997:1997" +
					";1998:1998" +
					";1999:1999" +
					";2000:2000" +
					";2001:2001" +
					";2002:2002" +
					";2003:2003" +
					";2004:2004" +
					";2005:2005" +
					";2006:2006" +
					";2007:2007" +
					";2008:2008" +
					";2009:2009" +
					";2010:2010" +
					";2011:2011" +
					";2012:2012" +
					"", defaultValue:'9999999999'};
var vmeses = {value:"9999999999:Seleccionar" +
					";1:Enero" +
					";2:Febrero" +
					";3:Marzo" +
					";4:Abril" +
					";5:Mayo" +
					";6:Junio" +
					";7:Julio" +
					";8:Agosto" +
					";9:Septiembre" +
					";10:Octubre" +
					";11:Noviembre" +
					";12:Diciembre" +
					"", defaultValue:'9999999999'};
optionregreajust = {
    height: 290,
    width: 1000,
    editurl: "reajustesave",
    colNames: ["C\u00F3digo", "Periodo","Tipo", "Mes", "Tasa Interes Mora.", "Factor Reajus.", "Fecha Vencimiento", "IPM", "Tipo Cuota", "Aplica IPM","Aplica Mora","Estado"],
    colModel: [
        {name:'idsigma', index:'idsigma', width:100,editable: true, align: 'center', frozen: true,editoptions:{readonly:true,size:10}},
        {name:'cperiod', index:'cperiod', width:90,editable: true, align: 'center', frozen: true,edittype:"select"
        	,editoptions:anios},// periodo
        {name:'ctiping', index:'ctiping', width:90,editable: true},//hidden:true},// tipo de ingreso 273=ip 0278=AM
        {name:'cnromes', index:'cnromes', width:90,editable: true, align: 'center',edittype:"select"
        	,editoptions:vmeses},//Mes
        
        {name:'nmontim', index:'nmontim', width:90,editable: true,align:"right",editoptions:{
        	dataInit:function(el){
				$(el).autoNumeric();
			},size:9}
			//taza de interes moratorio
        } ,       
        {name:'nfacrea', index:'nfacrea', width:90,editable: true,align:"right",editoptions:{
        	dataInit:function(el){
				$(el).autoNumeric();
			},size:9}
        },//factor Reajuste
        {name:'dfecven', index:'dfecven', width:100,editable: true,align:"right",formatter:'date',formatoptions: { newformat: 'Y-m-d'},editoptions:{
        	dataInit:function(el){
        		 $(el).datepicker({ changeMonth: true, changeYear: true, 
                     dateFormat: 'yy-mm-dd' });
			},size:9}
        },//fecha de vencimiento del tributo
        {name:'nmonipm', index:'nmonipm', width:90,editable: true,align:"right",editoptions:{
        	dataInit:function(el){
				$(el).autoNumeric();
			},size:9}
        },//IPM  
        {name:'ntipcuo', index:'ntipcuo', width:90,editable: true,align:"center",edittype:"checkbox",editoptions:{value:"1:0",defaultValue:"1"},formatter:'checkbox'},//condicional para el fracc :S
        {name:'nipmapl', index:'nipmapl', width:90,editable: true,align:"center",edittype:"checkbox",editoptions:{value:"1:0",defaultValue:"1"},formatter:'checkbox'},//si aplika ipm o no
        
        {name:'nmorapl', index:'nmorapl', width:90,editable: true,align:"center",edittype:"checkbox",editoptions:{value:"1:0",defaultValue:"1"},formatter:'checkbox'},//si aplika mora 1 si no 0
        {name:'nestado', index:'nestado', width:90,editable: true,align:"center",edittype:"checkbox",editoptions:{value:"1:0",defaultValue:"1"},formatter:'checkbox'}
        //{name:'nestado', index:'nestado', width:90,editable:true,align:"center",edittype:"checkbox",editoptions:{value:"1:0",defaultValue:"1"},formatter:'checkbox'}
        ],
        //cellEdit:true,
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
    $('#txtPeriodo').keyup(function(e) {
    	//alert(e.keyCode);
    	if(e.keyCode == 13) {
    		//alert('DAve');
    		if ($('#txtPeriodo').val()==''){
    			buscarreajust();
    		}
    	}
    });
    $("#txtPeriodo").bind("autocompletechange", function(event, ui) {
        if(ui.item) {
        	//buscarreajust(ui.item.value);
        	buscarreajust(ui.item.value);
        } else {
            //openDialogWarning("El valor ingresado no esta en la lista de elementos.", 380, 150);
        	buscarreajust();
        }
    });
    inicializarGrid("tblResultreajust", optionregreajust);
    buscarreajust();
//---
    
});
