ejecutarMetodoAdicional_Territorio = true;
ejecutarMetodoAdicional_Oficina = true;
ejecutarMetodoAdicional_Anio = true;
ejecutarMetodoAdicional_Mes = true;

function fn_CheckingAusente(control, valor) {
	control.checked = valor;
	control.value = $.trim(control.value)=='' ? '0' : $.trim(control.value);
}

function cargarListaRubrosAsignShort() {
	var jqxhr = $.post("cargarListaRubrosAsignShort.do", {
		'asignacionRubro.codterr': $('#idTerritorioFiltro').val(),
		'asignacionRubro.codofic': $('#idOficinaFiltro').val(),
		'asignacionRubro.anio': $('#idAnio').val(),
		'asignacionRubro.mes': $('#idMes').val()
	});
	
	jqxhr.success(function(data) {
		if(data.resultado != undefined && data.resultado == "ERROR") {
			openDialogError(data.mensaje);
		}
		else if(data.listaObjetos != undefined) {
			$('#idAsigRubro').empty();
			$('#idAsigRubro').append($('<option>', { value : '-1' }).text('----- Seleccione ------'));

			$.each(data.listaObjetos, function(i,objeto)
			{
				$('#idAsigRubro').append($('<option>', { value : objeto.id }).text(objeto.descrubro));  
			});
			
			$("#tbMetasMensuales > tbody").empty();
			$("#divMetas").css({"display" : "none"});
			
			/*
			 * fn_CalcularDistribMes();
			 * fn_ActivarQuintaSemana();
			 */
		}
		else {
			document.getElementById('currentForm').action = 'logout.do';
			document.getElementById('currentForm').submit();
		}
	});
}


function cargarListaCompletaListasMensuales() {
	if(validar()) {
		var jqxhr = $.post("cargarListaCompletaListasMensuales.do", 
			{
			'metaMensual.cod_terr': $('#idTerritorioFiltro').val(),
			'metaMensual.cod_ofi': $('#idOficinaFiltro').val(),
			'metaMensual.anio': $('#idAnio').val(),
			'metaMensual.mes': $('#idMes').val(),
			'metaMensual.id_rubro': $('#idAsigRubro').val()
			});
		
		jqxhr.success(function(data) 
			{ 
			
				if(data.resultado != undefined && data.resultado == "ERROR")
				{
					openDialogError(data.mensaje);
				}
				else if(data.listaObjetos != undefined)
				{
					regargarListaCompletaListasMensuales(data);
				}
				else
				{
					document.getElementById('currentForm').action = 'logout.do';
					document.getElementById('currentForm').submit();
				}
			}
		);	
	}
}

function validar() {
	var esValido = true;
	
	if($('#idTerritorioFiltro').val() == "-1") {
		openDialogInfo("Seleccione el territorio y oficina primero.");
		esValido = false;
	} else if($('#idOficinaFiltro').val() == "-1") {
		openDialogInfo("Seleccione la oficina primero.");
		esValido = false;
	} else if($('#idAsigRubro').val() == "-1") {
		openDialogInfo("Seleccione el rubro.");
		esValido = false;
	} else if($('#idAnio').val() == "-1") {
		openDialogInfo("Seleccione el a&ntilde;o.");
		esValido = false;
	} else if($('#idMes').val() == "-1") {
		openDialogInfo("Seleccione el mes.");
		esValido = false;
	}
	
	return esValido;
}

function executeActionForm_guardarRegistroMeta() {
	var esValido = validar();
	
	if(esValido) {
		openDialogConfirm('&#191;Desea guardar los datos ingresados?');
	}
}

function okButton() {
	
	closeDialogConfirm();
	
	var metasMensualesValues = 0; 
	var semana1Values = 0;
	var semana2Values = 0;
	var semana3Values = 0;
	var semana4Values = 0;
	var semana5Values = 0;
	var chkSemana1Values = 0;
	var chkSemana2Values = 0;
	var chkSemana3Values = 0;
	var chkSemana4Values = 0;
	var chkSemana5Values = 0;
	
	var index = 0;
	$('[name=txtMetaSemana1]').each(function() {
		if(index == 0)
			semana1Values = $(this).val();
		else
			semana1Values = semana1Values + '|' + $(this).val();
		index++;
	});
	
	index=0;
	$('[name=txtMetaSemana2]').each(function() {
		if(index == 0)
			semana2Values = $(this).val();
		else
			semana2Values = semana2Values + '|' + $(this).val();
		index++;
	});
	
	index=0;
	$('[name=txtMetaSemana3]').each(function() {
		if(index == 0)
			semana3Values = $(this).val();
		else
			semana3Values = semana3Values + '|' + $(this).val();
		index++;
    });
	
	index=0;
	$('[name=txtMetaSemana4]').each(function() {
		if(index == 0)
			semana4Values = $(this).val();
		else
			semana4Values = semana4Values + '|' + $(this).val();
		index++;
	});
	
	index=0;
	$('[name=txtMetaSemana5]').each(function() {
		if(index == 0)
			semana5Values = $(this).val();
		else
			semana5Values = semana5Values + '|' + $(this).val();
		index++;
	});
	
	index = 0;
	var checkValue = 'N';
	$('[name=chkAusenteMetaSemana1]').each(function() {
		if ($(this).attr("checked"))
			checkValue = 'S';
		else
			checkValue = 'N';
		
		if(index == 0)
			chkSemana1Values = checkValue;
		else
			chkSemana1Values = chkSemana1Values + '|' + checkValue;
		index++;
    });
	
	index=0;
	$('[name=chkAusenteMetaSemana2]').each(function() {
		if ($(this).attr("checked"))
			checkValue = 'S';
		else
			checkValue = 'N';
		
		if(index == 0)
			chkSemana2Values = checkValue;
		else
			chkSemana2Values = chkSemana2Values + '|' + checkValue;
		index++;
    });
	
	index=0;
	$('[name=chkAusenteMetaSemana3]').each(function() {
		if ($(this).attr("checked"))
			checkValue = 'S';
		else
			checkValue = 'N';
		
		if(index == 0)
			chkSemana3Values = checkValue;
		else
			chkSemana3Values = chkSemana3Values + '|' + checkValue;
		index++;
    });
	
	index=0;
	$('[name=chkAusenteMetaSemana4]').each(function() {
		if ($(this).attr("checked"))
			checkValue = 'S';
		else
			checkValue = 'N';
		
		if(index == 0)
			chkSemana4Values = checkValue;
		else
			chkSemana4Values = chkSemana4Values + '|' + checkValue;
		index++;
    });
	
	index=0;
	$('[name=chkAusenteMetaSemana5]').each(function() {
		if ($(this).attr("checked"))
			checkValue = 'S';
		else
			checkValue = 'N';
		
		if(index == 0)
			chkSemana5Values = checkValue;
		else
			chkSemana5Values = chkSemana5Values + '|' + checkValue;
		index++;
    });
	
	
	
	index=0;
	$('[name=metaMensual]').each(function() 
    {
		if(index == 0)
			metasMensualesValues = $(this).val();
		else
			metasMensualesValues = metasMensualesValues + '|' + $(this).val();
		index++;
    });
	
	var jqxhr = $.post("guardarRegistroMeta.do", 
		   		   {
					'metaMensual.cod_terr': $('#idTerritorioFiltro').val(),
					'metaMensual.cod_ofi': $('#idOficinaFiltro').val(),
					'metaMensual.anio': $('#idAnio').val(),
					'metaMensual.mes': $('#idMes').val(),
					'metaMensual.id_rubro': $('#idAsigRubro').val(),
					'semana1Values': semana1Values,
					'semana2Values': semana2Values,
					'semana3Values': semana3Values,
					'semana4Values': semana4Values,
					'semana5Values': semana5Values,
					'chkSemana1Values': chkSemana1Values,
					'chkSemana2Values': chkSemana2Values,
					'chkSemana3Values': chkSemana3Values,
					'chkSemana4Values': chkSemana4Values,
					'chkSemana5Values': chkSemana5Values,
					'metasMensualesValues': metasMensualesValues
		   		   });
	
    jqxhr.success(function(data) 
    	{ 
    		if(data.resultado != undefined && data.resultado == "ERROR")
    		{
    			openDialogError(data.mensaje);
    		}		    		
    		else if(data.resultado != undefined && data.resultado == "EXITO")
    		{
    			openDialogInfo(data.mensaje);
    			regargarListaCompletaListasMensuales(data);
    		}
    		else
    		{
    			document.getElementById('currentForm').action = 'logout.do';
				document.getElementById('currentForm').submit();
    		}
    	}
    );
    
}

function calcularMetasSemanales()
{
	if(validar()) {

		var metasMensualesValues = 0; 
		var semana1Values = 0;
		var semana2Values = 0;
		var semana3Values = 0;
		var semana4Values = 0;
		var semana5Values = 0;
		var chkSemana1Values = 0;
		var chkSemana2Values = 0;
		var chkSemana3Values = 0;
		var chkSemana4Values = 0;
		var chkSemana5Values = 0;
		
		var index = 0;
		$('[name=txtMetaSemana1]').each(function() {
			if(index == 0)
				semana1Values = $(this).val();
			else
				semana1Values = semana1Values + '|' + $(this).val();
			index++;
		});
		
		index=0;
		$('[name=txtMetaSemana2]').each(function() {
			if(index == 0)
				semana2Values = $(this).val();
			else
				semana2Values = semana2Values + '|' + $(this).val();
			index++;
		});
		
		index=0;
		$('[name=txtMetaSemana3]').each(function() {
			if(index == 0)
				semana3Values = $(this).val();
			else
				semana3Values = semana3Values + '|' + $(this).val();
			index++;
		});
		
		index=0;
		$('[name=txtMetaSemana4]').each(function() {
			if(index == 0)
				semana4Values = $(this).val();
			else
				semana4Values = semana4Values + '|' + $(this).val();
			index++;
		});
		
		index=0;
		$('[name=txtMetaSemana5]').each(function() {
			if(index == 0)
				semana5Values = $(this).val();
			else
				semana5Values = semana5Values + '|' + $(this).val();
			index++;
		});
		
		index = 0;
		var checkValue = 'N';
		$('[name=chkAusenteMetaSemana1]').each(function() {
			if ($(this).attr("checked"))
				checkValue = 'S';
			else
				checkValue = 'N';
			
			if(index == 0)
				chkSemana1Values = checkValue;
			else
				chkSemana1Values = chkSemana1Values + '|' + checkValue;
			index++;
		});
		
		index=0;
		$('[name=chkAusenteMetaSemana2]').each(function() {
			if ($(this).attr("checked"))
				checkValue = 'S';
			else
				checkValue = 'N';
			
			if(index == 0)
				chkSemana2Values = checkValue;
			else
				chkSemana2Values = chkSemana2Values + '|' + checkValue;
			index++;
		});
		
		index=0;
		$('[name=chkAusenteMetaSemana3]').each(function() {
			if ($(this).attr("checked"))
				checkValue = 'S';
			else
				checkValue = 'N';
			
			if(index == 0)
				chkSemana3Values = checkValue;
			else
				chkSemana3Values = chkSemana3Values + '|' + checkValue;
			index++;
		});
		
		index=0;
		$('[name=chkAusenteMetaSemana4]').each(function() {
			if ($(this).attr("checked"))
				checkValue = 'S';
			else
				checkValue = 'N';
			
			if(index == 0)
				chkSemana4Values = checkValue;
			else
				chkSemana4Values = chkSemana4Values + '|' + checkValue;
			index++;
		});
		
		index=0;
		$('[name=chkAusenteMetaSemana5]').each(function() {
			if ($(this).attr("checked"))
				checkValue = 'S';
			else
				checkValue = 'N';
			
			if(index == 0)
				chkSemana5Values = checkValue;
			else
				chkSemana5Values = chkSemana5Values + '|' + checkValue;
			index++;
		});
		
		index=0;
		$('[name=metaMensual]').each(function() {
			if(index == 0)
				metasMensualesValues = $(this).val();
			else
				metasMensualesValues = metasMensualesValues + '|' + $(this).val();
			index++;
	    });
		
		var jqxhr = $.post("calcularMetasSemanales.do", {
			'metaMensual.cod_terr': $('#idTerritorioFiltro').val(),
			'metaMensual.cod_ofi': $('#idOficinaFiltro').val(),
			'metaMensual.anio': $('#idAnio').val(),
			'metaMensual.mes': $('#idMes').val(),
			'metaMensual.id_rubro': $('#idAsigRubro').val(),
			'semana1Values': semana1Values,
			'semana2Values': semana2Values,
			'semana3Values': semana3Values,
			'semana4Values': semana4Values,
			'semana5Values': semana5Values,
			'chkSemana1Values': chkSemana1Values,
			'chkSemana2Values': chkSemana2Values,
			'chkSemana3Values': chkSemana3Values,
			'chkSemana4Values': chkSemana4Values,
			'chkSemana5Values': chkSemana5Values,
			'metasMensualesValues': metasMensualesValues
		});
		
		jqxhr.success(function(data) {
				if(data.resultado != undefined && data.resultado == "ERROR")
				{
					openDialogError(data.mensaje);
				}
				else if(data.resultado != undefined && data.resultado == "EXITO") {
					if (data.mensaje!="") openDialogInfo(data.mensaje);
					regargarListaCompletaListasMensuales(data);
				}
				else {
					document.getElementById('currentForm').action = 'logout.do';
					document.getElementById('currentForm').submit();
				}
			}
		);	
	}	
}

function regargarListaCompletaListasMensuales(data)
{
	$("#tbMetasMensuales").empty();
	
	var cabRow = "<tr>";
	cabRow = cabRow + "<th></th>";
	cabRow = cabRow + "<th>Nombre Gestor</th>";
	cabRow = cabRow + "<th id='thMetaSDO'>Meta Referencia SDO</th>";
	cabRow = cabRow + "<th>Meta Mensual</th>";
	cabRow = cabRow + "<th>Semana 1</th>";
	cabRow = cabRow + "<th>Semana 2</th>";
	cabRow = cabRow + "<th>Semana 3</th>";
	cabRow = cabRow + "<th>Semana 4</th>";
	cabRow = cabRow + "<th>Semana 5</th>";
	cabRow = cabRow + "</tr>";
	$("#tbMetasMensuales").append(cabRow);
	
	var flag_epigrafe_sdo='N';
	var id_rubro;
	
	$.each(data.listaObjetos, function(i,objeto)
	{  
		var newRow = '';
		var cssClase = (i%2 == 0 ? 'odd' : 'even');
		
		if (flag_epigrafe_sdo=='N')
			flag_epigrafe_sdo = objeto.flag_epigrafe_sdo;
		
		id_rubro = objeto.id_rubro;
		
		newRow = "<tr class='" + cssClase + "'>";
		newRow = newRow + "<td style='text-align:center;width:5px;'><input type='radio' name='rdoMetasMensuales' style='display:none;' value='" + objeto.id + "'/>";
		newRow = newRow + "<img src='/PIZELE_WEB/images/arrow_white.gif'/></td>";
		newRow = newRow + "<td style='width:275px;'>" + objeto.nom_gestor + ' ' + objeto.apell_pat_gestor + ' ' + objeto.apell_mat_gestor + ' - ' + objeto.perfil + "</td>";
		
		if ((objeto.id_rubro!=1 && objeto.id_rubro!=2) || flag_epigrafe_sdo=='S')
			newRow = newRow + "<td id='tdMetaSDO' class='metaSDO_TD' style='width:35px;'>" + objeto.meta_sdo + "</td>";
		
		newRow = newRow + "<td style='width:35px;'><input " + ( (permiso=='0' || objeto.id_rubro < 3) ? "disabled='disabled' " : "" ) + "type='text' size='5' maxlength='6' name='metaMensual' onchange='fn_OnlyZero(this);' onkeypress='return fn_validaTecla(\"entero\", this);' value='" + objeto.meta_mensual + "'/></td>";
		
		newRow = newRow + "<td style='width:85px;'><input type='text' size='4' maxlength='3' disabled='disabled' name='txtMetaSemana1' onchange='fn_OnlyZero(this);' onkeyup='if ($.trim(this.value)!=\"\" && eval($.trim(this.value))>0) document.getElementsByName(\"chkAusenteMetaSemana1\")[" + i + "].checked=false;' onkeypress='return fn_validaTecla(\"entero\", this);' value='" + (objeto.ausente1 == 'S' && objeto.semana1 == 0 && objeto.id_rubro < 3 ? "0" : objeto.semana1) + "'/>";
		newRow = newRow + "<input type='checkbox' style='display: none;' name='chkAusenteMetaSemana1' onclick='if (this.checked) document.getElementsByName(\"txtMetaSemana1\")[" + i + "].value=\"Ausente\";' value='" + objeto.ausente1 + "'/></td>";
		
		newRow = newRow + "<td style='width:85px;'><input type='text' size='4' maxlength='3' disabled='disabled' name='txtMetaSemana2' onchange='fn_OnlyZero(this);' onkeyup='if ($.trim(this.value)!=\"\" && eval($.trim(this.value))>0) document.getElementsByName(\"chkAusenteMetaSemana2\")[" + i + "].checked=false;' onkeypress='return fn_validaTecla(\"entero\", this);' value='" + (objeto.ausente2 == 'S' && objeto.semana2 == 0 && objeto.id_rubro < 3 ? "0" : objeto.semana2) + "'/>";
		newRow = newRow + "<input type='checkbox' style='display: none;' name='chkAusenteMetaSemana2' onclick='if (this.checked) document.getElementsByName(\"txtMetaSemana2\")[" + i + "].value=\"Ausente\";' value='" + objeto.ausente2 + "'/></td>";
		
		newRow = newRow + "<td style='width:85px;'><input type='text' size='4' maxlength='3' disabled='disabled' name='txtMetaSemana3' onchange='fn_OnlyZero(this);' onkeyup='if ($.trim(this.value)!=\"\" && eval($.trim(this.value))>0) document.getElementsByName(\"chkAusenteMetaSemana3\")[" + i + "].checked=false;' onkeypress='return fn_validaTecla(\"entero\", this);' value='" + (objeto.ausente3 == 'S' && objeto.semana3 == 0 && objeto.id_rubro < 3 ? "0" : objeto.semana3) + "'/>";
		newRow = newRow + "<input type='checkbox' style='display: none;' name='chkAusenteMetaSemana3' onclick='if (this.checked) document.getElementsByName(\"txtMetaSemana3\")[" + i + "].value=\"Ausente\";' value='" + objeto.ausente3 + "'/></td>";
		
		newRow = newRow + "<td style='width:85px;'><input type='text' size='4' maxlength='3' disabled='disabled' name='txtMetaSemana4' onchange='fn_OnlyZero(this);' onkeyup='if ($.trim(this.value)!=\"\" && eval($.trim(this.value))>0) document.getElementsByName(\"chkAusenteMetaSemana4\")[" + i + "].checked=false;' onkeypress='return fn_validaTecla(\"entero\", this);' value='" + (objeto.ausente4 == 'S' && objeto.semana4 == 0 && objeto.id_rubro < 3 ? "0" : objeto.semana4) + "'/>";
		newRow = newRow + "<input type='checkbox' style='display: none;' name='chkAusenteMetaSemana4' onclick='if (this.checked) document.getElementsByName(\"txtMetaSemana4\")[" + i + "].value=\"Ausente\";' value='" + objeto.ausente4 + "'/></td>";
		
		newRow = newRow + "<td style='width:85px;'><input type='text' size='4' maxlength='3' disabled='disabled' name='txtMetaSemana5' onchange='fn_OnlyZero(this);' onkeyup='if ($.trim(this.value)!=\"\" && eval($.trim(this.value))>0) document.getElementsByName(\"chkAusenteMetaSemana5\")[" + i + "].checked=false;' onkeypress='return fn_validaTecla(\"entero\", this);' value='" + (objeto.ausente5 == 'S' && objeto.semana5 == 0 && objeto.id_rubro < 3 ? "0" : objeto.semana5) + "'/>";
		newRow = newRow + "<input type='checkbox' style='display: none;' name='chkAusenteMetaSemana5' onclick='if (this.checked) document.getElementsByName(\"txtMetaSemana5\")[" + i + "].value=\"Ausente\";' value='" + objeto.ausente5 + "'/></td>";
		
		newRow = newRow + "</tr>";
		
		$("#tbMetasMensuales").append(newRow);
		
	});
	
	if (id_rubro==1 || id_rubro==2 || flag_epigrafe_sdo=='N') {
		document.getElementById('thMetaSDO').style.display = 'none';
		$(".metaSDO_TD").each(function(){
			$(this).css({"display": "none"});
		});
		
		if (id_rubro==1 || id_rubro==2) {
			var fields1 = document.getElementsByName('txtMetaSemana1');
			var fields2 = document.getElementsByName('txtMetaSemana2');
			var fields3 = document.getElementsByName('txtMetaSemana3');
			var fields4 = document.getElementsByName('txtMetaSemana4');
			var fields5 = document.getElementsByName('txtMetaSemana5');
			var chkFields1 = document.getElementsByName('chkAusenteMetaSemana1');
			var chkFields2 = document.getElementsByName('chkAusenteMetaSemana2');
			var chkFields3 = document.getElementsByName('chkAusenteMetaSemana3');
			var chkFields4 = document.getElementsByName('chkAusenteMetaSemana4');
			var chkFields5 = document.getElementsByName('chkAusenteMetaSemana5');
			
			for (var j=0; j<fields1.length; j++) {
				if(permiso == '1') {
					fields1[j].disabled = false;
					chkFields1[j].style.display = '';
				}
				
				if (chkFields1[j].value =='S')
					chkFields1[j].checked = true;
				else
					chkFields1[j].checked = false;
			}
			
			for (j=0; j<fields2.length; j++) {
				if(permiso == '1') {
					fields2[j].disabled = false;
					chkFields2[j].style.display = '';
				}
				
				if (chkFields2[j].value =='S')
					chkFields2[j].checked = true;
				else
					chkFields2[j].checked = false;
			}
			
			for (j=0; j<fields3.length; j++) {
				if(permiso == '1') {
					fields3[j].disabled = false;
					chkFields3[j].style.display = '';
				}
				
				if (chkFields3[j].value =='S')
					chkFields3[j].checked = true;
				else
					chkFields3[j].checked = false;
			}
			
			for (j=0; j<fields4.length; j++) {
				if(permiso == '1') {
					fields4[j].disabled = false;
					chkFields4[j].style.display = '';
				}
				
				if (chkFields4[j].value =='S')
					chkFields4[j].checked = true;
				else
					chkFields4[j].checked = false;
			}
			
			for (j=0; j<fields5.length; j++) {
				if(permiso == '1') {
					fields5[j].disabled = false;
					chkFields5[j].style.display = '';
				}
				
				if (chkFields5[j].value =='S')
					chkFields5[j].checked = true;
				else
					chkFields5[j].checked = false;
			}
		}
	}	
	gridSingleSelect('tbMetasMensuales');
	$("#divMetas").css({"display" : "block"});
}

function onChangeTerritorio() {
	seleccioneChangeTextOficina();
	cargarListaRubrosAsignShort();
}

function onChangeOficina() {
	cargarListaRubrosAsignShort();
}

function onChangeAnio() {
	cargarListaRubrosAsignShort();
}

function onChangeMes() {
	cargarListaRubrosAsignShort();
}

function exportarExcelRegistroMeta(){
	var result = "";
	var row = "";
	 
	// Head
	result += ($('#idTerritorioFiltro option:selected').text() == '' ? $('#descTerritorioFiltro').val() : $('#idTerritorioFiltro option:selected').text()) + "|";
	result += ($('#idOficinaFiltro option:selected').text() == '' ? $('#descOficinaFiltro').val() : $('#idOficinaFiltro option:selected').text()) + "|";
	result += $('#idAnio option:selected').text() + "|";
	result += $('#idMes option:selected').text() + "|";
	result += $('#idAsigRubro option:selected').text();
	$("#xlsHead").val(result);
	
	// Body
	result = "";
	row = "";
	$("#tbMetasMensuales tr th").each(function(){
		if($(this).css("display") != "none") {
			if(row.length>0) row += '%';
			row += $(this).text();
		}
	});
	result += row + "|";
	
	i = 0;
	$("#tbMetasMensuales tbody tr").each(function(){
		
		if(result.length > 0 && i != 0) result += '|';
		row = "";
		i = 0;
		$(this).find('td').each(function(){
			if($(this).css("display") != "none" && (i != 0 || $(this).text() == 'No se encontro nada para mostrar.')) {
				if(row.length>0) row += '%';
				
				if($(this).find("input").length == 0){
					row += $(this).text();
				} else {
					row += $(this).find("input").val();
				}
			}
			i++;
		});	
		 
		result += row;
	});
	$("#xlsBody").val(result);
	
	document.getElementById('currentFormXLS').action = 'exportarExcelRegistroMeta.do';
	document.getElementById('currentFormXLS').submit();
}

function iniciarCopia() {
	metaTotal = 0;
	$("input[name=metaMensual]").each(function(){
		metaTotal += $(this).val();
	});
	
	if(metaTotal>0) {
		openDialogInfo("El rubro ya cuenta con metas establecidas, no se puede realizar el proceso de copia.");
		return;
	}
	
	if($('#idMes').val()=='-1'){
		openDialogInfo("Seleccione el mes y rubro primero.");
		return;
	}
	if($('#idAsigRubro').val()=='0'){
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
	// Se usaria...
}

function copiarConfiguracion(){
	if($('#idAnioDestino').val()=='-1'){
		openDialogInfo("Seleccione el a\u00F1o y el mes de origen primero.");
		return;
	}
	if($('#idMesDestino').val()=='-1'){
		openDialogInfo("Seleccione el mes de origen primero.");
		return;
	}
 
	var jqxhr = $.post("copiarMetaMensual.do",{
		'metaMensual.cod_terr': $('#idTerritorioFiltro').val(),
		'metaMensual.cod_ofi': $('#idOficinaFiltro').val(),
		'metaMensual.anio': $('#idAnioDestino').val(),
		'metaMensual.mes': $('#idMesDestino').val(),
		'metaMensual.id_rubro': $('#idAsigRubro').val(),
		'anioDestino' : $('#idAnio').val(),
		'mesDestino' : $('#idMes').val()
	});

	jqxhr.success(function(data){ 
		if(data.resultado != undefined && data.resultado == "ERROR") {
			openDialogError(data.mensaje);
		}
		else if(data.resultado != undefined && data.resultado == "EXITO") {
			$('#jqDialogCopiarConfiguracion').dialog('close');
			cargarListaCompletaListasMensuales();
			openDialogInfo(data.mensaje);
		} else {
			document.getElementById('currentForm').action = 'logout.do';
			document.getElementById('currentForm').submit();
		}
	});
}