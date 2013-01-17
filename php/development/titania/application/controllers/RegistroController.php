<?php

require_once 'Zend/Controller/Action.php';

class RegistroController extends Zend_Controller_Action {

    public function init() {
    	$this->_helper->layout()->setLayout('layoutwithpanel');
    	$map = new Zend_Session_Namespace("map");
    	$map->data = true;
    }

    public function indexAction() {
        $this->view->util()->registerScriptJSControllerAction($this->getRequest());

        $parameters[] = date("Y");
        $dataAdapter = new Model_DataAdapter();
        $rows = $dataAdapter->executeAssocQuery("pl_function.listar_vias", $parameters);
        $this->view->mviascp = $rows;
    }

    public function listarpredioAction() {
        $this->_helper->getHelper('ajaxContext')->initContext();

        if ($this->getRequest()->isXmlHttpRequest()) {
            $this->_helper->layout->disableLayout();
            $name = $this->_request->getParam('name');

            if (isset($name)) {
                $dataSet = new Zend_Session_Namespace($name);
                $rows = $dataSet->data;

                $this->view->cidpers = $rows[0][0];
                $this->view->vnombre = $rows[0][1];
                $this->view->vdirecc = $rows[0][2];
                
                $this->_request->setParam('cidpers', $rows[0][0]);
            } else {
                $this->view->cidpers = $this->_request->getParam('cidpers');
                $this->view->vnombre = $this->_request->getParam('crazsoc');
                $this->view->vdirecc = $this->_request->getParam('direccf');
                
                $mhresum = $this->_request->getParam('mhresum');
                if (isset($mhresum)) {
	                $this->view->mhresum = $this->_request->getParam('mhresum');
	                $this->view->vnrodoc = $this->_request->getParam('vnrodoc');
                } else {
                	$parameters[] = $this->view->cidpers;
                	$dataAdapter = new Model_DataAdapter();
                	$rows = $dataAdapter->executeAssocQuery("pl_function.panel_persona", $parameters);
                	if(count($rows) == 1) {
                		$this->view->mhresum = $rows[0]['mhresum'];
                		$this->view->vnrodoc = $rows[0]['vnrodoc'];
                	}
                }
            }
        }
    }

    public function verpredioAction() {
        $this->_helper->getHelper('ajaxContext')->initContext();

        if ($this->getRequest()->isXmlHttpRequest()) {
            $this->_helper->layout->disableLayout();
            
            $this->view->mperson = $this->_request->getParam('mperson');
            $this->view->vnombre = $this->_request->getParam('vnombre');
            $this->view->vdirecf = $this->_request->getParam('vdirecf');
            $this->view->p_mhresum = $this->_request->getParam('mhresum');
            $this->view->p_mpredio = $this->_request->getParam('mpredio');
            $this->view->p_cperiod = $this->_request->getParam('cperiod');
            
            $parameters[] = $this->_request->getParam('mpredio');
            $parameters[] = $this->_request->getParam('mhresum'); 
            $parameters[] = $this->_request->getParam('cperiod');
            
            $dataAdapter = new Model_DataAdapter();
            $rows = $dataAdapter->executeAssocQuery("pl_function.ver_predio", $parameters);
            if(is_array($rows) && count($rows) > 0) {
	            $this->view->mpredio = $rows[0];
	            $parameters = array($rows[0]["dpredio"], $rows[0]["cperiod"]);
	            $dataAdapter->saveQuery("tblPiso", "pl_function.listar_construccion", $parameters);
	            $dataAdapter->saveQuery("tblInstalacion", "pl_function.listar_instalacion", $parameters);
	            $dataAdapter->saveQuery("tblLindero", "pl_function.listar_lindero", $parameters);
	            
	            $dataAdapter->saveQuery("tblRustico", "pl_function.listar_caracteristica_rustico", $parameters);
            }
        }
    }

    public function direccionAction() {
        $this->_helper->getHelper('ajaxContext')->initContext();

        if ($this->getRequest()->isXmlHttpRequest()) {
            $this->_helper->layout->disableLayout();
        }
    }

    public function declaracionAction() {
        $this->_helper->getHelper('ajaxContext')->initContext();

        if ($this->getRequest()->isXmlHttpRequest()) {
            $this->_helper->layout->disableLayout();
        }
    }

    public function condominioAction() {
        $this->_helper->getHelper('ajaxContext')->initContext();

        if ($this->getRequest()->isXmlHttpRequest()) {
            $this->_helper->layout->disableLayout();
        }
    }
    
    public function listardeclaracionAction() {
        $this->view->cidpers = $this->_request->getParam('cidpers');
    	$this->_helper->getHelper('ajaxContext')->initContext();
    	if ($this->getRequest()->isXmlHttpRequest()) {
    		$this->_helper->layout->disableLayout();
    	}
    }
    
    public function listarprediovalorAction() {
    	$this->view->mpredio = $this->_request->getParam('mpredio');
    	$this->view->mhresum = $this->_request->getParam('mhresum');
    	$this->view->cidpers = $this->_request->getParam('cidpers');
    }
    
    public function prediovalorAction() {
    	$this->_helper->layout->disableLayout();
    	$this->_helper->viewRenderer->setNoRender();
    		
    	$dataAdapter = new Model_DataAdapter();

    	$parameters[] = $this->_request->getParam('mpredio');
    	$parameters[] = $this->_request->getParam('mhresum');
    	$parameters[] = '-1';
    	$data['valorpredio'] = $dataAdapter->executeAssocQuery("pl_function.ver_predio", $parameters);

    	$parameters = array($this->_request->getParam('cidpers'));
    	$data['resumensaldo'] = $dataAdapter->executeAssocQuery("pl_function.resumen_saldo_personal", $parameters);
    		
    	echo $this->_helper->json($data);
    }
    
    public function verpisoAction() {
    	$this->_helper->getHelper('ajaxContext')->initContext();
    
    	if ($this->getRequest()->isXmlHttpRequest()) {
    		$this->_helper->layout->disableLayout();
    	}
    }
    
    public function verpisocaracteristicasAction() {
    	$this->_helper->getHelper('ajaxContext')->initContext();
    
    	if ($this->getRequest()->isXmlHttpRequest()) {
    		$this->_helper->layout->disableLayout();
    
    		$dataAdapter = new Model_DataAdapter();
    		$data['material'] = $dataAdapter->executeAssocQuery("pl_function.lista_caracteristica_piso", array('1000000161'));
    		$data['estado'] = $dataAdapter->executeAssocQuery("pl_function.lista_caracteristica_piso", array('1000000149'));
    		$data['banio'] = $dataAdapter->executeAssocQuery("pl_function.lista_caracteristica_piso", array('1000000283'));
    		$data['muro'] = $dataAdapter->executeAssocQuery("pl_function.lista_caracteristica_piso", array('1000000228'));
    		$data['piso'] = $dataAdapter->executeAssocQuery("pl_function.lista_caracteristica_piso", array('1000000250'));
    		$data['puerta'] = $dataAdapter->executeAssocQuery("pl_function.lista_caracteristica_piso", array('1000000261'));
    		$data['revestimiento'] = $dataAdapter->executeAssocQuery("pl_function.lista_caracteristica_piso", array('1000000272'));
    		$data['techo'] = $dataAdapter->executeAssocQuery("pl_function.lista_caracteristica_piso", array('1000000239'));
    		$data['instalacion'] = $dataAdapter->executeAssocQuery("pl_function.lista_caracteristica_piso", array('1000000294'));
    
    		echo $this->_helper->json($data);
    	}
    }
    
    public function verinstalacionAction() {
    	$this->_helper->getHelper('ajaxContext')->initContext();
    
    	if ($this->getRequest()->isXmlHttpRequest()) {
    		$this->_helper->layout->disableLayout();
    	}
    }
   
    public function impresionAction() {
    	$this->_helper->getHelper('ajaxContext')->initContext();
    
    	if ($this->getRequest()->isXmlHttpRequest()) {
    		$this->_helper->layout->disableLayout();
    	}
    }
    
    public function verlinderoAction() {
    	$this->_helper->getHelper('ajaxContext')->initContext();
    
    	if ($this->getRequest()->isXmlHttpRequest()) {
    		$this->_helper->layout->disableLayout();
    	}
    }
    
    public function verrusticoAction() {
    	$this->_helper->getHelper('ajaxContext')->initContext();
    
    	if ($this->getRequest()->isXmlHttpRequest()) {
    		$this->_helper->layout->disableLayout();
    	}
    }
    
}