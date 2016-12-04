<?php
namespace RND\UAA;

require_once(__DIR__ . "/../vendor/autoload.php");

//Configure Sentry
if(getenv("SENTRY_DSN")) {
	$error_handler = new \Raven_ErrorHandler(new \Raven_Client(getenv("SENTRY_DSN")));
	$error_handler->registerExceptionHandler();
	$error_handler->registerErrorHandler();
	$error_handler->registerShutdownFunction();
}

define("FCPATH", __dir__);
libs\Routes::handle($_SERVER['REQUEST_URI']);
