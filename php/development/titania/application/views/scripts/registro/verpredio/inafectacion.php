<table class="ui-table-panelLayout">
    <tr>
        <td style="text-align:right">Inafectaci&oacute;n y Exoneraci&oacute;n:</td><td><select id="cb_tipoinafecto" style="width:190px;padding:2px"><?php echo $this->util()->getComboContenedor('1000000455', null); ?></select></td>
        <td>Observaci&oacute;n:</td>
    </tr>
    <tr>
        <td style="text-align:right">Expediente:</td><td><input class="ui-text" style="width:90px;" id="txt_expedienteinafecto" value="" /></td>
        <td rowspan="7" valign="top"><textarea class="ui-text jquery_ckeditor" cols="80" id="txtObservacionInafectacion" name="txtObservacionInafectacion" rows="10"></textarea></td>
    </tr>
    <tr>
        <td style="text-align:right">Resoluci&oacute;n:</td><td><input class="ui-text" style="width:90px;" id="txt_resolucioninafecto" value="" /></td>
    </tr>
    <tr>
        <td style="text-align:right">Fecha Resoluci&oacute;n:</td><td><input class="ui-text" style="width:80px" id="dptFechaResolucionInafecto" value="" /></td>
    </tr>
    <tr>
        <td style="text-align:right">Base Legal:</td><td><input class="ui-text" style="width:190px" id="txt_baselegalinafecto" value="" /></td>
    </tr>
    <tr>
        <td style="text-align:right">Fecha Inicio:</td><td><input class="ui-text" style="width:80px" id="txt_inicioinafecto" value="" /></td>
    </tr>
    <tr>
        <td style="text-align:right">Fecha Fin:</td><td><input class="ui-text" style="width:80px" id="txt_fininafecto" value="" /></td>
    </tr>
    <tr>
        <td style="text-align:right" valign="top">Tributos:</td>
	</tr>
	<tr>
		<td align="right" colspan="2">
			<div id="panelTributo">
   				<table id="tblDatosTributo"></table>
    				<div id="ptblDatosTributo"></div>
			</div>
		</td>
    </tr>
</table>
<script type="text/javascript">

var mydata = [
		{id:"11.00",invdate:"11.00",name:"11.00",amount:"11.00",tax:"11.00"},
		{id:"12.00",invdate:"12.00",name:"12.00",amount:"12.00",tax:"12.00"}
		];
optionTributo= {
	data: mydata,
	datatype: "local",
	height: 50,
   	colNames:['IP','LP', 'RB', 'PJ','SG'],
   	colModel:[
   		{name:'id',index:'id', width:60,align:"right"},
   		{name:'invdate',index:'invdate', width:60,align:"right"},
   		{name:'name',index:'name', width:60,align:"right"},
   		{name:'amount',index:'amount', width:60,align:"right"},
   		{name:'tax',index:'tax', width:60,align:"right"}		
   	],
   	pager: '#pager',
  	caption: "Descripcion de Tributos"
};
</script>







