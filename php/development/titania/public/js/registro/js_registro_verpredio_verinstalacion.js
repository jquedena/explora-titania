verInstalacion = function(rowid, iRow, iCol, e) {
	if(rowid != undefined && rowid != null && rowid !== false ) {
		row = $("#tblInstalacion").jqGrid('getRowData', rowid);
	} else {
		row = undefined;
	}
	
    openDialogDataFunction1("registro/verinstalacion", {}, "480", "400", "Detalle de la Instalacion", function() {
    	if(row != undefined) {
    		$("#txt_idsigma").val(row.idsigma);
	        $("#txt_instdpredio").val(row.dpredio);
	  //	$("#txt_instcnitems").val(row.cnitems);
	        $("#txt_instcperiod").val(row.cperiod);
	  //	$("#txt_instctipdat").val(row.ctipdat);       
	  //	$("#txt_instvnrodoc").val(row.vnrodoc);
	   		$("#txt_instdfecdoc").val(row.dfecdoc);       
	  //	$("#txt_instcmotivo").val(row.cmotivo);
	  //	$("#txt_instctipdoc").val(row.ctipdoc);     
	   		$("#txt_instcnumpis").val(row.cnumpis);
	   		$("#txt_instnantigu").val(row.nantigu);       
	   		$("#txt_instcanocon").val(row.canocon);
	   		$("#txt_instnvalanc").val(row.nvalanc);   
	   		$("#txt_instnvalalt").val(row.nvalalt);     
	   		$("#txt_instnvallar").val(row.nvallar);     
	   		$("#txt_instctipint").val(row.ctipint);     
	   		$("#txt_instvdesint").val(row.vdesint);     
	   		$("#txt_instnvalins").val(row.nvalins);  
	   		$("#cb_tipoinstalacion").val(row.ctipint);
	   		
	 //		$("#txt_instdafecta").val(row.dafecta);     
   }  else {
	   $("#txt_idsigma").val('-1');  
	   
   		}
});

};

guardar = function() {
	row = {
			idsigma: $("#txt_idsigma").val(),
			dpredio: $("#txt_instdpredio").val(),
	  //	$("#txt_instcnitems").val(row.cnitems);
			cperiod:$("#txt_instcperiod").val(),
	  //	$("#txt_instctipdat").val(row.ctipdat);       
	  //	$("#txt_instvnrodoc").val(row.vnrodoc);
			dfecdoc:$("#txt_instdfecdoc").val(),       
	  //	$("#txt_instcmotivo").val(row.cmotivo);
	  //	$("#txt_instctipdoc").val(row.ctipdoc);     
			cnumpis:$("#txt_instcnumpis").val(),
			nantigu:$("#txt_instnantigu").val(),       
			canocon:$("#txt_instcanocon").val(),
			nvalanc:$("#txt_instnvalanc").val(),   
			nvalalt:$("#txt_instnvalalt").val(),     
			nvallar:$("#txt_instnvallar").val(),     
			ctipint:$("#txt_instctipint").val(),     
			vdesint:$("#txt_instvdesint").val(),     
			nvalins:$("#txt_instnvalins").val(),  
			ctipint:$("#cb_tipoinstalacion").val()
	};

	_post = $.post(path + "registro/guardarinstalacion", row);
    _post.success(function(data){
    	optionInstalacion = $.extend(optionInstalacion, {data: data.data});
    	procesarJSON("panelInstalacion", "tblInstalacion", optionInstalacion, null, navPanelInstalacion);
	});
    _post.error(postError);	
};

optionInstalacion = {height: 200,
    width: 990,
    rowNum: 10,
    colNames: [
        'idsigma',
        'dpredio',
       // 'cnitems',
       // 'cperiod',
       // 'ctipdat',
       // 'vnrodoc',
       // 'dfecdoc',
       // 'cmotivo',
       // 'ctipdoc',
        'Nivel',
        'Antig.',
        'canocon',
        'Altura',
        'Ancho',
        'Largo',
        'ctipint',
        'Descripci\u00F3n',
        'Val. Inst.'
       //  'dafecta'
    ],
    colModel:[
         {name: "idsigma", index: "idsigma", width: 30, hidden: true}, // Identificador de la instalacion del predio
         {name: "dpredio", index: "dpredio", width: 30, hidden: true}, // Identificador del predio
        // {name: "cnitems", index: "cnitems", width: 30, hidden: true}, // Nro de orden de la construccion
        // {name: "cperiod", index: "cperiod", width: 30, hidden: true}, // Ejercicio de la declaracion jurada
        // {name: "ctipdat", index: "ctipdat", width: 30, hidden: true}, // Tipo de ficha (1 = declaracion jurada // 2 = acta de inspeccion)
        //  {name: "vnrodoc", index: "vnrodoc", width: 30, hidden: true}, // Nro de declaracion jurada
        // {name: "dfecdoc", index: "dfecdoc", width: 30, hidden: true}, // Fecha de la declaracion jurada
        // {name: "cmotivo", index: "cmotivo", width: 30, hidden: true}, // Motivo de la declaracion jurada
        // {name: "ctipdoc", index: "ctipdoc", width: 30, hidden: true}, // Tipo de documento con el que se realiza la declaracion jurada
         {name: "cnumpis", index: "cnumpis", width: 65, align: "center"}, // Nro de piso
         {name: "nantigu", index: "nantigu", width: 65, align: "center"}, // Antiguedad
         {name: "canocon", index: "canocon", width: 30, hidden: true}, // Periodo de Construccion
         {name: "nvalanc", index: "nvalanc", width: 30, hidden: true}, // Ancho de la instalacion
         {name: "nvalalt", index: "nvalalt", width: 30, hidden: true}, // Altura de la instalacion
         {name: "nvallar", index: "nvallar", width: 30, hidden: true}, // Largo de la instalacion
         {name: "ctipint", index: "ctipint", width: 30, hidden: true}, // Tipo de instalacion
         {name: "vdesint", index: "vdesint", width: 250}, // Descripcion de la instalacion
         {name: "nvalins", index: "nvalins", width: 150, align: "right"}, // Valor de la instalacion
        // {name: "dafecta", index: "dafecta", width: 30, hidden: true}  // Fecha desde donde se comienzan a generar los tributos
     ],
        
        
    caption: "&nbsp;&nbsp;&nbsp;Instalaci\u00F3n",
    ondblClickRow: verInstalacion
};

	btnInsertarInstalacion = {
	    caption: "Agregar&nbsp;&nbsp;",
	    title: "Agrega un nuevo nivel al predio",
	    buttonicon: "ui-icon-plus",
	    onClickButton:function(){
	    	verInstalacion();
	    } 
	};

	btnEditarInstalacion = {
	    caption: "Editar&nbsp;&nbsp;",
	    title: "Editar el nivel seleccionado",
	    buttonicon: "ui-icon-pencil",
	    onClickButton:function(){
	        var gsr = $("#tblInstalacion").jqGrid('getGridParam','selrow');
	        if(gsr){
	        	verInstalacion(gsr, -1, -1, null);
	        } else { 
	            openDialogWarning("Seleccione la fila a editar.", 380, 150);
	        } 
	    } 
	};
	    
	btnEliminarInstalacion = {
	    caption: "Eliminar",
	    title: "Eliminar la construcci\u00F3n",
	    buttonicon: "ui-icon-trash",
	    onClickButton:function(){
	        var gsr = $("#tblInstalacion").jqGrid('getGridParam','selrow');
	        indexRow = $("#ctblInstalacion").val();
	        if(gsr){
	        	if(confirm("Seguro de eliminar")){
	        		if($("#tblInstalacion").jqGrid('delRowData', gsr)) {
	        			$("#ctblInstalacion").val(indexRow - 1);
	        		} else {
	        			alert('Error no se pudo eliminar');
	        		}
	        	}
	            console.log(gsr);
	            // $("#tblPiso").jqGrid('GridToForm',gsr,"#order"); 
	        } else { 
	            openDialogWarning("Seleccione la fila a eliminar.", 380, 150);
	        } 
	    } 
	};



