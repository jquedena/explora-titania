<?php

/**
 * sencilleraController
 *
 * @author
 * @version
 */

require_once 'Zend/Controller/Action.php';

class sencilleraController extends Zend_Controller_Action {

	public function init() {
		$this->view->util()->registerScriptJSController($this->getRequest());
	}

	public function indexAction() {
		// TODO Auto-generated sencilleraController::indexAction() default action
	}
	public function sencilleraAction() {



	}

	public function habsencilleraAction(){
		$this->_helper->getHelper ( 'ajaxContext' )->initContext ();
		if ($this->getRequest ()->isXmlHttpRequest ()) {
			$this->_helper->layout->disableLayout();
			$pidaper = $this->_request->getPost('idaper');
			$pdtcajeros = $this->_request->getPost('dtcajeros');
			$pestado = $this->_request->getPost('estado');

			if ($pdtcajeros!=""){
				$arrcajeros = explode(",", $pdtcajeros);
				if (count($arrcajeros)==1){
					$datocajero= explode('|',$arrcajeros[0]);
					$cod_cajero = $datocajero[0];
					$st_estado = $datocajero[1];
					$nrocajacajero = $datocajero[2];
						
					$cn = new Model_DataAdapter ();
					$nombrestore = '"public".obt_mconten';
					$parametros [ 0] = '' ;
					$parametros [ 1] = '1000000140' ;
					$datosmconten = $cn-> ejec_store_procedura_sql ( $nombrestore, $parametros );
					$nombrestore = '"public"."pxcobrowww"';
					$arraydatos [0] = '2';
					$arraydatos [1] = '';
					$arraydatos [2] = '';
					$datosfecha = $cn->ejec_store_procedura_sql( $nombrestore, $arraydatos );
					$dfecha = explode ( " ", $datosfecha[0][0]);
					$date = $dfecha[0];
						
					$bodytbl ='';
					$row=0;
					for ($i=0;count($datosmconten)>$i;$i++){
						if ($datosmconten[$i][0]!=$datosmconten[$i][2]){
								
							$bodytbl .='<tr>';
							$bodytbl .='<td style="padding-left:10px;"><input type="hidden" name="det['.$row.'][idmconten]" value="'.$datosmconten[$i][0].'">';
							$bodytbl .= $datosmconten[$i][1].'</td>';//descripcion
							$bodytbl .='<td align="right"><span id="mt_montorow">'.$datosmconten[$i][5].'</span></td>';//montos
							$bodytbl .='<td align="right"><input type="text" name="det['.$row.'][mt_cant]" style="width :50px;text-align: right;" onkeypress="return validarnumeros(event);" class="mt_cant" id="mt_cant" value="0" /></td>';//cantidad
							$bodytbl .='<td align="right"><input type="text" name="det['.$row.'][mt_totalrow]" style="width :50px;text-align: right;" class="mt_total" id="mt_totalrow" name="mt_totalrow" value="0.00" readonly="readonly" /></td>';//mt_total
							$bodytbl .='</tr>';
							$row++;
						}
					}
					$val[]=array("tbl_monedas tbody",$bodytbl,"html");
					$val[] = array('txtfech_proc', $date, 'val');
					$val[] = array('txtnom_cajero', $nrocajacajero, 'val');
					$val[] = array('hdid_apert', $pidaper, 'val');
					$val[] = array('hdid_cajero',$cod_cajero,'val');
					$val[] = array('hdid_estado',$st_estado,'val');
						
					$js[] = array('$("#txtfech_proc").datepicker({showOn: "button", buttonImage: jQuery.scriptPath + "img/calendar.gif",	buttonImageOnly: true});');
					$js[] = array('$("#txtfech_proc").datepicker("option", "dateFormat", "yy-mm-dd");');
					$js[] = array('mouseHover("tbl_monedas");');
					$js[] = array('$(".mt_cant").on("keyup",sumary_totals);');
					$js[] = array("$('#btnprocsencillero').button({ icons: {secondary:'ui-icon-disk'} })");
						
					$din[] = array("tbl_monedas .mt_total");
					//$din[] = array("tbl_monedas .mt_cant");
						
					$evt[] = array("btnprocsencillero","click","guardarsencillero();");
						
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

	public function sencilleraguardarAction(){
		$this->_helper->layout->disableLayout ();
		$this->_helper->viewRenderer->setNoRender ();
		$this->_helper->getHelper ( 'ajaxContext' )->initContext ();

		if ($this->getRequest ()->isXmlHttpRequest ()) {

			$det = $this->_request->getPost ( 'det' );
			$hdid_apert = $this->_request->getPost ( 'vhdid_apert' );
			$hdid_cajero = $this->_request->getPost ( 'vhdid_cajero' );
			$txtfech_proc = $this->_request->getPost ( 'vtxtfech_proc' );
			$hdid_estado = $this->_request->getPost ( 'vhdid_estado' );
			
			
			$ddatosuserlog = new Zend_Session_Namespace('datosuserlog');
			$cidpers = $ddatosuserlog->cidpers;
			$userlogin = $ddatosuserlog->userlogin;
				$cad = ''; 
			$corr = 1;
			for($i = 0 ; $i<count($det) ; $i++){
				$cad .= $corr.'^'; //correlativo del idsigma
				$cad .= $hdid_apert.'^'; //aperturacaja
				$cad .= '0000000001^'; //ctipope
				$cad .= $det[$i]['idmconten'].'^'; //ctipmon
				$cad .= $det[$i]['mt_cant'].'^'; //ncantid
				$cad .= $det[$i]['mt_totalrow'].'^'; //ntotals
				$cad .= $txtfech_proc.'^'; //dfecpro
				$cad .= '1^'; //nestado
				$cad .= $userlogin.'^'; //user
				$cad .= $this->view->util()->getHost().'~'; //host
	
				$corr++;
			}
			
			$cad = substr($cad,0,strlen($cad)-1);
			$cn = new Model_DataAdapter ();
			$nombrestore = '"tesoreria".guardarmonedas';
			$parametros [0] = $cad ;
			$parametros [1] = '~' ;
			$parametros [2] = '^';
			$datos = $cn->ejec_store_procedura_sql ( $nombrestore, $parametros );
			
			if($datos[0][0] == '1'){
				echo "Guardado Correctamente ";
				//echo '<script language=\"JavaScript\">window.open(\''.$this->view->util()->getLink('mantenimientos/mconten').'\', \'_self\')</script>';
			}else{
				echo 'Error en el guardado...';
			}
		}
	}

	public function consultasencilleraAction(){


	}
}

