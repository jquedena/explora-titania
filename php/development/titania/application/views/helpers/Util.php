<?php

class Zend_View_Helper_Util extends Zend_View_Helper_Abstract {
	
	private $widthLayout = 1200;

    public function util() {
        return $this;
    }

    public function getTitle() {
        return "Titania - Municipalidad de Puente Piedra";
    }
    
    public function getEntidad() {
    	return "Municipalidad de Puente Piedra";
    }
    
    public function getRUC() {
    	return "10425526176";
    }
    
    public function getAreaCobranza() {
    	return "Sub Gerencia de Tesoreria";
    }
    
    public function getProtocol() {
        return "http://";
    }
    
    public function getPath() {
        $path = explode("/index.php", $_SERVER["PHP_SELF"]);
        return $this->getProtocol() . $_SERVER["HTTP_HOST"] . $path[0] . "/" . PATH;
    }

    public function getPath2() {
        $path = explode("/index.php", $_SERVER["PHP_SELF"]);
        return $this->getProtocol() . $_SERVER["HTTP_HOST"] . $path[0] . "/";
    }
    
	public function getPathReport() {
		return $this->getProtocol() . $_SERVER["HTTP_HOST"] . ':8084/titania/index.jsp?';
	}
    
    public function getLink($url) {
        return $this->getPath2() . "index.php/" . $url;
    }
    
    public function getImage($image) {
        return $this->getPath() . "img/$image";
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
        $action = $request->getActionName();
        $script = "\t\t<script type='text/javascript' src='".$this->getPath()."js/js_".$controller.".js'/></script>\n";
        $session = new Zend_Session_Namespace("scriptController");
        $session->data = $script;
        return $script;
    }
    
    public function registerScriptJSControllerAction(Zend_Controller_Request_Abstract $request) {
    	$controller = $request->getControllerName();
    	$action = $request->getActionName();
    	$script = "\t\t<script type='text/javascript' src='".$this->getPath()."js/js_".$controller."_".$action.".js'/></script>\n";
    	$session = new Zend_Session_Namespace("scriptControllerAction");
    	$session->data = $script;
    	return $script;
    }

    public function registerLeaveControllerAction(Zend_Controller_Request_Abstract $request) {
    	$controller = $request->getControllerName();
    	$action = $request->getActionName();
    	$script  = "\t\t<script type='text/javascript'/>var __rw = ".'false'.";</script>\n";
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
