_ajaxPOST = null;
function ajaxPOST(url, parameters){
	_post = $.post(path + url, parameters);
	
	_post.success(function(requestData){
		_ajaxPOST = requestData;
	});
	
	_post.error(function(requestData, errMessagke, errNumber){
		if(errNumber == '') {
			openDialogError("No se puede determinar el error.");
		} else {
			openDialogError(errNumber +': ' + errMessage);
		}
	});	
	
	return _ajaxPOST;
}

function configurarGridPost(idPanel, idControl, _colNames, _colModel, _caption, _width, _height, parameters){
	_post = $.post(path + "jqgrid/array", parameters);
	
	_post.success(function(requestData){
		_html += requestData;
		_html += "<script type='text/javascript'>";
		_html += "configurarGrid('" + idControl + "', data_" + idControl + ", _colNames, _colModel, '" + _caption + "', " + _width + ", " + _height + ");";
		_html += "</script>";
		$("#"+idPanel).html(requestData);
		console.log();
		console.log();
		console.log();
		
	});
	
	_post.error(function(requestData, errMessagke, errNumber){
		if(errNumber == '') {
			openDialogError("No se puede determinar el error.");
		} else {
			openDialogError(errNumber +': ' + errMessage);
		}
	});
}

function configurarGrid(id, _data, _colNames, _colModel, _caption, _width, _height){
	console.log(_data);
	console.log(_colNames);
	console.log(_colModel);
	$("#" + id).jqGrid({
		scroll: 1,
		data: _data,
		datatype: "local",
		height: _height,
		width: _width,
		rowNum: 30,
		rownumbers: true,
		// rowList: [10,20,30],
		// loadtext: 'Cargando datos...',
		// recordtext: "{0} - {1} de {2} elementos",
     	// emptyrecords: 'No hay resultados',
     	// pgtext: 'Pág: {0} de {1}', //Paging input control text format. 
   	colNames: _colNames,
   	colModel: _colModel,
   	pager: "#p" + id,
   	viewrecords: true,
   	loadonce: true,
   	caption: "&nbsp;&nbsp;&nbsp;" + _caption
	});
}

function deshabilitarComponente(id, sw){
	id = "#" + id;
	
    if (sw == true || sw == 1) {
        $(id).removeAttr('disabled');
    } else if (sw == false || sw != 1) {
        $(id).attr('disabled', 'disabled');
    }
}

function print(){
    $("#divPrincipal").jqprint();
}

function closeDialog(id) {   
    $('#'+id).dialog('close');
}

function openDialogData1(url, data, width, height, title) {
	var _post = $.post(path + url, data);
	
	if(url != undefined) {
		_post.success(function(requestData){
			$("#jqDialog1").html(requestData);
			
		    if(width != undefined) $('#jqDialog1').dialog('option', 'width', width);
		    if(height != undefined) $('#jqDialog1').dialog('option', 'height', height);
		    if(title != undefined) $('#jqDialog1').dialog('option', 'title', title);
		    $('#jqDialog1').dialog('open');
		});
		
		_post.error(function(requestData, errMessage, errNumber){
			if(errNumber == '') {
				openDialogError("No se puede determinar el error.");
			} else {
				openDialogError(errNumber +': ' + errMessage);
			}
		});	
	}
}

function openDialog1(url, width, height, title) {
	var _post = $.post(path + url);
	
	if(url != undefined) {
		_post.success(function(requestData){
			$("#jqDialog1").html(requestData);
			
		    if(width != undefined) $('#jqDialog1').dialog('option', 'width', width);
		    if(height != undefined) $('#jqDialog1').dialog('option', 'height', height);
		    if(title != undefined) $('#jqDialog1').dialog('option', 'title', title);
		    $('#jqDialog1').dialog('open');
		});
		
		_post.error(function(requestData, errMessage, errNumber){
			if(errNumber == '') {
				openDialogError("No se puede determinar el error.");
			} else {
				openDialogError(errNumber +': ' + errMessage);
			}
		});	
	}
}

function openDialog2(url, width, height, title) {	
	var _post = $.post(path + url);
	
	if(url != undefined) {
		_post.success(function(requestData){
			$("#jqDialog2").html(requestData);
			
		    if(width != undefined) $('#jqDialog2').dialog('option', 'width', width);
		    if(height != undefined) $('#jqDialog2').dialog('option', 'height', height);
		    if(title != undefined) $('#jqDialog2').dialog('option', 'title', title);
		    $('#jqDialog2').dialog('open');
		});
		
		_post.error(function(requestData, errMessage, errNumber){
			if(errNumber == '') {
				openDialogError("No se puede determinar el error.");
			} else {
				openDialogError(errNumber +': ' + errMessage);
			}
		});	
	}
}

function openDialogConfirm1(contenido, width, height) {
    $('#jqConfirmacion1').html(contenido);
    if(width != undefined) $('#jqDialogConfirmacion1').dialog('option', 'width', width);
    if(height != undefined) $('#jqDialogConfirmacion1').dialog('option', 'height', height);
    $('#jqDialogConfirmacion1').dialog('open');
}

function openDialogConfirm2(contenido, width, height) {
    $('#jqConfirmacion2').html(contenido);
    if(width != undefined) $('#jqDialogConfirmacion2').dialog('option', 'width', width);
    if(height != undefined) $('#jqDialogConfirmacion2').dialog('option', 'height', height);
    $('#jqDialogConfirmacion2').dialog('open');
}

function openDialogError(contenido, width, height) {
    $('#jqError').html(contenido);
    if(width != undefined) $('#jqDialogError').dialog('option', 'width', width);
    if(height != undefined) $('#jqDialogError').dialog('option', 'height', height);
    $('#jqDialogError').dialog('open');
}

function openDialogWarning(contenido, width, height) {
    $('#jqWarning').html(contenido);
    if(width != undefined) $('#jqDialogWarning').dialog('option', 'width', width);
    if(height != undefined) $('#jqDialogWarning').dialog('option', 'height', height);
    $('#jqDialogWarning').dialog('open');
}

function openDialogInfo(contenido, width, height) {
    $('#jqInfo').html(contenido);
    if(width != undefined) $('#jqDialogInfo').dialog('option', 'width', width);
    if(height != undefined) $('#jqDialogInfo').dialog('option', 'height', height);
    $('#jqDialogInfo').dialog('open');
}

function mouseHover(idTable) {
	idTable = '#' +  idTable + " tbody";
	
	$(idTable).delegate('tr', 'hover', function() {
		$(this).toggleClass("ui-state-highlight").next().stop(true, true);
	});
}

function DoNavrow(theUrl) {
	window.open(theUrl, '_self');
}

$(function(){
   $("#itemMenu1").menu({
       content: $("#itemMenu1").next().html(),
       showSpeed: 1,
       flyOut: true
   });
   $("#itemMenu2").menu({
       content: $("#itemMenu2").next().html(),
       showSpeed: 1,
       flyOut: true
   });
   $("#itemMenu3").menu({
       content: $("#itemMenu3").next().html(),
       showSpeed: 1,
       flyOut: true
   });
});
