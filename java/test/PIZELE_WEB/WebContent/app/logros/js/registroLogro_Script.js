ejecutarMetodoAdicional_Territorio = true;
ejecutarMetodoAdicional_Oficina = true;

function onChangeTerritorio(){
	seleccioneChangeTextOficina();
}

function onChangeOficina(){
	if($('#idDia').val() != ""){
		if($('#idOficinaFiltro').val()!="-1"){
			cargarLogros();
		}
	}
}

function grabarLogros(){
	var result = "";
	var row = "";
	
	$("#bodyRubro2 tbody tr").each(function(){
		if(result.length>0) result += '|';
		row = "";
		$(this).find('td').each(function(){
			if(row.length>0) row += '%';
			
			$input = $(this).find("input");
			if($input.length == 0){
				row += $(this).text() + "_" + $(this).attr("name");
			} else {
				value = $input.val();
				if(value.length == 0) {
					value = '0';
				}
				id = $input.attr("id_item");
				id = (id == undefined || id == null) ? "" : id;
				row += value + "_" + $input.attr("name") + "_" + id;
			}
		});
		result += row;
	});

	var jqxhr = $.post("grabarLogroRubro.do",{
		'lista' : result,
		'dia' : $('#idDia').val(),
		'idTerritorio' : $('#idTerritorioFiltro').val(),
		'idOficina' : $('#idOficinaFiltro').val()
	});
	
	jqxhr.success(function(data){ 
		if(data.resultado != undefined && data.resultado == "ERROR") {
			openDialogError(data.mensaje);
		}
		else if(data.resultado != undefined && data.resultado == "EXITO") {
			cargarLogros();
			openDialogInfo(data.mensaje);
		} else {
			document.getElementById('currentForm').action = 'logout.do';
			document.getElementById('currentForm').submit();
		}
	});
}

function executeActionForm_guardarDecisor(){
	var esValido = true;
	
	if($('#idTerritorioFiltro').val() == "-1") {
		openDialogInfo("Seleccione el territorio y oficina primero.");
		esValido = false;
	} else if($('#idOficinaFiltro').val() == "-1") {
		openDialogInfo("Seleccione la oficina primero.");
		esValido = false;
	}
	
	if(esValido){
		openDialogConfirm('&#191;Desea guardar los datos ingresados?');
	}
	
}

function okButton(){
	closeDialogConfirm();
	grabarLogros();
}

function crearColumnasFijas(gestores){
	html  = "<table class='dataTable' style='width:100%; height:25px; border:1px solid #fff;' cellpadding='0' cellspacing='1'>";
	html += "<thead><tr><th style='width:5px;'>&nbsp;</th><th>Gestor</th></tr></thead>";
	html += "</table>";
	$("#headRubro1").html(html);
	
	html  = "<table class='dataTable' style='width:100%; border:1px solid #fff;' cellpadding='0' cellspacing='1'><tbody>";
	$.each(gestores, function(i, gestor){
		perfil = (gestor.perfil.length == 0) ? '' : " - " + gestor.perfil;
		html += "<tr class='" + gestor.codusu + "'><td style='width:5px; height: 25px;'><img src='/PIZELE_WEB/images/arrow_white.gif'></td>"
		html += "<td style='height: 25px;'>" + gestor.nombreCompleto + perfil + "</td></tr>";
	});
	html += "</tbody></table>";
	
	h = ((gestores.length * 27) + 5) + "px";
	$("#bodyRubro1").html(html);
	$("#bodyRubro1").css({"height": h});
}

function crearColumnasMoviles(gestores, rubros, activo){
	html  = "<table align='left' class='dataTable' style='width:" + (75 * rubros.length) + "px; height:25px; border:1px solid #fff;' cellpadding='0' cellspacing='1'><thead><tr>";
	$.each(rubros, function(i, rubro){
		html += "<th style='width: 75px;'><a title='" + rubro.descrubro + "' >";
		if(rubro.descrubro.length > 9){
			html += rubro.descrubro.substring(0, 5) + "...";
		} else {
			html += rubro.descrubro;
		}
		html += "</a></th>";
	});
	html += "</tr></thead></table>";
	
	$("#headRubro2").html(html);
	
	html  = "<table align='left' class='dataTable' style='width:" + (75 * rubros.length) + "px; border:1px solid #fff;' cellpadding='0' cellspacing='1'><tbody>";
	$.each(gestores, function(i, gestor){
		perfil = (gestor.perfilID.length == 0) ? '' : " - " + gestor.perfilID;
		html += "<tr class='" + gestor.codigoRegistro + "'>";
		html += "<td style='display:none;'>";
		html += "<input type='text' style='width: 50px;' id_item='' name='" + gestor.codigoRegistro + "' id='" + gestor.codigoRegistro + "' value='" + gestor.nombre 
			+ "%" + gestor.apellidoPaterno 
			+ "%" + gestor.apellidoMaterno + ' ' + gestor.oficinaHija
			+ "%" + perfil + " '/>";
		html += "</td>";
		
		$.each(rubros, function(i, rubro){
			id = gestor.codigoRegistro + "_" + rubro.id;
			html += "<td style='width: 75px; height: 25px; text-align: center;'>";
			if(activo == 0){
				html += "<input type='text' style='width: 55px;' name='" + id + "' id='" + id + "' value='' />";
			}else{
				html += "<span style='width: 50px;' name='" + id + "' id='" + id + "'>&nbsp;</span>";
			}
			html += "</td>";
		});	
		html += "</tr>";
	});
	html += "</tbody></table>";
	
	$("#bodyRubro2").html(html);
	
	$("#bodyRubro2").delegate("input", "keypress", function(event){
		nro = "0123456789";
		key = navigator.appName.indexOf("Netscape") != -1 ? event.which : event.keyCode;
		chr = String.fromCharCode(key);
		
		if( (key == 8) || (key == 0) || nro.indexOf(chr) > -1 ) {
			return true;
		} else {
			return false;
		}
	});
	
	h = ((gestores.length * 27) + 40) + "px";
	$("#bodyRubro2").css({"height": h});
}

function cargandoLogros(logros, activo){
	$.each(logros, function(i, logro){
		id = "#" + logro.cod_gestor + "_" + logro.id_rubro;
		if(activo == 0) {
			$(id).val(logro.logro);
		}else{
			$(id).html(logro.logro);
		}
		$(id).attr("id_item", logro.id);
	});
}

function cargarLogros(){
	
	var jqxhr = $.post("cargarLogroRubro.do",{
		'dia' : $('#idDia').val(),
		'idTerritorio' : $('#idTerritorioFiltro').val(),
		'idOficina' : $('#idOficinaFiltro').val()
	});
	
	jqxhr.success( function(data){
		if (data.resultado != undefined && data.resultado == 'error'){
			openDialogError(data.mensaje);
		} else {
			if (data.listaObjetos == undefined) {
				document.getElementById('currentForm').action = 'logout.do';
				document.getElementById('currentForm').submit();
			} else {
				
				if(data.listaObjetos[0].gestores == null) {
					$("#divRubroLogro").css({"display": "none"}); 
					openDialogError("No se ha podido recuperar la lista de gestores.");
					return;
				}
				if(data.listaObjetos[0].gestores.length == 0){
					$("#divRubroLogro").css({"display": "none"}); 
					openDialogInfo("No hay gestores asignados a esta oficina.");
					return; 
				}
				
				crearColumnasFijas(data.listaObjetos[0].gestores);
				crearColumnasMoviles(data.listaObjetos[0].gestores, data.listaObjetos[0].rubros, data.listaObjetos[0].activo);
				cargandoLogros(data.listaObjetos[0].logro, data.listaObjetos[0].activo);
				$("#divRubroLogro").css({"display": "inline"});
				
				reprocesarEstilos('bodyRubro1');
				reprocesarEstilos('bodyRubro2');
				gridSingleSelect2('bodyRubro1', 'bodyRubro2');
				gridSingleSelect2('bodyRubro2', 'bodyRubro1');
			}
		}
	});
}

function exportarExcelRubroLogro(){
	var result = "";
	var row = "";
	 
	// Head
	result += ($('#idTerritorioFiltro option:selected').text() == '' ? $('#descTerritorioFiltro').val() : $('#idTerritorioFiltro option:selected').text()) + "|";
	result += ($('#idOficinaFiltro option:selected').text() == '' ? $('#descOficinaFiltro').val() : $('#idOficinaFiltro option:selected').text()) + "|";
	result += $('#idDia').val();
	$("#xlsHead").val(result);
	
	// Body
	result = "";
	$("#headRubro1 thead tr").each(function(){
		if($.trim(result).length>0) result += '%';
		row = "";
		$(this).find('th').each(function(){
			if(row.length>0) row += '%';
			if($.trim($(this).text()).length>0) {
				row += $(this).text();
			}
		});
		result += row;
	});
	
	$("#headRubro2 thead tr").each(function(){
		if(result.length>0) result += '%';
		row = "";
		$(this).find('th').each(function(){
			if(row.length>0) row += '%';
			row += $(this).find("a").attr("title");
		});
		result += row;
	});
	
	$("#bodyRubro2 tbody tr").each(function(){
		
		if(result.length>0) result += '|';
		row = "";
		$(this).find('td').each(function(){
			if(row.length>0) row += '%';
			
			if($(this).find("input").length == 0){
				row += $(this).text();
			} else {
				row += $(this).find("input").val();
			}
		});
		 
		result += row;
	});
	
	$("#xlsBody").val(result);
	
	document.getElementById('currentForm').action = 'exportarExcelRubroLogro.do';
	document.getElementById('currentForm').submit();
}

function gridSingleSelect2(idGrid, idGrid2){
	idGrid = '#' +  idGrid + ' tr';
	idGrid2 = '#' +  idGrid2 + ' tr';
	
	$(idGrid).click(function(event){
		$(idGrid).each(function(){  
			if($(this).hasClass('seleccionado')){
				$(this).toggleClass('seleccionado');
				$(idGrid2 + "." + $(this).attr("class").substring(0, 7)).toggleClass('seleccionado');
			}
		});
		
		$(this).toggleClass('seleccionado');
		$(idGrid2 + "." + $(this).attr("class").substring(0, 7)).toggleClass('seleccionado');
		
		if (event.target.type !== 'radio') {
			$(':radio', this).attr('checked', function() {
				return !this.checked;
			});
		}
	});
}