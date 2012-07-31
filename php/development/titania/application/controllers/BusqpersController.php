<?php
require_once 'Zend/Controller/Action.php';

class BusqpersController extends Zend_Controller_Action {
	
	public function init() {
		$this->view->util()->registerScriptJSController($this->getRequest());
		$this->view->util()->registerLeaveControllerAction($this->getRequest());
	}
	
	public function indexAction() {
		
		$urlpag = $this->_request->getParam('url', '');
		$tit = $this->_request->getParam('tit', '');
		$fech = $this->_request->getParam('fech', '');
		
		if($fech == ''){
			$nombrestore = '"public"."pxcobrowww"';
			$arraydatos[0] = '1';
			$arraydatos[1] = '';
			$arraydatos[2] = '';
			$cn = new Model_DataAdapter();
			$datosfecha = $cn->ejec_store_procedura_sql($nombrestore, $arraydatos);
			$dfecha = explode (" ", $datosfecha[0][0]);
			$fech = $dfecha[0];
		}
		
		$func = new Libreria_Pintar(); 
		
		$val[0] = array("urlredirect", $urlpag, "val");
		$val[1] = array("div_titulo", $tit, "html");
		$val[2] = array("txtcidper", "", "focus");
		$val[3] = array("fech", $fech, "val");
		$func->PintarValor($val);
		
		$evt[0] = array("cbnivelbusqpers", "change", "carg_campos_busqpers();");
		$evt[1] = array("txtcidper", "keypress", "if(event.keyCode  == 13){Buscar();}else{return validarnumeros(event)}");
		$evt[2] = array("Buscar", "click", "Buscar();");
		$func->PintarEvento($evt);
	}
	
	public function busquedapersonaAction() {
		$func = new Libreria_Pintar();
		
		$this->_helper->getHelper('ajaxContext')->initContext();
		$this->_helper->layout->disableLayout();
		
		if ($this->getRequest()->isXmlHttpRequest()){				
			$cidpers = trim($this->_request->getPost('cidpers'));
			$nombre = trim($this->_request->getPost('nombre'));
			$apepat = trim($this->_request->getPost('apepat'));
			$apemat = trim($this->_request->getPost('apemat'));
			$dni = trim($this->_request->getPost('dni'));
			$urlredirect = trim($this->_request->getPost('urlredirect'));
			$fech = trim($this->_request->getPost('fech'));
			
			$nombrestore = '"public"."buscar_persona"';
			$arraydatos[0] = $cidpers; // Codigo de contribuyente
			$arraydatos[1] = $nombre; // Nombre
			$arraydatos[2] = $apepat; // Apellido paterno
			$arraydatos[3] = $apemat; // Apellido materno
			$arraydatos[4] = $dni; // Doc. Identidad
			
			$cn = new Model_DataAdapter();
			$datos = $cn->executeRowsToJSON($nombrestore, $arraydatos);
			
			if ($datos == '' || $datos == null){
				if ($cidpers == null || $cidpers == '' || $cidpers == '0000000000'){
					$cper = '_________1';
				} else {
					$cper = $cidpers;
				}
				
				$val[0] = array("cidpers", $cper, "html");
				$val[1] = array("div_pers_no_reg", $apepat.' '.$apemat.' '.$nombre, "html");
				$func->PintarValor($val);
			
				if ($apepat != null || $apepat != '' || $apemat != null || $apemat != '' || $nombre != null || $nombre != '') {
					$evt[0] = array("genrecibo", "click", "window.open('" . $urlredirect . "_________1|" . $apepat . " " . $apemat . " " . $nombre . "', '_self')");
					$evt[1] = array("limpiar", "click", "$(\"#div_rsbusqpers\").html(\"\");");
					$func->PintarEvento($evt);
					
					$js[] = array("$(\"input:submit, input:button, input:reset, button\").button();");
					$func->EjecutarFuncion($js, "function");
				}else{
					$val[0] = array("botones","","html");
					$func->PintarValor($val); 
				}
			}else{				
				$val2[0]=array("busqpersona","","html");
				$func->PintarValor($val2);
									
			   	$cont ='						
					<script type="text/javascript"> var members ='.$datos.'</script>
					<script type="text/javascript">
						$(document).ready(function(){
							var optInit = getOptionsFromForm();
							$("#Pagination").pagination(members.length, optInit);
							$("#setoptions").click(function(){
								var opt = getOptionsFromForm();
								$("#Pagination").pagination(members.length, opt);
							});
						});            
					</script>';
			   	echo $cont;
			}
		
		}
	}

}

