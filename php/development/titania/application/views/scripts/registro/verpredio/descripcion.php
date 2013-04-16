<style>
    table.ui-table-panelLayout tr td {
        padding: 1px; 
    }
</style>
<table>
    <tr>
        <td valign="top" rowspan="2" style="padding-right: 5px">
            <div id="panelPredio" align="center" class="ui-widget ui-widget-content ui-corner-top" style="width: 100%;">
                <div class="ui-widget ui-state-default ui-corner-top ui-title">
                    <label>Sobre el Predio</label>
                </div>
                <table class="ui-table-panelLayout">
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Predio:</td>
                        <td><select style="width: 190px;" id="cboTipoPredio"><?php echo $this->util()->getComboContenedor('1000000089', $this->mpredio["ctippre"]); ?></select></td>
                    </tr>
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Tipo:</td>
<!--                    <td><select style="width: 190px;" id="cboTipoPredioUrbano"><?php echo $this->util()->getComboContenedor(($this->mpredio["ctippre"]=='1000000091'? '1000000209': '1000000202'), null); ?></select></td>-->
						<td><select style="width: 190px;" id="cboTipoPredioUrbano"><?php echo $this->util()->getComboContenedor(($this->mpredio["ctippre"]=='1000000091'? '1000000209': '1000000202'),$this->mpredio["csubtip"] ); ?></select></td>
                    </tr>
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Uso:</td>
                        <td><select style="width: 190px;" id="cboUso"><?php echo $this->util()->getComboContenedor(($this->mpredio["ctippre"]=='1000000091'? '1000000195': '1000000165'), $this->mpredio["cusogen"]); ?></select></td>
                    </tr>
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Uso Especifico:</td>
                        <td><select style="width: 190px;" id="cboUsoEspecifico"><?php echo $this->util()->getComboContenedor('1000000217', $this->mpredio["cusoesp"]); ?></select></td>
                    </tr>
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Estado de Construcci&oacute;n:</td>
                        <td><select style="width: 190px;" id="cboEstado"><?php echo $this->util()->getComboContenedor('1000000155', $this->mpredio["cestado"]); ?></select></td> 
                    </tr>
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Condici&oacute;n de Propiedad:</td>
                        <td><select style="width: 190px;" id="cboCondicion"><?php echo $this->util()->getComboContenedor('1000000140', $this->mpredio["ccondic"]); ?></select></td>
                    </tr>
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">% de Condominante:</td>
                        <td>
                            <table cellpadding="0" cellspacing="0">
                                <tr>
                                    <td style="padding-right: 2px;"><input class="ui-text ui-text-numeric" style="width: 75px" id="nporcen" value="<?php echo $this->mpredio["nporcen"]; ?>" /></td>
                                    <td style="vertical-align: top;"><button id="btnVerCondominante" style="line-height: 20px; height: 20px;" title="Ver condominantes" ></button></td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Clasificaci&oacute;n:</td>
                        <td><select style="width: 190px;" id="cboClasificacion"><?php echo $this->util()->getComboContenedorOtro('1000000223', $this->mpredio["cclasif"], "public.obtener_tabla_otro"); ?></select></td>
                    </tr>
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Habitantes:</td>
                        <td><input class="ui-text ui-text-numeric" style="width: 75px" id="nnrohab" value="<?php echo $this->mpredio["ncanper"]; ?>" /></td>
                    </tr>
                    <tr>
                    	<td colspan="2" align="right">
                    	    <button id="btnCancelarDescrpPredio">Cancelar</button>
                    	    <button id="btnEditarPredio">Editar</button>
                			<button id="btnGrabarPredio">Grabar</button>
                    	</td>
                    </tr>
                </table>
            </div>
        </td>
        <td valign="top" style="padding-left: 5px">
            <div id="panelTransferencia" align="center" class="ui-widget ui-widget-content ui-corner-top" style="width: 100%;">
                <div class="ui-widget ui-state-default ui-corner-top ui-title" contentEditable='false' unselectable='true' style="disabled:true"  >
                    <label>Sobre la Transferencia</label>
                </div>
                <table class="ui-table-panelLayout">
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Motivo de Adquisici&oacute;n:</td>
                        <td colspan="3"><select style="width: 190px;" id="cboMotivo"><?php echo $this->util()->getComboContenedor('1000000334', $this->mpredio["cmotadq"]); ?></select></td>
                    </tr>
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Fecha Adquisici&oacute;n:</td>
                        <td><input class="ui-text" style="width: 80px; text-align: center;" id="dtpFechaAdquisicion" value="<?php echo $this->mpredio["dfecadq"]; ?>" /></td>
                        <td style="padding-left: 10px; padding-right: 4px;text-align: right;">Fecha de Transferencia:</td>
                        <td><input class="ui-text" style="width: 80px; text-align: center;" id="dtpFechaTransferencia" value="<?php echo $this->mpredio["dfectra"]; ?>" /></td>
                    </tr>
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Notaria:</td>
                        <td colspan="3"><input class="ui-text" style="width: 100%; text-align: center;" id="txtNotaria" value="<?php echo $this->mpredio["cnotari"]; ?>" /></td>
                    </tr>
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Tipo Doc.:</td>
                        <td><input class="ui-text" style="width: 80px; text-align: center;" id="txtTipoTransferencia" value="<?php echo $this->mpredio["ctiptra"]; ?>" /></td>
                        <td style="padding-right: 4px;text-align: right;">Partida Nro.:</td>
                        <td><input class="ui-text" style="width: 80px; text-align: center;" id="txtPartida" value="<?php echo $this->mpredio["cpartid"]; ?>" /></td>
                    </tr>
                </table>
            </div>
        </td>
    </tr>
    <tr>
        <td valign="top" style="padding-left: 5px;">
            <div id="panelTerreno" align="center" class="ui-widget ui-widget-content ui-corner-top" style="width: 100%;">
                <div class="ui-widget ui-state-default ui-corner-top ui-title">
                    <label>Sobre el Terreno</label>
                </div>
                <table class="ui-table-panelLayout">
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Area de Terreno:</td>
                        <td><input class="ui-text ui-text-numeric" style="width: 75px" id="nareter" value="<?php echo $this->mpredio["ntertot"]; ?>" /></td>
                        <td style="padding-right: 4px;text-align: right;">Area de Com&uacute;n:</td>
                        <td><input class="ui-text ui-text-numeric" style="width: 75px" id="narecom" value="<?php echo $this->mpredio["narecom"]; ?>" /></td>
                    </tr>
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Porcentaje de Terreno:</td>
                        <td><input class="ui-text ui-text-numeric" style="width: 75px" id="nporter" value="<?php echo $this->mpredio["nporter"]; ?>" /></td>
                        <td style="padding-right: 4px;text-align: right;">Porcentaje de Com&uacute;n:</td>
                        <td><input class="ui-text ui-text-numeric" style="width: 75px" id="nporcom" value="<?php echo $this->mpredio["nporcom"]; ?>" /></td>
                    </tr>
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Total de Terreno:</td>
                        <td><input class="ui-text ui-text-numeric" style="width: 75px" id="ntotter" value="<?php echo $this->mpredio["nterren"]; ?>" /></td>
                        <td style="padding-right: 4px;text-align: right;">Total de Com&uacute;n:</td>
                        <td><input class="ui-text ui-text-numeric" style="width: 75px" id="ntotcom" value="<?php echo $this->mpredio["ncomtot"]; ?>" /></td>
                    </tr>
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Frontis:</td>
                        <td colspan="3"><input class="ui-text ui-text-numeric" style="width: 75px" id="nfronti" value="<?php echo $this->mpredio["nfrente"]; ?>" /></td>
                    </tr>
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Ubicaci&oacute;n del Parque:</td>
                        <td colspan="3"><select style="width: 190px;" id="cboParque"><?php echo $this->util()->getComboContenedor('1000000219', $this->mpredio["ctippar"]); ?></select></td>
                    </tr>
                </table>
            </div>
        </td>
    </tr>
</table>
<div id="ajaxaca">
</div>


<script type="text/javascript">
    
    $(function() {

    	$("#btnCancelarDescrpPredio").click(function() {
   
    	 
    		row = {     		
    				mpredio: $("#_mpredio").val(),    				
    				mhresum: $("#_mhresum").val(), 
    				cperiod: $("#cboPeriodo").val()    				 
    		};

    		_post = $.post(path + "registro/recargarpredio", row);
    	    _post.success(function(data){
        	    $("#ajaxaca").html(data);
    	    }); 
    		
    	});

    	
    });

</script>
    
