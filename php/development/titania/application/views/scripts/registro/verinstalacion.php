<div id="forminstalacion">
		<div class="ui-widget ui-state-default ui-corner-top ui-title">
        	<table >
                 <tr>
					<td width="400" align="center" colspan=2><label></label></td>
					<td width="400" align="center" colspan=2><label></label></td>
				</tr>  
			</table> 
        </div>
	<table border="0"  cellspacing="5" style="margin: 3px;">
		<tr>
			<td width="140">&nbsp;Cod. Predio&nbsp;</td>
			<td width="35" ><input id="txt_instdpredio" class="ui-text" style="width: 100px; padding:2px;text-align:center; " value="" /></td>
			<td width="120"><div id=""></div></td>
			<td width="140">&nbsp;Ancho Instalacion</td>
			<td width="35"><input id="txt_instnvalanc"  class="ui-text" style="width:100px;padding:2px;text-align:center; "/></td>
			<td width="120"><div id="dtxt_instnvalanc"></div></td><td width="140"></td>

		</tr>
		<tr>
			<td width="140">&nbsp;Orden de Construccion&nbsp;</td>
			<td width="35"><input id="txt_instcnitems"  class="ui-text" style="width:100px; padding:2px;text-align:center; " value="" /></td>
			<td width="120"><div id="dtxt_instcnitems"></div></td>
			<td width="140">&nbsp;&nbsp;Altura Instalacion</td>
			<td width="100"><input id="txt_instnvalalt" class="ui-text ui-text-numeric"   style="width:100; padding:2px" value="" /></td>
			<td width="120"><div id="dtxt_instnvalalt"></div></td>	
		</tr>
		<tr>
			<td width="140">&nbsp;Decl. Jurada&nbsp;</td>
			<td width="35"><input id="txt_instcperiod"  class="ui-text" style="width:100px; padding:2px;text-align:center; " value="" /></td>
			<td width="120"><div id="dtxt_instcperiod"></div></td>
			<td width="140">&nbsp;&nbsp;Largo Instalacion</td>
			<td width="100"><input id="txt_instnvallar" class="ui-text ui-text-numeric"  style="width:100; padding:2px" value="" /></td>
			<td width="120"><div id="dtxt_instnvallar"></div></td>
		</tr>
		<tr>
			<td width="140">&nbsp;Tipo de Ficha&nbsp;</td>
			<td width="35"><input id="txt_instctipdat"  class="ui-text" style="width:100px;padding:2px;text-align:center; "/></td>
			<td width="120"><div id="dtxt_instctipdat"></div></td>
			<td width="140">&nbsp;&nbsp;Tipo Instalacion</td>
			<td width="100"><input id="txt_instctipint" class="ui-text ui-text-numeric"  style="width:100; padding:2px" value="" /></td>
				<td width="120"><div id="dtxt_instctipint"></div></td>
		</tr>
		<tr>
			<td width="140">&nbsp;Nro. Decl. Jurada</td>
			<td width="35"><input id="txt_instvnrodoc"  class="ui-text" style="width:100px;padding:2px;text-align:center; "/></td>
			<td width="120"><div id="dtxt_instvnrodoc" ></div></td>
			<td width="140">&nbsp;&nbsp;Descripcion inst.</td>
			<td width="100"><input id="txt_instvdesint" class="ui-text ui-text-numeric"  style="width:100" value="" /></td>
			<td width="120"><div id="dtxt_instvdesint" ></div></td>
		</tr>
		<tr>
			<td width="140">&nbsp;Fecha Decl. Jurada</td>
			<td width="35"><input id="txt_instdfecdoc"  class="ui-text" style="width:100px;padding:2px;text-align:center; "/></td>
			<td width="120"><div id="dtxt_instdfecdoc" ></div></td>
			<td width="140">&nbsp;&nbsp;Val. Instalacion</td>
			<td width="100"><input id="txt_instnvalins" class="ui-text ui-text-numeric"  style="width:100" value="" /></td>
				<td width="120"><div id="dtxt_instnvalins" ></div></td>
		</tr>
		<tr>
			<td width="140">&nbsp;Motivo</td>
			<td width="35"><input id="txt_instcmotivo"  class="ui-text" style="width:100px;padding:2px;text-align:center; "/></td>
			<td width="120"><div id="dtxt_instcmotivo" ></div></td>
			<td width="140">&nbsp;&nbsp;Fec. Tributos</td>
			<td width="100"><input id="txt_instdafecta" class="ui-text ui-text-numeric"  style="width:100" value="" /></td>
			<td width="120"><div id="dtxt_instdafecta" ></div></td>
		</tr>
		<tr> 
			<td width="140">&nbsp;Tip. Documento</td>
			<td width="35"><input id="txt_instctipdoc"  class="ui-text" style="width:100px;padding:2px;text-align:center; "/></td>
			<td width="120"><div id="dtxt_instctipdoc"></div></td>
		</tr>
		<tr>
			<td width="140">&nbsp;Nro. Pisos</td>
			<td width="35"><input id="txt_instcnumpis"  class="ui-text" style="width:100px;padding:2px;text-align:center; "/></td>
			<td width="120"><div id="dtxt_instcnumpis"></div></td>
		</tr>
		<tr>
			<td width="140">&nbsp;Antiguedad</td>
			<td width="35"><input id="txt_instnantigu"  class="ui-text" style="width:100px;padding:2px;text-align:center; "/></td>
			<td width="120"><div id="dtxt_instnantigu" ></div></td>
		</tr>
		<tr>
			<td width="140">&nbsp;Año Construccion</td>
			<td width="35"><input id="txt_instcanocon"  class="ui-text" style="width:100px;padding:2px;text-align:center; "/></td>
			<td width="120"><div id="dtxt_instcanocon"></div></td>
		</tr>
		<tr>
		<td></td>
		<td></td>
		<td></td>
			<td align="right" ><input  type="button" id="btnguardar" name="guardar" value="Aceptar"/></td>
			<td align="right" ><input type="button" id="btncancelar" name="cancelar" value="Cancelar"/></td>
		</tr>
	</table>
</div>

<script>
var projects = [
	{
		value: "a",
		label: "a",
		desc: "the write less, do more, JavaScript library",
		icon: "jquery_32x32.png"
	},
	{
		value: "b",
		label: "b",
		desc: "the official user interface library for jQuery",
		icon: "jqueryui_32x32.png"
	},
	{
		value: "c",
		label: "c",
		desc: "a pure-JavaScript CSS selector engine",
		icon: "sizzlejs_32x32.png"
	}
];

	autocompletar = function(id, data) {
		$(id).autocomplete({
			minLength: 0,
			source: data,
			select: function( event, ui ) {
				name = "#d" + $(this).attr("id");
				$(name).html(ui.item.desc);
				$(this).val(ui.item.label);
				return false;
			}
		}).data("autocomplete")._renderItem = function(ul, item) {
			return $("<li></li>")
				.data("item.autocomplete", item)
				.append("<a><b>" + item.label + "</b><br>" + item.desc + "</a>")
				.appendTo(ul);
		};
	};

	$(function() {

		autocompletar("#dtxt_instdpredio", projects);
		autocompletar("#dtxt_instcnitems", projects);
		autocompletar("#dtxt_instcperiod", projects);
		autocompletar("#dtxt_instctipdat", projects);
		autocompletar("#dtxt_instvnrodoc", projects);
		autocompletar("#dtxt_instdfecdoc", projects);
		autocompletar("#dtxt_instcmotivo", projects);
		autocompletar("#dtxt_instctipdoc", projects);
		autocompletar("#dtxt_instcnumpis", projects);
		autocompletar("#dtxt_instnantigu", projects);
		autocompletar("#dtxt_instcanocon", projects);
		
		autocompletar("#dtxt_instnvalanc", projects);
		autocompletar("#dtxt_instnvalalt", projects);
		autocompletar("#dtxt_instnvallar", projects);
		autocompletar("#dtxt_instctipint", projects);
		autocompletar("#dtxt_instvdesint", projects);
		autocompletar("#dtxt_instnvalins", projects);
		autocompletar("#dtxt_instdafecta", projects);

	});

	 $("#btnguardar").button({
         icons: {primary:'ui-icon-disk'}
     }).bind('click', function(){
     //    habilitarComponenteDetalle(false);
    	 closeDialog('jqDialog1');
     });


	 $("#btncancelar").button({
         icons: {primary:'ui-icon-pencil'}
     }).bind('click', function(){
    	 closeDialog('jqDialog1');
    	 //  habilitarComponenteDetalle(false);
     });

	 /*
	 btnEliminarPiso = {
		        caption: "Eliminar",
		        title: "Eliminar la construcci\u00F3n",
		        buttonicon: "ui-icon-trash",
		        onClickButton:function(){
		            var gsr = $("#tblPiso").jqGrid('getGridParam','selrow');
		            if(gsr){
		                console.log(gsr);
		                // $("#tblPiso").jqGrid('GridToForm',gsr,"#order"); 
		            } else { 
		                openDialogWarning("Seleccione la fila a eliminar.", 380, 150);
		            } ;
		        } ;
		    };
		*/
	</script>







