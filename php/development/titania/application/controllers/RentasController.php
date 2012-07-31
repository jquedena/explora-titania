<?php
require_once 'Zend/Controller/Action.php';

class RentasController extends Zend_Controller_Action {
	
	public function init() {
		$this->view->util()->registerScriptJSController($this->getRequest());
	}
	
	public function indexAction() {
		// TODO Auto-generated RentasController::indexAction() default action
	}
	
	public function datosAction(){
		//$evt[] = array('btndetpredio000001','click','$("#ventanadetallepredio" ).dialog( "open" );');

		$this->view->util()->registerScriptJSController($this->getRequest());
		$url = $this->view->util()->getPath();
		$datospers = $this->_request->getParam ( 'datospers', '' );
			if ($datospers == '') {
				header ( 'location:' . $url . 'index.php/busqpers/?tit=Datos Contribuyente&url=' . $url . 'index.php/rentas/datos/?datospers=', true );
			} else {				
				list ( $cidpers, $nompers, $dir , $fechaproyeccion ) = explode ( '|', $datospers );
				echo $this->view->inlineScript()->appendScript('pintardatoscontribuyente("'.$cidpers .'","'. $nompers .'","'. $dir .'")');		
			}
	}
	
	public function datoscontribuyenteAction(){
		$this->_helper->viewRenderer->setNoRender ();
		$this->_helper->layout->disableLayout ();
		
		$array['mensaje'] = "OK";
		$array['result']['contribuyente'] = array("codigo"=> ""	, "nombre"=> "Miguelito", "apaterno"=> "", "amaterno"=> "", "tipoDocumento"=> "", "nroDocumento"=> "", "domicilio"=> "");
		
		$predios[] = array("codigo"=> "000001", "tipo"=> "X", "direccion"=> "mi casita 01", "uso"=> "CASA"    ,"porcentaje" => '100', "fechaadq"=>"21/03/1990" , "fechabaj"=>"" ,"valorepredio"=> "100.00", "valorafecto"=> "100.00", "impuestoanual"=> "10.00" , "valuo"=>"876.00" );
		$predios[] = array("codigo"=> "000002", "tipo"=> "Y", "direccion"=> "mi casita 02", "uso"=> "COMERCIO","porcentaje" => '100', "fechaadq"=>"26/12/2010" , "fechabaj"=>"26/01/2012" ,"valorepredio"=> "200.00", "valorafecto"=> "200.00", "impuestoanual"=> "10.00" , "valuo"=>"123.00" );
		$predios[] = array("codigo"=> "000003", "tipo"=> "Z", "direccion"=> "mi casita 03", "uso"=> "IGLESIA" ,"porcentaje" => '100', "fechaadq"=>"26/01/2012" , "fechabaj"=>"" ,"valorepredio"=> "6000.00", "valorafecto"=> "0.00", "impuestoanual"=> "0.00" , "valuo"=>"321654.00" );
		
		$array['result']['predios']	= $predios;	

		echo json_encode($array);
	}
	
	public function detallepredioAction(){
		$this->_helper->viewRenderer->setNoRender ();
		$this->_helper->layout->disableLayout ();
		
		$array['mensaje'] = "OK";
		
		echo json_encode($array);
	}

}

