<div id="panelRustico">
    <table id="tblRustico"></table>
    <div id="ptblRustico"></div>
</div>
<script>
	verarancel = function() {
   openDialogDataFunction1("registro/verrustico", {}, "350", "300", "Detalle del Arancel",null );
   
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
       	onSelectRow: function(id) {
            row = $(this).getRowData(id);;
        }
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
            
        	openDialogWarning("Seleccione la fila a editar.", 380, 150);
        } 
    };
    
    btnEliminarRustico = {
        caption: "Eliminar",
        title: "Eliminar la construcci\u00F3n",
        buttonicon: "ui-icon-trash",
        onClickButton:function(){
        	openDialogWarning("Seleccione la fila a eliminar.", 380, 150);
        }
    };
    

</script> 