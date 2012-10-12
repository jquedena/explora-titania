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
    width: 800,
    colNames: ["Codigo", "Cod. Centr.Poblado", "Centro Poblado","Cod. Via","Via"
               ,"Lado Via","Cuadra Ini","Cuadra Fin","Arancel","Factor Bar","Periodo","Estado",
               "Host","Usuario","Fecha Tran."],
    colModel: [
        {name:'idsigma', index:'idsigma,', width:50, hidden: true, align: 'center'},
        {name:'mpoblad', index:'mpoblad', width:80, hidden: true},
        {name:'tnompob', index:'tnompob', width:150},
        {name:'mviadis', index:'mviadis', width:50, hidden: true} ,
        {name:'tnomvia', index:'tnomvia', width:150},
        {name:'nladvia', index:'nladvia', width:50},
        {name:'ncuaini', index:'ncuaini', width:50},
        {name:'ncuafin', index:'ncuafin', width:50},
        {name:'narance', index:'narance', width:50},
        {name:'nfacbar', index:'nfacbar', width:50},
        {name:'cperiod', index:'cperiod', width:50},
        {name:'nestado', index:'nestado', width:50, hidden: true},
        {name:'vhostnm', index:'vhostnm', width:50, hidden: true},
        {name:'vusernm', index:'vusernm', width:50, hidden: true},
        {name:'ddatetm', index:'ddatetm', width:50, hidden: true}     
        
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
            "procedure": "registro.mostrararancel",
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

$(function(){
	buscarVias();
     
    inicializarGrid("tblResult", optionVias);
    
    $("#panelbusqueda").on("keyup", "input", function(e) {
        if(e.keyCode == 13){
        	//buscarVias2();
        }
    });
    
    $("#btnbuscar").button("option", "icons", {
        primary:'ui-icon-search'
    });

    
    $(".pnl").on("focus", function() {
        $("#c_codigocontrib").val("");
        $("#c_predial").val("");
    });
    
    
    //$("#btnbuscar").click(buscarVias);
    
    /*
    $("#btningresar").click(function() {
    	
    	openDialog1("mantenimientos/frmcentropoblado","400","400","Centro Poblado");
    });   */ 		     
});

