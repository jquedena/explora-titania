function MostrarBuscarConceptosPagosDiversos(datoscpd)
{	
	//alert(datoscpd);
	
	var v = $("#hidden_buscarconcepto").val();
		if(v == 0){
			$("#hidden_buscarconcepto").val('1');
			//$("#div_buscarconcepto").html(datoscpd);
				$.ajax( 
			 	{
			 	dataType: "html",
			 	type: "POST",
			 	url:  jQuery.scriptPath + "index.php/pagosdiversos/busqconceptopagodiverso/", // ruta donde se encuentra nuestro action que procesa la peticion XmlHttpRequest
			 	data: "datoscpd="+datoscpd,
				beforeSend: function(data){ 
				$('#div_buscarconcepto').html('Cargando...');//Usando JQUERY, Mostramos el mensaje cargando en la lista regiones. (un efecto visual)
				},
				success: function(requestData){ 	//Llamada exitosa
				$("#div_buscarconcepto").html(requestData);
				},		
				error: function(requestData, strError, strTipoError){
				//En caso de error mostraremos un alert
				$("#div_buscarconcepto").html("Error " + strTipoError +': ' + strError);
				},
				complete: function(requestData, exito){ //fin de la llamada ajax.
				// 		En caso de usar una gif (cargando...) aqui quitas la imagen
				}
				});
		}else{			
			$("#hidden_buscarconcepto").val('0');
			$("#div_buscarconcepto").html('');
		}
}

function MostrarDetalleConceptoPagosDiversos()
{
	var datos =  $("#cbconceptos").val();
	var arraydatos = datos.split('|');
	var cod   = arraydatos[0];
	var des   = arraydatos[1];
	var cid   = arraydatos[2];
	var monto = arraydatos[3];
	$("#codconcepto").html(cod);	
	$("#descripconceptomin").html('<font size="1">'+des+'</font>');
	$("#descripconcepto").val(des);	
	$("#cidconcepto").val(cid);
	$("#montoconcepto").val(monto);
	$("#cantidadconcepto").val('1');
	$("#glosaconcepto").val('');
}

function BusqXCriterioConceptoPagosDiversos(crit,datos)
{
	
	var criterio = crit;
		if(criterio == 1){ //por codigo
			val =  $("#busqxcodconcepto").val();
			$("#busqxnomconcepto").val('');
		}if(criterio == 2){ //por nombre de concepto
			val =  $("#busqxnomconcepto").val();
			$("#busqxcodconcepto").val('');
		}
		
		var cadrequest = '';
	
		datos = replaceAll(datos,"&","^");
		
	$.ajax( 
 	{
 	dataType: "html",
 	type: "POST",
 	url:  jQuery.scriptPath + "index.php/pagosdiversos/busqxcriterioconceptopagosdiversos/", // ruta donde se encuentra nuestro action que procesa la peticion XmlHttpRequest
 	data: 'datoscpd='+datos+
 		  '&criterio='+criterio+
 		  '&valor='+val,
	beforeSend: function(data){ 
	$('#cbconceptos').html('Cargando...');//Usando JQUERY, Mostramos el mensaje cargando en la lista regiones. (un efecto visual)
	},
	success: function(requestData){ 	//Llamada exitosa
		$("#cbconceptos").html(requestData);
		MostrarDetalleConceptoPagosDiversos();
		$("#montoconcepto").focus();
	},		
	error: function(requestData, strError, strTipoError){
	//En caso de error mostraremos un alert
	$("#cbconceptos").html("Error " + strTipoError +': ' + strError);
	},
	complete: function(requestData, exito){ //fin de la llamada ajax.
	// 		En caso de usar una gif (cargando...) aqui quitas la imagen
	}
	});
}

function AgregarDetalleConceptoPagosDiversos()
{
	var cod      = $("#codconcepto").html();
	var des      = $("#descripconcepto").val();
	var cid      = $("#cidconcepto").val();
	var monto    = $("#montoconcepto").val();
	var cantidad = $("#cantidadconcepto").val();
	var glosa = $("#glosaconcepto").val();
	
		if(cod=='' || cod == null ){
			$("#div_erroragregarconcepto").html('<font color="#FF0000">Seleccionar el conceptop a cobrar.</font>');			
		}else if(monto=='0.00' || monto == '' || monto == '0'){
			$("#div_erroragregarconcepto").html('<font color="#FF0000">Ingresar monto a cobrar a dicho concepto.</font>');			
		}else if(cantidad == '' || cantidad == '0'){
			$("#div_erroragregarconcepto").html('<font color="#FF0000">Ingresar cantidad de conceptos a cobrar.</font>');
		}else{			
			$.ajax( 
		 	{
		 	dataType: "html",
		 	type: "POST",
		 	url:  jQuery.scriptPath + "index.php/pagosdiversos/agregarconceptopagodiverso/", // ruta donde se encuentra nuestro action que procesa la peticion XmlHttpRequest
		 	data: "cod="+cod+
		 		  "&des="+des+
		 		  "&cid="+cid+
		 		  "&monto="+monto+
		 		  "&cantidad="+cantidad+
		 		  "&glosa="+glosa,
			beforeSend: function(data){ 
		 	$("#div_erroragregarconcepto").html('');	
			$("#divdetallepagodiverso").html('Cargando...');//Usando JQUERY, Mostramos el mensaje cargando en la lista regiones. (un efecto visual)
			},
			success: function(requestData){ 	//Llamada exitosa
				//$("#hidden_buscarconcepto").val('0');
				//$("#div_buscarconcepto").html('');
			$("#divdetallepagodiverso").html(requestData);
				
			},		
			error: function(requestData, strError, strTipoError){
			//En caso de error mostraremos un alert
			$("#divdetallepagodiverso").html("Error " + strTipoError +': ' + strError);
			},
			complete: function(requestData, exito){ //fin de la llamada ajax.
			// 		En caso de usar una gif (cargando...) aqui quitas la imagen
			}
			});
		}		
}

function BorrarDetalleConceptoPagosDiversos(vcod,vmonto)
{
	var cod       = vcod;
	var cantidad  = '1';
	var monto = vmonto;
	
	$("#div_erroragregarconcepto").html("");
	$.ajax( 
 	{
 	dataType: "html",
 	type: "POST",
 	url:  jQuery.scriptPath + "index.php/pagosdiversos/borrarconceptopagodiverso/", // ruta donde se encuentra nuestro action que procesa la peticion XmlHttpRequest
 	data: "cod="+cod+
 		  "&cantidad="+cantidad+
 		  "&monto="+monto,
	beforeSend: function(data){ 
	$("#divdetallepagodiverso").html('Cargando...');//Usando JQUERY, Mostramos el mensaje cargando en la lista regiones. (un efecto visual)
	},
	success: function(requestData){ 	//Llamada exitosa
	$("#divdetallepagodiverso").html(requestData);
	},		
	error: function(requestData, strError, strTipoError){
	//En caso de error mostraremos un alert
	$("#divdetallepagodiverso").html("Error " + strTipoError +': ' + strError);
	},
	complete: function(requestData, exito){ //fin de la llamada ajax.
	// 		En caso de usar una gif (cargando...) aqui quitas la imagen
	}
	});	
}

function BorrarTodoDetalleConceptoPagosDiversos()
{
	$("#div_erroragregarconcepto").html("");
	$.ajax( 
 	{
 	dataType: "html",
 	type: "POST",
 	url:  jQuery.scriptPath + "index.php/pagosdiversos/borrartodoconceptopagodiverso/", // ruta donde se encuentra nuestro action que procesa la peticion XmlHttpRequest
 	data: "",
	beforeSend: function(data){ 
	$("#divdetallepagodiverso").html('Cargando...');//Usando JQUERY, Mostramos el mensaje cargando en la lista regiones. (un efecto visual)
	},
	success: function(requestData){ 	//Llamada exitosa
	$('#cobrar').removeAttr('disabled');
	$("#divdetallepagodiverso").html(requestData);
	},		
	error: function(requestData, strError, strTipoError){
	//En caso de error mostraremos un alert
	$("#divdetallepagodiverso").html("Error " + strTipoError +': ' + strError);
	},
	complete: function(requestData, exito){ //fin de la llamada ajax.
	// 		En caso de usar una gif (cargando...) aqui quitas la imagen
	}
	});	
}

function CobrarConceptoPagosDiversos()
{
	$.ajax( 
 	{
 	dataType: "html",
 	type: "POST",
 	url:  jQuery.scriptPath + "index.php/pagosdiversos/cobrarconceptopagodiverso/", // ruta donde se encuentra nuestro action que procesa la peticion XmlHttpRequest
 	data: "",
	beforeSend: function(data){ 
 	$("#cobrar").attr('disabled','disabled'); 
	$("#div_resultpagosdiversos").html('Cargando...');//Usando JQUERY, Mostramos el mensaje cargando en la lista regiones. (un efecto visual)
	},
	success: function(requestData){ 	//Llamada exitosa
	$("#div_resultpagosdiversos").html(requestData);
	},		
	error: function(requestData, strError, strTipoError){
	//En caso de error mostraremos un alert
	$("#div_resultpagosdiversos").html("Error " + strTipoError +': ' + strError);
	},
	complete: function(requestData, exito){ //fin de la llamada ajax.
	// 		En caso de usar una gif (cargando...) aqui quitas la imagen
	}
	});	
}

function CobrarConceptoPiscinaPagosDiversos()
{
	var cod         = $("#cbconceptos").val();
	var cantadulto  = $("#txtadulto").val();
	var cantninio   = $("#txtninio").val();
	var montoadulto = $("#txtadultocosto").val();
	var montoninio  = $("#txtniniocosto").val();
	var error = '';
	
		if(cod=='' || cod == null ){
			error += '<font color="#FF0000">Seleccionar el conceptop a cobrar.</font><br>';			
		}
		
		if(parseInt(cantadulto) > 0 || parseInt(cantninio) > 0){
			if(cantadulto.length>0){
				if(montoadulto=='0.00' || montoadulto == '' || montoadulto == '0'){
					error += '<font color="#FF0000">Ingresar monto a cobrar para los adultos.</font><br>';			
				}
			}
			if(cantninio.length>0){
				if(montoninio=='0.00' || montoninio == '' || montoninio == '0'){
					error += '<font color="#FF0000">Ingresar monto a cobrar para los niños.</font><br>';			
				}
			}
		}else{
			error += '<font color="#FF0000">Ingresar cantidad de almenos 1 adulto o 1 ni&ntilde;o.</font><br>';
		}
			
		
		if(error.length>0){
			$("#div_piscinarpta").html(error);
		}else{			
			
			//alert(cod+"->"+cantadulto+"->"+cantninio+"->"+montoadulto+"->"+montoninio);
			
			$.ajax( 
		 	{
		 	dataType: "html",
		 	type: "POST",
		 	url:  jQuery.scriptPath + "index.php/pagosdiversos/cobrarconceptopagodiversopiscina/", // ruta donde se encuentra nuestro action que procesa la peticion XmlHttpRequest
		 	data: "cod="+cod+
		 		  "&cantadulto="+cantadulto+
		 		  "&cantninio="+cantninio+
		 		  "&montoadulto="+montoadulto+
		 		  "&montoninio="+montoninio,
			beforeSend: function(data){ 
		 	$("#div_piscinarpta").html('');	
			$("#div_piscinaimpresion").html('Cargando...');//Usando JQUERY, Mostramos el mensaje cargando en la lista regiones. (un efecto visual)
			},
			success: function(requestData){ 
			$("#div_piscinaimpresion").html(requestData);
				
			},		
			error: function(requestData, strError, strTipoError){
			//En caso de error mostraremos un alert
			$("#div_piscinaimpresion").html("Error " + strTipoError +': ' + strError);
			},
			complete: function(requestData, exito){ //fin de la llamada ajax.
			// 		En caso de usar una gif (cargando...) aqui quitas la imagen
			}
			});
		}		
}