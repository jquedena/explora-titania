<?php

/**
 * Fraccionamiento
 * 
 * @author
 * @version 
 */

require_once 'Zend/Controller/Action.php';

class FraccionamientoController extends Zend_Controller_Action {
	/**
	 * The default action - show the home page
	 */
	
    public function init() {
    	$this->_helper->layout()->setLayout('layoutwithpanel');
    	$map = new Zend_Session_Namespace("map");
    	$map->data = false;
    }
    
	public function indexAction() {
		// TODO Auto-generated Fraccionamiento::indexAction() default action
		$this->view->util()->registerScriptJSControllerAction($this->getRequest());
						
			$pintar= new Libreria_Pintar();
		
//	
//		$val[]=array('locategridresultestctacte',$newcontent,'html');
//		
//		$pintar->PintarValor($val);
//		
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
            
                //$this->view->cidpers;
            	
            
                 //'%','0','2013-03-08','0','0','%'
            
              	$parameters[] = $this->view->cidpers;
              	$parameters[] = '%';
              	$parameters[] = '0';
              	$parameters[] = date("y-m-d"); 
              	$parameters[] = '0' ;
              	$parameters[] = '0' ;
              	$parameters[] = '%' ;
              	 
              	
               	$dataAdapter = new Model_DataAdapter();
               	$rows = $dataAdapter->executeAssocQuery("tesoreria.fx_Estadocuenta", $parameters);
               	
               //	echo count($rows );
               
               //	print_r($rows);
               	
                        	
               	$pintar= new Libreria_Pintar();
               	
               	if (count($rows)>0) {
               		
               $deudas ='<table width="500" >';
//               	$deudas.='<tr>';
//               	$deudas.='<td>Tributo</td>';
//               	$deudas.='<td>Cod.Predio</td>';
//               	$deudas.='<td>A&ntilde;o</td>';
//               	$deudas.='<td>Periodo</td>';
//               	$deudas.='<td>Insoluto</td>';
//               	$deudas.='<td>Mora</td>';        
//               	$deudas.='<td>Total</td>';
//               	$deudas.='<td>Estado</td>';
//               	$deudas.='<td><input type="checkbox" id="checkfracctodos"  onClick="checktodosfracci();" /></td>';
//               	$deudas.='</tr>';
               	
               $montototal=0;
               	
               	for ($i=0;$i< count($rows );++$i){
               		
               		$montototal+=$rows[$i]['ntotals'];
               		
               	$deudas.='<tr>';
               	$deudas.='<td>'. (String) $rows[$i]['ctiprc0'].'</td>';
               	$deudas.='<td>'. (String) $rows[$i]['ccodpre'].'</td>';
               	$deudas.='<td>'. (String) $rows[$i]['cejerci'].'</td>';
               	$deudas.='<td>'. (String) $rows[$i]['cperiod'].'</td>';
               	$deudas.='<td>'. (String) $rows[$i]['nimpins'].'</td>';
               	$deudas.='<td>'. (String) $rows[$i]['nimpmor'].'</td>';	
               	$deudas.='<td>'. (String) $rows[$i]['ntotals'].'</td>';	
               	$deudas.='<td>'. (String) $rows[$i]['vestad2'].'</td>';	
               	$deudas.='<td><input id="'.$rows[$i]['idsigma'].'" type="checkbox" class="checkfracc" value="'.$rows[$i]['ntotals'].'" onclick="calculamontofracc(this.id);" /> </td>';               	
               	$deudas.='</tr>';
               	
               	}
               	
               	$deudas.='</table>';
               	
               	$val[]=array('tabladeudas', $deudas,'html');
               	
               	$val[]=array('txtdeudatotal',$montototal,'val');
               	
               	//$js[]=array('$("#txtnrocuotas").spinner();');
               	
          		$js[]=array('themeTextBox(); themeComboBox();');
             
              	$pintar->PintarValor($val);
              	$pintar->EjecutarFuncion($js);
              	
               	}
              
        }
    }
    
    public function contratofraccAction(){
    		$this->view->util()->registerScriptJSControllerAction($this->getRequest());
    	     $this->_helper->layout->disableLayout();
    	     
    	     
    	     $cidpers=$this->_request->getParam('cidpers');
    	     $monto=$this->_request->getParam('monto');
    	     $numcuotas=$this->_request->getParam('numcuotas');
    	     $cuotaini=$this->_request->getParam('cuotaini');
    	     
    	     $pintar= new Libreria_Pintar();
		     
    	     $arrtipodoc = array(array('0000000001', 'DNI'), array('0000000002', 'RUC'));
    	     $arrcodpostal = array(array('0000000001', 'Puente Piedra'), array('0000000002', 'otros'));
    	     
    	     			
    	     $val[] = array('ctipdoc_titular', $pintar->ContenidoCombo($arrtipodoc, ''), 'html');
    	     
    	     $val[] = array('ctipdoc_titular', $pintar->ContenidoCombo($arrtipodoc, ''), 'html');
    	     
    	     $val[] = array('cdistrito_titular', $pintar->ContenidoCombo($arrcodpostal, ''), 'html');
    	     
    	     $val[] = array('ctipdoc_garante', $pintar->ContenidoCombo($arrtipodoc, ''), 'html');
    	     
    	     $val[] = array('cdistrito_garante', $pintar->ContenidoCombo($arrcodpostal, ''), 'html');
    	     
    	     $val[] = array('txtfechfracc',date('y-m-d'),'val');
    	     
    	     $val[] = array('txtnrocuotas2',$numcuotas,'val');    

    	      $val[] = array('txtcuotainicial2',$cuotaini,'val'); 
    	     
    	     $val[] = array('txttotalfracc', round($monto,2) , 'val');
    	     
    	     $evt[]=array('txtporcuoini','blur','inicial('.$monto.');');
		
			 $evt[]=array('txtcuotainicial2','keypress','cuotas();');
			 
			
    	     
    	     $pintar->PintarValor($val);
    	      $pintar->PintarEvento($evt);
    	
    }
	
	public function fracproyAction(){
		$this->view->util()->registerScriptJSControllerAction($this->getRequest());
		$pintar= new Libreria_Pintar();
		
		$evt[]=array('txtporcuotas','blur','inicial(1000);');
		
		$evt[]=array('txtcuotainicial','blur','cuotas();');
		
	    $pintar->PintarEvento($evt);
	}
	
	public function grabarfraccAction(){
		$this->_helper->layout->disableLayout();
		$this->_helper->viewRenderer->setNoRender();
		$this->_helper->getHelper('ajaxContext')->initContext();
			if ($this->getRequest()->isXmlHttpRequest()) {
			
			$p_idsigma=$this->_request->getPost('p_idsigma');
            $p_cnumfra=$this->_request->getPost('p_cnumfra');         
            $p_canofra=$this->_request->getPost('p_canofra');          
	        $p_cidpers=$this->_request->getPost('p_cidpers');
	        $p_ctipdoc_titular=$this->_request->getPost('p_ctipdoc_titular');
	        $p_descdoc_titular=$this->_request->getPost('p_descdoc_titular');
	        $p_cnombres_titular=$this->_request->getPost('p_cnombres_titular');
	        $p_cdomicilio_titular=$this->_request->getPost('p_cdomicilio_titular');
	        $p_cdistrito_titular=$this->_request->getPost('p_cdistrito_titular');
            $p_ctelef_fijo_titular=$this->_request->getPost('p_ctelef_fijo_titular');
            $p_ctelef_movil_titular=$this->_request->getPost('p_ctelef_movil_titular'); 
			$p_ctipdoc_garante=$this->_request->getPost('p_ctipdoc_garante');
			$p_desdoc_garante=$this->_request->getPost('p_desdoc_garante');
			$p_cnombres_garante=$this->_request->getPost('p_cnombres_garante');
			$p_cdomicilio_garante=$this->_request->getPost('p_cdomicilio_garante');
			$p_cdistrito_garante=$this->_request->getPost('p_cdistrito_garante');
			$p_ctelefono_garante=$this->_request->getPost('p_ctelefono_garante');
			$p_tif_mensual=$this->_request->getPost('p_tif_mensual');
			$p_tif_diario=$this->_request->getPost('p_tif_diario');
			$p_monto_deuda_total=$this->_request->getPost('p_monto_deuda_total');
			$p_monto_cuota_inicial=$this->_request->getPost('p_monto_cuota_inicial');
			$p_monto_deuda_regular=$this->_request->getPost('p_monto_deuda_regular');
			$p_numero_cuota=$this->_request->getPost('p_numero_cuota');
			$p_dfecha_emision=$this->_request->getPost('p_dfecha_emision');
			$p_modelo_convenio_id=$this->_request->getPost('p_modelo_convenio_id');
			$p_cf_ampliado=$this->_request->getPost('p_cf_ampliado');
			$p_nestado=$this->_request->getPost('p_nestado');
			$p_vhostnm=$this->_request->getPost('p_vhostnm');
			$p_vusernm=$this->_request->getPost('p_vusernm');
            
            
			$ddatosuserlog = new Zend_Session_Namespace('datosuserlog');
			$userlogin = $ddatosuserlog->userlogin;
			
			$cn = new Model_DataAdapter ();
			$nombrestore = '"recaudacion".insertupdate_fr_convenios';
			$parametros [0] = $p_idsigma;
			$parametros [1] = $p_cnumfra;
			$parametros [2] = $p_canofra;
			$parametros [3] = $p_cidpers;
			$parametros [4] = $p_ctipdoc_titular;
			$parametros [5] = $p_descdoc_titular;
			$parametros [6] = $p_cnombres_titular;
			$parametros [7] = $p_cdomicilio_titular;
			$parametros [8] = $p_cdistrito_titular;
			$parametros [9] = $p_ctelef_fijo_titular;
			$parametros [10] = $p_ctelef_movil_titular;
			$parametros [11] = $p_ctipdoc_garante;
			$parametros [12] = $p_desdoc_garante;
			$parametros [13] = $p_cnombres_garante;
			$parametros [14] = $p_cdomicilio_garante;
			$parametros [15] = $p_cdistrito_garante;
			$parametros [16] = $p_ctelefono_garante;
			$parametros [17] = $p_tif_mensual;
			$parametros [18] = $p_tif_diario;
			$parametros [19] = $p_monto_deuda_total;
			$parametros [20] = $p_monto_cuota_inicial;
			$parametros [21] = $p_monto_deuda_regular;
			$parametros [22] = $p_numero_cuota;
			$parametros [23] = $p_dfecha_emision;
			$parametros [24] = $p_modelo_convenio_id;
			$parametros [25] = $p_cf_ampliado;
			$parametros [26] = $p_nestado;
			$parametros [27] = $this->view->util()->getHost();
			$parametros [28] = $userlogin;

			$datos = $cn->ejec_store_procedura_sql($nombrestore, $parametros);
			if ($datos[0][0] == '1') {

			} else {
				header("Status: 400 Error al Guardar intentelo en otro momento o contacte al adminsitrador");
			}
            
            
			
			}
	}

}
