/**
 * 
 */
$(function(){

	verPredio = function(rowid, iRow, iCol, e) {
		if(rowid != undefined && rowid != null && rowid !== false ) {
			row = $("#tblResultmPredio").jqGrid('getRowData', rowid);
		} else {
			row = undefined;
		}
		
		
	};

	bindkeysmpredio = {"onEnter": verPredio};

	buscarmpredio = function() {
		/*if(_periodo == undefined || _periodo == null) {
			 $("#txtPeriodo").val('');
			 _periodo ='%'
	    }else{
	    	
	    }*/
	    parameters = {
	        "name": "tblResultmPredio",
	        "procedure": "registro.mostrarpredios",
	        "parameters": '{' +
	        '"p_cperiod":"01"' +
	        '}'
	    };
	    
	    proceso = function(requestData){
	        $("#panelResultmpredio").html(requestData);
	        records = $("#ctblResultmpredio").val();
	        //if(records > 1) {
	            actualizarGrid("tblResultmPredio", optionmpredio, bindkeysmpredio,navPanelPredio);
	    };
	    
	    procesarConsultaSubProceso('registrar', parameters, proceso);        
	 
	};
	 
	optionmpredio= {
	    height: 200,
	    width: 400,
	    editurl: "",
	    colNames: [              
				   "C\u00F3digo",
				   "Nombre",
				   "dni"
	               ],
	    colModel: [
	        {name:'codigo', index:'codigo', width:80,editable: true, align: 'center', frozen: true,editoptions:{readonly:true,size:10}},
	        {name:'nombre', index:'nombre', width:90,editable: true, align: 'center'},
	        {name:'dni', index:'dni', width:90,editable: true }
	        ],
	    caption: "&nbsp;&nbsp;&nbsp;Resultados de la busqueda",
	    ondblClickRow: verPredio
	    	

	};

		btnInsertarPersona = {
		    caption: "Agregar&nbsp;&nbsp;",
		    title: "Agrega una Persona",
		    buttonicon: "ui-icon-plus",
		    onClickButton:function(){
		    	openDialog2("registro/busqprediocontr",  "300", "150", "Persona"	);
		    } 
		};

	
		    
		btnEliminarPersona = {
		    caption: "Eliminar",
		    title: "Eliminar la construcci\u00F3n",
		    buttonicon: "ui-icon-trash",
		    onClickButton:function(){
		        var gsr = $("#tblResultmPredio").jqGrid('getGridParam','selrow');
		        indexRow = $("#ctblPredio").val();
		        if(gsr){
		        	if(confirm("Seguro de eliminar")){
		        		if($("#tblResultmPredio").jqGrid('delRowData', gsr)) {
		        			$("#ctblPredio").val(indexRow - 1);
		        		} else {
		        			alert('Error no se pudo eliminar');
		        		}
		        	}
		            console.log(gsr);
		            // $("#tblPiso").jqGrid('GridToForm',gsr,"#order"); 
		        } else { 
		            openDialogWarning("Seleccione la fila a eliminar.", 380, 150);
		        } 
		    } 
		};


	 navPanelPersona = function() {
	        $("#tblResultmPredio").jqGrid('navGrid', '#ptblResultmPredio', {edit:false, add:false, del:false, search:false, refresh:false});
	        $("#tblResultmPredio").jqGrid('navButtonAdd', '#ptblResultmPredio', btnInsertarPersona);
	        //$("#tblResultmPredio").jqGrid('navSeparatorAdd','#ptblResultmPredio');
	        //$("#tblResultmPredio").jqGrid('navButtonAdd','#ptblResultmPredio', btnEditarPredio);
	        //$("#tblResultmPredio").jqGrid('navSeparatorAdd','#ptblResultmPredio');
	        $("#tblResultmPredio").jqGrid('navButtonAdd','#ptblResultmPredio', btnEliminarPersona);
	    };

	    inicializarGrid("tblResultmPredio", optionmpredio,null,navPanelPersona);


	$(function(){
		//contenidocomboContenedorjqGrid(vlocales,'1000000346');    

	   // buscarmpredio();

	    themeTextBox();
	    themeComboBox();
	//---
	    
	});
			

    
});