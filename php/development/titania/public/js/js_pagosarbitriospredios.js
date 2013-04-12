function pintarregistrospagosarbitriospredios(registros,reajustecentimos,url) {
	
	$.ajax( 
 	{
 	dataType: "html",
 	type: "POST",
 	url: jQuery.scriptPath + "index.php/pagosarbitriospredios/pintarregistros/", 
 	data: 	"reajustecentimos="+reajustecentimos+"&registros="+registros+"&url="+url,
	beforeSend: function(data){ 
	$("#div_detalle_recibo").html("<tr><td colspan=\'9\'>Cargando...</td></tr>");
	},
	success: function(requestData){ 	
	$("#div_detalle_recibo").html(requestData);
	},		
	error: function(requestData, strError, strTipoError){											
	$("#div_detalle_recibo").html("Error " + strTipoError +": " + strError);
	},
	complete: function(requestData, exito){ 
	
	}
	});	
}

function cobrarpagosarbitriospredios() {	
	var registros = $("#hddata").val();
	var fecha = $("#fechrecibo").val();
	var efectivo = $("#txttotalpagar").val();
		$.ajax( 
	 	{
	 	dataType: "html",
	 	type: "POST",
	 	url: jQuery.scriptPath + "index.php/pagosarbitriospredios/cobrarpagosarbitriospredios/", 
	 	data: 	"registros="+registros+"&fecha="+fecha+"&efectivo="+efectivo,
		beforeSend: function(data){ 
	 	$("#btnaceptarcobro").attr('disabled','disabled'); 
		$("#div_rptacobroarbitrospredios").html("Cargando...");
		},
		success: function(requestData){ 	
		$("#div_rptacobroarbitrospredios").html(requestData);
		},		
		error: function(requestData, strError, strTipoError){											
		$("#div_rptacobroarbitrospredios").html("Error " + strTipoError +": " + strError);
		},
		complete: function(requestData, exito){ 
		
		}
		});	
}

function activarpagomanualpagosarbitriospredios() {	
	var b = $("#rbtn_cobromanual").attr('checked');
	if(b == true){
		$('#nrorecibo').removeAttr('disabled');
		$('#fechrecibo').removeAttr('disabled');
	}else{
		$("#nrorecibo").attr('disabled','disabled'); 
		$("#fechrecibo").attr('disabled','disabled'); 
		closeCalendar();
	}
}

function cerrarsubventpagosarbitriospredios() {	
	closeDialog("jDialog1");
}

function restarmontospagosarbitriospredios() {	
	var m1 = $("#txttotalpagar").val();
	var m2 = $("#txtefectivo").val();
		if(m2 == '' || m2 == null){
			m2 = 0.00;
		}
	var rest = m2-m1;
	$("#txtvuelto").val(rest.toFixed(2));
}

function nuevomontoefectivo() {
	var m = $("#txttotalpagar").val();
	$("#txtefectivo").val(m);
	$("#txtvuelto").val('0.00');
}

function descargospagosarbitriospredios() {		
	var registros = $("#hddata").val();
	var fecha = $("#fechrecibo").val();
	var tpdescargo = $("#tpdescargo").val();
	var nrodoc = $("#txtnrodoc").val();
	var observ = $("#txaobs").val();
	var efectivo = $("#txtefectivo").val();
	
		$.ajax( 
	 	{
	 	dataType: "html",
	 	type: "POST",
	 	url: jQuery.scriptPath + "index.php/pagosarbitriospredios/descargospagosarbitriospredios/", 
	 	data: 	"registros="+registros+"&fecha="+fecha+"&tpdescargo="+tpdescargo+"&nrodoc="+nrodoc+"&observ="+observ+"&efectivo="+efectivo,
		beforeSend: function(data){ 
		$("#div_rptacobroarbitrospredios").html("Cargando...");
		},
		success: function(requestData){ 	
		$("#div_rptacobroarbitrospredios").html(requestData);
		},		
		error: function(requestData, strError, strTipoError){											
		$("#div_rptacobroarbitrospredios").html("Error " + strTipoError +": " + strError);
		},
		complete: function(requestData, exito){ 
		
		}
		});	
}

function descargoregistrospagosarbitriospredios() {	
	$.lightbox(jQuery.scriptPath + "index.php/pagosarbitriospredios/ventanadescargospagosarbitriospredios/", {
        'width'       : 350, //350
        'height'      : 300, //250
        'autoresize'  : true,
        'modal': true
      });
}


function cobrarregistrospagosarbitriospredios() {
	openDialog1("pagosarbitriospredios/ventanacobrarpagosarbitriospredios/", 350, 270, "Generando Recibos");
}

function ventanarecibosxconribuyente(codper) {
	openDialog1("pagosarbitriospredios/ventanarecibosemitidos/?codper="+codper, 850, 570, "Recibos Emitidos");
}

function ventanadetallepago() {
	var totpag = $('#txttotalpagar').val();
	openDialog2("pagosarbitriospredios/ventanadetallepago/?totpag="+totpag, 400, 370, "Generando Recibos");
}

function detallerecibosxconribuyente(cad) {	
	parametro = cad.parentNode.getElementsByTagName("INPUT")[1].value;

	$.ajax( 
	{
	dataType: "html",
	type: "POST",
	url: jQuery.scriptPath + "index.php/pagosarbitriospredios/detallerecibosemitidos/", 
	data: 	"cad="+parametro,
	beforeSend: function(data){ 
	$("#div_detallerecibo").html('<div align="center"><img src=' + jQuery.scriptPath + 'img/loading.gif></div>');
	},
	success: function(requestData){ 	
	$("#div_detallerecibo").html(requestData);
	},		
	error: function(requestData, strError, strTipoError){											
	$("#div_detallerecibo").html("Error " + strTipoError +": " + strError);
	},
	complete: function(requestData, exito){ 
	
	}
	});
}

function reseteardetallepago(txt) {	
	var monto = $('#'+txt).val();
	$.ajax( 
	{
	dataType: "html",
	type: "POST",
	url: jQuery.scriptPath + "index.php/pagosarbitriospredios/reseteardetallepago/", 
	data: 	"monto="+monto,
	beforeSend: function(data){ 
		//$("#div_detallepago").html('cargando...');
	},
	success: function(requestData){ 	
		//$("#div_detallepago").html(requestData);		
	},		
	error: function(requestData, strError, strTipoError){											
		//$("#div_detallepago").html("Error " + strTipoError +": " + strError);
	},
	complete: function(requestData, exito){ 
	
	}
	});	
}

function aniadirdetallepago() {	
	
	var totalrestante = $('#hdsubtotal').val();
	
	var montototal = $('#montototal').html();
	var codtipppago = $('#cbtipopago').val();
	var desctipppago = $('#cbtipopago option:selected').html();
	var monto = $('#txtmontopago').val();
	var nrodoc = $('#txtnrodoc').val();
	var nroope = $('#txtnroope').val();
	
	var error = '';
	
	if(codtipppago == '9999999999'){
		error += 'Seleccionar Tipo de Pago.<br>';		
	}
	console.log(monto+" > "+totalrestante);
	
	/*if(monto > totalrestante){
		error += 'El Monto ingresado supera al total restante.<br>';
	}*/
		if(codtipppago == '0000007832'){
			//efectivo
			nrodoc = '';
			nroope = '';		
		}if(codtipppago == '0000007833'){
			//cheque
			if(trim(nrodoc) == ''){
				error += 'Ingresar Nro de Cheque.<br>';	
			}		
		}if(codtipppago == '0000007834'){
			//tarjeta
			if(trim(nrodoc) == ''){
				error += 'Ingresar Nro de Tarjeta.<br>';	
			}if(trim(nroope) == ''){
				error += 'Ingresar Nro de Operaci&oacute;n.<br>';	
			}		
		}
	
	if(monto == 0.00){
		error += 'Ingresar Monto a Pagar.<br>';				
	}
	
	if(error.length > 0)
	{
		$("#div_mensajex").html(error);
	}else{	
		$("#div_mensajex").html('');
		$.ajax( 
		{
		dataType: "html",
		type: "POST",
		url: jQuery.scriptPath + "index.php/pagosarbitriospredios/aniadirdetallepago/", 
		data: 	"montototal="+montototal+"&codtipppago="+codtipppago+"&desctipppago="+desctipppago+"&monto="+monto+"&nrodoc="+nrodoc+"&nroope="+nroope,
		beforeSend: function(data){ 
		$("#div_detallepago").html('cargando...');
		},
		success: function(requestData){ 	
		$("#div_detallepago").html(requestData);
			jQuery('#cbtipopago').attr('value', '9999999999'); 
			$('#txtmontopago').val('0.00');
			$('#txtnrodoc').val('');
			$('#txtnroope').val('');			
		},		
		error: function(requestData, strError, strTipoError){											
		$("#div_detallepago").html("Error " + strTipoError +": " + strError);
		},
		complete: function(requestData, exito){ 
		
		}
		});
	}
}

function borrardetallepago(codtipppago,nrodoc) {	
	var montototal = $('#montototal').html();
	$.ajax( 
	{
	dataType: "html",
	type: "POST",
	url: jQuery.scriptPath + "index.php/pagosarbitriospredios/borrardetallepago/", 
	data: 	"montototal="+montototal+"&codtipppago="+codtipppago+"&nrodoc="+nrodoc,
	beforeSend: function(data){ 
	$("#div_detallepago").html('cargando...');
	},
	success: function(requestData){ 	
	$("#div_detallepago").html(requestData);		
	},		
	error: function(requestData, strError, strTipoError){											
	$("#div_detallepago").html("Error " + strTipoError +": " + strError);
	},
	complete: function(requestData, exito){ 
	
	}
	});	
}

 