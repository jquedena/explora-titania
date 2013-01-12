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
    		
    		$dataAdapter = new Model_DataAdapter();
    		
    		$this->view->cidpers = $this->_request->getParam('cidpers');
    		$this->view->vnombre = $this->_request->getParam('crazsoc');
    		
    		$parameters[] = $this->view->cidpers;
    		
    		$rows = $dataAdapter->executeAssocQuery("pl_function.panel_persona", $parameters);
    		if($rows != null) {
    			$this->view->mperson = $rows[0];
    		} else {
    			$this->view->mperson = array(
    				'cidpers' => $this->view->cidpers,
    				'crazsoc' => $this->view->vnombre,
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
    			$this->view->msaldos = $rows[0];
    		} else {
    			$this->view->msaldos = array(
    					'cidpers' => '',
    					'ntotals' => '',
    					'npendie' => '',
    					'ncancel' => '',
    					'nporcen' => '',
    					'vindica' => 'ff0000.png'
    			);
    		}
    	}
    }
    
    public function predioAction() {
        
    }
}