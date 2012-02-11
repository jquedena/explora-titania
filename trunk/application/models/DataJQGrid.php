<?php
require_once dirname(__FILE__).'/../../library/Log4PHP/Logger.php';

class Model_DataJQGrid {
    
    private $dataAdapter = null;
    private $logger = null;
    
    public function __construct() {
        date_default_timezone_set(DATE_ZONE);
        Logger::configure(LOG_ERROR);
        
        $this->logger = Logger::getLogger(__CLASS__);
    }
    
    public function registerQuery($name, $query) {
        
    }
    
    public function getDataTable($name, $page, $sidx, $sord) {
        
    }
}