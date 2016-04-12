<?php

require_once(__DIR__ . "/vendor/autoload.php");

spl_autoload_register(function($className) {
	$className = explode("\\", $className);

	//Strip out the vendor prefix
	array_shift($className);
	array_shift($className);

	$path = __DIR__ . DIRECTORY_SEPARATOR . implode(DIRECTORY_SEPARATOR, $className) . ".php";
	if(file_exists($path)) {
		include($path);
	}
});