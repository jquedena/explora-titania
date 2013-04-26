<input type="hidden" id="hdnIdPersonaina" value="<?php echo $this->mperson; ?>"/>

<table class="ui-table-panelLayout">
    <tr>
        <td style="text-align:right">Inafectaci&oacute;n y Exoneraci&oacute;n:</td><td><select id="cb_tipoinafecto" style="width:190px;padding:2px"><?php echo $this->util()->getComboContenedor('1000001849', '1000001850'); ?></select></td>
        <td>Observaci&oacute;n:</td>
    </tr>
    <tr>
        <td style="text-align:right">Expediente:</td><td><input class="ui-text" style="width:90px;" id="txt_expedienteinafecto" value="" /></td>
        <td rowspan="7" valign="top"><textarea class="ui-text jquery_ckeditor" cols="80" id="txtObservacionInafectacion" name="txtObservacionInafectacion" rows="10"></textarea>
        <br/><button id="GrabarInafecta" onClick="grabarinafe();">Grabar </button>
        </td>
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


grabarinafe= function(){
 	   Hab=true;
      
	  if ($("#cb_tipoinafecto").val()=='9999999999'){
		  alert("Seleccione el tipo de inafecto");
		  $("#cb_tipoinafecto").focus();
		  Hab=false;
		  return false;
	  }
	   
	  if ($("#txt_baselegalinafecto").val()==''){
		  alert("Ingrese la base legal.");
		  $("#txt_baselegalinafecto").focus();
		  Hab=false; 
		  return false;
	  }
	   
	  if ($("#txt_expedienteinafecto").val()==''){
		  alert("Ingrese el expediente");
		  $("#txt_expedienteinafecto").focus();
		  Hab=false;
		  return false;
	  }
	   
	  if ($("#txt_resolucioninafecto").val()==''){
		  alert("Ingrese la resolucion");
		  $("#txt_resolucioninafecto").focus();
		  Hab=false;
		  return false;
		  
	  }
	    
	  if ($("#dptFechaResolucionInafecto").val()==''){
		  alert("Ingrese la fecha resolucion");
		  $("#dptFechaResolucionInafecto").focus();
		  Hab=false;
		  return false;
		  
	  }
	   	  
	  if ($("#txt_inicioinafecto").val()==''){
		  alert("Ingrese el inicio de afectacion");
		  $("#txt_inicioinafecto").focus();
		  Hab=false;
		  return false;
		  
	  }
	   
	  if ($("#txt_fininafecto").val()==''){
		  alert("Ingrese el fin de afectacion");
		  $("#txt_fininafecto").focus();
		  Hab=false;
		  return false;		  
	  }
	

	row = { 
			  idsigma: '-1',
			  mperson: $("#hdnIdPersonaina").val(),
			  mpredio: $("#_mpredio").val() ,
			  ctipina: $("#cb_tipoinafecto").val(),
			  vbasleg: $("#txt_baselegalinafecto").val(),
			  vnumexp: $("#txt_expedienteinafecto").val(),
			  vnumres: $("#txt_resolucioninafecto").val(), 
			  dfecres: $("#dptFechaResolucionInafecto").val(),
			  ctiping: '01',
			  nporafe: '100',
			  dfecini: $("#txt_inicioinafecto").val(),
			  dfecfin: $("#txt_fininafecto").val(),
			  nestado: 1,
			  //vhostnm,
			  //vusernm,
			  //ddatetm ,
			  mhresum: $("#_mhresum").val() ,
			  vobserv: $("#txtObservacionInafectacion").val() 
	}; 

	if (Hab==true){
				
	_post = $.post(path + "registro/guardarinafecta", row);
	_post.success(function(data){
		//optionPiso = $.extend(optionPiso, {data: data.data});
		//procesarJSON("panelPiso", "tblPiso", optionPiso, null, navPanelPiso);
	});

	}
};




</script>







