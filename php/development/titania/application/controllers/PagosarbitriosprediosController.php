<?php
require_once 'Zend/Controller/Action.php';

class PagosarbitriosprediosController extends Zend_Controller_Action {
	
	public function init() {
		$this->view->util()->registerScriptJSController($this->getRequest());
	}
		
	public function cobrarpago($cad,$efectivo){
		
		$func = new Libreria_Pintar();
    		$url = $this->view->util()->getPath();
			
    		//obtenemos el codigo del cajero 
    		$ddatosuserlog = new Zend_Session_Namespace('datosuserlog');
			$cidpers = $ddatosuserlog->cidpers;
			$codcajero = $ddatosuserlog->codcajero;
			$userlogin = $ddatosuserlog->userlogin;
			
			$cidapertura=$ddatosuserlog->cidapertura;
			
			
			//convertimos la cadena en un array
			$dat = explode( "~", $cad );
			$arraydatos = null;
			for($i = 0; $i < count ( $dat ); $i ++) {
				$datos = explode ( "@", $dat [$i] );            
				$cad = trim ( $datos [0] );
				$codpre = trim ( $datos [1] );
				$tributo = trim ( $datos [2] );
				$anio = trim ( $datos [3] );
				$total = trim ( $datos [4] );
				
				if ($arraydatos == '' || $arraydatos == null || count ( $arraydatos ) == 0) {
					$arraydatos [0] [0] = $cad; //cadena
					$arraydatos [0] [1] = $codpre; //predio
					$arraydatos [0] [2] = $tributo; //tributo
					$arraydatos [0] [3] = $anio; //anio
					$arraydatos [0] [4] = $total; //total
				} else {
					$b = '99999'; //contador de posicion de $arraydatos
					for($k = 0; $k < count ( $arraydatos ); $k ++) {
						if ($arraydatos[$k][1] === $codpre && $arraydatos[$k][2] === $tributo && $arraydatos[$k][3] === $anio) {
							$b = $k;
							break;
						} else {
							$b = '99999';
						}
					}
					if ($b <> '99999') {
						$arraydatos [$b] [0] .= '~' . $cad;
						$arraydatos [$b] [4] = $arraydatos [$b] [4] + $total;
					} else {
						$c = count ( $arraydatos );
						$arraydatos [$c] [0] = $cad; //cadena
						$arraydatos [$c] [1] = $codpre; //predio
						$arraydatos [$c] [2] = $tributo; //tributo
						$arraydatos [$c] [3] = $anio; //anio
						$arraydatos [$c] [4] = $total; //total
					}
				
				}
			}
			$cadrecibos = '';
			$contarecibos = 0;
			
			$arraydatos = $func->ordenar_array($arraydatos, '3', SORT_ASC ); // ordenar el array resultante por el anio y esta de manera ascendente...
			
			$correlativorecibos = 0;
			$nuevacadgrab = '';
			for($i=0;$i < count ( $arraydatos ); $i++) {
			//echo '---------------->'.$efectivo .' ->'. $arraydatos[$i][4].'<br><br>';
				if(number_format ($arraydatos[$i][4], '2', '.', '' ) != 0.00) {					
					if(number_format ($efectivo, '2', '.', '' ) >= number_format ($arraydatos[$i][4], '2', '.', '' )){
							$datoscad = explode ( "~", $arraydatos[$i][0] );
							//$nuevacadgrab = '<d>';
								for($j=0;$j<count($datoscad);$j++){
									$datossubcad = explode ( "^", $datoscad[$j] );
//										$nuevacadgrab .= '<r Id="" cnumcom="'.$correlativorecibos.'" ';
//										$nuevacadgrab .= 'cidecta="'.$datossubcad [0] .'" '; //idsigma de estcta//0
//										$nuevacadgrab .= 'ctiprec="'.$datossubcad [1] . '" '; //ctiprec//1
//										$nuevacadgrab .= 'ninsolu="'.number_format ( $datossubcad [2], '2', '.', '' ) . '" '; //imp. insoluto//2
//										$nuevacadgrab .= 'nfacrea="'.number_format ( $datossubcad [3], '2', '.', '' ) . '" '; //factor de reajuste//3
//										$nuevacadgrab .= 'nimprea="'.number_format ( $datossubcad [4], '2', '.', '' ) . '" '; //imp. reajuste//4
//										$nuevacadgrab .= 'nfacmor="'.number_format ( $datossubcad [5], '2', '.', '' ) . '" '; //fact. mora//5
//										$nuevacadgrab .= 'nimpmor="'.number_format ( $datossubcad [6], '2', '.', '' ) . '" '; //imp. mora//6
//										$nuevacadgrab .= 'ncosemi="'.number_format ( $datossubcad [7], '2', '.', '' ) . '" '; //costo de emision//7
//										$nuevacadgrab .= 'nmontot="'.number_format ( $datossubcad [8], '2', '.', '' ) . '" '; // total//8
//										$nuevacadgrab .= 'dfecpag="'.$datossubcad [9] . '" '; //9
//										$nuevacadgrab .= 'vobserv="'.$datossubcad [10] . '" '; //10
//										$nuevacadgrab .= 'nestado="'.$datossubcad [11] . '" '; // estado//11
//										$nuevacadgrab .= 'vusernm="'.$datossubcad [12] . '" ';
//										$nuevacadgrab .= 'moraacum="0" ></r>';
										
										$nuevacadgrab .= '|';
										$nuevacadgrab .= $correlativorecibos.'|';
										$nuevacadgrab .= $datossubcad [0] .'|'; //idsigma de estcta//0
										$nuevacadgrab .= $datossubcad [1] .'|'; //ctiprec//1
										$nuevacadgrab .= number_format ( $datossubcad [2], '2', '.', '' ) .'|'; //imp. insoluto//2
										$nuevacadgrab .= number_format ( $datossubcad [3], '2', '.', '' ) .'|'; //factor de reajuste//3
										$nuevacadgrab .= number_format ( $datossubcad [4], '2', '.', '' ) .'|'; //imp. reajuste//4
										$nuevacadgrab .= number_format ( $datossubcad [5], '2', '.', '' ) .'|'; //fact. mora//5
										$nuevacadgrab .= number_format ( $datossubcad [6], '2', '.', '' ) .'|'; //imp. mora//6
										$nuevacadgrab .= number_format ( $datossubcad [7], '2', '.', '' ) .'|'; //costo de emision//7
										$nuevacadgrab .= number_format ( $datossubcad [8], '2', '.', '' ) .'|'; // total//8
										$nuevacadgrab .= $datossubcad [9] .'|'; //9
										$nuevacadgrab .= $datossubcad [10] .'|'; //10
										$nuevacadgrab .= $datossubcad [11] .'|'; // estado//11
										$nuevacadgrab .= $datossubcad [12] .'|';
										$nuevacadgrab .= '0^';
								}
								$efectivo = number_format ($efectivo  - $arraydatos[$i][4], '2', '.', '' );
					}else{
						$datoscad = explode ( "~", $arraydatos[$i][0] );
						//$nuevacadgrab = '<d>';
							for($j=0;$j<count($datoscad);$j++){
								$datossubcad = explode ( "^", $datoscad[$j] );
								$montoxsubcad = $datossubcad[8];
								$nttal = 0;
									if($efectivo>=$montoxsubcad){
										$nuevacadgrab .= '|';
										$nuevacadgrab .= $correlativorecibos.'|';
										$nuevacadgrab .= $datossubcad [0] .'|'; //idsigma de estcta//0
										$nuevacadgrab .= $datossubcad [1] .'|'; //ctiprec//1
										$nuevacadgrab .= number_format ( $datossubcad [2], '2', '.', '' ) .'|'; //imp. insoluto//2
										$nuevacadgrab .= number_format ( $datossubcad [3], '2', '.', '' ) .'|'; //factor de reajuste//3
										$nuevacadgrab .= number_format ( $datossubcad [4], '2', '.', '' ) .'|'; //imp. reajuste//4
										$nuevacadgrab .= number_format ( $datossubcad [5], '2', '.', '' ) .'|'; //fact. mora//5
										$nuevacadgrab .= number_format ( $datossubcad [6], '2', '.', '' ) .'|'; //imp. mora//6
										$nuevacadgrab .= number_format ( $datossubcad [7], '2', '.', '' ) .'|'; //costo de emision//7
										$nuevacadgrab .= number_format ( $datossubcad [8], '2', '.', '' ) .'|'; // total//8
										$nuevacadgrab .= $datossubcad [9] .'|'; //9
										$nuevacadgrab .= $datossubcad [10] .'|'; //10
										$nuevacadgrab .= $datossubcad [11] .'|'; // estado//11
										$nuevacadgrab .= $datossubcad [12] .'|';
										$nuevacadgrab .= '0^';
										
										$efectivo = number_format ($efectivo - $montoxsubcad, '2', '.', '' );
									}else{
										//if($efectivo>0){
											$porcinso = number_format( ($datossubcad[2] / $montoxsubcad )  , '8', '.', '' );
											$porcreaj = number_format( (($datossubcad[4] - $datossubcad[2]) / $montoxsubcad ) , '8', '.', '' ) ;
											$porcmora = number_format( ($datossubcad[6] / $montoxsubcad )  , '8', '.', '' );
											$porcgast = number_format( ($datossubcad[7] / $montoxsubcad )  , '8', '.', '' );
											$ninso = number_format( ($efectivo * $porcinso) , '2', '.', '' );
											$nreaj = number_format( ($efectivo * $porcreaj) , '2', '.', '' );
											$nmora = number_format( ($efectivo * $porcmora) , '2', '.', '' );
											$ngast = number_format( ($efectivo * $porcgast) , '2', '.', '' );

											$moraacum = number_format( ($datossubcad[6] - $nmora) , '2', '.', '' ) ;

											$subtotal = $ninso + $nreaj + $nmora + $ngast;	

											//$nttal = $nttal + $subtotal;
											
											//ajuste
											if($subtotal != $efectivo){
												$diff = $efectivo - $subtotal;
												$nmora = $nmora + $diff;
												$subtotal = $ninso + $nreaj + $nmora + $ngast;
											}
											$nuevacadgrab .= '|'.$correlativorecibos.'|';
											$nuevacadgrab .= $datossubcad [0] . '|'; //idsigma de estcta//0
											$nuevacadgrab .= $datossubcad [1] . '|'; //ctiprec//1
											$nuevacadgrab .= number_format ( $ninso, '2', '.', '' ). '|'; //imp. insoluto//2
											$nuevacadgrab .= number_format ( $datossubcad [3], '2', '.', '' ) . '|'; //factor de reajuste//3
											$nuevacadgrab .= number_format ( ($nreaj+$ninso), '2', '.', '' ) . '|'; //imp. reajuste//4
											$nuevacadgrab .= number_format ( $datossubcad [5], '2', '.', '' ) . '|'; //fact. mora//5
											$nuevacadgrab .= number_format ( $nmora, '2', '.', '' ).'|'; //imp. mora//6
											$nuevacadgrab .= number_format ( $ngast, '2', '.', '' ).'|'; //costo de emision//7
											$nuevacadgrab .= number_format ( $subtotal, '2', '.', '' ).'|'; // total//8
											$nuevacadgrab .= $datossubcad [9] . '|'; //9
											$nuevacadgrab .= $datossubcad [10] . '|'; //10
											$nuevacadgrab .= 'I'. '|'; // estado//11
											$nuevacadgrab .= $datossubcad [12] .'|';
											$nuevacadgrab .= number_format ( $moraacum, '2', '.', '' ).'^'; 
											
											$efectivo = number_format( ($efectivo - $subtotal) , '2', '.', '' );
									}
							}
	
					}
					$correlativorecibos++;
				}
			}

			
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
					$xmldetallepago .= $detallepago[$i][0].'|'.number_format ($detallepago[$i][3], '2', '.', '' ).'|'.$detallepago[$i][1].'|'.$detallepago[$i][2].'^';
				}
				
			$nuevacadgrab   = substr ( $nuevacadgrab  , 0, strlen ( $nuevacadgrab   ) - 1 );
			$xmldetallepago = substr ( $xmldetallepago, 0, strlen ( $xmldetallepago ) - 1 );
			
			//echo "<textarea>".$nuevacadgrab."</textarea>";
			//echo "<textarea>".$xmldetallepago."</textarea>";
			
			$dcidpers = new Zend_Session_Namespace ( 'cidpers' );
			$cidpers =  $dcidpers->data ;
			
			
	
			
			$nombrestore = 'tesoreria.cobrar_arbitriospredios';
			$arrayd[0] = $cidpers ;
			$arrayd[1] = $nuevacadgrab ;
			$arrayd[2] = $xmldetallepago ;
			$arrayd[3] = '^' ;
			$arrayd[4] = '|' ;
			$arrayd[5] = $codcajero;#$userlogin ;
			$arrayd[6] = $cidapertura;
			//echo $nuevacadgrab.'<br><br><br>';
			
			$cn = new Model_DataAdapter ();
			$respd = $cn->ejec_store_procedura_sql ( $nombrestore, $arrayd );
			
			//echo "<textarea>".$nuevacadgrab.$xmldetallepago."</textarea>";
			//echo 'tfp->'.$xmldetallepago;

			for($i= 0; $i < count($respd) ; $i++ ){
				echo 'Se genero el recibo nro. <b>' . str_pad ( $respd[$i][0], 12,"0", STR_PAD_LEFT ) . '</b><br />';
				//print_r($respd);
			}
			
			echo '<script language=\'javascript\'>';
			for($i=0;$i<count($respd);$i++){
				echo 'window.open(\''.$url.'index.php/pagosarbitriospredios/imprimirrecibopagosarbitriospredios/?nrorecibo=' . str_pad ( $respd[$i][0], 12,"0", STR_PAD_LEFT ) . '\',"_blank","width=570, height=500, scrollbars=no, menubar=no, location=no, resizable=no,status =no,directories=no"); ';
			}
			echo 'function ventanaSecundaria(){ ';
			for($i=0;$i<count($respd);$i++){
				echo 'ventana=window.open(\''.$url.'index.php/pagosarbitriospredios/imprimirrecibopagosarbitriospredios/?nrorecibo=' . str_pad ( $respd[$i][0], 12,"0", STR_PAD_LEFT ). '\',"_blank","width=570, height=500, scrollbars=no, menubar=no, location=no, resizable=no,status =no,directories=no");ventana.focus();';
			}
			echo '}
				</script>
				<input type="button" name="imprimir" id="imprimir" value="Imprimir recibo" onClick="ventanaSecundaria()" />
				<br />
				<br />';
	}
	
	public function indexAction() {

		$surl = new Zend_Session_Namespace ( 'url' );
		$url = $this->view->util()->getPath();
		
		$ddatosuserlog = new Zend_Session_Namespace('datosuserlog');
		$codcajero = $ddatosuserlog->codcajero;	
		
		$titordenanza = null;
		$do = '';
		$cont = null;
		
		$func = new Libreria_Pintar();
		if ($codcajero > 0) {
			$dcadgrabacion = new Zend_Session_Namespace('cadgrabacion' );
			$dcadgrabacion->data = '';
			
			$dorden = $this->_request->getParam ( 'ord', '' );
			//echo '<script>alert("'.$dorden.'")</script>';
			//$dordenanza = new Zend_Session_Namespace('ordenanza');
			
			$datospers = $this->_request->getParam ( 'datospers', '' );
			if ($datospers == '') {
				//$dordenanza->data = '';
				header ( 'location:' . $url . 'index.php/busqpers/?tit=Pagos de Arbitrios y Predios&url=' . $url . 'index.php/pagosarbitriospredios/?datospers=', true );
			} else {
				
				$ddetallepago = new Zend_Session_Namespace ( 'detallepago' );
				$ddetallepago->data = '';
				
				#cadena de conceptos de pagos arbitrios predios
				$data = new Zend_Session_Namespace ( 'arrayconceptos' );
				$data->data = '';
				
				//$ordenanza = $dordenanza->data;
				
				list ( $cidpers, $nompers, $dir , $fechaproyeccion ) = explode ( '|', $datospers );
				
				if ($cidpers == '_________1') {
					echo '<br><br>Solo se aceptan contribuyentes registrados en el sistema.';
				} else {
					$dcidpers = new Zend_Session_Namespace ( 'cidpers' );
					$dcidpers->data = $cidpers;
					
					$dnompers = new Zend_Session_Namespace ( 'nompers' );
					$dnompers->data = $nompers;
					
					if($fechaproyeccion == '' ){
						$nombrestore = '"public"."pxcobrowww"';
						$arraydatos [0] = '1';
						$arraydatos [1] = '';
						$arraydatos [2] = '';
						$cn = new Model_DataAdapter ();
						$datosfecha = $cn->ejec_store_procedura_sql ( $nombrestore, $arraydatos );
						$dfecha = explode ( " ", $datosfecha [0] [0] );
						$fechaproyeccion = $dfecha[0]; 
					}					
					
//					$nombrestore = 'dbo.pxCobroWWW';
//					$arraydatos [0] = array ('@idquery', '2' );
//					$arraydatos [1] = array ('@paramt0', $cidpers );
//					$cn = new Model_DataAdapter ();
//					$datoscontribuyentes = $cn->ejec_store_procedura_sql ( $nombrestore, $arraydatos );


					$nombrestore = 'tesoreria.fx_Estadocuenta';
					$arraydatos [0] = $cidpers ;
					$arraydatos [1] = '%' ;
					$arraydatos [2] = '0' ;
					$arraydatos [3] = $fechaproyeccion ;
					$arraydatos [4] = '0';
					$arraydatos [5] = '0';
					$arraydatos [6] = '%';
					
					$cn = new Model_DataAdapter ();
					$datos = $cn->ejec_store_procedura_sql ( $nombrestore, $arraydatos );
					
					$arrayprediosprinc = '';
					$arrayprediohijo = '';
					
					$arrayarbitriosprinc = '';
					$arrayarbitrioshijo = '';
					//$arrayarbitrioshijoaï¿½os = '';
					$arrayarbitrioshijosub = '';
					
					$arrayfraccprinc = '';
					$arrayfracchijo = '';

					$arraypagvariosprinc = '';
					$arraypagvarioshijo = '';

					$btnordparams = false;
					
					if (count ( $datos ) > 0) {
						
						for($i = 0; $i < count ( $datos ); $i ++) {
							
							$text = $datos [$i] [3];
							$id = $datos [$i] [0];
							$depth = $datos [$i] [23] + 1; // si es 2 es el padre y si es 3 es el hijo (ya se le ta sumando 1)
							$leaf = '';
							$checked = false;
							$children = '';
							
							$ctiping = $datos [$i] [1];
							$ctiprecval = $datos [$i] [2];
							$codpredio = ($datos [$i] [4] == '' ? 'No Especificado ' : $datos [$i] [4]);
							$anio = $datos [$i] [5];
							$perid = trim ( $datos [$i] [6] );
							
							$nroval = $datos[$i][43].$datos[$i][44];
							
							$estad = $datos [$i] [7];
							
							$descripctiping = (($datos[$i][24] == '')?'No Especificado':$datos[$i][24]);# $datos[$i][24] es nulo U.u
							
							if ($dorden == '' || $dorden == null) {
								$idhijos = 'R' . '|'; //identificador q es un registro de cobro
								$idhijos .= $datos [$i] [0] . '|'; //idsigma de estcta 
								$idhijos .= $datos [$i] [2] . '|'; //ctiprec
								$idhijos .= $datos [$i] [3] . '|'; //tributo
								$idhijos .= (trim ( $datos [$i] [5] ) == '' ? '0000' : $datos [$i] [5]) . '|'; //aï¿½o
								$idhijos .= $datos [$i] [6] . '|'; //periodo
								$idhijos .= '-' . '|'; //dir
								//$idhijos .= $datos [$i] [21] . ' ' . $datos [$i] [22] . ' ' . $datos [$i] [20] . '|'; //direccion predio
								$idhijos .= $datos [$i] [8] . '|'; //imp. insoluto
								$idhijos .= $datos [$i] [9] . '|'; //factor de reajuste
								$idhijos .= $datos [$i] [10] . '|'; //imp. reajuste
								$idhijos .= $datos [$i] [11] . '|'; //fact. mora
								$idhijos .= $datos [$i] [12] . '|'; //imp. mora 
								$idhijos .= $datos [$i] [13] . '|'; //costo de emision
								$idhijos .= $datos [$i] [17] . '|'; // total
								$idhijos .= $datos [$i] [7] . '|'; // estado
								$idhijos .= (trim ( $datos [$i] [4] ) == '' ? '0000000000' : $datos [$i] [4]) . '|'; // codpredio
								$idhijos .= $datos [$i] [1]; // ctiping	
								$btnordparams = true;
							}
							if ($dorden == 'OK') { #ordenanza
								$idhijos = 'R' . '|'; //identificador q es un registro de cobro
								$idhijos .= $datos [$i] [0] . '|'; //idsigma de estcta 
								$idhijos .= $datos [$i] [2] . '|'; //ctiprec
								$idhijos .= $datos [$i] [3] . '|'; //tributo
								$idhijos .= (trim ( $datos [$i] [5] ) == '' ? '0000' : $datos [$i] [5]) . '|'; //aï¿½o
								$idhijos .= $datos [$i] [6] . '|'; //periodo
								$idhijos .= '-' . '|'; //dir
								//$idhijos .= $datos [$i] [21] . ' ' . $datos [$i] [22] . ' ' . $datos [$i] [20] . '|'; //direccion predio
								$idhijos .= $datos [$i] [8] . '|'; //imp. insoluto
								$idhijos .= $datos [$i] [9] . '|'; //factor de reajuste
								$idhijos .= $datos [$i] [14] . '|'; //imp. reajuste
								$idhijos .= $datos [$i] [11] . '|'; //fact. mora
								$idhijos .= $datos [$i] [15] . '|'; //imp. mora 
								$idhijos .= $datos [$i] [16] . '|'; //costo de emision
								$idhijos .= $datos [$i] [18] . '|'; // total
								$idhijos .= $datos [$i] [7] . '|'; // estado
								$idhijos .= (trim ( $datos [$i] [4] ) == '' ? '0000000000' : $datos [$i] [4]) . '|'; // codpredio
								$idhijos .= $datos [$i] [1]; // ctiping
								$btnordparams = false;
							}
							
							//predios padres
							if ($ctiprecval == '0000000273' && $depth == '2') {
								if ($arrayprediosprinc == '') {
									$arrayprediosprinc [0] = array ('text' => $text, 'id' => $id, 'depth' => $depth, 'leaf' => false, 'checked' => false, 'children' => '', 'enlace' => $ctiping . $anio . $codpredio, 'canthijos' => 0 );
								} else {
										//$cc = 99999;
										//for($z = 0 ; $z<count($arrayprediosprinc) ; $z++){
										//	if($arrayprediosprinc[$z]['enlace'] != $ctiping . $anio . $codpredio){
											 $conta = count ( $arrayprediosprinc );
											 $arrayprediosprinc [$conta] = array ('text' => $text, 'id' => $id, 'depth' => $depth, 'leaf' => false, 'checked' => false, 'children' => '', 'enlace' => $ctiping . $anio . $codpredio, 'canthijos' => 0 );	
										//	}
										//}
									
								}
							}
							//predios hijos
							if ($ctiprecval == '0000000273' && $depth == '3') { 
								for($j = 0; $j < count ( $arrayprediosprinc ); $j ++) {
									if ($arrayprediosprinc [$j] ['enlace'] == $ctiping . $anio . $codpredio ) {
										$arrayprediohijo [$arrayprediosprinc [$j] ['id']] [$arrayprediosprinc [$j] ['canthijos']] = array ('text' => $text . ' ' . $anio . ' ' . $perid, 'id' => $idhijos, 'depth' => $depth, 'leaf' => true, 'checked' => false  , 'children' => '', 'enlace' => $ctiping . $anio . $perid, 'canthijos' => 0 );
										$arrayprediosprinc [$j] ['children'] = $arrayprediohijo [$arrayprediosprinc [$j] ['id']];
										$arrayprediosprinc [$j] ['canthijos'] = $arrayprediosprinc [$j] ['canthijos'] + 1;
									}
								}
							}
							
							//arbitrios x predios
							if ($ctiprecval == '0000000278' && $depth == '2' && $perid == '') {
								if ($arrayarbitriosprinc == '') {
									$arrayarbitriosprinc [0] = array ('text' => $codpredio, 'id' => $id . $ctiping . $codpredio, 'depth' => $depth, 'leaf' => false, 'checked' => false, 'children' => '', 'enlace' => $ctiping . $codpredio, 'canthijos' => 0 );
									;
								} else {
									$ccont = count ( $arrayarbitriosprinc );
									$b = false;
									for($j = 0; $j < $ccont; $j ++) {
										if ($arrayarbitriosprinc [$j] ['enlace'] == $ctiping . $codpredio) {
											$b = true;
										}
									}
									if ($b == false) {
										$arrayarbitriosprinc [$ccont] = array ('text' => $codpredio, 'id' => $id . $ctiping . $codpredio, 'depth' => $depth, 'leaf' => false, 'checked' => false, 'children' => '', 'enlace' => $ctiping . $codpredio, 'canthijos' => 0 );
									}
								}
							}
							
							//arbitrios x anios por predios
							if ($ctiprecval == '0000000278' && $depth == '2' && $perid == '') {
								for($j = 0; $j < count ( $arrayarbitriosprinc ); $j ++) {
									if ($arrayarbitriosprinc [$j] ['enlace'] == $ctiping . $codpredio) {
										$arrayarbitrioshijo [$arrayarbitriosprinc [$j] ['id']] [$arrayarbitriosprinc [$j] ['canthijos']] = array ('text' => $text, 'id' => $id . $ctiping . $codpredio . $anio, 'depth' => $depth + 1, 'leaf' => false, 'checked' => false, 'children' => '', 'enlace' => $ctiping . $codpredio . $anio, 'canthijos' => 0 );
										$arrayarbitriosprinc [$j] ['children'] = $arrayarbitrioshijo [$arrayarbitriosprinc [$j] ['id']];
										$arrayarbitriosprinc [$j] ['canthijos'] = $arrayarbitriosprinc [$j] ['canthijos'] + 1;
									}
								}
							}
							
							//arbitrios hijos
							if ($ctiping == '0000000278' && $depth == '3') {
								for($j = 0; $j < count ( $arrayarbitriosprinc ); $j ++) {
									for($k = 0; $k < count ( $arrayarbitrioshijo [$arrayarbitriosprinc [$j] ['id']] ); $k ++) {
										if ($arrayarbitrioshijo [$arrayarbitriosprinc [$j] ['id']] [$k] ['enlace'] === $ctiping . $codpredio . $anio) {
											$arrayarbitrioshijosub [$arrayarbitrioshijo [$arrayarbitriosprinc [$j] ['id']] [$k] ['id']] [$arrayarbitrioshijo [$arrayarbitriosprinc [$j] ['id']] [$k] ['canthijos']] = array ('text' => $text . ' ' . $anio . ' ' . $perid, 'id' => $idhijos, 'depth' => $depth + 1, 'leaf' => true, 'checked' => false, 'children' => '', 'enlace' => $codpredio . $anio . $perid, 'canthijos' => 0 );
											$arrayarbitrioshijo [$arrayarbitriosprinc [$j] ['id']] [$k] ['children'] = $arrayarbitrioshijosub [$arrayarbitrioshijo [$arrayarbitriosprinc [$j] ['id']] [$k] ['id']];
											$arrayarbitrioshijo [$arrayarbitriosprinc [$j] ['id']] [$k] ['canthijos'] = $arrayarbitrioshijo [$arrayarbitriosprinc [$j] ['id']] [$k] ['canthijos'] + 1;
										}
									}
									for($k = 0; $k < count ( $arrayarbitriosprinc [$j] ['children'] ); $k ++) {
										if ($arrayarbitriosprinc [$j] ['children'] [$k] ['enlace'] === $ctiping . $codpredio . $anio) {
											$arrayarbitrioshijosub [$arrayarbitriosprinc [$j] ['children'] [$k] ['id']] [$arrayarbitriosprinc [$j] ['children'] [$k] ['canthijos']] = array ('text' => $text . ' ' . $anio . ' ' . $perid, 'id' => $idhijos, 'depth' => $depth + 1, 'leaf' => true, 'checked' => false, 'children' => '', 'enlace' => $codpredio . $anio . $perid, 'canthijos' => 0 );
											$arrayarbitriosprinc [$j] ['children'] [$k] ['children'] = $arrayarbitrioshijosub [$arrayarbitriosprinc [$j] ['children'] [$k] ['id']];
											$arrayarbitriosprinc [$j] ['children'] [$k] ['canthijos'] = $arrayarbitriosprinc [$j] ['children'] [$k] ['canthijos'] + 1;
										}
									}
								}
							
							}
							
							//fracc padres
							if ($ctiprecval == '0000000312' && $depth == '2') {
								if ($arrayfraccprinc == '') {
									$arrayfraccprinc [0] = array ('text' => $text, 'id' => $id, 'depth' => $depth, 'leaf' => false, 'checked' => false, 'children' => '', 'enlace' => $ctiprecval . $text . $anio, 'canthijos' => 0 );
								} else {
									$conta = count ( $arrayfraccprinc );
									$arrayfraccprinc [$conta] = array ('text' => $text, 'id' => $id, 'depth' => $depth, 'leaf' => false, 'checked' => false, 'children' => '', 'enlace' => $ctiprecval . $text . $anio, 'canthijos' => 0 );
								}
							}
							//fracc hijos
							if ($ctiprecval == '0000000312' && $depth == '3') {
								for($j = 0; $j < count ( $arrayfraccprinc ); $j ++) {
									if ($arrayfraccprinc [$j] ['enlace'] === $ctiprecval . $text . $anio) {
//											if ($estad  == 'P')
//												$arrayfracchijo [$arrayfraccprinc [$j] ['id']] [$arrayfraccprinc [$j] ['canthijos']] = array ('text' => $text, 'id' => 'P|'.$idhijos, 'depth' => $depth, 'leaf' => true, 'checked' => false,'disabled' => true,'editable' => false,'icon'=>$url.'tree/images/drop-no.gif' , 'children' => '', 'enlace' => $ctiping . $anio . $perid, 'canthijos' => 0 );
//											else
												$arrayfracchijo [$arrayfraccprinc [$j] ['id']] [$arrayfraccprinc [$j] ['canthijos']] = array ('text' => $text, 'id' => $idhijos, 'depth' => $depth, 'leaf' => true, 'checked' => false , 'children' => '', 'enlace' => $ctiping . $anio . $perid, 'canthijos' => 0 );
												
										$arrayfraccprinc [$j] ['children'] = $arrayfracchijo [$arrayfraccprinc [$j] ['id']];
										$arrayfraccprinc [$j] ['canthijos'] = $arrayfraccprinc [$j] ['canthijos'] + 1;
									}
								}
							}
							
							//pagos varios 
									if($ctiping != '0000000273' && $ctiping != '0000000278' && $ctiping != '00000000312' && ($depth == '2' || $depth == '4' )){			
										if($arraypagvariosprinc == ''){
											$arraypagvariosprinc[0] = array('text'=>$descripctiping.' '.$anio,'id'=>$idhijos,'depth'=>$depth,'leaf'=>true,'checked'=>false,'children'=>'','enlace'=>$ctiping.$anio.$perid,'canthijos'=>0);
										}else{
											$conta = count($arraypagvariosprinc);
											$arraypagvariosprinc[$conta] = array('text'=>$descripctiping.' '.$anio,'id'=>$idhijos,'depth'=>$depth,'leaf'=>true,'checked'=>false,'children'=>'','enlace'=>$ctiping.$anio.$perid,'canthijos'=>0);
										}
									}
						
						}
						
						if ($arrayprediosprinc != null) {
							$arraysubroot [0] = array ('text' => 'Predial', 'id' => '0000000273', 'depth' => '1', 'leaf' => false, 'checked' => false, 'children' => '' );
							$arraysubroot [0] ['children'] = $arrayprediosprinc;
						}
						if ($arrayarbitriosprinc != null) {
							$arraysubroot [1] = array ('text' => 'Arbitrios', 'id' => '0000000278', 'depth' => '1', 'leaf' => false, 'checked' => false, 'children' => '' );
							$arraysubroot [1] ['children'] = $arrayarbitriosprinc;
						}
						if ($arrayfraccprinc != '') {
							$arraysubroot [2] = array ('text' => 'Fraccionamiento', 'id' => '0000000312', 'depth' => '1', 'leaf' => false, 'checked' => false, 'children' => '' );
							$arraysubroot [2] ['children'] = $arrayfraccprinc;
						}
						if ($arraypagvariosprinc != '') {
							$arraysubroot [3] = array ('text' => 'Pagos Varios', 'id' => '0000000979', 'depth' => '1', 'leaf' => false, 'checked' => false, 'children' => '' );
							$arraysubroot [3] ['children'] = $arraypagvariosprinc;
						}
						
						$arraysubroot = array_values ( $arraysubroot );
						
						$arrayroot [0] = array ('text' => 'Deuda Pendiente', 'id' => '0000000000', 'depth' => '0', 'leaf' => false, 'checked' => false, 'children' => '' );
						$arrayroot [0] ['children'] = $arraysubroot;
						
						if (strlen ( $dorden ) == 0) {
							$do = 'OK';
							$cadordenanza = 'Aplicar Ordenanza';
							$titordenanza = 'Sin Ordenanza';
						} else {
							$do = '';
							$cadordenanza = 'Quitar Ordenanza';
							$titordenanza = 'Ordenanza Activa';
						}
					
					} // Fin si hay o no deuda 
					
					if (count ( $datos ) > 0 ){	
			
						$cont ='<script type="text/javascript"><!--
										Ext.BLANK_IMAGE_URL = "' . $url . 'css/images/s.gif";
										Ext.EventManager.onDocumentReady(function() {
											tree = new Ext.tree.TreePanel(\'tree-div\',{
												animate:true,
												loader: new Ext.tree.CustomUITreeLoader({baseAttr:{uiProvider: Ext.tree.CheckboxNodeUI}}),
												enableDD:false,
												collapsible : true,
										        animCollapse: true,
												containerScroll: true,
												rootUIProvider: Ext.tree.CheckboxNodeUI,
												selModel:new Ext.tree.CheckNodeMultiSelectionModel(),
												rootVisible:false
											});
											
											tree.on(\'check\', function() {
												//Ext.get(\'cn\').dom.value = this.getChecked().join(\',\');
												//aki va el ajax para llenar los registros!!
												var registros = this.getChecked().join(\'^\');
												pintarregistrospagosarbitriospredios(registros,\'1\',\'http://' . $_SERVER ["HTTP_HOST"] . $_SERVER ['REQUEST_URI'] . '\');
											}, tree);
										
											// set the root node
											root = new Ext.tree.AsyncTreeNode({
														text: \'root\',
														draggable:false,
														id:\'source\',
														uiProvider: Ext.tree.CheckboxNodeUI,
														children: ' . json_encode ( $arrayroot ) . '
												    });
											
											tree.setRootNode(root);
										
											// render the tree
											tree.render();
											root.expand(false, false, function() {
												root.firstChild.expand(false);
												//Ext.get(\'cn\').dom.value = tree.getChecked().join(\',\');
												//ser();
											});
											
											//Ext.get(\'exp\').on(\'click\', function() { tree.expandAll();});
											
											//Ext.get(\'coll\').on(\'click\', function() {tree.collapseAll();});
											
											//Ext.get(\'ser\').on(\'click\', ser);
										});
										
										//ser = function() {
										//	var c = Ext.get(\'c\');
										//	c.dom.style.display=\'block\';
										//	c.dom.firstChild.innerHTML = tree.getChecked();
										//};
										
										//--></script>
										
										<style>
										
										<style>
										//	#c {display:none;} 
										</style>
										
										<!--
										<input type="button" id="ser" value="Serialize Checked Nodes" />
										<br />
										<div id="c"><pre class="code"></pre></div>
										<b>Checked Nodes: </b> <input type="text" id="cn" value="" size="40" autocomplete="off" /><br />
										<br />
										-->';

					}

					if (count($datos) > 0){
						$forma = '<input type="button" id="btnordenanza" name="btnordenanza" value="' . $cadordenanza . '" onclick="" />';
						$tree = '<div id="tree-div" style="overflow:scroll; height:100%;width:230px;border:1px solid #c3daf9;"></div>';
						
					}else{
						$forma = '';
						$tree = '<div style="overflow:scroll; height:100%;width:100%;border:1px solid #c3daf9;"><table height="100%" width="100%"><tr valign="middle"><td align="center"><b>No tiene Deuda Pendiente</b></td></tr></table></div>';
					}
					$botones = '';
					if ($codcajero == '0099'){
						// $botones  = '<input type="button"  id="btnfraccionamiento" name="btnfraccionamiento" value="Fraccionamiento" onclick="ventanafraccionamiento(\\\'http://' . $_SERVER ["HTTP_HOST"] . $_SERVER ['REQUEST_URI'] . '\\\')" />';
						// $botones .= '<input type="button" id="btndescargo" name="btndescargo" value="Descargo de Recibo" onclick="descargoregistrospagosarbitriospredios()" />';
						$botones .= '<input type="button" id="btncobrar" name="btncobrar" value="Cobrar" onclick="cobrarregistrospagosarbitriospredios()" />';				
					} else if ($codcajero == '0050'){
						$botones = '<input type="button" id="btndescargo" name="btndescargo" value="Descargo de Recibo" onclick="descargoregistrospagosarbitriospredios()" />';
					} else {
						$botones = '<input type="button" id="btncobrar" name="btncobrar" value="Cobrar" onclick="cobrarregistrospagosarbitriospredios()" />';
					}
						
					$val[0] = array("cidpers", $cidpers, "html");
					$val[1] = array("nompers", $nompers, "html");
					$val[2] = array("dirpers", $dir, "html");
					$val[3] = array("btnord", $forma, "html");
					if($titordenanza != null) {
						$val[4] = array("isordenanza", '<font size="+1"><b>' . $titordenanza . '<b></font>', "html");
					}
					$val[5] = array("div_rptapagoarbitriospredios", $botones, "html");
					$val[6] = array("txt_fechaproyeccion", $fechaproyeccion, "val");
					$val[7] = array("btord", $tree, "html");
					
					//$val[6] = array("arbol", $scarb, "html");

					//$val[0] = array("arbol", $scarb, "html");
					
					$evt[0] = array("btnrecibos", "click", "ventanarecibosxconribuyente('" . $cidpers . "');");
					$evt[1] = array("btnestcta", "click", "ventanaestctacajero('" . $cidpers . "');");
					$evt[2] = array("btnordenanza", "click", "window.open('" . $url . "index.php/pagosarbitriospredios/?datospers=" . $datospers . "&ord=" . $do . "','_self')");
					$evt[3] = array("btnconvenios", "click", 'ventanaconvenio(\'0\',\'http://' . $_SERVER ['HTTP_HOST'] . $_SERVER ['REQUEST_URI'] .'\');');
					$evt[4] = array('txt_fechaproyeccion', 'click', 'displayCalendar(this,"yyyy-mm-dd" ,this);');					
					$evt[5] = array('btn_recalculardeuda', 'click', "window.open('" . $url . "index.php/pagosarbitriospredios/?datospers=" . $cidpers. "|". $nompers."|". $dir. "|". "'+$('#txt_fechaproyeccion').val()+'" . "&ord=" . $dorden . "','_self')"); //$cidpers, $nompers, $dir , $fechaproyeccion
					
					$sl[0] = array('txt_fechaproyeccion',true);

					$hab[0] = array('btn_recalculardeuda',false);
					//$hab[1] = array('btnordenanza',false);
					
					$func->PintarValor($val);
					$func->PintarEvento($evt);
					$func->ComponenteSoloLectura($sl);
					$func->HabilitarComponente($hab);
					if($cont != null) {
						echo $cont;	
					}
				}
			} //fin del else para los datos enviados
		} else {
			$val[0] = array("arbol", "No tienes privilegios de cajero para este modulo", "html");
			$func->PintarValor($val);
			
			//echo 'No tienes privilegios de cajero para este modulo.';
		} //fin condicion de cajero	
	}
	
	public function pintarregistrosAction() {
		$this->_helper->layout->disableLayout ();
		$this->_helper->getHelper ( 'ajaxContext' )->initContext ();
		
		if ($this->getRequest ()->isXmlHttpRequest ()) {
			//$this->_helper->viewRenderer->setNoRender ();
			$this->_helper->layout->disableLayout ();
			
			#$duserlogin = new Zend_Session_Namespace ( 'userlogin' );
			#$userlogin = $duserlogin->data;
			
			$ddatosuserlog = new Zend_Session_Namespace('datosuserlog');
			$userlogin = $ddatosuserlog->userlogin;
			
			
			$registros = $this->_request->getPost ( 'registros' );
			$url = $this->_request->getPost ( 'url' );
			$ord = $this->_request->getPost ( 'ord' );
			$reajustecentimos = $this->_request->getPost ( 'reajustecentimos' );
			
			
			//echo  $registros;
			
			//0//			$idhijos =  'R'.'|'; //identificador q es un registro de cobro
			//1//*						$idhijos .= $datos[$i][0].'|';  //idsigma de estcta 
			//2//*						$idhijos .=	$datos[$i][2].'|';  //ctiprec
			//3//						$idhijos .=	$datos[$i][3].'|';  //tributo
			//4//*						$idhijos .=	$datos[$i][5].'|';  //aï¿½o
			//5//						$idhijos .=	$datos[$i][6].'|';  //periodo
			//6//						$idhijos .=	$datos[$i][17].' '.$datos[$i][18].' '.$datos[$i][16].'|';  //direccion predio
			//7//*						$idhijos .=	$datos[$i][8].'|';  //imp. insoluto
			//8//*						$idhijos .=	$datos[$i][9].'|';  //factor de reajuste
			//9//*						$idhijos .=	$datos[$i][10].'|'; //imp. reajuste
			//10//*						$idhijos .=	$datos[$i][11].'|'; //fact. mora
			//11//*						$idhijos .=	$datos[$i][12].'|'; //imp. mora 
			//12//*						$idhijos .=	$datos[$i][13].'|'; //costo de emision
			//13//*						$idhijos .=	$datos[$i][14]; // total
			//fecha de pago
			//observaciones
			//14//*						$idhijos .=	$datos[$i][7]; // estado
			//15//*						$idhijos .=	$datos[$i][4]; // codpredio
			//numero de recibo manual
			//16//*						$idhijos .=	$datos[$i][1]; // ctiping
			

			$cadgrabacion = '';
			$cadkiebre = '';
			$buscarestado = array ('0', '3', 'B', 'D', 'F', 'P' );
			$ponercolor = array ('#ffffff', '#6bc5c5', '#ffc270', '#e67053', '#b0cff6', '#6bc5c5' );
			$sumtotal = 0.00;
			$func = new Libreria_Pintar();
			
			$detail = '<table border="0" cellspacing="0" cellpadding="0" style="font-size:12px">';
			
			if (strlen ( $registros ) > 0) {
				$datos = explode ( "^", $registros );
				for($i = 0; $i < count ( $datos ); $i ++) {
					$datoscol = explode ( "|", $datos [$i] );
					if (substr ( $datoscol [0], 0, 1 ) == 'R') {
						//para el total
						$sumtotal = $sumtotal + $datoscol [13];			
						//llenando el cadena de grabacion para la sesion								
						$cadgrab  = $datoscol [1] . '^'; //idsigma de estcta//0
						$cadgrab .= $datoscol [2] . '^'; //ctiprec//1
						$cadgrab .= number_format ( $datoscol [7], '2', '.', '' ) . '^'; //imp. insoluto//2
						$cadgrab .= number_format ( $datoscol [8], '2', '.', '' ) . '^'; //factor de reajuste//3
						$cadgrab .= number_format ( $datoscol [9], '2', '.', '' ) . '^'; //imp. reajuste//4
						$cadgrab .= number_format ( $datoscol [10], '2', '.', '' ) . '^'; //fact. mora//5
						$cadgrab .= number_format ( $datoscol [11], '2', '.', '' ) . '^'; //imp. mora//6
						$cadgrab .= number_format ( $datoscol [12], '2', '.', '' ) . '^'; //costo de emision//7
						$cadgrab .= number_format ( $datoscol [13], '2', '.', '' ) . '^'; // total//8
						$cadgrab .= 'fechpago' . '^'; //9
						$cadgrab .= '/' . '^'; //10
						$cadgrab .= 'estrec' . '^'; // estado//11
						$cadgrab .= $userlogin;

						// Llenando el cadena de kiebre	
						$cadkiebre .= $cadgrab . '@'; //idsigma de estcta//0
						$cadkiebre .= trim ( $datoscol [15] ) == '' ? '0000000000' : $datoscol [15] . '@'; // codpredio//1
						$cadkiebre .= $datoscol [16] . '@'; // ctiping//2
						$cadkiebre .= trim ( $datoscol [4] ) == '' ? '0000' : $datoscol [4] . '@'; // aï¿½o//3	
						$cadkiebre .= number_format ( $datoscol [13], '2', '.', '' ); // total//4		
						$cadkiebre .= '@'.$datoscol [3].'@'.$datoscol [5];						
						$cadkiebre .= '~';
						
						// Para pintar la tabla	
						$detail .= '<tr style="background-color:' . str_replace ( $buscarestado, $ponercolor, $datoscol [14] ) . '" >';
						$detail .= '<td width="45" align="center">' . $datoscol [3] . '</td>';
						$detail .= '<td width="49" align="center">' . $datoscol [4] . '</td>';
						$detail .= '<td width="49" align="center">' . $datoscol [5] . '</td>';
						$detail .= '<td width="61" align="center">' . number_format ( $datoscol [7], '2', '.', '' ) . '</td>';
						$detail .= '<td width="64" align="center">' . number_format ( $datoscol [9], '2', '.', '' ) . '</td>';
						$detail .= '<td width="60" align="center">' . number_format ( $datoscol [11], '2', '.', '' ) . '</td>';
						$detail .= '<td width="61" align="center">' . number_format ( $datoscol [12], '2', '.', '' ) . '</td>';
						$detail .= '<td width="50" align="center">' . number_format ( $datoscol [13], '2', '.', '' ) . '</td>';
						$detail .= '</tr>';
					}
				}
				$cadkiebre = substr ( $cadkiebre, 0, strlen ( $cadkiebre ) - 1 );
			}
			
			/* Aumentar par el kite de los centimos*/
			
			$dcodcajero = new Zend_Session_Namespace ( 'codcajero' );
			$codcajero = $dcodcajero->data;			

			if( $codcajero != '0050'  && $reajustecentimos == '1'  ){
			$dat = null;
			if(strlen($cadkiebre) > 0)
				$dat = explode ( "~", $cadkiebre );
				
			$arraydatos = null;			
			for($i = 0; $i < count ( $dat ); $i ++) {
				$datos = explode ( "@", $dat [$i] );
				$cad = trim ( $datos [0] );
				$codpre = trim ( $datos [1] );
				$tributo = trim ( $datos [2] );
				$anio = trim ( $datos [3] );
				$total = trim ( $datos [4] );
				$trib = trim ( $datos [5] );
				$perid = trim ( $datos [6] );
						
				if ($arraydatos == '' || $arraydatos == null || count ( $arraydatos ) == 0) {
					$arraydatos [0] [0] = $cad; //cadena
					$arraydatos [0] [1] = $codpre; //predio
					$arraydatos [0] [2] = $tributo; //tributo
					$arraydatos [0] [3] = $anio; //año
					$arraydatos [0] [4] = $total; //total
					$arraydatos [0] [5] = $trib; //trib
					$arraydatos [0] [6] = $perid; //perid
				} else {
					$b = null; //contador de posicion de $arraydatos
					for($k = 0; $k < count ( $arraydatos ); $k ++) {
						if ($arraydatos [$k] [1] == $codpre && $arraydatos [$k] [2] == $tributo && $arraydatos [$k] [3] == $anio) {
							$b = $k;
						} else {
							$b = 99999;
						}
					}
					if ($b == 99999) {
						$c = count ( $arraydatos );
						$arraydatos [$c] [0] = $cad; //cadena
						$arraydatos [$c] [1] = $codpre; //predio
						$arraydatos [$c] [2] = $tributo; //tributo
						$arraydatos [$c] [3] = $anio; //aï¿½o
						$arraydatos [$c] [4] = $total; //total
						$arraydatos [$c] [5] = $trib; //total
						$arraydatos [$c] [6] = $perid; //total
					} else {
						$arraydatos [$b] [0] .= '~' . $cad;
						$arraydatos [$b] [4] = $arraydatos [$b] [4] + $total;
					}				
				}
			}
			
			for($i = 0 ; $i <count($arraydatos) ; $i++){
				$total = number_format( $arraydatos[$i][4], '1', '.', '' );
					$subttotaldiff = number_format( $total - $arraydatos[$i][4] , '2', '.', '' );
					//echo "<script>alert('".$total." - ".$arraydatos[$i][4]." = ".$subttotaldiff."');</script>";
					if($subttotaldiff <> 0.00){
						$datoscad = explode ( "~", $arraydatos[$i][0] );
						$max = count($datoscad)-1;
							$datossubcad = explode ( "^", $datoscad[$max] );
								$sumtotal = $sumtotal + $subttotaldiff;			
								//llenando el cadena de grabacion para la sesion								
								$cadgrab  = $datossubcad [0] . '^'; //idsigma de estcta//0
								$cadgrab .= '0000007931' . '^'; //ctiprec//1
								$cadgrab .= number_format ( 0 , '2', '.', '' ) . '^'; //imp. insoluto//2
								$cadgrab .= number_format ( 0 , '2', '.', '' ) . '^'; //factor de reajuste//3
								$cadgrab .= number_format ( 0 , '2', '.', '' ) . '^'; //imp. reajuste//4
								$cadgrab .= number_format ( 1 , '2', '.', '' ) . '^'; //fact. mora//5
								$cadgrab .= number_format ( $subttotaldiff, '2', '.', '' ) . '^'; //imp. mora//6
								$cadgrab .= number_format ( 0 , '2', '.', '' ) . '^'; //costo de emision//7
								$cadgrab .= number_format ( $subttotaldiff, '2', '.', '' ) . '^'; // total//8
								$cadgrab .= 'fechpago' . '^'; //9
								$cadgrab .= '/' . '^'; //10
								$cadgrab .= 'R' . '^'; // estado//11
								$cadgrab .= $userlogin;
		
								// Llenando el cadena de kiebre	
								$cadkiebre .= '~';
								$cadkiebre .= $cadgrab . '@'; //idsigma de estcta//0
								$cadkiebre .= $arraydatos[$i][1] . '@'; // codpredio//1
								$cadkiebre .= $arraydatos[$i][2] . '@'; // ctiping//2
								$cadkiebre .= $arraydatos[$i][3] . '@'; // aï¿½o//3	
								$cadkiebre .= number_format ( $subttotaldiff , '2', '.', '' ); 
								$cadkiebre .= '@'.$arraydatos[$i][5].'@'.$arraydatos[$i][6];	// total//4	
								
								// Para pintar la tabla	
								$detail .= '<tr style="background-color:#FFCCFF" >';
								$detail .= '<td width="45" align="center">' . $arraydatos[$i][5] . '</td>';
								$detail .= '<td width="49" align="center">' . $arraydatos[$i][3] . '</td>';
								$detail .= '<td width="49" align="center">' . $arraydatos[$i][6] . '</td>';
								$detail .= '<td width="61" align="center">' . number_format ( 0 , '2', '.', '' ) . '</td>';
								$detail .= '<td width="64" align="center">' . number_format ( 0 , '2', '.', '' ) . '</td>';
								$detail .= '<td width="60" align="center">' . number_format ( $subttotaldiff , '2', '.', '' ) . '</td>';
								$detail .= '<td width="61" align="center">' . number_format ( 0 , '2', '.', '' ) . '</td>';
								$detail .= '<td width="50" align="center">' . number_format ( $subttotaldiff , '2', '.', '' ) . '</td>';
								$detail .= '</tr>';
							
					}
			}
			
			}

			/*fin de kite de centimos*/
			
			
			//echo $cadkiebre;
			
			//$detail .= '</table>';
			//metemos la cadena de grabacion en la session xD!
			$dcadgrabacion = new Zend_Session_Namespace ( 'cadgrabacion' );
			$dcadgrabacion->data = $cadkiebre . 'ï¿½' . $sumtotal . 'ï¿½' . $url . '&ord=' . $ord;
			//echo $detail;
			$total = '<font size="+2"><B>' . number_format ( $sumtotal, '2', '.', '' ) . '</B></font>';
			$val[0] = array("detail",$detail,"html");
			$val[1] = array("stotal",$total,"html");
			$func->PintarValor($val);
			//echo $cont;
			

		}
	}
	
	public function ventanacobrarpagosarbitriosprediosAction() {
		//$this->_helper->viewRenderer->setNoRender ();
		$this->_helper->layout->disableLayout ();
		
		$tipopago = $this->_request->getParam ( 'tipopago', '' );
		
		//cadena de grabacion en la session xD!
		$dcadgrabacion = new Zend_Session_Namespace ('cadgrabacion');
		$cadgrabacion = $dcadgrabacion->data;
		$cont = '';
		

		
		$func = new Libreria_Pintar();
		
		if($tipopago=='1'){
			$nombrestore = '"public"."pxcobrowww"';
			$arraydatos [0] = '1';
			$arraydatos [1] = '';
			$arraydatos [2] = '';
			$cn = new Model_DataAdapter ();
			$datosfecha = $cn->ejec_store_procedura_sql ( $nombrestore, $arraydatos );
			$dfecha = explode ( " ", $datosfecha [0] [0] );
			
			$data = new Zend_Session_Namespace('arrayconceptos');
			$arrayconceptos = $data->data;
			
			$totalPD =0;
			for($i=0;$i<count($arrayconceptos);$i++){
				$totalPD=$arrayconceptos[$i][3];
			}
			$nombrestore = '"public"."pxcobrowww"';
			$arraydatos [0] = '1';
			$arraydatos [1] = '';
			$arraydatos [2] = '';
			$cn = new Model_DataAdapter ();
			$datosfecha = $cn->ejec_store_procedura_sql ( $nombrestore, $arraydatos );
			$dfecha = explode ( " ", $datosfecha [0] [0] );
			
			$val[0]= array("txttotalcobrar",number_format( $totalPD, '2', '.', '' ),"val");
			$val[1]= array("txttotalpagar",number_format($totalPD,'2','.',''),"val");
			$val[2]= array("txtdevolucion","0.00","val");
			$val[3]= array("hddata",'',"val");
			$val[4]= array("fechrecibo",$dfecha [0],"val");
			$val[5]= array("txtefectivo",number_format( $totalPD, '2', '.', '' ),"val");
			$val[6]= array("txtvuelto",number_format( 0, '2', '.', '' ),"val");
			$func->PintarValor($val);
			
			$msk[0] = array("txttotalpagar");
			$msk[1] = array("txtefectivo");
			$msk[2] = array("txtvuelto");
			$func->CampoDinero($msk);
			
			$evt[0] = array("fechrecibo","click","displayCalendar(this,'dd/mm/yyyy',this)");
			$evt[1] = array("btnaceptarcobro","click","CobrarConceptoPagosDiversos();");
			$evt[2] = array("btncancelarcobro","click","closeDialog('jqDialog1');");
			$evt[3] = array("txtefectivo","change", "/*text_min('txtefectivo',$('#txttotalpagar').val());*/restarmontospagosarbitriospredios();");
			$evt[4] = array("rbtn_cobromanual","click", "activarpagomanualpagosarbitriospredios();");
			$evt[5] = array("txttotalpagar", "change", "min_max_text('txttotalpagar',1.00,".number_format($totalPD, '2', '.', '' ).");nuevomontoefectivo();restarmontospagosarbitriospredios();reseteardetallepago('txttotalpagar');");
			$evt[6] = array('btndetalle','click','ventanadetallepago();');
			$func->PintarEvento($evt);
			
			$hab[0] = array("nrorecibo",false);
			$hab[1] = array("fechrecibo",false);
			$hab[2] = array("rbtn_cobromanual",false);
			$func->HabilitarComponente($hab);
			
			
			if ($totalPD <= 0) {
				$hab[0] = array("btnaceptar",false);
				$func->HabilitarComponente($hab);
			}
			
			$ddetallepago = new Zend_Session_Namespace ( 'detallepago' );
			$detallepago = $ddetallepago->data;
			if(count($detallepago) == 0 || $detallepago == '' || $detallepago == null){
				$detallepago = null;
				$detallepago[0][0] = '0000007832';
				$detallepago[0][1] = '';
				$detallepago[0][2] = '';
				$detallepago[0][3] = $totalPD;
				$detallepago[0][4] = 'EFECTIVO';
			
				$ddetallepago->data = $detallepago;
			}
			
		}else{
		
			if(strlen ( $cadgrabacion ) > 5) {
				
				$nombrestore = '"public"."pxcobrowww"';
				$arraydatos [0] = '1';
				$arraydatos [1] = '';
				$arraydatos [2] = '';
				$cn = new Model_DataAdapter ();
				$datosfecha = $cn->ejec_store_procedura_sql ( $nombrestore, $arraydatos );
				$dfecha = explode ( " ", $datosfecha [0] [0] );
				//echo $cadgrabacion;
				$datos = explode ( "ï¿½", $cadgrabacion );
			
				
				$val[0]= array("txttotalcobrar",number_format( $datos [1], '2', '.', '' ),"val");
				$val[1]= array("txttotalpagar",number_format($datos [1],'2','.',''),"val");
				$val[2]= array("txtdevolucion","0.00","val");
				$val[3]= array("hddata",$datos [0],"val");
				$val[4]= array("fechrecibo",$dfecha [0],"val");
				$val[5]= array("txtefectivo",number_format( $datos [1], '2', '.', '' ),"val");
				$val[6]= array("txtvuelto",number_format( 0, '2', '.', '' ),"val");
				$func->PintarValor($val);
				
				$msk[0] = array("txttotalpagar");
				$msk[1] = array("txtefectivo");
				$msk[2] = array("txtvuelto");
				$func->CampoDinero($msk);
				
				$evt[0] = array("fechrecibo","click","displayCalendar(this,'dd/mm/yyyy',this)");
				$evt[1] = array("btnaceptarcobro","click","cobrarpagosarbitriospredios();");
				$evt[2] = array("btncancelarcobro","click","cerrarsubventpagosarbitriospredios();window.open('" . $datos [2] . "','_self');");
				$evt[3] = array("txtefectivo","change", "text_min('txtefectivo',$('#txttotalpagar').val());restarmontospagosarbitriospredios();");
				$evt[4] = array("rbtn_cobromanual","click", "activarpagomanualpagosarbitriospredios();");			
				$evt[5] = array("txttotalpagar", "change", "min_max_text('txttotalpagar',1.00,".number_format( $datos [1], '2', '.', '' ).");nuevomontoefectivo();restarmontospagosarbitriospredios();reseteardetallepago('txttotalpagar');");
				$evt[6] = array('btndetalle','click','ventanadetallepago();');
				$func->PintarEvento($evt);
				
				$hab[0] = array("nrorecibo",false);
				$hab[1] = array("fechrecibo",false);
				$hab[2] = array("rbtn_cobromanual",false);
				$func->HabilitarComponente($hab);
				
				
				if ($datos[1] <= 0) {
					$hab[0] = array("btnaceptar",false);
					$func->HabilitarComponente($hab);
				}
				
				$ddetallepago = new Zend_Session_Namespace ( 'detallepago' );
				$detallepago = $ddetallepago->data;
					if(count($detallepago) == 0 || $detallepago == '' || $detallepago == null){
						$detallepago = null;	
						$detallepago[0][0] = '0000007832';
						$detallepago[0][1] = '';
						$detallepago[0][2] = '';
						$detallepago[0][3] = $datos [1];
						$detallepago[0][4] = 'EFECTIVO';
					
						$ddetallepago->data = $detallepago;
					}  
		
				} else {
					$detail = '<table  height="100%" width="100%"  border="0" cellspacing="1" cellpadding="0">';
					$detail .= '<tr valign="center">';
					$detail .= '<td align="center">';
					$detail .= 'Seleccione registros a cancelar..<br><br>';
					$detail .= '<input type="button" id="btncancelarcobro" name="btncancelarcobro"  value="Regresar"/>';
					$detail .= '</td>';
					$detail .= '</tr>';
					$detail .= '</table>';
		
					$val[0] = array("div_p",$detail,"html");
					$func->PintarValor($val);
					$evt[0] = array("btncancelarcobro","click","cerrarsubventpagosarbitriospredios();");
					$func->PintarEvento($evt);
				}
		}
	}
	
	public function ventanadetallepagoAction() {

		$this->_helper->layout->disableLayout();
		$func = new Libreria_Pintar();

		$url = $this->view->util()->getPath();
		
		$totpag = $this->_request->getParam('totpag', '');		
						
		$ddetallepago = new Zend_Session_Namespace ( 'detallepago' );
		$detallepago = $ddetallepago->data;
			/*
			    0 - ctippag=''0000007831'' 
				1 - dnrodoc=''1234********5678'' 
				2 - nnroope=''123456'' 				
				3 - nmontot=''300.00'' 
			 */
		
		$nombrestore = 'tesoreria.obtener_formaspago';
		$arraydatos [0] = '';
		$cn = new Model_DataAdapter ();
		$datoscb = $cn->ejec_store_procedura_sql ( $nombrestore, $arraydatos );
		
		$val[0] = array('cbtipopago',$func->ContenidoCombo($datoscb,''),'html');
		$val[1] = array('montototal',$totpag,'html');
		$montodif = 0.00;
			if(count($detallepago) == 0 || $detallepago == '' || $detallepago == null){
				$val[2] = array('hdsubtotal',$totpag,'val');
				$hab[] = array('btnaceptardetalle',false);
	          	$hab[] = array('btnagregar',true);  
			}
			else{				
				for($i=0;$i<count($detallepago);$i++){
					$montodif = $montodif + $detallepago[$i][3];
				}				
				$val[2] = array('hdsubtotal',$totpag-$montodif,'val');
				
				$contdetalle= '<table width="290" border="0" cellspacing="0" cellpadding="0">';
					for($i=0;$i<count($detallepago);$i++){
			            $contdetalle.= '<tr>';
			            $contdetalle.= '<td width="55" >'.$detallepago[$i][4].'</td>';
			            $contdetalle.= '<td width="100">'.$detallepago[$i][1].'</td>';
			            $contdetalle.= '<td width="65" >'.$detallepago[$i][2].'</td>';
			            $contdetalle.= '<td width="50" >'.$detallepago[$i][3].'</td>';
			            $contdetalle.= '<td width="20"><img src="'.$url.'img/b_drop.png" width="16"  height="16" onclick="borrardetallepago(\''.$detallepago[$i][0].'\',\''.$detallepago[$i][1].'\');"  style="cursor:pointer" /></td>';
			            $contdetalle.= '</tr>';
					}
	            $contdetalle.= '</table>';	
				$val[3] = array('div_detallepago',$contdetalle,'html');
				
				if($totpag-$montodif == 0.00){
	            	$hab[] = array('btnaceptardetalle',true);
	            	$hab[] = array('btnagregar',false);
            	}else{
            		$hab[] = array('btnaceptardetalle',false);
	            	$hab[] = array('btnagregar',true);
            	} 
				
			}
		
			$func->PintarValor($val);
			$func->HabilitarComponente($hab);
			
			$msk[0] = array("txtmontopago");
			$func->CampoDinero($msk);
			
			$evt[0] = array("btnaceptardetalle","click","closeDialog('jqDialog2');");
			//$evt[1] = array("txtmontopago", "change", "min_max_text('txtmontopago',1.00,'hdsubtotal');");
			$evt[1] = array("btnagregar","click","aniadirdetallepago();");				
			$func->PintarEvento($evt);
		
			$sl[0] = array('hdsubtotal',true);
			$func->ComponenteSoloLectura($sl);
		
	}
	
	public function reseteardetallepagoAction() {
		
		$this->_helper->viewRenderer->setNoRender ();
		$this->_helper->layout->disableLayout ();
					
		$this->_helper->getHelper ( 'ajaxContext' )->initContext ();
		
		if ($this->getRequest ()->isXmlHttpRequest ()) {
    	
			$ddetallepago = new Zend_Session_Namespace ( 'detallepago' );
			//$detallepago = $ddetallepago->data;
			
			$monto = $this->_request->getPost ( 'monto' );
				$detallepago = null;	
				$detallepago[0][0] = '0000007832';
				$detallepago[0][1] = '';
				$detallepago[0][2] = '';
				$detallepago[0][3] = $monto;
				$detallepago[0][4] = 'EFECTIVO';
			
			$ddetallepago->data = $detallepago;

		}
	}
	
	public function aniadirdetallepagoAction() {
		
		$this->_helper->viewRenderer->setNoRender ();
		$this->_helper->layout->disableLayout ();
					
		$this->_helper->getHelper ( 'ajaxContext' )->initContext ();
		
		if ($this->getRequest ()->isXmlHttpRequest ()) {

			$func = new Libreria_Pintar();
			
			//$surl = new Zend_Session_Namespace('url');
		    $url = $this->view->util()->getPath();
    	
			$ddetallepago = new Zend_Session_Namespace ( 'detallepago' );
			$detallepago = $ddetallepago->data;

			$montototal = $this->_request->getPost ( 'montototal' );
			$codtipppago = $this->_request->getPost ( 'codtipppago' );
			$desctipppago = $this->_request->getPost ( 'desctipppago' );
			$monto = $this->_request->getPost ( 'monto' );
			$nrodoc = $this->_request->getPost ( 'nrodoc' );
			$nroope = $this->_request->getPost ( 'nroope' );
			
			//echo $codtipppago.'->'.$desctipppago.'->'.$monto.'->'.$nrodoc.'->'.$nroope;
			
			if(count($detallepago) == 0 || $detallepago == '' || $detallepago == null){
				$detallepago[0][0] = $codtipppago;
				$detallepago[0][1] = $nrodoc;
				$detallepago[0][2] = $nroope;
				$detallepago[0][3] = $monto;
				$detallepago[0][4] = $desctipppago;
			}
			else{
				$b = 99999;
				for($i=0;$i<count($detallepago);$i++){
					if($detallepago[$i][0] == $codtipppago && $detallepago[$i][1] == $nrodoc && $detallepago[$i][2] == $nroope){
						$b = $i;
					}
				}				
				
				if($b == 99999){
					$c = count($detallepago);
					$detallepago[$c][0] = $codtipppago;
					$detallepago[$c][1] = $nrodoc;
					$detallepago[$c][2] = $nroope;
					$detallepago[$c][3] = $monto;
					$detallepago[$c][4] = $desctipppago;
				}else{
					$detallepago[$b][3] = $detallepago[$b][3] + $monto ;
				}												
			}			
			$ddetallepago->data = $detallepago;
			
			$sumrestante = 0;
			$cont= '<table width="290" border="0" cellspacing="0" cellpadding="0">';
			for($i=0;$i<count($detallepago);$i++){
				$sumrestante = $sumrestante + $detallepago[$i][3];
	            $cont.= '  <tr>
	                        <td width="55" >'.$detallepago[$i][4].'</td>
	                        <td width="100">'.$detallepago[$i][1].'</td>
	                        <td width="65" >'.$detallepago[$i][2].'</td>
	                        <td width="50" >'.$detallepago[$i][3].'</td>
	                        <td width="20"><img src="'.$url.'img/b_drop.png" width="16" title="Borrar" height="16"  onclick="borrardetallepago(\''.$detallepago[$i][0].'\',\''.$detallepago[$i][1].'\');" style="cursor:pointer" /></td>
	                      </tr>';
			}
            $cont.= '</table>';

            $val[] = array('hdsubtotal',$montototal - $sumrestante,'val');
            $func->PintarValor($val);
            
            if($montototal - $sumrestante == 0.00){
            	$hab[] = array('btnaceptardetalle',true);
            	$hab[] = array('btnagregar',false);
            	$func->HabilitarComponente($hab);
            }            
            echo $cont;
			
		}
	}
	
	public function borrardetallepagoAction() {
		
		$this->_helper->viewRenderer->setNoRender ();
		$this->_helper->layout->disableLayout ();
					
		$this->_helper->getHelper ( 'ajaxContext' )->initContext ();
		
		if ($this->getRequest ()->isXmlHttpRequest ()) {

			$func = new Libreria_Pintar();
			
			//$surl = new Zend_Session_Namespace('url');
		    $url = $this->view->util()->getPath();
    	
			$ddetallepago = new Zend_Session_Namespace ( 'detallepago' );
			$detallepago = $ddetallepago->data;

			$montototal = $this->_request->getPost ( 'montototal' );
			$codtipppago = $this->_request->getPost ( 'codtipppago' );
			$nrodoc = $this->_request->getPost ( 'nrodoc' );

				for($i=0;$i<count($detallepago);$i++){
					if($detallepago[$i][0] == $codtipppago && $detallepago[$i][1] == $nrodoc){
						unset($detallepago[$i]);
		   				$detallepago = array_values($detallepago);	
					}
				}														
						
			$ddetallepago->data = $detallepago;
			
			$sumrestante = 0;
			$cont= '<table width="290" border="0" cellspacing="0" cellpadding="0">';
			for($i=0;$i<count($detallepago);$i++){
				$sumrestante = $sumrestante + $detallepago[$i][3];
	            $cont.= '  <tr>
	                        <td width="55" >'.$detallepago[$i][4].'</td>
	                        <td width="100">'.$detallepago[$i][1].'</td>
	                        <td width="65" >'.$detallepago[$i][2].'</td>
	                        <td width="50" >'.$detallepago[$i][3].'</td>
	                        <td width="20"><img src="'.$url.'img/b_drop.png" width="16"  title="Borrar" height="16" onclick="borrardetallepago(\''.$detallepago[$i][0].'\',\''.$detallepago[$i][1].'\');" style="cursor:pointer" /></td>
	                      </tr>';
			}
            $cont.= '</table>';

            $val[] = array('hdsubtotal',$montototal - $sumrestante,'val');
            $func->PintarValor($val);
            
            if($montototal - $sumrestante == 0.00){
            	$hab[] = array('btnaceptardetalle',true);
            	$hab[] = array('btnagregar',false);
            	$func->HabilitarComponente($hab);
            }else{
            	$hab[] = array('btnaceptardetalle',false);
            	$hab[] = array('btnagregar',true);
            	$func->HabilitarComponente($hab);
            
            }            
            echo $cont;
			
		}
	}
	
	
	public function cobrarpagosarbitriosprediosAction() {
		
			$this->_helper->viewRenderer->setNoRender ();
			$this->_helper->layout->disableLayout ();
			$this->_helper->getHelper ( 'ajaxContext' )->initContext ();
		if ($this->getRequest ()->isXmlHttpRequest ()) {			
			
			$registros = $this->_request->getPost ( 'registros' );
			$fecha = $this->_request->getPost ( 'fecha' );
			$efectivo = $this->_request->getPost ( 'efectivo' );
			
			$cad = str_replace ( 'fechpago', $fecha, $registros );
			$cad = str_replace ( 'estrec', '1', $cad );
			
			$this->cobrarpago($cad,$efectivo);

		}
	}
	
	public function imprimirrecibopagosarbitriosprediosAction() {
		$this->_helper->layout->disableLayout ();
		 
		$func = new Libreria_Pintar ();
				
		$nrorecibo = $this->_request->getParam ( 'nrorecibo', '' );
		$txtduplicado = $this->_request->getParam ( 'duplicado', '' );
		
		//echo $this->util()->getScript("js/app/common");
		echo $this->view->util()->getScript("js/app/ui");
		#echo $this->view->util()->getScript("js/app/common");
		
		
		
		if (strlen ( $nrorecibo ) == 12) {
			$nombrestore = 'tesoreria.imprimir_recibo_pagosarbitriospredios';
			$arraydatos[0] = $nrorecibo;
			$cn = new Model_DataAdapter ();
			$datosrecibo = $cn->ejec_store_procedura_sql ( $nombrestore, $arraydatos );
			
			$nombrestore = '"public"."pxcobrowww"';
			$arraydatos1 [0] = '1';
			$arraydatos1 [1] = '';
			$arraydatos1 [2] = '';
			$cn = new Model_DataAdapter ();
			$dfechaserver = $cn->ejec_store_procedura_sql($nombrestore, $arraydatos1);
			
			if (count ( $datosrecibo ) > 0) {
				
				//$nombrestore = 'general.buscar_persona';
				//$arraydatos[0] = array ('@nvar1', $datosrecibo[0][6] );
				$nombrestore = '"public"."buscar_persona"';
				$arraydatosp [0] = $datosrecibo[0][6] ;
				$arraydatosp [1] = '' ;
				$arraydatosp [2] = '' ;
				$arraydatosp [3] = '' ;
				$arraydatosp [4] = '';
				
				$cn = new Model_DataAdapter ();
				$datospersonas = $cn->ejec_store_procedura_sql ($nombrestore, $arraydatosp );
				
				$dcodcajero = new Zend_Session_Namespace ('codcajero');
				$codcajero = $dcodcajero->data;
				//print_r($datosrecibo);
				
				$val [0] = array ("duplicado", $txtduplicado, "html" );
				$val [1] = array ("datosrec1", $datosrecibo[0][1], "html" );
				$val [2] = array ("datosrec6", $datosrecibo[0][6], "html" );
				$val [3] = array ("datosper1", $datospersonas[0][1], "html" );
				$val [4] = array ("datosrec18",$datosrecibo[0][18], "html" );//codigo pred  
				$val [5] = array ("datosrec17", $datosrecibo[0][17], "html" );//direccion
				$val [6] = array ("datosrec15", $datosrecibo[0][15], "html" );//arbitroos 2009
				//10 direccion
				//17 arbitrios 2009
				//15 datos de mora
				//16 descripcion
				$detalle = '<table width="100%" border="0" cellpadding="0" cellspacing="0">';
				$sumtotal = 0;
				for($i = 0; $i < count ( $datosrecibo ); $i ++) {
					$sumtotal = $sumtotal + $datosrecibo[$i][3];
					$detalle .= '<tr>';
					$detalle .= '<td width="56" height="10" class="Estilo8">' . $datosrecibo[$i][14] . '</td>';
					$detalle .= '<td width="40" align="right" class="Estilo8">' . number_format ( $datosrecibo[$i][12], '2', '.', '' ) . '</td>';
					$detalle .= '<td width="40" align="right" class="Estilo8">' . number_format ( $datosrecibo[$i][13], '2', '.', '' ) . '</td>';
					$detalle .= '<td width="40" align="right" class="Estilo8">' . number_format ( $datosrecibo[$i][11], '2', '.', '' ) . '</td>';
					$detalle .= '<td width="50" align="right" class="Estilo8">' . number_format ( $datosrecibo[$i][3], '2', '.', '' ) . '</td>';
					$detalle .= '</tr>';
				}
				$detalle .= '</table>';
				$val [7] = array ("detalle", $detalle, "html" );
				$val [8] = array ("sumtotal", number_format ( $sumtotal, '2', '.', '' ), "html" );
				$val [9] = array ("datosrec", "Fecha Pago: " . $datosrecibo[0][2], "html" );
				$val [10] = array ("codcajero", "Cajero: " . $codcajero, "html" );
				$val [11] = array ("fechaserver", "Fecha Impresion:" . $dfechaserver[0][0], "html" );
				$func->PintarValor ( $val );
				//print_r ($datosrecibo);
			} else {
			
				
				
				$dd = 'No se imprimio el recibo nro: <b>' . $nrorecibo . '</b> porque no se encontro en la base de datos.<br><b>' . $dfechaserver [0] [0] . '</b>';
				$val [0] = array ("muni", $dd, "html" );
				$func->PintarValor ( $val );
			}
		
		} else {
			
			
			$dd = '</b> Ingresar número de recibo valido<b>';
			$val [0] = array ("muni", $dd, "html" );
			$func->PintarValor ( $val );
		}
		
	//}
	}
	
	public function ventanadescargospagosarbitriosprediosAction() {
		//$this->_helper->viewRenderer->setNoRender ();
		$this->_helper->layout->disableLayout ();
		//cadena de grabacion en la session xD!
		$dcadgrabacion = new Zend_Session_Namespace ( 'cadgrabacion' );
		$cadgrabacion = $dcadgrabacion->data;
		
		if (strlen ( $cadgrabacion ) > 5) {
			
			$nombrestore = 'dbo.pxCobroWWW';
			$arraydatos [0] = array ('@idquery', '1' );
			$cn = new Model_DataAdapter ();
			$datosfecha = $cn->ejec_store_procedura_sql ( $nombrestore, $arraydatos );
			$dfecha = explode ( " ", $datosfecha [0] [0] );
			
			$nombrestore = 'tesoreria.obtener_tipodescargo';
			$arraydatos [0] = array ('@cid', '' );
			$cn = new Model_DataAdapter ();
			$dtipodescargos = $cn->ejec_store_procedura_sql ( $nombrestore, $arraydatos );
			
			//echo $cadgrabacion;
			$datos = explode ( "ï¿½", $cadgrabacion );
			
			$func = new Libreria_Pintar ();
			$val [0] = array ("datos1", '<B>' . number_format ( $datos [1], '2', '.', '' ) . '</B>', "html" );
			$val [1] = array ("fechrecibo", $dfecha [0], "val" );
			
			
			for($i = 0; $i < count ( $dtipodescargos ); $i ++) {
				$cbo [$i] = array ($dtipodescargos [$i] [2], $dtipodescargos [$i] [1] );
			}
			$val [2] = array ("tpdescargo", $func->ContenidoCombo ( $cbo, $cbo [0] [0] ), "html" );
			
			if ($datos [1] <= 0) {
				$valor = '<tr><td colspan="3" align="center">No se puede descargar recibos con montos iguales a 0.00</td>';
				$valor .= '</tr><tr><td colspan="3" align="center">&nbsp;</td></tr>';
				$hab [0] = array ("btndescargo", false );
				$func->HabilitarComponente ( $hab );
			}
			$val [3] = array ("nocdescargan", $valor, "html" );
			$val [4] = array ("hddata", $datos [0], "val" );
			$val [5] = array("txtefectivo",number_format( $datos [1], '2', '.', '' ),"val");
			$func->PintarValor ( $val );
			$evt[0] = array ("btncancelarcobro", "click", "cerrarsubventpagosarbitriospredios();window.open('" . $datos [2] . "','_self');" );
			$evt[1] = array ("btndescargos", "click", "descargospagosarbitriospredios();" ); // no reconoce el evento
			$evt[2] = array("txtefectivo", "change", "min_max_text('txtefectivo',1.00,".number_format( $datos [1], '2', '.', '' ).");reseteardetallepago('txtefectivo');");
			$func->PintarEvento ( $evt );
			
			$msk[0] = array("txtefectivo");
			$func->CampoDinero($msk);
			
			$ddetallepago = new Zend_Session_Namespace ( 'detallepago' );
			$detallepago = $ddetallepago->data;
				if(count($detallepago) == 0 || $detallepago == '' || $detallepago == null){
					$detallepago = null;	
					$detallepago[0][0] = '0000007832';
					$detallepago[0][1] = '';
					$detallepago[0][2] = '';
					$detallepago[0][3] = number_format( $datos [1], '2', '.', '' );
					$detallepago[0][4] = 'EFECTIVO';
				
					$ddetallepago->data = $detallepago;
				}  
			
			
		} else {
			//
			$func = new Libreria_Pintar ();
			$tabla = '<table  height="100%" width="100%"  border="0" cellspacing="1" cellpadding="0">';
			$tabla .= '	<tr valign="center">';
			$tabla .= '<td align="center">';
			$tabla .= 'Seleccione registros para el descargo..<br><br>';
			$tabla .= '<input type="button" id="btncancelarcobro" name="btncancelarcobro"   value="Regresar" onclick="cerrarsubventpagosarbitriospredios();" />';
			$tabla .= '</td>';
			$tabla .= '</tr>';
			$tabla .= '</table>';
			$val[0] = array ("div_p", $tabla, "html" );
			$func->PintarValor ( $val );
		}
		//	echo $cont;
	}
	
	public function descargospagosarbitriosprediosAction() {
		$this->_helper->getHelper ( 'ajaxContext' )->initContext ();
		$this->_helper->viewRenderer->setNoRender ();
			$this->_helper->layout->disableLayout ();
		if ($this->getRequest ()->isXmlHttpRequest ()) {
			
			
			$registros = $this->_request->getPost ( 'registros' );
			$fecha = $this->_request->getPost ( 'fecha' );
			$est = $this->_request->getPost ( 'tpdescargo' );
			$efectivo = $this->_request->getPost ( 'efectivo' );
			
			$nrodoc = $this->_request->getPost ( 'nrodoc' );
			$observ = $this->_request->getPost ( 'observ' );
			
			
			$cad = str_replace ( 'fechpago', $fecha, $registros );
			$cad = str_replace ( 'estrec', $est, $cad );
			$cad = str_replace ( '^/^', '^Nro Doc: '.$nrodoc.', '.$observ.'^', $cad );
			
			$this->cobrarpago($cad,$efectivo);
		}
	}
	
	public function ventanarecibosemitidosAction() {
		//$this->_helper->viewRenderer->setNoRender ();
		$this->_helper->layout->disableLayout ();
		
		$codper = $this->_request->getParam ( 'codper', '' );
		$cont = '';
		
		$surl = new Zend_Session_Namespace ( 'url' );
		$url = $this->view->util()->getPath();
		
		if (strlen ( $codper ) == 10) {
			
			$nombrestore = '"public"."pxcobrowww"';
				$arraydatos [0] = '1';
				$arraydatos [1] = '';
				$arraydatos [2] = '';
				$cn = new Model_DataAdapter();
				$datosfecha = $cn->ejec_store_procedura_sql( $nombrestore, $arraydatos );
				$dfecha = explode ( " ", $datosfecha [0] [0] );
			
			$nombrestore = 'tesoreria.obtener_recibospagos';
			$arraydatosrecibos [0] = $codper;
			$cn = new Model_DataAdapter ();
			$datos = $cn->ejec_store_procedura_sql ( $nombrestore, $arraydatosrecibos );
			
			$array = '';
			
			for($i = 0; $i < count ( $datos ); $i ++) {
				
				$descrip = $datos[$i][0];
                $periodo = $datos[$i][1];
                $total = $datos[$i][2];
                $nrorecibo = $datos[$i][3];
                $caja = $datos[$i][4];
                $observ = $datos[$i][5];
                $usuario = $datos[$i][6];
                $fecha = $datos[$i][7];
                $ctiping = $datos[$i][8];
                $predio = $datos[$i][10];
                $estado = $datos[$i][11];
				
				if ($array == '' || $array == null || count ( $array ) == 0) {
					$array [0] [0] = $nrorecibo;
					$array [0] [1] = $caja;
					$array [0] [2] = $usuario;
					$array [0] [3] = $fecha;
					$array [0] [4] = $total;
					$array [0] [5] = $estado;
					$array [0] [6] = $descrip . '^' . $periodo . '^' . $total . '^' . $nrorecibo . '^' . '-' . '^' . $predio . '^' . $usuario . '^' . $fecha . '^' . $estado . '^' . $ctiping . '^' . $codper . '~'; // cadena para el detalle
				} else {
					$b = null;
					for($k = 0; $k < count ( $array ); $k ++) {
						if ($array [$k] [0] == $nrorecibo) {
							$b = $k;
							break;
						} else {
							$b = 99999;
						}
					}
					if ($b == 99999) {
						$c = count ( $array );
						$array [$c] [0] = $nrorecibo;
						$array [$c] [1] = $caja;
						$array [$c] [2] = $usuario;
						$array [$c] [3] = $fecha;
						$array [$c] [4] = $total;
						$array [$c] [5] = $estado;
						$array [$c] [6]  = $descrip . '^' . $periodo . '^' . $total . '^' . $nrorecibo . '^' . '-' . '^' . $predio . '^' . $usuario . '^' . $fecha . '^' . $estado . '^' . $ctiping . '^' . $codper . '~'; // cadena para el detalle
					} else {
						$array [$b] [6] .= $descrip . '^' . $periodo . '^' . $total . '^' . $nrorecibo . '^' . '-' . '^' . $predio . '^' . $usuario . '^' . $fecha . '^' . $estado . '^' . $ctiping . '^' . $codper . '~';
						$array [$b] [4] = $array [$b] [4] + $total;
					}
				}
			}
			
			$func = new Libreria_Pintar ();
			
			if($array == "") {
				$detalle = "No hay recibos genreados";
			} else {
				$detalle = '<table width="442" border="0" cellspacing="0" cellpadding="0" class="reportes">';
				for($k = 0; $k < count ( $array ); $k ++) {
					$detalle .= '<tr ' . (($dfecha [0] == $array [$k] [3]) ? ' bgcolor="#FFFF33" ' : '') . ' >';
					$detalle .= '<td width="87" align="center">' . $array [$k] [0] . '</td>';
					$detalle .= '<td width="30" align="center">' . $array [$k] [1] . '</td>'; //caja
					$detalle .= '<td width="78" align="center">' . $array [$k] [2] . '</td>';
					$detalle .= '<td width="77" align="center">' . $array [$k] [3] . '</td>';
					$detalle .= '<td width="50" align="right">' . number_format ( $array [$k] [4], '2', '.', '' ) . '&nbsp;</td>';
					$detalle .= '<td width="70" align="center">' . $array [$k] [5] . '</td>';
					$detalle .= '<td width="52" align="center"><input type="hidden" id="hd_nrored' . $array [$k] [0] . '" name="hd_nrored" value="" />';
					$detalle .= '<input type="hidden" id="hdd' . $k . '" value="' . $array [$k] [6] . '" name="hdd' . $k . '" />';
					$detalle .= '<img src="'.$url.'img/busqueda.png" width="16" height="16" onclick="detallerecibosxconribuyente(this)" /></td>';
					$detalle .= '</tr>';
					$detalle .= '<tr>';
					$detalle .= '<td colspan="7" align="center"><div id="div_nrorec' . $array[$k][0] . '"></div></td>';
					$detalle .= '</tr>';
					$detalle .= '<tr>';
					$detalle .= '<td colspan="7" height="3px" align="center"><hr></td>';
					$detalle .= '</tr>';
				}
				$detalle .= '</table>';
			}
			$val[0] = array ("detalletodorecibos", $detalle, "html" );
            $func->PintarValor($val);
			
			$evt[0] = array("btncancelarcobro", "click", "cerrarsubvent();");
			$func->PintarEvento($evt);

		} else {
			
			$func = new Libreria_Pintar ();
			
			$divp = '<table  height="100%" width="100%"  border="0" cellspacing="1" cellpadding="0">';
			$divp .= '<tr valign="center">';
			
			$divp .= '<td align="center">';
			$divp .= 'Seleccione a la persona para ver sus recibos...<br><br>';
			$divp .= '<input type="button" id="btncancelarcobro" name="btncancelarcobro"   value="Regresar" onclick="cerrarsubvent();" />';
			$divp .= '</td>';
			$divp .= '</tr>';
			$divp .= '</table>';
			$val [0] = array ("divp", $divp, "html" );
			
			$func->PintarValor($val);			
			
//			$evt[0]=array("btncancelarcobro", "click", "cerrarsubvent();");
//			$func->PintarEvento($evt);
			
		}
		//echo $cont;
	

	}
	
	public function detallerecibosemitidosAction() {
		$this->_helper->layout->disableLayout ();
		$this->_helper->getHelper ( 'ajaxContext' )->initContext ();
		
		if ($this->getRequest ()->isXmlHttpRequest ()) {
			//$this->_helper->viewRenderer->setNoRender ();
			
			
			$arraymeses = array ('Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic' );
			$nummeses = array ('01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12' );
			
			$cad = $this->_request->getPost ( 'cad' );
			$cad = substr ( $cad, 0, strlen ( $cad ) - 1 );
			$datos = explode ( "~", $cad );
			$datosprincipales = explode ( "^", $datos [0] );
			
			//$descrip.'^'.$periodo.'^'.$total.'^'.$nrorecibo.'^'.$observ.'^'.$predio.'^'.$usuario.'^'.$fecha.'^'.$estado.'^'.$ctiping.'^'.$codper
			//print_r($datosprincipales);
			

			$nombrestore = '"public"."pxcobrowww"';
				$arraydatos [0] = '1';
				$arraydatos [1] = '';
				$arraydatos [2] = '';
				$cn = new Model_DataAdapter();
				$datosfecha = $cn->ejec_store_procedura_sql( $nombrestore, $arraydatos );
				$dfecha = explode ( " ", $datosfecha [0] [0] );
			
			$nombrestore = 'tesoreria.obt_estadorecibo';
			$arraydatosrecibo [0] =  $datosprincipales [3] ;
			$cn = new Model_DataAdapter ();
			$datosrecibo = $cn->ejec_store_procedura_sql( $nombrestore, $arraydatosrecibo );
			
			$func = new Libreria_Pintar();
			$slec[0]= array("txtnrorecibo",true);
			$slec[1]=array("txtusuario",true);
			$slec[2]=array("txtfechapago",true);
			$slec[3]=array("txtcodpredio",true);
			$slec[4]=array("txtobservacion",true);
			//
			$val[0]=array("datosp8",'<font size="+1"><b>'.$datosprincipales [8] . '<b>',"html");
			$val[1]=array("txtnrorecibo",$datosprincipales [3],"val");
			$val[2]=array("txtusuario",$datosprincipales [6],"val");
			$val[3]=array("txtfechapago",$datosprincipales [7],"val");
			$val[4]=array("txtcodpredio",$datosprincipales [5],"val");
			$val[5]=array("txtobservacion",$datosrecibo[0][6],"html");
			
			if ($datosprincipales [9] == '0000000273' || $datosprincipales [9] == '0000000278')
				$dp = $datosprincipales [0];
			else
				$dp = 'Cobro Diverso '.$datosprincipales [9];
			$val[6]=array("datosp",$dp,"html");
			
		$sum = 0;
		$dtll='<table width="266" border="1" cellspacing="3" cellpadding="0" class="reportes">';
			for($i = 0; $i < count ( $datos ); $i ++) {
				$datosregistros = explode ( "^", $datos [$i] );
				$sum = $sum + $datosregistros [2];
				$dtll .= '<tr><td width="33">';
				if ($datosregistros [9] == '0000000273')
					$dtll .= 'PRED.';
				else if ($datosregistros [9] == '0000000278')
					$dtll .= 'ARB.';
				else
					$dtll .= 'C.D.';
				$dtll .= '</td><td width="162">';
				if ($datosregistros [9] == '0000000273')
					$dtll .= $datosregistros [1] . ' Trim.';
				else if ($datosregistros [9] == '0000000278')
					$dtll .= str_replace ( $nummeses, $arraymeses, $datosregistros [1] );
				else
					$dtll .= $datosregistros [0];
				$dtll .= '</td><td width="59" align="right">' . number_format ( $datosregistros [2], '2', '.', '' ) . '</td></tr>';
			}
			$dtll .='</table>';
			$val[7]=array("div_detalle",$dtll,"html");
			$val[8]=array("numberformat",number_format ( $sum, '2', '.', '' ),"html");
			
			$evt[0]=array("btnduplicado","click","Generarduplicadorecibodet('" . $datosprincipales [9] . "','" . $datosprincipales [3] . "','DUPLICADO'); ");
			
			$evt[1]=array("btnreimpresion","click","Generarduplicadorecibodet('" . $datosprincipales [9] . "','" . $datosprincipales [3] ."','')");
			$func->PintarValor($val);
			$func->ComponenteSoloLectura($slec);
			$func->PintarEvento($evt);
		// (($datosprincipales [8] == 'Anulado') ? ' disabled="disabled" ' : '')
		if  ($datosprincipales [8] == 'Anulado'){
			$hab[0]=array("btnduplicado",false);
			$func->HabilitarComponente($hab);
		}
		
		if ($dfecha[0] == $datosrecibo[0][3] && $datosrecibo[0][1]== '1'){
			$hab2[0]=array("btnreimpresion",true);
		}else{
			$hab2[0]=array("btnreimpresion",false);
		}
		$func->HabilitarComponente($hab2);
			
		}
	}
	
	

}

