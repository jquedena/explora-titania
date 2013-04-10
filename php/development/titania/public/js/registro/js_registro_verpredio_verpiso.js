verPiso = function(rowid, iRow, iCol, e) {
	if(rowid != undefined && rowid != null && rowid !== false ) {
		row = $("#tblPiso").jqGrid('getRowData', rowid);
	} else {
		row = undefined;
	}
	
    openDialogDataFunction1("registro/verpiso", {}, "780", "595", "Detalle del piso", function() {
        if(row != undefined) {
            $("#txt_pisonivel").val(row.cnumpis);
    		$("#txt_pisoanocon").val(row.canocon);
            $("#txt_pisomescon").val(row.cmescon);
            $("#txt_cmateri").val(row.vmateri); $("#ctxt_cmateri").val(row.cmateri); $("#dtxt_cmateri").html(row.dmateri);
    		$("#txt_cconser").val(row.vconser); $("#ctxt_cconser").val(row.cconser); $("#dtxt_cconser").html(row.dconser);
    		$("#txt_cmurcol").val(row.vmurcol); $("#ctxt_cmurcol").val(row.cmurcol); $("#dtxt_cmurcol").html(row.dmurcol);       
    		$("#txt_ctechos").val(row.vtechos); $("#ctxt_ctechos").val(row.ctechos); $("#dtxt_ctechos").html(row.dtechos);
    		$("#txt_cmpisos").val(row.vmpisos); $("#ctxt_cmpisos").val(row.cmpisos); $("#dtxt_cmpisos").html(row.dmpisos);     
    		$("#txt_cpueven").val(row.vpueven); $("#ctxt_cpueven").val(row.cpueven); $("#dtxt_cpueven").html(row.dpueven);
    		$("#txt_crevest").val(row.vrevest); $("#ctxt_crevest").val(row.crevest); $("#dtxt_crevest").html(row.drevest);
    		$("#txt_cbanios").val(row.vbanios); $("#ctxt_cbanios").val(row.cbanios); $("#dtxt_cbanios").html(row.dbanios);
    		$("#txt_celectr").val(row.velectr); $("#ctxt_celectr").val(row.celectr); $("#dtxt_celectr").html(row.delectr);
    		$("#txt_pisoarecon").val(row.narecon);
    		$("#txt_pisovaluni").val(row.nvaluni);
    		$("#txt_pisoincrem").val(row.nincrem);
    		$("#txt_pisopordep").val(row.npordep);      
    		$("#txt_pisodepred").val(row.ndepred);
    		$("#txt_pisovalare").val(row.nvalare);      
    		$("#txt_pisoarecom").val(row.narecom);
    		$("#txt_pisoporcom").val(row.nporcom);
    		$("#txt_pisovalcom").val(row.nvalcom);
    		$("#txt_valpre").val(row.nvalpis);
    		$("#txt_idsigma").val(row.idsigma);
    		$("#dtxt_pisoano").html(row.nantigu  + ' A\u00F1os de antiguedad');
        }  else {
        	$("#txt_idsigma").val('-1');
        }
	});
};

gridCompletePiso = function(){        
	var row, ids = $("#tblPiso").jqGrid('getDataIDs');
	
	for(var i=0; i < ids.length; i++) { 
    	row = $("#tblPiso").jqGrid('getRowData', ids[i]);
    	console.log(row);
    	$("#tblPiso").jqGrid('setRowData', ids[i], {
        	xmateri: "<div>"+row.vmateri+row.vconser+"</div>",
        	xconser: "<div>"+row.vmurcol+row.vtechos+row.vmpisos+row.vpueven+row.vrevest+row.vbanios+row.velectr+"</div>"
        });
	}
	
	var _rows = $("#tblPiso").find(".jqgrow");
    for (var i = 0; i < _rows.length; i++) {
    	if(parseInt(_rows[i].childNodes[0].textContent) >= 5) {
    		_rows[i].attributes["class"].value += " nivel5";
    	}
    }
};

selectPiso = function(id) {
    row = $("#tblPiso").jqGrid('getRowData', id);
    $.notty({
        content: 'Muros y Columnas: <b>' + row.vmurcol + "</b><p>" + row.dmurcol + "</p><br/>"
        	+ 'Techo: <b>' + row.vtechos + "</b><p>" + row.dtechos + "</p><br/>"
        	+ 'Piso: <b>' + row.vmpisos + "</b><p>" + row.dmpisos + "</p><br/>"
        	+ 'Puertas y Ventanas: <b>' + row.vpueven + "</b><p>" + row.dpueven + "</p><br/>"
        	+ 'Revestimientos: <b>' + row.vrevest + "</b><p>" + row.drevest + "</p><br/>"
        	+ 'Ba\u00F1os: <b>' + row.vbanios + "</b><p>" + row.dbanios + "</p><br/>"
        	+ 'Instalaciones: <b>' + row.velectr + "</b><p>" + row.delectr + "</p>",
        title: 'Detalle del Nivel ' + row.cnumpis,
    	timeout: 9000,
    	showTime: false
    });
};

optionPiso = {
    height: 200,
    width: 990,
    rowNum: 10,
    rownumbers: false,
    colNames: [
           'Niv'
         , 'Ant.'
         , 'cmescon'
         , 'canocon'
         , 'MyE'
         , 'Caract.'
         , 'Mat.'
         , 'Est.'
         , 'Mu'
         , 'Te'
         , 'Pi'
         , 'Pv'
         , 'Rv'
         , 'Ba'
         , 'In'
         , 'Area Con.'
         , 'V. Unit. m2'
         , 'Inc. 5%'
         , '% Depr'
         , 'Depr.'
         , 'V. Unit. Depr.'
         , 'Area Com.'
         , '% Area Com.'
         , 'Val. Area Com.'
         , 'Val. del Piso'
         , 'cmateri', 'cconser', 'cmurcol', 'ctechos'
         , 'cmpisos', 'cpueven', 'crevest', 'cbanios'
         , 'celectr', 'idsigma', 'dpredio', 'cnitems'
         , 'cperiod', 'dmateri', 'dconser', 'dmurcol'
         , 'dtechos', 'dmpisos', 'dpueven', 'drevest'
         , 'dbanios', 'delectr'
    ],
    colModel: [
        {name: 'cnumpis', index: 'cnumpis', width: 35, align: 'center'}, // Nro de piso
        {name: 'nantigu', index: 'nantigu', width: 35, align: 'center'}, // Antiguedad
        {name: 'cmescon', index: 'cmescon', width: 30, hidden: true}, // Mes de la construccion
        {name: 'canocon', index: 'canocon', width: 30, hidden: true}, // Periodo de Construccion
        {name: 'xmateri', index: 'xmateri', width: 35, align: 'center'}, // Material : Campo Calculado
        {name: 'xconser', index: 'xconser', width: 65, align: 'center'}, // Caracteristicas : Campo Calculado
        {name: 'vmateri', index: 'vmateri', width: 40, align: 'center', hidden: true}, // Material
        {name: 'vconser', index: 'vconser', width: 40, align: 'center', hidden: true}, // Estado de conservacion
        {name: 'vmurcol', index: 'vmurcol', width: 40, align: 'center', hidden: true}, // Muros y columnas
        {name: 'vtechos', index: 'vtechos', width: 40, align: 'center', hidden: true}, // Techos
        {name: 'vmpisos', index: 'vmpisos', width: 40, align: 'center', hidden: true}, // Pisos
        {name: 'vpueven', index: 'vpueven', width: 40, align: 'center', hidden: true}, // Puertas y ventanas
        {name: 'vrevest', index: 'vrevest', width: 40, align: 'center', hidden: true}, // Revestimientos
        {name: 'vbanios', index: 'vbanios', width: 40, align: 'center', hidden: true}, // Sanitarios
        {name: 'velectr', index: 'velectr', width: 40, align: 'center', hidden: true}, // Instalaciones electricas
        {name: 'narecon', index: 'narecon', width: 55, formatter:'currency', align: 'right'}, // Area construida
        {name: 'nvaluni', index: 'nvaluni', width: 80, formatter:'currency', align: 'right'}, // Valor unitario
        {name: 'nincrem', index: 'nincrem', width: 50, formatter:'currency', align: 'right'}, // Incremento
        {name: 'npordep', index: 'npordep', width: 50, formatter:'currency', align: 'right'}, // Porcentaje de depreciacion
        {name: 'ndepred', index: 'ndepred', width: 50, formatter:'currency', align: 'right'}, // Depreciacion
        {name: 'nvalare', index: 'nvalare', width: 80, formatter:'currency', align: 'right'}, // Valor unitario depreciado del area construida
        {name: 'narecom', index: 'narecom', width: 80, formatter:'currency', align: 'right', hidden: true}, // Area comun
        {name: 'nporcom', index: 'nporcom', width: 80, formatter:'currency', align: 'right', hidden: true}, // Porcentaje de area comun
        {name: 'nvalcom', index: 'nvalcom', width: 80, formatter:'currency', align: 'right', hidden: true}, // Valor del area comun
        {name: 'nvalpis', index: 'nvalpis', width: 80, formatter:'currency', align: 'right'}, // Valor total del piso
        {name: 'cmateri', index: 'cmateri', width: 30, hidden: true}, // Identificador de la construccion del predio
        {name: 'cconser', index: 'cconser', width: 30, hidden: true}, // Identificador del predio
        {name: 'cmurcol', index: 'cmurcol', width: 30, hidden: true}, // Nro de orden de la construccion
        {name: 'ctechos', index: 'ctechos', width: 30, hidden: true}, // Ejercicio de la declaracion jurada
        {name: 'cmpisos', index: 'cmpisos', width: 30, hidden: true},
        {name: 'cpueven', index: 'cpueven', width: 30, hidden: true},
        {name: 'crevest', index: 'crevest', width: 30, hidden: true},
        {name: 'cbanios', index: 'cbanios', width: 30, hidden: true},
        {name: 'celectr', index: 'celectr', width: 30, hidden: true},
        {name: 'idsigma', index: 'idsigma', width: 30, hidden: true},
        {name: 'dpredio', index: 'dpredio', width: 30, hidden: true},
        {name: 'cnitems', index: 'cnitems', width: 30, hidden: true},
        {name: 'cperiod', index: 'cperiod', width: 30, hidden: true},
        {name: 'dmateri', index: 'dmateri', width: 30, hidden: true},
        {name: 'dconser', index: 'dconser', width: 30, hidden: true},
        {name: 'dmurcol', index: 'dmurcol', width: 30, hidden: true},
        {name: 'dtechos', index: 'dtechos', width: 30, hidden: true},
        {name: 'dmpisos', index: 'dmpisos', width: 30, hidden: true},
        {name: 'dpueven', index: 'dpueven', width: 30, hidden: true},
        {name: 'drevest', index: 'drevest', width: 30, hidden: true},
        {name: 'dbanios', index: 'dbanios', width: 30, hidden: true},
        {name: 'delectr', index: 'delectr', width: 30, hidden: true}
    ],
    caption: "&nbsp;&nbsp;&nbsp;Pisos",
    gridComplete: gridCompletePiso,
    onSelectRow: selectPiso
};

btnInsertarPiso = {
    caption: "Agregar&nbsp;&nbsp;",
    title: "Agrega un nuevo nivel al predio",
    buttonicon: "ui-icon-plus",
    onClickButton:function(){
    	verPiso();
    } 
};

btnEditarPiso = {
    caption: "Editar&nbsp;&nbsp;",
    title: "Editar el nivel seleccionado",
    buttonicon: "ui-icon-pencil",
    onClickButton:function(){
        var gsr = $("#tblPiso").jqGrid('getGridParam','selrow');
        if(gsr){
            verPiso(gsr, -1, -1, null);
        } else { 
            openDialogWarning("Seleccione la fila a editar.", 380, 150);
        } 
    } 
};
    
btnEliminarPiso = {
    caption: "Eliminar&nbsp;&nbsp;",
    title: "Eliminar la construcci\u00F3n",
    buttonicon: "ui-icon-trash",
    onClickButton:function(){
        var gsr = $("#tblPiso").jqGrid('getGridParam','selrow');
        indexRow = $("#ctblPiso").val();
        if(gsr){
        	if(confirm("Seguro de eliminar")){
        	   //	if($("#tblPiso").jqGrid('delRowData', gsr)) {
        		
        		var row2 = $("#tblPiso").jqGrid('getRowData', gsr);
        		

        		row = {
        				idsigma: row2.idsigma,
        				cnitems: 0,
        				dpredio: row2.dpredio ,
        				cnumpis: row2.cnumpis,
        				canocon: row2.canocon,
        				cmescon: row2.cmescon,
        				cmateri: row2.cmateri ,       
        				cconser: row2.cconser,
        				cmurcol: row2.cmurcol ,     
        				ctechos: row2.ctechos,
        				cmpisos: row2.cmpisos,    
        				cpueven: row2.cpueven,
        				crevest: row2.crevest,      
        				cbanios: row2.cbanios,
        				celectr: row2.celectr,		
        				narecon: row2.narecon,      
        				narecom: row2.narecom,
        				nporcom: row2.nporcom,
        				nestado: 0,
        				cperiod: row2.cperiod,
        				cclasif: $("#cboClasificacion option:selected").val() + row2.xmateri,
        				caracte: row2.xconser,
        				//Detalle Piso
        				nvaluni: row2.nvaluni,
        				nincrem: row2.nincrem,
        				npordep: row2.npordep,
        				ndepred: row2.ndepred,
        				nvalare: row2.nvalare,
        				nvalcom: row2.nvalcom,
        				nvalpis: row2.nvalpis
        				
        		};

        		_post = $.post(path + "registro/guardarpiso", row);
        	    _post.success(function(data){
        	    	optionPiso = $.extend(optionPiso, {data: data.data});
        	    	procesarJSON("panelPiso", "tblPiso", optionPiso, null, navPanelPiso);
        		});
        	       
        	    _post.error(postError);	
        		
        		
        		$("#ctblPiso").val(indexRow - 1);
        		} 
        	//}
        } else { 
            openDialogWarning("Seleccione la fila a eliminar.", 380, 150);
        } 
    } 
};