xsavemanteperson = function(){
	datos=$('#divdatos :input,select').serialize();
	console.log(datos);
	//alert(datos);
	_post = $.post(path + "mantenimientos/personasave", datos);
	_post.success(function(request){
		 openDialogInfo(request, 400, 150);
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
	
	_post = $.post(path + "mantenimientos/personaview", _parameters);
	 _post.success(function(request){
		 $("#panelRegistro").html(request);
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
		 $("#fecnace").datepicker({
			 dateFormat : "yy-mm-dd",
			 changeMonth:true,
			 changeYear:true,
			 showOn: "button",
			 buttonImage: jQuery.scriptPath + "img/calendar.gif",
			 buttonImageOnly: true
			 });
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

optionPerson = {
    height: 270,
    width: 1000,
    colNames: ["C\u00F3digo", "Administrado", "Direcci\u00F3n Fiscal"],
    colModel: [
        {name:'id_person', index:'cidpers', width:80, align: 'center', frozen: true},
        {name:'crazsoc', index:'crazsoc', width:420},
        {name:'direccf', index:'direccf', width:420} ],
    caption: "&nbsp;&nbsp;&nbsp;Resultados de la busqueda",
    /*onSelectRow: function(id) {
        row = $(this).getRowData(id);
        console.log(row);
    },*/
    ondblClickRow: xmantepersonupdate
}
bindkeysPerson = {"onEnter": xmantepersonupdate};
buscarPerson = function() {
    valid = false;
    objnombre	=	$("#ds_nombre");
    objapepat	=	$("#ds_apepat");
    objapemat	=	$("#ds_apemat")
    objcodcontri=	$("#id_person")
    objnrodni 	=	$("#nrodni")
    if(trim(objcodcontri.val()).length > 0){
    	objcodcontri.val(LPad(objcodcontri.val(), 10, '0'));
    }

    valid = valid || (trim(objnombre.val()).length > 0);
    valid = valid || (trim(objapepat.val()).length > 0);
    valid = valid || (trim(objapemat.val()).length > 0);
    valid = valid || (trim(objcodcontri.val()).length > 0);
    valid = valid || (trim(objnrodni.val()).length > 8);

    if(valid) {    
        parameters = {
            "name": "tblResultpersons",
            "procedure": "public.buscar_persona",
            "parameters": '{' +
            '"p_nvar1":"' + objcodcontri.val().toUpperCase() + '",' +
            '"p_nvar2":"' + objnombre.val().toUpperCase() + '",' +
            '"p_nvar3":"' + objapepat.val().toUpperCase() + '",' +
            '"p_nvar4":"' + objapemat.val() + '",' +
            '"p_nvar5":"' + objnrodni.val() + '"' +
            '}'
        };
        
        proceso = function(requestData){
            $("#panelResultpersons").html(requestData);
            records = $("#ctblResultpersons").val();
            //if(records > 1) {
                actualizarGrid("tblResultpersons", optionPerson, bindkeysPerson);
            //} else {
            //	xmantepersonupdate();
            //}
        };
        
        procesarConsultaSubProceso('registrar', parameters, proceso);        
    } else {
        openDialogWarning("Ingrese un valor en los campos de busqueda.", 380, 150);
    }
};
$(function(){
    $("#id_person").numeric({
        decimal: false, 
        negative: false
    }, function() {
        openDialogWarning("Solo Numeros Enteros Positivos.", 150, 90);
        this.value = "";
        this.focus();
    });
    
    //$("#btnbuscar").button("option", "icons", {primary:'ui-icon-search'});
    $('#btnbuscar').button({ icons: {primary:'ui-icon-search'} }).click(buscarPerson);
    $('#btninsert').button({ icons: {primary:'ui-icon-document'} }).click(xmantepersonnew);
    inicializarGrid("tblResultpersons", optionPerson);
    
    $("#only ,#common").on("keyup", "input", function(e) {
        if(e.keyCode == 13){
            buscarPerson();
        }
    });
    
    $("#id_person, #id_nrodni").on("focus", function() {
        $("#only input.ui-text").val("");
        $("#common input.ui-text").val("");
    });
    
    $("#common input.ui-text").on("focus", function() {
        $("#only input.ui-text").val("");
    });
    
});
