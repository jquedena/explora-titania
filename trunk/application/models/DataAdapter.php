<?php
require_once dirname(__FILE__).'/../../library/Log4PHP/Logger.php';

class Model_DataAdapter {

    private static $instance;
    private static $driver = "mysql:host=localhost;dbname=istebpe_notas";
    private static $user = "root";
    private static $password = "admin";
    private $connection = null;
    private $logger = null;
    
    private function initDB() {
        if ($this->connection == null) {
            # echo "<!-- {ISTEBP}Info: Accediendo a la base de datos -->";
            # echo "<!-- {ISTEBP}Info: Driver ".self::$driver." -->";
            # echo "<!-- {ISTEBP}Info: User ".self::$user." -->";
            # echo "<!-- {ISTEBP}Info: Password ".self::$password." -->";
            $this->connection = new PDO(self::$driver, self::$user, self::$password);
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
        date_default_timezone_set("America/Lima");
        Logger::configure(APPLICATION_PATH.'/../public/properties/error_daily.properties');
        
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
        } catch (PDOException $e) {
            $this->logger->error($e->getMessage());
            return null;
        }
    }

    public function executeToJSON($procedure, $parameters) {
        $rows = $this->execute($procedure, $parameters, PDO::FETCH_ASSOC);
        return json_encode($rows, JSON_HEX_TAG | JSON_HEX_APOS | JSON_HEX_QUOT | JSON_HEX_AMP);
    }

    public function executeQueryToJSON($query) {
        $rows = $this->executeQuery($query, PDO::FETCH_ASSOC);
        
        $page = 1; //$_GET['page']; // get the requested page
        $limit = 5; // $_GET['rows']; // get how many rows we want to have into the grid
        // $sidx = $_GET['sidx']; // get index row - i.e. user click to sort
        // $sord = $_GET['sord']; // get the direction
        // if(!$sidx) $sidx =1;

        $count = count($rows);
        if( $count >0 ) {
                $total_pages = ceil($count/$limit);
        } else {
                $total_pages = 0;
        }
        
        if ($page > $total_pages) $page = $total_pages;
        $start = $limit * $page - $limit; // do not put $limit*($page - 1)

        $responce->page = $page;
        $responce->total = $total_pages;
        $responce->records = $count;
        $i = 0;
        foreach($rows as $row) {
            $responce->rows[$i]['id']=$row['idrowst'];
            $responce->rows[$i]['cell']=array($row['idrowst'], $row['idrol'], $row['vnameid'], $row['ctipobj']);
            $i++;
        }        

        return json_encode($responce, JSON_HEX_TAG | JSON_HEX_APOS | JSON_HEX_QUOT | JSON_HEX_AMP);
    }
}

