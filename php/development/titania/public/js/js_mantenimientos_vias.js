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


optionVias = {
    height: 290,
    width: 600,
    colNames: ["Tipo Via", "Nombre", "Via","Tipo Centro","Nombre Via","Desde","Hasta"  ],
    colModel: [
        {name:'ctipvia', index:'ctipvia', width:50, align: 'center'},
        {name:'mviadis', index:'mviadis', width:80, hidden: true},
        {name:'vnomvia', index:'vnomvia', width:150},
        {name:'ccodvia', index:'ccodvia', width:50, hidden: true} ,
        {name:'tnomvia', index:'tnomvia', width:150},
        {name:'cperdes', index:'cperdes', width:50},
        {name:'cperhas', index:'cperhas', width:50},
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

