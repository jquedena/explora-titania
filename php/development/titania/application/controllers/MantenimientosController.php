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
	
}