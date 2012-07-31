<?php
require_once dirname(__FILE__).'/../../library/Log4PHP/Logger.php';

class Model_DataJQGrid {
    
    private $dataAdapter = null;
    private $logger = null;
   
    public function __construct() {
        date_default_timezone_set(DATE_ZONE);
        Logger::configure(LOG_ERROR);
        
        $this->dataAdapter = new Model_DataAdapter();
        $this->logger = Logger::getLogger(__CLASS__);
    }
    
    public function registerQuery($name, $query, $colsView) {
        $rows = $this->dataAdapter->executeQuery($query);
        
        $adapter->colsView = $colsView;
        $adapter->rows = $rows;
        
        $session = new Zend_Session_Namespace($name);
        $session->data = $adapter;
    }
    
    public function getDataTable($name, $page, $sidx, $sord, $limit) {

        $session = new Zend_Session_Namespace($name);        
        $rows = $session->data;
        
        $count = count($rows);
        if( $count >0 ) {
            $total_pages = ceil($count/$limit);
        } else {
            $total_pages = 0;
        }
        
        if ($page > $total_pages) $page = $total_pages;
        
        $start = $limit * $page - $limit; // do not put $limit*($page - 1)
        if ($start < 0) $start = 0;
        
        // $sidx = $_GET['sidx']; // get index row - i.e. user click to sort
        // $sord = $_GET['sord']; // get the direction
        // if(!$sidx) $sidx = 1;
        
        $responce->page = $page;
        $responce->total = $total_pages;
        $responce->records = $count;
        
        $i = 0;
        for($i = $start; $i < $count; $i++) {
            $row = $rows[$i];
            $responce->rows[$i]['id'] = $i;
            $responce->rows[$i]['cell'] = $row; //  array($row['idrowst'], $row['idrol'], $row['vnameid'], $row['ctipobj']);
        }        

        return json_encode($responce, JSON_HEX_TAG | JSON_HEX_APOS | JSON_HEX_QUOT | JSON_HEX_AMP);
    }
}