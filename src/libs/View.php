<?php
namespace RND\UAA\libs;

class View {

	public static function render($file, ViewBag $params) {
        $loader = new \Twig_Loader_Filesystem(__DIR__ . '/../views');
        $twig = new \Twig_Environment($loader, array(
            //'cache' => 'cache',
        ));

        print $twig->render($file . ".twig", get_object_vars($params));
	}
}

