<?php

class Libreria_Pintar {

	public function PintarLibrerias(){
		 
		$surl = new Zend_Session_Namespace('url');
		$url = $surl->data;
		
		echo ' <script type="text/javascript" src="'.$url.'js/jquery-1.4.2.min.js"></script>';
		echo ' <script type="text/javascript" src="'.$url.'js/js_validaciones.js"></script>';

		echo '<link rel="stylesheet" href="'.$url.'css/admuniweb_estilos.css" />';
	}
	
	/**
	 * Escribe valores dentro de los componentes
	 * tiene como parametro un arreglo que tiene
	 * la siguiente estructura
	 * 		Col 0 = Id del Objecto
	 * 		Col 1 = Valor del Objecto
	 * 		Col 2 = Tipo de Propiedad (val, html)
	 * @param array $valores
	 */
	public function PintarValor($valores) {
		$script = "Parametro invalido Valor.";

		if(is_array($valores)){
			$valores = array_values($valores);
			$script = "\n<script>\n";
			for($i = 0; $i < count($valores); $i++) {
				$script .= "\t$('#".$valores[$i][0]."').".$valores[$i][2]."(validarcad('".$valores[$i][1]."'));\n";
				//$script .= "\t$('#".$valores[$i][0]."').".$valores[$i][2]."('".$valores[$i][1]."');\n";
			}
			$script .= "</script>\n";
		}
		
		echo $script;
	}
	public function PintarValorJS($valores) {
		$script = "Parametro invalido Valor.";

		if(is_array($valores)){
			$valores = array_values($valores);
			$script = "\n<script>\n";
			for($i = 0; $i < count($valores); $i++) {
				$script .= "\t$('#".$valores[$i][0]."').".$valores[$i][2]."(validarcad('".$valores[$i][1]."'));\n";
				//$script .= "\t$('#".$valores[$i][0]."').".$valores[$i][2]."('".$valores[$i][1]."');\n";
			}
			$script .= "</script>\n";
		}
		
		echo $script;
	}
	/**
	 * Asigna los eventos a los componentes
	 * tiene como parametro un arreglo que tiene
	 * la siguiente estructura
	 * 		Col 0 = Id del Objecto
	 * 		Col 1 = Evento
	 * 		Col 2 = Funcion
	 * @param array $valores
	 */
	public function PintarEvento($valores) {
		$script = "Parametro invalido Evento.";

		if(is_array($valores)){
			$valores = array_values($valores);
			$script = "\n<script>\n";
			for($i = 0; $i < count($valores); $i++) {
				$script .= "\t$('#".$valores[$i][0]."').".$valores[$i][1]."(function(event){ ".$valores[$i][2]." });\n";
			}
			$script .= "</script>\n";
		}
		
		echo $script;
	}
	
	/**
	 * Habilita o deshabilita los componentes
	 * tiene como parametro un arreglo que tiene
	 * la siguiente estructura
	 * 		Col 0 = Id del Objecto
	 * 		Col 1 = habilitad ( true, false )
	 * @param array $valores
	 */
	public function HabilitarComponente($valores) {
		$script = "Parametro invalido Habilitar.";
		if(is_array($valores)){
		$valores = array_values($valores);			
			$script = "\n<script>\n";
			for($i = 0; $i < count($valores); $i++) {
				if($valores[$i][1] == true){
					$script .= '$("#'.$valores[$i][0].'").attr(\'disabled\',\'\'); ';	
				}else if($valores[$i][1] == false){
					$script .= '$("#'.$valores[$i][0].'").attr(\'disabled\',\'disabled\'); ';
				}				
			}
			$script .= "</script>\n";
		}
		
		echo $script;
	}
	
	/**
	 * componentes de solo lectura
	 * tiene como parametro un arreglo que tiene  la siguiente estructura
	 * 		Col 0 = Id del Objecto
	 * 		Col 1 = habilitad ( true, false )
	 * @param array $valores
	 */
	public function ComponenteSoloLectura($valores) {
		$script = "Parametro invalido ReadOnly.";
		if(is_array($valores)){
		$valores = array_values($valores);
			$script = "\n<script>\n";
			for($i = 0; $i < count($valores); $i++) {
				if($valores[$i][1] == true){
					$script .= '$("#'.$valores[$i][0].'").attr(\'readonly\', true);';	
					$script .= '$("#'.$valores[$i][0].'").css(\'background-color\', \'#fffbc3\');';
					//$script .= '$("#'.$valores[$i][0].'").css(\'border\', \'0\');';
				}else if($valores[$i][1] == false){
					$script .= '$("#'.$valores[$i][0].'").attr(\'readonly\', false); ';
				}				
			}
			$script .= "</script>\n";
		}
		
		echo $script;
	}

	/**
	 * a�ade un atributo al componente
	 * tiene como parametro un arreglo que tiene  la siguiente estructura
	 * 		Col 0 = Id del Objecto
	 * 		Col 1 = tipo de atributo
	 *		Col 2 = dato del atributo
	 * @param array $valores
	 */
	public function AtributoComponente($valores) {
		$script = "Parametro invalido Atributo.";
		if(is_array($valores)){
		$valores = array_values($valores);
			$script = "\n<script>\n";
			for($i = 0; $i < count($valores); $i++) {
					$script .= '$("#'.$valores[$i][0].'").attr(\''.$valores[$i][1].'\', \''.$valores[$i][2].'\');';		
			}
			$script .= "</script>\n";
		}
		echo $script;
	}
	
	/**
	 * componentes de solo lectura
	 * tiene como parametro un arreglo que tiene  la siguiente estructura
	 * 		Col 0 = Id del Objecto
	 * 		Col 1 = habilitad ( true, false )
	 * @param array $valores
	 */
	public function CampoDinero($valores) {
		$script = "Parametro invalido Dinero.";
		if(is_array($valores)){
		$valores = array_values($valores);			
//			$script = "\n<script>\n$(function(){\n
//						";
//			for($i = 0; $i < count($valores); $i++) {
//				$script .= '$("#'.$valores[$i][0].'").maskMoney({symbol:"", decimal:".", thousands:"",precision:2}); ';
//			}
//			$script .= "})\n</script>\n";
//////////////////////////////////////////////////////
			$script = "\n<script>\n
						jQuery(function($) {\n
						";
			for($i = 0; $i < count($valores); $i++) {
				$script .= '$("#'.$valores[$i][0].'").autoNumeric(); ';
			}
			$script .= "});\n
						</script>\n";
			
		}
		echo $script;
	}
	
	/**
	 * Genera unca cadena html con el contenido
	 * de un ComboBox
	 * @param array $opciones 
	 * 		Arreglo bidemensional con los valores a usar
	 * 		Indice 0: Se asigna a la propiedad value
	 * 		Indice 1: Valor que se muestra
	 * @param Object $valor_defecto Valor por defecto a seleccionar
	 * return
	 */
	public function ContenidoCombo($opciones, $valor_defecto) {
		$html = "";
		if(is_array($opciones)) {
		$opciones = array_values($opciones);
			$html .= "<option value=\"9999999999\">Seleccionar...</option>";
			for($i = 0; $i < count($opciones); $i++) {
				if($opciones[$i][0] == $valor_defecto){
					$html .= "<option value=\"".$opciones[$i][0]."\" selected=\"selected\">".$opciones[$i][1]."</option>";
				}else{
					$html .= "<option value=\"".$opciones[$i][0]."\">".$opciones[$i][1]."</option>";	
				}				
			}
		} else {
			$html = "<option value='-1'>Parametros Invalidos</option>";
		}
		return $html;
	}
	
	/*
	 * ordena el array bidimensional segun el campo especificado , ejemplo $array_ordenadito2 = $this->ordenar_array($array_a_ordenar, 'campo3', SORT_DESC, 'campo2', SORT_DESC, 'campo1', SORT_ASC ) or die('<br>ERROR!<br>'); print_r($array_ordenadito2);
	 * @param array $array_a_ordenar
	 * return  
	 * */
	 function ordenar_array() { 
		  $n_parametros = func_num_args(); // Obenemos el n�mero de par�metros 
		  if ($n_parametros<3 || $n_parametros%2!=1) { // Si tenemos el n�mero de parametro mal... 
		    return false; 
		  } else { // Hasta aqu� todo correcto...veamos si los par�metros tienen lo que debe ser... 
		    $arg_list = func_get_args(); 
		
		    if (!(is_array($arg_list[0]) && is_array(current($arg_list[0])))) { 
		      return false; // Si el primero no es un array...MALO! 
		    } 
		    for ($i = 1; $i<$n_parametros; $i++) { // Miramos que el resto de par�metros tb est�n bien... 
		      if ($i%2!=0) {// Par�metro impar...tiene que ser un campo del array... 
		        if (!array_key_exists($arg_list[$i], current($arg_list[0]))) { 
		          return false; 
		        } 
		      } else { // Par, no falla...si no es SORT_ASC o SORT_DESC...a la calle! 
		        if ($arg_list[$i]!=SORT_ASC && $arg_list[$i]!=SORT_DESC) { 
		          return false; 
		        } 
		      } 
		    } 
		    $array_salida = $arg_list[0]; 
		
		    // Una vez los par�metros se que est�n bien, proceder� a ordenar... 
		    $a_evaluar = "foreach (\$array_salida as \$fila){\n"; 
		    for ($i=1; $i<$n_parametros; $i+=2) { // Ahora por cada columna... 
		      $a_evaluar .= "  \$campo{$i}[] = \$fila['$arg_list[$i]'];\n"; 
		    } 
		    $a_evaluar .= "}\n"; 
		    $a_evaluar .= "array_multisort(\n"; 
		    for ($i=1; $i<$n_parametros; $i+=2) { // Ahora por cada elemento... 
		      $a_evaluar .= "  \$campo{$i}, SORT_REGULAR, \$arg_list[".($i+1)."],\n"; 
		    } 
		    $a_evaluar .= "  \$array_salida);"; 
		    // La verdad es que es m�s complicado de lo que cre�a en principio... :) 
		
		    eval($a_evaluar); 
		    return $array_salida; 
		  } 
		} 
		
	/**
	 * EJECUTA FUNCIONES YA ESTABLECIDAS EN JS
	 * tiene como parametro un arreglo que tiene  la siguiente estructura
	 * 		Col 0 = fucion
	 * @param array $valores
	 */
	public function Ejecutarfuncionjs($valores) {
		$script = "Parametro invalido Funcion.";
		if(is_array($valores)){
		$valores = array_values($valores);			
			$script = "\n<script>$(document).ready(function(){";
			for($i = 0; $i < count($valores); $i++) {
				$script .= "\n\t".$valores[$i][0];
			}
			$script .= "\n});</script>\n";
			
		}
		echo $script;
	}

	/**
	 * IP Real
	 */
	public function getRealIP() {

		if( $_SERVER['HTTP_X_FORWARDED_FOR'] != '' ) {
			$client_ip = ( !empty($_SERVER['REMOTE_ADDR']) ) ? $_SERVER['REMOTE_ADDR'] : ( ( !empty($_ENV['REMOTE_ADDR']) ) ? $_ENV['REMOTE_ADDR'] : "unknown" );

			// Los proxys van a�adiendo al final de esta cabecera
			// las direcciones ip que van "ocultando". Para localizar la ip real
			// del usuario se comienza a mirar por el principio hasta encontrar
			// una direcci�n ip que no sea del rango privado. En caso de no
			// encontrarse ninguna se toma como valor el REMOTE_ADDR

			$entries = split('[, ]', $_SERVER['HTTP_X_FORWARDED_FOR']);

			reset($entries);
			while (list(, $entry) = each($entries)) {
				$entry = trim($entry);
				if ( preg_match("/^([0-9]+.[0-9]+.[0-9]+.[0-9]+)/", $entry, $ip_list) ) {
					// http://www.faqs.org/rfcs/rfc1918.html
					$private_ip = array(
						'/^0./',
						'/^127.0.0.1/',
						'/^192.168..*/',
						'/^172.((1[6-9])|(2[0-9])|(3[0-1]))..*/',
						'/^10..*/');

					$found_ip = preg_replace($private_ip, $client_ip, $ip_list[1]);

					if ($client_ip != $found_ip) {
						$client_ip = $found_ip;
						break;
					}
				}
			}
		} else {
			$client_ip = ( !empty($_SERVER['REMOTE_ADDR']) ) ? $_SERVER['REMOTE_ADDR'] : ( ( !empty($_ENV['REMOTE_ADDR']) ) ? $_ENV['REMOTE_ADDR'] : "unknown" );
		}

		return $client_ip;
	}
	/*
	 * 0 = nombre input text
	 * 1 = true,false (mostrar am/pm)
	 * 2 = mostrar hora
	 * 3 = mostrar minutos
	 * 4 = mostrar segundos
	 * 5 = formato hora
	 * 6 = hora min
	 * 7 = hora max
	 * 8 = dia min
	 * 9 = dia max
	 */
	public function CalendarHourComponente($valores) {
		$script = "Parametro invalido Atributo.";
		if(is_array($valores)){
		$valores = array_values($valores);
			$script = "\n<script>\n";
			for($i = 0; $i < count($valores); $i++) {
					$script .= "$('#".$valores[$i][0]."').datetimepicker({";
					$script .= "ampm: false";
					$script .= ",showHour: false";
					$script .= ",showMinute: false";
					$script .= ",showSecond: false";
					$script .= ",timeFormat: 'hh:mm:ss'";
					$script .= ",hourMin: 8";
					$script .= ",hourMax: 18";	
					$script .= ",minDate: new Date(2011, 10, 20, 8, 30)";
					$script .= ",maxDate: new Date(2011, 10, 31, 17, 30)";	
					$script .= "});";		
			}
			$script .= "</script>\n";
		}
		echo $script;
	}
	
}

?>