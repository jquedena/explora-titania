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

function BusqXCriterioConceptoPagosDiversos(crit, datos) {

	datos = replaceAll(datos, "&", "^");
	var cadrequest = '';
	var criterio = crit;
	
	if (criterio == 1) { // Por codigo
		val = $("#busqxcodconcepto").val();
		$("#busqxnomconcepto").val('');
	}
	if (criterio == 2) { // Por nombre de concepto
		val = $("#busqxnomconcepto").val();
		$("#busqxcodconcepto").val('');
	}

	var parameters = {datoscpd: datos, criterio: criterio, valor: val};
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

function CobrarConceptoPagosDiversos() {
	var _post = $.post(path + "pagosdiversos/cobrarconceptopagodiverso/");
	
	_post.success(function(requestData){
		$("#div_resultpagosdiversos").html(requestData);
	});
	
	_post.error(postError);
}
