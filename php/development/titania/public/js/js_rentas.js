

$(function(){$( "#tabs_detallepredio" ).tabs();});

$(function() {
	$( "#dialog:ui-dialog" ).dialog( "destroy" );					
	$( "#ventanadetallepredio" ).dialog({
		resizable: false,
		height:600,
		width:900,
		modal: true,
		autoOpen:false,
		draggable:false,
		buttons: {
			Editar: function(){$( this ).dialog( "close" );}
		   ,Guardar: function(){$( this ).dialog( "close" );}
		   ,Cerrar: function(){$( this ).dialog( "close" );}
		}
	});
});

function pintardatoscontribuyente(cod,nombre,dirfis){
	$( "#c_codigocontrib" ).html( cod );	
	$( "#c_nombrecontrib" ).html( nombre );	
	$( "#c_dirfiscal" ).html( dirfis );	
	
	var jqxhr = $.getJSON(path+"rentas/datoscontribuyente/");	
	jqxhr.success(function(data){
		if (data.result != undefined && data.result == 'error'){console.log(data.mensaje);} 
		else {
			var predios = data.result.predios;
//			  codigo , tipo , direccion , uso , fechaadq , fechabaj ,valorepredio , valorafecto, impuestoanual , valuo
			var cadpredio = '';
			  $.each(predios, function(i , colum){	   
		       // alert(colum.codigo + '->' +colum.uso);
			   cadpredio += '<div style="border:1px solid">'+
						    '    <table width="600" border="0" cellspacing="0" cellpadding="0">'+
						    '		  <tr><td colspan="8" height="8px"></td></tr>'+
						    '		  <tr>'+
						    '		    <td width="20">&nbsp;</td>'+
						    '		    <td width="62">C&oacute;digo:</td>'+
						    '		    <td width="165">'+colum.codigo+'</td>'+
						    '		    <td colspan="4" align="right">'+
						    '		    	<button id="btndetpredio'+colum.codigo+'" onclick="detallepredio(\''+cod+'\',\''+nombre+'\',\''+dirfis+'\',\''+colum.codigo+'\');"><span class="ui-button-text">Detalle Predio</span></button>'+
						    '		    </td>'+
						    '		    <td width="20">&nbsp;</td>'+
						    '		  </tr>'+
						    '		  <tr>'+
						    '		    <td colspan="8" height="8px"></td>'+
						    '		    </tr>'+
						    '		  <tr>'+
						    '		    <td>&nbsp;</td>'+
						    '		    <td>Tipo:</td>'+
						    '		    <td>&nbsp;</td>'+
						    '		    <td width="57">Uso:</td>'+
						    '		    <td width="166">'+colum.uso+'</td>'+
						    '		    <td width="60">Porcentaje:</td>'+
						    '		    <td width="50">'+colum.porcentaje+'</td>'+
						    '		    <td>&nbsp;</td>'+
						    '		  </tr>'+
						    '		  <tr>'+
						    '		    <td colspan="8" height="8px"></td>'+
						    '		    </tr>'+
						    '		  <tr>'+
						    '		    <td>&nbsp;</td>'+
						    '		    <td>Fech Adq.:</td>'+
						    '		    <td>'+colum.fechaadq+'</td>'+
						    '		    <td>Fech Baja:</td>'+
						    '		    <td>'+colum.fechabaj+'</td>'+
						    '		    <td>&nbsp;</td>'+
						    '		    <td>&nbsp;</td>'+
						    '		    <td>&nbsp;</td>'+
						    '		  </tr>'+
						    '		  <tr>'+
						    '		    <td colspan="8" height="8px"></td>'+
						    '		  </tr>'+
						    '		  <tr>'+
						    '		    <td>&nbsp;</td>'+
						    '		    <td colspan="6" align="center">'+
						    '		    	<table width="550" border="1" cellspacing="0" cellpadding="0">'+
						    '		              <tr>'+
						    '		                <th width="137" scope="col">Valor del Preio</th>'+
						    '		                <th width="135" scope="col">Valor Afecto</th>'+
						    '		                <th width="140" scope="col">Impuesto Anual</th>'+
						    '		                <th width="138" scope="col">Calculo de Valuo</th>'+
						    '		              </tr>'+
						    '		              <tr>'+
						    '		                <td>'+colum.valorepredio+'</td>'+
						    '		                <td>'+colum.valorafecto+'</td>'+
						    '		                <td>'+colum.impuestoanual+'</td>'+
						    '		                <td>'+colum.valuo+'</td>'+
						    '		              </tr>'+
						    '		            </table>    </td>'+
						    '		    <td>&nbsp;</td>'+
						    '		  </tr>'+
						    '		  <tr>'+
						    '		    <td colspan="8" height="8px"></td>'+
						    '		    </tr>'+
						    '		</table>'+     
						    '   </div><br>';
				  
		      });
			  
			  $( "#div_predios" ).html( cadpredio );	
			  $(function(){$("button").button();});
		}
	});
	
}

function detallepredio(cod, nombre, dirfis, codpredio){
	$( "#c_codigocontrib_x" ).html( cod );	
	$( "#c_nombrecontrib_x" ).html( nombre );	
	$( "#c_dirfiscal_x" ).html( dirfis );
	$('#c_codpred').html(codpredio);
	
	var jqxhr = $.getJSON(path+"rentas/detallepredio/");	
	jqxhr.success(function(data){
		if (data.result != undefined && data.result == 'error'){console.log(data.mensaje);} 
		else {
			
		}
	});
	
	$("#ventanadetallepredio" ).dialog( "open" );
}