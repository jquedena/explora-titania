package indra.bbva.pizele.action;

import indra.bbva.pizele.common.Constantes;
import indra.bbva.pizele.common.CurrentUser;
import indra.bbva.pizele.domain.base.AsignacionRubro;
import indra.bbva.pizele.domain.base.Rubro;
import indra.bbva.pizele.domain.base.RubroLogro;
import indra.bbva.pizele.service.AsignacionRubroService;
import indra.bbva.pizele.service.RubroLogroService;
import indra.core.DocumentoExcel;
import indra.core.FechaUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@ParentPackage("default")
@Controller("logroRegistroAction")
@Scope("prototype")
public class LogroRegistroAction extends ComunAction {

	private static final long serialVersionUID = 8323237915301658160L;
	private Logger logger = Logger.getLogger(this.getClass());
	private List<Rubro> listaRubro = null;
	private List<RubroLogro> listaLogro = null;
	private String idOficina = "-1";
	private String idTerritorio = "-1";
	private String dia = "01/01/1900";
	private String lista = "";
	private String xlsHead = "";
	private String xlsBody = "";
	private int permiso;
	
	@Resource
	private AsignacionRubroService asignacionRubroService;
	
	@Resource
	private RubroLogroService rubroLogroService;

	@Actions( { @Action(value = "/iniciarRegistroDiarioConsulta", results = {
			@Result(name = "success", type = "tiles", location = "registroLogro"),
			@Result(name = "error", type = "tiles", location = "panel") })
	})
	public String iniciarRegistroDiarioConsulta() {
		try {
			if(CurrentUser.Instance().getTerritorio() != null)
				idTerritorio = CurrentUser.Instance().getTerritorio().getCodigo();
			if( CurrentUser.Instance().getOficina() != null)
				idOficina = CurrentUser.Instance().getOficina().getCodigo();
			
			super.cargarTerritorios();
			super.cargarOficinas();

			this.setDia(FechaUtil.formatFecha(new Date(), "dd/MM/yyyy"));
			this.obtenerAcceso();
			
		} catch (Exception ex) {
			super.addActionError(ex.getMessage());
			this.logger.error(ex.getMessage());
			return ERROR;
		}

		return SUCCESS;
	}

	@Actions( {
		@Action(value="/cargarLogroRubro")
	})
	public void cargarLogroRubro() throws Exception {
		Long anio = Long.parseLong(this.getDia().substring(6, 10));
		Long mes = Long.parseLong(this.getDia().substring(3, 5)) + 6;
		Long dia = Long.parseLong(this.getDia().substring(0, 2));
		String codTerr = this.getIdTerritorio();
		String codOfi = this.getIdOficina();
		String hoy = FechaUtil.formatFecha(new Date(), "dd/MM/yyyy");
		int activo = -1;
		
		try {
			this.setCodigoOficinaFiltro(codOfi);
			this.cargarRubros(codTerr, codOfi, anio, mes, dia);
			this.cargarGestores();
			
			obtenerAcceso();
			activo = FechaUtil.compareDate(FechaUtil.formatoFechaDate(this.getDia()), FechaUtil.formatoFechaDate(hoy));
			
			if(this.permiso == 0) {
				activo = 1;
			}
			
			Map<String, Object> result = new HashMap<String, Object>(); 
			result.put("rubros", this.getListaRubro());
			result.put("gestores", this.getListaGestores());
			result.put("logro", this.getListaLogro());
			result.put("activo", activo);
			
			super.renderJsonEXITO_LISTA("Actualizando...", result);	
		} catch (Exception ex) {
			this.logger.error(ex.getMessage());
			super.renderJsonERROR(ex.getMessage());
		}
	}
	
	@Actions( {
		@Action(value="/exportarExcelRubroLogro",
			results={@Result(name="success",type="stream",
				params={"contentType", "application/vnd.ms-excel",
					"inputName", "excelStream",
					"contentDisposition", "attachment;filename=\"formRubroLogro.xls\"",
					"bufferSize", "1024"}),
			@Result(name="error",type="tiles",location="panel")})
	})
	public String exportarExcelRubroLogro() throws Exception  {
		try {
			int index;
			int indexRow;
			DocumentoExcel doc = new DocumentoExcel(super.getServletContext().getRealPath("/rpt/template/formRubroLogro.xls"));
			String[] expHead = this.getXlsHead().split("\\|");
			String[] expBody = this.getXlsBody().split("\\|");
			String[] row;
			
			doc.setContentValue(6, 1, expHead[0]);
			doc.setContentValue(6, 4, expHead[1]);
			doc.setContentValue(7, 1, expHead[2]);
			
			if(expBody.length > 0) {
				row = expBody[0].split("\\%");
				doc.setBarraTitulo(9, 0, 2 + row.length, "Registro de Logros Diarios");
				doc.setBarraTitulo(10, 0, 3, row[0]);
				for(index = 1; index < row.length; index++) {
					doc.setBarraTitulo(10, 3 + index, row[index]);
				}
				
				for(indexRow = 1; indexRow < expBody.length; indexRow++) {
					row = expBody[indexRow].split("\\%");
					if(row.length > 0) {
						doc.setContentValue(10 + indexRow, 0, 3, row[0] + row[1] + row[2] + row[3] );
						for(index = 4; index < row.length; index++) {
							doc.setContentValue(10 + indexRow, index, row[index]);
						}
					}
				}
			}
			
			this.setExcelStream(doc.getExcelStream());                      
		}
		catch(Exception ex) {
			this.logger.error(ex.getMessage());
			return ERROR;
		}
		
		return SUCCESS;
	}
	
	@Actions( {
		@Action(value="/grabarLogroRubro")
	})
	public void grabarLogroRubro() throws Exception {
		int i;
		int j;
		String row;
		String tmp[];
		String rows[];
		String cols[];
		String codgestor = "";
		String nombre = "";
		String paterno = "";
		String materno = "";
		String perfil = "";
		RubroLogro item;
		
		Long anio = Long.parseLong(this.getDia().substring(6, 10));
		Long mes = Long.parseLong(this.getDia().substring(3, 5)) + 6;
		Long dia = Long.parseLong(this.getDia().substring(0, 2));
		String codTerr = this.getIdTerritorio();
		String codOfic = this.getIdOficina();
		
		try {
			rows = this.getLista().split("\\|");
			for(i = 0; i < rows.length; i++) {
				row = rows[i];
				
				if(row.length() > 0) {
					cols = row.split("\\%");
					nombre = cols[0];
					paterno = cols[1];
					materno = cols[2];
					
					tmp = cols[3].split("\\_");
					if(tmp.length > 0){
						perfil = tmp[0].replaceAll("-", "").trim();
						codgestor = tmp[1];
					}
					
					if(perfil == null || perfil.length() == 0) {
						perfil = "---";
					}
					
					for(j = 4; j < cols.length; j++) {
						tmp = cols[j].split("\\_");
						
						item = new RubroLogro();
						item.setCodigoTerritorio(codTerr);
						item.setCodigoOficina(codOfic);
						item.setDia(dia);
						item.setMes(mes);
						item.setAnio(anio);
						item.setCod_gestor(codgestor);
						item.setNom_ges_sup(nombre);
						item.setApell_pat_ges_sup(paterno);
						item.setApell_mat_ges_sup(materno);
						item.setCod_cargo(perfil);
						item.setUsuarioCreacion(CurrentUser.Instance().getCodigoRegistro());
						
						item.setId_rubro(Long.parseLong(tmp[2]));
						item.setLogro(Long.parseLong(tmp[0]));
						item.setSemana(Long.parseLong(String.valueOf(FechaUtil.semanaActual())));
						
						this.getRubroLogroService().insertarRubroLogro(item);
					}
				}
			}
			
			this.renderJsonEXITO("Logros actualizados correctamente");
		} catch(Exception e) {
			this.logger.error("grabarLogroRubro", e);
			this.renderJsonERROR(e.getMessage());
		}
	}
	
	private void cargarRubros(String codTerr, String codOfic, Long anio, Long mes, Long dia){
		AsignacionRubro objAsigRubro = new AsignacionRubro();
		objAsigRubro.setCodterr(codTerr);
		objAsigRubro.setCodofic(codOfic);
		objAsigRubro.setAnio(anio);
		objAsigRubro.setMes(mes);
		
		RubroLogro objRubroLogro = new RubroLogro();
		objRubroLogro.setCodigoTerritorio(codTerr);
		objRubroLogro.setCodigoOficina(codOfic);
		objRubroLogro.setAnio(anio);
		objRubroLogro.setMes(mes);
		objRubroLogro.setDia(dia);
		
		this.setListaLogro(this.getRubroLogroService().listarRubro(objRubroLogro));
		this.setListaRubro(this.getAsignacionRubroService().listarRubrosAsignShort(objAsigRubro));
	}
	
	private void obtenerAcceso(){
		String acceso = CurrentUser.Instance().obtenerTipoAccesoOpcion(Constantes.Opcion_Menu.CONFIG_REGISTRO_LOGRO);
		if(Constantes.TipoAcceso.SOLO_LECTURA.equalsIgnoreCase(acceso)) {
			this.permiso = 0;
		} else if(Constantes.TipoAcceso.TOTAL.equalsIgnoreCase(acceso)) {
			this.permiso = 1;
		}
	}
	
	public List<Rubro> getListaRubro() {
		return listaRubro;
	}

	public void setListaRubro(List<Rubro> listaRubro) {
		this.listaRubro = listaRubro;
	}

	public List<RubroLogro> getListaLogro() {
		return listaLogro;
	}

	public void setListaLogro(List<RubroLogro> listaLogro) {
		this.listaLogro = listaLogro;
	}

	public String getIdOficina() {
		return idOficina;
	}

	public void setIdOficina(String idOficina) {
		this.idOficina = idOficina;
	}

	public String getIdTerritorio() {
		return idTerritorio;
	}

	public void setIdTerritorio(String idTerritorio) {
		this.idTerritorio = idTerritorio;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getXlsHead() {
		return xlsHead;
	}

	public void setXlsHead(String xlsHead) {
		this.xlsHead = xlsHead;
	}

	public String getXlsBody() {
		return xlsBody;
	}

	public void setXlsBody(String xlsBody) {
		this.xlsBody = xlsBody;
	}

	public String getLista() {
		if(lista == null) {
			lista = "";
		}
		return lista;
	}

	public void setLista(String lista) {
		this.lista = lista;
	}

	public int getPermiso() {
		return permiso;
	}

	public void setPermiso(int permiso) {
		this.permiso = permiso;
	}

	public AsignacionRubroService getAsignacionRubroService() {
		return asignacionRubroService;
	}

	public void setAsignacionRubroService(AsignacionRubroService asignacionRubroService) {
		this.asignacionRubroService = asignacionRubroService;
	}

	public RubroLogroService getRubroLogroService() {
		return rubroLogroService;
	}

	public void setRubroLogroService(RubroLogroService rubroLogroService) {
		this.rubroLogroService = rubroLogroService;
	}
	
}
