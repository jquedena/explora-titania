xsavemanteperson = function(){
	
	var idsigma = $("#idsigma").val();  
	var mpoblad = $("#cbocentrpob").val();
	var mviadis = $("#cbovia").val();
	var nladvia = $("#txtnlado").val();
	var ncuaini = $("#txtcuadraini").val();
	var ncuafin = $("#txtcuadrafin").val();
	var narance = $("#txtarancel").val();	
	var nfacbar = $("#txtfacbarr").val();
	var cperiod = $("#cboanios").val()
	var nestado = $("#cboestado").val();
	
	var datos="idsigma="+idsigma+"&mpoblad="+mpoblad+"&mviadis="+mviadis+"&nladvia="+nladvia+
	"&ncuaini="+ncuaini+"&ncuafin="+ncuafin+"&narance="+narance+"&nfacbar="+nfacbar+"&cperiod="+cperiod+
	"&nestado="+nestado;
	
	console.log(datos);
	//alert(datos);
	_post = $.post(path + "mantenimientos/arancelsave", datos);
	_post.success(function(request){
		 openDialogInfo(request, 400, 150);
		 location.reload();
	});
	
	_post.error(postError);
} 

xmantepersonnew=function(){
	//row = {};
	row = new Object();
	row.id_person='';
	row.crazsoc='';
	row.direccf='';
	row.action='insert';
	//console.log(row);
	
	view(row)
}
xmantepersonupdate = function(numberrow,_row){
	
	if(numberrow == undefined || numberrow == null) {
		row = _row
		
	}else{
		row = $(this).getRowData(numberrow);
		cidpers = row.id_person;
		crazsoc = row.crazsoc;
		direccf = row.direccf;
	}
		
	//if(numberrow == undefined || numberrow == null) {
	//	row = {"name": "tblResultpersons"};
	//} else {
		
	//}
	 
	row.action='update';
	view(row);
}

view= function(_parameters){
	
	_post = $.post(path + "mantenimientos/arancelview", _parameters);
	 _post.success(function(request){
		 
		 
		 $("#west").html(request);
		 themeComboBox();
		 $('#btnguardar').button({ icons: {primary:'ui-icon-disk'} })
		 $('#btnguardar').click(function(event){
			 xsavemanteperson();
			 
		 });
		 $('#btnregresar').button({ icons: {primary:'ui-icon-arrowreturnthick-1-w'} })
		 	.click(
		 			function(){
		 				location.reload()
	 				}
		 			);
		
		 if(_parameters.action=='update'){
			 $("#txtbuscar").numeric({
				 	decimal: false, 
			    	negative: false
			 	}, function() {
			 		openDialogWarning("Solo Numeros Enteros Positivos.", 150, 90);
			 		this.value = "";
			 		this.focus();
			});
			 
			 $("#txtbuscar").on("keyup", function(e) {
				 row = new Object();
				 row.id_person = $(this).val();
				 if(trim(row.id_person).length > 0){
					 row.id_person=LPad(row.id_person, 10, '0');
					 if(e.keyCode == 13){
						 xmantepersonupdate(null,row);
					 }
				}
				
			 });
			 $("#txtbuscar").show();
			 $('#ds_buscar').show();
		 }else{
			 $("#txtbuscar").hide();
			 $('#ds_buscar').hide();
		 }
	    
	});
	
	_post.error(postError);
}

optionVias = {
    height: 400,
    width: 820,
    colNames: ["Codigo", "Cod. Centr.Poblado", "Centro Poblado","Cod. Via","Via"
               ,"Lado Via","Cuadra Ini","Cuadra Fin","Arancel","Factor Bar","Periodo","Estado",
               "Host","Usuario","Fecha Tran."],
    colModel: [
        {name:'idsigma', index:'idsigma,', width:80, align: 'center',editable: true,frozen: true,editoptions:{readonly:true,size:10}},
        {name:'mpoblad', index:'mpoblad', width:80, hidden: true},
        {name:'tnompob', index:'tnompob', width:150},
        {name:'mviadis', index:'mviadis', width:50, hidden: true} ,
        {name:'tnomvia', index:'tnomvia', width:150},
        {name:'nladvia', index:'nladvia', width:50,editable: true, width:50, align: 'center',frozen: true},
        {name:'ncuaini', index:'ncuaini', width:50,editable: true, width:50, align: 'center',frozen: true},
        {name:'ncuafin', index:'ncuafin', width:50,editable: true, width:50, align: 'center',frozen: true},
        {name:'narance', index:'narance', width:50,editable: true, width:50, align: 'center',frozen: true},
        {name:'nfacbar', index:'nfacbar', width:50,editable: true, width:50, align: 'center',frozen: true},
        {name:'cperiod', index:'cperiod', width:50,editable: true, width:50, align: 'center',frozen: true},
        {name:'nestado', index:'nestado', width:50,editable:true,align:"center",edittype:"checkbox",editoptions:{value:"1:0",defaultValue:"1"},formatter:'checkbox'} ,   
        {name:'vhostnm', index:'vhostnm', width:50, hidden: true},
        {name:'vusernm', index:'vusernm', width:50, hidden: true},
        {name:'ddatetm', index:'ddatetm', width:50, hidden: true}     
        
        ],
    caption: "&nbsp;&nbsp;&nbsp",
    hidegrid: true,
      
    ondblClickRow: xmantepersonupdate
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
    
    
    $("#btningresar").click(function() {
    	
    	xmantepersonnew();
    });    		     
});

