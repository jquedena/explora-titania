<?php

/**
 * ReportesController
 * 
 * @author
 * @version 
 */

require_once 'Zend/Controller/Action.php';

class ReportesController extends Zend_Controller_Action {
	/**
	 * The default action - show the home page
	 */
	public function indexAction() {
		// TODO Auto-generated ReportesController::indexAction() default action
	}
	
	public function prediosAction(){
		    $this->_helper->getHelper('ajaxContext')->initContext();

        if ($this->getRequest()->isXmlHttpRequest()) {
            $this->_helper->layout->disableLayout();
            
        
        }
	}

}
