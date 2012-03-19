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
    
    public function pruebapgAction() {
        //$this->_helper->layout->disableLayout();
        //$this->_helper->viewRenderer->setNoRender();
		
    	echo $this->view->util()->getPath();
    	echo '<br><br><br>';
    	echo $this->view->util()->getPath2();
    	echo '<br><br><br>';
    	
        $func = 'tesoreria.buscar_concepto';
    	$param[] = '';
    	$param[] = ''; 

    	$cn = new Model_DataAdapter();
    	$datos = $cn->execute_pg($func, $param);
    	print_r($datos);
    	
    }

}

