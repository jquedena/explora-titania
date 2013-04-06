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
    	 $this->view->util()->registerScriptJSControllerAction($this->getRequest());
    	  
        $this->_helper->getHelper('ajaxContext')->initContext();
		
         $pintar= new Libreria_Pintar();
         
        if ($this->getRequest()->isXmlHttpRequest()) {
            $this->_helper->layout->disableLayout();
            $this->view->mperson = $this->_request->getParam('mperson');
            $this->view->mhresum = $this->_request->getParam('mhresum');
            $this->view->cperiod = date("Y");
            
            
           
            
            
            
            
            
        }
       // $pintar->EjecutarFuncion($fun);
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
    		$data['material'] = $dataAdapter->executeAssocQuery("pl_function.listar_caracteristica_piso", array('1000000161'));
    		$data['estado'] = $dataAdapter->executeAssocQuery("pl_function.listar_caracteristica_piso", array('1000000149'));
    		$data['banio'] = $dataAdapter->executeAssocQuery("pl_function.listar_caracteristica_piso", array('1000000283'));
    		$data['muro'] = $dataAdapter->executeAssocQuery("pl_function.listar_caracteristica_piso", array('1000000228'));
    		$data['piso'] = $dataAdapter->executeAssocQuery("pl_function.listar_caracteristica_piso", array('1000000250'));
    		$data['puerta'] = $dataAdapter->executeAssocQuery("pl_function.listar_caracteristica_piso", array('1000000261'));
    		$data['revestimiento'] = $dataAdapter->executeAssocQuery("pl_function.listar_caracteristica_piso", array('1000000272'));
    		$data['techo'] = $dataAdapter->executeAssocQuery("pl_function.listar_caracteristica_piso", array('1000000239'));
    		$data['instalacion'] = $dataAdapter->executeAssocQuery("pl_function.listar_caracteristica_piso", array('1000000294'));
    
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
     
    		/*
    		 * 
    		 * 	  idsigma,dpredio,cnitems::integer,cnumpis,
	  cmescon,canocon,cmateri,cconser,cmurcol,
	  ctechos,cmpisos,cpueven,crevest,cbanios,
	  celectr, narecom::numeric(18,5),
	  nporcom::numeric(18,5),nestado::integer,
	  vhostnm,vusernm,
	  now()::timestamp without time zone ddatetm,
	  narecon::numeric(10,5)
    		 * */
    		print_r($_POST);
    		
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
    				.date("y-m-d").','
    				.$_POST['narecon'];

    		$parameters[] = $row;
    		$dataAdapter = new Model_DataAdapter();
    		$rows = $dataAdapter->executeSelect("pl_function.guardar_mconstr", $parameters);

    		 print($row);
    		
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

	public function guardarinstalacionAction() {
		$this->_helper->getHelper('ajaxContext')->initContext();
	
		if ($this->getRequest()->isXmlHttpRequest()) {
			$this->_helper->layout->disableLayout();
	
			$ddatosuserlog = new Zend_Session_Namespace('datosuserlog');
			$coduser = $ddatosuserlog->cidpers;
			$vhostnm = $ddatosuserlog->vhostnm;

			$row = $_POST['idsigma'].','
					.$_POST['dpredio'].','
					.$_POST['cnumpis'].','
					.$_POST['canocon'].','
					.'0000000001'.',' //INSTALACION-
					.$_POST['nvalanc'].','
					.$_POST['nvalalt'].','
					.$_POST['nvallar'].','
					.$_POST['ctipint'].','		
					.$_POST['vdesint'].','
					.'0'.',' //cmateri
					.'0'.',' //cconser
					.'0'.',' //cmurcol
					.'0'.',' //ctechos
					.'0'.',' //cmpisos
					.'0'.',' //cpueven
					.'0'.',' //crevest
					.'0'.',' //cbanios
					.'0'.',' //celectr
					.'0'.',' //narecom
					.'0'.',' //nporcom
					.'1'.',' //nestado
					.$vhostnm.','
					.$coduser.','
					.date("y-m-d"); //fecha
			echo $row ;
			$parameters[] = $row;
			$dataAdapter = new Model_DataAdapter();
			$rows = $dataAdapter->executeSelect("pl_function.guardar_minstal", $parameters);
	
			if($rows[0][0] == 1) {		
    			$parameters = array($_POST['dpredio'], $_POST["cperiod"]);
    									
				$data['error'] = "";
				$data['data'] = $dataAdapter->executeAssocQuery("pl_function.listar_instalacion", $parameters);
			} else {
				$data['error'] = "Error al actualizar";
				$data['data'] = "";
			}
	
			$this->_helper->json($data);
		}
	}
	
	public function guardarDeclaracion() {
		/*
		idsigma character varying(10) NOT NULL,
		ctipdat character(10) NOT NULL,
		vnrodoc character varying(50) NOT NULL,
		dfecdoc timestamp without time zone NOT NULL,
		cmotivo character(10) NOT NULL,
		ctipdoc character(10) NOT NULL,
		vnrodjj character varying(50) NOT NULL,
		vobserv character varying(500) NOT NULL,
		nestado integer NOT NULL,
		vhostnm character varying(25) NOT NULL,
		vusernm character varying(25) NOT NULL,
		ddatetm timestamp without time zone NOT NULL,
		cperini character(4) NOT NULL,
		cperfin character(4) NOT NULL,
		mperson character(10) NOT NULL,
		*/
		$this->_helper->getHelper('ajaxContext')->initContext();
		
		if ($this->getRequest()->isXmlHttpRequest()) {
			$this->_helper->layout->disableLayout();		

			$ddatosuserlog = new Zend_Session_Namespace('datosuserlog');
			$coduser = $ddatosuserlog->cidpers;
			$vhostnm = $ddatosuserlog->vhostnm;
			
			$row = $_POST["idsigma"].','.
				   $_POST["ctipdat"].','.
				   $_POST["vnrodoc"].','.
				   $_POST["dfecdoc"].','.
				   $_POST["cmotivo"].','.
				   $_POST["ctipdoc"].','.
				   $_POST["vnrodjj"].','.
				   $_POST["vobserv"].','.
				   $_POST["nestado"].','.
				   $vhostnm.','.
				   $coduser.',,'.
				   $_POST["cperini"].','.
				   $_POST["cperfin"].','.
				   $_POST["mperson"];
			
			$parameters[] = $row;
			$dataAdapter = new Model_DataAdapter();
			$rows = $dataAdapter->executeSelect("pl_function.guardar_mhresum", $parameters);
			
					
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
		 
	public function guardardetalleAction(){
		/*
		idsigma character varying(10) NOT NULL, -- Identificador de las caracteristicas del predio
		mpredio character(10) NOT NULL, -- Identificador del predio
		ctippre character(10) NOT NULL, -- Tipo de predio
		cclasif character(10) NOT NULL, -- Clasificacion del predio
		ccondic character(10) NOT NULL, -- Condicion del predio
		cestado character(10) NOT NULL, -- Estado de construccion
		cusogen character(10) NOT NULL, -- Uso generico
		cusoesp character(10) NOT NULL, -- Uso especifico
		nporcen numeric(10,2) NOT NULL, -- Porcentaje de condiminante
		ntertot numeric(18,5) NOT NULL, -- Area total del terreno del predio
		nporter numeric(10,2) NOT NULL, -- Porcentaje de area de terreno
		nterren numeric(18,5) NOT NULL, -- Area total del terreno - Base para el calculo
		ncomtot numeric(18,5) NOT NULL, -- Area comun total del predio
		nporcom numeric(10,2) NOT NULL, -- Porcentaje de area comun
		narecom numeric(18,5) NOT NULL, -- Area comun total - Base para el calculo
		nporafe numeric(10,2) NOT NULL, -- Porcentaje afecto
		dfecadq timestamp without time zone NOT NULL, -- Fecha de adquisición del predio
		dfecdes timestamp without time zone, -- Fecha de descargo del predio
		dafecta timestamp without time zone, -- Fecha desde donde se comienzan a generar los tributos
		nfrente numeric(18,5) NOT NULL, -- Frontis del predio
		ncanper integer NOT NULL, -- Cantidad de personas que habita el predio
		ctippar character(10) NOT NULL, -- Tipo de parque
		vobserv character varying(500) NOT NULL, -- Observaciones
		nestado integer NOT NULL, -- Estado del registro
		vhostnm character varying(25) NOT NULL, -- Estacion
		vusernm character varying(25) NOT NULL, -- Usuario
		ddatetm timestamp without time zone NOT NULL, -- Fecha de Registro
		dfectra timestamp with time zone, -- Fecha de transferencia
		cnotari character varying(100), -- Notaria donde se registra la transferencia
  		ctiptra character varying(500), -- Tipo de transferencia
  		cpartid character varying(50), -- Nro de partida de la transferencia
  		csubtip character varying(10), -- Tipo de predio urbano o rustico
  		cmotadq character varying(10), -- Motivo de adquisicion
  		mhresum character(10) NOT NULL,
		*/
		
		$this->_helper->getHelper('ajaxContext')->initContext();
		
		if ($this->getRequest()->isXmlHttpRequest()) {
			$this->_helper->layout->disableLayout();
		
			$ddatosuserlog = new Zend_Session_Namespace('datosuserlog');
			$coduser = $ddatosuserlog->cidpers;
			$vhostnm = $ddatosuserlog->vhostnm;
				
			$row =  $_POST["idsigma"].','.
					$_POST["mpredio"].','.
					$_POST["ctippre"].','.
					$_POST["cclasif"].','.
					$_POST["ccondic"].','.				
					$_POST["cestado"].','.
					$_POST["cusogen"].','.
					$_POST["cusoesp"].','.
					$_POST["nporcen"].','.
					$_POST["ntertot"].','.
					$_POST["nporter"].','.
					$_POST["nterren"].','.
					$_POST["ncomtot"].','.
					$_POST["nporcom"].','.
					$_POST["narecom"].','.
					$_POST["nporafe"].','.
					$_POST["dfecdes"].','.
					$_POST["dfecadq"].','.					
					$_POST["dafecta"].','.
					$_POST["nfrente"].','.					
					$_POST["ncanper"].','.
					$_POST["ctippar"].','.
					$_POST["vobserv"].','.
					$_POST["nestado"].','.
					$vhostnm.','.
				    $coduser.','.
					date("y-m-d").','.
					date("y-m-d").','.
					"".','.
					"".','.
					"".','.
					"".','.
					"".','.
					$_POST["mhresum"];
				
				
			$parameters[] = $row;
			$dataAdapter = new Model_DataAdapter();
			$rows = $dataAdapter->executeSelect("pl_function.guardar_dpredio", $parameters);
		
			if($rows[0][0] == 1) {
				//$parameters = array($_POST['dpredio'], $_POST["cperiod"]);
					
				$data['error'] = "";
				//$data['data'] = $dataAdapter->executeAssocQuery("pl_function.listar_construccion", $parameters);
			} else {
				$data['error'] = "Error al actualizar";
				$data['data'] = "";
			}
				
			$this->_helper->json($data);
		}
			
		
	}
	
	public function prediomantenAction(){

	    $this->view->util()->registerScriptJSControllerAction($this->getRequest());
				        
    
		
	}
	
	public function verprediomanttAction(){
	$this->_helper->getHelper('ajaxContext')->initContext();
    
        if ($this->getRequest()->isXmlHttpRequest()) {
            $this->_helper->layout->disableLayout();

            $pintar = new Libreria_Pintar();
            $parameters[] = date("Y") -1;

            $dataAdapter = new Model_DataAdapter();
            $rows = $dataAdapter->executeAssocQuery("pl_function.listar_vias", $parameters);
            $this->view->mviascp = $rows;            
        

     }
    }

     public function guardarmpredioAction(){
          /*
          idsigma character(10) NOT NULL, -- Identificador del predio
          mviadis character(10) NOT NULL, -- Codigo de la via
          dnumero character varying(25) NOT NULL, -- Numero
          dinteri character varying(25) NOT NULL, -- Interior
          dletras character varying(25) NOT NULL, -- Letra
          ddepart character varying(25) NOT NULL, -- Departamento
          destaci character varying(25) NOT NULL, -- Estacionamiento
          ddeposi character varying(25) NOT NULL, -- Deposito
          drefere character varying(100) NOT NULL, -- Referencia
          dmanzan character varying(25) NOT NULL, -- Manzana
          dnlotes character varying(25) NOT NULL, -- Lote
          ccatast character varying(25) NOT NULL, -- Codigo Catastral
          cplanos character varying(4) NOT NULL, -- Ubicacion en el plano
          ctipmer character varying(1) NOT NULL, -- Tipo de Mercado
          dnummer character varying(10) NOT NULL, -- Nro de puesto dentro del mercado
          cdiscat character varying(25) NOT NULL, -- Distrito Catastral
          czoncat character varying(25) NOT NULL, -- Zona Catastral
          cmzacat character varying(25) NOT NULL, -- Manzana Catastral
          cseccat character varying(25) NOT NULL, -- Sector Catastral
          cltecat character varying(25) NOT NULL, -- Lote Catastral
          cundcat character varying(25) NOT NULL, -- Unidad Catastral
          dbloque character varying(25) NOT NULL, -- Bloque
          dseccio character varying(25) NOT NULL, -- Seccion
          dunidad character varying(25) NOT NULL, -- Unidad
          mpoblad character(10) NOT NULL, -- Centro Poblado
          vdirpre character varying(250) NOT NULL, -- Direccion del Predio
          nestado character varying(2) NOT NULL, -- Estado
          ccodpre character varying(20), -- Codigo de Predio Mostrar
          ctippre character(10) NOT NULL, -- Tipo de Predio
          idanexo character(10) NOT NULL, -- Anexo
          ccodcuc character varying(25) NOT NULL, -- Codigo unico castastral new
          vhostnm character varying(25) NOT NULL, -- Estacion
          vusernm character varying(25) NOT NULL, -- Usuario
          ddatetm timestamp without time zone NOT NULL, -- Fecha de Registro
          nlatitu numeric(18,8), -- Latitud del predio
          nlongit numeric(18,8), -- Longitud del predio
          nzoom numeric(18,8), -- Zoom del mapa
          */

            $this->_helper->getHelper('ajaxContext')->initContext(); 
        
        if ($this->getRequest()->isXmlHttpRequest()) {
            $this->_helper->layout->disableLayout();
        
            $ddatosuserlog = new Zend_Session_Namespace('datosuserlog');
            $coduser = $ddatosuserlog->cidpers;
            $vhostnm = $ddatosuserlog->vhostnm;
                
            $row =  $_POST["idsigma"].','.
                    $_POST["mviadis"].','.
                    $_POST["dnumero"].','.
                    $_POST["dinteri"].','.
                    $_POST["dletras"].','.              
                    $_POST["ddepart"].','.
                    $_POST["destaci"].','.
                    $_POST["ddeposi"].','.
                    $_POST["drefere"].','.
                    $_POST["dmanzan"].','.
                    $_POST["dnlotes"].','.
                    $_POST["ccatast"].','.
                    $_POST["cplanos"].','.
                    $_POST["ctipmer"].','.
                    $_POST["dnummer"].','.
                    $_POST["cdiscat"].','.
                    $_POST["czoncat"].','.
                    $_POST["cmzacat"].','.                  
                    $_POST["cseccat"].','.
                    $_POST["cltecat"].','.                  
                    $_POST["cundcat"].','.
                    $_POST["dbloque"].','.
                    $_POST["dseccio"].','.
                    $_POST["dunidad"].','.
                    $_POST["mpoblad"].','.
                    $_POST["vdirpre"].','.
                    $_POST["nestado"].','.
                    $_POST["ccodpre"].','.
                    $_POST["ctippre"].','.
                    $_POST["idanexo"].','.
                    $_POST["ccodcuc"].','. 
                    $vhostnm.','.
                    $coduser.','.
                    date("y-m-d").','.
                    $_POST["nlatitu"].','. 
                    $_POST["nlongit"].','. 
                    $_POST["nzoom"];
                
                
            $parameters[] = $row;
            $dataAdapter = new Model_DataAdapter();
            $rows = $dataAdapter->executeSelect("pl_function.guardar_mpredio", $parameters);
        
            if($rows[0][0] == 1) {
                //$parameters = array($_POST['dpredio'], $_POST["cperiod"]);
                    
                $data['error'] = "";
                //$data['data'] = $dataAdapter->executeAssocQuery("pl_function.listar_construccion", $parameters);
            } else {
                $data['error'] = "Error al actualizar";
                $data['data'] = "";
            }


        }
		
    } 
		
}  

