function aperturarcaja(vaccion){
	var vnrocaja='';
	var vfecha ='';
	var obs ='';
	if (vaccion=='1'){
		vnrocaja = $('#txtnrocaja').val();
		vfecha= $('#txtfecha').val();
		if (vnrocaja=='' || vnrocaja==null){
			openDialogWarning('Ingrese el Número de Caja a Aperturar');
			return false;
		}
		if (vfecha=='' || vfecha==null || vfecha.length != 10){
			openDialogWarning('Ingrese una Fecha Correcta');
			return false;
		}
	}
	else if (vaccion=='2') {
		vnrocaja = arcajascerrada.substr(1, arcajascerrada.length);
		vfecha= $('#fechaorg').val();
		obs =$('#txtobs').val();
		if (obs=='' || obs==null){
			openDialogWarning('Ingrese una observación');
			return false;
		}
	}
	$.ajax( {
		dataType : "html",
		type : "POST",
		url : jQuery.scriptPath + "index.php/cajaflujo/actaperturarcaja/",
		data : "vnrocaja="+vnrocaja+
				"&vfecha="+vfecha+
				"&vaccion="+vaccion+
				"&obs="+obs,
		beforeSend : function(data) {
			$('#result').html('Cargando...');
		},
		success : function(requestData) {
			$("#result").html(requestData);
		},
		error : function(requestData, strError, strTipoError) {
			$("#result").html("Error " + strTipoError + ': ' + strError);
		},
		complete : function(requestData, exito) {
		}
	});
}

function cerrarcaja(){
	var vobs = $('#txtobs').val();
	var vfech = $('#txtfecha').val();
	var vnrocaja = $('#txtnrocaja').val();

	if (vnrocaja=='' || vnrocaja == null){
		vnrocaja =arcajasapert.substr(1, arcajasapert.length);
		vfech= $('#fechaorg').val();
		if (vnrocaja==''|| vnrocaja ==null ){
			openDialogWarning('Seleccione la caja ha Cerrar');
			return false;
		}
	}
	
	var _post = $.post(path + "cajaflujo/actcerrarcaja/", {"obs": vobs, "fecha": vfech, "nrocaja": vnrocaja});
	
	_post.success(function(requestData){
		openDialogInfo(requestData, 400, 150);
	});
	
	_post.error(function(requestData, errMessage, errNumber){
		if(errNumber == '') {
			openDialogError("No se puede determinar el error.");
		} else {
			openDialogError(errNumber +': ' + errMessage);
		}
	});
}

function datoscaja(op){
	var nrocaj = $('#txtnrocaja').val();
	
	if (nrocaj=='' || nrocaj==null){
		openDialogWarning('Ingrese el Numero de Caja a cerrar');
		return false;
	}
	
	var _post = $.post(path + "cajaflujo/datoscaja/", {"nrocaja": nrocaj, "op": op});
	
	_post.success(function(requestData){
		$("#action").html(requestData);
	});
	
	_post.error(function(requestData, errMessage, errNumber){
		if(errNumber == '') {
			openDialogError("No se puede determinar el error.");
		} else {
			openDialogError(errNumber +': ' + errMessage);
		}
	});
}

function ventanareapertura(){
	if (arcajascerrada.substr(1, arcajascerrada.length) == '' || arcajascerrada.substr(1, arcajascerrada.length) == null){
		openDialogWarning('Seleccione las cajas a Reaperturar');
		return false;
	}
	$.lightbox(jQuery.scriptPath +"index.php/Cajaflujo/reaperturarcaja/", {
        'width'       : 350,
        'height'      : 270, 
        'autoresize'  : true,
        'modal': true
      });
}

function lstcajasapert(){
	var vdia = $('#txtdia').val();
	$('#fechaorg').val(vdia);
	
	arcajascerrada ='';
	arcajasapert='';
	if(vdia==''){
		openDialogWarning("Ingresar Fecha");
		return false;
	}
	
	$('#tbl_capert tr:gt(0)').remove();
	$('#chartdivbarras').html("");
	$('#chartdivpie').html("");
	
	var _post = $.post(path + "cajaflujo/lstcajasapert/", {fecha: vdia});
	
	_post.success(function(requestData){
		$("#tbl_capert").append(requestData);
		mouseHover("tbl_capert");
	});
	
	_post.error(function(requestData, errMessage, errNumber){
		if(errNumber == '') {
			openDialogError("No se puede determinar el error.");
		} else {
			openDialogError(errNumber +': ' + errMessage);
		}
	});
}

var arcajascerrada ='';
var arcajasapert='';
var habilitar='';

function guardarcaja(numcaja,estado,obj){
	var fechaorg = $('#fechaorg').val();
	if( estado == '1' || estado== '3') { // Aperturar caja
		toogleVar(arcajasapert, numcaja);
	} else if( estado == '2' ){ // Cerrar caja
		toogleVar(arcajascerrada, numcaja);
	} else if( estado == '0' ){ // Habilitada
		toogleVar(arcajascerrada, numcaja);
	}
}

function toogleVar(_string, _value) {
	if (_string.indexOf("," + _value) > -1){
		_string = _string.replace("," + _value, "");
	}else{
		_string += "," + _value;
	}
}
