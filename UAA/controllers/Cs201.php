<?php

class Cs201 extends C {

	public function index() {
		$this->render('cs201/index.twig');
	}

	public function schedule() {
		$this->render('cs201/schedule.twig');
	}

	public function jobs() {
		$this->render('cs201/jobs.twig');
	}

	public function examples() {
		$this->render('cs201/examples.twig');
	}

	public function assignments($assn = null) {
		if(empty($assn)) $this->render('cs201/assignments.twig');	
		else $this->render("cs201/assignments/$assn.twig");
	}

	public function drills($num) {
		$this->render("cs201/drills/$num.twig");
	}

	public function lectures($lecture, $format = null) {
		switch(strtoupper($format)) {
			case "HTML":
				header("location: /views/cs201/lectures/$lecture/index.html");
				break;

			case "PDF":
				header("location: /views/cs201/lectures/$lecture.pdf");
				break;

			/*case "OGV":
				header("location: /views/cs201/lectures/$lecture.ogv");
				break;*/

			default:
				$params = array();
				$params['num'] = $lecture;
				$params['showSlideHTML'] = is_dir(FCPATH . "/views/cs201/lectures/$lecture");
				$params['showSlidePDF'] = is_file(FCPATH . "/views/cs201/lectures/$lecture.pdf");

				$params['videoURL'] = "http://uaacdn.ryannixon.com/CS201_$lecture.";
				$params['showVideo'] = $this->url_exists($params['videoURL'] . "ogv") && $this->url_exists($params['videoURL'] . "mov");
				
				//= is_file(FCPATH . "/views/cs201/lectures/$lecture.ogv");

				$this->render("cs201/lectures/$lecture.twig", $params);
		}
	}

	private function url_exists($url) {
		$curl = curl_init();
		curl_setopt($curl, CURLOPT_URL, $url);
		curl_setopt($curl, CURLOPT_NOBODY, true);
		//curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
		curl_exec($curl);
		$ret = curl_getinfo($curl);
		curl_close($curl);
		return $ret['http_code'] == '200';
	}
}


?>