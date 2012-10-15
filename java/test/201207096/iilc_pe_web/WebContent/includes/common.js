// ===================================================================
// Author: Alfredo Lehar
// Stefanini IT Solutions
// ===================================================================
var lLetras=' ABCÇDEFGHIJKLMNÑOPQRSTUVWXYZabcdefghijklmnñopqrstuvwxyz';
var lExtraCorreo='@_-.';
var lExtraTelefono='#*';
var lExtraDireccion = '.#\'';
var lExtraBusqueda = '.\'';
var lExtraNombre = '\'-&';
var lNumeros='1234567890';
var lExtraDecimales='-.'
var lSigns=',.:;@-\'';
var lMathsigns='+-=()*/';
var lCustom='<>#$%&?¿';
var lFormatoNumCPI = ',.';

String.prototype.trimAll =
  function() {
    return this.replace(/^\s+|(\s+(?!\S))/mg,"");
  };

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

function trim(s){
	return s.replace(/^\s+|\s+$/, '');
}

function esSoloNumero(sText){
   if(isNaN(sText)){
      return false;
   }
   
   var ValidChars = lNumeros;
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