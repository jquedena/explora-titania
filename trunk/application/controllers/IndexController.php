<?php

class IndexController extends Zend_Controller_Action {

    public function init() {
        
    }

    public function indexAction() {
    }

    public function testAction() {
        $this->view->util()->registerScriptJSController($this->getRequest());
        $query = new Model_DataAdapter();
        #echo "{total: 1000, page: 1, records: 20000, rows: ";
        echo "<script type='text/javascript'>";
        echo "var x=".$query->executeQueryToJSON("SELECT * FROM maccess");
        echo "</script>";
    }

    public function testjsonAction() {
        $this->_helper->layout->disableLayout();
        $this->_helper->viewRenderer->setNoRender();
        $this->getResponse()->setHeader('Content-type', 'application/json');
        
        $query = new Model_DataAdapter();
        echo $query->executeQueryToJSON("SELECT * FROM maccess");
    }

}

