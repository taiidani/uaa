<?php
namespace RND\UAA\libs;

class Controller {

	protected $view;

	public function __construct() {
		$this->view = new ViewBag();
	}

	protected function render($file) {
		View::render($file, $this->view);
	}
}

