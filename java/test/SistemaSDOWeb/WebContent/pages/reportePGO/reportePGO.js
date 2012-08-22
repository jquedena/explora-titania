function buscarPGO() {
    var form = document.forms[0];         
    form.action = "reportePGOAction.do?method=inicioReportePGO";
    form.method="post";
    form.submit();
}