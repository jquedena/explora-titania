verPredio = function(rowid, iRow, iCol, e) {
	if(rowid != undefined && rowid != null && rowid !== false ) {
		row = $("#tblResultmPredio").jqGrid('getRowData', rowid);
	} else {
		row = undefined;
	}
	
    openDialogDataFunction1("registro/verprediomantt", {}, "900", "800", "Predio", function() {
    	if(row != undefined) {
    		$("#txt_idsigma").val(row.idsigma);
	        $("#txtnumero").val(row.dnumero);
	        $("#txtviacentrpob").val(row.zona);
	  //	$("#txt_instcnitems").val(row.cnitems);
	        $("#txtczoncat").val(row.czoncat);      
			$("#txtcmzacat").val(row.cmzacat);
			$("#txtcseccat").val(row.cseccat);
			$("#txtcltecat").val(row.cltecat); 
			$("#txtcundcat").val(row.cundcat);
			
	        $("#txtinterior").val(row.dinteri);
	  //	$("#txt_instctipdat").val(row.ctipdat);       
	  //	$("#txt_instvnrodoc").val(row.vnrodoc);
	   		$("#txtletra").val(row.dletras);       
	  //	$("#txt_instcmotivo").val(row.cmotivo);
	  //	$("#txt_instctipdoc").val(row.ctipdoc);  
	   		$("#txtcodpre").val(row.ccodpre);
	   		$("#txtdepart").val(row.ddepart);
	   		$("#txtmanzana").val(row.dmanzan);       
	   		$("#txtlote").val(row.dnlotes);
	   		$("#txtreferencia").val(row.drefere);   
	   		$("#txtestacio").val(row.destaci);     
	   		$("#txtdepart").val(row.ddepart);  
	   		$("#txtdeposito").val(row.ddeposi);
	   		$("#txtbloque").val(row.dbloque);     
	   		$("#txtseccion").val(row.dseccio);     
	   		$("#txtunidinmob").val(row.dunidad);  
	   		$("#txt_mviadis").val(row.mviadis);
	   		$("#txt_mpoblad").val(row.mpoblad);
	   	    $("#txt_nlatitu").val(row.nlatitu);
		    $("#txt_nlongit").val(row.nlongit);
		    $("#txt_nzoom").val(row.nzoom);							

	 //		$("#txt_instdafecta").val(row.dafecta);     
		    
		    
		    
   }  else {
	   $("#txt_idsigma").val('-1');  
	   
   		}
});

};

bindkeysmpredio = {"onEnter": verPredio};

buscarmpredio = function() {
	/*if(_periodo == undefined || _periodo == null) {
		 $("#txtPeriodo").val('');
		 _periodo ='%'
    }else{
    	
    }*/
    parameters = {
        "name": "tblResultmPredio",
        "procedure": "registro.mostrarpredios",
        "parameters": '{' +
        '"p_cperiod":"01"' +
        '}'
    };
    
    proceso = function(requestData){
        $("#panelResultmpredio").html(requestData);
        records = $("#ctblResultmpredio").val();
        //if(records > 1) {
            actualizarGrid("tblResultmPredio", optionmpredio, bindkeysmpredio,navPanelPredio);
    };
    
    procesarConsultaSubProceso('registrar', parameters, proceso);        
 
};
 
optionmpredio= {
    height: 300,
    width: 1000,
    editurl: "mcajerosave",
    colNames: [              
			   "C\u00F3digo",
			   "Codigo Predio",
			   "Direccion",
			   "C\u00F3digo de la via",
			   "Numero",
			   "Manzana",
			   "Lote",
			   "Departamento", 
			   "Interior",
			   "Referencia",
			   "Letra",			   
			   "Estacionamiento", 
			   "Deposito",
			   "C\u00F3digo Catastral",
			   "Ubicacion en el plano",
			   "Tipo de Mercado",
			   "Nro de puesto dentro del mercado",
			   "Distrito Catastral",
			   "Zona Catastral",
			   "Manzana Catastral",
			   "Sector Catastral",
			   "Lote Catastral",
			   "Unidad Catastral",
			   "Bloque",
			   "Seccion",
			   "Unidad",
			   "C\u00F3digo Centro Poblado",			   
			   "Estado",
			
			   "Tipo de Predio",
			   "Anexo",
			   "C\u00F3digounico castastral new",
			   "Estacion",
			   "Usuario",
			   "Fecha de Registro",
			   "Latitud del predio",
			   "Longitud del predio",
			   "Zoom del mapa",
			   "Zona"
               ],
    colModel: [
        {name:'idsigma', index:'idsigma', width:80,editable: true, align: 'center', frozen: true,editoptions:{readonly:true,size:10},hidden:true},
        {name:'ccodpre', index:'ccodpre', width:90 },  
        {name:'vdirpre', index:'vdirpre', width:290 },  
        {name:'mviadis', index:'mviadis', width:90,editable: true, align: 'center',hidden:true},
        {name:'dnumero', index:'dnumero', width:90,editable: true },
        {name:'dmanzan', index:'dmanzan', width:90,editable: true, align: 'center'},
        {name:'dnlotes', index:'dnlotes', width:90,editable: true, align: 'center'},
        {name:'ddepart', index:'ddepart', width:90,editable: true },
        {name:'dinteri', index:'dinteri', width:90,editable: true },
        {name:'drefere', index:'drefere', width:90,editable: true, align: 'left'},
        {name:'dletras', index:'dletras', width:90,editable: true, align: 'left'},
        {name:'destaci', index:'destaci', width:90,editable: true, align: 'center'},
        {name:'ddeposi', index:'ddeposi', width:80,editable: true, align: 'center'},
        {name:'ccatast', index:'ccatast', width:90,editable: true, align: 'center'},
        {name:'cplanos', index:'cplanos', width:90,editable: true,align:"center",hidden:true},
        {name:'ctipmer', index:'ctipmer', width:90,editable: true,align:"right",hidden:true},
        {name:'dnummer', index:'dnummer', width:90 },
        {name:'cdiscat', index:'cdiscat', width:90 },
        {name:'czoncat', index:'czoncat', width:90 },
         {name:'cmzacat', index:'cmzacat', width:90 },
          {name:'cseccat', index:'cseccat', width:90 },  
          {name:'cltecat', index:'cltecat', width:90 },
         {name:'cundcat', index:'cundcat', width:90 }, 
         {name:'dbloque', index:'dbloque', width:90 },  
         {name:'dseccio', index:'dseccio', width:90 },  
         {name:'dunidad', index:'dunidad', width:90 },  
		 {name:'mpoblad', index:'mpoblad', width:90,hidden:true},  
		
		 {name:'nestado', index:'nestado', width:90,hidden:true ,edittype:"checkbox",editoptions:{value:"1:0",defaultValue:"1"},formatter:'checkbox' },  
		
		 {name:'ctippre', index:'ctippre', width:90,hidden:true},  
		 {name:'idanexo', index:'idanexo', width:90,hidden:true},  
		 {name:'ccodcuc', index:'ccodcuc', width:90,hidden:true},  
		 {name:'vhostnm', index:'vhostnm', width:90,hidden:true},  
		 {name:'vusernm', index:'vusernm', width:90,hidden:true},  
		 {name:'ddatetm', index:'ddatetm', width:90,hidden:true ,formatter:'date',formatoptions: { newformat: 'd-m-Y'}},  
		 {name:'nlatitu', index:'nlatitu', width:90,hidden:false},  
		 {name:'nlongit', index:'nlongit', width:90,hidden:false},  
		 {name:'nzoom', index:'nzoom', width:90,hidden:false},
		 {name:'zona', index:'zona', width:90,hidden:true}
        ],
    caption: "&nbsp;&nbsp;&nbsp;Resultados de la busqueda",
    ondblClickRow: verPredio
    	

};

	btnInsertarPredio = {
	    caption: "Agregar&nbsp;&nbsp;",
	    title: "Agrega un nuevo nivel al predio",
	    buttonicon: "ui-icon-plus",
	    onClickButton:function(){
	    	verPredio();
	    } 
	};

	btnEditarPredio = {
	    caption: "Editar&nbsp;&nbsp;",
	    title: "Editar el nivel seleccionado",
	    buttonicon: "ui-icon-pencil",
	    onClickButton:function(){
	        var gsr = $("#tblResultmPredio").jqGrid('getGridParam','selrow');
	        if(gsr){
	        	verPredio(gsr, -1, -1, null);
	        } else { 
	            openDialogWarning("Seleccione la fila a editar.", 380, 150);
	        } 
	    } 
	};
	    
	btnEliminarPredio = {
	    caption: "Eliminar",
	    title: "Eliminar Predio",
	    buttonicon: "ui-icon-trash",
	    onClickButton:function(){
	        var gsr = $("#tblResultmPredio").jqGrid('getGridParam','selrow');
	        indexRow = $("#ctblPredio").val();
	        if(gsr){
	        	if(confirm("Seguro de eliminar")){
	        	//	if($("#tblResultmPredio").jqGrid('delRowData', gsr)) {
	        			
	        	 	var row2 = $("#tblResultmPredio").jqGrid('getRowData', gsr);
	        		
	        	 	
	        			row = {
	        			idsigma: row2.idsigma,
	        			dnumero: row2.dnumero,	        			
	        			zona: row2.zona,
	        			ccatast: row2.ccatast,
	        			cplanos: row2.cplanos,  
	        	        czoncat: row2.czoncat,      
	        			cmzacat: row2.cmzacat,
	        			cseccat: row2.cseccat,
	        			cltecat: row2.cltecat, 
	        			cundcat: row2.cundcat,	        			
	        	  //	$("#txt_instcnitems").val(row.cnitems);
	        			dinteri: row2.dinteri,
	        	  //	$("#txt_instctipdat").val(row.ctipdat);       
	        	  //	$("#txt_instvnrodoc").val(row.vnrodoc);
	        			dletras: row2.dletras,       
	        	  //	$("#txt_instcmotivo").val(row.cmotivo);
	        	  //	$("#txt_instctipdoc").val(row.ctipdoc);
	        			ctipmer: row2.ctipmer,	        	 	
	        			dnummer: row2.dnummer, 
	        			cdiscat: row2.cdiscat,  
	        			vdirpre: row2.vdirpre, 
	        			ctippre: row2.ctippre, 
	        			idanexo: row2.idanexo, 
	        			ccodcuc: row2.ccodcuc, 
	        			ccodpre: row2.ccodpre,
	        			ddepart: row2.ddepart,
	        			dmanzan: row2.dmanzan,      
	        			dnlotes: row2.dnlotes,
	        	   		drefere: row2.drefere,   
	        	   		destaci: row2.destaci,    
	        	   		ddeposi: row2.ddeposi,  	        	   	   
	        	   		dbloque: row2.dbloque,     
	        	   		dseccio: row2.dseccio,    
	        	   		dunidad: row2.dunidad,  
	        	   		mviadis: row2.mviadis,
	        	   		mpoblad: row2.mpoblad,
	        	   		nlatitu: row2.nlatitu,
	        	   	    nlongit: row2.nlongit,
	        		    nzoom: row2.nzoom,
	        		    nestado: "0"	        			
	        			};

	        		_post = $.post(path + "registro/guardarmpredio", row);
	        	    _post.success(function(data){
	        	    	
	        	    	//location.reload();
	        		});
	        			
	        			
	        			
	        			$("#ctblPredio").val(indexRow - 1);
//	        		} else {
//	        			alert('Error no se pudo eliminar');
//	        		}
	        	}
	            console.log(gsr);
	            // $("#tblPiso").jqGrid('GridToForm',gsr,"#order"); 
	        } else { 
	            openDialogWarning("Seleccione la fila a eliminar.", 380, 150);
	        } 
	    } 
	};


 navPanelPredio = function() {
        $("#tblResultmPredio").jqGrid('navGrid', '#ptblResultmPredio', {edit:false, add:false, del:false, search:false, refresh:false});
        $("#tblResultmPredio").jqGrid('navButtonAdd', '#ptblResultmPredio', btnInsertarPredio);
        $("#tblResultmPredio").jqGrid('navSeparatorAdd','#ptblResultmPredio');
        $("#tblResultmPredio").jqGrid('navButtonAdd','#ptblResultmPredio', btnEditarPredio);
        $("#tblResultmPredio").jqGrid('navSeparatorAdd','#ptblResultmPredio');
        $("#tblResultmPredio").jqGrid('navButtonAdd','#ptblResultmPredio', btnEliminarPredio);
    };

    inicializarGrid("tblResultmPredio", optionmpredio,null,navPanelPredio);

    buscarmpredio2 = function() {
    	/*if(_periodo == undefined || _periodo == null) {
    		 $("#txtPeriodo").val('');
    		 _periodo ='%'
        }else{
        	
        }*/

    	c_predial= $("#c_predial");
    	
    	//viacontrib=$("#c_viacontrib");
    	viacontrib=$("#txtCodmvia");
    	
    	nroviacontrib=$("#c_nroviacontrib");
    	
    	mzacontrib=$("#c_mzacontrib");
    	
    	lotecontrib=$("#c_lotecontrib");
    	

    	  if(trim(c_predial.val()).length > 0){
    		  c_predial.val(LPad(c_predial.val(), 10, '0'));
    	    }
    	  
    	 // alert(nroviacontrib.val());
        
    	  if (nroviacontrib.val()=='0'){
    		 // alert("entro aca");
    		  
    	        parameters = {
    	                "name": "tblResultmPredio",
    	                "procedure": "pl_function.buscar_predio",
    	                "parameters": '{' +
    	                '"p_ccodpre":"'+ c_predial.val() +'",' +
    	                //'"p_ccodpre":"'+ "0000000327" +'",' +
    	                '"p_ccodvia":"'+viacontrib.val()+'",' +
    	                //'"p_cnrovia":"'+   	nroviacontrib.val()=='0'? '' : nroviacontrib.val() + '",' +
    	                '"p_cnrovia":"",' +
    	                '"p_cmanzan":"'+ mzacontrib.val()+ '",' +
    	                '"p_cnrlote":"'+ lotecontrib.val()+ '"' +
    	                '}' 
    	            };
    		  
    	  }
    	  else{
    	        parameters = {
    	                "name": "tblResultmPredio",
    	                "procedure": "pl_function.buscar_predio",
    	                "parameters": '{' +
    	                '"p_ccodpre":"'+ c_predial.val() +'",' +
    	                //'"p_ccodpre":"'+ "0000000327" +'",' +
    	                '"p_ccodvia":"'+ viacontrib.val()+ '",' +
    	                //'"p_cnrovia":"'+   	nroviacontrib.val()=='0'? '' : nroviacontrib.val() + '",' +
    	                '"p_cnrovia":"'+  nroviacontrib.val() + '",' +
    	                '"p_cmanzan":"'+ mzacontrib.val()+ '",' +
    	                '"p_cnrlote":"'+ lotecontrib.val()+ '"' +
    	                '}' 
    	            };
    		  
    	  }


        console.log(parameters);
        
        proceso = function(requestData){
            $("#panelResultmPredio").html(requestData);
  
            console.log("busqueda");
            console.log(requestData);

			
            
            records = $("#ctblResultmPredio").val();

            console.log(records);

            //alert(records); 
           // alert(records);
           if(records > 0) {
           actualizarGrid("tblResultmPredio", optionmpredio, bindkeysmpredio,navPanelPredio);
           // inicializarGrid("tblResultmBusqPredio", optionmpredio);
           }else{
        	   inicializarGrid("tblResultmPredio", optionmpredio);        	     
               openDialogWarning("No hay predios registrados.", 380, 150);
    			
           }
            
          
        };

    	 procesarConsultaSubProceso('registrar', parameters, proceso);
    }; 

    
    
$(function(){
	
	


    buscarmpredio();
    
    $("#btnbuscar").click(function(){
    	buscarmpredio2();
    });
    
    themeTextBox();
    themeComboBox();
//---
    
});