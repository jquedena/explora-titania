xviewmcaja = function(){
	
}

bindkeysmcaja = {"onEnter": xviewmcaja};
buscarmcaja = function() {
	/*if(_periodo == undefined || _periodo == null) {
		 $("#txtPeriodo").val('');
		 _periodo ='%'
    }else{
    	
    }*/
  
    parameters = {
        "name": "tblResultmcaja",
        "procedure": "tesoreria.buscar_cajas",
        "parameters": '{' +
        '"p_idsigma":"",' +
        '"p_cnrocaja":"' + $('#txtnrocaja').val() + '",' +
        '"p_cidlocal":"' + $('#cbolocal').val() + '",' +
        '"p_nestado":"' + $('#cboestado').val() + '"' +
        '}'
    };
    
    proceso = function(requestData){
        $("#panelResultmcaja").html(requestData);
        records = $("#ctblResultmcaja").val();
        //if(records > 1) {
            actualizarGrid("tblResultmcaja", optionmcaja, bindkeysmcaja);
            jQuery("#tblResultmcaja").jqGrid('navGrid','#ptblResultmcaja',
            		{edit:true,add:true,del:false,search:false,view:false}, //options
            		{jqModal:true,checkOnUpdate:false,savekey: [true,13], navkeys: [true,38,40], checkOnSubmit : true, reloadAfterSubmit:false, closeOnEscape:true, bottominfo:""}, // edit options
            		{jqModal:true,checkOnUpdate:false,savekey: [true,13], navkeys: [true,38,40], checkOnSubmit : true, reloadAfterSubmit:false, closeOnEscape:true,bottominfo:""}, // add options
            		{reloadAfterSubmit:false,jqModal:false, closeOnEscape:true}, // del options
            		{closeOnEscape:true}, // search options
            		{navkeys: [true,38,40], height:250,jqModal:false,closeOnEscape:true} // view options
            		);
            $("#FrmGrid_tblResultmcaja").submit(function() {
            	alert("guardar");
                //var newUrl = "/cpsb/inventoryInquiry.do?method=getInventoryDetails" + $(this).serialize();
                //$("#inventoryInq").jqGrid("setGridParam","url", url).trigger("reloadGrid");
            });

    };
    
    procesarConsultaSubProceso('registrar', parameters, proceso);        
 
};
 
var vlocales = {value:"9999999999:Seleccionar" +
	";1000000348:LOMAS DE ZAPALLAL" +
	";1000000349:DAVID" +
	"", defaultValue:'9999999999'};

optionmcaja = {
    height: 290,
    width: 1000,
    editurl: "mcajasave",
    colNames: ["C\u00F3digo", "Nro Caja","cidlocal", "Local", "Estado", "drstado", "vusernm", "vhostnm", "vdatetm"],
    colModel: [
        {name:'idsigma', index:'idsigma', width:100,editable: true, align: 'center', frozen: true,editoptions:{readonly:true,size:10}},
        {name:'cnrocaja', index:'cnrocaja', width:90,editable: true, align: 'center', frozen: true,editoptions:{align:"left",size:10}},
        {name:'cidlocal', index:'cidlocal', width:90,editable: true,hidden:true},
        {name:'dlocal', index:'dlocal', width:200,editable: true, align: 'center',edittype:"select",editoptions:vlocales},        
        {name:'nestado', index:'nestado', width:90,editable: true,align:"center",edittype:"checkbox",editoptions:{value:"1:0",defaultValue:"1"},formatter:'checkbox'},
        //{name:'nestado', index:'nestado', width:90,editable: true,align:"center",edittype:"checkbox",editoptions:{value:"1:0",defaultValue:"1"},formatter:'checkbox'}
        {name:'destado', index:'destado', width:90,editable: true,align:"right",hidden:true},
        {name:'vusernm', index:'vusernm', width:90,hidden:true},
        {name:'vhostnm', index:'vhostnm', width:90,hidden:true},
        {name:'vdatetm', index:'vdatetm', width:90,hidden:true}
        
        ],
    caption: "&nbsp;&nbsp;&nbsp;Resultados de la busqueda"
    	

};
$(function(){
	$('#btnbuscar').click(function(){buscarmcaja();});
	contenidocomboContenedor('#cbolocal', '1000000346');
	rows = [["1","Activo"],["0","Inactivo"]];	
	$('#cboestado').html(contenidocombo(rows));
	$('#cboestado').val("1");
	$('#txtestado').val("Activo");
	vlocales = contenidocomboContenedorjqGrid('1000000346');
	alert(vlocales.value);
    //$("#txtlocal").attr("maxlength", 4);
    /*
    $('#txtlocal').keyup(function(e) {
    	if(e.keyCode == 13) {
    		if ($('#txtlocal').val()==''){
    			buscarmcaja();
    		}
    	}
    });*/
	/*$("#txtlocal").bind("autocompletechange", function(event, ui) {
        if(ui.item) {
        	buscarmcaja();
        } else {
        }
    });
    $("#txtestado").bind("autocompletechange", function(event, ui) {
        if(ui.item) {
        	buscarmcaja();
        } else {
        }
    });*/
    inicializarGrid("tblResultmcaja", optionmcaja);
    buscarmcaja();
//---
    
});
