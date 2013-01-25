verDatos = function(rowid) {   
    if(rowid == undefined || rowid == null) {
        parameters = {"name": "tblResult"};
    } else {
        parameters = $(this).getRowData(rowid);
    }
    
    closeDialog("busqresult");
    
    
   /*_post = $.post(path + "mantenimientos/listardatoscentrpob", parameters);
    
    _post.success(function(request){
        $("#manttcentropoblad").html(request);
     
    });
	
    _post.error(postError);*/
    
	
};


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


var tipos ={value:"" +
		"9999999999:Seleccionar" +
		";1000000071:AL."+
		";1000000072:AV."+
		";1000000073:CLL."+
		";1000000074:CR"+
		";1000000075:JR."+
		";1000000076:ML."+
		";1000000077:Ovl."+
		";1000000078:PQ"+
		";1000000079:PSJE."+
		";1000000080:PA"+
		";1000000081:Plz."+
		";1000000082:Prlg."+
		";1000000083:Pt."+
		";1000000084:Port."+
		";1000000085:Esq."+
		";1000000086:Otros"+
		";1000000087:Prlg. Av."+
		";1000000088:Prlg. Psje."+
		"", defaultValue:'9999999999'};
 

optionVias = {
	editurl: "viassave",
    height: 400,
    width: 800,
    colNames: ["Codigo", "Tipo Via", "Via","Tipo Centro","Nombre Via","Desde","Hasta" ,"Estado" ],
    colModel: [
               
        {name:'mviadis', index:'mviadis', frozen:true,editable: true,width:80 ,editoptions:{readonly:true,size:10}},      
        {name:'ctipvia', index:'ctipvia',editable: true, width:50, align: 'center',frozen: true,edittype:"select",editoptions:tipos},
        {name:'vnomvia', index:'vnomvia', editable: true ,width:150},
        {name:'ccodvia', index:'ccodvia', editable: true, width:50, hidden: true} ,
        {name:'tnomvia', index:'tnomvia',  width:150},
        {name:'cperdes', index:'cperdes', editable: true,width:50,frozen: true,edittype:"select",editoptions:anios},
        {name:'cperhas', index:'cperhas', editable: true,width:50,frozen: true,edittype:"select",editoptions:anios},
        {name:'nestado', index:'nestado', width:90,editable:true,align:"center",edittype:"checkbox",editoptions:{value:"1:0",defaultValue:"1"},formatter:'checkbox'}    
        ],
    caption: "&nbsp;&nbsp;&nbsp",
    hidegrid: true,
      
    ondblClickRow: verDatos
}


bindkeysVias = {"onEnter": function( rowid ) {}};

buscarVias = function() {
    valid = true;
  
    if(valid==true) {    
    	//alert("algo");
        parameters = {
            "name": "tblResult",
            "procedure": "registro.mostrarvias",
            "parameters": '{' +
            '"p_tipo":"01"'+
            '}'
        };
        
        proceso = function(requestData){
            $("#panelResult").html(requestData);
            records = $("#ctblResult").val();
            if(records > 0) {
                actualizarGrid("tblResult", optionVias, bindkeysVias);
                
                
                jQuery("#tblResult").jqGrid('navGrid','#ptblResult',
                		{edit:true,add:true,del:false,search:false,view:false}, //options
                		{jqModal:true,checkOnUpdate:false,savekey: [true,13], navkeys: [true,38,40], checkOnSubmit : true, reloadAfterSubmit:false, closeOnEscape:true, bottominfo:""}, // edit options
                		{jqModal:true,checkOnUpdate:false,savekey: [true,13], navkeys: [true,38,40], checkOnSubmit : true, reloadAfterSubmit:false, closeOnEscape:true,bottominfo:""}, // add options
                		{reloadAfterSubmit:false,jqModal:false, closeOnEscape:true}, // del options
                		{closeOnEscape:true}, // search options
                		{navkeys: [true,38,40], height:250,jqModal:false,closeOnEscape:true} // view options
                		);
                
                
                
            } else {
           // alert("no entro");              
                
            }
        };
        
        procesarConsultaSubProceso('registrar', parameters, proceso);        
    } else {
        openDialogWarning("Ingrese un valor en los campos de busqueda.", 380, 150);
    }
};

// buscarPredio = function() {};

buscarVias2 = function() {
    valid = true;
  
    if(valid==true) {    
    	//alert("algo");
        parameters = {
            "name": "tblResult",
            "procedure": "registro.mostrarvias2",
            "parameters": '{' +                        
            '"p_busq":"' + $("#txtbusq").val().toUpperCase() + '"' +
            
            '}'
        };
        
        proceso = function(requestData){
            $("#panelResult").html(requestData);
            records = $("#ctblResult").val();
            if(records > 0) {
                actualizarGrid("tblResult", optionVias, bindkeysVias);
            } else {
             alert("no entro");              
                
            }
        };
        
        procesarConsultaSubProceso('registrar', parameters, proceso);        
    } else {
        openDialogWarning("Ingrese un valor en los campos de busqueda.", 380, 150);
    }
};



$(function(){
	buscarVias();
     
    inicializarGrid("tblResult", optionVias);
    
    $("#panelbusqueda").on("keyup", "input", function(e) {
        if(e.keyCode == 13){
        	buscarVias2();
        }
    });
    
    $("#btnbuscar").button("option", "icons", {
        primary:'ui-icon-search'
    });

    
    $(".pnl").on("focus", function() {
        $("#c_codigocontrib").val("");
        $("#c_predial").val("");
    });
    
    $("#btnbuscar").button("option", "icons", {primary:'ui-icon-search'});
    
    $("#btnbuscar").click(buscarVias2);
    
    /*
    $("#btningresar").click(function() {
    	
    	openDialog1("mantenimientos/frmcentropoblado","400","400","Centro Poblado");
    });   */ 		     
});

