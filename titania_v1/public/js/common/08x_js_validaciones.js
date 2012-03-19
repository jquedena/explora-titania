//***************************** Convierte la primera letra a mayusculas ******************************/
function vNom(e,solicitar){
 // Admitir solo letras
	tecla = (document.all) ? e.keyCode : e.which;
	if (tecla==8) return true;
	patron =/[\D\s]/;
	te = String.fromCharCode(tecla);
	//if (!patron.test(te)) return false;
// No admitir espacios iniciales
	txt = solicitar.value;
	if(txt.length==0 && te==' '){
		alert('No se permiten espacios iniciales.');
		return false;
	}
// Convertir 1° letra a mayuscula
	if (txt.length==0 || txt.substr(txt.length-1,1)==' ' || txt.substr(txt.length-1,1)=='.') {
		solicitar.value = txt+te.toUpperCase();
		return false;
	}
	 return true;
}

//calcular la edad de una persona 
//recibe la fecha como un string en formato español 
//devuelve un entero con la edad. Devuelve false en caso de que la fecha sea incorrecta o mayor que el dia actual 
function calcular_edad(fecha){ 
    hoy=new Date() 
    var array_fecha = fecha.split("-") 
    if (array_fecha.length!=3) 
       return false 
    var ano 
    ano = parseInt(array_fecha[0]); 
    if (isNaN(ano)) 
       return false 
    var mes 
    mes = parseInt(array_fecha[1]); 
    if (isNaN(mes)) 
       return false 
	var dia 
    dia = parseInt(array_fecha[2]); 
    if (isNaN(dia)) 
       return false 
    if (ano<=99) 
       ano +=1900 
    edad=hoy.getFullYear()  - ano - 1; 
	if (((hoy.getMonth() + 1) - mes) < 0) 
       return edad 
    if (hoy.getMonth() + 1 - mes > 0) 
       return edad+1 
	if (hoy.getUTCDate() - dia >= 0) 
       return edad + 1 
    return edad 
}



//*
//**********************************************************************************************  
//  invierta una fecha dada retornando en formato YYYYMMDD  
//  dFecIni = Fecha a invertir  
//  nTipFormat = Formato en que biene la fecha  
//               1 = DD/MM/YYYY   
//               2 = MM/DD/YYYY   
//               3 = YYYY/MM/DD  
//               4 = YYYY/DD/MM  
  
function invFecha(nTipFormat,dFecIni){  
    var dFecIni = dFecIni.replace(/-/g,"/");                    // reemplaza el - por /   
      
    // primera division fecha  
    var nPosUno  = ponCero(dFecIni.substr(0,dFecIni.indexOf("/")));  
    // 2º divicion fecha  
    var nPosDos  = ponCero(dFecIni.substr(parseInt(dFecIni.indexOf("/")) + 1,parseInt(dFecIni.lastIndexOf("/")) - parseInt(dFecIni.indexOf("/")) - 1));  
    // 3º divicion fecha  
    var nPosTres = ponCero(dFecIni.substr(parseInt(dFecIni.lastIndexOf("/")) + 1));  
  
    switch(nTipFormat){  
        case 1 :    //  DD/MM/YYYY  
            dReturnFecha = nPosTres + "" + nPosDos + "" + nPosUno;  
            break;  
			
        case 2 :    //  MM/DD/YYYY  
            dReturnFecha = nPosTres + "" + nPosUno + "" +nPosDos;  
            break;  
			
        case 3 :    //  YYYY/MM/DD  
            dReturnFecha = nPosUno + "" + nPosDos + "" +nPosTres;  
            break;  
      
        case 4 :    //  YYYY/DD/MM  
            dReturnFecha = nPosUno + "" + nPosTres + "" +nPosDos;  
            break;  
    }  
      
    return dReturnFecha;    // retorna la fecha       
}  
  
// Agrega un cero delante del strPon cuando tenga solo un caracter  
function ponCero(strPon){  
    if(parseInt(strPon.length) < 2)  
        strPon = "0" + strPon;  
    return strPon;  
}  
  
function comparaFecha(dFormat,dFecMenor, dFecMayor){  
    dFecMenor = invFecha(dFormat,dFecMenor);  
    dFecMayor = invFecha(dFormat,dFecMayor);  
  
    if(dFecMenor > dFecMayor)  
        return false;  
    else  
        return true;  
}  

function validarnumerosyletrasycaracespe(e) { 
    tecla = (document.all) ? e.keyCode : e.which; 
    //alert(tecla);
    if (tecla==8) return true; //Tecla de retroceso (para poder borrar) 
    if (tecla==0) return true; //Tecla de tab
    if (tecla==13) return true; //Tecla de enter
    if (tecla==32) return true;
    // dejar la línea de patron que se necesite y borrar el resto 
    //patron =/[A-Za-z]/; // Solo acepta letras 
    //patron = /\d/; // Solo acepta números
    //patron = /\w/; // Acepta números y letras 
    //patron = /\D/; // No acepta números 
    patron = /[\w.-]/; //numeros el punto y el signo -
    te = String.fromCharCode(tecla); 
    return patron.test(te);
}

function validarnumeros(e) { 
    tecla = (document.all) ? e.keyCode : e.which; 
    //alert(tecla);
    if (tecla==8) return true; //Tecla de retroceso (para poder borrar) 
    if (tecla==0) return true; //Tecla de tab
    if (tecla==13) return true; //Tecla de enter
    // dejar la línea de patron que se necesite y borrar el resto 
    //patron =/[A-Za-z]/; // Solo acepta letras 
    patron = /\d/; // Solo acepta números
    //patron = /\w/; // Acepta números y letras 
    //patron = /\D/; // No acepta números 
    // patron = /[\d.-]/; numeros el punto y el signo -
    te = String.fromCharCode(tecla); 
    return patron.test(te);
}

function validarletras(e){
	tecla = (document.all) ? e.keyCode : e.which; 
    //alert(tecla);
    if (tecla==8) return true; //Tecla de retroceso (para poder borrar) 
    if (tecla==0) return true; //Tecla de tab
    if (tecla==13) return true; //Tecla de enter
    if (tecla==32) return true;
    patron =/[A-Za-z]/; // Solo acepta letras 
    te = String.fromCharCode(tecla); 
    return patron.test(te);
}
function validarnumerosyletras(e) { 
    tecla = (document.all) ? e.keyCode : e.which; 
    //alert(tecla);
    if (tecla==8) return true; //Tecla de retroceso (para poder borrar) 
    if (tecla==0) return true; //Tecla de tab
    if (tecla==13) return true; //Tecla de enter
    if (tecla==32) return true;
    // dejar la línea de patron que se necesite y borrar el resto 
    //patron =/[A-Za-z]/; // Solo acepta letras 
    //patron = /\d/; // Solo acepta números
    patron = /\w/; // Acepta números y letras 
    //patron = /\D/; // No acepta números 
    // patron = /[\d.-]/; numeros el punto y el signo -
    te = String.fromCharCode(tecla); 
    return patron.test(te);
}

function IsNumeric(expression)
{
    return (String(expression).search(/^\d+$/) != -1);
}
function LPad(ContentToSize,PadLength,PadChar)
{
   var PaddedString=ContentToSize.toString();
   for(var i=ContentToSize.length+1;i<=PadLength;i++)
   {
       PaddedString=PadChar+PaddedString;
   }
   return PaddedString;
}


function limitar_caracteres(objeto,elEvento, maxi)  
{  
  var elem = objeto;  
  
  var evento = elEvento || window.event;  
  var cod = evento.charCode || evento.keyCode;  
  
    // 37 izquierda  
    // 38 arriba  
    // 39 derecha  
    // 40 abajo  
    // 8  backspace  
    // 46 suprimir  
  
  if(cod == 37 || cod == 38 || cod == 39  
  || cod == 40 || cod == 8 || cod == 46)  
  {  
    return true;  
  }  
  
  if(elem.value.length < maxi )  
  {  
    return true;  
  }  
  
  return false;  
} 

function comparar_fechas(fech1,fech2)
{
	var m1=fech1.substring(3, 5);   
	var d1=fech1.substring(0, 2);   
	var a1=fech1.substring(6,10);   
	
	var m2=fech2.substring(3, 5);   
	var d2=fech2.substring(0, 2);   
	var a2=fech2.substring(6,10); 
	
	var f1 =  new Date(a1, m1, d1);
	var f2 =  new Date(a2, m2, d2);
	
	return f1.getTime() - f2.getTime();
}

function replaceAll( text, busca, reemplaza ){
	  while (text.toString().indexOf(busca) != -1){
	    text = text.toString().replace(busca,reemplaza);
		}
	  return text;
}

function cerrarsubvent()
{	
	$(document).ready(function(){
		jQuery.lightbox().close();
	});
}

function cerrarsubvent2()
{	
	$(document).ready(function(){
		jQuery.lightbox2().close();
	});
}

//funciones del spinner
function spinner_text_max(nombretext,max){
	 var nro = $("#"+nombretext).val();
	 nro++;
	 if(nro>max){		 
		 $("#"+nombretext).val(max);
	 }else{
		 $("#"+nombretext).val(nro);
	 }
}

function spinner_text_min(nombretext,min){
	 var nro = $("#"+nombretext).val();
	 nro--;
	 if(nro<min){		 
		 $("#"+nombretext).val(min);
	 }else{
		 $("#"+nombretext).val(nro);
	 }
}

function text_min(nombretext,min){
	 var nro = $("#"+nombretext).val();
	 if(trim(nro) == ''){
		 $("#"+nombretext).val(min);
	 }else
	 {
		 if(parseFloat(nro)<parseFloat(min)){		 
			 $("#"+nombretext).val(min);
		 }else{			
			 $("#"+nombretext).val(nro);
		 }
	 }
	 
}

function min_max_text(nombretext,min,max){
	
	if(!IsNumeric(min)){
		min = $("#"+min).val();
	}
	if(!IsNumeric(max)){
		max = $("#"+max).val();
	}
	
	var nro = $("#"+nombretext).val();
		if(parseFloat(nro)>parseFloat(max)){
			$("#"+nombretext).val(max);
		}else if(parseFloat(nro)<parseFloat(min)){		 
			$("#"+nombretext).val(min);
		}else{
			$("#"+nombretext).val(nro);
		}
}

//funciones trim
function trim(stringToTrim) {
	return stringToTrim.replace(/^\s+|\s+$/g,"");
}
function ltrim(stringToTrim) {
	return stringToTrim.replace(/^\s+/,"");
}
function rtrim(stringToTrim) {
	return stringToTrim.replace(/\s+$/,"");
}


function ChangeColorrow(tableRow, highLight)
{
    if (highLight)
    {
      tableRow.style.backgroundColor = '#dcfac9';
    }
    else
    {
      tableRow.style.backgroundColor = 'white';
    }
}

function DoNavrow(theUrl)
{
window.open(theUrl,'_self');
}

function validarcad(x) {
		x = x.replace(/¡/g,"\xA1");	x = x.replace(/&iexcl;/g,"\xA1");
		x = x.replace(/¿/g,"\xBF");	x = x.replace(/&iquest;/g,"\xBF");
		x = x.replace(/À/g,"\xC0");	x = x.replace(/&Agrave;/g,"\xC0");
		x = x.replace(/à/g,"\xE0");	x = x.replace(/&agrave;/g,"\xE0");
		x = x.replace(/Á/g,"\xC1");	x = x.replace(/&Aacute;/g,"\xC1");
		x = x.replace(/á/g,"\xE1");	x = x.replace(/&aacute;/g,"\xE1");
		x = x.replace(/Â/g,"\xC2");	x = x.replace(/&Acirc;/g,"\xC2");
		x = x.replace(/â/g,"\xE2");	x = x.replace(/&acirc;/g,"\xE2");
		x = x.replace(/Ã/g,"\xC3");	x = x.replace(/&Atilde;/g,"\xC3");
		x = x.replace(/ã/g,"\xE3");	x = x.replace(/&atilde;/g,"\xE3");
		x = x.replace(/Ä/g,"\xC4");	x = x.replace(/&Auml;/g,"\xC4");
		x = x.replace(/ä/g,"\xE4");	x = x.replace(/&auml;/g,"\xE4");
		x = x.replace(/Å/g,"\xC5");	x = x.replace(/&Aring;/g,"\xC5");
		x = x.replace(/å/g,"\xE5");	x = x.replace(/&aring;/g,"\xE5");
		x = x.replace(/Æ/g,"\xC6");	x = x.replace(/&AElig;/g,"\xC6");
		x = x.replace(/æ/g,"\xE6");	x = x.replace(/&aelig;/g,"\xE6");
		x = x.replace(/Ç/g,"\xC7");	x = x.replace(/&Ccedil;/g,"\xC7");
		x = x.replace(/ç/g,"\xE7");	x = x.replace(/&ccedil;/g,"\xE7");
		x = x.replace(/È/g,"\xC8");	x = x.replace(/&Egrave;/g,"\xC8");
		x = x.replace(/è/g,"\xE8");	x = x.replace(/&egrave;/g,"\xE8");
		x = x.replace(/É/g,"\xC9");	x = x.replace(/&Eacute;/g,"\xC9");
		x = x.replace(/é/g,"\xE9");	x = x.replace(/&eacute;/g,"\xE9");
		x = x.replace(/Ê/g,"\xCA");	x = x.replace(/&Ecirc;/g,"\xCA");
		x = x.replace(/ê/g,"\xEA");	x = x.replace(/&ecirc;/g,"\xEA");
		x = x.replace(/Ë/g,"\xCB");	x = x.replace(/&Euml;/g,"\xCB");
		x = x.replace(/ë/g,"\xEB");	x = x.replace(/&euml;/g,"\xEB");
		x = x.replace(/Ì/g,"\xCC");	x = x.replace(/&Igrave;/g,"\xCC");
		x = x.replace(/ì/g,"\xEC");	x = x.replace(/&igrave;/g,"\xEC");
		x = x.replace(/Í/g,"\xCD");	x = x.replace(/&Iacute;/g,"\xCD");
		x = x.replace(/í/g,"\xED");	x = x.replace(/&iacute;/g,"\xED");
		x = x.replace(/Î/g,"\xCE");	x = x.replace(/&Icirc;/g,"\xCE");
		x = x.replace(/î/g,"\xEE");	x = x.replace(/&icirc;/g,"\xEE");
		x = x.replace(/Ï/g,"\xCF");	x = x.replace(/&Iuml;/g,"\xCF");
		x = x.replace(/ï/g,"\xEF");	x = x.replace(/&iuml;/g,"\xEF");
		x = x.replace(/Ñ/g,"\xD1");	x = x.replace(/&Ntilde;/g,"\xD1");
		x = x.replace(/ñ/g,"\xF1");	x = x.replace(/&ntilde;/g,"\xF1");
		x = x.replace(/Ò/g,"\xD2");	x = x.replace(/&Ograve;/g,"\xD2");
		x = x.replace(/ò/g,"\xF2");	x = x.replace(/&ograve;/g,"\xF2");
		x = x.replace(/Ó/g,"\xD3");	x = x.replace(/&Oacute;/g,"\xD3");
		x = x.replace(/ó/g,"\xF3");	x = x.replace(/&oacute;/g,"\xF3");
		x = x.replace(/Ô/g,"\xD4");	x = x.replace(/&Ocirc;/g,"\xD4");
		x = x.replace(/ô/g,"\xF4");	x = x.replace(/&ocirc;/g,"\xF4");
		x = x.replace(/Õ/g,"\xD5");	x = x.replace(/&Otilde;/g,"\xD5");
		x = x.replace(/õ/g,"\xF5");	x = x.replace(/&otilde;/g,"\xF5");
		x = x.replace(/Ö/g,"\xD6");	x = x.replace(/&Ouml;/g,"\xD6");
		x = x.replace(/ö/g,"\xF6");	x = x.replace(/&ouml;/g,"\xF6");
		x = x.replace(/Ø/g,"\xD8");	x = x.replace(/&Oslash;/g,"\xD8");
		x = x.replace(/ø/g,"\xF8");	x = x.replace(/&oslash;/g,"\xF8");
		x = x.replace(/Ù/g,"\xD9");	x = x.replace(/&Ugrave;/g,"\xD9");
		x = x.replace(/ù/g,"\xF9");	x = x.replace(/&ugrave;/g,"\xF9");
		x = x.replace(/Ú/g,"\xDA");	x = x.replace(/&Uacute;/g,"\xDA");
		x = x.replace(/ú/g,"\xFA");	x = x.replace(/&uacute;/g,"\xFA");
		x = x.replace(/Û/g,"\xDB");	x = x.replace(/&Ucirc;/g,"\xDB");
		x = x.replace(/û/g,"\xFB");	x = x.replace(/&ucirc;/g,"\xFB");
		x = x.replace(/Ü/g,"\xDC");	x = x.replace(/&Uuml;/g,"\xDC");
		x = x.replace(/ü/g,"\xFC");	x = x.replace(/&uuml;/g,"\xFC");
		x = x.replace(/\"/g,"\x22");
		x = x.replace(/\'/g,"\x27");
		x = x.replace(/\</g,"\x3C");
		x = x.replace(/\>/g,"\x3E");
		x = x.replace(/\[/g,"\x5B");
		x = x.replace(/\]/g,"\x5D");
		x = x.replace(/¢/g,"\xA2");	x = x.replace(/&cent;/g,"\xA2");
		x = x.replace(/£/g,"\xA3");	x = x.replace(/&pound;/g,"\xA3");
		x = x.replace(/€/g,"\u20AC");	x = x.replace(/&euro;/g,"\u20AC");
		x = x.replace(/©/g,"\xA9");	x = x.replace(/&copy;/g,"\xA9");
		x = x.replace(/®/g,"\xAE");	x = x.replace(/&reg;/g,"\xAE");
		x = x.replace(/ª/g,"\xAA");	x = x.replace(/&ordf;/g,"\xAA");
		x = x.replace(/º/g,"\xBA");	x = x.replace(/&ordm;/g,"\xBA");
		x = x.replace(/°/g,"\xB0");	x = x.replace(/&deg;/g,"\xB0");
		x = x.replace(/±/g,"\xB1");	x = x.replace(/&plusmn;/g,"\xB1");
		x = x.replace(/×/g,"\xD7");	x = x.replace(/&times;/g,"\xD7");
		return x;
}

