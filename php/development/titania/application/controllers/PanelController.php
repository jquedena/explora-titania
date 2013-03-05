<?php
require_once 'Zend/Controller/Action.php';

class PanelController extends Zend_Controller_Action {

    public function init() {
    	$this->_helper->layout()->setLayout('layoutwithpanel');
    }
    
    public function indexAction() {
    }

    public function resumenPersona($cidpers, $crazsoc) {
    	$parameters[] = $cidpers;
    	$dataAdapter = new Model_DataAdapter();   
    	$rows = $dataAdapter->executeAssocQuery("pl_function.panel_persona", $parameters);
    	if($rows != null) {
    		$mperson = $rows[0];
    	} else {
    		$mperson = array(
    			'cidpers' => $cidpers,
    			'crazsoc' => $crazsoc,
    			'vnrodoc' => 'No existe informaci&oacute;n',
    			'dfecdoc' => '',
    			'vmotivo' => '',
    			'ntotpre' => '0',
    			'ntotcom' => '0',
    			'nbaseim' => '0.00',
    			'nimpanu' => '0.00',
    			'vprofis' => 'No',
    			'vprotra' => 'No',
    			'dfecpag' => '',
    		);
    	}
    
    	$rows = $dataAdapter->executeAssocQuery("pl_function.resumen_saldo_personal", $parameters);
    	if($rows != null) {
    		$msaldos = $rows[0];
    	} else {
    		$msaldos = array(
    				'cidpers' => '',
    				'ntotals' => '',
    				'npendie' => '',
    				'ncancel' => '',
    				'nporcen' => '',
    				'vindica' => 'ff0000.png'
    		);
    	}
    	
    	return array("mperson" => $mperson, "msaldos" => $msaldos);
    }
    
    public function personaAction() {
    	$this->_helper->getHelper('ajaxContext')->initContext();
    	
    	if ($this->getRequest()->isXmlHttpRequest()) {
    		$this->_helper->layout->disableLayout();
    		
    		$this->view->cidpers = $this->_request->getParam('cidpers');
    		$this->view->vnombre = $this->_request->getParam('crazsoc');
    		
    		$result = $this->resumenPersona($this->view->cidpers, $this->view->vnombre);

    		$this->view->mperson = $result["mperson"];
    		$this->view->msaldos = $result["msaldos"];
    	}
    }
    
    public function jsonpersonaAction() {
    	$this->_helper->getHelper('ajaxContext')->initContext();
    	 
    	if ($this->getRequest()->isXmlHttpRequest()) {
    		
    		$cidpers = $this->_request->getParam('cidpers');
    		$vnombre = $this->_request->getParam('crazsoc');
    		
    		$result = $this->resumenPersona($cidpers, $vnombre);
    		
    		$mperson = $result["mperson"];
    		$msaldos = $result["msaldos"];
    		
    		$data = array(
    			'cidpers' => $cidpers,
    			'vnombre' => $vnombre,
    			'mperson' => $mperson,
    			'msaldos' => $msaldos
    		);
    		
    		$this->_helper->json($data);
    	}
    }
    
    public function predioAction() {
        
    }
}