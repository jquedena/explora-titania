var op =0;
function llenar_cajas(opt){
	op=opt;
	var html ='<table>';
	if(op==0){
		html += '<tr><td>Nro Recibo </td><td><input type="text" name="txtnrecibo" id="txtnrecibo" maxlength="12" style="text-align: right;" onkeypress="if(event.keyCode  == 13){alert(\'presiono enter xD\');}else{return validarnumeros(event)}"></input></td></tr>';
	}
	if(op==1){
		html += '<tr>'+
			'<td>Nombre</td>'+
			'<td colspan="2"><input type="text" name="txtnombre" id="txtnombre" style="width: 100%;"></input></td></tr>'+
			'<tr><td>Concepto</td><td colspan="2" ><input type="text" id="txtconcep" name="txtconcep" style="width: 100%;"></td></tr>'+
			'<tr><td>Rango Fecha</td>'+
			
			'<td><input type="text" name="txtfecha1" id="txtfecha1" style="width: 80px;" onclick="displayCalendar(this,\'dd/mm/yyyy\',this);"></input></td>'+
			'<td><input type="text" name="txtfecha2" id="txtfecha2" style="width: 80px;" onclick="displayCalendar(this,\'dd/mm/yyyy\',this);"></input></td></tr>';
	}
	if(op==2){
		html +='<tr><td>Cod.Contrubuyente</td><td><input type="text" name="txtcodcontri" id="txtcodcontri" maxlength="10" style="text-align: right;" onkeypress="if(event.keyCode  == 13){recibosbusq();}else{return validarnumeros(event)}"></input></td></tr>';
	}
	html +='</table>';
	$('#tipos').html(html);
	$("#txtfecha1").attr("readonly", true);
	$("#txtfecha1").css("background-color", "#fffbc3");
	$("#txtfecha2").attr("readonly", true);	
	$("#txtfecha2").css("background-color", "#fffbc3");
	
}

function recibosbusq(){
	var nrecibo = '';
	var nombre  = '';
	var concept = '';
	var fecha1  = '';
	var fecha2  = '';
	var ccontri ='';

	if (op==0){//recibo
		nrecibo= $('#txtnrecibo').val();
		if (nrecibo==''){alert('Ingrese Nro. de Recibo');return false;}
		nrecibo = '000000000000'+nrecibo;
		nrecibo = nrecibo.substring(nrecibo.length-12,nrecibo.length);
		$("#txtnrecibo").val(nrecibo);
	}
	if (op==1){//filtro
		nombre = $('#txtnombre').val();
		fecha1 = $('#txtfecha1').val();
		fecha2 = $('#txtfecha2').val();
		concept = $('#txtconcep').val();
		
		if (!((nombre!='') || (fecha1!='' && fecha2!='') || (concept!=''))){alert('Ingrese datos para la Busqueda');return false;}
	}
	if (op==2){//cod.contr
		ccontri =$('#txtcodcontri').val();
		if (ccontri==''){alert('Ingrese Cod. Contribuyente');;return false;}
		ccontri = '0000000000'+ccontri;
		ccontri = ccontri.substring(ccontri.length-10,ccontri.length);
		$("#txtcodcontri").val(ccontri);
	}
	
	$.ajax( {
		dataType : "html",
		type : "POST",
		url : urlprinc + "index.php/cajaduplicadosrecibos/recibosfiltro/",
		data : "nrecibo="+nrecibo+
				"&nombre="+nombre+
				"&fecha1="+fecha1+
				"&fecha2="+fecha2+
				"&ccontri="+ccontri+
				"&op="+op+
				"&concept="+concept,
		beforeSend : function(data) {
			$('#details').html('Buscando...');
		},
		success : function(requestData) {
			$("#details").html(requestData);
		},
		error : function(requestData, strError, strTipoError) {
			$("#details").html("Error " + strTipoError + ': ' + strError);
		},
		complete : function(requestData, exito) {
		}
	});
}
function recibosimp(recibo){
		var ruta =urlprinc + 'index.php/Cajaduplicadosrecibos/reciboimp/?recibo='+recibo;
		ventana=window.open(ruta,"_blank","width=570, height=500, scrollbars=yes, menubar=no, location=no, resizable=yes,status =no,directories=no");
		ventana.focus();	
}

function datosrecibo(){
	
	var nrorecibo = $("#txtrecibo").val();
	var error = '';
	
	if(nrorecibo.length < 12 ){
		error += "Ingrese numero de recibo valido.<br>";	
	}
	
	if(error.length>1){
		$("#div_errorduplicado").html(error);
	}else{			
		$("#div_errorduplicado").html('');
		$.ajax( {
			dataType : "html",
			type : "POST",
			url : jQuery.scriptPath + "index.php/cajaduplicadosrecibos/datosrecibo/",
			data : "nrorecibo="+nrorecibo,
			beforeSend : function(data) {
				$('#div_datosrecibo').html('Buscando...');
			},
			success : function(requestData) {
				$("#div_datosrecibo").html(requestData);
			},
			error : function(requestData, strError, strTipoError) {
				$("#div_datosrecibo").html("Error " + strTipoError + ': ' + strError);
			},
			complete : function(requestData, exito) {
			}
		});		
	}
}

function imprimirduplicadorecibo(nrorecibo,tipo,duplicado)
{	
	if(tipo.substring(0,1) == '*'){
		url = jQuery.scriptPath + 'index.php/pagosdiversos/imprimirreciboconceptopagodiverso/?duplicado='+duplicado+'&nrorecibo=';
	}else{
		url = jQuery.scriptPath + 'index.php/pagosarbitriospredios/imprimirrecibopagosarbitriospredios/?duplicado='+duplicado+'&nrorecibo=';
	}
	ventana=window.open(url+nrorecibo,"_blank","width=570, height=500, scrollbars=yes, menubar=no, location=no, resizable=yes,status =no,directories=no");
	ventana.focus();

}

function Generarduplicadorecibodet(tipo,nrorecibo,duplicado)
{	
		//if(tipo == '0000000273' || tipo == '0000000278'|| tipo == '0000000312' || tipo == '0000007735' || tipo == '0000002284' || tipo == '0000006369'){
		if(tipo == '0000000269' || tipo == '0000002281' ){
			url = jQuery.scriptPath + 'index.php/pagosarbitriospredios/imprimirrecibopagosarbitriospredios/?duplicado='+duplicado+'&nrorecibo=';
		}	
		else{
			url = jQuery.scriptPath + 'index.php/pagosdiversos/imprimirreciboconceptopagodiverso/?duplicado='+duplicado+'&nrorecibo=';			
		}
		ventana=window.open(url+nrorecibo,"_blank","width=570, height=500, scrollbars=yes, menubar=no, location=no, resizable=yes,status =no,directories=no");
		ventana.focus();
}
