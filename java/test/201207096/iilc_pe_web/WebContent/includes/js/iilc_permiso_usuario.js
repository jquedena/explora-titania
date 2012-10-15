$(function(){
	$("input[name=allTerritorio]").click(function(){
		var checked = $(this).attr('checked') ? true : false;
		$(".territorio").attr('checked', checked);
		chk = $(this).attr('checked') ? "inline" : "none";
		$(".oficinaDiv").css({'display':chk});
		if(chk=='none'){
			$(".oficina").attr('checked', false);
			$("input[name=allOficina]").attr('checked', false);
		}
	});
	
	$("input[name=allOficina]").click(function(){
		var checked = $(this).attr('checked') ? true : false;
		// $(".oficina").attr('checked', checked);
		$(".oficinaDiv").each(function(){
			if($(this).css("display").indexOf("inline")>-1) {
				$(this).find("input").attr('checked', checked);
				// console.log("now:" + $(this).css("display") + ":" + $(this).find("input").attr('name') + ":" + checked);
			}
		});
	});
	
	$(".territorio").click(function(){
		cta = 0;
		chk = $(this).attr('checked') ? "inline" : "none";
		$("." + $(this).attr('name').replace('terr_', '')).css({"display":chk});
		$("." + $(this).attr('name').replace('terr_', '')).attr('checked', 'false');
		$("." + $(this).attr('name').replace('terr_', '')).each(function(){
			if(chk.indexOf("none")>-1) {
				$(this).find('input').attr('checked', false);
			}
		});
		$(".territorio").each(function(){
			chk = $(this).attr('checked') ? true : false;
			if(chk != true) {
				cta++;
			}
		});
		$("input[name=allTerritorio]").attr('checked', (cta > 0) ? false : true);
	});
	
	$(".oficina").click(function(){
		cta = 0;
		$(".oficina").each(function(){
			chk = $(this).attr('checked') ? true : false;
			if(chk != true) {
				cta++;
			}
		});
		$("input[name=allOficina]").attr('checked', (cta > 0) ? false : true);
	});
	
	$("input[name=registro]").blur(function(){
		$(this).val($(this).val().toUpperCase());
	});
	
	$("input[name=cmdLimpiar]").click(function(){
		$("input:checkbox").attr('checked', false);
		$(".oficinaDiv").css({'display':'none'});
		
		// $("input[name=cmdGrabar]").css('display', 'none');
		// $("input[name=cmdGrabar1]").css('display', 'inline');
		// $("input[name=cmdEliminar]").css('display', 'none');
		// $("input[name=cmdEliminar1]").css('display', 'inline');
		
		// $("input[name=cmdBuscar]").css({'display':'inline'});
		$("input[name=registroDisabled]").css({'display':'none'});
		$("input[name=registro]").css({'display':'inline'});
		$("input[name=registro]").val("");
		$("input[name=registro]").focus();
		$('#usuario').html('');
	});
	
	$("input[name=cmdEliminar]").click(function(){
		id = $("input[name=registro]").val();
		if(id.length==0){
			id = $("input[name=registroDisabled]").val();
			$("input[name=registro]").val(id);
		}
		if(id.length==0){
			alert('Debe ingresar un n\u00FAmero de registro');
			$("input[name=registro]").focus();
			return;
		}
		
		if(confirm("\u00BFEsta seguro que desea eliminar el registro?")) {
			$.ajax({
				dataType: "html",
				type: "POST",
				url: contexto + "permisoUsuario.do",
				data: "method=eliminar&codUsuario="+$("input[name=registro]").val(),
				beforeSend: function() {
				},
				success: function(requestData) {
					alert(requestData);
					if(requestData.indexOf('exito')>-1){
						$("input[name=cmdLimpiar]").click();
					}
				},
				error: function(requestData, strError, strTipoError) {
					alert("Error:" + strError + ", " + strTipoError);
				}
			});
		}
	});
	
	$("input[name=cmdBuscar]").click(function(){

		if($("input[name=registro]").val().length==0){
			alert('Debe ingresar un n\u00FAmero de registro');
			$("input[name=registro]").focus();
			return;
		}

		$.ajax({
			dataType: "html",
			type: "POST",
			url: contexto + "permisoUsuario.do",
			data: "method=buscar&codUsuario="+$("input[name=registro]").val(),
			beforeSend: function() {
			},
			success: function(requestData) {
				_registro = $("input[name=registro]").val();
				$("input[name=cmdLimpiar]").click();
				$("input[name=registroDisabled]").val(_registro);
				$("input[name=registroDisabled]").css({'display':'inline'});
				$("input[name=registro]").css({'display':'none'});			
				// $("input[name=cmdBuscar]").css({'display':'none'});
				$("#result").html(requestData);
				$("input[name=registro]").val(_registro);
			},
			error: function(requestData, strError, strTipoError) {
				alert("Error:" + strError + ", " + strTipoError);
			}
		});
	});
	
	$("input[name=cmdGrabar]").click(function(){
		id = $("input[name=registro]").val();
		if(id.length==0){
			id = $("input[name=registroDisabled]").val();
			$("input[name=registro]").val(id);
		}
		if(id.length==0){
			alert('Debe ingresar un n\u00FAmero de registro');
			$("input[name=registro]").focus();
			return;
		}
		
		$.ajax({
			dataType: "html",
			type: "POST",
			url: contexto + "permisoUsuario.do",
			data: "method=buscar&verificar=si&codUsuario="+$("input[name=registro]").val(),
			beforeSend: function() {
			},
			success: function(requestData) {
				$("#result").html(requestData);
			},
			error: function(requestData, strError, strTipoError) {
				alert("Error:" + strError + ", " + strTipoError);
			}
		});
	});	
	
	$("input[name=cmdSalir]").click(function(){
		location.href = contexto+"pages/iilc_listado_administrador.jsp";
	});
});