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

var zona ={value:"" +
		"9999999999:Seleccionar" +		
		";01:01" +
		";02:02" +
		";03:03" +
		";04:04" +
		";05:05" +
		";06:06" +		
		"", defaultValue:'9999999999'};

var tipos ={value:"" +
		"9999999999:Seleccionar" +		
		";1000000026:Urb."+
		";1000000027:P.J."+
		";1000000028:UNID.VEC."+
		";1000000029:C.H."+
		";1000000030:Asc."+
		";1000000031:A.H."+
		";1000000032:COOP.VIV."+
		";1000000033:LOT."+
		";1000000034:BAR."+
		";1000000035:Cd."+
		";1000000036:COM."+
		";1000000037:PROG.VIV."+
		";1000000038:Res."+
		";1000000039:ASOC.VIV."+
		";1000000040:ASOC.PRO."+
		";1000000041:ASOC.RES."+
		";1000000042:COM.VEC"+
		";1000000043:CP.RURAL"+
		";1000000044:C.H."+
		";1000000045:ASOC.AGRO."+
		";1000000046:ASOC.PEC."+
		";1000000047:FUN."+
		";1000000048:COM.CAM"+
		";1000000049:AGRU.FAM."+
		";1000000050:AGRU.POB."+
		";1000000051:ASOC.VIV."+
		";1000000052:PAR."+
		";1000000053:COOP.AGRA."+
		";1000000054:PAR."+
		";1000000055:ASOC.POB."+
		";1000000056:ASOC.PER"+
		";1000000057:COOP.AGRA"+
		";1000000058:PROG.VIV.RES."+
		";1000000059:PAM."+
		";1000000060:GRAN."+
		";1000000062:PROY."+
		";1000000063:POT."+
		";1000000064:PRO.VIV."+
		";1000000065:ASOC.TRAB"+
		";1000000066:ASOC.PADR"+
		";1000000067:SECT."+
		";1000000068:HABILITACION URBANA"+
		";1000000069:PARQUE"+
		";1000000061:VILLA RESIDENCIAL"+		
		"", defaultValue:'9999999999'};

optionCentroPoblado = {
	editurl: "centrpobsave",	
    height: 290,
    width: 700,
    colNames: ["Codigo","Tipo",  "codcen","Nombre","Zona","Nombre Completo","Desde","Hasta","Estado"  ],
    colModel: [
        {name:'mpoblad', index:'mpoblad', frozen:true,editable: true,width:80 ,editoptions:{readonly:true,size:10}},       
        {name:'ctippob', index:'ctippob', editable: true, width:50, align: 'center',frozen: true,edittype:"select",editoptions:tipos},
        {name:'ccodcen', index:'ccodcen', width:50, hidden: true},
        {name:'vnompob', index:'vnompob', editable: true, width:150} ,
        {name:'cidzona', index:'cidzona', editable: true, width:50, align: 'center',frozen: true,edittype:"select",editoptions:zona},
        {name:'tnompob', index:'tnompob', width:250},
        {name:'dfecdes', index:'dfecdes', editable: true,width:50,frozen: true,edittype:"select",editoptions:anios},
        {name:'dfechas', index:'dfechas', editable: true,width:50,frozen: true,edittype:"select",editoptions:anios},
        {name:'nestado', index:'nestado', width:90,editable:true,align:"center",edittype:"checkbox",editoptions:{value:"1:0",defaultValue:"1"},formatter:'checkbox'}],
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