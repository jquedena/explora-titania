panelPersona = function(parameters) {
    _post = $.post(path + "panel/persona", parameters);
    _post.error(postError);
    _post.success(function(request){  	
        $("#layoutPanelInformativo").html(request);
    });
};

