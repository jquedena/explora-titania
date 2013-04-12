<?php
require_once 'Zend/Controller/Action.php';

class PagosdiversosController extends Zend_Controller_Action {
	
	public function init() {
		$this->view->util()->registerScriptJSController($this->getRequest());	
	}
	
	private function imprimeConceptos($conceptos) {
		$items = null;
		for($i=0; $i<count($conceptos); $i++){
			$conceptos[$i][1] = trim($conceptos[$i][1]);
			if(strlen($conceptos[$i][1]) > 90){
				$descripcion = substr($conceptos[$i][1], 0, 89).'...';
			}else{
				$descripcion = $conceptos[$i][1];
			}
			$codigo = substr($conceptos[$i][0].'****************',0,10);
		
			$item = $codigo."   ".$descripcion;
			$items[$i]=array($conceptos[$i][0].'|'.$conceptos[$i][1].'|'.$conceptos[$i][2].'|'.$conceptos[$i][3], $item);
		}
		return $items;
	}

	private function imprimeDetalleSeleccionado($detalle) {
		$detail = '';
		$total = 0;
		
		for($i=0; $i<count($detalle); $i++){
			$total = $total + $detalle[$i][3];
		
			if(strlen($detalle[$i][1])>90){
				$descrip = substr($detalle[$i][1], 0, 89).'...';
			}else{
				$descrip = $detalle[$i][1];
			}
		
			$detail .= '<tr>';
			$detail .= '<td style="width: 85px" align="center">'.$detalle[$i][0].'</td>';
			$detail .= '<td>'.$descrip.'</td>';
			$detail .= '<td style="width: 50px;" align="center" >'.$detalle[$i][4].'</td>';
			$detail .= '<td style="width: 70px" align="center" >'.$detalle[$i][5].'</td>';
			$detail .= '<td style="width: 70px" align="center" >'.number_format($detalle[$i][3], 2, '.', ',').'</td>';
			$detail .= '<td style="width: 30px" align="center" ><img src="'.$this->view->util()->getImage('b_drop.png').'" onclick="BorrarDetalleConceptoPagosDiversos('.$detalle[$i][0].','.$detalle[$i][5].')" /></td>';
			$detail .= '</tr>';
		
			if(trim($detalle[$i][6]) != '' && trim($detalle[$i][6]) != null){
				$detail .= '<tr>';
				$detail .= '<td></td>';
				$detail .= '<td colspan="5"><b>Glosa: </b>'.$detalle[$i][6].'</td>';
				$detail .= '</tr>';
				$detail .= '<tr>';
				$detail .= '<td></td>';
				$detail .= '<td colspan="5"><hr /></td>';
				$detail .= '</tr>';
			}
		}

		$val[0] = array('tblDetalle tbody', $detail, 'html');
		$val[1] = array('rowTotal', number_format($total, 2, '.', ','), 'html');
		
		return $val;
	}
	
	public function indexAction() {
		$url = $this->view->util()->getPath();
/*
		$dcodcajero = new Zend_Session_Namespace('codcajero');
		$codcajero  = $dcodcajero->data;
*/	
		$ddatosuserlog = new Zend_Session_Namespace('datosuserlog');
		$codcajero = $ddatosuserlog->codcajero;
		//echo '<'.$codcajero.'>';
		//$codcajero = '99';
		$func = new Libreria_Pintar();

		if($codcajero>0){
			$datospers = $this->_request->getParam('datospers','');
			if($datospers == ''){
				header('location:'.$url.'index.php/busqpers/?tit=Pagos Diversos&url='.$url.'index.php/pagosdiversos/?datospers=',true);
			}else{
					
				$data = new Zend_Session_Namespace('arrayconceptos');
				$data->data = '';
					
				#detalle de pago ventanita
				$ddetallepago = new Zend_Session_Namespace ( 'detallepago' );
				$ddetallepago->data = '';
				
				#pagos arbitrios predios
				$dcadgrabacion = new Zend_Session_Namespace ('cadgrabacion');
				$dcadgrabacion->data='';
				
				
				list($cidpers, $nompers) = explode('|', $datospers);
					
				$ddatacontri = new Zend_Session_Namespace('contribuyente');
				$ddatacontri->cidcontri = $cidpers ;
				$ddatacontri->nomcontri = $nompers ;
					
				$cn = new Model_DataAdapter();
				
				$nombrestore0 = '"public"."obt_mconten"';
				$arraydatos0[0]= '';
				$arraydatos0[1]= '1000000492';
				$datosAreas = $cn->ejec_store_procedura_sql($nombrestore0,$arraydatos0);
				
								
				$nombrestore = '"tesoreria"."buscar_concepto"';
				$arraydatos[0]= '';
				$arraydatos[1]= '';
				$datoscpd = $cn->ejec_store_procedura_sql($nombrestore,$arraydatos);
				$jsondatoscpd = json_encode($datoscpd, JSON_HEX_TAG | JSON_HEX_APOS | JSON_HEX_QUOT | JSON_HEX_AMP);

				$content = '';
				if($cidpers=='_________1'){
					$content .= '<b>Venta Libre</b>';
				}
				
				$cbo = $this->imprimeConceptos($datoscpd);
				
				$val[0] = array("div_title",$content, "html");
				$val[1] = array("cidpers",$cidpers, "html");
				$val[2] = array("nompers",$nompers, "html");
				$val[3] = array("cbconceptos",$func->ContenidoCombo($cbo, $cbo[0][0]), "html");
				//$val[3] = array("cbconceptos",$func->ContenidoCombo($cbo, '9999999999'), "html");
				$val[4] = array('cbareas', $func->ContenidoCombo($datosAreas, $datosAreas[0][0]), 'html');
				$val[5] = array("cbareas","","focus");
				
				
				$func->PintarValor($val);
				
				$cadtempo = "BusqXCriterioConceptoPagosDiversos('1','".str_replace('"',"\'", $jsondatoscpd).'\')';
				$cadtempo2 = "BusqXCriterioConceptoPagosDiversos('2','".str_replace('"',"\'", $jsondatoscpd).'\')';
				
				$cadtempxarea ="FiltrarConceptosxAreas('".str_replace('"',"\'", $jsondatoscpd).'\')';
				$evt[0] = array("cbconceptos", "change","MostrarDetalleConceptoPagosDiversos();");
				$evt[1] = array("cantidadconcepto", "keypress","return validarnumeros(event);");
				$evt[2] = array("btnagregarconcepto", "click","AgregarDetalleConceptoPagosDiversos();");
				$evt[3] = array("busqxcodconcepto", "keypress","return validarnumeros(event);");
				
				//$evt[4] = array("cobrar","click", "CobrarConceptoPagosDiversos();");
				$evt[4] = array("cobrar","click", "DetallePagoConceptoPagosDiversos();");
				
				$evt[5] = array("nuevorecibo", "click", "window.open('".$url."index.php/pagosdiversos?datospers=','_self');");
				$evt[6] = array("busqxcodconcepto", "change", $cadtempo);
				$evt[7] = array("busqxnomconcepto", "change",$cadtempo2);
				$evt[8] = array('glosaconcepto','keypress','if(event.keyCode == 13){return false;}');
				$evt[9] = array("cbareas", "change",$cadtempxarea);
				
				$fn[] = array("MostrarDetalleConceptoPagosDiversos();");
				$func->PintarEvento($evt);
				
				$din[0]=array("montoconcepto");
				$func->CampoDinero($din);
				$func->EjecutarFuncion($fn);
			} // Fin del else para los datos enviados
		}else{
			$val[0] = array("show", "No tienes privilegios de cajero para este modulo", "html");
			$func->PintarValor($val);
		}
	}

	public function busqconceptopagodiversoAction() {
		$this->_helper->getHelper('ajaxContext')->initContext();

		if ($this->getRequest()->isXmlHttpRequest()) {
			$this->_helper->viewRenderer->setNoRender();
			$this->_helper->layout->disableLayout();
			
			$datoscpd = $this->_request->getPost('datoscpd');
			$datoscpd = str_replace("'", "\"", $datoscpd);
			
			$datos = json_decode($datoscpd);
			$cbo = $this->imprimeConceptos($datos);
			
			$func = new Libreria_Pintar();
			$val[0] = array("cbconceptos",$func->ContenidoCombo($cbo,$cbo[0][0] ), "html");
			$func->PintarValor($val);
			
			$cadtempo1 = "BusqXCriterioConceptoPagosDiversos('1','".str_replace('"',"\'", $jsondatoscpd).'\')';
			$cadtempo2 = "BusqXCriterioConceptoPagosDiversos('2','".str_replace('"',"\'", $jsondatoscpd).'\')';
			$evt[0] = array("cbconceptos","change","MostrarDetalleConceptoPagosDiversos();");
			$evt[1] = array("cantidadconcepto","keypress","return validarnumeros(event);");
			$evt[2] = array("busqxcodconcepto","change",$cadtempo1);
			$evt[3] = array("busqxnomconcepto","change",$cadtempo2);
			$evt[4] = array("busqxcodconcepto","keypress","return validarnumeros(event);");
			$evt[5]	= array("btnagregarconcepto","click","AgregarDetalleConceptoPagosDiversos();");
			$func->PintarEvento($evt);
			
			$msk[0] = array("montoconcepto");
			$func->CampoDinero($msk);
		}
	}

	public function busqxcriterioconceptopagosdiversosAction() {
		$this->_helper->getHelper('ajaxContext')->initContext();

		if ($this->getRequest()->isXmlHttpRequest()) {
			$this->_helper->viewRenderer->setNoRender();
			$this->_helper->layout->disableLayout();

			$valor = strtoupper(trim($this->_request->getPost('valor')));
			$criterio = $this->_request->getPost('criterio');
			$datoscpd = $this->_request->getPost('datoscpd');
			$area = $this->_request->getPost('area');
			
			$datoscpd = str_replace("'", "\"", $datoscpd);
			$datoscpd = str_replace("^", "&", $datoscpd);

			$datos = json_decode($datoscpd);

			$cont = '';
			if($criterio == '3'){
				$valor = ($area=='9999999999'?'':$area);
			}
			
			if($valor == '' || $valor == null || strlen($valor) == 0) {
				for($i=0;$i<count($datos);$i++){
					if(strlen($datos[$i][1])>90){
						$descrip = substr($datos[$i][1],0,89).'...';
					}else{
						$descrip = $datos[$i][1];
					}
					$ncodcon = substr($datos[$i][0].'****************',0,10);
					$caddescrip = $ncodcon."   ".$descrip;
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
					}if($criterio == '3'){
						$cadbusq = $datos[$i][4];
					}
					
					//if(ereg($valor,$cadbusq)){
					if(preg_match('/'.$valor.'/', $cadbusq)){
					//preg_match('/'.$patron.'/', $cadena_texto);
						$b++;
						if(strlen($datos[$i][1])>90){
							$descrip = substr($datos[$i][1],0,89).'...';
						}else{
							$descrip = $datos[$i][1];
						}
						
						$ncodcon = substr($datos[$i][0].'****************',0,10);
						$caddescrip = $ncodcon."   ".$descrip;
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

	public function agregarconceptopagodiversoAction() {
		$url = $this->view->util()->getPath();
		$this->_helper->getHelper('ajaxContext')->initContext();

		if ($this->getRequest()->isXmlHttpRequest()) {
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
				$arrayconceptos[0][0] = $cod;
				$arrayconceptos[0][1] = $des;
				$arrayconceptos[0][2] = $cid;
				$arrayconceptos[0][3] = $monto * $cantidad;
				$arrayconceptos[0][4] = $cantidad;
				$arrayconceptos[0][5] = $monto;
				$arrayconceptos[0][6] = $glosa;
			}else{
				$vcant = count($arrayconceptos);
				$b = '0';
				for($i=0;$i<count($arrayconceptos);$i++){
					if($arrayconceptos[$i][0] == $cod && $arrayconceptos[$i][5] == $monto){
						$arrayconceptos[$i][3] = $arrayconceptos[$i][3] + $monto * $cantidad;
						$arrayconceptos[$i][4] = $arrayconceptos[$i][4] + $cantidad;
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
			
			$val = $this->imprimeDetalleSeleccionado($arrayconceptos);
			
			$func = new Libreria_Pintar();
			$func->IniciaScript();
			$func->PintarValor($val);
			$func->FinScript();
		}
	}

	public function borrarconceptopagodiversoAction() {
		$this->_helper->getHelper('ajaxContext')->initContext();
		if ($this->getRequest()->isXmlHttpRequest()) {
			$this->_helper->layout->disableLayout();

			$url = $this->view->util()->getPath();
				
			$cod      = $this->_request->getPost('cod');
			$cantidad = $this->_request->getPost('cantidad');
			$monto = $this->_request->getPost('monto');
				
			$data = new Zend_Session_Namespace('arrayconceptos');
			$arrayconceptos = $data->data;
				
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
			$val = $this->imprimeDetalleSeleccionado($arrayconceptos);
			$func->PintarValor($val);
		}
	}


	public function cobrarconceptopagodiversoAction() {
		$this->_helper->getHelper('ajaxContext')->initContext();

		if ($this->getRequest()->isXmlHttpRequest()) {
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
				$userlogin = $ddatosuserlog->userlogin;
				$cidapertura=$ddatosuserlog->cidapertura;
				
				
				$ddatacontri = new Zend_Session_Namespace('contribuyente');
				$cidcontri = $ddatacontri->cidcontri;
				$nomcontri = $ddatacontri->nomcontri ;
					
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
							$cad .= str_replace('\'','',$nomcontri).'^'; //observacion o nombre de la persona
							$cad .= '*'.$arrayconceptos[$i][6].'^'; //glosa
							$cad .= $userlogin.'^'; //login
							$cad .= $codcajero.'~'; //codigo cajero

							$corr++;
						}
					}
				}
				$cad = substr($cad,0,strlen($cad)-1);
				
				
				/*Armando Detalle de pago*/
					$ddetallepago = new Zend_Session_Namespace ( 'detallepago' );
					$detallepago = $ddetallepago->data;
					
					$xmldetallepago = '';
					/*
					 0 - ctippag=''0000007831''
					1 - dnrodoc=''1234********5678''
					2 - nnroope=''123456''
					3 - nmontot=''300.00''
					*/
					for($i = 0; $i<count($detallepago) ; $i++){
						//$xmldetallepago .= '<r tfp="'.$detallepago[$i][0].'" monto="'.number_format ($detallepago[$i][3], '2', '.', '' ).'" nrodoc="'.$detallepago[$i][1].'" nroope="'.$detallepago[$i][2].'"></r>';
						$xmldetallepago .= $detallepago[$i][0].'^'.number_format ($detallepago[$i][3], '2', '.', '' ).'^'.$detallepago[$i][1].'^'.$detallepago[$i][2].'~';
					}
					
					$xmldetallepago = substr ( $xmldetallepago, 0, strlen ( $xmldetallepago ) - 1 );
					echo "<textarea>".$xmldetallepago."</textarea>";
				/*Armando Detalle de pago*/
				
				$nombrestore = 'tesoreria.cobrar_pagosdiversos';
				$arraydatos[0]= $cad;
				$arraydatos[1]= $xmldetallepago;
				$arraydatos[2]= '~';
				$arraydatos[3]= '^';
				$arraydatos[4]= $cidapertura;
				$cn = new Model_DataAdapter();
				//$datos = $cn->ejec_store_procedura_sql($nombrestore,$arraydatos);
					
				$nrorecibo = str_pad($datos[0][0], 12, "0", STR_PAD_LEFT);
								
				if($datos[0][0] == 0) {
					echo "<br/><b>".$datos[0][1]."</b>";
				} else {
					echo 'Se genero el recibo nro. <b>'.$nrorecibo.'</b><br />';
				}
				
				if($nrorecibo != '000000000000'){
					echo '<script language=\'javascript\'>
						window.open(\''.$url.'index.php/pagosdiversos/imprimirreciboconceptopagodiverso/?nrorecibo='.$nrorecibo.'\',"recibo","width=570, height=500, scrollbars=no, menubar=no, location=no, resizable=no,status =no,directories=no")
						
						function ventanaSecundaria(){
							ventana=window.open(\''.$url.'index.php/pagosdiversos/imprimirreciboconceptopagodiverso/?nrorecibo='.$nrorecibo.'\',"recibo","width=570, height=500, scrollbars=no, menubar=no, location=no, resizable=no,status =no,directories=no")
							ventana.focus()
						}
						
						$(function(){
							$("input:submit, input:button, input:reset, button").button();
							$("#cobrar").css({"display": "none"});
						});
						</script>
						
						<input type="button" name="imprimir" id="imprimir" value="Imprimir recibo" onclick="ventanaSecundaria()" />
						<br/>
						<br/>';
				}		
			}
		}
	}

	public function imprimirreciboconceptopagodiversoAction() {
		$this->_helper->layout->disableLayout();
		echo $this->view->util()->getScript("js/common");
		
		$nrorecibo = $this->_request->getParam('nrorecibo','');
		$txtduplicado = $this->_request->getParam('duplicado','');
		echo $this->view->util()->getScript("js/app/ui");
		if(strlen($nrorecibo) == 12 ){
			$nombrestore = 'tesoreria.imprimir_recibo_pagodiverso';
			$arraydatos[0]= $nrorecibo;
		
			$cn = new Model_DataAdapter();
			$datos = $cn->ejec_store_procedura_sql($nombrestore,$arraydatos);
			$func = new Libreria_Pintar();
			if(count($datos) > 0){
				$detalle ='<table width="100%" border="0" cellspacing="0" cellpadding="0">';
				for($i=0;$i<count($datos);$i++){
					$detalle .='<tr>';
					$detalle .='<td colspan="2"  width="170" class="Estilo8">'.$datos[$i][4].'</td>';
					$detalle .='<td width="45" align="right" class="Estilo6">'.number_format($datos[$i][7],'2','.','').'</td>';
					$detalle .='</tr>';
					$detalle .='<tr>';
					$detalle .='<td colspan="3" class="Estilo6">'.$datos[$i][8].'</td>';
					$detalle .='</tr>';
				}
				$detalle .='</table>';
		
				$val[0] = array("duplicado",$txtduplicado,"html");
				$val[1] = array("datos0",$datos[0][0],"html");
				$val[2] = array("datos1",$datos[0][1],"html");
				$val[3] = array("datos2",$datos[0][2],"html");
				$val[4] = array("datos9",number_format($datos[0][9],'2','.',''),"html");
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
	}
}



