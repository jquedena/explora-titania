panelPersona = function() {
    parameters = {};
    _post = $.post(path + "panel/", parameters);
    _post.error(postError);
    _post.success(function(request){
        $("#panelRegistro").html(request);
    });
}

