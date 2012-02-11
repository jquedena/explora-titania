<?php
require_once dirname(__FILE__).'/../../library/Log4PHP/Logger.php';

class ErrorController extends Zend_Controller_Action {

    private $_logger = null;
    
    public function __construct(Zend_Controller_Request_Abstract $request, Zend_Controller_Response_Abstract $response, array $invokeArgs = array()) {
        parent::__construct($request, $response, $invokeArgs);
        
        date_default_timezone_set(DATE_ZONE);
        Logger::configure(LOG_ERROR);
        $this->_logger = Logger::getLogger(__CLASS__);
    }
    
    public function errorAction() {
        $errors = $this->_getParam('error_handler');
        
        if (!$errors) {
            $this->view->message = 'Estas tratando de acceder a una p&aacute;gina de error.';
            $this->_logger->error("Estas tratando de acceder a una pagina de error.");
            return;
        }
        
        switch ($errors->type) {
            case Zend_Controller_Plugin_ErrorHandler::EXCEPTION_NO_ROUTE:
            case Zend_Controller_Plugin_ErrorHandler::EXCEPTION_NO_CONTROLLER:
            case Zend_Controller_Plugin_ErrorHandler::EXCEPTION_NO_ACTION:

                // 404 error -- controller or action not found
                $this->getResponse()->setHttpResponseCode(404);
                $this->view->message = 'P&aacute;gina no encontrada.';
                $this->_logger->error("Pagina no encontrada.");
                break;
            default:
                // application error
                $this->getResponse()->setHttpResponseCode(500);
                $this->view->message = 'Error en la Aplicaci&oacute;n';
                $this->_logger->error("Error en la aplicacion.");
                break;
        }

        $this->_logger->error($errors->type);
        $this->_logger->error($errors->exception->getMessage());
        $this->_logger->error($errors->exception->getTraceAsString());
        $this->_logger->error(var_export($errors->request->getParams(), true));
        
        // conditionally display exceptions
        if ($this->getInvokeArg('displayExceptions') == true) {
            $this->view->exception = $errors->exception;
        }

        $this->view->request = $errors->request;
    }
}

