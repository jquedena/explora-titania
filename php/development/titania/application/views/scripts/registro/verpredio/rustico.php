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
   		$("#_mrustic").val(row.mrustic);
   		$("#txtidsigma").val(row.idsigma);
   	  }  else {
   		$("#_mrustic").val('11');
   		$("#txtidsigma").val('-1');
   	   	  }
	});
	};

	optionRustico = {
			 height: 200,
		        width: 990,
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
		                   {name: 'vclasif', index:'vclasif', width: 320},
		                   {name: 'vcatego', index:'vcatego', width: 150},
		                   {name: 'narance', index:'narance', width: 100},
		                   {name: 'nhectar', index:'nhectar', width: 100},
		                   {name: 'nvalrus', index:'nvalrus', width: 100},//Hiden
		                   {name: 'idsigma', index:'idsigma', width: 100 , hidden: true},
		                   {name: 'mrustic', index:'mrustic', width: 100 , hidden: true },
		                   {name: 'cclasif', index:'cclasif', width: 100 , hidden: true},
		                   {name: 'ccatego', index:'ccatego', width: 100 , hidden: true },
		                   {name: 'dpredio', index:'dpredio', width: 100 , hidden: true },
		                   {name: 'nestado', index:'nestado', width: 100 , hidden: true },
		                   {name: 'cperiod', index:'cperiod', width: 100 , hidden: true }
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
        caption: "Editar&nbsp;&nbsp;",
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
    		  caption: "Eliminar&nbsp;&nbsp;",
    		    title: "Eliminar la construcci\u00F3n",
    		    buttonicon: "ui-icon-trash",
    		    onClickButton:function(){
    		        var gsr = $("#tblRustico").jqGrid('getGridParam','selrow');
    		        indexRow = $("#ctblRustico").val();
    		        if(gsr){
    		        	if(confirm("Seguro de eliminar")){        		        	
    		        		/*if($("#tblRustico").jqGrid('delRowData', gsr)) {
    		        			$("#ctblRustico").val(indexRow - 1);
    		        		} else {
    		        			alert('Error no se pudo eliminar');
    		        		}*/ 

    	        			var row2 = $("#tblRustico").jqGrid('getRowData', gsr);

    		        		row = $.extend(row, {
    		        			
    		        			vclasif: row2.vclasif,
    		        			vcatego: row2.vcatego,
    		        			narance: row2.narance,
    		        			nhectar: row2.nhectar,
    		              		nvalrus: row2.nvalrus,
    		              		idsigma: row2.idsigma, //"0000000009"
    		              		mrustic: row2.mrustic,
    		              		cclasif: row2.cclasif,
    		              		ccatego: row2.ccatego,
    		              		dpredio: row2.dpredio,
    		              		nestado: '0',
    		              		cperiod: row2.cperiod
    		        		});
    		        		console.log(row);
    		        		
    		        		_post = $.post(path + "registro/guardarrustico", row);
    		        	    _post.success(function(data){
    		        	    	optionRustico = $.extend(optionRustico, {data: data.data});
    		        	    	procesarJSON("panelRustico", "tblRustico", optionRustico, null, function(){
    		        	            $("#tblRustico").jqGrid('navGrid', '#ptblRustico', {edit:false, add:false, del:false, search:false, refresh:false});
    		        	            $("#tblRustico").jqGrid('navButtonAdd', '#ptblRustico', btnInsertarRustico);
    		        	            $("#tblRustico").jqGrid('navSeparatorAdd','#ptblRustico');
    		        	            $("#tblRustico").jqGrid('navButtonAdd','#ptblRustico', btnEditarRustico);
    		        	            $("#tblRustico").jqGrid('navSeparatorAdd','#ptblRustico');
    		        	            $("#tblRustico").jqGrid('navButtonAdd','#ptblRustico', btnEliminarRustico);
    		        	        });
    		        		});
    		        	    _post.error(postError);
    		        	    
    		        		
    		        		
    		        	}
    		            console.log(gsr);
    		            // $("#tblPiso").jqGrid('GridToForm',gsr,"#order"); 
    		        } else { 
    		            openDialogWarning("Seleccione la fila a eliminar.", 380, 150);
    		        } 
    		    } 
    		};
    

</script>