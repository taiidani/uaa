<?php
namespace RND\UAA\libs;

use FastRoute\Dispatcher;
use FastRoute\RouteCollector;

class Routes {

	const SEPARATOR = "::";

	public static function handle($uri) {
		$dispatcher = static::initDispatcher();
		$uri = static::process($uri);

		$routeInfo = $dispatcher->dispatch($_SERVER['REQUEST_METHOD'], $uri);

		switch ($routeInfo[0]) {
			case Dispatcher::NOT_FOUND:
				return static::display404();
				break;
			case Dispatcher::METHOD_NOT_ALLOWED:
				return static::display405();
				break;
			case Dispatcher::FOUND:
				$handler = explode(static::SEPARATOR, $routeInfo[1]);
				$className = $handler[0];
				$method = $handler[1];
				$vars = $routeInfo[2];
				
				$controller = array_slice(explode("\\", __NAMESPACE__), 0, 2);
				$controller = array_merge($controller, [ "controllers", $handler[0] ]);
				$controller = implode("\\", $controller);

				if(!class_exists($controller)) {
					print "!";
					return static::display404();
				} else {
					$cls = new $controller();
					return call_user_func_array([ $cls, $method ], $vars);
				}

				break;
		}
	}

	protected static function display404() {
		header("HTTP/1.0 404 Not Found");
		print "404 Not Found";
	}

	protected static function display405() {
		header("HTTP/1.0 405 Method Not Allowed");
		print "405 Method Not Allowed";
	}

	protected static function initDispatcher() {
		return \FastRoute\simpleDispatcher(function(RouteCollector $r) {
			$r->addRoute('GET', '', 'Main::index');
			$r->addRoute('GET', '/cs109', 'Cs109::index');
			$r->addRoute('GET', '/cs109/schedule', 'Cs109::schedule');
			$r->addRoute('GET', '/cs109/examples', 'Cs109::examples');
			$r->addRoute('GET', '/cs109/assignments[/{Assn}]', 'Cs109::assignments');
			$r->addRoute('GET', '/cs109/lectures/{Lecture}[/{Format}]', 'Cs109::lectures');

			$r->addRoute('GET', '/cs201', 'Cs201::index');
			$r->addRoute('GET', '/cs201/schedule', 'Cs201::schedule');
			$r->addRoute('GET', '/cs201/jobs', 'Cs201::jobs');
			$r->addRoute('GET', '/cs201/examples', 'Cs201::examples');
			$r->addRoute('GET', '/cs201/assignments[/{Assn}]', 'Cs201::assignments');
			$r->addRoute('GET', '/cs201/drills/{Num:\d+}', 'Cs201::drills');
			$r->addRoute('GET', '/cs201/lectures/{Lecture}[/{Format}]', 'Cs201::lectures');
		});
	}

	protected static function process($uri) {
		// Strip query string (?foo=bar) and decode URI
		if (false !== $pos = strpos($uri, '?')) {
			$uri = substr($uri, 0, $pos);
		}

		return rtrim(rawurldecode($uri), "/");
	}
}

