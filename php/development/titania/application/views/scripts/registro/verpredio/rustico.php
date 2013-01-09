

<table>
<tr>
<select style="width: 240px;" id="cboMotivo"><?php echo $this->util()->getComboContenedor('1000000004', null); ?></select></td>
<select style="width: 240px;" id="cboMotivo"><?php echo $this->util()->getComboContenedor('1000000004', null); ?></select></td>
</tr>
<tr>
<td><div id="ptblPredioColindante"></div></td>
<td><div id="ptblArancel"></div></td>
</tr>
</table>

<!--
<td><div id="ptblPredioColindante"></div>
<table id="tblPredioColindante"></table>

<div id="ptblArancel"></div>
<table id="tblArancel"></table>

<div id="panelprueba">
<div id="tblcolindante">
	-->
	
<script>

optionPrediocolindate = {
		data:[
			{ccardin:'Norte',cubicac:'aaaaa',cpropie:'bbbbb',dpropie:'ccccc',mpredio:'ddddd'},
			{ccardin:'Sur',cubicac:'aaaaa',cpropie:'bbbbb',dpropie:'ccccc',mpredio:'ddddd'},
			{ccardin:'Este',cubicac:'aaaaa',cpropie:'bbbbb',dpropie:'ccccc',mpredio:'ddddd'},
			{ccardin:'Oeste',cubicac:'aaaaa',cpropie:'bbbbb',dpropie:'ccccc',mpredio:'ddddd'}
				],
        height: 140,
        width: 438,
        rowNum: 5,
        colNames: [
            'Cardinal',
            'Ubicacion',
            'CodPropiedad',
            'DPropie',
            'mpredio'
        ],
        colModel: [
                   {name: 'ccardin', index:'vnrodoc', width: 75, align: 'center'},
                   {name: 'cubicac', index:'dfecdoc', width: 80, align: 'center'},
                   {name: 'cpropie', index:'vmotivo', width: 238},
               	   //{name: 'cpropie', index:'vmotivo', width: 238},align:"right", stype:'select', editoptions:{value:":All;0.00:0.00;12:12.00;20:20.00;40:40.00;60:60.00;120:120.00"}},	
                   {name: 'dpropie', index:'mhresum', width: 100},
                   {name: 'mpredio', index:'vobserv', width: 100}
               ],
		caption: "&nbsp;&nbsp;&nbsp;Predio Colindante",
       	onSelectRow: function(id) {
            row = $(this).getRowData(id);
        }       	
    };

	listacolindante = function() {         
		
		procesarJSON("ptblPredioColindante", "tblcolindante", optionPrediocolindate, null, null);	
	};

	$(document).ready(function(){
	listacolindante();
	});

	optionArancel = {
			data:[
				{dclasif:'xxxxx',mclasif:'aaaaa',dcatego:'bbbbb',mcatego:'ccccc',marance:'ddddd',nhectar:25,ntotals:150},
				{dclasif:'xxxxx',mclasif:'aaaaa',dcatego:'bbbbb',mcatego:'ccccc',marance:'ddddd',nhectar:25,ntotals:150},
				{dclasif:'xxxxx',mclasif:'aaaaa',dcatego:'bbbbb',mcatego:'ccccc',marance:'ddddd',nhectar:25,ntotals:150},
				{dclasif:'xxxxx',mclasif:'aaaaa',dcatego:'bbbbb',mcatego:'ccccc',marance:'ddddd',nhectar:25,ntotals:150}
					],
	        height: 140,
	        width: 438,
	        rowNum: 5,
	        colNames: [
	            'dCalsificacion',
	            'mClasificacion',
	            'dCategoria',
	            'mCategoria',
	            'narance',
	            'nhectar',
	            'ntotals'
	        ],
	        colModel: [
	                   {name: 'dclasif', index:'vnrodoc', width: 75, align: 'center'},
	                   {name: 'mclasif', index:'dfecdoc', width: 80, align: 'center'},
	                   {name: 'dcatego', index:'vmotivo', width: 238},
	                   {name: 'mcatego', index:'mhresum', width: 100},
	                   {name: 'marance', index:'vobserv', width: 100},
	                   {name: 'nhectar', index:'vobserv', width: 100},
	                   {name: 'ntotals', index:'vobserv', width: 100}
	               ],
			caption: "&nbsp;&nbsp;&nbsp;Arancel",
	       	onSelectRow: function(id) {
	            row = $(this).getRowData(id);
	        }       	
	    };

listaarancel = function() {         
		procesarJSON("ptblArancel", "tblarancel", optionArancel, null, null);	
	};

	$(document).ready(function(){
		listaarancel();
	});
	    
</script>