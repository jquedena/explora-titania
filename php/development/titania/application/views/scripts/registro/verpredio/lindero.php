<div id="panelLindero">
    <table id="tblLindero"></table>
    <div id="ptblLindero"></div>
</div>
<script>
	verlindero = function(rowid, iRow, iCol, e) {
		if(rowid != undefined && rowid != null && rowid !== false ) {
			row = $("#tblLindero").jqGrid('getRowData', rowid);
		} else {
			row = undefined;
			
		}
	    openDialogDataFunction1("registro/verlindero", {}, "500", "350", "Detalle del Lindero", function() {

	    	if(row != undefined) {
		        $("#cboTipLindero").val(row.ctiplin);
		   		$("#cboCardinal").val(row.cptocar);
		        $("#txtcodpropie").val(row.ccodpre);
		   		$("#txt_ubicacion").val(row.vdirecc);       
		   		$("#txt_dpropie").val(row.mperson);
		   		$("#txt_mpropie").val(row.vnombre);
		   		$("#txt_idsigma").val(row.idsigma);
	   		} else {
	   			$("#txt_idsigma").val('-1'); 
	   			} 
	});  
	};
		
	optionLindero = {
		height: 200,
		width: 990,
		rowNum: 5,
		colNames: [
			'Cardinal',
			'Tipo',
			'Predio',          
			'Ubicaci\u00F3n',
			'Contribuyente',
			'Nombres y Apellidos',
			'idsigma',
			'cptocar',
			'ctiplin',
			'dpredio'
		],
		colModel: [
			{name: "vptocar", index: "vptocar", width: 70, align: 'center'},
			{name: "vtiplin", index: "vtiplin", width: 60, align: 'center'},
			{name: "ccodpre", index: "ccodpre", width: 75, align: 'center' },
			{name: "vdirecc", index: "vdirecc", width: 350, align: 'left'},
			{name: "mperson", index: "mperson", width: 100, align: 'center'},
			{name: "vnombre", index: "vnombre", width: 200, align: 'left'},
			{name: "idsigma", index: "idsigma", hidden:true},
			{name: "cptocar", index: "cptocar", hidden:true},
			{name: "ctiplin", index: "ctiplin", hidden:true},
			{name: "dpredio", index: "dpredio", hidden:true}
		],	
		caption: "&nbsp;&nbsp;&nbsp;Linderos",
       	
    };

	btnInsertarColindante = {
        caption: "Agregar&nbsp;&nbsp;",
        title: "Agrega un nuevo nivel al predio",
        buttonicon: "ui-icon-plus",
        onClickButton:function(){
    		verlindero();
        } 
    };

    btnEditarColindante = {
        caption: "Editar&nbsp;&nbsp;",
        title: "Editar el nivel seleccionado",
        buttonicon: "ui-icon-pencil",
        onClickButton:function(){
	        var gsr = $("#tblLindero").jqGrid('getGridParam','selrow');
	        if(gsr){
	        	verlindero(gsr, -1, -1, null);
	        } else { 
	            openDialogWarning("Seleccione la fila a editar.", 380, 150);
	        } 
	    } 
	};
    
    btnEliminarColindante = {
    		  caption: "Eliminar&nbsp;&nbsp;",
    		    title: "Eliminar la construcci\u00F3n",
    		    buttonicon: "ui-icon-trash",
    		    onClickButton:function(){
    		        var gsr = $("#tblLindero").jqGrid('getGridParam','selrow');
    		        indexRow = $("#ctblLindero").val();
    		        if(gsr){
    		        	if(confirm("Seguro de eliminar")){
    		        		if($("#tblLindero").jqGrid('delRowData', gsr)) {
    		        			$("#ctblLindero").val(indexRow - 1);
    		        		} else {
    		        			alert('Error no se pudo eliminar');
    		        		}
    		        	}
    		        } else { 
    		            openDialogWarning("Seleccione la fila a eliminar.", 380, 150);
    		        } 
    		    } 
    		};
</script> 