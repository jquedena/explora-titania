function PagosAnularRecibo(){
	
	var nrorec = $("#txtnrorecibo").val();
	var obs    = $("#txtobs").val();
	var error = "";
	
	$("#div_rptaerroranular").html('');
	
	if(nrorec.length < 12 ){
		error = "Ingrese numero de recibo valido.<br>";	
	}
	
	if(error.length>1){
		$("#div_rptaerroranular").html(error);
	}else{
		var answer = confirm("Seguro de eliminar el recibo nro. "+nrorec+"?");
		if (answer){
			$.ajax({
			 	dataType: "html",
			 	type: "POST",
			 	url:  jQuery.scriptPath + "index.php/pagoanularrecibo/anular/",
			 	data: "nrorec="+nrorec+
			 		  "&obs="+obs,
				success: function(requestData){
					$("#div_rptaanular").html(requestData);
				},		
				error: function(requestData, strError, strTipoError){
					$("#div_rptaanular").html("Error " + strTipoError +': ' + strError);
				}
			});
		}
		
	}
		
}