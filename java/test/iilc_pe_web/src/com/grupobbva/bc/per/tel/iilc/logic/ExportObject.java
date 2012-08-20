/*
 * Created on 20/09/2007
 *
 */
package com.grupobbva.bc.per.tel.iilc.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import jxl.CellView;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import org.apache.log4j.Logger;

import com.grupobbva.bc.per.tel.iilc.beans.Tiilc_conf_cabeceras_rep;
import com.grupobbva.bc.per.tel.iilc.beans.Tiilc_his_ingresos_carp_com;
import com.grupobbva.bc.per.tel.iilc.beans.Tiilc_vinculacion_gco;
import com.grupobbva.bc.per.tel.iilc.beans.Tiilc_vinculacion_ph;
import com.grupobbva.bc.per.tel.iilc.beans.Tiilc_vinculacion_vip;
import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.dao.ReporteVinculacionDAO;

/**
 * @author Maria Paula Tomaylla Tunque c20795 Fecha : 20/09/2007
 * 
 */
@SuppressWarnings({"unchecked", "unused"})
public class ExportObject {

	private static Logger log = Logger.getLogger(ExportObject.class);
	private int registro=0;

	public boolean exportacionMasivaVinculacion(List listadoDetalle,
			String tipoReporte, String file, String path)
			throws FileNotFoundException, IOException, WriteException {

		log.info("[ExportObject :: exportacionMasivaVinculacion] inicio");
		boolean res = false;
		log.info("[ExportObject :: exportacionMasivaVinculacion] la ruta y nombre de archivo serÃ¡ "
						+ path + file);

		ReporteVinculacionDAO daoReporte = new ReporteVinculacionDAO();
		List lista = daoReporte.obtenerCabeceras(tipoReporte);

		try {
			archivoNuevo(path, file);
			WritableWorkbook workbook;
			workbook = Workbook.createWorkbook(new File(path, file));

			WritableFont fuenteCelda = null;
			WritableCellFormat formatoCelda = null;

			WritableSheet sheet = workbook.createSheet("VINCULACION", 0);
			CellView cv = new CellView();

			for (int j = 1; j < lista.size() + 1; j++) {
				cv = sheet.getColumnView(j);
				cv.setAutosize(true);
				sheet.setColumnView(j, cv);
			}

			fuenteCelda = new WritableFont(WritableFont.createFont("Calibri"),
					8, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.WHITE);
			formatoCelda = new WritableCellFormat(fuenteCelda);
			formatoCelda.setBackground(Colour.DARK_BLUE);
			formatoCelda.setAlignment(Alignment.CENTRE);
			formatoCelda.setVerticalAlignment(VerticalAlignment.TOP);
			formatoCelda.setBorder(Border.ALL, BorderLineStyle.NONE);

			imprimeTitulosVinculacion(sheet, formatoCelda, lista);

			fuenteCelda = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.BLACK);
			formatoCelda = new WritableCellFormat(fuenteCelda);
			formatoCelda.setBackground(Colour.WHITE);
			formatoCelda.setAlignment(Alignment.GENERAL);
			formatoCelda.setBorder(Border.ALL, BorderLineStyle.THIN);

			for (int i = 0; i < listadoDetalle.size(); i++) {
				imprimirPaginaVinculacion(tipoReporte,sheet, formatoCelda, listadoDetalle
						.get(i), i, lista);
			}

			workbook.write();
			// log.info("[ExportObject :: exportacionMasiva] escribiendo cambios en archivo");
			workbook.close();
			// log.info("[ExportObject :: exportacionMasiva] cerrando archivo");
			res = true;
		} catch (Exception e) {
			log.error("[ExportObject :: exportacionMasiva] error en generaciÃ³n del archivo");
		}
		log.info("[ExportObject :: exportacionMasiva] fin");
		return res;
	}

	public boolean exportacionMasivaSegmentada(List listadoDetalle,
			String file, String path) throws FileNotFoundException,
			IOException, WriteException {

		log.info("[ExportObject :: exportacionMasivaVinculada] inicio");
		boolean res = false;
		log
				.info("[ExportObject :: exportacionMasivaVinculada] la ruta y nombre de archivo serÃ¡ "
						+ path + file);

		try {
			archivoNuevo(path, file);
			WritableWorkbook workbook;
			workbook = Workbook.createWorkbook(new File(path, file));

			WritableFont fuenteCelda = null;
			WritableCellFormat formatoCelda = null;

			WritableSheet sheet = workbook.createSheet("SEGMENTADO POR GESTOR", 0);
			CellView cv = new CellView();

			for (int j = 1; j < Constantes.COLUMNAS_EXPORTAR_VINCULACION_SEGMENTADA + 1; j++) {
				cv = sheet.getColumnView(j);
				cv.setAutosize(true);
				sheet.setColumnView(j, cv);
			}
			
			
			
			fuenteCelda = new WritableFont(WritableFont.createFont("Calibri"),
					8, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.WHITE);
			formatoCelda = new WritableCellFormat(fuenteCelda);
			formatoCelda.setBackground(Colour.DARK_BLUE);
			formatoCelda.setAlignment(Alignment.CENTRE);
			formatoCelda.setVerticalAlignment(VerticalAlignment.TOP);
			formatoCelda.setBorder(Border.ALL, BorderLineStyle.NONE);

			imprimeTitulosSegmentada(sheet, formatoCelda);

			fuenteCelda = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.BLACK);
			formatoCelda = new WritableCellFormat(fuenteCelda);
			formatoCelda.setBackground(Colour.WHITE);
			formatoCelda.setAlignment(Alignment.GENERAL);
			formatoCelda.setBorder(Border.ALL, BorderLineStyle.THIN);

			for (int i = 0; i < listadoDetalle.size(); i++) {
				imprimirPaginaSegmentada(sheet, formatoCelda,
						(Tiilc_vinculacion_vip) listadoDetalle.get(i), i);
			}

			workbook.write();
			// log.info("[ExportObject :: exportacionMasiva] escribiendo cambios en archivo");
			workbook.close();
			// log.info("[ExportObject :: exportacionMasiva] cerrando archivo");
			res = true;
		} catch (Exception e) {
			log
					.info("[ExportObject :: exportacionMasiva] error en generaciÃ³n del archivo");
			log.info("[ExportObject :: exportacionMasiva] " + e.getMessage());
			// nom_archivo ="";
		}
		log.info("[ExportObject :: exportacionMasiva] fin");
		return res;
	}

	public boolean exportacionMasivaHistorico(String tipoReporte,
			List listadoDetalle, String file, String path)
			throws FileNotFoundException, IOException, WriteException {

		log.info("[ExportObject :: exportacion Historico seguimiento] inicio");
		boolean res = false;
		log.info("[ExportObject :: exportacion Historico seguimiento] la ruta y nombre de archivo ser" + (char) 225 + " "+ path + file);

		try {
			archivoNuevo(path, file);
			WritableWorkbook workbook;
			workbook = Workbook.createWorkbook(new File(path, file));

			WritableSheet sheet = workbook.createSheet("HISTORICO SEGUIMIENTO",
					0);
			CellView cv = new CellView();
			for (int j = 1; j < Constantes.COLUMNAS_EXPORTAR_HISTORICO + 1; j++) {
				cv = sheet.getColumnView(j);
				cv.setAutosize(true);
				sheet.setColumnView(j, cv);
			}

			WritableFont fuenteCelda = null;
			WritableCellFormat formatoCelda = null;

			fuenteCelda = new WritableFont(WritableFont.createFont("Calibri"),
					8, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.WHITE);
			formatoCelda = new WritableCellFormat(fuenteCelda);
			formatoCelda.setBackground(Colour.DARK_BLUE);

			formatoCelda.setAlignment(Alignment.CENTRE);
			formatoCelda.setVerticalAlignment(VerticalAlignment.TOP);
			formatoCelda.setBorder(Border.ALL, BorderLineStyle.NONE);

			
			WritableCellFormat formatoCelda_celeste = null; 
			formatoCelda_celeste = new WritableCellFormat(fuenteCelda);
			formatoCelda_celeste.setBackground(Colour.LIGHT_BLUE);

			formatoCelda_celeste.setAlignment(Alignment.CENTRE);
			formatoCelda_celeste.setVerticalAlignment(VerticalAlignment.TOP);
			formatoCelda_celeste.setBorder(Border.ALL, BorderLineStyle.NONE);
			
			
			
			WritableCellFormat formatoCelda_verde = null; 
			formatoCelda_verde = new WritableCellFormat(fuenteCelda);
			formatoCelda_verde.setBackground(Colour.GREEN);

			formatoCelda_verde.setAlignment(Alignment.CENTRE);
			formatoCelda_verde.setVerticalAlignment(VerticalAlignment.TOP);
			formatoCelda_verde.setBorder(Border.ALL, BorderLineStyle.NONE);
			
			
			
			WritableCellFormat formatoCelda_naranja = null; 
			formatoCelda_naranja = new WritableCellFormat(fuenteCelda);
			formatoCelda_naranja.setBackground(Colour.ORANGE);

			formatoCelda_naranja.setAlignment(Alignment.CENTRE);
			formatoCelda_naranja.setVerticalAlignment(VerticalAlignment.TOP);
			formatoCelda_naranja.setBorder(Border.ALL, BorderLineStyle.NONE);
			
			
			imprimeTitulosHistorico(tipoReporte, sheet, formatoCelda,formatoCelda_celeste,formatoCelda_verde,formatoCelda_naranja);

			fuenteCelda = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.BLACK);
			formatoCelda = new WritableCellFormat(fuenteCelda);
			formatoCelda.setBackground(Colour.WHITE);
			formatoCelda.setAlignment(Alignment.GENERAL);
			formatoCelda.setBorder(Border.ALL, BorderLineStyle.THIN);

			for (int i = 0; i < listadoDetalle.size(); i++) {
				imprimirPaginaHistorico(tipoReporte,sheet, formatoCelda,
						(Tiilc_his_ingresos_carp_com) listadoDetalle.get(i), i);
			}

			workbook.write();
			// log.info("[ExportObject :: exportacionMasiva] escribiendo cambios en archivo");
			workbook.close();
			// log.info("[ExportObject :: exportacionMasiva] cerrando archivo");
			res = true;
		} catch (Exception e) {
			log.info("[ExportObject :: exportacionMasiva] error en generacion del archivo");
			log.info("[ExportObject :: exportacionMasiva] " + e.getMessage());
			// nom_archivo ="";
		}
		log.info("[ExportObject :: exportacionMasiva] fin");
		return res;
	}

	public boolean exportacionMasivaVinculada(List listadoDetalle, String file,
			String path) throws FileNotFoundException, IOException,
			WriteException {

		log.info("[ExportObject :: exportacionMasivaVinculada] inicio");
		boolean res = false;
		log.info("[ExportObject :: exportacionMasivaVinculada] la ruta y nombre de archivo ser" + (char) 225 + " "
						+ path + file);

		try {
			archivoNuevo(path, file);
			WritableWorkbook workbook;
			workbook = Workbook.createWorkbook(new File(path, file));

			WritableFont fuenteCelda = null;
			WritableCellFormat formatoCelda = null;

			WritableSheet sheet = workbook.createSheet("VINCULADA POR GESTOR", 0);
			CellView cv = new CellView();

			for (int j = 1; j < Constantes.COLUMNAS_EXPORTAR_VINCULACION_VINCULADA + 1; j++) {
				cv = sheet.getColumnView(j);
				cv.setAutosize(true);
				sheet.setColumnView(j, cv);
			}

			fuenteCelda = new WritableFont(WritableFont.createFont("Calibri"),
					8, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.WHITE);
			formatoCelda = new WritableCellFormat(fuenteCelda);
			formatoCelda.setBackground(Colour.DARK_BLUE);
			formatoCelda.setAlignment(Alignment.CENTRE);
			formatoCelda.setVerticalAlignment(VerticalAlignment.TOP);
			formatoCelda.setBorder(Border.ALL, BorderLineStyle.NONE);

			imprimeTitulosVinculada(sheet, formatoCelda);

			fuenteCelda = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.BLACK);
			formatoCelda = new WritableCellFormat(fuenteCelda);
			formatoCelda.setBackground(Colour.WHITE);
			formatoCelda.setAlignment(Alignment.GENERAL);
			formatoCelda.setBorder(Border.ALL, BorderLineStyle.THIN);

			for (int i = 0; i < listadoDetalle.size(); i++) {
				imprimirPaginaVinculada(sheet, formatoCelda,
						(Tiilc_vinculacion_vip) listadoDetalle.get(i), i);
			}

			workbook.write();
			// log.info("[ExportObject :: exportacionMasiva] escribiendo cambios en archivo");
			workbook.close();
			// log.info("[ExportObject :: exportacionMasiva] cerrando archivo");
			res = true;
		} catch (Exception e) {
			log
					.info("[ExportObject :: exportacionMasiva] error en generacion del archivo");
			log.info("[ExportObject :: exportacionMasiva] " + e.getMessage());
			// nom_archivo ="";
		}
		log.info("[ExportObject :: exportacionMasiva] fin");
		return res;
	}

	private void imprimirPaginaVinculada(WritableSheet sheet,
			WritableCellFormat formatoCelda, Tiilc_vinculacion_vip bean,
			int nivel) {

		try {
			Label label;

			label = new Label(0, nivel + 1, bean.getCod_gestor(), formatoCelda);
			sheet.addCell(label);
			label = new Label(1, nivel + 1, bean.getNom_gestor(), formatoCelda);
			sheet.addCell(label);
			label = new Label(2, nivel + 1, bean.getPerfil(), formatoCelda);
			sheet.addCell(label);
			label = new Label(3, nivel + 1, bean.getTotal_puntos(),
					formatoCelda);
			sheet.addCell(label);

		} catch (Exception e) {
			log.error(e.getMessage());
		}

	}

	private void imprimirPaginaSegmentada(WritableSheet sheet,
			WritableCellFormat formatoCelda, Tiilc_vinculacion_vip bean,
			int nivel) {

		try {
			Label label;

			label = new Label(0, nivel + 1, bean.getCod_gestor(), formatoCelda);
			sheet.addCell(label);
			label = new Label(1, nivel + 1, bean.getNom_gestor(), formatoCelda);
			sheet.addCell(label);
			label = new Label(2, nivel + 1, bean.getSegmento(), formatoCelda);
			sheet.addCell(label);
			label = new Label(3, nivel + 1, bean.getTotal_puntos(),
					formatoCelda);
			sheet.addCell(label);

		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	private void imprimirPaginaHistorico(String tipoReporte,WritableSheet sheet, WritableCellFormat formatoCelda,Tiilc_his_ingresos_carp_com bean,int nivel) {
	
	try {
		Label label;
		Number number;
			int columna=0;
		
			if(tipoReporte.equals(Constantes.CODIGO_HISTORICO_DIA)){
				label = new Label(columna++, nivel+1,bean.getFecha_ingreso() ,formatoCelda);
		        sheet.addCell(label);	
			}
			label = new Label(columna++, nivel+1,bean.getCod_territorio() ,formatoCelda);
			sheet.addCell(label);	
			label = new Label(columna++, nivel+1,bean.getDes_territorio() ,formatoCelda);
			sheet.addCell(label);	
			label = new Label(columna++, nivel+1,bean.getCod_oficina() ,formatoCelda);
			sheet.addCell(label);	
			label = new Label(columna++, nivel+1,bean.getDes_oficina() ,formatoCelda);
			sheet.addCell(label);	
			label = new Label(columna++, nivel+1,bean.getUsuario() ,formatoCelda);
			sheet.addCell(label);	
			
			/*if(bean.getCod_perfil().equals("LC01") || bean.getCod_perfil().equals("LC02")){
				label = new Label(columna++, nivel+1,bean.getNombre_usuario() ,formatoCelda);
				sheet.addCell(label);
			}else{
				label = new Label(columna++, nivel+1,bean.getNom_gestor() ,formatoCelda);
				sheet.addCell(label);
			}
			*/
			label = new Label(columna++, nivel+1,bean.getNombre_usuario() ,formatoCelda);
			sheet.addCell(label);
			
			label = new Label(columna++, nivel+1,bean.getDes_cargo() ,formatoCelda);
			sheet.addCell(label);	
 			
			number = new Number(columna++, nivel+1,bean.getTotal() ,formatoCelda);
			sheet.addCell(number);	
			number = new Number(columna++, nivel+1,bean.getNivel_vinculacion() ,formatoCelda);
			sheet.addCell(number);
			number = new Number(columna++, nivel+1,bean.getClasificacion() ,formatoCelda);
			sheet.addCell(number);
			number = new Number(columna++, nivel+1,bean.getMargen_ordinario() ,formatoCelda);
			sheet.addCell(number);
			number = new Number(columna++, nivel+1,bean.getEtiqueta() ,formatoCelda);
			sheet.addCell(number);
			number = new Number(columna++, nivel+1,bean.getEdad() ,formatoCelda);
			sheet.addCell(number);
			number = new Number(columna++, nivel+1,bean.getCuota() ,formatoCelda);
			sheet.addCell(number);
			number = new Number(columna++, nivel+1,bean.getPago() ,formatoCelda);
			sheet.addCell(number);
			number = new Number(columna++, nivel+1,bean.getTodos() ,formatoCelda);
			sheet.addCell(number);
			number = new Number(columna++, nivel+1,bean.getActivo() ,formatoCelda);
			sheet.addCell(number);
			number = new Number(columna++, nivel+1,bean.getTarjetas() ,formatoCelda);
			sheet.addCell(number);
			number = new Number(columna++, nivel+1,bean.getPasivo() ,formatoCelda);
			sheet.addCell(number);
			number = new Number(columna++, nivel+1,bean.getServicios() ,formatoCelda);
			sheet.addCell(number);
			number = new Number(columna++, nivel+1,bean.getOfertas() ,formatoCelda);
			sheet.addCell(number);
			number = new Number(columna++, nivel+1,bean.getCanales() ,formatoCelda);
			sheet.addCell(number);
			number = new Number(columna++, nivel+1,bean.getExportar() ,formatoCelda);
			sheet.addCell(number);
 
	} catch (Exception e) {
		log.error(e.getMessage());
	}
}

	private void imprimirPaginaVinculacion(String tipoReporte,WritableSheet sheet,
			WritableCellFormat formatoCelda, Object bean, int nivel,
			List listaCabeceras) {

		try {
			Label label;
 
 
			int i=0;
				
			if(tipoReporte.equals(Constantes.CODIGO_VIP)){
				
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_vip)bean).getCod_oficina() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_vip)bean).getCodigo_cliente() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_vip)bean).getNombre_cliente() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_vip)bean).getCod_gestor() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_vip)bean).getNom_gestor() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_vip)bean).getSegmento() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_vip)bean).getAhorro_cta_cero() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_vip)bean).getCuenta_cte_vip() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_vip)bean).getAhorro_cta_gan() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_vip)bean).getOtras_ctas_ahorro() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_vip)bean).getFamilia1() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_vip)bean).getPlazo() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_vip)bean).getFondos_mutuos() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_vip)bean).getBolsa() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_vip)bean).getCts() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_vip)bean).getFamilia2() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_vip)bean).getPres_libre_dis() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_vip)bean).getPres_auto() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_vip)bean).getPres_hipotecario() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_vip)bean).getTc_activas() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_vip)bean).getFamilia3() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_vip)bean).getInfomail() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_vip)bean).getHaberes() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_vip)bean).getBca_internet() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_vip)bean).getDomiciliado() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_vip)bean).getFamilia4() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_vip)bean).getVida() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_vip)bean).getOnc_dent() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_vip)bean).getProteccion_tc() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_vip)bean).getOtros_seguros() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_vip)bean).getFamilia5() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_vip)bean).getTotal_puntos() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_vip)bean).getPerfil() , formatoCelda);sheet.addCell(label);
				
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_vip)bean).getLibre1() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_vip)bean).getLibre2() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_vip)bean).getLibre3() , formatoCelda);sheet.addCell(label);
				
	}else if(tipoReporte.equals(Constantes.CODIGO_GCO)){
		
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getCod_oficina() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getCodigo_cliente() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getNombre_cliente() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getCod_gestor() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getNom_gestor() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getSegmento() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getBloque() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getPres_com_letras() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getCom_exterior() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getLeasing() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getRiesgo_firma() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getTarjeta_cap_tra() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getTotal_tar_empre() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getHipo_autos() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getCta_plazo() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getFmutuos() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getCta_cte_ahorro() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getTotal_sal_pa_py() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getBolsa() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getHaberes() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getProveedores() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getRecaudacion() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getBanca_internet() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getSeguros() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getPtos_prescom_letras() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getPtos_com_ext() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getPtos_leasing() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getPtos_riesgo_firma() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getPtos_tarj_cap_trab() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getPtos_tarj_emp() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getPtos_hipo_autos() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getPtos_cta_cte_ahorro() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getPtos_cta_plazo() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getPtos_fmutuos() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getPtos_tot_pas_pym() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getPtos_bolsa() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getPtos_pago_haberes() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getPtos_pago_prov() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getPtos_recaudaciones() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getPtos_banca_internet() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getPtos_seguros() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getTotal_puntos() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getVinculado() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getRango_vinculacion() , formatoCelda);sheet.addCell(label);

				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getLibre1() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getLibre2() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_gco)bean).getLibre3() , formatoCelda);sheet.addCell(label);
				
	}else if(tipoReporte.equals(Constantes.CODIGO_PH)){
		
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getDes_territorio() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getCod_oficina() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getDes_oficina() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getCodcli_emisora() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getNom_emisora() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getCodigo_cliente() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getNombre() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getApellido1() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getApellido2() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getTipdoc_identidad() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getDoc_identidad() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getFecha_nacimiento() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getTipo_tlf1() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getCod_ciudad_tlf1() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getNro_tlf1() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getTipo_tlf2() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getCod_ciudad_tlf2() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getNro_tlf2() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getTipo_tlf3() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getCod_ciudad_tlf3() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getNro_tlf3() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getSegmento() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getClasificacion_rcc() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getRango_ingreso() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getSm_prest_consumo() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getNro_prest_consumo() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getSm_prest_hipo() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getNro_prest_hipo() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getSm_tarj_cred() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getNro_plasticos() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getTarj_creditos() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getNro_ctas_ahorro() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getNro_ctas_vista() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getNro_ctas_fmutuos() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getNro_ctas_plazo() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getNro_ctas_cts() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getMargen_ordinario() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getMargen_ordinario_acum() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getTipo_oferta() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getImp_oferta_consumo() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getTasa1() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getTasa2() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getTasa3() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getImp_oferta_tarjeta() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getLinea_tc() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getCanal() , formatoCelda);sheet.addCell(label);

				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getLibre1() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getLibre2() , formatoCelda);sheet.addCell(label);
				label = new Label(i++, nivel + 1,  ((Tiilc_vinculacion_ph)bean).getLibre3() , formatoCelda);sheet.addCell(label);
	}

	
		} catch (Exception e) {
			log.error(e.getMessage());
		}

	}

	private void imprimeTitulosVinculada(WritableSheet sheet,
			WritableCellFormat formatoCelda) {

		Label label;
		int nivel = 0;

		try {

			label = new Label(0, nivel, "Codigo Gestor", formatoCelda);
			sheet.addCell(label);

			label = new Label(1, nivel, "Nombre Gestor", formatoCelda);
			sheet.addCell(label);

			label = new Label(2, nivel, "Perfil", formatoCelda);
			sheet.addCell(label);

			label = new Label(3, nivel, "Total", formatoCelda);
			sheet.addCell(label);

		} catch (Exception e) {
			log.error(e.getMessage());
		}

	}

	private void imprimeTitulosSegmentada(WritableSheet sheet,
			WritableCellFormat formatoCelda) {

		Label label;
		int nivel = 0;

		try {

			label = new Label(0, nivel, "Codigo Gestor", formatoCelda);
			sheet.addCell(label);

			label = new Label(1, nivel, "Nombre Gestor", formatoCelda);
			sheet.addCell(label);

			label = new Label(2, nivel, "Segmento", formatoCelda);
			sheet.addCell(label);

			label = new Label(3, nivel, "Total", formatoCelda);
			sheet.addCell(label);

		} catch (Exception e) {
			log.error(e.getMessage());
		}

	}

	private void imprimeTitulosHistorico(String tipoReporte,
			WritableSheet sheet, WritableCellFormat formatoCelda, WritableCellFormat formatoCelda_celeste,
			WritableCellFormat formatoCelda_verde, WritableCellFormat formatoCelda_naranja) {

		Label label;
		int nivel = 0;

		try {
			int columna = 0;

			if (tipoReporte.equals(Constantes.CODIGO_HISTORICO_DIA)) {
				label = new Label(columna++, nivel, "Fecha ingreso",
						formatoCelda);
				sheet.addCell(label);
			}

			label = new Label(columna++, nivel, "Codigo territorio",
					formatoCelda);
			sheet.addCell(label);
			label = new Label(columna++, nivel, "Descripcion territorio",
					formatoCelda);
			sheet.addCell(label);
			label = new Label(columna++, nivel, "Codigo oficina", formatoCelda);
			sheet.addCell(label);
			label = new Label(columna++, nivel, "descripcion oficina",
					formatoCelda);
			sheet.addCell(label);
			label = new Label(columna++, nivel, "Registro", formatoCelda);
			sheet.addCell(label);
			label = new Label(columna++, nivel, "Nombre", formatoCelda);
			sheet.addCell(label);
			label = new Label(columna++, nivel, "Cargo", formatoCelda);
			sheet.addCell(label);

			label = new Label(columna++, nivel, "Ingresos a la aplicaci" + (char) 243 + "n",
					formatoCelda);
			sheet.addCell(label);
			label = new Label(columna++, nivel, "Nivel de vinculaci" + (char) 243 + "n ",
					formatoCelda_celeste);
			sheet.addCell(label);
			label = new Label(columna++, nivel, "Clasificaci" + (char) 243 + "n", formatoCelda_celeste);
			sheet.addCell(label);
			label = new Label(columna++, nivel, "Margen ordinario",
					formatoCelda_celeste);
			sheet.addCell(label);
			label = new Label(columna++, nivel, "Etiqueta", formatoCelda_celeste);
			sheet.addCell(label);
			label = new Label(columna++, nivel, "Edad", formatoCelda_celeste);
			sheet.addCell(label);
			label = new Label(columna++, nivel, "Cuota riesgo total",
					formatoCelda_celeste);
			sheet.addCell(label);
			label = new Label(columna++, nivel, "Pago haberes", formatoCelda_celeste);
			sheet.addCell(label);
			label = new Label(columna++, nivel, "Todos ", formatoCelda_verde);
			sheet.addCell(label);
			label = new Label(columna++, nivel, "Activo", formatoCelda_verde);
			sheet.addCell(label);
			label = new Label(columna++, nivel, "Tarjetas ", formatoCelda_verde);
			sheet.addCell(label);
			label = new Label(columna++, nivel, "Pasivo", formatoCelda_verde);
			sheet.addCell(label);
			label = new Label(columna++, nivel, "Servicios", formatoCelda_verde);
			sheet.addCell(label);
			label = new Label(columna++, nivel, "Ofertas", formatoCelda_verde);
			sheet.addCell(label);
			label = new Label(columna++, nivel, "Otras ofertas", formatoCelda_verde);
			sheet.addCell(label);
			label = new Label(columna++, nivel, "exportaciones", formatoCelda_naranja);
			sheet.addCell(label);
		} catch (Exception e) {
			log.error(e.getMessage());
		}

	}

	private void imprimeTitulosVinculacion(WritableSheet sheet,
			WritableCellFormat formatoCelda, List cabeceras) {

		Label label;
		int nivel = 0;

		try {
			for (int i = 0; i < cabeceras.size(); i++) {
				Tiilc_conf_cabeceras_rep bean = (Tiilc_conf_cabeceras_rep) cabeceras
						.get(i);

				label = new Label(i, nivel, bean.getDeslarga(), formatoCelda);
				sheet.addCell(label);

			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}

	}

	private boolean archivoNuevo(String ruta, String nombre) {
		log.info("[ExportObject :: archivoNuevo] inicio");
		boolean res = false;
		try {
			File f = new File(ruta, nombre);
			f.createNewFile();
			f = null;
		} catch (Throwable e) {
			log.error("[ExportObject :: archivoNuevo] error");
			log.error("[ExportObject :: archivoNuevo] " + e.getMessage());
		}
		log.info("[ExportObject :: archivoNuevo] fin");
		return res;
	}

}