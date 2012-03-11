function callAjaxPostJSON(url, parameters, fx){
    $.post(path+url
        , parameters
        , fx
        , "json");
}

function print(){
    $("#divPrincipal").jqprint();
}

function closeDialog(id) {   
    $('#'+id).dialog('close');
}

function openDialogConfirm1(contenido, width, height) {
    $('#jqConfirmacion1').html(contenido);
    if(width != undefined) $('#jqDialogConfirmacion1').dialog('option', 'width', width);
    if(height != undefined) $('#jqDialogConfirmacion1').dialog('option', 'height', height);
    $('#jqDialogConfirmacion1').dialog('open');
}

function openDialogConfirm2(contenido) {
    $('#jqConfirmacion2').html(contenido);
    if(width != undefined) $('#jqDialogConfirmacion2').dialog('option', 'width', width);
    if(height != undefined) $('#jqDialogConfirmacion2').dialog('option', 'height', height);
    $('#jqDialogConfirmacion2').dialog('open');
}

function openDialogError(contenido) {
    var contenido = '<p><span class=\"ui-icon ui-icon-alert\" style=\"float:left; margin:0 7px 7px 0;\"></span>';
    contenido = contenido + msg;
    contenido = contenido + '</p>';
    $('#jqDialogError').html(contenido);
    $('#jqDialogError').dialog('open');
}

function openDialogWarning(contenido) {
    var contenido = '<p><span class=\"ui-icon ui-icon-info\" style=\"float:left; margin:0 7px 7px 0;\"></span>';
    contenido = contenido + msg;
    contenido = contenido + '</p>';
    $('#jqDialogWarning').html(contenido);
    $('#jqDialogWarning').dialog('open');
}

function openDialogInfo(contenido) {
    var contenido = '<p><span class=\"ui-icon ui-icon-comment\" style=\"float:left; margin:0 7px 7px 0;\"></span>';
    contenido = contenido + msg;
    contenido = contenido + '</p>';
    $('#jqDialogInfo').html(contenido);
    $('#jqDialogInfo').dialog('open');
}

$(function(){
   $("#itemMenu1").menu({
       content: $("#itemMenu1").next().html(),
       showSpeed: 1,
       flyOut: true
   });
});