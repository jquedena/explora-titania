/*
 * Created on 20/04/2009
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package igrupobbva.pe.sistemasdoweb.excel;

import java.io.File;
import java.io.IOException;
import java.util.Vector;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import org.apache.log4j.Logger;

import com.grupobbva.bc.per.tele.sdo.serializable.ReporteExcelPPG;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;

/**
 * @author Administrador
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
@SuppressWarnings({"unchecked", "unused", "null"})
public class ExcelPPG {
	private static Logger log = Logger.getLogger(ExcelPPG.class);
	
	public boolean generarExcel(Vector datos, String path, String titulo){
		boolean res = false;
		Workbook original = null;
		WritableWorkbook workbook = null;
		ReporteExcelPPG beanLinea;
		int fila;
		
		try {
			log.info("[ExcelPPG :: generarExcel] Inicio");
			
			String sTemp = "";
			
			//verificaciones
				File test = null;
				//destino no existe
				test = new File(path);
				if (test.exists())
					//destino no esta bloqueado
					if (!test.delete()){
						log.info("[ExcelPPG :: generarExcel] Archivo bloqueado : " + path);
						return false;
					}
				test = null;
			//fin de verificaciones
			
			WorkbookSettings settings = new WorkbookSettings();
			settings.setLocale(java.util.Locale.US);
			
			//nuevo workbook
			workbook = Workbook.createWorkbook(new File(path),settings);
			//nueva hoja
			WritableSheet sheet = workbook.createSheet("Reporte",0);
			
			Label label;
			Number number;
			
//			estilos
			WritableFont fuenteTitulo = new WritableFont(WritableFont.createFont("Calibri"), 14, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.AUTOMATIC); 
			WritableCellFormat formatoTitulo = new WritableCellFormat (fuenteTitulo);
				formatoTitulo.setAlignment(Alignment.CENTRE);
			
			WritableFont fuenteCeldaTitulo = new WritableFont(WritableFont.createFont("Calibri"), 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.AUTOMATIC); 
			WritableCellFormat formatoCeldaTitulo = new WritableCellFormat (fuenteCeldaTitulo);
				formatoCeldaTitulo.setAlignment(Alignment.CENTRE);
				formatoCeldaTitulo.setBorder(Border.ALL, BorderLineStyle.THIN);
				formatoCeldaTitulo.setBackground(Colour.GRAY_25);
			
			WritableFont fuenteCeldaNormalNoAlign = new WritableFont(WritableFont.createFont("Calibri"), 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.AUTOMATIC); 
			WritableCellFormat formatoCeldaNormalNoAlign = new WritableCellFormat (fuenteCeldaNormalNoAlign);
				formatoCeldaNormalNoAlign.setBorder(Border.ALL, BorderLineStyle.THIN);
				
			WritableFont fuenteCeldaNormalSinBorde = new WritableFont(WritableFont.createFont("Calibri"), 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.AUTOMATIC); 
			WritableCellFormat formatoCeldaNormalSinBorde = new WritableCellFormat (fuenteCeldaNormalSinBorde);
				formatoCeldaNormalSinBorde.setAlignment(Alignment.LEFT);
				formatoCeldaNormalSinBorde.setBorder(Border.ALL, BorderLineStyle.NONE);
			
			WritableFont fuenteCeldaNormalDerecha = new WritableFont(WritableFont.createFont("Calibri"), 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.AUTOMATIC); 
			WritableCellFormat formatoCeldaNormalDerecha = new WritableCellFormat (fuenteCeldaNormalDerecha);
				formatoCeldaNormalDerecha.setAlignment(Alignment.RIGHT);
				formatoCeldaNormalDerecha.setBorder(Border.ALL, BorderLineStyle.THIN);
			
			WritableFont fuenteCeldaTotales = new WritableFont(WritableFont.createFont("Calibri"), 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.AUTOMATIC); 
			WritableCellFormat formatoCeldaTotales = new WritableCellFormat (fuenteCeldaTotales);
				formatoCeldaTotales.setAlignment(Alignment.RIGHT);
				formatoCeldaTotales.setBorder(Border.ALL, BorderLineStyle.THIN);
			
			//titulo
			sheet.mergeCells(0,0,3,0);
			label = new Label(0,0,titulo, formatoTitulo); 
			sheet.addCell(label);
			
			sheet.setColumnView(0,10);
			sheet.setColumnView(1,10);
			sheet.setColumnView(2,15);
			sheet.setColumnView(3,15);
			
			//cabeceras
			fila=1;
			label = new Label(0,fila,"Oficina", formatoCeldaTitulo); 
			sheet.addCell(label);
			
			label = new Label(1,fila,"Gestor", formatoCeldaTitulo); 
			sheet.addCell(label);
			
			label = new Label(2,fila,"Fecha 1", formatoCeldaTitulo); 
			sheet.addCell(label);
			
			label = new Label(3,fila,"Fecha 2", formatoCeldaTitulo); 
			sheet.addCell(label);
			
			//datos
			
			//...
			
			fila = 2;
			
			for(int i=0; i<datos.size(); i++){
				Vector elementoDato = (Vector) datos.elementAt(i);
				beanLinea = (ReporteExcelPPG)datos.elementAt(i);
				
				//oficina
				label = new Label(0,fila,beanLinea.getCodigoOficina(), formatoCeldaNormalDerecha); 
				sheet.addCell(label);
				
				//gestor
				label = new Label(1,fila,beanLinea.getCodigoGestor(), formatoCeldaNormalDerecha); 
				sheet.addCell(label);
				
				//fecha1
				label = new Label(2,fila,beanLinea.getFecha1(), formatoCeldaNormalDerecha); 
				sheet.addCell(label);
				
				//fecha2
				label = new Label(3,fila,beanLinea.getFecha2(), formatoCeldaNormalDerecha);
				sheet.addCell(label);
				
				fila++;
			}
			
			workbook.write();
			workbook.close();
			res = true;
			
			log.info("[ExcelPPG :: generarExcel] Fin");
		} catch (IOException e) {
			log.error("[ExcelPPG :: generarExcel] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			try {workbook.close();} catch (WriteException e1) {} catch (IOException e1) {} catch (RuntimeException e2) {}
			try {original.close();} catch (RuntimeException e2) {}
			return false;
		} catch (WriteException e) {
			log.error("[ExcelPPG :: generarExcel] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			try {workbook.close();} catch (WriteException e1) {} catch (IOException e1) {} catch (RuntimeException e2) {}
			try {original.close();} catch (RuntimeException e2) {}
			return false;
		} catch (Exception e) {
			log.error("[ExcelPPG :: generarExcel] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			try {workbook.close();} catch (WriteException e1) {} catch (IOException e1) {} catch (RuntimeException e2) {}
			try {original.close();} catch (RuntimeException e2) {}
			return false;
		}
		
		return res;
	}
}
