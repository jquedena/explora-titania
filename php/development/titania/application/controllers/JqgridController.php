<?php

class JqgridController extends Zend_Controller_Action {

    public function init() { 
    }

    public function registrarAction() {
        $this->_helper->layout->disableLayout();
        $this->_helper->getHelper('ajaxContext')->initContext();

        if ($this->getRequest()->isXmlHttpRequest()) {
            $name = $this->_request->getParam('name');
            $procedure = $this->_request->getParam('procedure');
            $parameters = json_decode($this->_request->getParam('parameters'), true);

            $dataAdapter = new Model_DataAdapter();
            $records = $dataAdapter->saveQuery($name, $procedure, $parameters);

            $this->view->name = $name;
            $this->view->records = $records;
        }
    }

    public function seleccionarAction() {
        $this->_helper->layout->disableLayout();
        $this->_helper->getHelper('ajaxContext')->initContext();

        if ($this->getRequest()->isXmlHttpRequest()) {
            $name = $this->_request->getParam('name');
            $procedure = $this->_request->getParam('procedure');
            $parameters = json_decode($this->_request->getParam('parameters'), true);

            $dataAdapter = new Model_DataAdapter();
            $records = $dataAdapter->saveSelect($name, $procedure, $parameters);

            $this->view->name = $name;
            $this->view->records = $records;
        }
    }
    
    public function paginarAction() {
        $this->_helper->viewRenderer->setNoRender();
        $this->_helper->layout->disableLayout();
        $this->_helper->getHelper('ajaxContext')->initContext();

        if ($this->getRequest()->isXmlHttpRequest()) {
            $name = $this->_request->getParam('name');
            $page = $this->_request->getParam('page');
            $sidx = $this->_request->getParam('sidx');
            $sord = $this->_request->getParam('sord');
            $limit = $this->_request->getParam('rows');

            $dataSet = new Zend_Session_Namespace($name);
            $rows = $dataSet->data;
            $count = count($rows);

            if ($count > 0) {
                $total_pages = ceil($count / $limit);
            } else {
                $total_pages = 0;
            }

            if ($page > $total_pages)
                $page = $total_pages;

            $start = $limit * $page - $limit; // do not put $limit * ($page - 1)
            if ($start < 0)
                $start = 0;
            if (!$sidx)
                $sidx = 1;

            $responce->page = $page;
            $responce->total = $total_pages;
            $responce->records = $count;

            $i = 0;
            for ($i = $start; $i < $count; $i++) {
                $row = $rows[$i];
                $responce->rows[$i]['id'] = $i;
                $responce->rows[$i]['cell'] = $row;
            }

            echo json_encode($responce, JSON_HEX_TAG | JSON_HEX_APOS | JSON_HEX_QUOT | JSON_HEX_AMP);
        }
    }

}