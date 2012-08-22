package indra.bbva.pizele.action;

import java.util.ArrayList;
import java.util.List;

import indra.bbva.pizele.common.Constantes;
import indra.bbva.pizele.common.CurrentUser;
import indra.bbva.pizele.domain.base.Backup;
import indra.bbva.pizele.domain.base.Equivalencia;
import indra.bbva.pizele.domain.base.OpcionMenu;
import indra.bbva.pizele.service.BackupService;
import indra.bbva.pizele.service.EquivalenciaService;
import indra.bbva.pizele.service.OficinaService;
import indra.bbva.pizele.service.OpcionService;
import indra.bbva.pizele.service.TerritorioService;
import indra.core.GenericAction;
import indra.core.ObjetoRender;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.grupobbva.bc.per.tele.ldap.comunes.IILDPeExcepcion;
import com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario;
import com.grupobbva.bc.per.tele.seguridad.ServiciosSeguridadBbva;

@ParentPackage("default")
@Controller("seguridadAction")
@Scope("prototype")
public class SeguridadAction extends GenericAction
{

	private static final long serialVersionUID = 8358237919301658160L;
	
	Logger logger = Logger.getLogger(this.getClass());
	
	private HttpServletRequest request;
	private HttpServletResponse response;
		
	// ---- INJECTION'S ----
	
	@Resource
	private EquivalenciaService equivalenciaService;
	
	@Resource
	private OpcionService opcionService;
	
	@Resource
	private BackupService backupService;
	
	@Resource
	private TerritorioService territorioService;
	
	@Resource
	private OficinaService oficinaService;
	
	// ---- METHOD'S ----

	@Actions( {
		@Action(value="/loginAction",
				results={@Result(name="success",type="tiles",location="panel"),
						 @Result(name="error",location="/common/error.jsp")})
	})
	public String login()
	{
		
		ServiciosSeguridadBbva ssBbva = null; 				
		ApplicationContext context = null;		
					
		IILDPeUsuario user = null;
		
		try 
		{

			String codigoUsuario = "";
			
			request = ServletActionContext.getRequest();
			
			if(request.getParameter("desa") == null)
			{
				ssBbva = new ServiciosSeguridadBbva(request);
				if(ssBbva != null) {
					ssBbva.obtener_ID();
					codigoUsuario  =  ssBbva.getUsuario().toUpperCase();	
				}
			}
			else
			{
				codigoUsuario = request.getParameter("codldap").trim();
			}
	
			user = IILDPeUsuario.recuperarUsuario(codigoUsuario);			
			if(user == null)
				return ERROR;
				
			boolean verificarBackup = false;
						
			Equivalencia objEquivalencia = this.getEquivalenciaService().listarEquivalencia(user.getCargo().getCodigo());			
			if(objEquivalencia == null)
				verificarBackup = true;
			
			List<OpcionMenu> listaOpciones  = null;
			
			if(!verificarBackup)
			{
				listaOpciones = this.getOpcionService().listarOpciones(objEquivalencia.getCodigoPerfil());
				if(listaOpciones.size() == 0)
					verificarBackup = true;
			}
				
			if(verificarBackup)
			{
				
				Backup objBackup = new Backup();
				objBackup.setCodigoGestorSuplente(codigoUsuario);
				objBackup = this.getBackupService().listarBackupVigente(objBackup);
				
				if(objBackup != null)
				{
				
					IILDPeUsuario UserGOF = IILDPeUsuario.recuperarUsuario(objBackup.getCodigoGOF().toUpperCase());
					if(UserGOF == null)
						return ERROR;
					
					objEquivalencia = this.getEquivalenciaService().listarEquivalencia(UserGOF.getCargo().getCodigo());
					if(objEquivalencia == null)
						return ERROR;
					
					listaOpciones = this.getOpcionService().listarOpciones(objEquivalencia.getCodigoPerfil());
					if(listaOpciones.size() == 0)
						return ERROR;
					
					CurrentUser.LogOut();
					super.setCurrentUser(CurrentUser.Instance()); 
					super.getCurrentUser().setEsBackupSuplente(true);
					super.getCurrentUser().setCodigoRegistro(codigoUsuario);
					super.getCurrentUser().setNombreCompleto(user.getNombreCompleto());
					super.getCurrentUser().setCodigoOficina(IILDPeUsuario.getOfActual(codigoUsuario));
					super.getCurrentUser().setCodigoCargo(user.getCargo().getCodigo());
					
					for(int index = 0; index < listaOpciones.size(); index++)
					{
						if(listaOpciones.get(index).getCodigo() == Constantes.Opcion_Menu.CONFIG_BACKUP_SUPLENTE)
							listaOpciones.remove(listaOpciones.get(index));
					}
										
					super.getCurrentUser().setListaOpciones(listaOpciones);
					this.formarMenuUsuario(listaOpciones);					
					
					super.getCurrentUser().setCodigoRegistroGOF(objBackup.getCodigoGOF().toUpperCase());
					super.getCurrentUser().setNombreCompletoGOF(UserGOF.getNombreCompleto());
					super.getCurrentUser().setCodigoPerfilGOF(objEquivalencia.getCodigoPerfil());	
					super.getCurrentUser().setCodigoCargoGOF(UserGOF.getCargo().getCodigo());					
					
					if(!this.definirNivelAcceso(super.getCurrentUser().getCodigoPerfilGOF(), super.getCurrentUser().getCodigoOficina()))
					{
						CurrentUser.LogOut();
						return ERROR;
					}
					
				}
				else
				{
					return ERROR;
				}
			}
			else
			{

				CurrentUser.LogOut();
				super.setCurrentUser(CurrentUser.Instance()); 
				super.getCurrentUser().setCodigoRegistro(codigoUsuario);
				super.getCurrentUser().setNombreCompleto(user.getNombreCompleto());
				super.getCurrentUser().setCodigoOficina(IILDPeUsuario.getOfActual(codigoUsuario));
				super.getCurrentUser().setCodigoPerfil(objEquivalencia.getCodigoPerfil());
				super.getCurrentUser().setCodigoCargo(user.getCargo().getCodigo());
				super.getCurrentUser().setListaOpciones(listaOpciones);
				this.formarMenuUsuario(listaOpciones);
				
				if(super.getCurrentUser().getCodigoPerfil().equals(Constantes.Perfil.GERENTE_TERRITORIO) || 
						super.getCurrentUser().getCodigoPerfil().equals(Constantes.Perfil.JEFE_PROMOCION_NEGOCIOS))
				{
					super.getCurrentUser().setCodigoOficina("3" + super.getCurrentUser().getCodigoOficina().substring(1, 4));					
				}
				
				if(!this.definirNivelAcceso(super.getCurrentUser().getCodigoPerfil(), super.getCurrentUser().getCodigoOficina()))
				{
					CurrentUser.LogOut();
					return ERROR;
				}									
			}
				
		}
		catch (IILDPeExcepcion e) 
		{
			logger.error(e.getMensaje());
			return ERROR;
		}
		catch (Exception e) 
		{
			logger.error(e.getMessage());
			return ERROR;
		}
		
		return SUCCESS;
	}
	
	@Actions( {
		@Action(value="/irInicio",
				results={@Result(name="success",type="tiles",location="panel")})
	})
	public String irInicio()
	{	
		return SUCCESS;
	}
		
	// ---- PRIVATE METHODS ----
	
	private boolean definirNivelAcceso(String codPerfil, String codOficina)
	{
		
		boolean existeOficina = true;
		
		if(codPerfil.equals(Constantes.Perfil.GERENTE_TERRITORIO) || codPerfil.equals(Constantes.Perfil.JEFE_PROMOCION_NEGOCIOS))
		{			
			super.getCurrentUser().setTerritorio(this.getTerritorioService().obtenerTerritorio(codOficina));
			existeOficina = !(super.getCurrentUser().getTerritorio() == null);				
		}
		else if(codPerfil.equals(Constantes.Perfil.GERENTE_OFICINA))
		{
			super.getCurrentUser().setOficina(this.getOficinaService().obtenerOficina(codOficina));
			if(super.getCurrentUser().getOficina() == null)
			{
				existeOficina = false;
			}
			else
			{
				super.getCurrentUser().setTerritorio(this.getTerritorioService().obtenerTerritorio(super.getCurrentUser().getOficina().getCodigoTerritorio()));
			}
		}

		return existeOficina;
	}
	
	private void formarMenuUsuario(List<OpcionMenu> listaOpciones)
	{
		
		List<OpcionMenu> listaOpcionesLocal = this.cargarMenu(listaOpciones);
		
		OpcionMenu objOpcionMenu = new OpcionMenu();
		objOpcionMenu.setNombre("Inicio");
		objOpcionMenu.setUrl("irInicio.do");
		listaOpcionesLocal.add(0, objOpcionMenu);
		
		super.getCurrentUser().setListaOpciones_html(new ArrayList<ObjetoRender>());
		super.getCurrentUser().setListaOpciones_js(new ArrayList<ObjetoRender>());
				
		ObjetoRender objRender = null;
		
		for(int index = 0; index < listaOpcionesLocal.size(); index ++)
		{
			
			objRender = new ObjetoRender();
			objRender.setContenido(listaOpcionesLocal.get(index).getHTML());
			super.getCurrentUser().getListaOpciones_html().add(objRender);
			
			if(listaOpcionesLocal.get(index).getOpcionesHijas() != null && listaOpcionesLocal.get(index).getOpcionesHijas().size() > 0)
			{
				objRender = new ObjetoRender();
				objRender.setContenido(this.obetenerMenuJS(listaOpcionesLocal.get(index).getCodigo()));
				super.getCurrentUser().getListaOpciones_js().add(objRender);
			}
		}
		
		
	}
	
	private String obetenerMenuJS(Long codMenu)
	{
		
		StringBuffer sbScript = new StringBuffer();
		sbScript.append("<script type=\"text/javascript\"> ");
		sbScript.append("$(function(){");
		sbScript.append("$('#flyout" + codMenu);
		sbScript.append("').menu({ ");
		sbScript.append("content: $('#flyout" + codMenu);
		sbScript.append("').next().html(), ");
		sbScript.append("showSpeed: 1, flyOut: true");
		sbScript.append("});");
		sbScript.append("});");
		sbScript.append("</script>");
		    	
		return sbScript.toString();
		
	}
	
	private List<OpcionMenu> cargarMenu(List<OpcionMenu> lstOpciones)
	{
		List<OpcionMenu> retornoLista = new ArrayList<OpcionMenu>();
		
		for(int index = 0; index < lstOpciones.size(); index ++)
		{
			if(lstOpciones.get(index).getCodigoPadre() == null)
			{				
				retornoLista.add(lstOpciones.get(index));
				this.cargarMenuHijos(lstOpciones.get(index), lstOpciones);
			}
		}
		
		return retornoLista;
	}
	
	private void cargarMenuHijos(OpcionMenu objPadre, List<OpcionMenu> lstOpciones)
	{
		for(int index = 0; index < lstOpciones.size(); index ++)
		{
			if(lstOpciones.get(index).getCodigoPadre() == objPadre.getCodigo())
			{
				if(objPadre.getOpcionesHijas() == null)
					objPadre.setOpcionesHijas(new ArrayList<OpcionMenu>());
				objPadre.getOpcionesHijas().add(lstOpciones.get(index));
				this.cargarMenuHijos(lstOpciones.get(index), lstOpciones);
			}
		}
	}
	
	// ---- GETTER'S AND SETTER'S ----
	
	public HttpServletRequest getRequest() {
		return request;
	}
	
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public HttpServletResponse getResponse() {
		return response;
	}
	
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public EquivalenciaService getEquivalenciaService() {
		return equivalenciaService;
	}

	public void setEquivalenciaService(EquivalenciaService equivalenciaService) {
		this.equivalenciaService = equivalenciaService;
	}
	
	public OpcionService getOpcionService() {
		return opcionService;
	}

	public void setOpcionService(OpcionService opcionService) {
		this.opcionService = opcionService;
	}

	public BackupService getBackupService() {
		return backupService;
	}

	public void setBackupService(BackupService backupService) {
		this.backupService = backupService;
	}

	public TerritorioService getTerritorioService() {
		return territorioService;
	}

	public void setTerritorioService(TerritorioService territorioService) {
		this.territorioService = territorioService;
	}

	public OficinaService getOficinaService() {
		return oficinaService;
	}

	public void setOficinaService(OficinaService oficinaService) {
		this.oficinaService = oficinaService;
	}
	

}
