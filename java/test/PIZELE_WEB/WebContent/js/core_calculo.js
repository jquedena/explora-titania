
var validarQuintaSemana = true;

function fn_calcTotal(controlsArray){
	var total=0;
	var controlValue=0;
	for (var i=0; i<controlsArray.length; i++) {
		controlValue = $("#" + controlsArray[i]).val();
		controlValue = controlValue=='' ? 0 : controlValue;
		$("#" + controlsArray[i]).val(controlValue*1);
		total += parseInt(controlValue);
	}
	return total;
}

function fn_ActivarQuintaSemana() 
{
	
	if(!validarQuintaSemana)
		return;
	
	var activarSemana = true;
	var anio = $('#idAnio').val();
	var mes = ($('option:selected', '#idMes').index()-1);

	if (anio!="-1" && mes!="-1") {
   		var fmFebrero = ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))) ? 29 : 28;
   		var DAYS_IN_MONTH = [31, fmFebrero, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
   		var di = new Date(anio, mes, 1, 0, 0, 0, 0);
   		var df = new Date(anio, mes, DAYS_IN_MONTH[mes], 0, 0, 0, 0);
   		
   		/* Si (es febrero e inicia en domingo (0) o sabado (6) )  
   		   ó finaliza en domingo (0) entonces solo tiene 4 semanas.
   		   Se desactiva la semana 5
   		*/
   		activarSemana = ((mes==1 && (di.getDay()==0 || di.getDay()==6)) || df.getDay()==0) ? false : activarSemana; 
   		
   		if (activarSemana)
			$('#semana5').removeAttr('disabled');
		else
			$('#semana5').attr('disabled','-1');
	}
	else
		$('#semana5').removeAttr('disabled');
}

function fn_tieneQuintaSemana() {
	var activarSemana = true;
	var anio = $('#idAnio').val();
	var mes = ($('option:selected', '#idMes').index()-1);

	if (anio!="-1" && mes!="-1") {
   		var fmFebrero = ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))) ? 29 : 28;
   		var DAYS_IN_MONTH = [31, fmFebrero, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
   		var di = new Date(anio, mes, 1, 0, 0, 0, 0);
   		var df = new Date(anio, mes, DAYS_IN_MONTH[mes], 0, 0, 0, 0);
   		
   		/* Si (es febrero e inicia en domingo (0) o sabado (6) )  
   		   ó finaliza en domingo (0) entonces solo tiene 4 semanas.
   		   Se desactiva la semana 5
   		*/
   		activarSemana = ((mes==1 && (di.getDay()==0 || di.getDay()==6)) || df.getDay()==0) ? false : activarSemana; 
   		
   		if (activarSemana)
			$('#semana5').removeAttr('disabled');
		else
			$('#semana5').attr('disabled','-1');
	}
	else
	{
		activarSemana = false;
		$('#semana5').removeAttr('disabled');
	}
		
	return activarSemana;
	
}