habilitarComponenteDetalle = function(disabled){
    $(".ui-text, .ui-combobox-input").attr("disabled", disabled);
    $(".ui-text, .ui-combobox-input").toggleClass("ui-text-disable");
    $(".ui-combobox a").button("option", "disabled", disabled);
    $("#dtpFechaAdquisicion, #dtpFechaTransferencia, #dptFechaResolucionInafecto").datepicker("option", "disabled", disabled);
   
    //$("#btnGrabarPredio").button("option", "disabled", disabled);
    
    if($("#cboCondicion").val() == "1000000145"){
        $("#btnVerCondominante").button("option", "disabled", disabled);
        $("#nporcen").attr("disabled", disabled);
        $("#nporcen").toggleClass("ui-text-disable");
    } else {
        if(!disabled) {
            $("#nporcen").attr("disabled", true);
            $("#nporcen").toggleClass("ui-text-disable"); 
        }
    }
    
    //$("#btnEditarPredio").button("option", "disabled", !disabled);
   
    $("#txtPeriodo").toggleClass("ui-text-disable");

    if(disabled) {
        $("#linkPeriodo").button("option", "disabled", false);
        $("#txtPeriodo").attr("disabled", false);
        
        /*var hEd = CKEDITOR.instances['txtObservacionInafectacion'];
        if (hEd) {
            CKEDITOR.remove(hEd);
        }*/
    } else {
        //CKEDITOR.replace('txtObservacionInafectacion', config);
    }
};

function habilitab(tipo ){
	  if (tipo==0){
		  $( "#tabsDetallePredio" ).tabs( "option", "disabled", [ 1,2,3,4,5 ] );  
	  }else{
		 //$( "#tabsDetallePredio" ).tabs( "option", "enable", [ 1,2,3,4,5 ] );	
		 $( "#tabsDetallePredio" ).tabs( "option", "disabled", false );
		 // $( "#tabsDetallePredio" ).tabs( "enable");
	  }
	  
}


guardar = function() {
	row = { 
			idsigma: $("#_dpredio").val(),
			mpredio: $("#_mpredio").val(),
			ctippre: $("#cboTipoPredioUrbano").val(),
			cclasif: $("#cboClasificacion option:selected").attr("data-idsigma"),
			ccondic: $("#cboCondicion").val(),        			
			cestado: $("#cboEstado").val(),
			cusogen: $("#cboUso").val(),       
			cusoesp: $("#cboUsoEspecifico").val(),
			nporcen: $("#nporcen").val(),     
			ntertot: $("#ntotter").val(),
			nporter: $("#nporter").val(),    
			nterren: $("#nareter").val(),
			ncomtot: $("#ntotcom").val(),      
			nporcom: $("#nporcom").val(),
			narecom: $("#narecom").val(),		
			nporafe: 0,      
			dfecadq: "",
			dfecdes: "",
			dafecta: "", 
			nfrente: $("#nfronti").val(),
			ncanper: $("#nnrohab").val() ,
			ctippar: $("#cboParque").val(),
			vobserv:"",
			nestado:'1',
			mhresum:$("#_mhresum").val() 
			 
	};

	_post = $.post(path + "registro/guardardetalle", row);
    _post.success(function(data){
    	//optionPiso = $.extend(optionPiso, {data: data.data});
    	//procesarJSON("panelPiso", "tblPiso", optionPiso, null, navPanelPiso);
	});
    _post.error(postError);	
};

cambioTipoPredio = function(event, ui) {
    if(ui.item) {
        bVisible = (ui.item.option.value == "1000000091");
        visibility = (bVisible? "hidden": "visible");
        display = (bVisible? "inline": "none");
        $("#panelTerreno").css({"visibility" : visibility});
        //$("#tabPredioRustico").css({"display" : display});
        
        // contenidocomboContenedor("#cboTipoPredioUrbano", (bVisible ? "1000000209": "1000000202"));
    } else {
        openDialogWarning("El valor ingresado no esta en la lista de elementos.", 380, 150);
    }
};

cambioTipoUso = function(event, ui) {
    if(ui.item) {
    } else {
        openDialogWarning("El valor ingresado no esta en la lista de elementos.", 380, 150);
    }
};

cambioCondicion = function(event, ui) {
    if(ui.item) {
        disable = !(ui.item.option.value == "1000000145");
        $("#btnVerCondominante").button("option", "disabled", disable);
        $("#nporcen").attr("disabled", disable);
        $("#nporcen").toggleClass("ui-text-disable");
    } else {
        openDialogWarning("El valor ingresado no esta en la lista de elementos.", 380, 150);
    }
};

var periodoSel = ''; 

cambioPeriodo = function(event, ui) {
	if(ui.item) {
		if(periodoSel != ui.item.option.value) {
	        parameters = {
	            "mperson": $("#lblCodigo").text(),
	            "vnombre": $("#lblNombre").text(),
	            "vdirecf": $("#lblDireccion").text(),
	            "mpredio": $("#_mpredio").val(),
	            "mhresum": $("#_mhresum").val(),
	            "cperiod": ui.item.option.value
	        };
	        _post = $.post(path + "registro/verpredio", parameters);
	        _post.error(postError);
	        _post.success(function(request){
	            $("#panelRegistro").html(request);
	        });
		}
        periodoSel = ui.item.option.value;
	} else {
		openDialogWarning("El valor ingresado no esta en la lista de elementos.", 380, 150);
	}
};

loadVerDetalle = function(){
    tabs = $("#tabsDetallePredio").tabs();

    $(".ui-text-numeric").numeric({
        decimal: '.',
        negative: false
    }, function() {
        openDialogWarning("Solo Numeros Positivos.", 150, 90);
        this.value = "";
        this.focus();
    });

    $("#nnrohab").numeric({
        decimal: false,
        negative: false
    }, function() {
        openDialogWarning("Solo Numeros Enteros Positivos.", 150, 90);
        this.value = "";
        this.focus();
    });

    themeTextBox("#panelRegistro .ui-text");
    themeComboBox("#panelRegistro select");
    habilitarComponenteDetalle(true);
    
    $("#txtTipoPredio").bind("autocompleteselect", cambioTipoPredio);
    $("#txtTipoPredio").bind("autocompletechange", cambioTipoPredio);

    $("#txtUso").bind("autocompleteselect", cambioTipoUso);
    $("#txtUso").bind("autocompletechange", cambioTipoUso);

    $("#txtCondicion").bind("autocompleteselect", cambioCondicion);
    $("#txtCondicion").bind("autocompletechange", cambioCondicion);

    $("#txtPeriodo").attr("maxlength", 4);
    $("#txtPeriodo").bind("autocompleteselect", cambioPeriodo);
    $("#txtPeriodo").bind("autocompletechange", cambioPeriodo);
    periodoSel = $("#txtPeriodo").val();
    
    $("#dtpFechaAdquisicion, #dtpFechaTransferencia, #dptFechaResolucionInafecto, #txt_inicioinafecto, #txt_fininafecto").datepicker({
        dateFormat: "dd/mm/yy",
        showOn: "button",
        buttonImage: pathImage + "calendar.gif",
        buttonImageOnly: true
    });

    $("#btnVerCondominante").button({
        text: false,
        icons: {primary:'ui-icon-search'},
        disabled: true
    }).bind("click", function(){
    	guardar();
    	
        openDialogData1("registro/condominio", {}, "725", "405", "Registro de Condomimantes");
    });

    $("#btnBuscarDireccion").button({
        text: false,
        icons: {primary:'ui-icon-search'}
    }).bind("click", function(){
        openDialogData1("registro/direccion", {}, "710", "180", "Ubicaci&oacute;n del Predio");
    });
    
     $("#btnCancelarDescrpPredio").hide(); 
    
    $("#btnGrabarPredio").button("option", "disabled", true);

    $("#btnEditarPredio").button({
        icons: {primary:'ui-icon-pencil'}
    }).bind('click', function(){
    	
    	$("#btnEditarPredio").hide();
    	
    	$("#btnCancelarDescrpPredio").show();
    	
    	//$("#btnEditarPredio").button("option", "disabled", false);
    		
        habilitarComponenteDetalle(false);
        
        $("#btnGrabarPredio").button("option", "disabled", false);
        
        //$( "#tabsDetallePredio" ).tabs( "option", "disabled", [ 1,2,3,4,5 ] );
        
        //$("#btnEditarPredio").html("Cancelar");
        
        habilitab(0);
        //$("#btnEditarPredio").text("Cancelar"); 
        //$('#btnEditarPredio').unbind("click").click(function(){
        	//$("#btnEditarPredio").text("Cancelar"); 
        	/*$("#btnEditarPredio").button({
                icons: {primary:'ui-icon-pencil'}
            }).bind('click', function(){
            	 
            	
            	  //habilitarComponenteDetalle(true);
            	   $("#btnGrabarPredio").button("option", "disabled", true);
            	   habilitab(0);
        	});*/
        	 // $("#btnGrabarPredio").button("option", "disabled", true);
        	 // $("#btnGrabarPredio").button("option", "disabled", false);
        //});
    });
    
 
    $("#btnCancelarDescrpPredio").button({
        icons: {primary:'ui-icon-pencil'}
    }).bind('click', function(){
    	$("#btnGrabarPredio").button("option", "disabled", true);
 	   habilitab(0);
 	   
    	$("#btnCancelarDescrpPredio").hide();
    	$("#btnEditarPredio").show();
    	
    	$("#btnGrabarPredio").button("option", "disabled", true);
    	
    	habilitarComponenteDetalle(true);
    	
    	habilitab(1);
    	
    });

    /*$("#btnEditarPredio").button({
        icons: {primary:'ui-icon-pencil'}
    }).bind('click', function(){
    	//$("#btnEditarPredio").text("Editar");
    	
    	  habilitarComponenteDetalle(true);
    	   $("#btnGrabarPredio").button("option", "disabled", true);
    	   habilitab(1);
	});*/
    
       

    $("#btnFinalizar").button({
    	icons: {primary:'ui-icon-stop'}
    }).bind('click', function(){
    	
    });
    
    $("#btnGrabarPredio").button({
        icons: {primary:'ui-icon-disk'},
        disabled: true
    }).bind('click', function(){
    	
    	$("#btnGrabarPredio").button("option", "disabled", true);
    	
    	habilitarComponenteDetalle(true);
    	
    	habilitab(1);
    	/*
    	parameters = {
    		mperson: $("#lblCodigo").text(),
    		mhresum: $("#_mhresum").val()
    	};
        openDialogData1("registro/declaracion", parameters, "700", "510", "Declaraci&oacute;n Jurada");
        */
    	

        
        guardar();
        
       // $('#btnEditarPredio').unbind("click").click(function(){
        	
        	 $("#btnEditarPredio").button({
        	        icons: {primary:'ui-icon-pencil'}
        	    }).bind('click', function(){
        	      	$("#btnEditarPredio").button("option", "disabled", false);
            		
                    habilitarComponenteDetalle(false);
                    
                    $("#btnGrabarPredio").button("option", "disabled", false);
                    
                    //$( "#tabsDetallePredio" ).tabs( "option", "disabled", [ 1,2,3,4,5 ] );
                    
                    habilitab(0);
        	    });
       
        	 $("#btnCancelarPredio").hide();	
       // });
        
    });

    $("#btnCancelarPredio").button({
        icons: {primary:'ui-icon-arrowreturnthick-1-w'}
    }).bind('click', function(){
        location.href = path + "registro";
    });

    $("#btnValorPredio").button({
        icons: {primary:'ui-icon-calculator'}
    }).bind('click', function(){
        // location.href = path + "registro";
        alert('ver valores del predio');
    });

    $("#btnImprimir").button({
        icons: {primary:'ui-icon-calculator'}
    }).bind('click', function(){
        // location.href = path + "registro";
    	window.open(pathReport+"reporte=Report_Completo&opt=p_mhresum^" + $("#_mhresum").val() + "|p_cperiod^-1|p_ccodpre^-1|p_mperson^" + $("#lblCodigo").html(), '_blank');
    });

    $("#btnGaleria").button({
        icons: {primary:'ui-icon-search'}
    }).bind('click', function(){
        // location.href = path + "registro";
    	// window.open(pathReport+"reporte=Report_Completo&opt=p_mhresum^" + $("#_mhresum").val() + "|p_cperiod^-1|p_ccodpre^-1|p_mperson^" + $("#lblCodigo").html(), '_blank');
    });
    
    navPanelPiso = function() {
        $("#tblPiso").jqGrid('navGrid', '#ptblPiso', {edit:false, add:false, del:false, search:false, refresh:false});
        $("#tblPiso").jqGrid('navButtonAdd', '#ptblPiso', btnInsertarPiso);
        $("#tblPiso").jqGrid('navSeparatorAdd','#ptblPiso');
        $("#tblPiso").jqGrid('navButtonAdd','#ptblPiso', btnEditarPiso);
        $("#tblPiso").jqGrid('navSeparatorAdd','#ptblPiso');
        $("#tblPiso").jqGrid('navButtonAdd','#ptblPiso', btnEliminarPiso);
    };
    
    actualizarGrid("tblPiso", optionPiso, null, navPanelPiso);
    
    navPanelInstalacion = function (){
    	 $("#tblInstalacion").jqGrid('navGrid', '#ptblInstalacion', {edit:false, add:false, del:false, search:false, refresh:false});
         $("#tblInstalacion").jqGrid('navButtonAdd','#ptblInstalacion', btnInsertarInstalacion);
         $("#tblInstalacion").jqGrid('navSeparatorAdd','#ptblInstalacion');
         $("#tblInstalacion").jqGrid('navButtonAdd','#ptblInstalacion', btnEditarInstalacion);
         $("#tblInstalacion").jqGrid('navSeparatorAdd','#ptblInstalacion');
         $("#tblInstalacion").jqGrid('navButtonAdd','#ptblInstalacion', btnEliminarInstalacion);    	
    };

    actualizarGrid("tblInstalacion", optionInstalacion, null, navPanelInstalacion );
    
    actualizarGrid("tblLindero", optionLindero, null, function(){
        $("#tblLindero").jqGrid('navGrid', '#ptblLindero', {edit:false, add:false, del:false, search:false, refresh:false});
        $("#tblLindero").jqGrid('navButtonAdd', '#ptblLindero', btnInsertarColindante);
        $("#tblLindero").jqGrid('navSeparatorAdd','#ptblLindero');
        $("#tblLindero").jqGrid('navButtonAdd','#ptblLindero', btnEditarColindante);
        $("#tblLindero").jqGrid('navSeparatorAdd','#ptblLindero');
        $("#tblLindero").jqGrid('navButtonAdd','#ptblLindero', btnEliminarColindante);
    });
    
    /*actualizarGrid("tblRustico", optionRustico, null, function(){
        $("#tblRustico").jqGrid('navGrid', '#ptblRustico', {edit:false, add:false, del:false, search:false, refresh:false});
        $("#tblRustico").jqGrid('navButtonAdd', '#ptblRustico', btnInsertarRustico);
        $("#tblRustico").jqGrid('navSeparatorAdd','#ptblRustico');
        $("#tblRustico").jqGrid('navButtonAdd','#ptblRustico', btnEditarRustico);
        $("#tblRustico").jqGrid('navSeparatorAdd','#ptblRustico');
        $("#tblRustico").jqGrid('navButtonAdd','#ptblRustico', btnEliminarRustico);
    });
    
    actualizarGrid("tblDatosTributo", optionTributo, null,function(){
        $("#tblDatosTributo").jqGrid('navGrid', '#ptblDatosTributo', {edit:false, add:false, del:false, search:false, refresh:false});       
    });*/
    
};

config = {
    skin:'v2'
    , toolbar: [
        ['Bold','Italic','Underline','-','NumberedList','BulletedList','-','Outdent','Indent','-','Undo','Redo','-','HorizontalRule','-','Blockquote','CreateDiv'],
        ['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock','-','TextColor','BGColor'],
        ['UIColor']
    ]
};
