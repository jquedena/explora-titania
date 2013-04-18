function buscarObjetivos() {
    var form = document.forms[0];         
    form.action = "objetivosAction.do?method=inicioObjetivo";
    form.method="post";
    form.submit();
}

function setearCero(){
  for (i = 11; i < (document.forms[0].elements.length - 3); i++){
    if(document.forms[0].elements[i].value == "" ){
        document.forms[0].elements[i].value=0;
     }
  } 
}

function mostrarFelicitacion(){ 
	var temp =  document.getElementById('restoOficina');
	var monto = 0;
	var tam;
 
	if(temp != null) {
		monto = temp.value;
	}  

	var indice = 0;
	var montoCompara = 0;     
  
	tam = document.forms[0].elements.length - 3;
	if(document.getElementById('grabacion') == null) {
 		tam++; 
	}  
                
  for (i = 12; i < tam; i++){
    if(document.forms[0].elements[i].type == "text" ){
      montoCompara = parseFloat(montoCompara) + parseFloat(document.forms[0].elements[i].value);
    }
  }
  if(montoCompara!=''){
	  document.getElementById('montoTotal').value = montoCompara;
	}
	
	 if(Math.abs(montoCompara) <= Math.abs(monto)){
	 	var mens = document.getElementById('trMensaje');
	 	
	 	if(mens != null) {
		    mens.style.display = 'none';
	    }
	  }else{
	    document.getElementById('trMensaje').style.display = 'block';
	  }
}

/**
 * function verificarMonto(){
 *  var monto = document.getElementById('restoOficina').value;
 *  var indice = 0;
 *  var montoCompara = 0;                 
 *   for (i = 7; i < (document.forms[0].elements.length - 3); i++){
 *     if(document.forms[0].elements[i].type == "text" ){
 *       montoCompara = parseFloat(montoCompara) + parseFloat(document.forms[0].elements[i].value);
 *     }
 *   }
 *   if(Math.abs(monto) < Math.abs(montoCompara)){
 *   alert('La suma de las metas no debe sobrepasar el Resto de Oficinas.');
 *   return false;
 *   }
 *   return true;
 * }
 **/

function verificarMonto(){
	// Valida Montos
	var i = 0;
	var error = [];
	$(".Text").each(function(){
		var disabled = false;
		var cellContent = $("#epigrafe").val();
		var cellGestor = $(this).parent().parent().find('td').eq(0).text();
		if(cellContent.toUpperCase().indexOf('CARTERA ATRASADA')>=0) {
			if(parseFloat($(this).val())>0) {
				error[i] = {mensaje: 'La cartera atrasada debe ser negativa', objeto: $(this)};
				i++;
			}	
		} else {
			if(parseFloat($(this).val())<0) {
				error[i] = {mensaje: 'El monto no puede ser negativo para el epigrafe ' + cellContent, objeto: $(this) + '. Gestor :' + cellGestor};
				i++;
			}
		}
	});	
	
	if(error.length>0){
		alert(error[0].mensaje);
		error[0].objeto.focus();
		return false;
	}
	
	if(document.getElementById('restoOficina') == null) {
		return false;
	}
	
	if(document.getElementById('montoTotal') == null) {
		return false;
	}

	var gestores = parseFloat(parseInt(document.getElementById('montoTotal').value)); // Total Gestores
	var total = parseFloat(parseInt(document.getElementById('restoOficina').value)); // Ajuste Territorial
	
	/*if(gestores <= 0) {
		alert('El valor debe ser mayor a 0 en Ajuste Territorial.');
		return false;
	} */
	
	if(Math.abs(gestores) < Math.abs(total)) {
		alert('La suma de las metas debe ser mayor o igual al Ajuste Territorial.');
		return false;
	} 
	
	return true;
}

function getCodPerfil(){
	var form = document.forms[0];
	var codPerfil = new Array();

	if(form.codPerfilInterno != null) { 
		for (var i = 0; i < form.codPerfilInterno.length; i++) {
    		codPerfil[i] = form.codPerfilInterno[i].value;
    	}
	}
	
	return codPerfil;
}

function getPorcentaje(){
var porcentaje = new Array();
  var indice = 0;                   
  for (i = 7; i < document.forms[0].elements.length - 3; i++){
    if(document.forms[0].elements[i].type == "text"){
      if(document.forms[0].elements[i].value !="" ){
       if( document.forms[0].elements[i].name == "montoTotal" || document.forms[0].elements[i].name == "epigrafe" || document.forms[0].elements[i].name == "prioridad"  || document.forms[0].elements[i].name == "restoOficina"){
       }else{
        porcentaje[indice] = document.forms[0].elements[i].value;
  		indice++;
  		}
      }
    }
  }
  return porcentaje;
}

function getCodigo(){
var codigo = new Array();
  var indice = 0;                   
  for (i = 7; i < document.forms[0].elements.length - 3; i++){
    if(document.forms[0].elements[i].type == "text"){
      if(document.forms[0].elements[i].value !=""){
      if(document.forms[0].elements[i].nombre != undefined){
        codigo[indice] = document.forms[0].elements[i].codigo;
        indice++;
       }
      }
    }
  } 
  return codigo;
}

function getNombre(){
var nombre = new Array();
  var indice = 0;                   
  for (i = 7; i < document.forms[0].elements.length - 3; i++){
    if(document.forms[0].elements[i].type == "text"){
      if(document.forms[0].elements[i].value !=""){
      	if( document.forms[0].elements[i].nombre != undefined){
        nombre[indice] = document.forms[0].elements[i].nombre;
        indice++;
        }
      }
    }
  }
  return nombre;
}

function imprimir() {
	window.print();
}