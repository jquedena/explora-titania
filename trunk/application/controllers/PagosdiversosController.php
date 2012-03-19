<?php

/**
 * SqlcnController
 * 
 * @author
 * @version 
 */

require_once 'Zend/Controller/Action.php';

class PagosdiversosController extends Zend_Controller_Action {

	public function indexAction() {		
		//sin laouts
		//$this->_helper->viewRenderer->setNoRender(); 
		//$this->_helper->layout->disableLayout(); 
		$url = $this->view->util()->getPath();
						
		$dcodcajero = new Zend_Session_Namespace('codcajero');
		$codcajero  = $dcodcajero->data;
		
		$codcajero = '99';
		
		$func = new Libreria_Pintar(); 
		
		if($codcajero>0){
				$datospers = $this->_request->getParam('datospers','');
				if($datospers == ''){
					header('location:'.$url.'index.php/busqpers/?tit=Pagos Diversos&url='.$url.'index.php/pagosdiversos/?datospers=',true);
				}else{
					
					$data = new Zend_Session_Namespace('arrayconceptos');
					$data->data = '';

	//				$dnomcajero = new Zend_Session_Namespace('userlogin');
	//				$dnomcajero->data = $nomcajero;
					
					list($cidpers, $nompers) = explode('|', $datospers);
					
						$ddatacontri = new Zend_Session_Namespace('contribuyente');
						$ddatacontri->cidcontri = $cidpers ;
						$ddatacontri->nomcontri = $nompers ;
										
					$nombrestore = '"tesoreria"."buscar_concepto"';
					$arraydatos[0]= '';
					$arraydatos[1]= '';
					$cn = new Model_DataAdapter();		
					$datoscpd = $cn->ejec_store_procedura_sql($nombrestore,$arraydatos);
				
					$jsondatoscpd = json_encode($datoscpd);
					
					
					//echo $jsondatoscpd;
					
					//restructurando arreglar 
					$content = '';									
					if($cidpers=='_________1'){
					$content .= '<b>Venta Libre</b>';	
					}
					
					for($i=0;$i<count($datoscpd);$i++){
	                	if(strlen($datoscpd[$i][1])>35){
	                		$descrip = substr($datoscpd[$i][1],0,34).'...';
	                	}else{
	                		$descrip = $datoscpd[$i][1];
	                	}		
	
	                	$ncodcon = substr($datoscpd[$i][0].'****************',0,10);
	                	
	                	$caddescrip = $ncodcon.$descrip;
	                	$cbo[$i]=array($datoscpd[$i][0].'|'.$datoscpd[$i][1].'|'.$datoscpd[$i][2].'|'.$datoscpd[$i][3],$caddescrip);
	                }
	                
	                
					$val[0] = array("div_title",$content, "html");
					$val[1] = array("cidpers",$cidpers, "html");
					$val[2] = array("nompers",$nompers, "html");
					$val[3] = array("cbconceptos",$func->ContenidoCombo($cbo,$cbo[0][0] ), "html");
					//$val[4]=array("montoconcepto",'{symbol:"", decimal:".", thousands:"",precision:2}',"maskMoney");//obs sale dollar
					$val[4]=array("busqxcodconcepto","","focus");
					$func->PintarValor($val);
				
					
					$evt[0] = array("cbconceptos", "change","MostrarDetalleConceptoPagosDiversos();");
					$evt[1] = array("cantidadconcepto", "keypress","return validarnumeros(event);");
					$evt[2] = array("btnagregarconcepto", "click","AgregarDetalleConceptoPagosDiversos();");
					$evt[3] = array("busqxcodconcepto", "keypress","return validarnumeros(event);");
				    $evt[4] = array("cobrar","click", "CobrarConceptoPagosDiversos();");
					$evt[5] = array("nuevorecibo", "click", "window.open('".$url."index.php/pagosdiversos?datospers=','_self');");
					$cadtempo = "BusqXCriterioConceptoPagosDiversos('1','".str_replace('"',"\'", $jsondatoscpd).'\')';
					$evt[6] = array("busqxcodconcepto", "change",$cadtempo);		
					$cadtempo2="BusqXCriterioConceptoPagosDiversos('2','".str_replace('"',"\'", $jsondatoscpd).'\')';
					$evt[7] = array("busqxnomconcepto", "change",$cadtempo2);	
					$evt[] = array('glosaconcepto','keypress','if(event.keyCode == 13){return false;}');
						
					$func->PintarEvento($evt);
					
					$din[0]=array("montoconcepto");
					$func->CampoDinero($din);
							
					}//fin del else para los datos enviados
		}else{
			$val[0] = array("show", "No tienes privilegios de cajero para este modulo", "html");
			$func->PintarValor($val);		
		}	
	}

	public function busqconceptopagodiversoAction()
	{   
		$this->_helper->getHelper('ajaxContext')->initContext();
		
		if ($this->getRequest()->isXmlHttpRequest())
		{
		$this->_helper->viewRenderer->setNoRender(); 
		$this->_helper->layout->disableLayout(); 
		
			$datoscpd = $this->_request->getPost('datoscpd');
			$datoscpd = str_replace("'", "\"", $datoscpd);
			
		
			//echo $datoscpd;
			
			$datos = json_decode($datoscpd);
			print_r($datos);
			            
			for($i=0;$i<count($datos);$i++){
                			if(strlen($datos[$i][1])>35){
                				$descrip = substr($datos[$i][1],0,34).'...';
                			}else{
                				$descrip = $datos[$i][1];
                			}		

                			$ncodcon = substr($datos[$i][0].'****************',0,10);
                			
                			$caddescrip = $ncodcon.$descrip;
                			
                	$cbo[$i]=array($datos[$i][0].'|'.$datos[$i][1].'|'.$datos[$i][2].'|'.$datos[$i][3],$caddescrip);
                	}
            $func = new Libreria_Pintar();
            $val[0] = array("cbconceptos",$func->ContenidoCombo($cbo,$cbo[0][0] ), "html");
            $func->PintarValor($val);
            
            $evt[0] = array("cbconceptos","change","MostrarDetalleConceptoPagosDiversos();");
            $evt[1] = array("cantidadconcepto","keypress","return validarnumeros(event);");
            $cadtempo = "BusqXCriterioConceptoPagosDiversos('1','".str_replace('"',"\'", $jsondatoscpd).'\')';
			$evt[2] = array("busqxcodconcepto","change",$cadtempo);		
			$cadtempo2="BusqXCriterioConceptoPagosDiversos('2','".str_replace('"',"\'", $jsondatoscpd).'\')';
			$evt[3] = array("busqxnomconcepto","change",$cadtempo2);
			$evt[4] = array("busqxcodconcepto","keypress","return validarnumeros(event);");
			$evt[5]	= array("btnagregarconcepto","click","AgregarDetalleConceptoPagosDiversos();");
			$func->PintarEvento($evt);
							
			$msk[0] = array("montoconcepto");
			$func->CampoDinero($msk);
			
		}
	}
	
	public function busqxcriterioconceptopagosdiversosAction()
	{   
		$this->_helper->getHelper('ajaxContext')->initContext();
		
					
			if ($this->getRequest()->isXmlHttpRequest())
			{
			$this->_helper->viewRenderer->setNoRender();
			$this->_helper->layout->disableLayout(); 
				
				$valor = strtoupper(trim($this->_request->getPost('valor')));
				$criterio = $this->_request->getPost('criterio');
				$datoscpd = $this->_request->getPost('datoscpd');
				$datoscpd = str_replace("'", "\"", $datoscpd);
				$datoscpd = str_replace("^", "&", $datoscpd);			
								
				$datos = json_decode($datoscpd);	
				
				$cont = '';
				
				if($valor == '' || $valor == null || strlen($valor) == 0){					
						for($i=0;$i<count($datos);$i++){
                				if(strlen($datos[$i][1])>35){
                					$descrip = substr($datos[$i][1],0,34).'...';
                				}else{
                					$descrip = $datos[$i][1];
                				}		

                				$ncodcon = substr($datos[$i][0].'****************',0,10);
                				
                				$caddescrip = $ncodcon.$descrip;
                				
                			$cont .='<option value="'.$datos[$i][0].'|'.$datos[$i][1].'|'.$datos[$i][2].'|'.$datos[$i][3].'">'.$caddescrip.'</option>';
                		}
				}else{		
					$b = 0;
					for($i=0;$i<count($datos);$i++){

						$valorbusq = '';
						if($criterio == '1'){
							$cadbusq = $datos[$i][0];
						}if($criterio == '2'){
							$cadbusq = strtoupper($datos[$i][1]);
						}
						
						if(ereg($valor,$cadbusq)){		
							$b++;				
	                			if(strlen($datos[$i][1])>35){
	                				$descrip = substr($datos[$i][1],0,34).'...';
	                			}else{
	                				$descrip = $datos[$i][1];
	                			}		
	                				
                				$ncodcon = substr($datos[$i][0].'****************',0,10);
                				
                				$caddescrip = $ncodcon.$descrip;
                			if($b == 1){
                			$cont .='<option value="'.$datos[$i][0].'|'.$datos[$i][1].'|'.$datos[$i][2].'|'.$datos[$i][3].'" selected="selected">'.$caddescrip.'</option>';
                			}else{	
                			$cont .='<option value="'.$datos[$i][0].'|'.$datos[$i][1].'|'.$datos[$i][2].'|'.$datos[$i][3].'">'.$caddescrip.'</option>';
                			}
						}
					}									
				}
				echo $cont;	
					
			}
	}
	
	public function agregarconceptopagodiversoAction()
	{   		
		$url = $this->view->util()->getPath();
		
		$this->_helper->getHelper('ajaxContext')->initContext();
		
		if ($this->getRequest()->isXmlHttpRequest())
		{
		//$this->_helper->viewRenderer->setNoRender(); 
			$this->_helper->layout->disableLayout(); 
		
			$cod = $this->_request->getPost('cod');
			$des = $this->_request->getPost('des');
			$cid = $this->_request->getPost('cid');
			$monto = $this->_request->getPost('monto');
			$cantidad = $this->_request->getPost('cantidad');
			$glosa = $this->_request->getPost('glosa');
					
			$data = new Zend_Session_Namespace('arrayconceptos');
			$arrayconceptos = $data->data;
			
			if($arrayconceptos == '' || $arrayconceptos == null || count($arrayconceptos)<=0){		
			   	$arrayconceptos[0][0]=$cod;
			   	$arrayconceptos[0][1]=$des;
			   	$arrayconceptos[0][2]=$cid;
			   	$arrayconceptos[0][3]=$monto*$cantidad;		
			   	$arrayconceptos[0][4]=$cantidad;
			   	$arrayconceptos[0][5]=$monto;   	
			   	$arrayconceptos[0][6]=$glosa;
			}else{
				$vcant = count($arrayconceptos);
				$b = '0';						
				for($i=0;$i<count($arrayconceptos);$i++){
					if($arrayconceptos[$i][0] == $cod && $arrayconceptos[$i][5] == $monto){
						$arrayconceptos[$i][3]=$arrayconceptos[$i][3]+$monto*$cantidad;
			   			$arrayconceptos[$i][4] = $arrayconceptos[$i][4]+$cantidad;
			   			$arrayconceptos[$i][6] = $glosa;
			   			$b = '1' ;
					}
				}
				if($b == '0'){
					$arrayconceptos[$vcant][0]=$cod;
				   	$arrayconceptos[$vcant][1]=$des;
				   	$arrayconceptos[$vcant][2]=$cid;
				   	$arrayconceptos[$vcant][3]=$monto*$cantidad;
				   	$arrayconceptos[$vcant][4]=$cantidad;
				   	$arrayconceptos[$vcant][5]=$monto;
				   	$arrayconceptos[$vcant][6]=$glosa;
				}

			}

			$data->data = $arrayconceptos;
			
			$func = new Libreria_Pintar();
			
			$detail = '<table width="500" border="0" cellspacing="0" cellpadding="0">';
			$total = 0;
			for($i=0; $i<count($arrayconceptos); $i++){
				if($i%2 == 0){
					$color = '';
				}else{
					$color = 'bgcolor="#D3D3D3"';
				}
				
				$total = $total + $arrayconceptos[$i][3]; 
			
				if(strlen($arrayconceptos[$i][1])>35){
					$descrip = substr($arrayconceptos[$i][1],0,34).'...';
				}else{
					$descrip = $arrayconceptos[$i][1];
				}

				$detail .= '<tr '.$color.' >';
				$detail .= '<td width="60" align="center">'.$arrayconceptos[$i][0].'</td>';
				$detail .= '<td width="240">'.$descrip.'</td>';
				$detail .= '<td width="30" align="center" >'.$arrayconceptos[$i][4].'</td>';
				$detail .= '<td width="70" align="center" >'.$arrayconceptos[$i][5].'</td>';
				$detail .= '<td width="70" align="center" >'.$arrayconceptos[$i][3].'</td>';
				$detail .= '<td width="30" align="center" ><img src="'.$url.'img/borrar.png" width="16" height="16" onclick="BorrarDetalleConceptoPagosDiversos('.$arrayconceptos[$i][0].','.$arrayconceptos[$i][5].')" /></td>';
				$detail .= '</tr>';

				if(trim($arrayconceptos[$i][6]) == '' || trim($arrayconceptos[$i][6]) == null){
							
				}else{
					$detail .= '<tr>';
					$detail .= '<td></td>';
					$detail .= '<td colspan="5"><hr /></td>';
					$detail .= '</tr>';
					$detail .= '<tr '.$color.' >';
					$detail .= '<td></td>';
					$detail .= '<td colspan="5"><b>Glosa: </b>'.$arrayconceptos[$i][6].'</td>';
					$detail .= '</tr>';
				}

			}
			$detail .= '</table>';

			$val[0] = array("detail", $detail, "html");
			$val[1] = array("ctotal", $total, "html");
			$func->PintarValor($val);
						
		}
		
	
	}
	
	public function borrarconceptopagodiversoAction()
	{   
		$this->_helper->getHelper('ajaxContext')->initContext();
		
		if ($this->getRequest()->isXmlHttpRequest())
		{
		//$this->_helper->viewRenderer->setNoRender();
			$this->_helper->layout->disableLayout();
		
			$url = $this->view->util()->getPath();
			
			$cod      = $this->_request->getPost('cod');
			$cantidad = $this->_request->getPost('cantidad');
			$monto = $this->_request->getPost('monto');
			
			$data = new Zend_Session_Namespace('arrayconceptos');
			$arrayconceptos = $data->data;
				
					//$vcant = count($arrayconceptos);
					
			for($i=0;$i<count($arrayconceptos);$i++){
				if($arrayconceptos[$i][0] == $cod && $arrayconceptos[$i][5] == $monto){
		   			$arrayconceptos[$i][3]=$arrayconceptos[$i][3]-($monto*$cantidad);
		   			$arrayconceptos[$i][4] = $arrayconceptos[$i][4]-($cantidad);
		   				if($arrayconceptos[$i][4] == '0' || $arrayconceptos[$i][4] == '' || $arrayconceptos[$i][4] == null){
		   					unset($arrayconceptos[$i]);
		   					$arrayconceptos = array_values($arrayconceptos);
		   				}
				}
			}

			$data->data = $arrayconceptos;

			$func = new Libreria_Pintar();

			$detail = '<table width="500" border="0" cellspacing="0" cellpadding="0">';
			$total = 0;
			for($i=0; $i<count($arrayconceptos); $i++){
				if($i%2 == 0){
					$color = '';
				}else{
					$color = 'bgcolor="#D3D3D3"';
				}
				
				$total = $total + $arrayconceptos[$i][3]; 
			
				if(strlen($arrayconceptos[$i][1])>35){
					$descrip = substr($arrayconceptos[$i][1],0,34).'...';
				}else{
					$descrip = $arrayconceptos[$i][1];
				}

				$detail .= '<tr '.$color.' >';
				$detail .= '<td width="60" align="center">'.$arrayconceptos[$i][0].'</td>';
				$detail .= '<td width="240">'.$descrip.'</td>';
				$detail .= '<td width="30" align="center" >'.$arrayconceptos[$i][4].'</td>';
				$detail .= '<td width="70" align="center" >'.$arrayconceptos[$i][5].'</td>';
				$detail .= '<td width="70" align="center" >'.$arrayconceptos[$i][3].'</td>';
				$detail .= '<td width="30" align="center" ><img src="'.$url.'img/borrar.png" width="16" height="16" onclick="BorrarDetalleConceptoPagosDiversos('.$arrayconceptos[$i][0].','.$arrayconceptos[$i][5].')" /></td>';
				$detail .= '</tr>';

				if(trim($arrayconceptos[$i][6]) == '' || trim($arrayconceptos[$i][6]) == null){
							
				}else{
					$detail .= '<tr>';
					$detail .= '<td></td>';
					$detail .= '<td colspan="5"><hr /></td>';
					$detail .= '</tr>';
					$detail .= '<tr '.$color.' >';
					$detail .= '<td></td>';
					$detail .= '<td colspan="5"><b>Glosa: </b>'.$arrayconceptos[$i][6].'</td>';
					$detail .= '</tr>';
				}

			}
			$detail .= '</table>';

			$val[0] = array("detail", $detail, "html");
			$val[1] = array("ctotal", $total, "html");
			$func->PintarValor($val);
		}
	}

	
	public function cobrarconceptopagodiversoAction()
	{   
		$this->_helper->getHelper('ajaxContext')->initContext();
		
			if ($this->getRequest()->isXmlHttpRequest())
			{
			$this->_helper->viewRenderer->setNoRender(); 
			$this->_helper->layout->disableLayout(); 
				
				$dconceptos = new Zend_Session_Namespace('arrayconceptos');
				$arrayconceptos = $dconceptos->data;
				
				if($arrayconceptos == '' || $arrayconceptos == null || count($arrayconceptos)<=0){
					echo '<font color="#FF0000">Ingresar Concepto(s) a cobrar.</font>';
				}else{
					
					$ddatosuserlog = new Zend_Session_Namespace('datosuserlog');				
					$cidpers = $ddatosuserlog->cidpers;			
					$codcajero = $ddatosuserlog->codcajero;	
					
					$ddatacontri = new Zend_Session_Namespace('contribuyente');
					$cidcontri = $ddatacontri->cidcontri;
					$nomcontri = 	$ddatacontri->nomcontri ;
									
					$url = $this->view->util()->getPath();
					
					$cad = ''; //CADENA QUE TIENE LOS DATOS DEL RECIBO
					$corr = 1;
					for($i = 0 ; $i<count($arrayconceptos) ; $i++){
						if($arrayconceptos[$i][4]>0){	
							if($arrayconceptos[$i][5]>0){
								$cad .= $corr.'^'; //correlativo
								$cad .= $cidcontri.'^'; //codpersona
								$cad .= $arrayconceptos[$i][2].'^'; //codconcepto
								$cad .= $arrayconceptos[$i][4].'^'; //cantidad por concepto
								$cad .= $arrayconceptos[$i][5].'^'; //precio unitario
								$cad .= '1'.'^'; 					//estado 1 = cancelado
								$cad .= str_replace('\'','',$nomcontri).'^';				//observacion o nombre de la persona
								$cad .= '*'.$arrayconceptos[$i][6].'^'; //glosa
								$cad .= $cidpers.'^';				//codigo cajero
								$cad .= $codcajero.'~';				//codigo cajero
								
								$corr++;
								
							}												
						}
					}
					$cad = substr($cad,0,strlen($cad)-1);
	
					//echo $cad;
					
					$nombrestore = 'tesoreria.cobrar_pagosdiversos';
					$arraydatos[0]= $cad;
					$arraydatos[1]= '~';
					$arraydatos[2]= '^';					
					
					$cn = new Model_DataAdapter();
					$datos = $cn->ejec_store_procedura_sql($nombrestore,$arraydatos);
					
					$nrorecibo = str_pad($datos[0][0], 12, "0", STR_PAD_LEFT);
					
					echo ' Se genero el recibo nro. <b>'.$nrorecibo.'</b><br />';
					
					$func = new Libreria_Pintar();
					if($nrorecibo != '000000000000'){
						$hab[0] = array("cobrar",false);						
					}else{
						$hab[0] = array("cobrar",true);
					}
					
					$func->HabilitarComponente($hab);
					
					echo ' <script language=\'javascript\'>
								window.open(\''.$url.'index.php/pagosdiversos/imprimirreciboconceptopagodiverso/?nrorecibo='.$nrorecibo.'\',"recibo","width=570, height=500, scrollbars=no, menubar=no, location=no, resizable=no,status =no,directories=no") 
								
							    function ventanaSecundaria(){ 
									ventana=window.open(\''.$url.'index.php/pagosdiversos/imprimirreciboconceptopagodiverso/?nrorecibo='.$nrorecibo.'\',"recibo","width=570, height=500, scrollbars=no, menubar=no, location=no, resizable=no,status =no,directories=no") 
									ventana.focus()
								} 
						    </script>					    
						   
						 <input type="button" name="imprimir" id="imprimir" value="Imprimir recibo" onclick="ventanaSecundaria()" />
						 <br />
						 <br />';
				}				
			}
	}
	
	public function imprimirreciboconceptopagodiversoAction()
	{   
			//$this->_helper->viewRenderer->setNoRender(); 
			$this->_helper->layout->disableLayout(); 
			echo $this->view->util()->getScript("js/common"); 
				
			$nrorecibo = $this->_request->getParam('nrorecibo','');
			$txtduplicado = $this->_request->getParam('duplicado','');

				if(strlen($nrorecibo) == 12 ){
					$nombrestore = 'tesoreria.imprimir_recibo_pagodiverso';
					$arraydatos[0]= $nrorecibo;
					
					$cn = new Model_DataAdapter();
					$datos = $cn->ejec_store_procedura_sql($nombrestore,$arraydatos);
					$func = new Libreria_Pintar();
					if(count($datos)> 0){
						//print_r($datos);
						$detalle ='<table width="100%" border="0" cellspacing="0" cellpadding="0">';
						for($i=0;$i<count($datos);$i++){
							$detalle .='<tr>';
							$detalle .='<td colspan="2"  width="170" class="Estilo8">'.$datos[$i][4].'</td>';
							$detalle .='<td width="45" align="right" class="Estilo6">'.number_format($datos[$i][6],'2','.','').'</td>';
							$detalle .='</tr>';
							$detalle .=' <tr>';
							$detalle .=' <td colspan="3" class="Estilo6">'.$datos[$i][8].'</td>';
							$detalle .=' </tr>';
						}
						$detalle .='</table>';
						
						$func->PintarLibrerias();
						$val[0] = array("duplicado",$txtduplicado,"html");
						$val[1] = array("datos0",$datos[0][0],"html");
						$val[2] = array("datos1",$datos[0][1],"html");
						$val[3] = array("datos2",$datos[0][2],"html");
						$val[4] = array("datos9",number_format($datos[0][7],'2','.',''),"html");
						$val[5] = array("datos10","Fecha: ".$datos[0][10],"html");
						$val[6] = array("datos11","Cajero: ".$datos[0][11],"html");
						$val[7] = array("detalle",$detalle,"html");												
					}else{					
						$val[] = array("detalle",'<div align="center">NO EXISTEN DATOS...</div>',"html");
					}
					$func->PintarValor($val);
									
					
				}else{
					echo 'Ingresar número de recibo valido';
				}				
			
			//}
	}
	
	public function submodulopagopiscinaindexAction()
	{   
		
		$dcodcajero = new Zend_Session_Namespace ( 'codcajero' );
		$codcajero = $dcodcajero->data;
		
		$func = new Libreria_Pintar ();
		if ($codcajero > 0) {
			
			$url = $this->view->util()->getPath();
			
			$nombrestore = 'general.buscar_concepto';
			$arraydatos [0] = array ('@id', '' );
			$arraydatos [1] = array ('@descrip', 'PISCINA' );
			$cn = new Model_DataAdapter ();
			$datoscpd = $cn->ejec_store_procedura_sql ( $nombrestore, $arraydatos );
			
			for($i = 0; $i < count ( $datoscpd ); $i ++) {
				if (strlen ( $datoscpd [$i] [1] ) > 35) {
					$descrip = substr ( $datoscpd [$i] [1], 0, 34 ) . '...';
				} else {
					$descrip = $datoscpd [$i] [1];
				}
				
				$ncodcon = substr ( $datoscpd [$i] [0] . ' => ', 0, 10 );
				
				$caddescrip = $ncodcon . $descrip;
				if ($i == 0) {
					$def = $i;
				}
				$combo [$i] = array ($datoscpd [$i] [2], $caddescrip );
			
			}
			$val [0] = array ("cbconceptos", $func->ContenidoCombo ( $combo, $combo [$def] [0] ), "html" );
			$val [1] = array ("btnnuevo", "disabled','disabled", "attr" );
			$func->PintarValor ( $val );
			
			//$evt[0] = array("txtadulto", "keypress", "return validarnumeros(event);");
			//$evt[1] = array("txtninio", "keypress", "return validarnumeros(event);");
			$evt [0] = array ("btncobrar", "click", "CobrarConceptoPiscinaPagosDiversos();" );
			$evt [1] = array ("btnnuevo", "click", "window.open('".$url."index.php/pagosdiversos/submodulopagopiscinaindex','_self');" );
			
			$func->PintarEvento ( $evt );
		
		} else {
			$val [0] = array ("showsmppi", "No tienes privilegios de cajero para este modulo", "html" );
			$func->PintarValor ( $val );
			
		//echo 'No tienes privilegios de cajero para este modulo.';
		} //fin condicion de cajero
	}
	
	public function cobrarconceptopagodiversopiscinaAction()
	{   
		
		//solo para piscina!!! xD!
		$this->_helper->getHelper('ajaxContext')->initContext();
		
			if ($this->getRequest()->isXmlHttpRequest())
			{
			$this->_helper->viewRenderer->setNoRender(); 
			$this->_helper->layout->disableLayout(); 
								
				
					$dcodcajero = new Zend_Session_Namespace('codcajero');
					$codcajero = $dcodcajero->data  ;
					
					$duserlogin = new Zend_Session_Namespace('userlogin');
					$userlogin = $duserlogin->data;

					$url = $this->view->util()->getPath();
					
					$cidpers = '_________1';
					$nompers = 'Piscina Municipal';
					$concepto = $this->_request->getPost('cod');
					$cantidadadulto = $this->_request->getPost('cantadulto');
					$cantidadninio = $this->_request->getPost('cantninio');
					$precioadulto = $this->_request->getPost('montoadulto');
					$precioninio = $this->_request->getPost('montoninio');
					$glosaadulto = $cantidadadulto.' entrada(s) para adulto';
					$glosaninio = $cantidadninio.' entrada(s) para nino';
					
					$cad = ''; //CADENA QUE TIENE LOS DATOS DEL RECIBO
						if($cantidadadulto > 0 && $precioadulto > 0){
							$cad .= $cidpers.'^'; //codpersona x
							$cad .= $concepto.'^'; //codconcepto x
							$cad .= $cantidadadulto.'^'; //cantidad por concepto x
							$cad .= $precioadulto.'^'; //precio unitario x
							$cad .= '1'.'^'; 					//estado 1 = cancelado 
							$cad .= $nompers.'^';				//observacion o nombre de la persona x
							$cad .= $glosaadulto.'^'; //glosa x
							$cad .= $userlogin.'^';				//codigo cajero x
							$cad .= $codcajero.'~';					//nombre cajero x
						}
						if($cantidadninio > 0 && $precioninio > 0){
							$cad .= $cidpers.'^'; //codpersona x
							$cad .= $concepto.'^'; //codconcepto x
							$cad .= $cantidadninio.'^'; //cantidad por concepto x
							$cad .= $precioninio.'^'; //precio unitario x
							$cad .= '1'.'^'; 					//estado 1 = cancelado 
							$cad .= $nompers.'^';				//observacion o nombre de la persona x
							$cad .= $glosaninio.'^'; //glosa x
							$cad .= $userlogin.'^';				//codigo cajero x
							$cad .= $codcajero.'~';					//nombre cajero x
						}
																		 
					if(strlen($cad)>0){
						$cad = substr($cad,0,strlen($cad)-1);
						
						$nombrestore = 'tesoreria.realizar_pago';
						$arraydatos[0]= array('@ccajero',$codcajero);
						$arraydatos[1]= array('@crecibo',$cad);
						
						$cn = new Model_DataAdapter();
						$datos = $cn->ejec_store_procedura_sql($nombrestore,$arraydatos);
						
						$nrorecibo = str_pad($datos[0][0], 12, "0", STR_PAD_LEFT);
						
						echo ' Se genero el recibo nro. <b>'.$nrorecibo.'</b><br />';
						
						if($nrorecibo != '000000000000'){
						
							$hab[0] = array("btncobrar", false);
							$hab[1] = array("btnnuevo", true);
						}else{
							
							$hab[0] = array("btncobrar", true);
							$hab[1] = array("btnnuevo", false);
						}
						$func = new Libreria_Pintar();
						$func->HabilitarComponente($hab);
						
						echo ' <script language=\'javascript\'>
									window.open(\''.$url.'index.php/pagosdiversos/imprimirreciboconceptopagodiverso/?nrorecibo='.$nrorecibo.'\',"recibo","width=570, height=500, scrollbars=yes, menubar=no, location=no, resizable=no,status =no,directories=no") 
									
								    function ventanaSecundaria(){ 
										ventana=window.open(\''.$url.'index.php/pagosdiversos/imprimirreciboconceptopagodiverso/?nrorecibo='.$nrorecibo.'\',"recibo","width=570, height=500, scrollbars=no, menubar=no, location=no, resizable=no,status =no,directories=no") 
										ventana.focus()
									} 
							    </script>					    
							   
							 <input type="button" name="imprimir" id="imprimir" value="Imprimir recibo" onclick="ventanaSecundaria()" />
							 <br />
							 <br />';
								
					}else{
						echo 'no grabo nada';
					}
			}
	}
	
	
	
}



