<?php

/**
 * sencilleraController
 * 
 * @author
 * @version 
 */

require_once 'Zend/Controller/Action.php';

class sencilleraController extends Zend_Controller_Action {
	
	public function init() {
		$this->view->util()->registerScriptJSController($this->getRequest());
	}
	
	public function indexAction() {
		// TODO Auto-generated sencilleraController::indexAction() default action
	}
	public function sencilleraAction() {
		
	}	
	
	public function consultasencilleraAction(){
		
	
	}
}

