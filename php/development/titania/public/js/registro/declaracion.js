/**
 * 
 */

$(function(){

	optionPerson = {
		    height: 150,
		    width: 450,
		    colNames: ["C\u00F3digo", "Nombre", "Direcci\u00F3n Fiscal"],
		    colModel: [
		        {name:'id_person', index:'cidpers', width:80, align: 'center', frozen: true},
		        {name:'crazsoc', index:'crazsoc', width:150},
		        {name:'direccf', index:'direccf', width:90} ],
		    caption: "&nbsp;&nbsp;&nbsp;Personas Participantes"
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
		    title: "Eliminar la Persona",
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

	    inicializarGrid("tblResultmPredio", optionPerson,null,navPanelPersona);


	$(function(){
	
	    themeTextBox();
	    themeComboBox();
	//---
	    
	});
			

    
});