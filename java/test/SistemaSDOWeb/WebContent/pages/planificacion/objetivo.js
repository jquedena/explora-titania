function imprimir() {
window.print();
}

function buscarObjetivos() {
if(verificarMonto()){
    var form = document.forms[0];         
    form.action = "objetivosAction.do?method=inicioObjetivo";
    form.method="post";
    form.submit();
    }
}

function verificarMonto(){
 var monto = document.getElementById('restoOficina').value;
  var indice = 0;
  var montoCompara = 0;                 
  for (i = 7; i < document.forms[0].elements.length; i++){
    if(document.forms[0].elements[i].type == "text"){     
       montoCompara = montoCompara + document.objetivosForm.elements[i].value;      
    }
  }
  if(monto < montoCompara){
  alert('La suma de las metas no debe sobrepasar el Resto de Oficinas.');
  return false;
  }
  return true;
}

function mostrarFelicitacion(){
 var monto = document.getElementById('restoOficina').value;
  var indice = 0;
  var montoCompara = 0;                   
  for (i = 7; i < document.forms[0].elements.length; i++){
    if(document.forms[0].elements[i].type == "text"){
      montoCompara = montoCompara + document.objetivosForm.elements[i].value;
    }
  }
  if(monto > montoCompara){
  document.getElementById('trMensaje').style.display = 'none';
  }else{
  document.getElementById('trMensaje').style.display = 'block';
  }
}
