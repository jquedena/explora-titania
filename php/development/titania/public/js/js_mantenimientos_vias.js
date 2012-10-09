verDatosVias = function(rowid) {   
    if(rowid == undefined || rowid == null) {
        parameters = {"name": "tblResult"};
    } else {
        parameters = $(this).getRowData(rowid);
    }
    
    closeDialog("busqresult");
    
    
   _post = $.post(path + "mantenimientos/listardatosvias", parameters);
    
    _post.success(function(request){
        $("#manttcentropoblad").html(request);
     
    });
	
    _post.error(postError);
    
	
};

optionVias = {
    height: 290,
    width: 600,
    colNames: ["C\u00F3digo", "Nombre", "Tipo","Desde","Hasta"  ],
    colModel: [
        {name:'ccodvia', index:'ccodvia', width:50, align: 'center'},
        {name:'vnombre', index:'vnombre', width:80},       
        {name:'ctipvia', index:'ctipvia', width:50} ,       
        {name:'dfecdes', index:'dfecdes', width:50},
        {name:'dfechas', index:'dfechas', width:50}],
    caption: "&nbsp;&nbsp;&nbsp",
    hidegrid: true,
      
    //ondblClickRow: verDatosVias
}


bindkeysVias = {"onEnter": function( rowid ) {}};

buscarVias = function() {
    valid = true;
  
    if(valid==true) {    
    	//alert("algo");
        parameters = {
            "name": "tblResul",
            "procedure": "registro.mostrarvias",
            "parameters": '{' +
            '"p_tipo":"01"'+
            '}'
        };
        
        proceso = function(requestData){
            $("#panelResult").html(requestData);
            records = $("#ctblResult").val();
           // alert(records);
            if(records > 0) {
                actualizarGrid("tblResult", optionVias, bindkeysVias );
            } else {
           // alert("no entro");              
                
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
    
    $("#txtbuscar").on("keyup", "input", function(e) {
        if(e.keyCode == 13){
        	buscarVias();
        }
    });
    

    
    $(".pnl").on("focus", function() {
        $("#c_codigocontrib").val("");
        $("#c_predial").val("");
    });
    

    
    /*
    $("#btningresar").click(function() {
    	
    	openDialog1("mantenimientos/frmcentropoblado","400","400","Centro Poblado");
    });   */ 		     
});
