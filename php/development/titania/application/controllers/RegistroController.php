<?php

require_once 'Zend/Controller/Action.php';

class RegistroController extends Zend_Controller_Action {

    public function init() {
    	$this->_helper->layout()->setLayout('layoutwithpanel');
    	$map = new Zend_Session_Namespace("map");
    	$map->data = true;
    }

    public function indexAction() {
        $this->view->util()->registerScriptJSControllerAction($this->getRequest());

        // TODO: Implementar la validacion de vias por a�o 
        $parameters[] = date("Y");
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
	            
	            $pintar=new Libreria_Pintar();        
           		 $val[]=array('ccodpre',$rows [0]['ccodpre2'],'val');
           		 $pintar->PintarValor($val);
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
            
            $codpre=$this->_request->getParam('idsigma','');
            $vdirpre=$this->_request->getParam('vdirpre','');
            $fechvig=$this->_request->getParam('fechvig','');
            $nrodecla=$this->_request->getParam('nrodecla','');
            $fechdecl=$this->_request->getParam('fechdecl','');
            $motivo=$this->_request->getParam('motivo','');
            $dataidsigma=$this->_request->getParam('dataidsigma','');
            $observa =$this->_request->getParam('observa','');		
            $ccodpre =$this->_request->getParam('ccodpre','');
            $tnomvia =$this->_request->getParam('tnomvia','');
            $tnompob =$this->_request->getParam('tnompob','');
                        
            $this->view->mperson = $this->_request->getParam('mperson');
            $this->view->mhresum = $this->_request->getParam('mhresum');
            $this->view->cperiod = date("Y");            
            
        }
        
        $val[]=array('dtpFechaVigencia',date('d/m/Y'),'val');
        $val[]=array('dtpFechaDeclaracion',date('d/m/Y'),'val');
        
        
            
        $pintar->PintarValor($val);
        //echo $codpre;
        //echo $vdirpre;
        
        if ( strlen($codpre)>2 &&  strlen($vdirpre)>2){
           $val[]=array('hdnIdPersona', $this->_request->getParam('mperson'),'val' );	
           $val[]=array('txtMpredio',$codpre,'val');
           $val[]=array('txtDirecpred',$vdirpre,'val');
           $val[]=array('dtpFechaVigencia',$fechvig,'val');
           $val[]=array('txtNroDeclaracion',$nrodecla,'val');
           $val[]=array('dtpFechaDeclaracion',$fechdecl,'val');
           $val[]=array('txtCodPre',$ccodpre,'val' );
           $val[]=array('dvtnomvia',$tnomvia,'html' );
           $val[]=array('dvtnompob',$tnompob,'html' );
           
           $fun[]=array(' 
            // Destroy the combobox
			$("#cboMotivo").combobox("destroy");
			
			// Unselect the currently selected option
			$("#cboMotivo option:selected").removeAttr("selected");
			
			// Select the option you want to select
			$("#cboMotivo option[data-idsigma='.$dataidsigma.']").attr("selected", "selected");
			
			// Create the combobox again
			$("#cboMotivo").combobox();');
                      
                      
           //$val[]=array('cboMotivo', $motivo,'val');
           $val[]=array('txtObservacion', $observa,'html');
             
        //print_r($val);
        
         $fun[]=array('$("#dvBajalt").show();');	
           
        $pintar->PintarValor($val);
        $pintar->EjecutarFuncion($fun);
        	
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
    				.'0,' // $_POST['narecom']
    				.'0,' // $_POST['nporcom']
    				.$_POST['nestado'].','
    				.$vhostnm.','
    				.$coduser.','
    				.date("y-m-d").','
    				.$_POST['narecon'];

    		$parameters[] = $row;
    		$parameters[] = $_POST["cclasif"];
    		$parameters[] = $_POST["caracte"];
    		$parameters[] = $_POST['cnumpis'];
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
					.$_POST['nestado'].',' //nestado
					.$vhostnm.','
					.$coduser.','
					.date("y-m-d").','
					.$_POST['nvalins']; //fecha

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
	
	public function guardardeclaracionAction() {
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
				   //$_POST["cmotivo"].','.
				   $_POST['dataidsigma'].','.
				   $_POST["ctipdoc"].','.
				   $_POST["vnrodjj"].','.
				   $_POST["vobserv"].','.
				   $_POST["nestado"].','.
				   $vhostnm.','.
				   $coduser.','.
				   date("y-m-d").','. 
				   date("Y", strtotime($_POST["cperini"])).','.//$_POST["cperini"].','.
				   $_POST["cperfin"].','.
				   $_POST["mperson"];
				   
				  
			
			$parameters[] =  $row;
			$parameters[] =  $_POST["mpredio"];
			$parameters[] =  $_POST["cmotivo"];
			
			$dataAdapter = new Model_DataAdapter();
			//print_r($parameters);
			$rows = $dataAdapter->executeSelect("pl_function.guardar_mhresum", $parameters);
			
			$pintar=new Libreria_Pintar();
			
			$val[]=array('txtNroDeclaracion',$rows[0][0],'html'); 
			 
			$pintar->PintarValor($val);

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
					date("d-m-y",strtotime($_POST["dfecadq"])).','. //$_POST["dfecdes"].','.
					date("y-m-d",strtotime('1900-01-01')).','.					
					date("y-m-d",strtotime('1900-01-01')).','.
					$_POST["nfrente"].','.					
					$_POST["ncanper"].','.
					$_POST["ctippar"].','.
					$_POST["vobserv"].','.
					$_POST["nestado"].','.
					$vhostnm.','.
				    $coduser.','.
					date("y-m-d").','.
					date("d-m-y",strtotime($_POST["dfectra"])).','.
					$_POST["cnotari"].','.
					$_POST["ctiptra"].','. 
					$_POST["cpartid"].','. 
					$_POST["csubtip"].','. 
				 	$_POST["cmotadq"].','. 
					$_POST["mhresum"];
				
			$parameters[] = $row;
			$dataAdapter = new Model_DataAdapter();
			$rows = $dataAdapter->executeSelect("pl_function.guardar_dpredio", $parameters);
		
			if($rows[0][0] != '-1') {
				$params[] = $_POST["mhresum"];
				$params[] = $_POST["cperiod"];
				$params[] = $rows[0][0];
				$rows = $dataAdapter->executeAssocQuery("pl_function.ver_valor_predio", $params);

				$data['valorPredio'] = $rows;
				$data['error'] = "";
			} else {
				$data['error'] = "Error al actualizar";
			}
				
			$this->_helper->json($data);
		}	
	}
	
	public function prediomantenAction(){

	    $pintar = new Libreria_Pintar();
        $parameters[] = date("Y") -1;

        $dataAdapter = new Model_DataAdapter();
        $rows = $dataAdapter->executeAssocQuery("pl_function.listar_vias", $parameters);
        $this->view->mviascp = $rows;       
    
		
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
            
            //print_r($rows);
        
            if($rows[0][0] == 1) {
                                  
                //$data['error'] = "";
           
                $parameters2[]= $_POST["idsigma"];
            	$parameters2[]= '' ;
            	$parameters2[]= '' ;
            	$parameters2[]= '' ;
            	$parameters2[]= '' ;
            
            	$dataAdapter2 = new Model_DataAdapter();            
    			$data['mpredio2'] = $dataAdapter2->executeAssocQuery("pl_function.buscar_mpredio", $parameters2);
       		   
                
            } else {
                $data['error'] = "Error al actualizar";
                $data['mpredio2'] = "";
            }
            
            $this->_helper->json($data);


        }
		
    } 
    
    public function busqpredioAction(){
    	 // $this->_helper->layout->disableLayout();

    	 $pintar=new Libreria_Pintar();
    	 
    	$this->_helper->getHelper('ajaxContext')->initContext();
    	       
        if ($this->getRequest()->isXmlHttpRequest()) {
            $this->_helper->layout->disableLayout();

              $mperson=$this->_request->getPost('mperson');
              
        }  
        
        $parameters[] = date("Y") ;
                    
        $dataAdapter = new Model_DataAdapter();
        $rows = $dataAdapter->executeAssocQuery("pl_function.listar_vias", $parameters);
        $this->view->mviascp = $rows;
        
    	  $val[]=array('txtMperson',$mperson,'val');
    	  
    	  $pintar->PintarValor($val);
    	
    }
   public function busqprediocontrAction(){
     	$this->_helper->getHelper('ajaxContext')->initContext();
    
    	if ($this->getRequest()->isXmlHttpRequest()) {
    		$this->_helper->layout->disableLayout();
    	}
    	
    }
    
    public function recargarpredioAction(){
    
      	$this->_helper->getHelper('ajaxContext')->initContext();
    
      	   $pintar = New Libreria_Pintar();
      	   
    	if ($this->getRequest()->isXmlHttpRequest()) {
    		$this->_helper->layout->disableLayout();
    	  	
    
            $parameters[] = $this->_request->getPost('mpredio');
            $parameters[] = $this->_request->getPost('mhresum'); 
            $parameters[] = $this->_request->getPost('cperiod');
            
            $dataAdapter = new Model_DataAdapter();
            $rows = $dataAdapter->executeAssocQuery("pl_function.ver_predio", $parameters);
            
           // print_r($rows );
           
               $fun[]=array(' 
            // Destroy the combobox
			$("#cboTipoPredio").combobox("destroy");
			
			// Unselect the currently selected option
			$("#cboTipoPredio option:selected").removeAttr("selected");
			
			// Select the option you want to select
			$("#cboTipoPredio option[value='.$rows[0]['ctippre'].']").attr("selected", "selected");
			
			// Create the combobox again
			$("#cboTipoPredio").combobox();');
			
             $fun[]=array(' 
            // Destroy the combobox
			$("#cboTipoPredioUrbano").combobox("destroy");
			
			// Unselect the currently selected option
			$("#cboTipoPredioUrbano option:selected").removeAttr("selected");
			
			// Select the option you want to select
			$("#cboTipoPredioUrbano option[value='.$rows[0]['csubtip'].']").attr("selected", "selected");
			
			// Create the combobox again
			$("#cboTipoPredioUrbano").combobox();');

               $fun[]=array(' 
            // Destroy the combobox
			$("#cboUso").combobox("destroy");
			
			// Unselect the currently selected option
			$("#cboUso option:selected").removeAttr("selected");
			
			// Select the option you want to select
			$("#cboUso option[value='.$rows[0]['cusogen'].']").attr("selected", "selected");
			
			// Create the combobox again
			$("#cboUso").combobox();');

			$fun[]=array(' 
            // Destroy the combobox
			$("#cboUsoEspecifico").combobox("destroy");
			
			// Unselect the currently selected option
			$("#cboUsoEspecifico option:selected").removeAttr("selected");
			
			// Select the option you want to select
			$("#cboUsoEspecifico option[value='.$rows[0]['cusoesp'].']").attr("selected", "selected");
			
			// Create the combobox again
			$("#cboUsoEspecifico").combobox();');               

				$fun[]=array(' 
            // Destroy the combobox
			$("#cboEstado").combobox("destroy");
			
			// Unselect the currently selected option
			$("#cboEstado option:selected").removeAttr("selected");
			
			// Select the option you want to select
			$("#cboEstado option[value='.$rows[0]['cestado'].']").attr("selected", "selected");
			
			// Create the combobox again
			$("#cboEstado").combobox();');   

			$fun[]=array(' 
            // Destroy the combobox
			$("#cboCondicion").combobox("destroy");
			
			// Unselect the currently selected option
			$("#cboCondicion option:selected").removeAttr("selected");
			
			// Select the option you want to select
			$("#cboCondicion option[value='.$rows[0]['ccondic'].']").attr("selected", "selected");
			
			// Create the combobox again
			$("#cboCondicion").combobox();');   

			$val[]=array('nporcen',$rows[0]['nporcen'] ,'val');
			
			$fun[]=array(' 
            // Destroy the combobox
			$("#cboClasificacion").combobox("destroy");
			
			// Unselect the currently selected option
			$("#cboClasificacion option:selected").removeAttr("selected");
			
			// Select the option you want to select
			$("#cboClasificacion option[data-idsigma='.$rows[0]['cclasif'].']").attr("selected", "selected");
			
			// Create the combobox again
			$("#cboClasificacion").combobox();');   
			
			
			$val[]=array('nnrohab',$rows[0]['ncanper'] ,'val');
			
			
			$fun[]=array(' 
            // Destroy the combobox
			$("#cboMotivo").combobox("destroy");
			
			// Unselect the currently selected option
			$("#cboMotivo option:selected").removeAttr("selected");
			
			// Select the option you want to select
			$("#cboMotivo option[value='.$rows[0]['cmotadq'].']").attr("selected", "selected");
			
			// Create the combobox again
			$("#cboMotivo").combobox();');   
			
			$val[]=array('dtpFechaAdquisicion',$rows[0]['dfecadq'] ,'val');
			
			$val[]=array('dtpFechaTransferencia', $rows[0]['dfecadq'],'val'); 
			
			$val[]=array('txtNotaria', $rows[0]['cnotari'] ,'val');
			
			$val[]=array('txtTipoTransferencia', $rows[0]['ctiptra'],'val'); 
			
			$val[]=array('txtPartida',$rows[0]['cpartid'],'val');
			
			$fun[]=array(' 
            // Destroy the combobox
			$("#cboCondicion").combobox("destroy");
			
			// Unselect the currently selected option
			$("#cboCondicion option:selected").removeAttr("selected");
			
			// Select the option you want to select
			$("#cboCondicion option[value='.$rows[0]['ccondic'].']").attr("selected", "selected");
			
			// Create the combobox again
			$("#cboCondicion").combobox();');  
				
            
            //Terreno
            $val[]=array('nareter',$rows[0]['ntertot'] ,'val');
            $val[]=array('narecom',$rows[0]['ncomtot'] ,'val');
            $val[]=array('nporter',$rows[0]['nporter'] ,'val');
            $val[]=array('nporcom',$rows[0]['nporcom'] ,'val');
            $val[]=array('ntotter',$rows[0]['nterren'] ,'val');
            $val[]=array('ntotcom',$rows[0]['narecom'] ,'val');
            $val[]=array('nfronti',$rows[0]['nfrente'] ,'val');
            //$val[]=array('cboParque', $this-> getComboContenedor('1000000219', $rows[0]['ctippar']),'html' );
            
            $fun[]=array(' 
            // Destroy the combobox
			$("#cboParque").combobox("destroy");
			
			// Unselect the currently selected option
			$("#cboParque option:selected").removeAttr("selected");
			
			// Select the option you want to select
			$("#cboParque option[value='.$rows[0]['ctippar'].']").attr("selected", "selected");
			
			// Create the combobox again
			$("#cboParque").combobox();
    		   
    		  	
    		  	
    		$(" .ui-combobox-input").attr("disabled", true);
    		$(" .ui-combobox-input").toggleClass("ui-text-disable");
    		$(" ui-combobox-input a").button("option", "disabled", true);
    		
	        //$("#txtMotivo").attr("disabled", true);	        
	        //$("#txtMotivo").toggleClass("ui-text-disable");
        	
        	$("#linkMotivo").button("option", "disabled", true);
        	
        	$("#linkTipoPredio").button("option", "disabled", true);
        	$("#linkTipoPredioUrbano").button("option", "disabled", true);
        	$("#linkUso").button("option", "disabled", true);
        	$("#linkUsoEspecifico").button("option", "disabled", true);
        	$("#linkEstado").button("option", "disabled", true);
        	$("#linkCondicion").button("option", "disabled", true);
        	$("#linkClasificacion").button("option", "disabled", true);
        	$("#linkParque").button("option", "disabled", true);
        	
        	
        	//$("#cboPeriodo").combobox("destroy");
    		//$("#cboPeriodo").combobox();
    		
    		//alert("despues");
									
			');
            
            
			            
            
//            $val[]=array('narecom',$rows[0]['ncomtot'] ,'val');
//            $val[]=array('narecom',$rows[0]['ncomtot'] ,'val');
//            $val[]=array('narecom',$rows[0]['ncomtot'] ,'val');
//            $val[]=array('narecom',$rows[0]['ncomtot'] ,'val');
//            $val[]=array('narecom',$rows[0]['ncomtot'] ,'val');
            
          
    	}
    	 $pintar->PintarValor($val); 
    	 $pintar->EjecutarFuncion($fun);
	}

	public function editarpredioAction(){
				$this->_helper->layout->disableLayout();		
	
			$codpre=$this->_request->getParam('mhresum','');
			$mpredio=$this->_request->getParam('mpredio','');
			
			
			$pintar = new Libreria_Pintar();
				
			
			//$ccodpre=$this->_request->getParam('ccodpre','');
						
            $parameters[] = date("Y") -1;

            $dataAdapter = new Model_DataAdapter();
            $rows = $dataAdapter->executeAssocQuery("pl_function.listar_vias", $parameters);
            $this->view->mviascp = $rows;  
            
            $parameters2[]= $mpredio;
            $parameters2[]= '' ;
            $parameters2[]= '' ;
            $parameters2[]= '' ;
            $parameters2[]= '' ;
            
            $dataAdapter2 = new Model_DataAdapter();
            $rows2 = $dataAdapter2->executeAssocQuery("pl_function.buscar_mpredio", $parameters2);
            
            //echo count($rows2 );

            if (count($rows2)>0){
                        
            $val[]=array( 'txtcodpre' ,$rows2[0]['ccodpre'] ,'val');            
            $val[]=array( 'txt_idsigma' ,$rows2[0]['idsigma'] ,'val');
            $val[]=array( 'txt_mviadis' , $rows2[0]['mviadis'] ,'val');
            $val[]=array( 'txt_mpoblad' , $rows2[0]['mpoblad'] ,'val');
            
            $val[]=array( 'txtviacentrpob' ,$rows2[0]['tnomvia'] .' - ' . $rows2[0]['tnompob']  ,'val');         
            $val[]=array( 'txtnumero' ,$rows2[0]['dnumero']  ,'val');
            $val[]=array( 'txtdepart' ,$rows2[0]['ddepart']  ,'val');
            $val[]=array( 'txtmanzana' ,$rows2[0]['dmanzan']  ,'val');
            $val[]=array( 'txtlote' ,$rows2[0]['dnlotes']  ,'val');
			$val[]=array( 'txt_ctippre' ,$rows2[0]['ctippre']  ,'val');
            
			
			$pintar->PintarValor($val);
            }
		
	}
	
	public function pintarpredioAction(){
		 $this->_helper->getHelper('ajaxContext')->initContext();
    
      	 $pintar = New Libreria_Pintar();
      	   
    	if ($this->getRequest()->isXmlHttpRequest()) {
    		$this->_helper->layout->disableLayout();	
    		
    		$codpre=$this->_request->getPost('idsigma','');
            $vdirpre=$this->_request->getPost('vdirepre','');
          
             //if (isset($codpre) &&  isset($vdirpre)){
           $val[]=array('txtMpredio',$codpre,'val');
           $val[]=array('txtDirecpred',$vdirpre,'val');
             
        //print_r($val);      
    	}
		    
    	$pintar->EjecutarFuncion($val);          
          
	}
	
	public function  recargarvalorpredioAction(){
  		$this->_helper->getHelper('ajaxContext')->initContext();
		$pintar= New Libreria_Pintar();
		
    	if ($this->getRequest()->isXmlHttpRequest()) {
    		$this->_helper->layout->disableLayout();
	    		
    		$p_mhresum =$this->_request->getPost('p_mhresum','');
            $p_cperiod =$this->_request->getPost('p_cperiod','');
            $p_dpredio =$this->_request->getPost('p_dpredio','');   
            
    		
            $parameters2[]= $p_mhresum ;
            $parameters2[]= $p_cperiod ;
            $parameters2[]= $p_dpredio ;
            
            $dataAdapter2 = new Model_DataAdapter();
            $rows2 = $dataAdapter2->executeAssocQuery("pl_function.ver_valor_predio", $parameters2);    		
            //print_r($rows2);    		
    	}

    	if 	(count($rows2)>0){
	    	$val[]=array('lblArancel',$rows2[0]['narance'],'html');
	    	
	    	$val[]=array('lblValorTerreno',$rows2[0]['nvalter'],'html');
	    	
	    	$val[]=array('lblValorConstruccion',$rows2[0]['nvalpis'],'html');
	    	
	    	$val[]=array('lblValorInstalacion',$rows2[0]['nvalins'],'html');
	    	
	    	$val[]=array('lblAutovaluo',$rows2[0]['nvalpre'],'html');
    	  
	        $val[]=array('lblMontoBarrido',$rows2[0]['nbarrid'],'html');
            
	        
	        
	        $val[]=array('lblMontoParque',$rows2[0]['nparque'],'html');
            
	        $val[]=array('lblMontoRecoleccion',$rows2[0]['nrecole'],'html');
            
	        $val[]=array('lblMontoSerenazgo',$rows2[0]['nserena'],'html');
	        
	        
	        $val[]=array('lblUsuario',$rows2[0]['vusernm'],'html');
    	
    		$val[]=array('lblFechaModificacion',$rows2[0]['ddatetm'],'html');
    	
    		$val[]=array('lblFechaProceso',$rows2[0]['dfectra'],'html');
	    	
        	    	
    	$pintar->PintarValor($val);
 
    		
    	}
    	
    	
    	
    	
		
	}
	
		
	public function galeriafotosAction(){
			$this->_helper->layout->disableLayout();
		
	}
	
	public function presubirfotoAction(){
				
	  $this->_helper->getHelper('ajaxContext')->initContext();
	  $this->_helper->layout->disableLayout();

	  $dpredio=$this->_request->getParam('dpredio','');
	  
        if ($this->getRequest()->isXmlHttpRequest()) {        	
		
        }
        
        $fotos = new Zend_Session_Namespace('fotos');
    	$foto ->dpredio =$dpredio;
    	
	}
	
	public function subirfotoAction(){
		$this->_helper->getHelper('ajaxContext')->initContext();

		    $pintar= New Libreria_Pintar();
		
    		if ($this->getRequest()->isXmlHttpRequest()) {
    			$this->_helper->layout->disableLayout();
    		
    			$p_dpredio =$this->_request->getPost('p_dpredio','');
    			$p_foto =$this->_request->getPost('p_foto','');
    		}

    		echo $p_dpredio ;
    		echo "</br>".$p_foto; 
	}
	
	public function uploadAction(){		
		
		$a = new Zend_Session_Namespace('fotos');

		echo "dpredio:".$a->dpredio;
		
		echo $_REQUEST["name"];
		
	}
	
	public function guardarinafectaAction(){
		$this->_helper->getHelper('ajaxContext')->initContext();
    
    	if ($this->getRequest()->isXmlHttpRequest()) {
    		$this->_helper->layout->disableLayout();

    		$ddatosuserlog = new Zend_Session_Namespace('datosuserlog');
    		$coduser = $ddatosuserlog->cidpers;
    		$vhostnm = $ddatosuserlog->vhostnm;
    		
    		
    		 $row = $_POST['idsigma'].','
			  		.$_POST['mperson'].','
			  		.$_POST['mpredio'].','
			  		.$_POST['ctipina'].','
			  		.$_POST['vbasleg'].','
			  		.$_POST['vnumexp'].','
			  		.$_POST['vnumres'].','
			  		.$_POST['dfecres'].','
			  		.$_POST['ctiping'].','
			  		.$_POST['nporafe'].','
			  		.$_POST['dfecini'].','
			  		.$_POST['dfecfin'].','
			  		.$_POST['nestado'].','
			  		.$vhostnm.','
			  		.$coduser.','  
			 		.date("y-m-d").','
			  		.$_POST['mhresum'].','	
			  		.$_POST['vobserv'];		  
					
			$parameters[] = $row;
			$dataAdapter = new Model_DataAdapter();
    		$rows = $dataAdapter->executeSelect("pl_function.guardar_minafec", $parameters);

    		
    	}
		
	}
	
}  

