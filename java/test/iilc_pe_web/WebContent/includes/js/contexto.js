function obtenerContexto(){
	url = document.URL;
	tmp = url.split("iilc_pe_web");
	return tmp[0] + "iilc_pe_web/";
}