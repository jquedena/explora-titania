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
            $print = $this->_request->getParam('print');
            $parameters = json_decode($this->_request->getParam('parameters'), true);
            $dataAdapter = new Model_DataAdapter();
            
            if($print == 'true') {
            	$rows = $dataAdapter->executeAssocQuery($procedure, $parameters);
            	$this->_helper->viewRenderer->setNoRender();
            	echo $this->_helper->json($rows);
            } else {
            	$records = $dataAdapter->saveQuery($name, $procedure, $parameters);
            	
            	$this->view->name = $name;
            	$this->view->records = $records;
            }
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

            $responce = new Model_JQGridResponce();
            $responce->page = $page;
            $responce->total = $total_pages;
            $responce->records = $count;
			//$limit2= ($count-$start > $limit ? $limit : $count-$start);
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