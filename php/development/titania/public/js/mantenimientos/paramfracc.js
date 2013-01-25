function verificaropparam(){
	 if($("#opcion1").is(':checked')) {
			$( "#txtporimpofracct" ).val(0);
			$( "#txtmontdetert" ).val(0);
	 }
	 
	 if($("#opcion2").is(':checked')) {		 
		 
	 }
	 
//	 if($("#opcion3").is(':checked')) {
//		 $("#txtporimpofracctipjur").val(0);
//		 $("#txtmontdeterttipjur").val(0);
//			
//		 $("#txtporimpofracctipnorm").val(0);
//		 $("#txtmontdeterttipnorm").val(0);			
//	 }
//	 
		 
}

function manttcentrpob(p_tipo){
 var p_idsigma=$("#txtidsigma").val();
 var p_ncantidad=$("#txtmontdetert").val();
 var p_nporcentaje=$("#txtporimpofracct").val();
 var p_codigo_doc=$("#cbocoddoc").val();
 var p_cresolucion=$("#txtnrodoc").val();
 var p_dfec_resol=$("#txtfechdoc").val();
	 
	

$.ajax( {
	dataType : "html",
	type : "POST",
	url : path + "/mantenimientos/paramrecsave/",
	data :  "p_idsigma="+p_idsigma+
			 "&p_ncantidad="+p_ncantidad+
			 "&p_nporcentaje="+p_nporcentaje+
			 "&p_codigo_doc="+p_codigo_doc+
			 "&p_cresolucion="+p_cresolucion+
			 "&p_dfec_resol="+p_dfec_resol,
	beforeSend : function(data) {
		$('#locategrid').html('Procesando...');
	},
	success : function(requestData) {
		$("#locategrid").html(requestData);
	},
	error : function(requestData, strError, strTipoError) {
		$("#locategrid").html("Error " + strTipoError + ': ' + strError);
	},
	complete : function(requestData, exito) {
		window.location.reload();
	}
});


}
