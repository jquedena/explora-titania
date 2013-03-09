/**
 * 
 */

function cuotas(cuotainicial){
	 var nrocuotas = $("#txtnrocuotas").val();
	 var inicial = $("#txtcuotainicial").val();
	 
	 var montofracc=1000- inicial;
	 
	 //alert(montofracc);
	 
	 var cuotamonto;
	 
	 var amortizacion=montofracc;
	 
	 var montodescuento=0;
	 
	 var hoy = new Date();
   //  var luego = hoy.addDays(31);
	 
	newcontent =  '<table border="1">';
	newcontent += '<tr>';
	newcontent += '<th width="50px">Amortizacion</th>';
	newcontent += '<th width="50px">Cuota</th>';
	newcontent += '<th width="50px">Fecha Vencimiento</th>';
	newcontent += '<th width="50px">Monto</th>';
	newcontent += '<th width="50px">Int.Fracc</th>';
	newcontent += '<th width="50px">Total</th>';
	newcontent += '</tr>';
	
	
	for(var i=0; i<=nrocuotas; i++){	
		
		if (i==0){		
		var cadcontentrow = '<tr>';		
		cadcontentrow += '<td align="center" width="50px">&nbsp;' +montofracc + '</td>';
		cadcontentrow += '<td align="center" width="50px">&nbsp;' +i + '</td>';
		cadcontentrow += '<td align="center" width="50px">&nbsp;' + hoy.getDate()+"/"+hoy.getMonth() + "/" + hoy.getFullYear() + '</td>';
		cadcontentrow += '<td align="center" width="50px">&nbsp;' +inicial+'</td>';
		cadcontentrow += '<td align="center" width="50px">&nbsp;' +5.60 + '</td>';
		cadcontentrow += '<td align="center" width="50px">&nbsp;' +(parseFloat(inicial)+parseFloat( 5.60)) + '</td>';
		cadcontentrow += '</tr>';			
		}
		else{			
			cuotamonto=Math.round(((montofracc/nrocuotas))*100)/100;
			
			montodescuento=montodescuento+cuotamonto;
			
			
			amortizacion=parseFloat(montofracc)- parseFloat(montodescuento);
			
			var cadcontentrow = '<tr>';		
			cadcontentrow += '<td align="center" width="50px">&nbsp;' +Math.round(amortizacion) + '</td>';
			cadcontentrow += '<td align="center" width="50px">&nbsp;' +i + '</td>';
			cadcontentrow += '<td align="center" width="50px">&nbsp;' + hoy.getDate()+"/"+hoy.getMonth() + "/" + hoy.getFullYear() + '</td>';
			cadcontentrow += '<td align="center" width="50px">&nbsp;' +cuotamonto+'</td>';
			cadcontentrow += '<td align="center" width="50px">&nbsp;'  +Math.round((((parseFloat(amortizacion)*0.008)/i))*100)/100+ '</td>';
			cadcontentrow += '<td align="center" width="50px">&nbsp;' +(parseFloat(Math.round((((parseFloat(amortizacion)*0.008)/i))))+parseFloat(cuotamonto))+ '</td>';
			cadcontentrow += '</tr>';
		}
	
		newcontent += cadcontentrow;	
				
		 hoy.setMonth(i+3);
	}

	newcontent += "</table>";
	
	$("#locategridresultestctacte").html(newcontent);
	return false;	
}