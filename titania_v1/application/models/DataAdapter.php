<?php
require_once dirname(__FILE__).'/../../library/Log4PHP/Logger.php';

class Model_DataAdapter {

    private static $instance;

    //private static $driver = "mysql:host=localhost;dbname=istebpe_notas";
    private static $driver = "host=127.0.0.1 port=5432 dbname=postgres user=postgres password=123456";
    private $connection = null;
    private $logger = null;
    
    private function initDB() {
        if ($this->connection == null) {
            # echo "<!-- {ISTEBP}Info: Accediendo a la base de datos -->";
            # echo "<!-- {ISTEBP}Info: Driver ".self::$driver." -->";
            # echo "<!-- {ISTEBP}Info: User ".self::$user." -->";
            # echo "<!-- {ISTEBP}Info: Password ".self::$password." -->";
            //$this->connection = new PDO(self::$driver, self::$user, self::$password);
            $this->connection = pg_connect(self::$driver);
            $this->logger->info("Accediendo a la base de datos...");
        } else {
            $this->logger->info("Error al acceder a la base de datos...");
        }
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
        $this->logger->info("Construyendo objeto.");
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
    public function execute($procedure, $parameters = null, $type = PDO::FETCH_NUM) {
        try {
            $lparameters = "";
            $count = count($parameters);
            if ($count) {
                $lparameters = str_repeat("?, ", $count);
                $lparameters = substr(trim($lparameters), 0, -1);
            }
            $stm = $this->connection->prepare("call $procedure($lparameters)");
            $this->logger->info("call $procedure($lparameters)");
            if ($count) {
                for ($index = 0; $index < count($parameters); $index++) {
                    $stm->bindValue($index + 1, $parameters[$index]);
                }
            }
            $stm->execute();
            
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
    
    public function ejec_store_procedura_sql($func, $parameters = null) {
    	    	
        try {        	
        	$caddatos = '';
				if(count($parameters)>0){
					for($i=0;$i<count($parameters);$i++){
						$caddatos.= "'".$parameters[$i]."',";
					}
					//$caddatos = substr($caddatos,0,strlen($caddatos)-1);
				}

	     $qry = "BEGIN; select ".$func."(".$caddatos."'ref_cursor'); FETCH ALL IN ref_cursor; ";
			//echo '<textarea>'.$qry.'</textarea><br>';
	     $result = pg_query ($this->connection, $qry) or die(pg_last_error());
	     
        	if (!$result) { 
			    pg_query($this->connection, "ROLLBACK"); 
			} else { 
			    pg_query($this->connection, "COMMIT"); 
			}
				     
	     $num = pg_num_rows($result);
	     $array = array();
	     for ($i=0; $i < $num; $i++) {
	       $r = pg_fetch_row($result, $i);
	       		for ($j=0; $j <count($r); $j++){
	       			$array[$i][$j] = utf8_decode($r[$j]);
	       		}
	    }
	    return $array;	
        
            
        } catch (Exception $e) {
            $this->logger->error($e->getMessage());
            return null;
        }
    }
    
}
