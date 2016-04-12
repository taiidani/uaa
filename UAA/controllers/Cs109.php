<?php
namespace RND\UAA\controllers;

class Cs109 extends \RND\UAA\libs\Controller {

	public function index() {
		$this->render('cs109/index');
	}

	public function schedule() {
		$this->render('cs109/schedule');
	}

	public function examples() {
		$this->render('cs109/examples');
	}

	public function assignments($assn = null) {
		if(empty($assn)) $this->render('cs109/assignments');	
		else $this->render("cs109/assignments/$assn");
	}

	public function lectures($lecture, $format) {
		switch(strtoupper($format)) {
			case "PDF":
				header("location: /views/cs109/lectures/$lecture.pdf");
				break;

			case "HTML":
				header("location: /views/cs109/lectures/$lecture/index.html");
				break;
		}
	}
}


?>