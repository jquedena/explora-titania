habilitarComponenteDetalle = function(disabled){
		
    $(".ui-text, .ui-combobox-input").attr("disabled", disabled);
    $(".ui-text, .ui-combobox-input").toggleClass("ui-text-disable");
    $(".ui-combobox a").button("option", "disabled", disabled);
    $("#dtpFechaAdquisicion, #dtpFechaTransferencia, #dptFechaResolucionInafecto").datepicker("option", "disabled", disabled);
       
    //$("#btnEditarPredio").button("option", "disabled", !disabled);
    /*
    alert($("#cboTipoPredioUrbano option:selected").val()); 
    
    if ($("#cboTipoPredioUrbano option:selected").val()=='1000000091'){
    	$("#panelTerreno").css({"display" : "none"});
       	 
    }else{    	
    	$("#panelTerreno").css({"display" : "inline"});
    } */ 
    
    
    
    $("#txtPeriodo").toggleClass("ui-text-disable");
    /*
    $("#cb_tipoinafecto").combobox("destroy");
    
    //$("#cb_tipoinafecto").removeClass("ui-text-disable");
    $("#txt_expedienteinafecto").removeClass("ui-text-disable");
    $("#txt_resolucioninafecto").removeClass("ui-text-disable");
    $("#txt_baselegalinafecto").removeClass("ui-text-disable");
    $("#txtObservacionInafectacion").removeClass("ui-text-disable");
    
    $("#dptFechaResolucionInafecto").removeClass("ui-text-disable");
    $("#txt_inicioinafecto").removeClass("ui-text-disable");
    $("#txt_fininafecto").removeClass("ui-text-disable");
        
     //$("#cb_tipoinafecto").attr("disabled", false);
     $("#txt_expedienteinafecto").attr("disabled", false);
     $("#txt_resolucioninafecto").attr("disabled", false);
     $("#txt_baselegalinafecto").attr("disabled", false);
     $("#txtObservacionInafectacion").attr("disabled", false);
     $("#dptFechaResolucionInafecto").attr("disabled", false);
     $("#txt_inicioinafecto").attr("disabled", false);
     $("#txt_fininafecto").attr("disabled", false);
          
     //$("#cb_tipoinafecto").toggleClass("ui-text");
    $("#txt_expedienteinafecto").toggleClass("ui-text");
    $("#txt_resolucioninafecto").toggleClass("ui-text");
    $("#txt_baselegalinafecto").toggleClass("ui-text");
    $("#txtObservacionInafectacion").toggleClass("ui-text");
    $("#dptFechaResolucionInafecto").toggleClass("ui-text");
    $("#txt_inicioinafecto").toggleClass("ui-text");
    $("#txt_fininafecto").toggleClass("ui-text");
    
    $("#GrabarInafecta").button("option", "disabled", false);
    */
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

//var vv = [ 2 ];  
 
function deshabilitab( vv ){	  
		  $( "#tabsDetallePredio" ).tabs( "option", "disabled", vv );	 
}

function habilitab(tipo ){
	  if (tipo==0){
		  $( "#tabsDetallePredio" ).tabs( "option", "disabled", [ 1,2,3,4,5 ] );  
		  
		  $("#btnImprimir").button("option", "disabled", true);
		  $("#btnFinalizar").button("option", "disabled", true);
		  $("#btnCancelarPredio").button("option", "disabled", true);
		  $("#btnBuscarDireccion").button("option", "disabled", true);
		  
		  $("#txtPeriodo").toggleClass("ui-text-disable");
		  $("#linkPeriodo").button("option", "disabled", true);
		  
		  
	  }else{
		 //$( "#tabsDetallePredio" ).tabs( "option", "enable", [ 1,2,3,4,5 ] );	
		 $( "#tabsDetallePredio" ).tabs( "option", "disabled", false );
		 // $( "#tabsDetallePredio" ).tabs( "enable");
		 $("#btnImprimir").button("option", "disabled", false);
		 $("#btnFinalizar").button("option", "disabled", false);
		 $("#btnCancelarPredio").button("option", "disabled", false);
		 $("#btnBuscarDireccion").button("option", "disabled", false);
		  
		 $("#txtPeriodo").toggleClass("ui-text");
		 $("#linkPeriodo").button("option", "disabled", false);
	  }
	  
}

function habilitatran(){

   	$("#dtpFechaAdquisicion").attr("disabled", true);
    $("#dtpFechaTransferencia").attr("disabled", true);
    $("#txtNotaria").attr("disabled", true);
    $("#txtTipoTransferencia").attr("disabled", true);
    $("#txtPartida").attr("disabled",true);
    
  
    $("#dtpFechaAdquisicion").toggleClass("ui-text-disable");
    $("#dtpFechaTransferencia").toggleClass("ui-text-disable");
    $("#txtNotaria").toggleClass("ui-text-disable");
    $("#txtTipoTransferencia").toggleClass("ui-text-disable");
    $("#txtPartida").toggleClass("ui-text-disable");
    
    //$("#cboMotivo .ui-combobox-input").attr("disabled", true);
    //  $("#txtMotivo").attr("disabled", true);
     //$("#cboMotivo .ui-combobox-input").toggleClass("ui-text-disable");
      $("#txtMotivo").toggleClass("ui-text-disable");
 	//$("#cboMotivo .ui-combobox-input").button("option", "disabled", true);
 	$("#linkMotivo").button("option", "disabled", true);
	
 	 $("#nporcen").toggleClass("ui-text-disable");
 	 
     $("#btnVerCondominante").button("option", "disabled", true);
     
     $("#narecom").toggleClass("ui-text-disable");
     $("#nporcom").toggleClass("ui-text-disable");
     $("#ntotcom").toggleClass("ui-text-disable");
     $("#nporter").toggleClass("ui-text-disable");
     $("#ntotter").toggleClass("ui-text-disable");
          
     $("#txtTipoPredio").toggleClass("ui-text-disable");
  	//$("#cboMotivo .ui-combobox-input").button("option", "disabled", true);
  	$("#linkTipoPredio").button("option", "disabled", true);
}


guardar = function() {	
	
	row = { 
			idsigma: $("#_dpredio").val(),
			mpredio: $("#_mpredio").val(),
			ctippre: $("#cboTipoPredio").val(),
			cclasif: $("#cboClasificacion option:selected").attr("data-idsigma"),
			ccondic: $("#cboCondicion").val(),        			
			cestado: $("#cboEstado").val(),
			cusogen: $("#cboUso").val(),       
			cusoesp: $("#cboUsoEspecifico").val(),
			nporcen: $("#nporcen").val(),     
			ntertot: $("#nareter").val(),
			nporter: $("#nporter").val(),    
			nterren: $("#ntotter").val(),
			ncomtot: $("#ntotcom").val(),      
			nporcom: $("#nporcom").val(),
			narecom: $("#narecom").val(),		
			nporafe: 100,      
			dfecadq: $("#dtpFechaAdquisicion").val(),
			dfecdes: '',
			dafecta: '', 
			nfrente: $("#nfronti").val(),
			ncanper: $("#nnrohab").val() ,
			ctippar: $("#cboParque").val(),
			vobserv: "",
			nestado: 1,
			dfectra: $("#dtpFechaTransferencia").val(),
			cnotari: $("#txtNotaria").val(),
			ctiptra: $("#txtTipoTransferencia").val(),
			cpartid: $("#txtPartida").val(),
			csubtip: $("#cboTipoPredioUrbano option:selected").val(),
			cmotadq: $("#cboMotivo option:selected").val(),
			mhresum: $("#_mhresum").val(),
			cperiod: $("#cboPeriodo option:selected").val()
			 
	};

	
	_post = $.post(path + "registro/guardardetalle", row);
	_post.error(postError);
	_post.success(function(data){
    	$("#lblArancel").html(data.valorPredio[0].narance);
    	$("#lblValorTerreno").html(data.valorPredio[0].nvalter);
    	$("#lblValorConstruccion").html(data.valorPredio[0].nvalpis);
    	$("#lblValorInstalacion").html(data.valorPredio[0].nvalins);
    	$("#lblAutovaluo").html(data.valorPredio[0].nvalpre);
    	$("#lblMontoBarrido").html(data.valorPredio[0].nbarrid);
        $("#lblMontoParque").html(data.valorPredio[0].nparque);
        $("#lblMontoRecoleccion").html(data.valorPredio[0].nrecole);
        $("#lblMontoSerenazgo").html(data.valorPredio[0].nserena);
	});
};

cambioTipoPredio = function(event, ui) {
    if(ui.item) {
        bVisible = (ui.item.option.value == "1000000091");
        visibility = (bVisible? "hidden": "visible");
        display = (bVisible? "inline": "none");
        $("#panelTerreno").css({"visibility" : visibility});
        $("#tabPredioRustico").css({"display" : display}); // Por Rustico para habilitar
        contenidocomboContenedor("#cboTipoPredioUrbano", (bVisible ? "1000000209": "1000000202")); // Por Rustico para habilitar
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

/*cambioCondicion = function(event, ui) {
    if(ui.item) {
        disable = !(ui.item.option.value == "1000000145");
        $("#btnVerCondominante").button("option", "disabled", disable);
        $("#nporcen").attr("disabled", disable);
        $("#nporcen").toggleClass("ui-text-disable");
    } else {
        openDialogWarning("El valor ingresado no esta en la lista de elementos.", 380, 150);
    }
};*/

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

    cambioCondicion= function(){
    		
    		//  alert($("#cboCondicion").val());
    		
    		   if($("#cboCondicion").val() == "1000000145"){
    		        $("#btnVerCondominante").button("option", "disabled", false);
    		   }
    		   else{
    			   $("#btnVerCondominante").button("option", "disabled", true);
    		   }
    	 	
    };
    
    $("#txtCondicion").bind("autocompleteselect", cambioCondicion);
    $("#txtCondicion").bind("autocompletechange", cambioCondicion);
    

     
    if ( $("#txtCondicion").val()=="CONDOMINIO"  ){
    	  $("#btnVerCondominante").button("option", "disabled", true);
		  
	}else{
		
	 $("#btnVerCondominante").button("option", "disabled", false);
    } 
    
    $("#txtPeriodo").attr("maxlength", 4);
    $("#txtPeriodo").bind("autocompleteselect", cambioPeriodo);
    $("#txtPeriodo").bind("autocompletechange", cambioPeriodo);
    periodoSel = $("#txtPeriodo").val();
    
    $("#dptFechaResolucionInafecto, #txt_inicioinafecto, #txt_fininafecto").datepicker({
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
   	
    	row = {
    			mhresum: $("#_mhresum").val(),
    			mpredio: $("#_mpredio").val()
    			
    	 };
    	
    	openDialogData1("registro/editarpredio", row, "650", "420", "Ubicaci&oacute;n del Predio");
    });
    
     $("#btnCancelarDescrpPredio").hide(); 
    
    $("#btnGrabarPredio").button("option", "disabled", true);

    $("#btnEditarPredio").button({
        icons: {primary:'ui-icon-pencil'}
    }).bind('click', function(){
    	
    	$("#btnEditarPredio").hide();
    	
    	$("#btnCancelarDescrpPredio").show();
    		
        habilitarComponenteDetalle(false);
        
        $("#btnGrabarPredio").button("option", "disabled", false);
         
        habilitab(0);
        
        habilitatran();
        
        
        if($("#cboCondicion").val() == "1000000145"){
            $("#btnVerCondominante").button("option", "disabled", false);
        }  
    });
    
 
    $("#btnCancelarDescrpPredio").button({
	        icons: {primary:'ui-icon-pencil'}
	    }).bind('click', function(){
	    	
	    	$("#btnGrabarPredio").button("option", "disabled", true);
	    	$("#btnVerCondominante").button("option", "disabled", true);
	 	   	 	   
	    	$("#btnCancelarDescrpPredio").hide();
	    	$("#btnEditarPredio").show();
	    	
	    	habilitarComponenteDetalle(true);
	    	   	
	    	habilitab(1);
	    	
	    	habilitatran();
	    		    	   
	    	$("#cboPeriodo").combobox('enable');
	    	
	    		    
    });

  
    $("#btnFinalizar").button({
    	icons: {primary:'ui-icon-stop'}
    }).bind('click', function(){
    	
    	if (confirm('Advertencia se dar por finalizada la declaracion.')){
    		alert("Se Procedera a Dar por cerrado");
    	}
    	
    });
    
    $("#btnGrabarPredio").button({
        icons: {primary:'ui-icon-disk'},
        disabled: true
    }).bind('click', function(){
    	
    	$("#btnGrabarPredio").button("option", "disabled", true);
    	
    	 $("#btnEditarPredio").show();
    	
    	habilitarComponenteDetalle(true);
    	
    	habilitab(1);

        
        guardar();
         
                
        $("#btnCancelarDescrpPredio").hide();
        
        habilitatran();

        
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
    	window.open(pathReport+"reporte=Report_Completo&opt=p_mhresum^"+ $("#_mhresum").val() +"|p_cperiod^"+$("#cboPeriodo option:selected").text()+"|p_ccodpre^"+$("#ccodpre").val()+ "|p_mperson^"+ $("#lblCodigo").html(), '_blank');
    });

    $("#btnSubirFoto").button({
        icons: {primary:'ui-icon-search'}
    }).bind('click', function(){
        // location.href = path + "registro";
    	// window.open(pathReport+"reporte=Report_Completo&opt=p_mhresum^" + $("#_mhresum").val() + "|p_cperiod^-1|p_ccodpre^-1|p_mperson^" + $("#lblCodigo").html(), '_blank');
    	//openDialog1("registro/galeriafotos", "725", "405", "Galeria Fotos");
    	//openDialogData1("registro/presubirfoto",{}, "725", "405", "Galeria Fotos");
        window.open( path + "registro/presubirfoto?dpredio="+$("#_dpredio").val(),'Subir Foto','width=200,height=200'); 
    });
    
    $("#btnGaleria").button({
        icons: {primary:'ui-icon-search'}
    }).bind('click', function(){
        // location.href = path + "registro";
    	// window.open(pathReport+"reporte=Report_Completo&opt=p_mhresum^" + $("#_mhresum").val() + "|p_cperiod^-1|p_ccodpre^-1|p_mperson^" + $("#lblCodigo").html(), '_blank');
    	//openDialog1("registro/galeriafotos", "725", "405", "Galeria Fotos");
    	openDialog1("registro/galeriafotos", "725", "405", "Galeria Fotos");        
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
    
    actualizarGrid("tblRustico", optionRustico, null, function(){
        $("#tblRustico").jqGrid('navGrid', '#ptblRustico', {edit:false, add:false, del:false, search:false, refresh:false});
        $("#tblRustico").jqGrid('navButtonAdd', '#ptblRustico', btnInsertarRustico);
        $("#tblRustico").jqGrid('navSeparatorAdd','#ptblRustico');
        $("#tblRustico").jqGrid('navButtonAdd','#ptblRustico', btnEditarRustico);
        $("#tblRustico").jqGrid('navSeparatorAdd','#ptblRustico');
        $("#tblRustico").jqGrid('navButtonAdd','#ptblRustico', btnEliminarRustico);
    });    
    
//    actualizarGrid("tblDatosTributo", optionTributo, null,function(){
//        $("#tblDatosTributo").jqGrid('navGrid', '#ptblDatosTributo', {edit:false, add:false, del:false, search:false, refresh:false});       
//    });
    
};

config = {
    skin:'v2'
    , toolbar: [
        ['Bold','Italic','Underline','-','NumberedList','BulletedList','-','Outdent','Indent','-','Undo','Redo','-','HorizontalRule','-','Blockquote','CreateDiv'],
        ['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock','-','TextColor','BGColor'],
        ['UIColor']
    ]
};
