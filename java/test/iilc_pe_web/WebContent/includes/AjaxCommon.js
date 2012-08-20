function limpiarDatosAjax(s){
  var res = s;
  //eliminar script webseal
  res = limpiarResponse(res);

  //decodificar
  res = unescape2(res);

  return res;
}

function unescape2(s){
	var res = s.replace(/\+/g," ");
	res = unescape(res);
	return res;
}

function limpiarResponse(cadena){
	var script2 = "</" + "SCRIPT>" + "\n";
	
	if (cadena.indexOf(script2) != -1){
		rspText = cadena.substring(cadena.indexOf(script2) + script2.length);
	}
	else{
		rspText = cadena;
	}
	return rspText;
}