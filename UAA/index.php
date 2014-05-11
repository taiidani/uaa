<?php

//Controller logic
require('NiceDog.php');

define("FCPATH", __dir__);

//Set up routes
$routes = array();

array_push($routes, R('')->controller('main')->action('index')->on('GET'));
array_push($routes, R('cs109')->controller('cs109')->action('index')->on('GET'));
array_push($routes, R('cs109/schedule')->controller('cs109')->action('schedule')->on('GET'));
array_push($routes, R('cs109/examples')->controller('cs109')->action('examples')->on('GET'));
array_push($routes, R('cs109/assignments/?(?P<Assn>.*)')->controller('cs109')->action('assignments')->on('GET'));
array_push($routes, R('cs109/lectures/(?P<Lecture>[^/]+)/(?P<Format>.*)')->controller('cs109')->action('lectures')->on('GET'));

array_push($routes, R('cs201')->controller('cs201')->action('index')->on('GET'));
array_push($routes, R('cs201/schedule')->controller('cs201')->action('schedule')->on('GET'));
array_push($routes, R('cs201/jobs')->controller('cs201')->action('jobs')->on('GET'));
array_push($routes, R('cs201/examples')->controller('cs201')->action('examples')->on('GET'));
array_push($routes, R('cs201/assignments/?(?P<Assn>.*)')->controller('cs201')->action('assignments')->on('GET'));
array_push($routes, R('cs201/drills/(?P<Num>\d+)')->controller('cs201')->action('drills')->on('GET'));
array_push($routes, R('cs201/lectures/(?P<Lecture>[^/]+)/?')->controller('cs201')->action('lectures')->on('GET'));
array_push($routes, R('cs201/lectures/(?P<Lecture>[^/]+)/(?P<Format>.*)')->controller('cs201')->action('lectures')->on('GET'));


foreach($routes as $route) {
	require_once('controllers/' . ucwords($route->controller) . ".php");
}

run();

?>