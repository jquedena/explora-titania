<?php

class IndexController extends Zend_Controller_Action {

	public function init() {
	}

	public function indexAction() {
		$url = $this->view->util()->getPath();
		$ddatosuserlog = new Zend_Session_Namespace('datosuserlog');
		$coduser = $ddatosuserlog->cidpers;
		$nompers = $ddatosuserlog->nompers;

		if($coduser == '' || $coduser == null){
			$this->_redirect($url.'index.php/logeo/');
		}else{
			echo 'Bienvenido '.$nompers;
		}
	}
}