<?php
class Zend_View_Helper_Dialog extends Zend_View_Helper_Abstract{
    
    public function dialog(){
        return $this;
    }
    
    /**
     * Configuracion del script para las ventanas de dialogo
     * @param type $id
     * @param type $title
     * @param type $buttons
     * @param type $height
     * @param type $width
     * @param type $dialogClass
     * @param type $resizable
     * @param type $autoOpen
     * @param type $closeOnEscape
     * @param type $modal
     * @param type $href
     * @return string 
     */
    public function scriptConfig($id
            , $title
            , $buttons
            , $height
            , $width
            , $dialogClass
            , $resizable
            , $autoOpen
            , $closeOnEscape
            , $modal
            , $href){
        $script = "\n<script type='text/javascript'>";
        $script .= "\n\tjQuery(document).ready(function () {";
		$script .= "\n\tvar options_".$id." = {};";
        $script .= "\n\toptions_".$id.".title = \"".$title."\";";
		$script .= "\n\toptions_".$id.".buttons = ".$buttons.";";
		$script .= "\n\toptions_".$id.".height = ".$height.";";
		$script .= "\n\toptions_".$id.".width = ".$width.";";
		if(strlen($dialogClass) > 0) $script .= "\n\toptions_".$id.".dialogClass = \"".$dialogClass."\";";
		$script .= "\n\toptions_".$id.".resizable = ".$resizable.";";
		$script .= "\n\toptions_".$id.".autoOpen = ".$autoOpen.";";
		$script .= "\n\toptions_".$id.".closeOnEscape = ".$closeOnEscape.";";
		$script .= "\n\toptions_".$id.".modal = ".$modal.";";
		$script .= "\n\toptions_".$id.".jqueryaction = \"dialog\";";
		$script .= "\n\toptions_".$id.".id = \"".$id."\";";
		$script .= "\n\toptions_".$id.".href = \"".$href."\";";
        $script .= "\n\tjQuery.struts2_jquery.bind(jQuery('#".$id."'),options_".$id.");";
        $script .= "\n\t});";  
        $script .= "\n\t</script>";
        
        return $script;
    }
}