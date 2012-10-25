xview = function(){
	
}

bindkeys = {"onEnter": xview};
buscarapertcajxfecha = function(_fecha) {
	if(_fecha == undefined || _fecha == null) {
		_fecha = $('#txtdia').val();
    }	
    parameters = {
        "name": "tblResultapertcaj",
        "procedure": "tesoreria.cajasapert",
        "parameters": '{' +
        '"p_nvar1":"'+_fecha+'",' +
        '"p_nvar2":"",' +
        '"p_nvar3":""' +
        '}'
    };
    
    proceso = function(requestData){
        $("#panelResultapertcaj").html(requestData);
        records = $("#ctblResultapertcaj").val();
        actualizarGrid("tblResultapertcaj", optionapertcaja, bindkeys);
    };

    procesarConsultaSubProceso('registrar', parameters, proceso);        
};
     	//NroCaja| MontoIngreso|RecibosValidos|RecibosAnulados|MontoEntrega|Entregado|Diferencia|Estado
optionapertcaja = {
    height: 290,
    width: 1000,
    colNames: ["Cajero", "Monto Ingreso","Recibos Validos", "Recibos Anulados", "Monto a Entrega", "Monto Entregado", "Diferencia","Estado"],
    colModel: [
        {name:'ccajero', index:'ccajero',width:100,align: 'center'},
        {name:'nmonape', index:'nmonape', width:90,align: 'center'},//Monto de Apertura
        {name:'nmonval', index:'nmonval', width:90,align:"right"},//Recibos Validos
        {name:'nmonanu', index:'nmonanu', width:90,align:"right"},//Recibos Anulados
        {name:'nmonaentreg', index:'nmonaentreg', width:90,align:"right"},//Monto a Entregar
        {name:'nimpmax', index:'nimpmax', width:90,align:"right"},//Monto Entregado
        {name:'nmonent', index:'nmonent', width:90,align:"right"},//Diferencia
        {name:'nnestado', index:'nnestado', width:90,align:"right"}//Estado
        //{name:'rbt', index:'rbt', width:90,editable:true,align:"center",formatter:'radiobutton'}
        ],
       
    caption: "&nbsp;&nbsp;&nbsp;Resultados de la busqueda"/*,
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
    }*/
    /* onSelectRow: function(id) {
        row = $(this).getRowData(id);
        console.log(row);
    },*/
    //ondblClickRow: xviewuit
};

$(function(){
    
    $("#txtdia").datepicker({
		 dateFormat : "yy-mm-dd",
		 changeMonth:true,
		 changeYear:true,
		 showOn: "button",
		 buttonImage: jQuery.scriptPath + "img/calendar.gif",
		 buttonImageOnly: true
		 });
    
    
	$('#btnhabilitar').on('click',function(){habsencillera();})
    inicializarGrid("tblResultapertcaj", optionapertcaja);
	buscarapertcajxfecha($('#txtdia').val());
	
	$("#btnbuscar").on("click", function(event){
		buscarapertcajxfecha();
	});
	
});
