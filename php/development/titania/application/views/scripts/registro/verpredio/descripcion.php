<style>
    table.ui-table-panelLayout tr td {
        padding: 1px; 
    }
</style>
<table>
    <tr>
        <td valign="middle" rowspan="2" style="padding-right: 5px">
            <div id="panelContribuyente" align="center" class="ui-widget ui-widget-content ui-corner-top" style="width: 100%;">
                <div class="ui-widget ui-state-default ui-corner-top ui-title">
                    <label>Sobre el Predio</label>
                </div>
                <table class="ui-table-panelLayout">
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Tipo de Predio:</td>
                        <td><select style="width: 190px;" id="cboTipoPredio"><option>Seleccione</option></select></td>
                    </tr>
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Uso:</td>
                        <td><select style="width: 190px;" id="cboUso"><option>Seleccione</option></select></td>
                    </tr>
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Uso Especifico:</td>
                        <td><select style="width: 190px;" id="cboUsoEspecifico"><option>Seleccione</option></select></td>
                    </tr>
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Tipo de Predio Urbano:</td>
                        <td><select style="width: 190px;" id="cboTipoPredioUrbano"><option>Seleccione</option></select></td>
                    </tr>
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Estado de Construcci&oacute;n:</td>
                        <td><select style="width: 190px;" id="cboEstado"><option>Seleccione</option></select></td>
                    </tr>
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Condici&oacute;n de Propiedad:</td>
                        <td><select style="width: 190px;" id="cboCondicion"><option>Seleccione</option></select></td>
                    </tr>
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">% de Condominante:</td>
                        <td><input class="ui-text" style="width: 75px"/></td>
                    </tr>
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Clasificaci&oacute;n:</td>
                        <td><select style="width: 190px;" id="cboClasificacion"><option>Seleccione</option></select></td>
                    </tr>
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Motivo de Adquisici&oacute;n:</td>
                        <td><select style="width: 190px;" id="cboMotivo"><option>Seleccione</option></select></td>
                    </tr>
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Habitantes:</td>
                        <td><input class="ui-text" style="width: 75px"/></td>
                    </tr>
                </table>
            </div>
        </td>
        <td valign="top" style="padding-left: 5px">
            <div id="panelContribuyente" align="center" class="ui-widget ui-widget-content ui-corner-top" style="width: 100%;">
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
            <div id="panelContribuyente" align="center" class="ui-widget ui-widget-content ui-corner-top" style="width: 100%;">
                <div class="ui-widget ui-state-default ui-corner-top ui-title">
                    <label>Sobre el Terreno</label>
                </div>
                <table class="ui-table-panelLayout">
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Area de Terreno:</td>
                        <td><input class="ui-text" style="width: 75px"/></td>
                        <td style="padding-right: 4px;text-align: right;">Area de Com&uacute;n:</td>
                        <td><input class="ui-text" style="width: 75px"/></td>
                    </tr>
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Porcentaje de Terreno:</td>
                        <td><input class="ui-text" style="width: 75px"/></td>
                        <td style="padding-right: 4px;text-align: right;">Porcentaje de Com&uacute;n:</td>
                        <td><input class="ui-text" style="width: 75px"/></td>
                    </tr>
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Total de Terreno:</td>
                        <td><input class="ui-text" style="width: 75px"/></td>
                        <td style="padding-right: 4px;text-align: right;">Total de Com&uacute;n:</td>
                        <td><input class="ui-text" style="width: 75px"/></td>
                    </tr>
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Frontis:</td>
                        <td colspan="3"><input class="ui-text" style="width: 75px"/></td>
                    </tr>
                    <tr>
                        <td style="padding-right: 4px;text-align: right;">Ubicaci&oacute;n del Parque:</td>
                        <td colspan="3"><select style="width: 190px;" id="cboParque"><option>Seleccione</option></select></td>
                    </tr>
                </table>
            </div>
        </td>
    </tr>
</table>
