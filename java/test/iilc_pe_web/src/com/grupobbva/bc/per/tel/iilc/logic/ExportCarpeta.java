package com.grupobbva.bc.per.tel.iilc.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import jxl.CellView;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.log4j.Logger;

import pe.com.indra.excel.CellComponent;
import pe.com.indra.excel.ColourComponent;

import com.grupobbva.bc.per.tel.iilc.common.NumeroUtil;
import com.grupobbva.bc.per.tel.iilc.serializable.Cliente;
import com.grupobbva.bc.per.tel.iilc.serializable.Multitabla;

@SuppressWarnings("unused")
public class ExportCarpeta {

	private static Logger log = Logger.getLogger(ExportCarpeta.class);
	private int columnas;
	private int tipo_detalle;
	private ColourComponent colourComponent = new ColourComponent();;
	private Map<Integer, Integer> rowspan = new HashMap<Integer, Integer>();
	
	private void prepareRowsExcel(CellComponent row, WritableSheet sheetWrite, WritableWorkbook book, String type){
		Label label = null;
		Number number = null;
		int col = 0;
		String temp;
		
		WritableFont font;
		WritableCellFormat cellFormat;
			
		// log.info(row);
		col = row.getCol();

		try {
			font = new WritableFont(WritableFont.TAHOMA);
			font.setColour(colourComponent.getColour(row.getColor(), book));
			font.setPointSize(9);
			if(row.getFontWeight().equalsIgnoreCase("bold") || row.getFontWeight().equalsIgnoreCase("700")) {
				font.setBoldStyle(WritableFont.BOLD);
			} else {
				font.setBoldStyle(WritableFont.NO_BOLD);
			}
			
			cellFormat = new WritableCellFormat();
			cellFormat.setBackground(colourComponent.getColour(row.getBackgroundColor(), book));
			cellFormat.setFont(font);
			cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
			cellFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
			if(type.equalsIgnoreCase("head")) {
				if(row.getCaption().length() == 0) {
					return;
				}
				cellFormat.setAlignment(Alignment.CENTRE);
				cellFormat.setWrap(false);
			} else {
				cellFormat.setAlignment(Alignment.LEFT);
				cellFormat.setWrap(false);	
			}
			
			if(row.getType().equalsIgnoreCase("number")) {
				try {
					temp = row.getCaption().replaceAll(",", ".");
					if(temp.length()>0) {
						number = new Number(col, row.getRow(), Double.valueOf(temp).doubleValue());
						cellFormat.setAlignment(Alignment.RIGHT);
						number.setCellFormat(cellFormat);
						sheetWrite.addCell(number);
					} else {
						label = new Label(col, row.getRow(), row.getCaption());
						label.setCellFormat(cellFormat);
						sheetWrite.addCell(label);
					}
				} catch(NumberFormatException ex) {
					// log.info(row);
					// log.info("Imprimiendo como valor de texto.");
					// log.info(ex);
					label = new Label(col, row.getRow(), row.getCaption());
					label.setCellFormat(cellFormat);
					sheetWrite.addCell(label);
				}
			} else if(row.getType().equalsIgnoreCase("date")) {
				label = new Label(col, row.getRow(), row.getCaption());
				label.setCellFormat(cellFormat);
				sheetWrite.addCell(label);
			} else {
				label = new Label(col, row.getRow(), row.getCaption());
				label.setCellFormat(cellFormat);
				sheetWrite.addCell(label);
			}
			
			
		} catch (RowsExceededException ex) {
			log.error(":(", ex);
		} catch (WriteException ex) {
			log.error(":(", ex);
		}
		
		if(row.getColspan() > 1) {
			try {
				sheetWrite.mergeCells(col, row.getRow(), col + (row.getColspan() - 1), row.getRow());
			} catch (RowsExceededException ex) {
				log.error(":(", ex);
			} catch (WriteException ex) {
				log.error(":(", ex);
			}
			col += (row.getColspan() - 1);
		}
		
		if(row.getRowspan() > 1) {
			rowspan.put(col, row.getRowspan() -1);
			try {
				sheetWrite.mergeCells(col, row.getRow(), col, row.getRow() + row.getRowspan() - 1);
			} catch (RowsExceededException ex) {
				log.error(":(", ex);
			} catch (WriteException ex) {
				log.error(":(", ex);
			}
		}
	}
	
	private void prepareRowsExcel(List<CellComponent> rows, WritableSheet sheetWrite, WritableWorkbook book, String type){	
		for(CellComponent row : rows) {
			prepareRowsExcel(row, sheetWrite, book, type);
		}
	}
	
	public boolean exportacionMasiva(FormateaListado formato
			, int detalle
			, String file
			, String path
			, boolean pestanaTodos) throws FileNotFoundException, IOException, WriteException {

		boolean res = false;
		log.info("[ExportObject :: exportacionMasiva] Inicio");
		log.info("[ExportObject :: exportacionMasiva] La ruta y nombre de archivo sera " + path + file);
		columnas = 60;
		
		try {
			archivoNuevo(path, file);
			WritableWorkbook workbook;
			workbook = Workbook.createWorkbook(new File(path, file));

			WritableSheet sheet = workbook.createSheet("CARPETAS COMERCIALES", 0);
			CellView cv = new CellView();
			
			// Anchos de columnas
			for (int j = 1; j < columnas + 1; j++) {
				cv = sheet.getColumnView(j);
				cv.setAutosize(true);
 				sheet.setColumnView(j, cv);
			}

			Vector<Cliente> lista_cliente = formato.obtenerListado(1, pestanaTodos);
			GridCliente gridCliente = new GridCliente();
			Multitabla[] cabecera =  gridCliente.obtieneCabeceraExcel(detalle, lista_cliente);
			tipo_detalle = detalle;
			
			List<CellComponent> cols = imprimirCabecera(cabecera);
			prepareRowsExcel(cols, sheet, workbook, "head");
			formato.setExportacion(true);
			lista_cliente = formato.obtenerListadoAll(pestanaTodos);			

			int filaInicial = 3;
			imprimirResultado(lista_cliente, cabecera, filaInicial, sheet, workbook);

			workbook.write();
			workbook.close();
			res = true;
		} catch (Exception e) {
			log.error("[ExportObject :: exportacionMasiva] Error en generacion del archivo", e);
		}
		log.info("[ExportObject :: exportacionMasiva] Fin");
		return res;
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
	
	
	private List<CellComponent> imprimirCabecera(Multitabla[] cabecera){
		int i;
		List<CellComponent> result = new ArrayList<CellComponent>();	

		Multitabla campo = cabecera[0];
		CellComponent row1 = null;
		CellComponent row2 = null;
		CellComponent row3 = null;
		String temp1 = "*[";
		String temp2 = "*["; 		
		String colour1 = "127,127,127";
		String colour2 = "83,142,213";
		
		for(i = 0; i < cabecera.length; i++) {
			campo = cabecera[i];
			
			if(!temp1.equalsIgnoreCase(campo.getValor2())) {
				if( row1 != null) {
					result.add(row1);
				}				
				if(colour1.equalsIgnoreCase("0,0,128")) {
					colour1 = "127,127,127";
				} else {
					colour1 = "0,0,128";
				}
				row1 = new CellComponent();
				row1.setCaption(campo.getValor2());
				row1.setRow(2);
				row1.setCol(i + 1);
				row1.setRowspan(1);
				row1.setColspan(1);
				row1.setFontWeight("bold");
				row1.setBackgroundColor(row1.getCaption().length() != 0 ? colour1 : "255,255,255"); // 127, 127, 127
				row1.setColor("255,255,255");
				row1.setType("string");
				row1.setPattern("");
				temp1 = row1.getCaption();
			} else {
				if(row1!=null) {
					row1.setColspan(row1.getColspan() + 1);
				}
			}
			
			if(!temp2.equalsIgnoreCase(campo.getValor3())) {
				if( row2 != null) {
					result.add(row2);
				}
				if(campo.getValor3().length()>0) {
					if(colour2.equalsIgnoreCase("31,73,125")) {
						colour2 = "83,142,213";
					} else {
						colour2 = "31,73,125";
					}
				}
				row2 = new CellComponent();
				row2.setCaption(campo.getValor3());
				row2.setRow(1);
				row2.setCol(i + 1);
				row2.setRowspan(1);
				row2.setColspan(1);
				row2.setFontWeight("bold");
				row2.setBackgroundColor(row2.getCaption().length() != 0 ? colour2 : "255,255,255");
				row2.setColor("255,255,255");
				row2.setType("string");
				row2.setPattern("");
				temp2 = row2.getCaption();
			} else {
				if(row2!=null) {
					row2.setColspan(row2.getColspan() + 1);
				}
			}
			
			row3 = new CellComponent();
			row3.setRow(3);
			row3.setCol(i + 1);
			row3.setRowspan(0);
			row3.setColspan(0);
			row3.setFontWeight("bold");
			row3.setBackgroundColor(colour1);
			row3.setColor("255,255,255");
			row3.setType("string");
			row3.setPattern("");
			row3.setCaption(campo.getValor1());
			
			result.add(row3);
		}
		
		result.add(row1);
		result.add(row2);
		
		return result;
	}
	
	private void imprimirResultado(Vector<Cliente> lista, Multitabla[] cabecera, int filaInicial, WritableSheet sheetWrite, WritableWorkbook book) {
		
		if(lista == null || cabecera == null || sheetWrite == null || book == null) {
			return;
		}
		
		int i;
		int j;
		int numFilas = lista.size();

		Class<?> object;	
		Class<?> parameterType[] = {};
		Object arguments[] ={};
		Object value;
		Object value2;
		String string;
		BigDecimal number;
		Method method;
		CellComponent row;
		String colour = "";
		String temp = "";
		
		try {
			for(i = 0; i < numFilas; i++) {
				
				Cliente bean = lista.elementAt(i);
	
				for(j = 0; j < cabecera.length; j++) {
					value = "";
					
					try {
						temp = cabecera[j].getValor4();
						if(temp == null) {
							temp = "";
						}
						
						object = bean.getClass();
						method = object.getMethod(temp, parameterType);
						value = method.invoke(bean, arguments);
						colour = "255,255,255";
						
						if(temp.equalsIgnoreCase("getph") || temp.equalsIgnoreCase("getmphpasv")) {
							try {
								if(temp.equalsIgnoreCase("getph")) {
									number = new BigDecimal(value.toString());
									method = object.getMethod("getMphpasv", parameterType);
									value2 = method.invoke(bean, arguments);
									if(value2 == null) {
										value2 = "";
									} 
									string = value2.toString();
								} else {
									string = value.toString();
									method = object.getMethod("getPh", parameterType);
									value2 = method.invoke(bean, arguments);
									string = "";
									if(value2 != null) {
										string = value2.toString();
									}
									number = new BigDecimal(string);
								}							
							} catch(NumberFormatException e) {
								// log.info(e);
								// log.info("Valor: " + value.toString());
								number = BigDecimal.ZERO;
								string = "";
							} catch(NullPointerException e) {
								number = BigDecimal.ZERO;
								string = "";
							}
													
							if (number.compareTo(BigDecimal.ZERO) == 0 && (string != null && !string.equals(""))) {
								colour = "255,255,102";
							}
						}
						
						if(temp.equalsIgnoreCase("getTconsactv") 
								|| temp.equalsIgnoreCase("getTsubactv")
								|| temp.equalsIgnoreCase("getThipotactv")
								|| temp.equalsIgnoreCase("getTvehicactv")
								|| temp.equalsIgnoreCase("getTcuot36act")
								|| temp.equalsIgnoreCase("getTcuot48act")
								|| temp.equalsIgnoreCase("getCs000montocta60")
								|| temp.equalsIgnoreCase("getTcuot60act")
								|| temp.equalsIgnoreCase("getCs000presmena5000")
								|| temp.equalsIgnoreCase("getCs000comisdesemen5000")
								|| temp.equalsIgnoreCase("getCs000pres5000a15000")
								|| temp.equalsIgnoreCase("getC5000comdes15000act")
								|| temp.equalsIgnoreCase("getCs000presmaya15000")
								|| temp.equalsIgnoreCase("getComdes15000ac")
								|| temp.equalsIgnoreCase("getCs000prestcmena5000")
								|| temp.equalsIgnoreCase("getCs000prestc500015000")
								|| temp.equalsIgnoreCase("getCs000prestcmaya15000")) {
							
							try {
								number = new BigDecimal(value.toString());
							} catch(NumberFormatException e) {
								log.info(e);
								number = BigDecimal.ZERO;
							}
							
							value = NumeroUtil.redondeaAString(number, 2);
						}
						// log.info("{row: " + i + ", col: " + j + ", method: " + method.getName() + ", Valor obtenido por invoke: " + value + "},");
					} catch (SecurityException e) {
						log.error(e);
					} catch (NoSuchMethodException e) {
						log.error(e);
					} catch (IllegalArgumentException e) {
						log.error(e);
					} catch (IllegalAccessException e) {
						log.error(e);
					} catch (InvocationTargetException e) {
						log.error(e);
					} catch (NullPointerException e) {
						log.info("Cabecera Nula");
						value = "";
					} catch (ArrayIndexOutOfBoundsException e) {
						log.error(e);
						log.info("Se acabaron las filas para imprimir");
						return;
					} finally {
						if(value == null){
							value = "";
						}			
					}
					
					row = new CellComponent();			
					row.setRow(i + filaInicial + 1);
					row.setCol(j + 1);
					row.setRowspan(1);
					row.setColspan(1);
					row.setFontWeight("normal");
					row.setBackgroundColor(colour);
					row.setColor("0,0,0");
					if(temp.equalsIgnoreCase("getCodigo") 
						|| temp.equalsIgnoreCase("getNombre")
						|| temp.equalsIgnoreCase("getTipo_persona")
						|| temp.equalsIgnoreCase("getEstcivil")
						|| temp.equalsIgnoreCase("getPrefijo")
						|| temp.equalsIgnoreCase("getTelefono")
						|| temp.equalsIgnoreCase("getSegment1")
						|| temp.equalsIgnoreCase("getVinculacion") ) {
						row.setType("string");
					} else {
						row.setType("number");
					}
					row.setPattern("");
					row.setCaption(value.toString());
					prepareRowsExcel(row, sheetWrite, book, "body");
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			log.error(e);
			log.info("Se acabaron las filas para imprimir");
			return;
		}
	}
}