<?php

class Libreria_FiltroPanel {
	
	public function renderListaContribuyente() {
		$dataSet = new Zend_Session_Namespace("registro.cidpers");
		$rows = $dataSet->data;
		
		$procedure = "pl_function.panel_persona";
		$parameters[] = "'".implode("','", $rows)."'";
		
		$db = new Model_DataAdapter();
		$json = $db->executeRowsToJSON($procedure, $parameters);
		
		echo $json;
	}

	public function renderContribuyente() {
	}
	
	public function renderListaPredio() {
	}
	
	public function renderPredio() {
	}
}