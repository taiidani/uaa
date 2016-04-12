<?php
namespace RND\UAA\controllers;

class Main extends \RND\UAA\libs\Controller {

	public function index() {
		print $this->render('index');
	}
}

?>