<?php
require_once dirname(__FILE__).'/../../library/Log4PHP/Logger.php';

class Application_Plugin_Intercepor extends Zend_Controller_Plugin_Abstract {

    private $_logger = null;
    private $_blackList = null;
    private $_auth = null;

    public function __construct(Zend_Auth $auth, array $blackList) {
        date_default_timezone_set("America/Lima");
        Logger::configure(APPLICATION_PATH.'/../public/properties/access_daily.properties');
        
        $this->_logger = Logger::getLogger(__CLASS__);
        $this->_auth = $auth;
        $this->_blackList = $blackList;
    }

    public function preDispatch(Zend_Controller_Request_Abstract $request) {
        $controller = $request->getControllerName();
	$action = $request->getActionName();
	$resource = $controller.':'.$action;

        $this->_logger->info($resource);
    }
}