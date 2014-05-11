<?php

class Cs109 extends C {

	public function index() {
		$this->render('cs109/index.twig');
	}

	public function schedule() {
		$this->render('cs109/schedule.twig');
	}

	public function examples() {
		$this->render('cs109/examples.twig');
	}

	public function assignments($assn = null) {
		if(empty($assn)) $this->render('cs109/assignments.twig');	
		else $this->render("cs109/assignments/$assn.twig");
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