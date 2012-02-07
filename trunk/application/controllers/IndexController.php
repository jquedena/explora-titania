<?php

class IndexController extends Zend_Controller_Action {

    public function init() {
        
    }

    public function indexAction() {
    }

    public function testAction() {
        echo $this->view->util()->getScriptJSController($this->getRequest());
    }

    public function testjsonAction() {
        $this->_helper->layout->disableLayout();
        $this->_helper->viewRenderer->setNoRender();
        $this->getResponse()->setHeader('Content-type', 'application/json');
        
        $query = new Model_DataAdapter();
        echo "{totalrows: 1000, page: 1, records: 20000, rows: ";
        echo $query->executeQueryToJSON("SELECT * FROM maccess");
        echo "}";
    }

}

