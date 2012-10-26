


/*function aperturarcaja(vaccion){
    var vnrocaja='';
    var vfecha='';
    var obs ='';
    if (vaccion=='1'){
        vnrocaja = $('#txtnrocaja').val();
        vfecha= $('#txtfecha').val();
        if (vnrocaja=='' || vnrocaja==null){
            openDialogWarning('Ingrese el N&uacute;mero de Caja a Aperturar');
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
            openDialogWarning('Ingrese una observaci&oacute;n');
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
	
    var _post = $.post(path + "cajaflujo/actcerrarcaja/", {
        "obs": vobs, 
        "fecha": vfech, 
        "nrocaja": vnrocaja
    });
	
    _post.success(function(requestData){
        openDialogInfo(requestData, 400, 150);
    });
	
    _post.error(postError);
}

function datoscaja(op){
    var nrocaj = $('#txtnrocaja').val();
	
    if (nrocaj=='' || nrocaj==null){
        openDialogWarning('Ingrese el Numero de Caja a cerrar');
        return false;
    }
	
    var _post = $.post(path + "cajaflujo/datoscaja/", {
        "nrocaja": nrocaj, 
        "op": op
    });
	
    _post.success(function(requestData){
        $("#action").html(requestData);
    });
	
    _post.error(postError);
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
	
    var _post = $.post(path + "cajaflujo/lstcajasapert/", {
        fecha: vdia
    });
	
    _post.success(function(requestData){
        $("#tbl_capert").append(requestData);
        mouseHover("tbl_capert");
    });
	
    _post.error(postError);
}

var listaCerrada = '';
var listaAperturada = '';
var listaInhabilitada = '';

function seleccionar(nroCaja, estado){
    if(estado == '1' || estado== '3') { // Para Cerrar
        listaAperturada = toogleVar(listaAperturada, nroCaja);
    } else if(estado == '0' || estado == '2'){ // Para Aperturar
        listaCerrada = toogleVar(listaCerrada, nroCaja);
    } else if(estado == '-'){ // Para Habilitar
        listaInhabilitada = toogleVar(listaInhabilitada, nroCaja);
    }
}

function toogleVar(_string, _value) {
    if (_string.indexOf("," + _value) > -1){
        _string = _string.replace("," + _value, "");
    }else{
        _string += "," + _value;
    }
	
    return _string;
}

function cerrarTodasCajas(){
    var vfecha, vcajas, msg, _post;

    if (listaAperturada == '' || listaAperturada == null) {
        msg = 'Seleccione las cajas ha cerrar';
		
        if(listaInhabilitada != '') {
            msg = 'Ud. ha seleccionado las cajas para su habilitaci\u00F3n.';
        }
		
        if(listaCerrada != '') {
            msg = 'Ud. ha seleccionado las cajas para su reapertura.';
        }
		
        openDialogWarning(msg);
        return false;
    }
	
    vfecha = $('#txtfecha').val();
    vcajas = listaAperturada.substr(1, listaAperturada.length);
    _post = $.post(path + "cajaflujo/actcerrarcaja/", {
        "obs": "Cerrado por el tesorero.", 
        "fecha": vfecha, 
        "nrocaja": vcajas
    });
	
    _post.success(function(requestData){
        openDialogInfo(requestData, 400, 150);
    });
	
    _post.error(postError);
}

habsencillera = function(){
    //id_apertura, cajero,
    var options = $("input:checked",$('#tbl_capert')).getCheckboxValues();
    options = options.join(',');
    var idaper= '0000000001',idcajero=options;
    dat = {
        "idaper":idaper,
        "dtcajeros":options
    };
    openDialogData1("sencillera/habsencillera", dat, 550, 450, "Sencillera");
}

sumary_totals = function(){
	
    textbox = $(this)
    tdparent = textbox.parent();
    trparent = tdparent.parent();
	
    objmonto = $('#mt_montorow',trparent);
    objtotal = $('#mt_totalrow',trparent);
	
    monto = objmonto.html();
    cant = textbox.val();
    mt_total=cant*monto;
    objtotal.val(mt_total);
	
    mt_totals=0.00;
    $(".mt_total",$('#tbl_monedas')).each(function(){
        mt_totals= mt_totals + $(this).val()*1;
    });
    $('#mt_totals').html(mt_totals);
}

guardarsencillero = function(){

    frmtblmonedas = $("#tbl_monedas").find("select, textarea, input,hidden").serialize();
    vhdid_apert = $('#hdid_apert').val();
    vhdid_cajero = $('#hdid_cajero').val();
    vtxtfech_proc = $('#txtfech_proc').val();
    vhdid_estado= $('#hdid_estado').val();
    _post = $.post(path + "sencillera/sencilleraguardar/", frmtblmonedas+"&vhdid_apert="+vhdid_apert+"&vhdid_cajero="+vhdid_cajero+"&vtxtfech_proc="+vtxtfech_proc+"&vhdid_estado="+vhdid_estado);
    _post.success(function(requestData){
        openDialogInfo(requestData, 400, 150);
    //$('#result').html(requestData);
    });
	
    _post.error(postError);
}
*/