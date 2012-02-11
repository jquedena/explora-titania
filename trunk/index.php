<?php

// Define date default timezone
defined('DATE_ZONE')
    || define('DATE_ZONE', 'America/Lima');

// Define path to public
defined('PATH')
    || define('PATH', 'public/');

// Define path to application directory
defined('APPLICATION_PATH')
    || define('APPLICATION_PATH', realpath(dirname(__FILE__) . '/application'));

// Define application environment
defined('APPLICATION_ENV')
    || define('APPLICATION_ENV', (getenv('APPLICATION_ENV') ? getenv('APPLICATION_ENV') : 'development'));

// Define log access
defined('LOG_ACCESS')
    || define('LOG_ACCESS', APPLICATION_PATH.'/../public/properties/access_daily.properties');

// Define log error
defined('LOG_ERROR')
    || define('LOG_ERROR', APPLICATION_PATH.'/../public/properties/error_daily.properties');

// Ensure library/ is on include_path
set_include_path(implode(PATH_SEPARATOR, array(
    realpath(APPLICATION_PATH . '/library'),
    get_include_path(),
)));

/** Zend_Application */
require_once 'Zend/Application.php';

// Create application, bootstrap, and run
$application = new Zend_Application(
    APPLICATION_ENV,
    APPLICATION_PATH . '/configs/application.ini'
);
$application->bootstrap()
            ->run();