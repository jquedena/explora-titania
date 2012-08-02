function solamente_numeros(e){
	tecla = (document.all) ? e.keyCode : e.which; 
	//alert(tecla);
	if (tecla==13) return true;
    if (tecla==8) return true; //Tecla de retroceso (para poder borrar) 
    if (tecla==0) return true;
    
	patron = /\d/;
	te = String.fromCharCode(tecla); 
	
    return patron.test(te);
}


function Datepiked(name){
		var dates = $(name).datepicker({
			closeText: "Cerrar",
			prevText: "&#x3c;Ant",
			nextText: "Sig&#x3e;",
			currentText: "Hoy",
			dateFormat: "dd/mm/yy",
		    maxDate: "+0d",
			changeMonth: true,
			changeYear:true,
			numberOfMonths: 1,
			minDate:"-25000"
		});
}

$(function() {
	$( "#dialog:ui-dialog" ).dialog( "destroy" );					
	$( "#sencilleradetalle" ).dialog({
		resizable: false,
		height:490,
		width:600,
		modal: true,
		autoOpen:false,
		draggable:false
	});
});



$(function() {
	$( "#dialog:ui-dialog" ).dialog( "destroy" );					
	$( "#sencilleraapertura" ).dialog({
		resizable: false,
		height:250,
		width:350,
		modal: true,
		autoOpen:false,
		draggable:false
	});
});

$(function() {
	$( "#dialog:ui-dialog" ).dialog( "destroy" );					
	$( "#AlertaSencillera" ).dialog({
		resizable: false,
		height:150,
		width:300,
		modal: true,
		autoOpen:false,
		draggable:false
	});
});

$(function() {
	$('#btnDetallesencillera').click(function(event){ 
		$('#sencilleradetalle').dialog("open");
	});
	

	$('#btnNrocaja_sencillera').click(function(event){ 
		ocultartext_sencillera(1);
	});
	$('#btnFecha_sencillera').click(function(event){ 
		ocultartext_sencillera(2);
	});
	$('#btnTodo_sencillera').click(function(event){ 
		ocultartext_sencillera(2);
	});

	
});

$(function() {
	$('#btnAperturarsencillera').click(function(event){ 
		$('#sencilleraapertura').dialog("open");
	});
	
	$('#btnConsultar_sencillera').click(function(event){ 
		consultasencillera();
	});
	
	$('#txtNrocaja_sencillera').keypress(function(event){ 
		return solamente_numeros(event); 
	});
	//
	$('#txtNrocaja_sencillera').keypress(function(event){ 
		return solamente_numeros(event); 
	});
	
	for(var x=0 ;x<=12;x++){
		$('#text'+x).keypress(function(event){ 
			return solamente_numeros(event); 
		});
	}
	$('#txtTotal_Sencillera').keypress(function(event){ 
		return solamente_numeros(event); 
	});
	$('#txtNrocaja_aperturasencillera').keypress(function(event){ 
		return solamente_numeros(event); 
	});
});



$(function(){
	$("#txtNrocaja_sencillera").hide();
	Datepiked('#txtFecha1_sencillera');
	Datepiked('#txtFecha2_sencillera');
	Datepiked('#txtFechaapertura_sencillera');
	ocultartext_sencillera(1);
		
})

function ocultartext_sencillera(caso){
	if (caso ==null || caso ==''){return;}
	
	if(caso==1){
		$("#lblNombre_sencillera").html('<b>Nro. Caja </b>');
		$("#txtNrocaja_sencillera").show();
		$("#txtFecha1_sencillera").hide();
		$("#txtFecha2_sencillera").hide();
		$("#btnConsultar_sencillera").css('margin-left','212px');
		
	}else if(caso==2){
		$("#lblNombre_sencillera").html('<b>Rango Fecha</b>');
		$("#txtNrocaja_sencillera").hide();
		$("#txtFecha1_sencillera").show();
		$("#txtFecha2_sencillera").show();
		$("#btnConsultar_sencillera").css('margin-left','85px');
	}
	return;
}

function consultasencillera(){
	var nrocaja=$("#txtNrocaja_sencillera").val();
	var fecha1=$("#txtFecha1_sencillera").val();
	var fecha2=$("#txtFecha2_sencillera").val();
	
	if( $('#txtNrocaja_sencillera').is (':visible')){
		if (nrocaja== null || nrocaja=='') return;
	}
	
	if( $('#txtFecha1_sencillera').is (':visible')){
		if (fecha1== null || fecha1==''|| fecha2== null || fecha2=='') return;
	}
	
	
	
}



