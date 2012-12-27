xview = function(){
};

bindkeys = {"onEnter": xview};
buscarapertcajxfecha = function(_fecha) {
	if(_fecha == undefined || _fecha == null) {
		_fecha = $('#txtdia').val();
    }
	$('#fechaorg').val(_fecha);
    parameters = {
        "name": "tblResultapertcaj",
        "procedure": "tesoreria.cajasapert",
        "parameters": '{' +
        '"p_nvar1":"'+_fecha+'",' +
        '"p_nvar2":"",' +
        '"p_nvar3":"",' +
        '"p_nvar4":""' +
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
    height: 370,
    width: 1000,
    colNames: ["Cajero","Id","ccajero", "ciduser","Inicio","Fin","nestado","Estado","dfecpro","vusernm"
               ,"M.Ingreso","Rec Validos", "Rec. Anulados", "M. a Entregar", "M.Entregado", "Diferencia"],
    colModel: [
        {name:'nccajusuario', index:'nccajusuario',width:220,align: 'left'},
        {name:'idsigma', index:'idsigma',width:30,hidden:false,align:"center"
        	,formatter: function (cellvalue, options, rowObject) {
        		//return cellvalue;
        		if (cellvalue=='---')
        			return '';
        		else
        			return parseInt(cellvalue,10);
            }
        },
        {name:'ccajero', index:'ccajero',width:100,align: 'center',hidden:true},
        {name:'ciduser', index:'ciduser',width:100,hidden:true},
        {name:'cnumini', index:'cnumini',width:75,hidden:false,align:"center"},
        {name:'cnumfin', index:'cnumfin',width:75,hidden:false,align:"center"},
        {name:'nestado', index:'nestado',width:40,hidden:true},
        {name:'nnestado', index:'nnestado', width:60,align:"right"},//Estado
        {name:'dfecpro', index:'dfecpro',width:100,hidden:true},
        {name:'vusernm', index:'vusernm',width:100,hidden:true},
        {name:'nmonape', index:'nmonape', width:70,align: 'right'},//Monto de Apertura
        {name:'nmonval', index:'nmonval', width:70,align:"right"},//Recibos Validos
        {name:'nmonanu', index:'nmonanu', width:90,align:"right"},//Recibos Anulados
        {name:'nmonaentreg', index:'nmonaentreg', width:80,align:"right"},//Monto a Entregar
        {name:'nmonent', index:'nmonent', width:75,align:"right"},//Monto Entregado
        {name:'nmondif', index:'nmondif', width:70,align:"right"}//Diferencia
        ],
    caption: "&nbsp;&nbsp;&nbsp;Resultados de la busqueda"
/*,
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

habilitarCaja = function(){
	var id = $("#tblResultapertcaj").jqGrid('getGridParam','selrow');
	if (id)	{
		
		var row = jQuery("#tblResultapertcaj").jqGrid('getRowData',id);
		
		if(row.nestado=='3'){// cerrado para el dia
			openDialogInfo("La Caja esta Cerrada para el dia de hoy y no se puede volver a habilitar", 400, 130);
			return false;
		}
		dat = {
        "p_cnrcaja":row.ccajero,
        "p_ciduser":row.ciduser,
        "p_fechadia" : $('#fechaorg').val()
		};
		
		_post = $.post(path + "sencillera/prehabsencillera/", dat);
	    _post.success(function(requestData){
	    	if (requestData.v_esttransac=='1'){
	    		//{"v_esttransac":"1","v_edt":"0","v_msg":"En el d\u00eda 2012-10-26 se encuentra Habilitada.","v_idsigma":"0000000013"}
	    		//'0' then 'Habilitada' 
				//'1' then 'Apeturada'
	    		if(requestData.v_edt=='2'){//Apeturadado y habilitado otro dia solo muestra mensaje
	    			openDialogInfo(requestData.v_msg, 400, 150);
	    		}else if(requestData.v_edt=='0'){//Habilitada  hecho insert en esta transaccion para refrescar
	    			 vdatos = {
	 	    		        "idapertura":requestData.v_idsigma,
	 	    		        "codcajero":row.ccajero,
	 	    		        "nomcajero":row.vusernm,
	 	    		        "accion":'0000000001'//0000000001(al habilitar) - 0000000002(al cierre)
	 	    		    };
	 	    		    openDialogData1("sencillera/ventanamonedas", vdatos, 550, 500, "Montos de Ingreso");
 	    			   buscarapertcajxfecha($('#fechaorg').val());
	    		}else if(requestData.v_edt=='1'){//Habilitada hoy pero no hizo el insert ahora mismo no refrescar
	    			 vdatos = {
		 	    		        "idapertura":requestData.v_idsigma,
		 	    		        "codcajero":row.ccajero,
		 	    		        "nomcajero":row.vusernm,
		 	    		        "accion":'0000000001'//0000000001(al habilitar) - 0000000002(al cierre)
		 	    		    };
		 	    		    openDialogData1("sencillera/ventanamonedas", vdatos, 550, 500, "Montos de Ingreso");
		    	}
	    	}else{
	    		//fail v_esttransac=0 v_msg = mensaje a mostrar
	    		openDialogInfo(requestData.v_msg, 400, 150);
	    	}
	    });
	    _post.error(postError);
	    
	} else { 
		openDialogInfo("Seleccionar Fila", 300, 130);
		}
    
};
sumary_totals = function(){
	
    textbox = $(this);
    tdparent = textbox.parent();
    trparent = tdparent.parent();
	
    objmonto = $('#mt_montorow',trparent);
    objtotal = $('#mt_totalrow',trparent);
	
    monto = objmonto.html();
    cant = textbox.val();
    mt_total=cant*monto;
    objtotal.val(mt_total);
	
    mt_totals=0.00;
    $(".mt_total",$('#tbl_monedas')).each(function(){
        mt_totals= mt_totals + $(this).val()*1;
    });
    $('#mt_totals').html(mt_totals);
};
guardarsencillero = function(){

    frmtblmonedas = $("#tbl_monedas").find("select, textarea, input,hidden").serialize();
    vhdid_apert = $('#hdid_apert').val();
    vhdid_cajero = $('#hdid_cajero').val();
    vtxtfech_proc = $('#txtfech_proc').val();
    vhdid_estado= $('#hdid_estado').val();
    vhdaccion = $('#hdaccion').val();
    _post = $.post(path + "sencillera/guardarsencillero/", frmtblmonedas+"&vhdid_apert="+vhdid_apert+"&vhdid_cajero="+vhdid_cajero+"&vtxtfech_proc="+vtxtfech_proc+"&vhdid_estado="+vhdid_estado+"&vhdaccion="+vhdaccion);
    _post.success(function(requestData){
        openDialogInfo(requestData, 400, 150);
        buscarapertcajxfecha($('#fechaorg').val());
    //$('#result').html(requestData);
    });
	
    _post.error(postError);
};


$(function(){
    /*
    $("#txtdia").datepicker({
		 dateFormat : "yy-mm-dd",
		 changeMonth:true,
		 changeYear:true,
		 showOn: "button",
		 buttonImage: jQuery.scriptPath + "img/calendar.gif",
		 buttonImageOnly: true
		 });
    */
    
	$('#btnhabilitar').on('click',function(){habilitarCaja();});
    inicializarGrid("tblResultapertcaj", optionapertcaja);
	buscarapertcajxfecha($('#txtdia').val());
	
	$("#btnbuscar").on("click", function(event){
		buscarapertcajxfecha();
	});
	
});
