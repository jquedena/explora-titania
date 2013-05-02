var 
	ALFA_PATTERN=/[\ñ\Ñ\w\s\.\-]*/,
	INT_PATTERN=/\d{0,}/,
	INT_PATTERN_NEGATIVO=/\-{0,1}\d{0,}/,
	isNN = (navigator.appName.indexOf("Netscape") != -1);

function validKey(e, format){
	// el = event.srcElement;	
	
	 /*tecla = (document.all) ? e.keyCode : e.which;
   	 if (tecla==8) return true;
   	 patron =/\d/;
   	 te = String.fromCharCode(tecla);
   	 return patron.test(te);*/
	
	// tecla = (document.all) ? window.event.keyCode : window.event.which; 
	tecla = (isNN) ? DnEvents.which : window.event.keyCode;
	
	/*if(tecla >= 97 && tecla <= 122) {
		event.keyCode -= 32;
	}
	
	if(tecla == 241) {
		event.keyCode = 209;
	}*/
	
   	 if(tecla == 8) return true;
   	 vTecla = String.fromCharCode(tecla);
   	 return format.test(vTecla);
	
	// str1 = el.value;
	// rango1 = document.selection.createRange().duplicate();

	// while(rango1.expand("character"));

	// var text = str1.substr(0,str1.length-rango1.text.length) + String.fromCharCode(event.keyCode) + rango1.text ;
	// var arr = format.exec(str1);
	// return (arr!=null && text==arr[0]);
}
