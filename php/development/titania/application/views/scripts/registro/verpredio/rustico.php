<table>
<tr>
<td><select style="width: 240px;" id="cboMotivo"><?php echo $this->util()->getComboContenedor('1000000004', null); ?></select>&nbsp;
&nbsp;<select style="width: 240px;" id="cboMotivo"><?php echo $this->util()->getComboContenedor('1000000004', null); ?></select></td>
</tr>
<tr>
<!--<td><div id="ptblPredioColindante"></div></td>-->
<td><div id="panelrustico" align="center"></div></td>
</tr>
</table>

*/
	
<script>
	optionArancel = {
			data:[
				{dclasif:'xxxxx',mclasif:'aaaaa',dcatego:'bbbbb',mcatego:'ccccc',marance:'ddddd',nhectar:25,ntotals:150},
				{dclasif:'xxxxx',mclasif:'aaaaa',dcatego:'bbbbb',mcatego:'ccccc',marance:'ddddd',nhectar:25,ntotals:150},
				{dclasif:'xxxxx',mclasif:'aaaaa',dcatego:'bbbbb',mcatego:'ccccc',marance:'ddddd',nhectar:25,ntotals:150},
				{dclasif:'xxxxx',mclasif:'aaaaa',dcatego:'bbbbb',mcatego:'ccccc',marance:'ddddd',nhectar:25,ntotals:150}
					],
	        height: 140,
	        width: 438,
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
	                   {name: 'dclasif', index:'vnrodoc', width: 75, align: 'center'},
	                   {name: 'mclasif', index:'dfecdoc', width: 80, align: 'center'},
	                   {name: 'dcatego', index:'vmotivo', width: 238},
	                   {name: 'mcatego', index:'mhresum', width: 100},
	                   {name: 'marance', index:'vobserv', width: 100},
	                   {name: 'nhectar', index:'vobserv', width: 100},
	                   {name: 'ntotals', index:'vobserv', width: 100}
	               ],
			caption: "&nbsp;&nbsp;&nbsp;Arancel",
	       	onSelectRow: function(id) {
	            row = $(this).getRowData(id);
	        }       	
	    };
/*
	btnInsertarRustico = {
	        caption: "Agregar&nbsp;&nbsp;",
	        title: "Agrega un nuevo nivel al predio",
	        buttonicon: "ui-icon-plus",
	        onClickButton:function(){
	    	//	verlindero();
	        	
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
	    
	    btnEliminarRustico= {
	        caption: "Eliminar",
	        title: "Eliminar la construcci\u00F3n",
	        buttonicon: "ui-icon-trash",
	        onClickButton:function(){
	        	openDialogWarning("Seleccione la fila a eliminar.", 380, 150);
	        }
	    };
*/
	listaarancel = function() {         
			procesarJSON("panelrustico", "tblarancel", optionArancel, null,null );
	/*		procesarJSON("panelrustico", "tblarancel", optionArancel, null, function(){
			$("#tblarancel").jqGrid('navGrid', '#ptblArancel', {edit:false, add:false, del:false, search:false, refresh:false});
	        $("#tblarancel").jqGrid('navButtonAdd', '#ptblArancel', btnInsertarRustico);
	        $("#tblarancel").jqGrid('navSeparatorAdd','#ptblArancel');
	        $("#tblarancel").jqGrid('navButtonAdd','#ptblArancel', btnEditarRustico);
	        $("#tblarancel").jqGrid('navSeparatorAdd','#ptblArancel');
	        $("#tblarancel").jqGrid('navButtonAdd','#ptblArancel', btnEliminarRustico);
		});*/
	};

	$(document).ready(function(){
		listaarancel();
	});
	    
</script>