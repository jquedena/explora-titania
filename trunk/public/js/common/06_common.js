function callAjaxPostJSON(url, parameters, fx){
    $.post(path+"index.php/"+url
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

function openDialogConfirm(msg) {
    var contenido = '<p><span class=\"ui-icon ui-icon-circle-check\" style=\"float:left; margin:0 7px 7px 0;\"></span>';
    contenido = contenido + msg;
    contenido = contenido + '</p>';
    $('#jqDialogCofirmacion').html(contenido);
    $('#jqDialogCofirmacion').dialog('open');
}

function openDialogConfirm2(msg) {
    var contenido = '<p><span class=\"ui-icon ui-icon-circle-check\" style=\"float:left; margin:0 7px 7px 0;\"></span>';
    contenido = contenido + msg;
    contenido = contenido + '</p>';
    $('#jqDialogCofirmacion2').html(contenido);
    $('#jqDialogCofirmacion2').dialog('open');
}

function openDialogPregunta(msg) {
    var contenido = '<p><span class=\"ui-icon ui-icon-circle-check\" style=\"float:left; margin:0 7px 7px 0;\"></span>';
    contenido = contenido + msg;
    contenido = contenido + '</p>';
    $('#jqDialogPregunta').html(contenido);
    $('#jqDialogPregunta').dialog('open');
}

function openDialogError(msg) {
    var contenido = '<p><span class=\"ui-icon ui-icon-alert\" style=\"float:left; margin:0 7px 7px 0;\"></span>';
    contenido = contenido + msg;
    contenido = contenido + '</p>';
    $('#jqDialogError').html(contenido);
    $('#jqDialogError').dialog('open');
}

function openDialogWarning(msg) {
    var contenido = '<p><span class=\"ui-icon ui-icon-info\" style=\"float:left; margin:0 7px 7px 0;\"></span>';
    contenido = contenido + msg;
    contenido = contenido + '</p>';
    $('#jqDialogWarning').html(contenido);
    $('#jqDialogWarning').dialog('open');
}

function openDialogInfo(msg) {
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