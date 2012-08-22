// objetivosDistribucion.js

// newFunction
function imprimir() {
window.print();
}

function buscar() {
    var form = document.forms[0];         
    form.action = "objetivosAction.do?method=inicioObjetivo";
    form.method="post";
    form.submit();
}

/*funcion verificarMonto(){
 var monto = document.getElementById('restoOficina').value;
  var indice = 0;
  var montoCompara = 0;                 
  for (i = 7; i < document.objetivosForm.elements.length; i++){
    if(document.objetivosForm.elements[i].type == "text"){     
       montoCompara = montoCompara + document.objetivosForm.elements[i].value;      
    }
  }
  if(monto < montoCompara){
	  alert('La suma de las metas no debe sobrepasar el Resto de Oficinas.');
  return false;
  }
  return true;
}*/

/*
funcion verificarMonto(){
	var gestores = document.getElementById('restoOficina').value;
	var total = document.getElementById('montoTotal').value;
	
	if(total < gestores) {
		alert('La suma de las metas debe sobrepasar el Resto de Oficinas.');
		return false;
	}
	
	return true;
}

funcion mostrarFelicitacion(){
 var monto = document.getElementById('restoOficina').value;
  var indice = 0;
  var montoCompara = 0;                   
  for (i = 7; i < document.objetivosForm.elements.length; i++){
    if(document.objetivosForm.elements[i].type == "text"){
      montoCompara = montoCompara + document.objetivosForm.elements[i].value;
    }
  }
  if(monto > montoCompara){
  document.getElementById('trMensaje').style.display = 'none';
  }else{
  document.getElementById('trMensaje').style.display = 'block';
  }
}

funcion getPorcentaje(){
var porcentaje = new Array();
  var indice = 0;                   
  for (i = 7; i < document.objetivosForm.elements.length; i++){
    if(document.objetivosForm.elements[i].type == "text"){
      if(!document.objetivosForm.elements[i].value =""){
        porcentaje[indice] = document.objetivosForm.elements[i].value;
        indice++;
      }
    }
  }
  return porcentaje;
}

funcion getCodigo(){
var codigo = new Array();
  var indice = 0;                   
  for (i = 0; i < document.objetivosForm.elements.length; i++){
    if(document.objetivosForm.elements[i].type == "text"){
      if(!document.objetivosForm.elements[i].value =""){
        codigo[indice] = document.objetivosForm.elements[i].value;
        indice++;
      }
    }
  }
  return codigo;
}

funcion getNombre(){
var nombre = new Array();
  var indice = 0;                   
  for (i = 0; i < document.objetivosForm.elements.length; i++){
    if(document.objetivosForm.elements[i].type == "text"){
      if(!document.objetivosForm.elements[i].value =""){
        nombre[indice] = document.objetivosForm.elements[i].value;
        indice++;
      }
    }
  }
  return nombre;
}
*/

function grabar(){
	var codPorcentaje = getPorcentaje();
    var codGestor = getCodigo();
    var nomGestor = getNombre();    
    if(verificarMonto()){
    var form = document.forms[0];         
    form.action = "planificacionAction.do?method=grabar&codPorcentaje="+codPorcentaje"&codGestor="+codGestor"&nomGestor"+nomGestor;
    form.method="post";
    form.submit();
    }
}