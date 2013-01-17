<?php

require_once dirname(__FILE__) . '/../../library/Log4PHP/Logger.php';

class Model_DataAdapter {

    private static $instance;
    //private static $driver = "host=192.168.2.2 port=5432 dbname=titania_test user=desarrollo password=perutest7";
	// private static $driver = "host=127.0.0.1 port=5432 dbname=titania_test user=desarrollo password=perutest7";
    private static $driver = "host=192.168.1.178 port=5432 dbname=titania_test user=desarrollo password=perutest7";
    // private static $driver = "host=192.168.2.38 port=5432 dbname=titania_test user=desarrollo password=desarrollo";
    // private static $driver = "host=190.81.63.199 port=5432 dbname=titania_test user=desarrollo password=perutest7";
    private $connection = null;
    private $logger = null;

    private function initDB() {
        $state = "Accediendo a la base de datos.";
        if ($this->connection == null) {
            try {
                $this->connection = pg_connect(self::$driver);
            } catch (Exception $e) {
                $this->logger->error("initDB", $e);
            }
        } else {
            $state = "No existe un conexion abierta.";
        }
        $this->logger->debug("initDB::" . $state);
    }

    public function __clone() {
        trigger_error("Error: No puedes clonar una instancia de " . get_class($this) . " class.", E_USER_ERROR);
    }

    public function __wakeup() {
        trigger_error("Error: No puedes deserializar una instancia de " . get_class($this) . " class.", E_USER_ERROR);
    }

    public function __construct() {
        date_default_timezone_set(DATE_ZONE);
        Logger::configure(LOG_ERROR);

        $this->logger = Logger::getLogger(__CLASS__);
        $this->logger->debug("Inicializando la base de datos.");
        $this->initDB();
    }

    public static function getInstance() {
        if (!self::$instance instanceof self) {
            self::$instance = new self;
        }
        return self::$instance;
    }

    public static function getDriver() {
        return self::$driver;
    }

    public static function setDriver($driver) {
        self::$driver = $driver;
    }

    public function getConnection() {
        return $this->connection;
    }

    public function setConnection($connection) {
        $this->connection = $connection;
    }

    public function executeRowsToJSON($procedure, $parameters) {
        $result = null;
        $rows = $this->ejec_store_procedura_sql($procedure, $parameters);

        if ($rows != null) {
            $result = json_encode($rows, JSON_HEX_TAG | JSON_HEX_APOS | JSON_HEX_QUOT | JSON_HEX_AMP);
        }

        return $result;
    }

    public function executeAssocQuery($function, $parameters = null) {
        $_rows = null;

        try {
            $_parameters = '';
            if (count($parameters) > 0) {
                $_parameters = implode("','", $parameters);
                $_parameters = "'" . $_parameters . "',";
            }

            $_query = "BEGIN; select " . $function . "(" . $_parameters . "'ref_cursor'); FETCH ALL IN ref_cursor;";
            $this->logger->info($_query);
            $result = pg_query($this->connection, $_query) or die(pg_last_error());

            if (!$result) {
                pg_query($this->connection, "ROLLBACK");
            } else {
                pg_query($this->connection, "COMMIT");
            }

            $_rowCount = pg_num_rows($result);
            $_rows = array();
            for ($i = 0; $i < $_rowCount; $i++) {
                $_row = pg_fetch_assoc($result, $i);
                $_rows[$i] = $_row; // json_encode($_row, JSON_HEX_TAG | JSON_HEX_APOS | JSON_HEX_QUOT | JSON_HEX_AMP | JSON_FORCE_OBJECT);
            }
        } catch (Exception $e) {
            $this->logger->error($e->getMessage());
        }

        return $_rows;
    }

    public function ejec_store_procedura_sql($function, $parameters = null) {
        $_rows = null;

        try {
            $_parameters = '';
            if (count($parameters) > 0) {
                $_parameters = implode("','", $parameters);
                $_parameters = "'" . $_parameters . "',";
            }

            $_query = "BEGIN; select " . $function . "(" . $_parameters . "'ref_cursor'); FETCH ALL IN ref_cursor;";
            $this->logger->info($_query);
            $result = pg_query($this->connection, $_query) or die(pg_last_error());

            if (!$result) {
                pg_query($this->connection, "ROLLBACK");
            } else {
                pg_query($this->connection, "COMMIT");
            }

            $_rowCount = pg_num_rows($result);
            $_rows = array();
            for ($i = 0; $i < $_rowCount; $i++) {
                $_row = pg_fetch_row($result, $i);
                for ($j = 0; $j < count($_row); $j++) {
                    $_rows[$i][$j] = $_row[$j] == null ? '' : $_row[$j]; // utf8_decode($_row[$j]);
                }
            }
        } catch (Exception $e) {
            $this->logger->error($e->getMessage());
        }

        return $_rows;
    }

    public function executeSelect($function, $parameters = null) {
        $_rows = null;

        try {
            $_parameters = '';
            if (count($parameters) > 0) {
                $_parameters = implode("','", $parameters);
                $_parameters = "'" . $_parameters . "',";
            }

            $_query = "select * from " . $function . "(" . $_parameters . ");";
            $this->logger->info($_query);
            $result = pg_query($this->connection, $_query) or die(pg_last_error());

            $_rowCount = pg_num_rows($result);
            $_rows = array();
            for ($i = 0; $i < $_rowCount; $i++) {
                $_row = pg_fetch_row($result, $i);
                for ($j = 0; $j < count($_row); $j++) {
                    $_rows[$i][$j] = $_row[$j] == null ? '' : $_row[$j]; // utf8_decode($_row[$j]);
                }
            }
        } catch (Exception $e) {
            $this->logger->error($e->getMessage());
        }

        return $_rows;
    }
    
    public function saveQuery($name, $function, $parameters = null) {
        $rows = $this->ejec_store_procedura_sql($function, $parameters);
        $dataSet = new Zend_Session_Namespace($name);
        $dataSet->data = $rows;
        return count($rows);
        // $dataSet->data = $this->executeAssocQuery($function, $parameters);
    }

    public function saveSelect($name, $function, $parameters = null) {
        $rows = $this->executeSelect($function, $parameters);
        $dataSet = new Zend_Session_Namespace($name);
        $dataSet->data = $rows;
        return count($rows);
        // $dataSet->data = $this->executeAssocQuery($function, $parameters);
    }
}