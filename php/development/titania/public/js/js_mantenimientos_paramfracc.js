function verificaropparam(){
	 if($("#opcion1").is(':checked')) {
	 }
	 
	 if($("#opcion2").is(':checked')) {		 
		 
			$( "#txtporimpofracct" ).val(0);
			$( "#txtmontdetert" ).val(0);
	 }
	 
	 if($("#opcion3").is(':checked')) {
		 $("#txtporimpofracctipjur").val(0);
		 $("#txtmontdeterttipjur").val(0);
			
		 $("#txtporimpofracctipnorm").val(0);
		 $("#txtmontdeterttipnorm").val(0);			
	 }
	 
		 
}
