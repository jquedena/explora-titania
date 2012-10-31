<?php
require_once 'Zend/Controller/Action.php';

class PanelController extends Zend_Controller_Action {

    public function init() {
    	$this->_helper->layout()->setLayout('layoutwithpanel');
    }
    
    public function indexAction() {
    }
    
    public function personaAction() {
        
    }
    
    public function predioAction() {
        
    }
}