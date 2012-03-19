
////prueba bsucar personas
function pageselectCallback(page_index, jq){
//	var dt;
	var items_per_page = $("#items_per_page").val();
	var max_elem = Math.min((page_index+1) * items_per_page, members.length);
	var newcontent = "";
	var urlredirect = $("#urlredirect").val(); 
	var fech = $("#fech").val();
	newcontent += '<table width="500" border="0" cellpadding="0" cellspacing="0">';
	newcontent += '<tr bgcolor="#FFFFFF" ><th width="100">CidPers</th><th width="350">Nombre de Persona</th><th width="50">Ver</th></tr>';

	for(var i=page_index*items_per_page;i<max_elem;i++){
		//var col = ""; if(i%2==0){col= 'bgcolor="#00FF00"';}

	var cadcontentrow = '<tr onmouseover="ChangeColorrow(this, true);"  onmouseout="ChangeColorrow(this, false);" onclick="DoNavrow(\''+ urlredirect + members[i][0] + '|' + members[i][1] + '|'+ members[i][2] + '\');" >'+
						'<td>'+members[i][0]+'</td>'+
						'<td>'+members[i][1]+'</td>'+
						'<td align="center"><a href="'+ urlredirect + members[i][0] + '|' + members[i][1] + '|' + members[i][2]+'|'+fech + '" id="a_'+ page_index*items_per_page + '"><img src="'+ jQuery.scriptPath +'img/busqueda.png " width="24" height="24"/></a> </td>'+
						'</tr>'+
						'<tr><td colspan="3"><hr/></td></tr>';
		newcontent += cadcontentrow;	
		//dt= dt +  urlredirect + members[i][0] + '|' + members[i][1] + '    ';
	}
	//alert(dt);
	newcontent += "</table>";
	$("#Searchresult").html(newcontent);
	$("#a_0").focus();
	return false;
}

function getOptionsFromForm(){

	var opt = {callback: pageselectCallback};
	$("input:hidden").each(function(){opt[this.name] = this.className.match(/numeric/) ? parseInt(this.value) : this.value;});
	var htmlspecialchars ={ '&':'&amp;', '<':'&lt;', '>':'&gt;', '"':'&quot;'}
		$.each(htmlspecialchars, function(k,v){
			//opt.prev_text = opt.prev_text.replace(k,v);
			//opt.next_text = opt.next_text.replace(k,v);
		}
	)
	return opt;
}//fin de la prueba

function carg_campos_busqpers()
{
	$('#div_rsbusqpers').html('');
    var valor = $("#cbnivelbusqpers").val();    
    if(valor == '0'){
    	//por codido de persona
    	$('#div_nivelbusqpers').html('<input type="text" id="txtcidper" name="txtcidper" value="" maxlength="10" size="30" '+ 
    								 'onkeypress="if(event.keyCode < 48 || event.keyCode > 57){event.returnValue = false;} if(event.keyCode == 13){BuscarPerxCID();}" >'+
          	  						 '<input type="button" id="Buscar" name="Buscar" value="&nbsp;&nbsp;&nbsp;&nbsp;Buscar&nbsp;&nbsp;&nbsp;&nbsp;" onClick="BuscarPerxCID()">'+
          	  						 '<script>$("#txtcidper").focus();</script>');    	
    }else if(valor == '1'){
    	//por nombres
    	$('#div_nivelbusqpers').html('<table><tr><td align="left">Apellido Paterno:</td><td><input name="txtapepat" type="text" id="txtapepat" size="30" maxlength="20" onkeypress="if(event.keyCode == 13){BuscarPerxApeNom();}" /></td></tr>'+
	    		 	                 '<tr><td align="left">Apellido Materno:</td><td><input name="txtapemat" type="text" id="txtapemat" size="30" maxlength="20" onkeypress="if(event.keyCode == 13){BuscarPerxApeNom();}" /></td></tr>'+
	    		 	                 '<tr><td align="left">Nombres:</td><td><input name="txtnombres" type="text" id="txtnombres" size="30" maxlength="20" onkeypress="if(event.keyCode == 13){BuscarPerxApeNom();}" /></td></tr>'+
	    		 	                 '<tr><td colspan="2" align="left"><input type="button" id="button" value="Buscar" onclick="BuscarPerxApeNom()" /></td></tr></table>'+
          	  						 '<script>$("#txtapepat").focus();</script>');    	
    }else if(valor == '2'){
    	//por dni
    	$('#div_nivelbusqpers').html('<input name="txtdni" type="text" id="txtdni" size="30" maxlength="8" '+
    								 'onkeypress="if(event.keyCode < 48 || event.keyCode > 57){event.returnValue = false;} if(event.keyCode == 13){BuscarPerxDNI();}" />'+
    			                 	 '<input type="button" id="button" value="Buscar" onclick="BuscarPerxDNI()" />'+
          	  						 '<script>$("#txtdni").focus();</script>');    	
    }
}

function BuscarPerxCID()
{
 var cidpers = $("#txtcidper").val(); 
 var nombre = "";
 var apepat = "";
 var apemat = "";
 var dni    = "";
 var urlredirect = $("#urlredirect").val(); 
 var fech = $("#fech").val();
 	if(cidpers.length < 1){ 
 		//alert(urlredirect);
		//alert("Debe ingresar el Codigo de la persona para la busqueda"); 
		$('#div_rsbusqpers').html('Debe ingresar el Codigo de la persona para la busqueda');
		return 0;
	 }else{
	   cidpers = '0000000000'+cidpers;
	   cidpers = cidpers.substring(cidpers.length-10,cidpers.length);
	   $("#txtcidper").val(cidpers);
	 	$.ajax( 
	 	{ 
	 	dataType: "html",
	 	type: "POST",
	 	url: jQuery.scriptPath + "index.php/busqpers/busquedapersona/", // ruta donde se encuentra nuestro action que procesa la peticion XmlHttpRequest
	 	data: 	"cidpers="+cidpers+
	 			"&nombre="+nombre+
				"&apepat="+apepat+
				"&apemat="+apemat+
				"&dni="+dni+
				"&urlredirect="+urlredirect+
				"&fech="+fech,
		beforeSend: function(data){ 
		$('#div_rsbusqpers').html('Cargando...');//Usando JQUERY, Mostramos el mensaje cargando en la lista regiones. (un efecto visual)
		},
		
		success: function(requestData){ 	//Llamada exitosa
		$("#div_rsbusqpers").html(requestData);
		},		
		error: function(requestData, strError, strTipoError){
		//En caso de error mostraremos un alert
		$("#div_rsbusqpers").html("Error " + strTipoError +': ' + strError);
		},
		complete: function(requestData, exito){ //fin de la llamada ajax.
		// 		En caso de usar una gif (cargando...) aqui quitas la imagen
		}
		});
			 
	 }
}

function BuscarPerxDNI()
{
 var cidpers = ""; 
 var nombre = ""; 
 var apepat = "";
 var apemat = "";
 var dni    = $("#txtdni").val();
 var urlredirect = $("#urlredirect").val(); 
 var fech = $("#fech").val();
 	if(dni.length < 8 ){ 
		$('#div_rsbusqpers').html('Debe ingresar un DNI valido de la persona para la busqueda');
		return 0;
	 }else{
	   cidpers = '0000000000'+cidpers;
	   cidpers = cidpers.substring(cidpers.length-10,cidpers.length);
	   $("#txtcidper").val(cidpers);
	 	$.ajax( 
	 	{
	 	dataType: "html",
	 	type: "POST",
	 	url: jQuery.scriptPath + "index.php/busqpers/busquedapersona/", // ruta donde se encuentra nuestro action que procesa la peticion XmlHttpRequest
	 	data: 	"cidpers="+cidpers+
	 			"&nombre="+nombre+
				"&apepat="+apepat+
				"&apemat="+apemat+
				"&dni="+dni+
				"&urlredirect="+urlredirect+
				"&fech="+fech,
		beforeSend: function(data){ 
		$('#div_rsbusqpers').html('Cargando...');//Usando JQUERY, Mostramos el mensaje cargando en la lista regiones. (un efecto visual)
		},
		success: function(requestData){ 	//Llamada exitosa
		$("#div_rsbusqpers").html(requestData);
		},		
		error: function(requestData, strError, strTipoError){
		//En caso de error mostraremos un alert
		$("#div_rsbusqpers").html("Error " + strTipoError +': ' + strError);
		},
		complete: function(requestData, exito){ //fin de la llamada ajax.
		// 		En caso de usar una gif (cargando...) aqui quitas la imagen
		}
		});
			 
	 }
}

function BuscarPerxApeNom()
{
 var cidpers = '0000000000'; 
 var nombre = $("#txtnombres").val().toUpperCase(); 
 var apepat = $("#txtapepat").val().toUpperCase();
 var apemat = $("#txtapemat").val().toUpperCase();
 var dni    = "";
 var urlredirect = $("#urlredirect").val();
 var fech = $("#fech").val();
 
 	if(nombre.length < 1 & apepat.length < 1 & apemat.length < 1 ){ //si el largo de nombre es menor a 2 caracteres
		//alert("Debe ingresar Almenos Un Valor Para la Busqueda"); //mensaje a la pantalla
		$('#div_rsbusqpers').html('Debe ingresar el Nombre o Apellidos de la persona para la busqueda');
		return 0;
	 }else{
			
		 	 if(nombre.length < 3 & apepat.length < 1 & apemat.length < 1 ){ //si el largo de nombre es menor a 2 caracteres
		 		 //alert("Debe ingresar por lo menos 3 letras en el nombre"); //mensaje a la pantalla
				$('#div_rsbusqpers').html('Debe ingresar por lo menos 3 letras en el nombre');
				return 0;
			 }
		 	 else if(nombre.length < 1 & apepat.length < 3 & apemat.length < 1 ){ //si el largo de nombre es menor a 2 caracteres
					//alert("Debe ingresar por lo menos 3 letras en el apellido paterno"); //mensaje a la pantalla
				$('#div_rsbusqpers').html('Debe ingresar por lo menos 3 letras en el apellido paterno');
				return 0;
			 }
		 	 else if(nombre.length < 1 & apepat.length < 1 & apemat.length < 3 ){ //si el largo de nombre es menor a 2 caracteres
					//alert("Debe ingresar por lo menos 3 letras en el apellido materno"); //mensaje a la pantalla
				$('#div_rsbusqpers').html('Debe ingresar por lo menos 3 letras en el apellido materno');
				return 0;
			 }
		 
		 else
		 {
			 	//alert(nombre+" "+apepat+" "+" "+apemat);
			 $.ajax( 
		 	{
		 	dataType: "html",
		 	type: "POST",
		 	url: jQuery.scriptPath + "index.php/busqpers/busquedapersona/", // ruta donde se encuentra nuestro action que procesa la peticion XmlHttpRequest
		 	data: 	"cidpers="+cidpers+
				 	"&nombre="+escape(nombre)+"&apepat="+escape(apepat)+"&apemat="+escape(apemat)+
					"&dni="+dni+
					"&urlredirect="+urlredirect+
					"&fech="+fech,
			beforeSend: function(data){ 
			$('#div_rsbusqpers').html('Cargando....');//Usando JQUERY, Mostramos el mensaje cargando en la lista regiones. (un efecto visual)
			},
			success: function(requestData){ 	//Llamada exitosa
			$("#div_rsbusqpers").html(requestData);
			},		
			error: function(requestData, strError, strTipoError){
			//En caso de error mostraremos un alert
			$("#div_rsbusqpers").html("Error " + strTipoError +': ' + strError);
			},
			complete: function(requestData, exito){ //fin de la llamada ajax.
			// 		En caso de usar una gif (cargando...) aqui quitas la imagen
			}
			});

		}	 
			 
	 }
}