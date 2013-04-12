function FiltrarConceptosxAreas(datos){
	v_area = $("#cbareas").val();
	//console.log(v_area);
	BusqXCriterioConceptoPagosDiversos(3,datos,v_area);
}

function MostrarBuscarConceptosPagosDiversos(conceptos) {

	var v = $("#hidden_buscarconcepto").val();
	if (v == 0) {
		$("#hidden_buscarconcepto").val('1');
		
		var parameters = {datoscpd: conceptos};
		var _post = $.post(path + "pagosdiversos/busqconceptopagodiverso/", parameters);
		
		_post.success(function(requestData){
			$("#div_buscarconcepto").html(requestData);
		});
		
		_post.error(postError);
	} else {
		$("#hidden_buscarconcepto").val('0');
		$("#div_buscarconcepto").html('');
	}
}

function MostrarDetalleConceptoPagosDiversos() {
	var datos = $("#cbconceptos").val();
	
	if(datos == null || datos == undefined) {
		datos = " | | |0.00";
	}
	
	var arraydatos = datos.split('|');
	var cod = arraydatos[0];
	var des = arraydatos[1];
	var cid = arraydatos[2];
	var monto = arraydatos[3];
	$("#codconcepto").html(cod);
	$("#descripconceptomin").html('<font size="1">' + des + '</font>');
	$("#descripconcepto").val(des);
	$("#cidconcepto").val(cid);
	$("#montoconcepto").val(monto);
	$("#cantidadconcepto").val('1');
	$("#glosaconcepto").val('');
}

function BusqXCriterioConceptoPagosDiversos(crit, datos,varea) {
	if(varea == undefined) varea='';
	 
	datos = replaceAll(datos, "&", "^");
	var cadrequest = '';
	var criterio = crit;
	var val='';
	if (criterio == 1) { // Por codigo
		val = $("#busqxcodconcepto").val();
		$("#busqxnomconcepto").val('');
	}
	if (criterio == 2) { // Por nombre de concepto
		val = $("#busqxnomconcepto").val();
		$("#busqxcodconcepto").val('');
	}

	var parameters = {datoscpd: datos, criterio: criterio, valor: val , area : varea};
	console.log(parameters);
	var _post = $.post(path + "pagosdiversos/busqxcriterioconceptopagosdiversos/", parameters);
	
	_post.success(function(requestData){
		$("#cbconceptos").html(requestData);
		MostrarDetalleConceptoPagosDiversos();
		$("#montoconcepto").focus();
	});
	
	_post.error(postError);
}

function AgregarDetalleConceptoPagosDiversos() {
	var o = {
		cod: $("#codconcepto").html(),
		des: $("#descripconcepto").val(),
		cid: $("#cidconcepto").val(),
		monto: $("#montoconcepto").val(),
		cantidad: $("#cantidadconcepto").val(),
		glosa: $("#glosaconcepto").val(),
	}

	$("#div_resultpagosdiversos").html('');
	
	if (o.cod == '' || o.cod == null) {
		openDialogWarning('Seleccionar el concepto a cobrar.');
	} else if (o.monto == '0.00' || o.monto == '' || o.monto == '0') {
		openDialogWarning('Ingresar monto a cobrar a dicho concepto.');
	} else if (o.cantidad == '' || o.cantidad == '0') {
		openDialogWarning('Ingresar cantidad de conceptos a cobrar.');
	} else {
		var _post = $.post(path + "pagosdiversos/agregarconceptopagodiverso/", o);
		
		_post.success(function(requestData){
			$("#divdetallepagodiverso").html(requestData);
		});
		
		_post.error(postError);
	}
}

function BorrarDetalleConceptoPagosDiversos(vcod, vmonto) {
	$("#div_erroragregarconcepto").html("");
	var o = {
		cod: vcod,
		cantidad: '1',
		monto: vmonto
	}
	var _post = $.post(path + "pagosdiversos/borrarconceptopagodiverso/", o);
	
	_post.success(function(requestData){
		$("#divdetallepagodiverso").html(requestData);
	});
	_post.error(postError);
}

function DetallePagoConceptoPagosDiversos() {
	openDialog1("pagosarbitriospredios/ventanacobrarpagosarbitriospredios/?tipopago=1", 350, 270, "Generando Recibos");
}
function ventanadetallepago() {
	var totpag = $('#txttotalpagar').val();
	openDialog2("pagosarbitriospredios/ventanadetallepago/?totpag="+totpag, 400, 370, "Generando Recibos");
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

function restarmontospagosarbitriospredios() {	
	var m1 = $("#txttotalpagar").val();
	var m2 = $("#txtefectivo").val();
		if(m2 == '' || m2 == null){
			m2 = 0.00;
		}
	var rest = m2-m1;
	$("#txtvuelto").val(rest.toFixed(2));
}

function CobrarConceptoPagosDiversos() {
	
	var _post = $.post(path + "pagosdiversos/cobrarconceptopagodiverso/");
	_post.success(function(requestData){
		$("#div_resultpagosdiversos").html(requestData);
	});
	_post.error(postError);
	
}
