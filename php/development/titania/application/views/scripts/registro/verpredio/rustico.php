<div id="panelRustico"></div>
<script>
	verarancel = function() {
   openDialogDataFunction1("registro/verrustico", {}, "350", "300", "Detalle del Arancel",null );
   
	};

	optionPredioArancel = {
			data:[
					{dclasif:'xxxxx',mclasif:'aaaaa',dcatego:'bbbbb',mcatego:'ccccc',marance:'ddddd',nhectar:25,ntotals:150},
					{dclasif:'xxxxx',mclasif:'aaaaa',dcatego:'bbbbb',mcatego:'ccccc',marance:'ddddd',nhectar:25,ntotals:150},
					{dclasif:'xxxxx',mclasif:'aaaaa',dcatego:'bbbbb',mcatego:'ccccc',marance:'ddddd',nhectar:25,ntotals:150},
					{dclasif:'xxxxx',mclasif:'aaaaa',dcatego:'bbbbb',mcatego:'ccccc',marance:'ddddd',nhectar:25,ntotals:150}
						],
		        height: 140,
		        width: 600,
		        rowNum: 5,
		        colNames: [
		            'dCalsificacion',
		            'mClasificacion',
		            'dCategoria',
		            'mCategoria',
		            'narance',
		            'nhectar',
		            'ntotals'
		        ],
		        colModel: [
		                   {name: 'dclasif', index:'vnrodoc', width: 75, hidden: true, align: 'center'},
		                   {name: 'mclasif', index:'dfecdoc', width: 80, align: 'center'},
		                   {name: 'dcatego', index:'vmotivo', width: 238, hidden: true},
		                   {name: 'mcatego', index:'mhresum', width: 100},
		                   {name: 'marance', index:'vobserv', width: 100},
		                   {name: 'nhectar', index:'vobserv', width: 100},
		                   {name: 'ntotals', index:'vobserv', width: 100}
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
    
	listaArancel = function() {         	
		procesarJSON("panelRustico", "tblRustico", optionPredioArancel, null, function(){
	        $("#tblRustico").jqGrid('navGrid', '#ptblRustico', {edit:false, add:false, del:false, search:false, refresh:false});
	        $("#tblRustico").jqGrid('navButtonAdd', '#ptblRustico', btnInsertarRustico);
	        $("#tblRustico").jqGrid('navSeparatorAdd','#ptblRustico');
	        $("#tblRustico").jqGrid('navButtonAdd','#ptblRustico', btnEditarRustico);
	        $("#tblRustico").jqGrid('navSeparatorAdd','#ptblRustico');
	        $("#tblRustico").jqGrid('navButtonAdd','#ptblRustico', btnEliminarRustico);
	    });
	};

	$(document).ready(function(){
		listaArancel();

	});
</script> 