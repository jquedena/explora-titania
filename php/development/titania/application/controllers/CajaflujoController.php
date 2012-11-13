<?php

require_once 'Zend/Controller/Action.php';

class CajaflujoController extends Zend_Controller_Action {

	public function init() {
		$this->view->util()->registerScriptJSController($this->getRequest());
		$this->view->util()->registerLeaveControllerAction($this->getRequest());


	}

	public function indexAction() {
		$this->view->util()->registerScriptJSControllerAction($this->getRequest());
		$ddatosuserlog = new Zend_Session_Namespace('datosuserlog');
		// Test
		$nrocaja = $ddatosuserlog->codcajero;
		// Test

		$nombrestore = '"public"."pxcobrowww"';
		$arraydatos [0] = '3';
		$arraydatos [1] = '';
		$arraydatos [2] = '';
		$cn = new Model_DataAdapter();
		$datosfecha = $cn->ejec_store_procedura_sql($nombrestore, $arraydatos);
		$dfecha = explode(" ", $datosfecha[0][0]);
		$date = $dfecha[0];

		$evt[] = array("btnaperturar", "click", "aperturarcaja('1');");

		$ctrl[] = array('txtnrocaja', true);
		$ctrl[] = array('txtfecha', true);

		$val[] = array('txtnrocaja', substr($nrocaja, -2), 'val');
		$val[] = array('txtfecha', $date, 'val');

		$func = new Libreria_Pintar();
		$func->IniciaScript();
		$func->PintarEvento($evt);
		$func->ComponenteSoloLectura($ctrl);
		$func->PintarValor($val);
		$func->FinScript();
	}

	/*Opcion : Aperturar de Caja(Usuario-Cajero) Vista*/
	public function aperturacajaAction() {
		$this->view->util()->registerScriptJSControllerAction($this->getRequest());
		$ddatosuserlog = new Zend_Session_Namespace('datosuserlog');
		// substr($ddatosuserlog->codcajero, -2);
		$nrocaja = substr($ddatosuserlog->codcajero, -2);
		$ciduser = $ddatosuserlog->cidpers;
		$func = new Libreria_Pintar();
		$cn = new Model_DataAdapter();
			
		$nombrestore = '"public"."pxcobrowww"';
		$arraydatos [0] = '2';
		$arraydatos [1] = '';
		$arraydatos [2] = '';
		$datosfecha = $cn->ejec_store_procedura_sql($nombrestore, $arraydatos);
		$dfecha = explode(" ", $datosfecha[0][0]);
		$date = $dfecha[0];
			
		$nombrestore = '"public".obt_mconten';
		$parametros [0] = '';
		$parametros [1] = '1000000346';
		$datosLocales = $cn->ejec_store_procedura_sql($nombrestore, $parametros);
		for ($i=0;count($datosLocales)>$i;$i++){
			if ($datosLocales[$i][0] != $datosLocales[$i][2])
				$cboLocales[] = array($datosLocales[$i][0],$datosLocales[$i][1]);
		}

		$nombrestore = 'tesoreria.cajasapert';
		$parametros2 [] = $date;//p_dfecpro
		$parametros2 [] = $nrocaja;//p_numcaja
		$parametros2 [] = '';//p_op
		$parametros2 [] = '0';//p_estado
		$datosCajero = $cn->ejec_store_procedura_sql($nombrestore, $parametros2);
		if (count($datosCajero)==0){
			$val[] = array('divmsj', 'La caja no se encuentra habilitada <br/><br/>', 'html');

			$func->PintarValor($val);
		}else{
			$nomCajero =$datosCajero[0][16];//nombre completo del cajero
			$nmonApe =$datosCajero[0][10];//monto apert
			$idpertCaja =$datosCajero[0][1];//idapertura caja
			$cidlocal = $datosCajero[0][17];//codigo de agencia
			$observ = $datosCajero[0][19]; #observacion
			$this->view->observ = $observ;
			//$arrayestado = array(array('1', 'HABILITADO'), array('0', 'DESHABILITADO'));
			$val[] = array('cbolocal', $func->ContenidoCombo($cboLocales, $cidlocal), 'html');


			$evt[] = array("btnaperturar", "click", "aperturarcaja();");

			$ctrl[] = array('txtnrocaja', true);
			$ctrl[] = array('txtfecha', true);

			
				
			$val[] = array('txtnrocaja', $nrocaja.' - '.$ddatosuserlog->userlogin, 'val');
			$val[] = array('txtfecha', $date, 'val');
			$val[] = array('hddnrocaja', $nrocaja, 'val');
			$val[] = array('txtnomcajero', $nomCajero, 'val');
			$val[] = array('txtmtinicial', $nmonApe, 'val');
			$val[] = array('hddidapercaja', $idpertCaja, 'val');
			$val[] = array('txtcodapert', intval($idpertCaja), 'val');
			//$val[] = array('observ', $observ, 'html');

			$func->IniciaScript();
			$func->PintarEvento($evt);
			$func->ComponenteSoloLectura($ctrl);
			$func->PintarValor($val);
			$func->FinScript();
		}
	}

	/*Apertura Caja :P Accion*/
	public function actaperturarcajaAction() {
		$this->_helper->getHelper('ajaxContext')->initContext();
		if ($this->getRequest()->isXmlHttpRequest()) {
			$this->_helper->viewRenderer->setNoRender();
			$this->_helper->layout->disableLayout();

			$vnrocaja = $this->_request->getPost('vnrocaja');
			$vfecha = $this->_request->getPost('vfecha');
			$vobs = $this->_request->getPost('obs');
			$vlocal = $this->_request->getPost('vlocal');
			$func = new Libreria_Pintar();

			$ddatosuserlog = new Zend_Session_Namespace('datosuserlog');
			$vusernm = $ddatosuserlog->userlogin;
			$ciduser = $ddatosuserlog->cidpers;
			$vhostnm=$this->view->util()->getHost();
			$cn = new Model_DataAdapter();
			$store = "tesoreria.aperturarcaja";
			/*tesoreria.aperturarcaja(
			 * 		 p_cnrcaja character varying
					, p_dfecpro character varying
					, p_ciduser character varying
					, p_vusernm character varying
					, p_vhostnm character varying
					, p_nestado character varying
					, p_vobserv character varying
					*/
			// if ($vaccion == '1') {
			$arstore [0] = $vnrocaja;//nro caja*
			$arstore [1] = $vfecha; //fecha
			$arstore [2] = $ciduser;//cidusuario
			$arstore [3] = $vusernm;//usuario *
			$arstore [4] = $vhostnm; # *
			$arstore [5] = '1';# *
			$arstore [6] = $vobs; # *
			$arstore [7] = $vlocal; # *
			$dt = $cn->ejec_store_procedura_sql($store, $arstore);
			echo "<h3>" . $dt[0][0] . "</h3>";
			//}
			/*elseif ($vaccion == '2') {
			 $Arcajas = explode(",", $vnrocaja);
			$dtlle = '';
			for ($i = 0; $i < count($Arcajas); $i++) {
			$arstore [0] = $Arcajas[$i];
			$arstore [1] = $vfecha; // La fecha se ingresa?
			$arstore [2] = $ciduser;
			$arstore [3] = $nomuser;
			$arstore [4] = "";
			$arstore [5] = $vaccion;
			$arstore [6] = $vobs;
			$dt = $cn->ejec_store_procedura_sql($store, $arstore);
			if (is_array($dt)) {
			echo $dt[0][0] . "  \" Caja Nro: " . $Arcajas[$i] . "\"<br>";
			$dtlle .=$dt[0][0] . "  \" Caja Nro: " . $Arcajas[$i] . "\"<br>";
			}
			}

			$val[] = array("result2", "<h3>Ultima Operacion: <br>" . $dtlle . "</h3>", "html");
			$func->PintarValor($val);
			$f [] = array("lstcajasapert();");
			$func->EjecutarFuncion($f);
			}*/
		}
	}
	/*Opcion cerrar caja*/
	public function cerrarcajaAction() {
		$this->view->util()->registerScriptJSControllerAction($this->getRequest());
		$ddatosuserlog = new Zend_Session_Namespace('datosuserlog');
		// substr($ddatosuserlog->codcajero, -2);
		$nrocaja = substr($ddatosuserlog->codcajero, -2);
		$ciduser = $ddatosuserlog->cidpers;
		$func = new Libreria_Pintar();
		$cn = new Model_DataAdapter();
			
		$nombrestore = '"public"."pxcobrowww"';
		$arraydatos [0] = '2';
		$arraydatos [1] = '';
		$arraydatos [2] = '';
		$datosfecha = $cn->ejec_store_procedura_sql($nombrestore, $arraydatos);
		$dfecha = explode(" ", $datosfecha[0][0]);
		$date = $dfecha[0];

		$nombrestore = 'tesoreria.cajasapert';
		$parametros2 [] = $date;//p_dfecpro
		$parametros2 [] = $nrocaja;//p_numcaja
		$parametros2 [] = '';//p_op
		$parametros2 [] = '0';//p_estado
		$datosCajero = $cn->ejec_store_procedura_sql($nombrestore, $parametros2);
		if (count($datosCajero)==0){
			$val[] = array('divmsj', 'La caja no se encuentra habilitada <br/><br/>', 'html');

			$func->PintarValor($val);
		}else{
			$nomCajero =$datosCajero[0][16];
			$nmonApe =$datosCajero[0][10];
			$nmonVal=$datosCajero[0][11];
			$nmonentregar=$datosCajero[0][13];
			
			$idpertCaja =$datosCajero[0][1];
			
			$nroinicial =$datosCajero[0][4];
			$nrofinal =$datosCajero[0][5];
			
			
			$evt[] = array("btncerrarcaja", "click", "ventanaCerrarCaja();");

			$ctrl[] = array('txtnrocaja', true);
			$ctrl[] = array('txtfecha', true);

			$val[] = array('txtnrocaja', $nrocaja.' - '.$ddatosuserlog->userlogin, 'val');
			$val[] = array('hddnomcaj', $ddatosuserlog->userlogin, 'val');
			$val[] = array('txtfecha', $date, 'val');
			$val[] = array('hddnrocaja', $nrocaja, 'val');
			$val[] = array('txtnomcajero', $nomCajero, 'val');
			$val[] = array('txtmtinicial', 'S/.'.$nmonApe, 'val');
			$val[] = array('txtmtcobrado', 'S/.'.$nmonVal, 'val');
			$val[] = array('txtmtentregar', 'S/.'.$nmonentregar, 'val');
			$val[] = array('hddidapercaja', $idpertCaja, 'val');
			$val[] = array('txtcodapert', intval($idpertCaja), 'val');
			
			$val[] = array('txtnroini', $nroinicial, 'val');
			$val[] = array('txtnrofinal', $nrofinal, 'val');
			
			$func->IniciaScript();
			$func->PintarEvento($evt);
			$func->ComponenteSoloLectura($ctrl);
			$func->PintarValor($val);
			$func->FinScript();
		}
	}


	public function datoscajaAction() {
		$this->_helper->getHelper('ajaxContext')->initContext();
		if ($this->getRequest()->isXmlHttpRequest()) {
			$this->_helper->viewRenderer->setNoRender();
			$this->_helper->layout->disableLayout();

			$nrocaja = $this->_request->getPost('nrocaja');
			$op = $this->_request->getPost('op');

			$cn = new Model_DataAdapter();
			$store = "tesoreria.cajasapert";
			$ardts[] = '';
			$ardts[] = $nrocaja;
			$ardts[] = $op;
			$datos = $cn->ejec_store_procedura_sql($store, $ardts);
			$f = null;

			if ($datos[0][0] == '0') {
				if ($op == '1') {
					$val[] = array("txtfecha", $datos[0][2], "val");
					$val[] = array("txtnroini", $datos[0][3], "val");
					$val[] = array("txtnrofin", $datos[0][4], "val");
					$val[] = array("txtmontcan", number_format($datos[0][5], 2), "val");
				} else {
					$val[] = array("txtnrofin", $datos[0][4], "val");
					$val[] = array("txtmontcan", number_format($datos[0][5], 2), "val");
				}
				$hab[] = array("cerrarcaja", true);
			} elseif ($datos[0][0] == '1') {
				$f [] = array("openDialogWarning('" . $datos[0][1] . "', 350, 130);");

				$hab[] = array("cerrarcaja", false);

				$val[] = array("txtfecha", "", "val");
				$val[] = array("txtnroini", "", "val");
				$val[] = array("txtobs", "", "val");
				$val[] = array("txtnrofin", "", "val");
				$val[] = array("txtmontcan", "", "val");
				$val[] = array("result2", "", "html");
			}

			$func = new Libreria_Pintar();
			$func->IniciaScript();
			$func->EjecutarFuncion($f);
			$func->HabilitarComponente($hab);
			$func->PintarValor($val);
			$func->FinScript();
		}
	}
	
	public function actcerrarcajaAction() {
		$this->_helper->getHelper('ajaxContext')->initContext();
		if ($this->getRequest()->isXmlHttpRequest()) {
			$this->_helper->viewRenderer->setNoRender();
			$this->_helper->layout->disableLayout();

			$obs = $this->_request->getPost('obs');
			$vfecha = $this->_request->getPost('fecha');
			$nrocaja = $this->_request->getPost('nrocaja');
			$duser = new Zend_Session_Namespace('userlogin');
			$vuser = $duser->data;
			$cn = new Model_DataAdapter();
			$store = "tesoreria.cerrarcaja";
			$Arcajas = explode(",", $nrocaja);
			echo "<h3>";
			for ($i = 0; $i < count($Arcajas); $i++) {
				$arstore [0] = $Arcajas[$i];
				$arstore [1] = $vfecha;
				$arstore [2] = $vuser;
				$arstore [3] = "";
				$arstore [4] = $obs;
				$dt = $cn->ejec_store_procedura_sql($store, $arstore);
				if (is_array($dt)) {
					echo $dt[0][0] . "  \" Caja Nro: " . $Arcajas[$i] . "\"</h3>";
				}
			}
			$func = new Libreria_Pintar();
			$f [] = array("lstcajasapert();");
			$func->EjecutarFuncion($f);
		}
	}
	/*opcion Cerrar Cajas --  y no cierra nada xD (tesorero)*/
	public function cerrarcajasAction(){
		/*$nombrestore = '"public"."pxcobrowww"';
		$arraydatos [0] = '2';
		$arraydatos [1] = '';
		$arraydatos [2] = '';
		$cn = new Model_DataAdapter();
		$datosfecha = $cn->ejec_store_procedura_sql($nombrestore, $arraydatos);
		$dfecha = explode(" ", $datosfecha[0][0]);
		$date = $dfecha[0];

		$evt [] = array("btnbuscar", "click", "lstcajasapert();");
		$evt [] = array("btnreaperturar", "click", "ventanareapertura();");
		$evt [] = array("btncerrarcaja", "click", "cerrarTodasCajas();");
		$evt [] = array("btnhabilitar", "click", "habsencillera();");

		$val[] = array('txtdia', $date, 'val');

		$js[] = array('lstcajasapert();');
		$js[] = array('$("#txtdia").datepicker({showOn: "button", buttonImage: jQuery.scriptPath + "img/calendar.gif",	buttonImageOnly: true});');
		$js[] = array('$("#txtdia").datepicker("option", "dateFormat", "yy-mm-dd");');

		$func = new Libreria_Pintar();
		$func->IniciaScript();
		$func->EjecutarFuncion($js, "function");
		$func->PintarEvento($evt);
		$func->PintarValor($val);
		$func->FinScript();*/
		$nombrestore = '"public"."pxcobrowww"';
		$arraydatos [0] = '2';
		$arraydatos [1] = '';
		$arraydatos [2] = '';
		$cn = new Model_DataAdapter();
		$datosfecha = $cn->ejec_store_procedura_sql($nombrestore, $arraydatos);
		$dfecha = explode(" ", $datosfecha[0][0]);
		$date = $dfecha[0];
		
		
		$val[] = array('txtdia', $date, 'val');
		$js[] = array('$("#txtdia").datepicker({showOn: "button", buttonImage: jQuery.scriptPath + "img/calendar.gif",	buttonImageOnly: true});');
		$js[] = array('$("#txtdia").datepicker("option", "dateFormat", "yy-mm-dd");');
		
		$func = new Libreria_Pintar();
		$func->IniciaScript();
		$func->PintarValor($val);
		$func->EjecutarFuncion($js, "function");
		$func->FinScript();
		
		
		
		$this->view->util()->registerScriptJSControllerAction($this->getRequest());
	}
	public function graficocajerosAction(){
		$this->_helper->layout->disableLayout();
		$this->_helper->viewRenderer->setNoRender();
		$this->_helper->getHelper('ajaxContext')->initContext();
		if ($this->getRequest()->isXmlHttpRequest()) {
			$url = $this->view->util()->getPath();
			// Graficas
			$vfecha1 = $this->_request->getPost('fecha1');
			$vfecha2 = $this->_request->getPost('fecha2');
			$store = 'tesoreria.obtener_montoxcajero';
			$pgraf[] = $vfecha1;
			$pgraf[] = $vfecha2;
			$cn = new Model_DataAdapter ();
			$datosgraf = $cn->ejec_store_procedura_sql($store, $pgraf);
			$cadgrafcategorias = '';
			$cadgrafcancelado = '';
			$cadgrafanulado = '';
			$cadgrafdatospie = '';
			for ($i = 0; $i < count($datosgraf); $i++) {
				$cadgrafcategorias .="<category label='" . $datosgraf[$i][1] . "'/>";
				$cadgrafcancelado .="<set value='" . $datosgraf[$i][2] . "' />";
				$cadgrafanulado .="<set value='" . $datosgraf[$i][3] . "' />";
				$cadgrafdatospie .="<set label='" . $datosgraf[$i][1] . "' value='" . $datosgraf[$i][2] . "'/>";
			}
			
			if (count($datosgraf) > 0) {
				$cadgrafbarras = "<script >
				var chart = new FusionCharts('" . $url . "graf/MSColumn3D.swf', 'ChartbarrasId', '690', '500', '0', '0');
				chart.setDataXML(\"<chart palette='1' caption='Monto por cajeros' xAxisName='Cajero' yAxisName='Monto' numberPrefix='S/.' decimals='2'   formatNumberScale='0'    showValues='0'  rotateNames='1'  slantLabels='1' rotateValues='1' placeValuesInside='1' forceYAxisValueDecimals='1'  yAxisValueDecimals='2'>";
				$cadgrafbarras .= "<categories>" . $cadgrafcategorias . "</categories>";
				$cadgrafbarras .= "<dataset seriesname='Monto Cancelado' color='00CC33' showValues='1'>" . $cadgrafcancelado . " </dataset>";
				$cadgrafbarras .= "<dataset seriesname='Monto Anulado' color='F1C7D2'  showValues='1'> " . $cadgrafanulado . " </dataset>";
				$cadgrafbarras .= "</chart>\");
				chart.render(\"chartdivbarras\");
				</script> ";
			
				$cadgrafpie = "<script>
				var chartpie = new FusionCharts('" . $url . "graf/Pie3D.swf', 'ChartpieId', '690', '300', '0', '0');
				chartpie.setDataXML(\"<chart palette='1' caption='Monto por cajeros' numberPrefix='S/.' decimals='2' formatNumberScale='0'  enableSmartLabels='1' enableRotation='1' bgColor='99CCFF,FFFFFF' bgAlpha='40,100' bgRatio='0,100' bgAngle='360' showBorder='1' startingAngle='70'>" . $cadgrafdatospie . "</chart>\");
				chartpie.render(\"chartdivpie\");
				</script>";
			
				echo $cadgrafbarras . $cadgrafpie;
			}
		}
	}
	/*Opcion : Aperturar de Cajas(tesorero) Vista La Accion de esta vista esta en Sencillera*/
	public function cajasaperturadasAction() {
			
		$nombrestore = '"public"."pxcobrowww"';
		$arraydatos [0] = '2';
		$arraydatos [1] = '';
		$arraydatos [2] = '';
		$cn = new Model_DataAdapter();
		$datosfecha = $cn->ejec_store_procedura_sql($nombrestore, $arraydatos);
		$dfecha = explode(" ", $datosfecha[0][0]);
		$date = $dfecha[0];


		$val[] = array('txtdia', $date, 'val');
		$js[] = array('$("#txtdia").datepicker({showOn: "button", buttonImage: jQuery.scriptPath + "img/calendar.gif",	buttonImageOnly: true});');
		$js[] = array('$("#txtdia").datepicker("option", "dateFormat", "yy-mm-dd");');

		$func = new Libreria_Pintar();
		$func->IniciaScript();
		$func->PintarValor($val);
		$func->EjecutarFuncion($js, "function");
		$func->FinScript();
		$this->view->util()->registerScriptJSControllerAction($this->getRequest());

	}

	public function lstcajasapertAction() {
		$this->_helper->viewRenderer->setNoRender();
		$this->_helper->layout->disableLayout();
		$this->_helper->getHelper('ajaxContext')->initContext();
		if ($this->getRequest()->isXmlHttpRequest()) {

			$url = $this->view->util()->getPath();

			$vfecha = $this->_request->getPost('fecha');
			$cn = new Model_DataAdapter();
			$store = "tesoreria.cajasapert";

			// echo $vfecha;
			// $timestamp = strtotime($vfecha);
			// $vfecha = date('l dS \o\f F Y h:i:s A', $timestamp)

			$ardts[] = $vfecha;
			$ardts[] = '';
			$ardts[] = '';
			$datos = $cn->ejec_store_procedura_sql($store, $ardts);
			$totalcancelado = 0;
			$totalanulado = 0;
			if (is_array($datos)) {
				$dts = "";
				for ($i = 0; $i < count($datos); $i++) {
					$totalcancelado = $totalcancelado + $datos[$i][4];
					$totalanulado = $totalanulado + $datos[$i][5];
					$dts .='<tr>';
					$dts .='<td style="padding-left:10px;">' . $datos[$i][0] . ' - ' . $datos[$i][9] . '</td>'; // Nro. Caja
					$dts .='<td align="center">' . $datos[$i][2] . '</td>';
					$dts .='<td align="center">' . $datos[$i][3] . '</td>';
					$dts .='<td align="right">' . $datos[$i][4] . '</td>';
					$dts .='<td align="right">' . $datos[$i][5] . '</td>';
					$dts .='<td style="padding-left:10px;">' . $datos[$i][7] . '</td>'; // 6 Es el estado numerico 7 Es el nombre del estado
					$dts .='<td align="center">';
					$dts .='<input type="checkbox" id="Chkcaja_' . $i . '" value="' . $datos[$i][0] . '|' . $datos[$i][6] . '|' . $datos[$i][0] . ' - ' . $datos[$i][9] . '"           onchange="seleccionar(\'' . $datos [$i][0] . '\',\'' . $datos [$i][6] . '\');"/>';
					// $dts .='<input type="checkbox" id="Chkcaja_'.$i.'" onchange="seleccionar(\''.$datos[$i][0].'\',\''.$datos[$i][6].'\');"/>';
					$dts .='<input type="hidden" id="ids_' . $i . '" value="' . $datos[$i][10] . '" />';
					$dts .='</td>';
					$dts .='</tr>';
				}
				$dts .='<tr><td colspan="7"><hr style="border-color: green;"></td></tr>
				<tr>
				<td colspan="3" align="center" style="font-size:15px;font-weight: bold;" >Totales</td>
				<td align="right" style="font-size:15px;font-weight: bold;">' . number_format($totalcancelado, 2) . '</td>
				<td align="right" style="font-size:15px;font-weight: bold;">' . number_format($totalanulado, 2) . '</td>
				<td colspan="2">&nbsp;</td>
				</tr>';
			} else
				$dts = '<tr><td colspan="9" align="center">No ahi registros</td></tr>';
			echo "<tbody class='ui-table-body'>" . $dts . "</tbody>";

			// Graficas
			$store = 'tesoreria.obtener_montoxcajero';
			$pgraf[] = $vfecha;
			$pgraf[] = $vfecha;
			$cn = new Model_DataAdapter ();
			$datosgraf = $cn->ejec_store_procedura_sql($store, $pgraf);
			$cadgrafcategorias = '';
			$cadgrafcancelado = '';
			$cadgrafanulado = '';
			$cadgrafdatospie = '';
			for ($i = 0; $i < count($datosgraf); $i++) {
				$cadgrafcategorias .="<category label='" . $datosgraf[$i][1] . "'/>";
				$cadgrafcancelado .="<set value='" . $datosgraf[$i][2] . "' />";
				$cadgrafanulado .="<set value='" . $datosgraf[$i][3] . "' />";
				$cadgrafdatospie .="<set label='" . $datosgraf[$i][1] . "' value='" . $datosgraf[$i][2] . "'/>";
			}

			if (count($datosgraf) > 0) {
				$cadgrafbarras = "<script >
				var chart = new FusionCharts('" . $url . "graf/MSColumn3D.swf', 'ChartbarrasId', '690', '500', '0', '0');
				chart.setDataXML(\"<chart palette='1' caption='Monto por cajeros' xAxisName='Cajero' yAxisName='Monto' numberPrefix='S/.' decimals='2'   formatNumberScale='0'    showValues='0'  rotateNames='1'  slantLabels='1' rotateValues='1' placeValuesInside='1' forceYAxisValueDecimals='1'  yAxisValueDecimals='2'>";
				$cadgrafbarras .= "<categories>" . $cadgrafcategorias . "</categories>";
				$cadgrafbarras .= "<dataset seriesname='Monto Cancelado' color='00CC33' showValues='1'>" . $cadgrafcancelado . " </dataset>";
				$cadgrafbarras .= "<dataset seriesname='Monto Anulado' color='F1C7D2'  showValues='1'> " . $cadgrafanulado . " </dataset>";
				$cadgrafbarras .= "</chart>\");
				chart.render(\"chartdivbarras\");
				</script> ";

				$cadgrafpie = "<script>
				var chartpie = new FusionCharts('" . $url . "graf/Pie3D.swf', 'ChartpieId', '690', '300', '0', '0');
				chartpie.setDataXML(\"<chart palette='1' caption='Monto por cajeros' numberPrefix='S/.' decimals='2' formatNumberScale='0'  enableSmartLabels='1' enableRotation='1' bgColor='99CCFF,FFFFFF' bgAlpha='40,100' bgRatio='0,100' bgAngle='360' showBorder='1' startingAngle='70'>" . $cadgrafdatospie . "</chart>\");
				chartpie.render(\"chartdivpie\");
				</script>";

				echo $cadgrafbarras . $cadgrafpie;
			}
		}
	}

	public function reaperturarcajaAction() {
		$this->_helper->layout->disableLayout();
		$func = new Libreria_Pintar();
		$evt [] = array("btnaperturar", "click", "aperturarcaja('2');");
		$evt [] = array("btncerrar", "click", "cerrarsubvent();");
		$func->PintarEvento($evt);
	}

	public function aperturarAction() {
		echo "<br/>";
		echo "<b style='font-size: 115%;'>" . $this->_request->getParam('mensaje') . "</b>";
	}

}