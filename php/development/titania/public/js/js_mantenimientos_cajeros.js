xsavemantemcajero = function(){
	datos=$('#dvaccion :input,hidden').serialize();
	console.log(datos);
	_post = $.post(path + "mantenimientos/cajerossave", datos);
	_post.success(function(request){
		 openDialogInfo(request, 400, 150);
	});
	
	_post.error(postError);
}

limpiarobjetos = function(){
	$('input').removeAttr('readonly');
	$('#idsigma').val("");
	$('#usuario').val("");
	$('#ciduser').val("");
	$('#nomusuario').val("");
	$('#idsigmamcaja').val("");
	$('#cnrocaja').val("");
	$('#dlocal').val("");
	$('#cidlocal').val("");
	$('#ccodcos').val("");
	$('#dfecini').val("");
	$('#dfecfin').val("");
	$('#nestado').attr('checked', true);

}

viewmcajero= function(_parameters){
	
	_post = $.post(path + "mantenimientos/cajerosview", _parameters);
	 _post.success(function(request){
		 $('#dvaccion').show();
		 $('#dvbusqueda').hide();
		 $('#panelResultmcajero').hide();
		 
		 $("#dvaccion").html(request);
		
		 $('#btnguardar').button({ icons: {primary:'ui-icon-disk'} })
		 $('#btnguardar').click(function(event){
			 xsavemantemcajero();
		 });
		 $('#btnregresar').button({ icons: {primary:'ui-icon-arrowreturnthick-1-w'} })
		 	.click(
		 			function(){
		 				//location.reload()
		 				$('#dvbusqueda').show();
		 				$('#dvaccion').hide();
		 				$('#panelResultmcajero').show();
		 				buscarmcajero();
	 				}
		 			);
		 if (_parameters.action!='delete'){
			 $("#dfecini,#dfecfin").datepicker({
				 dateFormat : "dd-mm-yy",
				 changeMonth:true,
				 changeYear:true,
				 showOn: "button",
				 buttonImage: jQuery.scriptPath + "img/calendar.gif",
				 buttonImageOnly: true
				 });
		 }
		 if(_parameters.action=='update' || _parameters.action=='delete'){
			 limpiarobjetos();
			$('#idsigma').val(_parameters.idsigma);
			$('#usuario').val(_parameters.usuario);
			$('#ciduser').val(_parameters.ciduser);
			
			$('#cidpers').val(_parameters.idsigmaperson);
			
			$('#nomusuario').val(_parameters.nomusuario);
			$('#idsigmamcaja').val(_parameters.idsigmamcaja);
			$('#cnrocaja').val(_parameters.cnrocaja);
			$('#dlocal').val(_parameters.dlocal);
			$('#cidlocal').val(_parameters.cidlocal);
			$('#ccodcos').val(_parameters.ccodcos);
			$('#dfecini').val(_parameters.dfecini);
			$('#dfecfin').val(_parameters.dfecfin);
			checkval = (_parameters.nestado==0 ? false : true);
			$('#nestado').attr('checked', checkval);
			if (_parameters.action=='delete'){
				$('input').attr('readonly', 'readonly');
				$('#nestado').attr('checked', false);
			}
		 }else if(_parameters.action=='insert'){
			 limpiarobjetos();
		 }
		 themeTextBox();
		 //themeComboBox();
	});
	
	_post.error(postError);
}

xmanteUpdatemcajero = function(numberrow,_row){
	
	if(numberrow == undefined || numberrow == null) {
		row = _row
		
	}else{
		row = $(this).getRowData(numberrow);
	}	 
	row.action='update';
	viewmcajero(row);
}
xmanteNewmcajero=function(){
	//row = {};
	row = new Object();
	row.idsigma='';
	row.usuario='';
	row.nomusuario='';
	row.action='insert';
	//console.log(row);
	
	viewmcajero(row)
}
xmanteDelmcajero = function(){
	var id = $("#tblResultmcajero").jqGrid('getGridParam','selrow');
	if (id)	{
		var row = jQuery("#tblResultmcajero").jqGrid('getRowData',id);
		row.action='delete';
		viewmcajero(row);
	}else 
		openDialogInfo("Seleccionar Fila", 300, 130); 
	
}

bindkeysmcajero = {"onEnter": xmanteUpdatemcajero};
buscarmcajero = function() {
	/*if(_periodo == undefined || _periodo == null) {
		 $("#txtPeriodo").val('');
		 _periodo ='%'
    }else{
    	
    }*/
    parameters = {
        "name": "tblResultmcajero",
        "procedure": "tesoreria.buscar_cajero",
        "parameters": '{' +
        '"p_idsigma":"",' +
        '"p_ciduser":"",' +
        '"p_ccajero":"",' +//nro caja
        '"p_nestado":"' + $('#cboestado').val() + '"' +
        '}'
    };
    
    proceso = function(requestData){
        $("#panelResultmcajero").html(requestData);
        records = $("#ctblResultmcajero").val();
        //if(records > 1) {
            actualizarGrid("tblResultmcajero", optionmcajero, bindkeysmcajero);
    };
    
    procesarConsultaSubProceso('registrar', parameters, proceso);        
 
};
 
optionmcajero = {
    height: 300,
    width: 1000,
    editurl: "mcajerosave",
    colNames: ["C\u00F3digo", "ciduser","Usuario","Codigopersona", "Nombre Usuario", "idsigmamcaja","Nro Caja", "cidlocal", "Agencia","ccodcos","Fecha Inicio","Fecha Fin","Estado","destado","vusernm", "vhostnm", "vdatetm"],
    colModel: [
        {name:'idsigma', index:'idsigma', width:80,editable: true, align: 'center', frozen: true,editoptions:{readonly:true,size:10}},
        {name:'ciduser', index:'ciduser', width:90,editable: true, align: 'center',hidden:true},
        {name:'usuario', index:'usuario', width:90,editable: true,hidden:false},
        {name:'idsigmaperson', index:'idsigmaperson', width:90,editable: true,hidden:true},
        {name:'nomusuario', index:'nomusuario', width:260,editable: true, align: 'left'},
        
        {name:'idsigmamcaja', index:'idsigmamcaja', width:80,editable: true,hidden:true},
        {name:'cnrocaja', index:'cnrocaja', width:70,editable: true, align: 'center'},
        {name:'cidlocal', index:'cidlocal', width:80,editable: true, align: 'center',hidden:true},
        {name:'dlocal', index:'dlocal', width:140,editable: true, align: 'left'},
        
        {name:'ccodcos', index:'ccodcos', width:200,editable: true, align: 'center',hidden:true},
        {name:'dfecini', index:'dfecini', width:100,editable: true, align: 'center',formatter:'date',formatoptions: { newformat: 'd-m-Y'}},
        {name:'dfecfin', index:'dfecfin', width:100,editable: true, align: 'center',formatter:'date',formatoptions: { newformat: 'd-m-Y'}},
        
        
        {name:'nestado', index:'nestado', width:90,editable: true,align:"center",edittype:"checkbox",editoptions:{value:"1:0",defaultValue:"1"},formatter:'checkbox'},
        {name:'destado', index:'destado', width:90,editable: true,align:"right",hidden:true},
        {name:'vusernm', index:'vusernm', width:90,hidden:true},
        {name:'vhostnm', index:'vhostnm', width:90,hidden:true},
        {name:'vdatetm', index:'vdatetm', width:90,hidden:true}
        ],
    caption: "&nbsp;&nbsp;&nbsp;Resultados de la busqueda",
    ondblClickRow: xmanteUpdatemcajero
    	

};
$(function(){
	//contenidocomboContenedorjqGrid(vlocales,'1000000346');
	$('#btnbuscar').click(function(){buscarmcajero();});
	$('#btnnuevo').click(function(){xmanteNewmcajero();});
	$('#btndeshabilitar').click(function(){xmanteDelmcajero();});
	contenidocomboContenedor('#cbolocal', '1000000346');
	rows = [["1","ACTIVO"],["0","INACTIVO"]];	
	$('#cboestado').html(contenidocombo(rows));
	
    //$("#txtlocal").attr("maxlength", 4);
    
 	/*$("#txtlocal").bind("autocompletechange", function(event, ui) {
        if(ui.item) {
        	buscarmcajero();
        } else {
        }
    });
    $("#txtestado").bind("autocompletechange", function(event, ui) {
        if(ui.item) {
        	buscarmcajero();
        } else {
        }
    });*/
    inicializarGrid("tblResultmcajero", optionmcajero);
    buscarmcajero();
//---
    
});
