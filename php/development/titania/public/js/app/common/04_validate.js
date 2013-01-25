var PATRON = {
    SOLO_LETRAS: /[A-Za-z]/,
    SOLO_NUMEROS: /\d/,
    SOLO_NUMEROS_LETRAS: /\w/,
    NO_NUMEROS: /\D/,
    NUMERO_SIGNO: /[\w.-]/
} 

function validar(e, patron) {
    tecla = (document.all) ? e.keyCode : e.which; 
    if (tecla==8) return true; //Tecla de retroceso (para poder borrar) 
    if (tecla==0) return true; //Tecla de tab
    if (tecla==13) return true; //Tecla de enter
    if (tecla==32) return true;
    te = String.fromCharCode(tecla); 
    return patron.test(te);
}

function validarnumeros(e) { 
    return validar(e, PATRON.SOLO_NUMEROS);
}

function validarletras(e){
    return validar(e, PATRON.SOLO_LETRAS);
}

function validarnumerosyletras(e) { 
    return validar(e, PATRON.SOLO_NUMEROS_LETRAS);
}

function IsNumeric(expression) {
    return (String(expression).search(/^\d+$/) != -1);
}

function LPad(ContentToSize,PadLength,PadChar) {
    var PaddedString = ContentToSize.toString();
    for(var i = ContentToSize.length+1; i<=PadLength; i++) {
        PaddedString = PadChar + PaddedString;
    }
    return PaddedString;
}

function trim(stringToTrim) {
    return stringToTrim.replace(/^\s+|\s+$/g,"");
}

function ltrim(stringToTrim) {
    return stringToTrim.replace(/^\s+/,"");
}

function rtrim(stringToTrim) {
    return stringToTrim.replace(/\s+$/,"");
}

function replaceAll(text, busca, reemplaza){
    while (text.toString().indexOf(busca) != -1){
        text = text.toString().replace(busca, reemplaza);
    }
    return text;
}