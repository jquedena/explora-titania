<?php
require_once 'Zend/Controller/Action.php';

class PanelController extends Zend_Controller_Action {

    public function init() {
    	$this->_helper->layout()->setLayout('layoutwithpanel');
    }
    
    public function indexAction() {
    }
    
    public function personaAction() {
    	$this->_helper->getHelper('ajaxContext')->initContext();
    	
    	if ($this->getRequest()->isXmlHttpRequest()) {
    		$this->_helper->layout->disableLayout();
    		
    		$this->view->cidpers = $this->_request->getParam('cidpers');
    		$this->view->vnombre = $this->_request->getParam('crazsoc');
    		$parameters[] = $this->view->cidpers;
    		
    		$dataAdapter = new Model_DataAdapter();
    		$rows = $dataAdapter->executeAssocQuery("pl_function.panel_persona", $parameters);
    		$this->view->mperson = $rows[0];
    	}
    }
    
    public function predioAction() {
        
    }
}