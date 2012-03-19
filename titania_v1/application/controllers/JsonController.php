<?php

class JsonController extends Zend_Controller_Action {

    public function init() {
    }

    public function indexAction() {
        $this->_helper->layout->disableLayout();
        $this->_helper->viewRenderer->setNoRender();
        $this->getResponse()->setHeader('Content-type', 'application/json');
        
        $name = $this->_request->getGet('name', '');
        $page = $this->_request->getGet('page', 1);
        $sidx = 1;
        $sord = 'asc';
        $limit = $this->_request->getGet('rows', 10);
        
        $query = new Model_DataJQGrid();
        echo $query->getDataTable($name, $page, $sidx, $sord, $limit);
    }

}

