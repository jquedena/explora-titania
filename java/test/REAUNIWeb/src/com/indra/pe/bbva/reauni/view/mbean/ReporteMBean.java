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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.indra.pe.bbva.core.util.Constantes;
import com.indra.pe.bbva.core.view.GenericMBean;
import com.indra.pe.bbva.reauni.view.helper.ApplicationHelper;

@SuppressWarnings({"rawtypes", "unused", "unchecked"})
@Controller("reporteMBean")
@Scope("session")
public class ReporteMBean extends GenericMBean {
	private static Logger logger = Logger.getLogger(ReporteMBean.class);

	private List tipos;
	private List años;
	private List meses;
	private String anio_reporte;
	private String tipo_reporte;
	private String mes_reporte;

	private String existe = "aaaa";

	public ReporteMBean() {
		try {

			cargarAños();
			cargaTipos();

		} catch (Exception e) {
			logger.error("ERROR EN UTILITARIO " + e.getMessage());
		}
	}

	
	public String iniciar () {
		return com.indra.pe.bbva.reauni.util.Constantes.UrlNavegacion.URL_REPORTE;
	}
	
	public String verificarExistenciaFile() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();

		return null;
	}

	public String carga_parametros(){

		FacesContext context = FacesContext.getCurrentInstance();  
        HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();        
        
        String ruta=ApplicationHelper.obtenerParametroPorId(1065L).getValorCadena();
        request.getSession().setAttribute("tipo", tipo_reporte);
        request.getSession().setAttribute("año", anio_reporte);
        request.getSession().setAttribute("mes", mes_reporte);
        request.getSession().setAttribute("exportacion_ruta",ruta );
    
        String archivo=tipo_reporte+"_"+anio_reporte+""+mes_reporte+".xls";
        
        File file = new File(ruta +  archivo);
        
        
        if(tipo_reporte==null || anio_reporte==null || mes_reporte==null || tipo_reporte.equals("") || anio_reporte.equals("") || mes_reporte.equals("")){
        	existe="nan";
        	showWarning("SELECCIONE TODOS LOS CRITERIOS DE BUSQUEDA.");
        }else{
		    	if(!file.exists()){		    		
		    		existe="false";
		    		try {
		    			showWarning("NO EXISTE NINGÚN REPORTE PARA LOS CRITERIOS SELECCIONADOS!");										
					} catch (Exception e) {
						
					}
		    	}else{
		    		existe="true";
		    		showMessage("DESCARGA SATISFACTORIAMENTE!");
		    		FileInputStream fin;
					try {
						fin = new FileInputStream(file);
						byte[] bytes = load(fin);
			            HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
			            response.setContentType("application/vnd.ms-excel");
			            response.addHeader("Content-disposition", "attachment;filename=" + archivo);
			            response.setContentLength(bytes.length);
			            response.getOutputStream().write(bytes);			                        
			            context.responseComplete();			   
					} catch (FileNotFoundException e) {
						showMessage("Error");
					} catch (IOException e) {
						showMessage("Error");
					}	
		    	}
        }
		return null;
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
		//tipos.add(Constantes.TIPO_TRAMITE_UNIFICACION);
		tipos.add(Constantes.TIPO_SOLICITUD);

	}

	public void cargarAños() {
		años = new ArrayList();
		Calendar hoy = Calendar.getInstance();
		SelectItem item = new SelectItem(hoy.get(Calendar.YEAR) + "",
				hoy.get(Calendar.YEAR) + "");
		años.add(item);
		for (int i = 1; i <= 10; i++) {
			SelectItem item_tem = new SelectItem((hoy.get(Calendar.YEAR) - i)
					+ "", (hoy.get(Calendar.YEAR) - i) + "");
			años.add(item_tem);
		}
	}

	public List getTipos() {
		return tipos;
	}

	public void setTipos(List tipos) {
		this.tipos = tipos;
	}

	public List getAños() {
		return años;
	}

	public void setAños(List años) {
		this.años = años;
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

	public String getExiste() {
		return existe;
	}

	public void setExiste(String existe) {
		this.existe = existe;
	}

}
