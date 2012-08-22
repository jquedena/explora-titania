/*
	Si se ingresa un número positivo en las cajas de texto de las columnas 
	"Ajuste Territorial" y "Asignación a Gerente de Oficina" del epígrafe "Cartera Atrasada" (Monto o Ratio), 
	emitir el siguiente mensaje de alerta "La cartera atrasada debe ser negativa" y no permitir grabar.
	
	El Gerente de Oficina puede modificar la meta asignada por el Gerente Territorial o Jefe de Promoción,
	en caso el monto modificado sea menor al registrado emitir el mensaje de alerta 
	"La meta debe ser mayor o igual a lo asignado por el Gerente Territorial o JPN".
*/

/* Begin: Modificado por Juan Quedena */
$(function() {
		
	$(".textVerde, .textAmbar, .textBlanco, .textNegro, .textRojo").each(function() {
		$(this).parent().addClass($(this).attr('class'));
	});

	$("input[name=exporta]").click(function(){
		// alert('test');
		prepareJSONTable();
		document.forms["fExportarExel"].submit();
	});
});
/* End: Modificado por Juan Quedena */



function imprimir() {
	window.open("about:blank","sdo_ppg_print","width=100,height=80,scrollbars=SI");
	var form = document.forms[0];         
   form.action = "planificacionAction.do?method=imprimir";
   form.method="post";
	form.target="sdo_ppg_print";
   form.submit();
}

function envioDatos() {
	var form = document.forms[0];     
	var txtPrioridad = document.forms[0].prioridad;
	var valorPrioridad;     
	var valido = 0;
	var i;
	var temp;
	var error = [];
	
	// La meta debe ser mayor o igual a lo asignado por el Gerente Territorial o JPN
	if(txtPrioridad != null) {
		if(txtPrioridad.length > 0) {
			for(i = 0; i < txtPrioridad.length; i++) {
				if(txtPrioridad[i].className.indexOf("Text")==-1){
					i++;
				}
				
				valorPrioridad = txtPrioridad[i].value;
				
				if(valorPrioridad != null && valorPrioridad != "") {
					valido = 1;
					break;
				}
			}
			
			if(valido == 0) {
				if(txtPrioridad[i] != null) {
					txtPrioridad[i].focus();
					txtPrioridad[i].select();
				}
				
				alert("Ingrese prioridad");
			}
			
			// Validar que las prioridades sean diferentes
			var repetido;
			if(valido == 1) {
				for(var j = 0; j < txtPrioridad.length; j++) {
					temp = txtPrioridad[j].value;
					
					if(temp != null && temp != "" ) {
						for(var k = j + 1; k < txtPrioridad.length; k++) {
							if(temp == txtPrioridad[k].value) {
								valido = 0;
								repetido = j;
								break;
							}
						}
					}
				}
				
				if(valido == 0) {
					alert("No está permitido repetir la misma prioridad");
					txtPrioridad[repetido].focus();
					txtPrioridad[repetido].select();
				}
			}
		}
	}
	
	if(valido!=0){
		i = 0;
		if(codPerfil == "GOF") {
			$("input[name=factAjusGereOfic]").each(function() {
				prior = $.trim($(this).parent().parent().find('td').eq(15).find('input').val());
				
				if(Math.abs(parseFloat($(this).val())) < Math.abs(parseFloat($(this).attr('valueOld'))) && prior != '') {
					if($(this).attr('valueOld')!=0) {
						$(this).val($(this).attr('valueOld'));
					}
					error[i] = {mensaje: 'La meta debe ser mayor o igual a lo asignado por el Gerente Territorial o JPN', objeto: $(this)};
					i++;
				}
			});
			
			$("input[name=factAjusTerri]").each(function() {
				prior = $.trim($(this).parent().parent().find('td').eq(15).find('input').val());
			
				if(Math.abs(parseFloat($(this).val())) < Math.abs(parseFloat($(this).attr('valueOld'))) && prior != '') {
					if($(this).attr('valueOld')!=0) {
						$(this).val($(this).attr('valueOld'));
					}
					error[i] = {mensaje: 'La meta debe ser mayor o igual a lo asignado por el Gerente Territorial o JPN', objeto: $(this)};
					i++;
				}
			});
			
			if(error.length>0){
				valido = 0;
				alert(error[0].mensaje);
				error[0].objeto.focus();
				return;
			}
		}
		
		// Valida Montos
		i = 0;
		$("input[name=factAjusTerri], input[name=factAjusGereOfic]").each(function() {
			var cellContent = $(this).parent().parent().find('td').eq(0).html();
			prior = $.trim($(this).parent().parent().find('td').eq(15).find('input').val());
			
			if(cellContent.toUpperCase().indexOf('CARTERA ATRASADA')>=0) {
				if(parseInt($(this).val())>0 && prior != '') {
					error[i] = {mensaje: 'La cartera atrasada debe ser negativa', objeto: $(this)};
					i++;
				}
			} else {
				if(parseInt($(this).val())<0 && prior != '') {
					error[i] = {mensaje: 'El monto no puede ser negativo para el epigrafe ' + cellContent, objeto: $(this)};
					i++;
				}
			}
		});
		
		if(error.length>0){
			valido = 0;
			alert(error[0].mensaje);
			error[0].objeto.focus();
		}
	}
	
	form.action = "planificacionAction.do?method=grabar";
	form.method="post";
	// Verifica cuando se ha ingresado ya se hecho un calculo anteriormente
	var suma = 0;
	for(var i = 0; i < form.monto.length; i++) {
		suma += parseFloat(form.metaMesSaldPunt[i].value);
	}
	if(suma > 0) {
		calculosRealizados = 1;
	}
	// validación
	if(valido == 1) {
		if(calculosRealizados == 1) {
			var resp = confirm("¿Desea guardar los cambios?");
			if(resp) {
				form.submit();
				$("input[name=exporta]").attr('disabled', false);
			}
		} else {
			alert("Pulse Calcular");
		}   
	}
}

function buscar() {
    var form = document.forms[0];         
    form.action = "planificacionAction.do?method=inicio";
    form.method="post";
    form.submit();
}

function buscarResumen(r) {
    var form = document.forms[0];    
    form.action = "planificacionAction.do?method=resumen";
    form.method="post";
    form.submit();
}

function imprimirFinal() {	
	window.print();
}

function historial() {
	var form = document.forms[0];         
    form.action = "planificacionAction.do?method=historial";
    form.method="post";
    form.submit();
}