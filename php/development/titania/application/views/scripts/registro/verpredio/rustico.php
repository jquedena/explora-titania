<div id="panelRustico">
    <table id="tblRustico"></table>
    <div id="ptblRustico"></div>
</div>
<script>
	verarancel = function(rowid, iRow, iCol, e) {
		if(rowid != undefined && rowid != null && rowid !== false ) {
			row = $("#tblRustico").jqGrid('getRowData', rowid);
		} else {
			row = undefined;
		}
   openDialogDataFunction1("registro/verrustico", {}, "350", "300", "Detalle del Arancel", function() {
   	   	
   	if(row != undefined) {
        $("#cboClasificacionRustico").val(row.cclasif);
   		$("#cboCategoria").val(row.ccatego);
        $("#txtArancel").val(row.narance);
   		$("#txt_Hectareas").val(row.nhectar);       
   		$("#txt_Total").val(row.nvalrus);

       }  
	});
	};

	optionRustico = {
			 height: 140,
		        width: 800,
		        rowNum: 5,
		        colNames: [
		          	'Calsificaci\u00F3n',
		         	'Categor\u00EDa',
		        	'Arancel',
		       	'Hect\u00E1rea',
		          	'Total',
	               	'idsigma',
	                	'mrustic',
	              	'cclasif',
	             		'ccatego',
	              	'dpredio',
	              	'nestado',
	              	'cperiod'
		        ],
		        colModel: [
		                   {name: 'vclasif', index:'vclasif', width: 230},
		                   {name: 'vcatego', index:'vcatego', width: 150},
		                   {name: 'narance', index:'narance', width: 100},
		                   {name: 'nhectar', index:'nhectar', width: 100},
		                   {name: 'nvalrus', index:'nvalrus', width: 100},
		                   {name: 'idsigma', index:'idsigma', width: 100, hidden: true},
		                   {name: 'mrustic', index:'mrustic', width: 100, hidden: true},
		                   {name: 'cclasif', index:'cclasif', width: 100, hidden: true},
		                   {name: 'ccatego', index:'ccatego', width: 100, hidden: true},
		                   {name: 'dpredio', index:'dpredio', width: 100, hidden: true},
		                   {name: 'nestado', index:'nestado', width: 100, hidden: true},
		                   {name: 'cperiod', index:'cperiod', width: 100, hidden: true}
		                  
		               ],
		caption: "&nbsp;&nbsp;&nbsp;Arancel",
       	
    };

	btnInsertarRustico = {
        caption: "Agregar&nbsp;&nbsp;",
        title: "Agrega un nuevo nivel al predio",
        buttonicon: "ui-icon-plus",
        onClickButton:function(){
        	verarancel();
        }
    };

    btnEditarRustico = {
        caption: "Editar",
        title: "Editar el nivel seleccionado",
        buttonicon: "ui-icon-pencil",
        onClickButton:function(){
            var gsr = $("#tblRustico").jqGrid('getGridParam','selrow');
            if(gsr){
            	verarancel(gsr, -1, -1, null);
            } else { 
                openDialogWarning("Seleccione la fila a editar.", 380, 150);
            } ;
        }
    };
    
    btnEliminarRustico = {
    		  caption: "Eliminar",
    		    title: "Eliminar la construcci\u00F3n",
    		    buttonicon: "ui-icon-trash",
    		    onClickButton:function(){
    		        var gsr = $("#tblRustico").jqGrid('getGridParam','selrow');
    		        indexRow = $("#ctblRustico").val();
    		        if(gsr){
    		        	if(confirm("Seguro de eliminar")){
    		        		if($("#tblRustico").jqGrid('delRowData', gsr)) {
    		        			$("#ctblRustico").val(indexRow - 1);
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
    

</script> </script> 