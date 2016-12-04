<?php
namespace RND\UAA;

require_once(__DIR__ . "/../vendor/autoload.php");

define("FCPATH", __dir__);
libs\Routes::handle($_SERVER['REQUEST_URI']);
