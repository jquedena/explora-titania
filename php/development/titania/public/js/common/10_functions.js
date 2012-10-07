function contenidocombo(data){
	var cad = '<option value="9999999999">Seleccionar...</option>';
	$.each(data, function(i , colum){
		var codigo = colum[0];
		var descripcion = colum[1];		
		cad +='<option value="' + codigo + '">' + descripcion + '</option>';
	});	
	return cad;
}