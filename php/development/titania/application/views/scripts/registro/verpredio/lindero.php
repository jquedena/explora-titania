<div id="panelLindero">
    <table id="tblLindero"></table>
    <div id="ptblLindero"></div>
</div>
<script>
	verlindero = function() {
	    openDialogDataFunction1("registro/verlindero", {}, "485", "300", "Detalle del Lindero",null );
   
	};

	optionLindero = {
		height: 140,
		width: 900,
		rowNum: 5,
		colNames: [
			'Cardinal',
			'Tipo',
			'Predio',          
			'Ubicaci\u00F3n',
			'C\u00F3d. Contribuyente',
			'Nombres y Apellidos',
			'idsigma',
			'cptocar',
			'ctiplin',
			'dpredio'
		],
		colModel: [
			{name: "vptocar", index: "vptocar", width: 55},
			{name: "vtiplin", index: "vtiplin", width: 40},
			{name: "ccodpre", index: "ccodpre", width: 50 },
			{name: "vdirecc", index: "vdirecc", width: 250},
			{name: "mperson", index: "mperson", width: 60},
			{name: "vnombre", index: "vnombre", width: 90},
			{name: "idsigma", index: "idsigma", hidden: true},
			{name: "cptocar", index: "cptocar", hidden: true},
			{name: "ctiplin", index: "ctiplin", hidden: true},
			{name: "dpredio", index: "dpredio", hidden: true}
		],	
		caption: "&nbsp;&nbsp;&nbsp;Linderos",
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
</script> 