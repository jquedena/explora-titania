<?php

class Zend_View_Helper_Util extends Zend_View_Helper_Abstract {

    public function util() {
        return $this;
    }

    public function getTitle() {
        return "Municipalidad de Puente Piedra";
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
        $script = "\t\t<script type='text/javascript' src='".$this->getPath()."js/js_".$controller."_".$action.".js'/></script>\n";
        $session = new Zend_Session_Namespace("script");
        $session->data = $script;
        return $script;
    }
    
    public function getScriptJSController() {
        $session = new Zend_Session_Namespace("script");
        $script = $session->data;
        $session->data = "";
        return $script;
    }
    
    public function getStyle() {
        $files = $this->readFile("css", $this->getPath());
        $script = $this->style($files);
        return $script;
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