<?php
require_once dirname(__FILE__).'/../../library/Log4PHP/Logger.php';

class Model_DataGeneric {

	const PROCEDURE_POSTGRES = 1;
	const PROCEDURE_ORACLE = 2;
	const PROCEDURE_MYSQL = 3;
    private static $instance;

    // private static $driver = "mysql:host=localhost;dbname=istebpe_notas";
    // private static $driver = "host=127.0.0.1 port=5432 dbname=desarrollo user=postgres password=1";
    private static $driver = "pgsql:host=localhost;port=5432;dbname=desarrollo";
    private static $user = "postgres";
    private static $password = "1";
    private $connection = null;
    private $logger = null;
    
    private function info($message){
    	if($this->logger->isInfoEnabled()) {
    		$this->logger->info($message);
    	}
    }
    
    private function initDB() {
    	$state = "Accediendo a la base de datos.";
        if ($this->connection == null) {
        	try {
        		// $this->connection = pg_connect(self::$driver);
        		// pg_set_client_encoding($this->connection, "Latin1");
        		$this->connection = new PDO(self::$driver, self::$user, self::$password);
        	}
        	catch (PDOException $e) {
        		$this->logger->error("initDB", $e);
        	}
        } else {
        	$state = "No existe un conexion abierta.";            
        }
        $this->info("initDB::".$state);
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
        $this->info("Inicializando la base de datos.");
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

    public static function getUser() {
        return self::$user;
    }

    public static function setUser($user) {
        self::$user = $user;
    }

    public static function getPassword() {
        return self::$password;
    }

    public static function setPassword($password) {
        self::$password = $password;
    }

    public function getConnection() {
        return $this->connection;
    }

    public function setConnection($connection) {
        $this->connection = $connection;
    }

    /**
     *
     * @param type $query
     * @param type $type
     * @return type 
     */
    public function executeQuery($query, $type = PDO::FETCH_NUM) {
        try {
            $stm = $this->connection->query($query);
            $this->logger->info($query);
            return $stm->fetchAll($type);
            
        } catch (PDOException $e) {
            $this->logger->error($e->getMessage());
            return null;
        }
    }
    
    /**
     *
     * @param type $procedure
     * @param type $parameters
     * @param type $type
     * @return type $array 
     */
    public function execute($procedure, $parameters = null, $type = PDO::FETCH_NUM, $type_procedure = Model_DataAdapter::PROCEDURE_POSTGRES ) {
        try {
            $lparameters = "";
            $count = count($parameters);
            $query = "";
            $bind_action = false;
            
            switch($type_procedure) {
            	case Model_DataAdapter::PROCEDURE_POSTGRES:
            		$lparameters = implode("','", $parameters);
            		$lparameters = "'" . $lparameters . "',";
            		$query = "BEGIN; select " . $procedure . "(". $lparameters . "'ref_cursor'); FETCH ALL IN ref_cursor; ";
            		break;
            	case Model_DataAdapter::PROCEDURE_ORACLE:
            		return null;
            		break;
            	case Model_DataAdapter::PROCEDURE_MYSQL:
            		if ($count) {
            			$lparameters = str_repeat("?, ", $count);
            			$lparameters = substr(trim($lparameters), 0, -1);
            		}
            				
            		$query = "call $procedure($lparameters)";
            		$bind_action = true;
            		break;
            	default:
            		$query = $procedure;
            		break;
            }
            
            $this->info("execute::" . $query);
            
            if ($count && $bind_action) {
            	$this->info("execute::prepare");
            	$stm = $this->connection->prepare($query);
            	
                for ($index = 0; $index < count($parameters); $index++) {
                    $stm->bindValue($index + 1, $parameters[$index]);
                }
                
                $stm->execute();
            }
            
            if ($count && !$bind_action) {
            	$this->info("execute::query");
            	$stm = $this->connection->query($query);
            }
            
            return $stm->fetchAll($type);
            
        } catch (Exception $e) {
            $this->logger->error($e->getMessage());
            return null;
        }
    }

    public function executeRowsToJSON($procedure, $parameters) {
        $rows = $this->execute($procedure, $parameters, PDO::FETCH_ASSOC);
        return json_encode($rows, JSON_HEX_TAG | JSON_HEX_APOS | JSON_HEX_QUOT | JSON_HEX_AMP);
    }

    public function executeQueryRowsToJSON($query) {
        $rows = $this->executeQuery($query, PDO::FETCH_ASSOC);
        return json_encode($rows, JSON_HEX_TAG | JSON_HEX_APOS | JSON_HEX_QUOT | JSON_HEX_AMP);
    }
    
    public function ejec_store_procedura_sql($function, $parameters = null) {
    	$_rows = $this->execute($function, $parameters);
    	print_r($_rows);
    	return $_rows;
    	/*$_rows = null;
    	
    	try {
    		$_parameters = '';
    		if(count($parameters) > 0){
    			for($i = 0; $i < count($parameters); $i++){
    				$_parameters .= "'" . $parameters[$i] . "',";
    			}
    		}
    	
    		$_query = "BEGIN; select " . $function . "(". $_parameters . "'ref_cursor'); FETCH ALL IN ref_cursor; ";
    		$this->logger->error($_query);
    		$result = pg_query ($this->connection, $qry) or die(pg_last_error());
    	
    		if (!$result) {
    			pg_query($this->connection, "ROLLBACK");
    		} else {
    			pg_query($this->connection, "COMMIT");
    		}
    	
    		$_rowCount = pg_num_rows($result);
    		$_rows = array();
    		for ($i=0; $i < $_rowCount; $i++) {
    			$_row = pg_fetch_row($result, $i);
    			for ($j=0; $j <count($r); $j++){
    				$_rows[$i][$j] = utf8_decode($_row[$j]);
    			}
    		}
    	} catch (Exception $e) {
    		$this->logger->error($e->getMessage());
    	}
    	
    	return $_rows;*/
    }
}

