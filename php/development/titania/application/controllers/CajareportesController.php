<?php
require_once 'Zend/Controller/Action.php';

class CajareportesController extends Zend_Controller_Action {

	public function init() {
		$this->view->util()->registerScriptJSController($this->getRequest());
		$this->view->util()->registerLeaveControllerAction($this->getRequest());
	}
	    
	public function indexAction() {
        
        $ddatosuserlog = new Zend_Session_Namespace('datosuserlog');			
		$codcajero = $ddatosuserlog->codcajero;
        
        $func = new Libreria_Pintar ();

        if ($codcajero > 0) {
           
            $nombrestore = '"public"."pxcobrowww"';
			$arraydatos [0] = '1';
			$arraydatos [1] = '';
			$arraydatos [2] = '';
			$cn = new Model_DataAdapter();
			$datosfecha = $cn->ejec_store_procedura_sql( $nombrestore, $arraydatos );
				
            for ($i = 1; $i < 32; $i++) {
                if (str_pad($i, 2, "0", STR_PAD_LEFT) == substr($datosfecha [0] [0], 8, 2)) {
                    $defd = $i - 1;
                }
                $dias [$i - 1] = array(str_pad($i, 2, "0", STR_PAD_LEFT), str_pad($i, 2, "0", STR_PAD_LEFT));
            }

            for ($i = 1; $i < 13; $i++) {
                if (str_pad($i, 2, "0", STR_PAD_LEFT) == substr($datosfecha [0] [0], 5, 2)) {
                    $defm = $i - 1;
                }
                $meses [$i - 1] = array(str_pad($i, 2, "0", STR_PAD_LEFT), str_pad($i, 2, "0", STR_PAD_LEFT));
            }
            $ind = 0;
            for ($i = 2005; $i < 2013; $i++) {
                if (str_pad($i, 4, "0", STR_PAD_LEFT) == substr($datosfecha [0] [0], 0, 4)) {
                    $defa = $ind;
                }
                $anios [$ind] = array(str_pad($i, 4, "0", STR_PAD_LEFT), str_pad($i, 4, "0", STR_PAD_LEFT));
                $ind++;
            }

//          $nombrestore = 'tesoreria.obtener_formaspago';
//			$arraydatosfp [0] = '';
//			$cn = new Model_DataAdapter ();
//			$datoscbtipopago = $cn->ejec_store_procedura_sql ( $nombrestore, $arraydatosfp );
            
            $datoscbtipopago[] = array('', 'TODAS');

            $val [0] = array("rptdia", $func->ContenidoCombo($dias, $dias [$defd] [0]), "html");
            $val [1] = array("rptmes", $func->ContenidoCombo($meses, $meses [$defm] [0]), "html");
            $val [2] = array("rptanio", $func->ContenidoCombo($anios, $anios [$defa] [0]), "html");
            $val [3] = array("txtcodcajero", $codcajero, "val");
            $val [4] = array('cbtipopago', $func->ContenidoCombo($datoscbtipopago, ''), 'html');
            $func->PintarValor($val);

            $evt [0] = array("genreport", "click", "GenerarRepoteCaja();");
            $func->PintarEvento($evt);
        } else {
            $val[0] = array("showing", "No tienes privilegios de cajero para este modulo", "html");
            $func->PintarValor($val);
            // Echo 'No tienes privilegios de cajero para este modulo.';
        }
    }

    public function indextesoreroAction() {
        $dcodcajero = new Zend_Session_Namespace('codcajero');
        $codcajero = $dcodcajero->data;

        //if($codcajero>0){
        $nombrestore = '"public"."pxcobrowww"';
			$arraydatos [0] = '1';
			$arraydatos [1] = '';
			$arraydatos [2] = '';
			$cn = new Model_DataAdapter();
			$datosfecha = $cn->ejec_store_procedura_sql( $nombrestore, $arraydatos );


        $func = new Libreria_Pintar();

        for ($i = 1; $i < 32; $i++) {
            if (str_pad($i, 2, "0", STR_PAD_LEFT) == substr($datosfecha[0][0], 8, 2)) {
                $defd = $i - 1;
            }
            $dias[$i - 1] = array(str_pad($i, 2, "0", STR_PAD_LEFT), str_pad($i, 2, "0", STR_PAD_LEFT));
        }

        for ($i = 1; $i < 13; $i++) {
            if (str_pad($i, 2, "0", STR_PAD_LEFT) == substr($datosfecha[0][0], 5, 2)) {
                $defm = $i - 1;
            }
            $meses[$i - 1] = array(str_pad($i, 2, "0", STR_PAD_LEFT), str_pad($i, 2, "0", STR_PAD_LEFT));
        }
        $ind = 0;
        for ($i = 2005; $i < 2013; $i++) {
            if (str_pad($i, 4, "0", STR_PAD_LEFT) == substr($datosfecha[0][0], 0, 4)) {
                $defa = $ind;
            }
            $anios[$ind] = array(str_pad($i, 4, "0", STR_PAD_LEFT), str_pad($i, 4, "0", STR_PAD_LEFT));
            $ind++;
        }

//          $nombrestore = 'tesoreria.obtener_formaspago';
//			$arraydatosfp [0] = '';
//			$cn = new Model_DataAdapter ();
//			$datoscbtipopago = $cn->ejec_store_procedura_sql ( $nombrestore, $arraydatosfp );

        $datoscbtipopago[] = array('', 'TODAS');


        $val[0] = array("rptdia", $func->ContenidoCombo($dias, $dias[$defd][0]), "html");
        $val[1] = array("rptmes", $func->ContenidoCombo($meses, $meses[$defm][0]), "html");
        $val[2] = array("rptanio", $func->ContenidoCombo($anios, $anios[$defa][0]), "html");
        $val[3] = array("rptdiaf", $func->ContenidoCombo($dias, $dias[$defd][0]), "html");
        $val[4] = array("rptmesf", $func->ContenidoCombo($meses, $meses[$defm][0]), "html");
        $val[5] = array("rptaniof", $func->ContenidoCombo($anios, $anios[$defa][0]), "html");
        $val[6] = array('cbtipopago', $func->ContenidoCombo($datoscbtipopago, ''), 'html');
        $func->PintarValor($val);

        $evt[0] = array("txtcodcajero", "keypress", "return validarnumeros(event);");
        $evt[1] = array("genrecibo", "click", "GenerarRepoteCaja();");
        $func->PintarEvento($evt);

        // $hab[0] = array('genrecibo',false);
        // $func->HabilitarComponente($hab);
        // }else{
        //	echo 'No tienes privilegios de cajero para este modulo.';
        // }
    }

    
    public function imprimirptAction() {
        $this->_helper->viewRenderer->setNoRender();
        $this->_helper->layout->disableLayout();

        $urlreport = $this->view->util()->getPathReport();

        $nomreport = $this->_request->getParam('nomreport', '');
        $codcajero = $this->_request->getParam('codcajero', '');
        $fecha = $this->_request->getParam('fecha', '');
        $fechaf = $this->_request->getParam('fechaf', '');
        $tipo = $this->_request->getParam('tipo', '');
        $paramextra = $this->_request->getParam('paramextra', '');
        if ($fechaf == '') {
            $fechaf = $fecha;
        }

        $duserlogin = new Zend_Session_Namespace('userlogin');
        $userlogin = $duserlogin->data;

        $nombrestore = '"public"."pxcobrowww"';
		$arraydatos [0] = '1';
		$arraydatos [1] = '';
		$arraydatos [2] = '';
		$cn = new Model_DataAdapter();
		$datosfecha = $cn->ejec_store_procedura_sql( $nombrestore, $arraydatos );

		//cambiar
        $nombrestore = '"public"."pxcobrowww"';
		$arraydatos [0] = '1';
		$arraydatos [1] = '';
		$arraydatos [2] = '';
		$cn = new Model_DataAdapter();
		$datosfechafull = $cn->ejec_store_procedura_sql( $nombrestore, $arraydatos );

        $url = $urlreport . 'tipo=' . $tipo . '&reporte=' . $nomreport . '&opt=P_NROCAJA^' . $codcajero . '|P_FECHAREPORT^' . $datosfechafull[0][0] . '|P_FECHADESDE^' . $fecha . '|P_FECHAHASTA^' . $fechaf . '|P_HORASERVER^' . $datosfecha[0][0] . '|P_USERIMPR^' . $userlogin . '|' . $paramextra;

        $arraybuscar = array('á', 'é', 'í', 'ó', 'ú', '&aacute;', '&eacute;', '&iacute;', '&oacute;', '&uacute;');
        $arraycambiar = array('a', 'e', 'i', 'o', 'u', 'a', 'e', 'i', 'o', 'u');

        $url = str_replace($arraybuscar, $arraycambiar, $url);

        echo '<script type="javascript">window.open("' . $url . '", "_self")</script>';
    }

}

