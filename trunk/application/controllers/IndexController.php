<?php

class IndexController extends Zend_Controller_Action {

    public function init() {
        
    }

    public function indexAction() {
        echo $this->view->util()->getScriptJSController($this->getRequest());
    }

    public function testAction() {
    }

}

