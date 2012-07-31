$(function(){
	display = 'block';
	if(__rw != true) {
		display = 'none';
	}
	$("#Nuevo").css({'display': display});
	Buscar();
});

function pageselectCallback(page_index, jq){
	var items_per_page = $("#items_per_page").val();
	var max_elem = Math.min((page_index+1) * items_per_page, members.length);
	var newcontent = "";
	var cadcontentrow = "";
	var urlredirect = $("#urlredirect").val(); 
	var fech = $("#fech").val();
	newcontent += '<table style="width: 100%; height: 20px;" border="0" cellpadding="0" cellspacing="0">';
	newcontent += '<thead class="ui-widget ui-widget-header ui-title2"><tr>';
	newcontent += '<th style="width: 90px;">C\u00F3digo</th>';
	newcontent += '<th style="width: 130px;">Nro. Doc.</th>';
	newcontent += '<th>Nombre de Persona</th>';
	if(__rw == true) {
		newcontent += '<th style="width: 24px">&nbsp;</th>';
		newcontent += '<th style="width: 24px">&nbsp;</th>';	
	}
	newcontent += '<th style="width: 24px">&nbsp;</th>';
	newcontent += '</tr></thead></table>';
	newcontent += '<table id="tblPersona" style="width: 100%;" border="0" cellpadding="0" cellspacing="0"><tbody class="ui-table-body">';
	for(var i=page_index*items_per_page;i<max_elem;i++){
		cadcontentrow = '<tr>';
		cadcontentrow += '<td style="width: 90px; text-align: center;">'+members[i][0]+'</td>';
		cadcontentrow += '<td style="width: 130px;"><span style="padding-left: 10px;">'+$.trim(members[i][3])+' '+$.trim(members[i][4])+'</span></td>';
		cadcontentrow += '<td><span style="padding-left: 10px;">'+members[i][1]+'</span></td>';
		if(__rw == true) {
			cadcontentrow += '<td style="width: 24px" class="ui-editar">&nbsp;</td>';
			cadcontentrow += '<td style="width: 24px" class="ui-eliminar">&nbsp;</td>';
		}
		cadcontentrow += '<td style="width: 24px" class="ui-ver">&nbsp;';
		cadcontentrow += '<input type="hidden" value="'+ urlredirect + members[i][0] + '|' + members[i][1] + '|' + members[i][2]+'|'+ fech + '">';
		cadcontentrow += '</td>';
		cadcontentrow += '</tr>';
		newcontent += cadcontentrow;
	}

	newcontent += "</tbody></table>";
	$("#Searchresult").html(newcontent);
	$("#tblPersona").delegate('tr', 'click', function() {
		url = $(this).find('input').val();
		DoNavrow(url);
	});
	
	$("#a_0").focus();
	
	mouseHover("tblPersona");
	return false;
}

function getOptionsFromForm(){
	var opt = {callback: pageselectCallback};
	$("input:hidden").each(function(){opt[this.name] = this.className.match(/numeric/) ? parseInt(this.value) : this.value;});
	var htmlspecialchars ={ '&':'&amp;', '<':'&lt;', '>':'&gt;', '"':'&quot;'}
		$.each(htmlspecialchars, function(k,v){
			opt.prev_text = opt.prev_text.replace(k,v);
			opt.next_text = opt.next_text.replace(k,v);
		}
	);
	return opt;
}

function carg_campos_busqpers(){
    var valor = $("#cbnivelbusqpers").val();
    var html = "";
    var control = "";
    
    $('#div_rsbusqpers').html('');
    
    if(valor == '0'){
    	// por codido de persona
    	control = "#txtcidper";
    	html = '<input type="text" id="txtcidper" name="txtcidper" value="" maxlength="10" size="30" '+ 
    		'onkeypress="if(event.keyCode < 48 || event.keyCode > 57){event.returnValue = false;} if(event.keyCode == 13){Buscar();}" >';
    }else if(valor == '1'){
    	// por nombres
    	control = "#txtapepat";
    	html = '<table><tr><td align="left">Apellido Paterno:</td><td><input name="txtapepat" type="text" id="txtapepat" size="30" maxlength="20" onkeypress="if(event.keyCode == 13){Buscar();}" /></td></tr>'+
			'<tr><td align="left">Apellido Materno:</td><td><input name="txtapemat" type="text" id="txtapemat" size="30" maxlength="20" onkeypress="if(event.keyCode == 13){Buscar();}" /></td></tr>'+
			'<tr><td align="left">Nombres:</td><td><input name="txtnombres" type="text" id="txtnombres" size="30" maxlength="20" onkeypress="if(event.keyCode == 13){Buscar();}" /></td></tr>'+
			'<tr><td colspan="2" align="left"></td></tr></table>';
    }else if(valor == '2'){
    	// por dni
    	control = "#txtdni";
    	html = '<input name="txtdni" type="text" id="txtdni" size="30" maxlength="8" '+
    		'onkeypress="if(event.keyCode < 48 || event.keyCode > 57){event.returnValue = false;} if(event.keyCode == 13){Buscar();}" />';
    }
    
    $('#div_nivelbusqpers').html(html);
    $(control).focus();
}

function BuscarPerxCID(){
	var o = {cidpers: $("#txtcidper").val()
	 	, nombre: ""
	 	, apepat: ""
	 	, apemat: ""
		, dni: $("#txtdni").val()
		, urlredirect: $("#urlredirect").val()
		, fech: $("#fech").val()};
	
	if(o.cidpers.length < 1){
		openDialogWarning('Debe ingresar el Codigo de la persona para la busqueda');
		return 0;
	}else{
		o.cidpers = '0000000000' + o.cidpers;
		o.cidpers = o.cidpers.substring(o.cidpers.length - 10, o.cidpers.length);
	   $("#txtcidper").val(o.cidpers);
	   return o;
	}
}

function BuscarPerxDNI(){
	var o = {cidpers: ""
	 	, nombre: ""
	 	, apepat: ""
	 	, apemat: ""
		, dni: $("#txtdni").val()
		, urlredirect: $("#urlredirect").val()
		, fech: $("#fech").val()};
	
	if(o.dni.length < 8 ){ 
		openDialogWarning('Debe ingresar un DNI valido de la persona para la busqueda');
		return 0;
	}
	
	return o;
}

function BuscarPerxApeNom(){
	var o = {cidpers: "0000000000"
	 	, nombre: $("#txtnombres").val().toUpperCase()
	 	, apepat: $("#txtapepat").val().toUpperCase()
	 	, apemat: $("#txtapemat").val().toUpperCase()
		, dni: ""
		, urlredirect: $("#urlredirect").val()
		, fech: $("#fech").val()};
 
	if(o.nombre.length < 1 & o.apepat.length < 1 & o.apemat.length < 1 ){ //si el largo de nombre es menor a 2 caracteres
		openDialogWarning('Debe ingresar el Nombre o Apellidos de la persona para la busqueda');
		return 0;
	}else{
		if(o.nombre.length < 3 & o.apepat.length < 1 & o.apemat.length < 1 ){ // si el largo de nombre es menor a 2 caracteres
			openDialogWarning('Debe ingresar por lo menos 3 letras en el nombre');
			return 0;
		}else if(o.nombre.length < 1 & o.apepat.length < 3 & o.apemat.length < 1 ){ //si el largo de nombre es menor a 2 caracteres
			openDialogWarning('Debe ingresar por lo menos 3 letras en el apellido paterno');
			return 0;
		}else if(o.nombre.length < 1 & o.apepat.length < 1 & o.apemat.length < 3 ){ //si el largo de nombre es menor a 2 caracteres
			openDialogWarning('Debe ingresar por lo menos 3 letras en el apellido materno');
			return 0;
		}
	}

	return o;
}

function Buscar(){
	var parameters = {};
    var index = $("#cbnivelbusqpers").val();
    
    if(index == '0'){
    	// por codido de persona
    	parameters = BuscarPerxCID();
    }else if(index == '1'){
    	// por nombres
    	parameters = BuscarPerxApeNom();
    }else if(index == '2'){
    	// por dni
    	parameters = BuscarPerxDNI();
    }
	
    if(parameters == 0) {
    	return;
    }
    
	var _post = $.post(path + "busqpers/busquedapersona/", parameters);
	
	_post.success(function(requestData){
		$("#div_rsbusqpers").html(requestData);
	});
	
	_post.error(function(requestData, errMessage, errNumber){
		if(errNumber == '') {
			openDialogError("No se puede determinar el error.");
		} else {
			openDialogError(errNumber +': ' + errMessage);
		}
	});
}