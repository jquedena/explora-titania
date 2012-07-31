function GenerarRepoteCaja() {	
    var tipo = $("#tiporpt").val();
    var codcajero = $("#txtcodcajero").val();
    codcajero = '0000'+codcajero;
    codcajero = codcajero.substring(codcajero.length-4,codcajero.length);
    $("#txtcodcajero").val(codcajero);
	
    var d = $("#rptdia").val();
    var m = $("#rptmes").val();
    var a = $("#rptanio").val();
	
    var df = $("#rptdiaf").val();
    var mf = $("#rptmesf").val();
    var af = $("#rptaniof").val();
	
    var fecha = d+'/'+m+'/'+a;
    var fechaf = df+'/'+mf+'/'+af;
    if(fechaf.length > 10){
        fechaf = fecha;			
    }
	
    var tfp = $("#cbtipopago").val(); //tipo forma de pago	
		
    var url = '';
    var error = '';
		
    if(tipo == '0'){		
        error += 'Seleccione un Tipo de Reporte...<br>';
    }
	
    //if(tfp == '9999999999'){error += 'Seleccione un Tipo de Forma de pago...<br>';}
	
    if(error.length>0){
        $("#div_rptapartediario").html(error);
    }
    else{		
        $("#div_rptapartediario").html('');
        if(tipo == '1'){
            //PARTE DIARIO
            //url = urlprinc + 'index.php/cajareportes/imprimircajapartediariopdf/?codcajero='+codcajero+'&fecha='+fecha+'&fechaf='+fechaf;
            url = path + 'cajareportes/imprimirpt/?nomreport='+'partediarioxcajero&codcajero='+codcajero+'&fecha='+fecha+'&fechaf='+fechaf+'&tipo=pdf'+'&paramextra=P_TIPOPAGO^'+tfp;
        }	
        if(tipo == '2'){
            //TIPO DE INGRESO
            //url = urlprinc + 'index.php/cajareportes/imprimircajatipoingresopdf/?codcajero='+codcajero+'&fecha='+fecha+'&fechaf='+fechaf;
            url = path + 'cajareportes/imprimirpt/?nomreport='+'reportetipoxcajero&codcajero='+codcajero+'&fecha='+fecha+'&fechaf='+fechaf+'&tipo=pdf'+'&paramextra=P_TIPOPAGO^'+tfp;
        }
        
        if(trim(url) == ''){
            return;
        }else{
            ventana=window.open(url,"recibos","width=750, height=560 , scrollbars = yes , menubar=no, location=no, resizable=no,status =no,directories=no");
            ventana.focus();
        }
    }
}