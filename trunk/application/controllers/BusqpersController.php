<?php
/**
 * SqlcnController
 * 
 * @author
 * @version 
 */

require_once 'Zend/Controller/Action.php';

class BusqpersController extends Zend_Controller_Action {
	/**
	 * The default action - show the home page
	 */
	public function indexAction() {
		
		$urlpag = $this->_request->getParam ( 'url', '' );
		$tit = $this->_request->getParam ( 'tit', '' );
		$fech = $this->_request->getParam ( 'fech', '' );
			if($fech == ''){
				$nombrestore = '"public"."pxcobrowww"';
				$arraydatos [0] = '1';
				$arraydatos [1] = '';
				$arraydatos [2] = '';
				$cn = new Model_DataAdapter();
				$datosfecha = $cn->ejec_store_procedura_sql( $nombrestore, $arraydatos );
				$dfecha = explode ( " ", $datosfecha [0] [0] );
				$fech = $dfecha[0];
			}
			
//		$ddatosuserlog = new Zend_Session_Namespace ( 'datosuserlog' );
//		$datosuserlog = $ddatosuserlog->data;
//		
		$func = new Libreria_Pintar (); 
		
//		if ($datosuserlog == '' || $datosuserlog == null) {
//			$val [0] = array ("showbp", "No tienes privilegios de usuario para este modulo", "html" );
//			$func->PintarValor ( $val );
//		} else {
			$val [0] = array ("urlredirect", $urlpag, "val" );
			$val [1] = array ("div_titulo", '<h2>' . $tit . '</h2>', "html" );
			$val [2] = array ("txtcidper", "", "focus" );
			$val [3] = array ("fech", $fech, "val" );
			$func->PintarValor ( $val );
			
			$evt [0] = array ("cbnivelbusqpers", "change", "carg_campos_busqpers();" );
			$evt [1] = array ("txtcidper", "keypress", "if(event.keyCode  == 13){BuscarPerxCID();}else{return validarnumeros(event)}" );
			$evt [2] = array ("Buscar", "click", "BuscarPerxCID();" );
			$func->PintarEvento ( $evt );
//		}
	
	}
	
	public function busquedapersonaAction() {
		$this->_helper->getHelper ( 'ajaxContext' )->initContext ();
		$this->_helper->layout->disableLayout ();
		if ($this->getRequest ()->isXmlHttpRequest ()) {
			//$this->_helper->viewRenderer->setNoRender(); 
			
			
			$surl = new Zend_Session_Namespace ( 'url' );
			$url = $surl->data;
			
			$cidpers = trim ( $this->_request->getPost ( 'cidpers' ) );
			$nombre = trim ( $this->_request->getPost ( 'nombre' ) );
			$apepat = trim ( $this->_request->getPost ( 'apepat' ) );
			$apemat = trim ( $this->_request->getPost ( 'apemat' ) );
			$dni = trim ( $this->_request->getPost ( 'dni' ) );
			$urlredirect = trim ( $this->_request->getPost ( 'urlredirect' ) );
			$fech = trim ( $this->_request->getPost ( 'fech' ) );
			
			$nombrestore = '"public"."buscar_persona"';
			//@valor varchar(10)='',		--valor de query
			//@nvar1 varchar(500)='',		--codigo de contribuyente
			//@nvar2 varchar(500)='',		--nombre
			//@nvar3 varchar(500)='',		--apellido paterno
			//@nvar4 varchar(500)='',		--apellido materno
			//@nvar5 varchar(500)=''		--doc identidad
			$arraydatos [0] = $cidpers ;
			$arraydatos [1] = $nombre ;
			$arraydatos [2] = $apepat ;
			$arraydatos [3] = $apemat ;
			$arraydatos [4] = $dni;
			
			$cn = new Model_DataAdapter();
			$datos = $cn->ejec_store_procedura_sql( $nombrestore, $arraydatos );
			
			//$datos = '';
			if ($datos == '' || $datos == null) {
				
				
				$func = new Libreria_Pintar();
				
				if ($cidpers == null || $cidpers == '' || $cidpers == '0000000000') {
					$cper = '_________1';
				} else {
					$cper = $cidpers;
				}
			$val[0]=array("cidpers",$cper,"html");
			$val[1]=array("div_pers_no_reg",$apepat.' '.$apemat.' '.$nombre,"html");
			$func->PintarValor($val);
			
				if ($apepat != null || $apepat != '' || $apemat != null || $apemat != '' || $nombre != null || $nombre != '') {
					$evt[0]=array("genrecibo","click","window.open('" . $urlredirect . "_________1|" . $apepat . " " . $apemat . " " . $nombre . "', '_self')");
					$evt[1]=array("limpiar","click","$(\"#div_rsbusqpers\").html(\"\");");
					$func->PintarEvento($evt);
					//$hab[0]=array("genrecibo",true);
					//$func->HabilitarComponente($hab);
				}else{
					$val[0]= array("botones","","html");
					$func->PintarValor($val);   
				}
				if ($apepat != null || $apepat != '' || $apemat != null || $apemat != '' || $nombre != null || $nombre != '') {
					
					
				}
			}else{
				//la data es pasada en formato json
				$data = json_encode($datos);
				$func = new Libreria_Pintar();
				$val2[0]=array("busqpersona","","html");
				$func->PintarValor($val2);
									
			   	$cont ='						
							<script type="text/javascript"> var members ='.$data.'</script>
							<script type="text/javascript">
								
								$(document).ready(function(){
									var optInit = getOptionsFromForm();
									$("#Pagination").pagination(members.length, optInit);
									$("#setoptions").click(function(){
										var opt = getOptionsFromForm();
										$("#Pagination").pagination(members.length, opt);
									});
								});            
							</script>
							
							<div align = "center">			
									<div id="Pagination">
									</div>
									<br style="clear:both;" />
									<div id="Searchresult">
									</div>
							</div>	
							<form name="paginationoptions">
								<input type="hidden" value="20" name="items_per_page" id="items_per_page"/>
								<input type="hidden" value="5" name="num_display_entries" id="num_display_entries" class="numeric"/>
								<input type="hidden" value="1" name="num_edge_entries" id="num_edge_entries" class="numeric"/>
								<input type="hidden" value="Prev" name="prev_text" id="prev_text"/>
								<input type="hidden" value="Next" name="next_text" id="next_text"/>
								<!--<input type="button" id="setoptions" value="Set options"/>-->
							</form>
						';
			   	echo $cont;
			}
		
		}
	}

}

