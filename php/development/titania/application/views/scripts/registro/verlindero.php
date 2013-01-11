
<div id="formPiso">
	<table>
		 <tr>
			<td width="495"  align="center">
				<div class="ui-widget ui-state-default ui-corner-top ui-title">
					<label>Lindero</label>
				</div>
				<div class="ui-widget-content ui-corner-bottom">
					<table cellspacing="5" style="margin: 3px;">
						<tr>
							<td width="150">Cardinal</td>
							<td width="35" ><select style="width: 240px;" id="cboCardinal"><?php echo $this->util()->getComboContenedor('1000000004', null); ?></select></td>
							<td width="300">&nbsp;</td>
						</tr>
						<tr>
							<td>Cod. Propiedad</td>
							<td><input id="txtcodproie" class="ui-text" style="width:30px; padding:2px;text-align:center;" value="" /></td>
						</tr>
						<tr>
							<td>Ubicacion</td>
							<td><input id="txt_ubicacion" class="ui-text" style="width:30px;padding:2px;text-align:center;"/></td>
						</tr>
						<tr>
							<td>DPropie</td>
							<td><input id="txt_dpropie" class="ui-text" style="width:30px; padding:2px;text-align:center;" value="" /></td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td>MPropie</td>
							<td><input id="txt_mpropie" class="ui-text" style="width:30px;padding:2px;text-align:center;"/></td>
						</tr>
						
						<tr>
							<td colspan="2" align="right"><input  type="button" id="btnguardar" name="guardar" value="Aceptar"/>&nbsp;&nbsp;<input type="button" id="btncancelar" name="cancelar" value="Cancelar"/></td></tr>
					</table>
				</div>
			</td>
			
		</tr>
	</table>
</div>
<script type="text/javascript">
	isValid = true;
	validar = function(){
		$("#formPiso").find("input").each(function(){
			if($(this).val().length ==0){
				isValid = false;
	            return;
	        }
		});
		
		if(!isValid){
		   openDialogWarning("Los campos deben estar llenos.", 380, 150);	
		}
	};

	$("#btnguardar").button({
		icons: {primary:'ui-icon-disk'}
	}).bind('click', function(){
		closeDialog('jqDialog1');
	});

	$("#btncancelar").button({
		icons: {primary:'ui-icon-pencil'}
	}).bind('click', function(){
		closeDialog('jqDialog1');
	});
</script>