<?php
class Zend_View_Helper_JQGrid extends Zend_View_Helper_Abstract{
    
    public function jqGrid(){
        return $this;
    }
    
    /**
     * Configuracion del script para jqGrid
     */
    public function scriptConfig($id
            , $colNames
            , $colModel
    		, $heigth
    		, $width){
        $script  = "\n<table id='tb_".$id."'></table>";
        $script .= "\n<div id='pg_".$id."'></div>";
        $script .= "\n<script type='text/javascript'>";
        $script .= "\n\tjQuery('#tb_".$id."').jqGrid({";
        $script .= "\n\turl: path+'index/testjson',";
        $script .= "\n\tdatatype: 'json',";
        $script .= "\n\theight: 250,";
        $script .= "\n\twidth: 450,";
        $script .= "\n\tcolNames:".$colNames.",";
        $script .= "\n\tcolModel:".$colModel.",";
        $script .= "\n\trowNum:10,";
        $script .= "\n\trowList:[10,20,30],";
        $script .= "\n\tpager: '#pg_".$id."',";
        $script .= "\n\tloadonce: true,";
        $script .= "\n\tviewrecords: true";
        $script .= "\n\t});";
        $script .= "\n\t</script>";
        
        return $script;
    }
}