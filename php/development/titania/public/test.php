<?php
header('Content-Type: text/html; charset=utf-8');
// echo $_REQUEST['test']."<br/>";
echo $_REQUEST['test'][1]['texto']."<br/>";
// print_r($_REQUEST['test']);
echo "<br/><br/><br/>".json_encode($_REQUEST['test']);
echo "<br/>".json_encode($_REQUEST['test'], JSON_HEX_TAG | JSON_HEX_APOS | JSON_HEX_QUOT | JSON_HEX_AMP | JSON_FORCE_OBJECT);
?>