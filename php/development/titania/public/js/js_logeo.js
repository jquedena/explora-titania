function ValidarLogeo() {
	var user = $('#txtuser').val();
	var pass = $('#txtpass').val();
	var nivel = $('#cbnivel').val();
	
	var parameters = {user: escape(user), pass: escape(pass), nivel: nivel};
	var _post = $.post(path + "logeo/validarlogeo/", parameters);
	
	_post.success(function(requestData){
		$("#div_resp_logeo").html(requestData);
	});
	
	_post.error(function(requestData, errMessage, errNumber){
		if(errNumber == '') {
			openDialogError("No se puede determinar el error.");
		} else {
			openDialogError(errNumber +': ' + errMessage);
		}
	});
}

