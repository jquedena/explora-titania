var lNumeros='1234567890';
var nNumeros='-1234567890';
var lExtraDecimales='.'

function $(id){
	if(document.all){
		return document.all[id];
	}
	else{
		if(document.getElementById){
			return document.getElementById(id);
		}
		else{
			for(var _2=1;_2<document.layers.length;_2++){
				if(document.layers[_2].id==id){
					return document.layers[_2];
				}
			}
		}
	}
	return false;
}

function esNumericoDecimal(sText){
	var i = 0;
	if(isNaN(sText)){
		return false;
	}

	var ValidChars = nNumeros + lExtraDecimales;
	var IsNumber=true;
	var Char;

	for (i = 0; i < sText.length; i++){ 
		Char = sText.charAt(i); 
		if (ValidChars.indexOf(Char) == -1){
			IsNumber = false;
			break;
		}
	}
	return IsNumber;
}

function esNumericoEntero(sText){
	var i = 0;
	if(isNaN(sText)){
		return false;
	}

	var ValidChars = nNumeros;
	var IsNumber=true;
	var Char;

	for (i = 0; i < sText.length; i++){ 
		Char = sText.charAt(i); 
		if (ValidChars.indexOf(Char) == -1){
			IsNumber = false;
			break;
		}
	}
	return IsNumber;
}

function ingresoEnteros(e){
	var key;
	var valid = '' + lNumeros;
	
	if(e.which){
		key = String.fromCharCode(e.which);
		if (valid.indexOf("" + key) == "-1")
			e.preventDefault();
	}
	else if(e.keyCode){
		key = String.fromCharCode(e.keyCode);
		if (valid.indexOf("" + key) == "-1")
			e.keyCode = 0;
	}
}

function ingresoEnterosN(e){
	var key;
	var valid = '' + nNumeros;
	
	if(e.which){
		key = String.fromCharCode(e.which);
		if (valid.indexOf("" + key) == "-1")
			e.preventDefault();
	}
	else if(e.keyCode){
		key = String.fromCharCode(e.keyCode);
		if (valid.indexOf("" + key) == "-1")
			e.keyCode = 0;
	}
}

function ingresoDecimales(e){
	var key;
	var valid = '' + lNumeros + lExtraDecimales;
	
	if(e.which){
		key = String.fromCharCode(e.which);
		if (valid.indexOf("" + key) == "-1")
			e.preventDefault();
	}
	else if(e.keyCode){
		key = String.fromCharCode(e.keyCode);
		if (valid.indexOf("" + key) == "-1")
			e.keyCode = 0;
	}
}