postError = function(requestData, errMessage, errNumber){
    if(errNumber == '') {
        openDialogError("No se puede determinar el error.");
    } else {
        openDialogError(errNumber +': ' + errMessage);
    }
};

function procesarConsultaSubProceso(source, parameters, fnc) {
    _post = $.post(path + "jqgrid/" + source, parameters);	
    _post.success(fnc);
    _post.error(postError);
}

function procesarSeleccion(idPanel, idx, _options, parameters) {
    procesarConsultaSubProceso('seleccionar', parameters, function(requestData){
        $("#" + idPanel).html(requestData);
        actualizarGrid(idx, _options);
    });
}

function procesarProcedimiento(idPanel, idx, _options, parameters, bindkeys) {
    procesarConsultaSubProceso('registrar', parameters, function(requestData){
        $("#" + idPanel).html(requestData);
        actualizarGrid(idx, _options, bindkeys);
    });
}

function actualizarGrid(id, _options, bindkeys){
    _url = path + "jqgrid/paginar?name=" + id;
    options = $.extend({
        url: _url,
        datatype: "json",
        rowNum: 30,
        rownumbers: true,
        recordtext: "{0} - {1} de {2} elementos",
        emptyrecords: 'No hay resultados',
        pgtext: 'Pag: {0} de {1}',
        pager: "#p" + id,
        viewrecords: true,
        loadonce: true,
        shrinkToFit: false,
        loadError : function(xhr,st,err) {
            alert("Type: "+st+"; Response: "+ xhr.status + " " + xhr.statusText);
            alert(err);
        }
    }, _options);
    idx = "#" + id;
    $(idx).jqGrid(options);
    $(idx).jqGrid('setFrozenColumns');
    if(bindkeys != undefined || bindkeys != null) {
        $(idx).jqGrid('bindKeys', bindkeys);
    }
}

function inicializarGrid(id, _options){
    options = $.extend({
        scroll: 1,
        data: [],
        datatype: "local",
        rowNum: 30,
        rownumbers: true,
        recordtext: "{0} - {1} de {2} elementos",
        emptyrecords: 'No hay resultados',
        pgtext: 'Pag: {0} de {1}',
        pager: "#p" + id,
        viewrecords: true,
        shrinkToFit: false,
        loadonce: true
    }, _options);
    idx = "#" + id;
    $(idx).jqGrid(options);
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
		
        _post.error(postError);	
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
		
        _post.error(postError);	
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
		
        _post.error(postError);	
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
        selector = "select";
    }
    $(selector).combobox();
    $(selector).each(function(){
        var id = $(this).attr("id").replace('cbo', '#txt');        
        $(id).bind("focus", function(){
            $(this).toggleClass("ui-combobox-input-highlight");
        });
        $(id).bind("blur", function(){
            $(this).toggleClass("ui-combobox-input-highlight");
        }); 
    });
}

var userAgent = navigator.userAgent.toLowerCase();
$.browser = {
    version: (userAgent.match( /.+(?:rv|it|ra|ie|me)[\/: ]([\d.]+)/ ) || [])[1],
    chrome: /chrome/.test( userAgent ),
    safari: /webkit/.test( userAgent ) && !/chrome/.test( userAgent ),
    opera: /opera/.test( userAgent ),
    msie: /msie/.test( userAgent ) && !/opera/.test( userAgent ),
    mozilla: /mozilla/.test( userAgent ) && !/(compatible|webkit)/.test( userAgent )
};

(function($) {
    $.fn.getCheckboxValues = function(){
        var values = [];
        var i = 0;
        this.each(function (){
            values[i++] = $( this).val();
        });
        return values;
    }
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
// alert($.browser.msie);
});
