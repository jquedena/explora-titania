<?php

/**
 * Fraccionamiento
 * 
 * @author
 * @version 
 */

require_once 'Zend/Controller/Action.php';

class FraccionamientoController extends Zend_Controller_Action {
	/**
	 * The default action - show the home page
	 */
	public function indexAction() {
		// TODO Auto-generated Fraccionamiento::indexAction() default action
		//$this->view->util()->registerScriptJSControllerAction($this->getRequest());
						
			$pintar= new Libreria_Pintar();
		
//	
//		$val[]=array('locategridresultestctacte',$newcontent,'html');
//		
//		$pintar->PintarValor($val);
//		
	}
	
	public function fracproyAction(){
		$this->view->util()->registerScriptJSControllerAction($this->getRequest());
		$pintar= new Libreria_Pintar();
		
		$evt[]=array('txtporcuotas','blur','inicial(1000);');
		
		$evt[]=array('txtcuotainicial','blur','cuotas();');
		
	    $pintar->PintarEvento($evt);
	}

}