function confirmarCargaBatch(pagina){
  if(confirm('¿Está seguro de iniciar la carga batch?')){
    document.forms[0].submit();
	lanzar(pagina);
  }
}


function lanzar(pagina){
	I= 'fab';                          //---- id de la ventana
	N= ((screen.width - 100) / 2)-40;                              //---- posicion x
	n= ((screen.height - 100) / 2)-100;                              //---- posicion y
	e= 150;                            //---- ancho
	r= 120;                             //---- alto
	d= pagina;                     //---- pagina de carga
	i= 'Cargando...';  //---- texto de la barra
	v=null;                              //---- indica si utiliza CSS
	//---- lanza la nueva ventana innerdiv
	INNERDIV.newInnerDiv(I,N,n,e,r,d,i,v);
}	