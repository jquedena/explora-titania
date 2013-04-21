<?php

class Libreria_Pintar {

    var $script = true;

    public function IniciaScript() {
        echo "<script type='text/javascript'>";
        $this->script = false;
    }

    public function FinScript() {
        echo "</script>";
        $this->script = true;
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
        $script = "Parametro invalido.";

        if (is_array($valores)) {
            $valores = array_values($valores);
            $script = ($this->script) ? "\n<script type='text/javascript'>\n" : "";
            for ($i = 0; $i < count($valores); $i++) {
                $valores[$i][1] = str_replace("'", "\'", $valores[$i][1]);
                $script .= "\t$('#" . $valores[$i][0] . "')." . $valores[$i][2] . "('" . $valores[$i][1] . "');\n";
            }
            $script .= ($this->script) ? "</script>\n" : "";
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
        $script = "Parametro invalido.";

        if (is_array($valores)) {
            $valores = array_values($valores);
            $script = ($this->script) ? "\n<script type='text/javascript'>\n" : "";
            for ($i = 0; $i < count($valores); $i++) {
                $script .= "\t$('#" . $valores[$i][0] . "')." . $valores[$i][1] . "(function(event){ " . $valores[$i][2] . " });\n";
            }
            $script .= ($this->script) ? "</script>\n" : "";
        }

        echo $script;
    }

    /**
     * Habilita o deshabilita los componentes
     * tiene como parametro un arreglo que tiene
     * la siguiente estructura
     * 		Col 0 = Id del Objecto
     * 		Col 1 = Valor ( true, false )
     * @param array $valores
     */
    public function HabilitarComponente($valores) {
        $script = "Parametro invalido.";
        if (is_array($valores)) {
            $valores = array_values($valores);
            $script = ($this->script) ? "\n<script type='text/javascript'>\n" : "";
            for ($i = 0; $i < count($valores); $i++) {
            	$script .= "\n\tdeshabilitarComponente('".$valores[$i][0]."', ".( strlen($valores[$i][1])==0 ? "''" : $valores[$i][1] ).");";
            }
            $script .= ($this->script) ? "\n</script>\n" : "";
        }

        echo $script;
    }

    /**
     * Componentes de solo lectura tiene como 
     * parametro un arreglo que tiene la siguiente estructura
     * 		Col 0 = Id del Objecto
     * 		Col 1 = Valor ( true, false )
     * @param array $valores
     */
    public function ComponenteSoloLectura($valores) {
        $script = "Parametro invalido.";
        if (is_array($valores)) {
            $valores = array_values($valores);
            $script = ($this->script) ? "\n<script type='text/javascript'>\n" : "";
            for ($i = 0; $i < count($valores); $i++) {
                if ($valores[$i][1] == true) {
                    $script .= "\n\t$('#" . $valores[$i][0] . "').attr('readonly', true);";
                    $script .= "\n\t$('#" . $valores[$i][0] . "').toggleClass('ui-disabled-text');";
                } else if ($valores[$i][1] == false) {
                    $script .= "\n\t$('#" . $valores[$i][0] . "').attr('readonly', false);";
                }
            }
            $script .= ($this->script) ? "\n</script>\n" : "";
        }

        echo $script;
    }

    /**
     * Agrega un atributo al componente
     * Tiene como parametro un arreglo 
     * que tiene la siguiente estructura
     * 		Col 0 = Id del Objecto
     * 		Col 1 = Atributo
     * 		Col 2 = Valor
     * @param array $valores
     */
    public function AtributoComponente($valores) {
        $script = "Parametro invalido.";

        if (is_array($valores)) {
            $valores = array_values($valores);
            $script = ($this->script) ? "\n<script type='text/javascript'>\n" : "";
            for ($i = 0; $i < count($valores); $i++) {
                $script .= '$("' . $valores[$i][0] . '").attr(\'' . $valores[$i][1] . '\', \'' . $valores[$i][2] . '\');';
            }
            $script .= ($this->script) ? "</script>\n" : "";
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
    public function ContenidoCombo($opciones, $valor_defecto,$help='1') {
        $html = "";
        if (is_array($opciones)) {
            $opciones = array_values($opciones);
           if($help=='1')$html .= "<option value=\"9999999999\">SELECCIONE</option>";
            for ($i = 0; $i < count($opciones); $i++) {
                if ($opciones[$i][0] == $valor_defecto) {
                    $html .= "<option value=\"" . $opciones[$i][0] . "\" selected=\"selected\">" . $opciones[$i][1] . "</option>";
                } else {
                    $html .= "<option value=\"" . $opciones[$i][0] . "\">" . $opciones[$i][1] . "</option>";
                }
            }
        } else {
            $html = "<option value='-1'>Parametros Invalidos</option>";
        }
        return $html;
    }

    public function ContenidoComboOtro($opciones, $valor_defecto) {
    	$html = "";
    	if (is_array($opciones)) {
    		$opciones = array_values($opciones);
    		$html .= "<option value=\"9999999999\">SELECCIONE</option>";
    		for ($i = 0; $i < count($opciones); $i++) {
    			if ($opciones[$i][2] == $valor_defecto) {
    				$html .= "<option data-idsigma=\"".$opciones[$i][2]."\" value=\"" . $opciones[$i][0] . "\" selected=\"selected\">" . $opciones[$i][1] . "</option>";
    			} else {
    				$html .= "<option data-idsigma=\"".$opciones[$i][2]."\" value=\"" . $opciones[$i][0] . "\">" . $opciones[$i][1] . "</option>";
    			}
    		}
    	} else {
    		$html = "<option value='-1'>Parametros Invalidos</option>";
    	}
    	return $html;
    }
    
    /**
     * Ejecuta funciones JavaScript
     * Tiene como parametro un arreglo
     * 		Col 0 = Funcion
     * @param array $valores
     */
    public function EjecutarFuncion($valores, $type="document") {
        $script = "// Parametro invalido.";
        if (is_array($valores)) {
            $valores = array_values($valores);
            $script = ($this->script) ? "\n<script type='text/javascript'>\n" : "";
            if($type == "document") {
            	$script .= "\n\t$(document).ready(function(){\n";
            } else {
            	$script .= "\n\t$(function(){\n";
            }
            for ($i = 0; $i < count($valores); $i++) {
                $script .= "\t\t" . $valores[$i][0] . "\n";
            }
            $script .= "\t});\n";
            $script .= ($this->script) ? "</script>\n" : "";
        }
        echo $script;
    }

    /**
     * Pinta variable
     * 		Col 0 = Nombre Variable
     * 		Col 1 = Valor
     * @param array $valores
     */
    public function PintarVariable($valores) {
        $script = "Parametro invalido.";

        if (is_array($valores)) {
            $valores = array_values($valores);
            $script = ($this->script) ? "\n<script type='text/javascript'>\n" : "";
            for ($i = 0; $i < count($valores); $i++) {
                $script .= "var " . $valores[$i][0] . "=" . $valores[$i][1] . ";\n";
            }
            $script .= ($this->script) ? "</script>\n" : "";
        }
        
        echo $script;
    }
    
    /**
     * Componentes con mascara numerica
     * 		Col 0 = Id del Objecto
     * @param array $valores
     */
    public function CampoDinero($valores) {
    	$script = "Parametro invalido Dinero.";
    	if(is_array($valores)){
    		$valores = array_values($valores);
    		$script = ($this->script) ? "\n<script type='text/javascript'>\n" : "";
    		$script .= "jQuery(function($) {\n";
    		for($i = 0; $i < count($valores); $i++) {
    			$script .= '$("#'.$valores[$i][0].'").autoNumeric(); ';
    		}
    		$script .= "});\n";
    		$script .= ($this->script) ? "</script>\n" : "";
    
    	}
    	echo $script;
    }

    /**
     * Ordena el array bidimensional segun el campo especificado, ejemplo
     * $array_ordenadito2 = $this->ordenar_array($array_a_ordenar, 'campo3', SORT_DESC, 'campo2', SORT_DESC, 'campo1', SORT_ASC ) or die('<br>ERROR!<br>');
     * print_r($array_ordenadito2);
     * @param array $array_a_ordenar
     * return
     **/
    public function ordenar_array() {
    	$n_parametros = func_num_args(); // Obenemos el numero de parametros
    	if ($n_parametros<3 || $n_parametros%2!=1) { // Si tenemos el numero de parametro mal...
    		return false;
    	} else { // Hasta aqui todo correcto...veamos si los parametros tienen lo que debe ser...
    		$arg_list = func_get_args();
    
    		if (!(is_array($arg_list[0]) && is_array(current($arg_list[0])))) {
    			return false; // Si el primero no es un array...MALO!
    		}
    
    		for ($i = 1; $i<$n_parametros; $i++) { // Miramos que el resto de parametros tb estan bien...
    			if ($i%2!=0) {// Parametro impar...tiene que ser un campo del array...
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
    
    		// Una vez los parametros se que estan bien, proceder? a ordenar...
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
    		// La verdad es que es mas complicado de lo que creia en principio... :)
    		eval($a_evaluar);
    		return $array_salida;
    	}
    }
}