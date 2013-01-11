<?php

class Zend_View_Helper_Util extends Zend_View_Helper_Abstract {

    private $widthLayout = 1030;
    private $heightLayout = 480;

    public function util() {
        return $this;
    }

    public function getTheme() {
    	return "green_explora";
    }
    
    public function getTitle() {
        return "Titania - Municipalidad de Puente Piedra";
    }

    public function getEntidad() {
        return "Municipalidad de Puente Piedra";
    }

    public function getRUC() {
        return "20131366702";
    }

    public function getAreaCobranza() {
        return "Sub Gerencia de Tesoreria";
    }

    public function getProtocol() {
        return "http://";
    }

    public function getHost() {
        // return str_replace(":" . $_SERVER["SERVER_PORT"], "", $_SERVER["HTTP_HOST"]);
    	return $_SERVER["HTTP_HOST"];
    }

    public function getPath() {
        $path = explode("/index.php", $_SERVER["PHP_SELF"]);
        return $this->getProtocol() . $this->getHost() . $path[0] . "/" . PATH;
    }

    public function getPath2() {
        $path = explode("/index.php", $_SERVER["PHP_SELF"]);
        return $this->getProtocol() . $this->getHost() . $path[0] . "/";
    }

    public function getPathReport() {
        return $this->getProtocol() . $this->getHost() . '/titania_report/index.jsp?';
    }

    public function getLink($url) {
        return $this->getPath2() . "index.php/" . $url;
    }

    public function getImage($image) {
        return $this->getPath() . "img/$image";
    }

    public function getPhoto($image) {
    	$file = $_SERVER['DOCUMENT_ROOT']."/titania/public/fotos/".$image.".png";
    	if(file_exists($file)) {
    		$file = $this->getPath() . "fotos/$image.png";
    	} else {
    		$file = $this->getPath() . "fotos/0000000000.png";
    	}
    	return $file;
    }
    
    public function getScript($pathJS) {
        $script = "\n";
        $files = $this->readFile($pathJS, $this->getPath());
        foreach ($files as $value) {
            if (!is_array($value)) {
                $script .= "\t\t<script type='text/javascript' src='$value'></script>\n";
            }
        }
        return $script;
    }

    public function registerScriptJSController(Zend_Controller_Request_Abstract $request) {
        $controller = $request->getControllerName();
        $script = "\t\t<script type='text/javascript' src='" . $this->getPath() . "js/js_" . $controller . ".js'/></script>\n";
        $session = new Zend_Session_Namespace("scriptController");
        $session->data = $script;
        return $script;
    }

    public function registerScriptJSControllerAction(Zend_Controller_Request_Abstract $request) {
        $controller = $request->getControllerName();
        $action = $request->getActionName();
        $script = "\t\t<script type='text/javascript' src='" . $this->getPath() . "js/js_" . $controller . "_" . $action . ".js'/></script>\n";
        $session = new Zend_Session_Namespace("scriptControllerAction");
        $session->data = $script;
        return $script;
    }

    public function registerLeaveControllerAction(Zend_Controller_Request_Abstract $request) {
        $controller = $request->getControllerName();
        $action = $request->getActionName();
        $script = "\t\t<script type='text/javascript'/>var __rw = " . 'false' . ";</script>\n";
        $session = new Zend_Session_Namespace("leave");
        $session->data = $script;
        return $script;
    }

    public function getScriptJSController() {
        $session = new Zend_Session_Namespace("scriptController");
        $script = $session->data;
        $session->data = "";
        return $script;
    }

    public function getScriptJSControllerAction() {
        $session = new Zend_Session_Namespace("scriptControllerAction");
        $script = $session->data;
        $session->data = "";
        return $script;
    }

    public function getScriptLeave() {
        $session = new Zend_Session_Namespace("leave");
        $script = $session->data;
        $session->data = "";
        return $script;
    }

    public function getStyle() {
        $files = $this->readFile("css", $this->getPath());
        $script = $this->style($files);
        return $script;
    }

    public function getWidthLayout() {
        return $this->widthLayout . "px";
    }

    public function getSubstractWidthLayout($size) {
        return ($this->widthLayout - $size) . "px";
    }

    public function getHeightLayout() {
        return $this->heightLayout;
    }

    public function getSubstractHeightLayout($size) {
        return ($this->heightLayout - $size) . "px";
    }

    public function getNow() {
        return date("Y-m-d H:i:s");
    }
    
    public function getPeriodos() {
        $result = "<select id='cboPeriodo' style='width: 60px;'>";
        $year = (int) date("Y");
        for($i = $year; $i >= 1996; $i--) {
            $result .= "\n\t<option value='$i'>$i</option>";
        }
        $result .= "\n</select>";
        
        return $result;
    }

    public function getPeriodosDeclarado($mhresum, $selected) {
    	$parameters[] = $mhresum;
    	$dataAdapter = new Model_DataAdapter();
    	$rows = $dataAdapter->ejec_store_procedura_sql("pl_function.listar_periodo", $parameters);
    	$result = "<select id='cboPeriodo' style='width: 60px;'>";
    	if(count($rows) > 0) {
	    	foreach($rows as $k => $v) {
	    		if ($v[0] == $selected) {
	    			$result .= "<option value=\"" . $v[0] . "\" selected=\"selected\">" . $v[0] . "</option>";
	    		} else {
	    			$result .= "<option value=\"" . $v[0] . "\">" . $v[0] . "</option>";
	    		}
	    	}
    	}
    	$result .= "\n</select>";
    
    	return $result;
    }
    
    public function getComboContenedor($idsigma, $selected) {
        $procedure = 'public.obtener_tabla';
        $parameters[0] = $idsigma;
        $dataAdapter = new Model_DataAdapter();
        $records = $dataAdapter->ejec_store_procedura_sql($procedure, $parameters);
        
        $library = new Libreria_Pintar();
        $html = $library->ContenidoCombo($records, $selected);
        
        return $html;
    }
    
    private function style($files) {
        $script = "\n";
        foreach ($files as $value) {
            if (!is_array($value)) {
                $ext = explode(".", $value);
                if (strtolower($ext[count($ext) - 1]) == 'css') {
                    $script .= "\t<link href='$value' rel=\"stylesheet\" type=\"text/css\"/>\n";
                }
            } else {
                $script .= $this->style($value);
            }
        }
        return $script;
    }

    private function readFile($carpeta, $path) {
        $script = array();
        if (is_dir(PATH . $carpeta)) {
            if (($_carpeta = opendir(PATH . $carpeta))) {
                while (($archivo = readdir($_carpeta)) !== false) {
                    if (is_dir(PATH . $carpeta . "/" . $archivo) && $archivo != "." && $archivo != "..") {
                        $script[] = $this->readFile($carpeta . "/" . $archivo, $path);
                    } else {
                        if ($archivo != "." && $archivo != "..") {
                            $script[] = $path . $carpeta . "/" . $archivo;
                        }
                    }
                }
                closedir($_carpeta);
            }
        }

        sort($script);
        return $script;
    }

}
