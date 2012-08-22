package indra.bbva.pizele.action;

import indra.bbva.pizele.common.CurrentUser;
import indra.bbva.pizele.domain.base.Rubro;
import indra.bbva.pizele.domain.extend.RubroDetalle;
import indra.bbva.pizele.service.RubroService;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@ParentPackage("default")
@Controller("admRubroAction")
@Scope("prototype")
public class AdmRubroAction extends ComunAction
{
	
	private static final long serialVersionUID = 8323237915301658160L;
	
	Logger logger = Logger.getLogger(this.getClass());
	
	// ---- INJECTION'S ----
	
	@Resource
	private RubroService rubroService;

	// ---- FIELD'S ----
	
	private List<RubroDetalle> listaRubro;
	
	private RubroDetalle rubro_Filtro;
	private Rubro rubro_Edicion;
	
	
	// ---- ACTION'S ----
	
	@Actions( {
		@Action(value="/buscarRubros")
	})
	public void buscarRubros() throws Exception
	{
		try
		{	
			this.setListaRubro(this.getRubroService().listarRubro(this.getRubro_Filtro()));
			super.renderListaObjetosJson(this.getListaRubro());
		}
		catch(Exception ex)
		{	
			this.logger.error(ex.getMessage());
			super.renderJsonERROR(ex.getMessage());
		}
	}

	@Actions( {
		@Action(value="/guardarRubro")
	})
	public void guardarRubro() throws Exception
	{
		try
		{	
			
			RubroDetalle objRubroDetalle = new RubroDetalle();
			objRubroDetalle.setDescCompleto(this.getRubro_Edicion().getDescrubro());
			
			if(this.getRubro_Edicion().getId() != null)
			{
				objRubroDetalle.setIdDiff(this.getRubro_Edicion().getId());

				if(this.getRubroService().listarRubro(objRubroDetalle).size() > 0)
					throw new Exception(super.getMensaje("Rubro.error.descripcion.repetida"));
				
				this.getRubro_Edicion().setUsuarioModificacion(CurrentUser.Instance().getCodigoRegistro());
				
				this.getRubroService().actualizarRubro(this.getRubro_Edicion());
				this.setListaRubro(this.getRubroService().listarRubro(this.getRubro_Filtro()));
				
				super.renderJsonEXITO_LISTA(super.getMensaje("Rubro.exito.insert"), this.getListaRubro());
				
			}
			else
			{

				if(this.getRubroService().listarRubro(objRubroDetalle).size() > 0)
					throw new Exception(super.getMensaje("Rubro.error.descripcion.repetida"));
				
				this.getRubro_Edicion().setUsuarioCreacion(CurrentUser.Instance().getCodigoRegistro());
				this.getRubroService().insertarRubro(this.getRubro_Edicion());
				this.setListaRubro(this.getRubroService().listarRubro(this.getRubro_Filtro()));
				
				super.renderJsonEXITO_LISTA(super.getMensaje("Rubro.exito.update"), this.getListaRubro());
				
			}
			
		}
		catch(Exception ex)
		{	
			this.logger.error(ex.getMessage());
			super.renderJsonERROR(ex.getMessage());
		}
	}
	
	// ---- GETTER'S AND SETTER'S ----
	
	public RubroService getRubroService() {
		return rubroService;
	}

	public void setRubroService(RubroService rubroService) {
		this.rubroService = rubroService;
	}

	public RubroDetalle getRubro_Filtro() {
		return rubro_Filtro;
	}

	public void setRubro_Filtro(RubroDetalle rubro_Filtro) {
		this.rubro_Filtro = rubro_Filtro;
	}

	public List<RubroDetalle> getListaRubro() {
		return listaRubro;
	}

	public void setListaRubro(List<RubroDetalle> listaRubro) {
		this.listaRubro = listaRubro;
	}

	public Rubro getRubro_Edicion() {
		return rubro_Edicion;
	}

	public void setRubro_Edicion(Rubro rubro_Edicion) {
		this.rubro_Edicion = rubro_Edicion;
	}
	
}
