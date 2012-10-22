<?php

class UtilController extends Zend_Controller_Action {

    public function init() {
    }

    public function combocontenedorAction() {
        $this->_helper->viewRenderer->setNoRender();
        $this->_helper->layout->disableLayout();
        $this->_helper->getHelper('ajaxContext')->initContext();

        if ($this->getRequest()->isXmlHttpRequest()) {
            $procedure = 'public.obtener_tabla';
            $parameters[0] = $this->_request->getParam('idsigma');
            $dataAdapter = new Model_DataAdapter();
            $records = $dataAdapter->ejec_store_procedura_sql($procedure, $parameters);
            echo json_encode($records);
        }
    }
}
