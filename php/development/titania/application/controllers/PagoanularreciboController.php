<?php

/**
 * PagoanularreciboController
 * 
 * @author
 * @version 
 */

require_once 'Zend/Controller/Action.php';

class PagoanularreciboController extends Zend_Controller_Action {

	public function init() {
		$this->view->util()->registerScriptJSController($this->getRequest());
		$this->view->util()->registerLeaveControllerAction($this->getRequest());
	}
	
	public function indexAction() {
		
		$ddatosuserlog = new Zend_Session_Namespace('datosuserlog');				
	    $codcajero=	$ddatosuserlog->codcajero ;

		$func = new Libreria_Pintar();
		if($codcajero>0){		
			$evt[0] = array("btnaceptar", "click", "PagosAnularRecibo();");
			$func->PintarEvento($evt);

		}else{
			$val[0] = array("showing", "No tienes privilegios de cajero para este modulo.", "html");
			$func->PintarValor($val);
			//echo 'No tienes privilegios de cajero para este modulo.';
		}//fin condicion de cajero
		
	}


	public function anularAction()
	{   
		$this->_helper->getHelper('ajaxContext')->initContext();
		
		if ($this->getRequest()->isXmlHttpRequest())
		{
		$this->_helper->viewRenderer->setNoRender(); 
		$this->_helper->layout->disableLayout(); 
		
		$ddatosuserlog = new Zend_Session_Namespace('datosuserlog');				
		$userlogin = $ddatosuserlog->userlogin;
		$codcajero = $ddatosuserlog->codcajero ;	

			$nrorec = $this->_request->getPost('nrorec');
			$obs = $this->_request->getPost('obs');
			
			
			$nombrestore = 'tesoreria.obt_estadorecibo';
			$arraydatos[0]= $nrorec;
			$cn = new Model_DataAdapter();
			$datosrecibo = $cn->ejec_store_procedura_sql($nombrestore,$arraydatos);
			
			if(count($datosrecibo)==1){
				if($datosrecibo[0][1] == '0'){
					echo 'Recibo ya esta anulado';	
				}else{
					
					$nombrestore = '"public"."pxcobrowww"';
					$arraydatos [0] = '1';
					$arraydatos [1] = '';
					$arraydatos [2] = '';
					$cn = new Model_DataAdapter();
					$datosfecha = $cn->ejec_store_procedura_sql( $nombrestore, $arraydatos );
					$dfecha = explode ( " ", $datosfecha [0] [0] );
										
						if($codcajero == $datosrecibo[0][5]){
							if($dfecha[0] == $datosrecibo[0][3]){
	
								$nombrestore = 'tesoreria.anular_recibo';
								$arraydatos[0]= $nrorec;
								$arraydatos[1]= $obs;
								$arraydatos[2]= $userlogin;
								$arraydatos[3]= '';
								
								$cn = new Model_DataAdapter();
								$datos = $cn->ejec_store_procedura_sql($nombrestore,$arraydatos);
								
								if(count($datos)>0){
									echo $datos[0][0];
								}else{
									echo 'Error en la anulaci&oacute;n';
								}		
								
							}else{
								echo 'Solo se pueden eliminar recibos del mismo d&iacute;a.';
							}			
						}else{
							echo 'El recibo nro: '.$nrorec. 'no pertenece a su nro de cajero.';
						}								
				}
				
			}else
				echo "No se encontro Recibo....o algo anda mal";
		}
	}
	
	
	
	
	
}

