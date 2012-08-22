function buscarPGO() {
    var form = document.forms[0];         
    form.action = "reportePPGAction.do?method=inicioReportePPG";
    form.method="post";
    form.submit();
}
function recargar() {
	var form = document.forms[0];
	form.action = "reportePPGAction.do?method=nuevoInicioReportePPG";
	form.submit();
}

function imprimir() {
	window.print();
}