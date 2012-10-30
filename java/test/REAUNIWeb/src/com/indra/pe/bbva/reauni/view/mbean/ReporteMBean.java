package com.indra.pe.bbva.reauni.view.mbean;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.indra.pe.bbva.core.util.Constantes;
import com.indra.pe.bbva.core.util.Utilitarios;
import com.indra.pe.bbva.core.view.GenericMBean;
import com.indra.pe.bbva.reauni.view.helper.ApplicationHelper;

@SuppressWarnings({"rawtypes", "unused", "unchecked"})
@Controller("reporteMBean")
@Scope("session")
public class ReporteMBean extends GenericMBean {
	private static Logger logger = Logger.getLogger(ReporteMBean.class);

	private List tipos;
	private List a�os;
	private List meses;
	private String anio_reporte;
	private String tipo_reporte;
	private String mes_reporte;
	private String ruta;

	private Boolean existe = false;

	public ReporteMBean() {
		try {

			cargarA�os();
			cargaTipos();

			this.tipo_reporte = Constantes.TIPO_OFICINA.getValue().toString();
			this.anio_reporte = String.valueOf(Utilitarios.Fecha.obtenerAnioActual());
			this.mes_reporte = String.valueOf(Utilitarios.Fecha.obtenerMesActual());
			carga_parametros(null);
			
		} catch (Exception e) {
			logger.error("ERROR EN UTILITARIO " + e.getMessage());
		}
	}
	
	public String iniciar () {
		return com.indra.pe.bbva.reauni.util.Constantes.UrlNavegacion.URL_REPORTE;
	}
	
	public String verificarExistenciaFile() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();

		return null;
	}

	public void carga_parametros(javax.faces.event.AjaxBehaviorEvent a){

		FacesContext context = FacesContext.getCurrentInstance();  
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();        
        
        String ruta = ApplicationHelper.obtenerParametroPorId(1065L).getValorCadena();
        request.getSession().setAttribute("tipo", tipo_reporte);
        request.getSession().setAttribute("a�o", anio_reporte);
        request.getSession().setAttribute("mes", mes_reporte);
        request.getSession().setAttribute("exportacion_ruta", ruta);
        this.setRuta(ruta);
        String archivo=tipo_reporte+"_"+anio_reporte+""+mes_reporte+".xls";
        
        File file = new File(ruta +  archivo);
        
        if(tipo_reporte==null || anio_reporte==null || mes_reporte==null || tipo_reporte.equals("") || anio_reporte.equals("") || mes_reporte.equals("")){
        	existe=false;
        	showWarning("SELECCIONE TODOS LOS CRITERIOS DE BUSQUEDA.");
        }else{
	    	if(!file.exists()){		    		
	    		existe=false;
	    		try {
	    			showWarning("NO EXISTE NING�N REPORTE PARA LOS CRITERIOS SELECCIONADOS!");										
				} catch (Exception e) {
					logger.error("ReporteMBean", e);
				}
	    	} else {
	    		existe=true;
	    		showMessage("EXISTE EL ARCHIVO PARA DESCARGAR!");
	    	}
        }
	}

	public final static byte[] load(FileInputStream fin) {
		byte readBuf[] = new byte[512 * 1024];

		try {
			ByteArrayOutputStream bout = new ByteArrayOutputStream();

			int readCnt = fin.read(readBuf);
			while (0 < readCnt) {
				bout.write(readBuf, 0, readCnt);
				readCnt = fin.read(readBuf);
			}

			fin.close();

			return bout.toByteArray();
		} catch (Exception e) {

			return new byte[0];
		}
	}

	public void cargaTipos() {

		tipos = new ArrayList();
		tipos.add(Constantes.TIPO_OFICINA);
		tipos.add(Constantes.TIPO_TERRITORIO);
		tipos.add(Constantes.TIPO_TRAMITE);
		tipos.add(Constantes.TIPO_SOLICITUD);

	}

	public void cargarA�os() {
		a�os = new ArrayList();
		Calendar hoy = Calendar.getInstance();
		SelectItem item = new SelectItem(hoy.get(Calendar.YEAR) + "", hoy.get(Calendar.YEAR) + "");
		a�os.add(item);
		for (int i = 1; i <= 10; i++) {
			SelectItem item_tem = new SelectItem((hoy.get(Calendar.YEAR) - i) + "", (hoy.get(Calendar.YEAR) - i) + "");
			a�os.add(item_tem);
		}
	}

	public List getTipos() {
		return tipos;
	}

	public void setTipos(List tipos) {
		this.tipos = tipos;
	}

	public List getA�os() {
		return a�os;
	}

	public void setA�os(List a�os) {
		this.a�os = a�os;
	}

	public List getMeses() {
		return meses;
	}

	public void setMeses(List meses) {
		this.meses = meses;
	}

	public String getAnio_reporte() {
		return anio_reporte;
	}

	public void setAnio_reporte(String anio_reporte) {
		this.anio_reporte = anio_reporte;
	}

	public String getTipo_reporte() {
		return tipo_reporte;
	}

	public void setTipo_reporte(String tipo_reporte) {
		this.tipo_reporte = tipo_reporte;
	}

	public String getMes_reporte() {
		return mes_reporte;
	}

	public void setMes_reporte(String mes_reporte) {
		this.mes_reporte = mes_reporte;
	}

	public Boolean getExiste() {
		return existe;
	}

	public void setExiste(Boolean existe) {
		this.existe = existe;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}	
}
