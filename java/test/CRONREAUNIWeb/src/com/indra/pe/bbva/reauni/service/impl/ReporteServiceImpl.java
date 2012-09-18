package com.indra.pe.bbva.reauni.service.impl;

import java.io.File;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import jxl.CellView;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.pe.bbva.core.dao.DAOGenericoLDAP;
import com.indra.pe.bbva.core.dao.ReporteDAO;
import com.indra.pe.bbva.core.util.Constantes;
import com.indra.pe.bbva.reauni.service.ReporteService;
import com.indra.pe.bbva.reauni.view.helper.ApplicationHelper;

@SuppressWarnings("rawtypes")
@Service("reporteService")
public class ReporteServiceImpl implements ReporteService{
	private static Logger logger = Logger.getLogger(ReporteServiceImpl.class);
	
	@Autowired
	private ReporteDAO reporteDAO;
	
	@Autowired
	private DAOGenericoLDAP daoGenericoLdap; 
	
	public void guardarReporteRepositorio(){
		try {
			
			List lista_oficina=reporteDAO.generarReportePorOficina();
			List lista_territorio=reporteDAO.generarReportePorTerritorio();
			List lista_solicitante=reporteDAO.generarReportePorTipoSolicitante();
			List lista_tramite=reporteDAO.generarReportePorTiempoTramite();
			
			cargaListaRepositorio(Constantes.CABECERA_OFICINA,lista_oficina,Constantes.TIPO_OFICINA);
			cargaListaRepositorio(Constantes.CABECERA_TERRITORIO,lista_territorio,Constantes.TIPO_TERRITORIO);
			cargaListaRepositorio(Constantes.CABECERA_SOLICITUD,lista_solicitante,Constantes.TIPO_SOLICITUD);
			cargaListaRepositorio(Constantes.CABECERA_TRAMITE,lista_tramite,Constantes.TIPO_TRAMITE	);

		} catch (Exception e) {
			logger.error("guardarReporteRepositorio", e);
		}
	}
	
	
	private boolean archivoNuevo(String ruta, String nombre) {
		boolean res = false;
		try {
			File f = new File(ruta, nombre);
			f.createNewFile();
			f = null;
		} catch (Throwable e) {
			logger.error("archivoNuevo", e);
		}
		return res;
	}
	
	public void cargaListaRepositorio(String cabecera, List lista, String tipo){
		try {
			Calendar hoy=Calendar.getInstance();
			
			String file=tipo+"_"+ hoy.get(Calendar.YEAR) + ""  + (hoy.get(Calendar.MONTH)+1) +".xls";
			String path=ApplicationHelper.obtenerParametroPorId(1065L).getValorCadena(); // Constantes.RUTA_REPOSITORIO_REPORTES;
			archivoNuevo(path, file);
			WritableWorkbook workbook;
			workbook = Workbook.createWorkbook(new File(path, file));

			WritableFont fuenteCelda = null;
			WritableCellFormat formatoCelda = null;
			WritableSheet sheet = workbook.createSheet("REPORTE", 0);
			
			// Imprimiendo titulos
			fuenteCelda = new WritableFont(WritableFont.createFont("Calibri"), 8, WritableFont.BOLD, false,UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
			formatoCelda = new WritableCellFormat(fuenteCelda);
			formatoCelda.setBackground(Colour.DARK_BLUE);
			formatoCelda.setAlignment(Alignment.CENTRE);
			formatoCelda.setVerticalAlignment(VerticalAlignment.TOP);
			
			formatoCelda.setBorder(Border.ALL, BorderLineStyle.NONE);

			StringTokenizer cabecera_array=new StringTokenizer(cabecera,"|");
			int columnas=0;
			while(cabecera_array.hasMoreTokens()){
				Label label;
				label = new Label(columnas, 0, cabecera_array.nextToken() , formatoCelda);
				sheet.addCell(label);
				columnas++;
			}
			
			CellView cv = new CellView();
			// Anchos de columnas
			for (int j = 0; j < columnas ; j++) {
				cv = sheet.getColumnView(j);
				cv.setAutosize(true);
				sheet.setColumnView(j, cv);
			}
			
			fuenteCelda = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
			formatoCelda = new WritableCellFormat(fuenteCelda);
			formatoCelda.setBackground(Colour.WHITE);
			formatoCelda.setAlignment(Alignment.GENERAL);
			formatoCelda.setBorder(Border.ALL, BorderLineStyle.THIN);
			
			int fila=1;
			String valor = null;
			String temp1 = null;
			String temp2 = null;
			if(lista != null) {
				for(Iterator iter=lista.iterator();iter.hasNext();){
					String registro=(String)iter.next();
					StringTokenizer registro_array=new StringTokenizer(registro,"|");
					int columnas_registro=0;
					while(registro_array.hasMoreTokens()){
						valor = registro_array.nextToken();
						
						if(Constantes.TIPO_TERRITORIO.equalsIgnoreCase(tipo) && columnas_registro == 1 && valor.equalsIgnoreCase("***")) {
							try {
								temp2 = daoGenericoLdap.obtenerTerritorio(temp1);
								if(temp2 != null) {
									valor = temp2;
								}
							} catch (Exception e) {
								logger.error("Obteniendo el codigo de territorio desde LDAP", e);
							}
						}
						
						if(Constantes.TIPO_OFICINA.equalsIgnoreCase(tipo) && columnas_registro == 1 && valor.equalsIgnoreCase("***")) {
							try {
								temp2 = daoGenericoLdap.obtenerTerritorio(temp1);
								if(temp2 != null) {
									valor = temp2;
								}
							} catch (Exception e) {
								logger.error("Obteniendo el codigo de territorio desde LDAP", e);
							}
						}
						
						if(Constantes.TIPO_TRAMITE.equalsIgnoreCase(tipo) && columnas_registro == 1 && valor.equalsIgnoreCase("***")) {
							try {
								temp2 = daoGenericoLdap.obtenerTerritorio(temp1);
								if(temp2 != null) {
									valor = temp2;
								}
							} catch (Exception e) {
								logger.error("Obteniendo el codigo de territorio desde LDAP", e);
							}
						}
						
						Label label;
						label = new Label(columnas_registro, fila, valor, formatoCelda);
						sheet.addCell(label);
						columnas_registro++;
						temp1 = valor;
					}
					
					fila++;
				}
			}
			
			workbook.write();
			workbook.close();
		} catch (Exception e) {
			logger.error("cargaListaRepositorio", e);
		}

	}
	
}
