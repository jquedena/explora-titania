<style>
    table.ui-table-panelLayout tr td {
        padding: 1px; 
    }
</style>
<table>
    <tr>
        <td valign="middle" rowspan="2" style="padding-right: 5px">
            <div id="panelPredio" align="center" class="ui-widget ui-widget-content ui-corner-top" style="width: 100%;">
                <div class="ui-widget ui-state-default ui-corner-top ui-title">
                    <label>Sobre el Predio</label>
                </div>
                <table class="ui-table-panelLayout">
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Tipo de Predio:</td>
                        <td><select style="width: 190px;" id="cboTipoPredio"><?php echo $this->util()->getComboContenedor('1000000089', null); ?></select></td>
                    </tr>
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Tipo de Predio Urbano:</td>
                        <td><select style="width: 190px;" id="cboTipoPredioUrbano"><?php echo $this->util()->getComboContenedor('1000000202', null); ?></select></td>
                    </tr>
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Uso:</td>
                        <td><select style="width: 190px;" id="cboUso"><?php echo $this->util()->getComboContenedor('1000000165', null); ?></select></td>
                    </tr>
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Uso Especifico:</td>
                        <td><select style="width: 190px;" id="cboUsoEspecifico"><?php echo $this->util()->getComboContenedor('1000000217', null); ?></select></td>
                    </tr>
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Estado de Construcci&oacute;n:</td>
                        <td><select style="width: 190px;" id="cboEstado"><?php echo $this->util()->getComboContenedor('1000000155', null); ?></select></td>
                    </tr>
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Condici&oacute;n de Propiedad:</td>
                        <td><select style="width: 190px;" id="cboCondicion"><?php echo $this->util()->getComboContenedor('1000000140', null); ?></select></td>
                    </tr>
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">% de Condominante:</td>
                        <td>
                            <table cellpadding="0" cellspacing="0">
                                <tr>
                                    <td style="padding-right: 2px;"><input class="ui-text ui-text-numeric" style="width: 75px" id="nporcen"/></td>
                                    <td style="vertical-align: top;"><button id="btnVerCondominante" style="line-height: 20px;height: 20px;" title="Ver condominantes" /></td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Clasificaci&oacute;n:</td>
                        <td><select style="width: 190px;" id="cboClasificacion"><?php echo $this->util()->getComboContenedor('1000000104', null); ?></select></td>
                    </tr>
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Motivo de Adquisici&oacute;n:</td>
                        <td><select style="width: 190px;" id="cboMotivo"><?php echo $this->util()->getComboContenedor('1000000004', null); ?></select></td>
                    </tr>
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Habitantes:</td>
                        <td><input class="ui-text ui-text-numeric" style="width: 75px" id="nnrohab"/></td>
                    </tr>
                </table>
            </div>
        </td>
        <td valign="top" style="padding-left: 5px">
            <div id="panelTransferencia" align="center" class="ui-widget ui-widget-content ui-corner-top" style="width: 100%;">
                <div class="ui-widget ui-state-default ui-corner-top ui-title">
                    <label>Sobre la Transferencia</label>
                </div>
                <table class="ui-table-panelLayout">
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Fecha Adquisici&oacute;n:</td>
                        <td><input class="ui-text" style="width: 80px; text-align: center;" id="dtpFechaAdquisicion"/></td>
                    </tr>
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Fecha de Descargo:</td>
                        <td><input class="ui-text" style="width: 80px; text-align: center;" id="dtpFechaDescargo"/></td>
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
                        <td><input class="ui-text ui-text-numeric" style="width: 75px" id="nareter"/></td>
                        <td style="padding-right: 4px;text-align: right;">Area de Com&uacute;n:</td>
                        <td><input class="ui-text ui-text-numeric" style="width: 75px" id="narecom"/></td>
                    </tr>
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Porcentaje de Terreno:</td>
                        <td><input class="ui-text ui-text-numeric" style="width: 75px" id="nporter"/></td>
                        <td style="padding-right: 4px;text-align: right;">Porcentaje de Com&uacute;n:</td>
                        <td><input class="ui-text ui-text-numeric" style="width: 75px" id="nporcom"/></td>
                    </tr>
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Total de Terreno:</td>
                        <td><input class="ui-text ui-text-numeric" style="width: 75px" id="ntotter"/></td>
                        <td style="padding-right: 4px;text-align: right;">Total de Com&uacute;n:</td>
                        <td><input class="ui-text ui-text-numeric" style="width: 75px" id="ntotcom"/></td>
                    </tr>
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Frontis:</td>
                        <td colspan="3"><input class="ui-text ui-text-numeric" style="width: 75px" id="nfronti"/></td>
                    </tr>
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Ubicaci&oacute;n del Parque:</td>
                        <td colspan="3"><select style="width: 190px;" id="cboParque"><?php echo $this->util()->getComboContenedor('1000000219', null); ?></select></td>
                    </tr>
                </table>
            </div>
        </td>
    </tr>
</table>
