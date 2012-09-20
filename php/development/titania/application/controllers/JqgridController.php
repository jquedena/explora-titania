<?php

class JqgridController extends Zend_Controller_Action {

	public function init() {
	}

	public function registarAction() {
		$this->_helper->layout->disableLayout();
		$this->_helper->getHelper('ajaxContext')->initContext();
		
		// if ($this->getRequest()->isXmlHttpRequest()) {
			$name = $this->_request->getParam('name');
			$procedure = $this->_request->getParam('procedure');
			$parameters = json_decode($this->_request->getParam('parameters'), true);
			
			$dataAdapter = new Model_DataAdapter();
			$dataAdapter->saveQuery($name, $function, $parameters);
			
			$this->view->$name = $name;
		//}
	}

	public function paginarAction() {
		$this->_helper->viewRenderer->setNoRender();
		$this->_helper->layout->disableLayout();
		$this->_helper->getHelper('ajaxContext')->initContext();
	
		//if ($this->getRequest()->isXmlHttpRequest()) {
			$page = $this->_request->getParam('page');
			$sidx = $this->_request->getParam('sidx');
			$sord = $this->_request->getParam('sord');
			$limit = $this->_request->getParam('limit');
			
			$procedure = trim($this->_request->getParam('procedure'));
			$parameters = json_decode(trim($this->_request->getParam('parameters')), true);
		
			$dataAdapter = new Model_DataAdapter();
			$rows = $dataAdapter->executeAssocQuery($procedure, $parameters);
			if($rows != null) {
				echo json_encode($rows);
			}
		//}
	}
}