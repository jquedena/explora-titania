

function executeActionForm_guardarSemaforo()
{
	var esValido = false;
	var valor2= parseInt($('#rangoMedio').val());
	var valor1= parseInt($('#rangoInferior').val());
        
		if(valor1 == 0 || valor2 == 0)
		{
			openDialogInfo('Los valores ingresados deben ser mayor a cero.');	
			return;			
		}		

		
		if(valor2 <= valor1)
		{
			openDialogInfo('El rango medio no puede ser menor o igual al rango inferior.');
			return;
		}
		
		esValido=true;
				 
		if(esValido)
		{
			calcularSuperior();
			openDialogConfirm('&#191;Desea guardar los datos ingresados?');
		}
		 					
}

function okButton()
{
		closeDialogConfirm();
	
		var jqxhr = $.post("guardarSemaforo.do", 
			   		   {
			           
			            'valor2': $('#rangoMedio').val(),
			            'valor1': $('#rangoInferior').val()

			   		   });
		
	    jqxhr.success(function(data) 
	    		
	    	{ 
	    		if(data.resultado != undefined && data.resultado == "ERROR")
	    		{
	    			openDialogError(data.mensaje);
	    			
	    		}		    		

	    		else if(data.resultado != undefined && data.resultado == "EXITO")
	    		{
	    			openDialogInfo(data.mensaje);
	    			
	    		}
	    		
	    		else
	    		{
	    			document.getElementById('currentForm').action = 'logout.do';
					document.getElementById('currentForm').submit();
	    		}
	    	}
	 
	    );       
}

function calcularSuperior()
{
	var valor2= parseInt($('#rangoMedio').val());
	$('#rangoSuperior').val(valor2 + 1);
}

function exportarExcelSemaforo()
{
	$('#hdrangosuperior').val($('#rangoSuperior').val());
	document.getElementById('currentForm').action = 'exportarExcelSemaforo.do';
	document.getElementById('currentForm').submit();
}
