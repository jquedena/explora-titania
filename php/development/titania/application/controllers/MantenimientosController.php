<?php

require_once 'Zend/Controller/Action.php';

class MantenimientosController extends Zend_Controller_Action {

	public function init() {
		$this->view->util()->registerScriptJSController($this->getRequest());
	}

	public function indexAction() {
	}

	public function buscarhijosmconten($padre, $depth, $arraydatos) {

		$url = $this->view->util()->getPath();

		$depth++;

		for ($i = 0; $i < count($arraydatos); $i++) {
			$idsigma = $arraydatos[$i][0];
			$vdescri = $arraydatos[$i][1];
			$cidtabl = $arraydatos[$i][2];
			$hijos = $arraydatos[$i][3];
			$ctipdat = $arraydatos[$i][4];
			$vobser = $arraydatos[$i][5];
			$nlongit = $arraydatos[$i][6];
			$ndecima = $arraydatos[$i][7];
			$ndefault = $arraydatos[$i][8];
			$nestado = $arraydatos[$i][9];

			if ($idsigma != $cidtabl && $cidtabl == $padre) {
				if ($hijos == 0) {
					$array[] = array('text' => $vdescri, 'id' => $idsigma, 'depth' => $depth, 'leaf' => true, 'checked' => false, 'children' => '', 'enlace' => $idsigma, 'canthijos' => $hijos, 'icon' => (($nestado == 1) ? '' : $url . 'css/images/drop-no.gif'));
				} else {
					//$array = '';
					$arrayhijos = $this->buscarhijosmconten($idsigma, $depth, $arraydatos);
					$array[] = array('text' => $vdescri, 'id' => $idsigma, 'depth' => $depth, 'leaf' => false, 'checked' => false, 'children' => $arrayhijos, 'enlace' => $idsigma, 'canthijos' => $hijos, 'icon' => (($nestado == 1) ? '' : $url . 'css/images/drop-no.gif'));
				}
			}
		}

		return $array;
	}

	public function pintararbolconten() {

		$url = $this->view->util()->getPath();

		$nombrestore = '"public".obt_mconten';
		$parametros [0] = '';
		$parametros [1] = '';

		$cn = new Model_DataAdapter ();
		$datos = $cn->ejec_store_procedura_sql($nombrestore, $parametros);

		$depth = 1;

		for ($i = 0; $i < count($datos); $i++) {

			$idsigma = $datos[$i][0];
			$vdescri = $datos[$i][1];
			$cidtabl = $datos[$i][2];
			$hijos = $datos[$i][3];
			$ctipdat = $datos[$i][4];
			$vobser = $datos[$i][5];
			$nlongit = $datos[$i][6];
			$ndecima = $datos[$i][7];
			$ndefault = $datos[$i][8];
			$nestado = $datos[$i][9];

			if ($idsigma == $cidtabl && $hijos > 0) {
				$arrayhijos = $this->buscarhijosmconten($idsigma, $depth, $datos);
				$arrayprinc[] = array('text' => $vdescri, 'id' => $idsigma, 'depth' => $depth, 'leaf' => false, 'checked' => false, 'children' => $arrayhijos, 'enlace' => $idsigma, 'canthijos' => $hijos, 'icon' => (($nestado == 1) ? '' : $url . 'css/images/drop-no.gif'));
			}if ($idsigma == $cidtabl && $hijos == 0) {
				$arrayprinc[] = array('text' => $vdescri, 'id' => $idsigma, 'depth' => $depth, 'leaf' => true, 'checked' => false, 'children' => '', 'enlace' => $idsigma, 'canthijos' => $hijos, 'icon' => (($nestado == 1) ? '' : $url . 'css/images/drop-no.gif'));
			}
		}
		$arrayroot[0] = array('text' => 'TABLAS GENERALES', 'id' => '0000000000', 'depth' => '0', 'leaf' => false, 'checked' => false, 'children' => $arrayprinc);

		$cont = '<script type="text/javascript">
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
	children: ' . json_encode($arrayroot) . '
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
		$evt[] = array('btnnuevonodo', 'click', 'detallenodomconten(\'\',\'\')');
		$func->PintarEvento($evt);
	}

	public function mcontennodoAction() {
		$this->_helper->layout->disableLayout();
		$this->_helper->getHelper('ajaxContext')->initContext();

		if ($this->getRequest()->isXmlHttpRequest()) {

			$idnodo = $this->_request->getPost('idnodo');
			$idpadre = $this->_request->getPost('idpadre');

			$func = new Libreria_Pintar();
			$cn = new Model_DataAdapter ();

			$nombrestore = '"public".obt_mconten';

			$arrayestado = array(array('1', 'HABILITADO'), array('0', 'DESHABILITADO'));

			if ($idnodo == '' || $idnodo == null) {
				$parametros [0] = '';
				$parametros [1] = '';
				$datosmconten = $cn->ejec_store_procedura_sql($nombrestore, $parametros);
				$val[] = array('cb_padre', $func->ContenidoCombo($datosmconten, ($idpadre == '') ? '' : $idpadre), 'html');
				$val[] = array('cb_estado', $func->ContenidoCombo($arrayestado, '1'), 'html');
			} else {
				$parametros [0] = $idnodo;
				$parametros [1] = '';
				$datosnodo = $cn->ejec_store_procedura_sql($nombrestore, $parametros);

				if (count($datosnodo) == 0) {
					return;
				}

				$idsigma = $datosnodo[0][0];
				$vdescri = $datosnodo[0][1];
				$cidtabl = $datosnodo[0][2];
				$hijos = $datosnodo[0][3];
				$ctipdat = $datosnodo[0][4];
				$vobser = $datosnodo[0][5];
				$nlongit = $datosnodo[0][6];
				$ndecima = $datosnodo[0][7];
				$ndefault = $datosnodo[0][8];
				$nestado = $datosnodo[0][9];

				$val[] = array('c_codigo', $idsigma, 'html');
				$val[] = array('txt_descripcion', $vdescri, 'val');

				$parametros [0] = '';
				$parametros [1] = '';
				$datosmconten = $cn->ejec_store_procedura_sql($nombrestore, $parametros);
				$val[] = array('cb_padre', $func->ContenidoCombo($datosmconten, $cidtabl), 'html');
				$val[] = array('txa_observ', $vobser, 'val');
				$val[] = array('txt_long', $nlongit, 'val');
				$val[] = array('txt_decimal', $ndecima, 'val');
				$val[] = array('txt_defecto', $ndefault, 'val');
				$val[] = array('cb_estado', $func->ContenidoCombo($arrayestado, $nestado), 'html');

				$contenhijos = '';
				$tienehijos = 0;

				for ($i = 0; $i < count($datosmconten); $i++) {
					$didsigma = $datosmconten[$i][0];
					$dvdescri = str_replace(array("'", "/"), array("", ""), $datosmconten[$i][1]);
					$dcidtabl = $datosmconten[$i][2];
					$dhijos = $datosmconten[$i][3];
					$dctipdat = $datosmconten[$i][4];
					$dvobser = $datosmconten[$i][5];
					$dnlongit = $datosmconten[$i][6];
					$dndecima = $datosmconten[$i][7];
					$dndefault = $datosmconten[$i][8];
					$dnestado = $datosmconten[$i][9];

					if ($dcidtabl == $idsigma && $didsigma != $idsigma) {
						$tienehijos = 1;
						$contenhijos .= '<tr><td style="width: 90px;">' . $didsigma
						. '</td><td style="width: 246px">' . $dvdescri
						. '</td><td style="width: 42px" align="center"><button onclick="detallenodomconten(\'' . $didsigma . '\',\'\');" >Buscar</button></td></tr>';
					}
				}
				if ($tienehijos == 0) {
					$contenhijos .= '<tr><td colspan="3">No tiene nodo hijos registrados</td></tr>';
				}

				$val[] = array('c_nodohijos', '<table id="tblDetalle" style="width: 372px; padding-left: 2px;" border="0" cellspacing="0" cellpadding="0"><tbody class="ui-table-body">' . $contenhijos . '</tbody></table>', 'html');
				$evt[] = array('btnaniadirnodo', 'click', 'detallenodomconten(\'\',\'' . $idsigma . '\');');
			}
			$evt[] = array('btnguardarmcontennodo', 'click', 'guardarmcontennodo();');
			$evt[] = array('txa_observ', 'keypress', 'if(event.keyCode == 13){return false;}');
			$evt[] = array("txt_long", "keypress", "return validarnumeros(event);");
			$evt[] = array("txt_decimal", "keypress", "return validarnumeros(event);");

			$fn[] = array("$('#bntguardarmcontennodo').unbind('click')");
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
		$this->_helper->layout->disableLayout();
		$this->_helper->getHelper('ajaxContext')->initContext();

		if ($this->getRequest()->isXmlHttpRequest()) {

			$codigo = $this->_request->getPost('codigo');
			$descripcion = $this->_request->getPost('descripcion');
			$padre = $this->_request->getPost('padre');
			$observ = $this->_request->getPost('observ');
			$long = $this->_request->getPost('long');
			$decimal = $this->_request->getPost('decimal');
			$defecto = $this->_request->getPost('defecto');
			$estado = $this->_request->getPost('estado');

			$ddatosuserlog = new Zend_Session_Namespace('datosuserlog');
			$cidpers = $ddatosuserlog->cidpers;

			$cn = new Model_DataAdapter ();
			$nombrestore = '"public".guardarmcontennodo';
			$parametros [0] = $codigo;
			$parametros [1] = $descripcion;
			$parametros [2] = $padre;
			$parametros [3] = $observ;
			$parametros [4] = $long;
			$parametros [5] = $decimal;
			$parametros [6] = $defecto;
			$parametros [7] = $estado;
			$parametros [8] = '';
			$parametros [9] = $cidpers;

			$datos = $cn->ejec_store_procedura_sql($nombrestore, $parametros);

			if ($datos[0][0] == '1') {
				echo '<script language=\"JavaScript\">window.open(\'' . $this->view->util()->getLink('mantenimientos/mconten') . '\', \'_self\')</script>';
			} else {
				echo 'Error en el guardado...';
			}
		}
	}

	public function depreciacionAction() {
		$pintar = new Libreria_Pintar();
		$fechAct = date("Y");
		for ($i = 1990; $i <= $fechAct; ++$i) {
			$cboanos[$i] = array($i, $i);
		}

		$val[] = array('cboanios', $pintar->ContenidoCombo($cboanos, '9999999999'), 'html');
		$cboclasificacion[] = array('1', 'Casas Habitacion y Departamentos para Vivienda.');
		$cboclasificacion[] = array('2', 'Tiendas,Depositos, Centros de Recreacion o Esparcimiento,Clubes Sociales o Instituciones.');
		$cboclasificacion[] = array('3', 'Edificios -Oficinas.');
		$cboclasificacion[] = array('4', 'Clinicas,Hospitales,Cines,Industrias,Colegios,Talleres.');

		$val[] = array('cboclasificacion', $pintar->ContenidoCombo($cboclasificacion, '9999999999'), 'html');
		$cbomateria[] = array('1', 'Croncreto');
		$cbomateria[] = array('2', 'Ladrillo');
		$cbomateria[] = array('3', 'Adobe');

		$val[] = array('cbomaterial', $pintar->ContenidoCombo($cbomateria, '9999999999'), 'html');
		$cboantiguedad[] = array('5', '5');
		$cboantiguedad[] = array('10', '10');
		$cboantiguedad[] = array('15', '15');
		$cboantiguedad[] = array('20', '20');
		$cboantiguedad[] = array('25', '25');
		$cboantiguedad[] = array('30', '30');
		$cboantiguedad[] = array('35', '35');
		$cboantiguedad[] = array('40', '40');
		$cboantiguedad[] = array('45', '45');
		$cboantiguedad[] = array('50', '50');
		$cboantiguedad[] = array('55', '55');
		$cboantiguedad[] = array('65', '65');

		$val[] = array('cboantiguedad', $pintar->ContenidoCombo($cboantiguedad, '9999999999'), 'html');
		for ($i = 0; $i <= 100; ++$i) {
			$cboporcen[$i] = array($i, $i);
		}

		$val[] = array('cbomuybueno', $pintar->ContenidoCombo($cboporcen, '9999999999'), 'html');
		$val[] = array('cbobueno', $pintar->ContenidoCombo($cboporcen, '9999999999'), 'html');
		$val[] = array('cbomalo', $pintar->ContenidoCombo($cboporcen, '9999999999'), 'html');
		$val[] = array('cbomuymalo', $pintar->ContenidoCombo($cboporcen, '9999999999'), 'html');

		$evt[] = array('btningresar', 'click', '$("#manttdepreciacion" ).dialog( "open" );');

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

	public function valoresunitariosAction() {
		$pintar = new Libreria_Pintar();
		$evt[] = array('#btnbuscar', 'click', '$("#manttvaloresunitarios" ).dialog( "open" );');
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
						Guardar: function(){$(this).dialog("close");},
						Cerrar: function(){$(this).dialog("close");}
					}
				});
			});');

		$pintar->PintarEvento($evt);
		$pintar->EjecutarFuncion($fn);
	}

	public function personasAction(){
		$this->view->util()->registerScriptJSControllerAction($this->getRequest());
	}

	public function personaviewAction() {
		$this->_helper->getHelper('ajaxContext')->initContext();
		if ($this->getRequest()->isXmlHttpRequest()) {
			$this->_helper->layout->disableLayout();
			$name = $this->_request->getParam('name');
			$action = $this->_request->getPost('action');
			$idperson = '';
			$func = new Libreria_Pintar();
			$arrestcivil = array(array('0000000001', 'CASADO'), array('0000000002', 'SOLTERO'));
			$arrtipodoc = array(array('0000000001', 'DNI'), array('0000000002', 'RUC'));
			$arrtipopers = array(array('0000000001', 'NATURAL'), array('0000000002', 'JURIDICA'));
			$arrcodpostal = array(array('0000000001', 'Puente Piedra'), array('0000000002', 'otros'));
			$ctipdoc = '';
			$ctipper = '';
			$cestciv = '';
			$cubigeo = '';
			if (isset($name)) {
				$dataSet = new Zend_Session_Namespace($name);
				$rows = $dataSet->data;
				$idperson = $rows[0][0];
				//$rows[0][1]; //crazsoc
				//$rows[0][2]; // direccf
			} else {
				$idperson = $this->_request->getPost('id_person');
			}

			$val[] = array('txtcodigo', $idperson, 'val');
			if ($action == 'update') {
				$nombrestore = 'public.buscar_persona2';
				$arraydatos [0] = $idperson;
				$cn = new Model_DataAdapter();
				$datosperson = $cn->ejec_store_procedura_sql($nombrestore, $arraydatos);
				if (count($datosperson) == 0)
					return;
				$idsigma = $datosperson[0][0];
				$vpatern = $datosperson[0][1];
				$vmatern = $datosperson[0][2];
				$vnombre = $datosperson[0][3];
				$ctipper = $datosperson[0][4];
				$vtipper = $datosperson[0][5];
				$nestado = $datosperson[0][6];
				$ntipers = $datosperson[0][10];
				$ntipper = $datosperson[0][11];
				$cubigeo = $datosperson[0][12];
				$cdenomi = $datosperson[0][13];
				$vdirecc = $datosperson[0][14];
				$vnumero = $datosperson[0][15];
				$vlote = $datosperson[0][16];
				$vmanzan = $datosperson[0][17];
				$vdpto = $datosperson[0][18];
				$vreferen = $datosperson[0][19];
				$ctipdoc = $datosperson[0][20];
				$vtipdoc = $datosperson[0][21];
				$vnrodoc = $datosperson[0][22];
				$dfecnac = $datosperson[0][23];
				$csexo = $datosperson[0][24]; //-- Sexo 1=Masculino  ----- 2= Femenino
				$dfecinic = $datosperson[0][25];
				$cestciv = $datosperson[0][26];
				$ctelfij = $datosperson[0][27];
				$ctelmov = $datosperson[0][28];
				$vcorreo = $datosperson[0][29];
				$vobserv = $datosperson[0][30];

				$val[] = array('txtcodigo', $idperson, 'val');
				$val[] = array('txtbuscar', $idperson, 'val');
				$val[] = array('nrodoc', $vnrodoc, 'val');
				$val[] = array('apatern', $vpatern, 'val');
				$val[] = array('amatern', $vmatern, 'val');
				$val[] = array('nombre', $vnombre, 'val');
				$val[] = array('cbosexo', $csexo, 'val');
				$val[] = array('fecnace', $dfecnac, 'val');
				$val[] = array('st_estado', $nestado, 'val');
				$val[] = array('nrotef', $ctelfij, 'val');
				$val[] = array('nromovil', $ctelmov, 'val');
				$val[] = array('mail', $vcorreo, 'val');
				$val[] = array('denominacion', $cdenomi, 'val');
				$val[] = array('direccion', $vdirecc, 'val');
				$val[] = array('direcnumero', $vnumero, 'val');
				$val[] = array('departamen', $vdpto, 'val');
				$val[] = array('manzana', $vmanzan, 'val');
				$val[] = array('lote', $vlote, 'val');
				$val[] = array('ref', str_replace('"', '', str_replace('�', '', $vreferen)), 'val');
				// echo str_replace('Nº','Nro',$vreferen);

				//echo "<textarea>" . $vreferen . "</textarea>";
				$val[] = array("ds_observacion", $vobserv, 'html');
			}
			$val[] = array('cbotipdoc', $func->ContenidoCombo($arrtipodoc, $ctipdoc), 'html');
			$val[] = array('cbotipper', $func->ContenidoCombo($arrtipopers, $ctipper), 'html');
			$val[] = array('cboestcivil', $func->ContenidoCombo($arrestcivil, $cestciv), 'html');
			$val[] = array('distrito', $func->ContenidoCombo($arrcodpostal, $cubigeo), 'html');

			//$func->IniciaScript();
			$func->PintarValor($val);
			//$func->FinScript();
			
		}
	}
	public function personasaveAction(){
		$this->_helper->layout->disableLayout ();
		$this->_helper->viewRenderer->setNoRender ();
		$this->_helper->getHelper ( 'ajaxContext' )->initContext ();
		if ($this->getRequest ()->isXmlHttpRequest ()) {
			//$cbotipingreso = $this->_request->getPost ( 'cbotipingreso' );
			$codperson = $this->_request->getPost ( 'txtcodigo' );
			$st_estado = $this->_request->getPost ( 'st_estado' );
			$cbotipdoc = $this->_request->getPost ( 'cbotipdoc' );
			$nrodoc = $this->_request->getPost ( 'nrodoc' );
			$cbotipper = $this->_request->getPost ( 'cbotipper' );
			$apatern = $this->_request->getPost ( 'apatern' );
			$amatern = $this->_request->getPost ( 'amatern' );
			$nombre = $this->_request->getPost ( 'nombre' );
			$cbosexo = $this->_request->getPost ( 'cbosexo' );
			$cboestcivil = $this->_request->getPost ( 'cboestcivil' );
			$fecnace = $this->_request->getPost ( 'fecnace' );
			$nrotef = $this->_request->getPost ( 'nrotef' );
			$nromovil = $this->_request->getPost ( 'nromovil' );
			$mail = $this->_request->getPost ( 'mail' );
			$distrito = $this->_request->getPost ( 'distrito' );
			$denominacion = $this->_request->getPost ( 'denominacion' );
			$direccion= $this->_request->getPost ( 'direccion' );
			$direcnumero = $this->_request->getPost ( 'direcnumero' );
			$departamen = $this->_request->getPost ( 'departamen' );
			$manzana = $this->_request->getPost ( 'manzana' );
			$lote = $this->_request->getPost ( 'lote' );
			$ref = $this->_request->getPost ( 'ref' );
			$ds_observacion = $this->_request->getPost ( 'ds_observacion' );//22
	
			$ddatosuserlog = new Zend_Session_Namespace('datosuserlog');
			$userlogin = $ddatosuserlog->userlogin;
			$cad = '';
			$corr = 1;
	
			$cad .= $corr.'^'; //1
			$cad .= $codperson.'^'; //2
			$cad .= $st_estado.'^'; //3
			$cad .= $cbotipdoc.'^'; //4
			$cad .= $nrodoc.'^'; //5
			$cad .= $cbotipper.'^'; //6
			$cad .= $apatern.'^'; //7
			$cad .= $amatern.'^'; //8
			$cad .= $nombre.'^'; //9
			$cad .= $cbosexo.'^'; //10
			$cad .= $cboestcivil.'^'; //11
			$cad .= $fecnace.'^'; //12
			$cad .= $nrotef.'^'; //13
			$cad .= $nromovil.'^'; //14
			$cad .= $mail.'^'; //15
			$cad .= $distrito.'^'; //16
			$cad .= $denominacion.'^'; //17
			$cad .= $direccion.'^'; //18
			$cad .= $direcnumero.'^'; //19
			$cad .= $departamen.'^'; //20
			$cad .= $manzana.'^'; //21
			$cad .= $lote.'^'; //22
			$cad .= $ref.'^'; //23
			$cad .= $ds_observacion.'^'; //24
			$cad .= $userlogin.'^'; //user 25
			$cad .= $this->view->util()->getHost(); //host 26
	
	
			$cn = new Model_DataAdapter ();
			$nombrestore = '"public".guardarpersona';
			$parametros [0] = $cad ;
			$parametros [1] = '~' ;
			$parametros [2] = '^';
			$datos = $cn->ejec_store_procedura_sql ( $nombrestore, $parametros );
	
			//echo "<textarea>".$cad."</textarea>";
			if($datos[0][0] == '1'){
				$codperson=$datos[0][1];
				echo ($codperson==''?"Guardado":"Actualizado")." Correctamente <script language=\"JavaScript\">$('#panelPersons').html('');row = new Object();row.id_person = '$codperson';xmantepersonupdate(null,row);</script>";#
				//echo "<textarea>'<script language=\"JavaScript\">row = new Object();row.id_person = '$codperson';xmantepersonupdate(null,row);</script>';</textarea>";
			}else{
				echo 'Error en el guardado...';
			}
	
	
	}
	}
	public function contenedorAction() {
	}

	public function uitAction() {
		$this->view->util()->registerScriptJSControllerAction($this->getRequest());
	}

	public function uitsaveAction() {
		$this->_helper->layout->disableLayout();
		$this->_helper->viewRenderer->setNoRender();
		$this->_helper->getHelper('ajaxContext')->initContext();
		if ($this->getRequest()->isXmlHttpRequest()) {
			$idsigma = $this->_request->getPost('idsigma');
			$cperiod = $this->_request->getPost('cperiod');
			$ctiptri = $this->_request->getPost('ctiptri');
			$nvaluit = $this->_request->getPost('mvaluit');
			$nimpmin = $this->_request->getPost('nimpmin');
			$nimpmax = $this->_request->getPost('nimpmax');

			$ncosemi = $this->_request->getPost('ncosemi');
			$ncosadi = $this->_request->getPost('ncosadi');
			$nestado = $this->_request->getPost('nestado');
			$oper = $this->_request->getPost('oper'); // add	edit del
			$id = $this->_request->getPost('id');

			$ddatosuserlog = new Zend_Session_Namespace('datosuserlog');
			$userlogin = $ddatosuserlog->userlogin;
			$cn = new Model_DataAdapter ();
			$nombrestore = '"public".guardarcvaluit';
			$parametros [0] = $idsigma;
			$parametros [1] = $cperiod;
			$parametros [2] = $ctiptri;
			$parametros [3] = $nvaluit;
			$parametros [4] = $nimpmin;
			$parametros [5] = $nimpmax;
			$parametros [6] = $ncosemi;
			$parametros [7] = $ncosadi;
			$parametros [8] = $nestado;
			$parametros [9] = $this->view->util()->getHost();
			$parametros [10] = $userlogin;

			$datos = $cn->ejec_store_procedura_sql($nombrestore, $parametros);
			if ($datos[0][0] == '1') {

			} else {
				header("Status: 400 Error al Guardar intentelo en otro momento o contacte al adminsitrador");
			}
		}
	}

	public function reajusteAction() {
		$this->view->util()->registerScriptJSControllerAction($this->getRequest());
	}
	public function reajustesaveAction(){
		$this->_helper->layout->disableLayout();
		$this->_helper->viewRenderer->setNoRender();
		$this->_helper->getHelper('ajaxContext')->initContext();
		if ($this->getRequest()->isXmlHttpRequest()) {

			$idsigma = $this->_request->getPost('idsigma');
			$cperiod = $this->_request->getPost('cperiod');
			$ctiping = $this->_request->getPost('ctiping');
			$cnromes = $this->_request->getPost('cnromes');
			$nmontim = $this->_request->getPost('nmontim');
			$nfacrea = $this->_request->getPost('nfacrea');
			$dfecven = $this->_request->getPost('dfecven');
			$nmonipm = $this->_request->getPost('nmonipm');
			$ntipcuo = $this->_request->getPost('ntipcuo');
			$nipmapl = $this->_request->getPost('nipmapl');
			$nmorapl = $this->_request->getPost('nmorapl');
			$nestado = $this->_request->getPost('nestado');
			$oper = $this->_request->getPost('oper');// add	edit del
			$id = $this->_request->getPost('id');
			 

			$ddatosuserlog = new Zend_Session_Namespace('datosuserlog');
			$userlogin = $ddatosuserlog->userlogin;
			$cn = new Model_DataAdapter ();
			$nombrestore = 'public.guardarmreajus';
			$parametros [0] = $idsigma;
			$parametros [1] = $cperiod;
			$parametros [2] = $ctiping;
			$parametros [3] = $cnromes;
			$parametros [4] = $nmontim;
			$parametros [5] = $nfacrea;
			$parametros [6] = $dfecven;
			$parametros [7] = $nmonipm;

			$parametros [8] = $ntipcuo;
			$parametros [9] = $nipmapl;
			$parametros [10] = $nmorapl;
			 
			$parametros [11] = $nestado;
			$parametros [12] = $this->view->util()->getHost();
			$parametros [13] = $userlogin;
			$datos = $cn->ejec_store_procedura_sql($nombrestore, $parametros);
			if ($datos[0][0]=='1'){
				 
			}
			else{
				header("Status: 400 Error al Guardar intentelo en otro momento o contacte al adminsitrador");
			}


		}

	}

 public function arancelAction() {
        $this->view->util()->registerScriptJSControllerAction($this->getRequest());
        $pintar = new Libreria_Pintar();
        $fechAct = date("Y");

        for ($i = 1990; $i <= $fechAct; ++$i) {
            $cboanos[$i] = array($i, $i);
        }

        $val[] = array('cboanios', $pintar->ContenidoCombo($cboanos, '9999999999'), 'html');
       
     
        $pintar->PintarValor($val);
     
    }
    
    
	private function centr($conceptos) {
		$items = null;
		for($i=0; $i<count($conceptos); $i++){
			
			$codigo = $conceptos[$i][0];
		
			$items[$i]=array($codigo, $conceptos[$i][5]);
		}
		return $items;
	}
	
	
	private function vias($conceptos) {
		$items = null;
		for($i=0; $i<count($conceptos); $i++){
			
			$codigo = $conceptos[$i][0];
		
			$items[$i]=array($codigo, $conceptos[$i][4]);
		}
		return $items;
	}
    
    public function arancelviewAction(){
    	  $this->_helper->getHelper('ajaxContext')->initContext();
        if ($this->getRequest()->isXmlHttpRequest()) {
            $this->_helper->layout->disableLayout();
            $name = $this->_request->getParam('name');
            $action = $this->_request->getPost('action');
            $idsigma=$this->_request->getPost('idsigma');
            $mpoblad=$this->_request->getPost('mpoblad');
            $tnompob=$this->_request->getPost('tnompob');
            $mviadis=$this->_request->getPost('mviadis');
            $tnomvia=$this->_request->getPost('tnomvia');	
	        $nladvia=$this->_request->getPost('nladvia');
	        $ncuaini=$this->_request->getPost('ncuaini');
	        $ncuafin=$this->_request->getPost('ncuafin');
	        $narance=$this->_request->getPost('narance');
	        $nfacbar=$this->_request->getPost('nfacbar');
	        $cperiod=$this->_request->getPost('cperiod');
            $nestado=$this->_request->getPost('nestado');
            
            
        $pintar = new Libreria_Pintar();
         
		$val[]=array('idsigma',$idsigma,'val');
        
        $fechAct = date("Y");

        for ($i = 1990; $i <= $fechAct; ++$i) {
            $cboanos[$i] = array($i, $i);
        }
        
        $val[] = array('cboanios', $pintar->ContenidoCombo($cboanos, '9999999999'), 'html');
        
        $val[] = array('cboanios', $cperiod,'val');
        

         $nombrestore = 'registro.contrpob';
		 $arraydatos[0]= "01";
		 $cn = new Model_DataAdapter();
		 $datoscpd = $cn->ejec_store_procedura_sql($nombrestore,$arraydatos);
				
		 $cbo = $this->centr($datoscpd);
         $val[] = array("cbocentrpob",$pintar->ContenidoCombo($cbo, $cbo[0][0]), "html");
        
         
          $nombrestore2 = 'registro.mostrarvias';
		 $arraydatos2[0]= "01";
		 $cn2= new Model_DataAdapter();
		 $datoscpd2 = $cn2->ejec_store_procedura_sql($nombrestore2,$arraydatos2);
				
		 $cbo2 = $this->vias($datoscpd2);
         $val[] = array("cbovia",$pintar->ContenidoCombo($cbo2, $cbo2[0][0]), "html");
           
         $val[] = array("cbocentrpob",$mpoblad, "val");
         
         $val[] = array("cbovia",$mviadis, "val");
         
                  
         $val[]=array('txtnlado',$nladvia,'val');
         
         $val[]=array('txtarancel',$narance,'val');
         
       	 $val[]=array('txtcuadraini',$ncuaini,'val');
       	 
       	 
       	  $val[]=array('txtcuadrafin',$ncuafin,'val');
       	 
       	  $val[]=array('txtfacbarr',$nfacbar ,'val');
       	 
         
         $cboestado[]=array('0','Inactivo');
         $cboestado[]=array('1','Activo');
         
          $val[] = array('cboestado', $pintar->ContenidoCombo($cboestado, '1'), 'html');
         
        //$pintar->PintarEvento($evt);
       // $pintar->EjecutarFuncion($fn);        
        
        
        $pintar->PintarValor($val);
        }       
        	
    }
    
    	public function arancelsaveAction(){
		 
		$this->_helper->layout->disableLayout();
		$this->_helper->viewRenderer->setNoRender();
		$this->_helper->getHelper('ajaxContext')->initContext();
			if ($this->getRequest()->isXmlHttpRequest()) {
			
			$idsigma=$this->_request->getPost('idsigma');
            $mpoblad=$this->_request->getPost('mpoblad');         
            $mviadis=$this->_request->getPost('mviadis');          
	        $nladvia=$this->_request->getPost('nladvia');
	        $ncuaini=$this->_request->getPost('ncuaini');
	        $ncuafin=$this->_request->getPost('ncuafin');
	        $narance=$this->_request->getPost('narance');
	        $nfacbar=$this->_request->getPost('nfacbar');
	        $cperiod=$this->_request->getPost('cperiod');
            $nestado=$this->_request->getPost('nestado');
                   
            
			$ddatosuserlog = new Zend_Session_Namespace('datosuserlog');
			$userlogin = $ddatosuserlog->userlogin;
			$cn = new Model_DataAdapter ();
			$nombrestore = '"registro".guardarmarance';
			$parametros [0] = $idsigma;
			$parametros [1] = $mpoblad;
			$parametros [2] = $mviadis;
			$parametros [3] = $nladvia;
			$parametros [4] = $ncuaini;
			$parametros [5] = $ncuafin;
			$parametros [6] = $narance;
			$parametros [7] = $nfacbar;
			$parametros [8] = $cperiod;
			$parametros [9] = $nestado;
			$parametros [10] = $this->view->util()->getHost();
			$parametros [11] = $userlogin;

			$datos = $cn->ejec_store_procedura_sql($nombrestore, $parametros);
			if ($datos[0][0] == '1') {

			} else {
				header("Status: 400 Error al Guardar intentelo en otro momento o contacte al adminsitrador");
			}
            
            
			
			}
		}
	public function viasAction() {
		$this->view->util()->registerScriptJSControllerAction($this->getRequest());

		$pintar = new Libreria_Pintar();

		$fechAct = date("dmY");

		$pintar = new Libreria_Pintar();
		$cn = new Model_DataAdapter ();
		$nombrestore = '"public".obt_mconten';
		$parametros [0] = "";
		$parametros [1] = "1000000070";

		$tabla = $datos = $cn->ejec_store_procedura_sql($nombrestore, $parametros);
		$val[] = array('cbotipo', $pintar->ContenidoCombo($tabla, '9999999999'), 'html');
		$val[] = array('txtdesde', date("d-m-Y"), 'val');
		$val[] = array('txthasta', date("d-m-Y"), 'val');
		$evt[] = array('btnnuevo', 'click', '$("#txtcodcentropobl").val("");
				$("#cbotipo").val("");
				$("#txtcentropobl").val("");
				$("#txtdesde").val("");
				$("#txthasta").val("");
				$("#manttvias" ).dialog( "open" );
				deshabilitarComponente("txtcodcentropobl",true);
				deshabilitarComponente("cbotipo",true);
				deshabilitarComponente("txtcentropobl",true);
				deshabilitarComponente("cbotipo",true);
				deshabilitarComponente("txtdesde",true);
				deshabilitarComponente("txthasta",true);
				$("#acciones").show(); ');
		$evt[] = array('btngrabar', 'click', 'manttcentrpob("1");');
		$evt[] = array('btncancelar', 'click', 'window.location.reload()');
		$fn[] = array('$(function() {
				$( "#dialog:ui-dialog" ).dialog( "destroy" );
				$( "#manttvias" ).dialog({
				resizable: false,
				height:400,
				width:400,
				modal: true,
				autoOpen:false,
				draggable:false	,
				title:"Vias"
	});

				$("#acciones").hide();

				$("#txtdesde").datepicker();
				$("#txthasta").datepicker();

				deshabilitarComponente("btnactualizar",false);
				deshabilitarComponente("btneliminar",false);


				deshabilitarComponente("txtcodcentropobl",false);
				deshabilitarComponente("cbotipo",false);
				deshabilitarComponente("txtcentropobl",false);
				deshabilitarComponente("cbotipo",false);

				deshabilitarComponente("txtdesde",false);
				deshabilitarComponente("txthasta",false);
	});');

		$pintar->PintarValor($val);
		$pintar->PintarEvento($evt);
		$pintar->EjecutarFuncion($fn);
	}

	public function listardatosviasAction() {
		$this->_helper->layout->disableLayout();
		$this->_helper->getHelper('ajaxContext')->initContext();

		$pintar = new Libreria_Pintar();
		if ($this->getRequest()->isXmlHttpRequest()) {
			$name = $this->_request->getParam('name');

			if (isset($name)) {
				$dataSet = new Zend_Session_Namespace($name);
				$rows = $dataSet->data;

				$this->view->ccodcen = $rows[0][0];
				$this->view->vnombre = $rows[0][1];
				$this->view->ctipcen = $rows[0][3];
				$this->view->dfecdes = $rows[0][6];
				$this->view->dfechas = $rows[0][7];
			} else {
				$this->view->ccodcen = $this->_request->getParam('ccodcen');
				$this->view->vnombre = $this->_request->getParam('vnombre');
				$this->view->ctipcen = $this->_request->getParam('ctipcen');
				$this->view->dfecdes = $this->_request->getParam('dfecdes');
				$this->view->dfechas = $this->_request->getParam('dfechas');

				if ($this->_request->getParam('dfechas') == '') {
					$val[] = array('txthasta', date("d-m-Y"), 'val');
				}
			}
		}
		$pintar->PintarValor($val);
	}

	public function viassaveAction(){
		 
		$this->_helper->layout->disableLayout();
		$this->_helper->viewRenderer->setNoRender();
		$this->_helper->getHelper('ajaxContext')->initContext();
		if ($this->getRequest()->isXmlHttpRequest()) {
			$idsigma = $this->_request->getPost('mviadis');
			$ccodvia  = $this->_request->getPost('ccodvia');
			$ctipvia  = $this->_request->getPost('ctipvia');
			$vnomvia  = $this->_request->getPost('vnomvia');
			$dfecdes = $this->_request->getPost('cperdes');
			$dfechas = $this->_request->getPost('cperhas');
			$nestado = $this->_request->getPost('nestado');
			$oper = $this->_request->getPost('oper');// add	edit del
			$id = $this->_request->getPost('id');

			$ddatosuserlog = new Zend_Session_Namespace('datosuserlog');
			$userlogin = $ddatosuserlog->userlogin;
			$cn = new Model_DataAdapter ();
			$nombrestore = '"registro".guardarmvias';
			$parametros [0] = $idsigma;
			$parametros [1] = $ccodvia;
			$parametros [2] = $ctipvia;
			$parametros [3] = $vnomvia;
			$parametros [4] = '01/01/'.$dfecdes;
			$parametros [5] = '31/12/'.$dfechas;
			$parametros [6] = $nestado;
			$parametros [7] = $this->view->util()->getHost();
			$parametros [8] = $userlogin;

			$datos = $cn->ejec_store_procedura_sql($nombrestore, $parametros);


			if ($datos[0][0]=='1'){
				 
			}
			else{
				header("Status: 400 Error al Guardar intentelo en otro momento o contacte al adminsitrador");
			}



		}

		 
		 
	}

	public function centropobladoAction() {
		$this->view->util()->registerScriptJSControllerAction($this->getRequest());
		$pintar = new Libreria_Pintar();
		$fechAct = date("dmY");

		$pintar = new Libreria_Pintar();
		$cn = new Model_DataAdapter ();
		$nombrestore = '"public".obt_mconten';
		$parametros [0] = "";
		$parametros [1] = "1000000025";

		$tabla = $datos = $cn->ejec_store_procedura_sql($nombrestore, $parametros);

		$val[] = array('cbotipo', $pintar->ContenidoCombo($tabla, '9999999999'), 'html');
		$val[] = array('txtdesde', date("d-m-Y"), 'val');
		$val[] = array('txthasta', date("d-m-Y"), 'val');
		$evt[] = array('btnbuscar', 'click', '$("#busqresult" ).dialog( "open" );');
		$evt[] = array('btnnuevo', 'click', '
				$("#manttcentropoblad" ).dialog( "open" );
				$("#txtcodcentropobl").val("");
				$("#cbotipo").val("");
				$("#txtcentropobl").val("");
				$("#cboPostal").val("");
				$("#nrozona").val("");
				$("#txtdesde").val("");
				$("#txthasta").val("");
				deshabilitarComponente("txtcodcentropobl",true);
				deshabilitarComponente("cbotipo",true);
				deshabilitarComponente("txtcentropobl",true);
				deshabilitarComponente("cbotipo",true);
				deshabilitarComponente("cboPostal",true);
				deshabilitarComponente("nrozona",true);
				deshabilitarComponente("txtdesde",true);
				deshabilitarComponente("txthasta",true); ');


		$fn[] = array('$(function() {
				$( "#dialog:ui-dialog" ).dialog( "destroy" );
				$( "#manttcentropoblad" ).dialog({
				resizable: false,
				height:400,
				width:400,
				modal: true,
				autoOpen:false,
				draggable:false	,
				title:"Busqueda de CentroPoblado"
	});

				$("#acciones").hide();
				$("#txtdesde").datepicker();
				$("#txthasta").datepicker();

				deshabilitarComponente("txtcodcentropobl",false);
				deshabilitarComponente("cbotipo",false);
				deshabilitarComponente("txtcentropobl",false);
				deshabilitarComponente("cbotipo",false);
				deshabilitarComponente("cboPostal",false);
				deshabilitarComponente("nrozona",false);
				deshabilitarComponente("txtdesde",false);
				deshabilitarComponente("txthasta",false);
	});');

		$pintar->PintarValor($val);
		$pintar->PintarEvento($evt);
		$pintar->EjecutarFuncion($fn);
	}

	public function listardatoscentrpobAction() {
		$this->_helper->layout->disableLayout();
		$this->_helper->getHelper('ajaxContext')->initContext();

		if ($this->getRequest()->isXmlHttpRequest()) {
			$name = $this->_request->getParam('name');

			$pintar = new Libreria_Pintar();
			$cn = new Model_DataAdapter ();
			$nombrestore = '"public".obt_mconten';
			$parametros [0] = "";
			$parametros [1] = "1000000025";

			$tabla = $datos = $cn->ejec_store_procedura_sql($nombrestore, $parametros);

			if (isset($name)) {
				$dataSet = new Zend_Session_Namespace($name);
				$rows = $dataSet->data;

				$this->view->ccodcen = $rows[0][0];
				$this->view->vnombre = $rows[0][1];
				$this->view->cdistri = $rows[0][2];
				$this->view->ctipcen = $rows[0][3];
				$this->view->cdistri = $rows[0][4];
				$this->view->cidzona = $rows[0][5];
				$this->view->dfecdes = $rows[0][6];
				$this->view->dfechas = $rows[0][7];
			} else {
				$this->view->ccodcen = $this->_request->getParam('ccodcen');
				$this->view->vnombre = $this->_request->getParam('vnombre');
				$this->view->cdistri = $this->_request->getParam('cdistri');
				$this->view->ctipcen = $this->_request->getParam('ctipcen');
				$this->view->cdistri = $this->_request->getParam('cdistri');
				$this->view->cidzona = $this->_request->getParam('cidzona');
				$this->view->dfecdes = $this->_request->getParam('dfecdes');
				$this->view->dfechas = $this->_request->getParam('dfechas');

				$val[] = array('cbotipo', $pintar->ContenidoCombo($tabla, $this->view->ctipcen), 'html');
				if ($this->_request->getParam('dfechas') == '') {
					$val[] = array('txthasta', date("d-m-Y"), 'val');
				}
			}
		}

		$fn[] = array('
				$("#txtdesde").datepicker();
				$("#txthasta").datepicker();
				deshabilitarComponente("txtcodcentropobl",true);
				deshabilitarComponente("cbotipo",true);
				deshabilitarComponente("txtcentropobl",true);
				deshabilitarComponente("cbotipo",true);
				deshabilitarComponente("cboPostal",true);
				deshabilitarComponente("nrozona",true);
				deshabilitarComponente("txtdesde",true);
				deshabilitarComponente("txthasta",true);');

		$pintar->PintarValor($val);
		$pintar->EjecutarFuncion($fn);
	}

	public function centrpobsaveAction() {
		$this->_helper->layout->disableLayout();
		$this->_helper->viewRenderer->setNoRender();
		$this->_helper->getHelper('ajaxContext')->initContext();
		if ($this->getRequest()->isXmlHttpRequest()) {
			$idsigma = $this->_request->getPost('mpoblad');
			$ccodcen = $this->_request->getPost('ccodcen');
			$ctippob = $this->_request->getPost('ctippob');
			$vnompob = $this->_request->getPost('vnompob');
			$cidzona = $this->_request->getPost('cidzona');
			$dfecdes = $this->_request->getPost('dfecdes');
			$dfechas = $this->_request->getPost('dfechas');
			$nestado = $this->_request->getPost('nestado');
			$oper = $this->_request->getPost('oper'); // add	edit del
			$id = $this->_request->getPost('id');

			$ddatosuserlog = new Zend_Session_Namespace('datosuserlog');
			$userlogin = $ddatosuserlog->userlogin;
			$cn = new Model_DataAdapter ();
			$nombrestore = '"registro".guardarmpoblad';
			$parametros [0] = $idsigma;
			$parametros [1] = $ccodcen;
			$parametros [2] = $vnompob;
			$parametros [3] = "01";
			$parametros [4] = $ctippob;
			$parametros [5] = $cidzona;
			$parametros [6] = '01/01/' . $dfecdes;
			$parametros [7] = '31/12/' . $dfechas;
			$parametros [8] = $nestado;
			$parametros [9] = $this->view->util()->getHost();
			$parametros [10] = $userlogin;

			$datos = $cn->ejec_store_procedura_sql($nombrestore, $parametros);
			if ($datos[0][0] == '1') {

			} else {
				header("Status: 400 Error al Guardar intentelo en otro momento o contacte al adminsitrador");
			}
		}
	}

	public function manttcentrpobAction() {
		$this->_helper->layout->disableLayout();
		$this->_helper->getHelper('ajaxContext')->initContext();

		if ($this->getRequest()->isXmlHttpRequest()) {
			$name = $this->_request->getParam('name');

			$ddatosuserlog = new Zend_Session_Namespace('datosuserlog');
			$cidpers = $ddatosuserlog->cidpers;
			$userlogin = $ddatosuserlog->userlogin;

			$p_ccodcen = $this->_request->getParam('p_ccodcen');
			$p_vnombre = $this->_request->getParam('p_vnombr');
			$p_cdistri = $this->_request->getParam('p_cdistri');
			$p_ctipcen = $this->_request->getParam('p_ctipcen');
			$p_cidzona = $this->_request->getParam('p_cidzona');
			$p_dfecdes = $this->_request->getParam('p_dfecdes');
			$p_dfechas = $this->_request->getParam('p_dfechas');
			$p_nestado = $this->_request->getParam('p_nestado');
			$p_vhostnm = $userlogin;
			$p_vusernm = $this->view->util()->getHost();

			if ($p_dfechas == '') {
				$p_dfechas = date("d-m-Y");
			}

			$cn = new Model_DataAdapter ();
			$nombrestore = '"public".guardarmpoblad';
			$parametros [0] = $p_ccodcen;
			$parametros [1] = $p_ccodcen;
			$parametros [2] = $p_vnombre;
			$parametros [3] = $p_cdistri;
			$parametros [4] = $p_ctipcen;
			$parametros [5] = $p_cidzona;
			$parametros [6] = $p_dfecdes;
			$parametros [7] = $p_dfechas;
			$parametros [8] = $p_nestado;
			$parametros [9] = $p_vhostnm;
			$parametros [10] = $p_vusernm;
			$tabla = $datos = $cn->ejec_store_procedura_sql($nombrestore, $parametros);
			print_r($tabla);
		}
	}
	
	public function mcajaAction(){
		$this->view->util()->registerScriptJSControllerAction($this->getRequest());
	}
	public function mcajasaveAction(){
		$this->_helper->layout->disableLayout();
		$this->_helper->viewRenderer->setNoRender();
		$this->_helper->getHelper('ajaxContext')->initContext();
		if ($this->getRequest()->isXmlHttpRequest()) {
			$idsigma = $this->_request->getPost('idsigma');
			$cnrocaja = $this->_request->getPost('cnrocaja');
			$dlocal = $this->_request->getPost('dlocal');
			$nestado = $this->_request->getPost('nestado');
			$oper = $this->_request->getPost('oper'); // add	edit del
			$id = $this->_request->getPost('id');
			//tesoreria.guardarmcaja(
					/*p_idsigma character varying, 
					p_cnrocaja character varying, 
					p_cidlocal character varying, 
					p_nestado character varying, 
					p_vusernm character varying, 
					p_vhostnm character varying, 
					p_ref refcursor)*/
		
			$ddatosuserlog = new Zend_Session_Namespace('datosuserlog');
			$userlogin = $ddatosuserlog->userlogin;
			$cn = new Model_DataAdapter ();
			$nombrestore = 'tesoreria.guardarmcaja';
			$parametros [0] = $idsigma;
			$parametros [1] = $cnrocaja;
			$parametros [2] = $dlocal;
			$parametros [3] = $nestado;
			$parametros [4] = $userlogin;
			$parametros [5] = $this->view->util()->getHost();
		
			$datos = $cn->ejec_store_procedura_sql($nombrestore, $parametros);
			
			if ($datos[0][0] == '1') {
				//header("Status: 400 Error al guardar".print_r($datos));
			} else {
				header("Status: 400 Error al Guardar intentelo en otro momento o contacte al adminsitrador");
				//header("Status: 400 $idsigma|$cnrocaja|$dlocal|$nestado|$oper|$id");
			}
		}
	}
	public function cajerosAction(){
		$this->view->util()->registerScriptJSControllerAction($this->getRequest());
	}
	public function cajerosviewAction(){
		//$this->view->util()->registerScriptJSControllerAction($this->getRequest());
		if ($this->getRequest()->isXmlHttpRequest()) {
			$this->_helper->getHelper('ajaxContext')->initContext();
			$this->_helper->layout->disableLayout();
			$dataAdapter = new Model_DataAdapter();
			$parameters[] = "";
			$parameters[] = "";
			$parameters[] = "";
			$parameters[] = "1";
			$datoscajas = $dataAdapter->ejec_store_procedura_sql("tesoreria.buscar_cajas", $parameters);
			
			/*seguridad.buscar_usuario(
					p_cidusuario character varying DEFAULT ''::character varying, 
					p_usuario character varying DEFAULT ''::character varying, 
					p_cidpers character varying DEFAULT ''::character varying, 
					p_cidarea character varying DEFAULT ''::character varying, 
					p_estado character varying DEFAULT ''::character varying,
					p_tipousuario*/
			$parametersu[] = "";//p_cidusuario
			$parametersu[] = "";//p_usuario
			$parametersu[] = "";//p_cidpers
			$parametersu[] = "";//p_cidarea
			$parametersu[] = "1";//p_estado
			$parametersu[] = "U";//p_tipousuario
			$datosusuarios = $dataAdapter->ejec_store_procedura_sql("seguridad.buscar_usuario", $parametersu);
			
			$arrmusu = array();
			for ($i = 0; $i < count($datosusuarios); $i++) {
				$arrmusu[] = array("category"=>"","label"=>$datosusuarios[$i][5],"_cidusuario"=>$datosusuarios[$i][0],"_cidarea"=>$datosusuarios[$i][1],"_cidpers"=>$datosusuarios[$i][2],"_nombrepers"=>$datosusuarios[$i][3],"_usuario"=>$datosusuarios[$i][5]);
			}
			//print_r($arrmusu);
			$this->view->musuari = $arrmusu;
			
			
			$arrmcajas = array();
			for ($i = 0; $i < count($datoscajas); $i++) {
				$arrmcajas[] = array("category"=>"","label"=>$datoscajas[$i][1],"idsigmamcaja"=>$datoscajas[$i][0],"cnrocaja"=>$datoscajas[$i][1],"cidlocal"=>$datoscajas[$i][2],"dlocal"=>$datoscajas[$i][3]);
			}
			$this->view->mcajas = $arrmcajas;
		}
	}
	public function cajerossaveAction(){
		//$this->view->util()->registerScriptJSControllerAction($this->getRequest());
		if ($this->getRequest()->isXmlHttpRequest()) {
			$this->_helper->layout->disableLayout();
			$this->_helper->viewRenderer->setNoRender();
			$this->_helper->getHelper('ajaxContext')->initContext();
			$idsigma = $this->_request->getPost('idsigma');
			$usuario = $this->_request->getPost('usuario');
			$ciduser = $this->_request->getPost('ciduser');
			$nomusuario = $this->_request->getPost('nomusuario');
			$cidpers = $this->_request->getPost('cidpers');
			$cnrocaja = $this->_request->getPost('cnrocaja');
			$idsigmamcaja = $this->_request->getPost('idsigmamcaja');
			$dlocal = $this->_request->getPost('dlocal');
			$cidlocal = $this->_request->getPost('cidlocal');
			$ccodcos = $this->_request->getPost('ccodcos');
			$dfecini = $this->_request->getPost('dfecini');
			$dfecfin = $this->_request->getPost('dfecfin');
			$nestado = $this->_request->getPost('nestado');
			
			if ($nestado==''){
				$nestado='0';
			}
			
			$ddatosuserlog = new Zend_Session_Namespace('datosuserlog');
			$userlogin = $ddatosuserlog->userlogin;
			$dataAdapter = new Model_DataAdapter();
			$parametersu[] = $idsigma;//
			$parametersu[] = $ciduser;//
			$parametersu[] = $cnrocaja;//
			$parametersu[] = $ccodcos;//
			$parametersu[] = $dfecini;//
			$parametersu[] = $dfecfin;//
			$parametersu[] = $nestado;
			$parametersu[] = $userlogin;
			$parametersu[] = $this->view->util()->getHost();
			
			$datosresult = $dataAdapter->ejec_store_procedura_sql("tesoreria.guardarmcajero", $parametersu);
			echo $datosresult[0][1];
			//if ($datosresult[0][0]=='1') 
			/*tesoreria.guardarmcajero(
				p_idsigma character varying, 
				p_ciduser character varying, 
				p_ccajero character varying, 
				p_ccodcos character varying,
				p_dfecini character varying,
				p_dfecfin character varying,						
				p_nestado character varying, 
				p_vusernm character varying, 
				p_vhostnm character varying, */
		}
	}
	
	public function paramfraccAction(){
		 $this->view->util()->registerScriptJSControllerAction($this->getRequest());
		$this->_helper->layout->disableLayout();	   
		$pintar= new Libreria_Pintar();

		$js[]=array('themeTextBox(); themeComboBox();');
		
						
		$js[]=array('$( "#txtporimpofracct" ).autoNumeric();');
		$js[]=array('$( "#txtmontdetert" ).autoNumeric();');
		
		$js[]=array('$("#txtporimpofracctipjur").autoNumeric();');
		$js[]=array('$("#txtmontdeterttipjur").autoNumeric();');
		
		$js[]=array('$("#txtporimpofracctipnorm").autoNumeric();');
		$js[]=array('$("#txtmontdeterttipnorm").autoNumeric();');
		
		$valor[]=array(0,'ORDENANZA');

		$val[]=array('cbocoddoc',$pintar->ContenidoCombo($valor,'0'),'html');
			
		$js[] = array('$("#txtfechdoc").datepicker({showOn: "button", buttonImage: jQuery.scriptPath + "img/calendar.gif",	buttonImageOnly: true});');
		
		$evt[]=array('opcion1','click',' if($("#opcion1").is(\':checked\')) {$( "#txtporimpofracct" ).val(0);$( "#txtmontdetert" ).val(0);};');
		
		$cn = new Model_DataAdapter ();
		$nombrestore = '"recaudacion".paramrec';
		$parametros [0] = '0000000001';
		$tabla = $datos = $cn->ejec_store_procedura_sql($nombrestore, $parametros);
		//print_r($tabla);

		$val[]=array('txtidsigma',$tabla[0][0],'val');
		$val[]=array('txtporimpofracct',$tabla[0][4],'val');
		$val[]=array('txtmontdetert',$tabla[0][3],'val');
		$val[]=array('txtnrodoc',$tabla[0][6],'val');
		$val[]=array('txtfechdoc',substr($tabla[0][7],0,10),'val');
		
		
		$evt[]=array('btngrabar','click','
		var p_idsigma=$("#txtidsigma").val();
 		var p_ncantidad=$("#txtmontdetert").val();
 		var p_nporcentaje=$("#txtporimpofracct").val();
 		var p_codigo_doc=$("#cbocoddoc").val();
 		var p_cresolucion=$("#txtnrodoc").val();
 		var p_dfec_resol=$("#txtfechdoc").val(); 	

		$.ajax( {
			dataType : "html",
			type : "POST",
			url : path + "/mantenimientos/paramrecsave/",
			data :  "p_idsigma="+p_idsigma+
					 "&p_ncantidad="+p_ncantidad+
					 "&p_nporcentaje="+p_nporcentaje+
					 "&p_codigo_doc="+p_codigo_doc+
					 "&p_cresolucion="+p_cresolucion+
					 "&p_dfec_resol="+p_dfec_resol,
			beforeSend : function(data) {
				$(\'#locategrid\').html(\'Procesando...\');
			},
			success : function(requestData) {
				$("#locategrid").html(requestData);
			},
			error : function(requestData, strError, strTipoError) {
				$("#locategrid").html("Error " + strTipoError + \': \' + strError);
			},
			complete : function(requestData, exito) {
				window.location.reload();
			}
		});');
				
		$pintar->PintarValor($val);
		$pintar->PintarEvento($evt);
		$pintar->EjecutarFuncion($js);
			
		
	}
	
	public  function paramrecsaveAction(){
		    if ($this->getRequest()->isXmlHttpRequest()) {
			$this->_helper->layout->disableLayout();
			$this->_helper->viewRenderer->setNoRender();
			$this->_helper->getHelper('ajaxContext')->initContext();
			$p_idsigma= $this->_request->getPost('p_idsigma');
			$p_ncantidad= $this->_request->getPost('p_ncantidad');
			$p_nporcentaje= $this->_request->getPost('p_nporcentaje');
			$p_codigo_doc= $this->_request->getPost('p_codigo_doc');
			$p_cresolucion= $this->_request->getPost('p_cresolucion');
			$p_dfec_resol= $this->_request->getPost('p_dfec_resol');
			
			$dataAdapter = new Model_DataAdapter();
			$parametersu[] = $p_idsigma;//
			$parametersu[] = $p_ncantidad;//
			$parametersu[] = $p_nporcentaje;//
			$parametersu[] = $p_codigo_doc;//
			$parametersu[] = $p_cresolucion;//
			$parametersu[] = $p_dfec_resol;//

			
			$datosresult = $dataAdapter->ejec_store_procedura_sql("recaudacion.grabarparamrec", $parametersu);
			
	     }
	}

		public function paramfracmontominAction(){
			$this->view->util()->registerScriptJSControllerAction($this->getRequest());
			$this->_helper->layout->disableLayout();			
			$pintar= new Libreria_Pintar();
	
			$js[]=array('themeTextBox(); themeComboBox();');
						
			$js[]=array('$( "#txtporimpofracct2" ).autoNumeric();');
			$js[]=array('$( "#txtmontdetert2" ).autoNumeric();');
			
			$js[]=array('$("#txtporimpofracctipjur2").autoNumeric();');
			$js[]=array('$("#txtmontdeterttipjur2").autoNumeric();');
			
			$js[]=array('$("#txtporimpofracctipnorm2").autoNumeric();');
			$js[]=array('$("#txtmontdeterttipnorm2").autoNumeric();');
			
			$valor[]=array(0,'ORDENANZA');
	
			$val[]=array('cbocoddoc2',$pintar->ContenidoCombo($valor,'0'),'html');
			
			
			
			$js[] = array('$("#txtfechdoc2").datepicker({showOn: "button", buttonImage: jQuery.scriptPath + "img/calendar.gif",	buttonImageOnly: true});');
			//$js[] = array('$("#txtfechdoc").datepicker("option", "dateFormat", "yy-mm-dd");');
		
			
			
		
			$evt[]=array('opcion21','click',' if($("#opcion21").is(\':checked\')) {
			$( "#txtporimpofracc2t" ).val(0);
			$( "#txtmontdetert2" ).val(0);
	 		}');
			//$evt[]=array('opcion22','click','verificaropparam2();');
			//$evt[]=array('opcion3','click','verificaropparam();');
			
			$cn = new Model_DataAdapter ();
			$nombrestore = '"recaudacion".paramrec';
			$parametros [0] = '0000000002';
			$tabla = $datos = $cn->ejec_store_procedura_sql($nombrestore, $parametros);
			//print_r($tabla);
	
			$val[]=array('txtidsigma2',$tabla[0][0],'val');
			$val[]=array('txtporimpofracct2',$tabla[0][4],'val');
			$val[]=array('txtmontdetert2',$tabla[0][3],'val');
			$val[]=array('txtnrodoc2',$tabla[0][6],'val');
			$val[]=array('txtfechdoc2',substr($tabla[0][7],0,10),'val');
			
			
			$evt[]=array('btngrabar2','click',' var p_idsigma=$("#txtidsigma2").val();
			 var p_ncantidad=$("#txtmontdetert2").val();
			 var p_nporcentaje=0;
			 var p_codigo_doc=$("#cbocoddoc2").val();
			 var p_cresolucion=$("#txtnrodoc2").val();
			 var p_dfec_resol=$("#txtfechdoc2").val();
				 
				
			
			$.ajax( {
				dataType : "html",
				type : "POST",
				url : path + "/mantenimientos/paramrecsave/",
				data :  "p_idsigma="+p_idsigma+
						 "&p_ncantidad="+p_ncantidad+
						 "&p_nporcentaje="+p_nporcentaje+
						 "&p_codigo_doc="+p_codigo_doc+
						 "&p_cresolucion="+p_cresolucion+
						 "&p_dfec_resol="+p_dfec_resol,
				beforeSend : function(data) {
					$(\'#locategrid2\').html(\'Procesando...\');
				},
				success : function(requestData) {
					$("#locategrid2").html(requestData);
				},
				error : function(requestData, strError, strTipoError) {
					$("#locategrid2").html("Error " + strTipoError + \': \' + strError);
				},
				complete : function(requestData, exito) {
					window.location.reload();
				}
			});');
						
			$pintar->PintarValor($val);
			$pintar->PintarEvento($evt);
			$pintar->EjecutarFuncion($js);
		}
		
		public function paramfracuotasAction(){
				$this->view->util()->registerScriptJSControllerAction($this->getRequest());
				$this->_helper->layout->disableLayout();				
				$pintar= new Libreria_Pintar();
		
				$js[]=array('themeTextBox(); themeComboBox();');
				
				$js[]=array('$( "#txtporimpofracct3" ).autoNumeric();');
				$js[]=array('$( "#txtmontdetert3" ).autoNumeric();');
				
				$js[]=array('$("#txtporimpofracctipjur3").autoNumeric();');
				$js[]=array('$("#txtmontdeterttipjur3").autoNumeric();');
				
				$js[]=array('$("#txtporimpofracctipnorm3").autoNumeric();');
				$js[]=array('$("#txtmontdeterttipnorm3").autoNumeric();');
				
				$valor[]=array(0,'ORDENANZA');
		
				$val[]=array('cbocoddoc3',$pintar->ContenidoCombo($valor,'0'),'html');
				
				
				
				$js[] = array('$("#txtfechdoc3").datepicker({showOn: "button", buttonImage: jQuery.scriptPath + "img/calendar.gif",	buttonImageOnly: true});');
				//$js[] = array('$("#txtfechdoc").datepicker("option", "dateFormat", "yy-mm-dd");');
			
				
				
			
				$evt[]=array('opcion31','click',' if($("#opcion31").is(\':checked\')) {
						$( "#txtporimpofracct3" ).val(0);
						$( "#txtmontdetert3" ).val(0);
				 };');
				//$evt[]=array('opcion32','click','verificaropparam3();');
				//$evt[]=array('opcion3','click','verificaropparam();');
				
					$cn = new Model_DataAdapter ();
					$nombrestore = '"recaudacion".paramrec';
					$parametros [0] = '0000000003';
					$tabla = $datos = $cn->ejec_store_procedura_sql($nombrestore, $parametros);
				//print_r($tabla);
		
				$val[]=array('txtidsigma3',$tabla[0][0],'val');
				$val[]=array('txtporimpofracct3',$tabla[0][4],'val');
				$val[]=array('txtmontdetert3',$tabla[0][3],'val');
				$val[]=array('txtnrodoc3',$tabla[0][6],'val');
				$val[]=array('txtfechdoc3',substr($tabla[0][7],0,10),'val');
				
				
				$evt[]=array('btngrabar3','click',' var p_idsigma=$("#txtidsigma3").val();
				 var p_ncantidad=$("#txtmontdetert3").val();
				 var p_nporcentaje=0
				 var p_codigo_doc=$("#cbocoddoc3").val();
				 var p_cresolucion=$("#txtnrodoc3").val();
				 var p_dfec_resol=$("#txtfechdoc3").val();									
				
				$.ajax( {
					dataType : "html",
					type : "POST",
					url : path + "/mantenimientos/paramrecsave/",
					data :  "p_idsigma="+p_idsigma+
							 "&p_ncantidad="+p_ncantidad+
							 "&p_nporcentaje="+p_nporcentaje+
							 "&p_codigo_doc="+p_codigo_doc+
							 "&p_cresolucion="+p_cresolucion+
							 "&p_dfec_resol="+p_dfec_resol,
					beforeSend : function(data) {
						$(\'#locategrid3\').html(\'Procesando...\');
					},
					success : function(requestData) {
						$("#locategrid3").html(requestData);
					},
					error : function(requestData, strError, strTipoError) {
						$("#locategrid3").html("Error " + strTipoError + \': \' + strError);
					},
					complete : function(requestData, exito) {
						window.location.reload();
					}
				});');
				
				$pintar->PintarValor($val);
				$pintar->PintarEvento($evt);
				$pintar->EjecutarFuncion($js);
		}
		
		public function  paramfracuotasatrasadasAction(){
				$this->view->util()->registerScriptJSControllerAction($this->getRequest());
				$this->_helper->layout->disableLayout();				
				$pintar= new Libreria_Pintar();
			
				$js[]=array('themeTextBox(); themeComboBox();');
				
				$js[]=array('$( "#txtporimpofracct4" ).autoNumeric();');
				$js[]=array('$( "#txtmontdetert4" ).autoNumeric();');
				
				$js[]=array('$("#txtporimpofracctipjur4").autoNumeric();');
				$js[]=array('$("#txtmontdeterttipjur4").autoNumeric();');
				
				$js[]=array('$("#txtporimpofracctipnorm4").autoNumeric();');
				$js[]=array('$("#txtmontdeterttipnorm4").autoNumeric();');
				
				$valor[]=array(0,'ORDENANZA');
		
				$val[]=array('cbocoddoc4',$pintar->ContenidoCombo($valor,'0'),'html');
				
				
				
				$js[] = array('$("#txtfechdoc4").datepicker({showOn: "button", buttonImage: jQuery.scriptPath + "img/calendar.gif",	buttonImageOnly: true});');
				//$js[] = array('$("#txtfechdoc").datepicker("option", "dateFormat", "yy-mm-dd");');
			
				
				
			
				//$evt[]=array('opcion41','click','verificaropparam4();');
				//$evt[]=array('opcion42','click','verificaropparam4();');
				//$evt[]=array('opcion3','click','verificaropparam();');
				
					$cn = new Model_DataAdapter ();
					$nombrestore = '"recaudacion".paramrec';
					$parametros [0] = '0000000005';
					$tabla = $datos = $cn->ejec_store_procedura_sql($nombrestore, $parametros);
				//print_r($tabla);
		
				$val[]=array('txtidsigma4',$tabla[0][0],'val');
				$val[]=array('txtporimpofracct4',$tabla[0][4],'val');
				$val[]=array('txtmontdetert4',$tabla[0][3],'val');
				$val[]=array('txtnrodoc4',$tabla[0][6],'val');
				$val[]=array('txtfechdoc4',substr($tabla[0][7],0,10),'val');
				
				
				$evt[]=array('btngrabar4','click','var p_idsigma=$("#txtidsigma4").val();
 				var p_ncantidad=$("#txtmontdetert4").val();
 				var p_nporcentaje=0;
 				var p_codigo_doc=$("#cbocoddoc4").val();
 				var p_cresolucion=$("#txtnrodoc4").val();
 				var p_dfec_resol=$("#txtfechdoc4").val();
				$.ajax( {
					dataType : "html",
					type : "POST",
					url : path + "/mantenimientos/paramrecsave/",
					data :  "p_idsigma="+p_idsigma+
							 "&p_ncantidad="+p_ncantidad+
							 "&p_nporcentaje="+p_nporcentaje+
							 "&p_codigo_doc="+p_codigo_doc+
							 "&p_cresolucion="+p_cresolucion+
							 "&p_dfec_resol="+p_dfec_resol,
					beforeSend : function(data) {
						$("#locategrid4").html("Procesando...");
					},
					success : function(requestData) {
						$("#locategrid4").html(requestData);
					},
					error : function(requestData, strError, strTipoError) {
						$("#locategrid4").html("Error " + strTipoError + ": " + strError);
					},
					complete : function(requestData, exito) {
						window.location.reload();
					}
				});	');
				
				$pintar->PintarValor($val);
				$pintar->PintarEvento($evt);
				$pintar->EjecutarFuncion($js);
			
		}
		
		public function paramfracAction(){
			
			$pintar=new Libreria_Pintar();
			
			$fun[]=array('$( "#tabs" ).tabs();');
			
			$pintar->EjecutarFuncion($fun);
			
			
		}
		
}