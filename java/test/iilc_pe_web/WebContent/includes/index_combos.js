function abrir(pagina) {
	abrir(pagina,"_blank");
}

function abrir(pagina,marco) {
	var opciones="toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, width=360px, height=420px, top=85, left=140";
	window.open(pagina,marco,opciones);
}

function llenarOficinas(){
	var cod1 = document.forms[0].territorio.value;
	
	AjaxRequest.get(
	  {
	    'url':'consulta2.do'
	    ,'parameters':{ 
	    	'method':'listaOficinas',
	    	'cod1':cod1
	     }
	    ,'timeout':3000
	    ,'onSuccess':function(req){
	    				var rspText = limpiarDatosAjax(req.responseText);
						try{
							var arr = eval(rspText);
							for(var i=0; i<arr.length; i++){
				    	       	document.forms[0].oficina.options[i+1] = new Option(arr[i]["des_oficina"], arr[i]["cod_oficina"]);
					        }
						}
						catch(e){
							alert("El servidor ha retornado una respuesta no válida");
						}
						document.getElementById("loaderOficina").style.visibility='hidden';
						desbloquear(hayResultados);
		 			}
	    ,'onTimeout':function(req){
	 					alert("Error de comunicación.  Intente nuevamente.");
						document.getElementById("loaderOficina").style.visibility='hidden';
						desbloquear(hayResultados);
		 			}
        ,'onError':function(req){
	 					alert("Error de comunicación.");
						document.getElementById("loaderOficina").style.visibility='hidden';
						desbloquear(hayResultados);
		 			}
	  }
	);
	
	document.forms[0].oficina.options.length = 0;
	document.forms[0].oficina.options[0] = new Option('TODOS', '-1');
	document.forms[0].gestor.options.length = 0;
	document.forms[0].gestor.options[0] = new Option('TODOS', '-1');
	document.getElementById("loaderOficina").style.visibility='visible';
	bloquear();
}

function llenarGestores(){
	var cod1 = document.forms[0].territorio.value;
	var cod2 = document.forms[0].oficina.value;
	
	AjaxRequest.get(
	  {
	    'url':'consulta2.do'
	    ,'parameters':{ 
	    	'method':'listaGestores',
	    	'cod1':cod1,
	    	'cod2':cod2
	     }
	    ,'timeout':3000
	    ,'onSuccess':function(req){
	    				var rspText = limpiarDatosAjax(req.responseText);
						try{
							var arr = eval(rspText);
							for(var i=0; i<arr.length; i++){
								if(!arr[i]["perfil_gestor"]=="")
					    	       	document.forms[0].gestor.options[i+1] = new Option(arr[i]["nom_gestor"] + " - " + arr[i]["perfil_gestor"], arr[i]["cod_gestor"]);
					    	    else
					    	       	document.forms[0].gestor.options[i+1] = new Option(arr[i]["nom_gestor"], arr[i]["cod_gestor"]);
					        }
						}
						catch(e){
							alert("El servidor ha retornado una respuesta no válida");
						}
						document.getElementById("loaderGestor").style.visibility='hidden';
						desbloquear(hayResultados);
		 			}
	    ,'onTimeout':function(req){
	 					alert("Error de comunicación.  Intente nuevamente.");
						document.getElementById("loaderGestor").style.visibility='hidden';
						desbloquear(hayResultados);
		 			}
        ,'onError':function(req){
	 					alert("Error de comunicación.");
						document.getElementById("loaderGestor").style.visibility='hidden';
						desbloquear(hayResultados);
		 			}
	  }
	);
	
	document.forms[0].gestor.options.length = 0;
	document.forms[0].gestor.options[0] = new Option('TODOS', '-1');
	document.getElementById("loaderGestor").style.visibility='visible';
	bloquear();
}