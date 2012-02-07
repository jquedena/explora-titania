<?php

class IndexController extends Zend_Controller_Action {

    public function init() {
        
    }

    public function indexAction() {
        echo $this->view->util()->getScriptJSController($this->getRequest());
    }

    public function testAction() {
    	$query = new Model_DataAdapter();
    	echo $query->getConnection();
    }

}

