<?php
require_once 'Zend/Controller/Action.php';

class MantenimientosController extends Zend_Controller_Action {

	public function init() {
		$this->view->util()->registerScriptJSController($this->getRequest());
	}
	
	public function indexAction() {
	}
	
	public function buscarhijosmconten($padre,$depth,$arraydatos){
		
		$url = $this->view->util()->getPath();
		
		$depth++;
		
		for($i=0;$i<count($arraydatos);$i++){
			$idsigma = $arraydatos[$i][0];
			$vdescri = $arraydatos[$i][1];
			$cidtabl = $arraydatos[$i][2];
			$hijos= $arraydatos[$i][3];
			$ctipdat = $arraydatos[$i][4];
			$vobser = $arraydatos[$i][5];
			$nlongit= $arraydatos[$i][6];
			$ndecima= $arraydatos[$i][7];
			$ndefault= $arraydatos[$i][8];
			$nestado= $arraydatos[$i][9];
			
			if($idsigma != $cidtabl && $cidtabl == $padre){
				if($hijos == 0){
					$array[] = array ('text' => $vdescri, 'id' => $idsigma, 'depth' => $depth, 'leaf' => true, 'checked' => false, 'children' => '', 'enlace' => $idsigma, 'canthijos' => $hijos, 'icon'=> (($nestado==1)?'':$url.'css/images/drop-no.gif') );
				}else{
					//$array = '';
					$arrayhijos = $this->buscarhijosmconten($idsigma,$depth,$arraydatos);
					$array[] = array ('text' => $vdescri, 'id' => $idsigma, 'depth' => $depth, 'leaf' => false, 'checked' => false, 'children' => $arrayhijos, 'enlace' => $idsigma, 'canthijos' => $hijos , 'icon'=> (($nestado==1)?'':$url.'css/images/drop-no.gif'));
				}
				
			}
		}
		
		return $array;
	}
	
	public function pintararbolconten(){
		
		$url = $this->view->util()->getPath();
		
		$nombrestore = '"public".obt_mconten';
		$parametros [0] = '' ;
		$parametros [1] = '' ;
		
		$cn = new Model_DataAdapter ();
		$datos = $cn->ejec_store_procedura_sql ( $nombrestore, $parametros );
		
		$depth = 1;
		
		for($i=0;$i<count($datos);$i++){
			
			$idsigma = $datos[$i][0];
			$vdescri = $datos[$i][1];
			$cidtabl = $datos[$i][2];
			$hijos= $datos[$i][3];
			$ctipdat = $datos[$i][4];
			$vobser = $datos[$i][5];
			$nlongit= $datos[$i][6];
			$ndecima= $datos[$i][7];
			$ndefault= $datos[$i][8];
			$nestado= $datos[$i][9];
			
			if( $idsigma == $cidtabl &&  $hijos > 0){
				$arrayhijos = $this->buscarhijosmconten($idsigma,$depth,$datos);
				$arrayprinc[] = array ('text' => $vdescri, 'id' => $idsigma, 'depth' => $depth, 'leaf' => false, 'checked' => false, 'children' => $arrayhijos, 'enlace' => $idsigma, 'canthijos' => $hijos , 'icon'=> (($nestado==1)?'':$url.'css/images/drop-no.gif'));
			}if( $idsigma == $cidtabl &&  $hijos == 0){
				$arrayprinc[] = array ('text' => $vdescri, 'id' => $idsigma, 'depth' => $depth, 'leaf' => true, 'checked' => false, 'children' => '', 'enlace' => $idsigma, 'canthijos' => $hijos , 'icon'=> (($nestado==1)?'':$url.'css/images/drop-no.gif') );
			}
		}
		$arrayroot[0] = array ('text' => 'TABLAS GENERALES', 'id' => '0000000000', 'depth' => '0', 'leaf' => false, 'checked' => false, 'children' => $arrayprinc );
		
		$cont ='<script type="text/javascript">
			Ext.BLANK_IMAGE_URL = "' . $url . 'css/images/s.gif";
			Ext.EventManager.onDocumentReady(function() {
				tree = new Ext.tree.TreePanel(\'tree-mconten\',{
					animate:true,
					//loader: new Ext.tree.CustomUITreeLoader({baseAttr:{uiProvider: Ext.tree.CheckboxNodeUI}}),
					loader: new Ext.tree.TreeLoader({}),
					enableDD:false,
					collapsible : true,
			        animCollapse: false,
					containerScroll: true,
					//rootUIProvider: Ext.tree.CheckboxNodeUI,
					//selModel:new Ext.tree.CheckNodeMultiSelectionModel(),
					rootVisible:false
				});
				
				tree.on(\'check\', function() {
					//aki va el ajax para llenar los registros!!
					var registros = this.getChecked().join(\'^\');
				}, tree);
				
				tree.on(\'click\', function(node, event){
				    detallenodomconten(node.attributes.id,\'\');
				});
			
				// set the root node
				root = new Ext.tree.AsyncTreeNode({
							text: \'root\',
							draggable:false,
							id:\'source\',
							//uiProvider: Ext.tree.CheckboxNodeUI,
							children: ' . json_encode ( $arrayroot ) . '
					    });
				
				tree.setRootNode(root);
			
				// render the tree
				tree.render();
				root.expand(false, false, function() {
					root.firstChild.expand(false);
				});
				
			});
			</script>';
		echo $cont;
		
	}
	
	public function mcontenAction() {
		$this->pintararbolconten();	
		$func = new Libreria_Pintar();
		$evt[] = array('btnnuevonodo','click','detallenodomconten(\'\',\'\')');	
		$func->PintarEvento($evt);
	}
	
	public function mcontennodoAction() {
		$this->_helper->layout->disableLayout ();
		$this->_helper->getHelper ( 'ajaxContext' )->initContext ();
		
		if ($this->getRequest ()->isXmlHttpRequest ()) {
			
			$idnodo = $this->_request->getPost ( 'idnodo' );
			$idpadre = $this->_request->getPost ( 'idpadre' );
			
			$func = new Libreria_Pintar();
			$cn = new Model_DataAdapter ();
			
			$nombrestore = '"public".obt_mconten';
			
			$arrayestado = array(array('1','HABILITADO'),array('0','DESHABILITADO'));
			
			if($idnodo == '' || $idnodo == null){
				$parametros [0] = '' ;
				$parametros [1] = '' ;
				$datosmconten = $cn->ejec_store_procedura_sql ( $nombrestore, $parametros );
				$val[] = array('cb_padre',$func->ContenidoCombo($datosmconten,($idpadre=='')?'':$idpadre),'html');
				$val[] = array('cb_estado',$func->ContenidoCombo($arrayestado,'1'),'html');
			}else{
				$parametros [0] = $idnodo ;
				$parametros [1] = '' ;
				$datosnodo = $cn->ejec_store_procedura_sql ( $nombrestore, $parametros );
				
				if(count($datosnodo) == 0){
					return;
				}
				
				$idsigma = $datosnodo[0][0];
				$vdescri = $datosnodo[0][1];
				$cidtabl = $datosnodo[0][2];
				$hijos= $datosnodo[0][3];
				$ctipdat = $datosnodo[0][4];
				$vobser = $datosnodo[0][5];
				$nlongit= $datosnodo[0][6];
				$ndecima= $datosnodo[0][7];
				$ndefault= $datosnodo[0][8];
				$nestado= $datosnodo[0][9];
				
				$val[] = array('c_codigo',$idsigma,'html');
				$val[] = array('txt_descripcion',$vdescri,'val');
				
				$parametros [0] = '' ;
				$parametros [1] = '' ;
				$datosmconten = $cn->ejec_store_procedura_sql ( $nombrestore, $parametros );
				$val[] = array('cb_padre',$func->ContenidoCombo($datosmconten,$cidtabl),'html');
				$val[] = array('txa_observ',$vobser,'val');
				$val[] = array('txt_long',$nlongit,'val');
				$val[] = array('txt_decimal',$ndecima,'val');
				$val[] = array('txt_defecto',$ndefault,'val');
				$val[] = array('cb_estado',$func->ContenidoCombo($arrayestado,$nestado),'html');
				
				$contenhijos  = '';
	          		$tienehijos = 0;
	          		
					for($i=0;$i<count($datosmconten);$i++){
						$didsigma = $datosmconten[$i][0];
						$dvdescri = str_replace(array("'","/"),array("",""),$datosmconten[$i][1]);
						$dcidtabl = $datosmconten[$i][2];
						$dhijos= $datosmconten[$i][3];
						$dctipdat = $datosmconten[$i][4];
						$dvobser = $datosmconten[$i][5];
						$dnlongit= $datosmconten[$i][6];
						$dndecima= $datosmconten[$i][7];
						$dndefault= $datosmconten[$i][8];
						$dnestado= $datosmconten[$i][9];
						
						if($dcidtabl == $idsigma && $didsigma != $idsigma){
							$tienehijos = 1;
							$contenhijos .= '<tr><td style="width: 90px;">'.$didsigma
								.'</td><td style="width: 246px">'.$dvdescri
								.'</td><td style="width: 42px" align="center"><button onclick="detallenodomconten(\''.$didsigma.'\',\'\');" >Buscar</button></td></tr>';
						}
					}
					if($tienehijos == 0){
						$contenhijos .= '<tr><td colspan="3">No tiene nodo hijos registrados</td></tr>';
					}
					
				$val[] = array('c_nodohijos','<table id="tblDetalle" style="width: 372px; padding-left: 2px;" border="0" cellspacing="0" cellpadding="0"><tbody class="ui-table-body">'.$contenhijos.'</tbody></table>','html');
				$evt[] = array('btnaniadirnodo','click','detallenodomconten(\'\',\''.$idsigma.'\');');
			}
			$evt[] = array('btnguardarmcontennodo','click','guardarmcontennodo();');
			$evt[] = array('txa_observ','keypress','if(event.keyCode == 13){return false;}');
			$evt[] = array("txt_long","keypress","return validarnumeros(event);");
			$evt[] = array("txt_decimal","keypress","return validarnumeros(event);");
			
			$fn[] = array("$('#tblDetalle button').button({icons: {primary: 'ui-icon-search'}, text: false});");
			$fn[] = array("mouseHover('tblDetalle');");
			
			$func->IniciaScript();
			$func->PintarValor($val);
			$func->PintarEvento($evt);
			$func->EjecutarFuncion($fn, "function");
			$func->FinScript();
		}
	}

	public function guardarmcontennodoAction() {
		$this->_helper->layout->disableLayout ();
		$this->_helper->getHelper ( 'ajaxContext' )->initContext ();
		
		if ($this->getRequest ()->isXmlHttpRequest ()) {
			
			$codigo = $this->_request->getPost ( 'codigo' );
			$descripcion = $this->_request->getPost ( 'descripcion' );
			$padre = $this->_request->getPost ( 'padre' );
			$observ = $this->_request->getPost ( 'observ' );
			$long = $this->_request->getPost ( 'long' );
			$decimal = $this->_request->getPost ( 'decimal' );
			$defecto = $this->_request->getPost ( 'defecto' );
			$estado = $this->_request->getPost ( 'estado' );
			
			$ddatosuserlog = new Zend_Session_Namespace('datosuserlog');
			$cidpers = $ddatosuserlog->cidpers;
			
			$cn = new Model_DataAdapter ();
			$nombrestore = '"public".guardarmcontennodo';	
			$parametros [0] = $codigo ;
			$parametros [1] = $descripcion ;
			$parametros [2] = $padre ;
			$parametros [3] = $observ ;
			$parametros [4] = $long ;
			$parametros [5] = $decimal ;
			$parametros [6] = $defecto ;
			$parametros [7] = $estado ;
			$parametros [8] = '' ;
			$parametros [9] = $cidpers ;
			
			$datos = $cn->ejec_store_procedura_sql ( $nombrestore, $parametros );
			
			if($datos[0][0] == '1'){
				echo '<script language=\"JavaScript\">window.open(\''.$this->view->util()->getLink('mantenimientos/mconten').'\', \'_self\')</script>';
			}else{
				echo 'Error en el guardado...';
			}
		}
	}
	
	public function ipmAction(){
		$pintar=new Libreria_Pintar();
		
		$fechAct=date("Y");
    	
    	for($i = 1990; $i <= $fechAct; ++$i){
		$cboanos[$i] = array($i,$i);
	   	}
	   	
	   	$cbomes[]=array('1','Enero');
		$cbomes[]=array('2','Febrero');
		$cbomes[]=array('3','Marzo');
		$cbomes[]=array('4','Abril');
		$cbomes[]=array('5','Mayo');
		$cbomes[]=array('6','Junio');
		$cbomes[]=array('7','Julio');
		$cbomes[]=array('8','Agosto');
		$cbomes[]=array('9','Septiembre');
		$cbomes[]=array('10','Octubre');
		$cbomes[]=array('11','Noviembre');
		$cbomes[]=array('12','Diciembre');
			   	
	   	
	   	
	   	$val[]=array('cboanios',$pintar->ContenidoCombo($cboanos,'9999999999'),'html');
	   	
	   	$val[]=array('cbomes',$pintar->ContenidoCombo($cbomes,'9999999999'),'html');
	   	
	   	$evt[]=array('btningresar','click','$("#divmanttipm" ).dialog( "open" );');

		$fn[] = array('$(function() {
						$( "#dialog:ui-dialog" ).dialog( "destroy" );					
						$( "#divmanttipm" ).dialog({
							resizable: false,
							height:300,
							width:350,
							modal: true,
							autoOpen:false,
							draggable:false,								
							buttons: {						
							   Guardar: function(){$( this ).dialog( "close" );}
							   ,Cerrar: function(){$( this ).dialog( "close" );}							
							}					
						});
					});');
		
	   	
	   	
	   	$pintar->PintarValor($val);
	   	$pintar->PintarEvento($evt);
  		$pintar->EjecutarFuncion($fn);	
	   	
	   	
		
		
	}
	

	

	public function uitAction(){
		$pintar=new Libreria_Pintar();
		
		$fechAct=date("Y");
    	
    	for($i = 1990; $i <= $fechAct; ++$i){
		$cboanos[$i] = array($i,$i);
	   	}
	   	   	
	   	$val[]=array('cboanios',$pintar->ContenidoCombo($cboanos,'9999999999'),'html');
	 	
		$evt[]=array('btningresar','click','$("#divmanttuit" ).dialog( "open" );');

		$fn[] = array('$(function() {
						$( "#dialog:ui-dialog" ).dialog( "destroy" );					
						$( "#divmanttuit" ).dialog({
							resizable: false,
							height:180,
							width:300,
							modal: true,
							autoOpen:false,
							draggable:false,								
							buttons: {						
							   Guardar: function(){$( this ).dialog( "close" );}
							   ,Cerrar: function(){$( this ).dialog( "close" );}							
							}					
						});
					});');
		
		$pintar->PintarValor($val);
		$pintar->PintarEvento($evt);
		$pintar->EjecutarFuncion($fn);		
	}
	
	
	public function depreciacionAction(){
		$pintar=new Libreria_Pintar();
		
		$fechAct=date("Y");
    	
    	for($i = 1990; $i <= $fechAct; ++$i){
		$cboanos[$i] = array($i,$i);
	   	}
	   	
	   	   	
	   	$val[]=array('cboanios',$pintar->ContenidoCombo($cboanos,'9999999999'),'html');
	   	
	   		
	   	$cboclasificacion[]=array('1','Casas Habitacion y Departamentos para Vivienda.');
		$cboclasificacion[]=array('2','Tiendas,Depositos, Centros de Recreacion o Esparcimiento,Clubes Sociales o Instituciones.');
		$cboclasificacion[]=array('3','Edificios -Oficinas.');
	    $cboclasificacion[]=array('4','Clinicas,Hospitales,Cines,Industrias,Colegios,Talleres.');
 
	   	
	   	
	   	$val[]=array('cboclasificacion',$pintar->ContenidoCombo($cboclasificacion,'9999999999'),'html');
	   	
	   	$cbomateria[]=array('1','Croncreto');
	   	$cbomateria[]=array('2','Ladrillo');
	   	$cbomateria[]=array('3','Adobe');
	   	
	   	$val[]=array('cbomaterial',$pintar->ContenidoCombo($cbomateria ,'9999999999'),'html');
	   	
	   	
	   	$cboantiguedad[]=array('5','5');
		$cboantiguedad[]=array('10','10');
		$cboantiguedad[]=array('15','15');
        $cboantiguedad[]=array('20','20');
		$cboantiguedad[]=array('25','25');
		$cboantiguedad[]=array('30','30');
		$cboantiguedad[]=array('35','35');
		$cboantiguedad[]=array('40','40');
		$cboantiguedad[]=array('45','45');
		$cboantiguedad[]=array('50','50');
		$cboantiguedad[]=array('55','55');
		$cboantiguedad[]=array('65','65');
	   	
		$val[]=array('cboantiguedad',$pintar->ContenidoCombo($cboantiguedad ,'9999999999'),'html');
		
	   	
		for($i = 0; $i <= 100; ++$i){
		$cboporcen[$i] = array($i,$i);
	   	}
	   	
	   	$val[]=array('cbomuybueno',$pintar->ContenidoCombo($cboporcen,'9999999999'),'html');
   	
	   	$val[]=array('cbobueno',$pintar->ContenidoCombo($cboporcen,'9999999999'),'html');
	   	
	 	$val[]=array('cbomalo',$pintar->ContenidoCombo($cboporcen,'9999999999'),'html');

	 	$val[]=array('cbomuymalo',$pintar->ContenidoCombo($cboporcen,'9999999999'),'html');
		   	
	 	$evt[]=array('btningresar','click','$("#manttdepreciacion" ).dialog( "open" );');

		$fn[] = array('$(function() {
						$( "#dialog:ui-dialog" ).dialog( "destroy" );					
						$( "#manttdepreciacion" ).dialog({
							resizable: false,
							height:500,
							width:650,
							modal: true,
							autoOpen:false,
							draggable:false,								
							buttons: {						
							   Guardar: function(){$( this ).dialog( "close" );}
							   ,Cerrar: function(){$( this ).dialog( "close" );}							
							}					
						});
					});');
		
		$pintar->PintarValor($val);
		$pintar->PintarEvento($evt);
		$pintar->EjecutarFuncion($fn);
		
	}
	
	public function timAction(){		
		$pintar=new Libreria_Pintar();
		
		$fechAct=date("Y");
    	
    	for($i = 1990; $i <= $fechAct; ++$i){
		$cboanos[$i] = array($i,$i);
	   	}
	   	
	   	$cbomes[]=array('1','Enero');
		$cbomes[]=array('2','Febrero');
		$cbomes[]=array('3','Marzo');
		$cbomes[]=array('4','Abril');
		$cbomes[]=array('5','Mayo');
		$cbomes[]=array('6','Junio');
		$cbomes[]=array('7','Julio');
		$cbomes[]=array('8','Agosto');
		$cbomes[]=array('9','Septiembre');
		$cbomes[]=array('10','Octubre');
		$cbomes[]=array('11','Noviembre');
		$cbomes[]=array('12','Diciembre');
			   	
	   	
	   	
	   	$val[]=array('cboanios',$pintar->ContenidoCombo($cboanos,'9999999999'),'html');
	   	
	   	$val[]=array('cbomes',$pintar->ContenidoCombo($cbomes,'9999999999'),'html');
			   	
	 	$evt[]=array('btningresar','click','$("#mantttim" ).dialog( "open" );');
		
		$fn[] = array('$(function() {
						$( "#dialog:ui-dialog" ).dialog( "destroy" );					
						$( "#mantttim" ).dialog({
							resizable: false,
							height:300,
							width:350,
							modal: true,
							autoOpen:false,
							draggable:false,								
							buttons: {						
							   Guardar: function(){$( this ).dialog( "close" );}
							   ,Cerrar: function(){$( this ).dialog( "close" );}							
							}					
						});
					});');
		
		$fn[] = array('$("#txtfechven").datepicker({showOn: "button", buttonImage: jQuery.scriptPath + "img/calendar.gif",	buttonImageOnly: true});');
    	$fn[] = array('$("#txtfechven").datepicker("option", "dateFormat", "dd-mm-yy");');
		
		$pintar->PintarValor($val);
		$pintar->PintarEvento($evt);
		$pintar->EjecutarFuncion($fn);
	}
	
    public function arancelAction(){
    	$pintar=new Libreria_Pintar();
		
		$fechAct=date("Y");
    	
    	for($i = 1990; $i <= $fechAct; ++$i){
		$cboanos[$i] = array($i,$i);
	   	}	   	  	
	   	
	   	$val[]=array('cboanios',$pintar->ContenidoCombo($cboanos,'9999999999'),'html');
	   		   	
	 	$evt[]=array('btningresar','click','$("#manttarancel" ).dialog( "open" );');
		
		$fn[] = array('$(function() {
						$( "#dialog:ui-dialog" ).dialog( "destroy" );					
						$( "#manttarancel" ).dialog({
							resizable: false,
							height:500,
							width:500,
							modal: true,
							autoOpen:false,
							draggable:false,								
							buttons: {						
							   Guardar: function(){$( this ).dialog( "close" );}
							   ,Cerrar: function(){$( this ).dialog( "close" );}							
							}					
						});
					});');
		$evt[]=array('btnbuscarvia','click','$("#busqvias" ).dialog( "open" );');
		
		$fn[] = array('$(function() {
						$( "#dialog:ui-dialog" ).dialog( "destroy" );					
						$( "#busqvias" ).dialog({
							resizable: false,
							height:500,
							width:600,
							modal: true,
							autoOpen:false,
							draggable:false,								
							buttons: {							  
							   Cerrar: function(){$( this ).dialog( "close" );}							
							}					
						});
					});');
		
		$evt[]=array('btnbuscarcentrpoblado','click','$("#busqcentrpobl" ).dialog( "open" );');
		
		$fn[] = array('$(function() {
						$( "#dialog:ui-dialog" ).dialog( "destroy" );					
						$( "#busqcentrpobl" ).dialog({
							resizable: false,
							height:500,
							width:600,
							modal: true,
							autoOpen:false,
							draggable:false,								
							buttons: {							  
							   Cerrar: function(){$( this ).dialog( "close" );}							
							}					
						});
		              });');		
		
		$pintar->PintarValor($val);
		$pintar->PintarEvento($evt);
		$pintar->EjecutarFuncion($fn);
    
    }
    
    public function viasAction(){
    	$pintar=new Libreria_Pintar();
		
		$fechAct=date("Y");
		
		$cbotipo[]=array('01','AVENIDA');
		$cbotipo[]=array('02','CALLE');
		$cbotipo[]=array('03','JIRON');
		$cbotipo[]=array('04','AVENIDA');
		$cbotipo[]=array('05','PASAJE');
		$cbotipo[]=array('06','MALECON');
		$cbotipo[]=array('07','ALAMEDA');
		$cbotipo[]=array('08','PROLONGACION');
		$cbotipo[]=array('10','CARRETERA');
		$cbotipo[]=array('11','PASEO');
		$cbotipo[]=array('12','CAMINO');
	   	
	 	$val[]=array('cbotipo',$pintar->ContenidoCombo($cbotipo,'9999999999'),'html');	
	   	
	   	$evt[]=array('btningresar','click','$("#manttvias" ).dialog( "open" );');	   	
	   	
	   	$evt[]=array('btnbuscarcentrpoblado','click','$("#manttvias" ).dialog( "open" );');
		
		$fn[] = array('$(function() {
						$( "#dialog:ui-dialog" ).dialog( "destroy" );					
						$( "#manttvias" ).dialog({
							resizable: false,
							height:500,
							width:600,
							modal: true,
							autoOpen:false,
							draggable:false,								
							buttons: {		
							   	Guardar: function(){$( this ).dialog( "close" );}				  
							   ,Cerrar: function(){$( this ).dialog( "close" );}							
							}					
						});
		              });');		
	       	
	   	$evt[]=array('btnbuscarvia','click','$("#busqvias" ).dialog( "open" );');
		
		$fn[] = array('$(function() {
						$( "#dialog:ui-dialog" ).dialog( "destroy" );					
						$( "#busqvias" ).dialog({
							resizable: false,
							height:500,
							width:600,
							modal: true,
							autoOpen:false,
							draggable:false,								
							buttons: {							   			  
							    Cerrar: function(){$( this ).dialog( "close" );}							
							}					
						});
		              });');
		
		$evt[]=array('btnbuscarcentpobl','click','$("#busqcentrpobl" ).dialog( "open" );');
		
		$fn[] = array('$(function() {
						$( "#dialog:ui-dialog" ).dialog( "destroy" );					
						$( "#busqcentrpobl" ).dialog({
							resizable: false,
							height:500,
							width:600,
							modal: true,
							autoOpen:false,
							draggable:false,								
							buttons: {							   			  
							    Cerrar: function(){$( this ).dialog( "close" );}							
							}					
						});
		              });');
		
		
		
		
		$pintar->PintarValor($val);
		$pintar->PintarEvento($evt);
		$pintar->EjecutarFuncion($fn);    	
    }
    
    public function centropobladoAction(){
    	
    	$pintar=new Libreria_Pintar();
		
		$fechAct=date("Y");
				
		$cbotipo[]=array('01','URB.');
		$cbotipo[]=array('02','P.V');
		$cbotipo[]=array('03','BARRIO');
		$cbotipo[]=array('04','C.H.');
		$cbotipo[]=array('05','A.P.V.');
		$cbotipo[]=array('06','P.V.');
		$cbotipo[]=array('07','PROG.V.');
		$cbotipo[]=array('08','AA.HH.');
		$cbotipo[]=array('09','ASOC.');
		$cbotipo[]=array('10','ASOC. COM.');
		$cbotipo[]=array('11','ASOC.RES');
		$cbotipo[]=array('12','ASOC. VIV.');		
		$cbotipo[]=array('13','B.M');
		$cbotipo[]=array('14','FDO.');
		$cbotipo[]=array('15','A.P.');
		$cbotipo[]=array('16','COOP.');
		$cbotipo[]=array('17','MDO.');
		$cbotipo[]=array('18','U.V.');			
	   			
	 	$val[]=array('cbotipo',$pintar->ContenidoCombo($cbotipo,'9999999999'),'html');	
	   	
	   	$evt[]=array('btningresar','click','$("#manttcentropoblad" ).dialog( "open" );');	   	
	   		
		$fn[] = array('$(function() {
						$( "#dialog:ui-dialog" ).dialog( "destroy" );					
						$( "#manttcentropoblad" ).dialog({
							resizable: false,
							height:500,
							width:600,
							modal: true,
							autoOpen:false,
							draggable:false,								
							buttons: {		
							   	Guardar: function(){$( this ).dialog( "close" );}				  
							   ,Cerrar: function(){$( this ).dialog( "close" );}							
							}					
						});
		              });');		
		
		$pintar->PintarValor($val);
		$pintar->PintarEvento($evt);
		$pintar->EjecutarFuncion($fn);
    }
    
    public function valoresunitariosAction(){
    	
    	$pintar=new Libreria_Pintar();
    		
	   	$evt[]=array('btningresar','click','$("#manttvaloresunitarios" ).dialog( "open" );');	   	
	   		
		$fn[] = array('$(function() {
						$( "#dialog:ui-dialog" ).dialog( "destroy" );					
						$( "#manttvaloresunitarios" ).dialog({
							resizable: false,
							height:500,
							width:600,
							modal: true,
							autoOpen:false,
							draggable:false,								
							buttons: {		
							   	Guardar: function(){$( this ).dialog( "close" );}				  
							   ,Cerrar: function(){$( this ).dialog( "close" );}							
							}					
						});
		              });');		
		
		$pintar->PintarEvento($evt);
		$pintar->EjecutarFuncion($fn);
    	
    }
    
    public function personasAction(){
    	
    	
    	
    }
    
    public function contenedorAction(){
    	
    }
    
    

    
    
    
}