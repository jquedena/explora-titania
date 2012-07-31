<?php

class Bootstrap extends Zend_Application_Bootstrap_Bootstrap {
    
    protected function __initSession() {
        Zend_Session::start();
    }

    protected function _initAutoload() {
        $options = $this->getOptions();

        $frontController = Zend_Controller_Front::getInstance();
        $frontController->registerPlugin(new Application_Plugin_Intercepor(Zend_Auth::getInstance(), $options['blackList'], $options['execute']));

        $moduleLoder = new Zend_Application_Module_Autoloader(array('namespace' => '', 'basePath' => APPLICATION_PATH ));
        return $moduleLoder;
    }

    protected function _initViewHelpers() {
        $this->bootstrap('layout');
        $layout = $this->getResource('layout');
        $view = $layout->getView();
        $view->doctype('HTML4_STRICT');
        $view->headMeta()
                ->appendHttpEquiv('Content-type', 'text/html;charset=utf-8')
                ->appendName('description', 'Explora TEC');
        $view->headTitle()->setSeparator(' - ')
                ->headTitle('Titania - Sistema Municipal de Administracion Tributaria - Explora TEC');

        Zend_Session::start();
    }
}

