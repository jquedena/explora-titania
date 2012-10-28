xviewuit = function(){
	
}

bindkeysuit = {"onEnter": xviewuit};
buscaruit = function(_periodo) {
	if(_periodo == undefined || _periodo == null) {
		//_periodo = $("#cboPeriodo").val();
		 $("#txtPeriodo").val('');
		 _periodo ='%'
    }else{
    	
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
            //jQuery("#tblResultuit").jqGrid('navGrid','#ptblResultuit',{edit:true,add:true,del:true,search:false});
           
            jQuery("#tblResultuit").jqGrid('navGrid','#ptblResultuit',
            		{edit:true,add:true,del:false,search:false,view:false}, //options
            		{jqModal:true,checkOnUpdate:false,savekey: [true,13], navkeys: [true,38,40], checkOnSubmit : true, reloadAfterSubmit:false, closeOnEscape:true, bottominfo:""}, // edit options
            		{jqModal:true,checkOnUpdate:false,savekey: [true,13], navkeys: [true,38,40], checkOnSubmit : true, reloadAfterSubmit:false, closeOnEscape:true,bottominfo:""}, // add options
            		{reloadAfterSubmit:false,jqModal:false, closeOnEscape:true}, // del options
            		{closeOnEscape:true}, // search options
            		{navkeys: [true,38,40], height:250,jqModal:false,closeOnEscape:true} // view options
            		);
            
            
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
//editoptions:{dataUrl:'test.txt', defaultValue:'Intime'},
var anios ={value:"" +
		"9999999999:Seleccionar" +
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


optionreguit = {
    height: 290,
    //url:'http://localhost/titania/public/index.php/mantenimientos/uitsave?q=1',
    editurl: "uitsave",
    width: 1000,
    colNames: ["C\u00F3digo", "Periodo","Tributo", "Valor UIT", "Imp. Min.", "Imp. Max.", "Costo Emisi\u00F3n", "Costos Adicionales", "Estado"],
    colModel: [
        {name:'idsigma', index:'idsigma',width:100,editable: true, align: 'center', frozen: true,editoptions:{readonly:true,size:10}},
		//{name:'ship_via',index:'ship_via',width:70, editable: true,edittype:"select",editoptions:{value:"FE:FedEx;TN:TNT"}},
        {name:'cperiod', index:'cperiod', width:90,editable: true, align: 'center', frozen: true,edittype:"select"
        	,editoptions:anios},
        	
        {name:'ctiptri', index:'ctiptri', width:90,editable: true,align:"right",editoptions:{size:7},editrules:{required:true}},//,hidden:true},
        {name:'mvaluit', index:'mvaluit', width:90,editable: true,align:"right",editoptions:{
        																						dataInit:function(el){
        																							$(el).autoNumeric();
        																						},size:9
																			        		}
        //,formoptions:{ rowpos:4, elmprefix:"(*)",elmsuffix:"dave" }
        ,editrules:{required:true}
        },
        {name:'nimpmin', index:'nimpmin', width:90,editable: true,align:"right"
        	,editoptions:{
        		dataInit:function(el){
        			$(el).autoNumeric();
        		},size:9
        	}
        ,editrules:{required:true}
        },
        {name:'nimpmax', index:'nimpmax', width:90,editable: true,align:"right"
        	,editoptions:{
        		dataInit:function(el){
        			$(el).autoNumeric();
        		},size:9
        	}
        ,editrules:{required:true}
        },
        {name:'ncosemi', index:'ncosemi', width:90,editable: true,align:"right"
        	,editoptions:{
        		dataInit:function(el){
        			$(el).autoNumeric();
        		},size:9
        	}
        ,editrules:{required:true}
        },
        {name:'ncosadi', index:'ncosadi', width:90,editable: true,align:"right"
        	,editoptions:{
        		dataInit:function(el){
        			$(el).autoNumeric();
        		},size:9
        	}
        ,editrules:{required:true}
        },
        {name:'nestado', index:'nestado', width:90,editable:true,align:"center",edittype:"checkbox",editoptions:{value:"1:0",defaultValue:"1"},formatter:'checkbox'}
        //{name:'closed',index:'closed',width:55,align:'center',editable:true,edittype:"checkbox",editoptions:{value:"1:2"}},
        ],
        
    //cellEdit:true,
    //cellsubmit : 'remote',
    //cellurl : 'uitsave',
        
    caption: "&nbsp;&nbsp;&nbsp;Resultados de la busqueda UIT",
    afterInsertRow: function(rowid, aData){
    	switch (aData.nestado) {
    		case '1':
    			//jQuery("#tblResultuit").jqGrid('setCell',rowid,'idsigma','',{color:'green'});
    		break;
    		case '0':
    			jQuery("#tblResultuit").jqGrid('setCell',rowid,'idsigma','',{color:'red'});
    			jQuery("#tblResultuit").jqGrid('setCell',rowid,'cperiod','',{color:'red'});
    			jQuery("#tblResultuit").jqGrid('setCell',rowid,'ctiptri','',{color:'red'});
    			jQuery("#tblResultuit").jqGrid('setCell',rowid,'mvaluit','',{color:'red'});
    			jQuery("#tblResultuit").jqGrid('setCell',rowid,'nimpmin','',{color:'red'});
    			jQuery("#tblResultuit").jqGrid('setCell',rowid,'nimpmax','',{color:'red'});
    			jQuery("#tblResultuit").jqGrid('setCell',rowid,'ncosemi','',{color:'red'});
    			jQuery("#tblResultuit").jqGrid('setCell',rowid,'ncosadi','',{color:'red'});
    			jQuery("#tblResultuit").jqGrid('setCell',rowid,'nestado','',{color:'red'});
    		break;
    		
    	}
    }
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
   
    $('#txtPeriodo').keyup(function(e) {
    	//alert(e.keyCode);
    	if(e.keyCode == 13) {
    		//alert('DAve');
    		if ($('#txtPeriodo').val()==''){
    				buscaruit();
    		}
    	}
    });
    
    $("#txtPeriodo").bind("autocompletechange", function(event,ui) {
        if(ui.item) {
        	//buscaruit(ui.item.value);
        	buscaruit(ui.item.value);
        } else {
            //openDialogWarning("El valor ingresado no esta en la lista de elementos.", 380, 150);
            buscaruit();
        }
    });
    inicializarGrid("tblResultuit", optionreguit);
    buscaruit();
});
