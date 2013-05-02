// JavaScript Document
function cambiarPuesto(){
	var prueba = document.getElementById('puesto').value;
	if(prueba=='4'){
	document.getElementById('otroPuesto').style.display = 'block';
	}else{
		document.getElementById('otroPuesto').style.display = 'none';
	}
}

function cambiarCobertura(){
	var prueba = document.getElementById('codCobertura').value;
	
	if(prueba=='T020001'){	

	document.getElementById('vacacionesCobertura').style.display = 'block';
	document.getElementById('periodo').style.display = 'block';
	document.getElementById('enter').style.display = 'none';
	document.getElementById('fechas').style.display = 'none';
	
	}else{
		document.getElementById('vacacionesCobertura').style.display = 'none';
		document.getElementById('periodo').style.display = 'none';	
		document.getElementById('enter').style.display = 'block';
		document.getElementById('fechas').style.display = 'block';
			
	}
}
function buscar(){
	var url = "busqueda.html";
      var ventanaBusqueda = window.open(url,"ventana6","width=750, height=550, scrollbars=yes, menubar=no, location=no, resizable=no")
}

function buscar1(){
	var url = "../busqueda.html";
      var ventanaBusqueda = window.open(url,"ventana7","width=750, height=550, scrollbars=yes, menubar=no, location=no, resizable=no")
}

function detalleOfi(n){
	if(n=='1') var url = "oficina/RegistroSolicitud.html";
	if(n=='2') var url = "oficina/RegistroSolicitud2.html";
	if(n=='3') var url = "oficina/RegistroSolicitud3.html";
	if(n=='6') var url = "DetalleJefeOficina2.html";
	if(n=='7') var url = "DetalleJefeOficina1.html";
	if(n=='4') var url = "oficina/RegistroSolicitud4.html";
	if(n=='5') var url = "oficina/RegistroSolicitud5.html";	
	//var url = "oficina/RegistroSolicitud.html";
      var ventanaBusqueda = window.open(url,"ventana6","width=820, height=650, scrollbars=yes, menubar=no, location=no, resizable=no")
}




function ocultarBbva(){
	var prueba = document.getElementById('tercero').value;
	if(prueba=='0001'){
	document.getElementById('ocultar2').style.display = 'block';
	document.getElementById('ocultar3').style.display = 'block';
	}else{
	document.getElementById('ocultar2').style.display = 'none';
	document.getElementById('ocultar3').style.display = 'none';
	}
}

function verAmpliacion(){
	var f = document.forms[0]; 
	if(document.getElementById('checkAmpliacion').checked){		
		document.getElementById('reubicacion').style.display = 'none';	
		document.getElementById('reubicacion1').style.display = 'none';	
		document.getElementById('ampliacion').style.display = 'block';		
		f.fecInicioAmp.focus()
		
	}else{		
		document.getElementById('reubicacion').style.display = 'block';
		document.getElementById('reubicacion1').style.display = 'block';
		document.getElementById('ampliacion').style.display = 'none';		
	}
}

function ir1(){
	location.href ="ControlAsistencia2.html";
	}
	
function ir2(){
	location.href ="ControlAsistencia3.html";
	}	

function detalleAsi(n){
	
	if(n=='1') var url = "ControlAsistencia1.html";
	if(n=='2') var url = "ControlAsistencia1.html";
	if(n=='3') var url = "ControlAsistencia1.html";
	//var url = "oficina/RegistroSolicitud.html";
      var ventanaBusqueda = window.open(url,"ventana6","width=800, height=450, scrollbars=yes, menubar=no, location=no, resizable=no")
}