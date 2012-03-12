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
                $script .= "\t$('" . $valores[$i][0] . "')." . $valores[$i][2] . "('" . $valores[$i][1] . "');\n";
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
                $script .= "\t$('" . $valores[$i][0] . "')." . $valores[$i][1] . "(function(event){ " . $valores[$i][2] . " });\n";
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
                if ($valores[$i][1] == true) {
                    $script .= '$("' . $valores[$i][0] . '").attr(\'disabled\',\'\'); ';
                } else if ($valores[$i][1] == false) {
                    $script .= '$("' . $valores[$i][0] . '").attr(\'disabled\',\'disabled\'); ';
                }
            }
            $script .= ($this->script) ? "</script>\n" : "";
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
                    $script .= '$("' . $valores[$i][0] . '").attr(\'readonly\', true);';
                    $script .= '$("' . $valores[$i][0] . '").css(\'background-color\', \'#fffbc3\');';
                } else if ($valores[$i][1] == false) {
                    $script .= '$("' . $valores[$i][0] . '").attr(\'readonly\', false); ';
                }
            }
            $script .= ($this->script) ? "</script>\n" : "";
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
    public function ContenidoCombo($opciones, $valor_defecto) {
        $html = "";
        if (is_array($opciones)) {
            $opciones = array_values($opciones);
            $html .= "<option value=\"9999999999\">Seleccionar...</option>";
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

    /**
     * Ejecuta funciones JavaScript
     * Tiene como parametro un arreglo
     * 		Col 0 = Funcion
     * @param array $valores
     */
    public function EjecutarFuncion($valores) {
        $script = "Parametro invalido.";
        if (is_array($valores)) {
            $valores = array_values($valores);
            $script = ($this->script) ? "\n<script type='text/javascript'>\n" : "";
            $script .= "\n $(document).ready(function(){";
            for ($i = 0; $i < count($valores); $i++) {
                $script .= "\t" . $valores[$i][0] . "\n";
            }
            $script .= "});";
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
}