<?php

class LogeoController extends Zend_Controller_Action implements Zend_Auth_Adapter_Interface {
	public $flag = false;
	
	public function init() {
		$this->view->util()->registerScriptJSController($this->getRequest());
		$this->view->util()->registerLeaveControllerAction($this->getRequest());
	}
	
    public function indexAction(){
		$url = $this->view->util()->getPath();
		
		$evt[0] = array("txtuser","keypress","if(event.keyCode == 13){ValidarLogeo();}");
		$evt[1] = array("txtpass","keypress","if(event.keyCode == 13){ValidarLogeo();}");
		$evt[2] = array("btningreso","click","ValidarLogeo();");
		
		$att[0] = array('logo','src',$url.'img/logomuni.png');
		
		$func = new Libreria_Pintar();
		$func->IniciaScript();
		$func->PintarEvento($evt);
		$func->AtributoComponente($att);
		$func->FinScript();
    }
   
    public function redirectAction() {
    }
    
	public function validarlogeoAction() {   
		$this->_helper->viewRenderer->setNoRender(); 
		$this->_helper->layout->disableLayout();
		$this->_helper->getHelper('ajaxContext')->initContext();
		
		if ($this->getRequest()->isXmlHttpRequest()) {
			
			$url = $this->view->util()->getPath();

			$user = trim($this->_request->getPost('user'));
			$pass = trim($this->_request->getPost('pass'));
			$nivel = $this->_request->getPost('nivel'); // aun no se usa!! pero igual lo pongo xD!

			if($user == '' || $user == null || $pass == '' || $pass == null){
				echo 'Ingresar Usuario y/o Contrase&ntilde;a';
			}else{
				$nombrestore = 'seguridad.login';
				$arraydatos[]= $user;
				$arraydatos[]= $pass;
				
				$cn = new Model_DataAdapter();
				$datos = $cn->ejec_store_procedura_sql($nombrestore,$arraydatos);

				$caddatos = "";
				
				if($datos == '' || $datos == null || count($datos)<=0){
					echo '<font color="#FF0000">Datos Incorrectos...</font>';
					$this->flag = false;
				}
				else{
//					if($datos[0][7] >= $dias[0][2]){
//						echo '<font color="#FF0000">Usuario bloqueado por superar el limite de inactividad <br>... Comuniquese con la S/G de Informatica</font>';
//					}else
					if ($datos[0][5] == '1'){						
						$ddatosuserlog = new Zend_Session_Namespace('datosuserlog');				
						$ddatosuserlog->cidpers = $datos[0][0];	
						$ddatosuserlog->nompers = $datos[0][1];
						$ddatosuserlog->userlogin = $datos[0][2];	
						$ddatosuserlog->arealogin = $datos[0][3];			
						$ddatosuserlog->codcajero = $datos[0][4];	 
			
						echo '<script language=\"JavaScript\">window.open(\''.$url.'index.php\', \'_self\')</script>';
					}else{
						echo '<font color="#FF0000">Usuario Inactivo...</font>';
					}
					$this->flag = true;
				}
				
				$auth = Zend_Auth::getInstance();
				$auth->authenticate($this);
			}
		}
	}

	public function logoutAction() {
		$url = $this->view->util()->getPath();
		Zend_Session::destroy();
		$this->_redirect($url.'index.php/');
	}
	
	public function authenticate()  {
		if ($this->flag) {
			$user = new Zend_Session_Namespace('datosuserlog');
			$result = new Zend_Auth_Result ( Zend_Auth_Result::SUCCESS, explode('|', $user->data), array ("Ok" ) );
		} else {
			$result = new Zend_Auth_Result ( Zend_Auth_Result::FAILURE_IDENTITY_NOT_FOUND, null, array ("Error" ) );
		}
		
		return $result;
	}
}

