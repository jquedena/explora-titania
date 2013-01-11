postError = function(requestData, errMessage, errNumber){
    if(errNumber == '') {
        openDialogError("No se puede determinar el error.");
    } else {
        openDialogError(errNumber +': ' + errMessage);
    }
};

function procesarConsultaSubProceso(source, parameters, fnc, dataType) {
	if(dataType != null || dataType != undefined) {
		_post = $.post(path + "jqgrid/" + source, parameters, function(request){}, dataType);
	}
	else {
		_post = $.post(path + "jqgrid/" + source, parameters);
	}
    _post.success(fnc);
    _post.error(postError);
}

function procesarSeleccion(idPanel, idx, _options, parameters) {
    procesarConsultaSubProceso('seleccionar', parameters, function(requestData){
        $("#" + idPanel).html(requestData);
        actualizarGrid(idx, _options);
    });
}

function procesarProcedimiento(idPanel, idx, _options, parameters, bindkeys, navGrid) {
    procesarConsultaSubProceso('registrar', parameters, function(requestData){
        $("#" + idPanel).html(requestData);
        actualizarGrid(idx, _options, bindkeys, navGrid);
    });
}

function procesarJSON(idPanel, idx, _options, bindkeys, navGrid) {
	html  = "<table id=" + idx + "></table>";
	html += "<div id=p" + idx + "></div>";
	html += "<input type='hidden' id='c" + idx + "' name='c" + idx + "' value='' />";                                  
                                    
	$("#" + idPanel).html(html);
    reloadJQGrid(idx, _options, bindkeys, navGrid);
}

function procesarProcedimientoJSON(idPanel, idx, _options, parameters, bindkeys, navGrid) {
	html  = "<table id=" + idx + "></table>";
	html += "<div id=p" + idx + "></div>";
	html += "<input type='hidden' id='c" + idx + "' name='c" + idx + "' value='' />";                                  
                                    
	$("#" + idPanel).html(html);
    procesarConsultaSubProceso('registrar', parameters, function(requestData){
    	$("#c" + idx).val(requestData.length);
    	_options = $.extend(_options, {
    		datatype: "local",
    		data: requestData
    	});
        reloadJQGrid(idx, _options, bindkeys, navGrid);
    });
}

function reloadJQGrid(id, _options, bindkeys, navGrid){
    options = $.extend({
        // scroll: 1,
    	// loadComplete: function (data){},
    	height: 250,
        data: [],
        datatype: "local",
        rowNum: 10,
        rownumbers: true,
        recordtext: "{0} - {1} de {2} elementos",
        emptyrecords: 'No hay resultados',
        pgtext: 'Pag: {0} de {1}',
        pager: "#p" + id,
        viewrecords: true,
        shrinkToFit: false,
        loadonce: true,
        scrollOffset: 1,		
		subGrid: false,
		footerrow: false,
		sortable: false
    }, _options);
    idx = "#" + id;
    $(idx).jqGrid(options);
    $(idx).jqGrid('setFrozenColumns');
    if(bindkeys != undefined || bindkeys != null) {
        $(idx).jqGrid('bindKeys', bindkeys);
    }
    if(navGrid != undefined || navGrid != null) {
        navGrid();
    };
}

function actualizarGrid(id, _options, bindkeys, navGrid){
	_url = path + "jqgrid/paginar?name=" + id;
    options = $.extend({
        url: _url,
        datatype: "json",
    }, _options);
	reloadJQGrid(id, options, bindkeys, navGrid);
}

function inicializarGrid(id, _options, bindkeys, navGrid){
	reloadJQGrid(id, _options, bindkeys, navGrid);
}

function contenidocomboContenedorjqGrid(selector,idsigma){
	var optionsjq = {};
   	optionsjq.value ="9999999999:Seleccionar";
   	optionsjq.defaultValue="9999999999";
   	
    _post = $.post(path + "util/combocontenedor", {"idsigma": idsigma}, function(request){
	    	$.each(request, function(i , columns){
	            var value = columns[0];
	            var label = columns[1];		
	            optionsjq.value +=';' + value + ':' + label;
	        });	
    	}, 'json');
    _post.error(postError);
    return optionsjq;
}

function contenidocomboContenedor(selectId, idsigma){
    _post = $.post(path + "util/combocontenedor", {"idsigma": idsigma}, function(request){
        $(selectId).html(contenidocombo(request));
    }, 'json');
    _post.error(postError); 
}

function contenidocombo(data){
    var options = '<option value="9999999999">SELECCIONAR</option>';
    $.each(data, function(i , columns){
        var value = columns[0];
        var label = columns[1];		
        options +='<option value="' + value + '">' + label + '</option>';
    });	
    return options;
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

openDialogData = function(url, data, width, height, title, id, fnc) {
	var _post;
    if(url != undefined) {
    	_post = $.post(path + url, data);
        _post.success(function(requestData){
            $(id).html(requestData);
			
            if(fnc != undefined && fnc != null && fnc != false) {
            	fnc();
            }
            
            if(width != undefined) $(id).dialog('option', 'width', width);
            if(height != undefined) $(id).dialog('option', 'height', height);
            if(title != undefined) $(id).dialog('option', 'title', title);
            $(id).dialog('open');
        });
		
        _post.error(postError);	
    }
};

function openDialogDataFunction1(url, data, width, height, title, fnc) {
	openDialogData(url, data, width, height, title, '#jqDialog1', fnc);
}

function openDialogData1(url, data, width, height, title) {
	openDialogData(url, data, width, height, title, '#jqDialog1', null);
}

function openDialogData2(url, data, width, height, title) {
	openDialogData(url, data, width, height, title, '#jqDialog2', null);
}

function openDialog1(url, width, height, title) {
	openDialogData(url, {}, width, height, title, '#jqDialog1', null);
}

function openDialog2(url, width, height, title) {	
	openDialogData(url, {}, width, height, title, '#jqDialog2', null);
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

function openDialogInfo(contenido, width, height, buttons, close) {
    $('#jqInfo').html(contenido);
    if(width != undefined) $('#jqDialogInfo').dialog('option', 'width', width);
    if(height != undefined) $('#jqDialogInfo').dialog('option', 'height', height);
    if(buttons != undefined) $('#jqDialogInfo').dialog('option', 'buttons', buttons);
    if(close != undefined) $('#jqDialogInfo').dialog('option', 'close', close);
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

function themeTextBox(selector) {
    if(selector == undefined || selector == null) {
        selector = ".ui-text";
    }
    $(selector).on("blur", function(){
        $(this).toggleClass("ui-text-highlight");
    });
    $(selector).on("focus", function(){
        $(this).toggleClass("ui-text-highlight");
    });
}
function themeComboBox(selector) {
    if(selector == undefined || selector == null) {
        //selector = "select";
    	selector = 'select:not(".notcombobox")';
    }
    
    _selector = $(selector);
    _selector.combobox();
    _selector.each(function(){
        var id = $(this).attr("id").replace('cbo', '#txt');        
        $(id).bind("focus", function(){
            $(this).toggleClass("ui-combobox-input-highlight");
        });
        $(id).bind("blur", function(){
            $(this).toggleClass("ui-combobox-input-highlight");
        }); 
    });
}

/*
var userAgent = navigator.userAgent.toLowerCase();
$.browser = {
    version: (userAgent.match( /.+(?:rv|it|ra|ie|me)[\/: ]([\d.]+)/ ) || [])[1],
    chrome: /chrome/.test( userAgent ),
    safari: /webkit/.test( userAgent ) && !/chrome/.test( userAgent ),
    opera: /opera/.test( userAgent ),
    msie: /msie/.test( userAgent ) && !/opera/.test( userAgent ),
    mozilla: /mozilla/.test( userAgent ) && !/(compatible|webkit)/.test( userAgent )
};
*/

(function($) {
    $.fn.getCheckboxValues = function(){
        var values = [];
        var i = 0;
        this.each(function (){
            values[i++] = $( this).val();
        });
        return values;
    };
})(jQuery);

$(function(){
    $("#itemMenu1").menuBar({
        content: $("#itemMenu1").next().html(),
        showSpeed: 1,
        flyOut: true
    });
    $("#itemMenu2").menuBar({
        content: $("#itemMenu2").next().html(),
        showSpeed: 1,
        flyOut: true
    });
    $("#itemMenu3").menuBar({
        content: $("#itemMenu3").next().html(),
        showSpeed: 1,
        flyOut: true
    });
    themeTextBox();
    themeComboBox();
	
	var brw = new Browser();
	console.log('fullName: ' + brw.fullName);
	console.log('name: ' + brw.name);
	console.log('fullVersion: ' + brw.fullVersion);
	console.log('version: ' + brw.version);
	console.log('platform: ' + brw.platform);
	console.log('mobile: ' + brw.mobile);
	console.log('resolution: ' + brw.width + 'x' + brw.height);
	
	console.log('availWidth: ' + screen.availWidth);
	console.log('width: ' + screen.width);
	console.log('availHeight: ' + screen.availHeight);
	console.log('height: ' + screen.height);
	
	window.moveTo(screen.width - screen.availWidth, screen.height - screen.availHeight);
	window.resizeTo(screen.availWidth + screen.availWidth - screen.width, screen.availHeight + screen.availHeight - screen.height);
	
	console.log("#west.height: " + $("#west").css("height"));
});
