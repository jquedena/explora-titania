<?php

class JsonController extends Zend_Controller_Action {

    public function init() {
    }

    public function indexAction() {
        $this->_helper->layout->disableLayout();
        $this->_helper->viewRenderer->setNoRender();
        $this->getResponse()->setHeader('Content-type', 'application/json');
        
        $name = $this->_request->getPost('name', '');
        $page = $this->_request->getPost('page', 1);
        $sidx = 1;
        $sord = 'asc';
        $limit = $this->_request->getPost('limit', 10);
        
        $query = new Model_DataJQGrid();
        echo $query->getDataTable($name, $page, $sidx, $sord, $limit);
    }

}

