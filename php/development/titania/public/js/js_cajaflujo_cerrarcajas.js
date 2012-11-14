xview = function(){}
xview2 = function(){}
bindkeys = {"onEnter": xview};
bindkeys2 = {"onEnter": xview2};
buscarapertcajxfecha = function(_fecha) {
	if(_fecha == undefined || _fecha == null) {
		_fecha = $('#txtdia').val();
    }

	$('#fechaorg').val(_fecha);
    parameters = {
        "name": "tblResultapertcaj",
        "procedure": "tesoreria.cajasapertagrup",
        "parameters": '{' +
        '"p_dfecpro":"'+_fecha+'",' +
        '"p_numcaja":"",' +
        '"p_op":"1",' +
        '"p_estado":""' +
        '}'
    };
    
    proceso = function(requestData){
        $("#panelResultapertcaj").html(requestData);
        actualizarGrid("tblResultapertcaj", optionapertcaja, bindkeys);
    };
    procesarConsultaSubProceso('registrar', parameters, proceso);
    
    parameters2 = {
            "name": "tblResultapertcajtotales",
            "procedure": "tesoreria.cajasapertagrup",
            "parameters": '{' +
            '"p_dfecpro":"'+_fecha+'",' +
            '"p_numcaja":"",' +
            '"p_op":"2",' +
            '"p_estado":""' +
            '}'
        };
    
    proceso2 = function(requestData){
        $("#panelResultapertcajtotales").html(requestData);
        actualizarGrid("tblResultapertcajtotales", optioncajasagruplocal, bindkeys2);
    };
    procesarConsultaSubProceso('registrar', parameters2, proceso2);
    
    /*Graficos*/
    _post2 = $.post(path + "cajaflujo/graficocajeros/", "fecha1="+_fecha+"&fecha2="+_fecha);
    _post2.success(function(requestData){
        $('#scriptgraf').html(requestData);
    });
	
    _post2.error(postError);
    
};
optionapertcaja = {
		height: 370,
	    width: 1000,
	    colNames: ["Cajero","ccajero", "idsigmaapert","nestado","Estado","dfecpro","usuario"
	               ,"M.Ingreso","Rec Validos", "Rec. Anulados", "M. a Entregar", "M.Entregado", "Diferencia"],
	    colModel: [
	        {name:'nccajusuario', index:'nccajusuario',width:270,align: 'left'},
	        /*{name:'idsigma', index:'idsigma',width:30,hidden:false,align:"center"
	        	,formatter: function (cellvalue, options, rowObject) {
	        		//return cellvalue;
	        		if (cellvalue=='---')
	        			return '';
	        		else
	        			return parseInt(cellvalue,10);
	            }
	        },*/
	        {name:'ccajero', index:'ccajero',width:100,align: 'center',hidden:true},
	        {name:'idsigmaapert', index:'idsigmaapert',width:100,hidden:true},
	        {name:'nestado', index:'nestado',width:40,hidden:true},
	        {name:'nnestado', index:'nnestado', width:80,align:"right"},//Estado
	        {name:'dfecpro', index:'dfecpro',width:100,hidden:true},
	        {name:'usuario', index:'usuario',width:100,hidden:true},
	        
	        {name:'nmonape', index:'nmonape', width:100,align: 'right'},//Monto de Apertura
	        {name:'nmonval', index:'nmonval', width:100,align:"right"},//Recibos Validos
	        {name:'nmonanu', index:'nmonanu', width:100,align:"right"},//Recibos Anulados
	        {name:'nmonaentreg', index:'nmonaentreg', width:100,align:"right"},//Monto a Entregar
	        {name:'nmonent', index:'nmonent', width:90,align:"right"},//Monto Entregado
	        {name:'nmondif', index:'nmondif', width:90,align:"right"}//Diferencia
	        ],
	    caption: "&nbsp;&nbsp;&nbsp;Totales por Cajero"
	};

optioncajasagruplocal = {
		height: 150,
	    width: 1000,
	    colNames: ["Cod Agencia","Agencia"
	               ,"M.Ingreso","Rec Validos", "Rec. Anulados", "M. a Entregar", "M.Entregado", "Diferencia"],
	    colModel: [
	        {name:'cidlocal', index:'cidlocal',width:80,align: 'left',hidden:true},
	        {name:'dlocal', index:'dlocal',width:270,align: 'left'},
	        
	        {name:'nmonape', index:'nmonape', width:113,align: 'right'},//Monto de Apertura
	        {name:'nmonval', index:'nmonval', width:113,align:"right"},//Recibos Validos
	        {name:'nmonanu', index:'nmonanu', width:113,align:"right"},//Recibos Anulados
	        {name:'nmonaentreg', index:'nmonaentreg', width:100,align:"right"},//Monto a Entregar
	        {name:'nmonent', index:'nmonent', width:103,align:"right"},//Monto Entregado
	        {name:'nmondif', index:'nmondif', width:105,align:"right"}//Diferencia
	        ],
	    caption: "&nbsp;&nbsp;&nbsp;Totales por Agencia"
	};

$(function(){
    inicializarGrid("tblResultapertcaj", optionapertcaja);
    inicializarGrid("tblResultapertcajtotales", optioncajasagruplocal);
	buscarapertcajxfecha($('#txtdia').val());
	$("#btnbuscar").on("click", function(event){
		buscarapertcajxfecha();
	});
	
});
