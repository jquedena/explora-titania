<?php

require_once 'Zend/Controller/Action.php';

class sencilleraController extends Zend_Controller_Action {

    public function init() {
        $this->view->util()->registerScriptJSController($this->getRequest());
    }

    public function indexAction() {
    }

    public function sencilleraAction() {       
    }
	/*si se usa*/
    public function ventanamonedasAction() {
    	$this->_helper->getHelper('ajaxContext')->initContext();
    	if ($this->getRequest()->isXmlHttpRequest()) {
    		$this->_helper->layout->disableLayout();
    		
    		$idapertura = $this->_request->getPost('idapertura');
    		$codcajero = $this->_request->getPost('codcajero');
    		$nomcajero = $this->_request->getPost('nomcajero');
    		$accion = $this->_request->getPost('accion');//0000000001(al habilitar) - 0000000002(al cierre)
    		
    		$codcajero = substr($codcajero, -2);
    		$cn = new Model_DataAdapter ();
    		$nombrestore = '"public"."pxcobrowww"';
    		$arraydatos [0] = '2';
    		$arraydatos [1] = '';
    		$arraydatos [2] = '';
    		$datosfecha = $cn->ejec_store_procedura_sql($nombrestore, $arraydatos);
    		$dfecha = explode(" ", $datosfecha[0][0]);
    		$date = $dfecha[0];
			
    		//tesoreria.buscardvalmon(p_idsigma character varying, p_aperturacaja character varying, p_ctipope character varying, p_ref refcursor)
    		$nombrestore = 'tesoreria.buscardvalmon';
    		$arraydatos [0] = '%';
    		$arraydatos [1] = $idapertura;
    		$arraydatos [2] = $accion;
    		
    		$datosdvalmon = $cn->ejec_store_procedura_sql($nombrestore, $arraydatos);
    		//print_r($datosdvalmon);
    		$bodytbl = '';
    		$row = 0;
    		$mt_totals = 0.00;
    		for ($i = 0; count($datosdvalmon) > $i; $i++) {
    			if ($datosdvalmon[$i][0] != $datosdvalmon[$i][2]) {
    		
    				$bodytbl .='<tr>';
    				$bodytbl .='<td style="padding-left:10px;"><input type="hidden" name="det[' . $row . '][vidsigma]" value="' . $datosdvalmon[$i][0] . '"><input type="hidden" name="det[' . $row . '][vctipmon]" value="' . $datosdvalmon[$i][3] . '">';
    				$bodytbl .= $datosdvalmon[$i][4] . '</td>'; //descripcion
    				$bodytbl .='<td align="right"><span id="mt_montorow">' . $datosdvalmon[$i][5] . '</span></td>'; //montos  
    				$bodytbl .='<td align="right"><input type="text" name="det[' . $row . '][vncantid]" style="width :50px;text-align: right;" onkeypress="return validarnumeros(event);" class="mt_cant ui-text" id="mt_cant" value="'.$datosdvalmon[$i][6].'" /></td>'; //cantidad
    				$bodytbl .='<td align="right"><input type="text" name="det[' . $row . '][vntotals]" style="width :50px;text-align: right;" class="mt_total ui-text" id="mt_totalrow" name="mt_totalrow" value="'.$datosdvalmon[$i][7].'" readonly="readonly" /></td>'; //mt_total
    				$mt_totals += $datosdvalmon[$i][7];
    				$bodytbl .='</tr>';
    				$row++;
    			}
    		}
    		
    		$val[] = array("tbl_monedas tbody", $bodytbl, "html");
    		$val[] = array('txtfech_proc', $date, 'val');
    		$val[] = array('txtnom_cajero', $codcajero.' - '.$nomcajero, 'val');
    		$val[] = array('hdid_apert', $idapertura, 'val');
    		$val[] = array('txtsenccodapert',intval($idapertura), 'val');
    		$val[] = array('hdid_cajero', $codcajero, 'val');
    		$val[] = array('hdaccion', $accion, 'val');
    		$val[] = array('mt_totals',$mt_totals,'html');
       		
    		//$js[] = array('$("#txtfech_proc").datepicker({showOn: "button", buttonImage: jQuery.scriptPath + "img/calendar.gif",	buttonImageOnly: true});');
    		//$js[] = array('$("#txtfech_proc").datepicker("option", "dateFormat", "yy-mm-dd");');
    		$js[] = array('mouseHover("tbl_monedas");');
    		$js[] = array('$(".mt_cant").on("keyup",sumary_totals);');
    		$js[] = array("$('#btnprocsencillero').button({ icons: {secondary:'ui-icon-disk'} })");
       		
    		if ($accion=='0000000002'){
    			$js[] = array("$('#obscerrarcaja').show();");
    			$js[] = array("var config = {
								            skin:'v2'
								            , toolbar: [
								                ['Bold','Italic','Underline','-','NumberedList','BulletedList','-','Outdent','Indent','-','Undo','Redo','-','HorizontalRule','-','Blockquote','CreateDiv','-','JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock','-','TextColor','BGColor'],
								                ['UIColor']
								            ]
								        };
        
								        var hEd = CKEDITOR.instances['txtobs'];
								        if (hEd) {
								            CKEDITOR.remove(hEd);
								        }
       								 CKEDITOR.replace('txtobs', config);");
    		}
    		$din[] = array("tbl_monedas .mt_total");

       		
       		$evt[] = array("btnprocsencillero", "click", "guardarsencillero();");
       		
       		$func = new Libreria_Pintar();
    		$func->IniciaScript();
     		$func->PintarValor($val);
    		$func->PintarEvento($evt);
    		//$func->CampoDinero($din);
    		$func->EjecutarFuncion($js, "function");
    		$func->FinScript();
    	}
    }
    
    /*Ya no al uso*/
    public function habsencilleraAction() {
        $this->_helper->getHelper('ajaxContext')->initContext();
        if ($this->getRequest()->isXmlHttpRequest()) {
            $this->_helper->layout->disableLayout();
            $pidaper = $this->_request->getPost('idaper');
            $pdtcajeros = $this->_request->getPost('dtcajeros');
            $pestado = $this->_request->getPost('estado');

            if ($pdtcajeros != "") {
                $arrcajeros = explode(",", $pdtcajeros);
                if (count($arrcajeros) == 1) {
                    $datocajero = explode('|', $arrcajeros[0]);
                    $cod_cajero = $datocajero[0];
                    $st_estado = $datocajero[1];
                    $nrocajacajero = $datocajero[2];

                    $cn = new Model_DataAdapter ();
                    $nombrestore = '"public".obt_mconten';
                    $parametros [0] = '';
                    $parametros [1] = '1000000140';
                    $datosmconten = $cn->ejec_store_procedura_sql($nombrestore, $parametros);
                    $nombrestore = '"public"."pxcobrowww"';
                    $arraydatos [0] = '2';
                    $arraydatos [1] = '';
                    $arraydatos [2] = '';
                    $datosfecha = $cn->ejec_store_procedura_sql($nombrestore, $arraydatos);
                    $dfecha = explode(" ", $datosfecha[0][0]);
                    $date = $dfecha[0];

                    $bodytbl = '';
                    $row = 0;
                    for ($i = 0; count($datosmconten) > $i; $i++) {
                        if ($datosmconten[$i][0] != $datosmconten[$i][2]) {

                            $bodytbl .='<tr>';
                            $bodytbl .='<td style="padding-left:10px;"><input type="hidden" name="det[' . $row . '][idmconten]" value="' . $datosmconten[$i][0] . '">';
                            $bodytbl .= $datosmconten[$i][1] . '</td>'; //descripcion
                            $bodytbl .='<td align="right"><span id="mt_montorow">' . $datosmconten[$i][5] . '</span></td>'; //montos
                            $bodytbl .='<td align="right"><input type="text" name="det[' . $row . '][mt_cant]" style="width :50px;text-align: right;" onkeypress="return validarnumeros(event);" class="mt_cant" id="mt_cant" value="0" /></td>'; //cantidad
                            $bodytbl .='<td align="right"><input type="text" name="det[' . $row . '][mt_totalrow]" style="width :50px;text-align: right;" class="mt_total" id="mt_totalrow" name="mt_totalrow" value="0.00" readonly="readonly" /></td>'; //mt_total
                            $bodytbl .='</tr>';
                            $row++;
                        }
                    }
                    $val[] = array("tbl_monedas tbody", $bodytbl, "html");
                    $val[] = array('txtfech_proc', $date, 'val');
                    $val[] = array('txtnom_cajero', $nrocajacajero, 'val');
                    $val[] = array('hdid_apert', $pidaper, 'val');
                    $val[] = array('hdid_cajero', $cod_cajero, 'val');
                    $val[] = array('hdid_estado', $st_estado, 'val');

                    $js[] = array('$("#txtfech_proc").datepicker({showOn: "button", buttonImage: jQuery.scriptPath + "img/calendar.gif",	buttonImageOnly: true});');
                    $js[] = array('$("#txtfech_proc").datepicker("option", "dateFormat", "yy-mm-dd");');
                    $js[] = array('mouseHover("tbl_monedas");');
                    $js[] = array('$(".mt_cant").on("keyup",sumary_totals);');
                    $js[] = array("$('#btnprocsencillero').button({ icons: {secondary:'ui-icon-disk'} })");

                    $din[] = array("tbl_monedas .mt_total");
                    //$din[] = array("tbl_monedas .mt_cant");

                    $evt[] = array("btnprocsencillero", "click", "guardarsencillero();");

                    $func = new Libreria_Pintar();
                    $func->IniciaScript();

                    $func->PintarValor($val);
                    $func->PintarEvento($evt);
                    //$func->CampoDinero($din);
                    $func->EjecutarFuncion($js, "function");
                    $func->FinScript();
                }
            }
        }
    }
/*si se usa*/
    public function guardarsencilleroAction() {
        $this->_helper->layout->disableLayout();
        $this->_helper->viewRenderer->setNoRender();
        $this->_helper->getHelper('ajaxContext')->initContext();

        if ($this->getRequest()->isXmlHttpRequest()) {
        	
            $det = $this->_request->getPost('det');
            $hdid_apert = $this->_request->getPost('vhdid_apert');
            $hdid_cajero = $this->_request->getPost('vhdid_cajero');
            $txtfech_proc = $this->_request->getPost('vtxtfech_proc');
            $hdid_estado = $this->_request->getPost('vhdid_estado');
            $hdaccion = $this->_request->getPost('vhdaccion');//0000000001(al habilitar) - 0000000002(al cierre)
            $vobs='';
			if($hdaccion=='0000000002'){
				$vobs = $this->_request->getPost('vobs');
			}
			/*	correlativo 
			 *  ,vidsigma varchar
			 *  ,vaperturacaja varchar
			 *  ,vctipope varchar
			 *  ,vctipmon varchar
			 *  ,vncantid varchar
			 *  ,vntotals varchar
			 *  ,vdfecpro varchar
			 *  ,vnestado varchar
			 *  ,vusernm varchar
			 *  ,vhostnm
			 */
            
            /* vidsigma
             * vncantid
             * vntotals
             */
            
            $ddatosuserlog = new Zend_Session_Namespace('datosuserlog');
            $cidpers = $ddatosuserlog->cidpers;
            $userlogin = $ddatosuserlog->userlogin;
            $cad = '';
            $corr = 1;
            for ($i = 0; $i < count($det); $i++) {
                $cad .= $corr . '^'; 				//correlativo
                $cad .= $det[$i]['vidsigma'] . '^';	//vidsigma*
                $cad .= $hdid_apert.'^'; 			//vaperturacaja*
                $cad .= $hdaccion.'^'; 				//vctipope*//0000000001(al habilitar) - 0000000002(al cierre)
                $cad .= $det[$i]['vctipmon'].'^'; 	//vctipmon*
                $cad .= $det[$i]['vncantid'].'^'; 	//vncantid*
                $cad .= '^'; 						//vntotals
                $cad .= $txtfech_proc.'^'; 			//vdfecpro
                $cad .= '1^'; 						//vnestado*
                $cad .= $userlogin.'^'; 			//vusernm*
                $cad .= $this->view->util()->getHost() . '~'; //vhostnm*
                
			
                $corr++;
            }
			
            $cad = substr($cad, 0, strlen($cad) - 1);
            $cn = new Model_DataAdapter ();
            $nombrestore = '"tesoreria".guardardvalmon';
            $parametros [0] = $cad;
            $parametros [1] = '~';
            $parametros [2] = '^';
            $parametros [3] = $vobs;
           
			/*
            if($hdaccion=='0000000002'){
            	//llamar al controlador Cajaflujo/ actcerrarcaja
            	$result = cerrarCaja($vobs,'',$hdid_cajero);
            	if($result[0][1]=='2'){
            		echo $result[0][0];
            	}elseif($result[0][1]=='0'){
            		echo $result[0][0].'<br>';
            		$datos = $cn->ejec_store_procedura_sql($nombrestore, $parametros);
            		if ($datos[0][0] == '1') {
            			echo "Guardado Correctamente ";
            			//echo '<script language=\"JavaScript\">window.open(\''.$this->view->util()->getLink('mantenimientos/mconten').'\', \'_self\')</script>';
            		} else {
            			echo 'Error en el guardado...';
            		}
            	}
            	#cerrarCaja($obs,$vfecha,$nrocaja)
            }else{*/
	            $datos = $cn->ejec_store_procedura_sql($nombrestore, $parametros);
	            if ($datos[0][0] == '1') {
	                echo $datos[0][1];
	                //echo '<script language=\"JavaScript\">window.open(\''.$this->view->util()->getLink('mantenimientos/mconten').'\', \'_self\')</script>';
	            } elseif ($datos[0][0] == '2') {
	                echo $datos[0][1];
	            }else
	            	echo "Error";
           // }
            
        }
    }
    
    /*Cierra la caja es llamado desde la ventana de guardar monedas*/
    public function cerrarCaja($obs,$vfecha,$nrocaja){
    	$duser = new Zend_Session_Namespace('userlogin');
    	$vuser = $duser->data;
    	$cn = new Model_DataAdapter();
    	$store = "tesoreria.cerrarcaja";
    	$arstore [0] = $nrocaja;
    	$arstore [1] = $vfecha;
    	$arstore [2] = $vuser;
    	$arstore [3] = "";
    	$arstore [4] = $obs;
    	$dt = $cn->ejec_store_procedura_sql($store, $arstore);
    	if (is_array($dt)) {
    		return $dt;
    	}else{
    		return array(array('Ah ocurrido un error','2'));
    	}
    }
    
    /*Si se usa*/
	public function prehabsencilleraAction(){
		$this->_helper->layout->disableLayout();
		$this->_helper->viewRenderer->setNoRender();
		$this->_helper->getHelper('ajaxContext')->initContext();
		if ($this->getRequest()->isXmlHttpRequest()) {
			header('Content-type: application/json');
			$p_cnrcaja = $this->_request->getPost('p_cnrcaja');
			$p_ciduser = $this->_request->getPost('p_ciduser');
			$p_fechadia = $this->_request->getPost('p_fechadia');
			
			$ddatosuserlog = new Zend_Session_Namespace('datosuserlog');
			$p_vusernm = $ddatosuserlog->userlogin;
			$p_vhostnm=$this->view->util()->getHost();
			
			$cn = new Model_DataAdapter ();
			$nombrestore = 'tesoreria.habcaja_moneddefault';
			$parametros [0] = $p_fechadia;
			$parametros [1] = $p_cnrcaja;
			$parametros [2] = $p_ciduser;
			$parametros [3] = $p_vusernm;
			$parametros [4] = $p_vhostnm;
			
			$datos = $cn->ejec_store_procedura_sql($nombrestore, $parametros);
		
			if ($datos[0][0]=='1'){
				$jsonarr=array('v_esttransac'=>$datos[0][0],'v_edt'=>$datos[0][1],'v_msg'=>$datos[0][2],'v_idsigma'=>$datos[0][3]);
				echo json_encode($jsonarr);
				//print_r($datos);
			}else{
				$jsonarr=array('v_esttransac'=>$datos[0][0],'v_descrip'=>'Error en Base de Datos...');
				echo json_encode($jsonarr);
				//print_r($datos);
			}
			
			//v_edt,v_msg , v_idsigma
		}
		/*tesoreria.habcaja_moneddefault(
				p_cnrcaja character varying
				, p_ciduser character varying
				
				, p_vusernm character varying
				, p_vhostnm character varying
				, p_ref refcursor)
		*/
	}
    public function consultasencilleraAction() {
        
    }

}

