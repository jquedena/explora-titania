var 
	ALFA_PATTERN=/[\ñ\Ñ\w\s\.\-]*/,
	INT_PATTERN=/\d{0,}/,
	INT_PATTERN_NEGATIVO=/\-{0,1}\d{0,}/;

function validKey(e, format){
	tecla = (document.all) ? e.keyCode : e.which;
	
	if (tecla==8 || tecla==9 ||tecla==127) return true;
	patron =/\d/;
	te = String.fromCharCode(tecla);
	return patron.test(te);
}
