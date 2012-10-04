<?php

require_once 'Zend/Controller/Action.php';

class RegistroController extends Zend_Controller_Action {

    public function init() {
    }

    public function indexAction() {
        $this->view->util()->registerScriptJSControllerAction($this->getRequest());
    }

    public function listarpredioAction() {
        $this->_helper->layout->disableLayout();
        $this->_helper->getHelper('ajaxContext')->initContext();

        if ($this->getRequest()->isXmlHttpRequest()) {
            $this->view->util()->registerScriptJSControllerAction($this->getRequest());

            $name = $this->_request->getParam('name');
            $dataSet = new Zend_Session_Namespace($name);
            $rows = $dataSet->data;

            $this->view->cidpers = $rows[0][0];
            $this->view->vnombre = $rows[0][1];
            $this->view->vdirecc = $rows[0][2];
        }
    }
}