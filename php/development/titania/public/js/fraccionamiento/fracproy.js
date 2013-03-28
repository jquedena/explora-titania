/**
 * 
 */

function inicial(monto){
	
	var porinicial = $("#txtporcuotas").val();
	// var inicial = $("#txtcuotainicial").val();
	 $("#txtcuotainicial").val((monto*porinicial)/100);
}

function cuotas(cuotainicial){
	 var nrocuotas = $("#txtnrocuotas").val();
	 var inicial = $("#txtcuotainicial").val();
	 
	 var montofracc=1000- inicial;
	 
	 //alert(montofracc);
	 
	 var cuotamonto;
	 
	 var amortizacion=montofracc;
	 
	 var montodescuento=0;
	 
	 var hoy = new Date();
	 
	 var interes;
	 
	 var Ui;
	 
	 var xAux;
	 
	 var R;
	 
	 var xInteFra;
	 
	  interes = ((1.2 * 0.8)/100);
	  
	  //console.log(interes);
	 
	  Ui = 1 + interes;
	 
	  for(var i=1; i<nrocuotas; i++){
			Ui = Ui * (1 + interes);		  
	  }
	  
	  xAux = ( Ui - 1 ) / (interes * Ui);
	  
	   R  = Math.round(montofracc /xAux,2);
	  
	  
   //  var luego = hoy.addDays(31);
	 
	newcontent =  '<table border="1">';
	newcontent += '<tr>';
	newcontent += '<th width="50px">Amortizacion</th>';
	newcontent += '<th width="50px">Cuota</th>';
	newcontent += '<th width="50px">Fecha Vencimiento</th>';
	newcontent += '<th width="50px">Int.Fracc</th>';
	newcontent += '<th width="50px">Monto</th>';
	newcontent += '<th width="50px">Total</th>';
	newcontent += '</tr>';
	
	
	for(var i=0; i<=nrocuotas; i++){	
		
		if (i==0){		
		var cadcontentrow = '<tr>';		
		cadcontentrow += '<td align="center" width="50px">&nbsp;' +montofracc + '</td>';
		cadcontentrow += '<td align="center" width="50px">&nbsp;' +i + '</td>';
		cadcontentrow += '<td align="center" width="50px">&nbsp;' + hoy.getDate()+"/"+hoy.getMonth() + "/" + hoy.getFullYear() + '</td>';
		cadcontentrow += '<td align="center" width="50px">&nbsp;' +0+'</td>';
		cadcontentrow += '<td align="center" width="50px">&nbsp;' +inicial + '</td>';
		cadcontentrow += '<td align="center" width="50px">&nbsp;' +(parseFloat(inicial)) + '</td>';
		cadcontentrow += '</tr>';			
		}
		else{			
		
			  	xInteFra   = amortizacion * interes;
			  	montodescuento = R - xInteFra;
			
			//montodescuento=montodescuento+cuotamonto;
			
			
			//amortizacion=parseFloat(montofracc)- parseFloat(montodescuento);
			
			var cadcontentrow = '<tr>';		
			cadcontentrow += '<td align="center" width="50px">&nbsp;' +Math.round(amortizacion) + '</td>';
			cadcontentrow += '<td align="center" width="50px">&nbsp;' +i + '</td>';
			cadcontentrow += '<td align="center" width="50px">&nbsp;' + hoy.getDate()+"/"+ (hoy.getMonth()=='0' ? "12" : hoy.getMonth() ) + "/" + hoy.getFullYear() + '</td>';
			cadcontentrow += '<td align="center" width="50px">&nbsp;' + Math.round(parseFloat(xInteFra)) + '</td>';
			cadcontentrow += '<td align="center" width="50px">&nbsp;'  +Math.round(montodescuento)+ '</td>';
			cadcontentrow += '<td align="center" width="50px">&nbsp;' +parseFloat(R)+ '</td>';
			cadcontentrow += '</tr>';
			
			 amortizacion = amortizacion - montodescuento;
		}
	
		newcontent += cadcontentrow;	
				
		 hoy.setMonth(i+3);
	}

	newcontent += "</table>";
	
	$("#locategridresultestctacte").html(newcontent);
	return false;	
}

