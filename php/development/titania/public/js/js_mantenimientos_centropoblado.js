verDatos = function(rowid) {   
    if(rowid == undefined || rowid == null) {
        parameters = {"name": "tblResult"};
    } else {
        parameters = $(this).getRowData(rowid);
    }
    
    closeDialog("busqresult");
    
    /*    
   _post = $.post(path + "mantenimientos/listardatoscentrpob", parameters);    
    _post.success(function(request){
        $("#manttcentropoblad").html(request);     
    });	
    _post.error(postError);    
	*/
};


optionCentroPoblado = {
    height: 290,
    width: 700,
    colNames: ["Tipo", "Codigo", "codcen","Nombre","Zona","Nombre Completo","Desde","Hasta","Estado"  ],
    colModel: [
        {name:'ctippob', index:'ctippob', width:50, align: 'center'},
        {name:'mpoblad', index:'mpoblad', width:80, hidden: true},
        {name:'ccodcen', index:'ccodcen', width:50, hidden: true},
        {name:'vnompob', index:'vnompob', width:150} ,
        {name:'cidzona', index:'cidzona', width:50},
        {name:'tnompob', index:'tnompob', width:250},
        {name:'dfecdes', index:'dfecdes', width:50},
        {name:'dfechas', index:'dfechas', width:50},
        {name:'nestado', index:'nestado', width:50}],
    caption: "Busqueda",
    hidegrid: true,
      
    ondblClickRow: verDatos
}


bindkeysCentroPoblado = {"onEnter": function( rowid ) {}};

buscarCentroPoblado = function() {
    valid = true;
  
    if(valid==true) {    
    	//alert("algo");
        parameters = {
            "name": "tblResult",
            "procedure": "registro.contrpob",
            "parameters": '{' +
            '"p_tipo":"01"'+
            '}'
        };
        
        proceso = function(requestData){
            $("#panelResult").html(requestData);
            records = $("#ctblResult").val();
            if(records > 0) {
                actualizarGrid("tblResult", optionCentroPoblado, bindkeysCentroPoblado);
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

buscarCentroPoblado2 = function() {
    valid = true;
  
    if(valid==true) {    
    	//alert("algo");
        parameters = {
            "name": "tblResult",
            "procedure": "registro.contrpob2",
            "parameters": '{' +                        
            '"p_busq":"' + $("#txtbusq").val().toUpperCase() + '"' +
            
            '}'
        };
        
        proceso = function(requestData){
            $("#panelResult").html(requestData);
            records = $("#ctblResult").val();
            if(records > 0) {
                actualizarGrid("tblResult", optionCentroPoblado, bindkeysCentroPoblado);
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
	buscarCentroPoblado();
     
    inicializarGrid("tblResult", optionCentroPoblado);
    
    $("#panelbusqueda").on("keyup", "input", function(e) {
        if(e.keyCode == 13){
        	buscarCentroPoblado2();
        }
    });
    
    $("#btnbuscar").button("option", "icons", {primary:'ui-icon-search'});

    
    $(".pnl").on("focus", function() {
        $("#c_codigocontrib").val("");
        $("#c_predial").val("");
    });
    
    
    $("#btnbuscar").click(buscarCentroPoblado2);
    
    /*
    $("#btningresar").click(function() {
    	
    	openDialog1("mantenimientos/frmcentropoblado","400","400","Centro Poblado");
    });   */ 		     
});


function manttcentrpob(p_tipo){
var p_ccodcen=$("#txtcodcentropobl").val();
var p_ctipcen=$("#cbotipo").val();		
var p_vnombr=$("#txtcentropobl").val(); 	
var p_cdistri=	$("#cboPostal").val();
var p_cidzona=$("#nrozona").val();
var p_dfecdes=$("#txtdesde").val();
var p_dfechas=$("#txthasta").val();
var p_nestado="1";	
if (p_tipo=="3"){
	deshabilitarComponente("txtcodcentropobl",false);
	deshabilitarComponente("cbotipo",false);						
	deshabilitarComponente("txtcentropobl",false);
	deshabilitarComponente("cbotipo",false);
	deshabilitarComponente("cboPostal",false);
	deshabilitarComponente("nrozona",false);
	deshabilitarComponente("txtdesde",false);
	deshabilitarComponente("txthasta",false);
	p_nestado="0";
}

$.ajax( {
	dataType : "html",
	type : "POST",
	url : path + "/mantenimientos/manttcentrpob/",
	data :  "p_ccodcen="+p_ccodcen+
			 "&p_ctipcen="+p_ctipcen+
			 "&p_vnombr="+p_vnombr+
			 "&p_cdistri="+p_cdistri+
			 "&p_cidzona="+p_cidzona+
			 "&p_dfecdes="+p_dfecdes+
			 "&p_dfechas="+p_dfechas+
			 "&p_nestado="+p_nestado,
	beforeSend : function(data) {
		$('#manttcentropoblad').html('Procesando...');
	},
	success : function(requestData) {
		$("#manttcentropoblad").html(requestData);
	},
	error : function(requestData, strError, strTipoError) {
		$("#manttcentropoblad").html("Error " + strTipoError + ': ' + strError);
	},
	complete : function(requestData, exito) {
		window.location.reload();
	}
});

}