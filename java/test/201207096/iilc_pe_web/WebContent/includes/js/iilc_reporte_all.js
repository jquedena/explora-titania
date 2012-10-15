function datoFiltro(){
	var codigos;
}

function validaPerfil(){

	if(perfilTerritorio != "") {
		if($("#territorio").val()=="-1"){
			$("#territorio").val(perfilTerritorio);
		}
	}

	if(perfilOficina != "") {
		if($("#oficina").val()=="-1"){
			$("#oficina").val(perfilOficina);
		}
	}
}

function limpiar(){
	if(document.forms[0].perfil.value == 'LC01' || document.forms[0].perfil.value == 'LC06'){
		document.forms[0].territorio.value="-1";
		document.forms[0].oficina.value="-1";
		document.forms[0].gestor.value="-1";
	}else if(document.forms[0].perfil.value == 'LC02'){
		document.forms[0].oficina.value="-1";
		document.forms[0].gestor.value="-1";
	}else if(document.forms[0].perfil.value == 'LC03'){
		document.forms[0].gestor.value="-1";
	}

	updateBotonesFiltro();
}

function updateBotonesFiltro(){
	if(document.forms[0].territorio.value=='null' || document.forms[0].territorio.value==null || document.forms[0].territorio.value=="-1"){
		if(document.getElementById("btnTerritorio")!=null){
			document.getElementById("btnTerritorio").value = "Todos";
			document.getElementById("btnTerritorio").className = "botonFiltro";
		}
	}
	else{
		if(document.getElementById("btnTerritorio")!=null){
			document.getElementById("btnTerritorio").value = "Filtrado";
			document.getElementById("btnTerritorio").className = "botonFiltroLleno";
		}
	}
	if(document.forms[0].oficina.value=='null' || document.forms[0].oficina.value==null || document.forms[0].oficina.value=="-1"){
		if(document.getElementById("btnOficina")!=null){
			document.getElementById("btnOficina").value = "Todos";
			document.getElementById("btnOficina").className = "botonFiltro";
		}
	}
	else{
		if(document.getElementById("btnOficina")!=null){
			document.getElementById("btnOficina").value = "Filtrado";
			document.getElementById("btnOficina").className = "botonFiltroLleno";
		}
	}
	if(document.forms[0].gestor.value=='null' || document.forms[0].gestor.value==null || document.forms[0].gestor.value=="-1"){
		if(document.getElementById("btnGestor")!=null){
			document.getElementById("btnGestor").value = "Todos";
			document.getElementById("btnGestor").className = "botonFiltro";
		}
	}
	else{
		if(document.getElementById("btnGestor")!=null){
			document.getElementById("btnGestor").value = "Filtrado";
			document.getElementById("btnGestor").className = "botonFiltroLleno";
		}
	}
}

function permisoPerfil(){	
	// $("#territorio").val(pTerritorio);
	// $("#oficina").val(pOficina);
	
	updateBotonesFiltro();
}

function buscar(){
	if(document.forms[0].paginaActual != undefined){
		document.forms[0].paginaActual.value = 1;
	}
	buscarPag();
}

function buscarPag(){
	// validaPerfil();
	document.forms[0].action = contexto+"reporteVinculacion.do";       
	document.forms[0].submit();
}

function setearPagina(pagina){
	document.forms[0].paginaActual.value = pagina;       
	buscarPag();			
}
 
function abrirFiltro(tipo){
 	var parametros='';
 
	if(tipo==0)
		datoFiltro.codigos = document.forms[0].territorio.value;

	if(tipo==1){
		parametros="&territorio="+document.forms[0].territorio.value;
		datoFiltro.codigos = document.forms[0].oficina.value;
	}
	if(tipo==2){
		parametros="&territorio="+document.forms[0].territorio.value+"&oficina="+document.forms[0].oficina.value;
		datoFiltro.codigos = document.forms[0].gestor.value;
	}

	var url = "consulta2.do?method=filtroHistorico&tipo="+tipo+parametros;
	
	if(window.showModalDialog(url,datoFiltro,"dialogWidth:240px;dialogHeight:360px;")){
		if(tipo==0) {
			document.forms[0].territorio.value = datoFiltro.codigos;
			document.forms[0].oficina.value = "-1";
			document.forms[0].gestor.value = "-1";
		}
			
		if(tipo==1) {
			document.forms[0].oficina.value = datoFiltro.codigos;
			document.forms[0].gestor.value = "-1";
		}
			
		if(tipo==2) {
			document.forms[0].gestor.value = datoFiltro.codigos;
		}
			

		updateBotonesFiltro();
	}
	else{
		return;
	}
}

function consultarPorPagina(e){
	var objPag = document.forms[0].paginaActual;
	var tecla =  e.keyCode ;
	
	if(tecla==13){
		objPag.value = objPag.value.trimAll();
		if(!esSoloNumero(objPag.value)){
			alert("No es un n\u00FAmero de p\u00E1gina v\u00E1lido");
			objPag.value=page_Act;
				objPag.focus();
				objPag.select();
		}
		else{
			if(objPag.value<1 || objPag.value>totalPag){
				alert("El n\u00FAmero de p\u00E1gina debe estar entre 1 y " + totalPag);
				objPag.value=page_Act;
				objPag.focus();
				objPag.select();
			}
			else{
				document.forms[0].action = contexto+"reporteVinculacion.do";       
				document.forms[0].submit();
			}
		} 
	}
}

function pintarDetalles(datos){
	var html = "";
	var objDiv = document.getElementById("divDetalleFiltros");
	
	html+="<table border='0' cellspacing='0' cellpadding='0' width='97%'>"
	if(datos.length > 0){
		html+="<tr class='detalle'>";
		html+="<td class='detalle2'>" + datos + "</td>";
		html+="</tr>";
	}
	
	html+="</table>";
	objDiv.innerHTML = html;
	objDiv.style.visibility = "visible";
}