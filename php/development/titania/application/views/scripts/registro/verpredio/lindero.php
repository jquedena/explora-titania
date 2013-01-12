<div id="panelPredioColindante"></div>
<script>
	verlindero = function() {
	    openDialogDataFunction1("registro/verlindero", {}, "485", "300", "Detalle del Lindero",null );
   
	};

	optionPrediocolindante = {
		data:[
			{ccardin:'Norte',cpropie:'bbbbb',cubicac:'aaaaa',dpropie:'ccccc',mpredio:'ddddd'},
			{ccardin:'Sur',cpropie:'bbbbb',cubicac:'aaaaa',dpropie:'ccccc',mpredio:'ddddd'},
			{ccardin:'Este',cpropie:'bbbbb',cubicac:'aaaaa',dpropie:'ccccc',mpredio:'ddddd'},
			{ccardin:'Oeste',cpropie:'bbbbb',cubicac:'aaaaa',dpropie:'ccccc',mpredio:'ddddd'}
		],
        height: 140,
        width: 900,
        rowNum: 5,
        rownumbers: false,
        colNames: [
            'Cardinal',
            'CodPropiedad',          
            'Ubicacion',
            'DPropie',
            'mpredio'
        ],
        colModel: [
                   {name: 'ccardin', index:'vnrodoc', width: 75, align: 'center', editable: true},
                   {name: 'cpropie', index:'vmotivo', width: 238, editable: true},    
                   {name: 'cubicac', index:'dfecdoc', width: 80, align: 'center', editable: true},
                   {name: 'dpropie', index:'mhresum', width: 100, editable: true},
                   {name: 'mpredio', index:'vobserv', width: 100, editable: true}
               ],
       
		caption: "&nbsp;&nbsp;&nbsp;Predio Colindante",
       	onSelectRow: function(id) {
            row = $(this).getRowData(id);;
        }
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
        caption: "Editar",
        title: "Editar el nivel seleccionado",
        buttonicon: "ui-icon-pencil",
        onClickButton:function(){
            
        	openDialogWarning("Seleccione la fila a editar.", 380, 150);
        } 
    };
    
    btnEliminarColindante = {
        caption: "Eliminar",
        title: "Eliminar la construcci\u00F3n",
        buttonicon: "ui-icon-trash",
        onClickButton:function(){
        	openDialogWarning("Seleccione la fila a eliminar.", 380, 150);
        }
    };
    
	listaLinderos = function() {         	
		procesarJSON("panelPredioColindante", "tblLindero", optionPrediocolindante, null, function(){
	        $("#tblLindero").jqGrid('navGrid', '#ptblLindero', {edit:false, add:false, del:false, search:false, refresh:false});
	        $("#tblLindero").jqGrid('navButtonAdd', '#ptblLindero', btnInsertarColindante);
	        $("#tblLindero").jqGrid('navSeparatorAdd','#ptblLindero');
	        $("#tblLindero").jqGrid('navButtonAdd','#ptblLindero', btnEditarColindante);
	        $("#tblLindero").jqGrid('navSeparatorAdd','#ptblLindero');
	        $("#tblLindero").jqGrid('navButtonAdd','#ptblLindero', btnEliminarColindante);
	    });
	};

	$(document).ready(function(){
		listaLinderos();

	});
</script> 