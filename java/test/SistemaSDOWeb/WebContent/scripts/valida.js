//********************************************************************************************//
function esTeclasTodas(e) {
var valid = "abcdefghijklmñnopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ :.-/()#&0123456789\"???????";
var key = String.fromCharCode(event.keyCode);
	if (valid.indexOf("" + key) == "-1") return false;
}
function esTeclasTodasSinTilde(e) {
var valid = "abcdefghijklmñnopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ :.-/()0123456789_,;";
var key = String.fromCharCode(event.keyCode);
	if (valid.indexOf("" + key) == "-1") return false;
}
function esTeclasTodasComodin(e) {
var valid = "abcdefghijklmñnopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ :.-/()#&0123456789_???????%";
var key = String.fromCharCode(event.keyCode);
	if (valid.indexOf("" + key) == "-1") return false;
}

//********************************************************************************************//
function esTeclaNumero(e) {
	// alert("nro")
var valid = "0123456789";
var key = String.fromCharCode(event.keyCode);
	if (valid.indexOf("" + key) == "-1") return false;
}
//********************************************************************************************//

function Trim(num)
	{
	this.num=num.replace(/^\s*/,"");
	this.num=this.num.replace(/\s*$/,"");
	return this.num
        }
function esNada(e) {
var valid = "";
var key = String.fromCharCode(event.keyCode);
	if (valid.indexOf("" + key) == "-1") return false;
}
//********************************************************************************************//

function esTeclaDecimal(e) {
var valid = "0123456789,.";
var key = String.fromCharCode(event.keyCode);
	if (valid.indexOf("" + key) == "-1") return false;
}
//********************************************************************************************//
function esTeclaRangoNumeros(e) {
var valid = "0123456789,-";
var key = String.fromCharCode(event.keyCode);
	if (valid.indexOf("" + key) == "-1") return false;
}
//********************************************************************************************//
function esEmail(string) //string = cadena que representa al correo electronico
{//valida si la entrada es un correo electronico si es cierto devuelve true
	  if (string.search(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/) != -1)
		  return true;
		else
		  return false;
}


//*************************************************************************************//
function mensaje(){
	obj = document.getElementById("errores"); 
	if(obj.style.display=='none')
		obj.style.display='';
	else
		obj.style.display='none'; 
}
//*************************************************************************************//
function replace(linea, antiguo,nuevo){
   res = eval('linea.replace(/'+antiguo+'/g, \"'+nuevo+'\")'); 
   return res;
}


//*************************************************************************************//
function isEnter(nextTab){
    if(event.keyCode==13){
		if(null!=document.all[nextTab])
			document.all[nextTab].focus()
    }
}
///////////////////////////////////



 function anulaEnter()
 {
    if(event.keyCode==13)
    {
        window.event.returnValue=0;        
    }

 }


 function anulaTeclado()
 {
     window.event.returnValue=0;
 }

 function anulaMouse()
 {
     window.event.returnValue=0;
     return false;
 }

function pegarDecimales() 
{
	 var objEvent = window.event;
     var strPasteData = window.clipboardData.getData("Text");
     var objInput = objEvent.srcElement;

	if(f_ValidaNumerico(strPasteData)==false)
	{
	   objEvent.returnValue=0;
	   return false;
	}
}


   /*
   @author      : Orlando Pihue Montoya
   Descripcion	:	Permite el ingreso de unicamente de Letras y Espacios.
   */
function SoloLetras()
{   if(window.event.keyCode!=13)
   {
      var Tecla;
      Tecla = String.fromCharCode(window.event.keyCode);
      if ( !( (Tecla>="A" && Tecla<="Z")||(Tecla>="a" && Tecla<="z") || 
              (Tecla=="?") || (Tecla=="?") || (Tecla=="?") || (Tecla=="?") || (Tecla=="?") ||
              (Tecla=="?") || (Tecla=="?") || (Tecla=="?") || (Tecla=="?") || (Tecla=="?") ||
              (Tecla==" ") || (Tecla=="?") || (Tecla=="?") ) )
     {
         window.event.keyCode = 0;
      }
   }	
   
}
   /*
   @author      : Orlando Pihue Montoya
   Descripcion	: Permite verificar si las fechas estan dentro del rango
   				  de las Solicitud o de la fecha de Ampliacion.
   */
function validarFechas(sFecha1,sFecha2,sFecha3,sFecha4,sFecha5,sFecha6){
	var fecha1 = sFecha1.split("-");
	var fecha2 = sFecha2.split("-");	
	
	var fecha3 = sFecha3.split("/");
	var fecha4 = sFecha4.split("/");
	
	var fecha5 = sFecha5.split("-");
	var fecha6 = sFecha6.split("-");

	var strFecha1 = parseFloat(fecha1[0] + fecha1[1] + fecha1[2].substring(0,2));
	var strFecha2 = parseFloat(fecha2[0] + fecha2[1] + fecha2[2].substring(0,2));

	var strFecha3 = parseFloat(fecha3[2] + fecha3[1] + fecha3[0]);
	var strFecha4 = parseFloat(fecha4[2] + fecha4[1] + fecha4[0]);
	

	var strFecha5 = parseFloat(fecha5[0] + fecha5[1] + fecha5[2].substring(0,2));
	var strFecha6 = parseFloat(fecha6[0] + fecha6[1] + fecha6[2].substring(0,2));
 
	if((strFecha3 >= strFecha1 && strFecha3 <= strFecha2) && (strFecha4 >= strFecha1 && strFecha4 <= strFecha2)
	|| (strFecha3 >= strFecha5 && strFecha3 <= strFecha6) && (strFecha4 >= strFecha5 && strFecha4 <= strFecha6)) 
		return true; 
	else  
		return false;
}





  
function sacpEsEntero(Cadena)
{  var i;

   if(Cadena == "")  return false;      
    
    for (i = 0; i < Cadena.length; i++)
    {   
        var c = Cadena.charAt(i);
        if (((c < "0") || (c > "9"))) return false;
    }
    return true;
}



function SoloNumeros()
{
/*
Descripcion	:	Permite el ingreso unicamente de Numeros.
*/

if(window.event.keyCode!=13)
	{
	var Tecla;
	Tecla = String.fromCharCode(window.event.keyCode);
	if ( !(Tecla>="0"&&Tecla<="9") )
		{
		window.event.keyCode = 0;
		}
	}
}

function obtenerCheckValues(nameCheck,separador)
{
    var f = document.forms[0];    
    var numChecked=0;
    var cadValues="";
    
    for(var i=0 ; i<f.elements.length; i++)	
    {
        if(f.elements[i].type == "checkbox")	
        {
           if(f.elements[i].name==nameCheck && f.elements[i].checked)
           {
                numChecked = numChecked + 1;
                
                if(numChecked==1)
                    cadValues = f.elements[i].value;
                else
                    cadValues = cadValues + separador +  f.elements[i].value;
           }
        }
    }    
    
    return cadValues;
}

error=0;
function BorCarEsp(num)
	{
        expreg=/[@_:;<>?!"#$%=???'*\~{}\[\]{\\^`|???]/g;
	this.num=num.replace(expreg,"");
	return this.num;
	}

//Validacion para nombre, direcciones, documentos de identidad
//Parametros: (this.value,this.name,this.form.name)
function LimpiaCar(num,nom,fname)
	{
        num=num.toUpperCase();
        this.num=Trim(num);
	this.num=BorCarEsp(this.num)
	eval("document."+fname+"[nom].value=this.num");
	}
function Trim(num)
	{
	this.num=num.replace(/^\s*/,"");
	this.num=this.num.replace(/\s*$/,"");
	return this.num
        }
        
function cerrarSesion()
 {
    window.close();
    
 }
    /*
   @author      : Orlando Pihue Montoya
   Descripcion	: Compara dos fechas en el formato: dd/mm/aaaa.
   */

 function opmFecha1MayorQueFecha2(sFecha1,sFecha2){
	var fecha1 = sFecha1.split("/");
	var fecha2 = sFecha2.split("/");	

	var strFecha1 = parseFloat(fecha1[2] + fecha1[1] + fecha1[0]);
	var strFecha2 = parseFloat(fecha2[2] + fecha2[1] + fecha2[0]);
		 		 
	if(strFecha1 <= strFecha2) 
		return true; 
	else  
		return false;
}

    /*
   @author      : Orlando Pihue Montoya
   Descripcion	: Compara dos fechas en el formato: dd/mm/aaaa && aaaa-mm-dd.
   */

 function opmFecha1MayorQueFecha2OtherFormat(sFecha1,sFecha2){

	var fecha1 = sFecha1.split("/");
	var fecha2 = sFecha2.split("-");	
	var strFecha1 = parseFloat(fecha1[2] + fecha1[1] + fecha1[0]);
	var strFecha2 = parseFloat(fecha2[0] + fecha2[1] + fecha2[2].substring(0,2));
		 		 
	if(strFecha1 > strFecha2) 
		return true; 
	else  
		return false;
}

