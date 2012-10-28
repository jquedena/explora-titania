<?php

require_once 'Zend/Controller/Action.php';

class RegistroController extends Zend_Controller_Action {

    public function init() {
    	$this->_helper->layout()->setLayout('layoutwithpanel');
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
            } else {
                $this->view->cidpers = $this->_request->getParam('cidpers');
                $this->view->vnombre = $this->_request->getParam('crazsoc');
                $this->view->vdirecc = $this->_request->getParam('direccf');
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
            $parameters[] = $this->_request->getParam('mpredio');

            $dataAdapter = new Model_DataAdapter();
            $rows = $dataAdapter->executeAssocQuery("pl_function.ver_predio", $parameters);
            $this->view->mpredio = $rows[0];
            
            $parameters = array($rows[0]["dpredio"]);
            $dataAdapter->saveQuery("tblPiso", "pl_function.listar_construccion", $parameters);
            $dataAdapter->saveQuery("tblInstalacion", "pl_function.listar_instalacion", $parameters);
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
}