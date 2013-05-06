var 
	ALFA_PATTERN=/[\ñ\Ñ\w\s\.\-]*/,
	INT_PATTERN=/^[0-9]+$/,
	INT_PATTERN_NEGATIVO=/^-?[0-9]+$/;
/* 
 * /\-{0,1}\d{0,}/
 * /\d{0,}/ */

function validKey(obj, e, format){
	tecla = (document.all) ? e.keyCode : e.which;
	if (tecla==8 || tecla==9 ||tecla==127 || tecla==0 || tecla == 45) return true;
	te = String.fromCharCode(tecla);
	return format.test(te);
}

function SoloLetras(){
	tecla = (document.all) ? e.keyCode : e.which;
	if(tecla !=13) {
    	var key = String.fromCharCode(tecla);
    	if ( !( (key>="A" && key<="Z")||(key>="a" && key<="z") || (key>="0" && key<="9") || (key==" ")) ) {
    		return false;
    	}
	}
	return true;
}