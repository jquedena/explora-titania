ejecutarMetodoAdicional_Anio = true;
ejecutarMetodoAdicional_Mes = true;

function inicializarEstadoRubro(){
	if ($('#idMes').val() == '-1'){
		$('#idRubro').val('-1');
		$('#idRubro').attr('disabled', 'disabled');
	} else {
		$('#idRubro').removeAttr('disabled');
	}
}

function inicializarEstadoMes(){
	if ($('#idAnio').val() == '-1'){
		$('#idMes').val('-1');
		$('#idMes').attr('disabled', 'disabled');
	} else {
		$('#idMes').removeAttr('disabled');
	}
}

function onChangeAnio(){
	inicializarEstadoMes();
	onChangeMes();
}

function onChangeMes(){
	inicializarEstadoRubro();
	limpiarTablas();
	$("#idRubro").val('-1');
	cargarEpigrafeRubro();
}

var asignado='';

function listarEpigrafeMIS(){
	if($('#idMes').val()=='-1'){
		openDialogInfo("Seleccione el mes y rubro primero.");
		return;
	}
	if($('#idRubro').val()=='-1'){
		openDialogInfo("Seleccione el rubro primero.");
		return;
	}
	
	asignado = '';
	$("#tbEpigrafeAsociado tbody tr td.MIS").each(function(){
		if(asignado.length > 0 ) asignado += '|';
		asignado += $(this).find("input").eq(0).val();
	});
	
	$('#tbEpigrafe_MIS > tbody').empty();
	$('#jqDialogRubro').dialog('open');
	$('#idTipoFiltro').val('N');
	$('#idFiltro').val('');
	$('#idFiltro').focus();
}

function buscarRubroEpigrafe(){
	if($('#idFiltro').val().length < 3) {
		openDialogInfo("Debe ingresar por lo menos 3 caracteres para realizar la busqueda.");
		return;
	}
	
	var jqxhr = $.post("buscarEpigrafeMIS.do",{
		'anio' : $('#idAnio').val(),
		'mes' : $('#idMes').val(),
		'idRubro' : $('#idRubro').val(),
		'codEpigrafe' : $('#idTipoFiltro').val() == 'C' ? $('#idFiltro').val() : '', 
		'nomEpigrafe' : $('#idTipoFiltro').val() == 'N' ? $('#idFiltro').val() : ''
	});
	
	jqxhr.success( function(data){
		var newRow = '', mensaje = '';
		
		if (data.resultado != undefined && data.resultado == 'error'){
			openDialogError(data.mensaje);
		} else {
			if (data.listaObjetos == undefined) {
				document.getElementById('currentForm').action = 'logout.do';
				document.getElementById('currentForm').submit();
			} else {
				crearFilaMIS("tbEpigrafe_MIS", data.listaObjetos[0].epigrafesMIS);
			}
		}
	});
}

function asignarRubroEpigrafe(){
	$("#tbEpigrafe_MIS tbody tr.seleccionado").each(function(){
	
		$newRow = $("<tr>");
		$newRow.append("<td style='text-align:center;width:5px;'>" + $(this).find("td").eq(0).html() + "</td>");
		$newRow.append("<td class='MIS'>" + $(this).find("td").eq(2).html() + "</td>");
		html = $newRow.find("div").html();
		if(html.indexOf($(this).find("td").eq(1).text()) == -1) {
			html = html + ' - ' + $(this).find("td").eq(1).text();
		}		
		$newRow.find("div").html(html);
		
		$("#tbEpigrafeAsociado").append($newRow);
	});

	reprocesarEstilos("tbEpigrafeAsociado");
	$('#jqDialogRubro').dialog('close');
}

function seleccionaFila(o, i, event){
	o.parent().parent('tr').toggleClass('seleccionado');
	if (jQuery.browser.msie) {
		event.cancelBubble = true;
	} else {
		event.stopPropagation();
	}
}

function crearFilaMIS(tabla, listaObjeto){
	var i = 0;
	var className = "odd";
	$('#'+tabla+' > tbody').empty();
	
	if(listaObjeto == undefined || listaObjeto.length == 0){
		return;
	}
	
	$.each(listaObjeto, function(i, objeto){
		if(asignado.indexOf(objeto.codigo) == -1){
			className = (i % 2 == 0) ? "odd" : "even";
			
			newRow = "<tr class='" + className + ' ' + objeto.tipo + "'><td style='text-align:center;width:5px;'>";
			newRow += "<img src='/PIZELE_WEB/images/arrow_white.gif'></td>";
			newRow += "<td><div  onclick='seleccionaFila($(this), " + (objeto.tipo=='S' ? "0" : (objeto.tipo=='M' ? "1" : "2")) + ", event);'>" + objeto.codigo + "</div></td>";
			newRow += "<td><input type='checkbox' name='chk_" + tabla + "_codigo' style='display:none;' value='" + objeto.codigo + "_" + objeto.tipo + "_" + (tabla == 'tbEpigrafeAsociado' ? objeto.id : "-1" ) + "'/>";
			newRow += "<div  onclick='seleccionaFila($(this), " + (objeto.tipo=='S' ? "0" : (objeto.tipo=='M' ? "1" : "2")) + ", event);'>" + objeto.nombre + "</div></td></tr>";
			
			newRow = newRow.replace('seleccionado', '');
			
			$('#'+tabla).append(newRow);
			
			i++;
		}
	});
}

function crearFila(tabla, listaObjeto){
	var i = 0;
	var className = "odd";
	$('#'+tabla + ' > tbody').empty();
	
	if(listaObjeto == undefined || listaObjeto.length == 0){
		return;
	}
	
	$.each(listaObjeto, function(i, objeto){
		className = (i % 2 == 0) ? "odd" : "even";
		
		newRow = "<tr class='" + className + ' ' + objeto.tipo + "'><td style='text-align:center;width:5px;'>";
		newRow += "<img src='/PIZELE_WEB/images/arrow_white.gif'></td><td>";
		newRow += "<input type='checkbox' name='chk_" + tabla + "_codigo' style='display:none;' value='" + objeto.codigo + "_" + objeto.tipo + "_" + (tabla == 'tbEpigrafeAsociado' ? objeto.id : "-1" ) + "'/>";
		newRow += "<div  onclick='seleccionaFila($(this), " + (objeto.tipo=='S' ? "0" : (objeto.tipo=='M' ? "1" : "2")) + ", event);'>" + objeto.nombre + (tabla == 'tbEpigrafeAsociado' ? " - " + objeto.codigo : "" ) + "</div></td></tr>";
		
		newRow = newRow.replace('seleccionado', '');
		
		$('#'+tabla).append(newRow);
		
		i++;
	});
}

function limpiarTablas(){
	$('#tbEpigrafeSDO > tbody').empty();
	$('#tbEpigrafeAsociado > tbody').empty();
}

function cargarEpigrafeRubro(){
	var _idrubro = $('#idRubro').val();
	var jqxhr = $.post("cargarEpigrafeRubro.do",{
		'anio' : $('#idAnio').val(),
		'mes' : $('#idMes').val(),
		'idRubro' : $('#idRubro').val()
	});

	jqxhr.success( function(data){
		var newRow = '', mensaje = '';
		
		if (data.resultado != undefined && data.resultado == 'error'){
			openDialogError(data.mensaje);
		} else {
			if (data.listaObjetos == undefined) {
				document.getElementById('currentForm').action = 'logout.do';
				document.getElementById('currentForm').submit();
			} else {
				_html = "";
				_html = "<option value='-1'>---Seleccione---</option>";
				$.each(data.listaObjetos[0].rubrosFijos, function(i, item){
					_html += "<option value='" + item.id + "'>" + item.descrubro + "</option>";
					i++;
				});
				$("#idRubro").html(_html);
				$("#idRubro").val(_idrubro);
				
				crearFila("tbEpigrafeSDO", data.listaObjetos[0].epigrafesSDO);
				crearFila("tbEpigrafeAsociado", data.listaObjetos[0].epigrafesAsignados);
			}
		}
		
		reprocesarEstilos("tbEpigrafeSDO");
		reprocesarEstilos("tbEpigrafeAsociado");
	});
}

function moverEpigrafeSDO(origen, destino, todo, i){
	$("#" + origen +" tbody tr" + (todo == true ? "" : ".seleccionado")).each(function(){
		
		if($(this).find("input").val().indexOf('-1') != 0){
			if($(this).find("input").val().indexOf('_S') > -1 || destino=='tbEpigrafeAsociado'){
				$tr = $("<tr class='" + $(this).attr('class').replace('seleccionado', '') + "'>").append($(this).html());
				html = $tr.find("div").html();
				cod_epigrafe = $(this).find("input").val().substring(0, 7);
				if(html.indexOf(cod_epigrafe) == -1){
					$tr.find("div").html(html + ' - ' + cod_epigrafe);
				}
				$("#" + destino).append($tr);
			}
			$(this).remove();
		}		
	});
	
	reprocesarEstilos(origen);
	reprocesarEstilos(destino);
}

function executeActionForm_guardarConfRubroEpigrafe(){
	var esValido = false;
	
	if($('#idRubro').val()!='-1'){
		esValido = true;
	}
	
	if(esValido){
		openDialogConfirm('&#191;Desea guardar los datos ingresados?');
	}
}

function okButton(){
	closeDialogConfirm();
	
	var rubroEpigrafe = '';
	
	$("#tbEpigrafeAsociado").find("input:checkbox").each(function(){
		if(rubroEpigrafe.length > 0) rubroEpigrafe += '|';
		rubroEpigrafe += $(this).val();
	});
		
	var jqxhr = $.post("guardarRelacionRubroEpigrafe.do",{
		'idRubro': $('#idRubro').val(),
		'rubroEpigrafe': rubroEpigrafe,
		'anio': $('#idAnio').val(),
		'mes': $('#idMes').val()
	});
	
	jqxhr.success(function(data){ 
		if(data.resultado != undefined && data.resultado == "ERROR") {
			openDialogError(data.mensaje);
		}
		else if(data.resultado != undefined && data.resultado == "EXITO") {
			cargarEpigrafeRubro();
			openDialogInfo(data.mensaje);
		} else {
			document.getElementById('currentForm').action = 'logout.do';
			document.getElementById('currentForm').submit();
		}
	});
}

function exportarExcelRubroEpigrafe(){
	var result = "";
	var temp = "";
	 
	result += $('#idAnio option:selected').text() + "|";
	result += $('#idMes option:selected').text() + "|";
	result += $('#idRubro option:selected').text() + "|";
	
	$("#tbEpigrafeSDO tbody tr").each(function(){
		temp = $(this).find('td').eq(1).text();
	
		if(result.length>0) result += '|'; 
			result += temp;
	});
 
	result += '|~';
 
	$("#tbEpigrafeAsociado tbody tr").each(function(){
		temp = $(this).find('td').eq(1).text();
	
		if(result.length>0) result += '|'; 
		result += temp;
	});

	$("#exportar").val(result);
	
	document.getElementById('currentForm').action = 'exportarExcelRubroEpigrafe.do';
	document.getElementById('currentForm').submit();
}

function iniciarCopia() {
	if($("#tbEpigrafeAsociado  tbody  tr").length>0) {
		openDialogInfo("El rubro ya cuenta con una configuraci\u00F3n, no se puede realizar el proceso de copia.");
		return;
	}
	
	if($('#idMes').val()=='-1'){
		openDialogInfo("Seleccione el mes y rubro primero.");
		return;
	}
	if($('#idRubro').val()=='-1'){
		openDialogInfo("Seleccione el rubro primero.");
		return;
	}
	
	$("#idAnioDestino").val($("#idAnio").val());
	
	$("#idMesDestino").val("-1");	
	seleccionaAnioDestino();
	$("#copiarConf").css({"visibility":"visible"});
	$('#jqDialogCopiarConfiguracion').dialog('open');
}

function seleccionaAnioDestino(){
	if ($('#idAnioDestino').val() == '-1'){
		$('#idMesDestino').val('-1');
		$('#idMesDestino').attr('disabled', 'disabled');
	} else {
		$('#idMesDestino').removeAttr('disabled');
	}
}

function seleccionaMesDestino(){
	var jqxhr = $.post("cargarEpigrafeRubro.do",{
		'anio' : $('#idAnioDestino').val(),
		'mes' : $('#idMesDestino').val(),
		'idRubro' : $('#idRubro').val()
	});

	jqxhr.success(function(data){
		if (data.resultado != undefined && data.resultado == 'error'){
			openDialogError(data.mensaje);
		} else {
			if (data.listaObjetos == undefined) {
				document.getElementById('currentForm').action = 'logout.do';
				document.getElementById('currentForm').submit();
			} else {
				asignados = data.listaObjetos[0].epigrafesAsignados;
				if(asignados.length==0){
					openDialogInfo("El mes seleccionado como matriz no tiene una configuración establecida.");
					$("#copiarConf").css({"visibility":"hidden"});
					return;
				} else {
					$("#copiarConf").css({"visibility":"visible"});
				}
			}
		}
	});
}

function copiarConfiguracion(){
	if($('#idAnioDestino').val()=='-1'){
		openDialogInfo("Seleccione el año y el mes de destino primero.");
		return;
	}
	if($('#idMesDestino').val()=='-1'){
		openDialogInfo("Seleccione el mes de destino primero.");
		return;
	}
 
	var jqxhr = $.post("copiarRelacionRubroEpigrafe.do",{
		'anio' : $('#idAnio').val(),
		'mes' : $('#idMes').val(),
		'idRubro' : $('#idRubro').val(),
		'anioDestino' : $('#idAnioDestino').val(),
		'mesDestino' : $('#idMesDestino').val()
	});

	jqxhr.success(function(data){ 
		if(data.resultado != undefined && data.resultado == "ERROR") {
			openDialogError(data.mensaje);
		}
		else if(data.resultado != undefined && data.resultado == "EXITO") {
			$('#jqDialogCopiarConfiguracion').dialog('close');
			cargarEpigrafeRubro();
			openDialogInfo(data.mensaje);
		} else {
			document.getElementById('currentForm').action = 'logout.do';
			document.getElementById('currentForm').submit();
		}
	});
}