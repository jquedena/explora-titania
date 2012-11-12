function PagosAnularRecibo(){
	
	var nrorec = $("#txtnrorecibo").val();
	var error = "";
	$("#div_rptaerroranular").html('');
	
	if(nrorec.length < 12 ){
		error = "Ingrese numero de recibo valido.<br>";
	}
	
	if(error.length>1){
		openDialogError(error, 400, 150);
		//$("#div_rptaerroranular").html(error);
	}else{
		//var answer = confirm("Seguro de eliminar el recibo nro. "+nrorec+"?");
		openDialogConfirm1("Seguro de eliminar el recibo nro. "+nrorec+"?", 400, 150);
	}
		
}

okConfirmacion1=function(){
	closeDialog('jqDialogConfirmacion1');
	var nrorec = $("#txtnrorecibo").val();
	//var obs    = $("#txtobs").val();
	var error = "";
	
	var oEditor = CKEDITOR.instances['txtobs']
    var obs = oEditor.getData();
    obs=escape(obs);
	$.ajax({
	 	dataType: "html",
	 	type: "POST",
	 	url:  jQuery.scriptPath + "index.php/pagoanularrecibo/anular/",
	 	data: "nrorec="+nrorec+
	 		  "&obs="+obs,
		success: function(requestData){
			$("#div_rptaanular").html(requestData);
		},		
		error: function(requestData, strError, strTipoError){
			$("#div_rptaanular").html("Error " + strTipoError +': ' + strError);
		}
	});
}
cancelConfirmacion1=function(){
	closeDialog('jqDialogConfirmacion1');
}

$(function(){
	var config = {
	        skin:'v2'
	        , toolbar: [
	            ['Bold','Italic','Underline','-','NumberedList','BulletedList','-','Outdent','Indent','-','Undo','Redo','-','HorizontalRule','-','Blockquote','CreateDiv','-','JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock','-','TextColor','BGColor'],
	            ['UIColor']
	        ]
	    };
	
	    var hEd = CKEDITOR.instances['txtobs'];
	    if (hEd) {
	        CKEDITOR.remove(hEd);
	    }
CKEDITOR.replace('txtobs', config);
});