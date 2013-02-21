<?php

require_once 'Zend/Controller/Action.php';

class RegistroController extends Zend_Controller_Action {

    public function init() {
    	$this->_helper->layout()->setLayout('layoutwithpanel');
    	$map = new Zend_Session_Namespace("map");
    	$map->data = false;
    }

    public function indexAction() {
        $this->view->util()->registerScriptJSControllerAction($this->getRequest());

        // TODO: Para pruebas
        $parameters[] = date("Y") -1;
        $dataAdapter = new Model_DataAdapter();
        $rows = $dataAdapter->executeAssocQuery("pl_function.listar_vias", $parameters);
        $this->view->mviascp = $rows;
    }

    public function listarpredioAction() {
        $this->_helper->getHelper('ajaxContext')->initContext();

        if ($this->getRequest()->isXmlHttpRequest()) {
            $this->_helper->layout->disableLayout();
            $name = $this->_request->getParam('name');

            if (isset($name)) {
                $dataSet = new Zend_Session_Namespace($name);
                $rows = $dataSet->data;

                $this->view->cidpers = $rows[0][0];
                $this->view->vnombre = $rows[0][1];
                $this->view->vdirecc = $rows[0][2];
                
                $this->_request->setParam('cidpers', $rows[0][0]);
            } else {
                $this->view->cidpers = $this->_request->getParam('cidpers');
                $this->view->vnombre = $this->_request->getParam('crazsoc');
                $this->view->vdirecc = $this->_request->getParam('direccf');
                
                $mhresum = $this->_request->getParam('mhresum');
                if (isset($mhresum)) {
	                $this->view->mhresum = $this->_request->getParam('mhresum');
	                $this->view->vnrodoc = $this->_request->getParam('vnrodoc');
                } else {
                	$parameters[] = $this->view->cidpers;
                	$dataAdapter = new Model_DataAdapter();
                	$rows = $dataAdapter->executeAssocQuery("pl_function.panel_persona", $parameters);
                	if(count($rows) == 1) {
                		$this->view->mhresum = $rows[0]['mhresum'];
                		$this->view->vnrodoc = $rows[0]['vnrodoc'];
                	}
                }
            }
        }
    }

    public function verpredioAction() {
        $this->_helper->getHelper('ajaxContext')->initContext();

        if ($this->getRequest()->isXmlHttpRequest()) {
            $this->_helper->layout->disableLayout();
            
            $this->view->mperson = $this->_request->getParam('mperson');
            $this->view->vnombre = $this->_request->getParam('vnombre');
            $this->view->vdirecf = $this->_request->getParam('vdirecf');
            $this->view->p_mhresum = $this->_request->getParam('mhresum');
            $this->view->p_mpredio = $this->_request->getParam('mpredio');
            $this->view->p_cperiod = $this->_request->getParam('cperiod');
            
            $parameters[] = $this->_request->getParam('mpredio');
            $parameters[] = $this->_request->getParam('mhresum'); 
            $parameters[] = $this->_request->getParam('cperiod');
            
            $dataAdapter = new Model_DataAdapter();
            $rows = $dataAdapter->executeAssocQuery("pl_function.ver_predio", $parameters);
            if(is_array($rows) && count($rows) > 0) {
	            $this->view->mpredio = $rows[0];
	            $parameters = array($rows[0]["dpredio"], $rows[0]["cperiod"]);
	            $dataAdapter->saveQuery("tblPiso", "pl_function.listar_construccion", $parameters);
	            $dataAdapter->saveQuery("tblInstalacion", "pl_function.listar_instalacion", $parameters);
	            $dataAdapter->saveQuery("tblLindero", "pl_function.listar_lindero", $parameters);
	            $dataAdapter->saveQuery("tblRustico", "pl_function.listar_caracteristica_rustico", $parameters);
            }
        }
    }

    public function direccionAction() {
        $this->_helper->getHelper('ajaxContext')->initContext();

        if ($this->getRequest()->isXmlHttpRequest()) {
            $this->_helper->layout->disableLayout();
        }
    }

    public function declaracionAction() {
        $this->_helper->getHelper('ajaxContext')->initContext();

        if ($this->getRequest()->isXmlHttpRequest()) {
            $this->_helper->layout->disableLayout();
        }
    }

    public function condominioAction() {
        $this->_helper->getHelper('ajaxContext')->initContext();

        if ($this->getRequest()->isXmlHttpRequest()) {
            $this->_helper->layout->disableLayout();
        }
    }
    
    public function listardeclaracionAction() {
        $this->view->cidpers = $this->_request->getParam('cidpers');
    	$this->_helper->getHelper('ajaxContext')->initContext();
    	if ($this->getRequest()->isXmlHttpRequest()) {
    		$this->_helper->layout->disableLayout();
    	}
    }
    
    public function listarprediovalorAction() {
    	$this->view->mpredio = $this->_request->getParam('mpredio');
    	$this->view->mhresum = $this->_request->getParam('mhresum');
    	$this->view->cidpers = $this->_request->getParam('cidpers');
    }
    
    public function prediovalorAction() {
    	$this->_helper->layout->disableLayout();
    	$this->_helper->viewRenderer->setNoRender();
    		
    	$dataAdapter = new Model_DataAdapter();

    	$parameters[] = $this->_request->getParam('mpredio');
    	$parameters[] = $this->_request->getParam('mhresum');
    	$parameters[] = '-1';
    	$data['valorpredio'] = $dataAdapter->executeAssocQuery("pl_function.ver_predio", $parameters);

    	$parameters = array($this->_request->getParam('cidpers'));
    	$data['resumensaldo'] = $dataAdapter->executeAssocQuery("pl_function.resumen_saldo_personal", $parameters);
    		
    	echo $this->_helper->json($data);
    }
    
    public function verpisoAction() {
    	$this->_helper->getHelper('ajaxContext')->initContext();
    
    	if ($this->getRequest()->isXmlHttpRequest()) {
    		$this->_helper->layout->disableLayout();
    	}
    }
    
    public function verpisocaracteristicasAction() {
    	$this->_helper->getHelper('ajaxContext')->initContext();
    
    	if ($this->getRequest()->isXmlHttpRequest()) {
    		$this->_helper->layout->disableLayout();
    
    		$dataAdapter = new Model_DataAdapter();
    		$data['material'] = $dataAdapter->executeAssocQuery("pl_function.lista_caracteristica_piso", array('1000000161'));
    		$data['estado'] = $dataAdapter->executeAssocQuery("pl_function.lista_caracteristica_piso", array('1000000149'));
    		$data['banio'] = $dataAdapter->executeAssocQuery("pl_function.lista_caracteristica_piso", array('1000000283'));
    		$data['muro'] = $dataAdapter->executeAssocQuery("pl_function.lista_caracteristica_piso", array('1000000228'));
    		$data['piso'] = $dataAdapter->executeAssocQuery("pl_function.lista_caracteristica_piso", array('1000000250'));
    		$data['puerta'] = $dataAdapter->executeAssocQuery("pl_function.lista_caracteristica_piso", array('1000000261'));
    		$data['revestimiento'] = $dataAdapter->executeAssocQuery("pl_function.lista_caracteristica_piso", array('1000000272'));
    		$data['techo'] = $dataAdapter->executeAssocQuery("pl_function.lista_caracteristica_piso", array('1000000239'));
    		$data['instalacion'] = $dataAdapter->executeAssocQuery("pl_function.lista_caracteristica_piso", array('1000000294'));
    
    		echo $this->_helper->json($data);
    	}
    }
    
    public function verinstalacionAction() {
    	$this->_helper->getHelper('ajaxContext')->initContext();
    
    	if ($this->getRequest()->isXmlHttpRequest()) {
    		$this->_helper->layout->disableLayout();
    	}
    }
   
    public function impresionAction() {
    	$this->_helper->getHelper('ajaxContext')->initContext();
    
    	if ($this->getRequest()->isXmlHttpRequest()) {
    		$this->_helper->layout->disableLayout();
    	}
    }
    
    public function verlinderoAction() {
    	$this->_helper->getHelper('ajaxContext')->initContext();
    	
    	if ($this->getRequest()->isXmlHttpRequest()) {
    		$this->_helper->layout->disableLayout();
    	}
    }
    

    public function verrusticoAction() {
    	$this->_helper->getHelper('ajaxContext')->initContext();
    
    	if ($this->getRequest()->isXmlHttpRequest()) {
    		$this->_helper->layout->disableLayout();
    	}
    }
    
    public function linderoAction() {
        	$this->_helper->getHelper('ajaxContext')->initContext();
    
    	if ($this->getRequest()->isXmlHttpRequest()) {
    		$this->_helper->layout->disableLayout();
    	}
    }
    
    public function guardarlinderoAction() {
    	$this->_helper->getHelper('ajaxContext')->initContext();
    
    	if ($this->getRequest()->isXmlHttpRequest()) {
    		$this->_helper->layout->disableLayout();

    		$ddatosuserlog = new Zend_Session_Namespace('datosuserlog');
    		$coduser = $ddatosuserlog->cidpers;
    		$vhostnm = $ddatosuserlog->vhostnm;
    		
    		/*
    		idsigma character varying,
    		cptocar character varying,
    		ctiplin character varying,
    		ccodpre character varying,
    		vdirecc character varying,
    		mperson character varying,
    		dpredio character varying,
    		vusernm character varying,
    		vhostnm character varying,
    		ddatetm timestamp without time zone
    		*/
    		
			$row = $_POST['idsigma'].','
				.$_POST['cptocar'].','
				.$_POST['ctiplin'].','
				.$_POST['ccodpre'].','
				.$_POST['vdirecc'].','
				.$_POST['mperson'].','
				.$_POST['dpredio'].','
				.$coduser.','
				.$vhostnm.',';
					
			$parameters[] = $row;
			$dataAdapter = new Model_DataAdapter();
    		$rows = $dataAdapter->executeSelect("pl_function.guardar_mlindero", $parameters);
			
    		if($rows[0][0] == 1) {
    			$parameters = array($_POST['dpredio'], $_POST["cperiod"]);

    			$data['error'] = "";
    			$data['data'] = $dataAdapter->executeAssocQuery("pl_function.listar_lindero", $parameters);
    		} else {
    			$data['error'] = "Error al actualizar";
    			$data['data'] = "";
    		}
    		
    		$this->_helper->json($data);
    	}
    }
    
    /*
    public function guardarrusticoAction() {
    	$this->_helper->getHelper('ajaxContext')->initContext();
    
    	if ($this->getRequest()->isXmlHttpRequest()) {
    		$this->_helper->layout->disableLayout();
    
    		$ddatosuserlog = new Zend_Session_Namespace('datosuserlog');
    		$coduser = $ddatosuserlog->cidpers;
    		$vhostnm = $ddatosuserlog->vhostnm;
    

    
    		$row = $_POST['idsigma'].','
    				.$_POST['cptocar'].','
    				.$_POST['ctiplin'].','
    				.$_POST['ccodpre'].','
    				.$_POST['vdirecc'].','
    				.$_POST['mperson'].','
    				.$_POST['dpredio'].','
    				.$coduser.','
    				.$vhostnm.',';
    			
    		$parameters[] = $row;
    		$dataAdapter = new Model_DataAdapter();
    		$rows = $dataAdapter->executeSelect("pl_function.guardar_mlindero", $parameters);
    			
    		if($rows[0][0] == 1) {
    			$parameters = array($_POST['dpredio'], $_POST["cperiod"]);
    
    			$data['error'] = "";
    			$data['data'] = $dataAdapter->executeAssocQuery("pl_function.listar_lindero", $parameters);
    		} else {
    			$data['error'] = "Error al actualizar";
    			$data['data'] = "";
    		}
    
    		$this->_helper->json($data);
    	}
    }*/

    public function guardarpisoAction() {
    	$this->_helper->getHelper('ajaxContext')->initContext();
    
    	if ($this->getRequest()->isXmlHttpRequest()) {
    		$this->_helper->layout->disableLayout();
    
    		$ddatosuserlog = new Zend_Session_Namespace('datosuserlog');
    		$coduser = $ddatosuserlog->cidpers;
    		$vhostnm = $ddatosuserlog->vhostnm;
     
    		$row = $_POST['idsigma'].','
    				.$_POST['dpredio'].','
    				.$_POST['cnitems'].','
    				.$_POST['cnumpis'].','
    				.$_POST['cmescon'].','
    				.$_POST['canocon'].','
    				.$_POST['cmateri'].','
    				.$_POST['cconser'].','
    				.$_POST['cmurcol'].','
    				.$_POST['ctechos'].','
    				.$_POST['cmpisos'].','
    				.$_POST['cpueven'].','
    				.$_POST['crevest'].','
    				.$_POST['cbanios'].','
    				.$_POST['celectr'].','
    				.$_POST['narecom'].','
    				.$_POST['nporcom'].','
    				.$_POST['nestado'].','
    				.$vhostnm.','
    				.$coduser.','
    				.$_POST['narecon'].',';
    		 echo $row;
    		$parameters[] = $row;
    		$dataAdapter = new Model_DataAdapter();
    		$rows = $dataAdapter->executeSelect("pl_function.guardar_mconstr", $parameters);
    		 
    		if($rows[0][0] == 1) {
    			$parameters = array($_POST['dpredio'], $_POST["cperiod"]);
    
    			$data['error'] = "";
    			$data['data'] = $dataAdapter->executeAssocQuery("pl_function.listar_construccion", $parameters);
    		} else {
    			$data['error'] = "Error al actualizar";
    			$data['data'] = "";
    		}
    
    		$this->_helper->json($data);
    	}
	}  

	
	
	/*
	public function guardarinstalacionAction() {
		$this->_helper->getHelper('ajaxContext')->initContext();
	
		if ($this->getRequest()->isXmlHttpRequest()) {
			$this->_helper->layout->disableLayout();
	
			$ddatosuserlog = new Zend_Session_Namespace('datosuserlog');
			$coduser = $ddatosuserlog->cidpers;
			$vhostnm = $ddatosuserlog->vhostnm;
			
			   --Faltan--
			  cmateri character varying(10) NOT NULL, -- Material
			  cconser character varying(10) NOT NULL, -- Estado de conservacion
			  cmurcol character varying(10) NOT NULL, -- Muros y columnas
			  ctechos character varying(10) NOT NULL, -- Techos
			  cmpisos character varying(10) NOT NULL, -- Pisos
			  cpueven character varying(10) NOT NULL, -- Puertas y ventanas
			  crevest character varying(10) NOT NULL, -- Revestimientos
			  cbanios character varying(10) NOT NULL, -- Sanitarios
			  celectr character varying(10) NOT NULL, -- Instalaciones electricas
			  
			  narecom numeric(10,5) NOT NULL, -- Area comun
			  nporcom numeric(10,5) NOT NULL, -- Porcentaje de area comun
			  nestado integer NOT NULL, -- Estado del registro
			  vhostnm character varying(25) NOT NULL, -- Estacion
			  vusernm character varying(25) NOT NULL, -- Usuario
			  ddatetm timestamp without time zone NOT NULL, -- Fecha de Registro

	
			$row = $_POST['idsigma'].','
					.$_POST['dpredio'].','
					.$_POST['cnumpis'].','
					.$_POST['canocon'].','
					.$_POST['ctipins'].','
					.$_POST['nvalanc'].','
					.$_POST['nvalalt'].','
					.$_POST['nvallar'].','
					.$_POST['vdesint'].','
					.$_POST[''].','
					.$_POST[''].','
					.$_POST[''].','
					.$_POST[''].','
					.$_POST[''].','
					.$_POST[''].','
					.$_POST[''].','
					.$_POST[''].','
					.$_POST[''].','
					.$_POST[''].','
					.$_POST[''].','
					.$_POST[''].','
					.$_POST[''].','
					.$coduser.','
					.$vhostnm.',';
				
			$parameters[] = $row;
			$dataAdapter = new Model_DataAdapter();
			$rows = $dataAdapter->executeSelect("pl_function.guardar_mlindero", $parameters);
				
			if($rows[0][0] == 1) {
				$parameters = array($_POST['dpredio'], $_POST["cperiod"]);
	
				$data['error'] = "";
				$data['data'] = $dataAdapter->executeAssocQuery("pl_function.listar_lindero", $parameters);
			} else {
				$data['error'] = "Error al actualizar";
				$data['data'] = "";
			}
	
			$this->_helper->json($data);
		}
	}
	*/

}  

