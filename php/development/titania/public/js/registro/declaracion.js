var config = {
	  skin:'v2'
	, toolbar: [
	            ['Bold','Italic','Underline','-','NumberedList','BulletedList','-','Outdent','Indent','-','Undo','Redo','-','HorizontalRule','-','Blockquote','CreateDiv','-','JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock','-','TextColor','BGColor'],
	            ['UIColor']
    ]
},

cambioMotivoDeclaracion = function(event, ui) {
    if(ui.item) {
        bVisible = (ui.item.option.value == "1000000091");
        visibility = (bVisible? "hidden": "visible");
        display = (bVisible? "inline": "none");
        $("#panelTerreno").css({"visibility" : visibility});
        $("#tabPredioRustico").css({"display" : display}); // Por Rustico para habilitar
        contenidocomboContenedor("#cboTipoPredioUrbano", (bVisible ? "1000000209": "1000000202")); // Por Rustico para habilitar
    } else {
        openDialogWarning("El valor ingresado no esta en la lista de elementos.", 380, 150);
    }
};

$(function(){
	var hEd = CKEDITOR.instances['txtObservacion'];
	if (hEd) {
	    CKEDITOR.remove(hEd);
	}
	CKEDITOR.replace('txtObservacion', config);

	$("#txtNroDeclaracion").html("");
	$("#dtpFechaDeclaracion, #dtpFechaVigencia").datepicker({
		dateFormat: "dd/mm/yy",
		showOn: "button",
		buttonImage: pathImage + "calendar.gif",
		    buttonImageOnly: true
	});

	themeTextBox();
	themeComboBox("#cellMotivo select");    
}); 



//$("#btnAceptarDeclaracion").button({
//icons: {primary:'ui-icon-check'}
//}).bind("click", function(){
//mhresum = {
//	idsigma: $("#hdnIdDeclaracion").val(),
//ctipdat: "1000000002", /* Registro Tributario */
//vnrodoc: 0,  //$("#hdnId").val(),
//dfecdoc: $("#dtpFechaDeclaracion").val(),
//cmotivo: $("#cboMotivo").val(), 
//dataidsigma: $("#cboMotivo option:selected").attr("data-idsigma"),  
//ctipdoc: "1000000021", /* Declaracion Jurada */ 
//vnrodjj: $("#txtNroDeclaracion").text(),
//vobserv: $("#txtObservacion").val(),
//nestado: "1",
//cperini: $("#dtpFechaVigencia").val(),
//cperfin: $("#hdnAnioTermino").val(),
//mperson: $("#hdnIdPersona").val(),
//mpredio: $("#txtMpredio").val() 
//};
//console.log(mhresum);
//
//if ($("#dtpFechaDeclaracion").val()==''){
//alert("Ingrese la fecha de declaracion ");
//	return false;
//} 
//
//if ($("#cboMotivo").val()=='9999999999'){
//alert("Seleccione el motivo.");
//$("#cboMotivo").focus();
//	return false; 
//}
//
//		
//
//_post = $.post(path + "registro/guardardeclaracion", mhresum);
//_post.success(function(data){
//	
//	openDialogWarning("Los datos han sido guardados.", 380, 150);
//  
//closeDialog('jqDialog1');
//	});
//    
//});
//$("#btnCancelarDeclaracion").button({
//icons: {primary:'ui-icon-arrowreturnthick-1-w'}
//}).bind("click", function(){
//closeDialog("jqDialog1");
//    });
//
//  function verificar(){    		
//		//alert(""+$("#txtMotivo").val());
////1000000008 --Compra
////1000000009 --Venta
//	 
//  /*if ( $("#cboMotivo").val()=='2' ||  $("#cboMotivo").val()=='3' ){
//	$("#dvBajalt").show();			  		
//}else{
//	$("#dvBajalt").hide();		
//}*/
//  }	  	 
//
//    $("#txtMotivo").bind("autocompleteselect", verificar);
//$("#txtMotivo").bind("autocompletechange", verificar);
//
////$("#dvBajalt").hide();	
//
//
//$("#btnVerPredios").button({
//icons: {primary:'ui-icon-search'}
//}).bind("click", function(){
//
//row2={
//		mperson: $("#hdnIdPersona").val()                	
//	}; 
//
//openDialogData2("registro/busqpredio", row2 , "600", "500", "Predios", function() {
//
//if(row != undefined) {
//	$("#txt_idsigma").val(row.idsigma);
//$("#txtnombre").val(row.nombre);
//  //	$("#txt_instcnitems").val(row.cnitems);
//$("#txtdni").val(row.dni);
//  //	$("#txt_instctipdat").val(row.ctipdat);       
//  //	$("#txt_instvnrodoc").val(row.vnrodoc);
//   		
// //		$("#txt_instdafecta").val(row.dafecta);     
//   }  else {
//	   $("#txt_idsigma").val('-1');  
//    		   
//    	   		}
//    		});
//            
//        }); 
//
//        
//        
//    });
//
//$(function(){
//
//	/*optionPerson = {
//		    height: 150,
//		    width: 450,
//		    colNames: ["C\u00F3digo", "Nombre", "Direcci\u00F3n Fiscal"],
//		    colModel: [
//		        {name:'id_person', index:'cidpers', width:80, align: 'center', frozen: true},
//		        {name:'crazsoc', index:'crazsoc', width:150},
//		        {name:'direccf', index:'direccf', width:90} ],
//		    caption: "&nbsp;&nbsp;&nbsp;Personas Participantes"
//	};
//
//		btnInsertarPersona = {
//		    caption: "Agregar&nbsp;&nbsp;",
//		    title: "Agrega una Persona",
//		    buttonicon: "ui-icon-plus",
//		    onClickButton:function(){
//		    	openDialog2("registro/busqprediocontr",  "300", "150", "Persona"	);
//		    } 
//		};
//	
//		    
//		btnEliminarPersona = {
//		    caption: "Eliminar",
//		    title: "Eliminar la Persona",
//		    buttonicon: "ui-icon-trash",
//		    onClickButton:function(){
//		        var gsr = $("#tblResultmPredio").jqGrid('getGridParam','selrow');
//		        indexRow = $("#ctblPredio").val();
//		        if(gsr){
//		        	if(confirm("Seguro de eliminar")){
//		        		if($("#tblResultmPredio").jqGrid('delRowData', gsr)) {
//		        			$("#ctblPredio").val(indexRow - 1);
//		        		} else {
//		        			alert('Error no se pudo eliminar');
//		        		}
//		        	}
//		            console.log(gsr);
//		            // $("#tblPiso").jqGrid('GridToForm',gsr,"#order"); 
//		        } else { 
//		            openDialogWarning("Seleccione la fila a eliminar.", 380, 150);
//		        } 
//		    } 
//		};
//
//
//	 navPanelPersona = function() {
//	        $("#tblResultmPredio").jqGrid('navGrid', '#ptblResultmPredio', {edit:false, add:false, del:false, search:false, refresh:false});
//	        $("#tblResultmPredio").jqGrid('navButtonAdd', '#ptblResultmPredio', btnInsertarPersona);
//	        //$("#tblResultmPredio").jqGrid('navSeparatorAdd','#ptblResultmPredio');
//	        //$("#tblResultmPredio").jqGrid('navButtonAdd','#ptblResultmPredio', btnEditarPredio);
//	        //$("#tblResultmPredio").jqGrid('navSeparatorAdd','#ptblResultmPredio');
//	        $("#tblResultmPredio").jqGrid('navButtonAdd','#ptblResultmPredio', btnEliminarPersona);
//	    };
//
//	    inicializarGrid("tblResultmPredio", optionPerson,null,navPanelPersona);
//*/
