
$(function(){
		$( "#tabs_detallepredio" ).tabs();
		
		$("#c_codigocontrib").numeric({ decimal: false, negative: false }, function() { alert("Solo Numeros Enteros Positivos..."); this.value = ""; this.focus(); });
		$('#c_codigocontrib').keyup(function(event) {
			if(event.keyCode == 13){ 
				$('#c_codigocontrib').val(LPad($('#c_codigocontrib').val(),6,'0'));				
				buscardatoscontribuyente($('#c_codigocontrib').val());
			}   
		});	
		$('#c_nombrecontrib').keyup(function(event) {
			if(event.keyCode == 13){
				var nombre = $('#c_nombrecontrib').val();
				
				var jqxhr = $.getJSON(path+"rentas/buscarcontribuyentexnombre/?nombre="+nombre);	
				jqxhr.success(function(data){
					if (data.result != undefined && data.result == 'error'){console.log(data.mensaje);} 
					else {
						var cad = '<table id="tbl_buscarpersonanombre" width="640" border="1" cellspacing="0" cellpadding="0"><tbody class="ui-table-body">';
						$.each(data.result.contribuyentes, function(i , colum){
							cad += '<tr onclick="buscardatoscontribuyente(\''+colum.codpers+'\');$(\'#ventanabuscarpersonanombre\').dialog(\'close\');"><td width="79">'+colum.codpers+'</td><td width="239">'+colum.nombre+'</td><td width="320">'+colum.dirfiscal+'</td></tr>';
						});
						cad += '</tbody></table>';
						
						$('#div_rptabuscarpersonanombre').html(cad)
						mouseHover("tbl_buscarpersonanombre");
						$("#ventanabuscarpersonanombre" ).dialog( "open" );
					}
				});
				
			}   
		});		
		$('#c_direccontri').keyup(function(event) {
			if(event.keyCode == 13){
				var dir = $('#c_direccontri').val();
				
				var jqxhr = $.getJSON(path+"rentas/buscarcontribuyentexdir/?dir="+dir);	
				jqxhr.success(function(data){
					if (data.result != undefined && data.result == 'error'){console.log(data.mensaje);} 
					else {
						var cad = '<table id="tbl_buscarpersonadir" width="805" border="1" cellspacing="0" cellpadding="0"><tbody class="ui-table-body">';
						$.each(data.result.direccion, function(i , colum){
							cad +=  '<tr onclick="buscardatoscontribuyente(\''+colum.codpers+'\');$(\'#ventanabuscarpersonadireccion\').dialog(\'close\');">'+
									'	<td width="54" >'+colum.codpred+'</td>'+
									'	<td width="237" >'+colum.nombrevia+'</td>'+
									'	<td width="24" >'+colum.nro+'</td>'+
									'   <td width="41" >'+colum.depart+'</td>'+
									'   <td width="24" >'+colum.interior+'</td>'+
									'   <td width="29" >'+colum.letra+'</td>'+
									'   <td width="34" >'+colum.estac+'</td>'+
									'   <td width="39" >'+colum.depos+'</td>'+
									'   <td width="24" >'+colum.mz+'</td>'+
									'   <td width="25" >'+colum.lote+'</td>'+
									'   <td width="248" >'+colum.codpers +' - '+ colum.nompers +'</td>'+
									'</tr>';
						});
						cad += '</tbody></table>';
						
						$('#div_rptabuscarpersonadir').html(cad)
						mouseHover("tbl_buscarpersonadir");
						$("#ventanabuscarpersonadireccion" ).dialog( "open" );
					}
				});
				
			}   
		});		
		
});


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
	$( "#ventanabuscarpersonanombre" ).dialog({
		resizable: false,
		height:300,
		width:750,
		modal: true,
		autoOpen:false,
		draggable:false,
		title:"Busqueda de Contribuyente",
		buttons: {
			Cerrar: function(){$( this ).dialog( "close" );}
		}
	});
	$( "#ventanabuscarpersonadireccion" ).dialog({
		resizable: false,
		height:300,
		width:880,
		modal: true,
		autoOpen:false,
		draggable:false,
		title:"Busqueda de Contribuyente",
		buttons: {
			Cerrar: function(){$( this ).dialog( "close" );}
		}
	});
	$( "#ventanadatosprediorustico" ).dialog({
		resizable: false,
		height:580,
		width:680,
		modal: true,
		autoOpen:false,
		draggable:false,
		title:"Busqueda de Contribuyente",
		buttons: {
			Cerrar: function(){$( this ).dialog( "close" );}
		}
	});
});




function buscardatoscontribuyente(codpers){
	//$( "#c_codigocontrib" ).html( cod );	
	
	var jqxhr = $.getJSON(path+"rentas/datoscontribuyente/?codpers="+codpers);	
	jqxhr.success(function(data){
		if (data.result != undefined && data.result == 'error'){console.log(data.mensaje);} 
		else {
			$( "#c_codigocontrib" ).val( data.result.contribuyente.codigo );
			$( "#c_nombrecontrib" ).val( data.result.contribuyente.ape_paterno + ' '+ data.result.contribuyente.ape_materno + ' '+ data.result.contribuyente.nombre );	
			$( "#c_direccontri" ).val( data.result.contribuyente.dirfiscal );				
			
			var predios = data.result.predios;
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
						    '		    	<button id="btndetpredio'+colum.codigo+'" onclick="detallepredio(\''+data.result.contribuyente.codigo+'\',\''+data.result.contribuyente.ape_paterno + ' '+ data.result.contribuyente.ape_materno + ' '+ data.result.contribuyente.nombre+'\',\''+data.result.contribuyente.dirfiscal+'\',\''+colum.codigo+'\');"><span class="ui-button-text">Detalle Predio</span></button>'+
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

function limpiarformulariodetallepredio(){
	$('#txt_nropiso').val('');
	$('#txt_pisoareaconst').val('');
	$('#txt_pisoanioconst').val('');
	$('#txt_pisoantig').val('');
	$('#txt_pisoporcareacomun').val('');
	$('#cb_pisomaterial').val('9999999999');
	$('#cb_pisoestado').val('9999999999');
	$('#cb_pisomuro').val('9999999999');
	$('#cb_pisotecho').val('9999999999');
	$('#cb_pisopisos').val('9999999999');
	$('#cb_pisopuertavetana').val('9999999999');
	$('#cb_pisorevestimiento').val('9999999999');
	$('#cb_pisobanio').val('9999999999');
	$('#cb_pisoinstalaciones').val('9999999999');
	$('#txt_pisovalorconstruccion').val('');
	$('#txt_pisoultimorecalculo').val('');
	$('#cb_pisotipodoc').val('9999999999');
	$('#txt_pisonrodoc').val('');
	$('#txt_pisonrodoc').val('');
	$('#txt_pisofechadoc').val('');	
	
	$('#txt_nrovalorinstalacion').val('');
	$('#txt_instalacionareaconst').val('');	
	$('#txt_instalacionanioconst').val('');	
	$('#txt_instalacionantig').val('');	
	$('#txt_instalacionporcareacomun').val('');	
	$('#cb_instalacionmaterial').val('9999999999');	
	$('#cb_instalacionestado').val('9999999999');
	$('#txt_instalacionalto').val('');	
	$('#txt_instalacionancho').val('');	
	$('#txt_instalacionlargo').val('');	
	$('#cb_instalacionunidmedida').val('9999999999');	
	$('#txt_instalacionvalor').val('');
	$('#txt_instalacionultimorecalculo').val('');	
	$('#cb_instalaciontipodoc').val('9999999999');	
	$('#txt_instalacionnrodoc').val('');	
	$('#cb_instalacionmotivo').val('9999999999');	
	$('#txt_instalacionfechadoc').val('');
	
}

function detalleprediollenarcomponentes(){
	var jqxhr = $.getJSON(path+"rentas/detalleprediollenarcomponentes/");	
	jqxhr.success(function(data){
		if (data.result != undefined && data.result == 'error'){console.log(data.mensaje);} 
		else {		
			$('#cb_condicionpropiedad').html(contenidocombo(data.result.condpropiedad));
			$('#cb_estadopredio').html(contenidocombo(data.result.estadopredio));
			$('#cb_tipopredio').html(contenidocombo(data.result.tipopredio));
			$('#cb_clasificacionpredio').html(contenidocombo(data.result.clasifpredio));
			$('#cb_usogeneralpredio').html(contenidocombo(data.result.usopredio));
			$('#cb_usoespecificopredio').html(contenidocombo(data.result.usoespecifico));
			$('#cb_ubicacionparque').html(contenidocombo(data.result.ubicparque));
			$('#cb_tipoinafecto').html(contenidocombo(data.result.tipoinafec));
			
			$('#cb_pisomuro').html(contenidocombo(data.result.caract_piso));
			$('#cb_pisotecho').html(contenidocombo(data.result.caract_piso));
			$('#cb_pisopisos').html(contenidocombo(data.result.caract_piso));
			$('#cb_pisopuertavetana').html(contenidocombo(data.result.caract_piso));
			$('#cb_pisorevestimiento').html(contenidocombo(data.result.caract_piso));
			$('#cb_pisobanio').html(contenidocombo(data.result.caract_piso));
			$('#cb_pisoinstalaciones').html(contenidocombo(data.result.caract_piso));
			
			$('#cb_pisomaterial').html(contenidocombo(data.result.piso_material));
			$('#cb_pisoestado').html(contenidocombo(data.result.piso_estado));
			$('#cb_pisotipodoc').html(contenidocombo(data.result.piso_documento));
			$('#cb_pisomotivo').html(contenidocombo(data.result.piso_motivo));
			
			$('#cb_instalacionmaterial').html(contenidocombo(data.result.instalacion_material));
			$('#cb_instalacionestado').html(contenidocombo(data.result.instalacion_estado));
			$('#cb_instalaciontipodoc').html(contenidocombo(data.result.instalacion_documento));
			$('#cb_instalacionmotivo').html(contenidocombo(data.result.instalacion_motivo));
			$('#cb_instalacionunidmedida').html(contenidocombo(data.result.instal_unid_medida));
			
			$('#cbrustico_clasif_0').html(contenidocombo(data.result.rustico_clasifpredio));
			$('#cbrustico_clasif_1').html(contenidocombo(data.result.rustico_clasifpredio));
			$('#cbrustico_clasif_2').html(contenidocombo(data.result.rustico_clasifpredio));
			$('#cbrustico_clasif_3').html(contenidocombo(data.result.rustico_clasifpredio));
			$('#cbrustico_clasif_4').html(contenidocombo(data.result.rustico_clasifpredio));
			$('#cbrustico_clasif_5').html(contenidocombo(data.result.rustico_clasifpredio));
			$('#cbrustico_categ_0').html(contenidocombo(data.result.rustico_categpredio));
			$('#cbrustico_categ_1').html(contenidocombo(data.result.rustico_categpredio));
			$('#cbrustico_categ_2').html(contenidocombo(data.result.rustico_categpredio));
			$('#cbrustico_categ_3').html(contenidocombo(data.result.rustico_categpredio));
			$('#cbrustico_categ_4').html(contenidocombo(data.result.rustico_categpredio));
			$('#cbrustico_categ_5').html(contenidocombo(data.result.rustico_categpredio));
			$('#btnprediorustico').click(function(event){ $("#ventanadatosprediorustico" ).dialog( "open" );  });
		}
	});
}

function detallepredio(cod, nombre, dirfis, codpredio){
	$( "#c_codigocontrib_x" ).html( cod );	
	$( "#c_nombrecontrib_x" ).html( nombre );	
	$( "#c_dirfiscal_x" ).html( dirfis );
	$('#c_codpred').html(codpredio);
	
	var jqxhr = $.getJSON(path+"rentas/detallepredio/?codpred="+cod);	
	jqxhr.success(function(data){
		if (data.result != undefined && data.result == 'error'){console.log(data.mensaje);} 
		else {
			//alert(data.result.codusopredio);
			$('#c_dirpred').html(data.result.dirpred);
			$('#txt_fechaadquisicion').val(data.result.fechaadq);
			$('#txt_fechabaja').val(data.result.fechabaj);
			$('#txt_ultimorecalculo').val(data.result.fecharecalculo);
			$('#cb_condicionpropiedad').val(data.result.codcondpropiedad);
			$('#cb_estadopredio').val(data.result.codestadopredio);
			$('#cb_tipopredio').val(data.result.codtipopredio);
			$('#cb_clasificacionpredio').val(data.result.codclasifpredio);
			$('#cb_usogeneralpredio').val(data.result.codusopredio);
			$('#cb_usoespecificopredio').val(data.result.codusoespecifico);
			
			$('#txt_areaterreno').val(data.result.areaterreno);
			$('#txt_procentajeterreno').val(data.result.porcterreno);
			$('#txt_totalarea').val(data.result.totalarea);
			$('#txt_areacomun').val(data.result.areacomun);
			$('#txt_porcentajecomun').val(data.result.porccomun);
			$('#txt_totalcomun').val(data.result.totalcomun);
			$('#txt_frente').val(data.result.frente);
			$('#txt_arancel').val(data.result.arancel);
			$('#txt_porcentajecond').val(data.result.porccond);
			$('#cb_ubicacionparque').val(data.result.codubicparque);
			
			$('#cb_tipoinafecto').val(data.result.codtipoinafec);
			$('#txt_expedienteinafecto').val(data.result.inafec_exped);
			$('#txt_resolucioninafecto').val(data.result.inafec_resol);
			$('#txt_fecharesolucioninafecto').val(data.result.inafec_fecharesol);
			$('#txt_baselegalinafecto').val(data.result.inafec_baselegal);
			$('#txt_observacioninafecto').val(data.result.inafec_observ);
			$('#txt_inicioinafecto').val(data.result.inafec_fechaini);
			$('#txt_fininafecto').val(data.result.inafec_fechafin);
			$('#txt_inafectoip').val(data.result.inafec_ip);
			$('#txt_inafectolc').val(data.result.inafec_lc);
			$('#txt_inafectorb').val(data.result.inafec_rb);
			$('#txt_inafectolp').val(data.result.inafec_lp);
			$('#txt_inafectopj').val(data.result.inafec_pj);
			$('#txt_inafectosg').val(data.result.inafec_sg);
			
			//tablita pisos
			var cadtablapisos = '<table id="tbl_pisos" border="1" cellspacing="0" cellpadding="0"><tbody class="ui-table-body">';
			var total_area_cons = 0;
			var valor_area_cons = 0;
			$.each(data.result.pisos, function(i , colum){	
				total_area_cons = parseFloat(total_area_cons) + parseFloat(colum.area_const);
				valor_area_cons = parseFloat(valor_area_cons) + parseFloat(colum.val_area_const);
				var jsonstring = JSON.stringify(colum); 
				jsonstring = jsonstring.replace(/\"/g,"\\\'");
				cadtablapisos   +='<tr onclick="llenardatospisos(\''+jsonstring +'\')">'
			                    +'	<td width="27" align="center">'+colum.nivel+'</td>'
			                    +'	<td width="40" align="center">'+colum.antiguedad+'</td>'
			                    +'	<td width="78">'+colum.material+'</td>'
			                    +'	<td width="59">'+colum.estado+'</td>'
			                    +'	<td width="20" align="center">'+colum.mu+'</td>'
			                    +'	<td width="20" align="center">'+colum.te+'</td>'
			                    +'	<td width="20" align="center">'+colum.pi+'</td>'
			                    +'	<td width="20" align="center">'+colum.pv+'</td>'
			                    +'	<td width="20" align="center">'+colum.rv+'</td>'
			                    +'	<td width="20" align="center">'+colum.ba+'</td>'
			                    +'	<td width="20" align="center">'+colum.in+'</td>'
			                    +'	<td width="70" align="right">'+colum.area_const+'</td>'                    
			                    +'	<td width="85" align="right">'+colum.val_unit_m2+'</td>'
			                    +'	<td width="50" align="right">'+colum.inc_5+'</td>'
			                    +'	<td width="50" align="right">'+colum.porc_deprec+'</td>'
			                    +'	<td width="50" align="right">'+colum.deprec+'</td>'
			                    +'	<td width="100" align="right">'+colum.val_unit_deprec+'</td>'
			                    +'	<td width="90" align="right">'+colum.val_area_const+'</td>'
			                    +'	<td width="90" align="right">'+colum.porc_area_comun+'</td>'
			                    +'	<td width="95" align="right">'+colum.val_area_comun+'</td>'
			                    +'	<td width="78" align="right">'+colum.valor_final+'</td>'
			                    +'</tr>';
			});	
				cadtablapisos   +='</tbody></table>'
								
			$('#c_tablapisos').html(cadtablapisos);
			$('#c_total_area_cons').html(total_area_cons);
			$('#c_valor_area_cons').html(valor_area_cons);
			
			mouseHover("tbl_pisos");
			
			//tablita instalacion
			var cadtablainstalacion = '<table id="tbl_instalacion" border="1" cellspacing="0" cellpadding="0"><tbody class="ui-table-body">';
			total_area_cons = 0;
			valor_area_cons = 0;
			$.each(data.result.instalacion, function(i , colum){	
				total_area_cons = parseFloat(total_area_cons) + parseFloat(colum.area_const);
				valor_area_cons = parseFloat(valor_area_cons) + parseFloat(colum.val_area_const);
				var jsonstring = JSON.stringify(colum); 
				jsonstring = jsonstring.replace(/\"/g,"\\\'");
				cadtablainstalacion+= '<tr onclick="llenardatosinstalacion(\''+jsonstring +'\')">'+
					                    '<td width="40" align="center">'+colum.antiguedad+'</td>'+
					                    '<td width="79">'+colum.material+'</td>'+
					                    '<td width="60">'+colum.estado+'</td>'+
					                    '<td width="150">'+colum.descripcion+'</td>'+
					                    '<td width="50" align="center">'+colum.altura+'</td>'+
					                    '<td width="50" align="center">'+colum.ancho+'</td>'+
					                    '<td width="50" align="center">'+colum.largo+'</td>'+
					                    '<td width="80" align="center">'+colum.unid_medida+'</td>'+
					                    '<td width="70" align="right">'+colum.area_const+'</td>'+
					                    '<td width="85" align="right">'+colum.val_unit_m2+'</td>'+
					                    '<td width="50" align="right">'+colum.porc_deprec+'</td>'+
					                    '<td width="50" align="right">'+colum.deprec+'</td>'+
					                    '<td width="100" align="right">'+colum.val_unit_deprec+'</td>'+
					                    '<td width="90" align="right">'+colum.val_area_const+'</td>'+
					                    '<td width="90" align="right">'+colum.porc_area_comun+'</td>'+
					                    '<td width="95" align="right">'+colum.val_area_comun+'</td>'+
					                    '<td width="78" align="right">'+colum.valor_final+'</td>';
					                   '</tr>';
			});
			cadtablainstalacion   +='</tbody></table>'
				
			$('#c_tablainstalacion').html(cadtablainstalacion);
			$('#c_total_area_cons_inst').html(total_area_cons);
			$('#c_valor_area_cons_inst').html(valor_area_cons);
			
			mouseHover("tbl_instalacion");
		}
	});
	
	$("#ventanadetallepredio" ).dialog( "open" );
}

function llenardatospisos(jsondata){
	jsondata = jsondata.replace(/\'/g,'"');
	var data = jQuery.parseJSON(jsondata);
	//alert(obj.nivel);
	$('#txt_nropiso').val(data.nivel);
	$('#txt_pisoareaconst').val(data.area_const);
	$('#txt_pisoanioconst').val(data.anio_const);
	$('#txt_pisoantig').val(data.antiguedad);
	$('#txt_pisoporcareacomun').val(data.porc_area_comun);
	$('#cb_pisomaterial').val(data.codmaterial);
	$('#cb_pisoestado').val(data.codestado);
	$('#cb_pisomuro').val(data.cod_mu);
	$('#cb_pisotecho').val(data.cod_te);
	$('#cb_pisopisos').val(data.cod_pi);
	$('#cb_pisopuertavetana').val(data.cod_pv);
	$('#cb_pisorevestimiento').val(data.cod_rv);
	$('#cb_pisobanio').val(data.cod_ba);
	$('#cb_pisoinstalaciones').val(data.cod_in);
	$('#txt_pisovalorconstruccion').val(data.valor_final);
	$('#txt_pisoultimorecalculo').val(data.ult_recalculo);
	$('#cb_pisotipodoc').val(data.codtipodoc);
	$('#txt_pisonrodoc').val(data.tipodoc);
	$('#cb_pisomotivo').val(data.codmotivo);
	$('#txt_pisofechadoc').val(data.fechadoc);	
}

function llenardatosinstalacion(jsondata){
	jsondata = jsondata.replace(/\'/g,'"');
	var data = jQuery.parseJSON(jsondata);
	//alert(data.antiguedad);
	$('#txt_nrovalorinstalacion').val(data.valor_final);
	$('#txt_instalacionareaconst').val(data.area_const);	
	$('#txt_instalacionanioconst').val(data.anio_const);	
	$('#txt_instalacionantig').val(data.antiguedad);	
	$('#txt_instalacionporcareacomun').val(data.porc_area_comun);	
	$('#cb_instalacionmaterial').val(data.codmaterial);	
	$('#cb_instalacionestado').val(data.codestado);
	$('#txt_instalacionalto').val(data.altura);	
	$('#txt_instalacionancho').val(data.ancho);	
	$('#txt_instalacionlargo').val(data.largo);	
	$('#cb_instalacionunidmedida').val(data.cod_unid_medida);	
	$('#txt_instalacionvalor').val(data.valor_final);
	$('#txt_instalacionultimorecalculo').val(data.ult_recalculo);	
	$('#cb_instalaciontipodoc').val(data.codtipodoc);	
	$('#txt_instalacionnrodoc').val(data.tipodoc);	
	$('#cb_instalacionmotivo').val(data.codmotivo);	
	$('#txt_instalacionfechadoc').val(data.fechadoc);
}
