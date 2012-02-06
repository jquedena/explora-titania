<?php
require_once dirname(__FILE__).'/../Log4PHP/Logger.php';

class Libreria_Log4 {

    private static $instance = null;
    private $logger = null;

    public function __construct() {
        date_default_timezone_set("America/Lima");
        Logger::configure(APPLICATION_PATH.'/../public/properties/appender_dailyfile.properties');
        $this->logger = Logger::getRootLogger();
    }
    
    public static function getInstance() {
        if(self::$instance == null) {
            self::$instance = new Libreria_Log4();
        }
        return self::$instance;
    }
    public function getLogger() {
        return $this->logger;
    }

    public function info($mensaje) {
        $this->getInstance()->getLogger()->info($mensaje);
    }
    
    public function error($mensaje) {
        $this->getInstance()->getLogger()->error($mensaje);
    }
}
