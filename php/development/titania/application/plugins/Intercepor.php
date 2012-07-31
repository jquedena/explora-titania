<?php
require_once dirname(__FILE__).'/../../library/Log4PHP/Logger.php';

class Application_Plugin_Intercepor extends Zend_Controller_Plugin_Abstract {

    private $_logger = null;
    private $_blackList = null;
    private $_auth = null;
    private $_execute = null;

    public function __construct(Zend_Auth $auth, array $blackList, array $execute) {
        date_default_timezone_set(DATE_ZONE);
        Logger::configure(LOG_ACCESS);
        
        $this->_logger = Logger::getLogger(__CLASS__);
        $this->_auth = $auth;
        $this->_blackList = $blackList;
        $this->_execute = $execute;
    }

    public function preDispatch(Zend_Controller_Request_Abstract $request) {
        
    	$controller = $request->getControllerName();
		$action = $request->getActionName();
		$resource = $controller.':'.$action;

        $auth = " [Acceso autorizado.]";
        
        $login = new Zend_Session_Namespace('datosuserlog');
        $nompers = $login->nompers;
        
        if(!in_array($resource, $this->_blackList) && ($nompers == '' || $nompers == null)) {
        	if($request->isXmlHttpRequest()) {
	        	$request->setControllerName('logeo')
	        			->setActionName('redirect');
        	} else {
        		$request->setControllerName('logeo')
        				->setActionName('index');
        	}
        	$auth = " [Acceso no autorizado.]";
        }
        
        if(strlen($login->codcajero)!=0 && in_array($controller, $this->_execute)) {
        	$nombrestore = 'tesoreria.verif_est_caja';
        	$arraydatos[]= $login->codcajero;
        	
        	$cn = new Model_DataAdapter();
        	$datos = $cn->ejec_store_procedura_sql($nombrestore, $arraydatos);
        	if(count($datos)) {
	        	if($datos[0][0]=='1' || $datos[0][0]=='3') {
	        		$mensaje = $datos[0][1];
	        	}else{
	        		$mensaje = $datos[0][1];
	        	}
        	} else {
        		$mensaje = 'Aperture su caja.';
        	}
        	$this->_logger->info($mensaje);
        	
        	if($mensaje != 'Ok') {
	        	$request->setControllerName('cajaflujo')
		        	->setActionName('aperturar')
		        	->setParam('mensaje', $mensaje);
        	}
        }
        
        $this->_logger->info($resource.$auth);
        
    }
}