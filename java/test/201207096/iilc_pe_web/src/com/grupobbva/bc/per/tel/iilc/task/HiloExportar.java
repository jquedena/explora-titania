package com.grupobbva.bc.per.tel.iilc.task;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;

import com.grupobbva.bc.per.tel.iilc.beans.Tiilc_his_ingresos_carp_com;
import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.conexionEJB.ConexionDAO;
import com.grupobbva.bc.per.tel.iilc.dao.AdmDescCabRepDAO;
import com.grupobbva.bc.per.tel.iilc.dao.HistoricoSeguimientoDAO;
import com.grupobbva.bc.per.tel.iilc.forms.FormBeanConsulta;
import com.grupobbva.bc.per.tel.iilc.logic.ExportCarpeta;
import com.grupobbva.bc.per.tel.iilc.logic.FormateaListado;

import com.grupobbva.bc.per.tel.iilc.beans.Tiilc_conf_cabeceras_rep;

public class HiloExportar implements Runnable {

	private static Logger log = Logger.getLogger(HiloExportar.class);
	private FormBeanConsulta form;
	private String id;
	private String registro;
	private int tipoDetalle;
	private String descripcion;
		
    public FormBeanConsulta getForm() {
		return form;
	}

	public void setForm(FormBeanConsulta form) {
		this.form = form;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public int getTipoDetalle() {
		return tipoDetalle;
	}

	public void setTipoDetalle(int tipoDetalle) {
		this.tipoDetalle = tipoDetalle;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String[][] descripcion) {
		String jsonString = "";
		if(descripcion != null) {
			JSONArray jsonArray = JSONArray.fromObject(descripcion);
			jsonString = jsonArray.toString();
		}
		this.descripcion = jsonString;
	}

	private String generarNombreArchivo(FormateaListado formato) 
	{
		StringBuilder sbNombre = new StringBuilder();
		
		List listaCabecera = new AdmDescCabRepDAO().obtenerDescripcion("6");	
		String pestanas[] = ((Tiilc_conf_cabeceras_rep)listaCabecera.get(formato.getTipoOpcion())).getDescorta().split(" ");
		for(String p : pestanas)
		{
			sbNombre.append(p.substring(0,1));
		}
		sbNombre.append("_");
		
		if(!formato.getCod_gestor().equals("-1"))
			sbNombre.append(formato.getCod_gestor());
		else if(!formato.getCod_oficina().equals("-1"))
			sbNombre.append(formato.getCod_oficina());
		else if(!formato.getCod_territorio().equals("-1"))
			sbNombre.append(formato.getCod_territorio());
		
		sbNombre.append("_");

		Format formatter = new SimpleDateFormat("ddMMyy_HH-mm");
		sbNombre.append(formatter.format(new java.util.Date()));
		
		//return "iilc-"+ formato.getCod_gestor() + "-" + String.valueOf(new java.util.Date().getTime()) + ".xls";
		return sbNombre.toString() + ".xls";
	}
	
	public void run() {
		log.info("[HiloExportar :: run :: start]");
		ConexionDAO cnn = new ConexionDAO();
		
        try {
        	
			HistoricoSeguimientoDAO historicodao = new HistoricoSeguimientoDAO();
        	Tiilc_his_ingresos_carp_com historico = null;
        	historico = historicodao.getHistorico(this.id);
			historico.setExportar(1);
			historico.setUsuario(this.registro);
			historicodao.actualizarHistorico2(historico);	
			
			int idDescarga = -1;
            FormateaListado formato = form.getFormatoXLS();
            ExportCarpeta exportObject = new ExportCarpeta();
            
            if (formato != null){
            	String path = cnn.findRecord(Constantes.PATH).getValor1().trim()+"downloads/";
            	String file = generarNombreArchivo(formato);
	            log.info("[HiloExportar :: run] file = \"" + file + "\"");
	            
	            idDescarga = cnn.insertarDescarga(registro, file, descripcion);
	            
	            boolean status = false;
	            try {
	            	status = exportObject.exportacionMasiva(formato, this.tipoDetalle, file, path, (this.tipoDetalle==0) ? true : false);
	            } catch(Exception e) {
	            	log.error("[HiloExportar :: run]", e);
	            }
	            
	            if(status) {
	            	cnn.actualizarDescarga(idDescarga, 2);
	            } else {
	            	cnn.actualizarDescarga(idDescarga, 3);
	            }
            }
            
        } catch (Exception e) {
    		log.error("[HiloExportar :: run]", e);
        }
        
		log.info("[HiloExportar :: run :: end]");		
	}
}