<?php

/**
 * CajaduplicadosrecibosController
 * 
 * @author
 * @version  
 */

require_once 'Zend/Controller/Action.php';

class CajaduplicadosrecibosController extends Zend_Controller_Action {

	public function init() {
		$this->view->util()->registerScriptJSController($this->getRequest());
		$this->view->util()->registerLeaveControllerAction($this->getRequest());
	}
	
	public function indexAction() {
		
//		$ddatosuserlog = new Zend_Session_Namespace('datosuserlog');				
//	    $codcajero=	$ddatosuserlog->codcajero ;
		
		$func = new Libreria_Pintar ();
//		if ($codcajero > 0) {			
			$evt [0] = array ("btngenerar", "click", "datosrecibo();" );
			$evt [1] = array ("txtrecibo", "keypress", "if(event.keyCode == 13){datosrecibo();} else{return validarnumeros(event)}" );
			$func->PintarEvento ( $evt );
//		} else {
//			$val [0] = array ("showing", "No tienes privilegios de cajero para este modulo.", "html" );
//			$func->PintarValor ( $val );
//		}
	}
	
	public function datosreciboAction(){
		$this->_helper->getHelper ( 'ajaxContext' )->initContext ();
		//$this->_helper->viewRenderer->setNoRender();
		$this->_helper->layout->disableLayout ();
		if ($this->getRequest ()->isXmlHttpRequest ()) {
			$nrorecibo = trim($this->_request->getPost('nrorecibo'));
			$nombrestore = 'tesoreria.obt_estadorecibo';
			$arraydatos[0]= $nrorecibo;
			$cn = new Model_DataAdapter();
			$datosrecibo = $cn->ejec_store_procedura_sql($nombrestore,$arraydatos);
			
			$func = new Libreria_Pintar();
			if(count($datosrecibo)>0){				
				$val[] = array('c_nrorec',$datosrecibo[0][0],'html');
				$val[] = array('c_estado',$datosrecibo[0][8],'html');
				$val[] = array('c_fecharec',$datosrecibo[0][3],'html');
				$val[] = array('c_cajero',$datosrecibo[0][5],'html');
				$val[] = array('c_monto',$datosrecibo[0][7],'html');
				$evt[] = array('btnimprimir','click','imprimirduplicadorecibo(\''.$datosrecibo[0][0].'\',\''.$datosrecibo[0][6].'\',\'DUPLICADO\');');
				$func->PintarEvento($evt);				
				
					if($datosrecibo[0][1] == '0'){
						$hab[] = array('btnimprimir',false);
						$func->HabilitarComponente($hab);
					}
				
			}else{
				$val[] = array('showing','Recibo no existe...','html'); 
			}
			$func->PintarValor($val);
		}
	}
	
	
	
	public function recibosbusqAction(){
			$func = new Libreria_Pintar();
//			$evt [1] = array("txtnrecibo", "keypress", "if(event.keyCode  == 13){alert('presiono enter xD');}else{return validarnumeros(event)}" );
			$evt [2] = array("rdnrecibo","change","llenar_cajas(this.value);");
			$evt [3] = array("rdfiltro","change","llenar_cajas(this.value);");
			$evt [4] = array("rdccontri","change","llenar_cajas(this.value);");
			$evt [5] = array("btnbuscar","click","recibosbusq();");
			$evt [6] = array("btnlimpiar","click","$('input:text').val('');$('#details').html('');");
			$func->PintarEvento($evt);
	}
	public function recibosfiltroAction(){
		$this->_helper->getHelper ( 'ajaxContext' )->initContext ();
		$this->_helper->viewRenderer->setNoRender();
			$this->_helper->layout->disableLayout ();
		if ($this->getRequest ()->isXmlHttpRequest ()) {
			$durl = new Zend_Session_Namespace('url');
			$url =$durl->data;
			/*nrecibo="+nrecibo+
				"nombre="+nombre+
				"fecha1="+fecha1+
				"fecha2="+fecha2+
				"cpago="+cpago+
				"ccontri="+ccontri,*/
			$nrecibo = trim($this->_request->getPost('nrecibo'));
			$nombre = strtoupper(trim($this->_request->getPost('nombre')));
			$fecha1 = trim($this->_request->getPost('fecha1'));
			$fecha2 = trim($this->_request->getPost('fecha2'));
			$cpago = trim($this->_request->getPost('cpago'));
			$ccontri = trim($this->_request->getPost('ccontri'));
			$op = $this->_request->getPost('op');
			$concept = $this->_request->getPost('concept');
			//echo $nrecibo.$nombre.$fecha1.$fecha2.$cpago.$ccontri;
			/*@numcom as varchar(12)='',
				@cidpers as varchar(10)='',
				@nom as varchar(max)='',
				@fecha1 as date='01/01/1990',
				@fecha2 as date='31/12/3000',
				@concpago as varchar(max)=''*/
			$nombrestore = 'pxda_buscarrecibos';
			$arraydatos [0]= array("@op",$op);
			$arraydatos [1]= array("@numcom",$nrecibo);
			$arraydatos [2]= array("@cidpers",$ccontri);
			$arraydatos [3]= array("@nom",$nombre);
			$arraydatos [4]= array("@fecha1",$fecha1);
			$arraydatos [5]= array("@fecha2",$fecha2);
			$arraydatos [6]= array("@concept",$concept);
			$cn = new Model_DataAdapter ();
			$datos = $cn->ejec_store_procedura_sql ( $nombrestore, $arraydatos );
			if(!is_array($datos)){	
				echo '<br><br><div align="center">No existen Recibos</div>';
				exit;
			}
			$details = '<table width="100%" border="0" >';
			for($i=0;$i<count($datos);$i++){
				$details .= '<tr>';
				$details .= '<td width="14%" align="center"><span style="font-size: 11px;">'.$datos[$i][0].'</span></td>';
				$details .= '<td width="29%"><span style="font-size: 11px;">'.$datos[$i][1].'</span></td>';
				$details .= '<td width="12%" align="center"><span style="font-size: 11px;">'.$datos[$i][2].'</span></td>';
				$details .= '<td width="8%" align="right"><span style="font-size: 11px;">'.number_format($datos[$i][3],2).'</span></td>';
				//$details .= '<td width="6%" align="center">ver</td>';
				$details .= '<td  width="8%" align="center"><a href="javascript:void(0);" title="Ver" ><img src="'.$url.'image/busqueda.png" width="20px" onclick="recibosimp(\''.$datos[$i][0].'\');"></a>';
				$details .= '</tr>';
				$details .= '<tr><td colspan="6"><hr></td></tr>';
			}
			$details .='</table>';
			echo $details;
			$func = new Libreria_Pintar();
		}
	}
	public function reciboimpAction(){
		$this->_helper->layout->disableLayout ();
		$func = new Libreria_Pintar();
		$func->PintarLibrerias();
		$recibo = $this->_request->getParam('recibo', '');
		$nombrestore = 'pxda_buscarrecibos';
		$arraydatos [0]= array("@op",'3');
		$arraydatos [1]= array("@numcom",$recibo);
		$arraydatos [2]= array("@cidpers",'');
		$arraydatos [3]= array("@nom",'');
		$arraydatos [4]= array("@fecha1",'');
		$arraydatos [5]= array("@fecha2",'');
		$cn = new Model_DataAdapter ();
		$datos = $cn->ejec_store_procedura_sql( $nombrestore, $arraydatos );
		//print_r($datos);
		//print_r($datos);

		$total=0;
		$details = '<table width="100%" border="0" >';
		$details .= '<tr >';
		$details .= '<th width="27%" align="left"><span style="font-size: 9px;">Descript.</span></th>';
		$details .= '<th width="27%" align="left"><span style="font-size: 9px;">Nom Part.</span></th>';
		$details .= '<th width="27%" align="left"><span style="font-size: 9px;">Partida</span></th>';
		$details .= '<th width="8%" align="right"><span style="font-size: 9px;">Total</span></th>';
		$details .= '</tr>';
		for($i=0;$i<count($datos);$i++){
			$total = $total +$datos[$i][6];
			$details .= '<tr>';
			//$details .= '<td width="14%" align="center"><span style="font-size: 9px;">'.$datos[$i][0].'</span></td>';
			//$details .= '<td width="29%"><span style="font-size: 9px;">'.$datos[$i][1].'</span></td>';
			$details .= '<td width="27%"><span style="font-size: 9px;">'.$datos[$i][2].'</span></td>';
			$details .= '<td width="27%"><span style="font-size: 9px;">'.$datos[$i][3].'</span></td>';
			$details .= '<td width="27%"><span style="font-size: 9px;">'.$datos[$i][4].'</span></td>';
			//$details .= '<td width="12%" align="center"><span style="font-size: 9px;">'.$datos[$i][3].'</span></td>';
			$details .= '<td width="8%" align="right"><span style="font-size: 9px;">'.number_format($datos[$i][6],2).'</span></td>';
			$details .= '</tr>';
		}
		$details .='</table>';
		$val[0]=array("detalle",$details,"html");
		$val[1]=array("tdrecibo",$datos[0][0],"html");
		$val[2]=array("tdcodigo",$datos[0][7],"html");
		$val[3]=array("tdnombre",$datos[0][1],"html");
		$val[4]=array("tdtotal",number_format($total,2),"html");
		$val[5]=array("tdfecha","Fecha : ".$datos[0][5],"html");
		$val[6]=array("tdcajer","Cajera : ".$datos[0][8]."-".$datos[0][9],"html");

		$func->PintarValor($val);
	}
	

}

