<?php

/**
 * RentasController
 * 
 * @author
 * @version 
 */

require_once 'Zend/Controller/Action.php';

class RentasController extends Zend_Controller_Action {
	/**
	 * The default action - show the home page
	 */
	
	public function init() {
		$this->view->util()->registerScriptJSController($this->getRequest());
	}
	
	public function indexAction() {
		
		$nombrestore = 'seguridad.login';
		$arraydatos[]= 'MALOIS';
		$arraydatos[]= '123456';
		
		$cn = new Model_DataAdapter();
		$datos = $cn->ejec_store_procedura_sql_array($nombrestore,$arraydatos);		
		
		print_r($datos);
		
	}
	
	public function datosAction(){
		//$evt[] = array('btndetpredio000001','click','$("#ventanadetallepredio" ).dialog( "open" );');

//		$this->view->util()->registerScriptJSController($this->getRequest());
//		$url = $this->view->util()->getPath();
//		$datospers = $this->_request->getParam ( 'datospers', '' );
//			if ($datospers == '') {
//				header ( 'location:' . $url . 'index.php/busqpers/?tit=Datos Contribuyente&url=' . $url . 'index.php/rentas/datos/?datospers=', true );
//			} else {				
//				list ( $cidpers, $nompers, $dir , $fechaproyeccion ) = explode ( '|', $datospers );
//				echo $this->view->inlineScript()->appendScript('pintardatoscontribuyente("'.$cidpers .'","'. $nompers .'","'. $dir .'")');
//				echo $this->view->inlineScript()->appendScript('detalleprediollenarcomponentes()');
//				echo $this->view->inlineScript()->appendScript('limpiarformulariodetallepredio()');				
//			}
	}
	
	public function datos1Action(){
		$this->view->util()->registerScriptJSController($this->getRequest());
//		$url = $this->view->util()->getPath();
//		$datospers = $this->_request->getParam ( 'datospers', '' );
//			if ($datospers == '') {
//				header ( 'location:' . $url . 'index.php/busqpers/?tit=Datos Contribuyente&url=' . $url . 'index.php/rentas/datos/?datospers=', true );
//			} else {				
//				list ( $cidpers, $nompers, $dir , $fechaproyeccion ) = explode ( '|', $datospers );
//				echo $this->view->inlineScript()->appendScript('pintardatoscontribuyente("'.$cidpers .'","'. $nompers .'","'. $dir .'")');
				echo $this->view->inlineScript()->appendScript('detalleprediollenarcomponentes()');
				echo $this->view->inlineScript()->appendScript('limpiarformulariodetallepredio()');				
//			}
	}
	
	public function datoscontribuyenteAction(){
		$this->_helper->viewRenderer->setNoRender ();
		$this->_helper->layout->disableLayout ();

		$codpers   = $this->_request->getParam ( 'codpers', '' );
		$nombre    = $this->_request->getParam ( 'nombre', '' );
		$codpred   = $this->_request->getParam ( 'codpred', '' );
		$direccion = $this->_request->getParam ( 'direccion', '' );
		
		$array['mensaje'] = "OK";
		$array['result']['contribuyente'] = array("codigo"=> $codpers, "nombre"=> "Miguel", "ape_paterno"=> "Villanueva", "ape_materno"=> "Gonzalez", "tipoDocumento"=> "", "nroDocumento"=> "", "dirfiscal"=> "Asoc Juan Linares Rojas D-15");
		
		$predios[] = array("codigo"=> "000001", "tipo"=> "X", "direccion"=> "mi casita 01", "uso"=> "CASA"    ,"porcentaje" => '100', "fechaadq"=>"21/03/1990" , "fechabaj"=>"" ,"valorepredio"=> "100.00", "valorafecto"=> "100.00", "impuestoanual"=> "10.00" , "valuo"=>"876.00" );
		$predios[] = array("codigo"=> "000002", "tipo"=> "Y", "direccion"=> "mi casita 02", "uso"=> "COMERCIO","porcentaje" => '100', "fechaadq"=>"26/12/2010" , "fechabaj"=>"26/01/2012" ,"valorepredio"=> "200.00", "valorafecto"=> "200.00", "impuestoanual"=> "10.00" , "valuo"=>"123.00" );
		$predios[] = array("codigo"=> "000003", "tipo"=> "Z", "direccion"=> "mi casita 03", "uso"=> "IGLESIA" ,"porcentaje" => '100', "fechaadq"=>"26/01/2012" , "fechabaj"=>"" ,"valorepredio"=> "6000.00", "valorafecto"=> "0.00", "impuestoanual"=> "0.00" , "valuo"=>"321654.00" );
		
		$array['result']['predios']	= $predios;	

		echo json_encode($array);
	}
	
	public function buscarcontribuyentexnombreAction(){
		$this->_helper->viewRenderer->setNoRender ();
		$this->_helper->layout->disableLayout ();
		$array['mensaje'] = "OK";
		
		$nombre = $this->_request->getParam ( 'nombre', '' );
		
		$array['result']['contribuyentes'][0]['codpers'] = '125589';
		$array['result']['contribuyentes'][0]['nombre'] = 'BARZOLA ROJAS DIANA';
		$array['result']['contribuyentes'][0]['dirfiscal'] = 'MZ.: N LT.: 13 - COOP. DE VIV. COVITI';
		
		$array['result']['contribuyentes'][1]['codpers'] = '456132';
		$array['result']['contribuyentes'][1]['nombre'] = 'ARENAS GONZALES GABRIEL G';
		$array['result']['contribuyentes'][1]['dirfiscal'] = ' AV 12 DE OCTUBRE MZ N LT 13 COOP. DE VIV ';
		
		$array['result']['contribuyentes'][2]['codpers'] = '008080';
		$array['result']['contribuyentes'][2]['nombre'] = 'VILLANUEVA GONZALEZ MIGUEL';
		$array['result']['contribuyentes'][2]['dirfiscal'] = ' CABO GRP. JUAN LINARES ROJAS D-15 ';
		
		echo json_encode($array);
	}
	
	public function buscarcontribuyentexdirAction(){
		$this->_helper->viewRenderer->setNoRender ();
		$this->_helper->layout->disableLayout ();
				
		$dir = $this->_request->getParam ( 'dir', '' );
		
		$array['mensaje'] = "OK";
		$array['result']['direccion'][0]['codpred'] = '000001';
		$array['result']['direccion'][0]['nombrevia'] = 'Via 1';
		$array['result']['direccion'][0]['nro'] = '1';
		$array['result']['direccion'][0]['depart'] = '';
		$array['result']['direccion'][0]['interior'] = '';
		$array['result']['direccion'][0]['letra'] = '';
		$array['result']['direccion'][0]['estac'] = '';
		$array['result']['direccion'][0]['depos'] = '';
		$array['result']['direccion'][0]['mz'] = '';
		$array['result']['direccion'][0]['lote'] = '';
		$array['result']['direccion'][0]['codpers'] = '008080';
		$array['result']['direccion'][0]['nompers'] = 'VILLANUEVA GONZALEZ MIGUEL';
		
		$array['result']['direccion'][1]['codpred'] = '000001';
		$array['result']['direccion'][1]['nombrevia'] = 'Via 2';
		$array['result']['direccion'][1]['nro'] = '2';
		$array['result']['direccion'][1]['depart'] = '';
		$array['result']['direccion'][1]['interior'] = '';
		$array['result']['direccion'][1]['letra'] = '';
		$array['result']['direccion'][1]['estac'] = '';
		$array['result']['direccion'][1]['depos'] = '';
		$array['result']['direccion'][1]['mz'] = '';
		$array['result']['direccion'][1]['lote'] = '';
		$array['result']['direccion'][1]['codpers'] = '008081';
		$array['result']['direccion'][1]['nompers'] = 'ARENAS GONZALES GABRIEL G';
		
		echo json_encode($array);
	}
	
	public function detalleprediollenarcomponentesAction(){
		$this->_helper->viewRenderer->setNoRender ();
		$this->_helper->layout->disableLayout ();
		
		$array['mensaje'] = "OK";
//		$array['result']['usopredio'] = array(array('codigo'=>'00001','descripcion'=>'casa habitacion'),array('codigo'=>'00002','descripcion'=>'comercio'));		
		
		$array['result']['condpropiedad'] = array(array('00001','A'),array('00002','B'),array('00003','C'));
		$array['result']['estadopredio'] = array(array('00001','A'),array('00002','B'),array('00003','C'));
		$array['result']['tipopredio'] = array(array('00001','A'),array('00002','B'),array('00003','C'));
		$array['result']['clasifpredio'] = array(array('00001','A'),array('00002','B'),array('00003','C'));
		$array['result']['usopredio'] = array(array('00001','casa habitacion'),array('00002','comercio'));
		$array['result']['usoespecifico'] = array(array('00001','A'),array('00002','B'),array('00003','C'));
		$array['result']['ubicparque'] = array(array('00001','A'),array('00002','B'),array('00003','C'));
		$array['result']['tipoinafec'] = array(array('00001','A'),array('00002','B'),array('00003','C'));
		
		$array['result']['piso_material'] = array(array('00001','A'),array('00002','B'),array('00003','C'));
		$array['result']['piso_estado'] = array(array('00001','A'),array('00002','B'),array('00003','C'));
		$array['result']['piso_documento'] = array(array('00001','A'),array('00002','B'),array('00003','C'));
		$array['result']['piso_motivo'] = array(array('00001','A'),array('00002','B'),array('00003','C'));
		
		$array['result']['instalacion_material'] = array(array('00001','A'),array('00002','B'),array('00003','C'));
		$array['result']['instalacion_estado'] = array(array('00001','A'),array('00002','B'),array('00003','C'));
		$array['result']['instalacion_documento'] = array(array('00001','A'),array('00002','B'),array('00003','C'));
		$array['result']['instalacion_motivo'] = array(array('00001','A'),array('00002','B'),array('00003','C'));
		
		$array['result']['caract_piso'] = array(array('00001','A'),array('00002','B'),array('00003','C'));
		
		$array['result']['instal_unid_medida'] = array(array('00001','A'),array('00002','B'),array('00003','C'));
		
		$array['result']['rustico_clasifpredio'] = array(array('00001','TIERRAS APTAS PARA CULTIVO LIMPIO CON RIEGO POR GRAVEDAD Y AGUA SUPERFICIAL'),array('00002','TIERRAS APTAS PARA CULTIVO LIMPIO CON RIEGO PROVENIENTE DE BOMBEO DE AGUA SUPERF'),array('00003','TIERRAS APTAS PARA CULTIVO LIMPIO CON RIEGO PROVENIENTE DE BOMBEO DE AGUA SUBT'),array('00004','TIERRAS APTAS PARA CULTIVO PERMANENTE CON RIEGO'),array('00005','TIERRAS APTAS PARA PASTOREO BAJO RIEGO'),array('00006','TIERRAS ERIAZAS'));
		$array['result']['rustico_categpredio'] = array(array('00001','1'),array('00002','2'),array('00003','3'),array('00004','4'),array('00005','5'),array('00006','6'));
		
		echo json_encode($array);
	}
	
	public function detallepredioAction(){
		$this->_helper->viewRenderer->setNoRender ();
		$this->_helper->layout->disableLayout ();
		
		$codpred = $this->_request->getParam ( 'codpred', '' );
		
		$array['mensaje'] = "OK";
		$array['result']['codpredio'] = $codpred;
		$array['result']['dirpred'] = 'mi casita 01';
		$array['result']['fechaadq'] = '21/03/1990';
		$array['result']['fechabaj'] = '';
		$array['result']['fecharecalculo'] = '27/03/2012';
		$array['result']['codcondpropiedad'] = '00001';
		$array['result']['codestadopredio'] = '00003';
		$array['result']['codtipopredio'] = '00002';
		$array['result']['codclasifpredio'] = '00003';
		$array['result']['codusopredio'] = '00002';
		$array['result']['codusoespecifico'] = '00003';
		
		$array['result']['areaterreno'] = '3000';
		$array['result']['porcterreno'] = '100';
		$array['result']['totalarea'] = '3000';
		$array['result']['areacomun'] = '0';
		$array['result']['porccomun'] = '100';
		$array['result']['totalcomun'] = '0';
		$array['result']['frente'] = '9.00';
		$array['result']['arancel'] = '213454';
		$array['result']['porccond'] = '100';		
		$array['result']['codubicparque'] = '00001';
		
		$array['result']['codtipoinafec'] = '00002';
		$array['result']['inafec_exped'] = '123456-2012';
		$array['result']['inafec_resol'] = '123-dfd-dtgfsd-2012';
		$array['result']['inafec_fecharesol'] = '01/07/2012';
		$array['result']['inafec_baselegal'] = '001';
		$array['result']['inafec_observ'] = '-';
		$array['result']['inafec_fechaini'] = '01/07/2012';
		$array['result']['inafec_fechafin'] = '31/12/2012';
		$array['result']['inafec_ip'] = '100';
		$array['result']['inafec_lc'] = '0';
		$array['result']['inafec_rb'] = '0';
		$array['result']['inafec_lp'] = '0';
		$array['result']['inafec_pj'] = '0';
		$array['result']['inafec_sg'] = '0';
		
		$array['result']['pisos'][0]['nivel'] = '2';
		$array['result']['pisos'][0]['anio_const'] = '2010';
		$array['result']['pisos'][0]['antiguedad'] = '';
		$array['result']['pisos'][0]['codmaterial'] = '00001';
		$array['result']['pisos'][0]['material'] = '';
		$array['result']['pisos'][0]['codestado'] = '00001';
		$array['result']['pisos'][0]['estado'] = '';
		$array['result']['pisos'][0]['cod_mu'] = '00001';
		$array['result']['pisos'][0]['mu'] = 'A';
		$array['result']['pisos'][0]['cod_te'] = '00002';
		$array['result']['pisos'][0]['te'] = 'B';
		$array['result']['pisos'][0]['cod_pi'] = '00003';
		$array['result']['pisos'][0]['pi'] = 'C';
		$array['result']['pisos'][0]['cod_pv'] = '00003';
		$array['result']['pisos'][0]['pv'] = 'D';
		$array['result']['pisos'][0]['cod_rv'] = '00002';
		$array['result']['pisos'][0]['rv'] = 'E';
		$array['result']['pisos'][0]['cod_ba'] = '00001';
		$array['result']['pisos'][0]['ba'] = 'F';
		$array['result']['pisos'][0]['cod_in'] = '00003';
		$array['result']['pisos'][0]['in'] = 'G';
		$array['result']['pisos'][0]['area_const'] = '1';
		$array['result']['pisos'][0]['val_unit_m2'] = '';
		$array['result']['pisos'][0]['inc_5'] = '';
		$array['result']['pisos'][0]['porc_deprec'] = '';
		$array['result']['pisos'][0]['deprec'] = '';
		$array['result']['pisos'][0]['val_unit_deprec'] = '';
		$array['result']['pisos'][0]['val_area_const'] = '2';
		$array['result']['pisos'][0]['porc_area_comun'] = '';
		$array['result']['pisos'][0]['val_area_comun'] = '';
		$array['result']['pisos'][0]['valor_final'] = '0';
		$array['result']['pisos'][0]['ult_recalculo'] = '24/07/2012';
		$array['result']['pisos'][0]['codtipodoc'] = '00001';
		$array['result']['pisos'][0]['tipodoc'] = '001-123456';
		$array['result']['pisos'][0]['codmotivo'] = '00001';
		$array['result']['pisos'][0]['fechadoc'] = '24/07/2012';

		$array['result']['pisos'][1]['nivel'] = '5';
		$array['result']['pisos'][1]['anio_const'] = '2010';
		$array['result']['pisos'][1]['antiguedad'] = '';
		$array['result']['pisos'][1]['codmaterial'] = '00001';
		$array['result']['pisos'][1]['material'] = '';
		$array['result']['pisos'][1]['codestado'] = '00001';
		$array['result']['pisos'][1]['estado'] = '';
		$array['result']['pisos'][1]['cod_mu'] = '00001';
		$array['result']['pisos'][1]['mu'] = 'A';
		$array['result']['pisos'][1]['cod_te'] = '00002';
		$array['result']['pisos'][1]['te'] = 'B';
		$array['result']['pisos'][1]['cod_pi'] = '00003';
		$array['result']['pisos'][1]['pi'] = 'C';
		$array['result']['pisos'][1]['cod_pv'] = '00003';
		$array['result']['pisos'][1]['pv'] = 'D';
		$array['result']['pisos'][1]['cod_rv'] = '00002';
		$array['result']['pisos'][1]['rv'] = 'E';
		$array['result']['pisos'][1]['cod_ba'] = '00001';
		$array['result']['pisos'][1]['ba'] = 'F';
		$array['result']['pisos'][1]['cod_in'] = '00003';
		$array['result']['pisos'][1]['in'] = 'G';
		$array['result']['pisos'][1]['area_const'] = '1';
		$array['result']['pisos'][1]['val_unit_m2'] = '';
		$array['result']['pisos'][1]['inc_5'] = '';
		$array['result']['pisos'][1]['porc_deprec'] = '';
		$array['result']['pisos'][1]['deprec'] = '';
		$array['result']['pisos'][1]['val_unit_deprec'] = '';
		$array['result']['pisos'][1]['val_area_const'] = '2';
		$array['result']['pisos'][1]['porc_area_comun'] = '';
		$array['result']['pisos'][1]['val_area_comun'] = '';
		$array['result']['pisos'][1]['valor_final'] = '0';
		$array['result']['pisos'][1]['ult_recalculo'] = '24/07/2012';
		$array['result']['pisos'][1]['codtipodoc'] = '00001';
		$array['result']['pisos'][1]['tipodoc'] = '001-123456';
		$array['result']['pisos'][1]['codmotivo'] = '00001';
		$array['result']['pisos'][1]['fechado'] = '24/07/2012';
		
		$array['result']['instalacion'][0]['anio_const'] = '2010';
		$array['result']['instalacion'][0]['antiguedad'] = '5';
		$array['result']['instalacion'][0]['codmaterial'] = '00001';
		$array['result']['instalacion'][0]['material'] = '';
		$array['result']['instalacion'][0]['codestado'] = '00001';
		$array['result']['instalacion'][0]['estado'] = '';
		$array['result']['instalacion'][0]['descripcion'] = 'xxx';
		$array['result']['instalacion'][0]['altura'] = '123';
		$array['result']['instalacion'][0]['ancho'] = '654';
		$array['result']['instalacion'][0]['largo'] = '987';
		$array['result']['instalacion'][0]['cod_unid_medida'] = '00001';
		$array['result']['instalacion'][0]['unid_medida'] = 'metros cuadr.';		
		$array['result']['instalacion'][0]['area_const'] = '1';
		$array['result']['instalacion'][0]['val_unit_m2'] = '';
		$array['result']['instalacion'][0]['porc_deprec'] = '';
		$array['result']['instalacion'][0]['deprec'] = '';
		$array['result']['instalacion'][0]['val_unit_deprec'] = '';
		$array['result']['instalacion'][0]['val_area_const'] = '2';
		$array['result']['instalacion'][0]['porc_area_comun'] = '';
		$array['result']['instalacion'][0]['val_area_comun'] = '';
		$array['result']['instalacion'][0]['valor_final'] = '0';
		$array['result']['instalacion'][0]['ult_recalculo'] = '24/07/2012';
		$array['result']['instalacion'][0]['codtipodoc'] = '00001';
		$array['result']['instalacion'][0]['tipodoc'] = '001-123456';
		$array['result']['instalacion'][0]['codmotivo'] = '00001';
		$array['result']['instalacion'][0]['fechadoc'] = '24/07/2012';
		
		$array['result']['instalacion'][1]['anio_const'] = '2011';
		$array['result']['instalacion'][1]['antiguedad'] = '8';
		$array['result']['instalacion'][1]['codmaterial'] = '00001';
		$array['result']['instalacion'][1]['material'] = '';
		$array['result']['instalacion'][1]['codestado'] = '00001';
		$array['result']['instalacion'][1]['estado'] = '';
		$array['result']['instalacion'][1]['descripcion'] = 'xxx';
		$array['result']['instalacion'][1]['altura'] = '123';
		$array['result']['instalacion'][1]['ancho'] = '654';
		$array['result']['instalacion'][1]['largo'] = '987';
		$array['result']['instalacion'][1]['cod_unid_medida'] = '00001';
		$array['result']['instalacion'][1]['unid_medida'] = 'metros cuadr.';		
		$array['result']['instalacion'][1]['area_const'] = '1';
		$array['result']['instalacion'][1]['val_unit_m2'] = '';
		$array['result']['instalacion'][1]['porc_deprec'] = '';
		$array['result']['instalacion'][1]['deprec'] = '';
		$array['result']['instalacion'][1]['val_unit_deprec'] = '';
		$array['result']['instalacion'][1]['val_area_const'] = '2';
		$array['result']['instalacion'][1]['porc_area_comun'] = '';
		$array['result']['instalacion'][1]['val_area_comun'] = '';
		$array['result']['instalacion'][1]['valor_final'] = '0';
		$array['result']['instalacion'][1]['ult_recalculo'] = '24/07/2012';
		$array['result']['instalacion'][1]['codtipodoc'] = '00001';
		$array['result']['instalacion'][1]['tipodoc'] = '001-123456';
		$array['result']['instalacion'][1]['codmotivo'] = '00001';
		$array['result']['instalacion'][1]['fechadoc'] = '24/07/2012';
		
		$array['result']['instalacion'][2]['anio_const'] = '2012';
		$array['result']['instalacion'][2]['antiguedad'] = '15';
		$array['result']['instalacion'][2]['codmaterial'] = '00001';
		$array['result']['instalacion'][2]['material'] = '';
		$array['result']['instalacion'][2]['codestado'] = '00001';
		$array['result']['instalacion'][2]['estado'] = '';
		$array['result']['instalacion'][2]['descripcion'] = 'xxx';
		$array['result']['instalacion'][2]['altura'] = '123';
		$array['result']['instalacion'][2]['ancho'] = '654';
		$array['result']['instalacion'][2]['largo'] = '987';
		$array['result']['instalacion'][2]['cod_unid_medida'] = '00001';
		$array['result']['instalacion'][2]['unid_medida'] = 'metros cuadr.';		
		$array['result']['instalacion'][2]['area_const'] = '1';
		$array['result']['instalacion'][2]['val_unit_m2'] = '';
		$array['result']['instalacion'][2]['porc_deprec'] = '';
		$array['result']['instalacion'][2]['deprec'] = '';
		$array['result']['instalacion'][2]['val_unit_deprec'] = '';
		$array['result']['instalacion'][2]['val_area_const'] = '2';
		$array['result']['instalacion'][2]['porc_area_comun'] = '';
		$array['result']['instalacion'][2]['val_area_comun'] = '';
		$array['result']['instalacion'][2]['valor_final'] = '0';
		$array['result']['instalacion'][2]['ult_recalculo'] = '24/07/2012';
		$array['result']['instalacion'][2]['codtipodoc'] = '00001';
		$array['result']['instalacion'][2]['tipodoc'] = '001-123456';
		$array['result']['instalacion'][2]['codmotivo'] = '00001';
		$array['result']['instalacion'][2]['fechadoc'] = '24/07/2012';
		
		echo json_encode($array);
	}
	
}

